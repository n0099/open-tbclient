package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> pkJ;
    protected int[] pkK;
    protected a pkL;

    public SwipeListView(Context context) {
        super(context);
        this.pkJ = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pkJ = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pkJ = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void ene() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.pkJ.size()) {
                    if (this.pkJ.get(i2) != null) {
                        this.pkJ.get(i2).close();
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
        if (this.pkJ.indexOf(swipeListViewScroll) == -1) {
            this.pkJ.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ene();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.pkK = iArr;
        this.pkL = aVar;
    }
}
