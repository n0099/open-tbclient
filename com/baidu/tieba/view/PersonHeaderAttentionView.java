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
    private TextView jhh;
    private ImageView jol;
    private e jqQ;
    private TextView kHV;
    private TextView kHW;
    private TextView kHX;
    private TextView kHY;
    private TextView kHZ;
    private View kIa;
    private View kIb;
    private View kIc;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kId = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhh.getId() && id != PersonHeaderAttentionView.this.kHV.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHW.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHX.getId() || id == PersonHeaderAttentionView.this.kHY.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kId.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kId.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kId.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqQ != null) {
                        this.kId.fYq = new Bundle();
                        this.kId.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqQ.a(view, this.kId);
                    }
                }
            }
        };
        init(context);
        cSc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kId = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhh.getId() && id != PersonHeaderAttentionView.this.kHV.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHW.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHX.getId() || id == PersonHeaderAttentionView.this.kHY.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kId.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kId.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kId.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqQ != null) {
                        this.kId.fYq = new Bundle();
                        this.kId.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqQ.a(view, this.kId);
                    }
                }
            }
        };
        init(context);
        cSc();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kId = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jhh.getId() && id != PersonHeaderAttentionView.this.kHV.getId()) {
                        if (id != PersonHeaderAttentionView.this.gPp.getId() && id != PersonHeaderAttentionView.this.kHW.getId()) {
                            if (id == PersonHeaderAttentionView.this.kHX.getId() || id == PersonHeaderAttentionView.this.kHY.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aLq() != 2)) {
                                    PersonHeaderAttentionView.this.zV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kId.fYp = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kId.fYp = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
                        this.kId.fYp = 4;
                    }
                    if (PersonHeaderAttentionView.this.jqQ != null) {
                        this.kId.fYq = new Bundle();
                        this.kId.fYq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jqQ.a(view, this.kId);
                    }
                }
            }
        };
        init(context);
        cSc();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gPp = (TextView) findViewById(R.id.person_header_fans_num);
        this.kHW = (TextView) findViewById(R.id.person_header_fans_des);
        this.jol = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jhh = (TextView) findViewById(R.id.person_header_attention_num);
        this.kHV = (TextView) findViewById(R.id.person_header_attention_des);
        this.kHX = (TextView) findViewById(R.id.person_header_bar_num);
        this.kHY = (TextView) findViewById(R.id.person_header_bar_des);
        this.hwV = (TextView) findViewById(R.id.person_header_thread_num);
        this.hwV.setVisibility(8);
        this.kHZ = (TextView) findViewById(R.id.person_header_thread_des);
        this.kHZ.setVisibility(8);
        this.kIa = findViewById(R.id.divider_for_fans_and_attention);
        this.kIb = findViewById(R.id.divider_for_attention_and_bar);
        this.kIc = findViewById(R.id.divider_for_bar_and_thread);
        this.kIc.setVisibility(8);
    }

    private void cSc() {
        this.gPp.setOnClickListener(this.arL);
        this.kHW.setOnClickListener(this.arL);
        this.jhh.setOnClickListener(this.arL);
        this.kHV.setOnClickListener(this.arL);
        this.kHX.setOnClickListener(this.arL);
        this.kHY.setOnClickListener(this.arL);
        this.hwV.setOnClickListener(this.arL);
        this.kHZ.setOnClickListener(this.arL);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jqQ = eVar;
    }

    private void A(String str, String str2, String str3, String str4) {
        this.jhh.setText(str);
        this.gPp.setText(str2);
        this.kHX.setText(str4);
        this.hwV.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jhh.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gPp.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kHX.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hwV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        A(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jhh, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHV, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gPp, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHW, R.color.cp_cont_j, 1);
            am.setImageResource(this.jol, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kHX, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHY, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hwV, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kHZ, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kIa, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIb, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIc, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCu();
    }
}
