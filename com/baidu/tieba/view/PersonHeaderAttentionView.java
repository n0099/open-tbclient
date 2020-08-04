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
    private TextView iZo;
    private TextView imF;
    private TextView kPX;
    private ImageView kXe;
    private f kZK;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private TextView mrf;
    private TextView mrg;
    private TextView mrh;
    private TextView mri;
    private TextView mrj;
    private View mrk;
    private View mrl;
    private View mrm;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrn = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPX.getId() && id != PersonHeaderAttentionView.this.mrf.getId()) {
                        if (id != PersonHeaderAttentionView.this.imF.getId() && id != PersonHeaderAttentionView.this.mrg.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrh.getId() || id == PersonHeaderAttentionView.this.mri.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrn.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrn.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrn.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZK != null) {
                        this.mrn.hrx = new Bundle();
                        this.mrn.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZK.a(view, this.mrn);
                    }
                }
            }
        };
        init(context);
        dtQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrn = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPX.getId() && id != PersonHeaderAttentionView.this.mrf.getId()) {
                        if (id != PersonHeaderAttentionView.this.imF.getId() && id != PersonHeaderAttentionView.this.mrg.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrh.getId() || id == PersonHeaderAttentionView.this.mri.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrn.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrn.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrn.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZK != null) {
                        this.mrn.hrx = new Bundle();
                        this.mrn.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZK.a(view, this.mrn);
                    }
                }
            }
        };
        init(context);
        dtQ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a mrn = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bf.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.kPX.getId() && id != PersonHeaderAttentionView.this.mrf.getId()) {
                        if (id != PersonHeaderAttentionView.this.imF.getId() && id != PersonHeaderAttentionView.this.mrg.getId()) {
                            if (id == PersonHeaderAttentionView.this.mrh.getId() || id == PersonHeaderAttentionView.this.mri.getId()) {
                                TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bii() != 2)) {
                                    PersonHeaderAttentionView.this.Da(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.mrn.hrw = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
                            this.mrn.hrw = 5;
                        }
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
                        this.mrn.hrw = 4;
                    }
                    if (PersonHeaderAttentionView.this.kZK != null) {
                        this.mrn.hrx = new Bundle();
                        this.mrn.hrx.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kZK.a(view, this.mrn);
                    }
                }
            }
        };
        init(context);
        dtQ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.imF = (TextView) findViewById(R.id.person_header_fans_num);
        this.mrg = (TextView) findViewById(R.id.person_header_fans_des);
        this.kXe = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.kPX = (TextView) findViewById(R.id.person_header_attention_num);
        this.mrf = (TextView) findViewById(R.id.person_header_attention_des);
        this.mrh = (TextView) findViewById(R.id.person_header_bar_num);
        this.mri = (TextView) findViewById(R.id.person_header_bar_des);
        this.iZo = (TextView) findViewById(R.id.person_header_thread_num);
        this.iZo.setVisibility(8);
        this.mrj = (TextView) findViewById(R.id.person_header_thread_des);
        this.mrj.setVisibility(8);
        this.mrk = findViewById(R.id.divider_for_fans_and_attention);
        this.mrl = findViewById(R.id.divider_for_attention_and_bar);
        this.mrm = findViewById(R.id.divider_for_bar_and_thread);
        this.mrm.setVisibility(8);
    }

    private void dtQ() {
        this.imF.setOnClickListener(this.awi);
        this.mrg.setOnClickListener(this.awi);
        this.kPX.setOnClickListener(this.awi);
        this.mrf.setOnClickListener(this.awi);
        this.mrh.setOnClickListener(this.awi);
        this.mri.setOnClickListener(this.awi);
        this.iZo.setOnClickListener(this.awi);
        this.mrj.setOnClickListener(this.awi);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kZK = fVar;
    }

    private void E(String str, String str2, String str3, String str4) {
        this.kPX.setText(str);
        this.imF.setText(str2);
        this.mrh.setText(str4);
        this.iZo.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.kPX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.imF.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.mrh.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.iZo.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        E(as.numFormatOverWanNa(this.mUserData.getConcernNum()), as.numFormatOverWanNa(this.mUserData.getFansNum()), as.numFormatOverWanNa(this.mUserData.getPosts_num()), as.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.kPX, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrf, R.color.cp_cont_j, 1);
            ao.setViewTextColor(this.imF, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrg, R.color.cp_cont_j, 1);
            ao.setImageResource(this.kXe, R.drawable.icon_news_down_bar_one);
            ao.setViewTextColor(this.mrh, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mri, R.color.cp_cont_j, 1);
            ao.setViewTextColor(this.iZo, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mrj, R.color.cp_cont_j, 1);
            ao.setBackgroundColor(this.mrk, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.mrl, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.mrm, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), as.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
    }
}
