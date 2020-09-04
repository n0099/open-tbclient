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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aBm;
    private TextView iAP;
    private TextView jou;
    private TextView lfU;
    private ImageView lni;
    private f lqk;
    private Context mContext;
    private TextView mJJ;
    private TextView mJK;
    private TextView mJL;
    private TextView mJM;
    private TextView mJN;
    private View mJO;
    private View mJP;
    private View mJQ;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJR = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfU.getId() && id != PersonHeaderAttentionView.this.mJJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAP.getId() && id != PersonHeaderAttentionView.this.mJK.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJL.getId() || id == PersonHeaderAttentionView.this.mJM.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJR.hEt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJR.hEt = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJR.hEt = 4;
                    }
                    if (PersonHeaderAttentionView.this.lqk != null) {
                        this.mJR.hEu = new Bundle();
                        this.mJR.hEu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lqk.a(view, this.mJR);
                    }
                }
            }
        };
        init(context);
        dFu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJR = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfU.getId() && id != PersonHeaderAttentionView.this.mJJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAP.getId() && id != PersonHeaderAttentionView.this.mJK.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJL.getId() || id == PersonHeaderAttentionView.this.mJM.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJR.hEt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJR.hEt = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJR.hEt = 4;
                    }
                    if (PersonHeaderAttentionView.this.lqk != null) {
                        this.mJR.hEu = new Bundle();
                        this.mJR.hEu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lqk.a(view, this.mJR);
                    }
                }
            }
        };
        init(context);
        dFu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJR = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfU.getId() && id != PersonHeaderAttentionView.this.mJJ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAP.getId() && id != PersonHeaderAttentionView.this.mJK.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJL.getId() || id == PersonHeaderAttentionView.this.mJM.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqV() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJR.hEt = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJR.hEt = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJR.hEt = 4;
                    }
                    if (PersonHeaderAttentionView.this.lqk != null) {
                        this.mJR.hEu = new Bundle();
                        this.mJR.hEu.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lqk.a(view, this.mJR);
                    }
                }
            }
        };
        init(context);
        dFu();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.iAP = (TextView) findViewById(R.id.person_header_fans_num);
        this.mJK = (TextView) findViewById(R.id.person_header_fans_des);
        this.lni = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lfU = (TextView) findViewById(R.id.person_header_attention_num);
        this.mJJ = (TextView) findViewById(R.id.person_header_attention_des);
        this.mJL = (TextView) findViewById(R.id.person_header_bar_num);
        this.mJM = (TextView) findViewById(R.id.person_header_bar_des);
        this.jou = (TextView) findViewById(R.id.person_header_thread_num);
        this.jou.setVisibility(8);
        this.mJN = (TextView) findViewById(R.id.person_header_thread_des);
        this.mJN.setVisibility(8);
        this.mJO = findViewById(R.id.divider_for_fans_and_attention);
        this.mJP = findViewById(R.id.divider_for_attention_and_bar);
        this.mJQ = findViewById(R.id.divider_for_bar_and_thread);
        this.mJQ.setVisibility(8);
    }

    private void dFu() {
        this.iAP.setOnClickListener(this.aBm);
        this.mJK.setOnClickListener(this.aBm);
        this.lfU.setOnClickListener(this.aBm);
        this.mJJ.setOnClickListener(this.aBm);
        this.mJL.setOnClickListener(this.aBm);
        this.mJM.setOnClickListener(this.aBm);
        this.jou.setOnClickListener(this.aBm);
        this.mJN.setOnClickListener(this.aBm);
    }

    public void setOnViewResponseListener(f fVar) {
        this.lqk = fVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.lfU.setText(str);
        this.iAP.setText(str2);
        this.mJL.setText(str4);
        this.jou.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lfU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.iAP.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mJL.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.jou.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lfU, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJJ, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.iAP, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJK, R.color.cp_cont_j, 1);
            ap.setImageResource(this.lni, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.mJL, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJM, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jou, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJN, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.mJO, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mJP, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mJQ, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fv(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
    }
}
