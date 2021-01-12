package com.baidu.tieba.yuyinala.liveroom.ranklist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class RankListView extends LinearLayout {
    private TextView akG;
    private ImageView nXQ;

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
        this.nXQ = (ImageView) findViewById(a.f.iv_icon);
        this.akG = (TextView) findViewById(a.f.tv_text);
    }

    public void setmTvText(int i) {
        if (this.akG != null) {
            if (i > 0) {
                this.akG.setText("交友房第" + i + "名");
            } else {
                this.akG.setText("交友房未上榜");
            }
        }
    }

    public void destory() {
    }
}
