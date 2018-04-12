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
    private HeadImageView dtQ;
    private TextView duh;
    private ShareFromPBMsgData ejm;
    private TextView title;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.i.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.dtQ = (HeadImageView) findViewById(d.g.chat_group_img);
        this.duh = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.duh.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.duh.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ejm = shareFromPBMsgData;
        wL();
    }

    private void wL() {
        this.title.setText(this.ejm.getTitle());
        this.dtQ.setDefaultResource(d.f.icon_default_ba_120);
        this.dtQ.setAutoChangeStyle(false);
        this.dtQ.startLoad(this.ejm.getImageUrl(), 10, false);
        this.duh.setText(this.ejm.getContent());
    }
}
