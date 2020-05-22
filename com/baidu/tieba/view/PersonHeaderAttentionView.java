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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aUZ;
    private TextView hRs;
    private TextView izk;
    private TextView klX;
    private ImageView ktc;
    private f kvJ;
    private TextView lNV;
    private TextView lNW;
    private TextView lNX;
    private TextView lNY;
    private TextView lNZ;
    private View lOa;
    private View lOb;
    private View lOc;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lOd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.klX.getId() && id != PersonHeaderAttentionView.this.lNV.getId()) {
                        if (id != PersonHeaderAttentionView.this.hRs.getId() && id != PersonHeaderAttentionView.this.lNW.getId()) {
                            if (id == PersonHeaderAttentionView.this.lNX.getId() || id == PersonHeaderAttentionView.this.lNY.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 2)) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lOd.gZn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lOd.gZn = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lOd.gZn = 4;
                    }
                    if (PersonHeaderAttentionView.this.kvJ != null) {
                        this.lOd.gZo = new Bundle();
                        this.lOd.gZo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kvJ.a(view, this.lOd);
                    }
                }
            }
        };
        init(context);
        dlX();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lOd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.klX.getId() && id != PersonHeaderAttentionView.this.lNV.getId()) {
                        if (id != PersonHeaderAttentionView.this.hRs.getId() && id != PersonHeaderAttentionView.this.lNW.getId()) {
                            if (id == PersonHeaderAttentionView.this.lNX.getId() || id == PersonHeaderAttentionView.this.lNY.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 2)) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lOd.gZn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lOd.gZn = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lOd.gZn = 4;
                    }
                    if (PersonHeaderAttentionView.this.kvJ != null) {
                        this.lOd.gZo = new Bundle();
                        this.lOd.gZo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kvJ.a(view, this.lOd);
                    }
                }
            }
        };
        init(context);
        dlX();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lOd = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.klX.getId() && id != PersonHeaderAttentionView.this.lNV.getId()) {
                        if (id != PersonHeaderAttentionView.this.hRs.getId() && id != PersonHeaderAttentionView.this.lNW.getId()) {
                            if (id == PersonHeaderAttentionView.this.lNX.getId() || id == PersonHeaderAttentionView.this.lNY.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcw() != 2)) {
                                    PersonHeaderAttentionView.this.Bw(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lOd.gZn = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lOd.gZn = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lOd.gZn = 4;
                    }
                    if (PersonHeaderAttentionView.this.kvJ != null) {
                        this.lOd.gZo = new Bundle();
                        this.lOd.gZo.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kvJ.a(view, this.lOd);
                    }
                }
            }
        };
        init(context);
        dlX();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.hRs = (TextView) findViewById(R.id.person_header_fans_num);
        this.lNW = (TextView) findViewById(R.id.person_header_fans_des);
        this.ktc = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.klX = (TextView) findViewById(R.id.person_header_attention_num);
        this.lNV = (TextView) findViewById(R.id.person_header_attention_des);
        this.lNX = (TextView) findViewById(R.id.person_header_bar_num);
        this.lNY = (TextView) findViewById(R.id.person_header_bar_des);
        this.izk = (TextView) findViewById(R.id.person_header_thread_num);
        this.izk.setVisibility(8);
        this.lNZ = (TextView) findViewById(R.id.person_header_thread_des);
        this.lNZ.setVisibility(8);
        this.lOa = findViewById(R.id.divider_for_fans_and_attention);
        this.lOb = findViewById(R.id.divider_for_attention_and_bar);
        this.lOc = findViewById(R.id.divider_for_bar_and_thread);
        this.lOc.setVisibility(8);
    }

    private void dlX() {
        this.hRs.setOnClickListener(this.aUZ);
        this.lNW.setOnClickListener(this.aUZ);
        this.klX.setOnClickListener(this.aUZ);
        this.lNV.setOnClickListener(this.aUZ);
        this.lNX.setOnClickListener(this.aUZ);
        this.lNY.setOnClickListener(this.aUZ);
        this.izk.setOnClickListener(this.aUZ);
        this.lNZ.setOnClickListener(this.aUZ);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kvJ = fVar;
    }

    private void E(String str, String str2, String str3, String str4) {
        this.klX.setText(str);
        this.hRs.setText(str2);
        this.lNX.setText(str4);
        this.izk.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.klX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.hRs.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.lNX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.izk.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        E(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.klX, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lNV, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hRs, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lNW, R.color.cp_cont_j, 1);
            am.setImageResource(this.ktc, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.lNX, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lNY, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.izk, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lNZ, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.lOa, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lOb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lOc, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
    }
}
