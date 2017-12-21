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
    private TextView aWs;
    private TextView axm;
    private ShareFromPBMsgData dWo;
    private HeadImageView ddV;

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
        this.axm = (TextView) findViewById(d.g.chat_title);
        this.ddV = (HeadImageView) findViewById(d.g.chat_group_img);
        this.aWs = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axm.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_b));
            this.aWs.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_f));
            return;
        }
        this.axm.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
        this.aWs.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dWo = shareFromPBMsgData;
        wp();
    }

    private void wp() {
        this.axm.setText(this.dWo.getTitle());
        this.ddV.setDefaultResource(d.f.icon_default_ba_120);
        this.ddV.setAutoChangeStyle(false);
        this.ddV.startLoad(this.dWo.getImageUrl(), 10, false);
        this.aWs.setText(this.dWo.getContent());
    }
}
