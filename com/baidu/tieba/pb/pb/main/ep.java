package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public final class ep extends LinearLayout {
    private TextView aFP;
    private TextView ahk;
    private TbImageView bJM;
    private EditText boI;
    private ShareFromPBMsgData ccw;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.boI;
    }

    public void x(String str, boolean z) {
        if (this.bJM != null) {
            this.bJM.d(str, z ? 17 : 18, false);
        }
    }

    public ep(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.g.share_content);
        this.ahk = (TextView) findViewById(n.g.share_title_view);
        this.boI = (EditText) findViewById(n.g.chat_msg);
        this.bJM = (TbImageView) findViewById(n.g.chat_group_img);
        this.aFP = (TextView) findViewById(n.g.chat_group_desc);
        com.baidu.tbadk.core.util.as.b(this.ahk, n.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.as.b(this.boI, n.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.as.b(this.aFP, n.d.cp_cont_f, 1);
        this.boI.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_e));
        this.boI.setPadding(context.getResources().getDimensionPixelSize(n.e.ds20), 0, 0, 0);
        Qt();
    }

    public void Qt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.boI != null) {
            return com.baidu.adp.lib.util.j.a(this.boI.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ccw = shareFromPBMsgData;
        vN();
    }

    private void vN() {
        this.ahk.setText(this.ccw.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.ccw.getImageUrl());
        this.bJM.setTag(this.ccw.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.ccw.getContent());
        this.aFP.setText(this.ccw.getContent());
    }
}
