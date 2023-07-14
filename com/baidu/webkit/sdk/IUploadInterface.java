package com.baidu.webkit.sdk;

import android.graphics.Picture;
/* loaded from: classes9.dex */
public interface IUploadInterface {
    String getFileId();

    void init(Picture picture, String str);

    BOSResponseEntity upload();
}
