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
    private View.OnClickListener cud;
    private TextView eSe;
    private TextView elO;
    private g gDW;
    private TextView gwg;
    private TextView hRV;
    private ImageView hRW;
    private TextView hRX;
    private TextView hRY;
    private TextView hRZ;
    private TextView hSa;
    private View hSb;
    private View hSc;
    private View hSd;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSe = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwg.getId() && id != PersonHeaderAttentionView.this.hRV.getId()) {
                        if (id != PersonHeaderAttentionView.this.elO.getId() && id != PersonHeaderAttentionView.this.hRX.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRY.getId() || id == PersonHeaderAttentionView.this.hRZ.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSe.duk = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSe.duk = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSe.duk = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDW != null) {
                        this.hSe.dul = new Bundle();
                        this.hSe.dul.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDW.a(view, this.hSe);
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
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSe = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwg.getId() && id != PersonHeaderAttentionView.this.hRV.getId()) {
                        if (id != PersonHeaderAttentionView.this.elO.getId() && id != PersonHeaderAttentionView.this.hRX.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRY.getId() || id == PersonHeaderAttentionView.this.hRZ.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSe.duk = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSe.duk = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSe.duk = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDW != null) {
                        this.hSe.dul = new Bundle();
                        this.hSe.dul.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDW.a(view, this.hSe);
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
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hSe = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.bJ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gwg.getId() && id != PersonHeaderAttentionView.this.hRV.getId()) {
                        if (id != PersonHeaderAttentionView.this.elO.getId() && id != PersonHeaderAttentionView.this.hRX.getId()) {
                            if (id == PersonHeaderAttentionView.this.hRY.getId() || id == PersonHeaderAttentionView.this.hRZ.getId()) {
                                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().LQ() != 2)) {
                                    PersonHeaderAttentionView.this.xb(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hSe.duk = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hSe.duk = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "9"));
                        this.hSe.duk = 4;
                    }
                    if (PersonHeaderAttentionView.this.gDW != null) {
                        this.hSe.dul = new Bundle();
                        this.hSe.dul.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gDW.a(view, this.hSe);
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
        this.elO = (TextView) findViewById(e.g.person_header_fans_num);
        this.hRX = (TextView) findViewById(e.g.person_header_fans_des);
        this.hRW = (ImageView) findViewById(e.g.person_header_fans_red_tip);
        this.gwg = (TextView) findViewById(e.g.person_header_attention_num);
        this.hRV = (TextView) findViewById(e.g.person_header_attention_des);
        this.hRY = (TextView) findViewById(e.g.person_header_bar_num);
        this.hRZ = (TextView) findViewById(e.g.person_header_bar_des);
        this.eSe = (TextView) findViewById(e.g.person_header_thread_num);
        this.eSe.setVisibility(8);
        this.hSa = (TextView) findViewById(e.g.person_header_thread_des);
        this.hSa.setVisibility(8);
        this.hSb = findViewById(e.g.divider_for_fans_and_attention);
        this.hSc = findViewById(e.g.divider_for_attention_and_bar);
        this.hSd = findViewById(e.g.divider_for_bar_and_thread);
        this.hSd.setVisibility(8);
    }

    private void bNy() {
        this.elO.setOnClickListener(this.cud);
        this.hRX.setOnClickListener(this.cud);
        this.gwg.setOnClickListener(this.cud);
        this.hRV.setOnClickListener(this.cud);
        this.hRY.setOnClickListener(this.cud);
        this.hRZ.setOnClickListener(this.cud);
        this.eSe.setOnClickListener(this.cud);
        this.hSa.setOnClickListener(this.cud);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gDW = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.gwg.setText(str);
        this.elO.setText(str2);
        this.hRY.setText(str4);
        this.eSe.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gwg.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.elO.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hRY.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eSe.setTextSize(0, l.h(this.mContext, e.C0210e.ds32));
        }
        q(ao.W(this.mUserData.getConcernNum()), ao.W(this.mUserData.getFansNum()), ao.W(this.mUserData.getPosts_num()), ao.W(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.gwg, e.d.cp_cont_b, 1);
            al.c(this.hRV, e.d.cp_cont_j, 1);
            al.c(this.elO, e.d.cp_cont_b, 1);
            al.c(this.hRX, e.d.cp_cont_j, 1);
            al.c(this.hRW, e.f.icon_news_down_bar_one);
            al.c(this.hRY, e.d.cp_cont_b, 1);
            al.c(this.hRZ, e.d.cp_cont_j, 1);
            al.c(this.eSe, e.d.cp_cont_b, 1);
            al.c(this.hSa, e.d.cp_cont_j, 1);
            al.j(this.hSb, e.d.cp_bg_line_b);
            al.j(this.hSc, e.d.cp_bg_line_b);
            al.j(this.hSd, e.d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(e.j.person_privacy_toast), ao.dU(i)), e.f.icon_toast_game_error).Ca();
    }

    @Override // com.baidu.tieba.view.e
    public void oq(boolean z) {
        if (this.hRW != null) {
            if (z) {
                this.hRW.setVisibility(0);
            } else {
                this.hRW.setVisibility(8);
            }
        }
    }
}
