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
public final class gi extends LinearLayout {
    private LinearLayout aDV;
    private TextView aKd;
    private TextView apY;
    private TbImageView bDA;
    private EditText bDz;
    private ShareFromPBMsgData cYs;

    public EditText getChatMsgView() {
        return this.bDz;
    }

    public void G(String str, boolean z) {
        if (this.bDA != null) {
            this.bDA.c(str, z ? 17 : 18, false);
        }
    }

    public gi(Context context) {
        super(context);
        aN(context);
    }

    private void aN(Context context) {
        LayoutInflater.from(context).inflate(r.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aDV = (LinearLayout) findViewById(r.g.share_content);
        this.apY = (TextView) findViewById(r.g.share_title_view);
        this.bDz = (EditText) findViewById(r.g.chat_msg);
        this.bDA = (TbImageView) findViewById(r.g.chat_group_img);
        this.aKd = (TextView) findViewById(r.g.chat_group_desc);
        com.baidu.tbadk.core.util.ar.c(this.apY, r.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ar.c(this.bDz, r.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ar.c(this.aKd, r.d.cp_cont_f, 1);
        this.bDz.setHintTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_e));
        this.bDz.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        Yp();
    }

    public void Yp() {
        this.aDV.setFocusable(true);
        this.aDV.setFocusableInTouchMode(true);
        this.aDV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bDz != null) {
            return com.baidu.adp.lib.util.j.a(this.bDz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cYs = shareFromPBMsgData;
        wg();
    }

    private void wg() {
        this.apY.setText(this.cYs.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.cYs.getImageUrl());
        this.bDA.setTag(this.cYs.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.cYs.getContent());
        this.aKd.setText(this.cYs.getContent());
    }
}
