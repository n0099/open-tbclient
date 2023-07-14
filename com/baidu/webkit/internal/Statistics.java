package com.baidu.webkit.internal;
/* loaded from: classes9.dex */
public class Statistics implements INoProGuard {
    public static final int kTypeWhiteScreen = 12302;
    public static final int kTypeWhiteScreenForAsyncSearch = 12304;

    /* loaded from: classes9.dex */
    public interface Client extends INoProGuard {
        boolean onCommitRecord(Record record);
    }

    /* loaded from: classes9.dex */
    public interface Record extends INoProGuard {
        int getType();

        String getUrl();

        String toJSON();
    }
}
