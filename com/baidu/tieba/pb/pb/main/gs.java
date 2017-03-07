package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class gs extends LinearLayout {
    private LinearLayout aIi;
    private TextView aOh;
    private TextView auy;
    private TbImageView cMd;
    private EditText cfF;
    private ShareFromPBMsgData dhY;

    public EditText getChatMsgView() {
        return this.cfF;
    }

    public void G(String str, boolean z) {
        if (this.cMd != null) {
            this.cMd.c(str, z ? 17 : 18, false);
        }
    }

    public gs(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aIi = (LinearLayout) findViewById(w.h.share_content);
        this.auy = (TextView) findViewById(w.h.share_title_view);
        this.cfF = (EditText) findViewById(w.h.chat_msg);
        this.cMd = (TbImageView) findViewById(w.h.chat_group_img);
        this.aOh = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.aq.c(this.auy, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.cfF, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aq.c(this.aOh, w.e.cp_cont_f, 1);
        this.cfF.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.cfF.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aeF();
    }

    public void aeF() {
        this.aIi.setFocusable(true);
        this.aIi.setFocusableInTouchMode(true);
        this.aIi.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cfF != null) {
            return com.baidu.adp.lib.util.j.a(this.cfF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dhY = shareFromPBMsgData;
        wy();
    }

    private void wy() {
        this.auy.setText(this.dhY.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dhY.getImageUrl());
        this.cMd.setTag(this.dhY.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dhY.getContent());
        this.aOh.setText(this.dhY.getContent());
    }
}
