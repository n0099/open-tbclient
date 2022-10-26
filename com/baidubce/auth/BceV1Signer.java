package com.baidubce.auth;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceConfig;
import com.baidubce.http.Headers;
import com.baidubce.internal.InternalRequest;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.DateUtils;
import com.baidubce.util.HashUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JoinerUtils;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import okhttp3.internal.http.HttpMethod;
/* loaded from: classes7.dex */
public class BceV1Signer implements Signer {
    public static /* synthetic */ Interceptable $ic;
    public static final Set defaultHeadersToSign;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(499707117, "Lcom/baidubce/auth/BceV1Signer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(499707117, "Lcom/baidubce/auth/BceV1Signer;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        defaultHeadersToSign = hashSet;
        hashSet.add("Host".toLowerCase());
        defaultHeadersToSign.add("Content-Length".toLowerCase());
        defaultHeadersToSign.add("Content-Type".toLowerCase());
        defaultHeadersToSign.add(Headers.CONTENT_MD5.toLowerCase());
    }

    public BceV1Signer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private String getCanonicalHeaders(SortedMap sortedMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, sortedMap)) == null) {
            if (sortedMap.isEmpty()) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : sortedMap.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    String str2 = (String) entry.getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    arrayList.add(HttpUtils.normalize(str.trim().toLowerCase()) + ':' + HttpUtils.normalize(str2.trim()));
                }
            }
            Collections.sort(arrayList);
            return JoinerUtils.on("\n", arrayList);
        }
        return (String) invokeL.objValue;
    }

    private String getCanonicalURIPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str == null) {
                return "/";
            }
            if (str.startsWith("/")) {
                return HttpUtils.normalizePath(str);
            }
            return "/" + HttpUtils.normalizePath(str);
        }
        return (String) invokeL.objValue;
    }

    private SortedMap getHeadersToSign(Map map, Set set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, set)) == null) {
            TreeMap treeMap = new TreeMap();
            if (set != null) {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    hashSet.add(((String) it.next()).trim().toLowerCase());
                }
                set = hashSet;
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (entry.getValue() != null && !((String) entry.getValue()).isEmpty() && ((set == null && isDefaultHeaderToSign(str)) || (set != null && set.contains(str.toLowerCase()) && !"Authorization".equalsIgnoreCase(str)))) {
                    treeMap.put(str, entry.getValue());
                }
            }
            return treeMap;
        }
        return (SortedMap) invokeLL.objValue;
    }

    private boolean isDefaultHeaderToSign(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            String lowerCase = str.trim().toLowerCase();
            if (!lowerCase.startsWith(Headers.BCE_PREFIX) && !defaultHeadersToSign.contains(lowerCase)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidubce.auth.Signer
    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, internalRequest, bceCredentials) == null) {
            sign(internalRequest, bceCredentials, null);
        }
    }

    @Override // com.baidubce.auth.Signer
    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials, SignOptions signOptions) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, internalRequest, bceCredentials, signOptions) == null) {
            CheckUtils.isNotNull(internalRequest, "request should not be null.");
            if (bceCredentials == null) {
                return;
            }
            if (signOptions == null) {
                if (internalRequest.getSignOptions() != null) {
                    signOptions = internalRequest.getSignOptions();
                } else {
                    signOptions = SignOptions.DEFAULT;
                }
            }
            String accessKeyId = bceCredentials.getAccessKeyId();
            String secretKey = bceCredentials.getSecretKey();
            internalRequest.addHeader("Host", HttpUtils.generateHostHeader(internalRequest.getUri()));
            String name = internalRequest.getHttpMethod().name();
            if (!HttpMethod.requiresRequestBody(name) && !HttpMethod.permitsRequestBody(name)) {
                z = false;
            } else {
                z = true;
            }
            if (internalRequest.getHeaders().get("Content-Length") == null && internalRequest.getContent() == null && z) {
                internalRequest.addHeader("Content-Length", "0");
            }
            if (bceCredentials instanceof BceSessionCredentials) {
                internalRequest.addHeader(Headers.BCE_SECURITY_TOKEN, ((BceSessionCredentials) bceCredentials).getSessionToken());
            }
            Date timestamp = signOptions.getTimestamp();
            if (timestamp == null) {
                timestamp = new Date();
            }
            String on = JoinerUtils.on("/", BceConfig.BCE_AUTH_VERSION, accessKeyId, DateUtils.alternateIso8601DateFormat(timestamp), Integer.valueOf(signOptions.getExpirationInSeconds()));
            String sha256Hex = HashUtils.sha256Hex(secretKey, on);
            String canonicalURIPath = getCanonicalURIPath(internalRequest.getUri().getPath());
            String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), true);
            SortedMap headersToSign = getHeadersToSign(internalRequest.getHeaders(), signOptions.getHeadersToSign());
            String canonicalHeaders = getCanonicalHeaders(headersToSign);
            if (signOptions.getHeadersToSign() != null) {
                str = JoinerUtils.on(ParamableElem.DIVIDE_PARAM, headersToSign.keySet()).trim().toLowerCase();
            } else {
                str = "";
            }
            String on2 = JoinerUtils.on("\n", internalRequest.getHttpMethod(), canonicalURIPath, canonicalQueryString, canonicalHeaders);
            String on3 = JoinerUtils.on("/", on, str, HashUtils.sha256Hex(sha256Hex, on2));
            BLog.debug("CanonicalRequest:{}\tAuthorization:{}", on2.replace("\n", "[\\n]"), on3);
            internalRequest.addHeader("Authorization", on3);
        }
    }
}
