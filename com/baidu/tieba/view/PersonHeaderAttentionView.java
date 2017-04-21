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
    private View.OnClickListener biY;
    private TextView cWk;
    private m eCN;
    private View fMm;
    private TextView fMn;
    private TextView fMo;
    private View fMp;
    private ImageView fMq;
    private TextView fMr;
    private View fMs;
    private TextView fMt;
    private TextView fMu;
    private View fMv;
    private TextView fMw;
    private TextView fMx;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.biY = new s(this);
        init(context);
        bnr();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.biY = new s(this);
        init(context);
        bnr();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.biY = new s(this);
        init(context);
        bnr();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.fMm = findViewById(w.h.person_header_attention_container);
        this.fMn = (TextView) findViewById(w.h.person_header_attention_num);
        this.fMo = (TextView) findViewById(w.h.person_header_attention_des);
        this.fMp = findViewById(w.h.person_header_fans_container);
        this.cWk = (TextView) findViewById(w.h.person_header_fans_num);
        this.fMq = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.fMr = (TextView) findViewById(w.h.person_header_fans_des);
        this.fMs = findViewById(w.h.person_header_post_container);
        this.fMt = (TextView) findViewById(w.h.person_header_post_num);
        this.fMu = (TextView) findViewById(w.h.person_header_post_des);
        this.fMv = findViewById(w.h.person_header_bar_container);
        this.fMw = (TextView) findViewById(w.h.person_header_bar_num);
        this.fMx = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void bnr() {
        this.fMm.setOnClickListener(this.biY);
        this.fMp.setOnClickListener(this.biY);
        this.fMs.setOnClickListener(this.biY);
        this.fMv.setOnClickListener(this.biY);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCN = mVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.fMn.setText(str);
        this.cWk.setText(str2);
        this.fMt.setText(str3);
        this.fMw.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fMn.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cWk.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fMt.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fMw.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        m(au.x(this.mUserData.getConcernNum()), au.x(this.mUserData.getFansNum()), au.x(this.mUserData.getPosts_num()), au.x(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.fMm, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fMn, w.e.cp_cont_f, 1);
            aq.c(this.fMo, w.e.cp_cont_c, 1);
            aq.j(this.fMp, w.g.item_person_header_attention_bg_selector);
            aq.c(this.cWk, w.e.cp_cont_f, 1);
            aq.c(this.fMr, w.e.cp_cont_c, 1);
            aq.c(this.fMq, w.g.icon_news_down_bar_one);
            aq.j(this.fMs, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fMt, w.e.cp_cont_f, 1);
            aq.c(this.fMu, w.e.cp_cont_c, 1);
            aq.j(this.fMv, w.g.item_person_header_attention_bg_selector);
            aq.c(this.fMw, w.e.cp_cont_f, 1);
            aq.c(this.fMx, w.e.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), au.cV(i)), w.g.icon_toast_game_error).tY();
    }

    public void lN(boolean z) {
        if (this.fMq != null) {
            if (z) {
                this.fMq.setVisibility(0);
            } else {
                this.fMq.setVisibility(8);
            }
        }
    }
}
