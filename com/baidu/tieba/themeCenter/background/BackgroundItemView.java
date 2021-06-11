package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import d.a.c.e.p.l;
import d.a.n0.k3.e.d;
/* loaded from: classes5.dex */
public class BackgroundItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21151e;

    /* renamed from: f  reason: collision with root package name */
    public View f21152f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21153g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21154h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21155i;
    public ImageView j;
    public TextView k;
    public SkinProgressView l;
    public DressItemData m;
    public int n;
    public int o;
    public d p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || BackgroundItemView.this.m == null || BackgroundItemView.this.p == null) {
                return;
            }
            if (view == BackgroundItemView.this.l) {
                TiebaStatic.log(new StatisticItem("c10280").param("obj_id", BackgroundItemView.this.m.getPropsId()));
                BackgroundItemView.this.p.e(BackgroundItemView.this.m, false);
            } else if (view == BackgroundItemView.this.f21153g) {
                TiebaStatic.log(new StatisticItem("c10279").param("obj_id", BackgroundItemView.this.m.getPropsId()));
                BackgroundItemView.this.p.b(BackgroundItemView.this.m);
            }
        }
    }

    public BackgroundItemView(Context context) {
        super(context);
        this.q = new a();
        this.f21151e = context;
        g();
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
        if (dressItemData.getPropsId() == 0) {
            SkinManager.setImageResource(this.f21153g, R.drawable.pic_bg_moren);
        } else {
            this.f21153g.setImageBitmap(null);
            this.f21153g.U(dressItemData.getExampleImgUrl(), 10, false);
        }
        this.k.setText(dressItemData.getTitle());
        if (valueOf.booleanValue()) {
            this.j.setVisibility(0);
            SkinManager.setImageResource(this.j, R.drawable.icon_choose_photo);
        } else {
            this.j.setVisibility(8);
        }
        this.f21154h.U(dressItemData.getPermissionImgUrl(), 10, false);
        this.f21155i.U(dressItemData.getPropsStateImg(), 10, false);
        if (valueOf.booleanValue()) {
            this.l.c(0, 0.0f);
        } else {
            this.l.c(4, 0.0f);
        }
        setVisibility(0);
    }

    public void f() {
        setVisibility(8);
    }

    public final void g() {
        int k = (l.k(this.f21151e) - l.g(this.f21151e, R.dimen.ds88)) / 3;
        this.n = k;
        this.o = (int) (k / 0.66d);
        View inflate = LayoutInflater.from(this.f21151e).inflate(R.layout.background_item, this);
        this.f21152f = inflate;
        this.f21153g = (TbImageView) inflate.findViewById(R.id.bg_image);
        TbImageView tbImageView = (TbImageView) this.f21152f.findViewById(R.id.permission_icon);
        this.f21154h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f21154h.setDefaultBgResource(R.drawable.transparent_bg);
        TbImageView tbImageView2 = (TbImageView) this.f21152f.findViewById(R.id.state_icon);
        this.f21155i = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.f21155i.setDefaultBgResource(R.drawable.transparent_bg);
        this.j = (ImageView) this.f21152f.findViewById(R.id.choosed_icon);
        this.k = (TextView) this.f21152f.findViewById(R.id.text_bg_name);
        SkinProgressView skinProgressView = (SkinProgressView) this.f21152f.findViewById(R.id.view_bg_use);
        this.l = skinProgressView;
        skinProgressView.setOnClickListener(this.q);
        this.f21153g.setOnClickListener(this.q);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21153g.getLayoutParams();
        layoutParams.height = this.o;
        layoutParams.width = this.n;
        this.f21153g.setLayoutParams(layoutParams);
    }

    public void setController(d dVar) {
        this.p = dVar;
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = new a();
        this.f21151e = context;
        g();
    }

    public BackgroundItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.q = new a();
        this.f21151e = context;
        g();
    }
}
