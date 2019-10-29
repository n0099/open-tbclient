package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FeedAdProgressText extends AppCompatTextView implements a {
    private int dhV;
    private int iQf;
    private int mColor;
    private int mProgress;

    public FeedAdProgressText(Context context) {
        super(context);
        this.dhV = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.iQf = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhV = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.iQf = 0;
        init(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhV = 100;
        this.mProgress = 0;
        this.mColor = 0;
        this.iQf = 0;
        init(context);
    }

    private void init(Context context) {
        setIncludeFontPadding(false);
    }

    public void setMax(int i) {
        this.dhV = i;
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
        this.iQf = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.dhV) {
            this.mProgress = i;
            setText("已下载" + i + "%");
        }
    }

    public int getMax() {
        return this.dhV;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        setTextColor(am.getColor(R.color.cp_cont_d));
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void bnq() {
        setTextColor(am.getColor(R.color.cp_cont_d));
    }
}
