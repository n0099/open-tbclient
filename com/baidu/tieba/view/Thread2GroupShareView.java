package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private TbImageView fzX;
    private EditText jCt;
    private ShareFromPBMsgData kEB;
    private TextView khi;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jCt;
    }

    public void aQ(String str, boolean z) {
        if (this.fzX != null) {
            this.fzX.startLoad(str, z ? 17 : 18, false);
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
        this.jCt = (EditText) findViewById(R.id.chat_msg);
        this.fzX = (TbImageView) findViewById(R.id.chat_group_img);
        this.khi = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCt, R.color.CAM_X0105, 2);
        ap.setViewTextColor(this.khi, R.color.CAM_X0106, 1);
        this.jCt.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jCt.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cMh();
    }

    public void cMh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCt != null) {
            return k.charSequence2String(this.jCt.getText(), null);
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
        this.kEB = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kEB.getTitle());
        this.fzX.setTag(this.kEB.getImageUrl());
        this.khi.setText(this.kEB.getContent());
    }
}
