package com.baidubce.services.vod;

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
/* loaded from: classes24.dex */
public class VodClient extends AbstractBceClient {
    private static final int MAX_SOURCE_EXTENSION_LENGTH = 10;
    private static final String PARA_APPLY = "apply";
    private static final String PARA_MODE = "mode";
    private static final String PARA_PROCESS = "process";
    private static final String PATH_MEDIA = "media";
    private static final String VALID_EXTENSION_PATTERN = "[0-9a-zA-Z]{0,10}";
    private static final String VERSION = "v1";
    private static final HttpResponseHandler[] responseHandlers = {new BceMetadataResponseHandler(), new BceErrorResponseHandler(), new VodJsonResponseHandler()};

    public VodClient(BceClientConfiguration bceClientConfiguration) {
        super(bceClientConfiguration, responseHandlers);
    }

    public ProcessMediaResponse processMedia(ProcessMediaRequest processMediaRequest) {
        InternalRequest createRequest = createRequest(HttpMethodName.POST, processMediaRequest, PATH_MEDIA, processMediaRequest.getMediaId());
        createRequest.addParameter(PARA_PROCESS, null);
        return (ProcessMediaResponse) invokeHttpClient(createRequest, ProcessMediaResponse.class);
    }

    public GenerateMediaIdResponse applyMedia() {
        InternalRequest createRequest = createRequest(HttpMethodName.POST, new GenerateMediaIdRequest(), PATH_MEDIA);
        createRequest.addParameter("apply", null);
        return (GenerateMediaIdResponse) invokeHttpClient(createRequest, GenerateMediaIdResponse.class);
    }

    public GenerateMediaIdResponse applyMediaForSpecificMode(String str) {
        InternalRequest createRequest = createRequest(HttpMethodName.POST, new GenerateMediaIdRequest(), PATH_MEDIA);
        createRequest.addParameter("apply", null);
        createRequest.addParameter(PARA_MODE, str);
        return (GenerateMediaIdResponse) invokeHttpClient(createRequest, GenerateMediaIdResponse.class);
    }

    public GetMediaResourceResponse getMediaResource(String str) {
        return getMediaResource(new GetMediaResourceRequest().withMediaId(str));
    }

    public GetMediaResourceResponse getMediaResource(GetMediaResourceRequest getMediaResourceRequest) {
        CheckUtils.checkArgument((getMediaResourceRequest.getMediaId() == null || getMediaResourceRequest.getMediaId().equals("")) ? false : true, "Media ID should not be null or empty!");
        return (GetMediaResourceResponse) invokeHttpClient(createRequest(HttpMethodName.GET, getMediaResourceRequest, PATH_MEDIA, getMediaResourceRequest.getMediaId()), GetMediaResourceResponse.class);
    }

    private InternalRequest createRequest(HttpMethodName httpMethodName, VodBceRequest vodBceRequest, String... strArr) {
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

    private InternalRequest fillRequestPayload(InternalRequest internalRequest, VodBceRequest vodBceRequest) {
        try {
            byte[] bytes = vodBceRequest.toJsonString().getBytes("UTF-8");
            internalRequest.addHeader("Content-Length", String.valueOf(bytes.length));
            internalRequest.addHeader("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
            internalRequest.setContent(RestartableInputStream.wrap(bytes));
            return internalRequest;
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Unsupported encode.", e);
        }
    }

    private String getFileExtension(String str) {
        if (str == null || str.lastIndexOf(".") == -1) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf(".") + 1);
        if (substring.length() <= 0 || substring.length() > 10 || !substring.matches(VALID_EXTENSION_PATTERN)) {
            return null;
        }
        return substring;
    }

    @Override // com.baidubce.AbstractBceClient
    public boolean isRegionSupported() {
        return false;
    }
}
