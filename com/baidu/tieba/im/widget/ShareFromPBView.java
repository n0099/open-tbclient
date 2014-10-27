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
    private TextView QG;
    private TextView bfk;
    private HeadImageView bjO;
    private ShareFromPBMsgData bjP;

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
        this.QG = (TextView) findViewById(v.chat_title);
        this.bjO = (HeadImageView) findViewById(v.chat_group_img);
        this.bfk = (TextView) findViewById(v.chat_group_desc);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bjP = shareFromPBMsgData;
        nx();
    }

    private void nx() {
        this.QG.setText(this.bjP.getTitle());
        this.bjO.setDefaultResource(u.icon_default_ba_120);
        this.bjO.setAutoChangeStyle(false);
        this.bjO.c(this.bjP.getImageUrl(), 10, false);
        this.bfk.setText(this.bjP.getContent());
    }
}
