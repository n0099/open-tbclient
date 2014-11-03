package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView QK;
    private TextView bfy;
    private HeadImageView bkc;
    private ShareFromPBMsgData bkd;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        b.ek().inflate(getContext(), w.share_from_pb_view, this);
        setOrientation(1);
        this.QK = (TextView) findViewById(v.chat_title);
        this.bkc = (HeadImageView) findViewById(v.chat_group_img);
        this.bfy = (TextView) findViewById(v.chat_group_desc);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bkd = shareFromPBMsgData;
        nx();
    }

    private void nx() {
        this.QK.setText(this.bkd.getTitle());
        this.bkc.setDefaultResource(u.icon_default_ba_120);
        this.bkc.setAutoChangeStyle(false);
        this.bkc.c(this.bkd.getImageUrl(), 10, false);
        this.bfy.setText(this.bkd.getContent());
    }
}
