package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView adj;
    private View bxh;
    private boolean drg;
    private TextView eqs;
    private TextView eqt;
    private PraiseData equ;
    private boolean eqv;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.drg = false;
        this.eqv = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drg = false;
        this.eqv = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bxh = View.inflate(this.mContext, t.h.frs_item_praise, this);
        this.adj = (TextView) this.bxh.findViewById(t.g.frs_go_praise_list_num);
        this.eqs = (TextView) this.bxh.findViewById(t.g.frs_praise_user_name_text1);
        this.eqt = (TextView) this.bxh.findViewById(t.g.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.eqt.setOnClickListener(new j(this));
        this.eqs.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.equ = praiseData;
            ju(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.drg = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.eqv = z;
    }

    private void ju(boolean z) {
        long num = this.equ.getNum();
        this.eqt.setVisibility(8);
        this.eqs.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.equ.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.eqs.setVisibility(0);
                        this.eqs.setText(nH(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.eqs.setVisibility(0);
                        this.eqs.setText(nH(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.eqt.setVisibility(0);
                        this.eqt.setText("、" + nH(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.adj.setText(this.mContext.getString(t.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.adj.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + num + this.mContext.getString(t.j.common_praise_view_text2));
            } else {
                this.adj.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(t.j.common_praise_view_text2));
            }
        }
    }

    private String nH(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cV(int i) {
        if (this.drg) {
            if (this.eqv) {
                at.k(this.bxh, t.f.praise_video_selector);
                at.c(this.adj, t.d.cp_cont_c, 1);
                at.c(this.eqs, t.d.cp_link_tip_c, 1);
                at.c(this.eqt, t.d.cp_link_tip_c, 1);
                return;
            }
            at.k(this.bxh, t.f.praise_head_selector);
            at.c(this.adj, t.d.cp_cont_d, 1);
            at.c(this.eqs, t.d.cp_link_tip_c, 1);
            at.c(this.eqt, t.d.cp_link_tip_c, 1);
            return;
        }
        at.k(this.bxh, t.f.praise_view_btn_color);
        at.c(this.adj, t.d.cp_cont_d, 1);
        at.c(this.eqs, t.d.cp_cont_c, 1);
        at.c(this.eqt, t.d.cp_cont_c, 1);
    }
}
