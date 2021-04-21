package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.i0.r.f0.m.a;
/* loaded from: classes3.dex */
public class OperableVideoErrorView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f20224e;

    public OperableVideoErrorView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LinearLayout.inflate(context, R.layout.operable_video_error, this);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.retry);
        this.f20224e = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds36);
        this.f20224e.setText(getResources().getString(R.string.click_retry));
        this.f20224e.setConfig(new a());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.f20224e.setOnClickListener(onClickListener);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
