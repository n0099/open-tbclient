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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener baj;
    private TextView cTf;
    private m ezb;
    private View fDG;
    private TextView fDH;
    private TextView fDI;
    private View fDJ;
    private ImageView fDK;
    private TextView fDL;
    private View fDM;
    private TextView fDN;
    private TextView fDO;
    private View fDP;
    private TextView fDQ;
    private TextView fDR;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.baj = new s(this);
        init(context);
        blR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.baj = new s(this);
        init(context);
        blR();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.baj = new s(this);
        init(context);
        blR();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(r.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.fDG = findViewById(r.h.person_header_attention_container);
        this.fDH = (TextView) findViewById(r.h.person_header_attention_num);
        this.fDI = (TextView) findViewById(r.h.person_header_attention_des);
        this.fDJ = findViewById(r.h.person_header_fans_container);
        this.cTf = (TextView) findViewById(r.h.person_header_fans_num);
        this.fDK = (ImageView) findViewById(r.h.person_header_fans_red_tip);
        this.fDL = (TextView) findViewById(r.h.person_header_fans_des);
        this.fDM = findViewById(r.h.person_header_post_container);
        this.fDN = (TextView) findViewById(r.h.person_header_post_num);
        this.fDO = (TextView) findViewById(r.h.person_header_post_des);
        this.fDP = findViewById(r.h.person_header_bar_container);
        this.fDQ = (TextView) findViewById(r.h.person_header_bar_num);
        this.fDR = (TextView) findViewById(r.h.person_header_bar_des);
    }

    private void blR() {
        this.fDG.setOnClickListener(this.baj);
        this.fDJ.setOnClickListener(this.baj);
        this.fDM.setOnClickListener(this.baj);
        this.fDP.setOnClickListener(this.baj);
    }

    public void setOnViewResponseListener(m mVar) {
        this.ezb = mVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.fDH.setText(str);
        this.cTf.setText(str2);
        this.fDN.setText(str3);
        this.fDQ.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fDH.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cTf.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fDN.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fDQ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32));
        }
        m(at.x(this.mUserData.getConcernNum()), at.x(this.mUserData.getFansNum()), at.x(this.mUserData.getPosts_num()), at.x(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.j(this.fDG, r.g.item_person_header_attention_bg_selector);
            ap.c(this.fDH, r.e.cp_cont_f, 1);
            ap.c(this.fDI, r.e.cp_cont_c, 1);
            ap.j(this.fDJ, r.g.item_person_header_attention_bg_selector);
            ap.c(this.cTf, r.e.cp_cont_f, 1);
            ap.c(this.fDL, r.e.cp_cont_c, 1);
            ap.c(this.fDK, r.g.icon_news_down_bar_one);
            ap.j(this.fDM, r.g.item_person_header_attention_bg_selector);
            ap.c(this.fDN, r.e.cp_cont_f, 1);
            ap.c(this.fDO, r.e.cp_cont_c, 1);
            ap.j(this.fDP, r.g.item_person_header_attention_bg_selector);
            ap.c(this.fDQ, r.e.cp_cont_f, 1);
            ap.c(this.fDR, r.e.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(r.l.person_privacy_toast), at.cW(i)), r.g.icon_toast_game_error).td();
    }

    public void lB(boolean z) {
        if (this.fDK != null) {
            if (z) {
                this.fDK.setVisibility(0);
            } else {
                this.fDK.setVisibility(8);
            }
        }
    }
}
