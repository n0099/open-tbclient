package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aLO;
    private TextView anH;
    private HeadImageView bEY;
    private ShareFromPBMsgData bEZ;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.share_from_pb_view, this);
        setOrientation(1);
        this.anH = (TextView) findViewById(i.f.chat_title);
        this.bEY = (HeadImageView) findViewById(i.f.chat_group_img);
        this.aLO = (TextView) findViewById(i.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.anH.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.aLO.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.anH.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.aLO.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bEZ = shareFromPBMsgData;
        vz();
    }

    private void vz() {
        this.anH.setText(this.bEZ.getTitle());
        this.bEY.setDefaultResource(i.e.icon_default_ba_120);
        this.bEY.setAutoChangeStyle(false);
        this.bEY.d(this.bEZ.getImageUrl(), 10, false);
        this.aLO.setText(this.bEZ.getContent());
    }
}
