package com.baidu.tieba;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes5.dex */
public interface n2a {
    void a(ReplaySubject$ReplayProducer replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(Object obj);
}
