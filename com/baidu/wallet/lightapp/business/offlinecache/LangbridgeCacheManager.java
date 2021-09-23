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
/* loaded from: classes8.dex */
public class LangbridgeCacheManager implements NoProguard, IOfflineCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String OFFLINE_FAIL_OVER_OCCUR;

    /* renamed from: a  reason: collision with root package name */
    public final int f62138a;

    /* renamed from: b  reason: collision with root package name */
    public IOfflineCache f62139b;

    /* renamed from: c  reason: collision with root package name */
    public String f62140c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62141d;

    /* renamed from: e  reason: collision with root package name */
    public String f62142e;

    /* renamed from: f  reason: collision with root package name */
    public long f62143f;

    /* renamed from: g  reason: collision with root package name */
    public int f62144g;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgeCacheManager f62145a;
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
            f62145a = new LangbridgeCacheManager();
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
        this.f62138a = 5000;
        this.f62141d = true;
        this.f62142e = "";
        this.f62143f = 0L;
        this.f62144g = 5000;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                this.f62144g = new JSONObject(str).optInt("refreshInterval", 5000);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static LangbridgeCacheManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f62145a : (LangbridgeCacheManager) invokeV.objValue;
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
            String str = this.f62140c;
            if (TextUtils.isEmpty(str)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
                    if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
                        userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
                    }
                    this.f62140c = userAgentString;
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
                return this.f62139b.getOfflineCacheInfo(str);
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
            if (this.f62139b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f62139b.getOfflineCacheInfo(str)) != null) {
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
            this.f62139b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && a()) {
            this.f62139b.handleFinishLangbirdge(j2);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && a()) {
            this.f62139b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, str) == null) && a()) {
            this.f62139b.handleLoadUrl(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j2, str) == null) && a()) {
            this.f62139b.handleStartLangbirdge(j2, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && a()) {
            this.f62139b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, map)) == null) {
            if (a()) {
                return this.f62139b.interceptRequest(str, map);
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
                return this.f62139b.isOfflineCacheReady(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (iOfflineCache = this.f62139b) == null) {
            return;
        }
        iOfflineCache.offlineConfigUpdate(str);
        a(str);
    }

    public void onLangbridgeRefresh(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) && a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f62142e.equals(str) && currentTimeMillis - this.f62143f < this.f62144g) {
                this.f62141d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f62142e = str;
            this.f62143f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && TextUtils.isEmpty(this.f62140c)) {
            this.f62140c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iOfflineCache) == null) {
            this.f62139b = iOfflineCache;
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (a()) {
                return this.f62139b.showProgressLine(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f62139b != null && this.f62141d : invokeV.booleanValue;
    }
}
