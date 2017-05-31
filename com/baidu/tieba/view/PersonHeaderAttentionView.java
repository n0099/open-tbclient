package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements p {
    private View.OnClickListener bkC;
    private View bxC;
    private TextView bxD;
    private TextView bxE;
    private View bxL;
    private TextView bxM;
    private ImageView bxN;
    private TextView bxO;
    private View bxP;
    private TextView bxQ;
    private TextView bxR;
    private r bxW;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bkC = new w(this);
        init(context);
        TR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bkC = new w(this);
        init(context);
        TR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bkC = new w(this);
        init(context);
        TR();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.bxC = findViewById(w.h.person_header_attention_container);
        this.bxD = (TextView) findViewById(w.h.person_header_attention_num);
        this.bxE = (TextView) findViewById(w.h.person_header_attention_des);
        this.bxL = findViewById(w.h.person_header_fans_container);
        this.bxM = (TextView) findViewById(w.h.person_header_fans_num);
        this.bxN = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.bxO = (TextView) findViewById(w.h.person_header_fans_des);
        this.bxP = findViewById(w.h.person_header_bar_container);
        this.bxQ = (TextView) findViewById(w.h.person_header_bar_num);
        this.bxR = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void TR() {
        this.bxC.setOnClickListener(this.bkC);
        this.bxL.setOnClickListener(this.bkC);
        this.bxP.setOnClickListener(this.bkC);
    }

    @Override // com.baidu.tieba.view.p
    public void setOnViewResponseListener(r rVar) {
        this.bxW = rVar;
    }

    private void k(String str, String str2, String str3, String str4) {
        this.bxD.setText(str);
        this.bxM.setText(str2);
        this.bxQ.setText(str4);
    }

    @Override // com.baidu.tieba.view.p
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.bxD.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.bxM.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.bxQ.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        k(au.y(this.mUserData.getConcernNum()), au.y(this.mUserData.getFansNum()), au.y(this.mUserData.getPosts_num()), au.y(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.p
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.c(this.bxD, w.e.cp_cont_i, 1);
            aq.c(this.bxE, w.e.cp_cont_i_alpha60, 1);
            aq.c(this.bxM, w.e.cp_cont_i, 1);
            aq.c(this.bxO, w.e.cp_cont_i_alpha60, 1);
            aq.c(this.bxN, w.g.icon_news_down_bar_one);
            aq.c(this.bxQ, w.e.cp_cont_i, 1);
            aq.c(this.bxR, w.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), au.cS(i)), w.g.icon_toast_game_error).tk();
    }

    @Override // com.baidu.tieba.view.p
    public void dm(boolean z) {
        if (this.bxN != null) {
            if (z) {
                this.bxN.setVisibility(0);
            } else {
                this.bxN.setVisibility(8);
            }
        }
    }
}
