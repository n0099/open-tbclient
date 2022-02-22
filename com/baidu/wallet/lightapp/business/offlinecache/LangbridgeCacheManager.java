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
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LangbridgeCacheManager implements NoProguard, IOfflineCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String OFFLINE_FAIL_OVER_OCCUR;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public IOfflineCache f51811b;

    /* renamed from: c  reason: collision with root package name */
    public String f51812c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51813d;

    /* renamed from: e  reason: collision with root package name */
    public String f51814e;

    /* renamed from: f  reason: collision with root package name */
    public long f51815f;

    /* renamed from: g  reason: collision with root package name */
    public int f51816g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static LangbridgeCacheManager a;
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
            a = new LangbridgeCacheManager();
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
        this.a = 5000;
        this.f51813d = true;
        this.f51814e = "";
        this.f51815f = 0L;
        this.f51816g = 5000;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                this.f51816g = new JSONObject(str).optInt("refreshInterval", 5000);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static LangbridgeCacheManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (LangbridgeCacheManager) invokeV.objValue;
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
            String str = this.f51812c;
            if (TextUtils.isEmpty(str)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
                    if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
                        userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
                    }
                    this.f51812c = userAgentString;
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
                return this.f51811b.getOfflineCacheInfo(str);
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
            if (this.f51811b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f51811b.getOfflineCacheInfo(str)) != null) {
                try {
                    jSONObject.put("package_name", offlineCacheInfo.optString("name"));
                    jSONObject.put("package_version", offlineCacheInfo.optString("decryVersion"));
                } catch (JSONException e2) {
                    LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "JSONException on getSummaryOfflineCacheInfo", e2);
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
            this.f51811b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && a()) {
            this.f51811b.handleFinishLangbirdge(j2);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && a()) {
            this.f51811b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, str) == null) && a()) {
            this.f51811b.handleLoadUrl(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j2, str) == null) && a()) {
            this.f51811b.handleStartLangbirdge(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && a()) {
            this.f51811b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, map)) == null) {
            if (a()) {
                return this.f51811b.interceptRequest(str, map);
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
                return this.f51811b.isOfflineCacheReady(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (iOfflineCache = this.f51811b) == null) {
            return;
        }
        iOfflineCache.offlineConfigUpdate(str);
        a(str);
    }

    public void onLangbridgeRefresh(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) && a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f51814e.equals(str) && currentTimeMillis - this.f51815f < this.f51816g) {
                this.f51813d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f51814e = str;
            this.f51815f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && TextUtils.isEmpty(this.f51812c)) {
            this.f51812c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iOfflineCache) == null) {
            this.f51811b = iOfflineCache;
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (a()) {
                return this.f51811b.showProgressLine(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f51811b != null && this.f51813d : invokeV.booleanValue;
    }
}
