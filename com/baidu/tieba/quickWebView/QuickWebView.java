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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class QuickWebView extends BaseWebView {
    public static /* synthetic */ Interceptable $ic;
    public static String s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.u2.a f20435e;

    /* renamed from: f  reason: collision with root package name */
    public QuickWebViewBridge f20436f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f20437g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20438h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20439i;
    public int j;
    public ObjectAnimator k;
    public ObjectAnimator l;
    public Context m;
    public Drawable n;
    public int o;
    public String p;
    public String q;
    public BaseWebView.g r;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QuickWebView f20440a;

        public a(QuickWebView quickWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20440a = quickWebView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, webView, i2) == null) || this.f20440a.f20437g == null) {
                return;
            }
            if (this.f20440a.f20438h) {
                this.f20440a.f20437g.setVisibility(8);
                return;
            }
            QuickWebView quickWebView = this.f20440a;
            quickWebView.j = quickWebView.f20437g.getProgress();
            if (i2 < 100 || this.f20440a.f20439i) {
                this.f20440a.f20437g.setVisibility(0);
                this.f20440a.n(i2);
                return;
            }
            this.f20440a.f20439i = true;
            this.f20440a.f20437g.setProgress(i2);
            QuickWebView quickWebView2 = this.f20440a;
            quickWebView2.m(quickWebView2.f20437g.getProgress());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QuickWebView f20442f;

        public b(QuickWebView quickWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20442f = quickWebView;
            this.f20441e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f20442f.f20437g.setProgress((int) (this.f20441e + ((100 - this.f20441e) * valueAnimator.getAnimatedFraction())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickWebView f20443e;

        public c(QuickWebView quickWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20443e = quickWebView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f20443e.f20437g.setProgress(0);
                this.f20443e.f20437g.setVisibility(8);
                this.f20443e.f20437g.setAlpha(1.0f);
                this.f20443e.f20439i = false;
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
        s = QuickWebView.class.getSimpleName();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20436f = null;
        this.f20438h = false;
        this.o = 0;
        this.p = "";
        this.q = "0.0.0.0";
        this.r = new a(this);
        k(context);
    }

    private Drawable getProgressDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.n == null) {
                this.n = getContext().getResources().getDrawable(R.drawable.quick_webview_progress);
            }
            return this.n;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            d.a.s0.u2.a aVar = this.f20435e;
            if (aVar != null) {
                aVar.e();
                this.f20435e = null;
            }
            this.r = null;
            setOnProgressChangedListener(null);
            ObjectAnimator objectAnimator = this.k;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.k = null;
            }
            ObjectAnimator objectAnimator2 = this.l;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                this.l = null;
            }
            this.f20437g = null;
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20438h = true;
            super.goBack();
        }
    }

    public void h(d.a.s0.h3.l0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.mJsBridge.a(bVar);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            this.f20437g = progressBar;
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds5), 0, 0));
            this.f20437g.setProgressDrawable(getProgressDrawable());
            addView(this.f20437g);
            setOnProgressChangedListener(this.r);
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
                d.a.s0.u2.d.a c2 = d.a.s0.u2.c.a().c(url.getPath());
                if (c2 == null) {
                    try {
                        if (d.a.s0.u2.c.a().b() != null) {
                            this.o = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    try {
                        if (!c2.f67383e) {
                            this.o = 4;
                            d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.f67380b, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String s2 = d.a.s0.u2.b.q().s(c2.f67380b);
                            if (!TextUtils.isEmpty(c2.f67380b) && !TextUtils.isEmpty(c2.f67381c) && !TextUtils.isEmpty(s2)) {
                                this.p = c2.f67380b;
                                this.q = s2;
                                String str6 = d.a.s0.u2.b.q().p() + "/" + c2.f67380b + "/" + s2 + "/";
                                String str7 = c2.f67381c;
                                if (!c2.f67381c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str7 = c2.f67381c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str8 = str6 + str7;
                                File file = new File(str8);
                                ArrayList<String> arrayList = c2.f67382d;
                                if (!str8.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.o = 2;
                                        d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.p, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str9 : arrayList) {
                                            if (StringUtils.isNull(str9)) {
                                                d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.p, "hybridResult", "static file path is null");
                                                this.o = 1;
                                                return null;
                                            } else if (!new File(str6, str9).exists()) {
                                                this.o = 1;
                                                d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.p, "hybridResult", "bundle incomplete");
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
                                    if (c2.f67379a != null && c2.f67379a.size() != 0) {
                                        String str10 = "&";
                                        if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                            for (String str11 : split) {
                                                String[] split2 = str11.split("=");
                                                if (split2 != null && split2.length == 2) {
                                                    hashMap.put(StringUtil.ARRAY_START + split2[0] + "}", split2[1]);
                                                }
                                            }
                                        }
                                        hashMap.put("{client_version}", TbConfig.getVersion());
                                        hashMap.put("{client_type}", "2");
                                        hashMap.put("{is_yy_user}", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                                        Iterator<String> it3 = c2.f67379a.iterator();
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
                                                    int length = split3.length;
                                                    int i2 = 0;
                                                    boolean z = true;
                                                    while (i2 < length) {
                                                        String str12 = split3[i2];
                                                        if (z) {
                                                            z = false;
                                                        } else {
                                                            sb.append(str10);
                                                        }
                                                        String[] split4 = str12.split("=");
                                                        if (split4 != null) {
                                                            it2 = it3;
                                                            str4 = str10;
                                                            if (split4.length == 2) {
                                                                String str13 = (String) hashMap.get(split4[1]);
                                                                if (str13 == null) {
                                                                    str13 = split4[1];
                                                                    if (str13.contains(StringUtil.ARRAY_START) && str13.contains("}")) {
                                                                        str13 = null;
                                                                    }
                                                                }
                                                                sb.append(split4[0]);
                                                                sb.append("=");
                                                                if (!TextUtils.isEmpty(str13)) {
                                                                    sb.append(str13);
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
                                            quickWebViewBridgeData.type = "get";
                                            quickWebViewBridgeData.url = next;
                                            quickWebViewBridgeData.module = c2.f67380b;
                                            quickWebViewBridgeData.begin = System.currentTimeMillis();
                                            if (this.f20435e != null) {
                                                this.f20435e.f(quickWebViewBridgeData, null);
                                            }
                                            it3 = it;
                                            str10 = str3;
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
            this.m = context;
            initCommonJsBridge(context);
            d.a.s0.u2.a aVar = new d.a.s0.u2.a(this);
            this.f20435e = aVar;
            aVar.h(this.mJsBridge);
            QuickWebViewBridge quickWebViewBridge = new QuickWebViewBridge(context, this.f20435e);
            this.f20436f = quickWebViewBridge;
            this.mJsBridge.a(quickWebViewBridge);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && z) {
            i(this.m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016e  */
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
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().f55371a;
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
                this.f20438h = false;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str2.contains("?") ? "&" : "?");
                sb.append("_webview_time=");
                sb.append(System.currentTimeMillis());
                str2 = sb.toString();
                d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                if (QuickWebViewSwitch.getInOn()) {
                    String j = j(str2);
                    if (!TextUtils.isEmpty(j)) {
                        d.a.r0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", j, "hybridName", this.p, "hybridVersion", this.q, "hybridVersion", "success");
                        str2 = j;
                        z = true;
                        String substring = str2.length() <= 100 ? str2.substring(0, 100) : str2;
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.o).param("obj_name", d.a.s0.u2.b.f67353h).param("obj_param1", this.p).param("obj_id", this.q));
                        this.o = 0;
                        this.q = "0.0.0.0";
                        this.p = "";
                        d.a.r0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.o = 5;
                }
                z = false;
                if (str2.length() <= 100) {
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.o).param("obj_name", d.a.s0.u2.b.f67353h).param("obj_param1", this.p).param("obj_id", this.q));
                this.o = 0;
                this.q = "0.0.0.0";
                this.p = "";
                d.a.r0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.f20436f != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f20436f.setLastLoadUrlTime(currentTimeMillis);
                this.mCommonJsBridge.setLastLoadUrlTime(currentTimeMillis);
            }
            super.loadUrl(str2);
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.l = null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20437g, "alpha", 1.0f, 0.0f);
            this.l = ofFloat;
            ofFloat.setDuration(150L);
            this.l.setInterpolator(new DecelerateInterpolator());
            this.l.addUpdateListener(new b(this, i2));
            this.l.addListener(new c(this));
            this.l.start();
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            ObjectAnimator objectAnimator = this.k;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.k = null;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f20437g, "progress", this.j, i2);
            this.k = ofInt;
            ofInt.setDuration(100L);
            this.k.setInterpolator(new DecelerateInterpolator());
            this.k.start();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView
    public void setOnJsPromptCallback(d.a.s0.h3.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            Log.e(s, "QuickWebView do not support setOnJsPromptCallback");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f20436f = null;
        this.f20438h = false;
        this.o = 0;
        this.p = "";
        this.q = "0.0.0.0";
        this.r = new a(this);
        k(context);
    }
}
