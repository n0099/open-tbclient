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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener csN;
    private TextView eOA;
    private TextView eis;
    private g gAb;
    private TextView gsl;
    private TextView hND;
    private ImageView hNE;
    private TextView hNF;
    private TextView hNG;
    private TextView hNH;
    private TextView hNI;
    private View hNJ;
    private View hNK;
    private View hNL;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hNM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gsl.getId() && id != PersonHeaderAttentionView.this.hND.getId()) {
                        if (id != PersonHeaderAttentionView.this.eis.getId() && id != PersonHeaderAttentionView.this.hNF.getId()) {
                            if (id == PersonHeaderAttentionView.this.hNG.getId() || id == PersonHeaderAttentionView.this.hNH.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 2)) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hNM.dqN = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hNM.dqN = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hNM.dqN = 4;
                    }
                    if (PersonHeaderAttentionView.this.gAb != null) {
                        this.hNM.dqO = new Bundle();
                        this.hNM.dqO.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gAb.a(view, this.hNM);
                    }
                }
            }
        };
        init(context);
        bMb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hNM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gsl.getId() && id != PersonHeaderAttentionView.this.hND.getId()) {
                        if (id != PersonHeaderAttentionView.this.eis.getId() && id != PersonHeaderAttentionView.this.hNF.getId()) {
                            if (id == PersonHeaderAttentionView.this.hNG.getId() || id == PersonHeaderAttentionView.this.hNH.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 2)) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hNM.dqN = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hNM.dqN = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hNM.dqN = 4;
                    }
                    if (PersonHeaderAttentionView.this.gAb != null) {
                        this.hNM.dqO = new Bundle();
                        this.hNM.dqO.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gAb.a(view, this.hNM);
                    }
                }
            }
        };
        init(context);
        bMb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hNM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gsl.getId() && id != PersonHeaderAttentionView.this.hND.getId()) {
                        if (id != PersonHeaderAttentionView.this.eis.getId() && id != PersonHeaderAttentionView.this.hNF.getId()) {
                            if (id == PersonHeaderAttentionView.this.hNG.getId() || id == PersonHeaderAttentionView.this.hNH.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LA() != 2)) {
                                    PersonHeaderAttentionView.this.wM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hNM.dqN = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hNM.dqN = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hNM.dqN = 4;
                    }
                    if (PersonHeaderAttentionView.this.gAb != null) {
                        this.hNM.dqO = new Bundle();
                        this.hNM.dqO.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gAb.a(view, this.hNM);
                    }
                }
            }
        };
        init(context);
        bMb();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.eis = (TextView) findViewById(e.g.person_header_fans_num);
        this.hNF = (TextView) findViewById(e.g.person_header_fans_des);
        this.hNE = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gsl = (TextView) findViewById(e.g.person_header_attention_num);
        this.hND = (TextView) findViewById(e.g.person_header_attention_des);
        this.hNG = (TextView) findViewById(e.g.person_header_bar_num);
        this.hNH = (TextView) findViewById(e.g.person_header_bar_des);
        this.eOA = (TextView) findViewById(e.g.person_header_thread_num);
        this.eOA.setVisibility(8);
        this.hNI = (TextView) findViewById(e.g.person_header_thread_des);
        this.hNI.setVisibility(8);
        this.hNJ = findViewById(e.g.divider_for_fans_and_attention);
        this.hNK = findViewById(e.g.divider_for_attention_and_bar);
        this.hNL = findViewById(e.g.divider_for_bar_and_thread);
        this.hNL.setVisibility(8);
    }

    private void bMb() {
        this.eis.setOnClickListener(this.csN);
        this.hNF.setOnClickListener(this.csN);
        this.gsl.setOnClickListener(this.csN);
        this.hND.setOnClickListener(this.csN);
        this.hNG.setOnClickListener(this.csN);
        this.hNH.setOnClickListener(this.csN);
        this.eOA.setOnClickListener(this.csN);
        this.hNI.setOnClickListener(this.csN);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gAb = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gsl.setText(str);
        this.eis.setText(str2);
        this.hNG.setText(str4);
        this.eOA.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gsl.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.eis.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hNG.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eOA.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        q(ao.V(this.mUserData.getConcernNum()), ao.V(this.mUserData.getFansNum()), ao.V(this.mUserData.getPosts_num()), ao.V(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gsl, e.d.cp_cont_b, 1);
            al.c(this.hND, e.d.cp_cont_j, 1);
            al.c(this.eis, e.d.cp_cont_b, 1);
            al.c(this.hNF, e.d.cp_cont_j, 1);
            al.c(this.hNE, e.f.icon_news_down_bar_one);
            al.c(this.hNG, e.d.cp_cont_b, 1);
            al.c(this.hNH, e.d.cp_cont_j, 1);
            al.c(this.eOA, e.d.cp_cont_b, 1);
            al.c(this.hNI, e.d.cp_cont_j, 1);
            al.j(this.hNJ, e.d.cp_bg_line_b);
            al.j(this.hNK, e.d.cp_bg_line_b);
            al.j(this.hNL, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.dU(i)), e.f.icon_toast_game_error).BN();
    }

    @Override // com.baidu.tieba.view.e
    public void om(boolean z) {
        if (this.hNE != null) {
            if (z) {
                this.hNE.setVisibility(0);
            } else {
                this.hNE.setVisibility(8);
            }
        }
    }
}
