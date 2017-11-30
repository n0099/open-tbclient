package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aWm;
    private TextView axe;
    private ShareFromPBMsgData dVf;
    private HeadImageView dcK;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.share_from_pb_view, this);
        setOrientation(1);
        this.axe = (TextView) findViewById(d.g.chat_title);
        this.dcK = (HeadImageView) findViewById(d.g.chat_group_img);
        this.aWm = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axe.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_b));
            this.aWm.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_f));
            return;
        }
        this.axe.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
        this.aWm.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dVf = shareFromPBMsgData;
        wr();
    }

    private void wr() {
        this.axe.setText(this.dVf.getTitle());
        this.dcK.setDefaultResource(d.f.icon_default_ba_120);
        this.dcK.setAutoChangeStyle(false);
        this.dcK.startLoad(this.dVf.getImageUrl(), 10, false);
        this.aWm.setText(this.dVf.getContent());
    }
}
