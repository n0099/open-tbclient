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
    private TextView aBD;
    private TextView alz;
    private TbImageView bJc;
    private EditText bem;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bem;
    }

    public void w(String str, boolean z) {
        if (this.bJc != null) {
            this.bJc.d(str, z ? 17 : 18, false);
        }
    }

    public n(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.alz = (TextView) findViewById(i.f.share_title_view);
        an.b(this.alz, i.c.cp_cont_b, 1);
        this.bem = (EditText) findViewById(i.f.chat_msg);
        this.bJc = (TbImageView) findViewById(i.f.chat_group_img);
        this.aBD = (TextView) findViewById(i.f.chat_group_desc);
        an.b(this.bem, i.c.cp_cont_b, 2);
        an.b(this.aBD, i.c.cp_cont_f, 1);
        this.bem.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.bem.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Ov();
    }

    public void Ov() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aBD != null) {
            this.aBD.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.alz != null) {
            this.alz.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bem != null) {
            return com.baidu.adp.lib.util.j.a(this.bem.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
