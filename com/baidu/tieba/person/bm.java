package com.baidu.tieba.person;

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
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bm extends bn {
    private int H;
    private LinearLayout I;
    private BaseFragmentActivity J;
    private int K;
    private ViewGroup L;
    private LinearLayout M;
    private LinearLayout N;
    private TextView O;
    private ImageView P;
    private TextView Q;
    private LinearLayout R;
    private LinearLayout S;
    private LinearLayout T;
    private ImageView U;
    private TextView V;
    private ImageView W;
    private LinearLayout X;
    private ImageView Y;
    private TextView Z;
    private TextView aa;
    private LinearLayout ab;
    private ImageView ac;
    private TextView ad;
    private TextView ae;
    private LinearLayout af;
    private ImageView ag;
    private TextView ah;
    private TextView ai;
    private TextView aj;
    private LinearLayout ak;
    private ImageView al;
    private TextView am;
    private TextView an;
    private bz ao;

    public bm(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, com.baidu.tieba.model.bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.H = -1;
        this.I = null;
        this.J = null;
        this.K = 0;
        this.L = null;
        this.N = null;
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
        this.an = null;
        this.ao = null;
        this.J = baseFragmentActivity;
        View q = baseFragment.q();
        this.L = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_host, (ViewGroup) null);
        this.I = (LinearLayout) this.L.findViewById(R.id.host);
        this.M = (LinearLayout) this.L.findViewById(R.id.box_btns);
        this.N = (LinearLayout) this.L.findViewById(R.id.btn_edit_profile);
        this.O = (TextView) this.L.findViewById(R.id.btn_account_exception);
        this.R = (LinearLayout) this.L.findViewById(R.id.sudoku_buttons_host);
        this.L.removeView(this.M);
        this.L.removeView(this.R);
        this.D.addView(this.M);
        this.n.addView(this.R);
        this.P = (ImageView) q.findViewById(R.id.edit_icon);
        this.Q = (TextView) q.findViewById(R.id.edit_text);
        this.H = TiebaApplication.h().an();
        this.S = (LinearLayout) q.findViewById(R.id.place_holder1);
        this.T = (LinearLayout) q.findViewById(R.id.my_bookmark);
        this.U = (ImageView) q.findViewById(R.id.my_bookmark_image);
        this.V = (TextView) q.findViewById(R.id.my_bookmark_text);
        this.W = (ImageView) q.findViewById(R.id.new_bookmark_mention);
        this.K = com.baidu.adp.lib.h.g.b(baseFragmentActivity);
        a(this.W, this.J.getResources().getDimensionPixelSize(R.dimen.person_bookmark_icon_margin_top), this.J.getResources().getDimensionPixelSize(R.dimen.person_bookmark_icon_margin_right));
        this.X = (LinearLayout) q.findViewById(R.id.my_forums);
        this.Y = (ImageView) q.findViewById(R.id.my_forums_image);
        this.Z = (TextView) q.findViewById(R.id.my_forums_text);
        this.aa = (TextView) q.findViewById(R.id.my_forums_num);
        this.ab = (LinearLayout) q.findViewById(R.id.my_attention);
        this.ac = (ImageView) q.findViewById(R.id.my_attention_image);
        this.ad = (TextView) q.findViewById(R.id.my_attention_text);
        this.ae = (TextView) q.findViewById(R.id.my_attention_num);
        this.af = (LinearLayout) q.findViewById(R.id.my_fans);
        this.ag = (ImageView) q.findViewById(R.id.my_fans_image);
        this.ah = (TextView) q.findViewById(R.id.my_fans_text);
        this.ai = (TextView) q.findViewById(R.id.my_fans_num);
        this.aj = (TextView) q.findViewById(R.id.new_fans_mention);
        a(this.aj, this.J.getResources().getDimensionPixelSize(R.dimen.person_fans_icon_margin_top), this.J.getResources().getDimensionPixelSize(R.dimen.person_fans_icon_margin_right));
        this.ak = (LinearLayout) q.findViewById(R.id.my_post);
        this.al = (ImageView) q.findViewById(R.id.my_post_image);
        this.am = (TextView) q.findViewById(R.id.my_post_text);
        this.an = (TextView) q.findViewById(R.id.my_post_num);
        this.T.setOnClickListener(baseFragment);
        this.X.setOnClickListener(baseFragment);
        this.ab.setOnClickListener(baseFragment);
        this.af.setOnClickListener(baseFragment);
        this.ak.setOnClickListener(baseFragment);
        this.N.setOnClickListener(baseFragment);
        this.O.setOnClickListener(baseFragment);
        e(bxVar);
    }

    private void a(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.person.bn
    public void a(com.baidu.tieba.model.bx bxVar) {
        super.a(bxVar);
        this.B = bxVar.b();
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        if (this.B != null && this.B.length() > 0) {
            this.k.setText(R.string.person_info);
            if (bxVar.j()) {
                this.f.setVisibility(4);
            } else if (bxVar.k()) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(0);
            }
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bx bxVar, int i) {
        this.v.setVisibility(8);
        if (z) {
            e(bxVar);
            f(bxVar);
            if (this.c != null && !this.c.p()) {
                e();
            }
        }
        if (i == 1) {
            this.l.c();
            if (bxVar.getErrorString() != null) {
                this.a.a(bxVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.bn
    public void c(com.baidu.tieba.model.bx bxVar) {
        this.C = bxVar.d();
        if (this.C == null) {
            this.v.setVisibility(0);
        }
        if (bz.a()) {
            this.l.setRefreshing(1);
        }
    }

    public void e() {
        if (!bz.a()) {
            if (this.ao == null) {
                this.ao = new bz(this.a);
            }
            if (!this.c.p()) {
                this.ao.a(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.person.bn
    public void d(com.baidu.tieba.model.bx bxVar) {
        super.d(bxVar);
        AntiData a = bxVar.a();
        if (AntiHelper.a(a) || AntiHelper.c(a)) {
            this.O.setVisibility(0);
        } else {
            this.O.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.person.bn
    public void b(com.baidu.tieba.model.bx bxVar) {
        super.b(bxVar);
        this.S.setVisibility(4);
        this.B = bxVar.b();
        if (this.B != null && this.B.length() > 0) {
            this.C = bxVar.d();
            b(this.H, bxVar);
            if (this.C != null && this.C.getLike_bars() > 0) {
                this.aa.setVisibility(0);
                this.aa.setText(String.valueOf(this.C.getLike_bars()));
            } else {
                this.aa.setVisibility(4);
            }
            if (this.C != null && this.C.getConcern_num() > 0) {
                this.ae.setVisibility(0);
                this.ae.setText(String.valueOf(this.C.getConcern_num()));
            } else {
                this.ae.setVisibility(4);
            }
            if (this.C != null && this.C.getPosts_num() > 0) {
                this.an.setVisibility(0);
                this.an.setText(String.valueOf(this.C.getPosts_num()));
            } else {
                this.an.setVisibility(4);
            }
            if (this.C != null && this.C.getFans_num() > 0) {
                this.ai.setVisibility(0);
                this.ai.setText(String.valueOf(this.C.getFans_num()));
                return;
            }
            this.ai.setVisibility(4);
        }
    }

    private void a(View view, int i, int i2, int i3) {
        if (i == 1) {
            view.setBackgroundResource(i2);
        } else {
            view.setBackgroundResource(i3);
        }
    }

    private void b(int i, com.baidu.tieba.model.bx bxVar) {
        int an = TiebaApplication.h().an();
        long h = bxVar.h();
        long i2 = bxVar.i();
        if (h > 0) {
            this.aj.setVisibility(0);
            if (h <= 9) {
                a(this.aj, an, R.drawable.icon_news_head_prompt_one_1, R.drawable.icon_news_head_prompt_one);
                this.aj.setText(String.valueOf(h));
            } else if (h > 9 && h <= 99) {
                a(this.aj, an, R.drawable.icon_news_head_prompt_two_1, R.drawable.icon_news_head_prompt_two);
                this.aj.setText(String.valueOf(h));
            } else if (h > 99) {
                a(this.aj, an, R.drawable.icon_news_head_prompt_more_1, R.drawable.icon_news_head_prompt_more);
            }
        } else {
            this.aj.setVisibility(8);
        }
        if (i2 > 0) {
            a(this.W, an, R.drawable.icon_news_list_prompt_1, R.drawable.icon_news_list_prompt);
            this.W.setVisibility(0);
            return;
        }
        this.W.setVisibility(8);
    }

    @Override // com.baidu.tieba.person.bn
    public void a(int i, com.baidu.tieba.model.bx bxVar) {
        super.a(i, bxVar);
        b(i, bxVar);
        if (i == 1) {
            this.N.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
        } else {
            this.N.setBackgroundResource(R.drawable.btn_white_bg_selector);
        }
    }

    public LinearLayout f() {
        return this.T;
    }

    public LinearLayout g() {
        return this.X;
    }

    public LinearLayout h() {
        return this.ab;
    }

    public LinearLayout i() {
        return this.af;
    }

    public LinearLayout j() {
        return this.ak;
    }

    public LinearLayout k() {
        return this.N;
    }

    public TextView l() {
        return this.O;
    }
}
