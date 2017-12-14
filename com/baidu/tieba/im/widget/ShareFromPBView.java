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
    private TextView aWo;
    private TextView axj;
    private ShareFromPBMsgData dWk;
    private HeadImageView ddR;

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
        this.axj = (TextView) findViewById(d.g.chat_title);
        this.ddR = (HeadImageView) findViewById(d.g.chat_group_img);
        this.aWo = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axj.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_b));
            this.aWo.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_f));
            return;
        }
        this.axj.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
        this.aWo.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dWk = shareFromPBMsgData;
        wp();
    }

    private void wp() {
        this.axj.setText(this.dWk.getTitle());
        this.ddR.setDefaultResource(d.f.icon_default_ba_120);
        this.ddR.setAutoChangeStyle(false);
        this.ddR.startLoad(this.dWk.getImageUrl(), 10, false);
        this.aWo.setText(this.dWk.getContent());
    }
}
