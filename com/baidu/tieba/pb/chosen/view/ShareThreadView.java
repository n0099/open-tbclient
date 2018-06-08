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
/* loaded from: classes3.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout aUT;
    private EditText dEh;
    private TextView dEz;
    private TbImageView eae;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dEh;
    }

    public void D(String str, boolean z) {
        if (this.eae != null) {
            this.eae.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        by(context);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(d.i.thread_to_group_share_view, this);
        setOrientation(1);
        this.aUT = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        al.c(this.title, d.C0141d.cp_cont_b, 1);
        this.dEh = (EditText) findViewById(d.g.chat_msg);
        this.eae = (TbImageView) findViewById(d.g.chat_group_img);
        this.dEz = (TextView) findViewById(d.g.chat_group_desc);
        al.c(this.dEh, d.C0141d.cp_cont_b, 2);
        al.c(this.dEz, d.C0141d.cp_cont_f, 1);
        this.dEh.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        this.dEh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azY();
    }

    public void azY() {
        this.aUT.setFocusable(true);
        this.aUT.setFocusableInTouchMode(true);
        this.aUT.requestFocus();
    }

    public void setDesc(String str) {
        if (this.dEz != null) {
            this.dEz.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dEh != null) {
            return k.a(this.dEh.getText(), null);
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
