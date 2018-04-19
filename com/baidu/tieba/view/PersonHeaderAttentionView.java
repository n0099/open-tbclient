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
    private View.OnClickListener bOj;
    private TextView dXn;
    private TextView duK;
    private TextView fEw;
    private g fMo;
    private TextView gXD;
    private ImageView gXE;
    private TextView gXF;
    private TextView gXG;
    private TextView gXH;
    private TextView gXI;
    private View gXJ;
    private View gXK;
    private View gXL;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEw.getId() && id != PersonHeaderAttentionView.this.gXD.getId()) {
                        if (id != PersonHeaderAttentionView.this.duK.getId() && id != PersonHeaderAttentionView.this.gXF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXG.getId() || id == PersonHeaderAttentionView.this.gXH.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXM.cKf = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXM.cKf = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXM.cKf = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMo != null) {
                        this.gXM.cKg = new Bundle();
                        this.gXM.cKg.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMo.a(view2, this.gXM);
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
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEw.getId() && id != PersonHeaderAttentionView.this.gXD.getId()) {
                        if (id != PersonHeaderAttentionView.this.duK.getId() && id != PersonHeaderAttentionView.this.gXF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXG.getId() || id == PersonHeaderAttentionView.this.gXH.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXM.cKf = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXM.cKf = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXM.cKf = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMo != null) {
                        this.gXM.cKg = new Bundle();
                        this.gXM.cKg.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMo.a(view2, this.gXM);
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
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gXM = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fEw.getId() && id != PersonHeaderAttentionView.this.gXD.getId()) {
                        if (id != PersonHeaderAttentionView.this.duK.getId() && id != PersonHeaderAttentionView.this.gXF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gXG.getId() || id == PersonHeaderAttentionView.this.gXH.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Dg() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gXM.cKf = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gXM.cKf = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gXM.cKf = 4;
                    }
                    if (PersonHeaderAttentionView.this.fMo != null) {
                        this.gXM.cKg = new Bundle();
                        this.gXM.cKg.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fMo.a(view2, this.gXM);
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
        this.duK = (TextView) findViewById(d.g.person_header_fans_num);
        this.gXF = (TextView) findViewById(d.g.person_header_fans_des);
        this.gXE = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fEw = (TextView) findViewById(d.g.person_header_attention_num);
        this.gXD = (TextView) findViewById(d.g.person_header_attention_des);
        this.gXG = (TextView) findViewById(d.g.person_header_bar_num);
        this.gXH = (TextView) findViewById(d.g.person_header_bar_des);
        this.dXn = (TextView) findViewById(d.g.person_header_thread_num);
        this.dXn.setVisibility(8);
        this.gXI = (TextView) findViewById(d.g.person_header_thread_des);
        this.gXI.setVisibility(8);
        this.gXJ = findViewById(d.g.divider_for_fans_and_attention);
        this.gXK = findViewById(d.g.divider_for_attention_and_bar);
        this.gXL = findViewById(d.g.divider_for_bar_and_thread);
        this.gXL.setVisibility(8);
    }

    private void bAe() {
        this.duK.setOnClickListener(this.bOj);
        this.gXF.setOnClickListener(this.bOj);
        this.fEw.setOnClickListener(this.bOj);
        this.gXD.setOnClickListener(this.bOj);
        this.gXG.setOnClickListener(this.bOj);
        this.gXH.setOnClickListener(this.bOj);
        this.dXn.setOnClickListener(this.bOj);
        this.gXI.setOnClickListener(this.bOj);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fMo = gVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.fEw.setText(str);
        this.duK.setText(str2);
        this.gXG.setText(str4);
        this.dXn.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fEw.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.duK.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gXG.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dXn.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        p(an.A(this.mUserData.getConcernNum()), an.A(this.mUserData.getFansNum()), an.A(this.mUserData.getPosts_num()), an.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.c(this.fEw, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXD, d.C0126d.cp_cont_j, 1);
            ak.c(this.duK, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXF, d.C0126d.cp_cont_j, 1);
            ak.c(this.gXE, d.f.icon_news_down_bar_one);
            ak.c(this.gXG, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXH, d.C0126d.cp_cont_j, 1);
            ak.c(this.dXn, d.C0126d.cp_cont_b, 1);
            ak.c(this.gXI, d.C0126d.cp_cont_j, 1);
            ak.j(this.gXJ, d.C0126d.cp_bg_line_b);
            ak.j(this.gXK, d.C0126d.cp_bg_line_b);
            ak.j(this.gXL, d.C0126d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.k.person_privacy_toast), an.cT(i)), d.f.icon_toast_game_error).tL();
    }

    @Override // com.baidu.tieba.view.e
    public void nf(boolean z) {
        if (this.gXE != null) {
            if (z) {
                this.gXE.setVisibility(0);
            } else {
                this.gXE.setVisibility(8);
            }
        }
    }
}
