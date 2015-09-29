package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aTb;
    private View bnc;
    private TextView cWI;
    private TextView cWJ;
    private PraiseData cWK;
    private boolean cnf;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cnf = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnf = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bnc = View.inflate(this.mContext, i.g.frs_item_praise, this);
        this.aTb = (TextView) this.bnc.findViewById(i.f.frs_go_praise_list_num);
        this.cWI = (TextView) this.bnc.findViewById(i.f.frs_praise_user_name_text1);
        this.cWJ = (TextView) this.bnc.findViewById(i.f.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.cWJ.setOnClickListener(new j(this));
        this.cWI.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cWK = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cnf = z;
    }

    private void fresh(boolean z) {
        long num = this.cWK.getNum();
        this.cWJ.setVisibility(8);
        this.cWI.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cWK.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cWI.setVisibility(0);
                        this.cWI.setText(lo(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cWI.setVisibility(0);
                        this.cWI.setText(lo(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cWJ.setVisibility(0);
                        this.cWJ.setText("、" + lo(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aTb.setText(this.mContext.getString(i.h.common_praise_view_text));
            } else if (num <= 999999) {
                this.aTb.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + num + this.mContext.getString(i.h.common_praise_view_text2));
            } else {
                this.aTb.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + "999999+" + this.mContext.getString(i.h.common_praise_view_text2));
            }
        }
    }

    private String lo(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cP(int i) {
        if (this.cnf) {
            am.i(this.bnc, i.e.praise_head_selector);
            am.b(this.aTb, i.c.cp_cont_d, 1);
            am.b(this.cWI, i.c.cp_cont_c, 1);
            am.b(this.cWJ, i.c.cp_cont_c, 1);
            return;
        }
        am.i(this.bnc, i.e.praise_view_btn_color);
        am.b(this.aTb, i.c.cp_cont_d, 1);
        am.b(this.cWI, i.c.cp_cont_c, 1);
        am.b(this.cWJ, i.c.cp_cont_c, 1);
    }
}
