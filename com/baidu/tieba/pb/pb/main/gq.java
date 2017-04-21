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
public final class gq extends LinearLayout {
    private LinearLayout aIA;
    private TextView aOz;
    private TextView auQ;
    private TbImageView cMT;
    private EditText cgw;
    private ShareFromPBMsgData diO;

    public EditText getChatMsgView() {
        return this.cgw;
    }

    public void G(String str, boolean z) {
        if (this.cMT != null) {
            this.cMT.c(str, z ? 17 : 18, false);
        }
    }

    public gq(Context context) {
        super(context);
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aIA = (LinearLayout) findViewById(w.h.share_content);
        this.auQ = (TextView) findViewById(w.h.share_title_view);
        this.cgw = (EditText) findViewById(w.h.chat_msg);
        this.cMT = (TbImageView) findViewById(w.h.chat_group_img);
        this.aOz = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.aq.c(this.auQ, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.cgw, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aq.c(this.aOz, w.e.cp_cont_f, 1);
        this.cgw.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.cgw.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        afA();
    }

    public void afA() {
        this.aIA.setFocusable(true);
        this.aIA.setFocusableInTouchMode(true);
        this.aIA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cgw != null) {
            return com.baidu.adp.lib.util.j.a(this.cgw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.diO = shareFromPBMsgData;
        wU();
    }

    private void wU() {
        this.auQ.setText(this.diO.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.diO.getImageUrl());
        this.cMT.setTag(this.diO.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.diO.getContent());
        this.aOz.setText(this.diO.getContent());
    }
}
