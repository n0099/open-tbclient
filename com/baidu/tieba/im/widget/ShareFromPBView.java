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
    private HeadImageView jCs;
    private ShareFromPBMsgData kEz;
    private TextView khg;
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
        this.jCs = (HeadImageView) findViewById(R.id.chat_group_img);
        this.khg = (TextView) findViewById(R.id.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.khg.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.khg.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kEz = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kEz.getTitle());
        this.jCs.setPlaceHolder(1);
        this.jCs.setAutoChangeStyle(false);
        this.jCs.startLoad(this.kEz.getImageUrl(), 10, false);
        this.khg.setText(this.kEz.getContent());
    }
}
