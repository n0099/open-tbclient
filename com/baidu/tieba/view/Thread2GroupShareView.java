package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private TbImageView fEW;
    private EditText jKp;
    private ShareFromPBMsgData kFf;
    private TextView kpP;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jKp;
    }

    public void aQ(String str, boolean z) {
        if (this.fEW != null) {
            this.fEW.startLoad(str, z ? 17 : 18, false);
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
        this.jKp = (EditText) findViewById(R.id.chat_msg);
        this.fEW = (TbImageView) findViewById(R.id.chat_group_img);
        this.kpP = (TextView) findViewById(R.id.chat_group_desc);
        ao.setViewTextColor(this.title, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.jKp, R.color.CAM_X0105, 2);
        ao.setViewTextColor(this.kpP, R.color.CAM_X0106, 1);
        this.jKp.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        this.jKp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cLt();
    }

    public void cLt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jKp != null) {
            return k.charSequence2String(this.jKp.getText(), null);
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
        this.kFf = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kFf.getTitle());
        this.fEW.setTag(this.kFf.getImageUrl());
        this.kpP.setText(this.kFf.getContent());
    }
}
