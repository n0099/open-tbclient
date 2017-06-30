package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aml;
    private View crW;
    private boolean eIE;
    private TextView fJC;
    private TextView fJD;
    private PraiseData fJE;
    private boolean fJF;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eIE = false;
        this.fJF = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIE = false;
        this.fJF = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.crW = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.aml = (TextView) this.crW.findViewById(w.h.frs_go_praise_list_num);
        this.fJC = (TextView) this.crW.findViewById(w.h.frs_praise_user_name_text1);
        this.fJD = (TextView) this.crW.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fJD.setOnClickListener(new j(this));
        this.fJC.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fJE = praiseData;
            lL(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eIE = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fJF = z;
    }

    private void lL(boolean z) {
        long num = this.fJE.getNum();
        this.fJD.setVisibility(8);
        this.fJC.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fJE.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fJC.setVisibility(0);
                        this.fJC.setText(qX(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fJC.setVisibility(0);
                        this.fJC.setText(qX(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fJD.setVisibility(0);
                        this.fJD.setText("、" + qX(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aml.setText(this.mContext.getString(w.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.aml.setText(String.valueOf(this.mContext.getString(w.l.etc)) + num + this.mContext.getString(w.l.common_praise_view_text2));
            } else {
                this.aml.setText(String.valueOf(this.mContext.getString(w.l.etc)) + "999999+" + this.mContext.getString(w.l.common_praise_view_text2));
            }
        }
    }

    private String qX(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dp(int i) {
        if (this.eIE) {
            if (this.fJF) {
                as.j(this.crW, w.g.praise_video_selector);
                as.c(this.aml, w.e.cp_cont_c, 1);
                as.c(this.fJC, w.e.cp_link_tip_c, 1);
                as.c(this.fJD, w.e.cp_link_tip_c, 1);
                return;
            }
            as.j(this.crW, w.g.praise_head_selector);
            as.c(this.aml, w.e.cp_cont_d, 1);
            as.c(this.fJC, w.e.cp_link_tip_c, 1);
            as.c(this.fJD, w.e.cp_link_tip_c, 1);
            return;
        }
        as.j(this.crW, w.g.praise_view_btn_color);
        as.c(this.aml, w.e.cp_cont_d, 1);
        as.c(this.fJC, w.e.cp_cont_c, 1);
        as.c(this.fJD, w.e.cp_cont_c, 1);
    }
}
