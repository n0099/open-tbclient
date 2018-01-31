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
    private LinearLayout bAA;
    private TextView bKx;
    private TextView blI;
    private EditText dVn;
    private ShareFromPBMsgData eKn;
    private TbImageView eoR;

    public EditText getChatMsgView() {
        return this.dVn;
    }

    public void J(String str, boolean z) {
        if (this.eoR != null) {
            this.eoR.startLoad(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        bB(context);
    }

    private void bB(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bAA = (LinearLayout) findViewById(d.g.share_content);
        this.blI = (TextView) findViewById(d.g.share_title_view);
        this.dVn = (EditText) findViewById(d.g.chat_msg);
        this.eoR = (TbImageView) findViewById(d.g.chat_group_img);
        this.bKx = (TextView) findViewById(d.g.chat_group_desc);
        aj.e(this.blI, d.C0108d.cp_cont_b, 1);
        aj.e(this.dVn, d.C0108d.cp_cont_b, 2);
        aj.e(this.bKx, d.C0108d.cp_cont_f, 1);
        this.dVn.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.dVn.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azD();
    }

    public void azD() {
        this.bAA.setFocusable(true);
        this.bAA.setFocusableInTouchMode(true);
        this.bAA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dVn != null) {
            return com.baidu.adp.lib.util.k.a(this.dVn.getText(), null);
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
        this.eKn = shareFromPBMsgData;
        DG();
    }

    private void DG() {
        this.blI.setText(this.eKn.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.eKn.getImageUrl());
        this.eoR.setTag(this.eKn.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.eKn.getContent());
        this.bKx.setText(this.eKn.getContent());
    }
}
