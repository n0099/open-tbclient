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
public final class gl extends LinearLayout {
    private LinearLayout aBh;
    private TextView aHe;
    private EditText bWf;
    private TbImageView cFV;
    private ShareFromPBMsgData daK;
    private TextView title;

    public EditText getChatMsgView() {
        return this.bWf;
    }

    public void A(String str, boolean z) {
        if (this.cFV != null) {
            this.cFV.c(str, z ? 17 : 18, false);
        }
    }

    public gl(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aBh = (LinearLayout) findViewById(u.g.share_content);
        this.title = (TextView) findViewById(u.g.share_title_view);
        this.bWf = (EditText) findViewById(u.g.chat_msg);
        this.cFV = (TbImageView) findViewById(u.g.chat_group_img);
        this.aHe = (TextView) findViewById(u.g.chat_group_desc);
        com.baidu.tbadk.core.util.av.c(this.title, u.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.av.c(this.bWf, u.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.av.c(this.aHe, u.d.cp_cont_f, 1);
        this.bWf.setHintTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_e));
        this.bWf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        abd();
    }

    public void abd() {
        this.aBh.setFocusable(true);
        this.aBh.setFocusableInTouchMode(true);
        this.aBh.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bWf != null) {
            return com.baidu.adp.lib.util.j.a(this.bWf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.daK = shareFromPBMsgData;
        uY();
    }

    private void uY() {
        this.title.setText(this.daK.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.daK.getImageUrl());
        this.cFV.setTag(this.daK.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.daK.getContent());
        this.aHe.setText(this.daK.getContent());
    }
}
