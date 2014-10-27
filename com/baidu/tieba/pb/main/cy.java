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
    private EditText bfh;
    private BarImageView bfi;
    private TextView bfk;
    private ShareFromPBMsgData bjP;

    public EditText getChatMsgView() {
        return this.bfh;
    }

    public void C(String str, boolean z) {
        if (this.bfi != null) {
            this.bfi.c(str, z ? 17 : 18, false);
        }
    }

    public cy(Context context) {
        super(context);
        ad(context);
    }

    private void ad(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.thread_to_group_share_view, this);
        setOrientation(1);
        this.bfh = (EditText) findViewById(com.baidu.tieba.v.chat_msg);
        this.bfi = (BarImageView) findViewById(com.baidu.tieba.v.chat_group_img);
        this.bfk = (TextView) findViewById(com.baidu.tieba.v.chat_group_desc);
        com.baidu.tbadk.core.util.aw.h((View) this.bfh, com.baidu.tieba.u.inputbox_share);
        com.baidu.tbadk.core.util.aw.b(this.bfh, com.baidu.tieba.s.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aw.b(this.bfk, com.baidu.tieba.s.dialog_bdalert_title, 1);
        this.bfh.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bfh != null) {
            return com.baidu.adp.lib.util.l.a(this.bfh.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bjP = shareFromPBMsgData;
        nx();
    }

    private void nx() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.bjP.getImageUrl());
        this.bfi.setTag(this.bjP.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bjP.getContent());
        this.bfk.setText(this.bjP.getContent());
    }
}
