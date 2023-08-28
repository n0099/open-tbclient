package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface q7c<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
