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
    private LinearLayout aLG;
    private TextView aTd;
    private TextView awv;
    private EditText cTh;
    private ShareFromPBMsgData dNm;
    private TbImageView drG;

    public EditText getChatMsgView() {
        return this.cTh;
    }

    public void G(String str, boolean z) {
        if (this.drG != null) {
            this.drG.startLoad(str, z ? 17 : 18, false);
        }
    }

    public k(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aLG = (LinearLayout) findViewById(d.g.share_content);
        this.awv = (TextView) findViewById(d.g.share_title_view);
        this.cTh = (EditText) findViewById(d.g.chat_msg);
        this.drG = (TbImageView) findViewById(d.g.chat_group_img);
        this.aTd = (TextView) findViewById(d.g.chat_group_desc);
        aj.c(this.awv, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTh, d.C0080d.cp_cont_b, 2);
        aj.c(this.aTd, d.C0080d.cp_cont_f, 1);
        this.cTh.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.cTh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aoT();
    }

    public void aoT() {
        this.aLG.setFocusable(true);
        this.aLG.setFocusableInTouchMode(true);
        this.aLG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTh != null) {
            return com.baidu.adp.lib.util.k.a(this.cTh.getText(), null);
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
        this.dNm = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awv.setText(this.dNm.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dNm.getImageUrl());
        this.drG.setTag(this.dNm.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dNm.getContent());
        this.aTd.setText(this.dNm.getContent());
    }
}
