package com.baidu.ugc.editvideo.record.preview;

import android.graphics.PointF;
/* loaded from: classes9.dex */
public interface OnMediaPreviewTouchEventListener {
    PointF getStickerCenterPoint();

    boolean onTouchDown(float f, float f2, float f3, float f4);

    void onTouchMove(float f, float f2, float f3, float f4);

    void onTouchUp(float f, float f2);
}
