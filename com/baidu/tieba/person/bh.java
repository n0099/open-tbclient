package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bh extends bj {
    private int D;
    private int E;
    private ViewGroup F;
    private LinearLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private ImageView J;
    private TextView K;
    private LinearLayout L;
    private ImageView M;
    private TextView N;
    private ProgressBar O;
    private LinearLayout P;
    private ImageView Q;
    private TextView R;
    private TextView S;
    private LinearLayout T;
    private ImageView U;
    private TextView V;
    private TextView W;
    private LinearLayout X;
    private ImageView Y;
    private TextView Z;
    private TextView aa;
    private LinearLayout ab;
    private ImageView ac;
    private TextView ad;
    private TextView ae;
    private LinearLayout af;
    private LinearLayout ag;

    public bh(PersonInfoActivity personInfoActivity, com.baidu.tieba.model.bm bmVar) {
        super(personInfoActivity, bmVar);
        this.D = -1;
        this.E = 0;
        this.F = null;
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
        this.F = (ViewGroup) LayoutInflater.from(personInfoActivity).inflate(R.layout.person_info_activity_guest, (ViewGroup) null);
        this.G = (LinearLayout) this.F.findViewById(R.id.guest_operation_btns);
        this.H = (LinearLayout) this.F.findViewById(R.id.sudoku_buttons_guest);
        this.F.removeView(this.G);
        this.F.removeView(this.H);
        this.B.addView(this.G);
        this.C.addView(this.H);
        this.O = (ProgressBar) personInfoActivity.findViewById(R.id.attention_progress);
        this.I = (LinearLayout) personInfoActivity.findViewById(R.id.guest_btn_attention);
        this.K = (TextView) personInfoActivity.findViewById(R.id.btn_attention_text);
        this.J = (ImageView) personInfoActivity.findViewById(R.id.btn_attention_icon);
        this.L = (LinearLayout) personInfoActivity.findViewById(R.id.guest_btn_send_message);
        this.N = (TextView) personInfoActivity.findViewById(R.id.btn_send_message_text);
        this.M = (ImageView) personInfoActivity.findViewById(R.id.btn_send_message_icon);
        this.D = TiebaApplication.g().an();
        this.P = (LinearLayout) personInfoActivity.findViewById(R.id.guest_forums);
        this.Q = (ImageView) personInfoActivity.findViewById(R.id.guest_forums_image);
        this.R = (TextView) personInfoActivity.findViewById(R.id.guest_forums_text);
        this.S = (TextView) personInfoActivity.findViewById(R.id.guest_forums_num);
        this.ab = (LinearLayout) personInfoActivity.findViewById(R.id.guest_posts);
        this.ac = (ImageView) personInfoActivity.findViewById(R.id.guest_posts_image);
        this.ad = (TextView) personInfoActivity.findViewById(R.id.guest_posts_text);
        this.ae = (TextView) personInfoActivity.findViewById(R.id.guest_posts_num);
        this.T = (LinearLayout) personInfoActivity.findViewById(R.id.guest_attention);
        this.U = (ImageView) personInfoActivity.findViewById(R.id.guest_attention_image);
        this.V = (TextView) personInfoActivity.findViewById(R.id.guest_attention_text);
        this.W = (TextView) personInfoActivity.findViewById(R.id.guest_attention_num);
        this.X = (LinearLayout) personInfoActivity.findViewById(R.id.guest_fans);
        this.Y = (ImageView) personInfoActivity.findViewById(R.id.guest_fans_image);
        this.Z = (TextView) personInfoActivity.findViewById(R.id.guest_fans_text);
        this.aa = (TextView) personInfoActivity.findViewById(R.id.guest_fans_num);
        this.af = (LinearLayout) personInfoActivity.findViewById(R.id.place_holder1);
        this.ag = (LinearLayout) personInfoActivity.findViewById(R.id.place_holder2);
        this.P.setOnClickListener(personInfoActivity);
        this.ab.setOnClickListener(personInfoActivity);
        this.T.setOnClickListener(personInfoActivity);
        this.X.setOnClickListener(personInfoActivity);
        this.I.setOnClickListener(personInfoActivity);
        this.L.setOnClickListener(personInfoActivity);
        d(bmVar);
        h(bmVar);
    }

    @Override // com.baidu.tieba.person.bj
    public void a(com.baidu.tieba.model.bm bmVar) {
        super.a(bmVar);
        this.A = bmVar.c();
        if (this.A == null) {
            this.h.setText(bmVar.f());
        } else {
            this.h.setText(this.A.getName_show());
        }
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    public void a(boolean z, com.baidu.tieba.model.bm bmVar, int i) {
        this.t.setVisibility(8);
        if (z) {
            d(bmVar);
            h(bmVar);
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
        this.z = bmVar.a();
        this.af.setVisibility(4);
        this.ag.setVisibility(4);
        if (this.z != null && this.z.length() > 0) {
            this.A = bmVar.c();
            if (this.A != null) {
                int sex = this.A.getSex();
                if (sex == 2) {
                    this.R.setText(R.string.her_attention_forums);
                    this.ad.setText(R.string.her_posts);
                    this.V.setText(R.string.her_attention_people);
                    this.Z.setText(R.string.attention_to_her);
                } else if (sex == 1) {
                    this.R.setText(R.string.his_attention_forums);
                    this.ad.setText(R.string.his_posts);
                    this.V.setText(R.string.his_attention_people);
                    this.Z.setText(R.string.attention_to_him);
                } else {
                    this.R.setText(R.string.ta_attention_forums);
                    this.ad.setText(R.string.ta_posts);
                    this.V.setText(R.string.ta_attention_people);
                    this.Z.setText(R.string.attention_to_ta);
                }
            }
            if (this.A != null && this.A.getLike_bars() > 0) {
                this.S.setVisibility(0);
                this.S.setText(String.valueOf(this.A.getLike_bars()));
            } else {
                this.S.setVisibility(4);
            }
            if (this.A != null && this.A.getConcern_num() > 0) {
                this.W.setVisibility(0);
                this.W.setText(String.valueOf(this.A.getConcern_num()));
            } else {
                this.W.setVisibility(4);
            }
            if (this.A != null && this.A.getPosts_num() > 0) {
                this.ae.setVisibility(0);
                this.ae.setText(String.valueOf(this.A.getPosts_num()));
            } else {
                this.ae.setVisibility(4);
            }
            if (this.A != null && this.A.getFans_num() > 0) {
                this.aa.setVisibility(0);
                this.aa.setText(String.valueOf(this.A.getFans_num()));
                return;
            }
            this.aa.setVisibility(4);
        }
    }

    public void c(com.baidu.tieba.model.bm bmVar) {
        if (bmVar.c() != null) {
            this.O.setVisibility(0);
        }
    }

    public void a(boolean z, com.baidu.tieba.model.bm bmVar) {
        this.O.setVisibility(8);
        if (z) {
            this.b.a(this.b.getString(R.string.success));
            h(bmVar);
        } else if (bmVar.getErrorString() != null) {
            this.b.a(bmVar.getErrorString());
        }
    }

    private void h(com.baidu.tieba.model.bm bmVar) {
        this.I.setVisibility(8);
        this.A = bmVar.c();
        this.z = bmVar.a();
        if (this.z != null && this.z.length() > 0 && this.A != null) {
            this.I.setVisibility(0);
            this.E = this.A.getHave_attention();
            i(bmVar);
        }
    }

    private void i(com.baidu.tieba.model.bm bmVar) {
        if (this.E == 1) {
            this.K.setText(R.string.attention_cancel);
            this.J.setImageResource(0);
            this.J.setVisibility(0);
            if (this.D == 1) {
                this.I.setBackgroundResource(R.drawable.btn_white_bg_night_selector);
                this.K.setTextColor(-11640196);
                return;
            }
            this.I.setBackgroundResource(R.drawable.btn_white_bg_selector);
            this.K.setTextColor(-9207399);
            return;
        }
        this.K.setText(R.string.attention);
        if (this.D == 1) {
            com.baidu.tieba.util.ao.g(this.I, (int) R.drawable.btn_attention_to_bg_night_selector);
            this.J.setVisibility(0);
            this.J.setImageResource(R.drawable.btn_icon_follow_1);
            this.K.setTextColor(-1199663);
            return;
        }
        com.baidu.tieba.util.ao.g(this.I, (int) R.drawable.btn_attention_to_bg_selector);
        this.J.setVisibility(0);
        this.J.setImageResource(R.drawable.btn_icon_follow);
        this.K.setTextColor(-1);
    }

    @Override // com.baidu.tieba.person.bj
    public void a(int i, com.baidu.tieba.model.bm bmVar) {
        super.a(i, bmVar);
        i(bmVar);
        if (i == 1) {
            com.baidu.tieba.util.ao.g(this.L, (int) R.drawable.btn_send_message_bg_night_selector);
            this.M.setImageResource(R.drawable.btn_icon_information_1);
            this.N.setTextColor(-5454368);
            this.P.setBackgroundResource(R.drawable.person_button_1);
            this.ab.setBackgroundResource(R.drawable.person_button_1);
            this.T.setBackgroundResource(R.drawable.person_button_1);
            this.X.setBackgroundResource(R.drawable.person_button_1);
            this.Q.setImageResource(R.drawable.cent_icon_myba_n_1);
            this.ac.setImageResource(R.drawable.cent_icon_tiezi_n_1);
            this.U.setImageResource(R.drawable.cent_icon_gz_n_1);
            this.Y.setImageResource(R.drawable.cent_icon_fs_n_1);
            this.R.setTextColor(-10523526);
            this.ad.setTextColor(-10523526);
            this.V.setTextColor(-10523526);
            this.Z.setTextColor(-10523526);
            this.S.setTextColor(-8352873);
            this.ae.setTextColor(-8352873);
            this.W.setTextColor(-8352873);
            this.aa.setTextColor(-8352873);
            return;
        }
        com.baidu.tieba.util.ao.g(this.L, (int) R.drawable.btn_send_message_bg_selector);
        this.M.setImageResource(R.drawable.btn_icon_information);
        this.N.setTextColor(-1);
        this.P.setBackgroundResource(R.drawable.person_button);
        this.ab.setBackgroundResource(R.drawable.person_button);
        this.T.setBackgroundResource(R.drawable.person_button);
        this.X.setBackgroundResource(R.drawable.person_button);
        this.Q.setImageResource(R.drawable.cent_icon_myba_n);
        this.ac.setImageResource(R.drawable.cent_icon_tiezi_n);
        this.U.setImageResource(R.drawable.cent_icon_gz_n);
        this.Y.setImageResource(R.drawable.cent_icon_fs_n);
        this.R.setTextColor(-12564913);
        this.ad.setTextColor(-12564913);
        this.V.setTextColor(-12564913);
        this.Z.setTextColor(-12564913);
        this.S.setTextColor(-6576974);
        this.ae.setTextColor(-6576974);
        this.W.setTextColor(-6576974);
        this.aa.setTextColor(-6576974);
    }

    @Override // com.baidu.tieba.person.bj
    public void b() {
        super.b();
        this.I.setBackgroundResource(0);
        this.J.setImageResource(0);
        this.L.setBackgroundResource(0);
        this.M.setImageResource(0);
        this.Q.setImageResource(0);
        this.ac.setImageResource(0);
        this.U.setImageResource(0);
        this.Y.setImageResource(0);
    }

    @Override // com.baidu.tieba.person.bj
    public void c() {
        super.c();
        if (this.O != null) {
            this.O.setVisibility(8);
        }
    }

    public LinearLayout d() {
        return this.I;
    }

    public LinearLayout e() {
        return this.L;
    }

    public LinearLayout f() {
        return this.P;
    }

    public LinearLayout g() {
        return this.ab;
    }

    public LinearLayout h() {
        return this.T;
    }

    public LinearLayout i() {
        return this.X;
    }
}
