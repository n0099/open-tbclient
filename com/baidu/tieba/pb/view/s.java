package com.baidu.tieba.pb.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends PopupWindow {
    private int ezZ;
    private j mContainer;
    private View mContentView;

    public s(Activity activity, View view, Drawable drawable, j.a aVar) {
        super(activity);
        this.mContainer = null;
        this.mContentView = null;
        this.ezZ = 0;
        init(activity, view, drawable, aVar);
    }

    private void init(Activity activity, View view, Drawable drawable, j.a aVar) {
        if (activity != null) {
            this.mContentView = view;
            this.mContainer = new j(activity, this.mContentView, aVar);
            TypedValue typedValue = new TypedValue();
            if (activity.getApplicationContext().getTheme() != null && activity.getApplicationContext().getTheme().resolveAttribute(16843499, typedValue, true)) {
                this.ezZ = TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getApplicationContext().getResources().getDisplayMetrics());
            }
            setContentView(this.mContainer);
            setOutsideTouchable(true);
            setFocusable(true);
            setHeight(-1);
            setWidth(-1);
            if (aRP() && this.mContainer != null && (this.mContainer.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
                layoutParams.bottomMargin = this.ezZ;
                this.mContentView.setLayoutParams(layoutParams);
            }
            setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(r.d.common_color_10022)));
            setAnimationStyle(r.k.pb_more_pop_anim);
        }
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }

    private boolean aRP() {
        return Build.MODEL != null && Build.MODEL.equals("Nexus 6");
    }
}
