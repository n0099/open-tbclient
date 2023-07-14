package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface v1c<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
