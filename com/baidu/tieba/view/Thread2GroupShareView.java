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
    private TbImageView fHi;
    private EditText jRA;
    private ShareFromPBMsgData kNy;
    private TextView kyk;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jRA;
    }

    public void aP(String str, boolean z) {
        if (this.fHi != null) {
            this.fHi.startLoad(str, z ? 17 : 18, false);
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
        this.jRA = (EditText) findViewById(R.id.chat_msg);
        this.fHi = (TbImageView) findViewById(R.id.chat_group_img);
        this.kyk = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jRA, R.color.CAM_X0105, 2);
        ap.setViewTextColor(this.kyk, R.color.CAM_X0106, 1);
        this.jRA.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jRA.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cNo();
    }

    public void cNo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jRA != null) {
            return k.charSequence2String(this.jRA.getText(), null);
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
        this.kNy = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kNy.getTitle());
        this.fHi.setTag(this.kNy.getImageUrl());
        this.kyk.setText(this.kNy.getContent());
    }
}
