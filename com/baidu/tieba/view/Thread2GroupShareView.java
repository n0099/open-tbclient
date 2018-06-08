package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout aUT;
    private EditText dEh;
    private TextView dEz;
    private TbImageView eae;
    private ShareFromPBMsgData evH;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dEh;
    }

    public void D(String str, boolean z) {
        if (this.eae != null) {
            this.eae.startLoad(str, z ? 17 : 18, false);
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
        LayoutInflater.from(context).inflate(d.i.thread_to_group_share_view, this);
        setOrientation(1);
        this.aUT = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.dEh = (EditText) findViewById(d.g.chat_msg);
        this.eae = (TbImageView) findViewById(d.g.chat_group_img);
        this.dEz = (TextView) findViewById(d.g.chat_group_desc);
        al.c(this.title, d.C0141d.cp_cont_b, 1);
        al.c(this.dEh, d.C0141d.cp_cont_b, 2);
        al.c(this.dEz, d.C0141d.cp_cont_f, 1);
        this.dEh.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        this.dEh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azY();
    }

    public void azY() {
        this.aUT.setFocusable(true);
        this.aUT.setFocusableInTouchMode(true);
        this.aUT.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dEh != null) {
            return com.baidu.adp.lib.util.k.a(this.dEh.getText(), null);
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
        this.evH = shareFromPBMsgData;
        Al();
    }

    private void Al() {
        this.title.setText(this.evH.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.evH.getImageUrl());
        this.eae.setTag(this.evH.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.evH.getContent());
        this.dEz.setText(this.evH.getContent());
    }
}
