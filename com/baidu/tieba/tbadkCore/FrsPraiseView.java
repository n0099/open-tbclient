package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView alL;
    private View cgV;
    private boolean ewo;
    private TextView fvE;
    private TextView fvF;
    private PraiseData fvG;
    private boolean fvH;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ewo = false;
        this.fvH = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewo = false;
        this.fvH = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cgV = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.alL = (TextView) this.cgV.findViewById(w.h.frs_go_praise_list_num);
        this.fvE = (TextView) this.cgV.findViewById(w.h.frs_praise_user_name_text1);
        this.fvF = (TextView) this.cgV.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fvF.setOnClickListener(new j(this));
        this.fvE.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fvG = praiseData;
            lm(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ewo = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fvH = z;
    }

    private void lm(boolean z) {
        long num = this.fvG.getNum();
        this.fvF.setVisibility(8);
        this.fvE.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fvG.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fvE.setVisibility(0);
                        this.fvE.setText(pN(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fvE.setVisibility(0);
                        this.fvE.setText(pN(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fvF.setVisibility(0);
                        this.fvF.setText("、" + pN(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.alL.setText(this.mContext.getString(w.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.alL.setText(String.valueOf(this.mContext.getString(w.l.etc)) + num + this.mContext.getString(w.l.common_praise_view_text2));
            } else {
                this.alL.setText(String.valueOf(this.mContext.getString(w.l.etc)) + "999999+" + this.mContext.getString(w.l.common_praise_view_text2));
            }
        }
    }

    private String pN(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* renamed from: do  reason: not valid java name */
    public void m24do(int i) {
        if (this.ewo) {
            if (this.fvH) {
                aq.j(this.cgV, w.g.praise_video_selector);
                aq.c(this.alL, w.e.cp_cont_c, 1);
                aq.c(this.fvE, w.e.cp_link_tip_c, 1);
                aq.c(this.fvF, w.e.cp_link_tip_c, 1);
                return;
            }
            aq.j(this.cgV, w.g.praise_head_selector);
            aq.c(this.alL, w.e.cp_cont_d, 1);
            aq.c(this.fvE, w.e.cp_link_tip_c, 1);
            aq.c(this.fvF, w.e.cp_link_tip_c, 1);
            return;
        }
        aq.j(this.cgV, w.g.praise_view_btn_color);
        aq.c(this.alL, w.e.cp_cont_d, 1);
        aq.c(this.fvE, w.e.cp_cont_c, 1);
        aq.c(this.fvF, w.e.cp_cont_c, 1);
    }
}
