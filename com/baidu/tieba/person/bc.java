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
import com.baidu.tieba.model.bx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bc extends be {
    private int G;
    private int H;
    private ViewGroup I;
    private LinearLayout J;
    private LinearLayout K;
    private LinearLayout L;
    private ImageView M;
    private TextView N;
    private LinearLayout O;
    private ImageView P;
    private TextView Q;
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
    private LinearLayout ad;
    private ImageView ae;
    private TextView af;
    private TextView ag;
    private LinearLayout ah;
    private LinearLayout ai;

    public bc(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.G = -1;
        this.H = 0;
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
        this.ai = null;
        View q = baseFragment.q();
        this.I = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_guest, (ViewGroup) null);
        this.J = (LinearLayout) this.I.findViewById(R.id.guest_operation_btns);
        this.K = (LinearLayout) this.I.findViewById(R.id.sudoku_buttons_guest);
        this.I.removeView(this.J);
        this.I.removeView(this.K);
        this.C.addView(this.J);
        this.m.addView(this.K);
        this.L = (LinearLayout) q.findViewById(R.id.guest_btn_attention);
        this.N = (TextView) q.findViewById(R.id.btn_attention_text);
        this.M = (ImageView) q.findViewById(R.id.btn_attention_icon);
        this.O = (LinearLayout) q.findViewById(R.id.guest_btn_send_message);
        this.Q = (TextView) q.findViewById(R.id.btn_send_message_text);
        this.P = (ImageView) q.findViewById(R.id.btn_send_message_icon);
        this.G = TiebaApplication.g().ap();
        this.R = (LinearLayout) q.findViewById(R.id.guest_forums);
        this.S = (ImageView) q.findViewById(R.id.guest_forums_image);
        this.T = (TextView) q.findViewById(R.id.guest_forums_text);
        this.U = (TextView) q.findViewById(R.id.guest_forums_num);
        this.ad = (LinearLayout) q.findViewById(R.id.guest_posts);
        this.ae = (ImageView) q.findViewById(R.id.guest_posts_image);
        this.af = (TextView) q.findViewById(R.id.guest_posts_text);
        this.ag = (TextView) q.findViewById(R.id.guest_posts_num);
        this.V = (LinearLayout) q.findViewById(R.id.guest_attention);
        this.W = (ImageView) q.findViewById(R.id.guest_attention_image);
        this.X = (TextView) q.findViewById(R.id.guest_attention_text);
        this.Y = (TextView) q.findViewById(R.id.guest_attention_num);
        this.Z = (LinearLayout) q.findViewById(R.id.guest_fans);
        this.aa = (ImageView) q.findViewById(R.id.guest_fans_image);
        this.ab = (TextView) q.findViewById(R.id.guest_fans_text);
        this.ac = (TextView) q.findViewById(R.id.guest_fans_num);
        this.ah = (LinearLayout) q.findViewById(R.id.place_holder1);
        this.ai = (LinearLayout) q.findViewById(R.id.place_holder2);
        this.R.setOnClickListener(baseFragment);
        this.ad.setOnClickListener(baseFragment);
        this.V.setOnClickListener(baseFragment);
        this.Z.setOnClickListener(baseFragment);
        this.L.setOnClickListener(baseFragment);
        this.O.setOnClickListener(baseFragment);
        d(bxVar);
        g(bxVar);
    }

    @Override // com.baidu.tieba.person.be
    public void a(bx bxVar) {
        super.a(bxVar);
        this.B = bxVar.d();
        if (this.B == null) {
            this.j.setText(bxVar.g());
        } else {
            this.j.setText(this.B.getName_show());
        }
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(8);
    }

    public void a(boolean z, bx bxVar, int i) {
        this.u.setVisibility(8);
        if (z) {
            d(bxVar);
            g(bxVar);
            f(bxVar);
        }
        if (i == 1) {
            this.k.c();
            if (bxVar.getErrorString() != null) {
                this.f2220a.a(bxVar.getErrorString());
            }
        }
    }

    @Override // com.baidu.tieba.person.be
    public void b(bx bxVar) {
        super.b(bxVar);
        this.A = bxVar.b();
        this.ah.setVisibility(4);
        this.ai.setVisibility(4);
        if (this.A != null && this.A.length() > 0) {
            this.B = bxVar.d();
            if (this.B != null) {
                int sex = this.B.getSex();
                if (sex == 2) {
                    this.T.setText(R.string.her_attention_forums);
                    this.af.setText(R.string.her_posts);
                    this.X.setText(R.string.her_attention_people);
                    this.ab.setText(R.string.attention_to_her);
                } else if (sex == 1) {
                    this.T.setText(R.string.his_attention_forums);
                    this.af.setText(R.string.his_posts);
                    this.X.setText(R.string.his_attention_people);
                    this.ab.setText(R.string.attention_to_him);
                } else {
                    this.T.setText(R.string.ta_attention_forums);
                    this.af.setText(R.string.ta_posts);
                    this.X.setText(R.string.ta_attention_people);
                    this.ab.setText(R.string.attention_to_ta);
                }
            }
            if (this.B != null && this.B.getLike_bars() > 0) {
                this.U.setVisibility(0);
                this.U.setText(String.valueOf(this.B.getLike_bars()));
            } else {
                this.U.setVisibility(4);
            }
            if (this.B != null && this.B.getConcern_num() > 0) {
                this.Y.setVisibility(0);
                this.Y.setText(String.valueOf(this.B.getConcern_num()));
            } else {
                this.Y.setVisibility(4);
            }
            if (this.B != null && this.B.getPosts_num() > 0) {
                this.ag.setVisibility(0);
                this.ag.setText(String.valueOf(this.B.getPosts_num()));
            } else {
                this.ag.setVisibility(4);
            }
            if (this.B != null && this.B.getFans_num() > 0) {
                this.ac.setVisibility(0);
                this.ac.setText(String.valueOf(this.B.getFans_num()));
                return;
            }
            this.ac.setVisibility(4);
        }
    }

    public void a_(bx bxVar) {
        if (bxVar.d() != null) {
        }
    }

    public void a(boolean z, bx bxVar) {
        if (z) {
            this.f2220a.a(this.f2220a.getString(R.string.success));
            g(bxVar);
        } else if (bxVar.getErrorString() != null) {
            this.f2220a.a(bxVar.getErrorString());
        }
    }

    private void g(bx bxVar) {
        this.L.setVisibility(8);
        this.B = bxVar.d();
        this.A = bxVar.b();
        if (this.A != null && this.A.length() > 0 && this.B != null) {
            this.L.setVisibility(0);
            this.H = this.B.getHave_attention();
            h(bxVar);
        }
    }

    private void h(bx bxVar) {
        this.G = TiebaApplication.g().ap();
        if (this.H == 1) {
            this.N.setText(R.string.attention_cancel);
            this.M.setImageDrawable(null);
            this.M.setVisibility(4);
            if (this.G == 1) {
                this.L.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
                this.N.setTextColor(this.b.getResources().getColor(R.color.person_edit));
                return;
            }
            this.L.setBackgroundResource(R.drawable.btn_white_bg_selector);
            this.N.setTextColor(this.b.getResources().getColor(R.color.person_edit_1));
            return;
        }
        this.N.setText(R.string.attention);
        if (this.G == 1) {
            com.baidu.tieba.util.bd.e(this.L, (int) R.drawable.btn_attention_to_bg_night_selector);
            this.M.setVisibility(0);
            this.M.setImageResource(R.drawable.btn_icon_follow_1);
            this.N.setTextColor(this.b.getResources().getColor(R.color.person_attention_1));
            return;
        }
        com.baidu.tieba.util.bd.e(this.L, (int) R.drawable.btn_attention_to_bg_selector);
        this.M.setVisibility(0);
        this.M.setImageResource(R.drawable.btn_icon_follow);
        this.N.setTextColor(this.b.getResources().getColor(R.color.person_attention));
    }

    @Override // com.baidu.tieba.person.be
    public void a(int i, bx bxVar) {
        super.a(i, bxVar);
        h(bxVar);
        if (i == 1) {
            com.baidu.tieba.util.bd.e(this.O, (int) R.drawable.btn_send_message_bg_night_selector);
        } else {
            com.baidu.tieba.util.bd.e(this.O, (int) R.drawable.btn_send_message_bg_selector);
        }
    }

    @Override // com.baidu.tieba.person.be
    public void a() {
        super.a();
    }

    public LinearLayout e() {
        return this.L;
    }

    public LinearLayout f() {
        return this.O;
    }

    public LinearLayout g() {
        return this.R;
    }

    public LinearLayout h() {
        return this.ad;
    }

    public LinearLayout i() {
        return this.V;
    }

    public LinearLayout j() {
        return this.Z;
    }
}
