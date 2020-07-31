package com.baidu.webkit.sdk.jschecker;

import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes8.dex */
public interface BdJsCheckPolicy extends INoProGuard {
    void onJsCheckFinished(BdJsCallInfo bdJsCallInfo);

    void onJsCheckUnFinished(BdJsCallInfo bdJsCallInfo);
}
