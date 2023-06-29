package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
/* loaded from: classes7.dex */
public interface qt4 {
    boolean a(MotionEvent motionEvent);

    boolean b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);

    boolean c(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    boolean d(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    boolean e(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    boolean onDoubleTap(MotionEvent motionEvent);

    boolean onDown(MotionEvent motionEvent);
}
