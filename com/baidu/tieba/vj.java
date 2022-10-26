package com.baidu.tieba;
/* loaded from: classes6.dex */
public interface vj {
    boolean isOnCancle();

    void onDeletedVoice(String str);

    void onSendVoice(String str, int i);

    void onShowErr(int i, String str);

    void onShowRecordTime(int i);

    void onShowRecording(int i);

    void onStartedRecorder(boolean z);

    void onStopingRecorder();
}
