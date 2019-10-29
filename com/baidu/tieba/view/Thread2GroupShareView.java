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
    private EditText fXK;
    private ShareFromPBMsgData gSc;
    private TbImageView gwF;
    private TextView gwG;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fXK;
    }

    public void ai(String str, boolean z) {
        if (this.gwF != null) {
            this.gwF.startLoad(str, z ? 17 : 18, false);
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
        this.fXK = (EditText) findViewById(R.id.chat_msg);
        this.gwF = (TbImageView) findViewById(R.id.chat_group_img);
        this.gwG = (TextView) findViewById(R.id.chat_group_desc);
        am.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fXK, R.color.cp_cont_b, 2);
        am.setViewTextColor(this.gwG, R.color.cp_cont_f, 1);
        this.fXK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fXK.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brG();
    }

    public void brG() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fXK != null) {
            return com.baidu.adp.lib.util.k.charSequence2String(this.fXK.getText(), null);
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
        this.gSc = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.gSc.getTitle());
        this.gwF.setTag(this.gSc.getImageUrl());
        this.gwG.setText(this.gSc.getContent());
    }
}
