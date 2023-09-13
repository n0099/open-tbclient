package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.w3a;
/* loaded from: classes8.dex */
public interface w2a {
    void onDestroy();

    void onPause();

    void onPrimary(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewClick();

    void onViewDoubleClick();

    void onViewDragToRight();

    void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6);

    void setPageChangeHandler(w3a.a aVar, int i);

    void updateTiebaData(int i, VideoItemModel videoItemModel);
}
