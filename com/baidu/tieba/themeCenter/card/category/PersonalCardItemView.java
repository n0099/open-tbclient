package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class PersonalCardItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21131e;

    /* renamed from: f  reason: collision with root package name */
    public View f21132f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21133g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21134h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21135i;
    public TbImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public d.a.n0.k3.a n;
    public b o;
    public int p;
    public int q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || PersonalCardItemView.this.o == null) {
                return;
            }
            PersonalCardItemView.this.o.a(PersonalCardItemView.this.n);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d.a.n0.k3.a aVar);
    }

    public PersonalCardItemView(Context context) {
        super(context);
        this.f21131e = context;
        d();
    }

    public void c(d.a.n0.k3.a aVar) {
        if (aVar == null) {
            return;
        }
        this.n = aVar;
        if (aVar.a() == d.a.n0.k3.a.k) {
            this.f21133g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f21133g, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f21133g, R.drawable.icon_bubble_choose_no);
            this.f21134h.setVisibility(0);
            this.j.setVisibility(8);
            this.f21135i.setVisibility(8);
        } else {
            this.f21134h.setVisibility(8);
            this.j.setVisibility(0);
            this.f21135i.setVisibility(0);
            this.f21133g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f21133g.setImageBitmap(null);
            this.f21133g.setDefaultResource(R.drawable.img_default_100);
            this.f21133g.V(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.k.setVisibility(0);
            SkinManager.setImageResource(this.k, R.drawable.icon_choose_photo);
        } else {
            this.k.setVisibility(8);
        }
        this.f21135i.V(aVar.i(), 10, false);
        this.j.V(aVar.b(), 10, false);
        this.l.setText(aVar.j());
        setVisibility(0);
    }

    public final void d() {
        setOrientation(1);
        int k = (l.k(this.f21131e) - l.g(this.f21131e, R.dimen.ds88)) / 3;
        this.p = k;
        this.q = (int) (k * 0.57d);
        View inflate = LayoutInflater.from(this.f21131e).inflate(R.layout.personal_card_item_layout, this);
        this.f21132f = inflate;
        this.f21133g = (TbImageView) inflate.findViewById(R.id.image_bg);
        TbImageView tbImageView = (TbImageView) this.f21132f.findViewById(R.id.permission_icon);
        this.f21135i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f21135i.setDefaultBgResource(R.drawable.transparent_bg);
        TbImageView tbImageView2 = (TbImageView) this.f21132f.findViewById(R.id.state_icon);
        this.j = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.j.setDefaultBgResource(R.drawable.transparent_bg);
        this.k = (ImageView) this.f21132f.findViewById(R.id.choosed_icon);
        this.f21134h = (TextView) this.f21132f.findViewById(R.id.txt_default);
        this.l = (TextView) this.f21132f.findViewById(R.id.view_card_name);
        this.m = this.f21132f.findViewById(R.id.black_stroke);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21133g.getLayoutParams();
        layoutParams.height = this.q;
        layoutParams.width = this.p;
        this.f21133g.setLayoutParams(layoutParams);
        this.m.setLayoutParams(layoutParams);
        this.f21133g.setOnClickListener(new a());
    }

    public b getCardViewController() {
        return this.o;
    }

    public void setCardViewController(b bVar) {
        this.o = bVar;
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21131e = context;
        d();
    }

    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21131e = context;
        d();
    }
}
