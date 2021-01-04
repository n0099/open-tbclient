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
    private HeadImageView jOW;
    private ShareFromPBMsgData kJK;
    private TextView kuu;
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
        this.jOW = (HeadImageView) findViewById(R.id.chat_group_img);
        this.kuu = (TextView) findViewById(R.id.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kuu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kuu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kJK = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.kJK.getTitle());
        this.jOW.setPlaceHolder(1);
        this.jOW.setAutoChangeStyle(false);
        this.jOW.startLoad(this.kJK.getImageUrl(), 10, false);
        this.kuu.setText(this.kJK.getContent());
    }
}
