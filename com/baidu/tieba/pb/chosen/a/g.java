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
    private LinearLayout bCu;
    private TextView bMr;
    private EditText dZg;
    private TbImageView eti;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dZg;
    }

    public void G(String str, boolean z) {
        if (this.eti != null) {
            this.eti.startLoad(str, z ? 17 : 18, false);
        }
    }

    public g(Context context) {
        super(context);
        bA(context);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.bCu = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        aj.e(this.title, d.C0141d.cp_cont_b, 1);
        this.dZg = (EditText) findViewById(d.g.chat_msg);
        this.eti = (TbImageView) findViewById(d.g.chat_group_img);
        this.bMr = (TextView) findViewById(d.g.chat_group_desc);
        aj.e(this.dZg, d.C0141d.cp_cont_b, 2);
        aj.e(this.bMr, d.C0141d.cp_cont_f, 1);
        this.dZg.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        this.dZg.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAV();
    }

    public void aAV() {
        this.bCu.setFocusable(true);
        this.bCu.setFocusableInTouchMode(true);
        this.bCu.requestFocus();
    }

    public void setDesc(String str) {
        if (this.bMr != null) {
            this.bMr.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dZg != null) {
            return k.a(this.dZg.getText(), null);
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
