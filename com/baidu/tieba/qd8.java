package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.tieba.pe8;
import com.baidu.tieba.video.VideoItemModel;
/* loaded from: classes5.dex */
public interface qd8 {
    void onDestroy();

    void onPause();

    void onPrimary(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewClick();

    void onViewDoubleClick();

    void onViewDragToRight();

    void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6);

    void setPageChangeHandler(pe8.a aVar, int i);

    void updateTiebaData(int i, VideoItemModel videoItemModel);
}
