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
public final class dc extends LinearLayout {
    private TextView avu;
    private EditText bpg;
    private BarImageView bph;
    private ShareFromPBMsgData bps;

    public EditText getChatMsgView() {
        return this.bpg;
    }

    public void A(String str, boolean z) {
        if (this.bph != null) {
            this.bph.d(str, z ? 17 : 18, false);
        }
    }

    public dc(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.thread_to_group_share_view, this);
        setOrientation(1);
        this.bpg = (EditText) findViewById(com.baidu.tieba.w.chat_msg);
        this.bph = (BarImageView) findViewById(com.baidu.tieba.w.chat_group_img);
        this.avu = (TextView) findViewById(com.baidu.tieba.w.chat_group_desc);
        com.baidu.tbadk.core.util.ax.i((View) this.bpg, com.baidu.tieba.v.inputbox_share);
        com.baidu.tbadk.core.util.ax.b(this.bpg, com.baidu.tieba.t.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ax.b(this.avu, com.baidu.tieba.t.dialog_bdalert_title, 1);
        this.bpg.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bpg != null) {
            return com.baidu.adp.lib.util.k.a(this.bpg.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bps = shareFromPBMsgData;
        qw();
    }

    private void qw() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.bps.getImageUrl());
        this.bph.setTag(this.bps.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bps.getContent());
        this.avu.setText(this.bps.getContent());
    }
}
