package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aCs;
    private View aOm;
    private TextView bUt;
    private TextView bUu;
    private PraiseData bUv;
    private boolean bUw;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.bUw = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUw = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aOm = View.inflate(this.mContext, com.baidu.tieba.x.frs_item_praise, this);
        this.aCs = (TextView) this.aOm.findViewById(com.baidu.tieba.w.frs_go_praise_list_num);
        this.bUt = (TextView) this.aOm.findViewById(com.baidu.tieba.w.frs_praise_user_name_text1);
        this.bUu = (TextView) this.aOm.findViewById(com.baidu.tieba.w.frs_praise_user_name_text2);
        setOnClickListener(new q(this));
        this.bUu.setOnClickListener(new r(this));
        this.bUt.setOnClickListener(new s(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.bUv = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.bUw = z;
    }

    private void fresh(boolean z) {
        long num = this.bUv.getNum();
        this.bUu.setVisibility(8);
        this.bUt.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.bUv.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.bUt.setVisibility(0);
                        this.bUt.setText(ic(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.bUt.setVisibility(0);
                        this.bUt.setText(ic(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.bUu.setVisibility(0);
                        this.bUu.setText("、" + ic(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aCs.setText(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text));
            } else if (num <= 999999) {
                this.aCs.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.z.common_praise_view_text2));
            } else {
                this.aCs.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.z.common_praise_view_text2));
            }
        }
    }

    private String ic(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void ct(int i) {
        if (this.bUw) {
            bc.i(this.aOm, com.baidu.tieba.v.praise_head_selector);
            bc.b(this.aCs, com.baidu.tieba.t.cp_cont_d, 1);
            bc.b(this.bUt, com.baidu.tieba.t.cp_cont_c, 1);
            bc.b(this.bUu, com.baidu.tieba.t.cp_cont_c, 1);
            return;
        }
        bc.i(this.aOm, com.baidu.tieba.v.praise_view_btn_color);
        bc.b(this.aCs, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bUt, com.baidu.tieba.t.cp_cont_c, 1);
        bc.b(this.bUu, com.baidu.tieba.t.cp_cont_c, 1);
    }
}
