package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aEp;
    private TextView aiA;
    private HeadImageView brk;
    private ShareFromPBMsgData brl;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.share_from_pb_view, this);
        setOrientation(1);
        this.aiA = (TextView) findViewById(q.chat_title);
        this.brk = (HeadImageView) findViewById(q.chat_group_img);
        this.aEp = (TextView) findViewById(q.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aiA.setTextColor(getContext().getResources().getColor(n.cp_cont_b));
            this.aEp.setTextColor(getContext().getResources().getColor(n.cp_cont_f));
            return;
        }
        this.aiA.setTextColor(getContext().getResources().getColor(n.cp_cont_g));
        this.aEp.setTextColor(getContext().getResources().getColor(n.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.brl = shareFromPBMsgData;
        uv();
    }

    private void uv() {
        this.aiA.setText(this.brl.getTitle());
        this.brk.setDefaultResource(p.icon_default_ba_120);
        this.brk.setAutoChangeStyle(false);
        this.brk.c(this.brl.getImageUrl(), 10, false);
        this.aEp.setText(this.brl.getContent());
    }
}
