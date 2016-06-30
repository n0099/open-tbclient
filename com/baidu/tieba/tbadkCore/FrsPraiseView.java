package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView adH;
    private View bUM;
    private boolean dXR;
    private TextView eVc;
    private TextView eVd;
    private PraiseData eVe;
    private boolean eVf;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.dXR = false;
        this.eVf = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXR = false;
        this.eVf = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bUM = View.inflate(this.mContext, u.h.frs_item_praise, this);
        this.adH = (TextView) this.bUM.findViewById(u.g.frs_go_praise_list_num);
        this.eVc = (TextView) this.bUM.findViewById(u.g.frs_praise_user_name_text1);
        this.eVd = (TextView) this.bUM.findViewById(u.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.eVd.setOnClickListener(new k(this));
        this.eVc.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.eVe = praiseData;
            kf(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.dXR = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.eVf = z;
    }

    private void kf(boolean z) {
        long num = this.eVe.getNum();
        this.eVd.setVisibility(8);
        this.eVc.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.eVe.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.eVc.setVisibility(0);
                        this.eVc.setText(pm(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.eVc.setVisibility(0);
                        this.eVc.setText(pm(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.eVd.setVisibility(0);
                        this.eVd.setText("、" + pm(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.adH.setText(this.mContext.getString(u.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.adH.setText(String.valueOf(this.mContext.getString(u.j.common_praise_view_text1)) + num + this.mContext.getString(u.j.common_praise_view_text2));
            } else {
                this.adH.setText(String.valueOf(this.mContext.getString(u.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(u.j.common_praise_view_text2));
            }
        }
    }

    private String pm(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cX(int i) {
        if (this.dXR) {
            if (this.eVf) {
                av.k(this.bUM, u.f.praise_video_selector);
                av.c(this.adH, u.d.cp_cont_c, 1);
                av.c(this.eVc, u.d.cp_link_tip_c, 1);
                av.c(this.eVd, u.d.cp_link_tip_c, 1);
                return;
            }
            av.k(this.bUM, u.f.praise_head_selector);
            av.c(this.adH, u.d.cp_cont_d, 1);
            av.c(this.eVc, u.d.cp_link_tip_c, 1);
            av.c(this.eVd, u.d.cp_link_tip_c, 1);
            return;
        }
        av.k(this.bUM, u.f.praise_view_btn_color);
        av.c(this.adH, u.d.cp_cont_d, 1);
        av.c(this.eVc, u.d.cp_cont_c, 1);
        av.c(this.eVd, u.d.cp_cont_c, 1);
    }
}
