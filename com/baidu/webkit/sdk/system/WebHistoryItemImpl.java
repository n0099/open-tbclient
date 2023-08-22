package com.baidu.webkit.sdk.system;

import android.graphics.Bitmap;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public final class WebHistoryItemImpl extends WebHistoryItem implements Cloneable {
    public static Method cloneMethod;
    public final android.webkit.WebHistoryItem mItem;

    static {
        try {
            cloneMethod = android.webkit.WebHistoryItem.class.getDeclaredMethod("clone", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebHistoryItemImpl(android.webkit.WebHistoryItem webHistoryItem) {
        this.mItem = webHistoryItem;
    }

    public static WebHistoryItem from(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        return new WebHistoryItemImpl(webHistoryItem);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.webkit.sdk.WebHistoryItem
    /* renamed from: clone */
    public final WebHistoryItem mo161clone() {
        try {
            if (cloneMethod != null && this.mItem != null) {
                return from((android.webkit.WebHistoryItem) cloneMethod.invoke(this.mItem, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final Bitmap getFavicon() {
        return this.mItem.getFavicon();
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getOriginalUrl() {
        return this.mItem.getOriginalUrl();
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getTitle() {
        return this.mItem.getTitle();
    }

    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final String getUrl() {
        return this.mItem.getUrl();
    }
}
