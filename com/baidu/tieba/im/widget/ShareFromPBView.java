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
    private HeadImageView dtN;
    private TextView due;
    private ShareFromPBMsgData ejj;
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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.dtN = (HeadImageView) findViewById(d.g.chat_group_img);
        this.due = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.due.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.due.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ejj = shareFromPBMsgData;
        wL();
    }

    private void wL() {
        this.title.setText(this.ejj.getTitle());
        this.dtN.setDefaultResource(d.f.icon_default_ba_120);
        this.dtN.setAutoChangeStyle(false);
        this.dtN.startLoad(this.ejj.getImageUrl(), 10, false);
        this.due.setText(this.ejj.getContent());
    }
}
