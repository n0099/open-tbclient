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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout bFz;
    private TbImageView fYw;
    private TextView fYx;
    private EditText fzM;
    private ShareFromPBMsgData gtR;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fzM;
    }

    public void ag(String str, boolean z) {
        if (this.fYw != null) {
            this.fYw.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bFz = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.fzM = (EditText) findViewById(d.g.chat_msg);
        this.fYw = (TbImageView) findViewById(d.g.chat_group_img);
        this.fYx = (TextView) findViewById(d.g.chat_group_desc);
        al.d(this.title, d.C0277d.cp_cont_b, 1);
        al.d(this.fzM, d.C0277d.cp_cont_b, 2);
        al.d(this.fYx, d.C0277d.cp_cont_f, 1);
        this.fzM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.fzM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bkf();
    }

    public void bkf() {
        this.bFz.setFocusable(true);
        this.bFz.setFocusableInTouchMode(true);
        this.bFz.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzM != null) {
            return com.baidu.adp.lib.util.k.a(this.fzM.getText(), null);
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
        this.gtR = shareFromPBMsgData;
        GP();
    }

    private void GP() {
        this.title.setText(this.gtR.getTitle());
        this.fYw.setTag(this.gtR.getImageUrl());
        this.fYx.setText(this.gtR.getContent());
    }
}
