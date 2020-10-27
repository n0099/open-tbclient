package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> oyj;
    protected int[] oyk;
    protected a oyl;

    public SwipeListView(Context context) {
        super(context);
        this.oyj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oyj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oyj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void eeM() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.oyj.size()) {
                    if (this.oyj.get(i2) != null) {
                        this.oyj.get(i2).close();
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
        if (this.oyj.indexOf(swipeListViewScroll) == -1) {
            this.oyj.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        eeM();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.oyk = iArr;
        this.oyl = aVar;
    }
}
