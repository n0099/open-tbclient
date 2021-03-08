package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaLoadingToastView extends RelativeLayout {
    private TextView kpK;

    public AlaLoadingToastView(Context context) {
        super(context);
        bu(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bu(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bu(context);
    }

    protected void bu(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_toast_view, (ViewGroup) this, true);
        setGravity(17);
        this.kpK = (TextView) findViewById(a.f.tv_content);
    }

    public void setContent(String str) {
        if (this.kpK != null && !TextUtils.isEmpty(str)) {
            this.kpK.setText(str);
        }
    }
}
