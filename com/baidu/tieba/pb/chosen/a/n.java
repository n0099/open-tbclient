package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class n extends LinearLayout {
    private TextView aCJ;
    private TextView alu;
    private TbImageView bIH;
    private EditText bdH;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdH;
    }

    public void w(String str, boolean z) {
        if (this.bIH != null) {
            this.bIH.d(str, z ? 17 : 18, false);
        }
    }

    public n(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.alu = (TextView) findViewById(i.f.share_title_view);
        an.b(this.alu, i.c.cp_cont_b, 1);
        this.bdH = (EditText) findViewById(i.f.chat_msg);
        this.bIH = (TbImageView) findViewById(i.f.chat_group_img);
        this.aCJ = (TextView) findViewById(i.f.chat_group_desc);
        an.b(this.bdH, i.c.cp_cont_b, 2);
        an.b(this.aCJ, i.c.cp_cont_f, 1);
        this.bdH.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.bdH.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Od();
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aCJ != null) {
            this.aCJ.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.alu != null) {
            this.alu.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bdH != null) {
            return com.baidu.adp.lib.util.j.a(this.bdH.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
