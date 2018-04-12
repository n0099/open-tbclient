package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends PopupWindow {
    private KeyEventDealContainerView mContainer;
    private View mContentView;

    public c(Activity activity, View view2, Drawable drawable, KeyEventDealContainerView.a aVar) {
        super(activity);
        this.mContainer = null;
        this.mContentView = null;
        init(activity, view2, drawable, aVar);
    }

    private void init(Activity activity, View view2, Drawable drawable, KeyEventDealContainerView.a aVar) {
        if (activity != null) {
            this.mContentView = view2;
            this.mContainer = new KeyEventDealContainerView(activity, this.mContentView, aVar);
            setContentView(this.mContainer);
            setOutsideTouchable(true);
            setFocusable(true);
            setHeight(-1);
            setWidth(-1);
            setSoftInputMode(16);
            setFocusable(false);
            setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(d.C0126d.common_color_10022)));
            setAnimationStyle(d.l.pb_more_pop_anim);
        }
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }
}
