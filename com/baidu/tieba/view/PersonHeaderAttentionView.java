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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private TextView aPt;
    private View.OnClickListener bdP;
    private m eFl;
    private TextView fYA;
    private TextView fYB;
    private View fYC;
    private ImageView fYD;
    private TextView fYE;
    private View fYF;
    private TextView fYG;
    private TextView fYH;
    private View fYI;
    private TextView fYJ;
    private TextView fYK;
    private View fYz;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bdP = new s(this);
        init(context);
        bqW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bdP = new s(this);
        init(context);
        bqW();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bdP = new s(this);
        init(context);
        bqW();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(r.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fYz = findViewById(r.g.person_header_attention_container);
        this.fYA = (TextView) findViewById(r.g.person_header_attention_num);
        this.fYB = (TextView) findViewById(r.g.person_header_attention_des);
        this.fYC = findViewById(r.g.person_header_fans_container);
        this.aPt = (TextView) findViewById(r.g.person_header_fans_num);
        this.fYD = (ImageView) findViewById(r.g.person_header_fans_red_tip);
        this.fYE = (TextView) findViewById(r.g.person_header_fans_des);
        this.fYF = findViewById(r.g.person_header_post_container);
        this.fYG = (TextView) findViewById(r.g.person_header_post_num);
        this.fYH = (TextView) findViewById(r.g.person_header_post_des);
        this.fYI = findViewById(r.g.person_header_bar_container);
        this.fYJ = (TextView) findViewById(r.g.person_header_bar_num);
        this.fYK = (TextView) findViewById(r.g.person_header_bar_des);
    }

    private void bqW() {
        this.fYz.setOnClickListener(this.bdP);
        this.fYC.setOnClickListener(this.bdP);
        this.fYF.setOnClickListener(this.bdP);
        this.fYI.setOnClickListener(this.bdP);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eFl = mVar;
    }

    private void n(String str, String str2, String str3, String str4) {
        this.fYA.setText(str);
        this.aPt.setText(str2);
        this.fYG.setText(str3);
        this.fYJ.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.fYA.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.aPt.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.fYG.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.fYJ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        n(az.A(this.mUserData.getConcernNum()), az.A(this.mUserData.getFansNum()), az.A(this.mUserData.getPosts_num()), az.A(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            av.k(this.fYz, r.f.item_person_header_attention_bg_selector);
            av.c(this.fYA, r.d.cp_cont_f, 1);
            av.c(this.fYB, r.d.cp_cont_c, 1);
            av.k(this.fYC, r.f.item_person_header_attention_bg_selector);
            av.c(this.aPt, r.d.cp_cont_f, 1);
            av.c(this.fYE, r.d.cp_cont_c, 1);
            av.c(this.fYD, r.f.icon_news_down_bar_one);
            av.k(this.fYF, r.f.item_person_header_attention_bg_selector);
            av.c(this.fYG, r.d.cp_cont_f, 1);
            av.c(this.fYH, r.d.cp_cont_c, 1);
            av.k(this.fYI, r.f.item_person_header_attention_bg_selector);
            av.c(this.fYJ, r.d.cp_cont_f, 1);
            av.c(this.fYK, r.d.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(r.j.person_privacy_toast), az.cT(i)), r.f.icon_toast_game_error).tu();
    }

    public void lC(boolean z) {
        if (this.fYD != null) {
            if (z) {
                this.fYD.setVisibility(0);
            } else {
                this.fYD.setVisibility(8);
            }
        }
    }
}
