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
    private View.OnClickListener coI;
    private TextView eGr;
    private TextView eau;
    private TextView gjV;
    private g grK;
    private TextView hEH;
    private ImageView hEI;
    private TextView hEJ;
    private TextView hEK;
    private TextView hEL;
    private TextView hEM;
    private View hEN;
    private View hEO;
    private View hEP;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hEQ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjV.getId() && id != PersonHeaderAttentionView.this.hEH.getId()) {
                        if (id != PersonHeaderAttentionView.this.eau.getId() && id != PersonHeaderAttentionView.this.hEJ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEK.getId() || id == PersonHeaderAttentionView.this.hEL.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hEQ.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hEQ.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hEQ.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grK != null) {
                        this.hEQ.djh = new Bundle();
                        this.hEQ.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grK.a(view, this.hEQ);
                    }
                }
            }
        };
        init(context);
        bKx();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hEQ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjV.getId() && id != PersonHeaderAttentionView.this.hEH.getId()) {
                        if (id != PersonHeaderAttentionView.this.eau.getId() && id != PersonHeaderAttentionView.this.hEJ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEK.getId() || id == PersonHeaderAttentionView.this.hEL.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hEQ.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hEQ.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hEQ.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grK != null) {
                        this.hEQ.djh = new Bundle();
                        this.hEQ.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grK.a(view, this.hEQ);
                    }
                }
            }
        };
        init(context);
        bKx();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hEQ = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjV.getId() && id != PersonHeaderAttentionView.this.hEH.getId()) {
                        if (id != PersonHeaderAttentionView.this.eau.getId() && id != PersonHeaderAttentionView.this.hEJ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEK.getId() || id == PersonHeaderAttentionView.this.hEL.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hEQ.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hEQ.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hEQ.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grK != null) {
                        this.hEQ.djh = new Bundle();
                        this.hEQ.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grK.a(view, this.hEQ);
                    }
                }
            }
        };
        init(context);
        bKx();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.eau = (TextView) findViewById(e.g.person_header_fans_num);
        this.hEJ = (TextView) findViewById(e.g.person_header_fans_des);
        this.hEI = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gjV = (TextView) findViewById(e.g.person_header_attention_num);
        this.hEH = (TextView) findViewById(e.g.person_header_attention_des);
        this.hEK = (TextView) findViewById(e.g.person_header_bar_num);
        this.hEL = (TextView) findViewById(e.g.person_header_bar_des);
        this.eGr = (TextView) findViewById(e.g.person_header_thread_num);
        this.eGr.setVisibility(8);
        this.hEM = (TextView) findViewById(e.g.person_header_thread_des);
        this.hEM.setVisibility(8);
        this.hEN = findViewById(e.g.divider_for_fans_and_attention);
        this.hEO = findViewById(e.g.divider_for_attention_and_bar);
        this.hEP = findViewById(e.g.divider_for_bar_and_thread);
        this.hEP.setVisibility(8);
    }

    private void bKx() {
        this.eau.setOnClickListener(this.coI);
        this.hEJ.setOnClickListener(this.coI);
        this.gjV.setOnClickListener(this.coI);
        this.hEH.setOnClickListener(this.coI);
        this.hEK.setOnClickListener(this.coI);
        this.hEL.setOnClickListener(this.coI);
        this.eGr.setOnClickListener(this.coI);
        this.hEM.setOnClickListener(this.coI);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.grK = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gjV.setText(str);
        this.eau.setText(str2);
        this.hEK.setText(str4);
        this.eGr.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gjV.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.eau.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hEK.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eGr.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        q(ao.M(this.mUserData.getConcernNum()), ao.M(this.mUserData.getFansNum()), ao.M(this.mUserData.getPosts_num()), ao.M(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gjV, e.d.cp_cont_b, 1);
            al.c(this.hEH, e.d.cp_cont_j, 1);
            al.c(this.eau, e.d.cp_cont_b, 1);
            al.c(this.hEJ, e.d.cp_cont_j, 1);
            al.c(this.hEI, e.f.icon_news_down_bar_one);
            al.c(this.hEK, e.d.cp_cont_b, 1);
            al.c(this.hEL, e.d.cp_cont_j, 1);
            al.c(this.eGr, e.d.cp_cont_b, 1);
            al.c(this.hEM, e.d.cp_cont_j, 1);
            al.j(this.hEN, e.d.cp_bg_line_b);
            al.j(this.hEO, e.d.cp_bg_line_b);
            al.j(this.hEP, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.ds(i)), e.f.icon_toast_game_error).AC();
    }

    @Override // com.baidu.tieba.view.e
    public void nW(boolean z) {
        if (this.hEI != null) {
            if (z) {
                this.hEI.setVisibility(0);
            } else {
                this.hEI.setVisibility(8);
            }
        }
    }
}
