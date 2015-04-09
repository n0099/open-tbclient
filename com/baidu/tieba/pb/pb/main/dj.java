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
public final class dj extends LinearLayout {
    private TextView aCm;
    private ShareFromPBMsgData boE;
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

    public dj(Context context) {
        super(context);
        au(context);
    }

    private void au(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.thread_to_group_share_view, this);
        setOrientation(1);
        this.bos = (EditText) findViewById(com.baidu.tieba.v.chat_msg);
        this.bot = (BarImageView) findViewById(com.baidu.tieba.v.chat_group_img);
        this.aCm = (TextView) findViewById(com.baidu.tieba.v.chat_group_desc);
        com.baidu.tbadk.core.util.ba.i((View) this.bos, com.baidu.tieba.u.inputbox_share);
        com.baidu.tbadk.core.util.ba.b(this.bos, com.baidu.tieba.s.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ba.b(this.aCm, com.baidu.tieba.s.dialog_bdalert_title, 1);
        this.bos.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bos != null) {
            return com.baidu.adp.lib.util.m.a(this.bos.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.boE = shareFromPBMsgData;
        tM();
    }

    private void tM() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.boE.getImageUrl());
        this.bot.setTag(this.boE.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.boE.getContent());
        this.aCm.setText(this.boE.getContent());
    }
}
