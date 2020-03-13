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
    private View.OnClickListener auY;
    private TextView gRD;
    private TextView hzi;
    private TextView jip;
    private ImageView jps;
    private e jrZ;
    private TextView kJe;
    private TextView kJf;
    private TextView kJg;
    private TextView kJh;
    private TextView kJi;
    private View kJj;
    private View kJk;
    private View kJl;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJm = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jip.getId() && id != PersonHeaderAttentionView.this.kJe.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRD.getId() && id != PersonHeaderAttentionView.this.kJf.getId()) {
                            if (id == PersonHeaderAttentionView.this.kJg.getId() || id == PersonHeaderAttentionView.this.kJh.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJm.gaE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJm.gaE = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJm.gaE = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrZ != null) {
                        this.kJm.gaF = new Bundle();
                        this.kJm.gaF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrZ.a(view, this.kJm);
                    }
                }
            }
        };
        init(context);
        cTA();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJm = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jip.getId() && id != PersonHeaderAttentionView.this.kJe.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRD.getId() && id != PersonHeaderAttentionView.this.kJf.getId()) {
                            if (id == PersonHeaderAttentionView.this.kJg.getId() || id == PersonHeaderAttentionView.this.kJh.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJm.gaE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJm.gaE = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJm.gaE = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrZ != null) {
                        this.kJm.gaF = new Bundle();
                        this.kJm.gaF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrZ.a(view, this.kJm);
                    }
                }
            }
        };
        init(context);
        cTA();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJm = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jip.getId() && id != PersonHeaderAttentionView.this.kJe.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRD.getId() && id != PersonHeaderAttentionView.this.kJf.getId()) {
                            if (id == PersonHeaderAttentionView.this.kJg.getId() || id == PersonHeaderAttentionView.this.kJh.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNP() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJm.gaE = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJm.gaE = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJm.gaE = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrZ != null) {
                        this.kJm.gaF = new Bundle();
                        this.kJm.gaF.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrZ.a(view, this.kJm);
                    }
                }
            }
        };
        init(context);
        cTA();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gRD = (TextView) findViewById(R.id.person_header_fans_num);
        this.kJf = (TextView) findViewById(R.id.person_header_fans_des);
        this.jps = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jip = (TextView) findViewById(R.id.person_header_attention_num);
        this.kJe = (TextView) findViewById(R.id.person_header_attention_des);
        this.kJg = (TextView) findViewById(R.id.person_header_bar_num);
        this.kJh = (TextView) findViewById(R.id.person_header_bar_des);
        this.hzi = (TextView) findViewById(R.id.person_header_thread_num);
        this.hzi.setVisibility(8);
        this.kJi = (TextView) findViewById(R.id.person_header_thread_des);
        this.kJi.setVisibility(8);
        this.kJj = findViewById(R.id.divider_for_fans_and_attention);
        this.kJk = findViewById(R.id.divider_for_attention_and_bar);
        this.kJl = findViewById(R.id.divider_for_bar_and_thread);
        this.kJl.setVisibility(8);
    }

    private void cTA() {
        this.gRD.setOnClickListener(this.auY);
        this.kJf.setOnClickListener(this.auY);
        this.jip.setOnClickListener(this.auY);
        this.kJe.setOnClickListener(this.auY);
        this.kJg.setOnClickListener(this.auY);
        this.kJh.setOnClickListener(this.auY);
        this.hzi.setOnClickListener(this.auY);
        this.kJi.setOnClickListener(this.auY);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jrZ = eVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jip.setText(str);
        this.gRD.setText(str2);
        this.kJg.setText(str4);
        this.hzi.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jip.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gRD.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kJg.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hzi.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jip, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kJe, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gRD, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kJf, R.color.cp_cont_j, 1);
            am.setImageResource(this.jps, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kJg, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kJh, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hzi, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kJi, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kJj, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kJk, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kJl, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ac(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEH();
    }
}
