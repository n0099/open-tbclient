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
    private View.OnClickListener aju;
    private TextView fYn;
    private TextView gGf;
    private TextView imw;
    private g iuv;
    private TextView jKJ;
    private ImageView jKK;
    private TextView jKL;
    private TextView jKM;
    private TextView jKN;
    private TextView jKO;
    private View jKP;
    private View jKQ;
    private View jKR;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKS = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.imw.getId() && id != PersonHeaderAttentionView.this.jKJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYn.getId() && id != PersonHeaderAttentionView.this.jKL.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKM.getId() || id == PersonHeaderAttentionView.this.jKN.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 2)) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKS.fhu = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKS.fhu = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKS.fhu = 4;
                    }
                    if (PersonHeaderAttentionView.this.iuv != null) {
                        this.jKS.aSR = new Bundle();
                        this.jKS.aSR.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.iuv.a(view, this.jKS);
                    }
                }
            }
        };
        init(context);
        cwR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKS = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.imw.getId() && id != PersonHeaderAttentionView.this.jKJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYn.getId() && id != PersonHeaderAttentionView.this.jKL.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKM.getId() || id == PersonHeaderAttentionView.this.jKN.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 2)) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKS.fhu = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKS.fhu = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKS.fhu = 4;
                    }
                    if (PersonHeaderAttentionView.this.iuv != null) {
                        this.jKS.aSR = new Bundle();
                        this.jKS.aSR.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.iuv.a(view, this.jKS);
                    }
                }
            }
        };
        init(context);
        cwR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKS = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.imw.getId() && id != PersonHeaderAttentionView.this.jKJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.fYn.getId() && id != PersonHeaderAttentionView.this.jKL.getId()) {
                            if (id == PersonHeaderAttentionView.this.jKM.getId() || id == PersonHeaderAttentionView.this.jKN.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aty() != 2)) {
                                    PersonHeaderAttentionView.this.Bk(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKS.fhu = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKS.fhu = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKS.fhu = 4;
                    }
                    if (PersonHeaderAttentionView.this.iuv != null) {
                        this.jKS.aSR = new Bundle();
                        this.jKS.aSR.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.iuv.a(view, this.jKS);
                    }
                }
            }
        };
        init(context);
        cwR();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fYn = (TextView) findViewById(R.id.person_header_fans_num);
        this.jKL = (TextView) findViewById(R.id.person_header_fans_des);
        this.jKK = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.imw = (TextView) findViewById(R.id.person_header_attention_num);
        this.jKJ = (TextView) findViewById(R.id.person_header_attention_des);
        this.jKM = (TextView) findViewById(R.id.person_header_bar_num);
        this.jKN = (TextView) findViewById(R.id.person_header_bar_des);
        this.gGf = (TextView) findViewById(R.id.person_header_thread_num);
        this.gGf.setVisibility(8);
        this.jKO = (TextView) findViewById(R.id.person_header_thread_des);
        this.jKO.setVisibility(8);
        this.jKP = findViewById(R.id.divider_for_fans_and_attention);
        this.jKQ = findViewById(R.id.divider_for_attention_and_bar);
        this.jKR = findViewById(R.id.divider_for_bar_and_thread);
        this.jKR.setVisibility(8);
    }

    private void cwR() {
        this.fYn.setOnClickListener(this.aju);
        this.jKL.setOnClickListener(this.aju);
        this.imw.setOnClickListener(this.aju);
        this.jKJ.setOnClickListener(this.aju);
        this.jKM.setOnClickListener(this.aju);
        this.jKN.setOnClickListener(this.aju);
        this.gGf.setOnClickListener(this.aju);
        this.jKO.setOnClickListener(this.aju);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.iuv = gVar;
    }

    private void y(String str, String str2, String str3, String str4) {
        this.imw.setText(str);
        this.fYn.setText(str2);
        this.jKM.setText(str4);
        this.gGf.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.imw.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fYn.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jKM.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gGf.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        y(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.imw, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jKJ, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fYn, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jKL, R.color.cp_cont_j, 1);
            am.setImageResource(this.jKK, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.jKM, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jKN, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gGf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jKO, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.jKP, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jKQ, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jKR, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake_n_svg, true).akT();
    }

    @Override // com.baidu.tieba.view.e
    public void rG(boolean z) {
        if (this.jKK != null) {
            if (z) {
                this.jKK.setVisibility(0);
            } else {
                this.jKK.setVisibility(8);
            }
        }
    }
}
