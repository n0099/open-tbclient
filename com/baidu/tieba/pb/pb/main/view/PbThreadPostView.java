package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.k0.d2.h.e;
/* loaded from: classes5.dex */
public class PbThreadPostView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19298e;

    /* renamed from: f  reason: collision with root package name */
    public View f19299f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19300g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19301h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19302i;

    public PbThreadPostView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f19299f = findViewById(R.id.pb_thread_post_container);
        this.f19300g = (TextView) findViewById(R.id.pb_thread_post_content);
        this.f19301h = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public final void b() {
        this.f19298e = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(R.layout.pb_thread_post_view, (ViewGroup) this, true);
        a();
    }

    public void c(int i2) {
        SkinManager.setBackgroundColor(this.f19299f, R.color.CAM_X0205, i2);
        SkinManager.setViewTextColor(this.f19300g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f19301h, R.color.CAM_X0302);
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.f19302i == null) {
            this.f19302i = onClickListener;
            this.f19301h.setOnClickListener(onClickListener);
        }
    }

    public void setData(e eVar) {
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public PbThreadPostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
