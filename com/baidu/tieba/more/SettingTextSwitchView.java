package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    protected TextView a;
    private Context b;
    private LinearLayout c;
    private TextView d;
    private BdSwitchView e;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        d();
        a(attributeSet);
        a(TiebaApplication.g().al());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.b = context;
        d();
        a(TiebaApplication.g().al());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        d();
        a(attributeSet);
        a(TiebaApplication.g().al());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.c == null) {
            super.setOnClickListener(onClickListener);
        } else {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public View getView() {
        return this.c;
    }

    public void a(int i) {
        if (i == 1) {
            this.d.setTextColor(this.b.getResources().getColor(R.color.about_tip_color_1));
            this.e.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            if (this.a != null) {
                this.a.setTextColor(this.b.getResources().getColor(R.color.setting_subtip_color_1));
                return;
            }
            return;
        }
        this.d.setTextColor(this.b.getResources().getColor(R.color.about_tip_color));
        this.e.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
        if (this.a != null) {
            this.a.setTextColor(this.b.getResources().getColor(R.color.setting_subtip_color));
        }
    }

    public void a() {
        a(false);
    }

    public void b() {
        b(false);
    }

    public void a(boolean z) {
        this.e.b(z);
    }

    public void b(boolean z) {
        this.e.a(z);
    }

    public void setText(String str) {
        this.d.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.e.setOnSwitchStateChangeListener(cVar);
    }

    private void d() {
        LayoutInflater.from(this.b).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.c = (LinearLayout) findViewById(R.id.container);
        this.d = (TextView) findViewById(R.id.text);
        this.e = (BdSwitchView) findViewById(R.id.button);
        this.a = (TextView) findViewById(R.id.tip);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        setTag(this.e);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(attributeSet, com.baidu.tieba.am.SettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.a != null && string2 != null) {
            this.a.setVisibility(0);
            this.a.setText(string2);
            if (color2 > -1) {
                this.a.setTextColor(color2);
            }
        }
        if (string != null) {
            this.d.setText(string);
        }
        if (color > -1) {
            this.d.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.d.setTextSize(0, dimension);
        }
        this.c.setClickable(false);
        this.c.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.a != null) {
            c();
            this.a.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.a != null) {
            c();
            this.a.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.a != null) {
            this.a.setTextColor(i);
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.e;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.e = bdSwitchView;
    }
}
