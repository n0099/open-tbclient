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
    private View.OnClickListener bEZ;
    private TextView dKj;
    private TextView dep;
    private h fBg;
    private TextView ftr;
    private View hbA;
    private View hbB;
    private TextView hbt;
    private ImageView hbu;
    private TextView hbv;
    private TextView hbw;
    private TextView hbx;
    private TextView hby;
    private View hbz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbC = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftr.getId() && id != PersonHeaderAttentionView.this.hbt.getId()) {
                        if (id != PersonHeaderAttentionView.this.dep.getId() && id != PersonHeaderAttentionView.this.hbv.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbw.getId() || id == PersonHeaderAttentionView.this.hbx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbC.cvm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbC.cvm = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbC.cvm = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBg != null) {
                        this.hbC.cvn = new Bundle();
                        this.hbC.cvn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBg.a(view, this.hbC);
                    }
                }
            }
        };
        init(context);
        bEN();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbC = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftr.getId() && id != PersonHeaderAttentionView.this.hbt.getId()) {
                        if (id != PersonHeaderAttentionView.this.dep.getId() && id != PersonHeaderAttentionView.this.hbv.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbw.getId() || id == PersonHeaderAttentionView.this.hbx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbC.cvm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbC.cvm = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbC.cvm = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBg != null) {
                        this.hbC.cvn = new Bundle();
                        this.hbC.cvn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBg.a(view, this.hbC);
                    }
                }
            }
        };
        init(context);
        bEN();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hbC = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aS(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ftr.getId() && id != PersonHeaderAttentionView.this.hbt.getId()) {
                        if (id != PersonHeaderAttentionView.this.dep.getId() && id != PersonHeaderAttentionView.this.hbv.getId()) {
                            if (id == PersonHeaderAttentionView.this.hbw.getId() || id == PersonHeaderAttentionView.this.hbx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CB() != 2)) {
                                    PersonHeaderAttentionView.this.vI(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hbC.cvm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.hbC.cvm = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.hbC.cvm = 4;
                    }
                    if (PersonHeaderAttentionView.this.fBg != null) {
                        this.hbC.cvn = new Bundle();
                        this.hbC.cvn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fBg.a(view, this.hbC);
                    }
                }
            }
        };
        init(context);
        bEN();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dep = (TextView) findViewById(d.g.person_header_fans_num);
        this.hbv = (TextView) findViewById(d.g.person_header_fans_des);
        this.hbu = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.ftr = (TextView) findViewById(d.g.person_header_attention_num);
        this.hbt = (TextView) findViewById(d.g.person_header_attention_des);
        this.hbw = (TextView) findViewById(d.g.person_header_bar_num);
        this.hbx = (TextView) findViewById(d.g.person_header_bar_des);
        this.dKj = (TextView) findViewById(d.g.person_header_thread_num);
        this.dKj.setVisibility(8);
        this.hby = (TextView) findViewById(d.g.person_header_thread_des);
        this.hby.setVisibility(8);
        this.hbz = findViewById(d.g.divider_for_fans_and_attention);
        this.hbA = findViewById(d.g.divider_for_attention_and_bar);
        this.hbB = findViewById(d.g.divider_for_bar_and_thread);
        this.hbB.setVisibility(8);
    }

    private void bEN() {
        this.dep.setOnClickListener(this.bEZ);
        this.hbv.setOnClickListener(this.bEZ);
        this.ftr.setOnClickListener(this.bEZ);
        this.hbt.setOnClickListener(this.bEZ);
        this.hbw.setOnClickListener(this.bEZ);
        this.hbx.setOnClickListener(this.bEZ);
        this.dKj.setOnClickListener(this.bEZ);
        this.hby.setOnClickListener(this.bEZ);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(h hVar) {
        this.fBg = hVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.ftr.setText(str);
        this.dep.setText(str2);
        this.hbw.setText(str4);
        this.dKj.setText(str3);
    }

    @Override // com.baidu.tieba.view.f
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ftr.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dep.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hbw.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dKj.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        m(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.ftr, d.C0095d.cp_cont_b, 1);
            aj.c(this.hbt, d.C0095d.cp_cont_j, 1);
            aj.c(this.dep, d.C0095d.cp_cont_b, 1);
            aj.c(this.hbv, d.C0095d.cp_cont_j, 1);
            aj.c(this.hbu, d.f.icon_news_down_bar_one);
            aj.c(this.hbw, d.C0095d.cp_cont_b, 1);
            aj.c(this.hbx, d.C0095d.cp_cont_j, 1);
            aj.c(this.dKj, d.C0095d.cp_cont_b, 1);
            aj.c(this.hby, d.C0095d.cp_cont_j, 1);
            aj.k(this.hbz, d.C0095d.cp_bg_line_b);
            aj.k(this.hbA, d.C0095d.cp_bg_line_b);
            aj.k(this.hbB, d.C0095d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.cX(i)), d.f.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.f
    public void nP(boolean z) {
        if (this.hbu != null) {
            if (z) {
                this.hbu.setVisibility(0);
            } else {
                this.hbu.setVisibility(8);
            }
        }
    }
}
