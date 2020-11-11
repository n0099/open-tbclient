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
    private View.OnClickListener aFV;
    private TextView jpx;
    private TextView kep;
    private TextView lWv;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private ImageView mdL;
    private f mgN;
    private View nBA;
    private View nBB;
    private TextView nBu;
    private TextView nBv;
    private TextView nBw;
    private TextView nBx;
    private TextView nBy;
    private View nBz;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nBC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWv.getId() && id != PersonHeaderAttentionView.this.nBu.getId()) {
                        if (id != PersonHeaderAttentionView.this.jpx.getId() && id != PersonHeaderAttentionView.this.nBv.getId()) {
                            if (id == PersonHeaderAttentionView.this.nBw.getId() || id == PersonHeaderAttentionView.this.nBx.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 2)) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nBC.isP = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nBC.isP = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nBC.isP = 4;
                    }
                    if (PersonHeaderAttentionView.this.mgN != null) {
                        this.nBC.isQ = new Bundle();
                        this.nBC.isQ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mgN.a(view, this.nBC);
                    }
                }
            }
        };
        init(context);
        dSK();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nBC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWv.getId() && id != PersonHeaderAttentionView.this.nBu.getId()) {
                        if (id != PersonHeaderAttentionView.this.jpx.getId() && id != PersonHeaderAttentionView.this.nBv.getId()) {
                            if (id == PersonHeaderAttentionView.this.nBw.getId() || id == PersonHeaderAttentionView.this.nBx.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 2)) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nBC.isP = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nBC.isP = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nBC.isP = 4;
                    }
                    if (PersonHeaderAttentionView.this.mgN != null) {
                        this.nBC.isQ = new Bundle();
                        this.nBC.isQ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mgN.a(view, this.nBC);
                    }
                }
            }
        };
        init(context);
        dSK();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nBC = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWv.getId() && id != PersonHeaderAttentionView.this.nBu.getId()) {
                        if (id != PersonHeaderAttentionView.this.jpx.getId() && id != PersonHeaderAttentionView.this.nBv.getId()) {
                            if (id == PersonHeaderAttentionView.this.nBw.getId() || id == PersonHeaderAttentionView.this.nBx.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byR() != 2)) {
                                    PersonHeaderAttentionView.this.Hi(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nBC.isP = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nBC.isP = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nBC.isP = 4;
                    }
                    if (PersonHeaderAttentionView.this.mgN != null) {
                        this.nBC.isQ = new Bundle();
                        this.nBC.isQ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mgN.a(view, this.nBC);
                    }
                }
            }
        };
        init(context);
        dSK();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jpx = (TextView) findViewById(R.id.person_header_fans_num);
        this.nBv = (TextView) findViewById(R.id.person_header_fans_des);
        this.mdL = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lWv = (TextView) findViewById(R.id.person_header_attention_num);
        this.nBu = (TextView) findViewById(R.id.person_header_attention_des);
        this.nBw = (TextView) findViewById(R.id.person_header_bar_num);
        this.nBx = (TextView) findViewById(R.id.person_header_bar_des);
        this.kep = (TextView) findViewById(R.id.person_header_thread_num);
        this.kep.setVisibility(8);
        this.nBy = (TextView) findViewById(R.id.person_header_thread_des);
        this.nBy.setVisibility(8);
        this.nBz = findViewById(R.id.divider_for_fans_and_attention);
        this.nBA = findViewById(R.id.divider_for_attention_and_bar);
        this.nBB = findViewById(R.id.divider_for_bar_and_thread);
        this.nBB.setVisibility(8);
    }

    private void dSK() {
        this.jpx.setOnClickListener(this.aFV);
        this.nBv.setOnClickListener(this.aFV);
        this.lWv.setOnClickListener(this.aFV);
        this.nBu.setOnClickListener(this.aFV);
        this.nBw.setOnClickListener(this.aFV);
        this.nBx.setOnClickListener(this.aFV);
        this.kep.setOnClickListener(this.aFV);
        this.nBy.setOnClickListener(this.aFV);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mgN = fVar;
    }

    private void J(String str, String str2, String str3, String str4) {
        this.lWv.setText(str);
        this.jpx.setText(str2);
        this.nBw.setText(str4);
        this.kep.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lWv.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jpx.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nBw.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kep.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        J(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lWv, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nBu, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jpx, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nBv, R.color.cp_cont_j, 1);
            ap.setImageResource(this.mdL, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.nBw, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nBx, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.kep, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nBy, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.nBz, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.nBA, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.nBB, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bpi();
    }
}
