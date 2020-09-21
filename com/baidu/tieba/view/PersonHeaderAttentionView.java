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
/* loaded from: classes21.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aBS;
    private TextView iIk;
    private TextView jwX;
    private TextView loQ;
    private ImageView lwe;
    private f lzd;
    private Context mContext;
    private int mSkinType;
    private TextView mTA;
    private TextView mTB;
    private TextView mTC;
    private TextView mTD;
    private View mTE;
    private View mTF;
    private View mTG;
    private TextView mTz;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mTH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.loQ.getId() && id != PersonHeaderAttentionView.this.mTz.getId()) {
                        if (id != PersonHeaderAttentionView.this.iIk.getId() && id != PersonHeaderAttentionView.this.mTA.getId()) {
                            if (id == PersonHeaderAttentionView.this.mTB.getId() || id == PersonHeaderAttentionView.this.mTC.getId()) {
                                TiebaStatic.log(new aq("c12502").dF("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 2)) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mTH.hLv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dF("obj_locate", "8"));
                            this.mTH.hLv = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "9"));
                        this.mTH.hLv = 4;
                    }
                    if (PersonHeaderAttentionView.this.lzd != null) {
                        this.mTH.hLw = new Bundle();
                        this.mTH.hLw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lzd.a(view, this.mTH);
                    }
                }
            }
        };
        init(context);
        dJo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mTH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.loQ.getId() && id != PersonHeaderAttentionView.this.mTz.getId()) {
                        if (id != PersonHeaderAttentionView.this.iIk.getId() && id != PersonHeaderAttentionView.this.mTA.getId()) {
                            if (id == PersonHeaderAttentionView.this.mTB.getId() || id == PersonHeaderAttentionView.this.mTC.getId()) {
                                TiebaStatic.log(new aq("c12502").dF("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 2)) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mTH.hLv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dF("obj_locate", "8"));
                            this.mTH.hLv = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "9"));
                        this.mTH.hLv = 4;
                    }
                    if (PersonHeaderAttentionView.this.lzd != null) {
                        this.mTH.hLw = new Bundle();
                        this.mTH.hLw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lzd.a(view, this.mTH);
                    }
                }
            }
        };
        init(context);
        dJo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mTH = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.loQ.getId() && id != PersonHeaderAttentionView.this.mTz.getId()) {
                        if (id != PersonHeaderAttentionView.this.iIk.getId() && id != PersonHeaderAttentionView.this.mTA.getId()) {
                            if (id == PersonHeaderAttentionView.this.mTB.getId() || id == PersonHeaderAttentionView.this.mTC.getId()) {
                                TiebaStatic.log(new aq("c12502").dF("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().brP() != 2)) {
                                    PersonHeaderAttentionView.this.FW(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mTH.hLv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dF("obj_locate", "8"));
                            this.mTH.hLv = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "9"));
                        this.mTH.hLv = 4;
                    }
                    if (PersonHeaderAttentionView.this.lzd != null) {
                        this.mTH.hLw = new Bundle();
                        this.mTH.hLw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lzd.a(view, this.mTH);
                    }
                }
            }
        };
        init(context);
        dJo();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.iIk = (TextView) findViewById(R.id.person_header_fans_num);
        this.mTA = (TextView) findViewById(R.id.person_header_fans_des);
        this.lwe = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.loQ = (TextView) findViewById(R.id.person_header_attention_num);
        this.mTz = (TextView) findViewById(R.id.person_header_attention_des);
        this.mTB = (TextView) findViewById(R.id.person_header_bar_num);
        this.mTC = (TextView) findViewById(R.id.person_header_bar_des);
        this.jwX = (TextView) findViewById(R.id.person_header_thread_num);
        this.jwX.setVisibility(8);
        this.mTD = (TextView) findViewById(R.id.person_header_thread_des);
        this.mTD.setVisibility(8);
        this.mTE = findViewById(R.id.divider_for_fans_and_attention);
        this.mTF = findViewById(R.id.divider_for_attention_and_bar);
        this.mTG = findViewById(R.id.divider_for_bar_and_thread);
        this.mTG.setVisibility(8);
    }

    private void dJo() {
        this.iIk.setOnClickListener(this.aBS);
        this.mTA.setOnClickListener(this.aBS);
        this.loQ.setOnClickListener(this.aBS);
        this.mTz.setOnClickListener(this.aBS);
        this.mTB.setOnClickListener(this.aBS);
        this.mTC.setOnClickListener(this.aBS);
        this.jwX.setOnClickListener(this.aBS);
        this.mTD.setOnClickListener(this.aBS);
    }

    public void setOnViewResponseListener(f fVar) {
        this.lzd = fVar;
    }

    private void H(String str, String str2, String str3, String str4) {
        this.loQ.setText(str);
        this.iIk.setText(str2);
        this.mTB.setText(str4);
        this.jwX.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.loQ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.iIk.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mTB.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.jwX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        H(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.loQ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTz, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.iIk, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTA, R.color.cp_cont_j, 1);
            ap.setImageResource(this.lwe, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.mTB, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTC, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jwX, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mTD, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.mTE, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mTF, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mTG, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).big();
    }
}
