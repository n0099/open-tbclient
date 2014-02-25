package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PartSwipeableViewPager extends ViewPager {
    private ArrayList<View> a;
    private boolean b;
    private boolean c;

    public PartSwipeableViewPager(Context context) {
        super(context);
        this.a = new ArrayList<>();
    }

    public PartSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a.clear();
        a(this);
    }

    private void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                Object tag = childAt.getTag();
                if (tag instanceof String) {
                    if ("scroll".equals((String) tag)) {
                        this.a.add(childAt);
                    } else {
                        a(viewGroup2);
                    }
                } else {
                    a(viewGroup2);
                }
            } else {
                Object tag2 = childAt.getTag();
                if ((tag2 instanceof String) && "scroll".equals((String) tag2)) {
                    this.a.add(childAt);
                }
            }
        }
    }

    private boolean a(MotionEvent motionEvent) {
        Iterator<View> it = this.a.iterator();
        while (it.hasNext()) {
            View next = it.next();
            int[] iArr = new int[2];
            next.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (rawX >= i && rawX <= i + next.getWidth() && rawY >= i2 && rawY <= next.getHeight() + i2) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.b = a(motionEvent);
                break;
        }
        if (this.b) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.b = false;
                    return false;
                case 2:
                default:
                    return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.c = a(motionEvent);
                break;
        }
        if (this.c) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.c = false;
                    return false;
                case 2:
                default:
                    return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
