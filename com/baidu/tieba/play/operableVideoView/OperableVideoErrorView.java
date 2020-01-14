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
    TBSpecificationBtn jxG;

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
        this.jxG = (TBSpecificationBtn) findViewById(R.id.retry);
        this.jxG.setTextSize(R.dimen.tbds36);
        this.jxG.setText(getResources().getString(R.string.click_retry));
        this.jxG.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.jxG.setOnClickListener(onClickListener);
    }
}
