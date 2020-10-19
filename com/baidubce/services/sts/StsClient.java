package com.baidubce.services.sts;

import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientConfiguration;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.services.sts.model.GetSessionTokenRequest;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
/* loaded from: classes25.dex */
public class StsClient extends AbstractBceClient {
    private static final String GET_SESSION_TOKEN_PATH = "sessionToken";
    private static HttpResponseHandler[] stsHandlers = {new BceMetadataResponseHandler(), new BceErrorResponseHandler(), new BceStsJsonResponseHandler()};

    public StsClient() {
        this(new BceClientConfiguration());
    }

    public StsClient(BceClientConfiguration bceClientConfiguration) {
        super(bceClientConfiguration, stsHandlers);
    }

    public GetSessionTokenResponse getSessionToken() {
        return getSessionToken(new GetSessionTokenRequest());
    }

    public GetSessionTokenResponse getSessionToken(GetSessionTokenRequest getSessionTokenRequest) {
        CheckUtils.isNotNull(getSessionTokenRequest, "The parameter request should NOT be null.");
        CheckUtils.checkArgument(getSessionTokenRequest.getDurationSeconds().intValue() > 0, "the durationSeconds parameter should be greater than zero");
        InternalRequest internalRequest = new InternalRequest(HttpMethodName.POST, HttpUtils.appendUri(getEndpoint(), AbstractBceClient.URL_PREFIX, GET_SESSION_TOKEN_PATH));
        if (getSessionTokenRequest.getDurationSeconds() != null) {
            internalRequest.addParameter("durationSeconds", String.valueOf(getSessionTokenRequest.getDurationSeconds()));
        }
        internalRequest.setCredentials(getSessionTokenRequest.getRequestCredentials());
        internalRequest.addHeader("Content-Length", String.valueOf(getSessionTokenRequest.getAcl() != null ? getSessionTokenRequest.getAcl().length() : 0));
        internalRequest.addHeader("Content-Type", HttpHelper.CONTENT_JSON);
        if (getSessionTokenRequest.getAcl() != null) {
            internalRequest.setContent(RestartableInputStream.wrap(getSessionTokenRequest.getAcl().getBytes()));
        }
        return (GetSessionTokenResponse) invokeHttpClient(internalRequest, GetSessionTokenResponse.class);
    }
}
