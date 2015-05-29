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
    private TextView aEo;
    private TextView aiA;
    private HeadImageView brj;
    private ShareFromPBMsgData brk;

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
        this.brj = (HeadImageView) findViewById(q.chat_group_img);
        this.aEo = (TextView) findViewById(q.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aiA.setTextColor(getContext().getResources().getColor(n.cp_cont_b));
            this.aEo.setTextColor(getContext().getResources().getColor(n.cp_cont_f));
            return;
        }
        this.aiA.setTextColor(getContext().getResources().getColor(n.cp_cont_g));
        this.aEo.setTextColor(getContext().getResources().getColor(n.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.brk = shareFromPBMsgData;
        uv();
    }

    private void uv() {
        this.aiA.setText(this.brk.getTitle());
        this.brj.setDefaultResource(p.icon_default_ba_120);
        this.brj.setAutoChangeStyle(false);
        this.brj.c(this.brk.getImageUrl(), 10, false);
        this.aEo.setText(this.brk.getContent());
    }
}
