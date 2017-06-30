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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements p {
    private View.OnClickListener boh;
    private TextView ddI;
    private r eRa;
    private View gaJ;
    private TextView gaK;
    private TextView gaL;
    private View gaM;
    private ImageView gaN;
    private TextView gaO;
    private View gaP;
    private TextView gaQ;
    private TextView gaR;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.boh = new w(this);
        init(context);
        Vg();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.boh = new w(this);
        init(context);
        Vg();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.boh = new w(this);
        init(context);
        Vg();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(w.j.item_person_header_attention_view, (ViewGroup) this, true);
        this.gaJ = findViewById(w.h.person_header_attention_container);
        this.gaK = (TextView) findViewById(w.h.person_header_attention_num);
        this.gaL = (TextView) findViewById(w.h.person_header_attention_des);
        this.gaM = findViewById(w.h.person_header_fans_container);
        this.ddI = (TextView) findViewById(w.h.person_header_fans_num);
        this.gaN = (ImageView) findViewById(w.h.person_header_fans_red_tip);
        this.gaO = (TextView) findViewById(w.h.person_header_fans_des);
        this.gaP = findViewById(w.h.person_header_bar_container);
        this.gaQ = (TextView) findViewById(w.h.person_header_bar_num);
        this.gaR = (TextView) findViewById(w.h.person_header_bar_des);
    }

    private void Vg() {
        this.gaJ.setOnClickListener(this.boh);
        this.gaM.setOnClickListener(this.boh);
        this.gaP.setOnClickListener(this.boh);
    }

    @Override // com.baidu.tieba.view.p
    public void setOnViewResponseListener(r rVar) {
        this.eRa = rVar;
    }

    private void m(String str, String str2, String str3, String str4) {
        this.gaK.setText(str);
        this.ddI.setText(str2);
        this.gaQ.setText(str4);
    }

    @Override // com.baidu.tieba.view.p
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.gaK.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.ddI.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.gaQ.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        }
        m(aw.z(this.mUserData.getConcernNum()), aw.z(this.mUserData.getFansNum()), aw.z(this.mUserData.getPosts_num()), aw.z(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.p
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            as.c(this.gaK, w.e.cp_cont_i, 1);
            as.c(this.gaL, w.e.cp_cont_i_alpha60, 1);
            as.c(this.ddI, w.e.cp_cont_i, 1);
            as.c(this.gaO, w.e.cp_cont_i_alpha60, 1);
            as.c(this.gaN, w.g.icon_news_down_bar_one);
            as.c(this.gaQ, w.e.cp_cont_i, 1);
            as.c(this.gaR, w.e.cp_cont_i_alpha60, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(w.l.person_privacy_toast), aw.cU(i)), w.g.icon_toast_game_error).ti();
    }

    @Override // com.baidu.tieba.view.p
    public void mo(boolean z) {
        if (this.gaN != null) {
            if (z) {
                this.gaN.setVisibility(0);
            } else {
                this.gaN.setVisibility(8);
            }
        }
    }
}
