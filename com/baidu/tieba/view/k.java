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
    private LinearLayout aLO;
    private TextView aTl;
    private TextView awD;
    private EditText cTB;
    private ShareFromPBMsgData dNr;
    private TbImageView dsa;

    public EditText getChatMsgView() {
        return this.cTB;
    }

    public void G(String str, boolean z) {
        if (this.dsa != null) {
            this.dsa.startLoad(str, z ? 17 : 18, false);
        }
    }

    public k(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aLO = (LinearLayout) findViewById(d.g.share_content);
        this.awD = (TextView) findViewById(d.g.share_title_view);
        this.cTB = (EditText) findViewById(d.g.chat_msg);
        this.dsa = (TbImageView) findViewById(d.g.chat_group_img);
        this.aTl = (TextView) findViewById(d.g.chat_group_desc);
        aj.c(this.awD, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTB, d.C0080d.cp_cont_b, 2);
        aj.c(this.aTl, d.C0080d.cp_cont_f, 1);
        this.cTB.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.cTB.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        apj();
    }

    public void apj() {
        this.aLO.setFocusable(true);
        this.aLO.setFocusableInTouchMode(true);
        this.aLO.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTB != null) {
            return com.baidu.adp.lib.util.k.a(this.cTB.getText(), null);
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
        this.dNr = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awD.setText(this.dNr.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dNr.getImageUrl());
        this.dsa.setTag(this.dNr.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dNr.getContent());
        this.aTl.setText(this.dNr.getContent());
    }
}
