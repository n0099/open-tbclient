package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.compatible.menukey.MenuKeyUtils;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public a f22128e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f22129f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22129f = new Rect();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f22129f);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f22129f.top) - size;
        if (this.f22128e != null) {
            boolean z = true;
            if (!MenuKeyUtils.hasSmartBar() ? height <= 128 : height <= l.e(activity, 48.0f) + 128) {
                z = false;
            }
            this.f22128e.a(z);
        }
        super.onMeasure(i, i2);
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.f22128e = aVar;
    }
}
