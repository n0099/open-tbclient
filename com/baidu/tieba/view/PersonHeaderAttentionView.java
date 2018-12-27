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
    private View.OnClickListener cts;
    private TextView eRr;
    private TextView eli;
    private g gCS;
    private TextView gvc;
    private TextView hQO;
    private ImageView hQP;
    private TextView hQQ;
    private TextView hQR;
    private TextView hQS;
    private TextView hQT;
    private View hQU;
    private View hQV;
    private View hQW;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hQX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gvc.getId() && id != PersonHeaderAttentionView.this.hQO.getId()) {
                        if (id != PersonHeaderAttentionView.this.eli.getId() && id != PersonHeaderAttentionView.this.hQQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hQR.getId() || id == PersonHeaderAttentionView.this.hQS.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 2)) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hQX.dtB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hQX.dtB = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hQX.dtB = 4;
                    }
                    if (PersonHeaderAttentionView.this.gCS != null) {
                        this.hQX.dtC = new Bundle();
                        this.hQX.dtC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gCS.a(view, this.hQX);
                    }
                }
            }
        };
        init(context);
        bMQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hQX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gvc.getId() && id != PersonHeaderAttentionView.this.hQO.getId()) {
                        if (id != PersonHeaderAttentionView.this.eli.getId() && id != PersonHeaderAttentionView.this.hQQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hQR.getId() || id == PersonHeaderAttentionView.this.hQS.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 2)) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hQX.dtB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hQX.dtB = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hQX.dtB = 4;
                    }
                    if (PersonHeaderAttentionView.this.gCS != null) {
                        this.hQX.dtC = new Bundle();
                        this.hQX.dtC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gCS.a(view, this.hQX);
                    }
                }
            }
        };
        init(context);
        bMQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hQX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gvc.getId() && id != PersonHeaderAttentionView.this.hQO.getId()) {
                        if (id != PersonHeaderAttentionView.this.eli.getId() && id != PersonHeaderAttentionView.this.hQQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hQR.getId() || id == PersonHeaderAttentionView.this.hQS.getId()) {
                                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LB() != 2)) {
                                    PersonHeaderAttentionView.this.wZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hQX.dtB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hQX.dtB = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "9"));
                        this.hQX.dtB = 4;
                    }
                    if (PersonHeaderAttentionView.this.gCS != null) {
                        this.hQX.dtC = new Bundle();
                        this.hQX.dtC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gCS.a(view, this.hQX);
                    }
                }
            }
        };
        init(context);
        bMQ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.eli = (TextView) findViewById(e.g.person_header_fans_num);
        this.hQQ = (TextView) findViewById(e.g.person_header_fans_des);
        this.hQP = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gvc = (TextView) findViewById(e.g.person_header_attention_num);
        this.hQO = (TextView) findViewById(e.g.person_header_attention_des);
        this.hQR = (TextView) findViewById(e.g.person_header_bar_num);
        this.hQS = (TextView) findViewById(e.g.person_header_bar_des);
        this.eRr = (TextView) findViewById(e.g.person_header_thread_num);
        this.eRr.setVisibility(8);
        this.hQT = (TextView) findViewById(e.g.person_header_thread_des);
        this.hQT.setVisibility(8);
        this.hQU = findViewById(e.g.divider_for_fans_and_attention);
        this.hQV = findViewById(e.g.divider_for_attention_and_bar);
        this.hQW = findViewById(e.g.divider_for_bar_and_thread);
        this.hQW.setVisibility(8);
    }

    private void bMQ() {
        this.eli.setOnClickListener(this.cts);
        this.hQQ.setOnClickListener(this.cts);
        this.gvc.setOnClickListener(this.cts);
        this.hQO.setOnClickListener(this.cts);
        this.hQR.setOnClickListener(this.cts);
        this.hQS.setOnClickListener(this.cts);
        this.eRr.setOnClickListener(this.cts);
        this.hQT.setOnClickListener(this.cts);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gCS = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gvc.setText(str);
        this.eli.setText(str2);
        this.hQR.setText(str4);
        this.eRr.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gvc.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.eli.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hQR.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eRr.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        q(ao.W(this.mUserData.getConcernNum()), ao.W(this.mUserData.getFansNum()), ao.W(this.mUserData.getPosts_num()), ao.W(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gvc, e.d.cp_cont_b, 1);
            al.c(this.hQO, e.d.cp_cont_j, 1);
            al.c(this.eli, e.d.cp_cont_b, 1);
            al.c(this.hQQ, e.d.cp_cont_j, 1);
            al.c(this.hQP, e.f.icon_news_down_bar_one);
            al.c(this.hQR, e.d.cp_cont_b, 1);
            al.c(this.hQS, e.d.cp_cont_j, 1);
            al.c(this.eRr, e.d.cp_cont_b, 1);
            al.c(this.hQT, e.d.cp_cont_j, 1);
            al.j(this.hQU, e.d.cp_bg_line_b);
            al.j(this.hQV, e.d.cp_bg_line_b);
            al.j(this.hQW, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.dU(i)), e.f.icon_toast_game_error).BN();
    }

    @Override // com.baidu.tieba.view.e
    public void op(boolean z) {
        if (this.hQP != null) {
            if (z) {
                this.hQP.setVisibility(0);
            } else {
                this.hQP.setVisibility(8);
            }
        }
    }
}
