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
    private TextView fRm;
    private TextView gzl;
    private TextView ier;
    private g imz;
    private TextView jBh;
    private ImageView jBi;
    private TextView jBj;
    private TextView jBk;
    private TextView jBl;
    private TextView jBm;
    private View jBn;
    private View jBo;
    private View jBp;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ier.getId() && id != PersonHeaderAttentionView.this.jBh.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRm.getId() && id != PersonHeaderAttentionView.this.jBj.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBk.getId() || id == PersonHeaderAttentionView.this.jBl.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBq.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBq.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBq.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imz != null) {
                        this.jBq.ayy = new Bundle();
                        this.jBq.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imz.a(view, this.jBq);
                    }
                }
            }
        };
        init(context);
        cve();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ier.getId() && id != PersonHeaderAttentionView.this.jBh.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRm.getId() && id != PersonHeaderAttentionView.this.jBj.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBk.getId() || id == PersonHeaderAttentionView.this.jBl.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBq.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBq.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBq.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imz != null) {
                        this.jBq.ayy = new Bundle();
                        this.jBq.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imz.a(view, this.jBq);
                    }
                }
            }
        };
        init(context);
        cve();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jBq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cE(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ier.getId() && id != PersonHeaderAttentionView.this.jBh.getId()) {
                        if (id != PersonHeaderAttentionView.this.fRm.getId() && id != PersonHeaderAttentionView.this.jBj.getId()) {
                            if (id == PersonHeaderAttentionView.this.jBk.getId() || id == PersonHeaderAttentionView.this.jBl.getId()) {
                                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aqr() != 2)) {
                                    PersonHeaderAttentionView.this.BS(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jBq.eXw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jBq.eXw = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "9"));
                        this.jBq.eXw = 4;
                    }
                    if (PersonHeaderAttentionView.this.imz != null) {
                        this.jBq.ayy = new Bundle();
                        this.jBq.ayy.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.imz.a(view, this.jBq);
                    }
                }
            }
        };
        init(context);
        cve();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fRm = (TextView) findViewById(R.id.person_header_fans_num);
        this.jBj = (TextView) findViewById(R.id.person_header_fans_des);
        this.jBi = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ier = (TextView) findViewById(R.id.person_header_attention_num);
        this.jBh = (TextView) findViewById(R.id.person_header_attention_des);
        this.jBk = (TextView) findViewById(R.id.person_header_bar_num);
        this.jBl = (TextView) findViewById(R.id.person_header_bar_des);
        this.gzl = (TextView) findViewById(R.id.person_header_thread_num);
        this.gzl.setVisibility(8);
        this.jBm = (TextView) findViewById(R.id.person_header_thread_des);
        this.jBm.setVisibility(8);
        this.jBn = findViewById(R.id.divider_for_fans_and_attention);
        this.jBo = findViewById(R.id.divider_for_attention_and_bar);
        this.jBp = findViewById(R.id.divider_for_bar_and_thread);
        this.jBp.setVisibility(8);
    }

    private void cve() {
        this.fRm.setOnClickListener(this.dSP);
        this.jBj.setOnClickListener(this.dSP);
        this.ier.setOnClickListener(this.dSP);
        this.jBh.setOnClickListener(this.dSP);
        this.jBk.setOnClickListener(this.dSP);
        this.jBl.setOnClickListener(this.dSP);
        this.gzl.setOnClickListener(this.dSP);
        this.jBm.setOnClickListener(this.dSP);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.imz = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.ier.setText(str);
        this.fRm.setText(str2);
        this.jBk.setText(str4);
        this.gzl.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ier.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fRm.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jBk.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gzl.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        u(ap.aM(this.mUserData.getConcernNum()), ap.aM(this.mUserData.getFansNum()), ap.aM(this.mUserData.getPosts_num()), ap.aM(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.f(this.ier, R.color.cp_cont_b, 1);
            al.f(this.jBh, R.color.cp_cont_j, 1);
            al.f(this.fRm, R.color.cp_cont_b, 1);
            al.f(this.jBj, R.color.cp_cont_j, 1);
            al.c(this.jBi, (int) R.drawable.icon_news_down_bar_one);
            al.f(this.jBk, R.color.cp_cont_b, 1);
            al.f(this.jBl, R.color.cp_cont_j, 1);
            al.f(this.gzl, R.color.cp_cont_b, 1);
            al.f(this.jBm, R.color.cp_cont_j, 1);
            al.l(this.jBn, R.color.cp_bg_line_b);
            al.l(this.jBo, R.color.cp_bg_line_b);
            al.l(this.jBp, R.color.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), ap.il(i)), R.drawable.icon_toast_game_error).afO();
    }

    @Override // com.baidu.tieba.view.e
    public void rF(boolean z) {
        if (this.jBi != null) {
            if (z) {
                this.jBi.setVisibility(0);
            } else {
                this.jBi.setVisibility(8);
            }
        }
    }
}
