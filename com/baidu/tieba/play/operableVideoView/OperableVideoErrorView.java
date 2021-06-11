package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.m0.r.f0.m.a;
/* loaded from: classes5.dex */
public class OperableVideoErrorView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f20039e;

    public OperableVideoErrorView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LinearLayout.inflate(context, R.layout.operable_video_error, this);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.retry);
        this.f20039e = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds36);
        this.f20039e.setText(getResources().getString(R.string.click_retry));
        this.f20039e.setConfig(new a());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.f20039e.setOnClickListener(onClickListener);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
