package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2640a;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private TextView e;
    private Activity f;
    private LayoutInflater g;
    private TextView h;
    private int i;
    private int j;
    private View.OnClickListener k;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON,
        HOME_BUTTON,
        ADD_CHAT,
        EDIT_BUTTON,
        MORE_BUTTON,
        CAMERA_BUTTON
    }

    public NavigationBar(Context context) {
        super(context);
        this.f2640a = true;
        this.i = 0;
        this.j = 0;
        this.k = new aw(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2640a = true;
        this.i = 0;
        this.j = 0;
        this.k = new aw(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2640a = true;
        this.i = 0;
        this.j = 0;
        this.k = new aw(this);
        a(context);
    }

    private void a(Context context) {
        this.f = (Activity) context;
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.g.inflate(R.layout.widget_navigation_bar, (ViewGroup) this, true);
        this.b = (LinearLayout) inflate.findViewById(R.id.leftBox);
        this.c = (LinearLayout) inflate.findViewById(R.id.centerBox);
        this.d = (LinearLayout) inflate.findViewById(R.id.rightBox);
        this.e = (TextView) inflate.findViewById(R.id.navBottomLine);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setGravity(48);
        a();
    }

    private void a() {
        setPadding(com.baidu.adp.lib.h.g.a(this.f, getResources().getDimension(R.dimen.navi_padding_left)), com.baidu.adp.lib.h.g.a(this.f, getResources().getDimension(R.dimen.navi_padding_top)), com.baidu.adp.lib.h.g.a(this.f, getResources().getDimension(R.dimen.navi_padding_right)), com.baidu.adp.lib.h.g.a(this.f, getResources().getDimension(R.dimen.navi_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j = View.MeasureSpec.getSize(i);
        this.i = Math.max(this.b.getMeasuredWidth() + getPaddingLeft(), this.d.getMeasuredWidth() + getPaddingRight());
        this.c.measure((this.j - (this.i * 2)) + 1073741824, this.c.getMeasuredHeight() + 1073741824);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.layout(this.i, this.c.getTop(), this.j - this.i, this.c.getBottom());
    }

    public TextView a(String str) {
        if (this.h == null) {
            this.h = (TextView) b(R.layout.widget_nb_item_title);
            this.c.addView(this.h);
        }
        this.h.setText(str);
        return this.h;
    }

    public TextView a(int i) {
        return a(this.f.getString(i));
    }

    public View a(int i, View.OnClickListener onClickListener) {
        return a(ControlAlign.HORIZONTAL_CENTER, b(i), onClickListener);
    }

    public ImageView a(ControlAlign controlAlign, ControlType controlType) {
        return a(controlAlign, controlType, this.k);
    }

    public ImageView a(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        ImageView imageView = null;
        if (controlType == ControlType.BACK_BUTTON) {
            imageView = (ImageView) b(R.layout.widget_nb_item_back);
        } else if (controlType == ControlType.HOME_BUTTON) {
            imageView = (ImageView) b(R.layout.widget_nb_item_home);
        } else if (controlType == ControlType.ADD_CHAT) {
            imageView = (ImageView) b(R.layout.widget_nb_item_addchat);
        } else if (controlType == ControlType.EDIT_BUTTON) {
            imageView = (ImageView) b(R.layout.widget_nb_item_edit);
        } else if (controlType == ControlType.MORE_BUTTON) {
            imageView = (ImageView) b(R.layout.widget_nb_item_more);
        } else if (controlType == ControlType.CAMERA_BUTTON) {
            imageView = (ImageView) b(R.layout.widget_nb_item_pb_camera);
        }
        if (imageView != null) {
            a(controlAlign).addView(imageView);
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
        return imageView;
    }

    public TextView a(ControlAlign controlAlign, String str) {
        return a(controlAlign, str, (View.OnClickListener) null);
    }

    public void setSystemClickable(boolean z) {
        this.f2640a = z;
    }

    public TextView a(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) b(R.layout.widget_nb_item_textbtn);
        textView.setText(str);
        if (str != null && str.length() > 3 && textView.getTextSize() > 2.0f) {
            textView.setTextSize(0, textView.getTextSize() - 4.0f);
        }
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(R.dimen.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        }
        a(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public View a(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        a(controlAlign).addView(view);
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        return view;
    }

    public View a(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return a(controlAlign, b(i), onClickListener);
    }

    private ViewGroup a(ControlAlign controlAlign) {
        return controlAlign == ControlAlign.HORIZONTAL_LEFT ? this.b : controlAlign == ControlAlign.HORIZONTAL_CENTER ? this.c : this.d;
    }

    public View b(int i) {
        return this.g.inflate(i, (ViewGroup) this, false);
    }

    public void c(int i) {
        if (i == 1) {
            setBackgroundColor(getResources().getColor(R.color.navi_bg_1));
            this.e.setBackgroundColor(getResources().getColor(R.color.navi_line_1));
        } else {
            setBackgroundColor(getResources().getColor(R.color.navi_bg));
            this.e.setBackgroundColor(getResources().getColor(R.color.navi_line));
        }
        a();
        if (this.f instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.f;
            jVar.getLayoutMode().a(i == 1);
            jVar.getLayoutMode().a(this);
        } else if (this.f instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.f;
            baseFragmentActivity.a().a(i == 1);
            baseFragmentActivity.a().a(this);
        }
    }
}
