package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class FeedAdProgressText extends AppCompatTextView implements a {
    private int dUc;
    private int mColor;
    private int mProgress;
    private int mQq;

    public FeedAdProgressText(Context context) {
        super(context);
        this.dUc = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.mQq = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUc = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.mQq = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUc = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.mQq = 0;
        init(context);
    }

    private void init(Context context) {
        setIncludeFontPadding(false);
    }

    public void setMax(int i) {
        this.dUc = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str) {
        setText(str);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str, int i) {
        this.mProgress = i;
        setText(str);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextSize(int i) {
        setTextSize(1, i);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextColor(int i) {
        this.mColor = i;
        setTextColor(i);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextNightColor(int i) {
        this.mQq = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.dUc) {
            this.mProgress = i;
            setText("已下载" + i + "%");
        }
    }

    public int getMax() {
        return this.dUc;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        setTextColor(ao.getColor(R.color.CAM_X0109));
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void btU() {
        setTextColor(ao.getColor(R.color.CAM_X0109));
    }
}
