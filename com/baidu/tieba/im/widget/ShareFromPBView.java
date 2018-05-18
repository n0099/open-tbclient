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
    private HeadImageView duV;
    private TextView dvm;
    private ShareFromPBMsgData ekq;
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
        this.duV = (HeadImageView) findViewById(d.g.chat_group_img);
        this.dvm = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.dvm.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.dvm.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ekq = shareFromPBMsgData;
        wK();
    }

    private void wK() {
        this.title.setText(this.ekq.getTitle());
        this.duV.setDefaultResource(d.f.icon_default_ba_120);
        this.duV.setAutoChangeStyle(false);
        this.duV.startLoad(this.ekq.getImageUrl(), 10, false);
        this.dvm.setText(this.ekq.getContent());
    }
}
