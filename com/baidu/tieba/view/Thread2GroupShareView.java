package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout axD;
    private TextView dKF;
    private EditText dKn;
    private ShareFromPBMsgData eDl;
    private TbImageView ehK;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dKn;
    }

    public void D(String str, boolean z) {
        if (this.ehK != null) {
            this.ehK.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        by(context);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(f.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.axD = (LinearLayout) findViewById(f.g.share_content);
        this.title = (TextView) findViewById(f.g.share_title_view);
        this.dKn = (EditText) findViewById(f.g.chat_msg);
        this.ehK = (TbImageView) findViewById(f.g.chat_group_img);
        this.dKF = (TextView) findViewById(f.g.chat_group_desc);
        am.c(this.title, f.d.cp_cont_b, 1);
        am.c(this.dKn, f.d.cp_cont_b, 2);
        am.c(this.dKF, f.d.cp_cont_f, 1);
        this.dKn.setHintTextColor(am.getColor(f.d.cp_cont_e));
        this.dKn.setPadding(context.getResources().getDimensionPixelSize(f.e.ds20), 0, 0, 0);
        aBl();
    }

    public void aBl() {
        this.axD.setFocusable(true);
        this.axD.setFocusableInTouchMode(true);
        this.axD.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKn != null) {
            return com.baidu.adp.lib.util.k.a(this.dKn.getText(), null);
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
        this.eDl = shareFromPBMsgData;
        Ap();
    }

    private void Ap() {
        this.title.setText(this.eDl.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.eDl.getImageUrl());
        this.ehK.setTag(this.eDl.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.eDl.getContent());
        this.dKF.setText(this.eDl.getContent());
    }
}
