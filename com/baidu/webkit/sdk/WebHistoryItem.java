package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
import android.graphics.Picture;
/* loaded from: classes8.dex */
public abstract class WebHistoryItem implements Cloneable {
    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public abstract WebHistoryItem m45clone();

    public abstract Bitmap getFavicon();

    public boolean getNightMode() {
        return false;
    }

    public abstract String getOriginalUrl();

    public Picture getScreenshot() {
        return null;
    }

    public abstract String getTitle();

    public String getTouchIconUrl() {
        return null;
    }

    public abstract String getUrl();

    public int getVisibleTitleHeight() {
        return 0;
    }
}
