package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aTm;
    private View bnn;
    private TextView cXh;
    private TextView cXi;
    private PraiseData cXj;
    private boolean cnq;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cnq = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnq = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bnn = View.inflate(this.mContext, i.g.frs_item_praise, this);
        this.aTm = (TextView) this.bnn.findViewById(i.f.frs_go_praise_list_num);
        this.cXh = (TextView) this.bnn.findViewById(i.f.frs_praise_user_name_text1);
        this.cXi = (TextView) this.bnn.findViewById(i.f.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.cXi.setOnClickListener(new j(this));
        this.cXh.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cXj = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cnq = z;
    }

    private void fresh(boolean z) {
        long num = this.cXj.getNum();
        this.cXi.setVisibility(8);
        this.cXh.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cXj.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cXh.setVisibility(0);
                        this.cXh.setText(lr(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cXh.setVisibility(0);
                        this.cXh.setText(lr(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cXi.setVisibility(0);
                        this.cXi.setText("、" + lr(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aTm.setText(this.mContext.getString(i.h.common_praise_view_text));
            } else if (num <= 999999) {
                this.aTm.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + num + this.mContext.getString(i.h.common_praise_view_text2));
            } else {
                this.aTm.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + "999999+" + this.mContext.getString(i.h.common_praise_view_text2));
            }
        }
    }

    private String lr(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cP(int i) {
        if (this.cnq) {
            an.i(this.bnn, i.e.praise_head_selector);
            an.b(this.aTm, i.c.cp_cont_d, 1);
            an.b(this.cXh, i.c.cp_cont_c, 1);
            an.b(this.cXi, i.c.cp_cont_c, 1);
            return;
        }
        an.i(this.bnn, i.e.praise_view_btn_color);
        an.b(this.aTm, i.c.cp_cont_d, 1);
        an.b(this.cXh, i.c.cp_cont_c, 1);
        an.b(this.cXi, i.c.cp_cont_c, 1);
    }
}
