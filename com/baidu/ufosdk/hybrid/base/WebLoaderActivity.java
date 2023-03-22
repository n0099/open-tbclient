package com.baidu.ufosdk.hybrid.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.b;
import com.baidu.ufosdk.c;
import com.baidu.ufosdk.d;
import com.baidu.ufosdk.e;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.f;
import com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity;
import com.baidu.ufosdk.i;
import com.baidu.ufosdk.j;
import com.baidu.ufosdk.k;
import com.baidu.ufosdk.l;
import com.baidu.ufosdk.m;
import com.baidu.ufosdk.o1;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.s1;
import com.baidu.ufosdk.ui.BdShimmerView;
import java.util.Timer;
/* loaded from: classes7.dex */
public class WebLoaderActivity extends FeedbackBrowserActivity implements View.OnClickListener, o1.a, i, j, k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k A;
    public String B;
    public boolean C;
    public e0 D;
    public boolean E;
    public String F;
    public int G;
    public String H;
    public BroadcastReceiver I;
    public RelativeLayout m;
    public FeedbackTitleBar n;
    public FrameLayout o;
    public RelativeLayout p;
    public ImageView q;
    public TextView r;
    public Button s;
    public View t;
    public RelativeLayout u;
    public FrameLayout v;
    public ImageView w;
    public BdShimmerView x;
    public o1 y;
    public Timer z;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebLoaderActivity a;

        public a(WebLoaderActivity webLoaderActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webLoaderActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webLoaderActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "com.baidu.ufosdk.ACTION_SIGN".equals(intent.getAction()) && this.a.y != null) {
                if (intent.getBooleanExtra("extra.permission_allow", false)) {
                    this.a.y.obtainMessage(1001).sendToTarget();
                } else {
                    this.a.y.sendEmptyMessage(1003);
                }
            }
        }
    }

    public WebLoaderActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            FrameLayout frameLayout = this.o;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }
    }

    public final void d() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (timer = this.z) != null) {
            timer.cancel();
            this.z.purge();
            this.z = null;
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.C) {
                this.o.setVisibility(0);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                return;
            }
            this.y.sendEmptyMessage(1001);
        }
    }

    @Override // com.baidu.ufosdk.k.a
    public void a(int i) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (frameLayout = this.o) == null) {
            return;
        }
        if (this.l == 1) {
            int height = i - (getWindow().getDecorView().getHeight() - this.o.getHeight());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.setMargins(0, -height, 0, 0);
            this.o.setLayoutParams(layoutParams);
            return;
        }
        frameLayout.getChildAt(0).getLayoutParams().height = getWindow().getDecorView().getHeight() - i;
        this.o.requestLayout();
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            super.c(str);
            d();
            long j = 300;
            try {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    String[] strArr = s1.b;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (strArr[i].equals(host)) {
                            j = 10000;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.y.sendEmptyMessageDelayed(1004, 300L);
                throw th;
            }
            this.y.sendEmptyMessageDelayed(1004, j);
            if (!this.E) {
                this.o.setVisibility(0);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.C = true;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            if (view2 == this.s) {
                WebView webView = this.d;
                if (p1.e(this) && webView != null && !TextUtils.isEmpty(webView.getUrl())) {
                    webView.reload();
                } else if (webView == null) {
                    Toast.makeText(this, (int) R.string.obfuscated_res_0x7f0f0667, 0).show();
                    finish();
                } else {
                    this.x.setVisibility(0);
                    this.y.sendEmptyMessage(1001);
                }
            } else if (view2 == this.v) {
                onBackPressed();
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            this.E = true;
            this.y.obtainMessage(1002).sendToTarget();
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void a(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, customViewCallback) == null) {
            FrameLayout frameLayout = this.o;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            super.a(view2, customViewCallback);
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            d();
            if (this.z == null) {
                this.z = new Timer();
            }
            this.z.schedule(new m(this), 9000L, 1L);
            this.x.setVisibility(0);
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.n.f.setProgress(i);
        }
    }

    @Override // com.baidu.ufosdk.k.a
    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (frameLayout = this.o) == null) {
            return;
        }
        if (this.l == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.o.setLayoutParams(layoutParams);
            return;
        }
        frameLayout.getChildAt(0).getLayoutParams().height = -1;
        this.o.requestLayout();
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.h
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.G == 0 && TextUtils.isEmpty(this.H)) {
            this.n.d.setText(str);
        }
    }

    @Override // com.baidu.ufosdk.o1.a
    public void handleMessage(Message message) {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
            switch (message.what) {
                case 1001:
                    this.E = false;
                    boolean e = p1.e(this);
                    if (TextUtils.isEmpty(this.D.b)) {
                        this.D.a(false);
                        return;
                    } else if (!e) {
                        this.x.setVisibility(8);
                        this.o.setVisibility(8);
                        this.p.setVisibility(0);
                        this.u.setVisibility(0);
                        Toast.makeText(this, (int) R.string.obfuscated_res_0x7f0f0667, 0).show();
                        return;
                    } else if (!TextUtils.isEmpty(this.B) && (fVar = this.f) != null) {
                        String str = this.B;
                        e0 e0Var = this.D;
                        FeedbackBrowserActivity.b bVar = (FeedbackBrowserActivity.b) fVar;
                        String str2 = str + "?os=" + b.e((Context) bVar.a) + "&appid=" + e0Var.b + "&devid=" + e0Var.c + "&clientid=" + e0Var.a + "&appvn=" + c.b() + "&pkgname=" + c.a() + "&sdkvn=4.1.9.1&baiducuid=" + b.f() + "&nettype=" + p1.b((Context) bVar.a) + "&channel_id=" + b.h() + "&nightMode=" + (this.b ? 1 : 0) + "&digital=" + (((Context) bVar.a).getSharedPreferences("feedback_switch_prefs", 0).getBoolean("ab_dg_h", false) ? 1 : 0);
                        WebView webView = bVar.b.get();
                        if (webView != null) {
                            webView.loadUrl(str2);
                            return;
                        }
                        return;
                    } else {
                        f fVar2 = this.f;
                        if (fVar2 != null) {
                            String str3 = this.F;
                            WebView webView2 = ((FeedbackBrowserActivity.b) fVar2).b.get();
                            if (webView2 != null) {
                                webView2.loadUrl(str3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 1002:
                    d();
                    this.x.setVisibility(8);
                    this.o.setVisibility(8);
                    this.p.setVisibility(0);
                    this.u.setVisibility(0);
                    return;
                case 1003:
                    this.x.setVisibility(8);
                    this.p.setVisibility(0);
                    this.u.setVisibility(0);
                    this.o.setVisibility(8);
                    Toast.makeText(this, (int) R.string.obfuscated_res_0x7f0f0667, 0).show();
                    return;
                case 1004:
                    this.x.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            b();
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            int i9 = 1;
            if (b.m() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.b = z;
            this.y = new o1(this);
            this.D = e0.a(this);
            this.B = b.a(getIntent(), "help_center_url");
            this.F = b.a(getIntent(), "third_url");
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    i9 = intent.getIntExtra("titlebar_visbility", 1);
                } catch (Exception unused) {
                    intent.replaceExtras((Bundle) null);
                }
            }
            this.G = i9;
            this.H = b.a(getIntent(), "titlebar_title");
            k kVar = new k(this, false);
            this.A = kVar;
            kVar.a.add(this);
            a aVar = new a(this);
            this.I = aVar;
            registerReceiver(aVar, new IntentFilter("com.baidu.ufosdk.ACTION_SIGN"));
            setContentView(R.layout.obfuscated_res_0x7f0d0926);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091e45);
            this.m = relativeLayout;
            boolean z2 = this.b;
            int i10 = BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG;
            if (z2) {
                i = BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG;
            } else {
                i = -1;
            }
            relativeLayout.setBackgroundColor(i);
            FeedbackTitleBar feedbackTitleBar = (FeedbackTitleBar) findViewById(R.id.obfuscated_res_0x7f09286e);
            this.n = feedbackTitleBar;
            Resources resources = getResources();
            int i11 = R.color.obfuscated_res_0x7f06050a;
            feedbackTitleBar.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06050a));
            this.n.b.setVisibility(8);
            BdShimmerView bdShimmerView = (BdShimmerView) findViewById(R.id.obfuscated_res_0x7f0903ae);
            this.x = bdShimmerView;
            if (this.b) {
                i2 = BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG;
            } else {
                i2 = -1;
            }
            bdShimmerView.setBackgroundColor(i2);
            this.x.setType(b.m());
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091804);
            this.p = relativeLayout2;
            Resources resources2 = getResources();
            if (this.b) {
                i11 = R.color.obfuscated_res_0x7f0603c4;
            }
            relativeLayout2.setBackgroundColor(resources2.getColor(i11));
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091832);
            this.q = imageView;
            if (this.b) {
                i3 = R.drawable.obfuscated_res_0x7f080edf;
            } else {
                i3 = R.drawable.obfuscated_res_0x7f080ede;
            }
            imageView.setBackgroundResource(i3);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091807);
            this.r = textView;
            Resources resources3 = getResources();
            if (this.b) {
                i4 = R.color.obfuscated_res_0x7f060766;
            } else {
                i4 = R.color.obfuscated_res_0x7f060765;
            }
            textView.setTextColor(resources3.getColor(i4));
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f091d73);
            this.s = button;
            Resources resources4 = getResources();
            if (this.b) {
                i5 = R.color.obfuscated_res_0x7f060762;
            } else {
                i5 = R.color.obfuscated_res_0x7f060761;
            }
            button.setTextColor(resources4.getColor(i5));
            Button button2 = this.s;
            if (this.b) {
                i6 = R.drawable.obfuscated_res_0x7f080edd;
            } else {
                i6 = R.drawable.obfuscated_res_0x7f080edc;
            }
            button2.setBackgroundResource(i6);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0908c1);
            this.t = findViewById;
            Resources resources5 = getResources();
            if (this.b) {
                i7 = R.color.obfuscated_res_0x7f060395;
            } else {
                i7 = R.color.obfuscated_res_0x7f060394;
            }
            findViewById.setBackgroundColor(resources5.getColor(i7));
            this.u = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090435);
            this.v = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090327);
            this.w = (ImageView) findViewById(R.id.obfuscated_res_0x7f090324);
            RelativeLayout relativeLayout3 = this.u;
            if (!this.b) {
                i10 = -1;
            }
            relativeLayout3.setBackgroundColor(i10);
            ImageView imageView2 = this.w;
            if (this.b) {
                i8 = R.drawable.obfuscated_res_0x7f08033a;
            } else {
                i8 = R.drawable.obfuscated_res_0x7f080339;
            }
            imageView2.setBackgroundResource(i8);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09076e);
            this.o = frameLayout;
            frameLayout.post(new l(this));
            this.v.setOnClickListener(this);
            this.s.setOnClickListener(this);
            FeedbackTitleBar feedbackTitleBar2 = this.n;
            feedbackTitleBar2.c.setOnClickListener(new d(feedbackTitleBar2, this));
            FeedbackTitleBar feedbackTitleBar3 = this.n;
            feedbackTitleBar3.e.setOnClickListener(new e(feedbackTitleBar3, this));
            if (this.G == 0) {
                this.n.b.setVisibility(0);
                FeedbackTitleBar feedbackTitleBar4 = this.n;
                feedbackTitleBar4.d.setText(this.H);
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            k kVar = this.A;
            if (kVar != null) {
                kVar.a.remove(this);
                k kVar2 = this.A;
                View view2 = kVar2.b;
                if (view2 != null) {
                    view2.getViewTreeObserver().removeOnGlobalLayoutListener(kVar2);
                    kVar2.b = null;
                    kVar2.a = null;
                }
                this.A = null;
            }
            BroadcastReceiver broadcastReceiver = this.I;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
                this.I = null;
            }
            d();
            o1 o1Var = this.y;
            if (o1Var != null) {
                o1Var.removeMessages(1001);
                this.y.removeMessages(1002);
                this.y.removeMessages(1003);
                this.y.removeMessages(1004);
                this.y = null;
            }
            super.onDestroy();
        }
    }
}
