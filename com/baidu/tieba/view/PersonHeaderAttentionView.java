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
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aGQ;
    private TextView jDE;
    private TextView ksy;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mkV;
    private ImageView msk;
    private f mvm;
    private TextView nQT;
    private TextView nQU;
    private TextView nQV;
    private TextView nQW;
    private TextView nQX;
    private View nQY;
    private View nQZ;
    private View nRa;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nRb = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mkV.getId() && id != PersonHeaderAttentionView.this.nQT.getId()) {
                        if (id != PersonHeaderAttentionView.this.jDE.getId() && id != PersonHeaderAttentionView.this.nQU.getId()) {
                            if (id == PersonHeaderAttentionView.this.nQV.getId() || id == PersonHeaderAttentionView.this.nQW.getId()) {
                                TiebaStatic.log(new ar("c12502").dY("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 2)) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nRb.iEv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dY("obj_locate", "8"));
                            this.nRb.iEv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.nRb.iEv = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvm != null) {
                        this.nRb.iEw = new Bundle();
                        this.nRb.iEw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvm.a(view, this.nRb);
                    }
                }
            }
        };
        init(context);
        dYd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nRb = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mkV.getId() && id != PersonHeaderAttentionView.this.nQT.getId()) {
                        if (id != PersonHeaderAttentionView.this.jDE.getId() && id != PersonHeaderAttentionView.this.nQU.getId()) {
                            if (id == PersonHeaderAttentionView.this.nQV.getId() || id == PersonHeaderAttentionView.this.nQW.getId()) {
                                TiebaStatic.log(new ar("c12502").dY("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 2)) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nRb.iEv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dY("obj_locate", "8"));
                            this.nRb.iEv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.nRb.iEv = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvm != null) {
                        this.nRb.iEw = new Bundle();
                        this.nRb.iEw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvm.a(view, this.nRb);
                    }
                }
            }
        };
        init(context);
        dYd();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.h.a nRb = new com.baidu.tieba.h.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bh.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.mkV.getId() && id != PersonHeaderAttentionView.this.nQT.getId()) {
                        if (id != PersonHeaderAttentionView.this.jDE.getId() && id != PersonHeaderAttentionView.this.nQU.getId()) {
                            if (id == PersonHeaderAttentionView.this.nQV.getId() || id == PersonHeaderAttentionView.this.nQW.getId()) {
                                TiebaStatic.log(new ar("c12502").dY("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bBH() != 2)) {
                                    PersonHeaderAttentionView.this.Ix(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nRb.iEv = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ar("c12502").dY("obj_locate", "8"));
                            this.nRb.iEv = 5;
                        }
                    } else {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.nRb.iEv = 4;
                    }
                    if (PersonHeaderAttentionView.this.mvm != null) {
                        this.nRb.iEw = new Bundle();
                        this.nRb.iEw.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.mvm.a(view, this.nRb);
                    }
                }
            }
        };
        init(context);
        dYd();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jDE = (TextView) findViewById(R.id.person_header_fans_num);
        this.nQU = (TextView) findViewById(R.id.person_header_fans_des);
        this.msk = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.mkV = (TextView) findViewById(R.id.person_header_attention_num);
        this.nQT = (TextView) findViewById(R.id.person_header_attention_des);
        this.nQV = (TextView) findViewById(R.id.person_header_bar_num);
        this.nQW = (TextView) findViewById(R.id.person_header_bar_des);
        this.ksy = (TextView) findViewById(R.id.person_header_thread_num);
        this.ksy.setVisibility(8);
        this.nQX = (TextView) findViewById(R.id.person_header_thread_des);
        this.nQX.setVisibility(8);
        this.nQY = findViewById(R.id.divider_for_fans_and_attention);
        this.nQZ = findViewById(R.id.divider_for_attention_and_bar);
        this.nRa = findViewById(R.id.divider_for_bar_and_thread);
        this.nRa.setVisibility(8);
    }

    private void dYd() {
        this.jDE.setOnClickListener(this.aGQ);
        this.nQU.setOnClickListener(this.aGQ);
        this.mkV.setOnClickListener(this.aGQ);
        this.nQT.setOnClickListener(this.aGQ);
        this.nQV.setOnClickListener(this.aGQ);
        this.nQW.setOnClickListener(this.aGQ);
        this.ksy.setOnClickListener(this.aGQ);
        this.nQX.setOnClickListener(this.aGQ);
    }

    public void setOnViewResponseListener(f fVar) {
        this.mvm = fVar;
    }

    private void J(String str, String str2, String str3, String str4) {
        this.mkV.setText(str);
        this.jDE.setText(str2);
        this.nQV.setText(str4);
        this.ksy.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.mkV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jDE.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nQV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ksy.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        J(au.numFormatOverWanNa(this.mUserData.getConcernNum()), au.numFormatOverWanNa(this.mUserData.getFansNum()), au.numFormatOverWanNa(this.mUserData.getPosts_num()), au.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.mkV, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nQT, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.jDE, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nQU, R.color.CAM_X0107, 1);
            ap.setImageResource(this.msk, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.nQV, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nQW, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.ksy, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.nQX, R.color.CAM_X0107, 1);
            ap.setBackgroundColor(this.nQY, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nQZ, R.color.CAM_X0204);
            ap.setBackgroundColor(this.nRa, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).brB();
    }
}
