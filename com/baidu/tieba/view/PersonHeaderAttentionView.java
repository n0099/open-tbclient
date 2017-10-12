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
    private TextView faU;
    private g fiM;
    private TextView gCS;
    private ImageView gCT;
    private TextView gCU;
    private TextView gCV;
    private TextView gCW;
    private TextView gCX;
    private View gCY;
    private View gCZ;
    private View gDa;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDb = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faU.getId() && id != PersonHeaderAttentionView.this.gCS.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCU.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCV.getId() || id == PersonHeaderAttentionView.this.gCW.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDb.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDb.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDb.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiM != null) {
                        this.gDb.ceV = new Bundle();
                        this.gDb.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiM.a(view, this.gDb);
                    }
                }
            }
        };
        init(context);
        bxY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDb = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faU.getId() && id != PersonHeaderAttentionView.this.gCS.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCU.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCV.getId() || id == PersonHeaderAttentionView.this.gCW.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDb.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDb.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDb.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiM != null) {
                        this.gDb.ceV = new Bundle();
                        this.gDb.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiM.a(view, this.gDb);
                    }
                }
            }
        };
        init(context);
        bxY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gDb = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.faU.getId() && id != PersonHeaderAttentionView.this.gCS.getId()) {
                        if (id != PersonHeaderAttentionView.this.cKD.getId() && id != PersonHeaderAttentionView.this.gCU.getId()) {
                            if (id == PersonHeaderAttentionView.this.gCV.getId() || id == PersonHeaderAttentionView.this.gCW.getId()) {
                                TiebaStatic.log(new ak("c12502").ad("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().BV() != 2)) {
                                    PersonHeaderAttentionView.this.uH(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.gDb.ceU = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ad("obj_locate", "8"));
                            this.gDb.ceU = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "9"));
                        this.gDb.ceU = 4;
                    }
                    if (PersonHeaderAttentionView.this.fiM != null) {
                        this.gDb.ceV = new Bundle();
                        this.gDb.ceV.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fiM.a(view, this.gDb);
                    }
                }
            }
        };
        init(context);
        bxY();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.cKD = (TextView) findViewById(d.h.person_header_fans_num);
        this.gCU = (TextView) findViewById(d.h.person_header_fans_des);
        this.gCT = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.faU = (TextView) findViewById(d.h.person_header_attention_num);
        this.gCS = (TextView) findViewById(d.h.person_header_attention_des);
        this.gCV = (TextView) findViewById(d.h.person_header_bar_num);
        this.gCW = (TextView) findViewById(d.h.person_header_bar_des);
        this.dtq = (TextView) findViewById(d.h.person_header_thread_num);
        this.dtq.setVisibility(8);
        this.gCX = (TextView) findViewById(d.h.person_header_thread_des);
        this.gCX.setVisibility(8);
        this.gCY = findViewById(d.h.divider_for_fans_and_attention);
        this.gCZ = findViewById(d.h.divider_for_attention_and_bar);
        this.gDa = findViewById(d.h.divider_for_bar_and_thread);
        this.gDa.setVisibility(8);
    }

    private void bxY() {
        this.cKD.setOnClickListener(this.bwN);
        this.gCU.setOnClickListener(this.bwN);
        this.faU.setOnClickListener(this.bwN);
        this.gCS.setOnClickListener(this.bwN);
        this.gCV.setOnClickListener(this.bwN);
        this.gCW.setOnClickListener(this.bwN);
        this.dtq.setOnClickListener(this.bwN);
        this.gCX.setOnClickListener(this.bwN);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fiM = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.faU.setText(str);
        this.cKD.setText(str2);
        this.gCV.setText(str4);
        this.dtq.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.faU.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cKD.setTextSize(0, l.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gCV.setTextSize(0, l.f(this.mContext, d.f.ds32));
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
            aj.c(this.faU, d.e.cp_cont_b, 1);
            aj.c(this.gCS, d.e.cp_cont_j, 1);
            aj.c(this.cKD, d.e.cp_cont_b, 1);
            aj.c(this.gCU, d.e.cp_cont_j, 1);
            aj.c(this.gCT, d.g.icon_news_down_bar_one);
            aj.c(this.gCV, d.e.cp_cont_b, 1);
            aj.c(this.gCW, d.e.cp_cont_j, 1);
            aj.c(this.dtq, d.e.cp_cont_b, 1);
            aj.c(this.gCX, d.e.cp_cont_j, 1);
            aj.k(this.gCY, d.e.cp_bg_line_b);
            aj.k(this.gCZ, d.e.cp_bg_line_b);
            aj.k(this.gDa, d.e.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), am.cX(i)), d.g.icon_toast_game_error).tq();
    }

    @Override // com.baidu.tieba.view.e
    public void nj(boolean z) {
        if (this.gCT != null) {
            if (z) {
                this.gCT.setVisibility(0);
            } else {
                this.gCT.setVisibility(8);
            }
        }
    }
}
