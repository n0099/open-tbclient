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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView ahq;
    private View chW;
    private boolean ewB;
    private TextView fpS;
    private TextView fpT;
    private PraiseData fpU;
    private boolean fpV;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ewB = false;
        this.fpV = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewB = false;
        this.fpV = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.chW = View.inflate(this.mContext, t.h.frs_item_praise, this);
        this.ahq = (TextView) this.chW.findViewById(t.g.frs_go_praise_list_num);
        this.fpS = (TextView) this.chW.findViewById(t.g.frs_praise_user_name_text1);
        this.fpT = (TextView) this.chW.findViewById(t.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.fpT.setOnClickListener(new k(this));
        this.fpS.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fpU = praiseData;
            kF(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ewB = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fpV = z;
    }

    private void kF(boolean z) {
        long num = this.fpU.getNum();
        this.fpT.setVisibility(8);
        this.fpS.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fpU.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fpS.setVisibility(0);
                        this.fpS.setText(qG(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fpS.setVisibility(0);
                        this.fpS.setText(qG(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fpT.setVisibility(0);
                        this.fpT.setText("、" + qG(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ahq.setText(this.mContext.getString(t.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ahq.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + num + this.mContext.getString(t.j.common_praise_view_text2));
            } else {
                this.ahq.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(t.j.common_praise_view_text2));
            }
        }
    }

    private String qG(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dl(int i) {
        if (this.ewB) {
            if (this.fpV) {
                av.k(this.chW, t.f.praise_video_selector);
                av.c(this.ahq, t.d.cp_cont_c, 1);
                av.c(this.fpS, t.d.cp_link_tip_c, 1);
                av.c(this.fpT, t.d.cp_link_tip_c, 1);
                return;
            }
            av.k(this.chW, t.f.praise_head_selector);
            av.c(this.ahq, t.d.cp_cont_d, 1);
            av.c(this.fpS, t.d.cp_link_tip_c, 1);
            av.c(this.fpT, t.d.cp_link_tip_c, 1);
            return;
        }
        av.k(this.chW, t.f.praise_view_btn_color);
        av.c(this.ahq, t.d.cp_cont_d, 1);
        av.c(this.fpS, t.d.cp_cont_c, 1);
        av.c(this.fpT, t.d.cp_cont_c, 1);
    }
}
