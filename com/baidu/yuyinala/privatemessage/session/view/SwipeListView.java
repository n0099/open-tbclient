package com.baidu.yuyinala.privatemessage.session.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwipeListView extends ListView {
    private ArrayList<SwipeListViewScroll> pkj;
    protected int[] pkk;
    protected a pkl;

    public SwipeListView(Context context) {
        super(context);
        this.pkj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pkj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public SwipeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pkj = new ArrayList<>();
        setMotionEventSplittingEnabled(false);
    }

    public void emV() {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 < this.pkj.size()) {
                    if (this.pkj.get(i2) != null) {
                        this.pkj.get(i2).close();
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
        if (this.pkj.indexOf(swipeListViewScroll) == -1) {
            this.pkj.add(swipeListViewScroll);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        emV();
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar, int[] iArr) {
        this.pkk = iArr;
        this.pkl = aVar;
    }
}
