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
    private LinearLayout bFu;
    private TbImageView fYJ;
    private TextView fYK;
    private EditText fzZ;
    private ShareFromPBMsgData gue;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fzZ;
    }

    public void ag(String str, boolean z) {
        if (this.fYJ != null) {
            this.fYJ.startLoad(str, z ? 17 : 18, false);
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
        this.bFu = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.fzZ = (EditText) findViewById(d.g.chat_msg);
        this.fYJ = (TbImageView) findViewById(d.g.chat_group_img);
        this.fYK = (TextView) findViewById(d.g.chat_group_desc);
        al.d(this.title, d.C0236d.cp_cont_b, 1);
        al.d(this.fzZ, d.C0236d.cp_cont_b, 2);
        al.d(this.fYK, d.C0236d.cp_cont_f, 1);
        this.fzZ.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        this.fzZ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bki();
    }

    public void bki() {
        this.bFu.setFocusable(true);
        this.bFu.setFocusableInTouchMode(true);
        this.bFu.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzZ != null) {
            return com.baidu.adp.lib.util.k.a(this.fzZ.getText(), null);
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
        this.gue = shareFromPBMsgData;
        GR();
    }

    private void GR() {
        this.title.setText(this.gue.getTitle());
        this.fYJ.setTag(this.gue.getImageUrl());
        this.fYK.setText(this.gue.getContent());
    }
}
