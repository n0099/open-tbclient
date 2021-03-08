package com.baidu.turbonet.net;

import com.baidu.turbonet.net.UrlRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class ResponseStreamCallbackForUrlRequest extends UrlRequest.Callback {
    private static ExecutorService cCr = Executors.newCachedThreadPool();
}
