package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aKC;
    private View aYj;
    private boolean bQo;
    private TextView cpd;
    private TextView cpe;
    private PraiseData cpf;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.bQo = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQo = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aYj = View.inflate(this.mContext, com.baidu.tieba.r.frs_item_praise, this);
        this.aKC = (TextView) this.aYj.findViewById(com.baidu.tieba.q.frs_go_praise_list_num);
        this.cpd = (TextView) this.aYj.findViewById(com.baidu.tieba.q.frs_praise_user_name_text1);
        this.cpe = (TextView) this.aYj.findViewById(com.baidu.tieba.q.frs_praise_user_name_text2);
        setOnClickListener(new q(this));
        this.cpe.setOnClickListener(new r(this));
        this.cpd.setOnClickListener(new s(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cpf = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.bQo = z;
    }

    private void fresh(boolean z) {
        long num = this.cpf.getNum();
        this.cpe.setVisibility(8);
        this.cpd.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cpf.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cpd.setVisibility(0);
                        this.cpd.setText(jp(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cpd.setVisibility(0);
                        this.cpd.setText(jp(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cpe.setVisibility(0);
                        this.cpe.setText("、" + jp(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aKC.setText(this.mContext.getString(com.baidu.tieba.t.common_praise_view_text));
            } else if (num <= 999999) {
                this.aKC.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.t.common_praise_view_text1)) + num + this.mContext.getString(com.baidu.tieba.t.common_praise_view_text2));
            } else {
                this.aKC.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.t.common_praise_view_text1)) + "999999+" + this.mContext.getString(com.baidu.tieba.t.common_praise_view_text2));
            }
        }
    }

    private String jp(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cz(int i) {
        if (this.bQo) {
            com.baidu.tbadk.core.util.ay.i(this.aYj, com.baidu.tieba.p.praise_head_selector);
            com.baidu.tbadk.core.util.ay.b(this.aKC, com.baidu.tieba.n.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ay.b(this.cpd, com.baidu.tieba.n.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.b(this.cpe, com.baidu.tieba.n.cp_cont_c, 1);
            return;
        }
        com.baidu.tbadk.core.util.ay.i(this.aYj, com.baidu.tieba.p.praise_view_btn_color);
        com.baidu.tbadk.core.util.ay.b(this.aKC, com.baidu.tieba.n.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ay.b(this.cpd, com.baidu.tieba.n.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ay.b(this.cpe, com.baidu.tieba.n.cp_cont_c, 1);
    }
}
