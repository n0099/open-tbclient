package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class PrivilegeTextView extends TextView {
    private a lmd;

    /* loaded from: classes9.dex */
    public interface a {
        void b(CharSequence charSequence, int i, int i2, int i3);
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PrivilegeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivilegeTextView(Context context) {
        super(context);
    }

    public void setTextChangeListener(a aVar) {
        this.lmd = aVar;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.lmd != null) {
            this.lmd.b(charSequence, i, i2, i3);
        }
    }

    public int getAvailableWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return ((((((((int) ((displayMetrics.widthPixels / displayMetrics.density) + 0.5f)) - 6) - 100) - 8) - 20) - 28) - getPaddingLeft()) - getPaddingRight();
    }
}
