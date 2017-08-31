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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener buo;
    private TextView dwf;
    private TextView dwg;
    private g feW;
    private View gwF;
    private TextView gwG;
    private TextView gwH;
    private View gwI;
    private ImageView gwJ;
    private TextView gwK;
    private View gwL;
    private TextView gwM;
    private TextView gwN;
    private View gwO;
    private TextView gwP;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwQ = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwQ.ceb = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwQ.ceb = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwQ.ceb = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feW != null) {
                        this.gwQ.cec = new Bundle();
                        this.gwQ.cec.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feW.a(view, this.gwQ);
                    }
                }
            }
        };
        init(context);
        Xo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwQ = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwQ.ceb = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwQ.ceb = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwQ.ceb = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feW != null) {
                        this.gwQ.cec = new Bundle();
                        this.gwQ.cec.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feW.a(view, this.gwQ);
                    }
                }
            }
        };
        init(context);
        Xo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwQ = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aT(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwQ.ceb = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwQ.ceb = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.uj(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwQ.ceb = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feW != null) {
                        this.gwQ.cec = new Bundle();
                        this.gwQ.cec.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feW.a(view, this.gwQ);
                    }
                }
            }
        };
        init(context);
        Xo();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gwF = findViewById(d.h.person_header_attention_container);
        this.gwG = (TextView) findViewById(d.h.person_header_attention_num);
        this.gwH = (TextView) findViewById(d.h.person_header_attention_des);
        this.gwI = findViewById(d.h.person_header_fans_container);
        this.dwf = (TextView) findViewById(d.h.person_header_fans_num);
        this.gwJ = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.gwK = (TextView) findViewById(d.h.person_header_fans_des);
        this.gwL = findViewById(d.h.person_header_bar_container);
        this.gwM = (TextView) findViewById(d.h.person_header_bar_num);
        this.gwN = (TextView) findViewById(d.h.person_header_bar_des);
        this.gwO = findViewById(d.h.person_header_thread_container);
        this.dwg = (TextView) findViewById(d.h.person_header_thread_num);
        this.gwP = (TextView) findViewById(d.h.person_header_thread_des);
        this.gwO.setVisibility(8);
    }

    private void Xo() {
        this.gwF.setOnClickListener(this.buo);
        this.gwI.setOnClickListener(this.buo);
        this.gwL.setOnClickListener(this.buo);
        this.gwO.setOnClickListener(this.buo);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.feW = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gwG.setText(str);
        this.dwf.setText(str2);
        this.gwM.setText(str4);
        this.dwg.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gwG.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dwf.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gwM.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dwg.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        m(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.gwG, d.e.cp_cont_i, 1);
            aj.c(this.gwH, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.dwf, d.e.cp_cont_i, 1);
            aj.c(this.gwK, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.gwJ, d.g.icon_news_down_bar_one);
            aj.c(this.gwM, d.e.cp_cont_i, 1);
            aj.c(this.gwN, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.dwg, d.e.cp_cont_i, 1);
            aj.c(this.gwP, d.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), am.cZ(i)), d.g.icon_toast_game_error).tw();
    }

    @Override // com.baidu.tieba.view.e
    public void nd(boolean z) {
        if (this.gwJ != null) {
            if (z) {
                this.gwJ.setVisibility(0);
            } else {
                this.gwJ.setVisibility(8);
            }
        }
    }
}
