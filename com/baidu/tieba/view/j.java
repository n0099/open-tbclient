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
public final class j extends LinearLayout {
    private LinearLayout aKW;
    private TextView aSZ;
    private TextView avY;
    private EditText cJV;
    private ShareFromPBMsgData dFy;
    private TbImageView djQ;

    public EditText getChatMsgView() {
        return this.cJV;
    }

    public void I(String str, boolean z) {
        if (this.djQ != null) {
            this.djQ.c(str, z ? 17 : 18, false);
        }
    }

    public j(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.j.thread_to_group_share_view, this);
        setOrientation(1);
        this.aKW = (LinearLayout) findViewById(d.h.share_content);
        this.avY = (TextView) findViewById(d.h.share_title_view);
        this.cJV = (EditText) findViewById(d.h.chat_msg);
        this.djQ = (TbImageView) findViewById(d.h.chat_group_img);
        this.aSZ = (TextView) findViewById(d.h.chat_group_desc);
        aj.c(this.avY, d.e.cp_cont_b, 1);
        aj.c(this.cJV, d.e.cp_cont_b, 2);
        aj.c(this.aSZ, d.e.cp_cont_f, 1);
        this.cJV.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cJV.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ami();
    }

    public void ami() {
        this.aKW.setFocusable(true);
        this.aKW.setFocusableInTouchMode(true);
        this.aKW.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJV != null) {
            return com.baidu.adp.lib.util.k.a(this.cJV.getText(), null);
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
        this.dFy = shareFromPBMsgData;
        wg();
    }

    private void wg() {
        this.avY.setText(this.dFy.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.dFy.getImageUrl());
        this.djQ.setTag(this.dFy.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.dFy.getContent());
        this.aSZ.setText(this.dFy.getContent());
    }
}
