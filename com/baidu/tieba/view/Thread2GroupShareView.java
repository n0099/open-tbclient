package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout aFq;
    private TextView dZK;
    private EditText dZt;
    private ShareFromPBMsgData eSl;
    private TbImageView ewT;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dZt;
    }

    public void L(String str, boolean z) {
        if (this.ewT != null) {
            this.ewT.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cs(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        cs(context);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        this.dZt = (EditText) findViewById(e.g.chat_msg);
        this.ewT = (TbImageView) findViewById(e.g.chat_group_img);
        this.dZK = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.title, e.d.cp_cont_b, 1);
        al.c(this.dZt, e.d.cp_cont_b, 2);
        al.c(this.dZK, e.d.cp_cont_f, 1);
        this.dZt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dZt.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZt != null) {
            return com.baidu.adp.lib.util.k.a(this.dZt.getText(), null);
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
        this.eSl = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.eSl.getTitle());
        this.ewT.setTag(this.eSl.getImageUrl());
        this.dZK.setText(this.eSl.getContent());
    }
}
