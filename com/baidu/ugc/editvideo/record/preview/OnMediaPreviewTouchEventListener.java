package com.baidu.ugc.editvideo.record.preview;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public interface OnMediaPreviewTouchEventListener {
    PointF getStickerCenterPoint();

    boolean onTouchDown(float f2, float f3, float f4, float f5);

    void onTouchMove(float f2, float f3, float f4, float f5);

    void onTouchUp(float f2, float f3);
}
