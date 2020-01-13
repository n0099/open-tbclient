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
/* loaded from: classes7.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener arL;
    private TextView gPp;
    private TextView hwV;
    private TextView jhc;
    private ImageView jog;
    private e jqL;
    private TextView kHQ;
    private TextView kHR;
    private TextView kHS;
    private TextView kHT;
    private TextView kHU;
    private View kHV;
    private View kHW;
    private View kHX;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kHY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhc.getId() && id != PersonHeaderAttentionView.this.kHQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHS.getId() || id == PersonHeaderAttentionView.this.kHT.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kHY.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kHY.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kHY.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqL != null) {
                        this.kHY.fYq = new Bundle();
                        this.kHY.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqL.a(view, this.kHY);
                    }
                }
            }
        };
        init(context);
        cSa();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kHY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhc.getId() && id != PersonHeaderAttentionView.this.kHQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHS.getId() || id == PersonHeaderAttentionView.this.kHT.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kHY.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kHY.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kHY.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqL != null) {
                        this.kHY.fYq = new Bundle();
                        this.kHY.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqL.a(view, this.kHY);
                    }
                }
            }
        };
        init(context);
        cSa();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kHY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhc.getId() && id != PersonHeaderAttentionView.this.kHQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHS.getId() || id == PersonHeaderAttentionView.this.kHT.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kHY.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kHY.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kHY.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqL != null) {
                        this.kHY.fYq = new Bundle();
                        this.kHY.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqL.a(view, this.kHY);
                    }
                }
            }
        };
        init(context);
        cSa();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gPp = (TextView) findViewById(R.id.person_header_fans_num);
        this.kHR = (TextView) findViewById(R.id.person_header_fans_des);
        this.jog = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jhc = (TextView) findViewById(R.id.person_header_attention_num);
        this.kHQ = (TextView) findViewById(R.id.person_header_attention_des);
        this.kHS = (TextView) findViewById(R.id.person_header_bar_num);
        this.kHT = (TextView) findViewById(R.id.person_header_bar_des);
        this.hwV = (TextView) findViewById(R.id.person_header_thread_num);
        this.hwV.setVisibility(8);
        this.kHU = (TextView) findViewById(R.id.person_header_thread_des);
        this.kHU.setVisibility(8);
        this.kHV = findViewById(R.id.divider_for_fans_and_attention);
        this.kHW = findViewById(R.id.divider_for_attention_and_bar);
        this.kHX = findViewById(R.id.divider_for_bar_and_thread);
        this.kHX.setVisibility(8);
    }

    private void cSa() {
        this.gPp.setOnClickListener(this.arL);
        this.kHR.setOnClickListener(this.arL);
        this.jhc.setOnClickListener(this.arL);
        this.kHQ.setOnClickListener(this.arL);
        this.kHS.setOnClickListener(this.arL);
        this.kHT.setOnClickListener(this.arL);
        this.hwV.setOnClickListener(this.arL);
        this.kHU.setOnClickListener(this.arL);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jqL = eVar;
    }

    private void A(String str, String str2, String str3, String str4) {
        this.jhc.setText(str);
        this.gPp.setText(str2);
        this.kHS.setText(str4);
        this.hwV.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jhc.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gPp.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kHS.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hwV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        A(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jhc, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHQ, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gPp, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHR, R.color.cp_cont_j, 1);
            am.setImageResource(this.jog, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kHS, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHT, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hwV, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHU, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kHV, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kHW, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kHX, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCu();
    }
}
