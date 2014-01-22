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
public class bt extends bu {
    private int I;
    private BaseFragmentActivity J;
    private ViewGroup K;
    private LinearLayout L;
    private LinearLayout M;
    private TextView N;
    private LinearLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private ImageView S;
    private TextView T;
    private LinearLayout U;
    private ImageView V;
    private TextView W;
    private LinearLayout X;
    private ImageView Y;
    private TextView Z;
    private TextView aa;
    private LinearLayout ab;
    private ImageView ac;
    private TextView ad;
    private cg ae;

    public bt(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, com.baidu.tieba.model.bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.I = -1;
        this.J = null;
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
        this.J = baseFragmentActivity;
        View q = baseFragment.q();
        this.K = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_host, (ViewGroup) null);
        this.L = (LinearLayout) this.K.findViewById(R.id.box_btns);
        this.M = (LinearLayout) this.K.findViewById(R.id.btn_edit_profile);
        this.N = (TextView) this.K.findViewById(R.id.btn_account_exception);
        this.O = (LinearLayout) this.K.findViewById(R.id.sudoku_buttons_host);
        this.K.removeView(this.L);
        this.K.removeView(this.O);
        this.D.addView(this.L);
        this.n.addView(this.O);
        this.I = TiebaApplication.h().al();
        this.P = (LinearLayout) q.findViewById(R.id.place_holder1);
        this.Q = (LinearLayout) q.findViewById(R.id.place_holder2);
        this.J.getResources().getDimensionPixelSize(R.dimen.person_bookmark_icon_margin_top);
        this.J.getResources().getDimensionPixelSize(R.dimen.person_bookmark_icon_margin_right);
        this.R = (LinearLayout) q.findViewById(R.id.my_forums);
        this.S = (ImageView) q.findViewById(R.id.my_forums_image);
        this.T = (TextView) q.findViewById(R.id.my_forums_num);
        this.U = (LinearLayout) q.findViewById(R.id.my_attention);
        this.V = (ImageView) q.findViewById(R.id.my_attention_image);
        this.W = (TextView) q.findViewById(R.id.my_attention_num);
        this.X = (LinearLayout) q.findViewById(R.id.my_fans);
        this.Y = (ImageView) q.findViewById(R.id.my_fans_image);
        this.Z = (TextView) q.findViewById(R.id.my_fans_num);
        this.aa = (TextView) q.findViewById(R.id.new_fans_mention);
        a(this.aa, this.J.getResources().getDimensionPixelSize(R.dimen.person_fans_icon_margin_top), this.J.getResources().getDimensionPixelSize(R.dimen.person_fans_icon_margin_right));
        this.ab = (LinearLayout) q.findViewById(R.id.my_post);
        this.ac = (ImageView) q.findViewById(R.id.my_post_image);
        this.ad = (TextView) q.findViewById(R.id.my_post_num);
        this.R.setOnClickListener(baseFragment);
        this.U.setOnClickListener(baseFragment);
        this.X.setOnClickListener(baseFragment);
        this.ab.setOnClickListener(baseFragment);
        this.M.setOnClickListener(baseFragment);
        this.N.setOnClickListener(baseFragment);
        e(bxVar);
    }

    private void a(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.person.bu
    public void a(com.baidu.tieba.model.bx bxVar) {
        super.a(bxVar);
        this.B = bxVar.b();
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        if (this.B != null && this.B.length() > 0) {
            this.k.setText(R.string.my_home_page);
            if (bxVar.i()) {
                this.f.setVisibility(4);
            } else if (bxVar.j()) {
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

    @Override // com.baidu.tieba.person.bu
    public void c(com.baidu.tieba.model.bx bxVar) {
        this.C = bxVar.d();
        if (this.C == null) {
            this.v.setVisibility(0);
        }
    }

    public void e() {
        if (!cg.a()) {
            if (this.ae == null) {
                this.ae = new cg(this.a);
            }
            if (!this.c.p()) {
                this.ae.a(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.person.bu
    public void d(com.baidu.tieba.model.bx bxVar) {
        super.d(bxVar);
        AntiData a = bxVar.a();
        if (AntiHelper.a(a) || AntiHelper.c(a)) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.person.bu
    public void b(com.baidu.tieba.model.bx bxVar) {
        super.b(bxVar);
        this.P.setVisibility(4);
        this.Q.setVisibility(4);
        this.B = bxVar.b();
        if (this.B != null && this.B.length() > 0) {
            this.C = bxVar.d();
            b(this.I, bxVar);
            if (this.C != null && this.C.getLike_bars() > 0) {
                this.T.setVisibility(0);
                this.T.setText(String.valueOf(this.C.getLike_bars()));
            } else {
                this.T.setVisibility(4);
            }
            if (this.C != null && this.C.getConcern_num() > 0) {
                this.W.setVisibility(0);
                this.W.setText(String.valueOf(this.C.getConcern_num()));
            } else {
                this.W.setVisibility(4);
            }
            if (this.C != null && this.C.getPosts_num() > 0) {
                this.ad.setVisibility(0);
                this.ad.setText(String.valueOf(this.C.getPosts_num()));
            } else {
                this.ad.setVisibility(4);
            }
            if (this.C != null && this.C.getFans_num() > 0) {
                this.Z.setVisibility(0);
                this.Z.setText(String.valueOf(this.C.getFans_num()));
                return;
            }
            this.Z.setVisibility(4);
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
        int al = TiebaApplication.h().al();
        long h = bxVar.h();
        if (h > 0) {
            this.aa.setVisibility(0);
            if (h <= 9) {
                a(this.aa, al, R.drawable.icon_news_head_prompt_one_1, R.drawable.icon_news_head_prompt_one);
                this.aa.setText(String.valueOf(h));
                return;
            } else if (h > 9 && h <= 99) {
                a(this.aa, al, R.drawable.icon_news_head_prompt_two_1, R.drawable.icon_news_head_prompt_two);
                this.aa.setText(String.valueOf(h));
                return;
            } else if (h > 99) {
                a(this.aa, al, R.drawable.icon_news_head_prompt_more_1, R.drawable.icon_news_head_prompt_more);
                return;
            } else {
                return;
            }
        }
        this.aa.setVisibility(8);
    }

    @Override // com.baidu.tieba.person.bu
    public void a(int i, com.baidu.tieba.model.bx bxVar) {
        super.a(i, bxVar);
        b(i, bxVar);
        if (i == 1) {
            this.M.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
        } else {
            this.M.setBackgroundResource(R.drawable.btn_white_bg_selector);
        }
    }

    public LinearLayout f() {
        return this.R;
    }

    public LinearLayout g() {
        return this.U;
    }

    public LinearLayout h() {
        return this.X;
    }

    public LinearLayout i() {
        return this.ab;
    }

    public LinearLayout j() {
        return this.M;
    }

    public TextView k() {
        return this.N;
    }

    public TextView l() {
        return this.i;
    }
}
