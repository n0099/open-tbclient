package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aYI;
    private View bwP;
    private boolean cHT;
    private TextView dxg;
    private TextView dxh;
    private PraiseData dxi;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cHT = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHT = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bwP = View.inflate(this.mContext, n.g.frs_item_praise, this);
        this.aYI = (TextView) this.bwP.findViewById(n.f.frs_go_praise_list_num);
        this.dxg = (TextView) this.bwP.findViewById(n.f.frs_praise_user_name_text1);
        this.dxh = (TextView) this.bwP.findViewById(n.f.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.dxh.setOnClickListener(new k(this));
        this.dxg.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.dxi = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cHT = z;
    }

    private void fresh(boolean z) {
        long num = this.dxi.getNum();
        this.dxh.setVisibility(8);
        this.dxg.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.dxi.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.dxg.setVisibility(0);
                        this.dxg.setText(mj(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.dxg.setVisibility(0);
                        this.dxg.setText(mj(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.dxh.setVisibility(0);
                        this.dxh.setText("、" + mj(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aYI.setText(this.mContext.getString(n.i.common_praise_view_text));
            } else if (num <= 999999) {
                this.aYI.setText(String.valueOf(this.mContext.getString(n.i.common_praise_view_text1)) + num + this.mContext.getString(n.i.common_praise_view_text2));
            } else {
                this.aYI.setText(String.valueOf(this.mContext.getString(n.i.common_praise_view_text1)) + "999999+" + this.mContext.getString(n.i.common_praise_view_text2));
            }
        }
    }

    private String mj(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cX(int i) {
        if (this.cHT) {
            as.i(this.bwP, n.e.praise_head_selector);
            as.b(this.aYI, n.c.cp_cont_d, 1);
            as.b(this.dxg, n.c.cp_cont_c, 1);
            as.b(this.dxh, n.c.cp_cont_c, 1);
            return;
        }
        as.i(this.bwP, n.e.praise_view_btn_color);
        as.b(this.aYI, n.c.cp_cont_d, 1);
        as.b(this.dxg, n.c.cp_cont_c, 1);
        as.b(this.dxh, n.c.cp_cont_c, 1);
    }
}
