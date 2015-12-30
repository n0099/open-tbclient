package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aFP;
    private TextView ahk;
    private HeadImageView boJ;
    private ShareFromPBMsgData ccw;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(n.h.share_from_pb_view, this);
        setOrientation(1);
        this.ahk = (TextView) findViewById(n.g.chat_title);
        this.boJ = (HeadImageView) findViewById(n.g.chat_group_img);
        this.aFP = (TextView) findViewById(n.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.ahk.setTextColor(getContext().getResources().getColor(n.d.cp_cont_b));
            this.aFP.setTextColor(getContext().getResources().getColor(n.d.cp_cont_f));
            return;
        }
        this.ahk.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
        this.aFP.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ccw = shareFromPBMsgData;
        vN();
    }

    private void vN() {
        this.ahk.setText(this.ccw.getTitle());
        this.boJ.setDefaultResource(n.f.icon_default_ba_120);
        this.boJ.setAutoChangeStyle(false);
        this.boJ.d(this.ccw.getImageUrl(), 10, false);
        this.aFP.setText(this.ccw.getContent());
    }
}
