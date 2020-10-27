package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public final class ShareThreadView extends LinearLayout {
    private TbImageView fng;
    private TextView jMV;
    private EditText jif;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jif;
    }

    public void aP(String str, boolean z) {
        if (this.fng != null) {
            this.fng.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public ShareThreadView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        ap.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        this.jif = (EditText) findViewById(R.id.chat_msg);
        this.fng = (TbImageView) findViewById(R.id.chat_group_img);
        this.jMV = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.jif, R.color.cp_cont_b, 2);
        ap.setViewTextColor(this.jMV, R.color.cp_cont_f, 1);
        this.jif.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.jif.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cEL();
    }

    public void cEL() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.jMV != null) {
            this.jMV.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.jif != null) {
            return k.charSequence2String(this.jif.getText(), null);
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
