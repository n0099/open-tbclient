package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import d.a.n0.t2.d0.a;
/* loaded from: classes5.dex */
public class AdExportDownloadView extends ApkDownloadView {
    public a.InterfaceC1675a l;

    public AdExportDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Nullable
    public a.InterfaceC1675a getRegisterListener() {
        return this.l;
    }

    public void setBackGroundDrawable(@DrawableRes int i2) {
        setBackgroundSkin(i2);
    }

    public void setDownloadTextColor(@ColorRes int i2) {
        setTextColorSkin(i2);
    }

    public void setForegroundColor(@ColorRes int i2) {
        setForegroundSkin(i2);
    }

    public void setInitTextColor(@ColorRes int i2) {
        setTextColorInitSkin(i2);
    }

    public void setRegisterListener(@Nullable a.InterfaceC1675a interfaceC1675a) {
        this.l = interfaceC1675a;
    }

    public AdExportDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdExportDownloadView(Context context) {
        super(context);
    }
}
