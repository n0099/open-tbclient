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
    TBSpecificationBtn lTD;

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
        this.lTD = (TBSpecificationBtn) findViewById(R.id.retry);
        this.lTD.setTextSize(R.dimen.tbds36);
        this.lTD.setText(getResources().getString(R.string.click_retry));
        this.lTD.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.lTD.setOnClickListener(onClickListener);
    }
}
