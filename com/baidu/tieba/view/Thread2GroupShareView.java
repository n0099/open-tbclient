package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private EditText gLu;
    private ShareFromPBMsgData hFp;
    private TbImageView hjU;
    private TextView hjV;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.gLu;
    }

    public void am(String str, boolean z) {
        if (this.hjU != null) {
            this.hjU.startLoad(str, z ? 17 : 18, false);
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
        this.gLu = (EditText) findViewById(R.id.chat_msg);
        this.hjU = (TbImageView) findViewById(R.id.chat_group_img);
        this.hjV = (TextView) findViewById(R.id.chat_group_desc);
        am.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gLu, R.color.cp_cont_b, 2);
        am.setViewTextColor(this.hjV, R.color.cp_cont_f, 1);
        this.gLu.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.gLu.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bJg();
    }

    public void bJg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gLu != null) {
            return k.charSequence2String(this.gLu.getText(), null);
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
        this.hFp = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.hFp.getTitle());
        this.hjU.setTag(this.hFp.getImageUrl());
        this.hjV.setText(this.hFp.getContent());
    }
}
