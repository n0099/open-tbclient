package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends PopupWindow {
    private com.baidu.tbadk.core.view.j mContainer;
    private View mContentView;

    public j(Activity activity, View view, Drawable drawable, j.a aVar) {
        super(activity);
        this.mContainer = null;
        this.mContentView = null;
        init(activity, view, drawable, aVar);
    }

    private void init(Activity activity, View view, Drawable drawable, j.a aVar) {
        this.mContentView = view;
        this.mContainer = new com.baidu.tbadk.core.view.j(activity, this.mContentView, aVar);
        setContentView(this.mContainer);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(drawable);
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(t.d.transparent)));
        setAnimationStyle(t.k.pb_more_pop_anim);
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }
}
