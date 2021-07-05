package com.baidu.wallet.lightapp.base;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WebView f25240a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25241b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25242c;

    /* renamed from: d  reason: collision with root package name */
    public URL f25243d;

    public b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25240a = webView;
        this.f25241b = str;
        this.f25242c = str2;
        if (webView != null) {
            a(new Runnable(this) { // from class: com.baidu.wallet.lightapp.base.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f25244a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f25244a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f25244a.f25240a == null) {
                                return;
                            }
                            this.f25244a.f25243d = new URL(this.f25244a.f25240a.getUrl());
                        } catch (MalformedURLException unused) {
                        }
                    }
                }
            });
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(this.f25242c) || this.f25240a == null) {
            return;
        }
        a(new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.base.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f25247a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f25248b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25248b = this;
                this.f25247a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        URL url = new URL(this.f25248b.f25240a.getUrl());
                        if (this.f25248b.f25243d != null && !url.sameFile(this.f25248b.f25243d)) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(url.toString());
                            hashSet.add(this.f25248b.f25243d.toString());
                            PayStatisticsUtil.onEventWithValues(StatServiceEvent.CALL_JS_NOT_SAME_FILE, hashSet);
                            return;
                        }
                    } catch (MalformedURLException unused) {
                    }
                    String str2 = this.f25248b.f25242c;
                    if (!TextUtils.isEmpty(this.f25247a)) {
                        str2 = str2 + "(" + this.f25247a + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    if (LogUtil.DEBUG) {
                        LogUtil.logd("loadUrl=" + str2);
                    }
                    try {
                        if (this.f25248b.f25240a == null) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 19) {
                            this.f25248b.f25240a.evaluateJavascript(str2, null);
                            return;
                        }
                        this.f25248b.f25240a.loadUrl("javascript:" + str2);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (LogUtil.DEBUG) {
                LogUtil.logd("sucessJsCallback=" + str + "#" + this.f25241b);
            }
            if (TextUtils.isEmpty(this.f25241b) || this.f25240a == null) {
                return;
            }
            a(new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.base.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25245a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f25246b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25246b = this;
                    this.f25245a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            URL url = new URL(this.f25246b.f25240a.getUrl());
                            if (this.f25246b.f25243d != null && !url.sameFile(this.f25246b.f25243d)) {
                                HashSet hashSet = new HashSet();
                                hashSet.add(url.toString());
                                hashSet.add(this.f25246b.f25243d.toString());
                                PayStatisticsUtil.onEventWithValues(StatServiceEvent.CALL_JS_NOT_SAME_FILE, hashSet);
                                return;
                            }
                        } catch (MalformedURLException unused) {
                        }
                        String str2 = this.f25246b.f25241b;
                        if (!TextUtils.isEmpty(this.f25245a)) {
                            str2 = str2 + "(" + this.f25245a + SmallTailInfo.EMOTION_SUFFIX;
                        }
                        if (LogUtil.DEBUG) {
                            LogUtil.logd("loadUrl=" + str2);
                        }
                        try {
                            if (this.f25246b.f25240a == null) {
                                return;
                            }
                            if (Build.VERSION.SDK_INT >= 19) {
                                this.f25246b.f25240a.evaluateJavascript(str2, null);
                                return;
                            }
                            this.f25246b.f25240a.loadUrl("javascript:" + str2);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            });
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, runnable) == null) || runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
