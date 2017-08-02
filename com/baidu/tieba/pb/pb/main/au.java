package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class au extends LinearLayout {
    private LinearLayout aKN;
    private TextView aRs;
    private TextView awz;
    private EditText cyP;
    private TbImageView dcX;
    private ShareFromPBMsgData dyK;

    public EditText getChatMsgView() {
        return this.cyP;
    }

    public void K(String str, boolean z) {
        if (this.dcX != null) {
            this.dcX.c(str, z ? 17 : 18, false);
        }
    }

    public au(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aKN = (LinearLayout) findViewById(d.h.share_content);
        this.awz = (TextView) findViewById(d.h.share_title_view);
        this.cyP = (EditText) findViewById(d.h.chat_msg);
        this.dcX = (TbImageView) findViewById(d.h.chat_group_img);
        this.aRs = (TextView) findViewById(d.h.chat_group_desc);
        com.baidu.tbadk.core.util.ai.c(this.awz, d.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ai.c(this.cyP, d.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ai.c(this.aRs, d.e.cp_cont_f, 1);
        this.cyP.setHintTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_e));
        this.cyP.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ajD();
    }

    public void ajD() {
        this.aKN.setFocusable(true);
        this.aKN.setFocusableInTouchMode(true);
        this.aKN.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cyP != null) {
            return com.baidu.adp.lib.util.j.a(this.cyP.getText(), null);
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
        this.dyK = shareFromPBMsgData;
        wG();
    }

    private void wG() {
        this.awz.setText(this.dyK.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dyK.getImageUrl());
        this.dcX.setTag(this.dyK.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dyK.getContent());
        this.aRs.setText(this.dyK.getContent());
    }
}
