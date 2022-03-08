package com.baidubce;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.http.BceHttpClient;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.DateUtils;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes6.dex */
public abstract class AbstractBceClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String DEFAULT_SERVICE_DOMAIN = "baidubce.com";
    public static final String URL_PREFIX = "v1";
    public transient /* synthetic */ FieldHolder $fh;
    public BceHttpClient client;
    public BceClientConfiguration config;
    public URI endpoint;
    public HttpResponseHandler[] responseHandlers;
    public String serviceId;

    public AbstractBceClient(BceClientConfiguration bceClientConfiguration, HttpResponseHandler[] httpResponseHandlerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration, httpResponseHandlerArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.serviceId = computeServiceId();
        this.config = bceClientConfiguration;
        this.endpoint = computeEndpoint();
        this.client = new BceHttpClient(bceClientConfiguration, new BceV1Signer());
        this.responseHandlers = httpResponseHandlerArr;
    }

    private URI computeEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String endpoint = this.config.getEndpoint();
            if (endpoint == null) {
                try {
                    endpoint = isRegionSupported() ? String.format("%s://%s.%s.%s", this.config.getProtocol(), this.serviceId, this.config.getRegion(), DEFAULT_SERVICE_DOMAIN) : String.format("%s://%s.%s", this.config.getProtocol(), this.serviceId, DEFAULT_SERVICE_DOMAIN);
                } catch (URISyntaxException e2) {
                    throw new IllegalArgumentException("Invalid endpoint." + endpoint, e2);
                }
            }
            return new URI(endpoint);
        }
        return (URI) invokeV.objValue;
    }

    private String computeServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String name = getClass().getPackage().getName();
            String str = AbstractBceClient.class.getPackage().getName() + ".services.";
            if (name.startsWith(str)) {
                String substring = name.substring(str.length());
                if (substring.indexOf(46) == -1) {
                    String name2 = getClass().getName();
                    String str2 = name + '.' + Character.toUpperCase(substring.charAt(0)) + substring.substring(1) + "Client";
                    if (name2.equals(str2)) {
                        return substring;
                    }
                    throw new IllegalStateException("Invalid class name " + name2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + " expected");
                }
                throw new IllegalStateException("The client class should be put in package like " + str + "XXX");
            }
            throw new IllegalStateException("Unrecognized prefix for the client package : " + name + ", '" + str + "' expected");
        }
        return (String) invokeV.objValue;
    }

    public BceHttpClient getClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.client : (BceHttpClient) invokeV.objValue;
    }

    public URI getEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endpoint : (URI) invokeV.objValue;
    }

    public String getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.serviceId : (String) invokeV.objValue;
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, internalRequest, cls)) == null) ? (T) invokeHttpClient(internalRequest, cls, null) : (T) invokeLL.objValue;
    }

    public boolean isRegionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setClient(BceHttpClient bceHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bceHttpClient) == null) {
            this.client = bceHttpClient;
        }
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls, BceProgressCallback<M> bceProgressCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, internalRequest, cls, bceProgressCallback)) == null) {
            if (!internalRequest.getHeaders().containsKey("Content-Type")) {
                internalRequest.addHeader("Content-Type", DEFAULT_CONTENT_TYPE);
            }
            if (!internalRequest.getHeaders().containsKey("Date")) {
                internalRequest.addHeader("Date", DateUtils.rfc822DateFormat());
            }
            return (T) this.client.execute(internalRequest, cls, this.responseHandlers, bceProgressCallback);
        }
        return (T) invokeLLL.objValue;
    }
}
