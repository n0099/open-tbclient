package com.baidu.tieba.yuyinala.liveroom.ranklist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class RankListView extends LinearLayout {
    private TextView ajV;
    private ImageView nMc;

    public RankListView(Context context) {
        super(context);
        initView();
    }

    public RankListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_liveroom_ranklist_layout, this);
        this.nMc = (ImageView) findViewById(a.f.iv_icon);
        this.ajV = (TextView) findViewById(a.f.tv_text);
    }

    public void setmTvText(int i) {
        if (this.ajV != null) {
            if (i > 0) {
                this.ajV.setText("交友房第" + i + "名");
            } else {
                this.ajV.setText("交友房未上榜");
            }
        }
    }

    public void destory() {
    }
}
