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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aXG;
    private TextView iRc;
    private TextView igz;
    private TextView kGU;
    private ImageView kOf;
    private f kQM;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mjc;
    private TextView mjd;
    private TextView mje;
    private TextView mjf;
    private TextView mjg;
    private View mjh;
    private View mji;
    private View mjj;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mjk = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && be.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kGU.getId() && id != PersonHeaderAttentionView.this.mjc.getId()) {
                        if (id != PersonHeaderAttentionView.this.igz.getId() && id != PersonHeaderAttentionView.this.mjd.getId()) {
                            if (id == PersonHeaderAttentionView.this.mje.getId() || id == PersonHeaderAttentionView.this.mjf.getId()) {
                                TiebaStatic.log(new ao("c12502").dk("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 2)) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mjk.hlK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ao("c12502").dk("obj_locate", "8"));
                            this.mjk.hlK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "9"));
                        this.mjk.hlK = 4;
                    }
                    if (PersonHeaderAttentionView.this.kQM != null) {
                        this.mjk.hlL = new Bundle();
                        this.mjk.hlL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kQM.a(view, this.mjk);
                    }
                }
            }
        };
        init(context);
        dqz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mjk = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && be.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kGU.getId() && id != PersonHeaderAttentionView.this.mjc.getId()) {
                        if (id != PersonHeaderAttentionView.this.igz.getId() && id != PersonHeaderAttentionView.this.mjd.getId()) {
                            if (id == PersonHeaderAttentionView.this.mje.getId() || id == PersonHeaderAttentionView.this.mjf.getId()) {
                                TiebaStatic.log(new ao("c12502").dk("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 2)) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mjk.hlK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ao("c12502").dk("obj_locate", "8"));
                            this.mjk.hlK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "9"));
                        this.mjk.hlK = 4;
                    }
                    if (PersonHeaderAttentionView.this.kQM != null) {
                        this.mjk.hlL = new Bundle();
                        this.mjk.hlL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kQM.a(view, this.mjk);
                    }
                }
            }
        };
        init(context);
        dqz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mjk = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && be.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kGU.getId() && id != PersonHeaderAttentionView.this.mjc.getId()) {
                        if (id != PersonHeaderAttentionView.this.igz.getId() && id != PersonHeaderAttentionView.this.mjd.getId()) {
                            if (id == PersonHeaderAttentionView.this.mje.getId() || id == PersonHeaderAttentionView.this.mjf.getId()) {
                                TiebaStatic.log(new ao("c12502").dk("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bez() != 2)) {
                                    PersonHeaderAttentionView.this.CA(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mjk.hlK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ao("c12502").dk("obj_locate", "8"));
                            this.mjk.hlK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "9"));
                        this.mjk.hlK = 4;
                    }
                    if (PersonHeaderAttentionView.this.kQM != null) {
                        this.mjk.hlL = new Bundle();
                        this.mjk.hlL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kQM.a(view, this.mjk);
                    }
                }
            }
        };
        init(context);
        dqz();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.igz = (TextView) findViewById(R.id.person_header_fans_num);
        this.mjd = (TextView) findViewById(R.id.person_header_fans_des);
        this.kOf = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.kGU = (TextView) findViewById(R.id.person_header_attention_num);
        this.mjc = (TextView) findViewById(R.id.person_header_attention_des);
        this.mje = (TextView) findViewById(R.id.person_header_bar_num);
        this.mjf = (TextView) findViewById(R.id.person_header_bar_des);
        this.iRc = (TextView) findViewById(R.id.person_header_thread_num);
        this.iRc.setVisibility(8);
        this.mjg = (TextView) findViewById(R.id.person_header_thread_des);
        this.mjg.setVisibility(8);
        this.mjh = findViewById(R.id.divider_for_fans_and_attention);
        this.mji = findViewById(R.id.divider_for_attention_and_bar);
        this.mjj = findViewById(R.id.divider_for_bar_and_thread);
        this.mjj.setVisibility(8);
    }

    private void dqz() {
        this.igz.setOnClickListener(this.aXG);
        this.mjd.setOnClickListener(this.aXG);
        this.kGU.setOnClickListener(this.aXG);
        this.mjc.setOnClickListener(this.aXG);
        this.mje.setOnClickListener(this.aXG);
        this.mjf.setOnClickListener(this.aXG);
        this.iRc.setOnClickListener(this.aXG);
        this.mjg.setOnClickListener(this.aXG);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kQM = fVar;
    }

    private void E(String str, String str2, String str3, String str4) {
        this.kGU.setText(str);
        this.igz.setText(str2);
        this.mje.setText(str4);
        this.iRc.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.kGU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.igz.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mje.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.iRc.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        E(ar.numFormatOverWanNa(this.mUserData.getConcernNum()), ar.numFormatOverWanNa(this.mUserData.getFansNum()), ar.numFormatOverWanNa(this.mUserData.getPosts_num()), ar.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setViewTextColor(this.kGU, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.mjc, R.color.cp_cont_j, 1);
            an.setViewTextColor(this.igz, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.mjd, R.color.cp_cont_j, 1);
            an.setImageResource(this.kOf, R.drawable.icon_news_down_bar_one);
            an.setViewTextColor(this.mje, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.mjf, R.color.cp_cont_j, 1);
            an.setViewTextColor(this.iRc, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.mjg, R.color.cp_cont_j, 1);
            an.setBackgroundColor(this.mjh, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.mji, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.mjj, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), ar.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aUS();
    }
}
