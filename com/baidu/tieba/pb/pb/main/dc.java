package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public final class dc extends LinearLayout {
    private TextView aEp;
    private TextView aiA;
    private EditText bqY;
    private TbImageView bqZ;
    private ShareFromPBMsgData brl;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqY;
    }

    public void v(String str, boolean z) {
        if (this.bqZ != null) {
            this.bqZ.c(str, z ? 17 : 18, false);
        }
    }

    public dc(Context context) {
        super(context);
        az(context);
    }

    private void az(Context context) {
        com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(com.baidu.tieba.q.share_content);
        this.aiA = (TextView) findViewById(com.baidu.tieba.q.share_title_view);
        this.bqY = (EditText) findViewById(com.baidu.tieba.q.chat_msg);
        this.bqZ = (TbImageView) findViewById(com.baidu.tieba.q.chat_group_img);
        this.aEp = (TextView) findViewById(com.baidu.tieba.q.chat_group_desc);
        com.baidu.tbadk.core.util.ay.b(this.aiA, com.baidu.tieba.n.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ay.b(this.bqY, com.baidu.tieba.n.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ay.b(this.aEp, com.baidu.tieba.n.cp_cont_f, 1);
        this.bqY.setHintTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_e));
        this.bqY.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20), 0, 0, 0);
        Vk();
    }

    public void Vk() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bqY != null) {
            return com.baidu.adp.lib.util.m.a(this.bqY.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.brl = shareFromPBMsgData;
        uv();
    }

    private void uv() {
        this.aiA.setText(this.brl.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.brl.getImageUrl());
        this.bqZ.setTag(this.brl.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.brl.getContent());
        this.aEp.setText(this.brl.getContent());
    }
}
