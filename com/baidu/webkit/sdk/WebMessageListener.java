package com.baidu.webkit.sdk;

import android.net.Uri;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes11.dex */
public interface WebMessageListener extends INoProGuard {
    void onPostMessage(String str, Uri uri, boolean z, ReplyMessageProxy replyMessageProxy);
}
