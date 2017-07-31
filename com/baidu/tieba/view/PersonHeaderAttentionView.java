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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener btm;
    private TextView dnE;
    private TextView dnF;
    private g feL;
    private View gwn;
    private TextView gwo;
    private TextView gwp;
    private View gwq;
    private ImageView gwr;
    private TextView gws;
    private View gwt;
    private TextView gwu;
    private TextView gwv;
    private View gww;
    private TextView gwx;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwy = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwy.cax = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwy.cax = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwy.cax = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feL != null) {
                        this.gwy.cay = new Bundle();
                        this.gwy.cay.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feL.a(view, this.gwy);
                    }
                }
            }
        };
        init(context);
        VS();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwy = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwy.cax = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwy.cax = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwy.cax = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feL != null) {
                        this.gwy.cay = new Bundle();
                        this.gwy.cay.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feL.a(view, this.gwy);
                    }
                }
            }
        };
        init(context);
        VS();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gwy = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gwy.cax = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gwy.cax = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gwy.cax = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.feL != null) {
                        this.gwy.cay = new Bundle();
                        this.gwy.cay.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.feL.a(view, this.gwy);
                    }
                }
            }
        };
        init(context);
        VS();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gwn = findViewById(d.h.person_header_attention_container);
        this.gwo = (TextView) findViewById(d.h.person_header_attention_num);
        this.gwp = (TextView) findViewById(d.h.person_header_attention_des);
        this.gwq = findViewById(d.h.person_header_fans_container);
        this.dnE = (TextView) findViewById(d.h.person_header_fans_num);
        this.gwr = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.gws = (TextView) findViewById(d.h.person_header_fans_des);
        this.gwt = findViewById(d.h.person_header_bar_container);
        this.gwu = (TextView) findViewById(d.h.person_header_bar_num);
        this.gwv = (TextView) findViewById(d.h.person_header_bar_des);
        this.gww = findViewById(d.h.person_header_thread_container);
        this.dnF = (TextView) findViewById(d.h.person_header_thread_num);
        this.gwx = (TextView) findViewById(d.h.person_header_thread_des);
        this.gww.setVisibility(8);
    }

    private void VS() {
        this.gwn.setOnClickListener(this.btm);
        this.gwq.setOnClickListener(this.btm);
        this.gwt.setOnClickListener(this.btm);
        this.gww.setOnClickListener(this.btm);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.feL = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gwo.setText(str);
        this.dnE.setText(str2);
        this.gwu.setText(str4);
        this.dnF.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gwo.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dnE.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gwu.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dnF.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        m(al.A(this.mUserData.getConcernNum()), al.A(this.mUserData.getFansNum()), al.A(this.mUserData.getPosts_num()), al.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.c(this.gwo, d.e.cp_cont_i, 1);
            ai.c(this.gwp, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dnE, d.e.cp_cont_i, 1);
            ai.c(this.gws, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.gwr, d.g.icon_news_down_bar_one);
            ai.c(this.gwu, d.e.cp_cont_i, 1);
            ai.c(this.gwv, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dnF, d.e.cp_cont_i, 1);
            ai.c(this.gwx, d.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), al.cY(i)), d.g.icon_toast_game_error).tz();
    }

    @Override // com.baidu.tieba.view.e
    public void mU(boolean z) {
        if (this.gwr != null) {
            if (z) {
                this.gwr.setVisibility(0);
            } else {
                this.gwr.setVisibility(8);
            }
        }
    }
}
