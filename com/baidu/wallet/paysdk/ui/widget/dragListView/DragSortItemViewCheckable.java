package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
/* loaded from: classes5.dex */
public class DragSortItemViewCheckable extends DragSortItemView implements Checkable {
    public DragSortItemViewCheckable(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            return ((Checkable) childAt).isChecked();
        }
        return false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
    }
}
