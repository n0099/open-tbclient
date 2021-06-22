package com.baidubce.services.bos;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.Headers;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.BosMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableFileInputStream;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.internal.RestartableMultiByteArrayInputStream;
import com.baidubce.internal.RestartableNonResettableInputStream;
import com.baidubce.internal.RestartableResettableInputStream;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.User;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.common.utils.BosUtils;
import com.baidubce.services.bos.model.AbortMultipartUploadRequest;
import com.baidubce.services.bos.model.AppendObjectRequest;
import com.baidubce.services.bos.model.AppendObjectResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BosResponse;
import com.baidubce.services.bos.model.CannedAccessControlList;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectRequest;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.CreateBucketRequest;
import com.baidubce.services.bos.model.CreateBucketResponse;
import com.baidubce.services.bos.model.DeleteBucketRequest;
import com.baidubce.services.bos.model.DeleteObjectRequest;
import com.baidubce.services.bos.model.DoesBucketExistRequest;
import com.baidubce.services.bos.model.GeneratePresignedUrlRequest;
import com.baidubce.services.bos.model.GenericBucketRequest;
import com.baidubce.services.bos.model.GenericObjectRequest;
import com.baidubce.services.bos.model.GetBosAccountOwnerRequest;
import com.baidubce.services.bos.model.GetBucketAclRequest;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationRequest;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.GetObjectMetadataRequest;
import com.baidubce.services.bos.model.GetObjectRequest;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.InitiateMultipartUploadRequest;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsRequest;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsRequest;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsRequest;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsRequest;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.baidubce.services.bos.model.ResponseHeaderOverrides;
import com.baidubce.services.bos.model.SetBucketAclRequest;
import com.baidubce.services.bos.model.UploadPartRequest;
import com.baidubce.services.bos.model.UploadPartResponse;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.ConvertUtils;
import com.baidubce.util.HashUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JsonUtils;
import com.baidubce.util.MD5DigestCalculatingInputStream;
import com.baidubce.util.Mimetypes;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class BosClient extends AbstractBceClient {
    public static final String STORAGE_CLASS_COLD = "COLD";
    public static final String STORAGE_CLASS_STANDARD = "STANDARD";
    public static final String STORAGE_CLASS_STANDARD_IA = "STANDARD_IA";
    public static final HttpResponseHandler[] bos_handlers = {new BceMetadataResponseHandler(), new BosMetadataResponseHandler(), new BceErrorResponseHandler(), new BosObjectResponseHandler(), new BceJsonResponseHandler()};

    public BosClient() {
        this(new BosClientConfiguration());
    }

    private void addResponseHeaderParameters(InternalRequest internalRequest, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.getCacheControl() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, responseHeaderOverrides.getCacheControl());
            }
            if (responseHeaderOverrides.getContentDisposition() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, responseHeaderOverrides.getContentDisposition());
            }
            if (responseHeaderOverrides.getContentEncoding() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, responseHeaderOverrides.getContentEncoding());
            }
            if (responseHeaderOverrides.getContentLanguage() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, responseHeaderOverrides.getContentLanguage());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.getExpires() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES, responseHeaderOverrides.getExpires());
            }
        }
    }

    private void assertStringNotNullOrEmpty(String str, String str2) {
        if (str != null) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException(str2);
            }
            return;
        }
        throw new IllegalArgumentException(str2);
    }

    private URL convertRequestToUrl(InternalRequest<AbstractBceRequest> internalRequest) {
        String str;
        String str2;
        String normalizePath = HttpUtils.normalizePath(internalRequest.getUri().getPath());
        boolean z = true;
        if (normalizePath.startsWith("/")) {
            normalizePath = normalizePath.substring(1);
        }
        String str3 = getEndpoint() + ("/" + normalizePath).replaceAll("(?<=/)/", "%2F");
        for (String str4 : internalRequest.getParameters().keySet()) {
            if (z) {
                str2 = str3 + "?";
                z = false;
            } else {
                str2 = str3 + "&";
            }
            str3 = str2 + str4 + "=" + HttpUtils.normalize(internalRequest.getParameters().get(str4));
        }
        if (internalRequest.getHeaders().get("Authorization") != null) {
            str3 = (z ? str3 + "?" : str3 + "&") + "authorization=" + HttpUtils.normalize(str);
        }
        try {
            return new URL(str3);
        } catch (MalformedURLException e2) {
            throw new BceClientException("Unable to convert request to well formed URL: " + e2.getMessage(), e2);
        }
    }

    private <T extends AbstractBceRequest> InternalRequest createRequest(T t, HttpMethodName httpMethodName) {
        Boolean isCnameEnabled;
        InternalRequest internalRequest = new InternalRequest(httpMethodName, HttpUtils.appendUri(getEndpoint(), "v1", (!(t instanceof GenericBucketRequest) || ((isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled()) != Boolean.FALSE && (isCnameEnabled != null || BosUtils.isCnameLikeHost(getEndpoint().getHost())))) ? null : ((GenericBucketRequest) t).getBucketName(), t instanceof GenericObjectRequest ? ((GenericObjectRequest) t).getKey() : null));
        internalRequest.setCredentials(t.getRequestCredentials());
        internalRequest.setRequest(t);
        return internalRequest;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0072 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x005a */
    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v13, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v17, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadObjectToFile(BosObject bosObject, File file, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        byte[] bArr2 = null;
        bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e3) {
                    BLog.error("Couldn't close the output stream", e3.getCause());
                }
            }
            try {
                bosObject.getObjectContent().close();
            } catch (Exception e4) {
                BLog.error("Couldn't get object content", e4.getCause());
            }
            throw th;
        }
        try {
            byte[] bArr3 = new byte[getStreamBufferSize()];
            while (true) {
                int read = bosObject.getObjectContent().read(bArr3);
                if (read > -1) {
                    bufferedOutputStream.write(bArr3, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception e5) {
                        BLog.error("Couldn't close the output stream", e5.getCause());
                    }
                }
            }
            bufferedOutputStream.close();
            try {
                bosObject.getObjectContent().close();
            } catch (Exception e6) {
                BLog.error("Couldn't get object content", e6.getCause());
            }
            if (z) {
                ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
                try {
                } catch (Exception e7) {
                    e = e7;
                    objectMetadata = null;
                }
                try {
                } catch (Exception e8) {
                    e = e8;
                    BLog.error("Unable to verify the integrity of the downloaded file", (Throwable) e);
                    bArr = null;
                    bArr2 = objectMetadata;
                    if (bArr2 == null) {
                    }
                }
                if (objectMetadata.getBceContentSha256() != null) {
                    byte[] decodeHex = ConvertUtils.decodeHex(objectMetadata.getBceContentSha256().toCharArray());
                    bArr = HashUtils.computeSha256Hash(new FileInputStream(file));
                    objectMetadata = decodeHex;
                } else if (objectMetadata.getContentMd5() != null) {
                    byte[] decode = Base64.decode(objectMetadata.getContentMd5().getBytes("UTF-8"), 0);
                    bArr = HashUtils.computeMd5Hash(new FileInputStream(file));
                    objectMetadata = decode;
                } else {
                    bArr = null;
                    if (bArr2 == null || bArr == null || Arrays.equals(bArr, bArr2)) {
                        return;
                    }
                    throw new BceClientException("Integrity verification failed! Client calculated content hash didn't match hash from server. The data stored in '" + file.getAbsolutePath() + "' may be corrupt.");
                }
                bArr2 = objectMetadata;
                if (bArr2 == null) {
                }
            }
        } catch (IOException e9) {
            e = e9;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                bosObject.getObjectContent().close();
            } catch (IOException e10) {
                BLog.error("Couldn't abort stream", (Throwable) e10);
            }
            throw new BceClientException("Unable to write to disk:" + e.getMessage(), e);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
            }
            bosObject.getObjectContent().close();
            throw th;
        }
    }

    private int getStreamBufferSize() {
        return ((BosClientConfiguration) this.config).getStreamBufferSize();
    }

    public static void populateRequestMetadata(InternalRequest internalRequest, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentType() != null) {
            internalRequest.addHeader("Content-Type", objectMetadata.getContentType());
        }
        if (objectMetadata.getContentMd5() != null) {
            internalRequest.addHeader(Headers.CONTENT_MD5, objectMetadata.getContentMd5());
        }
        if (objectMetadata.getContentEncoding() != null) {
            internalRequest.addHeader("Content-Encoding", HttpUtils.normalize(objectMetadata.getContentEncoding()));
        }
        if (objectMetadata.getBceContentSha256() != null) {
            internalRequest.addHeader(Headers.BCE_CONTENT_SHA256, objectMetadata.getBceContentSha256());
        }
        if (objectMetadata.getContentDisposition() != null) {
            internalRequest.addHeader("Content-Disposition", HttpUtils.normalize(objectMetadata.getContentDisposition()));
        }
        if (objectMetadata.getETag() != null) {
            internalRequest.addHeader("ETag", objectMetadata.getETag());
        }
        if (objectMetadata.getExpires() != null) {
            internalRequest.addHeader("Expires", objectMetadata.getExpires());
        }
        if (objectMetadata.getCacheControl() != null) {
            internalRequest.addHeader("Cache-Control", objectMetadata.getCacheControl());
        }
        if (objectMetadata.getStorageClass() != null) {
            internalRequest.addHeader(Headers.BCE_STORAGE_CLASS, objectMetadata.getStorageClass());
        }
        if (objectMetadata.getCrc32() != null) {
            internalRequest.addHeader(Headers.BCE_CRC32, String.valueOf(objectMetadata.getCrc32()));
        }
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null) {
            for (Map.Entry<String, String> entry : userMetadata.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    if (key.length() + value.length() <= 32768) {
                        internalRequest.addHeader(Headers.BCE_USER_METADATA_PREFIX + HttpUtils.normalize(key.trim()), HttpUtils.normalize(value));
                    } else {
                        throw new BceClientException("MetadataTooLarge");
                    }
                }
            }
        }
    }

    private List<byte[]> readAll(InputStream inputStream, ObjectMetadata objectMetadata) {
        ArrayList arrayList = new ArrayList();
        int streamBufferSize = getStreamBufferSize();
        long j = 0;
        while (true) {
            byte[] bArr = new byte[streamBufferSize];
            arrayList.add(bArr);
            int i2 = 0;
            while (i2 < streamBufferSize) {
                try {
                    int read = inputStream.read(bArr, i2, streamBufferSize - i2);
                    if (read < 0) {
                        objectMetadata.setContentLength(j);
                        return arrayList;
                    }
                    j += read;
                    i2 += read;
                } catch (IOException e2) {
                    throw new BceClientException("Fail to read data:" + e2.getMessage(), e2);
                }
            }
        }
    }

    private void setZeroContentLength(InternalRequest internalRequest) {
        internalRequest.addHeader("Content-Length", String.valueOf(0));
    }

    private BosResponse uploadObject(PutObjectRequest putObjectRequest, InternalRequest internalRequest) {
        FileInputStream fileInputStream;
        ObjectMetadata objectMetadata = putObjectRequest.getObjectMetadata();
        InputStream inputStream = putObjectRequest.getInputStream();
        if (putObjectRequest.getFile() != null) {
            File file = putObjectRequest.getFile();
            if (file.length() <= 5368709120L) {
                if (objectMetadata.getContentLength() < 0) {
                    objectMetadata.setContentLength(file.length());
                }
                if (objectMetadata.getContentType() == null) {
                    objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
                }
                if (objectMetadata.getContentLength() == file.length()) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        objectMetadata.setBceContentSha256(new String(ConvertUtils.encodeHex(HashUtils.computeSha256Hash(fileInputStream))));
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                            BLog.error("The inputStream accured error");
                        }
                    } catch (Exception e3) {
                        e = e3;
                        throw new BceClientException("Unable to calculate SHA-256 hash", e);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused2) {
                                BLog.error("The inputStream accured error");
                            }
                        }
                        throw th;
                    }
                }
                try {
                    internalRequest.setContent(new RestartableFileInputStream(file));
                } catch (FileNotFoundException e4) {
                    throw new BceClientException("Unable to find file to upload", e4);
                }
            } else {
                BceServiceException bceServiceException = new BceServiceException("Your proposed upload exceeds the maximum allowed object size.");
                bceServiceException.setStatusCode(400);
                bceServiceException.setErrorCode("EntityTooLarge");
                bceServiceException.setErrorType(BceServiceException.ErrorType.Client);
                throw bceServiceException;
            }
        } else {
            CheckUtils.isNotNull(inputStream, "Either file or inputStream should be set.");
            if (objectMetadata.getContentLength() < 0) {
                BLog.warn("No content length specified for stream data. Trying to read them all into memory.");
                internalRequest.setContent(new RestartableMultiByteArrayInputStream(readAll(inputStream, objectMetadata), objectMetadata.getContentLength()));
            } else if (inputStream instanceof RestartableInputStream) {
                internalRequest.setContent((RestartableInputStream) inputStream);
            } else {
                internalRequest.setContent(wrapRestartableInputStream(inputStream));
            }
            if (objectMetadata.getContentType() == null) {
                objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(putObjectRequest.getKey()));
            }
        }
        if (putObjectRequest.getStorageClass() != null) {
            objectMetadata.setStorageClass(putObjectRequest.getStorageClass());
        }
        internalRequest.addHeader("Content-Length", String.valueOf(objectMetadata.getContentLength()));
        populateRequestMetadata(internalRequest, objectMetadata);
        try {
            return (BosResponse) invokeHttpClient(internalRequest, BosResponse.class, putObjectRequest.getProgressCallback());
        } finally {
            try {
                internalRequest.getContent().close();
            } catch (Exception e5) {
                BLog.error("Fail to close input stream", (Throwable) e5);
            }
        }
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, getStreamBufferSize());
    }

    public void abortMultipartUpload(String str, String str2, String str3) {
        abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
    }

    public AppendObjectResponse appendObject(String str, String str2, File file) {
        return appendObject(new AppendObjectRequest(str, str2, file));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list));
    }

    public CopyObjectResponse copyObject(String str, String str2, String str3, String str4) {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CreateBucketResponse createBucket(String str) {
        return createBucket(new CreateBucketRequest(str));
    }

    public void deleteBucket(String str) {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteObject(String str, String str2) {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public boolean doesBucketExist(String str) {
        return doesBucketExist(new DoesBucketExistRequest(str));
    }

    public URL generatePresignedUrl(String str, String str2, int i2) {
        return generatePresignedUrl(str, str2, i2, HttpMethodName.GET);
    }

    public User getBosAccountOwner() {
        return getBosAccountOwner(new GetBosAccountOwnerRequest());
    }

    public GetBucketAclResponse getBucketAcl(String str) {
        return getBucketAcl(new GetBucketAclRequest(str));
    }

    public GetBucketLocationResponse getBucketLocation(String str) {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public BosObject getObject(String str, String str2) {
        return getObject(new GetObjectRequest(str, str2));
    }

    public byte[] getObjectContent(String str, String str2) {
        return getObjectContent(new GetObjectRequest(str, str2));
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(String str, String str2) {
        return initiateMultipartUpload(new InitiateMultipartUploadRequest(str, str2));
    }

    public ListBucketsResponse listBuckets() {
        return listBuckets(new ListBucketsRequest());
    }

    public ListMultipartUploadsResponse listMultipartUploads(String str) {
        return listMultipartUploads(new ListMultipartUploadsRequest(str));
    }

    public ListObjectsResponse listNextBatchOfObjects(ListObjectsResponse listObjectsResponse) {
        CheckUtils.isNotNull(listObjectsResponse, "previousResponse should not be null.");
        if (!listObjectsResponse.isTruncated()) {
            ListObjectsResponse listObjectsResponse2 = new ListObjectsResponse();
            listObjectsResponse2.setBucketName(listObjectsResponse.getBucketName());
            listObjectsResponse2.setDelimiter(listObjectsResponse.getDelimiter());
            listObjectsResponse2.setMarker(listObjectsResponse.getNextMarker());
            listObjectsResponse2.setMaxKeys(listObjectsResponse.getMaxKeys());
            listObjectsResponse2.setPrefix(listObjectsResponse.getPrefix());
            listObjectsResponse2.setTruncated(false);
            return listObjectsResponse2;
        }
        return listObjects(new ListObjectsRequest(listObjectsResponse.getBucketName()).withPrefix(listObjectsResponse.getPrefix()).withMarker(listObjectsResponse.getNextMarker()).withDelimiter(listObjectsResponse.getDelimiter()).withMaxKeys(listObjectsResponse.getMaxKeys()));
    }

    public ListObjectsResponse listObjects(String str) {
        return listObjects(new ListObjectsRequest(str));
    }

    public ListPartsResponse listParts(String str, String str2, String str3) {
        return listParts(new ListPartsRequest(str, str2, str3));
    }

    public PutObjectResponse putObject(String str, String str2, File file) {
        return putObject(new PutObjectRequest(str, str2, file));
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws JSONException {
        setBucketAcl(new SetBucketAclRequest(str, cannedAccessControlList));
    }

    @Deprecated
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, BosProgressCallback bosProgressCallback) {
        uploadPartRequest.setProgressCallback(bosProgressCallback);
        return uploadPart(uploadPartRequest);
    }

    public BosClient(BosClientConfiguration bosClientConfiguration) {
        super(bosClientConfiguration, bos_handlers);
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        CheckUtils.isNotNull(abortMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, file, objectMetadata));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list, objectMetadata));
    }

    public CreateBucketResponse createBucket(CreateBucketRequest createBucketRequest) {
        CheckUtils.isNotNull(createBucketRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(createBucketRequest, HttpMethodName.PUT);
        setZeroContentLength(createRequest);
        CreateBucketResponse createBucketResponse = new CreateBucketResponse();
        createBucketResponse.setName(createBucketRequest.getBucketName());
        createBucketResponse.setLocation(((BosResponse) invokeHttpClient(createRequest, BosResponse.class)).getMetadata().getLocation());
        return createBucketResponse;
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        CheckUtils.isNotNull(deleteBucketRequest, "request should not be null.");
        invokeHttpClient(createRequest(deleteBucketRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) {
        CheckUtils.isNotNull(deleteObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(deleteObjectRequest.getKey(), "object key should not be null or empty");
        invokeHttpClient(createRequest(deleteObjectRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public boolean doesBucketExist(DoesBucketExistRequest doesBucketExistRequest) {
        CheckUtils.isNotNull(doesBucketExistRequest, "request should not be null.");
        try {
            invokeHttpClient(createRequest(doesBucketExistRequest, HttpMethodName.HEAD), BosResponse.class);
            return true;
        } catch (BceServiceException e2) {
            if (e2.getStatusCode() == 403) {
                return true;
            }
            if (e2.getStatusCode() == 404) {
                return false;
            }
            throw e2;
        }
    }

    public URL generatePresignedUrl(String str, String str2, int i2, HttpMethodName httpMethodName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethodName);
        generatePresignedUrlRequest.setExpiration(i2);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public User getBosAccountOwner(GetBosAccountOwnerRequest getBosAccountOwnerRequest) {
        CheckUtils.isNotNull(getBosAccountOwnerRequest, "request should not be null.");
        return ((ListBucketsResponse) invokeHttpClient(createRequest(getBosAccountOwnerRequest, HttpMethodName.GET), ListBucketsResponse.class)).getOwner();
    }

    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) {
        CheckUtils.isNotNull(getBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketAclRequest, HttpMethodName.GET);
        createRequest.addParameter("acl", null);
        GetBucketAclResponse getBucketAclResponse = (GetBucketAclResponse) invokeHttpClient(createRequest, GetBucketAclResponse.class);
        if (getBucketAclResponse.getVersion() <= 1) {
            return getBucketAclResponse;
        }
        throw new BceClientException("Unsupported acl version.");
    }

    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) {
        CheckUtils.isNotNull(getBucketLocationRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter("location", null);
        return (GetBucketLocationResponse) invokeHttpClient(createRequest, GetBucketLocationResponse.class);
    }

    public ObjectMetadata getObject(String str, String str2, File file) {
        return getObject(new GetObjectRequest(str, str2), file);
    }

    public byte[] getObjectContent(GetObjectRequest getObjectRequest) {
        BosObjectInputStream objectContent = getObject(getObjectRequest).getObjectContent();
        try {
            try {
                byte[] inputStreamToByte = ConvertUtils.inputStreamToByte(objectContent);
                try {
                    objectContent.close();
                } catch (IOException unused) {
                }
                return inputStreamToByte;
            } catch (Throwable th) {
                try {
                    objectContent.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            try {
                objectContent.close();
            } catch (IOException unused3) {
            }
            throw new BceClientException("Fail read object content:" + e2.getMessage(), e2);
        }
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        CheckUtils.isNotNull(getObjectMetadataRequest, "request should not be null.");
        return ((GetObjectResponse) invokeHttpClient(createRequest(getObjectMetadataRequest, HttpMethodName.HEAD), GetObjectResponse.class)).getObject().getObjectMetadata();
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        CheckUtils.isNotNull(initiateMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploads", null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass());
        }
        setZeroContentLength(createRequest);
        if (initiateMultipartUploadRequest.getObjectMetadata() != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.getObjectMetadata());
        }
        return (InitiateMultipartUploadResponse) invokeHttpClient(createRequest, InitiateMultipartUploadResponse.class);
    }

    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) {
        CheckUtils.isNotNull(listBucketsRequest, "request should not be null.");
        return (ListBucketsResponse) invokeHttpClient(createRequest(listBucketsRequest, HttpMethodName.GET), ListBucketsResponse.class);
    }

    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        CheckUtils.isNotNull(listMultipartUploadsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listMultipartUploadsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploads", null);
        String keyMarker = listMultipartUploadsRequest.getKeyMarker();
        if (keyMarker != null) {
            createRequest.addParameter("keyMarker", keyMarker);
        }
        int maxUploads = listMultipartUploadsRequest.getMaxUploads();
        if (maxUploads >= 0) {
            createRequest.addParameter("maxUploads", String.valueOf(maxUploads));
        }
        String delimiter = listMultipartUploadsRequest.getDelimiter();
        if (delimiter != null) {
            createRequest.addParameter("delimiter", delimiter);
        }
        String prefix = listMultipartUploadsRequest.getPrefix();
        if (prefix != null) {
            createRequest.addParameter("prefix", prefix);
        }
        ListMultipartUploadsResponse listMultipartUploadsResponse = (ListMultipartUploadsResponse) invokeHttpClient(createRequest, ListMultipartUploadsResponse.class);
        listMultipartUploadsResponse.setBucketName(listMultipartUploadsRequest.getBucketName());
        return listMultipartUploadsResponse;
    }

    public ListObjectsResponse listObjects(String str, String str2) {
        return listObjects(new ListObjectsRequest(str, str2));
    }

    public ListPartsResponse listParts(ListPartsRequest listPartsRequest) {
        CheckUtils.isNotNull(listPartsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listPartsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploadId", listPartsRequest.getUploadId());
        int maxParts = listPartsRequest.getMaxParts();
        if (maxParts >= 0) {
            createRequest.addParameter("maxParts", String.valueOf(maxParts));
        }
        createRequest.addParameter("partNumberMarker", String.valueOf(listPartsRequest.getPartNumberMarker()));
        ListPartsResponse listPartsResponse = (ListPartsResponse) invokeHttpClient(createRequest, ListPartsResponse.class);
        listPartsResponse.setBucketName(listPartsRequest.getBucketName());
        return listPartsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, file, objectMetadata));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws JSONException {
        CheckUtils.isNotNull(setBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(setBucketAclRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", null);
        if (setBucketAclRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.BCE_ACL, setBucketAclRequest.getCannedAcl().toString());
            setZeroContentLength(createRequest);
        } else if (setBucketAclRequest.getAccessControlList() != null) {
            try {
                byte[] bytes = JsonUtils.setAclJson(setBucketAclRequest.getAccessControlList()).getBytes("UTF-8");
                createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
                createRequest.addHeader("Content-Type", "application/json");
                createRequest.setContent(RestartableInputStream.wrap(bytes));
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Fail to get UTF-8 bytes:" + e2.getMessage(), e2);
            }
        } else {
            CheckUtils.isNotNull(null, "request.acl should not be null.");
        }
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes.", e2);
        }
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws JSONException {
        CheckUtils.isNotNull(completeMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(completeMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploadId", completeMultipartUploadRequest.getUploadId());
        ObjectMetadata objectMetadata = completeMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata != null) {
            populateRequestMetadata(createRequest, objectMetadata);
        }
        try {
            byte[] bytes = JsonUtils.setPartETag(completeMultipartUploadRequest.getPartETags()).getBytes("UTF-8");
            createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
            createRequest.addHeader("Content-Type", "application/json");
            createRequest.setContent(RestartableInputStream.wrap(bytes));
            CompleteMultipartUploadResponse completeMultipartUploadResponse = (CompleteMultipartUploadResponse) invokeHttpClient(createRequest, CompleteMultipartUploadResponse.class);
            completeMultipartUploadResponse.setBucketName(completeMultipartUploadRequest.getBucketName());
            completeMultipartUploadResponse.setCrc32(completeMultipartUploadResponse.getMetadata().getCrc32());
            return completeMultipartUploadResponse;
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get UTF-8 bytes:" + e2.getMessage(), e2);
        }
    }

    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) {
        CheckUtils.isNotNull(copyObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(copyObjectRequest.getSourceKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(copyObjectRequest, HttpMethodName.PUT);
        createRequest.addHeader(Headers.BCE_COPY_SOURCE, HttpUtils.normalizePath("/" + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey()));
        if (copyObjectRequest.getETag() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MATCH, "\"" + copyObjectRequest.getETag() + "\"");
        }
        if (copyObjectRequest.getNoneMatchETagConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_NONE_MATCH, "\"" + copyObjectRequest.getNoneMatchETagConstraint() + "\"");
        }
        if (copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        }
        if (copyObjectRequest.getModifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            createRequest.addHeader(Headers.BCE_COPY_METADATA_DIRECTIVE, "replace");
            populateRequestMetadata(createRequest, newObjectMetadata);
        } else {
            createRequest.addHeader(Headers.BCE_COPY_METADATA_DIRECTIVE, "copy");
        }
        setZeroContentLength(createRequest);
        CopyObjectResponseWithExceptionInfo copyObjectResponseWithExceptionInfo = (CopyObjectResponseWithExceptionInfo) invokeHttpClient(createRequest, CopyObjectResponseWithExceptionInfo.class);
        if (copyObjectResponseWithExceptionInfo.getETag() == null && copyObjectResponseWithExceptionInfo.getLastModified() == null && copyObjectResponseWithExceptionInfo.getMessage() != null) {
            BceServiceException bceServiceException = new BceServiceException(copyObjectResponseWithExceptionInfo.getMessage());
            bceServiceException.setErrorCode(copyObjectResponseWithExceptionInfo.getCode());
            bceServiceException.setRequestId(copyObjectResponseWithExceptionInfo.getRequestId());
            if (bceServiceException.getErrorCode() == "InternalError") {
                bceServiceException.setErrorType(BceServiceException.ErrorType.Service);
            } else {
                bceServiceException.setErrorType(BceServiceException.ErrorType.Client);
            }
            bceServiceException.setStatusCode(500);
            throw bceServiceException;
        }
        return copyObjectResponseWithExceptionInfo;
    }

    public BosObject getObject(GetObjectRequest getObjectRequest) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getObjectRequest, HttpMethodName.GET);
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            createRequest.addHeader("Range", "bytes=" + range[0] + "-" + range[1]);
        }
        BosObject object = ((GetObjectResponse) invokeHttpClient(createRequest, GetObjectResponse.class)).getObject();
        object.setBucketName(getObjectRequest.getBucketName());
        object.setKey(getObjectRequest.getKey());
        return object;
    }

    public ListObjectsResponse listObjects(ListObjectsRequest listObjectsRequest) {
        CheckUtils.isNotNull(listObjectsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listObjectsRequest, HttpMethodName.GET);
        if (listObjectsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            createRequest.addParameter("marker", listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() >= 0) {
            createRequest.addParameter("maxKeys", String.valueOf(listObjectsRequest.getMaxKeys()));
        }
        ListObjectsResponse listObjectsResponse = (ListObjectsResponse) invokeHttpClient(createRequest, ListObjectsResponse.class);
        listObjectsResponse.setBucketName(listObjectsRequest.getBucketName());
        for (BosObjectSummary bosObjectSummary : listObjectsResponse.getContents()) {
            bosObjectSummary.setBucketName(listObjectsRequest.getBucketName());
        }
        return listObjectsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, String str3) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes:" + e2.getMessage(), e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest) {
        CheckUtils.isNotNull(uploadPartRequest, "request should not be null.");
        CheckUtils.isNotNull(Long.valueOf(uploadPartRequest.getPartSize()), "partSize should not be null");
        CheckUtils.isNotNull(Integer.valueOf(uploadPartRequest.getPartNumber()), "partNumber should not be null");
        if (uploadPartRequest.getPartSize() <= 5368709120L) {
            InternalRequest createRequest = createRequest(uploadPartRequest, HttpMethodName.PUT);
            createRequest.addParameter("uploadId", uploadPartRequest.getUploadId());
            createRequest.addParameter("partNumber", String.valueOf(uploadPartRequest.getPartNumber()));
            createRequest.addHeader("Content-Length", String.valueOf(uploadPartRequest.getPartSize()));
            InputStream inputStream = uploadPartRequest.getInputStream();
            MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream = 0;
            mD5DigestCalculatingInputStream = 0;
            if (uploadPartRequest.getMd5Digest() == null) {
                try {
                    inputStream = new MD5DigestCalculatingInputStream(inputStream);
                    mD5DigestCalculatingInputStream = inputStream;
                } catch (NoSuchAlgorithmException e2) {
                    BLog.error("Unable to verify data integrity.", (Throwable) e2);
                }
            }
            if (uploadPartRequest.getCrc32() != null) {
                createRequest.addHeader(Headers.BCE_CRC32, String.valueOf(uploadPartRequest.getCrc32()));
            }
            try {
                createRequest.setContent(wrapRestartableInputStream(inputStream, Long.valueOf(uploadPartRequest.getPartSize())));
                BosResponse bosResponse = (BosResponse) invokeHttpClient(createRequest, BosResponse.class, uploadPartRequest.getProgressCallback());
                if (mD5DigestCalculatingInputStream != 0) {
                    try {
                        if (!Arrays.equals(mD5DigestCalculatingInputStream.getMd5Digest(), ConvertUtils.decodeHex(bosResponse.getMetadata().getETag().toCharArray()))) {
                            throw new BceClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Baidu BOS.  You may need to delete the data stored in Baidu BOS.");
                        }
                    } catch (Exception e3) {
                        throw new BceClientException("Unable to verify integrity of data upload:" + e3.getMessage(), e3);
                    }
                }
                UploadPartResponse uploadPartResponse = new UploadPartResponse();
                uploadPartResponse.setETag(bosResponse.getMetadata().getETag());
                uploadPartResponse.setCrc32(bosResponse.getMetadata().getCrc32());
                uploadPartResponse.setPartNumber(uploadPartRequest.getPartNumber());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                return uploadPartResponse;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        throw new BceClientException("PartNumber " + uploadPartRequest.getPartNumber() + " : Part Size should not be more than 5GB.");
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream, Long l) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, l.longValue() > ((long) getStreamBufferSize()) ? getStreamBufferSize() : l.intValue());
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes.", e2);
        }
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        CheckUtils.isNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        HttpMethodName valueOf = HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString());
        Boolean isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled();
        InternalRequest internalRequest = new InternalRequest(valueOf, HttpUtils.appendUri(getEndpoint(), "v1", (isCnameEnabled == Boolean.FALSE || (isCnameEnabled == null && !BosUtils.isCnameLikeHost(getEndpoint().getHost()))) ? generatePresignedUrlRequest.getBucketName() : null, generatePresignedUrlRequest.getKey()));
        internalRequest.setCredentials(generatePresignedUrlRequest.getRequestCredentials());
        SignOptions signOptions = new SignOptions();
        signOptions.setExpirationInSeconds(generatePresignedUrlRequest.getExpiration());
        for (Map.Entry<String, String> entry : generatePresignedUrlRequest.getRequestHeaders().entrySet()) {
            if (entry.getValue() == null) {
                internalRequest.addHeader(entry.getKey(), "");
            } else {
                internalRequest.addHeader(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : generatePresignedUrlRequest.getRequestParameters().entrySet()) {
            if (entry2.getValue() == null) {
                internalRequest.addParameter(entry2.getKey(), "");
            } else {
                internalRequest.addParameter(entry2.getKey(), entry2.getValue());
            }
        }
        if (generatePresignedUrlRequest.getContentType() != null) {
            internalRequest.addHeader("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMd5() != null) {
            internalRequest.addHeader(Headers.CONTENT_MD5, generatePresignedUrlRequest.getContentMd5());
        }
        addResponseHeaderParameters(internalRequest, generatePresignedUrlRequest.getResponseHeaders());
        new BceV1Signer().sign(internalRequest, this.config.getCredentials(), signOptions);
        return convertRequestToUrl(internalRequest);
    }

    public PutObjectResponse putObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes:" + e2.getMessage(), e2);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr) {
        return appendObject(str, str2, bArr, new ObjectMetadata());
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr) {
        return putObject(str, str2, bArr, new ObjectMetadata());
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength(bArr.length);
        }
        return appendObject(new AppendObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength(bArr.length);
        }
        return putObject(new PutObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        CheckUtils.isNotNull(file, "destinationFile should not be null.");
        BosObject object = getObject(getObjectRequest);
        downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
        return object.getObjectMetadata();
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream) {
        return putObject(new PutObjectRequest(str, str2, inputStream));
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
        CheckUtils.isNotNull(putObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(putObjectRequest.getKey(), "object key should not be null or empty");
        BosResponse uploadObject = uploadObject(putObjectRequest, createRequest(putObjectRequest, HttpMethodName.PUT));
        PutObjectResponse putObjectResponse = new PutObjectResponse();
        putObjectResponse.setETag(uploadObject.getMetadata().getETag());
        putObjectResponse.setCrc32(uploadObject.getMetadata().getCrc32());
        return putObjectResponse;
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream));
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
        CheckUtils.isNotNull(appendObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(appendObjectRequest.getKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(appendObjectRequest, HttpMethodName.POST);
        createRequest.addParameter("append", null);
        if (appendObjectRequest.getOffset() != null) {
            createRequest.addParameter("offset", appendObjectRequest.getOffset().toString());
        }
        BosResponse uploadObject = uploadObject(appendObjectRequest, createRequest);
        AppendObjectResponse appendObjectResponse = new AppendObjectResponse();
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        appendObjectResponse.setContentMd5(uploadObject.getMetadata().getContentMd5());
        appendObjectResponse.setETag(uploadObject.getMetadata().getETag());
        appendObjectResponse.setCrc32(uploadObject.getMetadata().getCrc32());
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        return appendObjectResponse;
    }

    @Deprecated
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, BosProgressCallback bosProgressCallback) {
        putObjectRequest.setProgressCallback(bosProgressCallback);
        return putObject(putObjectRequest);
    }
}
