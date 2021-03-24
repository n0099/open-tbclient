package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.c3.h0.a;
/* loaded from: classes5.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f20159e;

    /* renamed from: f  reason: collision with root package name */
    public a f20160f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20161g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f20162h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public boolean m;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public final void a() {
        this.l = LayoutInflater.from(this.f20159e).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.f20161g = (TbImageView) findViewById(R.id.pic_img);
        this.f20162h = (LinearLayout) findViewById(R.id.bottom_ll);
        this.j = (TextView) findViewById(R.id.title_ll);
        this.k = (TextView) findViewById(R.id.desc_ll);
        this.i = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public a getData() {
        return this.f20160f;
    }

    public ImageView getIcon() {
        return this.i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f20160f;
        if (aVar != null) {
            d.b.h0.l.a.l(this.f20159e, aVar.e());
        }
    }

    public void setData(a aVar) {
        if (aVar == null || this.f20160f == aVar) {
            return;
        }
        this.f20160f = aVar;
        if (!StringUtils.isNULL(aVar.f())) {
            this.j.setVisibility(0);
            this.j.setText(aVar.f());
        } else {
            this.j.setVisibility(8);
        }
        if (!StringUtils.isNULL(aVar.a())) {
            this.k.setVisibility(0);
            this.k.setText(aVar.a());
        } else {
            this.k.setVisibility(8);
        }
        if (this.m) {
            this.f20161g.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f20161g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20161g.setOnClickListener(this);
        this.f20161g.setInterceptOnClick(true);
        this.f20161g.setDefaultResource(R.drawable.icon_click);
        this.f20161g.W(aVar.c(), 18, false);
        int k = l.k(this.f20159e) - (l.g(this.f20159e, R.dimen.ds30) * 2);
        float f2 = b2 / d2;
        this.f20161g.setLayoutParams(new FrameLayout.LayoutParams(k, (int) (f2 > 1.7777778f ? k * 1.7777778f : f2 < 0.75f ? k * 0.75f : k * f2)));
        removeView(this.f20161g);
        addView(this.f20161g);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20162h.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = l.g(this.f20159e, R.dimen.ds110);
        removeView(this.f20162h);
        addView(this.f20162h, layoutParams);
    }

    public void setIconResId(int i) {
        SkinManager.setImageResource(this.i, i);
    }

    public void setSupportNoImage() {
        this.m = true;
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = false;
        this.f20159e = context;
        a();
    }
}
