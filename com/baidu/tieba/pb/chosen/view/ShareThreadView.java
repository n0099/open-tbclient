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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout bMZ;
    private EditText fQJ;
    private TbImageView gpL;
    private TextView gpM;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fQJ;
    }

    public void ai(String str, boolean z) {
        if (this.gpL != null) {
            this.gpL.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.bMZ = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        al.f(this.title, R.color.cp_cont_b, 1);
        this.fQJ = (EditText) findViewById(R.id.chat_msg);
        this.gpL = (TbImageView) findViewById(R.id.chat_group_img);
        this.gpM = (TextView) findViewById(R.id.chat_group_desc);
        al.f(this.fQJ, R.color.cp_cont_b, 2);
        al.f(this.gpM, R.color.cp_cont_f, 1);
        this.fQJ.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.fQJ.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brA();
    }

    public void brA() {
        this.bMZ.setFocusable(true);
        this.bMZ.setFocusableInTouchMode(true);
        this.bMZ.requestFocus();
    }

    public void setDesc(String str) {
        if (this.gpM != null) {
            this.gpM.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.fQJ != null) {
            return k.a(this.fQJ.getText(), null);
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
