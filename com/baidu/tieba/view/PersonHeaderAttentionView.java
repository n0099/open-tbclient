package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements f {
    private View.OnClickListener bEV;
    private TextView dKf;
    private TextView del;
    private h fBb;
    private TextView ftm;
    private TextView hbo;
    private ImageView hbp;
    private TextView hbq;
    private TextView hbr;
    private TextView hbs;
    private TextView hbt;
    private View hbu;
    private View hbv;
    private View hbw;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbx = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftm.getId() && id != PersonHeaderAttentionView.this.hbo.getId()) {
                        if (id != PersonHeaderAttentionView.this.del.getId() && id != PersonHeaderAttentionView.this.hbq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbr.getId() || id == PersonHeaderAttentionView.this.hbs.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbx.cvi = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbx.cvi = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbx.cvi = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBb != null) {
                        this.hbx.cvj = new Bundle();
                        this.hbx.cvj.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBb.a(view, this.hbx);
                    }
                }
            }
        };
        init(context);
        bEM();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbx = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftm.getId() && id != PersonHeaderAttentionView.this.hbo.getId()) {
                        if (id != PersonHeaderAttentionView.this.del.getId() && id != PersonHeaderAttentionView.this.hbq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbr.getId() || id == PersonHeaderAttentionView.this.hbs.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbx.cvi = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbx.cvi = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbx.cvi = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBb != null) {
                        this.hbx.cvj = new Bundle();
                        this.hbx.cvj.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBb.a(view, this.hbx);
                    }
                }
            }
        };
        init(context);
        bEM();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbx = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftm.getId() && id != PersonHeaderAttentionView.this.hbo.getId()) {
                        if (id != PersonHeaderAttentionView.this.del.getId() && id != PersonHeaderAttentionView.this.hbq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbr.getId() || id == PersonHeaderAttentionView.this.hbs.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbx.cvi = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbx.cvi = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbx.cvi = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBb != null) {
                        this.hbx.cvj = new Bundle();
                        this.hbx.cvj.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBb.a(view, this.hbx);
                    }
                }
            }
        };
        init(context);
        bEM();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.del = (TextView) findViewById(d.g.person_header_fans_num);
        this.hbq = (TextView) findViewById(d.g.person_header_fans_des);
        this.hbp = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.ftm = (TextView) findViewById(d.g.person_header_attention_num);
        this.hbo = (TextView) findViewById(d.g.person_header_attention_des);
        this.hbr = (TextView) findViewById(d.g.person_header_bar_num);
        this.hbs = (TextView) findViewById(d.g.person_header_bar_des);
        this.dKf = (TextView) findViewById(d.g.person_header_thread_num);
        this.dKf.setVisibility(8);
        this.hbt = (TextView) findViewById(d.g.person_header_thread_des);
        this.hbt.setVisibility(8);
        this.hbu = findViewById(d.g.divider_for_fans_and_attention);
        this.hbv = findViewById(d.g.divider_for_attention_and_bar);
        this.hbw = findViewById(d.g.divider_for_bar_and_thread);
        this.hbw.setVisibility(8);
    }

    private void bEM() {
        this.del.setOnClickListener(this.bEV);
        this.hbq.setOnClickListener(this.bEV);
        this.ftm.setOnClickListener(this.bEV);
        this.hbo.setOnClickListener(this.bEV);
        this.hbr.setOnClickListener(this.bEV);
        this.hbs.setOnClickListener(this.bEV);
        this.dKf.setOnClickListener(this.bEV);
        this.hbt.setOnClickListener(this.bEV);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(h hVar) {
        this.fBb = hVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.ftm.setText(str);
        this.del.setText(str2);
        this.hbr.setText(str4);
        this.dKf.setText(str3);
    }

    @Override // com.baidu.tieba.view.f
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ftm.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.del.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hbr.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dKf.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        m(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.ftm, d.C0096d.cp_cont_b, 1);
            aj.c(this.hbo, d.C0096d.cp_cont_j, 1);
            aj.c(this.del, d.C0096d.cp_cont_b, 1);
            aj.c(this.hbq, d.C0096d.cp_cont_j, 1);
            aj.c(this.hbp, d.f.icon_news_down_bar_one);
            aj.c(this.hbr, d.C0096d.cp_cont_b, 1);
            aj.c(this.hbs, d.C0096d.cp_cont_j, 1);
            aj.c(this.dKf, d.C0096d.cp_cont_b, 1);
            aj.c(this.hbt, d.C0096d.cp_cont_j, 1);
            aj.k(this.hbu, d.C0096d.cp_bg_line_b);
            aj.k(this.hbv, d.C0096d.cp_bg_line_b);
            aj.k(this.hbw, d.C0096d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.cX(i)), d.f.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.f
    public void nP(boolean z) {
        if (this.hbp != null) {
            if (z) {
                this.hbp.setVisibility(0);
            } else {
                this.hbp.setVisibility(8);
            }
        }
    }
}
