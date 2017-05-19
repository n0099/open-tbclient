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
    private View.OnClickListener bjv;
    private TextView cQn;
    private p eyy;
    private View fJb;
    private TextView fJc;
    private TextView fJd;
    private View fJe;
    private ImageView fJf;
    private TextView fJg;
    private View fJh;
    private TextView fJi;
    private TextView fJj;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bjv = new v(this);
        init(context);
        aQb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bjv = new v(this);
        init(context);
        aQb();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bjv = new v(this);
        init(context);
        aQb();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.fJb = findViewById(w.h.person_header_attention_container);
        this.fJc = (TextView) findViewById(w.h.person_header_attention_num);
        this.fJd = (TextView) findViewById(w.h.person_header_attention_des);
        this.fJe = findViewById(w.h.person_header_fans_container);
        this.cQn = (TextView) findViewById(w.h.person_header_fans_num);
        this.fJf = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.fJg = (TextView) findViewById(w.h.person_header_fans_des);
        this.fJh = findViewById(w.h.person_header_bar_container);
        this.fJi = (TextView) findViewById(w.h.person_header_bar_num);
        this.fJj = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void aQb() {
        this.fJb.setOnClickListener(this.bjv);
        this.fJe.setOnClickListener(this.bjv);
        this.fJh.setOnClickListener(this.bjv);
    }

    public void setOnViewResponseListener(p pVar) {
        this.eyy = pVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.fJc.setText(str);
        this.cQn.setText(str2);
        this.fJi.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fJc.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.cQn.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fJi.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        m(au.y(this.mUserData.getConcernNum()), au.y(this.mUserData.getFansNum()), au.y(this.mUserData.getPosts_num()), au.y(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.c(this.fJc, w.e.cp_cont_i, 1);
            aq.c(this.fJd, w.e.cp_cont_i_alpha60, 1);
            aq.c(this.cQn, w.e.cp_cont_i, 1);
            aq.c(this.fJg, w.e.cp_cont_i_alpha60, 1);
            aq.c(this.fJf, w.g.icon_news_down_bar_one);
            aq.c(this.fJi, w.e.cp_cont_i, 1);
            aq.c(this.fJj, w.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), au.cR(i)), w.g.icon_toast_game_error).tl();
    }

    public void lv(boolean z) {
        if (this.fJf != null) {
            if (z) {
                this.fJf.setVisibility(0);
            } else {
                this.fJf.setVisibility(8);
            }
        }
    }
}
