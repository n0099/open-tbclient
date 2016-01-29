package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView ahn;
    private View bDS;
    private boolean cUD;
    private TextView dUC;
    private TextView dUD;
    private PraiseData dUE;
    private boolean dUF;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.cUD = false;
        this.dUF = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUD = false;
        this.dUF = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bDS = View.inflate(this.mContext, t.h.frs_item_praise, this);
        this.ahn = (TextView) this.bDS.findViewById(t.g.frs_go_praise_list_num);
        this.dUC = (TextView) this.bDS.findViewById(t.g.frs_praise_user_name_text1);
        this.dUD = (TextView) this.bDS.findViewById(t.g.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.dUD.setOnClickListener(new j(this));
        this.dUC.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.dUE = praiseData;
            hQ(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.cUD = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.dUF = z;
    }

    private void hQ(boolean z) {
        long num = this.dUE.getNum();
        this.dUD.setVisibility(8);
        this.dUC.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.dUE.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.dUC.setVisibility(0);
                        this.dUC.setText(mx(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.dUC.setVisibility(0);
                        this.dUC.setText(mx(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.dUD.setVisibility(0);
                        this.dUD.setText("、" + mx(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ahn.setText(this.mContext.getString(t.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ahn.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + num + this.mContext.getString(t.j.common_praise_view_text2));
            } else {
                this.ahn.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(t.j.common_praise_view_text2));
            }
        }
    }

    private String mx(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dk(int i) {
        if (this.cUD) {
            if (this.dUF) {
                ar.k(this.bDS, t.f.praise_video_selector);
                ar.b(this.ahn, t.d.cp_cont_c, 1);
                ar.b(this.dUC, t.d.cp_link_tip_c, 1);
                ar.b(this.dUD, t.d.cp_link_tip_c, 1);
                return;
            }
            ar.k(this.bDS, t.f.praise_head_selector);
            ar.b(this.ahn, t.d.cp_cont_d, 1);
            ar.b(this.dUC, t.d.cp_cont_c, 1);
            ar.b(this.dUD, t.d.cp_cont_c, 1);
            return;
        }
        ar.k(this.bDS, t.f.praise_view_btn_color);
        ar.b(this.ahn, t.d.cp_cont_d, 1);
        ar.b(this.dUC, t.d.cp_cont_c, 1);
        ar.b(this.dUD, t.d.cp_cont_c, 1);
    }
}
