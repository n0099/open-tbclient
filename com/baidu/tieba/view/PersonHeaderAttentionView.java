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
    private View.OnClickListener aFH;
    private TextView jUw;
    private TextView kJg;
    private Context mContext;
    private ImageView mEp;
    private f mHs;
    private int mSkinType;
    private UserData mUserData;
    private TextView mwS;
    private TextView ocA;
    private View ocB;
    private View ocC;
    private View ocD;
    private TextView ocw;
    private TextView ocx;
    private TextView ocy;
    private TextView ocz;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a ocE = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mwS.getId() && id != PersonHeaderAttentionView.this.ocw.getId()) {
                        if (id != PersonHeaderAttentionView.this.jUw.getId() && id != PersonHeaderAttentionView.this.ocx.getId()) {
                            if (id == PersonHeaderAttentionView.this.ocy.getId() || id == PersonHeaderAttentionView.this.ocz.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 2)) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.ocE.iTH = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.ocE.iTH = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.ocE.iTH = 4;
                    }
                    if (PersonHeaderAttentionView.this.mHs != null) {
                        this.ocE.iTI = new Bundle();
                        this.ocE.iTI.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mHs.a(view, this.ocE);
                    }
                }
            }
        };
        init(context);
        dWu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a ocE = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mwS.getId() && id != PersonHeaderAttentionView.this.ocw.getId()) {
                        if (id != PersonHeaderAttentionView.this.jUw.getId() && id != PersonHeaderAttentionView.this.ocx.getId()) {
                            if (id == PersonHeaderAttentionView.this.ocy.getId() || id == PersonHeaderAttentionView.this.ocz.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 2)) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.ocE.iTH = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.ocE.iTH = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.ocE.iTH = 4;
                    }
                    if (PersonHeaderAttentionView.this.mHs != null) {
                        this.ocE.iTI = new Bundle();
                        this.ocE.iTI.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mHs.a(view, this.ocE);
                    }
                }
            }
        };
        init(context);
        dWu();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a ocE = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mwS.getId() && id != PersonHeaderAttentionView.this.ocw.getId()) {
                        if (id != PersonHeaderAttentionView.this.jUw.getId() && id != PersonHeaderAttentionView.this.ocx.getId()) {
                            if (id == PersonHeaderAttentionView.this.ocy.getId() || id == PersonHeaderAttentionView.this.ocz.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAE() != 2)) {
                                    PersonHeaderAttentionView.this.Hf(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.ocE.iTH = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.ocE.iTH = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.ocE.iTH = 4;
                    }
                    if (PersonHeaderAttentionView.this.mHs != null) {
                        this.ocE.iTI = new Bundle();
                        this.ocE.iTI.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mHs.a(view, this.ocE);
                    }
                }
            }
        };
        init(context);
        dWu();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jUw = (TextView) findViewById(R.id.person_header_fans_num);
        this.ocx = (TextView) findViewById(R.id.person_header_fans_des);
        this.mEp = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.mwS = (TextView) findViewById(R.id.person_header_attention_num);
        this.ocw = (TextView) findViewById(R.id.person_header_attention_des);
        this.ocy = (TextView) findViewById(R.id.person_header_bar_num);
        this.ocz = (TextView) findViewById(R.id.person_header_bar_des);
        this.kJg = (TextView) findViewById(R.id.person_header_thread_num);
        this.kJg.setVisibility(8);
        this.ocA = (TextView) findViewById(R.id.person_header_thread_des);
        this.ocA.setVisibility(8);
        this.ocB = findViewById(R.id.divider_for_fans_and_attention);
        this.ocC = findViewById(R.id.divider_for_attention_and_bar);
        this.ocD = findViewById(R.id.divider_for_bar_and_thread);
        this.ocD.setVisibility(8);
    }

    private void dWu() {
        this.jUw.setOnClickListener(this.aFH);
        this.ocx.setOnClickListener(this.aFH);
        this.mwS.setOnClickListener(this.aFH);
        this.ocw.setOnClickListener(this.aFH);
        this.ocy.setOnClickListener(this.aFH);
        this.ocz.setOnClickListener(this.aFH);
        this.kJg.setOnClickListener(this.aFH);
        this.ocA.setOnClickListener(this.aFH);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mHs = fVar;
    }

    private void G(String str, String str2, String str3, String str4) {
        this.mwS.setText(str);
        this.jUw.setText(str2);
        this.ocy.setText(str4);
        this.kJg.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.mwS.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jUw.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.ocy.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kJg.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        G(au.numFormatOverWanNa(this.mUserData.getConcernNum()), au.numFormatOverWanNa(this.mUserData.getFansNum()), au.numFormatOverWanNa(this.mUserData.getPosts_num()), au.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.mwS, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ocw, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.jUw, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ocx, R.color.CAM_X0107, 1);
            ap.setImageResource(this.mEp, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.ocy, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ocz, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.kJg, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ocA, R.color.CAM_X0107, 1);
            ap.setBackgroundColor(this.ocB, R.color.CAM_X0204);
            ap.setBackgroundColor(this.ocC, R.color.CAM_X0204);
            ap.setBackgroundColor(this.ocD, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
    }
}
