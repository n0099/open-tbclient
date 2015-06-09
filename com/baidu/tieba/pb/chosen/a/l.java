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
    private TextView aEp;
    private TextView aiA;
    private EditText bqY;
    private TbImageView bqZ;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqY;
    }

    public void v(String str, boolean z) {
        if (this.bqZ != null) {
            this.bqZ.c(str, z ? 17 : 18, false);
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
        this.bqY = (EditText) findViewById(q.chat_msg);
        this.bqZ = (TbImageView) findViewById(q.chat_group_img);
        this.aEp = (TextView) findViewById(q.chat_group_desc);
        ay.b(this.bqY, n.cp_cont_b, 2);
        ay.b(this.aEp, n.cp_cont_f, 1);
        this.bqY.setHintTextColor(ay.getColor(n.cp_cont_e));
        this.bqY.setPadding(context.getResources().getDimensionPixelSize(o.ds20), 0, 0, 0);
        Vk();
    }

    public void Vk() {
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
        if (this.aiA != null) {
            this.aiA.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bqY != null) {
            return m.a(this.bqY.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
