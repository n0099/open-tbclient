package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout aMU;
    private TbImageView dNL;
    private EditText dtM;
    private TextView due;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dtM;
    }

    public void D(String str, boolean z) {
        if (this.dNL != null) {
            this.dNL.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bo(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        bo(context);
    }

    private void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMU = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        ak.c(this.title, d.C0126d.cp_cont_b, 1);
        this.dtM = (EditText) findViewById(d.g.chat_msg);
        this.dNL = (TbImageView) findViewById(d.g.chat_group_img);
        this.due = (TextView) findViewById(d.g.chat_group_desc);
        ak.c(this.dtM, d.C0126d.cp_cont_b, 2);
        ak.c(this.due, d.C0126d.cp_cont_f, 1);
        this.dtM.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.dtM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        avQ();
    }

    public void avQ() {
        this.aMU.setFocusable(true);
        this.aMU.setFocusableInTouchMode(true);
        this.aMU.requestFocus();
    }

    public void setDesc(String str) {
        if (this.due != null) {
            this.due.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dtM != null) {
            return k.a(this.dtM.getText(), null);
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
