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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener dYB;
    private TextView fYS;
    private TextView gIh;
    private TextView inN;
    private g ivT;
    private TextView jKU;
    private ImageView jKV;
    private TextView jKW;
    private TextView jKX;
    private TextView jKY;
    private TextView jKZ;
    private View jLa;
    private View jLb;
    private View jLc;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jLd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.inN.getId() && id != PersonHeaderAttentionView.this.jKU.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYS.getId() && id != PersonHeaderAttentionView.this.jKW.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKX.getId() || id == PersonHeaderAttentionView.this.jKY.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 2)) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jLd.feK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jLd.feK = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jLd.feK = 4;
                    }
                    if (PersonHeaderAttentionView.this.ivT != null) {
                        this.jLd.azD = new Bundle();
                        this.jLd.azD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ivT.a(view, this.jLd);
                    }
                }
            }
        };
        init(context);
        czd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jLd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.inN.getId() && id != PersonHeaderAttentionView.this.jKU.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYS.getId() && id != PersonHeaderAttentionView.this.jKW.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKX.getId() || id == PersonHeaderAttentionView.this.jKY.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 2)) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jLd.feK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jLd.feK = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jLd.feK = 4;
                    }
                    if (PersonHeaderAttentionView.this.ivT != null) {
                        this.jLd.azD = new Bundle();
                        this.jLd.azD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ivT.a(view, this.jLd);
                    }
                }
            }
        };
        init(context);
        czd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jLd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.inN.getId() && id != PersonHeaderAttentionView.this.jKU.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYS.getId() && id != PersonHeaderAttentionView.this.jKW.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKX.getId() || id == PersonHeaderAttentionView.this.jKY.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arK() != 2)) {
                                    PersonHeaderAttentionView.this.CF(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jLd.feK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jLd.feK = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jLd.feK = 4;
                    }
                    if (PersonHeaderAttentionView.this.ivT != null) {
                        this.jLd.azD = new Bundle();
                        this.jLd.azD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ivT.a(view, this.jLd);
                    }
                }
            }
        };
        init(context);
        czd();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fYS = (TextView) findViewById(R.id.person_header_fans_num);
        this.jKW = (TextView) findViewById(R.id.person_header_fans_des);
        this.jKV = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.inN = (TextView) findViewById(R.id.person_header_attention_num);
        this.jKU = (TextView) findViewById(R.id.person_header_attention_des);
        this.jKX = (TextView) findViewById(R.id.person_header_bar_num);
        this.jKY = (TextView) findViewById(R.id.person_header_bar_des);
        this.gIh = (TextView) findViewById(R.id.person_header_thread_num);
        this.gIh.setVisibility(8);
        this.jKZ = (TextView) findViewById(R.id.person_header_thread_des);
        this.jKZ.setVisibility(8);
        this.jLa = findViewById(R.id.divider_for_fans_and_attention);
        this.jLb = findViewById(R.id.divider_for_attention_and_bar);
        this.jLc = findViewById(R.id.divider_for_bar_and_thread);
        this.jLc.setVisibility(8);
    }

    private void czd() {
        this.fYS.setOnClickListener(this.dYB);
        this.jKW.setOnClickListener(this.dYB);
        this.inN.setOnClickListener(this.dYB);
        this.jKU.setOnClickListener(this.dYB);
        this.jKX.setOnClickListener(this.dYB);
        this.jKY.setOnClickListener(this.dYB);
        this.gIh.setOnClickListener(this.dYB);
        this.jKZ.setOnClickListener(this.dYB);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.ivT = gVar;
    }

    private void v(String str, String str2, String str3, String str4) {
        this.inN.setText(str);
        this.fYS.setText(str2);
        this.jKX.setText(str4);
        this.gIh.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.inN.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fYS.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jKX.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gIh.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        v(aq.aN(this.mUserData.getConcernNum()), aq.aN(this.mUserData.getFansNum()), aq.aN(this.mUserData.getPosts_num()), aq.aN(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.f(this.inN, R.color.cp_cont_b, 1);
            am.f(this.jKU, R.color.cp_cont_j, 1);
            am.f(this.fYS, R.color.cp_cont_b, 1);
            am.f(this.jKW, R.color.cp_cont_j, 1);
            am.c(this.jKV, (int) R.drawable.icon_news_down_bar_one);
            am.f(this.jKX, R.color.cp_cont_b, 1);
            am.f(this.jKY, R.color.cp_cont_j, 1);
            am.f(this.gIh, R.color.cp_cont_b, 1);
            am.f(this.jKZ, R.color.cp_cont_j, 1);
            am.l(this.jLa, R.color.cp_bg_line_c);
            am.l(this.jLb, R.color.cp_bg_line_c);
            am.l(this.jLc, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CF(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), aq.is(i)), R.drawable.icon_pure_toast_mistake_n_svg, true).agW();
    }

    @Override // com.baidu.tieba.view.e
    public void rX(boolean z) {
        if (this.jKV != null) {
            if (z) {
                this.jKV.setVisibility(0);
            } else {
                this.jKV.setVisibility(8);
            }
        }
    }
}
