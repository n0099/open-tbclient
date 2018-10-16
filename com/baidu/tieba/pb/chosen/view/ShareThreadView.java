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
    private LinearLayout aFq;
    private TextView dZJ;
    private EditText dZs;
    private TbImageView ewS;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dZs;
    }

    public void L(String str, boolean z) {
        if (this.ewS != null) {
            this.ewS.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cs(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        cs(context);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.share_content);
        this.title = (TextView) findViewById(e.g.share_title_view);
        al.c(this.title, e.d.cp_cont_b, 1);
        this.dZs = (EditText) findViewById(e.g.chat_msg);
        this.ewS = (TbImageView) findViewById(e.g.chat_group_img);
        this.dZJ = (TextView) findViewById(e.g.chat_group_desc);
        al.c(this.dZs, e.d.cp_cont_b, 2);
        al.c(this.dZJ, e.d.cp_cont_f, 1);
        this.dZs.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dZs.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public void setDesc(String str) {
        if (this.dZJ != null) {
            this.dZJ.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.dZs != null) {
            return k.a(this.dZs.getText(), null);
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
