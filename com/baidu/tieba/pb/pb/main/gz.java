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
public final class gz extends LinearLayout {
    private TextView aOS;
    private LinearLayout amo;
    private TextView auU;
    private TbImageView cGW;
    private EditText cds;
    private ShareFromPBMsgData dcQ;

    public EditText getChatMsgView() {
        return this.cds;
    }

    public void G(String str, boolean z) {
        if (this.cGW != null) {
            this.cGW.c(str, z ? 17 : 18, false);
        }
    }

    public gz(Context context) {
        super(context);
        bp(context);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.amo = (LinearLayout) findViewById(w.h.share_content);
        this.auU = (TextView) findViewById(w.h.share_title_view);
        this.cds = (EditText) findViewById(w.h.chat_msg);
        this.cGW = (TbImageView) findViewById(w.h.chat_group_img);
        this.aOS = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.aq.c(this.auU, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.cds, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aq.c(this.aOS, w.e.cp_cont_f, 1);
        this.cds.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.cds.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        adj();
    }

    public void adj() {
        this.amo.setFocusable(true);
        this.amo.setFocusableInTouchMode(true);
        this.amo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cds != null) {
            return com.baidu.adp.lib.util.j.a(this.cds.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dcQ = shareFromPBMsgData;
        wh();
    }

    private void wh() {
        this.auU.setText(this.dcQ.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dcQ.getImageUrl());
        this.cGW.setTag(this.dcQ.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dcQ.getContent());
        this.aOS.setText(this.dcQ.getContent());
    }
}
