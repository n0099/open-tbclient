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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NavigationBar extends RelativeLayout {
    private boolean a;
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
        HOME_BUTTON,
        ADD_CHAT,
        EDIT_BUTTON,
        MORE_BUTTON,
        CAMERA_BUTTON;

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
        this.a = true;
        this.i = 0;
        this.j = 0;
        this.k = new bv(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.i = 0;
        this.j = 0;
        this.k = new bv(this);
        a(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.i = 0;
        this.j = 0;
        this.k = new bv(this);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        setPadding(BdUtilHelper.a(this.f, getResources().getDimension(R.dimen.navi_padding_left)), BdUtilHelper.a(this.f, getResources().getDimension(R.dimen.navi_padding_top)), BdUtilHelper.a(this.f, getResources().getDimension(R.dimen.navi_padding_right)), BdUtilHelper.a(this.f, getResources().getDimension(R.dimen.navi_padding_bottom)));
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

    public final TextView a(String str) {
        if (this.h == null) {
            this.h = (TextView) c(R.layout.widget_nb_item_title);
            this.c.addView(this.h);
        }
        this.h.setText(str);
        return this.h;
    }

    public final TextView a(int i) {
        return a(this.f.getString(i));
    }

    public final View a(int i, View.OnClickListener onClickListener) {
        return a(ControlAlign.HORIZONTAL_CENTER, c(i), (View.OnClickListener) null);
    }

    public final ImageView a(ControlAlign controlAlign, ControlType controlType) {
        return a(controlAlign, controlType, this.k);
    }

    public final ImageView a(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        ImageView imageView = null;
        if (controlType == ControlType.BACK_BUTTON) {
            imageView = (ImageView) c(R.layout.widget_nb_item_back);
        } else if (controlType == ControlType.HOME_BUTTON) {
            imageView = (ImageView) c(R.layout.widget_nb_item_home);
        } else if (controlType == ControlType.ADD_CHAT) {
            imageView = (ImageView) c(R.layout.widget_nb_item_addchat);
        } else if (controlType == ControlType.EDIT_BUTTON) {
            imageView = (ImageView) c(R.layout.widget_nb_item_edit);
        } else if (controlType == ControlType.MORE_BUTTON) {
            imageView = (ImageView) c(R.layout.widget_nb_item_more);
        } else if (controlType == ControlType.CAMERA_BUTTON) {
            imageView = (ImageView) c(R.layout.widget_nb_item_pb_camera);
        }
        if (imageView != null) {
            a(controlAlign).addView(imageView);
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
        return imageView;
    }

    public final TextView a(ControlAlign controlAlign, String str) {
        return a(controlAlign, str, (View.OnClickListener) null);
    }

    public final TextView a(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        TextView textView = (TextView) c(R.layout.widget_nb_item_create_group);
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

    public void setSystemClickable(boolean z) {
        this.a = z;
    }

    public final TextView a(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) c(R.layout.widget_nb_item_textbtn);
        textView.setText(str);
        if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) getResources().getDimension(R.dimen.navi_btn_margin_right);
            layoutParams.setMargins(0, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
        } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension2 = (int) getResources().getDimension(R.dimen.navi_btn_margin_right);
            layoutParams2.setMargins(dimension2, dimension2, 0, dimension2);
            textView.setLayoutParams(layoutParams2);
        }
        a(controlAlign).addView(textView);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    public final View a(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        a(controlAlign).addView(view);
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
        return view;
    }

    public final View a(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        return a(controlAlign, c(i), onClickListener);
    }

    private ViewGroup a(ControlAlign controlAlign) {
        return controlAlign == ControlAlign.HORIZONTAL_LEFT ? this.b : controlAlign == ControlAlign.HORIZONTAL_CENTER ? this.c : this.d;
    }

    private View c(int i) {
        return this.g.inflate(i, (ViewGroup) this, false);
    }

    public void b(int i) {
        if (i == 1) {
            setBackgroundColor(getResources().getColor(R.color.navi_bg_1));
            this.e.setBackgroundColor(getResources().getColor(R.color.navi_line_1));
        } else {
            setBackgroundColor(getResources().getColor(R.color.navi_bg));
            this.e.setBackgroundColor(getResources().getColor(R.color.navi_line));
        }
        a();
        if (this.f instanceof com.baidu.tieba.f) {
            com.baidu.tieba.f fVar = (com.baidu.tieba.f) this.f;
            fVar.getLayoutMode().a(i == 1);
            fVar.getLayoutMode().a(this);
        } else if (this.f instanceof com.baidu.tieba.k) {
            com.baidu.tieba.k kVar = (com.baidu.tieba.k) this.f;
            kVar.a().a(i == 1);
            kVar.a().a(this);
        }
    }
}
