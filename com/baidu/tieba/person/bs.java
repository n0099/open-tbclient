package com.baidu.tieba.person;

import android.graphics.drawable.BitmapDrawable;
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
public class bs extends bu {
    private int I;
    private int J;
    private ViewGroup K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private TextView O;
    private LinearLayout P;
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

    public bs(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, com.baidu.tieba.model.bx bxVar) {
        super(baseFragmentActivity, baseFragment, bxVar);
        this.I = -1;
        this.J = 0;
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
        this.K = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.person_info_activity_guest, (ViewGroup) null);
        this.L = (LinearLayout) this.K.findViewById(R.id.guest_operation_btns);
        this.M = (LinearLayout) this.K.findViewById(R.id.sudoku_buttons_guest);
        this.K.removeView(this.L);
        this.K.removeView(this.M);
        this.D.addView(this.L);
        this.n.addView(this.M);
        this.N = (LinearLayout) q.findViewById(R.id.guest_btn_attention);
        this.O = (TextView) q.findViewById(R.id.guest_btn_attention_text);
        this.P = (LinearLayout) q.findViewById(R.id.guest_btn_send_message);
        this.Q = (TextView) q.findViewById(R.id.guest_btn_send_message_text);
        this.I = TiebaApplication.h().al();
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
        this.N.setOnClickListener(baseFragment);
        this.P.setOnClickListener(baseFragment);
        e(bxVar);
        g(bxVar);
    }

    @Override // com.baidu.tieba.person.bu
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

    @Override // com.baidu.tieba.person.bu
    public void b(com.baidu.tieba.model.bx bxVar) {
        super.b(bxVar);
        this.B = bxVar.b();
        this.ah.setVisibility(4);
        this.ai.setVisibility(4);
        if (this.B != null && this.B.length() > 0) {
            this.C = bxVar.d();
            if (this.C != null) {
                int sex = this.C.getSex();
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
            if (this.C != null && this.C.getLike_bars() > 0) {
                this.U.setVisibility(0);
                this.U.setText(String.valueOf(this.C.getLike_bars()));
            } else {
                this.U.setVisibility(4);
            }
            if (this.C != null && this.C.getConcern_num() > 0) {
                this.Y.setVisibility(0);
                this.Y.setText(String.valueOf(this.C.getConcern_num()));
            } else {
                this.Y.setVisibility(4);
            }
            if (this.C != null && this.C.getPosts_num() > 0) {
                this.ag.setVisibility(0);
                this.ag.setText(String.valueOf(this.C.getPosts_num()));
            } else {
                this.ag.setVisibility(4);
            }
            if (this.C != null && this.C.getFans_num() > 0) {
                this.ac.setVisibility(0);
                this.ac.setText(String.valueOf(this.C.getFans_num()));
                return;
            }
            this.ac.setVisibility(4);
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
        this.N.setVisibility(4);
        this.C = bxVar.d();
        this.B = bxVar.b();
        if (this.B != null && this.B.length() > 0 && this.C != null) {
            this.N.setVisibility(0);
            this.J = this.C.getHave_attention();
            h(bxVar);
        }
    }

    private void h(com.baidu.tieba.model.bx bxVar) {
        BitmapDrawable bitmapDrawable;
        this.I = TiebaApplication.h().al();
        if (this.J == 1) {
            this.O.setText(R.string.attention_cancel);
            this.O.setCompoundDrawables(null, null, null, null);
            if (this.I == 1) {
                this.N.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
                this.O.setTextColor(this.b.getResources().getColor(R.color.person_edit));
                return;
            }
            this.N.setBackgroundResource(R.drawable.btn_white_bg_selector);
            this.O.setTextColor(this.b.getResources().getColor(R.color.person_edit_1));
            return;
        }
        this.O.setText(R.string.attention);
        if (this.I == 1) {
            com.baidu.tieba.util.bs.e(this.N, (int) R.drawable.btn_attention_to_bg_night_selector);
            bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(R.drawable.btn_icon_follow_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.O.setTextColor(this.b.getResources().getColor(R.color.person_attention_1));
        } else {
            com.baidu.tieba.util.bs.e(this.N, (int) R.drawable.btn_attention_to_bg_selector);
            bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(R.drawable.btn_icon_follow);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.O.setTextColor(this.b.getResources().getColor(R.color.person_attention));
        }
        this.O.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    @Override // com.baidu.tieba.person.bu
    public void a(int i, com.baidu.tieba.model.bx bxVar) {
        super.a(i, bxVar);
        h(bxVar);
        if (i == 1) {
            com.baidu.tieba.util.bs.e(this.P, (int) R.drawable.btn_send_message_bg_night_selector);
        } else {
            com.baidu.tieba.util.bs.e(this.P, (int) R.drawable.btn_send_message_bg_selector);
        }
    }

    @Override // com.baidu.tieba.person.bu
    public void a() {
        super.a();
    }

    public LinearLayout e() {
        return this.N;
    }

    public LinearLayout f() {
        return this.P;
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
