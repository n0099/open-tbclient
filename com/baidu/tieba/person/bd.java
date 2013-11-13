package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.model.bx;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bd extends be {
    private int G;
    private LinearLayout H;
    private BaseFragmentActivity I;
    private int J;
    private ViewGroup K;
    private LinearLayout L;
    private LinearLayout M;
    private TextView N;
    private ImageView O;
    private TextView P;
    private LinearLayout Q;
    private LinearLayout R;
    private LinearLayout S;
    private ImageView T;
    private TextView U;
    private ImageView V;
    private LinearLayout W;
    private ImageView X;
    private TextView Y;
    private TextView Z;
    private LinearLayout aa;
    private ImageView ab;
    private TextView ac;
    private TextView ad;
    private LinearLayout ae;
    private ImageView af;
    private TextView ag;
    private TextView ah;
    private TextView ai;
    private LinearLayout aj;
    private ImageView ak;
    private TextView al;
    private TextView am;

    public bd(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.G = -1;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.K = null;
        this.M = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ac = null;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.ai = null;
        this.aj = null;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.I = baseFragmentActivity;
        View q = baseFragment.q();
        this.K = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_host, (ViewGroup) null);
        this.H = (LinearLayout) this.K.findViewById(R.id.host);
        this.L = (LinearLayout) this.K.findViewById(R.id.box_btns);
        this.M = (LinearLayout) this.K.findViewById(R.id.btn_edit_profile);
        this.N = (TextView) this.K.findViewById(R.id.btn_account_exception);
        this.Q = (LinearLayout) this.K.findViewById(R.id.sudoku_buttons_host);
        this.K.removeView(this.L);
        this.K.removeView(this.Q);
        this.C.addView(this.L);
        this.m.addView(this.Q);
        this.O = (ImageView) q.findViewById(R.id.edit_icon);
        this.P = (TextView) q.findViewById(R.id.edit_text);
        this.G = TiebaApplication.g().ap();
        this.R = (LinearLayout) q.findViewById(R.id.place_holder1);
        this.S = (LinearLayout) q.findViewById(R.id.my_bookmark);
        this.T = (ImageView) q.findViewById(R.id.my_bookmark_image);
        this.U = (TextView) q.findViewById(R.id.my_bookmark_text);
        this.V = (ImageView) q.findViewById(R.id.new_bookmark_mention);
        this.J = UtilHelper.a((Context) baseFragmentActivity);
        a(this.V, UtilHelper.a(baseFragmentActivity, (int) this.I.getResources().getDimension(R.dimen.person_bookmark_icon_margin_top)), UtilHelper.a(baseFragmentActivity, (int) this.I.getResources().getDimension(R.dimen.person_bookmark_icon_margin_right)));
        this.W = (LinearLayout) q.findViewById(R.id.my_forums);
        this.X = (ImageView) q.findViewById(R.id.my_forums_image);
        this.Y = (TextView) q.findViewById(R.id.my_forums_text);
        this.Z = (TextView) q.findViewById(R.id.my_forums_num);
        this.aa = (LinearLayout) q.findViewById(R.id.my_attention);
        this.ab = (ImageView) q.findViewById(R.id.my_attention_image);
        this.ac = (TextView) q.findViewById(R.id.my_attention_text);
        this.ad = (TextView) q.findViewById(R.id.my_attention_num);
        this.ae = (LinearLayout) q.findViewById(R.id.my_fans);
        this.af = (ImageView) q.findViewById(R.id.my_fans_image);
        this.ag = (TextView) q.findViewById(R.id.my_fans_text);
        this.ah = (TextView) q.findViewById(R.id.my_fans_num);
        this.ai = (TextView) q.findViewById(R.id.new_fans_mention);
        a(this.ai, UtilHelper.a(baseFragmentActivity, (int) this.I.getResources().getDimension(R.dimen.person_fans_icon_margin_top)), UtilHelper.a(baseFragmentActivity, (int) this.I.getResources().getDimension(R.dimen.person_fans_icon_margin_right)));
        this.aj = (LinearLayout) q.findViewById(R.id.my_post);
        this.ak = (ImageView) q.findViewById(R.id.my_post_image);
        this.al = (TextView) q.findViewById(R.id.my_post_text);
        this.am = (TextView) q.findViewById(R.id.my_post_num);
        this.S.setOnClickListener(baseFragment);
        this.W.setOnClickListener(baseFragment);
        this.aa.setOnClickListener(baseFragment);
        this.ae.setOnClickListener(baseFragment);
        this.aj.setOnClickListener(baseFragment);
        this.M.setOnClickListener(baseFragment);
        this.N.setOnClickListener(baseFragment);
        d(bxVar);
    }

    private void a(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.person.be
    public void a(bx bxVar) {
        super.a(bxVar);
        this.A = bxVar.b();
        if (this.A != null && this.A.length() > 0) {
            this.j.setText(R.string.person_info);
            if (bxVar.j()) {
                this.f.setVisibility(4);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
            } else if (bxVar.k()) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
            } else {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(8);
            }
        }
    }

    public void a(boolean z, bx bxVar, int i) {
        this.u.setVisibility(8);
        if (z) {
            d(bxVar);
            f(bxVar);
        }
        if (i == 1) {
            this.k.c();
            if (bxVar.getErrorString() != null) {
                this.f2235a.a(bxVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.be
    public void c(bx bxVar) {
        super.c(bxVar);
        AntiData a2 = bxVar.a();
        if (AntiHelper.a(a2) || AntiHelper.c(a2)) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.person.be
    public void b(bx bxVar) {
        super.b(bxVar);
        this.R.setVisibility(4);
        this.A = bxVar.b();
        if (this.A != null && this.A.length() > 0) {
            this.B = bxVar.d();
            b(this.G, bxVar);
            if (this.B != null && this.B.getLike_bars() > 0) {
                this.Z.setVisibility(0);
                this.Z.setText(String.valueOf(this.B.getLike_bars()));
            } else {
                this.Z.setVisibility(4);
            }
            if (this.B != null && this.B.getConcern_num() > 0) {
                this.ad.setVisibility(0);
                this.ad.setText(String.valueOf(this.B.getConcern_num()));
            } else {
                this.ad.setVisibility(4);
            }
            if (this.B != null && this.B.getPosts_num() > 0) {
                this.am.setVisibility(0);
                this.am.setText(String.valueOf(this.B.getPosts_num()));
            } else {
                this.am.setVisibility(4);
            }
            if (this.B != null && this.B.getFans_num() > 0) {
                this.ah.setVisibility(0);
                this.ah.setText(String.valueOf(this.B.getFans_num()));
                return;
            }
            this.ah.setVisibility(4);
        }
    }

    private void a(View view, int i, int i2, int i3) {
        if (i == 1) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundResource(i3);
        }
    }

    private void b(int i, bx bxVar) {
        long h = bxVar.h();
        long i2 = bxVar.i();
        if (h > 0) {
            this.ai.setVisibility(0);
            if (h <= 9) {
                a(this.ai, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
                a(this.ai, UtilHelper.a((Context) this.I, 9.0f), (this.J / 6) - UtilHelper.a((Context) this.I, 28.0f));
                this.ai.setText(String.valueOf(h));
            } else if (h > 9 && h <= 99) {
                a(this.ai, i, R.drawable.icon_news_head_prompt_1, R.drawable.icon_news_head_prompt);
                this.ai.setText(String.valueOf(h));
            } else if (h > 99) {
                a(this.ai, i, R.drawable.icon_news_head_prompt_more_1, R.drawable.icon_news_head_prompt_more);
            }
        } else {
            this.ai.setVisibility(8);
        }
        if (i2 > 0) {
            a(this.V, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
            this.V.setVisibility(0);
            return;
        }
        this.V.setVisibility(8);
    }

    @Override // com.baidu.tieba.person.be
    public void a(int i, bx bxVar) {
        super.a(i, bxVar);
        a(this.ai, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
        a(this.V, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
        if (i == 1) {
            this.M.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
        } else {
            this.M.setBackgroundResource(R.drawable.btn_white_bg_selector);
        }
    }

    public LinearLayout e() {
        return this.S;
    }

    public LinearLayout f() {
        return this.W;
    }

    public LinearLayout g() {
        return this.aa;
    }

    public LinearLayout h() {
        return this.ae;
    }

    public LinearLayout i() {
        return this.aj;
    }

    public LinearLayout j() {
        return this.M;
    }

    public TextView k() {
        return this.N;
    }
}
