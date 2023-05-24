package com.baidu.tieba;
/* loaded from: classes6.dex */
public interface j7b<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
