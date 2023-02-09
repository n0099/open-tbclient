package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface yda<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
