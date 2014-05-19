package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class LiveRoomEntranceScrollView extends ScrollView {
    private l a;

    public LiveRoomEntranceScrollView(Context context) {
        super(context);
    }

    public LiveRoomEntranceScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveRoomEntranceScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(i, i2, i3, i4);
        }
    }

    public void setOnSizeChangeListener(l lVar) {
        this.a = lVar;
    }
}
