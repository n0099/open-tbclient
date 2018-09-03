package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView dKF;
    private HeadImageView dKo;
    private ShareFromPBMsgData eDl;
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
        LayoutInflater.from(getContext()).inflate(f.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(f.g.chat_title);
        this.dKo = (HeadImageView) findViewById(f.g.chat_group_img);
        this.dKF = (TextView) findViewById(f.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(f.d.cp_cont_b));
            this.dKF.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
        this.dKF.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eDl = shareFromPBMsgData;
        Ap();
    }

    private void Ap() {
        this.title.setText(this.eDl.getTitle());
        this.dKo.setDefaultResource(f.C0146f.icon_default_ba_120);
        this.dKo.setAutoChangeStyle(false);
        this.dKo.startLoad(this.eDl.getImageUrl(), 10, false);
        this.dKF.setText(this.eDl.getContent());
    }
}
