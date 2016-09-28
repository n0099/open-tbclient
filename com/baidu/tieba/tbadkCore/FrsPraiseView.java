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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView agZ;
    private View chU;
    private boolean eyJ;
    private PraiseData fsA;
    private boolean fsB;
    private TextView fsy;
    private TextView fsz;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eyJ = false;
        this.fsB = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyJ = false;
        this.fsB = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.chU = View.inflate(this.mContext, r.h.frs_item_praise, this);
        this.agZ = (TextView) this.chU.findViewById(r.g.frs_go_praise_list_num);
        this.fsy = (TextView) this.chU.findViewById(r.g.frs_praise_user_name_text1);
        this.fsz = (TextView) this.chU.findViewById(r.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.fsz.setOnClickListener(new k(this));
        this.fsy.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.fsA = praiseData;
            kI(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eyJ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.fsB = z;
    }

    private void kI(boolean z) {
        long num = this.fsA.getNum();
        this.fsz.setVisibility(8);
        this.fsy.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.fsA.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.fsy.setVisibility(0);
                        this.fsy.setText(qU(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.fsy.setVisibility(0);
                        this.fsy.setText(qU(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.fsz.setVisibility(0);
                        this.fsz.setText("、" + qU(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.agZ.setText(this.mContext.getString(r.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.agZ.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + num + this.mContext.getString(r.j.common_praise_view_text2));
            } else {
                this.agZ.setText(String.valueOf(this.mContext.getString(r.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(r.j.common_praise_view_text2));
            }
        }
    }

    private String qU(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dl(int i) {
        if (this.eyJ) {
            if (this.fsB) {
                av.k(this.chU, r.f.praise_video_selector);
                av.c(this.agZ, r.d.cp_cont_c, 1);
                av.c(this.fsy, r.d.cp_link_tip_c, 1);
                av.c(this.fsz, r.d.cp_link_tip_c, 1);
                return;
            }
            av.k(this.chU, r.f.praise_head_selector);
            av.c(this.agZ, r.d.cp_cont_d, 1);
            av.c(this.fsy, r.d.cp_link_tip_c, 1);
            av.c(this.fsz, r.d.cp_link_tip_c, 1);
            return;
        }
        av.k(this.chU, r.f.praise_view_btn_color);
        av.c(this.agZ, r.d.cp_cont_d, 1);
        av.c(this.fsy, r.d.cp_cont_c, 1);
        av.c(this.fsz, r.d.cp_cont_c, 1);
    }
}
