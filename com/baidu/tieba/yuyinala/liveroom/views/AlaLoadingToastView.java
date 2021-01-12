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
    private TextView kfm;

    public AlaLoadingToastView(Context context) {
        super(context);
        bs(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bs(context);
    }

    public AlaLoadingToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bs(context);
    }

    protected void bs(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_toast_view, (ViewGroup) this, true);
        setGravity(17);
        this.kfm = (TextView) findViewById(a.f.tv_content);
    }

    public void setContent(String str) {
        if (this.kfm != null && !TextUtils.isEmpty(str)) {
            this.kfm.setText(str);
        }
    }
}
