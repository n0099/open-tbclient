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
    private TextView aIt;
    private View aVC;
    private TextView clc;
    private TextView cld;
    private PraiseData cle;
    private boolean clf;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.clf = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clf = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aVC = View.inflate(this.mContext, com.baidu.tieba.w.frs_item_praise, this);
        this.aIt = (TextView) this.aVC.findViewById(com.baidu.tieba.v.frs_go_praise_list_num);
        this.clc = (TextView) this.aVC.findViewById(com.baidu.tieba.v.frs_praise_user_name_text1);
        this.cld = (TextView) this.aVC.findViewById(com.baidu.tieba.v.frs_praise_user_name_text2);
        setOnClickListener(new q(this));
        this.cld.setOnClickListener(new r(this));
        this.clc.setOnClickListener(new s(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cle = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.clf = z;
    }

    private void fresh(boolean z) {
        long num = this.cle.getNum();
        this.cld.setVisibility(8);
        this.clc.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cle.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.clc.setVisibility(0);
                        this.clc.setText(iw(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.clc.setVisibility(0);
                        this.clc.setText(iw(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cld.setVisibility(0);
                        this.cld.setText("、" + iw(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aIt.setText(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text));
            } else if (num <= 999999) {
                this.aIt.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            } else {
                this.aIt.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.y.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.y.common_praise_view_text2));
            }
        }
    }

    private String iw(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cu(int i) {
        if (this.clf) {
            ba.i(this.aVC, com.baidu.tieba.u.praise_head_selector);
            ba.b(this.aIt, com.baidu.tieba.s.cp_cont_d, 1);
            ba.b(this.clc, com.baidu.tieba.s.cp_cont_c, 1);
            ba.b(this.cld, com.baidu.tieba.s.cp_cont_c, 1);
            return;
        }
        ba.i(this.aVC, com.baidu.tieba.u.praise_view_btn_color);
        ba.b(this.aIt, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.clc, com.baidu.tieba.s.cp_cont_c, 1);
        ba.b(this.cld, com.baidu.tieba.s.cp_cont_c, 1);
    }
}
