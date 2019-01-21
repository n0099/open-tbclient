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
    private View.OnClickListener cue;
    private TextView eSf;
    private TextView elP;
    private g gDX;
    private TextView gwh;
    private TextView hRW;
    private ImageView hRX;
    private TextView hRY;
    private TextView hRZ;
    private TextView hSa;
    private TextView hSb;
    private View hSc;
    private View hSd;
    private View hSe;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSf = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwh.getId() && id != PersonHeaderAttentionView.this.hRW.getId()) {
                        if (id != PersonHeaderAttentionView.this.elP.getId() && id != PersonHeaderAttentionView.this.hRY.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRZ.getId() || id == PersonHeaderAttentionView.this.hSa.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSf.dul = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSf.dul = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSf.dul = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDX != null) {
                        this.hSf.dum = new Bundle();
                        this.hSf.dum.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDX.a(view, this.hSf);
                    }
                }
            }
        };
        init(context);
        bNy();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSf = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwh.getId() && id != PersonHeaderAttentionView.this.hRW.getId()) {
                        if (id != PersonHeaderAttentionView.this.elP.getId() && id != PersonHeaderAttentionView.this.hRY.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRZ.getId() || id == PersonHeaderAttentionView.this.hSa.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSf.dul = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSf.dul = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSf.dul = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDX != null) {
                        this.hSf.dum = new Bundle();
                        this.hSf.dum.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDX.a(view, this.hSf);
                    }
                }
            }
        };
        init(context);
        bNy();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSf = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwh.getId() && id != PersonHeaderAttentionView.this.hRW.getId()) {
                        if (id != PersonHeaderAttentionView.this.elP.getId() && id != PersonHeaderAttentionView.this.hRY.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRZ.getId() || id == PersonHeaderAttentionView.this.hSa.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSf.dul = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSf.dul = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSf.dul = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDX != null) {
                        this.hSf.dum = new Bundle();
                        this.hSf.dum.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDX.a(view, this.hSf);
                    }
                }
            }
        };
        init(context);
        bNy();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(e.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.elP = (TextView) findViewById(e.g.person_header_fans_num);
        this.hRY = (TextView) findViewById(e.g.person_header_fans_des);
        this.hRX = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gwh = (TextView) findViewById(e.g.person_header_attention_num);
        this.hRW = (TextView) findViewById(e.g.person_header_attention_des);
        this.hRZ = (TextView) findViewById(e.g.person_header_bar_num);
        this.hSa = (TextView) findViewById(e.g.person_header_bar_des);
        this.eSf = (TextView) findViewById(e.g.person_header_thread_num);
        this.eSf.setVisibility(8);
        this.hSb = (TextView) findViewById(e.g.person_header_thread_des);
        this.hSb.setVisibility(8);
        this.hSc = findViewById(e.g.divider_for_fans_and_attention);
        this.hSd = findViewById(e.g.divider_for_attention_and_bar);
        this.hSe = findViewById(e.g.divider_for_bar_and_thread);
        this.hSe.setVisibility(8);
    }

    private void bNy() {
        this.elP.setOnClickListener(this.cue);
        this.hRY.setOnClickListener(this.cue);
        this.gwh.setOnClickListener(this.cue);
        this.hRW.setOnClickListener(this.cue);
        this.hRZ.setOnClickListener(this.cue);
        this.hSa.setOnClickListener(this.cue);
        this.eSf.setOnClickListener(this.cue);
        this.hSb.setOnClickListener(this.cue);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gDX = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gwh.setText(str);
        this.elP.setText(str2);
        this.hRZ.setText(str4);
        this.eSf.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gwh.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.elP.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hRZ.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eSf.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        q(ao.W(this.mUserData.getConcernNum()), ao.W(this.mUserData.getFansNum()), ao.W(this.mUserData.getPosts_num()), ao.W(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gwh, e.d.cp_cont_b, 1);
            al.c(this.hRW, e.d.cp_cont_j, 1);
            al.c(this.elP, e.d.cp_cont_b, 1);
            al.c(this.hRY, e.d.cp_cont_j, 1);
            al.c(this.hRX, e.f.icon_news_down_bar_one);
            al.c(this.hRZ, e.d.cp_cont_b, 1);
            al.c(this.hSa, e.d.cp_cont_j, 1);
            al.c(this.eSf, e.d.cp_cont_b, 1);
            al.c(this.hSb, e.d.cp_cont_j, 1);
            al.j(this.hSc, e.d.cp_bg_line_b);
            al.j(this.hSd, e.d.cp_bg_line_b);
            al.j(this.hSe, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.dU(i)), e.f.icon_toast_game_error).Ca();
    }

    @Override // com.baidu.tieba.view.e
    public void oq(boolean z) {
        if (this.hRX != null) {
            if (z) {
                this.hRX.setVisibility(0);
            } else {
                this.hRX.setVisibility(8);
            }
        }
    }
}
