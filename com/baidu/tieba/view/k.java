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
public final class k extends LinearLayout {
    private LinearLayout aMt;
    private TextView aWo;
    private TextView axj;
    private TbImageView dAR;
    private ShareFromPBMsgData dWk;
    private EditText ddQ;

    public EditText getChatMsgView() {
        return this.ddQ;
    }

    public void I(String str, boolean z) {
        if (this.dAR != null) {
            this.dAR.startLoad(str, z ? 17 : 18, false);
        }
    }

    public k(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMt = (LinearLayout) findViewById(d.g.share_content);
        this.axj = (TextView) findViewById(d.g.share_title_view);
        this.ddQ = (EditText) findViewById(d.g.chat_msg);
        this.dAR = (TbImageView) findViewById(d.g.chat_group_img);
        this.aWo = (TextView) findViewById(d.g.chat_group_desc);
        aj.c(this.axj, d.C0096d.cp_cont_b, 1);
        aj.c(this.ddQ, d.C0096d.cp_cont_b, 2);
        aj.c(this.aWo, d.C0096d.cp_cont_f, 1);
        this.ddQ.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        this.ddQ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        arm();
    }

    public void arm() {
        this.aMt.setFocusable(true);
        this.aMt.setFocusableInTouchMode(true);
        this.aMt.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddQ != null) {
            return com.baidu.adp.lib.util.k.a(this.ddQ.getText(), null);
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
        this.dWk = shareFromPBMsgData;
        wp();
    }

    private void wp() {
        this.axj.setText(this.dWk.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dWk.getImageUrl());
        this.dAR.setTag(this.dWk.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dWk.getContent());
        this.aWo.setText(this.dWk.getContent());
    }
}
