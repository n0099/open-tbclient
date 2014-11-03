package com.baidu.tieba.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes.dex */
public final class cy extends LinearLayout {
    private EditText bfv;
    private BarImageView bfw;
    private TextView bfy;
    private ShareFromPBMsgData bkd;

    public EditText getChatMsgView() {
        return this.bfv;
    }

    public void C(String str, boolean z) {
        if (this.bfw != null) {
            this.bfw.c(str, z ? 17 : 18, false);
        }
    }

    public cy(Context context) {
        super(context);
        ad(context);
    }

    private void ad(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.thread_to_group_share_view, this);
        setOrientation(1);
        this.bfv = (EditText) findViewById(com.baidu.tieba.v.chat_msg);
        this.bfw = (BarImageView) findViewById(com.baidu.tieba.v.chat_group_img);
        this.bfy = (TextView) findViewById(com.baidu.tieba.v.chat_group_desc);
        com.baidu.tbadk.core.util.aw.h((View) this.bfv, com.baidu.tieba.u.inputbox_share);
        com.baidu.tbadk.core.util.aw.b(this.bfv, com.baidu.tieba.s.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aw.b(this.bfy, com.baidu.tieba.s.dialog_bdalert_title, 1);
        this.bfv.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bfv != null) {
            return com.baidu.adp.lib.util.l.a(this.bfv.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bkd = shareFromPBMsgData;
        nx();
    }

    private void nx() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.bkd.getImageUrl());
        this.bfw.setTag(this.bkd.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bkd.getContent());
        this.bfy.setText(this.bkd.getContent());
    }
}
