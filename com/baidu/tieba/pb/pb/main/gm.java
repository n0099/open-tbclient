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
public final class gm extends LinearLayout {
    private LinearLayout aEo;
    private TextView aKu;
    private TbImageView cRC;
    private EditText chp;
    private ShareFromPBMsgData dms;
    private TextView title;

    public EditText getChatMsgView() {
        return this.chp;
    }

    public void E(String str, boolean z) {
        if (this.cRC != null) {
            this.cRC.c(str, z ? 17 : 18, false);
        }
    }

    public gm(Context context) {
        super(context);
        aE(context);
    }

    private void aE(Context context) {
        LayoutInflater.from(context).inflate(t.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aEo = (LinearLayout) findViewById(t.g.share_content);
        this.title = (TextView) findViewById(t.g.share_title_view);
        this.chp = (EditText) findViewById(t.g.chat_msg);
        this.cRC = (TbImageView) findViewById(t.g.chat_group_img);
        this.aKu = (TextView) findViewById(t.g.chat_group_desc);
        com.baidu.tbadk.core.util.av.c(this.title, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.av.c(this.chp, t.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.av.c(this.aKu, t.d.cp_cont_f, 1);
        this.chp.setHintTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_e));
        this.chp.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        afO();
    }

    public void afO() {
        this.aEo.setFocusable(true);
        this.aEo.setFocusableInTouchMode(true);
        this.aEo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chp != null) {
            return com.baidu.adp.lib.util.j.a(this.chp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dms = shareFromPBMsgData;
        wc();
    }

    private void wc() {
        this.title.setText(this.dms.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dms.getImageUrl());
        this.cRC.setTag(this.dms.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dms.getContent());
        this.aKu.setText(this.dms.getContent());
    }
}
