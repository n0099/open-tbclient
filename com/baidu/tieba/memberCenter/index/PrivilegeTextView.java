package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class PrivilegeTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public a f18245e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(CharSequence charSequence, int i2, int i3, int i4);
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public int getAvailableWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return ((((((((int) ((displayMetrics.widthPixels / displayMetrics.density) + 0.5f)) - 6) - 100) - 8) - 20) - 28) - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        a aVar = this.f18245e;
        if (aVar != null) {
            aVar.a(charSequence, i2, i3, i4);
        }
    }

    public void setTextChangeListener(a aVar) {
        this.f18245e = aVar;
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivilegeTextView(Context context) {
        super(context);
    }
}
