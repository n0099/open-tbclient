package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface z0c<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
