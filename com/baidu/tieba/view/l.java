package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class l extends LinearLayout {
    private LinearLayout bAj;
    private TextView bKh;
    private TextView blr;
    private EditText dQe;
    private ShareFromPBMsgData eIs;
    private TbImageView emX;

    public EditText getChatMsgView() {
        return this.dQe;
    }

    public void J(String str, boolean z) {
        if (this.emX != null) {
            this.emX.startLoad(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        bE(context);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bAj = (LinearLayout) findViewById(d.g.share_content);
        this.blr = (TextView) findViewById(d.g.share_title_view);
        this.dQe = (EditText) findViewById(d.g.chat_msg);
        this.emX = (TbImageView) findViewById(d.g.chat_group_img);
        this.bKh = (TextView) findViewById(d.g.chat_group_desc);
        aj.e(this.blr, d.C0108d.cp_cont_b, 1);
        aj.e(this.dQe, d.C0108d.cp_cont_b, 2);
        aj.e(this.bKh, d.C0108d.cp_cont_f, 1);
        this.dQe.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.dQe.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        ayt();
    }

    public void ayt() {
        this.bAj.setFocusable(true);
        this.bAj.setFocusableInTouchMode(true);
        this.bAj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dQe != null) {
            return com.baidu.adp.lib.util.k.a(this.dQe.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eIs = shareFromPBMsgData;
        DN();
    }

    private void DN() {
        this.blr.setText(this.eIs.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.eIs.getImageUrl());
        this.emX.setTag(this.eIs.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.eIs.getContent());
        this.bKh.setText(this.eIs.getContent());
    }
}
