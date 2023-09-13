package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface ti {
    boolean isOnCancle();

    void onDeletedVoice(String str);

    void onSendVoice(String str, int i);

    void onShowErr(int i, String str);

    void onShowRecordTime(int i);

    void onShowRecording(int i);

    void onStartedRecorder(boolean z, int i);

    void onStopingRecorder();
}
