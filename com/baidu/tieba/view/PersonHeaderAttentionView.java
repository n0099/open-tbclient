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
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener cgg;
    private TextView dSA;
    private TextView eyH;
    private TextView gct;
    private g gkl;
    private View hxA;
    private View hxB;
    private View hxC;
    private TextView hxu;
    private ImageView hxv;
    private TextView hxw;
    private TextView hxx;
    private TextView hxy;
    private TextView hxz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hxD = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bA(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gct.getId() && id != PersonHeaderAttentionView.this.hxu.getId()) {
                        if (id != PersonHeaderAttentionView.this.dSA.getId() && id != PersonHeaderAttentionView.this.hxw.getId()) {
                            if (id == PersonHeaderAttentionView.this.hxx.getId() || id == PersonHeaderAttentionView.this.hxy.getId()) {
                                TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 2)) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hxD.daV = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hxD.daV = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").al("obj_locate", "9"));
                        this.hxD.daV = 4;
                    }
                    if (PersonHeaderAttentionView.this.gkl != null) {
                        this.hxD.daW = new Bundle();
                        this.hxD.daW.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gkl.a(view, this.hxD);
                    }
                }
            }
        };
        init(context);
        bHl();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hxD = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bA(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gct.getId() && id != PersonHeaderAttentionView.this.hxu.getId()) {
                        if (id != PersonHeaderAttentionView.this.dSA.getId() && id != PersonHeaderAttentionView.this.hxw.getId()) {
                            if (id == PersonHeaderAttentionView.this.hxx.getId() || id == PersonHeaderAttentionView.this.hxy.getId()) {
                                TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 2)) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hxD.daV = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hxD.daV = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").al("obj_locate", "9"));
                        this.hxD.daV = 4;
                    }
                    if (PersonHeaderAttentionView.this.gkl != null) {
                        this.hxD.daW = new Bundle();
                        this.hxD.daW.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gkl.a(view, this.hxD);
                    }
                }
            }
        };
        init(context);
        bHl();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hxD = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bA(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gct.getId() && id != PersonHeaderAttentionView.this.hxu.getId()) {
                        if (id != PersonHeaderAttentionView.this.dSA.getId() && id != PersonHeaderAttentionView.this.hxw.getId()) {
                            if (id == PersonHeaderAttentionView.this.hxx.getId() || id == PersonHeaderAttentionView.this.hxy.getId()) {
                                TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Il() != 2)) {
                                    PersonHeaderAttentionView.this.vz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hxD.daV = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").al("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hxD.daV = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").al("obj_locate", "9"));
                        this.hxD.daV = 4;
                    }
                    if (PersonHeaderAttentionView.this.gkl != null) {
                        this.hxD.daW = new Bundle();
                        this.hxD.daW.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gkl.a(view, this.hxD);
                    }
                }
            }
        };
        init(context);
        bHl();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dSA = (TextView) findViewById(e.g.person_header_fans_num);
        this.hxw = (TextView) findViewById(e.g.person_header_fans_des);
        this.hxv = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gct = (TextView) findViewById(e.g.person_header_attention_num);
        this.hxu = (TextView) findViewById(e.g.person_header_attention_des);
        this.hxx = (TextView) findViewById(e.g.person_header_bar_num);
        this.hxy = (TextView) findViewById(e.g.person_header_bar_des);
        this.eyH = (TextView) findViewById(e.g.person_header_thread_num);
        this.eyH.setVisibility(8);
        this.hxz = (TextView) findViewById(e.g.person_header_thread_des);
        this.hxz.setVisibility(8);
        this.hxA = findViewById(e.g.divider_for_fans_and_attention);
        this.hxB = findViewById(e.g.divider_for_attention_and_bar);
        this.hxC = findViewById(e.g.divider_for_bar_and_thread);
        this.hxC.setVisibility(8);
    }

    private void bHl() {
        this.dSA.setOnClickListener(this.cgg);
        this.hxw.setOnClickListener(this.cgg);
        this.gct.setOnClickListener(this.cgg);
        this.hxu.setOnClickListener(this.cgg);
        this.hxx.setOnClickListener(this.cgg);
        this.hxy.setOnClickListener(this.cgg);
        this.eyH.setOnClickListener(this.cgg);
        this.hxz.setOnClickListener(this.cgg);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gkl = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gct.setText(str);
        this.dSA.setText(str2);
        this.hxx.setText(str4);
        this.eyH.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gct.setTextSize(0, l.h(this.mContext, e.C0141e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dSA.setTextSize(0, l.h(this.mContext, e.C0141e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hxx.setTextSize(0, l.h(this.mContext, e.C0141e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eyH.setTextSize(0, l.h(this.mContext, e.C0141e.ds32));
        }
        q(ao.K(this.mUserData.getConcernNum()), ao.K(this.mUserData.getFansNum()), ao.K(this.mUserData.getPosts_num()), ao.K(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gct, e.d.cp_cont_b, 1);
            al.c(this.hxu, e.d.cp_cont_j, 1);
            al.c(this.dSA, e.d.cp_cont_b, 1);
            al.c(this.hxw, e.d.cp_cont_j, 1);
            al.c(this.hxv, e.f.icon_news_down_bar_one);
            al.c(this.hxx, e.d.cp_cont_b, 1);
            al.c(this.hxy, e.d.cp_cont_j, 1);
            al.c(this.eyH, e.d.cp_cont_b, 1);
            al.c(this.hxz, e.d.cp_cont_j, 1);
            al.j(this.hxA, e.d.cp_bg_line_b);
            al.j(this.hxB, e.d.cp_bg_line_b);
            al.j(this.hxC, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.di(i)), e.f.icon_toast_game_error).yt();
    }

    @Override // com.baidu.tieba.view.e
    public void nG(boolean z) {
        if (this.hxv != null) {
            if (z) {
                this.hxv.setVisibility(0);
            } else {
                this.hxv.setVisibility(8);
            }
        }
    }
}
