package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class gn extends LinearLayout {
    private LinearLayout aDv;
    private TextView aJE;
    private TextView apE;
    private TbImageView bXN;
    private EditText bwN;
    private ShareFromPBMsgData crB;

    public EditText getChatMsgView() {
        return this.bwN;
    }

    public void y(String str, boolean z) {
        if (this.bXN != null) {
            this.bXN.c(str, z ? 17 : 18, false);
        }
    }

    public gn(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(t.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aDv = (LinearLayout) findViewById(t.g.share_content);
        this.apE = (TextView) findViewById(t.g.share_title_view);
        this.bwN = (EditText) findViewById(t.g.chat_msg);
        this.bXN = (TbImageView) findViewById(t.g.chat_group_img);
        this.aJE = (TextView) findViewById(t.g.chat_group_desc);
        com.baidu.tbadk.core.util.at.b(this.apE, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.b(this.bwN, t.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.at.b(this.aJE, t.d.cp_cont_f, 1);
        this.bwN.setHintTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_e));
        this.bwN.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Uo();
    }

    public void Uo() {
        this.aDv.setFocusable(true);
        this.aDv.setFocusableInTouchMode(true);
        this.aDv.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwN != null) {
            return com.baidu.adp.lib.util.j.a(this.bwN.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.crB = shareFromPBMsgData;
        xo();
    }

    private void xo() {
        this.apE.setText(this.crB.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.crB.getImageUrl());
        this.bXN.setTag(this.crB.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.crB.getContent());
        this.aJE.setText(this.crB.getContent());
    }
}
