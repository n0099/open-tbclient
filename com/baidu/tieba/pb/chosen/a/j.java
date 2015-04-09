package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class j extends LinearLayout {
    private TextView aCm;
    private EditText bos;
    private BarImageView bot;

    public EditText getChatMsgView() {
        return this.bos;
    }

    public void v(String str, boolean z) {
        if (this.bot != null) {
            this.bot.c(str, z ? 17 : 18, false);
        }
    }

    public j(Context context) {
        super(context);
        au(context);
    }

    private void au(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, w.thread_to_group_share_view, this);
        setOrientation(1);
        this.bos = (EditText) findViewById(v.chat_msg);
        this.bot = (BarImageView) findViewById(v.chat_group_img);
        this.aCm = (TextView) findViewById(v.chat_group_desc);
        ba.i((View) this.bos, u.inputbox_share);
        ba.b(this.bos, s.cp_cont_b, 2);
        ba.b(this.aCm, s.dialog_bdalert_title, 1);
        this.bos.setPadding(context.getResources().getDimensionPixelSize(t.ds20), 0, 0, 0);
    }

    public void setTitle(String str) {
        if (this.aCm != null) {
            this.aCm.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bos != null) {
            return m.a(this.bos.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
