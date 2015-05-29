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
    private TextView aEo;
    private TextView aiA;
    private EditText bqX;
    private TbImageView bqY;
    private ShareFromPBMsgData brk;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqX;
    }

    public void v(String str, boolean z) {
        if (this.bqY != null) {
            this.bqY.c(str, z ? 17 : 18, false);
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
        this.bqX = (EditText) findViewById(com.baidu.tieba.q.chat_msg);
        this.bqY = (TbImageView) findViewById(com.baidu.tieba.q.chat_group_img);
        this.aEo = (TextView) findViewById(com.baidu.tieba.q.chat_group_desc);
        com.baidu.tbadk.core.util.ay.b(this.aiA, com.baidu.tieba.n.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ay.b(this.bqX, com.baidu.tieba.n.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ay.b(this.aEo, com.baidu.tieba.n.cp_cont_f, 1);
        this.bqX.setHintTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_e));
        this.bqX.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20), 0, 0, 0);
        Vj();
    }

    public void Vj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bqX != null) {
            return com.baidu.adp.lib.util.m.a(this.bqX.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.brk = shareFromPBMsgData;
        uv();
    }

    private void uv() {
        this.aiA.setText(this.brk.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.brk.getImageUrl());
        this.bqY.setTag(this.brk.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.brk.getContent());
        this.aEo.setText(this.brk.getContent());
    }
}
