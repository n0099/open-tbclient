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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private TextView aQQ;
    private View.OnClickListener bgh;
    private m epg;
    private View fuM;
    private TextView fuN;
    private TextView fuO;
    private View fuP;
    private ImageView fuQ;
    private TextView fuR;
    private View fuS;
    private TextView fuT;
    private TextView fuU;
    private View fuV;
    private TextView fuW;
    private TextView fuX;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bgh = new s(this);
        init(context);
        bkp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bgh = new s(this);
        init(context);
        bkp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bgh = new s(this);
        init(context);
        bkp();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(r.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fuM = findViewById(r.g.person_header_attention_container);
        this.fuN = (TextView) findViewById(r.g.person_header_attention_num);
        this.fuO = (TextView) findViewById(r.g.person_header_attention_des);
        this.fuP = findViewById(r.g.person_header_fans_container);
        this.aQQ = (TextView) findViewById(r.g.person_header_fans_num);
        this.fuQ = (ImageView) findViewById(r.g.person_header_fans_red_tip);
        this.fuR = (TextView) findViewById(r.g.person_header_fans_des);
        this.fuS = findViewById(r.g.person_header_post_container);
        this.fuT = (TextView) findViewById(r.g.person_header_post_num);
        this.fuU = (TextView) findViewById(r.g.person_header_post_des);
        this.fuV = findViewById(r.g.person_header_bar_container);
        this.fuW = (TextView) findViewById(r.g.person_header_bar_num);
        this.fuX = (TextView) findViewById(r.g.person_header_bar_des);
    }

    private void bkp() {
        this.fuM.setOnClickListener(this.bgh);
        this.fuP.setOnClickListener(this.bgh);
        this.fuS.setOnClickListener(this.bgh);
        this.fuV.setOnClickListener(this.bgh);
    }

    public void setOnViewResponseListener(m mVar) {
        this.epg = mVar;
    }

    private void l(String str, String str2, String str3, String str4) {
        this.fuN.setText(str);
        this.aQQ.setText(str2);
        this.fuT.setText(str3);
        this.fuW.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fuN.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.aQQ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fuT.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fuW.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        l(av.z(this.mUserData.getConcernNum()), av.z(this.mUserData.getFansNum()), av.z(this.mUserData.getPosts_num()), av.z(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ar.k(this.fuM, r.f.item_person_header_attention_bg_selector);
            ar.c(this.fuN, r.d.cp_cont_f, 1);
            ar.c(this.fuO, r.d.cp_cont_c, 1);
            ar.k(this.fuP, r.f.item_person_header_attention_bg_selector);
            ar.c(this.aQQ, r.d.cp_cont_f, 1);
            ar.c(this.fuR, r.d.cp_cont_c, 1);
            ar.c(this.fuQ, r.f.icon_news_down_bar_one);
            ar.k(this.fuS, r.f.item_person_header_attention_bg_selector);
            ar.c(this.fuT, r.d.cp_cont_f, 1);
            ar.c(this.fuU, r.d.cp_cont_c, 1);
            ar.k(this.fuV, r.f.item_person_header_attention_bg_selector);
            ar.c(this.fuW, r.d.cp_cont_f, 1);
            ar.c(this.fuX, r.d.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(r.j.person_privacy_toast), av.cW(i)), r.f.icon_toast_game_error).tj();
    }

    public void lp(boolean z) {
        if (this.fuQ != null) {
            if (z) {
                this.fuQ.setVisibility(0);
            } else {
                this.fuQ.setVisibility(8);
            }
        }
    }
}
