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
    private TextView fYJ;
    private HeadImageView fzZ;
    private ShareFromPBMsgData gud;
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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.fzZ = (HeadImageView) findViewById(d.g.chat_group_img);
        this.fYJ = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_b));
            this.fYJ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.fYJ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gud = shareFromPBMsgData;
        GR();
    }

    private void GR() {
        this.title.setText(this.gud.getTitle());
        this.fzZ.setDefaultResource(d.f.icon_default_ba_120);
        this.fzZ.setAutoChangeStyle(false);
        this.fzZ.startLoad(this.gud.getImageUrl(), 10, false);
        this.fYJ.setText(this.gud.getContent());
    }
}
