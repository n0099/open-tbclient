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
    private View.OnClickListener bsc;
    private TextView dmm;
    private TextView dmn;
    private g fdz;
    private View gvc;
    private TextView gvd;
    private TextView gve;
    private View gvf;
    private ImageView gvg;
    private TextView gvh;
    private View gvi;
    private TextView gvj;
    private TextView gvk;
    private View gvl;
    private TextView gvm;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gvn = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aN(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gvn.bZr = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gvn.bZr = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gvn.bZr = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fdz != null) {
                        this.gvn.bZs = new Bundle();
                        this.gvn.bZs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fdz.a(view, this.gvn);
                    }
                }
            }
        };
        init(context);
        VN();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gvn = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aN(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gvn.bZr = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gvn.bZr = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gvn.bZr = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fdz != null) {
                        this.gvn.bZs = new Bundle();
                        this.gvn.bZs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fdz.a(view, this.gvn);
                    }
                }
            }
        };
        init(context);
        VN();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gvn = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aN(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gvn.bZr = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gvn.bZr = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cp() != 2)) {
                            PersonHeaderAttentionView.this.tX(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gvn.bZr = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fdz != null) {
                        this.gvn.bZs = new Bundle();
                        this.gvn.bZs.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fdz.a(view, this.gvn);
                    }
                }
            }
        };
        init(context);
        VN();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gvc = findViewById(d.h.person_header_attention_container);
        this.gvd = (TextView) findViewById(d.h.person_header_attention_num);
        this.gve = (TextView) findViewById(d.h.person_header_attention_des);
        this.gvf = findViewById(d.h.person_header_fans_container);
        this.dmm = (TextView) findViewById(d.h.person_header_fans_num);
        this.gvg = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.gvh = (TextView) findViewById(d.h.person_header_fans_des);
        this.gvi = findViewById(d.h.person_header_bar_container);
        this.gvj = (TextView) findViewById(d.h.person_header_bar_num);
        this.gvk = (TextView) findViewById(d.h.person_header_bar_des);
        this.gvl = findViewById(d.h.person_header_thread_container);
        this.dmn = (TextView) findViewById(d.h.person_header_thread_num);
        this.gvm = (TextView) findViewById(d.h.person_header_thread_des);
        this.gvl.setVisibility(8);
    }

    private void VN() {
        this.gvc.setOnClickListener(this.bsc);
        this.gvf.setOnClickListener(this.bsc);
        this.gvi.setOnClickListener(this.bsc);
        this.gvl.setOnClickListener(this.bsc);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fdz = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gvd.setText(str);
        this.dmm.setText(str2);
        this.gvj.setText(str4);
        this.dmn.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gvd.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dmm.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gvj.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dmn.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        m(al.A(this.mUserData.getConcernNum()), al.A(this.mUserData.getFansNum()), al.A(this.mUserData.getPosts_num()), al.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.c(this.gvd, d.e.cp_cont_i, 1);
            ai.c(this.gve, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dmm, d.e.cp_cont_i, 1);
            ai.c(this.gvh, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.gvg, d.g.icon_news_down_bar_one);
            ai.c(this.gvj, d.e.cp_cont_i, 1);
            ai.c(this.gvk, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dmn, d.e.cp_cont_i, 1);
            ai.c(this.gvm, d.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), al.cW(i)), d.g.icon_toast_game_error).tp();
    }

    @Override // com.baidu.tieba.view.e
    public void mU(boolean z) {
        if (this.gvg != null) {
            if (z) {
                this.gvg.setVisibility(0);
            } else {
                this.gvg.setVisibility(8);
            }
        }
    }
}
