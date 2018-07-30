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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout axG;
    private TextView dKJ;
    private EditText dKr;
    private ShareFromPBMsgData eDp;
    private TbImageView ehN;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dKr;
    }

    public void D(String str, boolean z) {
        if (this.ehN != null) {
            this.ehN.startLoad(str, z ? 17 : 18, false);
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
        LayoutInflater.from(context).inflate(d.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.axG = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.dKr = (EditText) findViewById(d.g.chat_msg);
        this.ehN = (TbImageView) findViewById(d.g.chat_group_img);
        this.dKJ = (TextView) findViewById(d.g.chat_group_desc);
        am.c(this.title, d.C0140d.cp_cont_b, 1);
        am.c(this.dKr, d.C0140d.cp_cont_b, 2);
        am.c(this.dKJ, d.C0140d.cp_cont_f, 1);
        this.dKr.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        this.dKr.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aBo();
    }

    public void aBo() {
        this.axG.setFocusable(true);
        this.axG.setFocusableInTouchMode(true);
        this.axG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKr != null) {
            return com.baidu.adp.lib.util.k.a(this.dKr.getText(), null);
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
        this.eDp = shareFromPBMsgData;
        Ar();
    }

    private void Ar() {
        this.title.setText(this.eDp.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.eDp.getImageUrl());
        this.ehN.setTag(this.eDp.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.eDp.getContent());
        this.dKJ.setText(this.eDp.getContent());
    }
}
