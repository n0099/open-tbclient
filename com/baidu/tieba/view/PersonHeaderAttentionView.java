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
    private View.OnClickListener dSO;
    private TextView fRl;
    private TextView gzk;
    private TextView ieo;
    private g imw;
    private TextView jBg;
    private ImageView jBh;
    private TextView jBi;
    private TextView jBj;
    private TextView jBk;
    private TextView jBl;
    private View jBm;
    private View jBn;
    private View jBo;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBp = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ieo.getId() && id != PersonHeaderAttentionView.this.jBg.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRl.getId() && id != PersonHeaderAttentionView.this.jBi.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBj.getId() || id == PersonHeaderAttentionView.this.jBk.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBp.eXv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBp.eXv = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBp.eXv = 4;
                    }
                    if (PersonHeaderAttentionView.this.imw != null) {
                        this.jBp.ayy = new Bundle();
                        this.jBp.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imw.a(view, this.jBp);
                    }
                }
            }
        };
        init(context);
        cvc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBp = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ieo.getId() && id != PersonHeaderAttentionView.this.jBg.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRl.getId() && id != PersonHeaderAttentionView.this.jBi.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBj.getId() || id == PersonHeaderAttentionView.this.jBk.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBp.eXv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBp.eXv = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBp.eXv = 4;
                    }
                    if (PersonHeaderAttentionView.this.imw != null) {
                        this.jBp.ayy = new Bundle();
                        this.jBp.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imw.a(view, this.jBp);
                    }
                }
            }
        };
        init(context);
        cvc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBp = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ieo.getId() && id != PersonHeaderAttentionView.this.jBg.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRl.getId() && id != PersonHeaderAttentionView.this.jBi.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBj.getId() || id == PersonHeaderAttentionView.this.jBk.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBp.eXv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBp.eXv = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBp.eXv = 4;
                    }
                    if (PersonHeaderAttentionView.this.imw != null) {
                        this.jBp.ayy = new Bundle();
                        this.jBp.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imw.a(view, this.jBp);
                    }
                }
            }
        };
        init(context);
        cvc();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fRl = (TextView) findViewById(R.id.person_header_fans_num);
        this.jBi = (TextView) findViewById(R.id.person_header_fans_des);
        this.jBh = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ieo = (TextView) findViewById(R.id.person_header_attention_num);
        this.jBg = (TextView) findViewById(R.id.person_header_attention_des);
        this.jBj = (TextView) findViewById(R.id.person_header_bar_num);
        this.jBk = (TextView) findViewById(R.id.person_header_bar_des);
        this.gzk = (TextView) findViewById(R.id.person_header_thread_num);
        this.gzk.setVisibility(8);
        this.jBl = (TextView) findViewById(R.id.person_header_thread_des);
        this.jBl.setVisibility(8);
        this.jBm = findViewById(R.id.divider_for_fans_and_attention);
        this.jBn = findViewById(R.id.divider_for_attention_and_bar);
        this.jBo = findViewById(R.id.divider_for_bar_and_thread);
        this.jBo.setVisibility(8);
    }

    private void cvc() {
        this.fRl.setOnClickListener(this.dSO);
        this.jBi.setOnClickListener(this.dSO);
        this.ieo.setOnClickListener(this.dSO);
        this.jBg.setOnClickListener(this.dSO);
        this.jBj.setOnClickListener(this.dSO);
        this.jBk.setOnClickListener(this.dSO);
        this.gzk.setOnClickListener(this.dSO);
        this.jBl.setOnClickListener(this.dSO);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.imw = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.ieo.setText(str);
        this.fRl.setText(str2);
        this.jBj.setText(str4);
        this.gzk.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ieo.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fRl.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jBj.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gzk.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        u(ap.aM(this.mUserData.getConcernNum()), ap.aM(this.mUserData.getFansNum()), ap.aM(this.mUserData.getPosts_num()), ap.aM(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.f(this.ieo, R.color.cp_cont_b, 1);
            al.f(this.jBg, R.color.cp_cont_j, 1);
            al.f(this.fRl, R.color.cp_cont_b, 1);
            al.f(this.jBi, R.color.cp_cont_j, 1);
            al.c(this.jBh, (int) R.drawable.icon_news_down_bar_one);
            al.f(this.jBj, R.color.cp_cont_b, 1);
            al.f(this.jBk, R.color.cp_cont_j, 1);
            al.f(this.gzk, R.color.cp_cont_b, 1);
            al.f(this.jBl, R.color.cp_cont_j, 1);
            al.l(this.jBm, R.color.cp_bg_line_b);
            al.l(this.jBn, R.color.cp_bg_line_b);
            al.l(this.jBo, R.color.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), ap.il(i)), R.drawable.icon_toast_game_error).afO();
    }

    @Override // com.baidu.tieba.view.e
    public void rF(boolean z) {
        if (this.jBh != null) {
            if (z) {
                this.jBh.setVisibility(0);
            } else {
                this.jBh.setVisibility(8);
            }
        }
    }
}
