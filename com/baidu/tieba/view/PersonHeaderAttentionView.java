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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener bOi;
    private TextView dXk;
    private TextView duH;
    private TextView fEt;
    private g fMl;
    private TextView gXA;
    private ImageView gXB;
    private TextView gXC;
    private TextView gXD;
    private TextView gXE;
    private TextView gXF;
    private View gXG;
    private View gXH;
    private View gXI;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXJ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEt.getId() && id != PersonHeaderAttentionView.this.gXA.getId()) {
                        if (id != PersonHeaderAttentionView.this.duH.getId() && id != PersonHeaderAttentionView.this.gXC.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXD.getId() || id == PersonHeaderAttentionView.this.gXE.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXJ.cKc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXJ.cKc = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXJ.cKc = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMl != null) {
                        this.gXJ.cKd = new Bundle();
                        this.gXJ.cKd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMl.a(view2, this.gXJ);
                    }
                }
            }
        };
        init(context);
        bAe();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXJ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEt.getId() && id != PersonHeaderAttentionView.this.gXA.getId()) {
                        if (id != PersonHeaderAttentionView.this.duH.getId() && id != PersonHeaderAttentionView.this.gXC.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXD.getId() || id == PersonHeaderAttentionView.this.gXE.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXJ.cKc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXJ.cKc = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXJ.cKc = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMl != null) {
                        this.gXJ.cKd = new Bundle();
                        this.gXJ.cKd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMl.a(view2, this.gXJ);
                    }
                }
            }
        };
        init(context);
        bAe();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXJ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEt.getId() && id != PersonHeaderAttentionView.this.gXA.getId()) {
                        if (id != PersonHeaderAttentionView.this.duH.getId() && id != PersonHeaderAttentionView.this.gXC.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXD.getId() || id == PersonHeaderAttentionView.this.gXE.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXJ.cKc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXJ.cKc = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXJ.cKc = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMl != null) {
                        this.gXJ.cKd = new Bundle();
                        this.gXJ.cKd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMl.a(view2, this.gXJ);
                    }
                }
            }
        };
        init(context);
        bAe();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.i.item_person_header_attention_view, (ViewGroup) this, true);
        this.duH = (TextView) findViewById(d.g.person_header_fans_num);
        this.gXC = (TextView) findViewById(d.g.person_header_fans_des);
        this.gXB = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fEt = (TextView) findViewById(d.g.person_header_attention_num);
        this.gXA = (TextView) findViewById(d.g.person_header_attention_des);
        this.gXD = (TextView) findViewById(d.g.person_header_bar_num);
        this.gXE = (TextView) findViewById(d.g.person_header_bar_des);
        this.dXk = (TextView) findViewById(d.g.person_header_thread_num);
        this.dXk.setVisibility(8);
        this.gXF = (TextView) findViewById(d.g.person_header_thread_des);
        this.gXF.setVisibility(8);
        this.gXG = findViewById(d.g.divider_for_fans_and_attention);
        this.gXH = findViewById(d.g.divider_for_attention_and_bar);
        this.gXI = findViewById(d.g.divider_for_bar_and_thread);
        this.gXI.setVisibility(8);
    }

    private void bAe() {
        this.duH.setOnClickListener(this.bOi);
        this.gXC.setOnClickListener(this.bOi);
        this.fEt.setOnClickListener(this.bOi);
        this.gXA.setOnClickListener(this.bOi);
        this.gXD.setOnClickListener(this.bOi);
        this.gXE.setOnClickListener(this.bOi);
        this.dXk.setOnClickListener(this.bOi);
        this.gXF.setOnClickListener(this.bOi);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fMl = gVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.fEt.setText(str);
        this.duH.setText(str2);
        this.gXD.setText(str4);
        this.dXk.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fEt.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.duH.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gXD.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dXk.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        p(an.A(this.mUserData.getConcernNum()), an.A(this.mUserData.getFansNum()), an.A(this.mUserData.getPosts_num()), an.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.c(this.fEt, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXA, d.C0126d.cp_cont_j, 1);
            ak.c(this.duH, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXC, d.C0126d.cp_cont_j, 1);
            ak.c(this.gXB, d.f.icon_news_down_bar_one);
            ak.c(this.gXD, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXE, d.C0126d.cp_cont_j, 1);
            ak.c(this.dXk, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXF, d.C0126d.cp_cont_j, 1);
            ak.j(this.gXG, d.C0126d.cp_bg_line_b);
            ak.j(this.gXH, d.C0126d.cp_bg_line_b);
            ak.j(this.gXI, d.C0126d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.k.person_privacy_toast), an.cT(i)), d.f.icon_toast_game_error).tL();
    }

    @Override // com.baidu.tieba.view.e
    public void nf(boolean z) {
        if (this.gXB != null) {
            if (z) {
                this.gXB.setVisibility(0);
            } else {
                this.gXB.setVisibility(8);
            }
        }
    }
}
