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
    private View.OnClickListener aHh;
    private TextView jQi;
    private TextView kDp;
    private f mAB;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mqg;
    private ImageView mxz;
    private TextView nUq;
    private TextView nUr;
    private TextView nUs;
    private TextView nUt;
    private TextView nUu;
    private View nUv;
    private View nUw;
    private View nUx;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nUy = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mqg.getId() && id != PersonHeaderAttentionView.this.nUq.getId()) {
                        if (id != PersonHeaderAttentionView.this.jQi.getId() && id != PersonHeaderAttentionView.this.nUr.getId()) {
                            if (id == PersonHeaderAttentionView.this.nUs.getId() || id == PersonHeaderAttentionView.this.nUt.getId()) {
                                TiebaStatic.log(new aq("c12502").dX("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 2)) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nUy.iQJ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dX("obj_locate", "8"));
                            this.nUy.iQJ = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dX("obj_locate", "9"));
                        this.nUy.iQJ = 4;
                    }
                    if (PersonHeaderAttentionView.this.mAB != null) {
                        this.nUy.iQK = new Bundle();
                        this.nUy.iQK.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mAB.a(view, this.nUy);
                    }
                }
            }
        };
        init(context);
        dXH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nUy = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mqg.getId() && id != PersonHeaderAttentionView.this.nUq.getId()) {
                        if (id != PersonHeaderAttentionView.this.jQi.getId() && id != PersonHeaderAttentionView.this.nUr.getId()) {
                            if (id == PersonHeaderAttentionView.this.nUs.getId() || id == PersonHeaderAttentionView.this.nUt.getId()) {
                                TiebaStatic.log(new aq("c12502").dX("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 2)) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nUy.iQJ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dX("obj_locate", "8"));
                            this.nUy.iQJ = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dX("obj_locate", "9"));
                        this.nUy.iQJ = 4;
                    }
                    if (PersonHeaderAttentionView.this.mAB != null) {
                        this.nUy.iQK = new Bundle();
                        this.nUy.iQK.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mAB.a(view, this.nUy);
                    }
                }
            }
        };
        init(context);
        dXH();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nUy = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mqg.getId() && id != PersonHeaderAttentionView.this.nUq.getId()) {
                        if (id != PersonHeaderAttentionView.this.jQi.getId() && id != PersonHeaderAttentionView.this.nUr.getId()) {
                            if (id == PersonHeaderAttentionView.this.nUs.getId() || id == PersonHeaderAttentionView.this.nUt.getId()) {
                                TiebaStatic.log(new aq("c12502").dX("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bEc() != 2)) {
                                    PersonHeaderAttentionView.this.Ir(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nUy.iQJ = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dX("obj_locate", "8"));
                            this.nUy.iQJ = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dX("obj_locate", "9"));
                        this.nUy.iQJ = 4;
                    }
                    if (PersonHeaderAttentionView.this.mAB != null) {
                        this.nUy.iQK = new Bundle();
                        this.nUy.iQK.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mAB.a(view, this.nUy);
                    }
                }
            }
        };
        init(context);
        dXH();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jQi = (TextView) findViewById(R.id.person_header_fans_num);
        this.nUr = (TextView) findViewById(R.id.person_header_fans_des);
        this.mxz = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.mqg = (TextView) findViewById(R.id.person_header_attention_num);
        this.nUq = (TextView) findViewById(R.id.person_header_attention_des);
        this.nUs = (TextView) findViewById(R.id.person_header_bar_num);
        this.nUt = (TextView) findViewById(R.id.person_header_bar_des);
        this.kDp = (TextView) findViewById(R.id.person_header_thread_num);
        this.kDp.setVisibility(8);
        this.nUu = (TextView) findViewById(R.id.person_header_thread_des);
        this.nUu.setVisibility(8);
        this.nUv = findViewById(R.id.divider_for_fans_and_attention);
        this.nUw = findViewById(R.id.divider_for_attention_and_bar);
        this.nUx = findViewById(R.id.divider_for_bar_and_thread);
        this.nUx.setVisibility(8);
    }

    private void dXH() {
        this.jQi.setOnClickListener(this.aHh);
        this.nUr.setOnClickListener(this.aHh);
        this.mqg.setOnClickListener(this.aHh);
        this.nUq.setOnClickListener(this.aHh);
        this.nUs.setOnClickListener(this.aHh);
        this.nUt.setOnClickListener(this.aHh);
        this.kDp.setOnClickListener(this.aHh);
        this.nUu.setOnClickListener(this.aHh);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mAB = fVar;
    }

    private void I(String str, String str2, String str3, String str4) {
        this.mqg.setText(str);
        this.jQi.setText(str2);
        this.nUs.setText(str4);
        this.kDp.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.mqg.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jQi.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nUs.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kDp.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        I(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.mqg, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nUq, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.jQi, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nUr, R.color.CAM_X0107, 1);
            ao.setImageResource(this.mxz, R.drawable.icon_news_down_bar_one);
            ao.setViewTextColor(this.nUs, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nUt, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.kDp, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.nUu, R.color.CAM_X0107, 1);
            ao.setBackgroundColor(this.nUv, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nUw, R.color.CAM_X0204);
            ao.setBackgroundColor(this.nUx, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
    }
}
