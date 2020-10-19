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
/* loaded from: classes22.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aEX;
    private TextView iXc;
    private TextView jLU;
    private TextView lEd;
    private ImageView lLq;
    private f lOs;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView niZ;
    private TextView nja;
    private TextView njb;
    private TextView njc;
    private TextView njd;
    private View nje;
    private View njf;
    private View njg;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a njh = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lEd.getId() && id != PersonHeaderAttentionView.this.niZ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iXc.getId() && id != PersonHeaderAttentionView.this.nja.getId()) {
                            if (id == PersonHeaderAttentionView.this.njb.getId() || id == PersonHeaderAttentionView.this.njc.getId()) {
                                TiebaStatic.log(new aq("c12502").dK("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 2)) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.njh.iaq = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dK("obj_locate", "8"));
                            this.njh.iaq = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dK("obj_locate", "9"));
                        this.njh.iaq = 4;
                    }
                    if (PersonHeaderAttentionView.this.lOs != null) {
                        this.njh.iar = new Bundle();
                        this.njh.iar.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lOs.a(view, this.njh);
                    }
                }
            }
        };
        init(context);
        dNa();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a njh = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lEd.getId() && id != PersonHeaderAttentionView.this.niZ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iXc.getId() && id != PersonHeaderAttentionView.this.nja.getId()) {
                            if (id == PersonHeaderAttentionView.this.njb.getId() || id == PersonHeaderAttentionView.this.njc.getId()) {
                                TiebaStatic.log(new aq("c12502").dK("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 2)) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.njh.iaq = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dK("obj_locate", "8"));
                            this.njh.iaq = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dK("obj_locate", "9"));
                        this.njh.iaq = 4;
                    }
                    if (PersonHeaderAttentionView.this.lOs != null) {
                        this.njh.iar = new Bundle();
                        this.njh.iar.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lOs.a(view, this.njh);
                    }
                }
            }
        };
        init(context);
        dNa();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a njh = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lEd.getId() && id != PersonHeaderAttentionView.this.niZ.getId()) {
                        if (id != PersonHeaderAttentionView.this.iXc.getId() && id != PersonHeaderAttentionView.this.nja.getId()) {
                            if (id == PersonHeaderAttentionView.this.njb.getId() || id == PersonHeaderAttentionView.this.njc.getId()) {
                                TiebaStatic.log(new aq("c12502").dK("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().buz() != 2)) {
                                    PersonHeaderAttentionView.this.GC(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.njh.iaq = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dK("obj_locate", "8"));
                            this.njh.iaq = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dK("obj_locate", "9"));
                        this.njh.iaq = 4;
                    }
                    if (PersonHeaderAttentionView.this.lOs != null) {
                        this.njh.iar = new Bundle();
                        this.njh.iar.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lOs.a(view, this.njh);
                    }
                }
            }
        };
        init(context);
        dNa();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.iXc = (TextView) findViewById(R.id.person_header_fans_num);
        this.nja = (TextView) findViewById(R.id.person_header_fans_des);
        this.lLq = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lEd = (TextView) findViewById(R.id.person_header_attention_num);
        this.niZ = (TextView) findViewById(R.id.person_header_attention_des);
        this.njb = (TextView) findViewById(R.id.person_header_bar_num);
        this.njc = (TextView) findViewById(R.id.person_header_bar_des);
        this.jLU = (TextView) findViewById(R.id.person_header_thread_num);
        this.jLU.setVisibility(8);
        this.njd = (TextView) findViewById(R.id.person_header_thread_des);
        this.njd.setVisibility(8);
        this.nje = findViewById(R.id.divider_for_fans_and_attention);
        this.njf = findViewById(R.id.divider_for_attention_and_bar);
        this.njg = findViewById(R.id.divider_for_bar_and_thread);
        this.njg.setVisibility(8);
    }

    private void dNa() {
        this.iXc.setOnClickListener(this.aEX);
        this.nja.setOnClickListener(this.aEX);
        this.lEd.setOnClickListener(this.aEX);
        this.niZ.setOnClickListener(this.aEX);
        this.njb.setOnClickListener(this.aEX);
        this.njc.setOnClickListener(this.aEX);
        this.jLU.setOnClickListener(this.aEX);
        this.njd.setOnClickListener(this.aEX);
    }

    public void setOnViewResponseListener(f fVar) {
        this.lOs = fVar;
    }

    private void I(String str, String str2, String str3, String str4) {
        this.lEd.setText(str);
        this.iXc.setText(str2);
        this.njb.setText(str4);
        this.jLU.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lEd.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.iXc.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.njb.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.jLU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        I(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lEd, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.niZ, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.iXc, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nja, R.color.cp_cont_j, 1);
            ap.setImageResource(this.lLq, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.njb, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.njc, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jLU, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.njd, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.nje, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.njf, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.njg, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bkP();
    }
}
