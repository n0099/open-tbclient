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
    private View.OnClickListener cxY;
    private TextView eCJ;
    private TextView eaa;
    private TextView gjZ;
    private i grN;
    private TextView hBi;
    private ImageView hBj;
    private TextView hBk;
    private TextView hBl;
    private TextView hBm;
    private TextView hBn;
    private View hBo;
    private View hBp;
    private View hBq;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBr = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjZ.getId() && id != PersonHeaderAttentionView.this.hBi.getId()) {
                        if (id != PersonHeaderAttentionView.this.eaa.getId() && id != PersonHeaderAttentionView.this.hBk.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBl.getId() || id == PersonHeaderAttentionView.this.hBm.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBr.dro = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBr.dro = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBr.dro = 4;
                    }
                    if (PersonHeaderAttentionView.this.grN != null) {
                        this.hBr.drp = new Bundle();
                        this.hBr.drp.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grN.a(view, this.hBr);
                    }
                }
            }
        };
        init(context);
        bES();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBr = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjZ.getId() && id != PersonHeaderAttentionView.this.hBi.getId()) {
                        if (id != PersonHeaderAttentionView.this.eaa.getId() && id != PersonHeaderAttentionView.this.hBk.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBl.getId() || id == PersonHeaderAttentionView.this.hBm.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBr.dro = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBr.dro = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBr.dro = 4;
                    }
                    if (PersonHeaderAttentionView.this.grN != null) {
                        this.hBr.drp = new Bundle();
                        this.hBr.drp.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grN.a(view, this.hBr);
                    }
                }
            }
        };
        init(context);
        bES();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hBr = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ay.ba(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.gjZ.getId() && id != PersonHeaderAttentionView.this.hBi.getId()) {
                        if (id != PersonHeaderAttentionView.this.eaa.getId() && id != PersonHeaderAttentionView.this.hBk.getId()) {
                            if (id == PersonHeaderAttentionView.this.hBl.getId() || id == PersonHeaderAttentionView.this.hBm.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().KA() != 2)) {
                                    PersonHeaderAttentionView.this.xc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hBr.dro = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hBr.dro = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hBr.dro = 4;
                    }
                    if (PersonHeaderAttentionView.this.grN != null) {
                        this.hBr.drp = new Bundle();
                        this.hBr.drp.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.grN.a(view, this.hBr);
                    }
                }
            }
        };
        init(context);
        bES();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.eaa = (TextView) findViewById(d.g.person_header_fans_num);
        this.hBk = (TextView) findViewById(d.g.person_header_fans_des);
        this.hBj = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.gjZ = (TextView) findViewById(d.g.person_header_attention_num);
        this.hBi = (TextView) findViewById(d.g.person_header_attention_des);
        this.hBl = (TextView) findViewById(d.g.person_header_bar_num);
        this.hBm = (TextView) findViewById(d.g.person_header_bar_des);
        this.eCJ = (TextView) findViewById(d.g.person_header_thread_num);
        this.eCJ.setVisibility(8);
        this.hBn = (TextView) findViewById(d.g.person_header_thread_des);
        this.hBn.setVisibility(8);
        this.hBo = findViewById(d.g.divider_for_fans_and_attention);
        this.hBp = findViewById(d.g.divider_for_attention_and_bar);
        this.hBq = findViewById(d.g.divider_for_bar_and_thread);
        this.hBq.setVisibility(8);
    }

    private void bES() {
        this.eaa.setOnClickListener(this.cxY);
        this.hBk.setOnClickListener(this.cxY);
        this.gjZ.setOnClickListener(this.cxY);
        this.hBi.setOnClickListener(this.cxY);
        this.hBl.setOnClickListener(this.cxY);
        this.hBm.setOnClickListener(this.cxY);
        this.eCJ.setOnClickListener(this.cxY);
        this.hBn.setOnClickListener(this.cxY);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.grN = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.gjZ.setText(str);
        this.eaa.setText(str2);
        this.hBl.setText(str4);
        this.eCJ.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gjZ.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.eaa.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hBl.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eCJ.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32));
        }
        p(am.I(this.mUserData.getConcernNum()), am.I(this.mUserData.getFansNum()), am.I(this.mUserData.getPosts_num()), am.I(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.gjZ, d.C0141d.cp_cont_b, 1);
            aj.e(this.hBi, d.C0141d.cp_cont_j, 1);
            aj.e(this.eaa, d.C0141d.cp_cont_b, 1);
            aj.e(this.hBk, d.C0141d.cp_cont_j, 1);
            aj.c(this.hBj, d.f.icon_news_down_bar_one);
            aj.e(this.hBl, d.C0141d.cp_cont_b, 1);
            aj.e(this.hBm, d.C0141d.cp_cont_j, 1);
            aj.e(this.eCJ, d.C0141d.cp_cont_b, 1);
            aj.e(this.hBn, d.C0141d.cp_cont_j, 1);
            aj.t(this.hBo, d.C0141d.cp_bg_line_b);
            aj.t(this.hBp, d.C0141d.cp_bg_line_b);
            aj.t(this.hBq, d.C0141d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fU(i)), d.f.icon_toast_game_error).Bd();
    }

    @Override // com.baidu.tieba.view.g
    public void nB(boolean z) {
        if (this.hBj != null) {
            if (z) {
                this.hBj.setVisibility(0);
            } else {
                this.hBj.setVisibility(8);
            }
        }
    }
}
