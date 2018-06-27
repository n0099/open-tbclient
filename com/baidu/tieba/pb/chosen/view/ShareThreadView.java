package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout aya;
    private EditText dHC;
    private TextView dHU;
    private TbImageView edX;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dHC;
    }

    public void E(String str, boolean z) {
        if (this.edX != null) {
            this.edX.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bx(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        bx(context);
    }

    private void bx(Context context) {
        LayoutInflater.from(context).inflate(d.i.thread_to_group_share_view, this);
        setOrientation(1);
        this.aya = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        am.c(this.title, d.C0142d.cp_cont_b, 1);
        this.dHC = (EditText) findViewById(d.g.chat_msg);
        this.edX = (TbImageView) findViewById(d.g.chat_group_img);
        this.dHU = (TextView) findViewById(d.g.chat_group_desc);
        am.c(this.dHC, d.C0142d.cp_cont_b, 2);
        am.c(this.dHU, d.C0142d.cp_cont_f, 1);
        this.dHC.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        this.dHC.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAF();
    }

    public void aAF() {
        this.aya.setFocusable(true);
        this.aya.setFocusableInTouchMode(true);
        this.aya.requestFocus();
    }

    public void setDesc(String str) {
        if (this.dHU != null) {
            this.dHU.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dHC != null) {
            return k.a(this.dHC.getText(), null);
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
