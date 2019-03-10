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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener dJa;
    private TextView fAB;
    private TextView gim;
    private TextView hMx;
    private g hUc;
    private TextView jiG;
    private ImageView jiH;
    private TextView jiI;
    private TextView jiJ;
    private TextView jiK;
    private TextView jiL;
    private View jiM;
    private View jiN;
    private View jiO;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiP = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMx.getId() && id != PersonHeaderAttentionView.this.jiG.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jiI.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiJ.getId() || id == PersonHeaderAttentionView.this.jiK.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiP.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiP.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiP.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUc != null) {
                        this.jiP.eHD = new Bundle();
                        this.jiP.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUc.a(view, this.jiP);
                    }
                }
            }
        };
        init(context);
        cmY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiP = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMx.getId() && id != PersonHeaderAttentionView.this.jiG.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jiI.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiJ.getId() || id == PersonHeaderAttentionView.this.jiK.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiP.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiP.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiP.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUc != null) {
                        this.jiP.eHD = new Bundle();
                        this.jiP.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUc.a(view, this.jiP);
                    }
                }
            }
        };
        init(context);
        cmY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiP = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMx.getId() && id != PersonHeaderAttentionView.this.jiG.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jiI.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiJ.getId() || id == PersonHeaderAttentionView.this.jiK.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiP.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiP.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiP.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUc != null) {
                        this.jiP.eHD = new Bundle();
                        this.jiP.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUc.a(view, this.jiP);
                    }
                }
            }
        };
        init(context);
        cmY();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fAB = (TextView) findViewById(d.g.person_header_fans_num);
        this.jiI = (TextView) findViewById(d.g.person_header_fans_des);
        this.jiH = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.hMx = (TextView) findViewById(d.g.person_header_attention_num);
        this.jiG = (TextView) findViewById(d.g.person_header_attention_des);
        this.jiJ = (TextView) findViewById(d.g.person_header_bar_num);
        this.jiK = (TextView) findViewById(d.g.person_header_bar_des);
        this.gim = (TextView) findViewById(d.g.person_header_thread_num);
        this.gim.setVisibility(8);
        this.jiL = (TextView) findViewById(d.g.person_header_thread_des);
        this.jiL.setVisibility(8);
        this.jiM = findViewById(d.g.divider_for_fans_and_attention);
        this.jiN = findViewById(d.g.divider_for_attention_and_bar);
        this.jiO = findViewById(d.g.divider_for_bar_and_thread);
        this.jiO.setVisibility(8);
    }

    private void cmY() {
        this.fAB.setOnClickListener(this.dJa);
        this.jiI.setOnClickListener(this.dJa);
        this.hMx.setOnClickListener(this.dJa);
        this.jiG.setOnClickListener(this.dJa);
        this.jiJ.setOnClickListener(this.dJa);
        this.jiK.setOnClickListener(this.dJa);
        this.gim.setOnClickListener(this.dJa);
        this.jiL.setOnClickListener(this.dJa);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.hUc = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.hMx.setText(str);
        this.fAB.setText(str2);
        this.jiJ.setText(str4);
        this.gim.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.hMx.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fAB.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jiJ.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gim.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        u(ap.ay(this.mUserData.getConcernNum()), ap.ay(this.mUserData.getFansNum()), ap.ay(this.mUserData.getPosts_num()), ap.ay(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.d(this.hMx, d.C0236d.cp_cont_b, 1);
            al.d(this.jiG, d.C0236d.cp_cont_j, 1);
            al.d(this.fAB, d.C0236d.cp_cont_b, 1);
            al.d(this.jiI, d.C0236d.cp_cont_j, 1);
            al.c(this.jiH, d.f.icon_news_down_bar_one);
            al.d(this.jiJ, d.C0236d.cp_cont_b, 1);
            al.d(this.jiK, d.C0236d.cp_cont_j, 1);
            al.d(this.gim, d.C0236d.cp_cont_b, 1);
            al.d(this.jiL, d.C0236d.cp_cont_j, 1);
            al.l(this.jiM, d.C0236d.cp_bg_line_b);
            al.l(this.jiN, d.C0236d.cp_bg_line_b);
            al.l(this.jiO, d.C0236d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), ap.hy(i)), d.f.icon_toast_game_error).abh();
    }

    @Override // com.baidu.tieba.view.e
    public void qQ(boolean z) {
        if (this.jiH != null) {
            if (z) {
                this.jiH.setVisibility(0);
            } else {
                this.jiH.setVisibility(8);
            }
        }
    }
}
