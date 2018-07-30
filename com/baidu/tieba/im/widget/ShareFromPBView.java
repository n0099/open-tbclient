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
    private TextView dKJ;
    private HeadImageView dKs;
    private ShareFromPBMsgData eDp;
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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.dKs = (HeadImageView) findViewById(d.g.chat_group_img);
        this.dKJ = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_b));
            this.dKJ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.dKJ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eDp = shareFromPBMsgData;
        Ar();
    }

    private void Ar() {
        this.title.setText(this.eDp.getTitle());
        this.dKs.setDefaultResource(d.f.icon_default_ba_120);
        this.dKs.setAutoChangeStyle(false);
        this.dKs.startLoad(this.eDp.getImageUrl(), 10, false);
        this.dKJ.setText(this.eDp.getContent());
    }
}
