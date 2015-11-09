package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class dp extends LinearLayout {
    private TextView aBD;
    private TextView alz;
    private TbImageView bJc;
    private ShareFromPBMsgData bJr;
    private EditText bem;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bem;
    }

    public void w(String str, boolean z) {
        if (this.bJc != null) {
            this.bJc.d(str, z ? 17 : 18, false);
        }
    }

    public dp(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.alz = (TextView) findViewById(i.f.share_title_view);
        this.bem = (EditText) findViewById(i.f.chat_msg);
        this.bJc = (TbImageView) findViewById(i.f.chat_group_img);
        this.aBD = (TextView) findViewById(i.f.chat_group_desc);
        com.baidu.tbadk.core.util.an.b(this.alz, i.c.cp_cont_b, 1);
        com.baidu.tbadk.core.util.an.b(this.bem, i.c.cp_cont_b, 2);
        com.baidu.tbadk.core.util.an.b(this.aBD, i.c.cp_cont_f, 1);
        this.bem.setHintTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_e));
        this.bem.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Ov();
    }

    public void Ov() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bem != null) {
            return com.baidu.adp.lib.util.j.a(this.bem.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bJr = shareFromPBMsgData;
        vx();
    }

    private void vx() {
        this.alz.setText(this.bJr.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.bJr.getImageUrl());
        this.bJc.setTag(this.bJr.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bJr.getContent());
        this.aBD.setText(this.bJr.getContent());
    }
}
