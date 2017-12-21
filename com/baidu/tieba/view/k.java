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
    private LinearLayout aMw;
    private TextView aWs;
    private TextView axm;
    private TbImageView dAV;
    private ShareFromPBMsgData dWo;
    private EditText ddU;

    public EditText getChatMsgView() {
        return this.ddU;
    }

    public void I(String str, boolean z) {
        if (this.dAV != null) {
            this.dAV.startLoad(str, z ? 17 : 18, false);
        }
    }

    public k(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMw = (LinearLayout) findViewById(d.g.share_content);
        this.axm = (TextView) findViewById(d.g.share_title_view);
        this.ddU = (EditText) findViewById(d.g.chat_msg);
        this.dAV = (TbImageView) findViewById(d.g.chat_group_img);
        this.aWs = (TextView) findViewById(d.g.chat_group_desc);
        aj.c(this.axm, d.C0095d.cp_cont_b, 1);
        aj.c(this.ddU, d.C0095d.cp_cont_b, 2);
        aj.c(this.aWs, d.C0095d.cp_cont_f, 1);
        this.ddU.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
        this.ddU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        arn();
    }

    public void arn() {
        this.aMw.setFocusable(true);
        this.aMw.setFocusableInTouchMode(true);
        this.aMw.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddU != null) {
            return com.baidu.adp.lib.util.k.a(this.ddU.getText(), null);
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
        this.dWo = shareFromPBMsgData;
        wp();
    }

    private void wp() {
        this.axm.setText(this.dWo.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dWo.getImageUrl());
        this.dAV.setTag(this.dWo.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dWo.getContent());
        this.aWs.setText(this.dWo.getContent());
    }
}
