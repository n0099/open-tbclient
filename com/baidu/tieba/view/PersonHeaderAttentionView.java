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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aEk;
    private TextView jqe;
    private TextView kfa;
    private TextView lWN;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private ImageView med;
    private f mhg;
    private TextView nCR;
    private TextView nCS;
    private TextView nCT;
    private TextView nCU;
    private TextView nCV;
    private View nCW;
    private View nCX;
    private View nCY;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nCZ = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWN.getId() && id != PersonHeaderAttentionView.this.nCR.getId()) {
                        if (id != PersonHeaderAttentionView.this.jqe.getId() && id != PersonHeaderAttentionView.this.nCS.getId()) {
                            if (id == PersonHeaderAttentionView.this.nCT.getId() || id == PersonHeaderAttentionView.this.nCU.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 2)) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nCZ.itD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nCZ.itD = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nCZ.itD = 4;
                    }
                    if (PersonHeaderAttentionView.this.mhg != null) {
                        this.nCZ.itE = new Bundle();
                        this.nCZ.itE.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mhg.a(view, this.nCZ);
                    }
                }
            }
        };
        init(context);
        dSJ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nCZ = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWN.getId() && id != PersonHeaderAttentionView.this.nCR.getId()) {
                        if (id != PersonHeaderAttentionView.this.jqe.getId() && id != PersonHeaderAttentionView.this.nCS.getId()) {
                            if (id == PersonHeaderAttentionView.this.nCT.getId() || id == PersonHeaderAttentionView.this.nCU.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 2)) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nCZ.itD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nCZ.itD = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nCZ.itD = 4;
                    }
                    if (PersonHeaderAttentionView.this.mhg != null) {
                        this.nCZ.itE = new Bundle();
                        this.nCZ.itE.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mhg.a(view, this.nCZ);
                    }
                }
            }
        };
        init(context);
        dSJ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nCZ = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lWN.getId() && id != PersonHeaderAttentionView.this.nCR.getId()) {
                        if (id != PersonHeaderAttentionView.this.jqe.getId() && id != PersonHeaderAttentionView.this.nCS.getId()) {
                            if (id == PersonHeaderAttentionView.this.nCT.getId() || id == PersonHeaderAttentionView.this.nCU.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().byh() != 2)) {
                                    PersonHeaderAttentionView.this.HG(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nCZ.itD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nCZ.itD = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nCZ.itD = 4;
                    }
                    if (PersonHeaderAttentionView.this.mhg != null) {
                        this.nCZ.itE = new Bundle();
                        this.nCZ.itE.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mhg.a(view, this.nCZ);
                    }
                }
            }
        };
        init(context);
        dSJ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jqe = (TextView) findViewById(R.id.person_header_fans_num);
        this.nCS = (TextView) findViewById(R.id.person_header_fans_des);
        this.med = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lWN = (TextView) findViewById(R.id.person_header_attention_num);
        this.nCR = (TextView) findViewById(R.id.person_header_attention_des);
        this.nCT = (TextView) findViewById(R.id.person_header_bar_num);
        this.nCU = (TextView) findViewById(R.id.person_header_bar_des);
        this.kfa = (TextView) findViewById(R.id.person_header_thread_num);
        this.kfa.setVisibility(8);
        this.nCV = (TextView) findViewById(R.id.person_header_thread_des);
        this.nCV.setVisibility(8);
        this.nCW = findViewById(R.id.divider_for_fans_and_attention);
        this.nCX = findViewById(R.id.divider_for_attention_and_bar);
        this.nCY = findViewById(R.id.divider_for_bar_and_thread);
        this.nCY.setVisibility(8);
    }

    private void dSJ() {
        this.jqe.setOnClickListener(this.aEk);
        this.nCS.setOnClickListener(this.aEk);
        this.lWN.setOnClickListener(this.aEk);
        this.nCR.setOnClickListener(this.aEk);
        this.nCT.setOnClickListener(this.aEk);
        this.nCU.setOnClickListener(this.aEk);
        this.kfa.setOnClickListener(this.aEk);
        this.nCV.setOnClickListener(this.aEk);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mhg = fVar;
    }

    private void J(String str, String str2, String str3, String str4) {
        this.lWN.setText(str);
        this.jqe.setText(str2);
        this.nCT.setText(str4);
        this.kfa.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lWN.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jqe.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nCT.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kfa.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        J(au.numFormatOverWanNa(this.mUserData.getConcernNum()), au.numFormatOverWanNa(this.mUserData.getFansNum()), au.numFormatOverWanNa(this.mUserData.getPosts_num()), au.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lWN, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nCR, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.jqe, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nCS, R.color.CAM_X0107, 1);
            ap.setImageResource(this.med, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.nCT, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nCU, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.kfa, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nCV, R.color.CAM_X0107, 1);
            ap.setBackgroundColor(this.nCW, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nCX, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nCY, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bom();
    }
}
