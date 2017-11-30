package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends PopupWindow {
    private com.baidu.tbadk.core.view.d mContainer;
    private View mContentView;

    public f(Activity activity, View view, Drawable drawable, d.a aVar) {
        super(activity);
        this.mContainer = null;
        this.mContentView = null;
        init(activity, view, drawable, aVar);
    }

    private void init(Activity activity, View view, Drawable drawable, d.a aVar) {
        if (activity != null) {
            this.mContentView = view;
            this.mContainer = new com.baidu.tbadk.core.view.d(activity, this.mContentView, aVar);
            setContentView(this.mContainer);
            setOutsideTouchable(true);
            setFocusable(true);
            setHeight(-1);
            setWidth(-1);
            setSoftInputMode(16);
            setFocusable(false);
            setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(d.C0082d.common_color_10022)));
            setAnimationStyle(d.k.pb_more_pop_anim);
        }
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }
}
