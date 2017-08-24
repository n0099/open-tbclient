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
    private LinearLayout aMe;
    private TextView aSG;
    private TextView axS;
    private EditText cCh;
    private ShareFromPBMsgData dBY;
    private TbImageView dgo;

    public EditText getChatMsgView() {
        return this.cCh;
    }

    public void K(String str, boolean z) {
        if (this.dgo != null) {
            this.dgo.c(str, z ? 17 : 18, false);
        }
    }

    public au(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMe = (LinearLayout) findViewById(d.h.share_content);
        this.axS = (TextView) findViewById(d.h.share_title_view);
        this.cCh = (EditText) findViewById(d.h.chat_msg);
        this.dgo = (TbImageView) findViewById(d.h.chat_group_img);
        this.aSG = (TextView) findViewById(d.h.chat_group_desc);
        com.baidu.tbadk.core.util.ai.c(this.axS, d.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ai.c(this.cCh, d.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ai.c(this.aSG, d.e.cp_cont_f, 1);
        this.cCh.setHintTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_e));
        this.cCh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        akq();
    }

    public void akq() {
        this.aMe.setFocusable(true);
        this.aMe.setFocusableInTouchMode(true);
        this.aMe.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cCh != null) {
            return com.baidu.adp.lib.util.j.a(this.cCh.getText(), null);
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
        this.dBY = shareFromPBMsgData;
        wQ();
    }

    private void wQ() {
        this.axS.setText(this.dBY.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dBY.getImageUrl());
        this.dgo.setTag(this.dBY.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dBY.getContent());
        this.aSG.setText(this.dBY.getContent());
    }
}
