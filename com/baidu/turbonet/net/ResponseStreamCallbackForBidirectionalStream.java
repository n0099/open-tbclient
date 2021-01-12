package com.baidu.turbonet.net;

import com.baidu.turbonet.net.BidirectionalStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public abstract class ResponseStreamCallbackForBidirectionalStream extends BidirectionalStream.Callback {
    private static final Executor mExecutor = Executors.newCachedThreadPool();
}
