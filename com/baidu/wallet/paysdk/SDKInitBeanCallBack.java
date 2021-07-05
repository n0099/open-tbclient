package com.baidu.wallet.paysdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PollOfflineCacheSwitch;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SDKInitBeanCallBack implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f25733a = true;

    /* renamed from: c  reason: collision with root package name */
    public static int f25734c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f25735b;

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
        this.f25735b = context;
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

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) || f25733a) {
            return;
        }
        int i4 = f25734c + 1;
        f25734c = i4;
        if (i4 >= 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", "1");
            Tracker.send("OfflineFailOverOccur", hashMap, this.f25735b);
            LogUtil.d("WebViewCacheManager", "pollinit-连续三次失败关闭离线缓存");
            PollOfflineCacheSwitch.getInstance().updateCacheConfig(null);
            SdkInitResponse.getInstance().updateOfflineCacheConfig(this.f25735b, null);
            LogUtil.d("WebViewCacheManager", "pollinit-连续三次失败关闭多webview");
            LocalRouter.getInstance(this.f25735b).route(this.f25735b, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_updateSettings").data("config", null), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.SDKInitBeanCallBack.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SDKInitBeanCallBack f25736a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25736a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i5, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, hashMap2) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            if (!f25733a) {
                f25734c = 0;
                return;
            }
            f25733a = false;
            if (obj instanceof SdkInitResponse) {
                SdkInitResponse sdkInitResponse = (SdkInitResponse) obj;
                if (!TextUtils.isEmpty(sdkInitResponse.domainConfig)) {
                    try {
                        new JSONObject(sdkInitResponse.domainConfig);
                        z = true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        z = false;
                    }
                    if (z) {
                        if (DebugConfig.getInstance().isOnline()) {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY, sdkInitResponse.domainConfig);
                        } else {
                            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, sdkInitResponse.domainConfig);
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY, sdkInitResponse.domainConfig);
                        }
                    }
                }
                if (!TextUtils.isEmpty(sdkInitResponse.domainSwitch)) {
                    if (TextUtils.equals("1", sdkInitResponse.domainSwitch)) {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.TRUE);
                        }
                        com.baidu.apollon.heartbeat.a.c().a(true);
                    } else {
                        if (DebugConfig.getInstance().isOnline()) {
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        } else {
                            SharedPreferencesUtils.setParam(this.f25735b.getApplicationContext(), BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE);
                        }
                        com.baidu.apollon.heartbeat.a.c().a(false);
                    }
                }
                if (TextUtils.isEmpty(sdkInitResponse.publicKeyPins)) {
                    return;
                }
                try {
                    Map<String, Set<String>> a2 = a(sdkInitResponse.publicKeyPins);
                    com.baidu.apollon.b.a.a().b();
                    for (String str2 : a2.keySet()) {
                        com.baidu.apollon.b.a.a().a(str2, a2.get(str2));
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}
