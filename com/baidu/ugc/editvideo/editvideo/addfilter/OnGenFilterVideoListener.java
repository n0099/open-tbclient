package com.baidu.ugc.editvideo.editvideo.addfilter;
/* loaded from: classes9.dex */
public interface OnGenFilterVideoListener {
    void onGenFilterVideoAbort();

    void onGenFilterVideoFail(int i, String str);

    void onGenFilterVideoProgress(int i);

    void onGenFilterVideoRecordError(int i, String str);

    void onGenFilterVideoSuccess(String str);
}
