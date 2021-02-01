package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaAcceptAndInviteBtn extends TextView {
    public AlaAcceptAndInviteBtn(Context context) {
        super(context);
    }

    public AlaAcceptAndInviteBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSelectedState(int i) {
        if (i == 0) {
            setBackgroundResource(a.e.yuyin_sdk_wheat_connection_accept_btn_bg_unable);
            setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
        } else if (i == 1) {
            setBackgroundResource(a.e.yuyin_sdk_wheat_connection_accept_btn_bg_enable);
            setTextColor(getContext().getResources().getColor(a.c.sdk_color_ff1e66));
        } else if (i == 2) {
            setBackgroundResource(a.e.yuyin_sdk_wheat_connection_invite_btn_blue_bg);
            setTextColor(Color.parseColor("#507AF1"));
        } else {
            setBackgroundResource(a.e.yuyin_sdk_wheat_connection_accept_btn_bg_unable);
            setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
        }
    }
}
