package com.baidu.wallet.lightapp.business.offlinecache;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class LangbridgeCacheManager implements NoProguard, IOfflineCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String OFFLINE_FAIL_OVER_OCCUR;

    /* renamed from: a  reason: collision with root package name */
    public final int f61833a;

    /* renamed from: b  reason: collision with root package name */
    public IOfflineCache f61834b;

    /* renamed from: c  reason: collision with root package name */
    public String f61835c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61836d;

    /* renamed from: e  reason: collision with root package name */
    public String f61837e;

    /* renamed from: f  reason: collision with root package name */
    public long f61838f;

    /* renamed from: g  reason: collision with root package name */
    public int f61839g;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgeCacheManager f61840a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1312542655, "Lcom/baidu/wallet/lightapp/business/offlinecache/LangbridgeCacheManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1312542655, "Lcom/baidu/wallet/lightapp/business/offlinecache/LangbridgeCacheManager$a;");
                    return;
                }
            }
            f61840a = new LangbridgeCacheManager();
        }
    }

    public LangbridgeCacheManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.OFFLINE_FAIL_OVER_OCCUR = "OfflineFailOverOccur";
        this.f61833a = 5000;
        this.f61836d = true;
        this.f61837e = "";
        this.f61838f = 0L;
        this.f61839g = 5000;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                this.f61839g = new JSONObject(str).optInt("refreshInterval", 5000);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static LangbridgeCacheManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f61840a : (LangbridgeCacheManager) invokeV.objValue;
    }

    public void forceLangbridgeCacheOnly(Context context, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bool) == null) {
            LangbridgePreloadCellCenter.getInstance(context).setAllCellsEnable(!bool.booleanValue());
        }
    }

    public String getLangbridgeUA(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            String str = this.f61835c;
            if (TextUtils.isEmpty(str)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
                    if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                        userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
                    }
                    this.f61835c = userAgentString;
                    return userAgentString;
                }
                return BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String getOfflineCacheConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? SdkInitResponse.getInstance().getOfflineCacheConfig(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public JSONObject getOfflineCacheInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (a()) {
                return this.f61834b.getOfflineCacheInfo(str);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject getSummaryOfflineCacheInfo(String str) {
        InterceptResult invokeL;
        JSONObject offlineCacheInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f61834b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f61834b.getOfflineCacheInfo(str)) != null) {
                try {
                    jSONObject.put("package_name", offlineCacheInfo.optString("name"));
                    jSONObject.put("package_version", offlineCacheInfo.optString("decryVersion"));
                } catch (JSONException e2) {
                    LogUtil.e("WebViewCacheManager", "JSONException on getSummaryOfflineCacheInfo", e2);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleCreateLangbirdge(String str, WebView webView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, webView) == null) && a()) {
            this.f61834b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && a()) {
            this.f61834b.handleFinishLangbirdge(j2);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && a()) {
            this.f61834b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, str) == null) && a()) {
            this.f61834b.handleLoadUrl(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j2, str) == null) && a()) {
            this.f61834b.handleStartLangbirdge(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && a()) {
            this.f61834b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, map)) == null) {
            if (a()) {
                return this.f61834b.interceptRequest(str, map);
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean isOfflineCacheReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (a()) {
                return this.f61834b.isOfflineCacheReady(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (iOfflineCache = this.f61834b) == null) {
            return;
        }
        iOfflineCache.offlineConfigUpdate(str);
        a(str);
    }

    public void onLangbridgeRefresh(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) && a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f61837e.equals(str) && currentTimeMillis - this.f61838f < this.f61839g) {
                this.f61836d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f61837e = str;
            this.f61838f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && TextUtils.isEmpty(this.f61835c)) {
            this.f61835c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iOfflineCache) == null) {
            this.f61834b = iOfflineCache;
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (a()) {
                return this.f61834b.showProgressLine(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f61834b != null && this.f61836d : invokeV.booleanValue;
    }
}
