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
    private View.OnClickListener cyh;
    private TextView dZW;
    private TextView eCF;
    private TextView gjU;
    private i grI;
    private TextView hAX;
    private ImageView hAY;
    private TextView hAZ;
    private TextView hBa;
    private TextView hBb;
    private TextView hBc;
    private View hBd;
    private View hBe;
    private View hBf;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjU.getId() && id != PersonHeaderAttentionView.this.hAX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZW.getId() && id != PersonHeaderAttentionView.this.hAZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBa.getId() || id == PersonHeaderAttentionView.this.hBb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBg.drx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBg.drx = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBg.drx = 4;
                    }
                    if (PersonHeaderAttentionView.this.grI != null) {
                        this.hBg.dry = new Bundle();
                        this.hBg.dry.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grI.a(view, this.hBg);
                    }
                }
            }
        };
        init(context);
        bEO();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjU.getId() && id != PersonHeaderAttentionView.this.hAX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZW.getId() && id != PersonHeaderAttentionView.this.hAZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBa.getId() || id == PersonHeaderAttentionView.this.hBb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBg.drx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBg.drx = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBg.drx = 4;
                    }
                    if (PersonHeaderAttentionView.this.grI != null) {
                        this.hBg.dry = new Bundle();
                        this.hBg.dry.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grI.a(view, this.hBg);
                    }
                }
            }
        };
        init(context);
        bEO();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjU.getId() && id != PersonHeaderAttentionView.this.hAX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dZW.getId() && id != PersonHeaderAttentionView.this.hAZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBa.getId() || id == PersonHeaderAttentionView.this.hBb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBg.drx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBg.drx = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBg.drx = 4;
                    }
                    if (PersonHeaderAttentionView.this.grI != null) {
                        this.hBg.dry = new Bundle();
                        this.hBg.dry.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grI.a(view, this.hBg);
                    }
                }
            }
        };
        init(context);
        bEO();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dZW = (TextView) findViewById(d.g.person_header_fans_num);
        this.hAZ = (TextView) findViewById(d.g.person_header_fans_des);
        this.hAY = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.gjU = (TextView) findViewById(d.g.person_header_attention_num);
        this.hAX = (TextView) findViewById(d.g.person_header_attention_des);
        this.hBa = (TextView) findViewById(d.g.person_header_bar_num);
        this.hBb = (TextView) findViewById(d.g.person_header_bar_des);
        this.eCF = (TextView) findViewById(d.g.person_header_thread_num);
        this.eCF.setVisibility(8);
        this.hBc = (TextView) findViewById(d.g.person_header_thread_des);
        this.hBc.setVisibility(8);
        this.hBd = findViewById(d.g.divider_for_fans_and_attention);
        this.hBe = findViewById(d.g.divider_for_attention_and_bar);
        this.hBf = findViewById(d.g.divider_for_bar_and_thread);
        this.hBf.setVisibility(8);
    }

    private void bEO() {
        this.dZW.setOnClickListener(this.cyh);
        this.hAZ.setOnClickListener(this.cyh);
        this.gjU.setOnClickListener(this.cyh);
        this.hAX.setOnClickListener(this.cyh);
        this.hBa.setOnClickListener(this.cyh);
        this.hBb.setOnClickListener(this.cyh);
        this.eCF.setOnClickListener(this.cyh);
        this.hBc.setOnClickListener(this.cyh);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.grI = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.gjU.setText(str);
        this.dZW.setText(str2);
        this.hBa.setText(str4);
        this.eCF.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gjU.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dZW.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hBa.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eCF.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        p(am.I(this.mUserData.getConcernNum()), am.I(this.mUserData.getFansNum()), am.I(this.mUserData.getPosts_num()), am.I(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.gjU, d.C0140d.cp_cont_b, 1);
            aj.e(this.hAX, d.C0140d.cp_cont_j, 1);
            aj.e(this.dZW, d.C0140d.cp_cont_b, 1);
            aj.e(this.hAZ, d.C0140d.cp_cont_j, 1);
            aj.c(this.hAY, d.f.icon_news_down_bar_one);
            aj.e(this.hBa, d.C0140d.cp_cont_b, 1);
            aj.e(this.hBb, d.C0140d.cp_cont_j, 1);
            aj.e(this.eCF, d.C0140d.cp_cont_b, 1);
            aj.e(this.hBc, d.C0140d.cp_cont_j, 1);
            aj.t(this.hBd, d.C0140d.cp_bg_line_b);
            aj.t(this.hBe, d.C0140d.cp_bg_line_b);
            aj.t(this.hBf, d.C0140d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fU(i)), d.f.icon_toast_game_error).Bc();
    }

    @Override // com.baidu.tieba.view.g
    public void nw(boolean z) {
        if (this.hAY != null) {
            if (z) {
                this.hAY.setVisibility(0);
            } else {
                this.hAY.setVisibility(8);
            }
        }
    }
}
