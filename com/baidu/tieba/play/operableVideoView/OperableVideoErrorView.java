package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OperableVideoErrorView extends LinearLayout {
    TBSpecificationBtn mFQ;

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
        this.mFQ = (TBSpecificationBtn) findViewById(R.id.retry);
        this.mFQ.setTextSize(R.dimen.tbds36);
        this.mFQ.setText(getResources().getString(R.string.click_retry));
        this.mFQ.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.mFQ.setOnClickListener(onClickListener);
    }
}
