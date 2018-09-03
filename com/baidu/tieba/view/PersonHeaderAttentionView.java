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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener caq;
    private TextView dLi;
    private TextView erm;
    private TextView fVe;
    private g gcU;
    private TextView hpC;
    private ImageView hpD;
    private TextView hpE;
    private TextView hpF;
    private TextView hpG;
    private TextView hpH;
    private View hpI;
    private View hpJ;
    private View hpK;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpL = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVe.getId() && id != PersonHeaderAttentionView.this.hpC.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLi.getId() && id != PersonHeaderAttentionView.this.hpE.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpF.getId() || id == PersonHeaderAttentionView.this.hpG.getId()) {
                                TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpL.cVc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpL.cVc = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ae("obj_locate", "9"));
                        this.hpL.cVc = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcU != null) {
                        this.hpL.cVd = new Bundle();
                        this.hpL.cVd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcU.a(view, this.hpL);
                    }
                }
            }
        };
        init(context);
        bEu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpL = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVe.getId() && id != PersonHeaderAttentionView.this.hpC.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLi.getId() && id != PersonHeaderAttentionView.this.hpE.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpF.getId() || id == PersonHeaderAttentionView.this.hpG.getId()) {
                                TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpL.cVc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpL.cVc = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ae("obj_locate", "9"));
                        this.hpL.cVc = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcU != null) {
                        this.hpL.cVd = new Bundle();
                        this.hpL.cVd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcU.a(view, this.hpL);
                    }
                }
            }
        };
        init(context);
        bEu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpL = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVe.getId() && id != PersonHeaderAttentionView.this.hpC.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLi.getId() && id != PersonHeaderAttentionView.this.hpE.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpF.getId() || id == PersonHeaderAttentionView.this.hpG.getId()) {
                                TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpL.cVc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpL.cVc = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ae("obj_locate", "9"));
                        this.hpL.cVc = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcU != null) {
                        this.hpL.cVd = new Bundle();
                        this.hpL.cVd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcU.a(view, this.hpL);
                    }
                }
            }
        };
        init(context);
        bEu();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(f.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dLi = (TextView) findViewById(f.g.person_header_fans_num);
        this.hpE = (TextView) findViewById(f.g.person_header_fans_des);
        this.hpD = (ImageView) findViewById(f.g.person_header_fans_red_tip);
        this.fVe = (TextView) findViewById(f.g.person_header_attention_num);
        this.hpC = (TextView) findViewById(f.g.person_header_attention_des);
        this.hpF = (TextView) findViewById(f.g.person_header_bar_num);
        this.hpG = (TextView) findViewById(f.g.person_header_bar_des);
        this.erm = (TextView) findViewById(f.g.person_header_thread_num);
        this.erm.setVisibility(8);
        this.hpH = (TextView) findViewById(f.g.person_header_thread_des);
        this.hpH.setVisibility(8);
        this.hpI = findViewById(f.g.divider_for_fans_and_attention);
        this.hpJ = findViewById(f.g.divider_for_attention_and_bar);
        this.hpK = findViewById(f.g.divider_for_bar_and_thread);
        this.hpK.setVisibility(8);
    }

    private void bEu() {
        this.dLi.setOnClickListener(this.caq);
        this.hpE.setOnClickListener(this.caq);
        this.fVe.setOnClickListener(this.caq);
        this.hpC.setOnClickListener(this.caq);
        this.hpF.setOnClickListener(this.caq);
        this.hpG.setOnClickListener(this.caq);
        this.erm.setOnClickListener(this.caq);
        this.hpH.setOnClickListener(this.caq);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gcU = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.fVe.setText(str);
        this.dLi.setText(str2);
        this.hpF.setText(str4);
        this.erm.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fVe.setTextSize(0, l.f(this.mContext, f.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dLi.setTextSize(0, l.f(this.mContext, f.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hpF.setTextSize(0, l.f(this.mContext, f.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.erm.setTextSize(0, l.f(this.mContext, f.e.ds32));
        }
        q(ap.G(this.mUserData.getConcernNum()), ap.G(this.mUserData.getFansNum()), ap.G(this.mUserData.getPosts_num()), ap.G(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.c(this.fVe, f.d.cp_cont_b, 1);
            am.c(this.hpC, f.d.cp_cont_j, 1);
            am.c(this.dLi, f.d.cp_cont_b, 1);
            am.c(this.hpE, f.d.cp_cont_j, 1);
            am.c(this.hpD, f.C0146f.icon_news_down_bar_one);
            am.c(this.hpF, f.d.cp_cont_b, 1);
            am.c(this.hpG, f.d.cp_cont_j, 1);
            am.c(this.erm, f.d.cp_cont_b, 1);
            am.c(this.hpH, f.d.cp_cont_j, 1);
            am.j(this.hpI, f.d.cp_bg_line_b);
            am.j(this.hpJ, f.d.cp_bg_line_b);
            am.j(this.hpK, f.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(f.j.person_privacy_toast), ap.cZ(i)), f.C0146f.icon_toast_game_error).xm();
    }

    @Override // com.baidu.tieba.view.e
    public void nj(boolean z) {
        if (this.hpD != null) {
            if (z) {
                this.hpD.setVisibility(0);
            } else {
                this.hpD.setVisibility(8);
            }
        }
    }
}
