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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView ahz;
    private View cnb;
    private boolean eFv;
    private TextView fzI;
    private TextView fzJ;
    private PraiseData fzK;
    private boolean fzL;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eFv = false;
        this.fzL = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFv = false;
        this.fzL = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cnb = View.inflate(this.mContext, r.h.frs_item_praise, this);
        this.ahz = (TextView) this.cnb.findViewById(r.g.frs_go_praise_list_num);
        this.fzI = (TextView) this.cnb.findViewById(r.g.frs_praise_user_name_text1);
        this.fzJ = (TextView) this.cnb.findViewById(r.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.fzJ.setOnClickListener(new k(this));
        this.fzI.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fzK = praiseData;
            lg(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eFv = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fzL = z;
    }

    private void lg(boolean z) {
        long num = this.fzK.getNum();
        this.fzJ.setVisibility(8);
        this.fzI.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fzK.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fzI.setVisibility(0);
                        this.fzI.setText(ro(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fzI.setVisibility(0);
                        this.fzI.setText(ro(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fzJ.setVisibility(0);
                        this.fzJ.setText("、" + ro(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ahz.setText(this.mContext.getString(r.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ahz.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + num + this.mContext.getString(r.j.common_praise_view_text2));
            } else {
                this.ahz.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(r.j.common_praise_view_text2));
            }
        }
    }

    private String ro(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dm(int i) {
        if (this.eFv) {
            if (this.fzL) {
                at.k(this.cnb, r.f.praise_video_selector);
                at.c(this.ahz, r.d.cp_cont_c, 1);
                at.c(this.fzI, r.d.cp_link_tip_c, 1);
                at.c(this.fzJ, r.d.cp_link_tip_c, 1);
                return;
            }
            at.k(this.cnb, r.f.praise_head_selector);
            at.c(this.ahz, r.d.cp_cont_d, 1);
            at.c(this.fzI, r.d.cp_link_tip_c, 1);
            at.c(this.fzJ, r.d.cp_link_tip_c, 1);
            return;
        }
        at.k(this.cnb, r.f.praise_view_btn_color);
        at.c(this.ahz, r.d.cp_cont_d, 1);
        at.c(this.fzI, r.d.cp_cont_c, 1);
        at.c(this.fzJ, r.d.cp_cont_c, 1);
    }
}
