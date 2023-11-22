package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface kjc<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
