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
public final class j extends LinearLayout {
    private LinearLayout aLj;
    private TextView aTm;
    private TextView awk;
    private EditText cKh;
    private ShareFromPBMsgData dFM;
    private TbImageView dkd;

    public EditText getChatMsgView() {
        return this.cKh;
    }

    public void I(String str, boolean z) {
        if (this.dkd != null) {
            this.dkd.c(str, z ? 17 : 18, false);
        }
    }

    public j(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aLj = (LinearLayout) findViewById(d.h.share_content);
        this.awk = (TextView) findViewById(d.h.share_title_view);
        this.cKh = (EditText) findViewById(d.h.chat_msg);
        this.dkd = (TbImageView) findViewById(d.h.chat_group_img);
        this.aTm = (TextView) findViewById(d.h.chat_group_desc);
        aj.c(this.awk, d.e.cp_cont_b, 1);
        aj.c(this.cKh, d.e.cp_cont_b, 2);
        aj.c(this.aTm, d.e.cp_cont_f, 1);
        this.cKh.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cKh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        amn();
    }

    public void amn() {
        this.aLj.setFocusable(true);
        this.aLj.setFocusableInTouchMode(true);
        this.aLj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cKh != null) {
            return com.baidu.adp.lib.util.k.a(this.cKh.getText(), null);
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
        this.dFM = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awk.setText(this.dFM.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dFM.getImageUrl());
        this.dkd.setTag(this.dFM.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dFM.getContent());
        this.aTm.setText(this.dFM.getContent());
    }
}
