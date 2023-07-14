package com.baidu.tieba;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes7.dex */
public interface q6c<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
