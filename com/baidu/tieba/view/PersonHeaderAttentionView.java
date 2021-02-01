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
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aEh;
    private TextView jSz;
    private TextView kGQ;
    private ImageView mBU;
    private Context mContext;
    private f mFa;
    private int mSkinType;
    private UserData mUserData;
    private TextView muB;
    private TextView nZP;
    private TextView nZQ;
    private TextView nZR;
    private TextView nZS;
    private TextView nZT;
    private View nZU;
    private View nZV;
    private View nZW;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nZX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muB.getId() && id != PersonHeaderAttentionView.this.nZP.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSz.getId() && id != PersonHeaderAttentionView.this.nZQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.nZR.getId() || id == PersonHeaderAttentionView.this.nZS.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nZX.iRK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nZX.iRK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nZX.iRK = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFa != null) {
                        this.nZX.iRL = new Bundle();
                        this.nZX.iRL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFa.a(view, this.nZX);
                    }
                }
            }
        };
        init(context);
        dWe();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nZX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muB.getId() && id != PersonHeaderAttentionView.this.nZP.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSz.getId() && id != PersonHeaderAttentionView.this.nZQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.nZR.getId() || id == PersonHeaderAttentionView.this.nZS.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nZX.iRK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nZX.iRK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nZX.iRK = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFa != null) {
                        this.nZX.iRL = new Bundle();
                        this.nZX.iRL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFa.a(view, this.nZX);
                    }
                }
            }
        };
        init(context);
        dWe();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nZX = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muB.getId() && id != PersonHeaderAttentionView.this.nZP.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSz.getId() && id != PersonHeaderAttentionView.this.nZQ.getId()) {
                            if (id == PersonHeaderAttentionView.this.nZR.getId() || id == PersonHeaderAttentionView.this.nZS.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nZX.iRK = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.nZX.iRK = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.nZX.iRK = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFa != null) {
                        this.nZX.iRL = new Bundle();
                        this.nZX.iRL.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFa.a(view, this.nZX);
                    }
                }
            }
        };
        init(context);
        dWe();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jSz = (TextView) findViewById(R.id.person_header_fans_num);
        this.nZQ = (TextView) findViewById(R.id.person_header_fans_des);
        this.mBU = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.muB = (TextView) findViewById(R.id.person_header_attention_num);
        this.nZP = (TextView) findViewById(R.id.person_header_attention_des);
        this.nZR = (TextView) findViewById(R.id.person_header_bar_num);
        this.nZS = (TextView) findViewById(R.id.person_header_bar_des);
        this.kGQ = (TextView) findViewById(R.id.person_header_thread_num);
        this.kGQ.setVisibility(8);
        this.nZT = (TextView) findViewById(R.id.person_header_thread_des);
        this.nZT.setVisibility(8);
        this.nZU = findViewById(R.id.divider_for_fans_and_attention);
        this.nZV = findViewById(R.id.divider_for_attention_and_bar);
        this.nZW = findViewById(R.id.divider_for_bar_and_thread);
        this.nZW.setVisibility(8);
    }

    private void dWe() {
        this.jSz.setOnClickListener(this.aEh);
        this.nZQ.setOnClickListener(this.aEh);
        this.muB.setOnClickListener(this.aEh);
        this.nZP.setOnClickListener(this.aEh);
        this.nZR.setOnClickListener(this.aEh);
        this.nZS.setOnClickListener(this.aEh);
        this.kGQ.setOnClickListener(this.aEh);
        this.nZT.setOnClickListener(this.aEh);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mFa = fVar;
    }

    private void G(String str, String str2, String str3, String str4) {
        this.muB.setText(str);
        this.jSz.setText(str2);
        this.nZR.setText(str4);
        this.kGQ.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.muB.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jSz.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nZR.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kGQ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        G(au.numFormatOverWanNa(this.mUserData.getConcernNum()), au.numFormatOverWanNa(this.mUserData.getFansNum()), au.numFormatOverWanNa(this.mUserData.getPosts_num()), au.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.muB, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nZP, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.jSz, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nZQ, R.color.CAM_X0107, 1);
            ap.setImageResource(this.mBU, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.nZR, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nZS, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.kGQ, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nZT, R.color.CAM_X0107, 1);
            ap.setBackgroundColor(this.nZU, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nZV, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nZW, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
    }
}
