package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public final class m extends LinearLayout {
    private TextView aEp;
    private TextView agd;
    private TbImageView bGf;
    private EditText bkR;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bkR;
    }

    public void x(String str, boolean z) {
        if (this.bGf != null) {
            this.bGf.d(str, z ? 17 : 18, false);
        }
    }

    public m(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.f.share_content);
        this.agd = (TextView) findViewById(n.f.share_title_view);
        as.b(this.agd, n.c.cp_cont_b, 1);
        this.bkR = (EditText) findViewById(n.f.chat_msg);
        this.bGf = (TbImageView) findViewById(n.f.chat_group_img);
        this.aEp = (TextView) findViewById(n.f.chat_group_desc);
        as.b(this.bkR, n.c.cp_cont_b, 2);
        as.b(this.aEp, n.c.cp_cont_f, 1);
        this.bkR.setHintTextColor(as.getColor(n.c.cp_cont_e));
        this.bkR.setPadding(context.getResources().getDimensionPixelSize(n.d.ds20), 0, 0, 0);
        Qb();
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aEp != null) {
            this.aEp.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.agd != null) {
            this.agd.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bkR != null) {
            return com.baidu.adp.lib.util.j.a(this.bkR.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
