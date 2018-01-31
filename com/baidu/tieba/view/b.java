package com.baidu.tieba.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class b extends RelativeLayout {
    private a hyC;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context) {
        super(context);
    }

    public a getListener() {
        return this.hyC;
    }

    public void setListener(a aVar) {
        this.hyC = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.hyC != null) {
            this.hyC.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
