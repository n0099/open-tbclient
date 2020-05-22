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
    private EditText hQX;
    private ShareFromPBMsgData iLh;
    private TbImageView ipN;
    private TextView ipO;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.hQX;
    }

    public void aF(String str, boolean z) {
        if (this.ipN != null) {
            this.ipN.startLoad(str, z ? 17 : 18, false);
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
        this.hQX = (EditText) findViewById(R.id.chat_msg);
        this.ipN = (TbImageView) findViewById(R.id.chat_group_img);
        this.ipO = (TextView) findViewById(R.id.chat_group_desc);
        am.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hQX, R.color.cp_cont_b, 2);
        am.setViewTextColor(this.ipO, R.color.cp_cont_f, 1);
        this.hQX.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hQX.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cde();
    }

    public void cde() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hQX != null) {
            return k.charSequence2String(this.hQX.getText(), null);
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
        this.iLh = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.iLh.getTitle());
        this.ipN.setTag(this.iLh.getImageUrl());
        this.ipO.setText(this.iLh.getContent());
    }
}
