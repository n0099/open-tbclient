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
public final class cx extends LinearLayout {
    private TextView aCJ;
    private TextView alu;
    private TbImageView bIH;
    private ShareFromPBMsgData bIW;
    private EditText bdH;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdH;
    }

    public void w(String str, boolean z) {
        if (this.bIH != null) {
            this.bIH.d(str, z ? 17 : 18, false);
        }
    }

    public cx(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.alu = (TextView) findViewById(i.f.share_title_view);
        this.bdH = (EditText) findViewById(i.f.chat_msg);
        this.bIH = (TbImageView) findViewById(i.f.chat_group_img);
        this.aCJ = (TextView) findViewById(i.f.chat_group_desc);
        com.baidu.tbadk.core.util.an.b(this.alu, i.c.cp_cont_b, 1);
        com.baidu.tbadk.core.util.an.b(this.bdH, i.c.cp_cont_b, 2);
        com.baidu.tbadk.core.util.an.b(this.aCJ, i.c.cp_cont_f, 1);
        this.bdH.setHintTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_e));
        this.bdH.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        NZ();
    }

    public void NZ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bdH != null) {
            return com.baidu.adp.lib.util.j.a(this.bdH.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bIW = shareFromPBMsgData;
        vt();
    }

    private void vt() {
        this.alu.setText(this.bIW.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.bIW.getImageUrl());
        this.bIH.setTag(this.bIW.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bIW.getContent());
        this.aCJ.setText(this.bIW.getContent());
    }
}
