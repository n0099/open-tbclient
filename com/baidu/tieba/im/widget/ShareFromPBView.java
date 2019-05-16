package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private HeadImageView fQJ;
    private ShareFromPBMsgData gLe;
    private TextView gpL;
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
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(R.id.chat_title);
        this.fQJ = (HeadImageView) findViewById(R.id.chat_group_img);
        this.gpL = (TextView) findViewById(R.id.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gpL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gpL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gLe = shareFromPBMsgData;
        Jf();
    }

    private void Jf() {
        this.title.setText(this.gLe.getTitle());
        this.fQJ.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fQJ.setAutoChangeStyle(false);
        this.fQJ.startLoad(this.gLe.getImageUrl(), 10, false);
        this.gpL.setText(this.gLe.getContent());
    }
}
