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
    private TextView aEp;
    private TextView agd;
    private ShareFromPBMsgData bYw;
    private HeadImageView bkS;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(n.g.share_from_pb_view, this);
        setOrientation(1);
        this.agd = (TextView) findViewById(n.f.chat_title);
        this.bkS = (HeadImageView) findViewById(n.f.chat_group_img);
        this.aEp = (TextView) findViewById(n.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.agd.setTextColor(getContext().getResources().getColor(n.c.cp_cont_b));
            this.aEp.setTextColor(getContext().getResources().getColor(n.c.cp_cont_f));
            return;
        }
        this.agd.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
        this.aEp.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bYw = shareFromPBMsgData;
        wd();
    }

    private void wd() {
        this.agd.setText(this.bYw.getTitle());
        this.bkS.setDefaultResource(n.e.icon_default_ba_120);
        this.bkS.setAutoChangeStyle(false);
        this.bkS.d(this.bYw.getImageUrl(), 10, false);
        this.aEp.setText(this.bYw.getContent());
    }
}
