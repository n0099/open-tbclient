package com.baidu.tieba;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes8.dex */
public interface u5c<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
