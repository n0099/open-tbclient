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
    private TbImageView feH;
    private EditText iVI;
    private TextView jAw;
    private ShareFromPBMsgData jXX;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.iVI;
    }

    public void aN(String str, boolean z) {
        if (this.feH != null) {
            this.feH.startLoad(str, z ? 17 : 18, false);
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
        this.iVI = (EditText) findViewById(R.id.chat_msg);
        this.feH = (TbImageView) findViewById(R.id.chat_group_img);
        this.jAw = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iVI, R.color.cp_cont_b, 2);
        ap.setViewTextColor(this.jAw, R.color.cp_cont_f, 1);
        this.iVI.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.iVI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cBE();
    }

    public void cBE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.iVI != null) {
            return k.charSequence2String(this.iVI.getText(), null);
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
        this.jXX = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.jXX.getTitle());
        this.feH.setTag(this.jXX.getImageUrl());
        this.jAw.setText(this.jXX.getContent());
    }
}
