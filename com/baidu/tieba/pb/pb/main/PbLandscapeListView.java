package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
public class PbLandscapeListView extends BdTypeListView {
    private a eKZ;
    private boolean isLandscape;

    /* loaded from: classes.dex */
    public interface a {
        void aRo();
    }

    public PbLandscapeListView(Context context) {
        super(context);
        this.isLandscape = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLandscape = false;
    }

    public PbLandscapeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLandscape = false;
    }

    public void setIsLandscape(boolean z) {
        this.isLandscape = z;
    }

    public void setOnLayoutListener(a aVar) {
        this.eKZ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isLandscape) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isLandscape) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eKZ != null) {
            this.eKZ.aRo();
        }
    }
}
