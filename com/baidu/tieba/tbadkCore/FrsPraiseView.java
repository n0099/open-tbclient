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
    private View ckf;
    private boolean ezi;
    private PraiseData fzA;
    private boolean fzB;
    private TextView fzy;
    private TextView fzz;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ezi = false;
        this.fzB = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezi = false;
        this.fzB = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ckf = View.inflate(this.mContext, w.j.frs_item_praise, this);
        this.alx = (TextView) this.ckf.findViewById(w.h.frs_go_praise_list_num);
        this.fzy = (TextView) this.ckf.findViewById(w.h.frs_praise_user_name_text1);
        this.fzz = (TextView) this.ckf.findViewById(w.h.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.fzz.setOnClickListener(new j(this));
        this.fzy.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fzA = praiseData;
            lm(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ezi = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fzB = z;
    }

    private void lm(boolean z) {
        long num = this.fzA.getNum();
        this.fzz.setVisibility(8);
        this.fzy.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fzA.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fzy.setVisibility(0);
                        this.fzy.setText(pZ(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fzy.setVisibility(0);
                        this.fzy.setText(pZ(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fzz.setVisibility(0);
                        this.fzz.setText("、" + pZ(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.alx.setText(this.mContext.getString(w.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.alx.setText(String.valueOf(this.mContext.getString(w.l.etc)) + num + this.mContext.getString(w.l.common_praise_view_text2));
            } else {
                this.alx.setText(String.valueOf(this.mContext.getString(w.l.etc)) + "999999+" + this.mContext.getString(w.l.common_praise_view_text2));
            }
        }
    }

    private String pZ(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dn(int i) {
        if (this.ezi) {
            if (this.fzB) {
                aq.j(this.ckf, w.g.praise_video_selector);
                aq.c(this.alx, w.e.cp_cont_c, 1);
                aq.c(this.fzy, w.e.cp_link_tip_c, 1);
                aq.c(this.fzz, w.e.cp_link_tip_c, 1);
                return;
            }
            aq.j(this.ckf, w.g.praise_head_selector);
            aq.c(this.alx, w.e.cp_cont_d, 1);
            aq.c(this.fzy, w.e.cp_link_tip_c, 1);
            aq.c(this.fzz, w.e.cp_link_tip_c, 1);
            return;
        }
        aq.j(this.ckf, w.g.praise_view_btn_color);
        aq.c(this.alx, w.e.cp_cont_d, 1);
        aq.c(this.fzy, w.e.cp_cont_c, 1);
        aq.c(this.fzz, w.e.cp_cont_c, 1);
    }
}
