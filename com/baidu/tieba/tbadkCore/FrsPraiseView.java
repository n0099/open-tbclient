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
    private TextView aUf;
    private View bmB;
    private TextView cPs;
    private TextView cPt;
    private PraiseData cPu;
    private boolean chJ;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.chJ = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chJ = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmB = View.inflate(this.mContext, i.g.frs_item_praise, this);
        this.aUf = (TextView) this.bmB.findViewById(i.f.frs_go_praise_list_num);
        this.cPs = (TextView) this.bmB.findViewById(i.f.frs_praise_user_name_text1);
        this.cPt = (TextView) this.bmB.findViewById(i.f.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.cPt.setOnClickListener(new j(this));
        this.cPs.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.cPu = praiseData;
            fresh(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.chJ = z;
    }

    private void fresh(boolean z) {
        long num = this.cPu.getNum();
        this.cPt.setVisibility(8);
        this.cPs.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.cPu.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.cPs.setVisibility(0);
                        this.cPs.setText(kQ(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.cPs.setVisibility(0);
                        this.cPs.setText(kQ(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.cPt.setVisibility(0);
                        this.cPt.setText("、" + kQ(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aUf.setText(this.mContext.getString(i.h.common_praise_view_text));
            } else if (num <= 999999) {
                this.aUf.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + num + this.mContext.getString(i.h.common_praise_view_text2));
            } else {
                this.aUf.setText(String.valueOf(this.mContext.getString(i.h.common_praise_view_text1)) + "999999+" + this.mContext.getString(i.h.common_praise_view_text2));
            }
        }
    }

    private String kQ(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void cO(int i) {
        if (this.chJ) {
            al.h(this.bmB, i.e.praise_head_selector);
            al.b(this.aUf, i.c.cp_cont_d, 1);
            al.b(this.cPs, i.c.cp_cont_c, 1);
            al.b(this.cPt, i.c.cp_cont_c, 1);
            return;
        }
        al.h(this.bmB, i.e.praise_view_btn_color);
        al.b(this.aUf, i.c.cp_cont_d, 1);
        al.b(this.cPs, i.c.cp_cont_c, 1);
        al.b(this.cPt, i.c.cp_cont_c, 1);
    }
}
