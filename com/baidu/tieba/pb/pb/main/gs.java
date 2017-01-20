package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class gs extends LinearLayout {
    private LinearLayout aCL;
    private TextView aIK;
    private TextView apd;
    private EditText bYj;
    private TbImageView cKs;
    private ShareFromPBMsgData dfH;

    public EditText getChatMsgView() {
        return this.bYj;
    }

    public void F(String str, boolean z) {
        if (this.cKs != null) {
            this.cKs.c(str, z ? 17 : 18, false);
        }
    }

    public gs(Context context) {
        super(context);
        aT(context);
    }

    private void aT(Context context) {
        LayoutInflater.from(context).inflate(r.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aCL = (LinearLayout) findViewById(r.h.share_content);
        this.apd = (TextView) findViewById(r.h.share_title_view);
        this.bYj = (EditText) findViewById(r.h.chat_msg);
        this.cKs = (TbImageView) findViewById(r.h.chat_group_img);
        this.aIK = (TextView) findViewById(r.h.chat_group_desc);
        com.baidu.tbadk.core.util.ap.c(this.apd, r.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ap.c(this.bYj, r.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ap.c(this.aIK, r.e.cp_cont_f, 1);
        this.bYj.setHintTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_e));
        this.bYj.setPadding(context.getResources().getDimensionPixelSize(r.f.ds20), 0, 0, 0);
        adF();
    }

    public void adF() {
        this.aCL.setFocusable(true);
        this.aCL.setFocusableInTouchMode(true);
        this.aCL.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bYj != null) {
            return com.baidu.adp.lib.util.j.a(this.bYj.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dfH = shareFromPBMsgData;
        wb();
    }

    private void wb() {
        this.apd.setText(this.dfH.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dfH.getImageUrl());
        this.cKs.setTag(this.dfH.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dfH.getContent());
        this.aIK.setText(this.dfH.getContent());
    }
}
