package com.baidu.webkit.sdk;

import java.io.Serializable;
/* loaded from: classes7.dex */
public abstract class WebBackForwardList implements Serializable, Cloneable {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: clone */
    public abstract WebBackForwardList mo81clone();

    public abstract int getCurrentIndex();

    public abstract WebHistoryItem getCurrentItem();

    public abstract WebHistoryItem getItemAtIndex(int i);

    public abstract int getSize();
}
