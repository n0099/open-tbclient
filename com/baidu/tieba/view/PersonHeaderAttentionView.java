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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener dSP;
    private TextView fRo;
    private TextView gzn;
    private TextView ies;
    private g imA;
    private TextView jBk;
    private ImageView jBl;
    private TextView jBm;
    private TextView jBn;
    private TextView jBo;
    private TextView jBp;
    private View jBq;
    private View jBr;
    private View jBs;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBt = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ies.getId() && id != PersonHeaderAttentionView.this.jBk.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRo.getId() && id != PersonHeaderAttentionView.this.jBm.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBn.getId() || id == PersonHeaderAttentionView.this.jBo.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBt.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBt.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBt.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imA != null) {
                        this.jBt.ayy = new Bundle();
                        this.jBt.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imA.a(view, this.jBt);
                    }
                }
            }
        };
        init(context);
        cvd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBt = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ies.getId() && id != PersonHeaderAttentionView.this.jBk.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRo.getId() && id != PersonHeaderAttentionView.this.jBm.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBn.getId() || id == PersonHeaderAttentionView.this.jBo.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBt.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBt.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBt.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imA != null) {
                        this.jBt.ayy = new Bundle();
                        this.jBt.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imA.a(view, this.jBt);
                    }
                }
            }
        };
        init(context);
        cvd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBt = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ies.getId() && id != PersonHeaderAttentionView.this.jBk.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRo.getId() && id != PersonHeaderAttentionView.this.jBm.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBn.getId() || id == PersonHeaderAttentionView.this.jBo.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBt.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBt.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBt.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imA != null) {
                        this.jBt.ayy = new Bundle();
                        this.jBt.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imA.a(view, this.jBt);
                    }
                }
            }
        };
        init(context);
        cvd();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fRo = (TextView) findViewById(R.id.person_header_fans_num);
        this.jBm = (TextView) findViewById(R.id.person_header_fans_des);
        this.jBl = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ies = (TextView) findViewById(R.id.person_header_attention_num);
        this.jBk = (TextView) findViewById(R.id.person_header_attention_des);
        this.jBn = (TextView) findViewById(R.id.person_header_bar_num);
        this.jBo = (TextView) findViewById(R.id.person_header_bar_des);
        this.gzn = (TextView) findViewById(R.id.person_header_thread_num);
        this.gzn.setVisibility(8);
        this.jBp = (TextView) findViewById(R.id.person_header_thread_des);
        this.jBp.setVisibility(8);
        this.jBq = findViewById(R.id.divider_for_fans_and_attention);
        this.jBr = findViewById(R.id.divider_for_attention_and_bar);
        this.jBs = findViewById(R.id.divider_for_bar_and_thread);
        this.jBs.setVisibility(8);
    }

    private void cvd() {
        this.fRo.setOnClickListener(this.dSP);
        this.jBm.setOnClickListener(this.dSP);
        this.ies.setOnClickListener(this.dSP);
        this.jBk.setOnClickListener(this.dSP);
        this.jBn.setOnClickListener(this.dSP);
        this.jBo.setOnClickListener(this.dSP);
        this.gzn.setOnClickListener(this.dSP);
        this.jBp.setOnClickListener(this.dSP);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.imA = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.ies.setText(str);
        this.fRo.setText(str2);
        this.jBn.setText(str4);
        this.gzn.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ies.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fRo.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jBn.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gzn.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        u(ap.aM(this.mUserData.getConcernNum()), ap.aM(this.mUserData.getFansNum()), ap.aM(this.mUserData.getPosts_num()), ap.aM(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.f(this.ies, R.color.cp_cont_b, 1);
            al.f(this.jBk, R.color.cp_cont_j, 1);
            al.f(this.fRo, R.color.cp_cont_b, 1);
            al.f(this.jBm, R.color.cp_cont_j, 1);
            al.c(this.jBl, (int) R.drawable.icon_news_down_bar_one);
            al.f(this.jBn, R.color.cp_cont_b, 1);
            al.f(this.jBo, R.color.cp_cont_j, 1);
            al.f(this.gzn, R.color.cp_cont_b, 1);
            al.f(this.jBp, R.color.cp_cont_j, 1);
            al.l(this.jBq, R.color.cp_bg_line_b);
            al.l(this.jBr, R.color.cp_bg_line_b);
            al.l(this.jBs, R.color.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), ap.il(i)), R.drawable.icon_toast_game_error).afO();
    }

    @Override // com.baidu.tieba.view.e
    public void rG(boolean z) {
        if (this.jBl != null) {
            if (z) {
                this.jBl.setVisibility(0);
            } else {
                this.jBl.setVisibility(8);
            }
        }
    }
}
