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
    private TextView awu;
    private EditText bqE;
    private BarImageView bqF;
    private ShareFromPBMsgData bqQ;

    public EditText getChatMsgView() {
        return this.bqE;
    }

    public void z(String str, boolean z) {
        if (this.bqF != null) {
            this.bqF.d(str, z ? 17 : 18, false);
        }
    }

    public db(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.thread_to_group_share_view, this);
        setOrientation(1);
        this.bqE = (EditText) findViewById(com.baidu.tieba.w.chat_msg);
        this.bqF = (BarImageView) findViewById(com.baidu.tieba.w.chat_group_img);
        this.awu = (TextView) findViewById(com.baidu.tieba.w.chat_group_desc);
        com.baidu.tbadk.core.util.bc.i((View) this.bqE, com.baidu.tieba.v.inputbox_share);
        com.baidu.tbadk.core.util.bc.b(this.bqE, com.baidu.tieba.t.cp_cont_b, 2);
        com.baidu.tbadk.core.util.bc.b(this.awu, com.baidu.tieba.t.dialog_bdalert_title, 1);
        this.bqE.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.bqE != null) {
            return com.baidu.adp.lib.util.k.a(this.bqE.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bqQ = shareFromPBMsgData;
        qH();
    }

    private void qH() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.bqQ.getImageUrl());
        this.bqF.setTag(this.bqQ.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bqQ.getContent());
        this.awu.setText(this.bqQ.getContent());
    }
}
