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
    private TextView alx;
    private View cge;
    private boolean evT;
    private TextView frC;
    private TextView frD;
    private PraiseData frE;
    private boolean frF;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.evT = false;
        this.frF = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evT = false;
        this.frF = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cge = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.alx = (TextView) this.cge.findViewById(w.h.frs_go_praise_list_num);
        this.frC = (TextView) this.cge.findViewById(w.h.frs_praise_user_name_text1);
        this.frD = (TextView) this.cge.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.frD.setOnClickListener(new j(this));
        this.frC.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.frE = praiseData;
            kZ(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.evT = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.frF = z;
    }

    private void kZ(boolean z) {
        long num = this.frE.getNum();
        this.frD.setVisibility(8);
        this.frC.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.frE.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.frC.setVisibility(0);
                        this.frC.setText(pv(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.frC.setVisibility(0);
                        this.frC.setText(pv(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.frD.setVisibility(0);
                        this.frD.setText("、" + pv(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.alx.setText(this.mContext.getString(w.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.alx.setText(String.valueOf(this.mContext.getString(w.l.common_praise_view_text1)) + num + this.mContext.getString(w.l.common_praise_view_text2));
            } else {
                this.alx.setText(String.valueOf(this.mContext.getString(w.l.common_praise_view_text1)) + "999999+" + this.mContext.getString(w.l.common_praise_view_text2));
            }
        }
    }

    private String pv(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dl(int i) {
        if (this.evT) {
            if (this.frF) {
                aq.j(this.cge, w.g.praise_video_selector);
                aq.c(this.alx, w.e.cp_cont_c, 1);
                aq.c(this.frC, w.e.cp_link_tip_c, 1);
                aq.c(this.frD, w.e.cp_link_tip_c, 1);
                return;
            }
            aq.j(this.cge, w.g.praise_head_selector);
            aq.c(this.alx, w.e.cp_cont_d, 1);
            aq.c(this.frC, w.e.cp_link_tip_c, 1);
            aq.c(this.frD, w.e.cp_link_tip_c, 1);
            return;
        }
        aq.j(this.cge, w.g.praise_view_btn_color);
        aq.c(this.alx, w.e.cp_cont_d, 1);
        aq.c(this.frC, w.e.cp_cont_c, 1);
        aq.c(this.frD, w.e.cp_cont_c, 1);
    }
}
