package com.baidu.webkit.internal;
/* loaded from: classes14.dex */
public class Statistics implements INoProGuard {
    public static int MONITOR_TYPE_ADD_JAVA_SCRIPT = 12320;
    public static final int kTypeWhiteScreen = 12302;
    public static final int kTypeWhiteScreenForAsyncSearch = 12304;

    /* loaded from: classes14.dex */
    public interface Client extends INoProGuard {
        boolean onCommitRecord(Record record);
    }

    /* loaded from: classes14.dex */
    public interface Record extends INoProGuard {
        int getType();

        String getUrl();

        String toJSON();
    }

    private Statistics() {
    }
}
