package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private EditText fWT;
    private ShareFromPBMsgData gRl;
    private TbImageView gvO;
    private TextView gvP;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fWT;
    }

    public void ai(String str, boolean z) {
        if (this.gvO != null) {
            this.gvO.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        this.fWT = (EditText) findViewById(R.id.chat_msg);
        this.gvO = (TbImageView) findViewById(R.id.chat_group_img);
        this.gvP = (TextView) findViewById(R.id.chat_group_desc);
        am.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fWT, R.color.cp_cont_b, 2);
        am.setViewTextColor(this.gvP, R.color.cp_cont_f, 1);
        this.fWT.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fWT.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brE();
    }

    public void brE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fWT != null) {
            return com.baidu.adp.lib.util.k.charSequence2String(this.fWT.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gRl = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.gRl.getTitle());
        this.gvO.setTag(this.gRl.getImageUrl());
        this.gvP.setText(this.gRl.getContent());
    }
}
