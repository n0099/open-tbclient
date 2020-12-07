package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class PlayIntroduceView extends LinearLayout {
    private TextView akV;
    private ImageView oai;

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
        this.oai = (ImageView) findViewById(a.f.iv_icon);
        this.akV = (TextView) findViewById(a.f.tv_text);
    }

    public void destory() {
    }
}
