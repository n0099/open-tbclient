package com.baidu.turbonet.net;

import com.baidu.turbonet.net.UrlRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public abstract class ResponseStreamCallbackForUrlRequest extends UrlRequest.Callback {
    private static ExecutorService bFJ = Executors.newCachedThreadPool();
}
