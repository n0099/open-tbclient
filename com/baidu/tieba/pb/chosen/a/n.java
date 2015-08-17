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
    private TextView aLO;
    private TextView anH;
    private EditText bEM;
    private TbImageView bEN;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bEM;
    }

    public void v(String str, boolean z) {
        if (this.bEN != null) {
            this.bEN.d(str, z ? 17 : 18, false);
        }
    }

    public n(Context context) {
        super(context);
        aB(context);
    }

    private void aB(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.anH = (TextView) findViewById(i.f.share_title_view);
        al.b(this.anH, i.c.cp_cont_b, 1);
        this.bEM = (EditText) findViewById(i.f.chat_msg);
        this.bEN = (TbImageView) findViewById(i.f.chat_group_img);
        this.aLO = (TextView) findViewById(i.f.chat_group_desc);
        al.b(this.bEM, i.c.cp_cont_b, 2);
        al.b(this.aLO, i.c.cp_cont_f, 1);
        this.bEM.setHintTextColor(al.getColor(i.c.cp_cont_e));
        this.bEM.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        WR();
    }

    public void WR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aLO != null) {
            this.aLO.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.anH != null) {
            this.anH.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bEM != null) {
            return com.baidu.adp.lib.util.j.a(this.bEM.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
