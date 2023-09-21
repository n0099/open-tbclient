package com.baidu.tieba;

import com.baidu.searchbox.http.HttpManager;
import okhttp3.Callback;
import okhttp3.Request;
/* loaded from: classes8.dex */
public interface ts1 {
    HttpManager a();

    void call(HttpManager httpManager, Request request, Callback callback);
}
