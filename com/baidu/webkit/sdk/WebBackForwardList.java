package com.baidu.webkit.sdk;

import java.io.Serializable;
/* loaded from: classes11.dex */
public abstract class WebBackForwardList implements Serializable, Cloneable {
    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public abstract WebBackForwardList m45clone();

    public abstract int getCurrentIndex();

    public abstract WebHistoryItem getCurrentItem();

    public abstract WebHistoryItem getItemAtIndex(int i);

    public abstract int getSize();
}
