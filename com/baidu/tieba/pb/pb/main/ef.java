package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public final class ef extends LinearLayout {
    private TextView aEp;
    private TextView agd;
    private TbImageView bGf;
    private ShareFromPBMsgData bYw;
    private EditText bkR;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bkR;
    }

    public void x(String str, boolean z) {
        if (this.bGf != null) {
            this.bGf.d(str, z ? 17 : 18, false);
        }
    }

    public ef(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.f.share_content);
        this.agd = (TextView) findViewById(n.f.share_title_view);
        this.bkR = (EditText) findViewById(n.f.chat_msg);
        this.bGf = (TbImageView) findViewById(n.f.chat_group_img);
        this.aEp = (TextView) findViewById(n.f.chat_group_desc);
        com.baidu.tbadk.core.util.as.b(this.agd, n.c.cp_cont_b, 1);
        com.baidu.tbadk.core.util.as.b(this.bkR, n.c.cp_cont_b, 2);
        com.baidu.tbadk.core.util.as.b(this.aEp, n.c.cp_cont_f, 1);
        this.bkR.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_e));
        this.bkR.setPadding(context.getResources().getDimensionPixelSize(n.d.ds20), 0, 0, 0);
        Qb();
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bkR != null) {
            return com.baidu.adp.lib.util.j.a(this.bkR.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bYw = shareFromPBMsgData;
        wd();
    }

    private void wd() {
        this.agd.setText(this.bYw.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.bYw.getImageUrl());
        this.bGf.setTag(this.bYw.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bYw.getContent());
        this.aEp.setText(this.bYw.getContent());
    }
}
