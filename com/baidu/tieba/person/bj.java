package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bj extends bk {
    private int D;
    private LinearLayout E;
    private Context F;
    private int G;
    private ViewGroup H;
    private LinearLayout I;
    private ImageView J;
    private TextView K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private ImageView O;
    private TextView P;
    private ImageView Q;
    private LinearLayout R;
    private ImageView S;
    private TextView T;
    private TextView U;
    private LinearLayout V;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private LinearLayout Z;
    private ImageView aa;
    private TextView ab;
    private TextView ac;
    private TextView ad;
    private LinearLayout ae;
    private ImageView af;
    private TextView ag;
    private TextView ah;

    public bj(PersonInfoActivity personInfoActivity, bw bwVar) {
        super(personInfoActivity, bwVar);
        this.D = -1;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
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
        this.F = personInfoActivity;
        this.H = (ViewGroup) LayoutInflater.from(personInfoActivity).inflate(R.layout.person_info_activity_host, (ViewGroup) null);
        this.E = (LinearLayout) this.H.findViewById(R.id.host);
        this.I = (LinearLayout) this.H.findViewById(R.id.btn_edit_profile);
        this.L = (LinearLayout) this.H.findViewById(R.id.sudoku_buttons_host);
        this.H.removeView(this.I);
        this.H.removeView(this.L);
        this.B.addView(this.I);
        this.C.addView(this.L);
        this.J = (ImageView) personInfoActivity.findViewById(R.id.edit_icon);
        this.K = (TextView) personInfoActivity.findViewById(R.id.edit_text);
        this.D = TiebaApplication.g().as();
        this.M = (LinearLayout) personInfoActivity.findViewById(R.id.place_holder1);
        this.N = (LinearLayout) personInfoActivity.findViewById(R.id.my_bookmark);
        this.O = (ImageView) personInfoActivity.findViewById(R.id.my_bookmark_image);
        this.P = (TextView) personInfoActivity.findViewById(R.id.my_bookmark_text);
        this.Q = (ImageView) personInfoActivity.findViewById(R.id.new_bookmark_mention);
        this.G = UtilHelper.a((Context) personInfoActivity);
        a(this.Q, UtilHelper.a((Context) personInfoActivity, 14.0f), (this.G / 6) - UtilHelper.a((Context) personInfoActivity, 23.0f));
        this.R = (LinearLayout) personInfoActivity.findViewById(R.id.my_forums);
        this.S = (ImageView) personInfoActivity.findViewById(R.id.my_forums_image);
        this.T = (TextView) personInfoActivity.findViewById(R.id.my_forums_text);
        this.U = (TextView) personInfoActivity.findViewById(R.id.my_forums_num);
        this.V = (LinearLayout) personInfoActivity.findViewById(R.id.my_attention);
        this.W = (ImageView) personInfoActivity.findViewById(R.id.my_attention_image);
        this.X = (TextView) personInfoActivity.findViewById(R.id.my_attention_text);
        this.Y = (TextView) personInfoActivity.findViewById(R.id.my_attention_num);
        this.Z = (LinearLayout) personInfoActivity.findViewById(R.id.my_fans);
        this.aa = (ImageView) personInfoActivity.findViewById(R.id.my_fans_image);
        this.ab = (TextView) personInfoActivity.findViewById(R.id.my_fans_text);
        this.ac = (TextView) personInfoActivity.findViewById(R.id.my_fans_num);
        this.ad = (TextView) personInfoActivity.findViewById(R.id.new_fans_mention);
        a(this.ad, UtilHelper.a((Context) personInfoActivity, 8.0f), (this.G / 6) - UtilHelper.a((Context) personInfoActivity, 30.0f));
        this.ae = (LinearLayout) personInfoActivity.findViewById(R.id.my_post);
        this.af = (ImageView) personInfoActivity.findViewById(R.id.my_post_image);
        this.ag = (TextView) personInfoActivity.findViewById(R.id.my_post_text);
        this.ah = (TextView) personInfoActivity.findViewById(R.id.my_post_num);
        this.N.setOnClickListener(personInfoActivity);
        this.R.setOnClickListener(personInfoActivity);
        this.V.setOnClickListener(personInfoActivity);
        this.Z.setOnClickListener(personInfoActivity);
        this.ae.setOnClickListener(personInfoActivity);
        this.I.setOnClickListener(personInfoActivity);
        d(bwVar);
    }

    private void a(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.person.bk
    public void a(bw bwVar) {
        super.a(bwVar);
        this.z = bwVar.a();
        if (this.z != null && this.z.length() > 0) {
            this.h.setText(R.string.person_info);
            if (bwVar.i()) {
                this.d.setVisibility(4);
                this.e.setVisibility(8);
                this.f.setVisibility(0);
            } else if (bwVar.j()) {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.f.setVisibility(0);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(0);
                this.f.setVisibility(8);
            }
        }
    }

    public void a(boolean z, bw bwVar, int i) {
        this.t.setVisibility(8);
        if (z) {
            d(bwVar);
            g(bwVar);
        }
        if (i == 1) {
            this.i.c();
            if (bwVar.getErrorString() != null) {
                this.f2199a.a(bwVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.bk
    public void b(bw bwVar) {
        super.b(bwVar);
        this.M.setVisibility(4);
        this.z = bwVar.a();
        if (this.z != null && this.z.length() > 0) {
            this.A = bwVar.c();
            b(this.D, bwVar);
            if (this.A != null && this.A.getLike_bars() > 0) {
                this.U.setVisibility(0);
                this.U.setText(String.valueOf(this.A.getLike_bars()));
            } else {
                this.U.setVisibility(4);
            }
            if (this.A != null && this.A.getConcern_num() > 0) {
                this.Y.setVisibility(0);
                this.Y.setText(String.valueOf(this.A.getConcern_num()));
            } else {
                this.Y.setVisibility(4);
            }
            if (this.A != null && this.A.getPosts_num() > 0) {
                this.ah.setVisibility(0);
                this.ah.setText(String.valueOf(this.A.getPosts_num()));
            } else {
                this.ah.setVisibility(4);
            }
            if (this.A != null && this.A.getFans_num() > 0) {
                this.ac.setVisibility(0);
                this.ac.setText(String.valueOf(this.A.getFans_num()));
                return;
            }
            this.ac.setVisibility(4);
        }
    }

    private void a(View view, int i, int i2, int i3) {
        if (i == 1) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundResource(i3);
        }
    }

    private void b(int i, bw bwVar) {
        long g = bwVar.g();
        long h = bwVar.h();
        if (g > 0) {
            this.ad.setVisibility(0);
            if (g <= 9) {
                a(this.ad, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
                a(this.ad, UtilHelper.a(this.F, 9.0f), (this.G / 6) - UtilHelper.a(this.F, 28.0f));
                this.ad.setText(String.valueOf(g));
            } else if (g > 9 && g <= 99) {
                a(this.ad, i, R.drawable.icon_news_head_prompt_1, R.drawable.icon_news_head_prompt);
                this.ad.setText(String.valueOf(g));
            } else if (g > 99) {
                a(this.ad, i, R.drawable.icon_news_head_prompt_more_1, R.drawable.icon_news_head_prompt_more);
            }
        } else {
            this.ad.setVisibility(8);
        }
        if (h > 0) {
            a(this.Q, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
            this.Q.setVisibility(0);
            return;
        }
        this.Q.setVisibility(8);
    }

    @Override // com.baidu.tieba.person.bk
    public void a(int i, bw bwVar) {
        super.a(i, bwVar);
        a(this.ad, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
        a(this.Q, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
        if (i == 1) {
            this.I.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
        } else {
            this.I.setBackgroundResource(R.drawable.btn_white_bg_selector);
        }
    }

    @Override // com.baidu.tieba.person.bk
    public void a() {
        super.a();
        this.N.setBackgroundDrawable(null);
        this.R.setBackgroundDrawable(null);
        this.V.setBackgroundDrawable(null);
        this.Z.setBackgroundDrawable(null);
        this.ae.setBackgroundDrawable(null);
        this.O.setImageDrawable(null);
        this.S.setImageDrawable(null);
        this.W.setImageDrawable(null);
        this.aa.setImageDrawable(null);
        this.af.setImageDrawable(null);
    }

    public LinearLayout f() {
        return this.N;
    }

    public LinearLayout g() {
        return this.R;
    }

    public LinearLayout h() {
        return this.V;
    }

    public LinearLayout i() {
        return this.Z;
    }

    public LinearLayout j() {
        return this.ae;
    }

    public LinearLayout k() {
        return this.I;
    }
}
