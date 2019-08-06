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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public final class ShareThreadView extends LinearLayout {
    private LinearLayout bOg;
    private EditText fWy;
    private TbImageView gwR;
    private TextView gwS;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fWy;
    }

    public void am(String str, boolean z) {
        if (this.gwR != null) {
            this.gwR.startLoad(str, z ? 17 : 18, false);
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
        this.bOg = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        am.f(this.title, R.color.cp_cont_b, 1);
        this.fWy = (EditText) findViewById(R.id.chat_msg);
        this.gwR = (TbImageView) findViewById(R.id.chat_group_img);
        this.gwS = (TextView) findViewById(R.id.chat_group_desc);
        am.f(this.fWy, R.color.cp_cont_b, 2);
        am.f(this.gwS, R.color.cp_cont_f, 1);
        this.fWy.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fWy.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        btQ();
    }

    public void btQ() {
        this.bOg.setFocusable(true);
        this.bOg.setFocusableInTouchMode(true);
        this.bOg.requestFocus();
    }

    public void setDesc(String str) {
        if (this.gwS != null) {
            this.gwS.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.fWy != null) {
            return k.a(this.fWy.getText(), null);
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
