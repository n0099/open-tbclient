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
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener bgO;
    private TextView cTT;
    private m eAx;
    private View fJQ;
    private TextView fJR;
    private TextView fJS;
    private View fJT;
    private ImageView fJU;
    private TextView fJV;
    private View fJW;
    private TextView fJX;
    private TextView fJY;
    private View fJZ;
    private TextView fKa;
    private TextView fKb;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bgO = new s(this);
        init(context);
        bmq();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bgO = new s(this);
        init(context);
        bmq();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bgO = new s(this);
        init(context);
        bmq();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.fJQ = findViewById(w.h.person_header_attention_container);
        this.fJR = (TextView) findViewById(w.h.person_header_attention_num);
        this.fJS = (TextView) findViewById(w.h.person_header_attention_des);
        this.fJT = findViewById(w.h.person_header_fans_container);
        this.cTT = (TextView) findViewById(w.h.person_header_fans_num);
        this.fJU = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.fJV = (TextView) findViewById(w.h.person_header_fans_des);
        this.fJW = findViewById(w.h.person_header_post_container);
        this.fJX = (TextView) findViewById(w.h.person_header_post_num);
        this.fJY = (TextView) findViewById(w.h.person_header_post_des);
        this.fJZ = findViewById(w.h.person_header_bar_container);
        this.fKa = (TextView) findViewById(w.h.person_header_bar_num);
        this.fKb = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void bmq() {
        this.fJQ.setOnClickListener(this.bgO);
        this.fJT.setOnClickListener(this.bgO);
        this.fJW.setOnClickListener(this.bgO);
        this.fJZ.setOnClickListener(this.bgO);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eAx = mVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.fJR.setText(str);
        this.cTT.setText(str2);
        this.fJX.setText(str3);
        this.fKa.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fJR.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cTT.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fJX.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fKa.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        m(au.x(this.mUserData.getConcernNum()), au.x(this.mUserData.getFansNum()), au.x(this.mUserData.getPosts_num()), au.x(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.fJQ, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fJR, w.e.cp_cont_f, 1);
            aq.c(this.fJS, w.e.cp_cont_c, 1);
            aq.j(this.fJT, w.g.item_person_header_attention_bg_selector);
            aq.c(this.cTT, w.e.cp_cont_f, 1);
            aq.c(this.fJV, w.e.cp_cont_c, 1);
            aq.c(this.fJU, w.g.icon_news_down_bar_one);
            aq.j(this.fJW, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fJX, w.e.cp_cont_f, 1);
            aq.c(this.fJY, w.e.cp_cont_c, 1);
            aq.j(this.fJZ, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fKa, w.e.cp_cont_f, 1);
            aq.c(this.fKb, w.e.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), au.cV(i)), w.g.icon_toast_game_error).tY();
    }

    public void lD(boolean z) {
        if (this.fJU != null) {
            if (z) {
                this.fJU.setVisibility(0);
            } else {
                this.fJU.setVisibility(8);
            }
        }
    }
}
