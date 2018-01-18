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
    private View.OnClickListener ctQ;
    private TextView dVo;
    private TextView exO;
    private TextView ghP;
    private i gpE;
    private TextView hyX;
    private ImageView hyY;
    private TextView hyZ;
    private TextView hza;
    private TextView hzb;
    private TextView hzc;
    private View hzd;
    private View hze;
    private View hzf;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ghP.getId() && id != PersonHeaderAttentionView.this.hyX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVo.getId() && id != PersonHeaderAttentionView.this.hyZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hza.getId() || id == PersonHeaderAttentionView.this.hzb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzg.doj = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hzg.doj = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hzg.doj = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpE != null) {
                        this.hzg.dok = new Bundle();
                        this.hzg.dok.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpE.a(view, this.hzg);
                    }
                }
            }
        };
        init(context);
        bDW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ghP.getId() && id != PersonHeaderAttentionView.this.hyX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVo.getId() && id != PersonHeaderAttentionView.this.hyZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hza.getId() || id == PersonHeaderAttentionView.this.hzb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzg.doj = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hzg.doj = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hzg.doj = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpE != null) {
                        this.hzg.dok = new Bundle();
                        this.hzg.dok.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpE.a(view, this.hzg);
                    }
                }
            }
        };
        init(context);
        bDW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hzg = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ghP.getId() && id != PersonHeaderAttentionView.this.hyX.getId()) {
                        if (id != PersonHeaderAttentionView.this.dVo.getId() && id != PersonHeaderAttentionView.this.hyZ.getId()) {
                            if (id == PersonHeaderAttentionView.this.hza.getId() || id == PersonHeaderAttentionView.this.hzb.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().JS() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hzg.doj = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hzg.doj = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hzg.doj = 4;
                    }
                    if (PersonHeaderAttentionView.this.gpE != null) {
                        this.hzg.dok = new Bundle();
                        this.hzg.dok.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gpE.a(view, this.hzg);
                    }
                }
            }
        };
        init(context);
        bDW();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dVo = (TextView) findViewById(d.g.person_header_fans_num);
        this.hyZ = (TextView) findViewById(d.g.person_header_fans_des);
        this.hyY = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.ghP = (TextView) findViewById(d.g.person_header_attention_num);
        this.hyX = (TextView) findViewById(d.g.person_header_attention_des);
        this.hza = (TextView) findViewById(d.g.person_header_bar_num);
        this.hzb = (TextView) findViewById(d.g.person_header_bar_des);
        this.exO = (TextView) findViewById(d.g.person_header_thread_num);
        this.exO.setVisibility(8);
        this.hzc = (TextView) findViewById(d.g.person_header_thread_des);
        this.hzc.setVisibility(8);
        this.hzd = findViewById(d.g.divider_for_fans_and_attention);
        this.hze = findViewById(d.g.divider_for_attention_and_bar);
        this.hzf = findViewById(d.g.divider_for_bar_and_thread);
        this.hzf.setVisibility(8);
    }

    private void bDW() {
        this.dVo.setOnClickListener(this.ctQ);
        this.hyZ.setOnClickListener(this.ctQ);
        this.ghP.setOnClickListener(this.ctQ);
        this.hyX.setOnClickListener(this.ctQ);
        this.hza.setOnClickListener(this.ctQ);
        this.hzb.setOnClickListener(this.ctQ);
        this.exO.setOnClickListener(this.ctQ);
        this.hzc.setOnClickListener(this.ctQ);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.gpE = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.ghP.setText(str);
        this.dVo.setText(str2);
        this.hza.setText(str4);
        this.exO.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ghP.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dVo.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hza.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.exO.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        p(am.I(this.mUserData.getConcernNum()), am.I(this.mUserData.getFansNum()), am.I(this.mUserData.getPosts_num()), am.I(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.ghP, d.C0107d.cp_cont_b, 1);
            aj.e(this.hyX, d.C0107d.cp_cont_j, 1);
            aj.e(this.dVo, d.C0107d.cp_cont_b, 1);
            aj.e(this.hyZ, d.C0107d.cp_cont_j, 1);
            aj.c(this.hyY, d.f.icon_news_down_bar_one);
            aj.e(this.hza, d.C0107d.cp_cont_b, 1);
            aj.e(this.hzb, d.C0107d.cp_cont_j, 1);
            aj.e(this.exO, d.C0107d.cp_cont_b, 1);
            aj.e(this.hzc, d.C0107d.cp_cont_j, 1);
            aj.t(this.hzd, d.C0107d.cp_bg_line_b);
            aj.t(this.hze, d.C0107d.cp_bg_line_b);
            aj.t(this.hzf, d.C0107d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fU(i)), d.f.icon_toast_game_error).AI();
    }

    @Override // com.baidu.tieba.view.g
    public void nm(boolean z) {
        if (this.hyY != null) {
            if (z) {
                this.hyY.setVisibility(0);
            } else {
                this.hyY.setVisibility(8);
            }
        }
    }
}
