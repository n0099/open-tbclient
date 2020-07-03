package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OperableVideoErrorView extends LinearLayout {
    TBSpecificationBtn kXr;

    public OperableVideoErrorView(Context context) {
        super(context);
        init(context);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public OperableVideoErrorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.operable_video_error, this);
        this.kXr = (TBSpecificationBtn) findViewById(R.id.retry);
        this.kXr.setTextSize(R.dimen.tbds36);
        this.kXr.setText(getResources().getString(R.string.click_retry));
        this.kXr.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.kXr.setOnClickListener(onClickListener);
    }
}
