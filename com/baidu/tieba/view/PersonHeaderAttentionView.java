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
    private View.OnClickListener btC;
    private TextView dpC;
    private TextView dpD;
    private g fgE;
    private View gyf;
    private TextView gyg;
    private TextView gyh;
    private View gyi;
    private ImageView gyj;
    private TextView gyk;
    private View gyl;
    private TextView gym;
    private TextView gyn;
    private View gyo;
    private TextView gyp;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gyq = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gyq.cbj = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gyq.cbj = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gyq.cbj = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fgE != null) {
                        this.gyq.cbk = new Bundle();
                        this.gyq.cbk.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fgE.a(view, this.gyq);
                    }
                }
            }
        };
        init(context);
        Wo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gyq = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gyq.cbj = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gyq.cbj = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gyq.cbj = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fgE != null) {
                        this.gyq.cbk = new Bundle();
                        this.gyq.cbk.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fgE.a(view, this.gyq);
                    }
                }
            }
        };
        init(context);
        Wo();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gyq = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && aw.aO(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gyq.cbj = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gyq.cbj = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cx() != 2)) {
                            PersonHeaderAttentionView.this.uh(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gyq.cbj = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.fgE != null) {
                        this.gyq.cbk = new Bundle();
                        this.gyq.cbk.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.fgE.a(view, this.gyq);
                    }
                }
            }
        };
        init(context);
        Wo();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gyf = findViewById(d.h.person_header_attention_container);
        this.gyg = (TextView) findViewById(d.h.person_header_attention_num);
        this.gyh = (TextView) findViewById(d.h.person_header_attention_des);
        this.gyi = findViewById(d.h.person_header_fans_container);
        this.dpC = (TextView) findViewById(d.h.person_header_fans_num);
        this.gyj = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.gyk = (TextView) findViewById(d.h.person_header_fans_des);
        this.gyl = findViewById(d.h.person_header_bar_container);
        this.gym = (TextView) findViewById(d.h.person_header_bar_num);
        this.gyn = (TextView) findViewById(d.h.person_header_bar_des);
        this.gyo = findViewById(d.h.person_header_thread_container);
        this.dpD = (TextView) findViewById(d.h.person_header_thread_num);
        this.gyp = (TextView) findViewById(d.h.person_header_thread_des);
        this.gyo.setVisibility(8);
    }

    private void Wo() {
        this.gyf.setOnClickListener(this.btC);
        this.gyi.setOnClickListener(this.btC);
        this.gyl.setOnClickListener(this.btC);
        this.gyo.setOnClickListener(this.btC);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.fgE = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gyg.setText(str);
        this.dpC.setText(str2);
        this.gym.setText(str4);
        this.dpD.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gyg.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dpC.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gym.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dpD.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        }
        m(al.A(this.mUserData.getConcernNum()), al.A(this.mUserData.getFansNum()), al.A(this.mUserData.getPosts_num()), al.A(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.c(this.gyg, d.e.cp_cont_i, 1);
            ai.c(this.gyh, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dpC, d.e.cp_cont_i, 1);
            ai.c(this.gyk, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.gyj, d.g.icon_news_down_bar_one);
            ai.c(this.gym, d.e.cp_cont_i, 1);
            ai.c(this.gyn, d.e.cp_cont_i_alpha60, 1);
            ai.c(this.dpD, d.e.cp_cont_i, 1);
            ai.c(this.gyp, d.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), al.cY(i)), d.g.icon_toast_game_error).tz();
    }

    @Override // com.baidu.tieba.view.e
    public void mX(boolean z) {
        if (this.gyj != null) {
            if (z) {
                this.gyj.setVisibility(0);
            } else {
                this.gyj.setVisibility(8);
            }
        }
    }
}
