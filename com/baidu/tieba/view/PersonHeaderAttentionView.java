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
    private TextView jSN;
    private TextView kHe;
    private ImageView mCj;
    private Context mContext;
    private f mFp;
    private int mSkinType;
    private UserData mUserData;
    private TextView muQ;
    private TextView oap;
    private TextView oaq;
    private TextView oar;
    private TextView oas;
    private TextView oat;
    private View oau;
    private View oav;
    private View oaw;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a oax = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muQ.getId() && id != PersonHeaderAttentionView.this.oap.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSN.getId() && id != PersonHeaderAttentionView.this.oaq.getId()) {
                            if (id == PersonHeaderAttentionView.this.oar.getId() || id == PersonHeaderAttentionView.this.oas.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.oax.iRY = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.oax.iRY = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.oax.iRY = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFp != null) {
                        this.oax.iRZ = new Bundle();
                        this.oax.iRZ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFp.a(view, this.oax);
                    }
                }
            }
        };
        init(context);
        dWm();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a oax = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muQ.getId() && id != PersonHeaderAttentionView.this.oap.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSN.getId() && id != PersonHeaderAttentionView.this.oaq.getId()) {
                            if (id == PersonHeaderAttentionView.this.oar.getId() || id == PersonHeaderAttentionView.this.oas.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.oax.iRY = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.oax.iRY = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.oax.iRY = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFp != null) {
                        this.oax.iRZ = new Bundle();
                        this.oax.iRZ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFp.a(view, this.oax);
                    }
                }
            }
        };
        init(context);
        dWm();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a oax = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.muQ.getId() && id != PersonHeaderAttentionView.this.oap.getId()) {
                        if (id != PersonHeaderAttentionView.this.jSN.getId() && id != PersonHeaderAttentionView.this.oaq.getId()) {
                            if (id == PersonHeaderAttentionView.this.oar.getId() || id == PersonHeaderAttentionView.this.oas.getId()) {
                                TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bAB() != 2)) {
                                    PersonHeaderAttentionView.this.Hc(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.oax.iRY = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
                            this.oax.iRY = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
                        this.oax.iRY = 4;
                    }
                    if (PersonHeaderAttentionView.this.mFp != null) {
                        this.oax.iRZ = new Bundle();
                        this.oax.iRZ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mFp.a(view, this.oax);
                    }
                }
            }
        };
        init(context);
        dWm();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jSN = (TextView) findViewById(R.id.person_header_fans_num);
        this.oaq = (TextView) findViewById(R.id.person_header_fans_des);
        this.mCj = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.muQ = (TextView) findViewById(R.id.person_header_attention_num);
        this.oap = (TextView) findViewById(R.id.person_header_attention_des);
        this.oar = (TextView) findViewById(R.id.person_header_bar_num);
        this.oas = (TextView) findViewById(R.id.person_header_bar_des);
        this.kHe = (TextView) findViewById(R.id.person_header_thread_num);
        this.kHe.setVisibility(8);
        this.oat = (TextView) findViewById(R.id.person_header_thread_des);
        this.oat.setVisibility(8);
        this.oau = findViewById(R.id.divider_for_fans_and_attention);
        this.oav = findViewById(R.id.divider_for_attention_and_bar);
        this.oaw = findViewById(R.id.divider_for_bar_and_thread);
        this.oaw.setVisibility(8);
    }

    private void dWm() {
        this.jSN.setOnClickListener(this.aEh);
        this.oaq.setOnClickListener(this.aEh);
        this.muQ.setOnClickListener(this.aEh);
        this.oap.setOnClickListener(this.aEh);
        this.oar.setOnClickListener(this.aEh);
        this.oas.setOnClickListener(this.aEh);
        this.kHe.setOnClickListener(this.aEh);
        this.oat.setOnClickListener(this.aEh);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mFp = fVar;
    }

    private void G(String str, String str2, String str3, String str4) {
        this.muQ.setText(str);
        this.jSN.setText(str2);
        this.oar.setText(str4);
        this.kHe.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.muQ.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jSN.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.oar.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.kHe.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        G(au.numFormatOverWanNa(this.mUserData.getConcernNum()), au.numFormatOverWanNa(this.mUserData.getFansNum()), au.numFormatOverWanNa(this.mUserData.getPosts_num()), au.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.muQ, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.oap, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.jSN, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.oaq, R.color.CAM_X0107, 1);
            ap.setImageResource(this.mCj, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.oar, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.oas, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.kHe, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.oat, R.color.CAM_X0107, 1);
            ap.setBackgroundColor(this.oau, R.color.CAM_X0204);
            ap.setBackgroundColor(this.oav, R.color.CAM_X0204);
            ap.setBackgroundColor(this.oaw, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
    }
}
