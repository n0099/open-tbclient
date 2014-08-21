package com.baidu.tieba.pb.main;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes.dex */
public final class cw extends LinearLayout {
    private EditText a;
    private BarImageView b;
    private TextView c;
    private ShareFromPBMsgData d;

    public EditText getChatMsgView() {
        return this.a;
    }

    public void a(String str, boolean z) {
        if (this.b != null) {
            this.b.a(str, z ? 17 : 18, false);
        }
    }

    public cw(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.thread_to_group_share_view, this);
        setOrientation(1);
        this.a = (EditText) findViewById(com.baidu.tieba.u.chat_msg);
        this.b = (BarImageView) findViewById(com.baidu.tieba.u.chat_group_img);
        this.c = (TextView) findViewById(com.baidu.tieba.u.chat_group_desc);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.a.setBackgroundResource(com.baidu.tieba.t.inputbox_share_1);
            this.a.setTextColor(context.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
            this.c.setTextColor(context.getResources().getColor(com.baidu.tieba.r.dialog_bdalert_title_1));
        } else {
            this.a.setBackgroundResource(com.baidu.tieba.t.inputbox_share);
            this.a.setTextColor(context.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
            this.c.setTextColor(context.getResources().getColor(com.baidu.tieba.r.dialog_bdalert_title));
        }
        this.a.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds20), 0, 0, 0);
    }

    public String getLeaveMsg() {
        if (this.a != null) {
            return com.baidu.adp.lib.util.i.a(this.a.getText(), (String) null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.d = shareFromPBMsgData;
        a();
    }

    private void a() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.d.getImageUrl());
        this.b.setTag(this.d.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.d.getContent());
        this.c.setText(this.d.getContent());
    }
}
