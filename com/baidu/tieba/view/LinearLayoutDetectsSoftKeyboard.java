package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.compatible.menukey.MenuKeyUtils;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21814e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f21815f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21815f = new Rect();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f21815f);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f21815f.top) - size;
        if (this.f21814e != null) {
            boolean z = true;
            if (!MenuKeyUtils.hasSmartBar() ? height <= 128 : height <= l.e(activity, 48.0f) + 128) {
                z = false;
            }
            this.f21814e.a(z);
        }
        super.onMeasure(i, i2);
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.f21814e = aVar;
    }
}
