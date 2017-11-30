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
    private LinearLayout aMp;
    private TextView aWm;
    private TextView axe;
    private ShareFromPBMsgData dVf;
    private EditText dcJ;
    private TbImageView dzN;

    public EditText getChatMsgView() {
        return this.dcJ;
    }

    public void H(String str, boolean z) {
        if (this.dzN != null) {
            this.dzN.startLoad(str, z ? 17 : 18, false);
        }
    }

    public k(Context context) {
        super(context);
        bw(context);
    }

    private void bw(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMp = (LinearLayout) findViewById(d.g.share_content);
        this.axe = (TextView) findViewById(d.g.share_title_view);
        this.dcJ = (EditText) findViewById(d.g.chat_msg);
        this.dzN = (TbImageView) findViewById(d.g.chat_group_img);
        this.aWm = (TextView) findViewById(d.g.chat_group_desc);
        aj.c(this.axe, d.C0082d.cp_cont_b, 1);
        aj.c(this.dcJ, d.C0082d.cp_cont_b, 2);
        aj.c(this.aWm, d.C0082d.cp_cont_f, 1);
        this.dcJ.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        this.dcJ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        ard();
    }

    public void ard() {
        this.aMp.setFocusable(true);
        this.aMp.setFocusableInTouchMode(true);
        this.aMp.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dcJ != null) {
            return com.baidu.adp.lib.util.k.a(this.dcJ.getText(), null);
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
        this.dVf = shareFromPBMsgData;
        wr();
    }

    private void wr() {
        this.axe.setText(this.dVf.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dVf.getImageUrl());
        this.dzN.setTag(this.dVf.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dVf.getContent());
        this.aWm.setText(this.dVf.getContent());
    }
}
