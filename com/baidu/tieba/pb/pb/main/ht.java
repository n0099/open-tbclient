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
public final class ht extends LinearLayout {
    private LinearLayout aJF;
    private TextView aQj;
    private TextView avH;
    private TbImageView cUr;
    private EditText crG;
    private ShareFromPBMsgData dqi;

    public EditText getChatMsgView() {
        return this.crG;
    }

    public void I(String str, boolean z) {
        if (this.cUr != null) {
            this.cUr.c(str, z ? 17 : 18, false);
        }
    }

    public ht(Context context) {
        super(context);
        bj(context);
    }

    private void bj(Context context) {
        LayoutInflater.from(context).inflate(w.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aJF = (LinearLayout) findViewById(w.h.share_content);
        this.avH = (TextView) findViewById(w.h.share_title_view);
        this.crG = (EditText) findViewById(w.h.chat_msg);
        this.cUr = (TbImageView) findViewById(w.h.chat_group_img);
        this.aQj = (TextView) findViewById(w.h.chat_group_desc);
        com.baidu.tbadk.core.util.as.c(this.avH, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.as.c(this.crG, w.e.cp_cont_b, 2);
        com.baidu.tbadk.core.util.as.c(this.aQj, w.e.cp_cont_f, 1);
        this.crG.setHintTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_e));
        this.crG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aia();
    }

    public void aia() {
        this.aJF.setFocusable(true);
        this.aJF.setFocusableInTouchMode(true);
        this.aJF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.crG != null) {
            return com.baidu.adp.lib.util.j.a(this.crG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dqi = shareFromPBMsgData;
        ww();
    }

    private void ww() {
        this.avH.setText(this.dqi.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dqi.getImageUrl());
        this.cUr.setTag(this.dqi.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dqi.getContent());
        this.aQj.setText(this.dqi.getContent());
    }
}
