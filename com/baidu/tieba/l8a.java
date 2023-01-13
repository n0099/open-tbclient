package com.baidu.tieba;
/* loaded from: classes5.dex */
public interface l8a<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
