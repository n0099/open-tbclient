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
    private LinearLayout aIy;
    private TextView aOx;
    private TextView auO;
    private TbImageView cKC;
    private EditText cef;
    private ShareFromPBMsgData dgx;

    public EditText getChatMsgView() {
        return this.cef;
    }

    public void G(String str, boolean z) {
        if (this.cKC != null) {
            this.cKC.c(str, z ? 17 : 18, false);
        }
    }

    public gq(Context context) {
        super(context);
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aIy = (LinearLayout) findViewById(w.h.share_content);
        this.auO = (TextView) findViewById(w.h.share_title_view);
        this.cef = (EditText) findViewById(w.h.chat_msg);
        this.cKC = (TbImageView) findViewById(w.h.chat_group_img);
        this.aOx = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.aq.c(this.auO, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.cef, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aq.c(this.aOx, w.e.cp_cont_f, 1);
        this.cef.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.cef.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aez();
    }

    public void aez() {
        this.aIy.setFocusable(true);
        this.aIy.setFocusableInTouchMode(true);
        this.aIy.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cef != null) {
            return com.baidu.adp.lib.util.j.a(this.cef.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dgx = shareFromPBMsgData;
        wU();
    }

    private void wU() {
        this.auO.setText(this.dgx.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dgx.getImageUrl());
        this.cKC.setTag(this.dgx.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dgx.getContent());
        this.aOx.setText(this.dgx.getContent());
    }
}
