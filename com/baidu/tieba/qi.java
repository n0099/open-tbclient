package com.baidu.tieba;
/* loaded from: classes7.dex */
public interface qi {
    boolean isOnCancle();

    void onDeletedVoice(String str);

    void onSendVoice(String str, int i);

    void onShowErr(int i, String str);

    void onShowRecordTime(int i);

    void onShowRecording(int i);

    void onStartedRecorder(boolean z, int i);

    void onStopingRecorder();
}
