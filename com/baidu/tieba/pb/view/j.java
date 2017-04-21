package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends PopupWindow {
    private int eyq;
    private com.baidu.tbadk.core.view.j mContainer;
    private View mContentView;

    public j(Activity activity, View view, Drawable drawable, j.a aVar) {
        super(activity);
        this.mContainer = null;
        this.mContentView = null;
        this.eyq = 0;
        init(activity, view, drawable, aVar);
    }

    private void init(Activity activity, View view, Drawable drawable, j.a aVar) {
        if (activity != null) {
            this.mContentView = view;
            this.mContainer = new com.baidu.tbadk.core.view.j(activity, this.mContentView, aVar);
            TypedValue typedValue = new TypedValue();
            if (activity.getApplicationContext().getTheme() != null && activity.getApplicationContext().getTheme().resolveAttribute(16843499, typedValue, true)) {
                this.eyq = TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getApplicationContext().getResources().getDisplayMetrics());
            }
            setContentView(this.mContainer);
            setOutsideTouchable(true);
            setFocusable(true);
            setHeight(-1);
            setWidth(-1);
            setSoftInputMode(16);
            setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(w.e.common_color_10022)));
            setAnimationStyle(w.m.pb_more_pop_anim);
        }
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }
}
