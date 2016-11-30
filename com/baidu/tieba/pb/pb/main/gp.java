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
public final class gp extends LinearLayout {
    private LinearLayout aEC;
    private TextView aKM;
    private EditText bXp;
    private TbImageView bXq;
    private ShareFromPBMsgData dty;
    private TextView title;

    public EditText getChatMsgView() {
        return this.bXp;
    }

    public void F(String str, boolean z) {
        if (this.bXq != null) {
            this.bXq.c(str, z ? 17 : 18, false);
        }
    }

    public gp(Context context) {
        super(context);
        aO(context);
    }

    private void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aEC = (LinearLayout) findViewById(r.g.share_content);
        this.title = (TextView) findViewById(r.g.share_title_view);
        this.bXp = (EditText) findViewById(r.g.chat_msg);
        this.bXq = (TbImageView) findViewById(r.g.chat_group_img);
        this.aKM = (TextView) findViewById(r.g.chat_group_desc);
        com.baidu.tbadk.core.util.at.c(this.title, r.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.c(this.bXp, r.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.at.c(this.aKM, r.d.cp_cont_f, 1);
        this.bXp.setHintTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_e));
        this.bXp.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        adV();
    }

    public void adV() {
        this.aEC.setFocusable(true);
        this.aEC.setFocusableInTouchMode(true);
        this.aEC.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bXp != null) {
            return com.baidu.adp.lib.util.j.a(this.bXp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dty = shareFromPBMsgData;
        ww();
    }

    private void ww() {
        this.title.setText(this.dty.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dty.getImageUrl());
        this.bXq.setTag(this.dty.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dty.getContent());
        this.aKM.setText(this.dty.getContent());
    }
}
