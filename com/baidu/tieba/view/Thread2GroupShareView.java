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
    private LinearLayout bFw;
    private TbImageView fYI;
    private TextView fYJ;
    private EditText fzY;
    private ShareFromPBMsgData gud;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fzY;
    }

    public void ag(String str, boolean z) {
        if (this.fYI != null) {
            this.fYI.startLoad(str, z ? 17 : 18, false);
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
        this.bFw = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.fzY = (EditText) findViewById(d.g.chat_msg);
        this.fYI = (TbImageView) findViewById(d.g.chat_group_img);
        this.fYJ = (TextView) findViewById(d.g.chat_group_desc);
        al.d(this.title, d.C0277d.cp_cont_b, 1);
        al.d(this.fzY, d.C0277d.cp_cont_b, 2);
        al.d(this.fYJ, d.C0277d.cp_cont_f, 1);
        this.fzY.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.fzY.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bkh();
    }

    public void bkh() {
        this.bFw.setFocusable(true);
        this.bFw.setFocusableInTouchMode(true);
        this.bFw.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzY != null) {
            return com.baidu.adp.lib.util.k.a(this.fzY.getText(), null);
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
        this.gud = shareFromPBMsgData;
        GR();
    }

    private void GR() {
        this.title.setText(this.gud.getTitle());
        this.fYI.setTag(this.gud.getImageUrl());
        this.fYJ.setText(this.gud.getContent());
    }
}
