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
import d.b.i0.c2.h.e;
/* loaded from: classes5.dex */
public class PbThreadPostView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19841e;

    /* renamed from: f  reason: collision with root package name */
    public View f19842f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19843g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19844h;
    public View.OnClickListener i;

    public PbThreadPostView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f19842f = findViewById(R.id.pb_thread_post_container);
        this.f19843g = (TextView) findViewById(R.id.pb_thread_post_content);
        this.f19844h = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public final void b() {
        this.f19841e = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(R.layout.pb_thread_post_view, (ViewGroup) this, true);
        a();
    }

    public void c(int i) {
        SkinManager.setBackgroundColor(this.f19842f, R.color.CAM_X0205, i);
        SkinManager.setViewTextColor(this.f19843g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f19844h, R.color.CAM_X0302);
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.i == null) {
            this.i = onClickListener;
            this.f19844h.setOnClickListener(onClickListener);
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
