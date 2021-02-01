package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class ChooseLoverView extends TextView {
    public ChooseLoverView(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        setText("选择心动对象");
        setBackgroundResource(a.e.shape_yuin_dating_choose_lover_btn_bg);
        setGravity(17);
        setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        setTextSize(12.0f);
    }
}
