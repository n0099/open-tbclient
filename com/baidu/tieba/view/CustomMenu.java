package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CustomMenu extends PopupWindow {
    private LinearLayout line;
    private LinearLayout line1;
    private LinearLayout line2;
    private View.OnClickListener mClickListener;
    private Context mContext;

    public CustomMenu(Context context, View.OnClickListener clickListener) {
        super(context);
        this.mContext = context;
        this.mClickListener = clickListener;
        LayoutInflater mInflater = LayoutInflater.from(this.mContext);
        View mLayout = mInflater.inflate(R.layout.custom_menu, (ViewGroup) null);
        this.line = (LinearLayout) mLayout.findViewById(R.id.line);
        this.line1 = (LinearLayout) mLayout.findViewById(R.id.line1);
        this.line2 = (LinearLayout) mLayout.findViewById(R.id.line2);
        setContentView(mLayout);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.custom_animate);
        setFocusable(true);
    }

    public void add(int itemId, int order, CharSequence title, int resId) {
        if (order >= 1 && order <= 6) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            params.weight = 1.0f;
            Button button = new Button(this.mContext);
            button.setId(itemId);
            button.setText(title);
            button.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.custom_menu_bg));
            Drawable drawable = this.mContext.getResources().getDrawable(resId);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            button.setCompoundDrawables(null, drawable, null, null);
            if (order >= 1 && order <= 3) {
                this.line1.setVisibility(0);
                if (order > 1) {
                    params.leftMargin = 1;
                }
                this.line1.addView(button, params);
            }
            if (order >= 4 && order <= 6) {
                this.line2.setVisibility(0);
                params.topMargin = 1;
                if (order > 4) {
                    params.leftMargin = 1;
                }
                this.line2.addView(button, params);
            }
            button.setOnClickListener(this.mClickListener);
        }
    }

    public View findItem(int id) {
        return this.line.findViewById(id);
    }
}
