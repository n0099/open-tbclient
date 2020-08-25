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
    private View.OnClickListener aBk;
    private TextView iAJ;
    private TextView joo;
    private TextView lfN;
    private ImageView lmW;
    private f lpZ;
    private Context mContext;
    private TextView mJr;
    private TextView mJs;
    private TextView mJt;
    private TextView mJu;
    private TextView mJv;
    private View mJw;
    private View mJx;
    private View mJy;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJz = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfN.getId() && id != PersonHeaderAttentionView.this.mJr.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAJ.getId() && id != PersonHeaderAttentionView.this.mJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJt.getId() || id == PersonHeaderAttentionView.this.mJu.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJz.hEn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJz.hEn = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJz.hEn = 4;
                    }
                    if (PersonHeaderAttentionView.this.lpZ != null) {
                        this.mJz.hEo = new Bundle();
                        this.mJz.hEo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lpZ.a(view, this.mJz);
                    }
                }
            }
        };
        init(context);
        dFl();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJz = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfN.getId() && id != PersonHeaderAttentionView.this.mJr.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAJ.getId() && id != PersonHeaderAttentionView.this.mJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJt.getId() || id == PersonHeaderAttentionView.this.mJu.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJz.hEn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJz.hEn = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJz.hEn = 4;
                    }
                    if (PersonHeaderAttentionView.this.lpZ != null) {
                        this.mJz.hEo = new Bundle();
                        this.mJz.hEo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lpZ.a(view, this.mJz);
                    }
                }
            }
        };
        init(context);
        dFl();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mJz = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lfN.getId() && id != PersonHeaderAttentionView.this.mJr.getId()) {
                        if (id != PersonHeaderAttentionView.this.iAJ.getId() && id != PersonHeaderAttentionView.this.mJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.mJt.getId() || id == PersonHeaderAttentionView.this.mJu.getId()) {
                                TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bqU() != 2)) {
                                    PersonHeaderAttentionView.this.Fv(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mJz.hEn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
                            this.mJz.hEn = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
                        this.mJz.hEn = 4;
                    }
                    if (PersonHeaderAttentionView.this.lpZ != null) {
                        this.mJz.hEo = new Bundle();
                        this.mJz.hEo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.lpZ.a(view, this.mJz);
                    }
                }
            }
        };
        init(context);
        dFl();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.iAJ = (TextView) findViewById(R.id.person_header_fans_num);
        this.mJs = (TextView) findViewById(R.id.person_header_fans_des);
        this.lmW = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lfN = (TextView) findViewById(R.id.person_header_attention_num);
        this.mJr = (TextView) findViewById(R.id.person_header_attention_des);
        this.mJt = (TextView) findViewById(R.id.person_header_bar_num);
        this.mJu = (TextView) findViewById(R.id.person_header_bar_des);
        this.joo = (TextView) findViewById(R.id.person_header_thread_num);
        this.joo.setVisibility(8);
        this.mJv = (TextView) findViewById(R.id.person_header_thread_des);
        this.mJv.setVisibility(8);
        this.mJw = findViewById(R.id.divider_for_fans_and_attention);
        this.mJx = findViewById(R.id.divider_for_attention_and_bar);
        this.mJy = findViewById(R.id.divider_for_bar_and_thread);
        this.mJy.setVisibility(8);
    }

    private void dFl() {
        this.iAJ.setOnClickListener(this.aBk);
        this.mJs.setOnClickListener(this.aBk);
        this.lfN.setOnClickListener(this.aBk);
        this.mJr.setOnClickListener(this.aBk);
        this.mJt.setOnClickListener(this.aBk);
        this.mJu.setOnClickListener(this.aBk);
        this.joo.setOnClickListener(this.aBk);
        this.mJv.setOnClickListener(this.aBk);
    }

    public void setOnViewResponseListener(f fVar) {
        this.lpZ = fVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.lfN.setText(str);
        this.iAJ.setText(str2);
        this.mJt.setText(str4);
        this.joo.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lfN.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.iAJ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mJt.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.joo.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lfN, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJr, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.iAJ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJs, R.color.cp_cont_j, 1);
            ap.setImageResource(this.lmW, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.mJt, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJu, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.joo, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mJv, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.mJw, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mJx, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.mJy, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fv(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
    }
}
