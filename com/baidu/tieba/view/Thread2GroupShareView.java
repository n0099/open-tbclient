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
/* loaded from: classes2.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private TbImageView ePE;
    private EditText izr;
    private ShareFromPBMsgData jAs;
    private TextView jcM;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.izr;
    }

    public void aJ(String str, boolean z) {
        if (this.ePE != null) {
            this.ePE.startLoad(str, z ? 17 : 18, false);
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
        this.izr = (EditText) findViewById(R.id.chat_msg);
        this.ePE = (TbImageView) findViewById(R.id.chat_group_img);
        this.jcM = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izr, R.color.cp_cont_b, 2);
        ap.setViewTextColor(this.jcM, R.color.cp_cont_f, 1);
        this.izr.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.izr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cuN();
    }

    public void cuN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.izr != null) {
            return k.charSequence2String(this.izr.getText(), null);
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
        this.jAs = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.jAs.getTitle());
        this.ePE.setTag(this.jAs.getImageUrl());
        this.jcM.setText(this.jAs.getContent());
    }
}
