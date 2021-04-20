package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class PrivilegeTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public a f18617e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(CharSequence charSequence, int i, int i2, int i3);
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getAvailableWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return ((((((((int) ((displayMetrics.widthPixels / displayMetrics.density) + 0.5f)) - 6) - 100) - 8) - 20) - 28) - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        a aVar = this.f18617e;
        if (aVar != null) {
            aVar.a(charSequence, i, i2, i3);
        }
    }

    public void setTextChangeListener(a aVar) {
        this.f18617e = aVar;
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivilegeTextView(Context context) {
        super(context);
    }
}
