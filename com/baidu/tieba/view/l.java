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
    private LinearLayout aLK;
    private TextView aSq;
    private TextView axd;
    private EditText cIx;
    private ShareFromPBMsgData dIC;
    private TbImageView dmS;

    public EditText getChatMsgView() {
        return this.cIx;
    }

    public void L(String str, boolean z) {
        if (this.dmS != null) {
            this.dmS.c(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aLK = (LinearLayout) findViewById(d.h.share_content);
        this.axd = (TextView) findViewById(d.h.share_title_view);
        this.cIx = (EditText) findViewById(d.h.chat_msg);
        this.dmS = (TbImageView) findViewById(d.h.chat_group_img);
        this.aSq = (TextView) findViewById(d.h.chat_group_desc);
        aj.c(this.axd, d.e.cp_cont_b, 1);
        aj.c(this.cIx, d.e.cp_cont_b, 2);
        aj.c(this.aSq, d.e.cp_cont_f, 1);
        this.cIx.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cIx.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        alY();
    }

    public void alY() {
        this.aLK.setFocusable(true);
        this.aLK.setFocusableInTouchMode(true);
        this.aLK.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cIx != null) {
            return com.baidu.adp.lib.util.j.a(this.cIx.getText(), null);
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
        this.dIC = shareFromPBMsgData;
        wO();
    }

    private void wO() {
        this.axd.setText(this.dIC.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dIC.getImageUrl());
        this.dmS.setTag(this.dIC.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dIC.getContent());
        this.aSq.setText(this.dIC.getContent());
    }
}
