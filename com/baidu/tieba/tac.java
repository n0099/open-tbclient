package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface tac<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
