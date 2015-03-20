package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aIl;
    private View aVn;
    private TextView ckM;
    private TextView ckN;
    private PraiseData ckO;
    private boolean ckP;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ckP = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckP = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aVn = View.inflate(this.mContext, com.baidu.tieba.w.frs_item_praise, this);
        this.aIl = (TextView) this.aVn.findViewById(com.baidu.tieba.v.frs_go_praise_list_num);
        this.ckM = (TextView) this.aVn.findViewById(com.baidu.tieba.v.frs_praise_user_name_text1);
        this.ckN = (TextView) this.aVn.findViewById(com.baidu.tieba.v.frs_praise_user_name_text2);
        setOnClickListener(new q(this));
        this.ckN.setOnClickListener(new r(this));
        this.ckM.setOnClickListener(new s(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.ckO = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ckP = z;
    }

    private void fresh(boolean z) {
        long num = this.ckO.getNum();
        this.ckN.setVisibility(8);
        this.ckM.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.ckO.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.ckM.setVisibility(0);
                        this.ckM.setText(it(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.ckM.setVisibility(0);
                        this.ckM.setText(it(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.ckN.setVisibility(0);
                        this.ckN.setText("、" + it(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aIl.setText(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text));
            } else if (num <= 999999) {
                this.aIl.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            } else {
                this.aIl.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            }
        }
    }

    private String it(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cu(int i) {
        if (this.ckP) {
            ba.i(this.aVn, com.baidu.tieba.u.praise_head_selector);
            ba.b(this.aIl, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.ckM, com.baidu.tieba.s.cp_cont_c, 1);
            ba.b(this.ckN, com.baidu.tieba.s.cp_cont_c, 1);
            return;
        }
        ba.i(this.aVn, com.baidu.tieba.u.praise_view_btn_color);
        ba.b(this.aIl, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.ckM, com.baidu.tieba.s.cp_cont_c, 1);
        ba.b(this.ckN, com.baidu.tieba.s.cp_cont_c, 1);
    }
}
