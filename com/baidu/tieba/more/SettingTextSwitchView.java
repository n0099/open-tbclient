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

    /* renamed from: a  reason: collision with root package name */
    private Context f1972a;
    private LinearLayout b;
    private TextView c;
    private BdSwitchView d;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1972a = context;
        c();
        a(attributeSet);
        a(TiebaApplication.g().as());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.f1972a = context;
        c();
        a(TiebaApplication.g().as());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.b;
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.f1972a.getResources().getColor(R.color.skin_1_common_color));
            this.d.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
            return;
        }
        this.c.setTextColor(this.f1972a.getResources().getColor(R.color.more_color));
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
    }

    public void a() {
        this.d.b();
    }

    public void b() {
        this.d.a();
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setSwitchStateChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.d.setOnSwitchStateChangeListener(cVar);
    }

    private void c() {
        LayoutInflater.from(this.f1972a).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(R.id.container);
        this.c = (TextView) findViewById(R.id.text);
        this.d = (BdSwitchView) findViewById(R.id.button);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1972a.obtainStyledAttributes(attributeSet, com.baidu.tieba.al.SettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        if (string != null) {
            this.c.setText(string);
        }
        if (color > -1) {
            this.c.setTextColor(color);
        }
        this.b.setClickable(false);
        this.b.setFocusable(false);
    }

    public BdSwitchView getSwitchView() {
        return this.d;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.d = bdSwitchView;
    }
}
