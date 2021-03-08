package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> pmO;
    protected int[] pmP;
    protected a pmQ;

    public SwipeListView(Context context) {
        super(context);
        this.pmO = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pmO = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pmO = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void eno() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.pmO.size()) {
                    if (this.pmO.get(i2) != null) {
                        this.pmO.get(i2).close();
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
        if (this.pmO.indexOf(swipeListViewScroll) == -1) {
            this.pmO.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        eno();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.pmP = iArr;
        this.pmQ = aVar;
    }
}
