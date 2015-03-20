package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes.dex */
public final class di extends LinearLayout {
    private TextView aCe;
    private EditText boc;
    private BarImageView bod;
    private ShareFromPBMsgData boo;

    public EditText getChatMsgView() {
        return this.boc;
    }

    public void v(String str, boolean z) {
        if (this.bod != null) {
            this.bod.c(str, z ? 17 : 18, false);
        }
    }

    public di(Context context) {
        super(context);
        au(context);
    }

    private void au(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.thread_to_group_share_view, this);
        setOrientation(1);
        this.boc = (EditText) findViewById(com.baidu.tieba.v.chat_msg);
        this.bod = (BarImageView) findViewById(com.baidu.tieba.v.chat_group_img);
        this.aCe = (TextView) findViewById(com.baidu.tieba.v.chat_group_desc);
        com.baidu.tbadk.core.util.ba.i((View) this.boc, com.baidu.tieba.u.inputbox_share);
        com.baidu.tbadk.core.util.ba.b(this.boc, com.baidu.tieba.s.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ba.b(this.aCe, com.baidu.tieba.s.dialog_bdalert_title, 1);
        this.boc.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.boc != null) {
            return com.baidu.adp.lib.util.m.a(this.boc.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.boo = shareFromPBMsgData;
        tM();
    }

    private void tM() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.boo.getImageUrl());
        this.bod.setTag(this.boo.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.boo.getContent());
        this.aCe.setText(this.boo.getContent());
    }
}
