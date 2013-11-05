package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2489a;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private Activity e;
    private LayoutInflater f;
    private TextView g;
    private int h;
    private int i;
    private View.OnClickListener j;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON,
        HOME_BUTTON
    }

    public NavigationBar(Context context) {
        super(context);
        this.f2489a = true;
        this.h = 0;
        this.i = 0;
        this.j = new av(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2489a = true;
        this.h = 0;
        this.i = 0;
        this.j = new av(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2489a = true;
        this.h = 0;
        this.i = 0;
        this.j = new av(this);
        a(context);
    }

    private void a(Context context) {
        this.e = (Activity) context;
        this.f = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.f.inflate(R.layout.widget_navigation_bar, (ViewGroup) this, true);
        this.b = (LinearLayout) inflate.findViewById(R.id.leftBox);
        this.c = (LinearLayout) inflate.findViewById(R.id.centerBox);
        this.d = (LinearLayout) inflate.findViewById(R.id.rightBox);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setGravity(48);
        a();
    }

    private void a() {
        setPadding(UtilHelper.a(this.e, getResources().getDimension(R.dimen.navigation_bar_padding_left)), UtilHelper.a(this.e, getResources().getDimension(R.dimen.navigation_bar_padding_top)), UtilHelper.a(this.e, getResources().getDimension(R.dimen.navigation_bar_padding_right)), UtilHelper.a(this.e, getResources().getDimension(R.dimen.navigation_bar_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.i = View.MeasureSpec.getSize(i);
        this.h = Math.max(this.b.getMeasuredWidth() + getPaddingLeft(), this.d.getMeasuredWidth() + getPaddingRight());
        this.c.measure((this.i - this.h) << 1, this.c.getMeasuredHeight());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.layout(this.h, this.c.getTop(), this.i - this.h, this.c.getBottom());
    }

    public TextView a(String str) {
        if (this.g == null) {
            this.g = (TextView) a(R.layout.widget_nb_item_title);
            this.c.addView(this.g);
        }
        this.g.setText(str);
        return this.g;
    }

    public ImageView a(ControlAlign controlAlign, ControlType controlType) {
        return a(controlAlign, controlType, this.j);
    }

    public ImageView a(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        ImageView imageView = null;
        if (controlType == ControlType.BACK_BUTTON) {
            imageView = (ImageView) a(R.layout.widget_nb_item_back);
        } else if (controlType == ControlType.HOME_BUTTON) {
            imageView = (ImageView) a(R.layout.widget_nb_item_home);
        }
        if (imageView != null) {
            a(controlAlign).addView(imageView);
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
        return imageView;
    }

    public Button a(ControlAlign controlAlign, String str) {
        return a(controlAlign, str, (View.OnClickListener) null);
    }

    public Button b(ControlAlign controlAlign, String str) {
        Button button = (Button) a(R.layout.widget_nb_item_stepbtn);
        button.setText(str);
        a(controlAlign).addView(button);
        return button;
    }

    public void setSystemClickable(boolean z) {
        this.f2489a = z;
    }

    public Button a(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        Button button = (Button) a(R.layout.widget_nb_item_textbtn);
        button.setText(str);
        a(controlAlign).addView(button);
        if (onClickListener != null) {
            button.setOnClickListener(onClickListener);
        }
        return button;
    }

    public View a(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        a(controlAlign).addView(view);
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        return view;
    }

    public View a(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return a(controlAlign, a(i), onClickListener);
    }

    private ViewGroup a(ControlAlign controlAlign) {
        return controlAlign == ControlAlign.HORIZONTAL_LEFT ? this.b : controlAlign == ControlAlign.HORIZONTAL_CENTER ? this.c : this.d;
    }

    public View a(int i) {
        return this.f.inflate(i, (ViewGroup) null);
    }

    public void b(int i) {
        if (i == 1) {
            setBackgroundResource(R.drawable.titlebar_bg_1);
        } else {
            setBackgroundResource(R.drawable.titlebar_bg);
        }
        a();
        if (this.e instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.e;
            jVar.m().a(i == 1);
            jVar.m().a(this);
        }
    }
}
