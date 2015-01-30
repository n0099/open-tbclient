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
    private TextView Xo;
    private TextView awu;
    private HeadImageView bqP;
    private ShareFromPBMsgData bqQ;

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
        this.Xo = (TextView) findViewById(w.chat_title);
        this.bqP = (HeadImageView) findViewById(w.chat_group_img);
        this.awu = (TextView) findViewById(w.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.Xo.setTextColor(getContext().getResources().getColor(t.cp_cont_b));
            this.awu.setTextColor(getContext().getResources().getColor(t.cp_cont_f));
            return;
        }
        this.Xo.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
        this.awu.setTextColor(getContext().getResources().getColor(t.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bqQ = shareFromPBMsgData;
        qH();
    }

    private void qH() {
        this.Xo.setText(this.bqQ.getTitle());
        this.bqP.setDefaultResource(v.icon_default_ba_120);
        this.bqP.setAutoChangeStyle(false);
        this.bqP.d(this.bqQ.getImageUrl(), 10, false);
        this.awu.setText(this.bqQ.getContent());
    }
}
