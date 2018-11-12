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
    private LinearLayout aGg;
    private ShareFromPBMsgData eTD;
    private EditText eaM;
    private TextView ebd;
    private TbImageView eyo;
    private TextView title;

    public EditText getChatMsgView() {
        return this.eaM;
    }

    public void L(String str, boolean z) {
        if (this.eyo != null) {
            this.eyo.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cn(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        cn(context);
    }

    private void cn(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aGg = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        this.eaM = (EditText) findViewById(e.g.chat_msg);
        this.eyo = (TbImageView) findViewById(e.g.chat_group_img);
        this.ebd = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.title, e.d.cp_cont_b, 1);
        al.c(this.eaM, e.d.cp_cont_b, 2);
        al.c(this.ebd, e.d.cp_cont_f, 1);
        this.eaM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.eaM.setPadding(context.getResources().getDimensionPixelSize(e.C0200e.ds20), 0, 0, 0);
        aGm();
    }

    public void aGm() {
        this.aGg.setFocusable(true);
        this.aGg.setFocusableInTouchMode(true);
        this.aGg.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.eaM != null) {
            return com.baidu.adp.lib.util.k.a(this.eaM.getText(), null);
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
        this.eTD = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.eTD.getTitle());
        this.eyo.setTag(this.eTD.getImageUrl());
        this.ebd.setText(this.eTD.getContent());
    }
}
