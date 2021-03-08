package com.baidu.turbonet.net;
/* loaded from: classes5.dex */
public interface UploadDataSink {
    void onReadSucceeded(boolean z);

    void onRewindSucceeded();

    void z(Exception exc);
}
