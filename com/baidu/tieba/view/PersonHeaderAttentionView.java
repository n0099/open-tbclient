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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private TextView aRz;
    private View.OnClickListener bgP;
    private m eLK;
    private View gfU;
    private TextView gfV;
    private TextView gfW;
    private View gfX;
    private ImageView gfY;
    private TextView gfZ;
    private View gga;
    private TextView ggb;
    private TextView ggc;
    private View ggd;
    private TextView gge;
    private TextView ggf;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.bgP = new s(this);
        init(context);
        btp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.bgP = new s(this);
        init(context);
        btp();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.bgP = new s(this);
        init(context);
        btp();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(r.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.gfU = findViewById(r.g.person_header_attention_container);
        this.gfV = (TextView) findViewById(r.g.person_header_attention_num);
        this.gfW = (TextView) findViewById(r.g.person_header_attention_des);
        this.gfX = findViewById(r.g.person_header_fans_container);
        this.aRz = (TextView) findViewById(r.g.person_header_fans_num);
        this.gfY = (ImageView) findViewById(r.g.person_header_fans_red_tip);
        this.gfZ = (TextView) findViewById(r.g.person_header_fans_des);
        this.gga = findViewById(r.g.person_header_post_container);
        this.ggb = (TextView) findViewById(r.g.person_header_post_num);
        this.ggc = (TextView) findViewById(r.g.person_header_post_des);
        this.ggd = findViewById(r.g.person_header_bar_container);
        this.gge = (TextView) findViewById(r.g.person_header_bar_num);
        this.ggf = (TextView) findViewById(r.g.person_header_bar_des);
    }

    private void btp() {
        this.gfU.setOnClickListener(this.bgP);
        this.gfX.setOnClickListener(this.bgP);
        this.gga.setOnClickListener(this.bgP);
        this.ggd.setOnClickListener(this.bgP);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eLK = mVar;
    }

    private void n(String str, String str2, String str3, String str4) {
        this.gfV.setText(str);
        this.aRz.setText(str2);
        this.ggb.setText(str3);
        this.gge.setText(str4);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gfV.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.aRz.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ggb.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gge.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32));
        }
        n(ax.z(this.mUserData.getConcernNum()), ax.z(this.mUserData.getFansNum()), ax.z(this.mUserData.getPosts_num()), ax.z(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            at.k(this.gfU, r.f.item_person_header_attention_bg_selector);
            at.c(this.gfV, r.d.cp_cont_f, 1);
            at.c(this.gfW, r.d.cp_cont_c, 1);
            at.k(this.gfX, r.f.item_person_header_attention_bg_selector);
            at.c(this.aRz, r.d.cp_cont_f, 1);
            at.c(this.gfZ, r.d.cp_cont_c, 1);
            at.c(this.gfY, r.f.icon_news_down_bar_one);
            at.k(this.gga, r.f.item_person_header_attention_bg_selector);
            at.c(this.ggb, r.d.cp_cont_f, 1);
            at.c(this.ggc, r.d.cp_cont_c, 1);
            at.k(this.ggd, r.f.item_person_header_attention_bg_selector);
            at.c(this.gge, r.d.cp_cont_f, 1);
            at.c(this.ggf, r.d.cp_cont_c, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(r.j.person_privacy_toast), ax.cU(i)), r.f.icon_toast_game_error).ty();
    }

    public void mb(boolean z) {
        if (this.gfY != null) {
            if (z) {
                this.gfY.setVisibility(0);
            } else {
                this.gfY.setVisibility(8);
            }
        }
    }
}
