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
    private View.OnClickListener bOY;
    private TextView dYr;
    private TextView dvP;
    private TextView fFz;
    private g fNr;
    private TextView gYE;
    private ImageView gYF;
    private TextView gYG;
    private TextView gYH;
    private TextView gYI;
    private TextView gYJ;
    private View gYK;
    private View gYL;
    private View gYM;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gYN = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fFz.getId() && id != PersonHeaderAttentionView.this.gYE.getId()) {
                        if (id != PersonHeaderAttentionView.this.dvP.getId() && id != PersonHeaderAttentionView.this.gYG.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYH.getId() || id == PersonHeaderAttentionView.this.gYI.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 2)) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYN.cLl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gYN.cLl = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gYN.cLl = 4;
                    }
                    if (PersonHeaderAttentionView.this.fNr != null) {
                        this.gYN.cLm = new Bundle();
                        this.gYN.cLm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fNr.a(view2, this.gYN);
                    }
                }
            }
        };
        init(context);
        bAc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gYN = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fFz.getId() && id != PersonHeaderAttentionView.this.gYE.getId()) {
                        if (id != PersonHeaderAttentionView.this.dvP.getId() && id != PersonHeaderAttentionView.this.gYG.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYH.getId() || id == PersonHeaderAttentionView.this.gYI.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 2)) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYN.cLl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gYN.cLl = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gYN.cLl = 4;
                    }
                    if (PersonHeaderAttentionView.this.fNr != null) {
                        this.gYN.cLm = new Bundle();
                        this.gYN.cLm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fNr.a(view2, this.gYN);
                    }
                }
            }
        };
        init(context);
        bAc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a gYN = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PersonHeaderAttentionView.this.mUserData != null && view2 != null && az.aK(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view2.getId();
                    if (id != PersonHeaderAttentionView.this.fFz.getId() && id != PersonHeaderAttentionView.this.gYE.getId()) {
                        if (id != PersonHeaderAttentionView.this.dvP.getId() && id != PersonHeaderAttentionView.this.gYG.getId()) {
                            if (id == PersonHeaderAttentionView.this.gYH.getId() || id == PersonHeaderAttentionView.this.gYI.getId()) {
                                TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().De() != 2)) {
                                    PersonHeaderAttentionView.this.uF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gYN.cLl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.gYN.cLl = 5;
                        }
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "9"));
                        this.gYN.cLl = 4;
                    }
                    if (PersonHeaderAttentionView.this.fNr != null) {
                        this.gYN.cLm = new Bundle();
                        this.gYN.cLm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fNr.a(view2, this.gYN);
                    }
                }
            }
        };
        init(context);
        bAc();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.i.item_person_header_attention_view, (ViewGroup) this, true);
        this.dvP = (TextView) findViewById(d.g.person_header_fans_num);
        this.gYG = (TextView) findViewById(d.g.person_header_fans_des);
        this.gYF = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fFz = (TextView) findViewById(d.g.person_header_attention_num);
        this.gYE = (TextView) findViewById(d.g.person_header_attention_des);
        this.gYH = (TextView) findViewById(d.g.person_header_bar_num);
        this.gYI = (TextView) findViewById(d.g.person_header_bar_des);
        this.dYr = (TextView) findViewById(d.g.person_header_thread_num);
        this.dYr.setVisibility(8);
        this.gYJ = (TextView) findViewById(d.g.person_header_thread_des);
        this.gYJ.setVisibility(8);
        this.gYK = findViewById(d.g.divider_for_fans_and_attention);
        this.gYL = findViewById(d.g.divider_for_attention_and_bar);
        this.gYM = findViewById(d.g.divider_for_bar_and_thread);
        this.gYM.setVisibility(8);
    }

    private void bAc() {
        this.dvP.setOnClickListener(this.bOY);
        this.gYG.setOnClickListener(this.bOY);
        this.fFz.setOnClickListener(this.bOY);
        this.gYE.setOnClickListener(this.bOY);
        this.gYH.setOnClickListener(this.bOY);
        this.gYI.setOnClickListener(this.bOY);
        this.dYr.setOnClickListener(this.bOY);
        this.gYJ.setOnClickListener(this.bOY);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fNr = gVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.fFz.setText(str);
        this.dvP.setText(str2);
        this.gYH.setText(str4);
        this.dYr.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fFz.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dvP.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gYH.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dYr.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        p(an.A(this.mUserData.getConcernNum()), an.A(this.mUserData.getFansNum()), an.A(this.mUserData.getPosts_num()), an.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.c(this.fFz, d.C0126d.cp_cont_b, 1);
            ak.c(this.gYE, d.C0126d.cp_cont_j, 1);
            ak.c(this.dvP, d.C0126d.cp_cont_b, 1);
            ak.c(this.gYG, d.C0126d.cp_cont_j, 1);
            ak.c(this.gYF, d.f.icon_news_down_bar_one);
            ak.c(this.gYH, d.C0126d.cp_cont_b, 1);
            ak.c(this.gYI, d.C0126d.cp_cont_j, 1);
            ak.c(this.dYr, d.C0126d.cp_cont_b, 1);
            ak.c(this.gYJ, d.C0126d.cp_cont_j, 1);
            ak.j(this.gYK, d.C0126d.cp_bg_line_b);
            ak.j(this.gYL, d.C0126d.cp_bg_line_b);
            ak.j(this.gYM, d.C0126d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.k.person_privacy_toast), an.cU(i)), d.f.icon_toast_game_error).tK();
    }

    @Override // com.baidu.tieba.view.e
    public void ng(boolean z) {
        if (this.gYF != null) {
            if (z) {
                this.gYF.setVisibility(0);
            } else {
                this.gYF.setVisibility(8);
            }
        }
    }
}
