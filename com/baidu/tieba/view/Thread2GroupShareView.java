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
    private LinearLayout bOF;
    private EditText fYp;
    private ShareFromPBMsgData gUc;
    private TbImageView gyI;
    private TextView gyJ;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fYp;
    }

    public void am(String str, boolean z) {
        if (this.gyI != null) {
            this.gyI.startLoad(str, z ? 17 : 18, false);
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
        this.bOF = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        this.fYp = (EditText) findViewById(R.id.chat_msg);
        this.gyI = (TbImageView) findViewById(R.id.chat_group_img);
        this.gyJ = (TextView) findViewById(R.id.chat_group_desc);
        am.f(this.title, R.color.cp_cont_b, 1);
        am.f(this.fYp, R.color.cp_cont_b, 2);
        am.f(this.gyJ, R.color.cp_cont_f, 1);
        this.fYp.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fYp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        buE();
    }

    public void buE() {
        this.bOF.setFocusable(true);
        this.bOF.setFocusableInTouchMode(true);
        this.bOF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fYp != null) {
            return com.baidu.adp.lib.util.k.a(this.fYp.getText(), null);
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
        this.gUc = shareFromPBMsgData;
        JW();
    }

    private void JW() {
        this.title.setText(this.gUc.getTitle());
        this.gyI.setTag(this.gUc.getImageUrl());
        this.gyJ.setText(this.gUc.getContent());
    }
}
