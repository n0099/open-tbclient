package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class PlayIntroduceView extends LinearLayout {
    private TextView aly;
    private ImageView ocx;

    public PlayIntroduceView(Context context) {
        super(context);
        initView();
    }

    public PlayIntroduceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_liveroom_play_introduce_layout, this);
        this.ocx = (ImageView) findViewById(a.f.iv_icon);
        this.aly = (TextView) findViewById(a.f.tv_text);
    }

    public void destory() {
    }
}
