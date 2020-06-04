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
    private TextView hSf;
    private TextView izX;
    private TextView knd;
    private ImageView kui;
    private f kwP;
    private TextView lPd;
    private TextView lPe;
    private TextView lPf;
    private TextView lPg;
    private TextView lPh;
    private View lPi;
    private View lPj;
    private View lPk;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lPl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.knd.getId() && id != PersonHeaderAttentionView.this.lPd.getId()) {
                        if (id != PersonHeaderAttentionView.this.hSf.getId() && id != PersonHeaderAttentionView.this.lPe.getId()) {
                            if (id == PersonHeaderAttentionView.this.lPf.getId() || id == PersonHeaderAttentionView.this.lPg.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 2)) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lPl.gZy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lPl.gZy = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lPl.gZy = 4;
                    }
                    if (PersonHeaderAttentionView.this.kwP != null) {
                        this.lPl.gZz = new Bundle();
                        this.lPl.gZz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kwP.a(view, this.lPl);
                    }
                }
            }
        };
        init(context);
        dmm();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lPl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.knd.getId() && id != PersonHeaderAttentionView.this.lPd.getId()) {
                        if (id != PersonHeaderAttentionView.this.hSf.getId() && id != PersonHeaderAttentionView.this.lPe.getId()) {
                            if (id == PersonHeaderAttentionView.this.lPf.getId() || id == PersonHeaderAttentionView.this.lPg.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 2)) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lPl.gZy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lPl.gZy = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lPl.gZy = 4;
                    }
                    if (PersonHeaderAttentionView.this.kwP != null) {
                        this.lPl.gZz = new Bundle();
                        this.lPl.gZz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kwP.a(view, this.lPl);
                    }
                }
            }
        };
        init(context);
        dmm();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a lPl = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.knd.getId() && id != PersonHeaderAttentionView.this.lPd.getId()) {
                        if (id != PersonHeaderAttentionView.this.hSf.getId() && id != PersonHeaderAttentionView.this.lPe.getId()) {
                            if (id == PersonHeaderAttentionView.this.lPf.getId() || id == PersonHeaderAttentionView.this.lPg.getId()) {
                                TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bcx() != 2)) {
                                    PersonHeaderAttentionView.this.By(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.lPl.gZy = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
                            this.lPl.gZy = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
                        this.lPl.gZy = 4;
                    }
                    if (PersonHeaderAttentionView.this.kwP != null) {
                        this.lPl.gZz = new Bundle();
                        this.lPl.gZz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.kwP.a(view, this.lPl);
                    }
                }
            }
        };
        init(context);
        dmm();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.hSf = (TextView) findViewById(R.id.person_header_fans_num);
        this.lPe = (TextView) findViewById(R.id.person_header_fans_des);
        this.kui = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.knd = (TextView) findViewById(R.id.person_header_attention_num);
        this.lPd = (TextView) findViewById(R.id.person_header_attention_des);
        this.lPf = (TextView) findViewById(R.id.person_header_bar_num);
        this.lPg = (TextView) findViewById(R.id.person_header_bar_des);
        this.izX = (TextView) findViewById(R.id.person_header_thread_num);
        this.izX.setVisibility(8);
        this.lPh = (TextView) findViewById(R.id.person_header_thread_des);
        this.lPh.setVisibility(8);
        this.lPi = findViewById(R.id.divider_for_fans_and_attention);
        this.lPj = findViewById(R.id.divider_for_attention_and_bar);
        this.lPk = findViewById(R.id.divider_for_bar_and_thread);
        this.lPk.setVisibility(8);
    }

    private void dmm() {
        this.hSf.setOnClickListener(this.aUZ);
        this.lPe.setOnClickListener(this.aUZ);
        this.knd.setOnClickListener(this.aUZ);
        this.lPd.setOnClickListener(this.aUZ);
        this.lPf.setOnClickListener(this.aUZ);
        this.lPg.setOnClickListener(this.aUZ);
        this.izX.setOnClickListener(this.aUZ);
        this.lPh.setOnClickListener(this.aUZ);
    }

    public void setOnViewResponseListener(f fVar) {
        this.kwP = fVar;
    }

    private void E(String str, String str2, String str3, String str4) {
        this.knd.setText(str);
        this.hSf.setText(str2);
        this.lPf.setText(str4);
        this.izX.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.knd.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.hSf.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.lPf.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.izX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        E(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.knd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lPd, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hSf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lPe, R.color.cp_cont_j, 1);
            am.setImageResource(this.kui, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.lPf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lPg, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.izX, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.lPh, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.lPi, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lPj, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.lPk, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void By(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
    }
}
