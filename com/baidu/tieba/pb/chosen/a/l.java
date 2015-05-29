package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class l extends LinearLayout {
    private TextView aEo;
    private TextView aiA;
    private EditText bqX;
    private TbImageView bqY;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqX;
    }

    public void v(String str, boolean z) {
        if (this.bqY != null) {
            this.bqY.c(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        az(context);
    }

    private void az(Context context) {
        com.baidu.adp.lib.g.b.hr().inflate(context, r.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(q.share_content);
        this.aiA = (TextView) findViewById(q.share_title_view);
        ay.b(this.aiA, n.cp_cont_b, 1);
        this.bqX = (EditText) findViewById(q.chat_msg);
        this.bqY = (TbImageView) findViewById(q.chat_group_img);
        this.aEo = (TextView) findViewById(q.chat_group_desc);
        ay.b(this.bqX, n.cp_cont_b, 2);
        ay.b(this.aEo, n.cp_cont_f, 1);
        this.bqX.setHintTextColor(ay.getColor(n.cp_cont_e));
        this.bqX.setPadding(context.getResources().getDimensionPixelSize(o.ds20), 0, 0, 0);
        Vj();
    }

    public void Vj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aEo != null) {
            this.aEo.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.aiA != null) {
            this.aiA.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bqX != null) {
            return m.a(this.bqX.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
