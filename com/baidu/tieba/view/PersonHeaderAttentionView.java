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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener cas;
    private TextView dLm;
    private TextView erq;
    private TextView fVh;
    private g gcV;
    private TextView hpB;
    private ImageView hpC;
    private TextView hpD;
    private TextView hpE;
    private TextView hpF;
    private TextView hpG;
    private View hpH;
    private View hpI;
    private View hpJ;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpK = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVh.getId() && id != PersonHeaderAttentionView.this.hpB.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLm.getId() && id != PersonHeaderAttentionView.this.hpD.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpE.getId() || id == PersonHeaderAttentionView.this.hpF.getId()) {
                                TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpK.cVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpK.cVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").af("obj_locate", "9"));
                        this.hpK.cVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcV != null) {
                        this.hpK.cVh = new Bundle();
                        this.hpK.cVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcV.a(view, this.hpK);
                    }
                }
            }
        };
        init(context);
        bEs();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpK = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVh.getId() && id != PersonHeaderAttentionView.this.hpB.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLm.getId() && id != PersonHeaderAttentionView.this.hpD.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpE.getId() || id == PersonHeaderAttentionView.this.hpF.getId()) {
                                TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpK.cVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpK.cVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").af("obj_locate", "9"));
                        this.hpK.cVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcV != null) {
                        this.hpK.cVh = new Bundle();
                        this.hpK.cVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcV.a(view, this.hpK);
                    }
                }
            }
        };
        init(context);
        bEs();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hpK = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ba.aV(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fVh.getId() && id != PersonHeaderAttentionView.this.hpB.getId()) {
                        if (id != PersonHeaderAttentionView.this.dLm.getId() && id != PersonHeaderAttentionView.this.hpD.getId()) {
                            if (id == PersonHeaderAttentionView.this.hpE.getId() || id == PersonHeaderAttentionView.this.hpF.getId()) {
                                TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GV() != 2)) {
                                    PersonHeaderAttentionView.this.uZ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hpK.cVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").af("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hpK.cVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").af("obj_locate", "9"));
                        this.hpK.cVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcV != null) {
                        this.hpK.cVh = new Bundle();
                        this.hpK.cVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcV.a(view, this.hpK);
                    }
                }
            }
        };
        init(context);
        bEs();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dLm = (TextView) findViewById(d.g.person_header_fans_num);
        this.hpD = (TextView) findViewById(d.g.person_header_fans_des);
        this.hpC = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fVh = (TextView) findViewById(d.g.person_header_attention_num);
        this.hpB = (TextView) findViewById(d.g.person_header_attention_des);
        this.hpE = (TextView) findViewById(d.g.person_header_bar_num);
        this.hpF = (TextView) findViewById(d.g.person_header_bar_des);
        this.erq = (TextView) findViewById(d.g.person_header_thread_num);
        this.erq.setVisibility(8);
        this.hpG = (TextView) findViewById(d.g.person_header_thread_des);
        this.hpG.setVisibility(8);
        this.hpH = findViewById(d.g.divider_for_fans_and_attention);
        this.hpI = findViewById(d.g.divider_for_attention_and_bar);
        this.hpJ = findViewById(d.g.divider_for_bar_and_thread);
        this.hpJ.setVisibility(8);
    }

    private void bEs() {
        this.dLm.setOnClickListener(this.cas);
        this.hpD.setOnClickListener(this.cas);
        this.fVh.setOnClickListener(this.cas);
        this.hpB.setOnClickListener(this.cas);
        this.hpE.setOnClickListener(this.cas);
        this.hpF.setOnClickListener(this.cas);
        this.erq.setOnClickListener(this.cas);
        this.hpG.setOnClickListener(this.cas);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gcV = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.fVh.setText(str);
        this.dLm.setText(str2);
        this.hpE.setText(str4);
        this.erq.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fVh.setTextSize(0, l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dLm.setTextSize(0, l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hpE.setTextSize(0, l.f(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.erq.setTextSize(0, l.f(this.mContext, d.e.ds32));
        }
        q(ap.G(this.mUserData.getConcernNum()), ap.G(this.mUserData.getFansNum()), ap.G(this.mUserData.getPosts_num()), ap.G(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.c(this.fVh, d.C0140d.cp_cont_b, 1);
            am.c(this.hpB, d.C0140d.cp_cont_j, 1);
            am.c(this.dLm, d.C0140d.cp_cont_b, 1);
            am.c(this.hpD, d.C0140d.cp_cont_j, 1);
            am.c(this.hpC, d.f.icon_news_down_bar_one);
            am.c(this.hpE, d.C0140d.cp_cont_b, 1);
            am.c(this.hpF, d.C0140d.cp_cont_j, 1);
            am.c(this.erq, d.C0140d.cp_cont_b, 1);
            am.c(this.hpG, d.C0140d.cp_cont_j, 1);
            am.j(this.hpH, d.C0140d.cp_bg_line_b);
            am.j(this.hpI, d.C0140d.cp_bg_line_b);
            am.j(this.hpJ, d.C0140d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), ap.cZ(i)), d.f.icon_toast_game_error).xn();
    }

    @Override // com.baidu.tieba.view.e
    public void nj(boolean z) {
        if (this.hpC != null) {
            if (z) {
                this.hpC.setVisibility(0);
            } else {
                this.hpC.setVisibility(8);
            }
        }
    }
}
