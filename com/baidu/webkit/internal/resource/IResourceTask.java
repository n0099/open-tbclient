package com.baidu.webkit.internal.resource;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes14.dex */
public interface IResourceTask extends INoProGuard {

    /* loaded from: classes14.dex */
    public enum OutputType {
        FILE,
        STRING
    }

    /* loaded from: classes14.dex */
    public enum ResultType {
        RESULT_OK,
        RESULT_CACHE,
        RESULT_FAILED
    }

    /* loaded from: classes14.dex */
    public interface TaskPriority extends INoProGuard {
        public static final int HIGH = 1;
        public static final int IDLE = 4;
        public static final int LOW = 3;
        public static final int MEDIUM = 2;
        public static final int URGANT = 0;
    }

    String getCacheFileName();

    OutputType getOutputType();

    int getPriority();

    String getTaskName();

    String getTaskUrl();

    void onResourceReady(String str, ResultType resultType);

    boolean shouldForceLoadFromFile();
}
