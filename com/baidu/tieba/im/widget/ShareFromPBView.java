package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView dZK;
    private HeadImageView dZu;
    private ShareFromPBMsgData eSl;
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
        LayoutInflater.from(getContext()).inflate(e.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(e.g.chat_title);
        this.dZu = (HeadImageView) findViewById(e.g.chat_group_img);
        this.dZK = (TextView) findViewById(e.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.dZK.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.dZK.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eSl = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.eSl.getTitle());
        this.dZu.setDefaultResource(e.f.icon_default_ba_120);
        this.dZu.setAutoChangeStyle(false);
        this.dZu.startLoad(this.eSl.getImageUrl(), 10, false);
        this.dZK.setText(this.eSl.getContent());
    }
}
