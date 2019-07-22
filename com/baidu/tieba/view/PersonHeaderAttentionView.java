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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener dWK;
    private TextView fWl;
    private TextView gFx;
    private TextView ikI;
    private g isR;
    private View jHA;
    private TextView jHs;
    private ImageView jHt;
    private TextView jHu;
    private TextView jHv;
    private TextView jHw;
    private TextView jHx;
    private View jHy;
    private View jHz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jHB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ikI.getId() && id != PersonHeaderAttentionView.this.jHs.getId()) {
                        if (id != PersonHeaderAttentionView.this.fWl.getId() && id != PersonHeaderAttentionView.this.jHu.getId()) {
                            if (id == PersonHeaderAttentionView.this.jHv.getId() || id == PersonHeaderAttentionView.this.jHw.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 2)) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jHB.fcx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jHB.fcx = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jHB.fcx = 4;
                    }
                    if (PersonHeaderAttentionView.this.isR != null) {
                        this.jHB.azf = new Bundle();
                        this.jHB.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.isR.a(view, this.jHB);
                    }
                }
            }
        };
        init(context);
        cxT();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jHB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ikI.getId() && id != PersonHeaderAttentionView.this.jHs.getId()) {
                        if (id != PersonHeaderAttentionView.this.fWl.getId() && id != PersonHeaderAttentionView.this.jHu.getId()) {
                            if (id == PersonHeaderAttentionView.this.jHv.getId() || id == PersonHeaderAttentionView.this.jHw.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 2)) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jHB.fcx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jHB.fcx = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jHB.fcx = 4;
                    }
                    if (PersonHeaderAttentionView.this.isR != null) {
                        this.jHB.azf = new Bundle();
                        this.jHB.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.isR.a(view, this.jHB);
                    }
                }
            }
        };
        init(context);
        cxT();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jHB = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ikI.getId() && id != PersonHeaderAttentionView.this.jHs.getId()) {
                        if (id != PersonHeaderAttentionView.this.fWl.getId() && id != PersonHeaderAttentionView.this.jHu.getId()) {
                            if (id == PersonHeaderAttentionView.this.jHv.getId() || id == PersonHeaderAttentionView.this.jHw.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().arw() != 2)) {
                                    PersonHeaderAttentionView.this.Cz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jHB.fcx = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jHB.fcx = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jHB.fcx = 4;
                    }
                    if (PersonHeaderAttentionView.this.isR != null) {
                        this.jHB.azf = new Bundle();
                        this.jHB.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.isR.a(view, this.jHB);
                    }
                }
            }
        };
        init(context);
        cxT();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fWl = (TextView) findViewById(R.id.person_header_fans_num);
        this.jHu = (TextView) findViewById(R.id.person_header_fans_des);
        this.jHt = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ikI = (TextView) findViewById(R.id.person_header_attention_num);
        this.jHs = (TextView) findViewById(R.id.person_header_attention_des);
        this.jHv = (TextView) findViewById(R.id.person_header_bar_num);
        this.jHw = (TextView) findViewById(R.id.person_header_bar_des);
        this.gFx = (TextView) findViewById(R.id.person_header_thread_num);
        this.gFx.setVisibility(8);
        this.jHx = (TextView) findViewById(R.id.person_header_thread_des);
        this.jHx.setVisibility(8);
        this.jHy = findViewById(R.id.divider_for_fans_and_attention);
        this.jHz = findViewById(R.id.divider_for_attention_and_bar);
        this.jHA = findViewById(R.id.divider_for_bar_and_thread);
        this.jHA.setVisibility(8);
    }

    private void cxT() {
        this.fWl.setOnClickListener(this.dWK);
        this.jHu.setOnClickListener(this.dWK);
        this.ikI.setOnClickListener(this.dWK);
        this.jHs.setOnClickListener(this.dWK);
        this.jHv.setOnClickListener(this.dWK);
        this.jHw.setOnClickListener(this.dWK);
        this.gFx.setOnClickListener(this.dWK);
        this.jHx.setOnClickListener(this.dWK);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.isR = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.ikI.setText(str);
        this.fWl.setText(str2);
        this.jHv.setText(str4);
        this.gFx.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ikI.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fWl.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jHv.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gFx.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        u(aq.aN(this.mUserData.getConcernNum()), aq.aN(this.mUserData.getFansNum()), aq.aN(this.mUserData.getPosts_num()), aq.aN(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.f(this.ikI, R.color.cp_cont_b, 1);
            am.f(this.jHs, R.color.cp_cont_j, 1);
            am.f(this.fWl, R.color.cp_cont_b, 1);
            am.f(this.jHu, R.color.cp_cont_j, 1);
            am.c(this.jHt, (int) R.drawable.icon_news_down_bar_one);
            am.f(this.jHv, R.color.cp_cont_b, 1);
            am.f(this.jHw, R.color.cp_cont_j, 1);
            am.f(this.gFx, R.color.cp_cont_b, 1);
            am.f(this.jHx, R.color.cp_cont_j, 1);
            am.l(this.jHy, R.color.cp_bg_line_b);
            am.l(this.jHz, R.color.cp_bg_line_b);
            am.l(this.jHA, R.color.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), aq.ir(i)), R.drawable.icon_toast_game_error).agQ();
    }

    @Override // com.baidu.tieba.view.e
    public void rT(boolean z) {
        if (this.jHt != null) {
            if (z) {
                this.jHt.setVisibility(0);
            } else {
                this.jHt.setVisibility(8);
            }
        }
    }
}
