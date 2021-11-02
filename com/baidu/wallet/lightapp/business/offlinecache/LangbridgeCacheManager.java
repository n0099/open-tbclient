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
/* loaded from: classes10.dex */
public class LangbridgeCacheManager implements NoProguard, IOfflineCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String OFFLINE_FAIL_OVER_OCCUR;

    /* renamed from: a  reason: collision with root package name */
    public final int f59051a;

    /* renamed from: b  reason: collision with root package name */
    public IOfflineCache f59052b;

    /* renamed from: c  reason: collision with root package name */
    public String f59053c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59054d;

    /* renamed from: e  reason: collision with root package name */
    public String f59055e;

    /* renamed from: f  reason: collision with root package name */
    public long f59056f;

    /* renamed from: g  reason: collision with root package name */
    public int f59057g;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgeCacheManager f59058a;
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
            f59058a = new LangbridgeCacheManager();
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
        this.f59051a = 5000;
        this.f59054d = true;
        this.f59055e = "";
        this.f59056f = 0L;
        this.f59057g = 5000;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                this.f59057g = new JSONObject(str).optInt("refreshInterval", 5000);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static LangbridgeCacheManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f59058a : (LangbridgeCacheManager) invokeV.objValue;
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
            String str = this.f59053c;
            if (TextUtils.isEmpty(str)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
                    if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
                        userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
                    }
                    this.f59053c = userAgentString;
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
                return this.f59052b.getOfflineCacheInfo(str);
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
            if (this.f59052b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f59052b.getOfflineCacheInfo(str)) != null) {
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
            this.f59052b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && a()) {
            this.f59052b.handleFinishLangbirdge(j);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && a()) {
            this.f59052b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, str) == null) && a()) {
            this.f59052b.handleLoadUrl(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) && a()) {
            this.f59052b.handleStartLangbirdge(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && a()) {
            this.f59052b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, map)) == null) {
            if (a()) {
                return this.f59052b.interceptRequest(str, map);
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
                return this.f59052b.isOfflineCacheReady(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (iOfflineCache = this.f59052b) == null) {
            return;
        }
        iOfflineCache.offlineConfigUpdate(str);
        a(str);
    }

    public void onLangbridgeRefresh(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) && a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f59055e.equals(str) && currentTimeMillis - this.f59056f < this.f59057g) {
                this.f59054d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f59055e = str;
            this.f59056f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && TextUtils.isEmpty(this.f59053c)) {
            this.f59053c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iOfflineCache) == null) {
            this.f59052b = iOfflineCache;
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (a()) {
                return this.f59052b.showProgressLine(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f59052b != null && this.f59054d : invokeV.booleanValue;
    }
}
