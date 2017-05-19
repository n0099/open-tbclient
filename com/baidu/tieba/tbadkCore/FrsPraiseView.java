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
    private TextView alH;
    private View cdR;
    private boolean erW;
    private TextView frI;
    private TextView frJ;
    private PraiseData frK;
    private boolean frL;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.erW = false;
        this.frL = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erW = false;
        this.frL = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cdR = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.alH = (TextView) this.cdR.findViewById(w.h.frs_go_praise_list_num);
        this.frI = (TextView) this.cdR.findViewById(w.h.frs_praise_user_name_text1);
        this.frJ = (TextView) this.cdR.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.frJ.setOnClickListener(new j(this));
        this.frI.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.frK = praiseData;
            kS(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.erW = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.frL = z;
    }

    private void kS(boolean z) {
        long num = this.frK.getNum();
        this.frJ.setVisibility(8);
        this.frI.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.frK.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.frI.setVisibility(0);
                        this.frI.setText(pL(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.frI.setVisibility(0);
                        this.frI.setText(pL(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.frJ.setVisibility(0);
                        this.frJ.setText("、" + pL(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.alH.setText(this.mContext.getString(w.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.alH.setText(String.valueOf(this.mContext.getString(w.l.etc)) + num + this.mContext.getString(w.l.common_praise_view_text2));
            } else {
                this.alH.setText(String.valueOf(this.mContext.getString(w.l.etc)) + "999999+" + this.mContext.getString(w.l.common_praise_view_text2));
            }
        }
    }

    private String pL(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dm(int i) {
        if (this.erW) {
            if (this.frL) {
                aq.j(this.cdR, w.g.praise_video_selector);
                aq.c(this.alH, w.e.cp_cont_c, 1);
                aq.c(this.frI, w.e.cp_link_tip_c, 1);
                aq.c(this.frJ, w.e.cp_link_tip_c, 1);
                return;
            }
            aq.j(this.cdR, w.g.praise_head_selector);
            aq.c(this.alH, w.e.cp_cont_d, 1);
            aq.c(this.frI, w.e.cp_link_tip_c, 1);
            aq.c(this.frJ, w.e.cp_link_tip_c, 1);
            return;
        }
        aq.j(this.cdR, w.g.praise_view_btn_color);
        aq.c(this.alH, w.e.cp_cont_d, 1);
        aq.c(this.frI, w.e.cp_cont_c, 1);
        aq.c(this.frJ, w.e.cp_cont_c, 1);
    }
}
