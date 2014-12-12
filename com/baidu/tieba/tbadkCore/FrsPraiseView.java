package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aBr;
    private View aNd;
    private TextView bSA;
    private TextView bSB;
    private PraiseData bSC;
    private boolean bSD;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.bSD = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSD = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aNd = View.inflate(this.mContext, com.baidu.tieba.x.frs_item_praise, this);
        this.aBr = (TextView) this.aNd.findViewById(com.baidu.tieba.w.frs_go_praise_list_num);
        this.bSA = (TextView) this.aNd.findViewById(com.baidu.tieba.w.frs_praise_user_name_text1);
        this.bSB = (TextView) this.aNd.findViewById(com.baidu.tieba.w.frs_praise_user_name_text2);
        setOnClickListener(new q(this));
        this.bSB.setOnClickListener(new r(this));
        this.bSA.setOnClickListener(new s(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.bSC = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.bSD = z;
    }

    private void fresh(boolean z) {
        long num = this.bSC.getNum();
        this.bSB.setVisibility(8);
        this.bSA.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.bSC.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.bSA.setVisibility(0);
                        this.bSA.setText(hV(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.bSA.setVisibility(0);
                        this.bSA.setText(hV(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.bSB.setVisibility(0);
                        this.bSB.setText("、" + hV(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aBr.setText(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text));
            } else if (num <= 999999) {
                this.aBr.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.z.common_praise_view_text2));
            } else {
                this.aBr.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.z.common_praise_view_text2));
            }
        }
    }

    private String hV(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cm(int i) {
        if (this.bSD) {
            ax.i(this.aNd, com.baidu.tieba.v.praise_head_selector);
            ax.b(this.aBr, com.baidu.tieba.t.cp_cont_d, 1);
            ax.b(this.bSA, com.baidu.tieba.t.cp_cont_c, 1);
            ax.b(this.bSB, com.baidu.tieba.t.cp_cont_c, 1);
            return;
        }
        ax.i(this.aNd, com.baidu.tieba.v.praise_view_btn_color);
        ax.b(this.aBr, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bSA, com.baidu.tieba.t.cp_cont_c, 1);
        ax.b(this.bSB, com.baidu.tieba.t.cp_cont_c, 1);
    }
}
