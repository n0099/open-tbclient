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
    private LinearLayout aAJ;
    private TextView dRP;
    private EditText dRx;
    private TbImageView epd;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dRx;
    }

    public void E(String str, boolean z) {
        if (this.epd != null) {
            this.epd.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cf(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        cf(context);
    }

    private void cf(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aAJ = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        al.c(this.title, e.d.cp_cont_b, 1);
        this.dRx = (EditText) findViewById(e.g.chat_msg);
        this.epd = (TbImageView) findViewById(e.g.chat_group_img);
        this.dRP = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.dRx, e.d.cp_cont_b, 2);
        al.c(this.dRP, e.d.cp_cont_f, 1);
        this.dRx.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dRx.setPadding(context.getResources().getDimensionPixelSize(e.C0141e.ds20), 0, 0, 0);
        aDw();
    }

    public void aDw() {
        this.aAJ.setFocusable(true);
        this.aAJ.setFocusableInTouchMode(true);
        this.aAJ.requestFocus();
    }

    public void setDesc(String str) {
        if (this.dRP != null) {
            this.dRP.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dRx != null) {
            return k.a(this.dRx.getText(), null);
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
