package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class MsgSettingItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20720e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20721f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20722g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwitchView f20723h;
    public View i;
    public int j;

    public MsgSettingItemView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view, (ViewGroup) this, true);
        this.f20720e = (TextView) findViewById(R.id.setting_text);
        this.f20721f = (TbImageView) findViewById(R.id.setting_tip_image);
        this.f20722g = (TextView) findViewById(R.id.setting_tip);
        BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.setting_switch);
        this.f20723h = bdSwitchView;
        l.c(context, bdSwitchView, 10, 10, 10, 10);
        View findViewById = findViewById(R.id.space_view);
        this.i = findViewById;
        findViewById.setVisibility(0);
    }

    public boolean b() {
        return this.f20723h.d();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().k(i == 1);
        tbPageContext.getLayoutMode().j(this);
        this.f20723h.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        int i2 = this.j;
        if (i2 != 0) {
            SkinManager.setImageResource(this.f20721f, i2);
        }
    }

    public void d() {
        this.f20723h.f();
    }

    public void e() {
        this.f20723h.h();
    }

    public void f() {
        this.f20723h.i();
    }

    public void g() {
        this.f20723h.k();
    }

    public BdSwitchView getSwitchView() {
        return this.f20723h;
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.b bVar) {
        this.f20723h.setOnSwitchStateChangeListener(bVar);
    }

    public void setSpaceView(int i) {
        View view = this.i;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.f20723h.k();
        } else {
            this.f20723h.h();
        }
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.f20720e.setText(str);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.f20721f.setOnClickListener(onClickListener);
    }

    public void setTipImageResource(int i) {
        this.j = i;
        SkinManager.setImageResource(this.f20721f, i);
        this.f20721f.setVisibility(0);
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.f20722g.setVisibility(0);
        this.f20722g.setText(str);
    }

    public MsgSettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setText(int i) {
        if (i != 0) {
            this.f20720e.setText(i);
        }
    }

    public void setTipText(int i) {
        if (i != 0) {
            this.f20722g.setVisibility(0);
            this.f20722g.setText(i);
        }
    }
}
