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
    private LinearLayout aLH;
    private TextView aSn;
    private TextView axa;
    private EditText cJr;
    private ShareFromPBMsgData dJx;
    private TbImageView dnN;

    public EditText getChatMsgView() {
        return this.cJr;
    }

    public void L(String str, boolean z) {
        if (this.dnN != null) {
            this.dnN.c(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aLH = (LinearLayout) findViewById(d.h.share_content);
        this.axa = (TextView) findViewById(d.h.share_title_view);
        this.cJr = (EditText) findViewById(d.h.chat_msg);
        this.dnN = (TbImageView) findViewById(d.h.chat_group_img);
        this.aSn = (TextView) findViewById(d.h.chat_group_desc);
        aj.c(this.axa, d.e.cp_cont_b, 1);
        aj.c(this.cJr, d.e.cp_cont_b, 2);
        aj.c(this.aSn, d.e.cp_cont_f, 1);
        this.cJr.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cJr.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        amj();
    }

    public void amj() {
        this.aLH.setFocusable(true);
        this.aLH.setFocusableInTouchMode(true);
        this.aLH.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJr != null) {
            return com.baidu.adp.lib.util.j.a(this.cJr.getText(), null);
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
        this.dJx = shareFromPBMsgData;
        wO();
    }

    private void wO() {
        this.axa.setText(this.dJx.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dJx.getImageUrl());
        this.dnN.setTag(this.dJx.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dJx.getContent());
        this.aSn.setText(this.dJx.getContent());
    }
}
