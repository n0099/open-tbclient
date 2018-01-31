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
public class PersonHeaderAttentionView extends LinearLayout implements g {
    private View.OnClickListener ctZ;
    private TextView dVJ;
    private TextView eyj;
    private TextView gil;
    private i gpZ;
    private TextView hzr;
    private ImageView hzs;
    private TextView hzt;
    private TextView hzu;
    private TextView hzv;
    private TextView hzw;
    private View hzx;
    private View hzy;
    private View hzz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzA = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.bb(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gil.getId() && id != PersonHeaderAttentionView.this.hzr.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVJ.getId() && id != PersonHeaderAttentionView.this.hzt.getId()) {
                            if (id == PersonHeaderAttentionView.this.hzu.getId() || id == PersonHeaderAttentionView.this.hzv.getId()) {
                                TiebaStatic.log(new ak("c12502").aa("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzA.doE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").aa("obj_locate", "8"));
                            this.hzA.doE = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").aa("obj_locate", "9"));
                        this.hzA.doE = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpZ != null) {
                        this.hzA.doF = new Bundle();
                        this.hzA.doF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpZ.a(view, this.hzA);
                    }
                }
            }
        };
        init(context);
        bDY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzA = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.bb(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gil.getId() && id != PersonHeaderAttentionView.this.hzr.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVJ.getId() && id != PersonHeaderAttentionView.this.hzt.getId()) {
                            if (id == PersonHeaderAttentionView.this.hzu.getId() || id == PersonHeaderAttentionView.this.hzv.getId()) {
                                TiebaStatic.log(new ak("c12502").aa("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzA.doE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").aa("obj_locate", "8"));
                            this.hzA.doE = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").aa("obj_locate", "9"));
                        this.hzA.doE = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpZ != null) {
                        this.hzA.doF = new Bundle();
                        this.hzA.doF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpZ.a(view, this.hzA);
                    }
                }
            }
        };
        init(context);
        bDY();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzA = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.bb(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gil.getId() && id != PersonHeaderAttentionView.this.hzr.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVJ.getId() && id != PersonHeaderAttentionView.this.hzt.getId()) {
                            if (id == PersonHeaderAttentionView.this.hzu.getId() || id == PersonHeaderAttentionView.this.hzv.getId()) {
                                TiebaStatic.log(new ak("c12502").aa("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JU() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzA.doE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").aa("obj_locate", "8"));
                            this.hzA.doE = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").aa("obj_locate", "9"));
                        this.hzA.doE = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpZ != null) {
                        this.hzA.doF = new Bundle();
                        this.hzA.doF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpZ.a(view, this.hzA);
                    }
                }
            }
        };
        init(context);
        bDY();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dVJ = (TextView) findViewById(d.g.person_header_fans_num);
        this.hzt = (TextView) findViewById(d.g.person_header_fans_des);
        this.hzs = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.gil = (TextView) findViewById(d.g.person_header_attention_num);
        this.hzr = (TextView) findViewById(d.g.person_header_attention_des);
        this.hzu = (TextView) findViewById(d.g.person_header_bar_num);
        this.hzv = (TextView) findViewById(d.g.person_header_bar_des);
        this.eyj = (TextView) findViewById(d.g.person_header_thread_num);
        this.eyj.setVisibility(8);
        this.hzw = (TextView) findViewById(d.g.person_header_thread_des);
        this.hzw.setVisibility(8);
        this.hzx = findViewById(d.g.divider_for_fans_and_attention);
        this.hzy = findViewById(d.g.divider_for_attention_and_bar);
        this.hzz = findViewById(d.g.divider_for_bar_and_thread);
        this.hzz.setVisibility(8);
    }

    private void bDY() {
        this.dVJ.setOnClickListener(this.ctZ);
        this.hzt.setOnClickListener(this.ctZ);
        this.gil.setOnClickListener(this.ctZ);
        this.hzr.setOnClickListener(this.ctZ);
        this.hzu.setOnClickListener(this.ctZ);
        this.hzv.setOnClickListener(this.ctZ);
        this.eyj.setOnClickListener(this.ctZ);
        this.hzw.setOnClickListener(this.ctZ);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.gpZ = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.gil.setText(str);
        this.dVJ.setText(str2);
        this.hzu.setText(str4);
        this.eyj.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gil.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dVJ.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hzu.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eyj.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        p(am.I(this.mUserData.getConcernNum()), am.I(this.mUserData.getFansNum()), am.I(this.mUserData.getPosts_num()), am.I(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.gil, d.C0108d.cp_cont_b, 1);
            aj.e(this.hzr, d.C0108d.cp_cont_j, 1);
            aj.e(this.dVJ, d.C0108d.cp_cont_b, 1);
            aj.e(this.hzt, d.C0108d.cp_cont_j, 1);
            aj.c(this.hzs, d.f.icon_news_down_bar_one);
            aj.e(this.hzu, d.C0108d.cp_cont_b, 1);
            aj.e(this.hzv, d.C0108d.cp_cont_j, 1);
            aj.e(this.eyj, d.C0108d.cp_cont_b, 1);
            aj.e(this.hzw, d.C0108d.cp_cont_j, 1);
            aj.t(this.hzx, d.C0108d.cp_bg_line_b);
            aj.t(this.hzy, d.C0108d.cp_bg_line_b);
            aj.t(this.hzz, d.C0108d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fU(i)), d.f.icon_toast_game_error).AJ();
    }

    @Override // com.baidu.tieba.view.g
    public void no(boolean z) {
        if (this.hzs != null) {
            if (z) {
                this.hzs.setVisibility(0);
            } else {
                this.hzs.setVisibility(8);
            }
        }
    }
}
