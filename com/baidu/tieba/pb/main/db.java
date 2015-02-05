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
public final class db extends LinearLayout {
    private TextView awr;
    private EditText bqD;
    private BarImageView bqE;
    private ShareFromPBMsgData bqP;

    public EditText getChatMsgView() {
        return this.bqD;
    }

    public void z(String str, boolean z) {
        if (this.bqE != null) {
            this.bqE.d(str, z ? 17 : 18, false);
        }
    }

    public db(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.thread_to_group_share_view, this);
        setOrientation(1);
        this.bqD = (EditText) findViewById(com.baidu.tieba.w.chat_msg);
        this.bqE = (BarImageView) findViewById(com.baidu.tieba.w.chat_group_img);
        this.awr = (TextView) findViewById(com.baidu.tieba.w.chat_group_desc);
        com.baidu.tbadk.core.util.bc.i((View) this.bqD, com.baidu.tieba.v.inputbox_share);
        com.baidu.tbadk.core.util.bc.b(this.bqD, com.baidu.tieba.t.cp_cont_b, 2);
        com.baidu.tbadk.core.util.bc.b(this.awr, com.baidu.tieba.t.dialog_bdalert_title, 1);
        this.bqD.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bqD != null) {
            return com.baidu.adp.lib.util.k.a(this.bqD.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bqP = shareFromPBMsgData;
        qB();
    }

    private void qB() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.bqP.getImageUrl());
        this.bqE.setTag(this.bqP.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bqP.getContent());
        this.awr.setText(this.bqP.getContent());
    }
}
