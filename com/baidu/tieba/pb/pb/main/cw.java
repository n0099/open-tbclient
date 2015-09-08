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
public final class cw extends LinearLayout {
    private TextView aMb;
    private TextView amV;
    private ShareFromPBMsgData bFG;
    private EditText bFt;
    private TbImageView bFu;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bFt;
    }

    public void x(String str, boolean z) {
        if (this.bFu != null) {
            this.bFu.d(str, z ? 17 : 18, false);
        }
    }

    public cw(Context context) {
        super(context);
        aA(context);
    }

    private void aA(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.amV = (TextView) findViewById(i.f.share_title_view);
        this.bFt = (EditText) findViewById(i.f.chat_msg);
        this.bFu = (TbImageView) findViewById(i.f.chat_group_img);
        this.aMb = (TextView) findViewById(i.f.chat_group_desc);
        com.baidu.tbadk.core.util.al.b(this.amV, i.c.cp_cont_b, 1);
        com.baidu.tbadk.core.util.al.b(this.bFt, i.c.cp_cont_b, 2);
        com.baidu.tbadk.core.util.al.b(this.aMb, i.c.cp_cont_f, 1);
        this.bFt.setHintTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_e));
        this.bFt.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        WT();
    }

    public void WT() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bFt != null) {
            return com.baidu.adp.lib.util.j.a(this.bFt.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bFG = shareFromPBMsgData;
        vE();
    }

    private void vE() {
        this.amV.setText(this.bFG.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.bFG.getImageUrl());
        this.bFu.setTag(this.bFG.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bFG.getContent());
        this.aMb.setText(this.bFG.getContent());
    }
}
