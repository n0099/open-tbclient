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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements f {
    private View.OnClickListener byf;
    private TextView cTC;
    private TextView dAR;
    private TextView fiX;
    private h frg;
    private View gMA;
    private View gMB;
    private TextView gMt;
    private ImageView gMu;
    private TextView gMv;
    private TextView gMw;
    private TextView gMx;
    private TextView gMy;
    private View gMz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gMC = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fiX.getId() && id != PersonHeaderAttentionView.this.gMt.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTC.getId() && id != PersonHeaderAttentionView.this.gMv.getId()) {
                            if (id == PersonHeaderAttentionView.this.gMw.getId() || id == PersonHeaderAttentionView.this.gMx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 2)) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gMC.cmb = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gMC.cmb = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gMC.cmb = 4;
                    }
                    if (PersonHeaderAttentionView.this.frg != null) {
                        this.gMC.cmc = new Bundle();
                        this.gMC.cmc.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frg.a(view, this.gMC);
                    }
                }
            }
        };
        init(context);
        bBj();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gMC = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fiX.getId() && id != PersonHeaderAttentionView.this.gMt.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTC.getId() && id != PersonHeaderAttentionView.this.gMv.getId()) {
                            if (id == PersonHeaderAttentionView.this.gMw.getId() || id == PersonHeaderAttentionView.this.gMx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 2)) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gMC.cmb = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gMC.cmb = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gMC.cmb = 4;
                    }
                    if (PersonHeaderAttentionView.this.frg != null) {
                        this.gMC.cmc = new Bundle();
                        this.gMC.cmc.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frg.a(view, this.gMC);
                    }
                }
            }
        };
        init(context);
        bBj();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gMC = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fiX.getId() && id != PersonHeaderAttentionView.this.gMt.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTC.getId() && id != PersonHeaderAttentionView.this.gMv.getId()) {
                            if (id == PersonHeaderAttentionView.this.gMw.getId() || id == PersonHeaderAttentionView.this.gMx.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Ce() != 2)) {
                                    PersonHeaderAttentionView.this.uY(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gMC.cmb = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gMC.cmb = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gMC.cmb = 4;
                    }
                    if (PersonHeaderAttentionView.this.frg != null) {
                        this.gMC.cmc = new Bundle();
                        this.gMC.cmc.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frg.a(view, this.gMC);
                    }
                }
            }
        };
        init(context);
        bBj();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.cTC = (TextView) findViewById(d.g.person_header_fans_num);
        this.gMv = (TextView) findViewById(d.g.person_header_fans_des);
        this.gMu = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fiX = (TextView) findViewById(d.g.person_header_attention_num);
        this.gMt = (TextView) findViewById(d.g.person_header_attention_des);
        this.gMw = (TextView) findViewById(d.g.person_header_bar_num);
        this.gMx = (TextView) findViewById(d.g.person_header_bar_des);
        this.dAR = (TextView) findViewById(d.g.person_header_thread_num);
        this.dAR.setVisibility(8);
        this.gMy = (TextView) findViewById(d.g.person_header_thread_des);
        this.gMy.setVisibility(8);
        this.gMz = findViewById(d.g.divider_for_fans_and_attention);
        this.gMA = findViewById(d.g.divider_for_attention_and_bar);
        this.gMB = findViewById(d.g.divider_for_bar_and_thread);
        this.gMB.setVisibility(8);
    }

    private void bBj() {
        this.cTC.setOnClickListener(this.byf);
        this.gMv.setOnClickListener(this.byf);
        this.fiX.setOnClickListener(this.byf);
        this.gMt.setOnClickListener(this.byf);
        this.gMw.setOnClickListener(this.byf);
        this.gMx.setOnClickListener(this.byf);
        this.dAR.setOnClickListener(this.byf);
        this.gMy.setOnClickListener(this.byf);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(h hVar) {
        this.frg = hVar;
    }

    private void n(String str, String str2, String str3, String str4) {
        this.fiX.setText(str);
        this.cTC.setText(str2);
        this.gMw.setText(str4);
        this.dAR.setText(str3);
    }

    @Override // com.baidu.tieba.view.f
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fiX.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cTC.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gMw.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dAR.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        n(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.fiX, d.C0080d.cp_cont_b, 1);
            aj.c(this.gMt, d.C0080d.cp_cont_j, 1);
            aj.c(this.cTC, d.C0080d.cp_cont_b, 1);
            aj.c(this.gMv, d.C0080d.cp_cont_j, 1);
            aj.c(this.gMu, d.f.icon_news_down_bar_one);
            aj.c(this.gMw, d.C0080d.cp_cont_b, 1);
            aj.c(this.gMx, d.C0080d.cp_cont_j, 1);
            aj.c(this.dAR, d.C0080d.cp_cont_b, 1);
            aj.c(this.gMy, d.C0080d.cp_cont_j, 1);
            aj.k(this.gMz, d.C0080d.cp_bg_line_b);
            aj.k(this.gMA, d.C0080d.cp_bg_line_b);
            aj.k(this.gMB, d.C0080d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.cX(i)), d.f.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.f
    public void ne(boolean z) {
        if (this.gMu != null) {
            if (z) {
                this.gMu.setVisibility(0);
            } else {
                this.gMu.setVisibility(8);
            }
        }
    }
}
