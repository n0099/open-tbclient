package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class n extends LinearLayout {
    private TextView aMb;
    private TextView amV;
    private EditText bFt;
    private TbImageView bFu;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bFt;
    }

    public void x(String str, boolean z) {
        if (this.bFu != null) {
            this.bFu.d(str, z ? 17 : 18, false);
        }
    }

    public n(Context context) {
        super(context);
        aA(context);
    }

    private void aA(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.amV = (TextView) findViewById(i.f.share_title_view);
        al.b(this.amV, i.c.cp_cont_b, 1);
        this.bFt = (EditText) findViewById(i.f.chat_msg);
        this.bFu = (TbImageView) findViewById(i.f.chat_group_img);
        this.aMb = (TextView) findViewById(i.f.chat_group_desc);
        al.b(this.bFt, i.c.cp_cont_b, 2);
        al.b(this.aMb, i.c.cp_cont_f, 1);
        this.bFt.setHintTextColor(al.getColor(i.c.cp_cont_e));
        this.bFt.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        WT();
    }

    public void WT() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aMb != null) {
            this.aMb.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.amV != null) {
            this.amV.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bFt != null) {
            return com.baidu.adp.lib.util.j.a(this.bFt.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
