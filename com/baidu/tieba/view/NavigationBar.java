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
    private LinearLayout f1957a;
    private LinearLayout b;
    private LinearLayout c;
    private Activity d;
    private LayoutInflater e;
    private TextView f;
    private int g;
    private int h;
    private View.OnClickListener i;

    /* loaded from: classes.dex */
    public enum ControlAlign {
        HORIZONTAL_LEFT,
        HORIZONTAL_CENTER,
        HORIZONTAL_RIGHT;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlAlign[] valuesCustom() {
            ControlAlign[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlAlign[] controlAlignArr = new ControlAlign[length];
            System.arraycopy(valuesCustom, 0, controlAlignArr, 0, length);
            return controlAlignArr;
        }
    }

    /* loaded from: classes.dex */
    public enum ControlType {
        BACK_BUTTON,
        HOME_BUTTON;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ControlType[] valuesCustom() {
            ControlType[] valuesCustom = values();
            int length = valuesCustom.length;
            ControlType[] controlTypeArr = new ControlType[length];
            System.arraycopy(valuesCustom, 0, controlTypeArr, 0, length);
            return controlTypeArr;
        }
    }

    public NavigationBar(Context context) {
        super(context);
        this.g = 0;
        this.h = 0;
        this.i = new av(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.h = 0;
        this.i = new av(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0;
        this.h = 0;
        this.i = new av(this);
        a(context);
    }

    private void a(Context context) {
        this.d = (Activity) context;
        this.e = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.e.inflate(R.layout.widget_navigation_bar, (ViewGroup) this, true);
        this.f1957a = (LinearLayout) inflate.findViewById(R.id.leftBox);
        this.b = (LinearLayout) inflate.findViewById(R.id.centerBox);
        this.c = (LinearLayout) inflate.findViewById(R.id.rightBox);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setGravity(48);
        a();
    }

    private void a() {
        setPadding(UtilHelper.a(this.d, getResources().getDimension(R.dimen.navigation_bar_padding_left)), UtilHelper.a(this.d, getResources().getDimension(R.dimen.navigation_bar_padding_top)), UtilHelper.a(this.d, getResources().getDimension(R.dimen.navigation_bar_padding_right)), UtilHelper.a(this.d, getResources().getDimension(R.dimen.navigation_bar_padding_bottom)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = View.MeasureSpec.getSize(i);
        this.g = Math.max(this.f1957a.getMeasuredWidth() + getPaddingLeft(), this.c.getMeasuredWidth() + getPaddingRight());
        this.b.measure((this.h - this.g) << 1, this.b.getMeasuredHeight());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.layout(this.g, this.b.getTop(), this.h - this.g, this.b.getBottom());
    }

    public TextView a(String str) {
        if (this.f == null) {
            this.f = (TextView) a(R.layout.widget_nb_item_title);
            this.b.addView(this.f);
        }
        this.f.setText(str);
        return this.f;
    }

    public ImageView a(ControlAlign controlAlign, ControlType controlType) {
        return a(controlAlign, controlType, this.i);
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
        if (controlAlign == ControlAlign.HORIZONTAL_LEFT) {
            return this.f1957a;
        }
        return controlAlign == ControlAlign.HORIZONTAL_CENTER ? this.b : this.c;
    }

    public View a(int i) {
        return this.e.inflate(i, (ViewGroup) null);
    }

    public void b(int i) {
        if (i == 1) {
            setBackgroundResource(R.drawable.titlebar_bg_1);
        } else {
            setBackgroundResource(R.drawable.titlebar_bg);
        }
        a();
        if (this.d instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.d;
            jVar.l().a(i == 1);
            jVar.l().a(this);
        }
    }
}
