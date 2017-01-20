package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView agf;
    private View bYI;
    private boolean esF;
    private TextView fne;
    private TextView fnf;
    private PraiseData fng;
    private boolean fnh;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.esF = false;
        this.fnh = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esF = false;
        this.fnh = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bYI = View.inflate(this.mContext, r.j.frs_item_praise, this);
        this.agf = (TextView) this.bYI.findViewById(r.h.frs_go_praise_list_num);
        this.fne = (TextView) this.bYI.findViewById(r.h.frs_praise_user_name_text1);
        this.fnf = (TextView) this.bYI.findViewById(r.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fnf.setOnClickListener(new j(this));
        this.fne.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fng = praiseData;
            lb(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.esF = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fnh = z;
    }

    private void lb(boolean z) {
        long num = this.fng.getNum();
        this.fnf.setVisibility(8);
        this.fne.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fng.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fne.setVisibility(0);
                        this.fne.setText(qm(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fne.setVisibility(0);
                        this.fne.setText(qm(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fnf.setVisibility(0);
                        this.fnf.setText("、" + qm(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.agf.setText(this.mContext.getString(r.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.agf.setText(String.valueOf(this.mContext.getString(r.l.common_praise_view_text1)) + num + this.mContext.getString(r.l.common_praise_view_text2));
            } else {
                this.agf.setText(String.valueOf(this.mContext.getString(r.l.common_praise_view_text1)) + "999999+" + this.mContext.getString(r.l.common_praise_view_text2));
            }
        }
    }

    private String qm(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dp(int i) {
        if (this.esF) {
            if (this.fnh) {
                ap.j(this.bYI, r.g.praise_video_selector);
                ap.c(this.agf, r.e.cp_cont_c, 1);
                ap.c(this.fne, r.e.cp_link_tip_c, 1);
                ap.c(this.fnf, r.e.cp_link_tip_c, 1);
                return;
            }
            ap.j(this.bYI, r.g.praise_head_selector);
            ap.c(this.agf, r.e.cp_cont_d, 1);
            ap.c(this.fne, r.e.cp_link_tip_c, 1);
            ap.c(this.fnf, r.e.cp_link_tip_c, 1);
            return;
        }
        ap.j(this.bYI, r.g.praise_view_btn_color);
        ap.c(this.agf, r.e.cp_cont_d, 1);
        ap.c(this.fne, r.e.cp_cont_c, 1);
        ap.c(this.fnf, r.e.cp_cont_c, 1);
    }
}
