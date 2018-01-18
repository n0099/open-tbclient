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
public final class l extends LinearLayout {
    private LinearLayout bAs;
    private TextView bKp;
    private TextView blA;
    private EditText dUS;
    private ShareFromPBMsgData eJS;
    private TbImageView eow;

    public EditText getChatMsgView() {
        return this.dUS;
    }

    public void J(String str, boolean z) {
        if (this.eow != null) {
            this.eow.startLoad(str, z ? 17 : 18, false);
        }
    }

    public l(Context context) {
        super(context);
        bE(context);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bAs = (LinearLayout) findViewById(d.g.share_content);
        this.blA = (TextView) findViewById(d.g.share_title_view);
        this.dUS = (EditText) findViewById(d.g.chat_msg);
        this.eow = (TbImageView) findViewById(d.g.chat_group_img);
        this.bKp = (TextView) findViewById(d.g.chat_group_desc);
        aj.e(this.blA, d.C0107d.cp_cont_b, 1);
        aj.e(this.dUS, d.C0107d.cp_cont_b, 2);
        aj.e(this.bKp, d.C0107d.cp_cont_f, 1);
        this.dUS.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        this.dUS.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azy();
    }

    public void azy() {
        this.bAs.setFocusable(true);
        this.bAs.setFocusableInTouchMode(true);
        this.bAs.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dUS != null) {
            return com.baidu.adp.lib.util.k.a(this.dUS.getText(), null);
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
        this.eJS = shareFromPBMsgData;
        DE();
    }

    private void DE() {
        this.blA.setText(this.eJS.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.eJS.getImageUrl());
        this.eow.setTag(this.eJS.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.eJS.getContent());
        this.bKp.setText(this.eJS.getContent());
    }
}
