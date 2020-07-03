package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class ShareThreadView extends LinearLayout {
    private TbImageView iHH;
    private TextView iHI;
    private EditText ifm;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.ifm;
    }

    public void aH(String str, boolean z) {
        if (this.iHH != null) {
            this.iHH.startLoad(str, z ? 17 : 18, false);
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
        an.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        this.ifm = (EditText) findViewById(R.id.chat_msg);
        this.iHH = (TbImageView) findViewById(R.id.chat_group_img);
        this.iHI = (TextView) findViewById(R.id.chat_group_desc);
        an.setViewTextColor(this.ifm, R.color.cp_cont_b, 2);
        an.setViewTextColor(this.iHI, R.color.cp_cont_f, 1);
        this.ifm.setHintTextColor(an.getColor(R.color.cp_cont_e));
        this.ifm.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cgJ();
    }

    public void cgJ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.iHI != null) {
            this.iHI.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.ifm != null) {
            return k.charSequence2String(this.ifm.getText(), null);
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
