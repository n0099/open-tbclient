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
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener bWZ;
    private TextView dFc;
    private TextView ejE;
    private TextView fQS;
    private g fYD;
    private TextView hko;
    private ImageView hkp;
    private TextView hkq;
    private TextView hkr;
    private TextView hks;
    private TextView hkt;
    private View hku;
    private View hkv;
    private View hkw;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hkx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fQS.getId() && id != PersonHeaderAttentionView.this.hko.getId()) {
                        if (id != PersonHeaderAttentionView.this.dFc.getId() && id != PersonHeaderAttentionView.this.hkq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hkr.getId() || id == PersonHeaderAttentionView.this.hks.getId()) {
                                TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 2)) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hkx.cUr = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hkx.cUr = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ah("obj_locate", "9"));
                        this.hkx.cUr = 4;
                    }
                    if (PersonHeaderAttentionView.this.fYD != null) {
                        this.hkx.cUs = new Bundle();
                        this.hkx.cUs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fYD.a(view, this.hkx);
                    }
                }
            }
        };
        init(context);
        bFh();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hkx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fQS.getId() && id != PersonHeaderAttentionView.this.hko.getId()) {
                        if (id != PersonHeaderAttentionView.this.dFc.getId() && id != PersonHeaderAttentionView.this.hkq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hkr.getId() || id == PersonHeaderAttentionView.this.hks.getId()) {
                                TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 2)) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hkx.cUr = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hkx.cUr = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ah("obj_locate", "9"));
                        this.hkx.cUr = 4;
                    }
                    if (PersonHeaderAttentionView.this.fYD != null) {
                        this.hkx.cUs = new Bundle();
                        this.hkx.cUs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fYD.a(view, this.hkx);
                    }
                }
            }
        };
        init(context);
        bFh();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hkx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fQS.getId() && id != PersonHeaderAttentionView.this.hko.getId()) {
                        if (id != PersonHeaderAttentionView.this.dFc.getId() && id != PersonHeaderAttentionView.this.hkq.getId()) {
                            if (id == PersonHeaderAttentionView.this.hkr.getId() || id == PersonHeaderAttentionView.this.hks.getId()) {
                                TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GH() != 2)) {
                                    PersonHeaderAttentionView.this.uS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hkx.cUr = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hkx.cUr = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").ah("obj_locate", "9"));
                        this.hkx.cUr = 4;
                    }
                    if (PersonHeaderAttentionView.this.fYD != null) {
                        this.hkx.cUs = new Bundle();
                        this.hkx.cUs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fYD.a(view, this.hkx);
                    }
                }
            }
        };
        init(context);
        bFh();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.i.item_person_header_attention_view, (ViewGroup) this, true);
        this.dFc = (TextView) findViewById(d.g.person_header_fans_num);
        this.hkq = (TextView) findViewById(d.g.person_header_fans_des);
        this.hkp = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fQS = (TextView) findViewById(d.g.person_header_attention_num);
        this.hko = (TextView) findViewById(d.g.person_header_attention_des);
        this.hkr = (TextView) findViewById(d.g.person_header_bar_num);
        this.hks = (TextView) findViewById(d.g.person_header_bar_des);
        this.ejE = (TextView) findViewById(d.g.person_header_thread_num);
        this.ejE.setVisibility(8);
        this.hkt = (TextView) findViewById(d.g.person_header_thread_des);
        this.hkt.setVisibility(8);
        this.hku = findViewById(d.g.divider_for_fans_and_attention);
        this.hkv = findViewById(d.g.divider_for_attention_and_bar);
        this.hkw = findViewById(d.g.divider_for_bar_and_thread);
        this.hkw.setVisibility(8);
    }

    private void bFh() {
        this.dFc.setOnClickListener(this.bWZ);
        this.hkq.setOnClickListener(this.bWZ);
        this.fQS.setOnClickListener(this.bWZ);
        this.hko.setOnClickListener(this.bWZ);
        this.hkr.setOnClickListener(this.bWZ);
        this.hks.setOnClickListener(this.bWZ);
        this.ejE.setOnClickListener(this.bWZ);
        this.hkt.setOnClickListener(this.bWZ);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fYD = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.fQS.setText(str);
        this.dFc.setText(str2);
        this.hkr.setText(str4);
        this.ejE.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fQS.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dFc.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hkr.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ejE.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        q(ao.D(this.mUserData.getConcernNum()), ao.D(this.mUserData.getFansNum()), ao.D(this.mUserData.getPosts_num()), ao.D(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.fQS, d.C0141d.cp_cont_b, 1);
            al.c(this.hko, d.C0141d.cp_cont_j, 1);
            al.c(this.dFc, d.C0141d.cp_cont_b, 1);
            al.c(this.hkq, d.C0141d.cp_cont_j, 1);
            al.c(this.hkp, d.f.icon_news_down_bar_one);
            al.c(this.hkr, d.C0141d.cp_cont_b, 1);
            al.c(this.hks, d.C0141d.cp_cont_j, 1);
            al.c(this.ejE, d.C0141d.cp_cont_b, 1);
            al.c(this.hkt, d.C0141d.cp_cont_j, 1);
            al.j(this.hku, d.C0141d.cp_bg_line_b);
            al.j(this.hkv, d.C0141d.cp_bg_line_b);
            al.j(this.hkw, d.C0141d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.k.person_privacy_toast), ao.cW(i)), d.f.icon_toast_game_error).xi();
    }

    @Override // com.baidu.tieba.view.e
    public void nn(boolean z) {
        if (this.hkp != null) {
            if (z) {
                this.hkp.setVisibility(0);
            } else {
                this.hkp.setVisibility(8);
            }
        }
    }
}
