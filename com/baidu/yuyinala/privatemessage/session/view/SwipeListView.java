package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> oZR;
    protected int[] oZS;
    protected a oZT;

    public SwipeListView(Context context) {
        super(context);
        this.oZR = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oZR = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZR = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void ekD() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.oZR.size()) {
                    if (this.oZR.get(i2) != null) {
                        this.oZR.get(i2).close();
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
        if (this.oZR.indexOf(swipeListViewScroll) == -1) {
            this.oZR.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ekD();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.oZS = iArr;
        this.oZT = aVar;
    }
}
