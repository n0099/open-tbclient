package com.baidubce.services.bos;

import android.annotation.SuppressLint;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientConfiguration;
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
/* loaded from: classes5.dex */
public class BosClient extends AbstractBceClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String STORAGE_CLASS_COLD = "COLD";
    public static final String STORAGE_CLASS_STANDARD = "STANDARD";
    public static final String STORAGE_CLASS_STANDARD_IA = "STANDARD_IA";
    public static final HttpResponseHandler[] bos_handlers;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(515038296, "Lcom/baidubce/services/bos/BosClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(515038296, "Lcom/baidubce/services/bos/BosClient;");
                return;
            }
        }
        bos_handlers = new HttpResponseHandler[]{new BceMetadataResponseHandler(), new BosMetadataResponseHandler(), new BceErrorResponseHandler(), new BosObjectResponseHandler(), new BceJsonResponseHandler()};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BosClient() {
        this(new BosClientConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((BosClientConfiguration) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addResponseHeaderParameters(InternalRequest internalRequest, ResponseHeaderOverrides responseHeaderOverrides) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, internalRequest, responseHeaderOverrides) == null) || responseHeaderOverrides == null) {
            return;
        }
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

    private void assertStringNotNullOrEmpty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            if (str != null) {
                if (str.isEmpty()) {
                    throw new IllegalArgumentException(str2);
                }
                return;
            }
            throw new IllegalArgumentException(str2);
        }
    }

    private URL convertRequestToUrl(InternalRequest<AbstractBceRequest> internalRequest) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, internalRequest)) == null) {
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
        return (URL) invokeL.objValue;
    }

    private <T extends AbstractBceRequest> InternalRequest createRequest(T t, HttpMethodName httpMethodName) {
        InterceptResult invokeLL;
        Boolean isCnameEnabled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, t, httpMethodName)) == null) {
            InternalRequest internalRequest = new InternalRequest(httpMethodName, HttpUtils.appendUri(getEndpoint(), "v1", (!(t instanceof GenericBucketRequest) || ((isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled()) != Boolean.FALSE && (isCnameEnabled != null || BosUtils.isCnameLikeHost(getEndpoint().getHost())))) ? null : ((GenericBucketRequest) t).getBucketName(), t instanceof GenericObjectRequest ? ((GenericObjectRequest) t).getKey() : null));
            internalRequest.setCredentials(t.getRequestCredentials());
            internalRequest.setRequest(t);
            return internalRequest;
        }
        return (InternalRequest) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0076 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x00a0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x005e */
    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v13, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r9v17, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadObjectToFile(BosObject bosObject, File file, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, this, bosObject, file, z) == null) {
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
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
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
                        } catch (Exception e3) {
                            BLog.error("Couldn't close the output stream", e3.getCause());
                        }
                    }
                }
                bufferedOutputStream.close();
                try {
                    bosObject.getObjectContent().close();
                } catch (Exception e4) {
                    BLog.error("Couldn't get object content", e4.getCause());
                }
                if (z) {
                    ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
                    try {
                    } catch (Exception e5) {
                        e = e5;
                        objectMetadata = null;
                    }
                    try {
                    } catch (Exception e6) {
                        e = e6;
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
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bosObject.getObjectContent().close();
                } catch (IOException e8) {
                    BLog.error("Couldn't abort stream", (Throwable) e8);
                }
                throw new BceClientException("Unable to write to disk:" + e.getMessage(), e);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception e9) {
                        BLog.error("Couldn't close the output stream", e9.getCause());
                    }
                }
                try {
                    bosObject.getObjectContent().close();
                } catch (Exception e10) {
                    BLog.error("Couldn't get object content", e10.getCause());
                }
                throw th;
            }
        }
    }

    private int getStreamBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? ((BosClientConfiguration) this.config).getStreamBufferSize() : invokeV.intValue;
    }

    public static void populateRequestMetadata(InternalRequest internalRequest, ObjectMetadata objectMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, internalRequest, objectMetadata) == null) {
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
    }

    private List<byte[]> readAll(InputStream inputStream, ObjectMetadata objectMetadata) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65546, this, inputStream, objectMetadata)) != null) {
            return (List) invokeLL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, internalRequest) == null) {
            internalRequest.addHeader("Content-Length", String.valueOf(0));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private BosResponse uploadObject(PutObjectRequest putObjectRequest, InternalRequest internalRequest) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, putObjectRequest, internalRequest)) == null) {
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
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Throwable th) {
                            th = th;
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
                            fileInputStream2 = fileInputStream;
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
        return (BosResponse) invokeLL.objValue;
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, inputStream)) == null) {
            if (inputStream.markSupported()) {
                return new RestartableResettableInputStream(inputStream);
            }
            return new RestartableNonResettableInputStream(inputStream, getStreamBufferSize());
        }
        return (RestartableInputStream) invokeL.objValue;
    }

    public void abortMultipartUpload(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, file)) == null) ? appendObject(new AppendObjectRequest(str, str2, file)) : (AppendObjectResponse) invokeLLL.objValue;
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, str2, str3, list)) == null) ? completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list)) : (CompleteMultipartUploadResponse) invokeLLLL.objValue;
    }

    public CopyObjectResponse copyObject(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, str, str2, str3, str4)) == null) ? copyObject(new CopyObjectRequest(str, str2, str3, str4)) : (CopyObjectResponse) invokeLLLL.objValue;
    }

    public CreateBucketResponse createBucket(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? createBucket(new CreateBucketRequest(str)) : (CreateBucketResponse) invokeL.objValue;
    }

    public void deleteBucket(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            deleteBucket(new DeleteBucketRequest(str));
        }
    }

    public void deleteObject(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            deleteObject(new DeleteObjectRequest(str, str2));
        }
    }

    public boolean doesBucketExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? doesBucketExist(new DoesBucketExistRequest(str)) : invokeL.booleanValue;
    }

    public URL generatePresignedUrl(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048601, this, str, str2, i2)) == null) ? generatePresignedUrl(str, str2, i2, HttpMethodName.GET) : (URL) invokeLLI.objValue;
    }

    public User getBosAccountOwner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getBosAccountOwner(new GetBosAccountOwnerRequest()) : (User) invokeV.objValue;
    }

    public GetBucketAclResponse getBucketAcl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? getBucketAcl(new GetBucketAclRequest(str)) : (GetBucketAclResponse) invokeL.objValue;
    }

    public GetBucketLocationResponse getBucketLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) ? getBucketLocation(new GetBucketLocationRequest(str)) : (GetBucketLocationResponse) invokeL.objValue;
    }

    public BosObject getObject(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, str, str2)) == null) ? getObject(new GetObjectRequest(str, str2)) : (BosObject) invokeLL.objValue;
    }

    public byte[] getObjectContent(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, str, str2)) == null) ? getObjectContent(new GetObjectRequest(str, str2)) : (byte[]) invokeLL.objValue;
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, str, str2)) == null) ? getObjectMetadata(new GetObjectMetadataRequest(str, str2)) : (ObjectMetadata) invokeLL.objValue;
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, str, str2)) == null) ? initiateMultipartUpload(new InitiateMultipartUploadRequest(str, str2)) : (InitiateMultipartUploadResponse) invokeLL.objValue;
    }

    public ListBucketsResponse listBuckets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? listBuckets(new ListBucketsRequest()) : (ListBucketsResponse) invokeV.objValue;
    }

    public ListMultipartUploadsResponse listMultipartUploads(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) ? listMultipartUploads(new ListMultipartUploadsRequest(str)) : (ListMultipartUploadsResponse) invokeL.objValue;
    }

    public ListObjectsResponse listNextBatchOfObjects(ListObjectsResponse listObjectsResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, listObjectsResponse)) == null) {
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
        return (ListObjectsResponse) invokeL.objValue;
    }

    public ListObjectsResponse listObjects(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) ? listObjects(new ListObjectsRequest(str)) : (ListObjectsResponse) invokeL.objValue;
    }

    public ListPartsResponse listParts(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048628, this, str, str2, str3)) == null) ? listParts(new ListPartsRequest(str, str2, str3)) : (ListPartsResponse) invokeLLL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048631, this, str, str2, file)) == null) ? putObject(new PutObjectRequest(str, str2, file)) : (PutObjectResponse) invokeLLL.objValue;
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, str, cannedAccessControlList) == null) {
            setBucketAcl(new SetBucketAclRequest(str, cannedAccessControlList));
        }
    }

    @Deprecated
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, BosProgressCallback bosProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048642, this, uploadPartRequest, bosProgressCallback)) == null) {
            uploadPartRequest.setProgressCallback(bosProgressCallback);
            return uploadPart(uploadPartRequest);
        }
        return (UploadPartResponse) invokeLL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BosClient(BosClientConfiguration bosClientConfiguration) {
        super(bosClientConfiguration, bos_handlers);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bosClientConfiguration};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BceClientConfiguration) objArr2[0], (HttpResponseHandler[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, abortMultipartUploadRequest) == null) {
            CheckUtils.isNotNull(abortMultipartUploadRequest, "request should not be null.");
            InternalRequest createRequest = createRequest(abortMultipartUploadRequest, HttpMethodName.DELETE);
            createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
            invokeHttpClient(createRequest, BosResponse.class);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, file, objectMetadata)) == null) ? appendObject(new AppendObjectRequest(str, str2, file, objectMetadata)) : (AppendObjectResponse) invokeLLLL.objValue;
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) throws JSONException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048589, this, str, str2, str3, list, objectMetadata)) == null) ? completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list, objectMetadata)) : (CompleteMultipartUploadResponse) invokeLLLLL.objValue;
    }

    public CreateBucketResponse createBucket(CreateBucketRequest createBucketRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, createBucketRequest)) == null) {
            CheckUtils.isNotNull(createBucketRequest, "request should not be null.");
            InternalRequest createRequest = createRequest(createBucketRequest, HttpMethodName.PUT);
            setZeroContentLength(createRequest);
            CreateBucketResponse createBucketResponse = new CreateBucketResponse();
            createBucketResponse.setName(createBucketRequest.getBucketName());
            createBucketResponse.setLocation(((BosResponse) invokeHttpClient(createRequest, BosResponse.class)).getMetadata().getLocation());
            return createBucketResponse;
        }
        return (CreateBucketResponse) invokeL.objValue;
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, deleteBucketRequest) == null) {
            CheckUtils.isNotNull(deleteBucketRequest, "request should not be null.");
            invokeHttpClient(createRequest(deleteBucketRequest, HttpMethodName.DELETE), BosResponse.class);
        }
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, deleteObjectRequest) == null) {
            CheckUtils.isNotNull(deleteObjectRequest, "request should not be null.");
            assertStringNotNullOrEmpty(deleteObjectRequest.getKey(), "object key should not be null or empty");
            invokeHttpClient(createRequest(deleteObjectRequest, HttpMethodName.DELETE), BosResponse.class);
        }
    }

    public boolean doesBucketExist(DoesBucketExistRequest doesBucketExistRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, doesBucketExistRequest)) == null) {
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
        return invokeL.booleanValue;
    }

    public URL generatePresignedUrl(String str, String str2, int i2, HttpMethodName httpMethodName) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048602, this, str, str2, i2, httpMethodName)) == null) {
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethodName);
            generatePresignedUrlRequest.setExpiration(i2);
            return generatePresignedUrl(generatePresignedUrlRequest);
        }
        return (URL) invokeLLIL.objValue;
    }

    public User getBosAccountOwner(GetBosAccountOwnerRequest getBosAccountOwnerRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, getBosAccountOwnerRequest)) == null) {
            CheckUtils.isNotNull(getBosAccountOwnerRequest, "request should not be null.");
            return ((ListBucketsResponse) invokeHttpClient(createRequest(getBosAccountOwnerRequest, HttpMethodName.GET), ListBucketsResponse.class)).getOwner();
        }
        return (User) invokeL.objValue;
    }

    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, getBucketAclRequest)) == null) {
            CheckUtils.isNotNull(getBucketAclRequest, "request should not be null.");
            InternalRequest createRequest = createRequest(getBucketAclRequest, HttpMethodName.GET);
            createRequest.addParameter("acl", null);
            GetBucketAclResponse getBucketAclResponse = (GetBucketAclResponse) invokeHttpClient(createRequest, GetBucketAclResponse.class);
            if (getBucketAclResponse.getVersion() <= 1) {
                return getBucketAclResponse;
            }
            throw new BceClientException("Unsupported acl version.");
        }
        return (GetBucketAclResponse) invokeL.objValue;
    }

    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, getBucketLocationRequest)) == null) {
            CheckUtils.isNotNull(getBucketLocationRequest, "request should not be null.");
            InternalRequest createRequest = createRequest(getBucketLocationRequest, HttpMethodName.GET);
            createRequest.addParameter("location", null);
            return (GetBucketLocationResponse) invokeHttpClient(createRequest, GetBucketLocationResponse.class);
        }
        return (GetBucketLocationResponse) invokeL.objValue;
    }

    public ObjectMetadata getObject(String str, String str2, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, str, str2, file)) == null) ? getObject(new GetObjectRequest(str, str2), file) : (ObjectMetadata) invokeLLL.objValue;
    }

    public byte[] getObjectContent(GetObjectRequest getObjectRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, getObjectRequest)) == null) {
            BosObjectInputStream objectContent = getObject(getObjectRequest).getObjectContent();
            try {
                try {
                    byte[] inputStreamToByte = ConvertUtils.inputStreamToByte(objectContent);
                    try {
                        objectContent.close();
                    } catch (IOException unused) {
                    }
                    return inputStreamToByte;
                } catch (IOException e2) {
                    try {
                        objectContent.close();
                    } catch (IOException unused2) {
                    }
                    throw new BceClientException("Fail read object content:" + e2.getMessage(), e2);
                }
            } catch (Throwable th) {
                try {
                    objectContent.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, getObjectMetadataRequest)) == null) {
            CheckUtils.isNotNull(getObjectMetadataRequest, "request should not be null.");
            return ((GetObjectResponse) invokeHttpClient(createRequest(getObjectMetadataRequest, HttpMethodName.HEAD), GetObjectResponse.class)).getObject().getObjectMetadata();
        }
        return (ObjectMetadata) invokeL.objValue;
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, initiateMultipartUploadRequest)) == null) {
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
        return (InitiateMultipartUploadResponse) invokeL.objValue;
    }

    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, listBucketsRequest)) == null) {
            CheckUtils.isNotNull(listBucketsRequest, "request should not be null.");
            return (ListBucketsResponse) invokeHttpClient(createRequest(listBucketsRequest, HttpMethodName.GET), ListBucketsResponse.class);
        }
        return (ListBucketsResponse) invokeL.objValue;
    }

    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, listMultipartUploadsRequest)) == null) {
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
        return (ListMultipartUploadsResponse) invokeL.objValue;
    }

    public ListObjectsResponse listObjects(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048626, this, str, str2)) == null) ? listObjects(new ListObjectsRequest(str, str2)) : (ListObjectsResponse) invokeLL.objValue;
    }

    public ListPartsResponse listParts(ListPartsRequest listPartsRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, listPartsRequest)) == null) {
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
        return (ListPartsResponse) invokeL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048632, this, str, str2, file, objectMetadata)) == null) ? putObject(new PutObjectRequest(str, str2, file, objectMetadata)) : (PutObjectResponse) invokeLLLL.objValue;
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, setBucketAclRequest) == null) {
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
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, str2, str3)) == null) {
            try {
                return appendObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Fail to get bytes.", e2);
            }
        }
        return (AppendObjectResponse) invokeLLL.objValue;
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, completeMultipartUploadRequest)) == null) {
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
        return (CompleteMultipartUploadResponse) invokeL.objValue;
    }

    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, copyObjectRequest)) == null) {
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
                createRequest.addHeader(Headers.BCE_COPY_METADATA_DIRECTIVE, StickerDataChangeType.REPLACE);
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
        return (CopyObjectResponse) invokeL.objValue;
    }

    public BosObject getObject(GetObjectRequest getObjectRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, getObjectRequest)) == null) {
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
        return (BosObject) invokeL.objValue;
    }

    public ListObjectsResponse listObjects(ListObjectsRequest listObjectsRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, listObjectsRequest)) == null) {
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
        return (ListObjectsResponse) invokeL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048635, this, str, str2, str3)) == null) {
            try {
                return putObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Fail to get bytes:" + e2.getMessage(), e2);
            }
        }
        return (PutObjectResponse) invokeLLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidubce.util.MD5DigestCalculatingInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, uploadPartRequest)) == null) {
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
        return (UploadPartResponse) invokeL.objValue;
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream, Long l) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, inputStream, l)) == null) {
            if (inputStream.markSupported()) {
                return new RestartableResettableInputStream(inputStream);
            }
            return new RestartableNonResettableInputStream(inputStream, l.longValue() > ((long) getStreamBufferSize()) ? getStreamBufferSize() : l.intValue());
        }
        return (RestartableInputStream) invokeLL.objValue;
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, objectMetadata)) == null) {
            try {
                return appendObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Fail to get bytes.", e2);
            }
        }
        return (AppendObjectResponse) invokeLLLL.objValue;
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, generatePresignedUrlRequest)) == null) {
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
        return (URL) invokeL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048636, this, str, str2, str3, objectMetadata)) == null) {
            try {
                return putObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Fail to get bytes:" + e2.getMessage(), e2);
            }
        }
        return (PutObjectResponse) invokeLLLL.objValue;
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, bArr)) == null) ? appendObject(str, str2, bArr, new ObjectMetadata()) : (AppendObjectResponse) invokeLLL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048637, this, str, str2, bArr)) == null) ? putObject(str, str2, bArr, new ObjectMetadata()) : (PutObjectResponse) invokeLLL.objValue;
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, str, str2, bArr, objectMetadata)) == null) {
            CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
            if (objectMetadata.getContentLength() == -1) {
                objectMetadata.setContentLength(bArr.length);
            }
            return appendObject(new AppendObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
        }
        return (AppendObjectResponse) invokeLLLL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048638, this, str, str2, bArr, objectMetadata)) == null) {
            if (objectMetadata.getContentLength() == -1) {
                objectMetadata.setContentLength(bArr.length);
            }
            return putObject(new PutObjectRequest(str, str2, RestartableInputStream.wrap(bArr), objectMetadata));
        }
        return (PutObjectResponse) invokeLLLL.objValue;
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, getObjectRequest, file)) == null) {
            CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
            CheckUtils.isNotNull(file, "destinationFile should not be null.");
            BosObject object = getObject(getObjectRequest);
            downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
            return object.getObjectMetadata();
        }
        return (ObjectMetadata) invokeLL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048633, this, str, str2, inputStream)) == null) ? putObject(new PutObjectRequest(str, str2, inputStream)) : (PutObjectResponse) invokeLLL.objValue;
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048634, this, str, str2, inputStream, objectMetadata)) == null) ? putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata)) : (PutObjectResponse) invokeLLLL.objValue;
    }

    public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, putObjectRequest)) == null) {
            CheckUtils.isNotNull(putObjectRequest, "request should not be null.");
            assertStringNotNullOrEmpty(putObjectRequest.getKey(), "object key should not be null or empty");
            BosResponse uploadObject = uploadObject(putObjectRequest, createRequest(putObjectRequest, HttpMethodName.PUT));
            PutObjectResponse putObjectResponse = new PutObjectResponse();
            putObjectResponse.setETag(uploadObject.getMetadata().getETag());
            putObjectResponse.setCrc32(uploadObject.getMetadata().getCrc32());
            return putObjectResponse;
        }
        return (PutObjectResponse) invokeL.objValue;
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, inputStream)) == null) ? appendObject(new AppendObjectRequest(str, str2, inputStream)) : (AppendObjectResponse) invokeLLL.objValue;
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, str, str2, inputStream, objectMetadata)) == null) ? appendObject(new AppendObjectRequest(str, str2, inputStream, objectMetadata)) : (AppendObjectResponse) invokeLLLL.objValue;
    }

    public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, appendObjectRequest)) == null) {
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
        return (AppendObjectResponse) invokeL.objValue;
    }

    @Deprecated
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, BosProgressCallback bosProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048630, this, putObjectRequest, bosProgressCallback)) == null) {
            putObjectRequest.setProgressCallback(bosProgressCallback);
            return putObject(putObjectRequest);
        }
        return (PutObjectResponse) invokeLL.objValue;
    }
}
