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
    private TextView aev;
    private View bWM;
    private boolean ekt;
    private TextView fia;
    private TextView fib;
    private PraiseData fic;
    private boolean fie;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ekt = false;
        this.fie = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekt = false;
        this.fie = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bWM = View.inflate(this.mContext, u.h.frs_item_praise, this);
        this.aev = (TextView) this.bWM.findViewById(u.g.frs_go_praise_list_num);
        this.fia = (TextView) this.bWM.findViewById(u.g.frs_praise_user_name_text1);
        this.fib = (TextView) this.bWM.findViewById(u.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.fib.setOnClickListener(new k(this));
        this.fia.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fic = praiseData;
            kt(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ekt = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fie = z;
    }

    private void kt(boolean z) {
        long num = this.fic.getNum();
        this.fib.setVisibility(8);
        this.fia.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fic.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fia.setVisibility(0);
                        this.fia.setText(pW(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fia.setVisibility(0);
                        this.fia.setText(pW(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fib.setVisibility(0);
                        this.fib.setText("、" + pW(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aev.setText(this.mContext.getString(u.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.aev.setText(String.valueOf(this.mContext.getString(u.j.common_praise_view_text1)) + num + this.mContext.getString(u.j.common_praise_view_text2));
            } else {
                this.aev.setText(String.valueOf(this.mContext.getString(u.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(u.j.common_praise_view_text2));
            }
        }
    }

    private String pW(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cX(int i) {
        if (this.ekt) {
            if (this.fie) {
                av.k(this.bWM, u.f.praise_video_selector);
                av.c(this.aev, u.d.cp_cont_c, 1);
                av.c(this.fia, u.d.cp_link_tip_c, 1);
                av.c(this.fib, u.d.cp_link_tip_c, 1);
                return;
            }
            av.k(this.bWM, u.f.praise_head_selector);
            av.c(this.aev, u.d.cp_cont_d, 1);
            av.c(this.fia, u.d.cp_link_tip_c, 1);
            av.c(this.fib, u.d.cp_link_tip_c, 1);
            return;
        }
        av.k(this.bWM, u.f.praise_view_btn_color);
        av.c(this.aev, u.d.cp_cont_d, 1);
        av.c(this.fia, u.d.cp_cont_c, 1);
        av.c(this.fib, u.d.cp_cont_c, 1);
    }
}
