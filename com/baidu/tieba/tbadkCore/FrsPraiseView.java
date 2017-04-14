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
    private View ceE;
    private boolean etY;
    private TextView ftn;
    private TextView fto;
    private PraiseData ftp;
    private boolean ftq;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.etY = false;
        this.ftq = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etY = false;
        this.ftq = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ceE = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.alL = (TextView) this.ceE.findViewById(w.h.frs_go_praise_list_num);
        this.ftn = (TextView) this.ceE.findViewById(w.h.frs_praise_user_name_text1);
        this.fto = (TextView) this.ceE.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fto.setOnClickListener(new j(this));
        this.ftn.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.ftp = praiseData;
            lc(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.etY = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.ftq = z;
    }

    private void lc(boolean z) {
        long num = this.ftp.getNum();
        this.fto.setVisibility(8);
        this.ftn.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.ftp.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.ftn.setVisibility(0);
                        this.ftn.setText(pM(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.ftn.setVisibility(0);
                        this.ftn.setText(pM(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fto.setVisibility(0);
                        this.fto.setText("、" + pM(user.get(1).getName_show()));
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

    private String pM(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* renamed from: do  reason: not valid java name */
    public void m26do(int i) {
        if (this.etY) {
            if (this.ftq) {
                aq.j(this.ceE, w.g.praise_video_selector);
                aq.c(this.alL, w.e.cp_cont_c, 1);
                aq.c(this.ftn, w.e.cp_link_tip_c, 1);
                aq.c(this.fto, w.e.cp_link_tip_c, 1);
                return;
            }
            aq.j(this.ceE, w.g.praise_head_selector);
            aq.c(this.alL, w.e.cp_cont_d, 1);
            aq.c(this.ftn, w.e.cp_link_tip_c, 1);
            aq.c(this.fto, w.e.cp_link_tip_c, 1);
            return;
        }
        aq.j(this.ceE, w.g.praise_view_btn_color);
        aq.c(this.alL, w.e.cp_cont_d, 1);
        aq.c(this.ftn, w.e.cp_cont_c, 1);
        aq.c(this.fto, w.e.cp_cont_c, 1);
    }
}
