package com.baidu.tieba.quickWebView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g98;
import com.repackage.h98;
import com.repackage.i98;
import com.repackage.j98;
import com.repackage.ok8;
import com.repackage.pk8;
import com.repackage.xt4;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class QuickWebView extends BaseWebView {
    public static /* synthetic */ Interceptable $ic;
    public static String o;
    public transient /* synthetic */ FieldHolder $fh;
    public g98 a;
    public QuickWebViewBridge b;
    public ProgressBar c;
    public boolean d;
    public boolean e;
    public int f;
    public ObjectAnimator g;
    public ObjectAnimator h;
    public Context i;
    public Drawable j;
    public int k;
    public String l;
    public String m;
    public BaseWebView.g n;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickWebView a;

        public a(QuickWebView quickWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickWebView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) || this.a.c == null) {
                return;
            }
            if (this.a.d) {
                this.a.c.setVisibility(8);
                return;
            }
            QuickWebView quickWebView = this.a;
            quickWebView.f = quickWebView.c.getProgress();
            if (i < 100 || this.a.e) {
                this.a.c.setVisibility(0);
                this.a.o(i);
                return;
            }
            this.a.e = true;
            this.a.c.setProgress(i);
            QuickWebView quickWebView2 = this.a;
            quickWebView2.n(quickWebView2.c.getProgress());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ QuickWebView b;

        public b(QuickWebView quickWebView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = quickWebView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.b.c.setProgress((int) (this.a + ((100 - this.a) * valueAnimator.getAnimatedFraction())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickWebView a;

        public c(QuickWebView quickWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = quickWebView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.c.setProgress(0);
                this.a.c.setVisibility(8);
                this.a.c.setAlpha(1.0f);
                this.a.e = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(967926042, "Lcom/baidu/tieba/quickWebView/QuickWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(967926042, "Lcom/baidu/tieba/quickWebView/QuickWebView;");
                return;
            }
        }
        o = QuickWebView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = false;
        this.k = 0;
        this.l = "none";
        this.m = "0.0.0.0";
        this.n = new a(this);
        k(context);
    }

    private Drawable getProgressDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.j == null) {
                this.j = getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080fba);
            }
            return this.j;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            g98 g98Var = this.a;
            if (g98Var != null) {
                g98Var.h();
                this.a = null;
            }
            this.n = null;
            setOnProgressChangedListener(null);
            ObjectAnimator objectAnimator = this.g;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.g = null;
            }
            ObjectAnimator objectAnimator2 = this.h;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                this.h = null;
            }
            this.c = null;
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = true;
            super.goBack();
        }
    }

    public void h(ok8 ok8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ok8Var) == null) {
            this.mJsBridge.a(ok8Var);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            this.c = progressBar;
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702d4), 0, 0));
            this.c.setProgressDrawable(getProgressDrawable());
            addView(this.c);
            setOnProgressChangedListener(this.n);
        }
    }

    public final String j(String str) {
        InterceptResult invokeL;
        String str2;
        Iterator<String> it;
        String str3;
        Iterator<String> it2;
        String str4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            HashMap hashMap = new HashMap();
            String str5 = null;
            try {
                URL url = new URL(str);
                j98 c2 = i98.a().c(url.getPath());
                if (c2 == null) {
                    try {
                        if (i98.a().b() != null) {
                            this.k = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    int i = 2;
                    int i2 = 0;
                    try {
                        if (!c2.e) {
                            this.k = 4;
                            xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.b, "hybridVersion", this.m, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String s = h98.q().s(c2.b);
                            if (!TextUtils.isEmpty(c2.b) && !TextUtils.isEmpty(c2.c) && !TextUtils.isEmpty(s)) {
                                this.l = h98.z(true, c2.b);
                                this.m = h98.z(false, s);
                                String str6 = h98.q().p() + "/" + c2.b + "/" + s + "/";
                                String str7 = c2.c;
                                if (!c2.c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str7 = c2.c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str8 = str6 + str7;
                                File file = new File(str8);
                                ArrayList<String> arrayList = c2.d;
                                if (!str8.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.k = 2;
                                        xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.l, "hybridVersion", this.m, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str9 : arrayList) {
                                            if (StringUtils.isNull(str9)) {
                                                xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.l, "hybridVersion", this.m, "hybridResult", "static file path is null");
                                                this.k = 1;
                                                return null;
                                            } else if (!new File(str6, str9).exists()) {
                                                this.k = 1;
                                                xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.l, "hybridVersion", this.m, "hybridResult", "bundle incomplete");
                                                return null;
                                            }
                                        }
                                    }
                                }
                                String query = url.getQuery();
                                str2 = "file://" + str6 + str7;
                                try {
                                    if (!TextUtils.isEmpty(query)) {
                                        str2 = str2 + "?" + query;
                                    }
                                    if (c2.a != null && c2.a.size() != 0) {
                                        String str10 = "&";
                                        if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                            int length = split.length;
                                            int i3 = 0;
                                            while (i3 < length) {
                                                String[] split2 = split[i3].split("=");
                                                if (split2 != null && split2.length == i) {
                                                    hashMap.put("{" + split2[0] + "}", split2[1]);
                                                }
                                                i3++;
                                                i = 2;
                                            }
                                        }
                                        hashMap.put("{client_version}", TbConfig.getVersion());
                                        hashMap.put("{client_type}", "2");
                                        hashMap.put("{is_yy_user}", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                                        Iterator<String> it3 = c2.a.iterator();
                                        while (it3.hasNext()) {
                                            String next = it3.next();
                                            StringBuilder sb = new StringBuilder();
                                            String query2 = new URL(next).getQuery();
                                            if (TextUtils.isEmpty(query2)) {
                                                it = it3;
                                                str3 = str10;
                                            } else {
                                                String[] split3 = query2.split(str10);
                                                if (split3 != null) {
                                                    int length2 = split3.length;
                                                    boolean z = true;
                                                    while (i2 < length2) {
                                                        String str11 = split3[i2];
                                                        if (z) {
                                                            z = false;
                                                        } else {
                                                            sb.append(str10);
                                                        }
                                                        String[] split4 = str11.split("=");
                                                        if (split4 != null) {
                                                            it2 = it3;
                                                            str4 = str10;
                                                            if (split4.length == 2) {
                                                                String str12 = (String) hashMap.get(split4[1]);
                                                                if (str12 == null) {
                                                                    str12 = split4[1];
                                                                    if (str12.contains("{") && str12.contains("}")) {
                                                                        str12 = null;
                                                                    }
                                                                }
                                                                sb.append(split4[0]);
                                                                sb.append("=");
                                                                if (!TextUtils.isEmpty(str12)) {
                                                                    sb.append(str12);
                                                                }
                                                                i2++;
                                                                it3 = it2;
                                                                str10 = str4;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            str4 = str10;
                                                        }
                                                        i2++;
                                                        it3 = it2;
                                                        str10 = str4;
                                                    }
                                                }
                                                it = it3;
                                                str3 = str10;
                                                String sb2 = sb.toString();
                                                if (!TextUtils.isEmpty(sb2)) {
                                                    next = next.replace(query2, sb2);
                                                }
                                            }
                                            QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                                            quickWebViewBridgeData.type = SharedPreferenceManager.OPERATION_GET_PERFIX;
                                            quickWebViewBridgeData.url = next;
                                            quickWebViewBridgeData.module = c2.b;
                                            quickWebViewBridgeData.begin = System.currentTimeMillis();
                                            if (this.a != null) {
                                                this.a.i(quickWebViewBridgeData, null);
                                            }
                                            it3 = it;
                                            str10 = str3;
                                            i2 = 0;
                                        }
                                        return str2;
                                    }
                                    return str2;
                                } catch (MalformedURLException unused2) {
                                    str5 = str2;
                                    return str5;
                                }
                            }
                            return null;
                        } catch (MalformedURLException unused3) {
                            str2 = null;
                        }
                    } catch (MalformedURLException unused4) {
                        str5 = null;
                    }
                }
            } catch (MalformedURLException unused5) {
            }
            return str5;
        }
        return (String) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.i = context;
            initCommonJsBridge(context);
            g98 g98Var = new g98(this);
            this.a = g98Var;
            g98Var.l(this.mJsBridge);
            QuickWebViewBridge quickWebViewBridge = new QuickWebViewBridge(context, this.a);
            this.b = quickWebViewBridge;
            this.mJsBridge.a(quickWebViewBridge);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && z) {
            i(this.i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    @Override // android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String str2 = str;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().a;
                String str3 = null;
                for (String str4 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str4) && str2.contains(str4)) {
                        str3 = str4;
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(hashMap.get(str3))) {
                    String str5 = hashMap.get(str3);
                    Uri parse = Uri.parse(str);
                    String str6 = (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost())) ? "" : parse.getScheme() + "://" + parse.getHost();
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        str2 = str2.replace(str6, str5);
                    }
                }
            }
            if (!str2.contains("javascript:")) {
                this.d = false;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str2.contains("?") ? "&" : "?");
                sb.append("_webview_time=");
                sb.append(System.currentTimeMillis());
                str2 = sb.toString();
                xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                String substring = str2.length() > 100 ? str2.substring(0, 100) : str2;
                if (QuickWebViewSwitch.getInOn()) {
                    String j = j(str2);
                    if (!TextUtils.isEmpty(j)) {
                        xt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", j, "hybridName", this.l, "hybridVersion", this.m, "hybridResult", "success");
                        str2 = j;
                        z = true;
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.k).param("obj_name", h98.h).param("obj_param1", this.l).param("obj_id", this.m));
                        this.k = 0;
                        this.l = "none";
                        this.m = "0.0.0.0";
                        xt4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.k = 5;
                }
                z = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.k).param("obj_name", h98.h).param("obj_param1", this.l).param("obj_id", this.m));
                this.k = 0;
                this.l = "none";
                this.m = "0.0.0.0";
                xt4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.b != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.b.setLastLoadUrlTime(currentTimeMillis);
                this.mCommonJsBridge.setLastLoadUrlTime(currentTimeMillis);
            }
            super.loadUrl(str2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || StringUtils.isNull(str) || this.mJsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("data", str);
        this.mJsBridge.i(this, SearchJsBridge.METHOD_SET_SEARCH_HISTORY, linkedHashMap);
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            ObjectAnimator objectAnimator = this.h;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.h = null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.h = ofFloat;
            ofFloat.setDuration(150L);
            this.h.setInterpolator(new DecelerateInterpolator());
            this.h.addUpdateListener(new b(this, i));
            this.h.addListener(new c(this));
            this.h.start();
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            ObjectAnimator objectAnimator = this.g;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.g = null;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.c, "progress", this.f, i);
            this.g = ofInt;
            ofInt.setDuration(100L);
            this.g.setInterpolator(new DecelerateInterpolator());
            this.g.start();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView
    public void setOnJsPromptCallback(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pk8Var) == null) {
            Log.e(o, "QuickWebView do not support setOnJsPromptCallback");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = false;
        this.k = 0;
        this.l = "none";
        this.m = "0.0.0.0";
        this.n = new a(this);
        k(context);
    }
}
