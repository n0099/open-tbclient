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
    private View.OnClickListener bvd;
    private TextView dxa;
    private TextView dxb;
    private g ffP;
    private TextView gxA;
    private TextView gxB;
    private View gxC;
    private ImageView gxD;
    private TextView gxE;
    private View gxF;
    private TextView gxG;
    private TextView gxH;
    private View gxI;
    private TextView gxJ;
    private View gxz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gxK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gxK.ceT = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gxK.ceT = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gxK.ceT = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.ffP != null) {
                        this.gxK.ceU = new Bundle();
                        this.gxK.ceU.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ffP.a(view, this.gxK);
                    }
                }
            }
        };
        init(context);
        Xz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gxK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gxK.ceT = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gxK.ceT = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gxK.ceT = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.ffP != null) {
                        this.gxK.ceU = new Bundle();
                        this.gxK.ceU.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ffP.a(view, this.gxK);
                    }
                }
            }
        };
        init(context);
        Xz();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.b gxK = new com.baidu.tieba.f.b();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.aU(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (d.h.person_header_attention_container == id) {
                        this.gxK.ceT = 4;
                    } else if (d.h.person_header_fans_container == id) {
                        this.gxK.ceT = 5;
                    } else if (d.h.person_header_bar_container == id) {
                        if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Cs() != 2)) {
                            PersonHeaderAttentionView.this.ul(PersonHeaderAttentionView.this.mUserData.getSex());
                            return;
                        } else {
                            this.gxK.ceT = 7;
                        }
                    }
                    if (PersonHeaderAttentionView.this.ffP != null) {
                        this.gxK.ceU = new Bundle();
                        this.gxK.ceU.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.ffP.a(view, this.gxK);
                    }
                }
            }
        };
        init(context);
        Xz();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gxz = findViewById(d.h.person_header_attention_container);
        this.gxA = (TextView) findViewById(d.h.person_header_attention_num);
        this.gxB = (TextView) findViewById(d.h.person_header_attention_des);
        this.gxC = findViewById(d.h.person_header_fans_container);
        this.dxa = (TextView) findViewById(d.h.person_header_fans_num);
        this.gxD = (ImageView) findViewById(d.h.person_header_fans_red_tip);
        this.gxE = (TextView) findViewById(d.h.person_header_fans_des);
        this.gxF = findViewById(d.h.person_header_bar_container);
        this.gxG = (TextView) findViewById(d.h.person_header_bar_num);
        this.gxH = (TextView) findViewById(d.h.person_header_bar_des);
        this.gxI = findViewById(d.h.person_header_thread_container);
        this.dxb = (TextView) findViewById(d.h.person_header_thread_num);
        this.gxJ = (TextView) findViewById(d.h.person_header_thread_des);
        this.gxI.setVisibility(8);
    }

    private void Xz() {
        this.gxz.setOnClickListener(this.bvd);
        this.gxC.setOnClickListener(this.bvd);
        this.gxF.setOnClickListener(this.bvd);
        this.gxI.setOnClickListener(this.bvd);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.ffP = gVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gxA.setText(str);
        this.dxa.setText(str2);
        this.gxG.setText(str4);
        this.dxb.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gxA.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dxa.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gxG.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.dxb.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        }
        m(am.z(this.mUserData.getConcernNum()), am.z(this.mUserData.getFansNum()), am.z(this.mUserData.getPosts_num()), am.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.gxA, d.e.cp_cont_i, 1);
            aj.c(this.gxB, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.dxa, d.e.cp_cont_i, 1);
            aj.c(this.gxE, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.gxD, d.g.icon_news_down_bar_one);
            aj.c(this.gxG, d.e.cp_cont_i, 1);
            aj.c(this.gxH, d.e.cp_cont_i_alpha60, 1);
            aj.c(this.dxb, d.e.cp_cont_i, 1);
            aj.c(this.gxJ, d.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.l.person_privacy_toast), am.cZ(i)), d.g.icon_toast_game_error).tw();
    }

    @Override // com.baidu.tieba.view.e
    public void ne(boolean z) {
        if (this.gxD != null) {
            if (z) {
                this.gxD.setVisibility(0);
            } else {
                this.gxD.setVisibility(8);
            }
        }
    }
}
