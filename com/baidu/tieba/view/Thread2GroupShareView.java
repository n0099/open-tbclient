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
    private LinearLayout aMU;
    private TbImageView dNO;
    private EditText dtP;
    private TextView duh;
    private ShareFromPBMsgData ejm;
    private TextView title;

    public EditText getChatMsgView() {
        return this.dtP;
    }

    public void D(String str, boolean z) {
        if (this.dNO != null) {
            this.dNO.startLoad(str, z ? 17 : 18, false);
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
        this.aMU = (LinearLayout) findViewById(d.g.share_content);
        this.title = (TextView) findViewById(d.g.share_title_view);
        this.dtP = (EditText) findViewById(d.g.chat_msg);
        this.dNO = (TbImageView) findViewById(d.g.chat_group_img);
        this.duh = (TextView) findViewById(d.g.chat_group_desc);
        ak.c(this.title, d.C0126d.cp_cont_b, 1);
        ak.c(this.dtP, d.C0126d.cp_cont_b, 2);
        ak.c(this.duh, d.C0126d.cp_cont_f, 1);
        this.dtP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.dtP.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        avQ();
    }

    public void avQ() {
        this.aMU.setFocusable(true);
        this.aMU.setFocusableInTouchMode(true);
        this.aMU.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dtP != null) {
            return k.a(this.dtP.getText(), null);
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
        this.ejm = shareFromPBMsgData;
        wL();
    }

    private void wL() {
        this.title.setText(this.ejm.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.ejm.getImageUrl());
        this.dNO.setTag(this.ejm.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.ejm.getContent());
        this.duh.setText(this.ejm.getContent());
    }
}
