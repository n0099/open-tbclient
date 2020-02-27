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
    private TextView gRp;
    private TextView hyU;
    private TextView jia;
    private ImageView jpe;
    private e jrL;
    private TextView kIQ;
    private TextView kIR;
    private TextView kIS;
    private TextView kIT;
    private TextView kIU;
    private View kIV;
    private View kIW;
    private View kIX;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kIY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jia.getId() && id != PersonHeaderAttentionView.this.kIQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRp.getId() && id != PersonHeaderAttentionView.this.kIR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIS.getId() || id == PersonHeaderAttentionView.this.kIT.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kIY.gap = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kIY.gap = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kIY.gap = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrL != null) {
                        this.kIY.gaq = new Bundle();
                        this.kIY.gaq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrL.a(view, this.kIY);
                    }
                }
            }
        };
        init(context);
        cTx();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kIY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jia.getId() && id != PersonHeaderAttentionView.this.kIQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRp.getId() && id != PersonHeaderAttentionView.this.kIR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIS.getId() || id == PersonHeaderAttentionView.this.kIT.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kIY.gap = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kIY.gap = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kIY.gap = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrL != null) {
                        this.kIY.gaq = new Bundle();
                        this.kIY.gaq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrL.a(view, this.kIY);
                    }
                }
            }
        };
        init(context);
        cTx();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kIY = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jia.getId() && id != PersonHeaderAttentionView.this.kIQ.getId()) {
                        if (id != PersonHeaderAttentionView.this.gRp.getId() && id != PersonHeaderAttentionView.this.kIR.getId()) {
                            if (id == PersonHeaderAttentionView.this.kIS.getId() || id == PersonHeaderAttentionView.this.kIT.getId()) {
                                TiebaStatic.log(new an("c12502").cy("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNM() != 2)) {
                                    PersonHeaderAttentionView.this.Ac(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kIY.gap = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cy("obj_locate", "8"));
                            this.kIY.gap = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "9"));
                        this.kIY.gap = 4;
                    }
                    if (PersonHeaderAttentionView.this.jrL != null) {
                        this.kIY.gaq = new Bundle();
                        this.kIY.gaq.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jrL.a(view, this.kIY);
                    }
                }
            }
        };
        init(context);
        cTx();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gRp = (TextView) findViewById(R.id.person_header_fans_num);
        this.kIR = (TextView) findViewById(R.id.person_header_fans_des);
        this.jpe = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jia = (TextView) findViewById(R.id.person_header_attention_num);
        this.kIQ = (TextView) findViewById(R.id.person_header_attention_des);
        this.kIS = (TextView) findViewById(R.id.person_header_bar_num);
        this.kIT = (TextView) findViewById(R.id.person_header_bar_des);
        this.hyU = (TextView) findViewById(R.id.person_header_thread_num);
        this.hyU.setVisibility(8);
        this.kIU = (TextView) findViewById(R.id.person_header_thread_des);
        this.kIU.setVisibility(8);
        this.kIV = findViewById(R.id.divider_for_fans_and_attention);
        this.kIW = findViewById(R.id.divider_for_attention_and_bar);
        this.kIX = findViewById(R.id.divider_for_bar_and_thread);
        this.kIX.setVisibility(8);
    }

    private void cTx() {
        this.gRp.setOnClickListener(this.auX);
        this.kIR.setOnClickListener(this.auX);
        this.jia.setOnClickListener(this.auX);
        this.kIQ.setOnClickListener(this.auX);
        this.kIS.setOnClickListener(this.auX);
        this.kIT.setOnClickListener(this.auX);
        this.hyU.setOnClickListener(this.auX);
        this.kIU.setOnClickListener(this.auX);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jrL = eVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jia.setText(str);
        this.gRp.setText(str2);
        this.kIS.setText(str4);
        this.hyU.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jia.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gRp.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kIS.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hyU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jia, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIQ, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gRp, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIR, R.color.cp_cont_j, 1);
            am.setImageResource(this.jpe, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kIS, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIT, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hyU, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kIU, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kIV, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIW, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kIX, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ac(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEF();
    }
}
