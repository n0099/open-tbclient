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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout aKk;
    private TbImageView eIH;
    private EditText ekM;
    private TextView eld;
    private TextView title;

    public EditText getChatMsgView() {
        return this.ekM;
    }

    public void M(String str, boolean z) {
        if (this.eIH != null) {
            this.eIH.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        cr(context);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aKk = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        al.c(this.title, e.d.cp_cont_b, 1);
        this.ekM = (EditText) findViewById(e.g.chat_msg);
        this.eIH = (TbImageView) findViewById(e.g.chat_group_img);
        this.eld = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.ekM, e.d.cp_cont_b, 2);
        al.c(this.eld, e.d.cp_cont_f, 1);
        this.ekM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ekM.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aJl();
    }

    public void aJl() {
        this.aKk.setFocusable(true);
        this.aKk.setFocusableInTouchMode(true);
        this.aKk.requestFocus();
    }

    public void setDesc(String str) {
        if (this.eld != null) {
            this.eld.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.ekM != null) {
            return k.a(this.ekM.getText(), null);
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
