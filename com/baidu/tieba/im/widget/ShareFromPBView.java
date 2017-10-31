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
    private TextView aTd;
    private TextView awv;
    private HeadImageView cTi;
    private ShareFromPBMsgData dNm;

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
        this.awv = (TextView) findViewById(d.g.chat_title);
        this.cTi = (HeadImageView) findViewById(d.g.chat_group_img);
        this.aTd = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.awv.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_b));
            this.aTd.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            return;
        }
        this.awv.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.aTd.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dNm = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awv.setText(this.dNm.getTitle());
        this.cTi.setDefaultResource(d.f.icon_default_ba_120);
        this.cTi.setAutoChangeStyle(false);
        this.cTi.startLoad(this.dNm.getImageUrl(), 10, false);
        this.aTd.setText(this.dNm.getContent());
    }
}
