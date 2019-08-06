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
    private View.OnClickListener dWR;
    private TextView fXb;
    private TextView gGp;
    private TextView ilL;
    private g itU;
    private ImageView jIA;
    private TextView jIB;
    private TextView jIC;
    private TextView jID;
    private TextView jIE;
    private View jIF;
    private View jIG;
    private View jIH;
    private TextView jIz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jII = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilL.getId() && id != PersonHeaderAttentionView.this.jIz.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXb.getId() && id != PersonHeaderAttentionView.this.jIB.getId()) {
                            if (id == PersonHeaderAttentionView.this.jIC.getId() || id == PersonHeaderAttentionView.this.jID.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 2)) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jII.fcX = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jII.fcX = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jII.fcX = 4;
                    }
                    if (PersonHeaderAttentionView.this.itU != null) {
                        this.jII.azf = new Bundle();
                        this.jII.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itU.a(view, this.jII);
                    }
                }
            }
        };
        init(context);
        cyp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jII = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilL.getId() && id != PersonHeaderAttentionView.this.jIz.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXb.getId() && id != PersonHeaderAttentionView.this.jIB.getId()) {
                            if (id == PersonHeaderAttentionView.this.jIC.getId() || id == PersonHeaderAttentionView.this.jID.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 2)) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jII.fcX = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jII.fcX = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jII.fcX = 4;
                    }
                    if (PersonHeaderAttentionView.this.itU != null) {
                        this.jII.azf = new Bundle();
                        this.jII.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itU.a(view, this.jII);
                    }
                }
            }
        };
        init(context);
        cyp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jII = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bd.cF(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilL.getId() && id != PersonHeaderAttentionView.this.jIz.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXb.getId() && id != PersonHeaderAttentionView.this.jIB.getId()) {
                            if (id == PersonHeaderAttentionView.this.jIC.getId() || id == PersonHeaderAttentionView.this.jID.getId()) {
                                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().ary() != 2)) {
                                    PersonHeaderAttentionView.this.CB(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jII.fcX = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jII.fcX = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "9"));
                        this.jII.fcX = 4;
                    }
                    if (PersonHeaderAttentionView.this.itU != null) {
                        this.jII.azf = new Bundle();
                        this.jII.azf.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itU.a(view, this.jII);
                    }
                }
            }
        };
        init(context);
        cyp();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fXb = (TextView) findViewById(R.id.person_header_fans_num);
        this.jIB = (TextView) findViewById(R.id.person_header_fans_des);
        this.jIA = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ilL = (TextView) findViewById(R.id.person_header_attention_num);
        this.jIz = (TextView) findViewById(R.id.person_header_attention_des);
        this.jIC = (TextView) findViewById(R.id.person_header_bar_num);
        this.jID = (TextView) findViewById(R.id.person_header_bar_des);
        this.gGp = (TextView) findViewById(R.id.person_header_thread_num);
        this.gGp.setVisibility(8);
        this.jIE = (TextView) findViewById(R.id.person_header_thread_des);
        this.jIE.setVisibility(8);
        this.jIF = findViewById(R.id.divider_for_fans_and_attention);
        this.jIG = findViewById(R.id.divider_for_attention_and_bar);
        this.jIH = findViewById(R.id.divider_for_bar_and_thread);
        this.jIH.setVisibility(8);
    }

    private void cyp() {
        this.fXb.setOnClickListener(this.dWR);
        this.jIB.setOnClickListener(this.dWR);
        this.ilL.setOnClickListener(this.dWR);
        this.jIz.setOnClickListener(this.dWR);
        this.jIC.setOnClickListener(this.dWR);
        this.jID.setOnClickListener(this.dWR);
        this.gGp.setOnClickListener(this.dWR);
        this.jIE.setOnClickListener(this.dWR);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.itU = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.ilL.setText(str);
        this.fXb.setText(str2);
        this.jIC.setText(str4);
        this.gGp.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ilL.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fXb.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jIC.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gGp.setTextSize(0, l.g(this.mContext, R.dimen.ds32));
        }
        u(aq.aN(this.mUserData.getConcernNum()), aq.aN(this.mUserData.getFansNum()), aq.aN(this.mUserData.getPosts_num()), aq.aN(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.f(this.ilL, R.color.cp_cont_b, 1);
            am.f(this.jIz, R.color.cp_cont_j, 1);
            am.f(this.fXb, R.color.cp_cont_b, 1);
            am.f(this.jIB, R.color.cp_cont_j, 1);
            am.c(this.jIA, (int) R.drawable.icon_news_down_bar_one);
            am.f(this.jIC, R.color.cp_cont_b, 1);
            am.f(this.jID, R.color.cp_cont_j, 1);
            am.f(this.gGp, R.color.cp_cont_b, 1);
            am.f(this.jIE, R.color.cp_cont_j, 1);
            am.l(this.jIF, R.color.cp_bg_line_b);
            am.l(this.jIG, R.color.cp_bg_line_b);
            am.l(this.jIH, R.color.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), aq.ir(i)), R.drawable.icon_toast_game_error).agS();
    }

    @Override // com.baidu.tieba.view.e
    public void rU(boolean z) {
        if (this.jIA != null) {
            if (z) {
                this.jIA.setVisibility(0);
            } else {
                this.jIA.setVisibility(8);
            }
        }
    }
}
