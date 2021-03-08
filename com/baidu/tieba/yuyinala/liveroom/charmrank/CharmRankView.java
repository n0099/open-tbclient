package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class CharmRankView extends LinearLayout {
    private TextView alO;
    private ImageView okC;

    public CharmRankView(Context context) {
        super(context);
        initView();
    }

    public CharmRankView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_liveroom_charm_rank_layout, this);
        this.okC = (ImageView) findViewById(a.f.iv_icon);
        this.alO = (TextView) findViewById(a.f.tv_text);
    }

    public void setTvText(String str) {
        if (this.alO != null) {
            this.alO.setText(str);
        }
    }

    public void destory() {
    }
}
