package com.baidubce.services.vod;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientConfiguration;
import com.baidubce.BceClientException;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.services.vod.model.GenerateMediaIdRequest;
import com.baidubce.services.vod.model.GenerateMediaIdResponse;
import com.baidubce.services.vod.model.GetMediaResourceRequest;
import com.baidubce.services.vod.model.GetMediaResourceResponse;
import com.baidubce.services.vod.model.ProcessMediaRequest;
import com.baidubce.services.vod.model.ProcessMediaResponse;
import com.baidubce.services.vod.model.VodBceRequest;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class VodClient extends AbstractBceClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SOURCE_EXTENSION_LENGTH = 10;
    public static final String PARA_APPLY = "apply";
    public static final String PARA_MODE = "mode";
    public static final String PARA_PROCESS = "process";
    public static final String PATH_MEDIA = "media";
    public static final String VALID_EXTENSION_PATTERN = "[0-9a-zA-Z]{0,10}";
    public static final String VERSION = "v1";
    public static final HttpResponseHandler[] responseHandlers;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1344872846, "Lcom/baidubce/services/vod/VodClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1344872846, "Lcom/baidubce/services/vod/VodClient;");
                return;
            }
        }
        responseHandlers = new HttpResponseHandler[]{new BceMetadataResponseHandler(), new BceErrorResponseHandler(), new VodJsonResponseHandler()};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodClient(BceClientConfiguration bceClientConfiguration) {
        super(bceClientConfiguration, responseHandlers);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BceClientConfiguration) objArr2[0], (HttpResponseHandler[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private InternalRequest createRequest(HttpMethodName httpMethodName, VodBceRequest vodBceRequest, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, httpMethodName, vodBceRequest, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("v1");
            if (strArr != null) {
                for (String str : strArr) {
                    arrayList.add(str);
                }
            }
            InternalRequest internalRequest = new InternalRequest(httpMethodName, HttpUtils.appendUri(getEndpoint(), (String[]) arrayList.toArray(new String[arrayList.size()])));
            internalRequest.setCredentials(vodBceRequest.getRequestCredentials());
            if (httpMethodName == HttpMethodName.POST || httpMethodName == HttpMethodName.PUT) {
                fillRequestPayload(internalRequest, vodBceRequest);
            }
            return internalRequest;
        }
        return (InternalRequest) invokeLLL.objValue;
    }

    private InternalRequest fillRequestPayload(InternalRequest internalRequest, VodBceRequest vodBceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, internalRequest, vodBceRequest)) == null) {
            try {
                byte[] bytes = vodBceRequest.toJsonString().getBytes("UTF-8");
                internalRequest.addHeader("Content-Length", String.valueOf(bytes.length));
                internalRequest.addHeader("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
                internalRequest.setContent(RestartableInputStream.wrap(bytes));
                return internalRequest;
            } catch (UnsupportedEncodingException e2) {
                throw new BceClientException("Unsupported encode.", e2);
            }
        }
        return (InternalRequest) invokeLL.objValue;
    }

    private String getFileExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (str != null && str.lastIndexOf(".") != -1) {
                String substring = str.substring(str.lastIndexOf(".") + 1);
                if (substring.length() <= 0 || substring.length() > 10 || !substring.matches(VALID_EXTENSION_PATTERN)) {
                    return null;
                }
                return substring;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public GenerateMediaIdResponse applyMedia() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            InternalRequest createRequest = createRequest(HttpMethodName.POST, new GenerateMediaIdRequest(), PATH_MEDIA);
            createRequest.addParameter("apply", null);
            return (GenerateMediaIdResponse) invokeHttpClient(createRequest, GenerateMediaIdResponse.class);
        }
        return (GenerateMediaIdResponse) invokeV.objValue;
    }

    public GenerateMediaIdResponse applyMediaForSpecificMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            InternalRequest createRequest = createRequest(HttpMethodName.POST, new GenerateMediaIdRequest(), PATH_MEDIA);
            createRequest.addParameter("apply", null);
            createRequest.addParameter("mode", str);
            return (GenerateMediaIdResponse) invokeHttpClient(createRequest, GenerateMediaIdResponse.class);
        }
        return (GenerateMediaIdResponse) invokeL.objValue;
    }

    public GetMediaResourceResponse getMediaResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? getMediaResource(new GetMediaResourceRequest().withMediaId(str)) : (GetMediaResourceResponse) invokeL.objValue;
    }

    @Override // com.baidubce.AbstractBceClient
    public boolean isRegionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public ProcessMediaResponse processMedia(ProcessMediaRequest processMediaRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, processMediaRequest)) == null) {
            InternalRequest createRequest = createRequest(HttpMethodName.POST, processMediaRequest, PATH_MEDIA, processMediaRequest.getMediaId());
            createRequest.addParameter("process", null);
            return (ProcessMediaResponse) invokeHttpClient(createRequest, ProcessMediaResponse.class);
        }
        return (ProcessMediaResponse) invokeL.objValue;
    }

    public GetMediaResourceResponse getMediaResource(GetMediaResourceRequest getMediaResourceRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getMediaResourceRequest)) == null) {
            CheckUtils.checkArgument((getMediaResourceRequest.getMediaId() == null || getMediaResourceRequest.getMediaId().equals("")) ? false : true, "Media ID should not be null or empty!");
            return (GetMediaResourceResponse) invokeHttpClient(createRequest(HttpMethodName.GET, getMediaResourceRequest, PATH_MEDIA, getMediaResourceRequest.getMediaId()), GetMediaResourceResponse.class);
        }
        return (GetMediaResourceResponse) invokeL.objValue;
    }
}
