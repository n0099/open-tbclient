package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class hh extends LinearLayout {
    private TextView aOR;
    private LinearLayout ame;
    private TextView auE;
    private TbImageView cMu;
    private EditText cjG;
    private ShareFromPBMsgData dim;

    public EditText getChatMsgView() {
        return this.cjG;
    }

    public void D(String str, boolean z) {
        if (this.cMu != null) {
            this.cMu.c(str, z ? 17 : 18, false);
        }
    }

    public hh(Context context) {
        super(context);
        bp(context);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.ame = (LinearLayout) findViewById(w.h.share_content);
        this.auE = (TextView) findViewById(w.h.share_title_view);
        this.cjG = (EditText) findViewById(w.h.chat_msg);
        this.cMu = (TbImageView) findViewById(w.h.chat_group_img);
        this.aOR = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.aq.c(this.auE, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.cjG, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.aq.c(this.aOR, w.e.cp_cont_f, 1);
        this.cjG.setHintTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_e));
        this.cjG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aem();
    }

    public void aem() {
        this.ame.setFocusable(true);
        this.ame.setFocusableInTouchMode(true);
        this.ame.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cjG != null) {
            return com.baidu.adp.lib.util.j.a(this.cjG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dim = shareFromPBMsgData;
        we();
    }

    private void we() {
        this.auE.setText(this.dim.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dim.getImageUrl());
        this.cMu.setTag(this.dim.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dim.getContent());
        this.aOR.setText(this.dim.getContent());
    }
}
