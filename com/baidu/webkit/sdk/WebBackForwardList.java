package com.baidu.webkit.sdk;

import java.io.Serializable;
/* loaded from: classes5.dex */
public abstract class WebBackForwardList implements Serializable, Cloneable {
    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public abstract WebBackForwardList m30clone();

    public abstract int getCurrentIndex();

    public abstract WebHistoryItem getCurrentItem();

    public abstract WebHistoryItem getItemAtIndex(int i2);

    public abstract int getSize();
}
