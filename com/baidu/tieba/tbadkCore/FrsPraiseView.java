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
    private TextView aTu;
    private View bnR;
    private TextView cYD;
    private TextView cYE;
    private PraiseData cYF;
    private boolean coH;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.coH = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coH = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bnR = View.inflate(this.mContext, i.g.frs_item_praise, this);
        this.aTu = (TextView) this.bnR.findViewById(i.f.frs_go_praise_list_num);
        this.cYD = (TextView) this.bnR.findViewById(i.f.frs_praise_user_name_text1);
        this.cYE = (TextView) this.bnR.findViewById(i.f.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.cYE.setOnClickListener(new j(this));
        this.cYD.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cYF = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.coH = z;
    }

    private void fresh(boolean z) {
        long num = this.cYF.getNum();
        this.cYE.setVisibility(8);
        this.cYD.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cYF.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cYD.setVisibility(0);
                        this.cYD.setText(lv(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cYD.setVisibility(0);
                        this.cYD.setText(lv(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cYE.setVisibility(0);
                        this.cYE.setText("、" + lv(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aTu.setText(this.mContext.getString(i.h.common_praise_view_text));
            } else if (num <= 999999) {
                this.aTu.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + num + this.mContext.getString(i.h.common_praise_view_text2));
            } else {
                this.aTu.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + "999999+" + this.mContext.getString(i.h.common_praise_view_text2));
            }
        }
    }

    private String lv(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cP(int i) {
        if (this.coH) {
            an.i(this.bnR, i.e.praise_head_selector);
            an.b(this.aTu, i.c.cp_cont_d, 1);
            an.b(this.cYD, i.c.cp_cont_c, 1);
            an.b(this.cYE, i.c.cp_cont_c, 1);
            return;
        }
        an.i(this.bnR, i.e.praise_view_btn_color);
        an.b(this.aTu, i.c.cp_cont_d, 1);
        an.b(this.cYD, i.c.cp_cont_c, 1);
        an.b(this.cYE, i.c.cp_cont_c, 1);
    }
}
