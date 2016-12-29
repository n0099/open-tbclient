package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView agS;
    private View bSl;
    private boolean ejv;
    private TextView fdJ;
    private TextView fdK;
    private PraiseData fdL;
    private boolean fdM;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ejv = false;
        this.fdM = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejv = false;
        this.fdM = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSl = View.inflate(this.mContext, r.h.frs_item_praise, this);
        this.agS = (TextView) this.bSl.findViewById(r.g.frs_go_praise_list_num);
        this.fdJ = (TextView) this.bSl.findViewById(r.g.frs_praise_user_name_text1);
        this.fdK = (TextView) this.bSl.findViewById(r.g.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fdK.setOnClickListener(new j(this));
        this.fdJ.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fdL = praiseData;
            kP(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ejv = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fdM = z;
    }

    private void kP(boolean z) {
        long num = this.fdL.getNum();
        this.fdK.setVisibility(8);
        this.fdJ.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fdL.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fdJ.setVisibility(0);
                        this.fdJ.setText(pS(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fdJ.setVisibility(0);
                        this.fdJ.setText(pS(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fdK.setVisibility(0);
                        this.fdK.setText("、" + pS(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.agS.setText(this.mContext.getString(r.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.agS.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + num + this.mContext.getString(r.j.common_praise_view_text2));
            } else {
                this.agS.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(r.j.common_praise_view_text2));
            }
        }
    }

    private String pS(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* renamed from: do  reason: not valid java name */
    public void m24do(int i) {
        if (this.ejv) {
            if (this.fdM) {
                ar.k(this.bSl, r.f.praise_video_selector);
                ar.c(this.agS, r.d.cp_cont_c, 1);
                ar.c(this.fdJ, r.d.cp_link_tip_c, 1);
                ar.c(this.fdK, r.d.cp_link_tip_c, 1);
                return;
            }
            ar.k(this.bSl, r.f.praise_head_selector);
            ar.c(this.agS, r.d.cp_cont_d, 1);
            ar.c(this.fdJ, r.d.cp_link_tip_c, 1);
            ar.c(this.fdK, r.d.cp_link_tip_c, 1);
            return;
        }
        ar.k(this.bSl, r.f.praise_view_btn_color);
        ar.c(this.agS, r.d.cp_cont_d, 1);
        ar.c(this.fdJ, r.d.cp_cont_c, 1);
        ar.c(this.fdK, r.d.cp_cont_c, 1);
    }
}
