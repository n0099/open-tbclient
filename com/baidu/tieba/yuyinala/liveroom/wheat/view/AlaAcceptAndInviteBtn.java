package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaAcceptAndInviteBtn extends TextView {
    public AlaAcceptAndInviteBtn(Context context) {
        super(context);
    }

    public AlaAcceptAndInviteBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBtnEnabled(boolean z) {
        if (z) {
            setBackgroundResource(a.e.yuyin_sdk_wheat_connection_accept_btn_bg_enable);
            setTextColor(getContext().getResources().getColor(a.c.sdk_color_ff1e66));
            return;
        }
        setBackgroundResource(a.e.yuyin_sdk_wheat_connection_accept_btn_bg_unable);
        setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
    }
}
