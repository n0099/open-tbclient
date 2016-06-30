package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public final class gh extends LinearLayout {
    private LinearLayout aAr;
    private TextView aGn;
    private EditText bUf;
    private TbImageView cDg;
    private ShareFromPBMsgData cXN;
    private TextView title;

    public EditText getChatMsgView() {
        return this.bUf;
    }

    public void A(String str, boolean z) {
        if (this.cDg != null) {
            this.cDg.c(str, z ? 17 : 18, false);
        }
    }

    public gh(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aAr = (LinearLayout) findViewById(u.g.share_content);
        this.title = (TextView) findViewById(u.g.share_title_view);
        this.bUf = (EditText) findViewById(u.g.chat_msg);
        this.cDg = (TbImageView) findViewById(u.g.chat_group_img);
        this.aGn = (TextView) findViewById(u.g.chat_group_desc);
        com.baidu.tbadk.core.util.av.c(this.title, u.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.av.c(this.bUf, u.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.av.c(this.aGn, u.d.cp_cont_f, 1);
        this.bUf.setHintTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_e));
        this.bUf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        aaB();
    }

    public void aaB() {
        this.aAr.setFocusable(true);
        this.aAr.setFocusableInTouchMode(true);
        this.aAr.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bUf != null) {
            return com.baidu.adp.lib.util.j.a(this.bUf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cXN = shareFromPBMsgData;
        uY();
    }

    private void uY() {
        this.title.setText(this.cXN.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.cXN.getImageUrl());
        this.cDg.setTag(this.cXN.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.cXN.getContent());
        this.aGn.setText(this.cXN.getContent());
    }
}
