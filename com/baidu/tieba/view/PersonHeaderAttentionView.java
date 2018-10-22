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
    private TextView eGs;
    private TextView eav;
    private TextView gjW;
    private g grL;
    private TextView hEI;
    private ImageView hEJ;
    private TextView hEK;
    private TextView hEL;
    private TextView hEM;
    private TextView hEN;
    private View hEO;
    private View hEP;
    private View hEQ;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hER = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjW.getId() && id != PersonHeaderAttentionView.this.hEI.getId()) {
                        if (id != PersonHeaderAttentionView.this.eav.getId() && id != PersonHeaderAttentionView.this.hEK.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEL.getId() || id == PersonHeaderAttentionView.this.hEM.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hER.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hER.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hER.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grL != null) {
                        this.hER.djh = new Bundle();
                        this.hER.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grL.a(view, this.hER);
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
            com.baidu.tieba.g.a hER = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjW.getId() && id != PersonHeaderAttentionView.this.hEI.getId()) {
                        if (id != PersonHeaderAttentionView.this.eav.getId() && id != PersonHeaderAttentionView.this.hEK.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEL.getId() || id == PersonHeaderAttentionView.this.hEM.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hER.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hER.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hER.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grL != null) {
                        this.hER.djh = new Bundle();
                        this.hER.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grL.a(view, this.hER);
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
            com.baidu.tieba.g.a hER = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bI(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjW.getId() && id != PersonHeaderAttentionView.this.hEI.getId()) {
                        if (id != PersonHeaderAttentionView.this.eav.getId() && id != PersonHeaderAttentionView.this.hEK.getId()) {
                            if (id == PersonHeaderAttentionView.this.hEL.getId() || id == PersonHeaderAttentionView.this.hEM.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kk() != 2)) {
                                    PersonHeaderAttentionView.this.vW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hER.djg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hER.djg = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hER.djg = 4;
                    }
                    if (PersonHeaderAttentionView.this.grL != null) {
                        this.hER.djh = new Bundle();
                        this.hER.djh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grL.a(view, this.hER);
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
        this.eav = (TextView) findViewById(e.g.person_header_fans_num);
        this.hEK = (TextView) findViewById(e.g.person_header_fans_des);
        this.hEJ = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gjW = (TextView) findViewById(e.g.person_header_attention_num);
        this.hEI = (TextView) findViewById(e.g.person_header_attention_des);
        this.hEL = (TextView) findViewById(e.g.person_header_bar_num);
        this.hEM = (TextView) findViewById(e.g.person_header_bar_des);
        this.eGs = (TextView) findViewById(e.g.person_header_thread_num);
        this.eGs.setVisibility(8);
        this.hEN = (TextView) findViewById(e.g.person_header_thread_des);
        this.hEN.setVisibility(8);
        this.hEO = findViewById(e.g.divider_for_fans_and_attention);
        this.hEP = findViewById(e.g.divider_for_attention_and_bar);
        this.hEQ = findViewById(e.g.divider_for_bar_and_thread);
        this.hEQ.setVisibility(8);
    }

    private void bKx() {
        this.eav.setOnClickListener(this.coI);
        this.hEK.setOnClickListener(this.coI);
        this.gjW.setOnClickListener(this.coI);
        this.hEI.setOnClickListener(this.coI);
        this.hEL.setOnClickListener(this.coI);
        this.hEM.setOnClickListener(this.coI);
        this.eGs.setOnClickListener(this.coI);
        this.hEN.setOnClickListener(this.coI);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.grL = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gjW.setText(str);
        this.eav.setText(str2);
        this.hEL.setText(str4);
        this.eGs.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gjW.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.eav.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hEL.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eGs.setTextSize(0, l.h(this.mContext, e.C0175e.ds32));
        }
        q(ao.M(this.mUserData.getConcernNum()), ao.M(this.mUserData.getFansNum()), ao.M(this.mUserData.getPosts_num()), ao.M(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gjW, e.d.cp_cont_b, 1);
            al.c(this.hEI, e.d.cp_cont_j, 1);
            al.c(this.eav, e.d.cp_cont_b, 1);
            al.c(this.hEK, e.d.cp_cont_j, 1);
            al.c(this.hEJ, e.f.icon_news_down_bar_one);
            al.c(this.hEL, e.d.cp_cont_b, 1);
            al.c(this.hEM, e.d.cp_cont_j, 1);
            al.c(this.eGs, e.d.cp_cont_b, 1);
            al.c(this.hEN, e.d.cp_cont_j, 1);
            al.j(this.hEO, e.d.cp_bg_line_b);
            al.j(this.hEP, e.d.cp_bg_line_b);
            al.j(this.hEQ, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.ds(i)), e.f.icon_toast_game_error).AC();
    }

    @Override // com.baidu.tieba.view.e
    public void nW(boolean z) {
        if (this.hEJ != null) {
            if (z) {
                this.hEJ.setVisibility(0);
            } else {
                this.hEJ.setVisibility(8);
            }
        }
    }
}
