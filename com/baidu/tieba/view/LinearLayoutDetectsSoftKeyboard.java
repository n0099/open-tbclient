package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f21836e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f21837f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21837f = new Rect();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f21837f);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f21837f.top) - size;
        if (this.f21836e != null) {
            boolean z = true;
            if (!MenuKeyUtils.hasSmartBar() ? height <= 128 : height <= l.e(activity, 48.0f) + 128) {
                z = false;
            }
            this.f21836e.a(z);
        }
        super.onMeasure(i2, i3);
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.f21836e = aVar;
    }
}
