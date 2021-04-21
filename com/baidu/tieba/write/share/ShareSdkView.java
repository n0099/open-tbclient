package com.baidu.tieba.write.share;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f21995e;

    /* renamed from: f  reason: collision with root package name */
    public View f21996f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21997g;

    /* renamed from: h  reason: collision with root package name */
    public View f21998h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TbImageView l;
    public EditText m;
    public View n;
    public TextView o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public c x;

    /* loaded from: classes5.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > ShareSdkView.this.r * 2) {
                if (ShareSdkView.this.s != 0) {
                    ShareSdkView.this.s = 0;
                    ShareSdkView shareSdkView = ShareSdkView.this;
                    shareSdkView.t = shareSdkView.v;
                    ShareSdkView.this.m.setPadding(ShareSdkView.this.w, ShareSdkView.this.s, ShareSdkView.this.w, ShareSdkView.this.t);
                }
            } else if (editable.length() > ShareSdkView.this.r) {
                if (ShareSdkView.this.s != ShareSdkView.this.v) {
                    ShareSdkView shareSdkView2 = ShareSdkView.this;
                    shareSdkView2.s = shareSdkView2.v;
                    ShareSdkView shareSdkView3 = ShareSdkView.this;
                    shareSdkView3.t = shareSdkView3.v;
                    ShareSdkView.this.m.setPadding(ShareSdkView.this.w, ShareSdkView.this.s, ShareSdkView.this.w, ShareSdkView.this.t);
                }
            } else if (ShareSdkView.this.s != ShareSdkView.this.u) {
                ShareSdkView shareSdkView4 = ShareSdkView.this;
                shareSdkView4.s = shareSdkView4.u;
                ShareSdkView shareSdkView5 = ShareSdkView.this;
                shareSdkView5.t = shareSdkView5.u;
                ShareSdkView.this.m.setPadding(ShareSdkView.this.w, ShareSdkView.this.s, ShareSdkView.this.w, ShareSdkView.this.t);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams = ShareSdkView.this.l.getLayoutParams();
            layoutParams.height = ((l.k(ShareSdkView.this.getContext()) - l.g(ShareSdkView.this.getContext(), R.dimen.tbds408)) * 9) / 16;
            ShareSdkView.this.l.setLayoutParams(layoutParams);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(String str);
    }

    public ShareSdkView(Context context) {
        super(context);
        this.f21995e = 3;
        k(context);
    }

    public final void k(Context context) {
        setOrientation(1);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.share_sdk_view, (ViewGroup) this, true);
        this.f21996f = findViewById(R.id.share_sdk_content_root);
        this.f21997g = (TextView) findViewById(R.id.share_sdk_forum);
        this.f21998h = findViewById(R.id.share_sdk_content_container);
        this.i = (HeadImageView) findViewById(R.id.share_sdk_appicon);
        this.j = (TextView) findViewById(R.id.share_sdk_appname);
        this.k = (TextView) findViewById(R.id.share_sdk_content);
        this.l = (TbImageView) findViewById(R.id.share_sdk_img);
        this.m = (EditText) findViewById(R.id.share_sdk_edit);
        this.n = findViewById(R.id.share_sdk_content_line);
        this.o = (TextView) findViewById(R.id.share_sdk_cancel);
        this.p = findViewById(R.id.share_sdk_action_line);
        this.q = (TextView) findViewById(R.id.share_sdk_share);
        setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.i.setIsRound(true);
        this.i.setIsPreDrawBorder(true);
        this.i.setDrawBorder(true);
        this.i.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.i.setDefaultResource(R.color.CAM_X0205);
        this.i.setRadius(l.g(context, R.dimen.ds70));
        this.l.setDefaultBgResource(R.drawable.pic_share_default_applets);
        this.r = (l.k(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
        this.u = l.g(getContext(), R.dimen.tbds27);
        this.v = l.g(getContext(), R.dimen.tbds11);
        this.w = l.g(getContext(), R.dimen.tbds36);
        int i = this.u;
        this.s = i;
        this.t = i;
        this.m.addTextChangedListener(new a());
        l();
    }

    public void l() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f21995e) {
            return;
        }
        this.f21995e = skinType;
        SkinManager.setBackgroundColor(this, R.color.black_alpha30);
        SkinManager.setBackgroundResource(this.f21996f, R.drawable.share_sdk_bg);
        SkinManager.setViewTextColor(this.f21997g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f21998h, R.color.CAM_X0205);
        this.i.setBorderColor(SkinManager.getColor(R.color.CAM_X0111));
        this.i.setIsNight(this.f21995e == 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        this.l.setIsNight(this.f21995e == 1);
        this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundResource(this.m, R.drawable.share_sdk_input_shape_bg);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.o) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else if (view == this.q && ViewHelper.checkUpIsLogin(getContext())) {
            String obj = this.m.getText().toString();
            c cVar = this.x;
            if (cVar != null) {
                cVar.a(obj);
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.x = null;
        super.onDetachedFromWindow();
    }

    public void setData(d.b.j0.v3.q.c cVar) {
        if (cVar == null && getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
            return;
        }
        this.f21997g.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.f63831f));
        this.i.W(cVar.f63829d, 10, false);
        this.j.setText(cVar.f63828c);
        if (StringUtils.isNull(cVar.f63833h)) {
            this.k.setVisibility(8);
        } else {
            this.k.setText(cVar.f63833h);
        }
        this.l.setEvent(new b());
        this.l.W(cVar.i, 42, false);
    }

    public void setOnShareListener(c cVar) {
        this.x = cVar;
    }

    public ShareSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21995e = 3;
        k(context);
    }

    public ShareSdkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21995e = 3;
        k(context);
    }
}
