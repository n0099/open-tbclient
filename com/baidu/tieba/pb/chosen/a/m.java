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
    private TextView aFP;
    private TextView ahk;
    private TbImageView bJM;
    private EditText boI;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.boI;
    }

    public void x(String str, boolean z) {
        if (this.bJM != null) {
            this.bJM.d(str, z ? 17 : 18, false);
        }
    }

    public m(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.g.share_content);
        this.ahk = (TextView) findViewById(n.g.share_title_view);
        as.b(this.ahk, n.d.cp_cont_b, 1);
        this.boI = (EditText) findViewById(n.g.chat_msg);
        this.bJM = (TbImageView) findViewById(n.g.chat_group_img);
        this.aFP = (TextView) findViewById(n.g.chat_group_desc);
        as.b(this.boI, n.d.cp_cont_b, 2);
        as.b(this.aFP, n.d.cp_cont_f, 1);
        this.boI.setHintTextColor(as.getColor(n.d.cp_cont_e));
        this.boI.setPadding(context.getResources().getDimensionPixelSize(n.e.ds20), 0, 0, 0);
        Qt();
    }

    public void Qt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aFP != null) {
            this.aFP.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.ahk != null) {
            this.ahk.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.boI != null) {
            return com.baidu.adp.lib.util.j.a(this.boI.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
