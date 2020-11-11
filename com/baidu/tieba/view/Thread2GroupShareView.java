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
    private TbImageView fsZ;
    private TextView jSS;
    private EditText jod;
    private ShareFromPBMsgData kqt;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jod;
    }

    public void aP(String str, boolean z) {
        if (this.fsZ != null) {
            this.fsZ.startLoad(str, z ? 17 : 18, false);
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
        this.jod = (EditText) findViewById(R.id.chat_msg);
        this.fsZ = (TbImageView) findViewById(R.id.chat_group_img);
        this.jSS = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jod, R.color.cp_cont_b, 2);
        ap.setViewTextColor(this.jSS, R.color.cp_cont_f, 1);
        this.jod.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.jod.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cHm();
    }

    public void cHm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jod != null) {
            return k.charSequence2String(this.jod.getText(), null);
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
        this.kqt = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kqt.getTitle());
        this.fsZ.setTag(this.kqt.getImageUrl());
        this.jSS.setText(this.kqt.getContent());
    }
}
