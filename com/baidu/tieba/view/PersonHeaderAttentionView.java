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
    private View.OnClickListener bwN;
    private TextView cKD;
    private TextView dtq;
    private TextView faV;
    private g fiN;
    private TextView gCT;
    private ImageView gCU;
    private TextView gCV;
    private TextView gCW;
    private TextView gCX;
    private TextView gCY;
    private View gCZ;
    private View gDa;
    private View gDb;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDc = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faV.getId() && id != PersonHeaderAttentionView.this.gCT.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCV.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCW.getId() || id == PersonHeaderAttentionView.this.gCX.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDc.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDc.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDc.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiN != null) {
                        this.gDc.ceV = new Bundle();
                        this.gDc.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiN.a(view, this.gDc);
                    }
                }
            }
        };
        init(context);
        bxZ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDc = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faV.getId() && id != PersonHeaderAttentionView.this.gCT.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCV.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCW.getId() || id == PersonHeaderAttentionView.this.gCX.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDc.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDc.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDc.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiN != null) {
                        this.gDc.ceV = new Bundle();
                        this.gDc.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiN.a(view, this.gDc);
                    }
                }
            }
        };
        init(context);
        bxZ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDc = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faV.getId() && id != PersonHeaderAttentionView.this.gCT.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCV.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCW.getId() || id == PersonHeaderAttentionView.this.gCX.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDc.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDc.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDc.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiN != null) {
                        this.gDc.ceV = new Bundle();
                        this.gDc.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiN.a(view, this.gDc);
                    }
                }
            }
        };
        init(context);
        bxZ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.cKD = (TextView) findViewById(d.h.person_header_fans_num);
        this.gCV = (TextView) findViewById(d.h.person_header_fans_des);
        this.gCU = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.faV = (TextView) findViewById(d.h.person_header_attention_num);
        this.gCT = (TextView) findViewById(d.h.person_header_attention_des);
        this.gCW = (TextView) findViewById(d.h.person_header_bar_num);
        this.gCX = (TextView) findViewById(d.h.person_header_bar_des);
        this.dtq = (TextView) findViewById(d.h.person_header_thread_num);
        this.dtq.setVisibility(8);
        this.gCY = (TextView) findViewById(d.h.person_header_thread_des);
        this.gCY.setVisibility(8);
        this.gCZ = findViewById(d.h.divider_for_fans_and_attention);
        this.gDa = findViewById(d.h.divider_for_attention_and_bar);
        this.gDb = findViewById(d.h.divider_for_bar_and_thread);
        this.gDb.setVisibility(8);
    }

    private void bxZ() {
        this.cKD.setOnClickListener(this.bwN);
        this.gCV.setOnClickListener(this.bwN);
        this.faV.setOnClickListener(this.bwN);
        this.gCT.setOnClickListener(this.bwN);
        this.gCW.setOnClickListener(this.bwN);
        this.gCX.setOnClickListener(this.bwN);
        this.dtq.setOnClickListener(this.bwN);
        this.gCY.setOnClickListener(this.bwN);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fiN = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.faV.setText(str);
        this.cKD.setText(str2);
        this.gCW.setText(str4);
        this.dtq.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.faV.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cKD.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gCW.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dtq.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        m(am.y(this.mUserData.getConcernNum()), am.y(this.mUserData.getFansNum()), am.y(this.mUserData.getPosts_num()), am.y(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.faV, d.e.cp_cont_b, 1);
            aj.c(this.gCT, d.e.cp_cont_j, 1);
            aj.c(this.cKD, d.e.cp_cont_b, 1);
            aj.c(this.gCV, d.e.cp_cont_j, 1);
            aj.c(this.gCU, d.g.icon_news_down_bar_one);
            aj.c(this.gCW, d.e.cp_cont_b, 1);
            aj.c(this.gCX, d.e.cp_cont_j, 1);
            aj.c(this.dtq, d.e.cp_cont_b, 1);
            aj.c(this.gCY, d.e.cp_cont_j, 1);
            aj.k(this.gCZ, d.e.cp_bg_line_b);
            aj.k(this.gDa, d.e.cp_bg_line_b);
            aj.k(this.gDb, d.e.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), am.cX(i)), d.g.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.e
    public void nj(boolean z) {
        if (this.gCU != null) {
            if (z) {
                this.gCU.setVisibility(0);
            } else {
                this.gCU.setVisibility(8);
            }
        }
    }
}
