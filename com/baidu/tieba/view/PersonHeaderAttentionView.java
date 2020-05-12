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
/* loaded from: classes9.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aOQ;
    private TextView hCF;
    private TextView ikC;
    private TextView jUf;
    private ImageView kbk;
    private f kdS;
    private TextView lvm;
    private TextView lvn;
    private TextView lvo;
    private TextView lvp;
    private TextView lvq;
    private View lvr;
    private View lvs;
    private View lvt;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvu = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUf.getId() && id != PersonHeaderAttentionView.this.lvm.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCF.getId() && id != PersonHeaderAttentionView.this.lvn.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvo.getId() || id == PersonHeaderAttentionView.this.lvp.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvu.gKB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvu.gKB = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvu.gKB = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdS != null) {
                        this.lvu.gKC = new Bundle();
                        this.lvu.gKC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdS.a(view, this.lvu);
                    }
                }
            }
        };
        init(context);
        deH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvu = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUf.getId() && id != PersonHeaderAttentionView.this.lvm.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCF.getId() && id != PersonHeaderAttentionView.this.lvn.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvo.getId() || id == PersonHeaderAttentionView.this.lvp.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvu.gKB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvu.gKB = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvu.gKB = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdS != null) {
                        this.lvu.gKC = new Bundle();
                        this.lvu.gKC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdS.a(view, this.lvu);
                    }
                }
            }
        };
        init(context);
        deH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvu = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUf.getId() && id != PersonHeaderAttentionView.this.lvm.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCF.getId() && id != PersonHeaderAttentionView.this.lvn.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvo.getId() || id == PersonHeaderAttentionView.this.lvp.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWn() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvu.gKB = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvu.gKB = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvu.gKB = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdS != null) {
                        this.lvu.gKC = new Bundle();
                        this.lvu.gKC.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdS.a(view, this.lvu);
                    }
                }
            }
        };
        init(context);
        deH();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.hCF = (TextView) findViewById(R.id.person_header_fans_num);
        this.lvn = (TextView) findViewById(R.id.person_header_fans_des);
        this.kbk = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jUf = (TextView) findViewById(R.id.person_header_attention_num);
        this.lvm = (TextView) findViewById(R.id.person_header_attention_des);
        this.lvo = (TextView) findViewById(R.id.person_header_bar_num);
        this.lvp = (TextView) findViewById(R.id.person_header_bar_des);
        this.ikC = (TextView) findViewById(R.id.person_header_thread_num);
        this.ikC.setVisibility(8);
        this.lvq = (TextView) findViewById(R.id.person_header_thread_des);
        this.lvq.setVisibility(8);
        this.lvr = findViewById(R.id.divider_for_fans_and_attention);
        this.lvs = findViewById(R.id.divider_for_attention_and_bar);
        this.lvt = findViewById(R.id.divider_for_bar_and_thread);
        this.lvt.setVisibility(8);
    }

    private void deH() {
        this.hCF.setOnClickListener(this.aOQ);
        this.lvn.setOnClickListener(this.aOQ);
        this.jUf.setOnClickListener(this.aOQ);
        this.lvm.setOnClickListener(this.aOQ);
        this.lvo.setOnClickListener(this.aOQ);
        this.lvp.setOnClickListener(this.aOQ);
        this.ikC.setOnClickListener(this.aOQ);
        this.lvq.setOnClickListener(this.aOQ);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kdS = fVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jUf.setText(str);
        this.hCF.setText(str2);
        this.lvo.setText(str4);
        this.ikC.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jUf.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.hCF.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.lvo.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ikC.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jUf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvm, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hCF, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvn, R.color.cp_cont_j, 1);
            am.setImageResource(this.kbk, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.lvo, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvp, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.ikC, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvq, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.lvr, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lvs, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lvt, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aMX();
    }
}
