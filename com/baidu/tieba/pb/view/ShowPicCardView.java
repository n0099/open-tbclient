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
import d.b.c.e.p.l;
import d.b.i0.d3.h0.a;
/* loaded from: classes3.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f19852e;

    /* renamed from: f  reason: collision with root package name */
    public a f19853f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19854g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19855h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public boolean m;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public final void a() {
        this.l = LayoutInflater.from(this.f19852e).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.f19854g = (TbImageView) findViewById(R.id.pic_img);
        this.f19855h = (LinearLayout) findViewById(R.id.bottom_ll);
        this.j = (TextView) findViewById(R.id.title_ll);
        this.k = (TextView) findViewById(R.id.desc_ll);
        this.i = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public a getData() {
        return this.f19853f;
    }

    public ImageView getIcon() {
        return this.i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f19853f;
        if (aVar != null) {
            d.b.h0.l.a.l(this.f19852e, aVar.e());
        }
    }

    public void setData(a aVar) {
        if (aVar == null || this.f19853f == aVar) {
            return;
        }
        this.f19853f = aVar;
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
            this.f19854g.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f19854g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f19854g.setOnClickListener(this);
        this.f19854g.setInterceptOnClick(true);
        this.f19854g.setDefaultResource(R.drawable.icon_click);
        this.f19854g.W(aVar.c(), 18, false);
        int k = l.k(this.f19852e) - (l.g(this.f19852e, R.dimen.ds30) * 2);
        float f2 = b2 / d2;
        this.f19854g.setLayoutParams(new FrameLayout.LayoutParams(k, (int) (f2 > 1.7777778f ? k * 1.7777778f : f2 < 0.75f ? k * 0.75f : k * f2)));
        removeView(this.f19854g);
        addView(this.f19854g);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19855h.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = l.g(this.f19852e, R.dimen.ds110);
        removeView(this.f19855h);
        addView(this.f19855h, layoutParams);
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
        this.f19852e = context;
        a();
    }
}
