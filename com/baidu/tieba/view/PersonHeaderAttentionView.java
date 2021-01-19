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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aCu;
    private TextView jLC;
    private TextView kyK;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mlA;
    private ImageView msU;
    private f mvW;
    private TextView nPL;
    private TextView nPM;
    private TextView nPN;
    private TextView nPO;
    private TextView nPP;
    private View nPQ;
    private View nPR;
    private View nPS;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nPT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mlA.getId() && id != PersonHeaderAttentionView.this.nPL.getId()) {
                        if (id != PersonHeaderAttentionView.this.jLC.getId() && id != PersonHeaderAttentionView.this.nPM.getId()) {
                            if (id == PersonHeaderAttentionView.this.nPN.getId() || id == PersonHeaderAttentionView.this.nPO.getId()) {
                                TiebaStatic.log(new aq("c12502").dW("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 2)) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nPT.iMc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dW("obj_locate", "8"));
                            this.nPT.iMc = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "9"));
                        this.nPT.iMc = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvW != null) {
                        this.nPT.iMd = new Bundle();
                        this.nPT.iMd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvW.a(view, this.nPT);
                    }
                }
            }
        };
        init(context);
        dTQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nPT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mlA.getId() && id != PersonHeaderAttentionView.this.nPL.getId()) {
                        if (id != PersonHeaderAttentionView.this.jLC.getId() && id != PersonHeaderAttentionView.this.nPM.getId()) {
                            if (id == PersonHeaderAttentionView.this.nPN.getId() || id == PersonHeaderAttentionView.this.nPO.getId()) {
                                TiebaStatic.log(new aq("c12502").dW("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 2)) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nPT.iMc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dW("obj_locate", "8"));
                            this.nPT.iMc = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "9"));
                        this.nPT.iMc = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvW != null) {
                        this.nPT.iMd = new Bundle();
                        this.nPT.iMd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvW.a(view, this.nPT);
                    }
                }
            }
        };
        init(context);
        dTQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nPT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mlA.getId() && id != PersonHeaderAttentionView.this.nPL.getId()) {
                        if (id != PersonHeaderAttentionView.this.jLC.getId() && id != PersonHeaderAttentionView.this.nPM.getId()) {
                            if (id == PersonHeaderAttentionView.this.nPN.getId() || id == PersonHeaderAttentionView.this.nPO.getId()) {
                                TiebaStatic.log(new aq("c12502").dW("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAj() != 2)) {
                                    PersonHeaderAttentionView.this.GK(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nPT.iMc = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dW("obj_locate", "8"));
                            this.nPT.iMc = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "9"));
                        this.nPT.iMc = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvW != null) {
                        this.nPT.iMd = new Bundle();
                        this.nPT.iMd.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvW.a(view, this.nPT);
                    }
                }
            }
        };
        init(context);
        dTQ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jLC = (TextView) findViewById(R.id.person_header_fans_num);
        this.nPM = (TextView) findViewById(R.id.person_header_fans_des);
        this.msU = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.mlA = (TextView) findViewById(R.id.person_header_attention_num);
        this.nPL = (TextView) findViewById(R.id.person_header_attention_des);
        this.nPN = (TextView) findViewById(R.id.person_header_bar_num);
        this.nPO = (TextView) findViewById(R.id.person_header_bar_des);
        this.kyK = (TextView) findViewById(R.id.person_header_thread_num);
        this.kyK.setVisibility(8);
        this.nPP = (TextView) findViewById(R.id.person_header_thread_des);
        this.nPP.setVisibility(8);
        this.nPQ = findViewById(R.id.divider_for_fans_and_attention);
        this.nPR = findViewById(R.id.divider_for_attention_and_bar);
        this.nPS = findViewById(R.id.divider_for_bar_and_thread);
        this.nPS.setVisibility(8);
    }

    private void dTQ() {
        this.jLC.setOnClickListener(this.aCu);
        this.nPM.setOnClickListener(this.aCu);
        this.mlA.setOnClickListener(this.aCu);
        this.nPL.setOnClickListener(this.aCu);
        this.nPN.setOnClickListener(this.aCu);
        this.nPO.setOnClickListener(this.aCu);
        this.kyK.setOnClickListener(this.aCu);
        this.nPP.setOnClickListener(this.aCu);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mvW = fVar;
    }

    private void I(String str, String str2, String str3, String str4) {
        this.mlA.setText(str);
        this.jLC.setText(str2);
        this.nPN.setText(str4);
        this.kyK.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.mlA.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jLC.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nPN.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kyK.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        I(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.mlA, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nPL, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.jLC, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nPM, R.color.CAM_X0107, 1);
            ao.setImageResource(this.msU, R.drawable.icon_news_down_bar_one);
            ao.setViewTextColor(this.nPN, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nPO, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.kyK, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nPP, R.color.CAM_X0107, 1);
            ao.setBackgroundColor(this.nPQ, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nPR, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nPS, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
    }
}
