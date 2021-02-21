package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaLoadingToastView extends RelativeLayout {
    private TextView knI;

    public AlaLoadingToastView(Context context) {
        super(context);
        bv(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bv(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bv(context);
    }

    protected void bv(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_toast_view, (ViewGroup) this, true);
        setGravity(17);
        this.knI = (TextView) findViewById(a.f.tv_content);
    }

    public void setContent(String str) {
        if (this.knI != null && !TextUtils.isEmpty(str)) {
            this.knI.setText(str);
        }
    }
}
