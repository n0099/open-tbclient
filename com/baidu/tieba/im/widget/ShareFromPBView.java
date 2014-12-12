package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView avu;
    private HeadImageView bpr;
    private ShareFromPBMsgData bps;
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
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), x.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(w.chat_title);
        this.bpr = (HeadImageView) findViewById(w.chat_group_img);
        this.avu = (TextView) findViewById(w.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(t.cp_cont_b));
            this.avu.setTextColor(getContext().getResources().getColor(t.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
        this.avu.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bps = shareFromPBMsgData;
        qw();
    }

    private void qw() {
        this.title.setText(this.bps.getTitle());
        this.bpr.setDefaultResource(v.icon_default_ba_120);
        this.bpr.setAutoChangeStyle(false);
        this.bpr.d(this.bps.getImageUrl(), 10, false);
        this.avu.setText(this.bps.getContent());
    }
}
