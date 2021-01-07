package com.baidu.webkit.sdk.system;

import android.graphics.Bitmap;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
final class WebHistoryItemImpl extends WebHistoryItem implements Cloneable {
    private static Method cloneMethod;
    private final android.webkit.WebHistoryItem mItem;

    static {
        try {
            cloneMethod = android.webkit.WebHistoryItem.class.getDeclaredMethod("clone", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WebHistoryItemImpl(android.webkit.WebHistoryItem webHistoryItem) {
        this.mItem = webHistoryItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem from(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        return new WebHistoryItemImpl(webHistoryItem);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.webkit.sdk.WebHistoryItem
    public final WebHistoryItem clone() {
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
