package com.baidu.ugc.editvideo.editvideo.addfilter;
/* loaded from: classes11.dex */
public interface OnGenFilterVideoListener {
    void onGenFilterVideoAbort();

    void onGenFilterVideoFail(int i2, String str);

    void onGenFilterVideoProgress(int i2);

    void onGenFilterVideoRecordError(int i2, String str);

    void onGenFilterVideoSuccess(String str);
}
