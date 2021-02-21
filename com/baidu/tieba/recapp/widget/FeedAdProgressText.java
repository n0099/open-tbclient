package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class FeedAdProgressText extends AppCompatTextView implements a {
    private int dWi;
    private int mColor;
    private int mProgress;
    private int nan;

    public FeedAdProgressText(Context context) {
        super(context);
        this.dWi = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.nan = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWi = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.nan = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWi = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.nan = 0;
        init(context);
    }

    private void init(Context context) {
        setIncludeFontPadding(false);
    }

    public void setMax(int i) {
        this.dWi = i;
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
        this.nan = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.dWi) {
            this.mProgress = i;
            setText("已下载" + i + "%");
        }
    }

    public int getMax() {
        return this.dWi;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        setTextColor(ap.getColor(R.color.CAM_X0109));
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void buo() {
        setTextColor(ap.getColor(R.color.CAM_X0109));
    }
}
