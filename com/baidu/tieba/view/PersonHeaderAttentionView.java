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
    private View.OnClickListener bER;
    private TextView dJb;
    private TextView dde;
    private h fAj;
    private TextView fsr;
    private TextView gYA;
    private TextView gYB;
    private TextView gYC;
    private TextView gYD;
    private View gYE;
    private View gYF;
    private View gYG;
    private TextView gYy;
    private ImageView gYz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a gYH = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fsr.getId() && id != PersonHeaderAttentionView.this.gYy.getId()) {
                        if (id != PersonHeaderAttentionView.this.dde.getId() && id != PersonHeaderAttentionView.this.gYA.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYB.getId() || id == PersonHeaderAttentionView.this.gYC.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 2)) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYH.cuZ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gYH.cuZ = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gYH.cuZ = 4;
                    }
                    if (PersonHeaderAttentionView.this.fAj != null) {
                        this.gYH.cva = new Bundle();
                        this.gYH.cva.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fAj.a(view, this.gYH);
                    }
                }
            }
        };
        init(context);
        bEb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a gYH = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fsr.getId() && id != PersonHeaderAttentionView.this.gYy.getId()) {
                        if (id != PersonHeaderAttentionView.this.dde.getId() && id != PersonHeaderAttentionView.this.gYA.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYB.getId() || id == PersonHeaderAttentionView.this.gYC.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 2)) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYH.cuZ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gYH.cuZ = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gYH.cuZ = 4;
                    }
                    if (PersonHeaderAttentionView.this.fAj != null) {
                        this.gYH.cva = new Bundle();
                        this.gYH.cva.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fAj.a(view, this.gYH);
                    }
                }
            }
        };
        init(context);
        bEb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a gYH = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fsr.getId() && id != PersonHeaderAttentionView.this.gYy.getId()) {
                        if (id != PersonHeaderAttentionView.this.dde.getId() && id != PersonHeaderAttentionView.this.gYA.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYB.getId() || id == PersonHeaderAttentionView.this.gYC.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().CA() != 2)) {
                                    PersonHeaderAttentionView.this.vw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYH.cuZ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gYH.cuZ = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gYH.cuZ = 4;
                    }
                    if (PersonHeaderAttentionView.this.fAj != null) {
                        this.gYH.cva = new Bundle();
                        this.gYH.cva.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fAj.a(view, this.gYH);
                    }
                }
            }
        };
        init(context);
        bEb();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dde = (TextView) findViewById(d.g.person_header_fans_num);
        this.gYA = (TextView) findViewById(d.g.person_header_fans_des);
        this.gYz = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fsr = (TextView) findViewById(d.g.person_header_attention_num);
        this.gYy = (TextView) findViewById(d.g.person_header_attention_des);
        this.gYB = (TextView) findViewById(d.g.person_header_bar_num);
        this.gYC = (TextView) findViewById(d.g.person_header_bar_des);
        this.dJb = (TextView) findViewById(d.g.person_header_thread_num);
        this.dJb.setVisibility(8);
        this.gYD = (TextView) findViewById(d.g.person_header_thread_des);
        this.gYD.setVisibility(8);
        this.gYE = findViewById(d.g.divider_for_fans_and_attention);
        this.gYF = findViewById(d.g.divider_for_attention_and_bar);
        this.gYG = findViewById(d.g.divider_for_bar_and_thread);
        this.gYG.setVisibility(8);
    }

    private void bEb() {
        this.dde.setOnClickListener(this.bER);
        this.gYA.setOnClickListener(this.bER);
        this.fsr.setOnClickListener(this.bER);
        this.gYy.setOnClickListener(this.bER);
        this.gYB.setOnClickListener(this.bER);
        this.gYC.setOnClickListener(this.bER);
        this.dJb.setOnClickListener(this.bER);
        this.gYD.setOnClickListener(this.bER);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(h hVar) {
        this.fAj = hVar;
    }

    private void n(String str, String str2, String str3, String str4) {
        this.fsr.setText(str);
        this.dde.setText(str2);
        this.gYB.setText(str4);
        this.dJb.setText(str3);
    }

    @Override // com.baidu.tieba.view.f
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fsr.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dde.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gYB.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dJb.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        n(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.fsr, d.C0082d.cp_cont_b, 1);
            aj.c(this.gYy, d.C0082d.cp_cont_j, 1);
            aj.c(this.dde, d.C0082d.cp_cont_b, 1);
            aj.c(this.gYA, d.C0082d.cp_cont_j, 1);
            aj.c(this.gYz, d.f.icon_news_down_bar_one);
            aj.c(this.gYB, d.C0082d.cp_cont_b, 1);
            aj.c(this.gYC, d.C0082d.cp_cont_j, 1);
            aj.c(this.dJb, d.C0082d.cp_cont_b, 1);
            aj.c(this.gYD, d.C0082d.cp_cont_j, 1);
            aj.k(this.gYE, d.C0082d.cp_bg_line_b);
            aj.k(this.gYF, d.C0082d.cp_bg_line_b);
            aj.k(this.gYG, d.C0082d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.cX(i)), d.f.icon_toast_game_error).tt();
    }

    @Override // com.baidu.tieba.view.f
    public void nO(boolean z) {
        if (this.gYz != null) {
            if (z) {
                this.gYz.setVisibility(0);
            } else {
                this.gYz.setVisibility(8);
            }
        }
    }
}
