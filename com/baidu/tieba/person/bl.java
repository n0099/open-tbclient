package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bl extends bn {
    private int H;
    private int I;
    private ViewGroup J;
    private LinearLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private ImageView N;
    private TextView O;
    private LinearLayout P;
    private ImageView Q;
    private TextView R;
    private LinearLayout S;
    private ImageView T;
    private TextView U;
    private TextView V;
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
    private LinearLayout ai;
    private LinearLayout aj;

    public bl(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, com.baidu.tieba.model.bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.H = -1;
        this.I = 0;
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
        this.ai = null;
        this.aj = null;
        View q = baseFragment.q();
        this.J = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_guest, (ViewGroup) null);
        this.K = (LinearLayout) this.J.findViewById(R.id.guest_operation_btns);
        this.L = (LinearLayout) this.J.findViewById(R.id.sudoku_buttons_guest);
        this.J.removeView(this.K);
        this.J.removeView(this.L);
        this.D.addView(this.K);
        this.n.addView(this.L);
        this.M = (LinearLayout) q.findViewById(R.id.guest_btn_attention);
        this.O = (TextView) q.findViewById(R.id.btn_attention_text);
        this.N = (ImageView) q.findViewById(R.id.btn_attention_icon);
        this.P = (LinearLayout) q.findViewById(R.id.guest_btn_send_message);
        this.R = (TextView) q.findViewById(R.id.btn_send_message_text);
        this.Q = (ImageView) q.findViewById(R.id.btn_send_message_icon);
        this.H = TiebaApplication.h().an();
        this.S = (LinearLayout) q.findViewById(R.id.guest_forums);
        this.T = (ImageView) q.findViewById(R.id.guest_forums_image);
        this.U = (TextView) q.findViewById(R.id.guest_forums_text);
        this.V = (TextView) q.findViewById(R.id.guest_forums_num);
        this.ae = (LinearLayout) q.findViewById(R.id.guest_posts);
        this.af = (ImageView) q.findViewById(R.id.guest_posts_image);
        this.ag = (TextView) q.findViewById(R.id.guest_posts_text);
        this.ah = (TextView) q.findViewById(R.id.guest_posts_num);
        this.W = (LinearLayout) q.findViewById(R.id.guest_attention);
        this.X = (ImageView) q.findViewById(R.id.guest_attention_image);
        this.Y = (TextView) q.findViewById(R.id.guest_attention_text);
        this.Z = (TextView) q.findViewById(R.id.guest_attention_num);
        this.aa = (LinearLayout) q.findViewById(R.id.guest_fans);
        this.ab = (ImageView) q.findViewById(R.id.guest_fans_image);
        this.ac = (TextView) q.findViewById(R.id.guest_fans_text);
        this.ad = (TextView) q.findViewById(R.id.guest_fans_num);
        this.ai = (LinearLayout) q.findViewById(R.id.place_holder1);
        this.aj = (LinearLayout) q.findViewById(R.id.place_holder2);
        this.S.setOnClickListener(baseFragment);
        this.ae.setOnClickListener(baseFragment);
        this.W.setOnClickListener(baseFragment);
        this.aa.setOnClickListener(baseFragment);
        this.M.setOnClickListener(baseFragment);
        this.P.setOnClickListener(baseFragment);
        e(bxVar);
        g(bxVar);
    }

    @Override // com.baidu.tieba.person.bn
    public void a(com.baidu.tieba.model.bx bxVar) {
        super.a(bxVar);
        this.C = bxVar.d();
        if (this.C == null) {
            this.k.setText(bxVar.g());
        } else {
            this.k.setText(this.C.getName_show());
        }
        this.f.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(8);
    }

    public void a(boolean z, com.baidu.tieba.model.bx bxVar, int i) {
        this.v.setVisibility(8);
        if (z) {
            e(bxVar);
            g(bxVar);
            f(bxVar);
        }
        if (i == 1) {
            this.l.c();
            if (bxVar.getErrorString() != null) {
                this.a.a(bxVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.bn
    public void b(com.baidu.tieba.model.bx bxVar) {
        super.b(bxVar);
        this.B = bxVar.b();
        this.ai.setVisibility(4);
        this.aj.setVisibility(4);
        if (this.B != null && this.B.length() > 0) {
            this.C = bxVar.d();
            if (this.C != null) {
                int sex = this.C.getSex();
                if (sex == 2) {
                    this.U.setText(R.string.her_attention_forums);
                    this.ag.setText(R.string.her_posts);
                    this.Y.setText(R.string.her_attention_people);
                    this.ac.setText(R.string.attention_to_her);
                } else if (sex == 1) {
                    this.U.setText(R.string.his_attention_forums);
                    this.ag.setText(R.string.his_posts);
                    this.Y.setText(R.string.his_attention_people);
                    this.ac.setText(R.string.attention_to_him);
                } else {
                    this.U.setText(R.string.ta_attention_forums);
                    this.ag.setText(R.string.ta_posts);
                    this.Y.setText(R.string.ta_attention_people);
                    this.ac.setText(R.string.attention_to_ta);
                }
            }
            if (this.C != null && this.C.getLike_bars() > 0) {
                this.V.setVisibility(0);
                this.V.setText(String.valueOf(this.C.getLike_bars()));
            } else {
                this.V.setVisibility(4);
            }
            if (this.C != null && this.C.getConcern_num() > 0) {
                this.Z.setVisibility(0);
                this.Z.setText(String.valueOf(this.C.getConcern_num()));
            } else {
                this.Z.setVisibility(4);
            }
            if (this.C != null && this.C.getPosts_num() > 0) {
                this.ah.setVisibility(0);
                this.ah.setText(String.valueOf(this.C.getPosts_num()));
            } else {
                this.ah.setVisibility(4);
            }
            if (this.C != null && this.C.getFans_num() > 0) {
                this.ad.setVisibility(0);
                this.ad.setText(String.valueOf(this.C.getFans_num()));
                return;
            }
            this.ad.setVisibility(4);
        }
    }

    public void a_(com.baidu.tieba.model.bx bxVar) {
        if (bxVar.d() != null) {
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bx bxVar) {
        if (z) {
            this.a.a(this.a.getString(R.string.success));
            g(bxVar);
        } else if (bxVar.getErrorString() != null) {
            this.a.a(bxVar.getErrorString());
        }
    }

    private void g(com.baidu.tieba.model.bx bxVar) {
        this.M.setVisibility(8);
        this.C = bxVar.d();
        this.B = bxVar.b();
        if (this.B != null && this.B.length() > 0 && this.C != null) {
            this.M.setVisibility(0);
            this.I = this.C.getHave_attention();
            h(bxVar);
        }
    }

    private void h(com.baidu.tieba.model.bx bxVar) {
        this.H = TiebaApplication.h().an();
        if (this.I == 1) {
            this.O.setText(R.string.attention_cancel);
            this.N.setImageDrawable(null);
            this.N.setVisibility(4);
            if (this.H == 1) {
                this.M.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
                this.O.setTextColor(this.b.getResources().getColor(R.color.person_edit));
                return;
            }
            this.M.setBackgroundResource(R.drawable.btn_white_bg_selector);
            this.O.setTextColor(this.b.getResources().getColor(R.color.person_edit_1));
            return;
        }
        this.O.setText(R.string.attention);
        if (this.H == 1) {
            com.baidu.tieba.util.bb.e(this.M, (int) R.drawable.btn_attention_to_bg_night_selector);
            this.N.setVisibility(0);
            this.N.setImageResource(R.drawable.btn_icon_follow_1);
            this.O.setTextColor(this.b.getResources().getColor(R.color.person_attention_1));
            return;
        }
        com.baidu.tieba.util.bb.e(this.M, (int) R.drawable.btn_attention_to_bg_selector);
        this.N.setVisibility(0);
        this.N.setImageResource(R.drawable.btn_icon_follow);
        this.O.setTextColor(this.b.getResources().getColor(R.color.person_attention));
    }

    @Override // com.baidu.tieba.person.bn
    public void a(int i, com.baidu.tieba.model.bx bxVar) {
        super.a(i, bxVar);
        h(bxVar);
        if (i == 1) {
            com.baidu.tieba.util.bb.e(this.P, (int) R.drawable.btn_send_message_bg_night_selector);
        } else {
            com.baidu.tieba.util.bb.e(this.P, (int) R.drawable.btn_send_message_bg_selector);
        }
    }

    @Override // com.baidu.tieba.person.bn
    public void a() {
        super.a();
    }

    public LinearLayout e() {
        return this.M;
    }

    public LinearLayout f() {
        return this.P;
    }

    public LinearLayout g() {
        return this.S;
    }

    public LinearLayout h() {
        return this.ae;
    }

    public LinearLayout i() {
        return this.W;
    }

    public LinearLayout j() {
        return this.aa;
    }
}
