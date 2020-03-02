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
    private View.OnClickListener auX;
    private TextView gRr;
    private TextView hyW;
    private TextView jic;
    private ImageView jpg;
    private e jrN;
    private TextView kIS;
    private TextView kIT;
    private TextView kIU;
    private TextView kIV;
    private TextView kIW;
    private View kIX;
    private View kIY;
    private View kIZ;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJa = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jic.getId() && id != PersonHeaderAttentionView.this.kIS.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRr.getId() && id != PersonHeaderAttentionView.this.kIT.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIU.getId() || id == PersonHeaderAttentionView.this.kIV.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJa.gar = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJa.gar = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJa.gar = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrN != null) {
                        this.kJa.gas = new Bundle();
                        this.kJa.gas.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrN.a(view, this.kJa);
                    }
                }
            }
        };
        init(context);
        cTz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJa = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jic.getId() && id != PersonHeaderAttentionView.this.kIS.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRr.getId() && id != PersonHeaderAttentionView.this.kIT.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIU.getId() || id == PersonHeaderAttentionView.this.kIV.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJa.gar = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJa.gar = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJa.gar = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrN != null) {
                        this.kJa.gas = new Bundle();
                        this.kJa.gas.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrN.a(view, this.kJa);
                    }
                }
            }
        };
        init(context);
        cTz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kJa = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jic.getId() && id != PersonHeaderAttentionView.this.kIS.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRr.getId() && id != PersonHeaderAttentionView.this.kIT.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIU.getId() || id == PersonHeaderAttentionView.this.kIV.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNO() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kJa.gar = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kJa.gar = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kJa.gar = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrN != null) {
                        this.kJa.gas = new Bundle();
                        this.kJa.gas.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrN.a(view, this.kJa);
                    }
                }
            }
        };
        init(context);
        cTz();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gRr = (TextView) findViewById(R.id.person_header_fans_num);
        this.kIT = (TextView) findViewById(R.id.person_header_fans_des);
        this.jpg = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jic = (TextView) findViewById(R.id.person_header_attention_num);
        this.kIS = (TextView) findViewById(R.id.person_header_attention_des);
        this.kIU = (TextView) findViewById(R.id.person_header_bar_num);
        this.kIV = (TextView) findViewById(R.id.person_header_bar_des);
        this.hyW = (TextView) findViewById(R.id.person_header_thread_num);
        this.hyW.setVisibility(8);
        this.kIW = (TextView) findViewById(R.id.person_header_thread_des);
        this.kIW.setVisibility(8);
        this.kIX = findViewById(R.id.divider_for_fans_and_attention);
        this.kIY = findViewById(R.id.divider_for_attention_and_bar);
        this.kIZ = findViewById(R.id.divider_for_bar_and_thread);
        this.kIZ.setVisibility(8);
    }

    private void cTz() {
        this.gRr.setOnClickListener(this.auX);
        this.kIT.setOnClickListener(this.auX);
        this.jic.setOnClickListener(this.auX);
        this.kIS.setOnClickListener(this.auX);
        this.kIU.setOnClickListener(this.auX);
        this.kIV.setOnClickListener(this.auX);
        this.hyW.setOnClickListener(this.auX);
        this.kIW.setOnClickListener(this.auX);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jrN = eVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jic.setText(str);
        this.gRr.setText(str2);
        this.kIU.setText(str4);
        this.hyW.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jic.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gRr.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kIU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hyW.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jic, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIS, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gRr, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIT, R.color.cp_cont_j, 1);
            am.setImageResource(this.jpg, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kIU, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIV, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hyW, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIW, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kIX, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIY, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIZ, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ac(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEH();
    }
}
