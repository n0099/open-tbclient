package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class g extends LinearLayout {
    private LinearLayout bCE;
    private TextView bMB;
    private EditText dZb;
    private TbImageView ete;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dZb;
    }

    public void H(String str, boolean z) {
        if (this.ete != null) {
            this.ete.startLoad(str, z ? 17 : 18, false);
        }
    }

    public g(Context context) {
        super(context);
        bA(context);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bCE = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        aj.e(this.title, d.C0140d.cp_cont_b, 1);
        this.dZb = (EditText) findViewById(d.g.chat_msg);
        this.ete = (TbImageView) findViewById(d.g.chat_group_img);
        this.bMB = (TextView) findViewById(d.g.chat_group_desc);
        aj.e(this.dZb, d.C0140d.cp_cont_b, 2);
        aj.e(this.bMB, d.C0140d.cp_cont_f, 1);
        this.dZb.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        this.dZb.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAU();
    }

    public void aAU() {
        this.bCE.setFocusable(true);
        this.bCE.setFocusableInTouchMode(true);
        this.bCE.requestFocus();
    }

    public void setDesc(String str) {
        if (this.bMB != null) {
            this.bMB.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dZb != null) {
            return k.a(this.dZb.getText(), null);
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
