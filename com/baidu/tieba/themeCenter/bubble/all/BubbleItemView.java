package com.baidu.tieba.themeCenter.bubble.all;

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
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class BubbleItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21924e;

    /* renamed from: f  reason: collision with root package name */
    public View f21925f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f21926g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21927h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21928i;
    public TbImageView j;
    public TbImageView k;
    public ImageView l;
    public DressItemData m;
    public d.a.j0.j3.f.a.a n;
    public boolean o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || BubbleItemView.this.m == null || BubbleItemView.this.n == null || view != BubbleItemView.this.f21927h) {
                return;
            }
            BubbleItemView.this.n.b(BubbleItemView.this.m, BubbleItemView.this.o);
        }
    }

    public BubbleItemView(Context context) {
        super(context);
        this.p = new a();
        this.f21924e = context;
        f();
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isDefault()) {
            this.f21927h.setDefaultResource(R.drawable.icon_choose_no);
            this.f21927h.V("", 10, false);
            this.f21928i.setText(R.string.default_bubble);
            this.f21928i.setGravity(17);
            this.f21928i.setTextSize(0, l.g(this.f21924e, R.dimen.ds28));
            this.f21928i.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f21928i.setLayoutParams(layoutParams);
            this.f21928i.setVisibility(0);
            this.f21926g.removeView(this.f21928i);
            this.f21926g.addView(this.f21928i);
        } else {
            this.f21926g.removeView(this.f21928i);
            this.f21927h.setDefaultResource(R.drawable.img_default_100);
            this.f21927h.V(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.l.setVisibility(0);
            SkinManager.setImageResource(this.l, R.drawable.icon_choose_photo);
        } else {
            this.l.setVisibility(8);
        }
        this.j.V(dressItemData.getPermissionImgUrl(), 10, false);
        this.k.V(dressItemData.getPropsStateImg(), 10, false);
        setVisibility(0);
    }

    public void e() {
        setVisibility(4);
    }

    public final void f() {
        View inflate = LayoutInflater.from(this.f21924e).inflate(R.layout.bubble_item, this);
        this.f21925f = inflate;
        this.f21926g = (FrameLayout) inflate.findViewById(R.id.ly_bubble);
        this.f21927h = (TbImageView) this.f21925f.findViewById(R.id.bg_image);
        TbImageView tbImageView = (TbImageView) this.f21925f.findViewById(R.id.permission_icon);
        this.j = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.j.setDefaultBgResource(R.drawable.transparent_bg);
        TbImageView tbImageView2 = (TbImageView) this.f21925f.findViewById(R.id.state_icon);
        this.k = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.k.setDefaultBgResource(R.drawable.transparent_bg);
        this.l = (ImageView) this.f21925f.findViewById(R.id.choosed_icon);
        this.f21928i = new TextView(this.f21924e);
        this.f21927h.setOnClickListener(this.p);
    }

    public void setController(d.a.j0.j3.f.a.a aVar) {
        this.n = aVar;
    }

    public void setFromBubbleGroup(boolean z) {
        this.o = z;
    }

    public BubbleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new a();
        this.f21924e = context;
        f();
    }

    public BubbleItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.p = new a();
        this.f21924e = context;
        f();
    }
}
