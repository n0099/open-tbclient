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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private TextView aOj;
    private View.OnClickListener bdv;
    private m eDi;
    private View fWA;
    private TextView fWB;
    private TextView fWC;
    private View fWD;
    private TextView fWE;
    private TextView fWF;
    private View fWu;
    private TextView fWv;
    private TextView fWw;
    private View fWx;
    private ImageView fWy;
    private TextView fWz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bdv = new s(this);
        init(context);
        bqs();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bdv = new s(this);
        init(context);
        bqs();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bdv = new s(this);
        init(context);
        bqs();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(t.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fWu = findViewById(t.g.person_header_attention_container);
        this.fWv = (TextView) findViewById(t.g.person_header_attention_num);
        this.fWw = (TextView) findViewById(t.g.person_header_attention_des);
        this.fWx = findViewById(t.g.person_header_fans_container);
        this.aOj = (TextView) findViewById(t.g.person_header_fans_num);
        this.fWy = (ImageView) findViewById(t.g.person_header_fans_red_tip);
        this.fWz = (TextView) findViewById(t.g.person_header_fans_des);
        this.fWA = findViewById(t.g.person_header_post_container);
        this.fWB = (TextView) findViewById(t.g.person_header_post_num);
        this.fWC = (TextView) findViewById(t.g.person_header_post_des);
        this.fWD = findViewById(t.g.person_header_bar_container);
        this.fWE = (TextView) findViewById(t.g.person_header_bar_num);
        this.fWF = (TextView) findViewById(t.g.person_header_bar_des);
    }

    private void bqs() {
        this.fWu.setOnClickListener(this.bdv);
        this.fWx.setOnClickListener(this.bdv);
        this.fWA.setOnClickListener(this.bdv);
        this.fWD.setOnClickListener(this.bdv);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eDi = mVar;
    }

    private void o(String str, String str2, String str3, String str4) {
        this.fWv.setText(str);
        this.aOj.setText(str2);
        this.fWB.setText(str3);
        this.fWE.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fWv.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.aOj.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fWB.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fWE.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds32));
        }
        o(ba.z(this.mUserData.getConcernNum()), ba.z(this.mUserData.getFansNum()), ba.z(this.mUserData.getPosts_num()), ba.z(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            av.k(this.fWu, t.f.item_person_header_attention_bg_selector);
            av.c(this.fWv, t.d.cp_cont_f, 1);
            av.c(this.fWw, t.d.cp_cont_c, 1);
            av.k(this.fWx, t.f.item_person_header_attention_bg_selector);
            av.c(this.aOj, t.d.cp_cont_f, 1);
            av.c(this.fWz, t.d.cp_cont_c, 1);
            av.c(this.fWy, t.f.icon_news_down_bar_one);
            av.k(this.fWA, t.f.item_person_header_attention_bg_selector);
            av.c(this.fWB, t.d.cp_cont_f, 1);
            av.c(this.fWC, t.d.cp_cont_c, 1);
            av.k(this.fWD, t.f.item_person_header_attention_bg_selector);
            av.c(this.fWE, t.d.cp_cont_f, 1);
            av.c(this.fWF, t.d.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(t.j.person_privacy_toast), ba.cT(i)), t.f.icon_toast_game_error).tf();
    }

    public void lA(boolean z) {
        if (this.fWy != null) {
            if (z) {
                this.fWy.setVisibility(0);
            } else {
                this.fWy.setVisibility(8);
            }
        }
    }
}
