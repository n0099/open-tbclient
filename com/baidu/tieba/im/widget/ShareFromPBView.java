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
    private TextView Xl;
    private TextView awr;
    private HeadImageView bqO;
    private ShareFromPBMsgData bqP;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.share_from_pb_view, this);
        setOrientation(1);
        this.Xl = (TextView) findViewById(w.chat_title);
        this.bqO = (HeadImageView) findViewById(w.chat_group_img);
        this.awr = (TextView) findViewById(w.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.Xl.setTextColor(getContext().getResources().getColor(t.cp_cont_b));
            this.awr.setTextColor(getContext().getResources().getColor(t.cp_cont_f));
            return;
        }
        this.Xl.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
        this.awr.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bqP = shareFromPBMsgData;
        qB();
    }

    private void qB() {
        this.Xl.setText(this.bqP.getTitle());
        this.bqO.setDefaultResource(v.icon_default_ba_120);
        this.bqO.setAutoChangeStyle(false);
        this.bqO.d(this.bqP.getImageUrl(), 10, false);
        this.awr.setText(this.bqP.getContent());
    }
}
