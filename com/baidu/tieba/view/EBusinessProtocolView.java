package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class EBusinessProtocolView extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f21753e;

    /* renamed from: f  reason: collision with root package name */
    public View f21754f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21755g;

    /* renamed from: h  reason: collision with root package name */
    public WebView f21756h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f21757i;
    public TBSpecificationBtn j;
    public TextView k;
    public TBSpecificationBtn l;
    public boolean m;
    public String n;
    public CharSequence o;
    public String p;
    public final WindowType q;
    public int r;
    public f s;
    public WebViewClient t;

    /* loaded from: classes5.dex */
    public enum WindowType {
        TIP,
        PROTOCOL
    }

    /* loaded from: classes5.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            String str2 = "javascript:setContentTextColor(" + EBusinessProtocolView.this.r + SmallTailInfo.EMOTION_SUFFIX;
            if (EBusinessProtocolView.this.f21756h != null) {
                EBusinessProtocolView.this.f21756h.loadUrl(str2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EBusinessProtocolView.this.m = true;
            if (EBusinessProtocolView.this.s != null) {
                EBusinessProtocolView.this.s.a(EBusinessProtocolView.this.m);
            }
            EBusinessProtocolView.this.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EBusinessProtocolView.this.m = false;
            if (EBusinessProtocolView.this.s != null) {
                EBusinessProtocolView.this.s.a(EBusinessProtocolView.this.m);
            }
            EBusinessProtocolView.this.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EBusinessProtocolView.this.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21762a;

        static {
            int[] iArr = new int[WindowType.values().length];
            f21762a = iArr;
            try {
                iArr[WindowType.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21762a[WindowType.PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z);
    }

    public EBusinessProtocolView(@NonNull Context context, WindowType windowType) {
        super(context, R.style.e_business_protocol_dialog);
        this.m = false;
        this.r = 0;
        this.t = new a();
        this.f21753e = context;
        this.q = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.f21754f = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    public final void f() {
        this.j.setOnClickListener(new b());
        this.f21757i.setOnClickListener(new c());
        this.l.setOnClickListener(new d());
    }

    public final void g() {
        this.f21755g = (TextView) this.f21754f.findViewById(R.id.protocol_title);
        this.f21756h = (WebView) this.f21754f.findViewById(R.id.protocol_content);
        this.j = (TBSpecificationBtn) this.f21754f.findViewById(R.id.agree_protocol);
        this.f21757i = (TBSpecificationBtn) this.f21754f.findViewById(R.id.cancel_protocol);
        this.k = (TextView) this.f21754f.findViewById(R.id.tip_content);
        this.l = (TBSpecificationBtn) findViewById(R.id.tip_known);
        h();
        f();
    }

    public final void h() {
        this.f21755g.setText(this.n);
        int i2 = e.f21762a[this.q.ordinal()];
        if (i2 == 1) {
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            setCanceledOnTouchOutside(true);
            this.k.setText(this.o);
            this.l.setText(this.f21753e.getResources().getString(R.string.tip_known));
            d.a.n0.r.f0.m.c cVar = new d.a.n0.r.f0.m.c();
            cVar.o(R.color.CAM_X0302);
            this.l.setTextSize(R.dimen.T_X08);
            this.l.setConfig(cVar);
        } else if (i2 != 2) {
        } else {
            n();
            this.f21756h.setVisibility(0);
            this.j.setVisibility(0);
            this.f21757i.setVisibility(0);
            this.f21756h.loadUrl(this.p);
            d.a.n0.r.f0.m.c cVar2 = new d.a.n0.r.f0.m.c();
            cVar2.o(R.color.CAM_X0107);
            this.f21757i.setConfig(cVar2);
            this.f21757i.setTextSize(R.dimen.tbds42);
            this.f21757i.setText(this.f21753e.getResources().getString(R.string.protocol_cancel));
            this.j.setTextSize(R.dimen.tbds42);
            d.a.n0.r.f0.m.c cVar3 = new d.a.n0.r.f0.m.c();
            cVar3.o(R.color.CAM_X0302);
            this.j.setConfig(cVar3);
            this.j.setTextSize(R.dimen.tbds42);
            this.j.setText(this.f21753e.getResources().getString(R.string.protocol_agree));
        }
    }

    public void i(String str) {
        this.p = str;
    }

    public void j(int i2) {
        l(i2);
        this.r = i2;
        SkinManager.setViewTextColor(this.f21755g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f21756h, R.color.CAM_X0211);
        SkinManager.setViewTextColor(this.f21757i, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0303);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
    }

    public void k(CharSequence charSequence) {
        this.o = charSequence;
    }

    public final void l(int i2) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(SkinManager.getColor(i2, R.color.CAM_X0211));
        this.f21754f.setBackgroundDrawable(gradientDrawable);
    }

    public void m(f fVar) {
        this.s = fVar;
    }

    public final void n() {
        WebSettings settings = this.f21756h.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.f21756h.setWebViewClient(this.t);
        settings.setTextZoom(115);
    }

    public void o(String str) {
        this.n = str;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.width = this.f21753e.getResources().getDisplayMetrics().widthPixels - l.g(this.f21753e, R.dimen.tbds90);
        layoutParams.height = l.g(this.f21753e, R.dimen.tbds879);
        setContentView(this.f21754f, layoutParams);
        setCanceledOnTouchOutside(true);
        g();
        j(TbadkCoreApplication.getInst().getSkinType());
    }
}
