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
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class EBusinessProtocolView extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f21745e;

    /* renamed from: f  reason: collision with root package name */
    public View f21746f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21747g;

    /* renamed from: h  reason: collision with root package name */
    public WebView f21748h;
    public TBSpecificationBtn i;
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
            if (EBusinessProtocolView.this.f21748h != null) {
                EBusinessProtocolView.this.f21748h.loadUrl(str2);
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
        public static final /* synthetic */ int[] f21753a;

        static {
            int[] iArr = new int[WindowType.values().length];
            f21753a = iArr;
            try {
                iArr[WindowType.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21753a[WindowType.PROTOCOL.ordinal()] = 2;
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
        this.f21745e = context;
        this.q = windowType;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.f21746f = LayoutInflater.from(getContext()).inflate(R.layout.e_business_protocol_dialog, (ViewGroup) null);
    }

    public final void f() {
        this.j.setOnClickListener(new b());
        this.i.setOnClickListener(new c());
        this.l.setOnClickListener(new d());
    }

    public final void g() {
        this.f21747g = (TextView) this.f21746f.findViewById(R.id.protocol_title);
        this.f21748h = (WebView) this.f21746f.findViewById(R.id.protocol_content);
        this.j = (TBSpecificationBtn) this.f21746f.findViewById(R.id.agree_protocol);
        this.i = (TBSpecificationBtn) this.f21746f.findViewById(R.id.cancel_protocol);
        this.k = (TextView) this.f21746f.findViewById(R.id.tip_content);
        this.l = (TBSpecificationBtn) findViewById(R.id.tip_known);
        h();
        f();
    }

    public final void h() {
        this.f21747g.setText(this.n);
        int i = e.f21753a[this.q.ordinal()];
        if (i == 1) {
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            setCanceledOnTouchOutside(true);
            this.k.setText(this.o);
            this.l.setText(this.f21745e.getResources().getString(R.string.tip_known));
            d.b.i0.r.f0.m.c cVar = new d.b.i0.r.f0.m.c();
            cVar.o(R.color.CAM_X0302);
            this.l.setTextSize(R.dimen.T_X08);
            this.l.setConfig(cVar);
        } else if (i != 2) {
        } else {
            n();
            this.f21748h.setVisibility(0);
            this.j.setVisibility(0);
            this.i.setVisibility(0);
            this.f21748h.loadUrl(this.p);
            d.b.i0.r.f0.m.c cVar2 = new d.b.i0.r.f0.m.c();
            cVar2.o(R.color.CAM_X0107);
            this.i.setConfig(cVar2);
            this.i.setTextSize(R.dimen.tbds42);
            this.i.setText(this.f21745e.getResources().getString(R.string.protocol_cancel));
            this.j.setTextSize(R.dimen.tbds42);
            d.b.i0.r.f0.m.c cVar3 = new d.b.i0.r.f0.m.c();
            cVar3.o(R.color.CAM_X0302);
            this.j.setConfig(cVar3);
            this.j.setTextSize(R.dimen.tbds42);
            this.j.setText(this.f21745e.getResources().getString(R.string.protocol_agree));
        }
    }

    public void i(String str) {
        this.p = str;
    }

    public void j(int i) {
        l(i);
        this.r = i;
        SkinManager.setViewTextColor(this.f21747g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f21748h, R.color.CAM_X0211);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0303);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
    }

    public void k(CharSequence charSequence) {
        this.o = charSequence;
    }

    public final void l(int i) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimensionPixelSize);
        gradientDrawable.setColor(SkinManager.getColor(i, R.color.CAM_X0211));
        this.f21746f.setBackgroundDrawable(gradientDrawable);
    }

    public void m(f fVar) {
        this.s = fVar;
    }

    public final void n() {
        WebSettings settings = this.f21748h.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.f21748h.setWebViewClient(this.t);
        settings.setTextZoom(115);
    }

    public void o(String str) {
        this.n = str;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.width = this.f21745e.getResources().getDisplayMetrics().widthPixels - l.g(this.f21745e, R.dimen.tbds90);
        layoutParams.height = l.g(this.f21745e, R.dimen.tbds879);
        setContentView(this.f21746f, layoutParams);
        setCanceledOnTouchOutside(true);
        g();
        j(TbadkCoreApplication.getInst().getSkinType());
    }
}
