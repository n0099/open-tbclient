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
import d.a.c.e.p.l;
import d.a.j0.d3.h0.a;
/* loaded from: classes3.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f20356e;

    /* renamed from: f  reason: collision with root package name */
    public a f20357f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20358g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f20359h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20360i;
    public TextView j;
    public TextView k;
    public View l;
    public boolean m;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public final void a() {
        this.l = LayoutInflater.from(this.f20356e).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.f20358g = (TbImageView) findViewById(R.id.pic_img);
        this.f20359h = (LinearLayout) findViewById(R.id.bottom_ll);
        this.j = (TextView) findViewById(R.id.title_ll);
        this.k = (TextView) findViewById(R.id.desc_ll);
        this.f20360i = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public a getData() {
        return this.f20357f;
    }

    public ImageView getIcon() {
        return this.f20360i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f20357f;
        if (aVar != null) {
            d.a.i0.l.a.l(this.f20356e, aVar.e());
        }
    }

    public void setData(a aVar) {
        if (aVar == null || this.f20357f == aVar) {
            return;
        }
        this.f20357f = aVar;
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
            this.f20358g.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f20358g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20358g.setOnClickListener(this);
        this.f20358g.setInterceptOnClick(true);
        this.f20358g.setDefaultResource(R.drawable.icon_click);
        this.f20358g.V(aVar.c(), 18, false);
        int k = l.k(this.f20356e) - (l.g(this.f20356e, R.dimen.ds30) * 2);
        float f2 = b2 / d2;
        this.f20358g.setLayoutParams(new FrameLayout.LayoutParams(k, (int) (f2 > 1.7777778f ? k * 1.7777778f : f2 < 0.75f ? k * 0.75f : k * f2)));
        removeView(this.f20358g);
        addView(this.f20358g);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20359h.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = l.g(this.f20356e, R.dimen.ds110);
        removeView(this.f20359h);
        addView(this.f20359h, layoutParams);
    }

    public void setIconResId(int i2) {
        SkinManager.setImageResource(this.f20360i, i2);
    }

    public void setSupportNoImage() {
        this.m = true;
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = false;
        this.f20356e = context;
        a();
    }
}
