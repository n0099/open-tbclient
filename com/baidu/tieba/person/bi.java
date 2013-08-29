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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bi extends bj {
    private int D;
    private Context E;
    private int F;
    private ViewGroup G;
    private LinearLayout H;
    private ImageView I;
    private TextView J;
    private LinearLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private ImageView N;
    private TextView O;
    private ImageView P;
    private LinearLayout Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private LinearLayout U;
    private ImageView V;
    private TextView W;
    private TextView X;
    private LinearLayout Y;
    private ImageView Z;
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private LinearLayout ad;
    private ImageView ae;
    private TextView af;
    private TextView ag;

    public bi(PersonInfoActivity personInfoActivity, com.baidu.tieba.model.bm bmVar) {
        super(personInfoActivity, bmVar);
        this.D = -1;
        this.E = null;
        this.F = 0;
        this.G = null;
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
        this.E = personInfoActivity;
        this.G = (ViewGroup) LayoutInflater.from(personInfoActivity).inflate(R.layout.person_info_activity_host, (ViewGroup) null);
        this.H = (LinearLayout) this.G.findViewById(R.id.btn_edit_profile);
        this.K = (LinearLayout) this.G.findViewById(R.id.sudoku_buttons_host);
        this.G.removeView(this.H);
        this.G.removeView(this.K);
        this.B.addView(this.H);
        this.C.addView(this.K);
        this.I = (ImageView) personInfoActivity.findViewById(R.id.edit_icon);
        this.J = (TextView) personInfoActivity.findViewById(R.id.edit_text);
        this.D = TiebaApplication.g().an();
        this.L = (LinearLayout) personInfoActivity.findViewById(R.id.place_holder1);
        this.M = (LinearLayout) personInfoActivity.findViewById(R.id.my_bookmark);
        this.N = (ImageView) personInfoActivity.findViewById(R.id.my_bookmark_image);
        this.O = (TextView) personInfoActivity.findViewById(R.id.my_bookmark_text);
        this.P = (ImageView) personInfoActivity.findViewById(R.id.new_bookmark_mention);
        this.F = UtilHelper.a((Context) personInfoActivity);
        a(this.P, UtilHelper.a((Context) personInfoActivity, 14.0f), (this.F / 6) - UtilHelper.a((Context) personInfoActivity, 23.0f));
        this.Q = (LinearLayout) personInfoActivity.findViewById(R.id.my_forums);
        this.R = (ImageView) personInfoActivity.findViewById(R.id.my_forums_image);
        this.S = (TextView) personInfoActivity.findViewById(R.id.my_forums_text);
        this.T = (TextView) personInfoActivity.findViewById(R.id.my_forums_num);
        this.U = (LinearLayout) personInfoActivity.findViewById(R.id.my_attention);
        this.V = (ImageView) personInfoActivity.findViewById(R.id.my_attention_image);
        this.W = (TextView) personInfoActivity.findViewById(R.id.my_attention_text);
        this.X = (TextView) personInfoActivity.findViewById(R.id.my_attention_num);
        this.Y = (LinearLayout) personInfoActivity.findViewById(R.id.my_fans);
        this.Z = (ImageView) personInfoActivity.findViewById(R.id.my_fans_image);
        this.aa = (TextView) personInfoActivity.findViewById(R.id.my_fans_text);
        this.ab = (TextView) personInfoActivity.findViewById(R.id.my_fans_num);
        this.ac = (TextView) personInfoActivity.findViewById(R.id.new_fans_mention);
        a(this.ac, UtilHelper.a((Context) personInfoActivity, 8.0f), (this.F / 6) - UtilHelper.a((Context) personInfoActivity, 30.0f));
        this.ad = (LinearLayout) personInfoActivity.findViewById(R.id.my_post);
        this.ae = (ImageView) personInfoActivity.findViewById(R.id.my_post_image);
        this.af = (TextView) personInfoActivity.findViewById(R.id.my_post_text);
        this.ag = (TextView) personInfoActivity.findViewById(R.id.my_post_num);
        this.M.setOnClickListener(personInfoActivity);
        this.Q.setOnClickListener(personInfoActivity);
        this.U.setOnClickListener(personInfoActivity);
        this.Y.setOnClickListener(personInfoActivity);
        this.ad.setOnClickListener(personInfoActivity);
        this.H.setOnClickListener(personInfoActivity);
        d(bmVar);
    }

    private void a(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.person.bj
    public void a(com.baidu.tieba.model.bm bmVar) {
        super.a(bmVar);
        this.z = bmVar.a();
        if (this.z != null && this.z.length() > 0) {
            this.h.setText(R.string.person_info);
            if (bmVar.j()) {
                this.c.setVisibility(4);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
            } else if (bmVar.k()) {
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            }
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bm bmVar, int i) {
        this.t.setVisibility(8);
        if (z) {
            d(bmVar);
            g(bmVar);
        }
        if (i == 1) {
            this.i.c();
            if (bmVar.getErrorString() != null) {
                this.b.a(bmVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.bj
    public void b(com.baidu.tieba.model.bm bmVar) {
        super.b(bmVar);
        this.L.setVisibility(4);
        this.z = bmVar.a();
        if (this.z != null && this.z.length() > 0) {
            this.A = bmVar.c();
            b(this.D, bmVar);
            if (this.A != null && this.A.getLike_bars() > 0) {
                this.T.setVisibility(0);
                this.T.setText(String.valueOf(this.A.getLike_bars()));
            } else {
                this.T.setVisibility(4);
            }
            if (this.A != null && this.A.getConcern_num() > 0) {
                this.X.setVisibility(0);
                this.X.setText(String.valueOf(this.A.getConcern_num()));
            } else {
                this.X.setVisibility(4);
            }
            if (this.A != null && this.A.getPosts_num() > 0) {
                this.ag.setVisibility(0);
                this.ag.setText(String.valueOf(this.A.getPosts_num()));
            } else {
                this.ag.setVisibility(4);
            }
            if (this.A != null && this.A.getFans_num() > 0) {
                this.ab.setVisibility(0);
                this.ab.setText(String.valueOf(this.A.getFans_num()));
                return;
            }
            this.ab.setVisibility(4);
        }
    }

    private void a(View view, int i, int i2, int i3) {
        if (i == 1) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundResource(i3);
        }
    }

    private void b(int i, com.baidu.tieba.model.bm bmVar) {
        long h = bmVar.h();
        long i2 = bmVar.i();
        if (h > 0) {
            this.ac.setVisibility(0);
            if (h <= 9) {
                a(this.ac, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
                a(this.ac, UtilHelper.a(this.E, 9.0f), (this.F / 6) - UtilHelper.a(this.E, 28.0f));
                this.ac.setText(String.valueOf(h));
            } else if (h > 9 && h <= 99) {
                a(this.ac, i, R.drawable.icon_news_head_prompt_1, R.drawable.icon_news_head_prompt);
                this.ac.setText(String.valueOf(h));
            } else if (h > 99) {
                a(this.ac, i, R.drawable.icon_news_head_prompt_more_1, R.drawable.icon_news_head_prompt_more);
            }
        } else {
            this.ac.setVisibility(8);
        }
        if (i2 > 0) {
            a(this.P, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
            this.P.setVisibility(0);
            return;
        }
        this.P.setVisibility(8);
    }

    @Override // com.baidu.tieba.person.bj
    public void a(int i, com.baidu.tieba.model.bm bmVar) {
        super.a(i, bmVar);
        a(i, this.O, (TextView) null);
        a(i, this.af, (TextView) null);
        a(this.ac, i, R.drawable.icon_news_prompt_1, R.drawable.icon_news_prompt);
        a(this.P, i, R.drawable.icon_news_content_prompt_1, R.drawable.icon_news_content_prompt);
        if (i == 1) {
            this.H.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
            this.I.setImageResource(R.drawable.btn_icon_edit_1);
            this.J.setTextColor(-11640196);
            this.M.setBackgroundResource(R.drawable.person_button_1);
            this.Q.setBackgroundResource(R.drawable.person_button_1);
            this.U.setBackgroundResource(R.drawable.person_button_1);
            this.Y.setBackgroundResource(R.drawable.person_button_1);
            this.ad.setBackgroundResource(R.drawable.person_button_1);
            this.N.setImageResource(R.drawable.cent_icon_sc_n_1);
            this.R.setImageResource(R.drawable.cent_icon_myba_n_1);
            this.V.setImageResource(R.drawable.cent_icon_gz_n_1);
            this.Z.setImageResource(R.drawable.cent_icon_fs_n_1);
            this.ae.setImageResource(R.drawable.cent_icon_tiezi_n_1);
            this.S.setTextColor(-10523526);
            this.W.setTextColor(-10523526);
            this.O.setTextColor(-10523526);
            this.af.setTextColor(-10523526);
            this.aa.setTextColor(-10523526);
            this.T.setTextColor(-8352873);
            this.ab.setTextColor(-8352873);
            this.X.setTextColor(-8352873);
            this.ag.setTextColor(-8352873);
            return;
        }
        this.H.setBackgroundResource(R.drawable.btn_white_bg_selector);
        this.I.setImageResource(R.drawable.btn_icon_edit);
        this.J.setTextColor(-9207399);
        this.M.setBackgroundResource(R.drawable.person_button);
        this.Q.setBackgroundResource(R.drawable.person_button);
        this.U.setBackgroundResource(R.drawable.person_button);
        this.Y.setBackgroundResource(R.drawable.person_button);
        this.ad.setBackgroundResource(R.drawable.person_button);
        this.N.setImageResource(R.drawable.cent_icon_sc_n);
        this.R.setImageResource(R.drawable.cent_icon_myba_n);
        this.V.setImageResource(R.drawable.cent_icon_gz_n);
        this.Z.setImageResource(R.drawable.cent_icon_fs_n);
        this.ae.setImageResource(R.drawable.cent_icon_tiezi_n);
        this.S.setTextColor(-12564913);
        this.W.setTextColor(-12564913);
        this.O.setTextColor(-12564913);
        this.af.setTextColor(-12564913);
        this.aa.setTextColor(-12564913);
        this.T.setTextColor(-6576974);
        this.ab.setTextColor(-6576974);
        this.X.setTextColor(-6576974);
        this.ag.setTextColor(-6576974);
    }

    @Override // com.baidu.tieba.person.bj
    public void b() {
        super.b();
        this.M.setBackgroundResource(0);
        this.Q.setBackgroundResource(0);
        this.U.setBackgroundResource(0);
        this.Y.setBackgroundResource(0);
        this.ad.setBackgroundResource(0);
        this.N.setImageResource(0);
        this.R.setImageResource(0);
        this.V.setImageResource(0);
        this.Z.setImageResource(0);
        this.ae.setImageResource(0);
    }

    public LinearLayout d() {
        return this.M;
    }

    public LinearLayout e() {
        return this.Q;
    }

    public LinearLayout f() {
        return this.U;
    }

    public LinearLayout g() {
        return this.Y;
    }

    public LinearLayout h() {
        return this.ad;
    }

    public LinearLayout i() {
        return this.H;
    }
}
