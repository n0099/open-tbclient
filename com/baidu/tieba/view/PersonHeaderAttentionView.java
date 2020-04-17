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
    private View.OnClickListener aOK;
    private TextView hCz;
    private TextView ikw;
    private TextView jUb;
    private ImageView kbg;
    private f kdO;
    private TextView lvi;
    private TextView lvj;
    private TextView lvk;
    private TextView lvl;
    private TextView lvm;
    private View lvn;
    private View lvo;
    private View lvp;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUb.getId() && id != PersonHeaderAttentionView.this.lvi.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCz.getId() && id != PersonHeaderAttentionView.this.lvj.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvk.getId() || id == PersonHeaderAttentionView.this.lvl.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvq.gKv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvq.gKv = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvq.gKv = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdO != null) {
                        this.lvq.gKw = new Bundle();
                        this.lvq.gKw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdO.a(view, this.lvq);
                    }
                }
            }
        };
        init(context);
        deJ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUb.getId() && id != PersonHeaderAttentionView.this.lvi.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCz.getId() && id != PersonHeaderAttentionView.this.lvj.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvk.getId() || id == PersonHeaderAttentionView.this.lvl.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvq.gKv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvq.gKv = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvq.gKv = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdO != null) {
                        this.lvq.gKw = new Bundle();
                        this.lvq.gKw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdO.a(view, this.lvq);
                    }
                }
            }
        };
        init(context);
        deJ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lvq = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jUb.getId() && id != PersonHeaderAttentionView.this.lvi.getId()) {
                        if (id != PersonHeaderAttentionView.this.hCz.getId() && id != PersonHeaderAttentionView.this.lvj.getId()) {
                            if (id == PersonHeaderAttentionView.this.lvk.getId() || id == PersonHeaderAttentionView.this.lvl.getId()) {
                                TiebaStatic.log(new an("c12502").cI("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aWp() != 2)) {
                                    PersonHeaderAttentionView.this.AL(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lvq.gKv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cI("obj_locate", "8"));
                            this.lvq.gKv = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cI("obj_locate", "9"));
                        this.lvq.gKv = 4;
                    }
                    if (PersonHeaderAttentionView.this.kdO != null) {
                        this.lvq.gKw = new Bundle();
                        this.lvq.gKw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kdO.a(view, this.lvq);
                    }
                }
            }
        };
        init(context);
        deJ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.hCz = (TextView) findViewById(R.id.person_header_fans_num);
        this.lvj = (TextView) findViewById(R.id.person_header_fans_des);
        this.kbg = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jUb = (TextView) findViewById(R.id.person_header_attention_num);
        this.lvi = (TextView) findViewById(R.id.person_header_attention_des);
        this.lvk = (TextView) findViewById(R.id.person_header_bar_num);
        this.lvl = (TextView) findViewById(R.id.person_header_bar_des);
        this.ikw = (TextView) findViewById(R.id.person_header_thread_num);
        this.ikw.setVisibility(8);
        this.lvm = (TextView) findViewById(R.id.person_header_thread_des);
        this.lvm.setVisibility(8);
        this.lvn = findViewById(R.id.divider_for_fans_and_attention);
        this.lvo = findViewById(R.id.divider_for_attention_and_bar);
        this.lvp = findViewById(R.id.divider_for_bar_and_thread);
        this.lvp.setVisibility(8);
    }

    private void deJ() {
        this.hCz.setOnClickListener(this.aOK);
        this.lvj.setOnClickListener(this.aOK);
        this.jUb.setOnClickListener(this.aOK);
        this.lvi.setOnClickListener(this.aOK);
        this.lvk.setOnClickListener(this.aOK);
        this.lvl.setOnClickListener(this.aOK);
        this.ikw.setOnClickListener(this.aOK);
        this.lvm.setOnClickListener(this.aOK);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kdO = fVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jUb.setText(str);
        this.hCz.setText(str2);
        this.lvk.setText(str4);
        this.ikw.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jUb.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.hCz.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.lvk.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ikw.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jUb, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvi, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hCz, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvj, R.color.cp_cont_j, 1);
            am.setImageResource(this.kbg, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.lvk, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvl, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.ikw, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lvm, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.lvn, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lvo, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lvp, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aMZ();
    }
}
