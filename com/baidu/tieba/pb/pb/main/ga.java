package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class ga extends LinearLayout {
    private TextView aFL;
    private LinearLayout azz;
    private TbImageView bYs;
    private EditText bwz;
    private ShareFromPBMsgData csy;
    private TextView title;

    public EditText getChatMsgView() {
        return this.bwz;
    }

    public void z(String str, boolean z) {
        if (this.bYs != null) {
            this.bYs.c(str, z ? 17 : 18, false);
        }
    }

    public ga(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(t.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.azz = (LinearLayout) findViewById(t.g.share_content);
        this.title = (TextView) findViewById(t.g.share_title_view);
        this.bwz = (EditText) findViewById(t.g.chat_msg);
        this.bYs = (TbImageView) findViewById(t.g.chat_group_img);
        this.aFL = (TextView) findViewById(t.g.chat_group_desc);
        com.baidu.tbadk.core.util.at.c(this.title, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.c(this.bwz, t.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.at.c(this.aFL, t.d.cp_cont_f, 1);
        this.bwz.setHintTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_e));
        this.bwz.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Um();
    }

    public void Um() {
        this.azz.setFocusable(true);
        this.azz.setFocusableInTouchMode(true);
        this.azz.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwz != null) {
            return com.baidu.adp.lib.util.j.a(this.bwz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.csy = shareFromPBMsgData;
        uX();
    }

    private void uX() {
        this.title.setText(this.csy.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.csy.getImageUrl());
        this.bYs.setTag(this.csy.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.csy.getContent());
        this.aFL.setText(this.csy.getContent());
    }
}
