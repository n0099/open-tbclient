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
    private TextView agz;
    private View bAG;
    private boolean cLV;
    private TextView dEH;
    private TextView dEI;
    private PraiseData dEJ;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cLV = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLV = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bAG = View.inflate(this.mContext, n.h.frs_item_praise, this);
        this.agz = (TextView) this.bAG.findViewById(n.g.frs_go_praise_list_num);
        this.dEH = (TextView) this.bAG.findViewById(n.g.frs_praise_user_name_text1);
        this.dEI = (TextView) this.bAG.findViewById(n.g.frs_praise_user_name_text2);
        setOnClickListener(new j(this));
        this.dEI.setOnClickListener(new k(this));
        this.dEH.setOnClickListener(new l(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.dEJ = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cLV = z;
    }

    private void fresh(boolean z) {
        long num = this.dEJ.getNum();
        this.dEI.setVisibility(8);
        this.dEH.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.dEJ.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.dEH.setVisibility(0);
                        this.dEH.setText(mh(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.dEH.setVisibility(0);
                        this.dEH.setText(mh(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.dEI.setVisibility(0);
                        this.dEI.setText("、" + mh(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.agz.setText(this.mContext.getString(n.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.agz.setText(String.valueOf(this.mContext.getString(n.j.common_praise_view_text1)) + num + this.mContext.getString(n.j.common_praise_view_text2));
            } else {
                this.agz.setText(String.valueOf(this.mContext.getString(n.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(n.j.common_praise_view_text2));
            }
        }
    }

    private String mh(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cR(int i) {
        if (this.cLV) {
            as.i(this.bAG, n.f.praise_head_selector);
            as.b(this.agz, n.d.cp_cont_d, 1);
            as.b(this.dEH, n.d.cp_cont_c, 1);
            as.b(this.dEI, n.d.cp_cont_c, 1);
            return;
        }
        as.i(this.bAG, n.f.praise_view_btn_color);
        as.b(this.agz, n.d.cp_cont_d, 1);
        as.b(this.dEH, n.d.cp_cont_c, 1);
        as.b(this.dEI, n.d.cp_cont_c, 1);
    }
}
