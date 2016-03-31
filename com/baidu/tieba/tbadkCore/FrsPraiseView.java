package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView ahs;
    private View bJp;
    private boolean dpy;
    private TextView ene;
    private TextView enf;
    private PraiseData eng;
    private boolean enh;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.dpy = false;
        this.enh = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpy = false;
        this.enh = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bJp = View.inflate(this.mContext, t.h.frs_item_praise, this);
        this.ahs = (TextView) this.bJp.findViewById(t.g.frs_go_praise_list_num);
        this.ene = (TextView) this.bJp.findViewById(t.g.frs_praise_user_name_text1);
        this.enf = (TextView) this.bJp.findViewById(t.g.frs_praise_user_name_text2);
        setOnClickListener(new i(this));
        this.enf.setOnClickListener(new j(this));
        this.ene.setOnClickListener(new k(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.eng = praiseData;
            iF(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.dpy = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.enh = z;
    }

    private void iF(boolean z) {
        long num = this.eng.getNum();
        this.enf.setVisibility(8);
        this.ene.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.eng.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.ene.setVisibility(0);
                        this.ene.setText(nI(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.ene.setVisibility(0);
                        this.ene.setText(nI(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.enf.setVisibility(0);
                        this.enf.setText("、" + nI(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ahs.setText(this.mContext.getString(t.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ahs.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + num + this.mContext.getString(t.j.common_praise_view_text2));
            } else {
                this.ahs.setText(String.valueOf(this.mContext.getString(t.j.common_praise_view_text1)) + "999999+" + this.mContext.getString(t.j.common_praise_view_text2));
            }
        }
    }

    private String nI(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dn(int i) {
        if (this.dpy) {
            if (this.enh) {
                at.k(this.bJp, t.f.praise_video_selector);
                at.b(this.ahs, t.d.cp_cont_c, 1);
                at.b(this.ene, t.d.cp_link_tip_c, 1);
                at.b(this.enf, t.d.cp_link_tip_c, 1);
                return;
            }
            at.k(this.bJp, t.f.praise_head_selector);
            at.b(this.ahs, t.d.cp_cont_d, 1);
            at.b(this.ene, t.d.cp_cont_c, 1);
            at.b(this.enf, t.d.cp_cont_c, 1);
            return;
        }
        at.k(this.bJp, t.f.praise_view_btn_color);
        at.b(this.ahs, t.d.cp_cont_d, 1);
        at.b(this.ene, t.d.cp_cont_c, 1);
        at.b(this.enf, t.d.cp_cont_c, 1);
    }
}
