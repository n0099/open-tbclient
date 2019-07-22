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
    private LinearLayout bOb;
    private EditText fVI;
    private ShareFromPBMsgData gRr;
    private TbImageView gvZ;
    private TextView gwa;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fVI;
    }

    public void am(String str, boolean z) {
        if (this.gvZ != null) {
            this.gvZ.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.bOb = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        this.fVI = (EditText) findViewById(R.id.chat_msg);
        this.gvZ = (TbImageView) findViewById(R.id.chat_group_img);
        this.gwa = (TextView) findViewById(R.id.chat_group_desc);
        am.f(this.title, R.color.cp_cont_b, 1);
        am.f(this.fVI, R.color.cp_cont_b, 2);
        am.f(this.gwa, R.color.cp_cont_f, 1);
        this.fVI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fVI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        btD();
    }

    public void btD() {
        this.bOb.setFocusable(true);
        this.bOb.setFocusableInTouchMode(true);
        this.bOb.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fVI != null) {
            return com.baidu.adp.lib.util.k.a(this.fVI.getText(), null);
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
        this.gRr = shareFromPBMsgData;
        JS();
    }

    private void JS() {
        this.title.setText(this.gRr.getTitle());
        this.gvZ.setTag(this.gRr.getImageUrl());
        this.gwa.setText(this.gRr.getContent());
    }
}
