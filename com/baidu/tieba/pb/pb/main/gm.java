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
public final class gm extends LinearLayout {
    private LinearLayout aDM;
    private TextView aJT;
    private TbImageView cSt;
    private EditText chn;
    private ShareFromPBMsgData dnP;
    private TextView title;

    public EditText getChatMsgView() {
        return this.chn;
    }

    public void F(String str, boolean z) {
        if (this.cSt != null) {
            this.cSt.c(str, z ? 17 : 18, false);
        }
    }

    public gm(Context context) {
        super(context);
        aC(context);
    }

    private void aC(Context context) {
        LayoutInflater.from(context).inflate(r.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aDM = (LinearLayout) findViewById(r.g.share_content);
        this.title = (TextView) findViewById(r.g.share_title_view);
        this.chn = (EditText) findViewById(r.g.chat_msg);
        this.cSt = (TbImageView) findViewById(r.g.chat_group_img);
        this.aJT = (TextView) findViewById(r.g.chat_group_desc);
        com.baidu.tbadk.core.util.av.c(this.title, r.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.av.c(this.chn, r.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.av.c(this.aJT, r.d.cp_cont_f, 1);
        this.chn.setHintTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_cont_e));
        this.chn.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        agc();
    }

    public void agc() {
        this.aDM.setFocusable(true);
        this.aDM.setFocusableInTouchMode(true);
        this.aDM.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chn != null) {
            return com.baidu.adp.lib.util.j.a(this.chn.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dnP = shareFromPBMsgData;
        ws();
    }

    private void ws() {
        this.title.setText(this.dnP.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dnP.getImageUrl());
        this.cSt.setTag(this.dnP.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dnP.getContent());
        this.aJT.setText(this.dnP.getContent());
    }
}
