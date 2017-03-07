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
    private View.OnClickListener bgU;
    private TextView cVw;
    private m eCA;
    private View fIh;
    private TextView fIi;
    private TextView fIj;
    private View fIk;
    private ImageView fIl;
    private TextView fIm;
    private View fIn;
    private TextView fIo;
    private TextView fIp;
    private View fIq;
    private TextView fIr;
    private TextView fIs;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bgU = new s(this);
        init(context);
        blG();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bgU = new s(this);
        init(context);
        blG();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bgU = new s(this);
        init(context);
        blG();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.fIh = findViewById(w.h.person_header_attention_container);
        this.fIi = (TextView) findViewById(w.h.person_header_attention_num);
        this.fIj = (TextView) findViewById(w.h.person_header_attention_des);
        this.fIk = findViewById(w.h.person_header_fans_container);
        this.cVw = (TextView) findViewById(w.h.person_header_fans_num);
        this.fIl = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.fIm = (TextView) findViewById(w.h.person_header_fans_des);
        this.fIn = findViewById(w.h.person_header_post_container);
        this.fIo = (TextView) findViewById(w.h.person_header_post_num);
        this.fIp = (TextView) findViewById(w.h.person_header_post_des);
        this.fIq = findViewById(w.h.person_header_bar_container);
        this.fIr = (TextView) findViewById(w.h.person_header_bar_num);
        this.fIs = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void blG() {
        this.fIh.setOnClickListener(this.bgU);
        this.fIk.setOnClickListener(this.bgU);
        this.fIn.setOnClickListener(this.bgU);
        this.fIq.setOnClickListener(this.bgU);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCA = mVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.fIi.setText(str);
        this.cVw.setText(str2);
        this.fIo.setText(str3);
        this.fIr.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fIi.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cVw.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fIo.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fIr.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        m(au.x(this.mUserData.getConcernNum()), au.x(this.mUserData.getFansNum()), au.x(this.mUserData.getPosts_num()), au.x(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.fIh, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fIi, w.e.cp_cont_f, 1);
            aq.c(this.fIj, w.e.cp_cont_c, 1);
            aq.j(this.fIk, w.g.item_person_header_attention_bg_selector);
            aq.c(this.cVw, w.e.cp_cont_f, 1);
            aq.c(this.fIm, w.e.cp_cont_c, 1);
            aq.c(this.fIl, w.g.icon_news_down_bar_one);
            aq.j(this.fIn, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fIo, w.e.cp_cont_f, 1);
            aq.c(this.fIp, w.e.cp_cont_c, 1);
            aq.j(this.fIq, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fIr, w.e.cp_cont_f, 1);
            aq.c(this.fIs, w.e.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), au.cS(i)), w.g.icon_toast_game_error).tA();
    }

    public void lA(boolean z) {
        if (this.fIl != null) {
            if (z) {
                this.fIl.setVisibility(0);
            } else {
                this.fIl.setVisibility(8);
            }
        }
    }
}
