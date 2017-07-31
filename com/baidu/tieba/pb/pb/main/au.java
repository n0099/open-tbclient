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
    private LinearLayout aMc;
    private TextView aSE;
    private TextView axQ;
    private EditText cAj;
    private ShareFromPBMsgData dAb;
    private TbImageView deq;

    public EditText getChatMsgView() {
        return this.cAj;
    }

    public void J(String str, boolean z) {
        if (this.deq != null) {
            this.deq.c(str, z ? 17 : 18, false);
        }
    }

    public au(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMc = (LinearLayout) findViewById(d.h.share_content);
        this.axQ = (TextView) findViewById(d.h.share_title_view);
        this.cAj = (EditText) findViewById(d.h.chat_msg);
        this.deq = (TbImageView) findViewById(d.h.chat_group_img);
        this.aSE = (TextView) findViewById(d.h.chat_group_desc);
        com.baidu.tbadk.core.util.ai.c(this.axQ, d.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ai.c(this.cAj, d.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ai.c(this.aSE, d.e.cp_cont_f, 1);
        this.cAj.setHintTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_e));
        this.cAj.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ajQ();
    }

    public void ajQ() {
        this.aMc.setFocusable(true);
        this.aMc.setFocusableInTouchMode(true);
        this.aMc.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cAj != null) {
            return com.baidu.adp.lib.util.j.a(this.cAj.getText(), null);
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
        this.dAb = shareFromPBMsgData;
        wP();
    }

    private void wP() {
        this.axQ.setText(this.dAb.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dAb.getImageUrl());
        this.deq.setTag(this.dAb.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dAb.getContent());
        this.aSE.setText(this.dAb.getContent());
    }
}
