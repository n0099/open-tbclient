package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
final class WebBackForwardListImpl extends WebBackForwardList implements Cloneable {
    private static Method cloneMethod;
    private final android.webkit.WebBackForwardList mList;

    static {
        try {
            cloneMethod = android.webkit.WebBackForwardList.class.getDeclaredMethod("clone", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WebBackForwardListImpl(android.webkit.WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList from(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        return new WebBackForwardListImpl(webBackForwardList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebBackForwardList clone() {
        try {
            if (cloneMethod != null && this.mList != null) {
                return from((android.webkit.WebBackForwardList) cloneMethod.invoke(this.mList, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final int getCurrentIndex() {
        return this.mList.getCurrentIndex();
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebHistoryItem getCurrentItem() {
        return WebHistoryItemImpl.from(this.mList.getCurrentItem());
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final WebHistoryItem getItemAtIndex(int i) {
        return WebHistoryItemImpl.from(this.mList.getItemAtIndex(i));
    }

    @Override // com.baidu.webkit.sdk.WebBackForwardList
    public final int getSize() {
        return this.mList.getSize();
    }
}
