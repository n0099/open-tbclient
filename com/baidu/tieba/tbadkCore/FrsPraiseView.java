package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aTR;
    private View bmf;
    private TextView cGU;
    private TextView cGV;
    private PraiseData cGW;
    private boolean cgM;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cgM = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cgM = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmf = View.inflate(this.mContext, i.g.frs_item_praise, this);
        this.aTR = (TextView) this.bmf.findViewById(i.f.frs_go_praise_list_num);
        this.cGU = (TextView) this.bmf.findViewById(i.f.frs_praise_user_name_text1);
        this.cGV = (TextView) this.bmf.findViewById(i.f.frs_praise_user_name_text2);
        setOnClickListener(new h(this));
        this.cGV.setOnClickListener(new i(this));
        this.cGU.setOnClickListener(new j(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cGW = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cgM = z;
    }

    private void fresh(boolean z) {
        long num = this.cGW.getNum();
        this.cGV.setVisibility(8);
        this.cGU.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cGW.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cGU.setVisibility(0);
                        this.cGU.setText(kl(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cGU.setVisibility(0);
                        this.cGU.setText(kl(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cGV.setVisibility(0);
                        this.cGV.setText("、" + kl(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aTR.setText(this.mContext.getString(i.C0057i.common_praise_view_text));
            } else if (num <= 999999) {
                this.aTR.setText(String.valueOf(this.mContext.getString(i.C0057i.common_praise_view_text1)) + num + this.mContext.getString(i.C0057i.common_praise_view_text2));
            } else {
                this.aTR.setText(String.valueOf(this.mContext.getString(i.C0057i.common_praise_view_text1)) + "999999+" + this.mContext.getString(i.C0057i.common_praise_view_text2));
            }
        }
    }

    private String kl(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cI(int i) {
        if (this.cgM) {
            al.i(this.bmf, i.e.praise_head_selector);
            al.b(this.aTR, i.c.cp_cont_d, 1);
            al.b(this.cGU, i.c.cp_cont_c, 1);
            al.b(this.cGV, i.c.cp_cont_c, 1);
            return;
        }
        al.i(this.bmf, i.e.praise_view_btn_color);
        al.b(this.aTR, i.c.cp_cont_d, 1);
        al.b(this.cGU, i.c.cp_cont_c, 1);
        al.b(this.cGV, i.c.cp_cont_c, 1);
    }
}
