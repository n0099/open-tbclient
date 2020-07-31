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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener awi;
    private TextView iZm;
    private TextView imD;
    private TextView kPV;
    private ImageView kXc;
    private f kZI;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mrd;
    private TextView mre;
    private TextView mrf;
    private TextView mrg;
    private TextView mrh;
    private View mri;
    private View mrj;
    private View mrk;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPV.getId() && id != PersonHeaderAttentionView.this.mrd.getId()) {
                        if (id != PersonHeaderAttentionView.this.imD.getId() && id != PersonHeaderAttentionView.this.mre.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrf.getId() || id == PersonHeaderAttentionView.this.mrg.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrl.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrl.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrl.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZI != null) {
                        this.mrl.hrx = new Bundle();
                        this.mrl.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZI.a(view, this.mrl);
                    }
                }
            }
        };
        init(context);
        dtP();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPV.getId() && id != PersonHeaderAttentionView.this.mrd.getId()) {
                        if (id != PersonHeaderAttentionView.this.imD.getId() && id != PersonHeaderAttentionView.this.mre.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrf.getId() || id == PersonHeaderAttentionView.this.mrg.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrl.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrl.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrl.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZI != null) {
                        this.mrl.hrx = new Bundle();
                        this.mrl.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZI.a(view, this.mrl);
                    }
                }
            }
        };
        init(context);
        dtP();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPV.getId() && id != PersonHeaderAttentionView.this.mrd.getId()) {
                        if (id != PersonHeaderAttentionView.this.imD.getId() && id != PersonHeaderAttentionView.this.mre.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrf.getId() || id == PersonHeaderAttentionView.this.mrg.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrl.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrl.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrl.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZI != null) {
                        this.mrl.hrx = new Bundle();
                        this.mrl.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZI.a(view, this.mrl);
                    }
                }
            }
        };
        init(context);
        dtP();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.imD = (TextView) findViewById(R.id.person_header_fans_num);
        this.mre = (TextView) findViewById(R.id.person_header_fans_des);
        this.kXc = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.kPV = (TextView) findViewById(R.id.person_header_attention_num);
        this.mrd = (TextView) findViewById(R.id.person_header_attention_des);
        this.mrf = (TextView) findViewById(R.id.person_header_bar_num);
        this.mrg = (TextView) findViewById(R.id.person_header_bar_des);
        this.iZm = (TextView) findViewById(R.id.person_header_thread_num);
        this.iZm.setVisibility(8);
        this.mrh = (TextView) findViewById(R.id.person_header_thread_des);
        this.mrh.setVisibility(8);
        this.mri = findViewById(R.id.divider_for_fans_and_attention);
        this.mrj = findViewById(R.id.divider_for_attention_and_bar);
        this.mrk = findViewById(R.id.divider_for_bar_and_thread);
        this.mrk.setVisibility(8);
    }

    private void dtP() {
        this.imD.setOnClickListener(this.awi);
        this.mre.setOnClickListener(this.awi);
        this.kPV.setOnClickListener(this.awi);
        this.mrd.setOnClickListener(this.awi);
        this.mrf.setOnClickListener(this.awi);
        this.mrg.setOnClickListener(this.awi);
        this.iZm.setOnClickListener(this.awi);
        this.mrh.setOnClickListener(this.awi);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kZI = fVar;
    }

    private void E(String str, String str2, String str3, String str4) {
        this.kPV.setText(str);
        this.imD.setText(str2);
        this.mrf.setText(str4);
        this.iZm.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.kPV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.imD.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mrf.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.iZm.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        E(as.numFormatOverWanNa(this.mUserData.getConcernNum()), as.numFormatOverWanNa(this.mUserData.getFansNum()), as.numFormatOverWanNa(this.mUserData.getPosts_num()), as.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.kPV, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrd, R.color.cp_cont_j, 1);
            ao.setViewTextColor(this.imD, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mre, R.color.cp_cont_j, 1);
            ao.setImageResource(this.kXc, R.drawable.icon_news_down_bar_one);
            ao.setViewTextColor(this.mrf, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrg, R.color.cp_cont_j, 1);
            ao.setViewTextColor(this.iZm, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrh, R.color.cp_cont_j, 1);
            ao.setBackgroundColor(this.mri, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.mrj, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.mrk, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), as.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
    }
}
