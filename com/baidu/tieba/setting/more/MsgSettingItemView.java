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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class MsgSettingItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20528e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20529f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20530g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwitchView f20531h;

    /* renamed from: i  reason: collision with root package name */
    public View f20532i;
    public int j;

    public MsgSettingItemView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.msg_setting_item_view, (ViewGroup) this, true);
        this.f20528e = (TextView) findViewById(R.id.setting_text);
        this.f20529f = (TbImageView) findViewById(R.id.setting_tip_image);
        this.f20530g = (TextView) findViewById(R.id.setting_tip);
        BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.setting_switch);
        this.f20531h = bdSwitchView;
        l.c(context, bdSwitchView, 10, 10, 10, 10);
        View findViewById = findViewById(R.id.space_view);
        this.f20532i = findViewById;
        findViewById.setVisibility(0);
    }

    public boolean b() {
        return this.f20531h.d();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(TbPageContext<?> tbPageContext, int i2) {
        tbPageContext.getLayoutMode().k(i2 == 1);
        tbPageContext.getLayoutMode().j(this);
        this.f20531h.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        int i3 = this.j;
        if (i3 != 0) {
            SkinManager.setImageResource(this.f20529f, i3);
        }
    }

    public void d() {
        this.f20531h.f();
    }

    public void e() {
        this.f20531h.h();
    }

    public void f() {
        this.f20531h.i();
    }

    public void g() {
        this.f20531h.k();
    }

    public BdSwitchView getSwitchView() {
        return this.f20531h;
    }

    @Deprecated
    public void setLineVisibility(boolean z) {
    }

    public void setOnSwitchStateChangeListener(BdSwitchView.b bVar) {
        this.f20531h.setOnSwitchStateChangeListener(bVar);
    }

    public void setSpaceView(int i2) {
        View view = this.f20532i;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void setSwitchStateNoCallback(boolean z) {
        if (z) {
            this.f20531h.k();
        } else {
            this.f20531h.h();
        }
    }

    public void setText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.f20528e.setText(str);
    }

    public void setTipImageListener(View.OnClickListener onClickListener) {
        this.f20529f.setOnClickListener(onClickListener);
    }

    public void setTipImageResource(int i2) {
        this.j = i2;
        SkinManager.setImageResource(this.f20529f, i2);
        this.f20529f.setVisibility(0);
    }

    public void setTipText(String str) {
        if (StringUtils.isNULL(str)) {
            str = "";
        }
        this.f20530g.setVisibility(0);
        this.f20530g.setText(str);
    }

    public MsgSettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setText(int i2) {
        if (i2 != 0) {
            this.f20528e.setText(i2);
        }
    }

    public void setTipText(int i2) {
        if (i2 != 0) {
            this.f20530g.setVisibility(0);
            this.f20530g.setText(i2);
        }
    }
}
