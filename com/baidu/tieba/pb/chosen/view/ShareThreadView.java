package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout bFy;
    private TbImageView fYw;
    private TextView fYx;
    private EditText fzM;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fzM;
    }

    public void ag(String str, boolean z) {
        if (this.fYw != null) {
            this.fYw.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bFy = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        al.d(this.title, d.C0277d.cp_cont_b, 1);
        this.fzM = (EditText) findViewById(d.g.chat_msg);
        this.fYw = (TbImageView) findViewById(d.g.chat_group_img);
        this.fYx = (TextView) findViewById(d.g.chat_group_desc);
        al.d(this.fzM, d.C0277d.cp_cont_b, 2);
        al.d(this.fYx, d.C0277d.cp_cont_f, 1);
        this.fzM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.fzM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bkf();
    }

    public void bkf() {
        this.bFy.setFocusable(true);
        this.bFy.setFocusableInTouchMode(true);
        this.bFy.requestFocus();
    }

    public void setDesc(String str) {
        if (this.fYx != null) {
            this.fYx.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.fzM != null) {
            return k.a(this.fzM.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
