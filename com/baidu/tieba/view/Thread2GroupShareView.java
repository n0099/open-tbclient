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
    private LinearLayout aKl;
    private TbImageView eII;
    private EditText ekN;
    private TextView ele;
    private ShareFromPBMsgData fdX;
    private TextView title;

    public EditText getChatMsgView() {
        return this.ekN;
    }

    public void M(String str, boolean z) {
        if (this.eII != null) {
            this.eII.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        cr(context);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aKl = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        this.ekN = (EditText) findViewById(e.g.chat_msg);
        this.eII = (TbImageView) findViewById(e.g.chat_group_img);
        this.ele = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.title, e.d.cp_cont_b, 1);
        al.c(this.ekN, e.d.cp_cont_b, 2);
        al.c(this.ele, e.d.cp_cont_f, 1);
        this.ekN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ekN.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aJl();
    }

    public void aJl() {
        this.aKl.setFocusable(true);
        this.aKl.setFocusableInTouchMode(true);
        this.aKl.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekN != null) {
            return com.baidu.adp.lib.util.k.a(this.ekN.getText(), null);
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
        this.fdX = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.fdX.getTitle());
        this.eII.setTag(this.fdX.getImageUrl());
        this.ele.setText(this.fdX.getContent());
    }
}
