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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener bZi;
    private TextView dIx;
    private TextView eny;
    private TextView fUU;
    private g gcD;
    private View hoA;
    private View hoB;
    private TextView hot;
    private ImageView hou;
    private TextView hov;
    private TextView how;
    private TextView hox;
    private TextView hoy;
    private View hoz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hoC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fUU.getId() && id != PersonHeaderAttentionView.this.hot.getId()) {
                        if (id != PersonHeaderAttentionView.this.dIx.getId() && id != PersonHeaderAttentionView.this.hov.getId()) {
                            if (id == PersonHeaderAttentionView.this.how.getId() || id == PersonHeaderAttentionView.this.hox.getId()) {
                                TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 2)) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hoC.cSt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hoC.cSt = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ah("obj_locate", "9"));
                        this.hoC.cSt = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcD != null) {
                        this.hoC.cSu = new Bundle();
                        this.hoC.cSu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcD.a(view, this.hoC);
                    }
                }
            }
        };
        init(context);
        bFH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hoC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fUU.getId() && id != PersonHeaderAttentionView.this.hot.getId()) {
                        if (id != PersonHeaderAttentionView.this.dIx.getId() && id != PersonHeaderAttentionView.this.hov.getId()) {
                            if (id == PersonHeaderAttentionView.this.how.getId() || id == PersonHeaderAttentionView.this.hox.getId()) {
                                TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 2)) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hoC.cSt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hoC.cSt = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ah("obj_locate", "9"));
                        this.hoC.cSt = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcD != null) {
                        this.hoC.cSu = new Bundle();
                        this.hoC.cSu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcD.a(view, this.hoC);
                    }
                }
            }
        };
        init(context);
        bFH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a hoC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bb.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.fUU.getId() && id != PersonHeaderAttentionView.this.hot.getId()) {
                        if (id != PersonHeaderAttentionView.this.dIx.getId() && id != PersonHeaderAttentionView.this.hov.getId()) {
                            if (id == PersonHeaderAttentionView.this.how.getId() || id == PersonHeaderAttentionView.this.hox.getId()) {
                                TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().GZ() != 2)) {
                                    PersonHeaderAttentionView.this.va(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hoC.cSt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.hoC.cSt = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").ah("obj_locate", "9"));
                        this.hoC.cSt = 4;
                    }
                    if (PersonHeaderAttentionView.this.gcD != null) {
                        this.hoC.cSu = new Bundle();
                        this.hoC.cSu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gcD.a(view, this.hoC);
                    }
                }
            }
        };
        init(context);
        bFH();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.i.item_person_header_attention_view, (ViewGroup) this, true);
        this.dIx = (TextView) findViewById(d.g.person_header_fans_num);
        this.hov = (TextView) findViewById(d.g.person_header_fans_des);
        this.hou = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.fUU = (TextView) findViewById(d.g.person_header_attention_num);
        this.hot = (TextView) findViewById(d.g.person_header_attention_des);
        this.how = (TextView) findViewById(d.g.person_header_bar_num);
        this.hox = (TextView) findViewById(d.g.person_header_bar_des);
        this.eny = (TextView) findViewById(d.g.person_header_thread_num);
        this.eny.setVisibility(8);
        this.hoy = (TextView) findViewById(d.g.person_header_thread_des);
        this.hoy.setVisibility(8);
        this.hoz = findViewById(d.g.divider_for_fans_and_attention);
        this.hoA = findViewById(d.g.divider_for_attention_and_bar);
        this.hoB = findViewById(d.g.divider_for_bar_and_thread);
        this.hoB.setVisibility(8);
    }

    private void bFH() {
        this.dIx.setOnClickListener(this.bZi);
        this.hov.setOnClickListener(this.bZi);
        this.fUU.setOnClickListener(this.bZi);
        this.hot.setOnClickListener(this.bZi);
        this.how.setOnClickListener(this.bZi);
        this.hox.setOnClickListener(this.bZi);
        this.eny.setOnClickListener(this.bZi);
        this.hoy.setOnClickListener(this.bZi);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.gcD = gVar;
    }

    private void q(String str, String str2, String str3, String str4) {
        this.fUU.setText(str);
        this.dIx.setText(str2);
        this.how.setText(str4);
        this.eny.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fUU.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dIx.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.how.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.eny.setTextSize(0, l.e(this.mContext, d.e.ds32));
        }
        q(ap.E(this.mUserData.getConcernNum()), ap.E(this.mUserData.getFansNum()), ap.E(this.mUserData.getPosts_num()), ap.E(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.c(this.fUU, d.C0142d.cp_cont_b, 1);
            am.c(this.hot, d.C0142d.cp_cont_j, 1);
            am.c(this.dIx, d.C0142d.cp_cont_b, 1);
            am.c(this.hov, d.C0142d.cp_cont_j, 1);
            am.c(this.hou, d.f.icon_news_down_bar_one);
            am.c(this.how, d.C0142d.cp_cont_b, 1);
            am.c(this.hox, d.C0142d.cp_cont_j, 1);
            am.c(this.eny, d.C0142d.cp_cont_b, 1);
            am.c(this.hoy, d.C0142d.cp_cont_j, 1);
            am.j(this.hoz, d.C0142d.cp_bg_line_b);
            am.j(this.hoA, d.C0142d.cp_bg_line_b);
            am.j(this.hoB, d.C0142d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.k.person_privacy_toast), ap.cX(i)), d.f.icon_toast_game_error).xv();
    }

    @Override // com.baidu.tieba.view.e
    public void nv(boolean z) {
        if (this.hou != null) {
            if (z) {
                this.hou.setVisibility(0);
            } else {
                this.hou.setVisibility(8);
            }
        }
    }
}
