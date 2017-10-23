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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener bwB;
    private TextView cKr;
    private TextView dtc;
    private TextView faG;
    private g fiy;
    private TextView gCD;
    private ImageView gCE;
    private TextView gCF;
    private TextView gCG;
    private TextView gCH;
    private TextView gCI;
    private View gCJ;
    private View gCK;
    private View gCL;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gCM = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faG.getId() && id != PersonHeaderAttentionView.this.gCD.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKr.getId() && id != PersonHeaderAttentionView.this.gCF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCG.getId() || id == PersonHeaderAttentionView.this.gCH.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gCM.ceI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gCM.ceI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gCM.ceI = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiy != null) {
                        this.gCM.ceJ = new Bundle();
                        this.gCM.ceJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiy.a(view, this.gCM);
                    }
                }
            }
        };
        init(context);
        bxQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gCM = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faG.getId() && id != PersonHeaderAttentionView.this.gCD.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKr.getId() && id != PersonHeaderAttentionView.this.gCF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCG.getId() || id == PersonHeaderAttentionView.this.gCH.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gCM.ceI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gCM.ceI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gCM.ceI = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiy != null) {
                        this.gCM.ceJ = new Bundle();
                        this.gCM.ceJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiy.a(view, this.gCM);
                    }
                }
            }
        };
        init(context);
        bxQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gCM = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faG.getId() && id != PersonHeaderAttentionView.this.gCD.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKr.getId() && id != PersonHeaderAttentionView.this.gCF.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCG.getId() || id == PersonHeaderAttentionView.this.gCH.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BP() != 2)) {
                                    PersonHeaderAttentionView.this.uG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gCM.ceI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gCM.ceI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gCM.ceI = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiy != null) {
                        this.gCM.ceJ = new Bundle();
                        this.gCM.ceJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiy.a(view, this.gCM);
                    }
                }
            }
        };
        init(context);
        bxQ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.cKr = (TextView) findViewById(d.h.person_header_fans_num);
        this.gCF = (TextView) findViewById(d.h.person_header_fans_des);
        this.gCE = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.faG = (TextView) findViewById(d.h.person_header_attention_num);
        this.gCD = (TextView) findViewById(d.h.person_header_attention_des);
        this.gCG = (TextView) findViewById(d.h.person_header_bar_num);
        this.gCH = (TextView) findViewById(d.h.person_header_bar_des);
        this.dtc = (TextView) findViewById(d.h.person_header_thread_num);
        this.dtc.setVisibility(8);
        this.gCI = (TextView) findViewById(d.h.person_header_thread_des);
        this.gCI.setVisibility(8);
        this.gCJ = findViewById(d.h.divider_for_fans_and_attention);
        this.gCK = findViewById(d.h.divider_for_attention_and_bar);
        this.gCL = findViewById(d.h.divider_for_bar_and_thread);
        this.gCL.setVisibility(8);
    }

    private void bxQ() {
        this.cKr.setOnClickListener(this.bwB);
        this.gCF.setOnClickListener(this.bwB);
        this.faG.setOnClickListener(this.bwB);
        this.gCD.setOnClickListener(this.bwB);
        this.gCG.setOnClickListener(this.bwB);
        this.gCH.setOnClickListener(this.bwB);
        this.dtc.setOnClickListener(this.bwB);
        this.gCI.setOnClickListener(this.bwB);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fiy = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.faG.setText(str);
        this.cKr.setText(str2);
        this.gCG.setText(str4);
        this.dtc.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.faG.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cKr.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gCG.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dtc.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        m(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.faG, d.e.cp_cont_b, 1);
            aj.c(this.gCD, d.e.cp_cont_j, 1);
            aj.c(this.cKr, d.e.cp_cont_b, 1);
            aj.c(this.gCF, d.e.cp_cont_j, 1);
            aj.c(this.gCE, d.g.icon_news_down_bar_one);
            aj.c(this.gCG, d.e.cp_cont_b, 1);
            aj.c(this.gCH, d.e.cp_cont_j, 1);
            aj.c(this.dtc, d.e.cp_cont_b, 1);
            aj.c(this.gCI, d.e.cp_cont_j, 1);
            aj.k(this.gCJ, d.e.cp_bg_line_b);
            aj.k(this.gCK, d.e.cp_bg_line_b);
            aj.k(this.gCL, d.e.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), am.cW(i)), d.g.icon_toast_game_error).tj();
    }

    @Override // com.baidu.tieba.view.e
    public void ni(boolean z) {
        if (this.gCE != null) {
            if (z) {
                this.gCE.setVisibility(0);
            } else {
                this.gCE.setVisibility(8);
            }
        }
    }
}
