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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements g {
    private View.OnClickListener cxV;
    private TextView dZK;
    private TextView eCt;
    private TextView gjJ;
    private i grx;
    private TextView hAK;
    private ImageView hAL;
    private TextView hAM;
    private TextView hAN;
    private TextView hAO;
    private TextView hAP;
    private View hAQ;
    private View hAR;
    private View hAS;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hAT = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjJ.getId() && id != PersonHeaderAttentionView.this.hAK.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZK.getId() && id != PersonHeaderAttentionView.this.hAM.getId()) {
                            if (id == PersonHeaderAttentionView.this.hAN.getId() || id == PersonHeaderAttentionView.this.hAO.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hAT.drl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hAT.drl = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hAT.drl = 4;
                    }
                    if (PersonHeaderAttentionView.this.grx != null) {
                        this.hAT.drm = new Bundle();
                        this.hAT.drm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grx.a(view, this.hAT);
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
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hAT = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjJ.getId() && id != PersonHeaderAttentionView.this.hAK.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZK.getId() && id != PersonHeaderAttentionView.this.hAM.getId()) {
                            if (id == PersonHeaderAttentionView.this.hAN.getId() || id == PersonHeaderAttentionView.this.hAO.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hAT.drl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hAT.drl = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hAT.drl = 4;
                    }
                    if (PersonHeaderAttentionView.this.grx != null) {
                        this.hAT.drm = new Bundle();
                        this.hAT.drm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grx.a(view, this.hAT);
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
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hAT = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjJ.getId() && id != PersonHeaderAttentionView.this.hAK.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZK.getId() && id != PersonHeaderAttentionView.this.hAM.getId()) {
                            if (id == PersonHeaderAttentionView.this.hAN.getId() || id == PersonHeaderAttentionView.this.hAO.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kz() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hAT.drl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hAT.drl = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hAT.drl = 4;
                    }
                    if (PersonHeaderAttentionView.this.grx != null) {
                        this.hAT.drm = new Bundle();
                        this.hAT.drm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grx.a(view, this.hAT);
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
        this.dZK = (TextView) findViewById(d.g.person_header_fans_num);
        this.hAM = (TextView) findViewById(d.g.person_header_fans_des);
        this.hAL = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.gjJ = (TextView) findViewById(d.g.person_header_attention_num);
        this.hAK = (TextView) findViewById(d.g.person_header_attention_des);
        this.hAN = (TextView) findViewById(d.g.person_header_bar_num);
        this.hAO = (TextView) findViewById(d.g.person_header_bar_des);
        this.eCt = (TextView) findViewById(d.g.person_header_thread_num);
        this.eCt.setVisibility(8);
        this.hAP = (TextView) findViewById(d.g.person_header_thread_des);
        this.hAP.setVisibility(8);
        this.hAQ = findViewById(d.g.divider_for_fans_and_attention);
        this.hAR = findViewById(d.g.divider_for_attention_and_bar);
        this.hAS = findViewById(d.g.divider_for_bar_and_thread);
        this.hAS.setVisibility(8);
    }

    private void bEN() {
        this.dZK.setOnClickListener(this.cxV);
        this.hAM.setOnClickListener(this.cxV);
        this.gjJ.setOnClickListener(this.cxV);
        this.hAK.setOnClickListener(this.cxV);
        this.hAN.setOnClickListener(this.cxV);
        this.hAO.setOnClickListener(this.cxV);
        this.eCt.setOnClickListener(this.cxV);
        this.hAP.setOnClickListener(this.cxV);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.grx = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.gjJ.setText(str);
        this.dZK.setText(str2);
        this.hAN.setText(str4);
        this.eCt.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gjJ.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dZK.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hAN.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eCt.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        p(am.I(this.mUserData.getConcernNum()), am.I(this.mUserData.getFansNum()), am.I(this.mUserData.getPosts_num()), am.I(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.gjJ, d.C0141d.cp_cont_b, 1);
            aj.e(this.hAK, d.C0141d.cp_cont_j, 1);
            aj.e(this.dZK, d.C0141d.cp_cont_b, 1);
            aj.e(this.hAM, d.C0141d.cp_cont_j, 1);
            aj.c(this.hAL, d.f.icon_news_down_bar_one);
            aj.e(this.hAN, d.C0141d.cp_cont_b, 1);
            aj.e(this.hAO, d.C0141d.cp_cont_j, 1);
            aj.e(this.eCt, d.C0141d.cp_cont_b, 1);
            aj.e(this.hAP, d.C0141d.cp_cont_j, 1);
            aj.t(this.hAQ, d.C0141d.cp_bg_line_b);
            aj.t(this.hAR, d.C0141d.cp_bg_line_b);
            aj.t(this.hAS, d.C0141d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fU(i)), d.f.icon_toast_game_error).Bc();
    }

    @Override // com.baidu.tieba.view.g
    public void nw(boolean z) {
        if (this.hAL != null) {
            if (z) {
                this.hAL.setVisibility(0);
            } else {
                this.hAL.setVisibility(8);
            }
        }
    }
}
