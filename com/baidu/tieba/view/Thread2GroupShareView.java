package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout aMV;
    private TbImageView dOS;
    private EditText duU;
    private TextView dvm;
    private ShareFromPBMsgData ekq;
    private TextView title;

    public EditText getChatMsgView() {
        return this.duU;
    }

    public void D(String str, boolean z) {
        if (this.dOS != null) {
            this.dOS.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bo(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        bo(context);
    }

    private void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.thread_to_group_share_view, this);
        setOrientation(1);
        this.aMV = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.duU = (EditText) findViewById(d.g.chat_msg);
        this.dOS = (TbImageView) findViewById(d.g.chat_group_img);
        this.dvm = (TextView) findViewById(d.g.chat_group_desc);
        ak.c(this.title, d.C0126d.cp_cont_b, 1);
        ak.c(this.duU, d.C0126d.cp_cont_b, 2);
        ak.c(this.dvm, d.C0126d.cp_cont_f, 1);
        this.duU.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.duU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        avP();
    }

    public void avP() {
        this.aMV.setFocusable(true);
        this.aMV.setFocusableInTouchMode(true);
        this.aMV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.duU != null) {
            return k.a(this.duU.getText(), null);
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
        this.ekq = shareFromPBMsgData;
        wK();
    }

    private void wK() {
        this.title.setText(this.ekq.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.ekq.getImageUrl());
        this.dOS.setTag(this.ekq.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.ekq.getContent());
        this.dvm.setText(this.ekq.getContent());
    }
}
