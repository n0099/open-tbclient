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
    private View.OnClickListener dIW;
    private TextView fAA;
    private TextView gil;
    private TextView hMr;
    private g hTW;
    private TextView jiA;
    private TextView jiB;
    private TextView jiC;
    private TextView jiD;
    private View jiE;
    private View jiF;
    private View jiG;
    private TextView jiy;
    private ImageView jiz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMr.getId() && id != PersonHeaderAttentionView.this.jiy.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAA.getId() && id != PersonHeaderAttentionView.this.jiA.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiB.getId() || id == PersonHeaderAttentionView.this.jiC.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiH.eHy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiH.eHy = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiH.eHy = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTW != null) {
                        this.jiH.eHz = new Bundle();
                        this.jiH.eHz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTW.a(view, this.jiH);
                    }
                }
            }
        };
        init(context);
        cnb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMr.getId() && id != PersonHeaderAttentionView.this.jiy.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAA.getId() && id != PersonHeaderAttentionView.this.jiA.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiB.getId() || id == PersonHeaderAttentionView.this.jiC.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiH.eHy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiH.eHy = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiH.eHy = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTW != null) {
                        this.jiH.eHz = new Bundle();
                        this.jiH.eHz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTW.a(view, this.jiH);
                    }
                }
            }
        };
        init(context);
        cnb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMr.getId() && id != PersonHeaderAttentionView.this.jiy.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAA.getId() && id != PersonHeaderAttentionView.this.jiA.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiB.getId() || id == PersonHeaderAttentionView.this.jiC.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alr() != 2)) {
                                    PersonHeaderAttentionView.this.AN(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiH.eHy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiH.eHy = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiH.eHy = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTW != null) {
                        this.jiH.eHz = new Bundle();
                        this.jiH.eHz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTW.a(view, this.jiH);
                    }
                }
            }
        };
        init(context);
        cnb();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fAA = (TextView) findViewById(d.g.person_header_fans_num);
        this.jiA = (TextView) findViewById(d.g.person_header_fans_des);
        this.jiz = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.hMr = (TextView) findViewById(d.g.person_header_attention_num);
        this.jiy = (TextView) findViewById(d.g.person_header_attention_des);
        this.jiB = (TextView) findViewById(d.g.person_header_bar_num);
        this.jiC = (TextView) findViewById(d.g.person_header_bar_des);
        this.gil = (TextView) findViewById(d.g.person_header_thread_num);
        this.gil.setVisibility(8);
        this.jiD = (TextView) findViewById(d.g.person_header_thread_des);
        this.jiD.setVisibility(8);
        this.jiE = findViewById(d.g.divider_for_fans_and_attention);
        this.jiF = findViewById(d.g.divider_for_attention_and_bar);
        this.jiG = findViewById(d.g.divider_for_bar_and_thread);
        this.jiG.setVisibility(8);
    }

    private void cnb() {
        this.fAA.setOnClickListener(this.dIW);
        this.jiA.setOnClickListener(this.dIW);
        this.hMr.setOnClickListener(this.dIW);
        this.jiy.setOnClickListener(this.dIW);
        this.jiB.setOnClickListener(this.dIW);
        this.jiC.setOnClickListener(this.dIW);
        this.gil.setOnClickListener(this.dIW);
        this.jiD.setOnClickListener(this.dIW);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.hTW = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.hMr.setText(str);
        this.fAA.setText(str2);
        this.jiB.setText(str4);
        this.gil.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.hMr.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fAA.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jiB.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gil.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        u(ap.ay(this.mUserData.getConcernNum()), ap.ay(this.mUserData.getFansNum()), ap.ay(this.mUserData.getPosts_num()), ap.ay(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.d(this.hMr, d.C0277d.cp_cont_b, 1);
            al.d(this.jiy, d.C0277d.cp_cont_j, 1);
            al.d(this.fAA, d.C0277d.cp_cont_b, 1);
            al.d(this.jiA, d.C0277d.cp_cont_j, 1);
            al.c(this.jiz, d.f.icon_news_down_bar_one);
            al.d(this.jiB, d.C0277d.cp_cont_b, 1);
            al.d(this.jiC, d.C0277d.cp_cont_j, 1);
            al.d(this.gil, d.C0277d.cp_cont_b, 1);
            al.d(this.jiD, d.C0277d.cp_cont_j, 1);
            al.l(this.jiE, d.C0277d.cp_bg_line_b);
            al.l(this.jiF, d.C0277d.cp_bg_line_b);
            al.l(this.jiG, d.C0277d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), ap.hy(i)), d.f.icon_toast_game_error).abh();
    }

    @Override // com.baidu.tieba.view.e
    public void qQ(boolean z) {
        if (this.jiz != null) {
            if (z) {
                this.jiz.setVisibility(0);
            } else {
                this.jiz.setVisibility(8);
            }
        }
    }
}
