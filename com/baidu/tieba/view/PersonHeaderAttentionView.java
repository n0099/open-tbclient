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
    private View.OnClickListener avi;
    private TextView gSK;
    private TextView hAI;
    private TextView jjO;
    private ImageView jqR;
    private e jty;
    private TextView kKL;
    private TextView kKM;
    private TextView kKN;
    private TextView kKO;
    private TextView kKP;
    private View kKQ;
    private View kKR;
    private View kKS;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kKT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jjO.getId() && id != PersonHeaderAttentionView.this.kKL.getId()) {
                        if (id != PersonHeaderAttentionView.this.gSK.getId() && id != PersonHeaderAttentionView.this.kKM.getId()) {
                            if (id == PersonHeaderAttentionView.this.kKN.getId() || id == PersonHeaderAttentionView.this.kKO.getId()) {
                                TiebaStatic.log(new an("c12502").cx("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 2)) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kKT.gbm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cx("obj_locate", "8"));
                            this.kKT.gbm = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "9"));
                        this.kKT.gbm = 4;
                    }
                    if (PersonHeaderAttentionView.this.jty != null) {
                        this.kKT.gbn = new Bundle();
                        this.kKT.gbn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jty.a(view, this.kKT);
                    }
                }
            }
        };
        init(context);
        cTU();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kKT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jjO.getId() && id != PersonHeaderAttentionView.this.kKL.getId()) {
                        if (id != PersonHeaderAttentionView.this.gSK.getId() && id != PersonHeaderAttentionView.this.kKM.getId()) {
                            if (id == PersonHeaderAttentionView.this.kKN.getId() || id == PersonHeaderAttentionView.this.kKO.getId()) {
                                TiebaStatic.log(new an("c12502").cx("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 2)) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kKT.gbm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cx("obj_locate", "8"));
                            this.kKT.gbm = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "9"));
                        this.kKT.gbm = 4;
                    }
                    if (PersonHeaderAttentionView.this.jty != null) {
                        this.kKT.gbn = new Bundle();
                        this.kKT.gbn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jty.a(view, this.kKT);
                    }
                }
            }
        };
        init(context);
        cTU();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kKT = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jjO.getId() && id != PersonHeaderAttentionView.this.kKL.getId()) {
                        if (id != PersonHeaderAttentionView.this.gSK.getId() && id != PersonHeaderAttentionView.this.kKM.getId()) {
                            if (id == PersonHeaderAttentionView.this.kKN.getId() || id == PersonHeaderAttentionView.this.kKO.getId()) {
                                TiebaStatic.log(new an("c12502").cx("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aNT() != 2)) {
                                    PersonHeaderAttentionView.this.Ak(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kKT.gbm = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cx("obj_locate", "8"));
                            this.kKT.gbm = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "9"));
                        this.kKT.gbm = 4;
                    }
                    if (PersonHeaderAttentionView.this.jty != null) {
                        this.kKT.gbn = new Bundle();
                        this.kKT.gbn.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jty.a(view, this.kKT);
                    }
                }
            }
        };
        init(context);
        cTU();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gSK = (TextView) findViewById(R.id.person_header_fans_num);
        this.kKM = (TextView) findViewById(R.id.person_header_fans_des);
        this.jqR = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jjO = (TextView) findViewById(R.id.person_header_attention_num);
        this.kKL = (TextView) findViewById(R.id.person_header_attention_des);
        this.kKN = (TextView) findViewById(R.id.person_header_bar_num);
        this.kKO = (TextView) findViewById(R.id.person_header_bar_des);
        this.hAI = (TextView) findViewById(R.id.person_header_thread_num);
        this.hAI.setVisibility(8);
        this.kKP = (TextView) findViewById(R.id.person_header_thread_des);
        this.kKP.setVisibility(8);
        this.kKQ = findViewById(R.id.divider_for_fans_and_attention);
        this.kKR = findViewById(R.id.divider_for_attention_and_bar);
        this.kKS = findViewById(R.id.divider_for_bar_and_thread);
        this.kKS.setVisibility(8);
    }

    private void cTU() {
        this.gSK.setOnClickListener(this.avi);
        this.kKM.setOnClickListener(this.avi);
        this.jjO.setOnClickListener(this.avi);
        this.kKL.setOnClickListener(this.avi);
        this.kKN.setOnClickListener(this.avi);
        this.kKO.setOnClickListener(this.avi);
        this.hAI.setOnClickListener(this.avi);
        this.kKP.setOnClickListener(this.avi);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jty = eVar;
    }

    private void D(String str, String str2, String str3, String str4) {
        this.jjO.setText(str);
        this.gSK.setText(str2);
        this.kKN.setText(str4);
        this.hAI.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jjO.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gSK.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kKN.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hAI.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        D(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jjO, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kKL, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gSK, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kKM, R.color.cp_cont_j, 1);
            am.setImageResource(this.jqR, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kKN, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kKO, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hAI, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kKP, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kKQ, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kKR, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kKS, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ak(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEL();
    }
}
