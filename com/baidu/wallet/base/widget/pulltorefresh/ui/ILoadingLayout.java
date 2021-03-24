package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public interface ILoadingLayout {
    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);

    void setTextTypeface(Typeface typeface);
}
