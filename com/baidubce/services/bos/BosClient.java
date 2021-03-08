package com.baidubce.services.bos;

import android.annotation.SuppressLint;
import android.net.http.Headers;
import android.util.Base64;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.auth.SignOptions;
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
import com.xiaomi.mipush.sdk.Constants;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class BosClient extends AbstractBceClient {
    public static final String STORAGE_CLASS_COLD = "COLD";
    public static final String STORAGE_CLASS_STANDARD = "STANDARD";
    public static final String STORAGE_CLASS_STANDARD_IA = "STANDARD_IA";
    private static final HttpResponseHandler[] bos_handlers = {new BceMetadataResponseHandler(), new BosMetadataResponseHandler(), new BceErrorResponseHandler(), new BosObjectResponseHandler(), new BceJsonResponseHandler()};

    public BosClient() {
        this(new BosClientConfiguration());
    }

    public BosClient(BosClientConfiguration bosClientConfiguration) {
        super(bosClientConfiguration, bos_handlers);
    }

    public User getBosAccountOwner() {
        return getBosAccountOwner(new GetBosAccountOwnerRequest());
    }

    public User getBosAccountOwner(GetBosAccountOwnerRequest getBosAccountOwnerRequest) {
        CheckUtils.isNotNull(getBosAccountOwnerRequest, "request should not be null.");
        return ((ListBucketsResponse) invokeHttpClient(createRequest(getBosAccountOwnerRequest, HttpMethodName.GET), ListBucketsResponse.class)).getOwner();
    }

    public ListBucketsResponse listBuckets() {
        return listBuckets(new ListBucketsRequest());
    }

    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) {
        CheckUtils.isNotNull(listBucketsRequest, "request should not be null.");
        return (ListBucketsResponse) invokeHttpClient(createRequest(listBucketsRequest, HttpMethodName.GET), ListBucketsResponse.class);
    }

    public CreateBucketResponse createBucket(String str) {
        return createBucket(new CreateBucketRequest(str));
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

    public GetBucketLocationResponse getBucketLocation(String str) {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) {
        CheckUtils.isNotNull(getBucketLocationRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter(Headers.LOCATION, null);
        return (GetBucketLocationResponse) invokeHttpClient(createRequest, GetBucketLocationResponse.class);
    }

    public boolean doesBucketExist(String str) {
        return doesBucketExist(new DoesBucketExistRequest(str));
    }

    public boolean doesBucketExist(DoesBucketExistRequest doesBucketExistRequest) {
        CheckUtils.isNotNull(doesBucketExistRequest, "request should not be null.");
        try {
            invokeHttpClient(createRequest(doesBucketExistRequest, HttpMethodName.HEAD), BosResponse.class);
            return true;
        } catch (BceServiceException e) {
            if (e.getStatusCode() != 403) {
                if (e.getStatusCode() == 404) {
                    return false;
                }
                throw e;
            }
            return true;
        }
    }

    public GetBucketAclResponse getBucketAcl(String str) {
        return getBucketAcl(new GetBucketAclRequest(str));
    }

    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) {
        CheckUtils.isNotNull(getBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketAclRequest, HttpMethodName.GET);
        createRequest.addParameter("acl", null);
        GetBucketAclResponse getBucketAclResponse = (GetBucketAclResponse) invokeHttpClient(createRequest, GetBucketAclResponse.class);
        if (getBucketAclResponse.getVersion() > 1) {
            throw new BceClientException("Unsupported acl version.");
        }
        return getBucketAclResponse;
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws JSONException {
        setBucketAcl(new SetBucketAclRequest(str, cannedAccessControlList));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws JSONException {
        CheckUtils.isNotNull(setBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(setBucketAclRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", null);
        if (setBucketAclRequest.getCannedAcl() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_ACL, setBucketAclRequest.getCannedAcl().toString());
            setZeroContentLength(createRequest);
        } else if (setBucketAclRequest.getAccessControlList() != null) {
            try {
                byte[] bytes = JsonUtils.setAclJson(setBucketAclRequest.getAccessControlList()).getBytes("UTF-8");
                createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
                createRequest.addHeader("Content-Type", HttpHelper.CONTENT_JSON);
                createRequest.setContent(RestartableInputStream.wrap(bytes));
            } catch (UnsupportedEncodingException e) {
                throw new BceClientException("Fail to get UTF-8 bytes:" + e.getMessage(), e);
            }
        } else {
            CheckUtils.isNotNull(null, "request.acl should not be null.");
        }
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public void deleteBucket(String str) {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        CheckUtils.isNotNull(deleteBucketRequest, "request should not be null.");
        invokeHttpClient(createRequest(deleteBucketRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public URL generatePresignedUrl(String str, String str2, int i) {
        return generatePresignedUrl(str, str2, i, HttpMethodName.GET);
    }

    public URL generatePresignedUrl(String str, String str2, int i, HttpMethodName httpMethodName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethodName);
        generatePresignedUrlRequest.setExpiration(i);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        String bucketName;
        CheckUtils.isNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        HttpMethodName valueOf = HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString());
        Boolean isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled();
        if (isCnameEnabled != Boolean.FALSE && (isCnameEnabled != null || BosUtils.isCnameLikeHost(getEndpoint().getHost()))) {
            bucketName = null;
        } else {
            bucketName = generatePresignedUrlRequest.getBucketName();
        }
        InternalRequest internalRequest = new InternalRequest(valueOf, HttpUtils.appendUri(getEndpoint(), AbstractBceClient.URL_PREFIX, bucketName, generatePresignedUrlRequest.getKey()));
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
            internalRequest.addHeader(com.baidubce.http.Headers.CONTENT_MD5, generatePresignedUrlRequest.getContentMd5());
        }
        addResponseHeaderParameters(internalRequest, generatePresignedUrlRequest.getResponseHeaders());
        new BceV1Signer().sign(internalRequest, this.config.getCredentials(), signOptions);
        return convertRequestToUrl(internalRequest);
    }

    public ListObjectsResponse listObjects(String str) {
        return listObjects(new ListObjectsRequest(str));
    }

    public ListObjectsResponse listObjects(String str, String str2) {
        return listObjects(new ListObjectsRequest(str, str2));
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

    public BosObject getObject(String str, String str2) {
        return getObject(new GetObjectRequest(str, str2));
    }

    public ObjectMetadata getObject(String str, String str2, File file) {
        return getObject(new GetObjectRequest(str, str2), file);
    }

    public BosObject getObject(GetObjectRequest getObjectRequest) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getObjectRequest, HttpMethodName.GET);
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            createRequest.addHeader(com.baidubce.http.Headers.RANGE, "bytes=" + range[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + range[1]);
        }
        BosObject object = ((GetObjectResponse) invokeHttpClient(createRequest, GetObjectResponse.class)).getObject();
        object.setBucketName(getObjectRequest.getBucketName());
        object.setKey(getObjectRequest.getKey());
        return object;
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        CheckUtils.isNotNull(file, "destinationFile should not be null.");
        BosObject object = getObject(getObjectRequest);
        downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
        return object.getObjectMetadata();
    }

    public byte[] getObjectContent(String str, String str2) {
        return getObjectContent(new GetObjectRequest(str, str2));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public byte[] getObjectContent(GetObjectRequest getObjectRequest) {
        BosObjectInputStream objectContent = getObject(getObjectRequest).getObjectContent();
        try {
            try {
                return ConvertUtils.inputStreamToByte(objectContent);
            } catch (IOException e) {
                try {
                    objectContent.close();
                } catch (IOException e2) {
                }
                throw new BceClientException("Fail read object content:" + e.getMessage(), e);
            }
        } finally {
            try {
                objectContent.close();
            } catch (IOException e3) {
            }
        }
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        CheckUtils.isNotNull(getObjectMetadataRequest, "request should not be null.");
        return ((GetObjectResponse) invokeHttpClient(createRequest(getObjectMetadataRequest, HttpMethodName.HEAD), GetObjectResponse.class)).getObject().getObjectMetadata();
    }

    public PutObjectResponse putObject(String str, String str2, File file) {
        return putObject(new PutObjectRequest(str, str2, file));
    }

    public PutObjectResponse putObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, file, objectMetadata));
    }

    public PutObjectResponse putObject(String str, String str2, String str3) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes:" + e.getMessage(), e);
        }
    }

    public PutObjectResponse putObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes:" + e.getMessage(), e);
        }
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr) {
        return putObject(str, str2, bArr, new ObjectMetadata());
    }

    public AppendObjectResponse appendObject(String str, String str2, File file) {
        return appendObject(new AppendObjectRequest(str, str2, file));
    }

    public AppendObjectResponse appendObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, file, objectMetadata));
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes.", e);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get bytes.", e);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr) {
        return appendObject(str, str2, bArr, new ObjectMetadata());
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength(bArr.length);
        }
        return appendObject(new AppendObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
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

    public PutObjectResponse putObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength(bArr.length);
        }
        return putObject(new PutObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
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

    @Deprecated
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, BosProgressCallback bosProgressCallback) {
        putObjectRequest.setProgressCallback(bosProgressCallback);
        return putObject(putObjectRequest);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BosResponse uploadObject(PutObjectRequest putObjectRequest, InternalRequest internalRequest) {
        FileInputStream fileInputStream;
        ObjectMetadata objectMetadata = putObjectRequest.getObjectMetadata();
        InputStream inputStream = putObjectRequest.getInputStream();
        if (putObjectRequest.getFile() != null) {
            File file = putObjectRequest.getFile();
            if (file.length() > 5368709120L) {
                BceServiceException bceServiceException = new BceServiceException("Your proposed upload exceeds the maximum allowed object size.");
                bceServiceException.setStatusCode(400);
                bceServiceException.setErrorCode("EntityTooLarge");
                bceServiceException.setErrorType(BceServiceException.ErrorType.Client);
                throw bceServiceException;
            }
            if (objectMetadata.getContentLength() < 0) {
                objectMetadata.setContentLength(file.length());
            }
            if (objectMetadata.getContentType() == null) {
                objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
            }
            if (objectMetadata.getContentLength() == file.length()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            objectMetadata.setBceContentSha256(new String(ConvertUtils.encodeHex(HashUtils.computeSha256Hash(fileInputStream))));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e) {
                                    BLog.error("The inputStream accured error");
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            throw new BceClientException("Unable to calculate SHA-256 hash", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                BLog.error("The inputStream accured error");
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
            try {
                internalRequest.setContent(new RestartableFileInputStream(file));
            } catch (FileNotFoundException e5) {
                throw new BceClientException("Unable to find file to upload", e5);
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
            } catch (Exception e6) {
                BLog.error("Fail to close input stream", (Throwable) e6);
            }
        }
    }

    public CopyObjectResponse copyObject(String str, String str2, String str3, String str4) {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) {
        CheckUtils.isNotNull(copyObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(copyObjectRequest.getSourceKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(copyObjectRequest, HttpMethodName.PUT);
        createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_SOURCE, HttpUtils.normalizePath("/" + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey()));
        if (copyObjectRequest.getETag() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_SOURCE_IF_MATCH, "\"" + copyObjectRequest.getETag() + "\"");
        }
        if (copyObjectRequest.getNoneMatchETagConstraint() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_SOURCE_IF_NONE_MATCH, "\"" + copyObjectRequest.getNoneMatchETagConstraint() + "\"");
        }
        if (copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        }
        if (copyObjectRequest.getModifiedSinceConstraint() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_METADATA_DIRECTIVE, "replace");
            populateRequestMetadata(createRequest, newObjectMetadata);
        } else {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_COPY_METADATA_DIRECTIVE, "copy");
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

    public void deleteObject(String str, String str2) {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) {
        CheckUtils.isNotNull(deleteObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(deleteObjectRequest.getKey(), "object key should not be null or empty");
        invokeHttpClient(createRequest(deleteObjectRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(String str, String str2) {
        return initiateMultipartUpload(new InitiateMultipartUploadRequest(str, str2));
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        CheckUtils.isNotNull(initiateMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploads", null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass());
        }
        setZeroContentLength(createRequest);
        if (initiateMultipartUploadRequest.getObjectMetadata() != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.getObjectMetadata());
        }
        return (InitiateMultipartUploadResponse) invokeHttpClient(createRequest, InitiateMultipartUploadResponse.class);
    }

    @Deprecated
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, BosProgressCallback bosProgressCallback) {
        uploadPartRequest.setProgressCallback(bosProgressCallback);
        return uploadPart(uploadPartRequest);
    }

    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest) {
        CheckUtils.isNotNull(uploadPartRequest, "request should not be null.");
        CheckUtils.isNotNull(Long.valueOf(uploadPartRequest.getPartSize()), "partSize should not be null");
        CheckUtils.isNotNull(Integer.valueOf(uploadPartRequest.getPartNumber()), "partNumber should not be null");
        if (uploadPartRequest.getPartSize() > 5368709120L) {
            throw new BceClientException("PartNumber " + uploadPartRequest.getPartNumber() + " : Part Size should not be more than 5GB.");
        }
        InternalRequest createRequest = createRequest(uploadPartRequest, HttpMethodName.PUT);
        createRequest.addParameter("uploadId", uploadPartRequest.getUploadId());
        createRequest.addParameter("partNumber", String.valueOf(uploadPartRequest.getPartNumber()));
        createRequest.addHeader("Content-Length", String.valueOf(uploadPartRequest.getPartSize()));
        InputStream inputStream = uploadPartRequest.getInputStream();
        MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream = null;
        if (uploadPartRequest.getMd5Digest() == null) {
            try {
                MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream2 = new MD5DigestCalculatingInputStream(inputStream);
                mD5DigestCalculatingInputStream = mD5DigestCalculatingInputStream2;
                inputStream = mD5DigestCalculatingInputStream2;
            } catch (NoSuchAlgorithmException e) {
                BLog.error("Unable to verify data integrity.", (Throwable) e);
            }
        }
        if (uploadPartRequest.getCrc32() != null) {
            createRequest.addHeader(com.baidubce.http.Headers.BCE_CRC32, String.valueOf(uploadPartRequest.getCrc32()));
        }
        try {
            createRequest.setContent(wrapRestartableInputStream(inputStream, Long.valueOf(uploadPartRequest.getPartSize())));
            BosResponse bosResponse = (BosResponse) invokeHttpClient(createRequest, BosResponse.class, uploadPartRequest.getProgressCallback());
            if (mD5DigestCalculatingInputStream != null) {
                try {
                    if (!Arrays.equals(mD5DigestCalculatingInputStream.getMd5Digest(), ConvertUtils.decodeHex(bosResponse.getMetadata().getETag().toCharArray()))) {
                        throw new BceClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Baidu BOS.  You may need to delete the data stored in Baidu BOS.");
                    }
                } catch (Exception e2) {
                    throw new BceClientException("Unable to verify integrity of data upload:" + e2.getMessage(), e2);
                }
            }
            UploadPartResponse uploadPartResponse = new UploadPartResponse();
            uploadPartResponse.setETag(bosResponse.getMetadata().getETag());
            uploadPartResponse.setCrc32(bosResponse.getMetadata().getCrc32());
            uploadPartResponse.setPartNumber(uploadPartRequest.getPartNumber());
            return uploadPartResponse;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        }
    }

    public ListPartsResponse listParts(String str, String str2, String str3) {
        return listParts(new ListPartsRequest(str, str2, str3));
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

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list, objectMetadata));
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
            createRequest.addHeader("Content-Type", HttpHelper.CONTENT_JSON);
            createRequest.setContent(RestartableInputStream.wrap(bytes));
            CompleteMultipartUploadResponse completeMultipartUploadResponse = (CompleteMultipartUploadResponse) invokeHttpClient(createRequest, CompleteMultipartUploadResponse.class);
            completeMultipartUploadResponse.setBucketName(completeMultipartUploadRequest.getBucketName());
            completeMultipartUploadResponse.setCrc32(completeMultipartUploadResponse.getMetadata().getCrc32());
            return completeMultipartUploadResponse;
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Fail to get UTF-8 bytes:" + e.getMessage(), e);
        }
    }

    public void abortMultipartUpload(String str, String str2, String str3) {
        abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        CheckUtils.isNotNull(abortMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public ListMultipartUploadsResponse listMultipartUploads(String str) {
        return listMultipartUploads(new ListMultipartUploadsRequest(str));
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

    private static void populateRequestMetadata(InternalRequest internalRequest, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentType() != null) {
            internalRequest.addHeader("Content-Type", objectMetadata.getContentType());
        }
        if (objectMetadata.getContentMd5() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.CONTENT_MD5, objectMetadata.getContentMd5());
        }
        if (objectMetadata.getContentEncoding() != null) {
            internalRequest.addHeader("Content-Encoding", HttpUtils.normalize(objectMetadata.getContentEncoding()));
        }
        if (objectMetadata.getBceContentSha256() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.BCE_CONTENT_SHA256, objectMetadata.getBceContentSha256());
        }
        if (objectMetadata.getContentDisposition() != null) {
            internalRequest.addHeader("Content-Disposition", HttpUtils.normalize(objectMetadata.getContentDisposition()));
        }
        if (objectMetadata.getETag() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.ETAG, objectMetadata.getETag());
        }
        if (objectMetadata.getExpires() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.EXPIRES, objectMetadata.getExpires());
        }
        if (objectMetadata.getCacheControl() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.CACHE_CONTROL, objectMetadata.getCacheControl());
        }
        if (objectMetadata.getStorageClass() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.BCE_STORAGE_CLASS, objectMetadata.getStorageClass());
        }
        if (objectMetadata.getCrc32() != null) {
            internalRequest.addHeader(com.baidubce.http.Headers.BCE_CRC32, String.valueOf(objectMetadata.getCrc32()));
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
                    if (key.length() + value.length() > 32768) {
                        throw new BceClientException("MetadataTooLarge");
                    }
                    internalRequest.addHeader(com.baidubce.http.Headers.BCE_USER_METADATA_PREFIX + HttpUtils.normalize(key.trim()), HttpUtils.normalize(value));
                }
            }
        }
    }

    private <T extends AbstractBceRequest> InternalRequest createRequest(T t, HttpMethodName httpMethodName) {
        Boolean isCnameEnabled;
        InternalRequest internalRequest = new InternalRequest(httpMethodName, HttpUtils.appendUri(getEndpoint(), AbstractBceClient.URL_PREFIX, (!(t instanceof GenericBucketRequest) || ((isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled()) != Boolean.FALSE && (isCnameEnabled != null || BosUtils.isCnameLikeHost(getEndpoint().getHost())))) ? null : ((GenericBucketRequest) t).getBucketName(), t instanceof GenericObjectRequest ? ((GenericObjectRequest) t).getKey() : null));
        internalRequest.setCredentials(t.getRequestCredentials());
        internalRequest.setRequest(t);
        return internalRequest;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0129 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0092 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x007b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadObjectToFile(BosObject bosObject, File file, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        String str;
        byte[] bArr;
        BufferedOutputStream bufferedOutputStream2 = null;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception e) {
                        BLog.error("Couldn't close the output stream", e.getCause());
                    }
                }
                try {
                    bosObject.getObjectContent().close();
                } catch (Exception e2) {
                    BLog.error("Couldn't get object content", e2.getCause());
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        }
        try {
            byte[] bArr2 = new byte[getStreamBufferSize()];
            while (true) {
                int read = bosObject.getObjectContent().read(bArr2);
                if (read <= -1) {
                    break;
                }
                bufferedOutputStream.write(bArr2, 0, read);
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                    BLog.error("Couldn't close the output stream", e4.getCause());
                }
            }
            try {
                bosObject.getObjectContent().close();
            } catch (Exception e5) {
                BLog.error("Couldn't get object content", e5.getCause());
            }
            if (z) {
                ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
                try {
                    str = objectMetadata.getBceContentSha256();
                } catch (Exception e6) {
                    e = e6;
                    str = 0;
                }
                try {
                    if (str != 0) {
                        byte[] decodeHex = ConvertUtils.decodeHex(objectMetadata.getBceContentSha256().toCharArray());
                        bArr = HashUtils.computeSha256Hash(new FileInputStream(file));
                        str = decodeHex;
                    } else if (objectMetadata.getContentMd5() != null) {
                        byte[] decode = Base64.decode(objectMetadata.getContentMd5().getBytes("UTF-8"), 0);
                        bArr = HashUtils.computeMd5Hash(new FileInputStream(file));
                        str = decode;
                    } else {
                        bArr = null;
                        str = 0;
                    }
                } catch (Exception e7) {
                    e = e7;
                    BLog.error("Unable to verify the integrity of the downloaded file", (Throwable) e);
                    bArr = null;
                    if (str == 0) {
                        return;
                    }
                    return;
                }
                if (str == 0 && bArr != null && !Arrays.equals(bArr, (byte[]) str)) {
                    throw new BceClientException("Integrity verification failed! Client calculated content hash didn't match hash from server. The data stored in '" + file.getAbsolutePath() + "' may be corrupt.");
                }
            }
        } catch (IOException e8) {
            e = e8;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                bosObject.getObjectContent().close();
            } catch (IOException e9) {
                BLog.error("Couldn't abort stream", (Throwable) e9);
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

    private List<byte[]> readAll(InputStream inputStream, ObjectMetadata objectMetadata) {
        ArrayList arrayList = new ArrayList();
        int streamBufferSize = getStreamBufferSize();
        long j = 0;
        while (true) {
            byte[] bArr = new byte[streamBufferSize];
            arrayList.add(bArr);
            int i = 0;
            while (i < streamBufferSize) {
                try {
                    int read = inputStream.read(bArr, i, streamBufferSize - i);
                    if (read < 0) {
                        objectMetadata.setContentLength(j);
                        return arrayList;
                    }
                    j += read;
                    i += read;
                } catch (IOException e) {
                    throw new BceClientException("Fail to read data:" + e.getMessage(), e);
                }
            }
        }
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream) {
        return inputStream.markSupported() ? new RestartableResettableInputStream(inputStream) : new RestartableNonResettableInputStream(inputStream, getStreamBufferSize());
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream, Long l) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, l.longValue() > ((long) getStreamBufferSize()) ? getStreamBufferSize() : l.intValue());
    }

    private void setZeroContentLength(InternalRequest internalRequest) {
        internalRequest.addHeader("Content-Length", String.valueOf(0));
    }

    private int getStreamBufferSize() {
        return ((BosClientConfiguration) this.config).getStreamBufferSize();
    }

    private void assertStringNotNullOrEmpty(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException(str2);
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
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

    private URL convertRequestToUrl(InternalRequest<AbstractBceRequest> internalRequest) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2 = true;
        String normalizePath = HttpUtils.normalizePath(internalRequest.getUri().getPath());
        if (normalizePath.startsWith("/")) {
            normalizePath = normalizePath.substring(1);
        }
        String str5 = getEndpoint() + ("/" + normalizePath).replaceAll("(?<=/)/", "%2F");
        Iterator<String> it = internalRequest.getParameters().keySet().iterator();
        while (true) {
            str = str5;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (z2) {
                z = false;
                str4 = str + "?";
            } else {
                str4 = str + ETAG.ITEM_SEPARATOR;
                z = z2;
            }
            str5 = str4 + next + "=" + HttpUtils.normalize(internalRequest.getParameters().get(next));
            z2 = z;
        }
        if (internalRequest.getHeaders().get("Authorization") != null) {
            if (z2) {
                str3 = str + "?";
            } else {
                str3 = str + ETAG.ITEM_SEPARATOR;
            }
            str = str3 + "authorization=" + HttpUtils.normalize(str2);
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new BceClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }
}
