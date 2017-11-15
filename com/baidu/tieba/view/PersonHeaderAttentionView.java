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
    private View.OnClickListener byr;
    private TextView cTW;
    private TextView dBn;
    private TextView fju;
    private h frE;
    private TextView gNB;
    private ImageView gNC;
    private TextView gND;
    private TextView gNE;
    private TextView gNF;
    private TextView gNG;
    private View gNH;
    private View gNI;
    private View gNJ;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gNK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fju.getId() && id != PersonHeaderAttentionView.this.gNB.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTW.getId() && id != PersonHeaderAttentionView.this.gND.getId()) {
                            if (id == PersonHeaderAttentionView.this.gNE.getId() || id == PersonHeaderAttentionView.this.gNF.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 2)) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gNK.cmv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gNK.cmv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gNK.cmv = 4;
                    }
                    if (PersonHeaderAttentionView.this.frE != null) {
                        this.gNK.cmw = new Bundle();
                        this.gNK.cmw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frE.a(view, this.gNK);
                    }
                }
            }
        };
        init(context);
        bBv();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gNK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fju.getId() && id != PersonHeaderAttentionView.this.gNB.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTW.getId() && id != PersonHeaderAttentionView.this.gND.getId()) {
                            if (id == PersonHeaderAttentionView.this.gNE.getId() || id == PersonHeaderAttentionView.this.gNF.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 2)) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gNK.cmv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gNK.cmv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gNK.cmv = 4;
                    }
                    if (PersonHeaderAttentionView.this.frE != null) {
                        this.gNK.cmw = new Bundle();
                        this.gNK.cmw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frE.a(view, this.gNK);
                    }
                }
            }
        };
        init(context);
        bBv();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gNK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fju.getId() && id != PersonHeaderAttentionView.this.gNB.getId()) {
                        if (id != PersonHeaderAttentionView.this.cTW.getId() && id != PersonHeaderAttentionView.this.gND.getId()) {
                            if (id == PersonHeaderAttentionView.this.gNE.getId() || id == PersonHeaderAttentionView.this.gNF.getId()) {
                                TiebaStatic.log(new ak("c12502").ac("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cq() != 2)) {
                                    PersonHeaderAttentionView.this.vc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gNK.cmv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ac("obj_locate", "8"));
                            this.gNK.cmv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "9"));
                        this.gNK.cmv = 4;
                    }
                    if (PersonHeaderAttentionView.this.frE != null) {
                        this.gNK.cmw = new Bundle();
                        this.gNK.cmw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.frE.a(view, this.gNK);
                    }
                }
            }
        };
        init(context);
        bBv();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.cTW = (TextView) findViewById(d.g.person_header_fans_num);
        this.gND = (TextView) findViewById(d.g.person_header_fans_des);
        this.gNC = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fju = (TextView) findViewById(d.g.person_header_attention_num);
        this.gNB = (TextView) findViewById(d.g.person_header_attention_des);
        this.gNE = (TextView) findViewById(d.g.person_header_bar_num);
        this.gNF = (TextView) findViewById(d.g.person_header_bar_des);
        this.dBn = (TextView) findViewById(d.g.person_header_thread_num);
        this.dBn.setVisibility(8);
        this.gNG = (TextView) findViewById(d.g.person_header_thread_des);
        this.gNG.setVisibility(8);
        this.gNH = findViewById(d.g.divider_for_fans_and_attention);
        this.gNI = findViewById(d.g.divider_for_attention_and_bar);
        this.gNJ = findViewById(d.g.divider_for_bar_and_thread);
        this.gNJ.setVisibility(8);
    }

    private void bBv() {
        this.cTW.setOnClickListener(this.byr);
        this.gND.setOnClickListener(this.byr);
        this.fju.setOnClickListener(this.byr);
        this.gNB.setOnClickListener(this.byr);
        this.gNE.setOnClickListener(this.byr);
        this.gNF.setOnClickListener(this.byr);
        this.dBn.setOnClickListener(this.byr);
        this.gNG.setOnClickListener(this.byr);
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(h hVar) {
        this.frE = hVar;
    }

    private void n(String str, String str2, String str3, String str4) {
        this.fju.setText(str);
        this.cTW.setText(str2);
        this.gNE.setText(str4);
        this.dBn.setText(str3);
    }

    @Override // com.baidu.tieba.view.f
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fju.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cTW.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gNE.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dBn.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32));
        }
        n(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.fju, d.C0080d.cp_cont_b, 1);
            aj.c(this.gNB, d.C0080d.cp_cont_j, 1);
            aj.c(this.cTW, d.C0080d.cp_cont_b, 1);
            aj.c(this.gND, d.C0080d.cp_cont_j, 1);
            aj.c(this.gNC, d.f.icon_news_down_bar_one);
            aj.c(this.gNE, d.C0080d.cp_cont_b, 1);
            aj.c(this.gNF, d.C0080d.cp_cont_j, 1);
            aj.c(this.dBn, d.C0080d.cp_cont_b, 1);
            aj.c(this.gNG, d.C0080d.cp_cont_j, 1);
            aj.k(this.gNH, d.C0080d.cp_bg_line_b);
            aj.k(this.gNI, d.C0080d.cp_bg_line_b);
            aj.k(this.gNJ, d.C0080d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.cW(i)), d.f.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.f
    public void nm(boolean z) {
        if (this.gNC != null) {
            if (z) {
                this.gNC.setVisibility(0);
            } else {
                this.gNC.setVisibility(8);
            }
        }
    }
}
