package com.baidu.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SDKInitBeanCallBack implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static int f50485b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-435213231, "Lcom/baidu/wallet/paysdk/SDKInitBeanCallBack;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-435213231, "Lcom/baidu/wallet/paysdk/SDKInitBeanCallBack;");
        }
    }

    public SDKInitBeanCallBack(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static Map<String, Set<String>> a(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray(str);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONArray jSONArray2 = jSONObject.getJSONArray("pin-sha256");
                JSONArray jSONArray3 = jSONObject.getJSONArray("domains");
                hashSet.clear();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    hashSet.add(jSONArray2.getString(i3));
                }
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    hashMap.put(jSONArray3.getString(i4), hashSet);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean checkIsJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) && (obj instanceof SdkInitResponse)) {
            SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
            SdkInitBean.setContentSignForReq(sdkInitResponse.sign);
            if (DebugConfig.getInstance().isOnline()) {
                if (checkIsJson(sdkInitResponse.domainConfig)) {
                    DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                }
                if (checkIsJson(sdkInitResponse.appDomainConfig)) {
                    com.baidu.apollon.heartbeat.a.c().a(sdkInitResponse.appDomainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, sdkInitResponse.appDomainConfig);
                }
            } else {
                if (checkIsJson(sdkInitResponse.domainConfig)) {
                    DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", sdkInitResponse.domainConfig);
                }
                if (checkIsJson(sdkInitResponse.appDomainConfig)) {
                    com.baidu.apollon.heartbeat.a.c().a(sdkInitResponse.appDomainConfig);
                    SharedPreferencesUtils.setParam(DxmApplicationContextImpl.getApplicationContext(this.a), BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, sdkInitResponse.appDomainConfig);
                }
            }
            if (TextUtils.isEmpty(sdkInitResponse.publicKeyPins)) {
                return;
            }
            try {
                Map<String, Set<String>> a = a(sdkInitResponse.publicKeyPins);
                com.baidu.apollon.b.a.a().b();
                for (String str2 : a.keySet()) {
                    com.baidu.apollon.b.a.a().a(str2, a.get(str2));
                }
            } catch (JSONException unused) {
            }
        }
    }
}
