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
    private HeadImageView dEi;
    private TextView dEz;
    private ShareFromPBMsgData evH;
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
        this.dEi = (HeadImageView) findViewById(d.g.chat_group_img);
        this.dEz = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_b));
            this.dEz.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.dEz.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.evH = shareFromPBMsgData;
        Al();
    }

    private void Al() {
        this.title.setText(this.evH.getTitle());
        this.dEi.setDefaultResource(d.f.icon_default_ba_120);
        this.dEi.setAutoChangeStyle(false);
        this.dEi.startLoad(this.evH.getImageUrl(), 10, false);
        this.dEz.setText(this.evH.getContent());
    }
}
