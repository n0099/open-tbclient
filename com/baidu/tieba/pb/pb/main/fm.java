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
public final class fm extends LinearLayout {
    private LinearLayout aCx;
    private TextView aGI;
    private TextView apm;
    private TbImageView bNv;
    private EditText brF;
    private ShareFromPBMsgData cgW;

    public EditText getChatMsgView() {
        return this.brF;
    }

    public void x(String str, boolean z) {
        if (this.bNv != null) {
            this.bNv.d(str, z ? 17 : 18, false);
        }
    }

    public fm(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(t.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aCx = (LinearLayout) findViewById(t.g.share_content);
        this.apm = (TextView) findViewById(t.g.share_title_view);
        this.brF = (EditText) findViewById(t.g.chat_msg);
        this.bNv = (TbImageView) findViewById(t.g.chat_group_img);
        this.aGI = (TextView) findViewById(t.g.chat_group_desc);
        com.baidu.tbadk.core.util.ar.b(this.apm, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.ar.b(this.brF, t.d.cp_cont_b, 2);
        com.baidu.tbadk.core.util.ar.b(this.aGI, t.d.cp_cont_f, 1);
        this.brF.setHintTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_e));
        this.brF.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Sx();
    }

    public void Sx() {
        this.aCx.setFocusable(true);
        this.aCx.setFocusableInTouchMode(true);
        this.aCx.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.brF != null) {
            return com.baidu.adp.lib.util.j.a(this.brF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cgW = shareFromPBMsgData;
        wV();
    }

    private void wV() {
        this.apm.setText(this.cgW.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.cgW.getImageUrl());
        this.bNv.setTag(this.cgW.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.cgW.getContent());
        this.aGI.setText(this.cgW.getContent());
    }
}
