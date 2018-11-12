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
    private View.OnClickListener coU;
    private TextView eHL;
    private TextView ebP;
    private TextView glv;
    private g gtl;
    private View hGA;
    private TextView hGs;
    private ImageView hGt;
    private TextView hGu;
    private TextView hGv;
    private TextView hGw;
    private TextView hGx;
    private View hGy;
    private View hGz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hGB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bG(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.glv.getId() && id != PersonHeaderAttentionView.this.hGs.getId()) {
                        if (id != PersonHeaderAttentionView.this.ebP.getId() && id != PersonHeaderAttentionView.this.hGu.getId()) {
                            if (id == PersonHeaderAttentionView.this.hGv.getId() || id == PersonHeaderAttentionView.this.hGw.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 2)) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hGB.dkl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hGB.dkl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hGB.dkl = 4;
                    }
                    if (PersonHeaderAttentionView.this.gtl != null) {
                        this.hGB.dkm = new Bundle();
                        this.hGB.dkm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gtl.a(view, this.hGB);
                    }
                }
            }
        };
        init(context);
        bJW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hGB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bG(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.glv.getId() && id != PersonHeaderAttentionView.this.hGs.getId()) {
                        if (id != PersonHeaderAttentionView.this.ebP.getId() && id != PersonHeaderAttentionView.this.hGu.getId()) {
                            if (id == PersonHeaderAttentionView.this.hGv.getId() || id == PersonHeaderAttentionView.this.hGw.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 2)) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hGB.dkl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hGB.dkl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hGB.dkl = 4;
                    }
                    if (PersonHeaderAttentionView.this.gtl != null) {
                        this.hGB.dkm = new Bundle();
                        this.hGB.dkm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gtl.a(view, this.hGB);
                    }
                }
            }
        };
        init(context);
        bJW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hGB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bG(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.glv.getId() && id != PersonHeaderAttentionView.this.hGs.getId()) {
                        if (id != PersonHeaderAttentionView.this.ebP.getId() && id != PersonHeaderAttentionView.this.hGu.getId()) {
                            if (id == PersonHeaderAttentionView.this.hGv.getId() || id == PersonHeaderAttentionView.this.hGw.getId()) {
                                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kw() != 2)) {
                                    PersonHeaderAttentionView.this.wp(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hGB.dkl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hGB.dkl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "9"));
                        this.hGB.dkl = 4;
                    }
                    if (PersonHeaderAttentionView.this.gtl != null) {
                        this.hGB.dkm = new Bundle();
                        this.hGB.dkm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gtl.a(view, this.hGB);
                    }
                }
            }
        };
        init(context);
        bJW();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.ebP = (TextView) findViewById(e.g.person_header_fans_num);
        this.hGu = (TextView) findViewById(e.g.person_header_fans_des);
        this.hGt = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.glv = (TextView) findViewById(e.g.person_header_attention_num);
        this.hGs = (TextView) findViewById(e.g.person_header_attention_des);
        this.hGv = (TextView) findViewById(e.g.person_header_bar_num);
        this.hGw = (TextView) findViewById(e.g.person_header_bar_des);
        this.eHL = (TextView) findViewById(e.g.person_header_thread_num);
        this.eHL.setVisibility(8);
        this.hGx = (TextView) findViewById(e.g.person_header_thread_des);
        this.hGx.setVisibility(8);
        this.hGy = findViewById(e.g.divider_for_fans_and_attention);
        this.hGz = findViewById(e.g.divider_for_attention_and_bar);
        this.hGA = findViewById(e.g.divider_for_bar_and_thread);
        this.hGA.setVisibility(8);
    }

    private void bJW() {
        this.ebP.setOnClickListener(this.coU);
        this.hGu.setOnClickListener(this.coU);
        this.glv.setOnClickListener(this.coU);
        this.hGs.setOnClickListener(this.coU);
        this.hGv.setOnClickListener(this.coU);
        this.hGw.setOnClickListener(this.coU);
        this.eHL.setOnClickListener(this.coU);
        this.hGx.setOnClickListener(this.coU);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gtl = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.glv.setText(str);
        this.ebP.setText(str2);
        this.hGv.setText(str4);
        this.eHL.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.glv.setTextSize(0, l.h(this.mContext, e.C0200e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.ebP.setTextSize(0, l.h(this.mContext, e.C0200e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hGv.setTextSize(0, l.h(this.mContext, e.C0200e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eHL.setTextSize(0, l.h(this.mContext, e.C0200e.ds32));
        }
        q(ao.O(this.mUserData.getConcernNum()), ao.O(this.mUserData.getFansNum()), ao.O(this.mUserData.getPosts_num()), ao.O(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.glv, e.d.cp_cont_b, 1);
            al.c(this.hGs, e.d.cp_cont_j, 1);
            al.c(this.ebP, e.d.cp_cont_b, 1);
            al.c(this.hGu, e.d.cp_cont_j, 1);
            al.c(this.hGt, e.f.icon_news_down_bar_one);
            al.c(this.hGv, e.d.cp_cont_b, 1);
            al.c(this.hGw, e.d.cp_cont_j, 1);
            al.c(this.eHL, e.d.cp_cont_b, 1);
            al.c(this.hGx, e.d.cp_cont_j, 1);
            al.j(this.hGy, e.d.cp_bg_line_b);
            al.j(this.hGz, e.d.cp_bg_line_b);
            al.j(this.hGA, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.dG(i)), e.f.icon_toast_game_error).AJ();
    }

    @Override // com.baidu.tieba.view.e
    public void ok(boolean z) {
        if (this.hGt != null) {
            if (z) {
                this.hGt.setVisibility(0);
            } else {
                this.hGt.setVisibility(8);
            }
        }
    }
}
