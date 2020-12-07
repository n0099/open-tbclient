package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> oYl;
    protected int[] oYm;
    protected a oYn;

    public SwipeListView(Context context) {
        super(context);
        this.oYl = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYl = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYl = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void eop() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.oYl.size()) {
                    if (this.oYl.get(i2) != null) {
                        this.oYl.get(i2).close();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SwipeListViewScroll swipeListViewScroll) {
        if (this.oYl.indexOf(swipeListViewScroll) == -1) {
            this.oYl.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        eop();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.oYm = iArr;
        this.oYn = aVar;
    }
}
