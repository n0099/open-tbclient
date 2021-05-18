package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.j0.r.u.c;
/* loaded from: classes5.dex */
public class TitleTipView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22003e;

    /* renamed from: f  reason: collision with root package name */
    public int f22004f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f22005g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22006h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22007i;
    public TextView j;
    public View k;
    public View.OnClickListener l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TitleTipView.this.a();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TitleTipView.this.a();
        }
    }

    public TitleTipView(Context context) {
        super(context);
        this.f22003e = 3;
        this.f22004f = 5000;
        this.l = new a();
        this.m = new b();
        b();
    }

    public void a() {
        setVisibility(8);
        e.a().removeCallbacks(this.m);
    }

    public final void b() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.f22005g = (LinearLayout) findViewById(R.id.tip_bg);
        this.f22006h = (ImageView) findViewById(R.id.img_icon);
        this.f22007i = (ImageView) findViewById(R.id.img_close);
        this.j = (TextView) findViewById(R.id.tv_tip);
        this.k = findViewById(R.id.tv_line);
        this.j.setText(R.string.add_title_tip);
        this.f22007i.setOnClickListener(this.l);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i2) {
        if (this.f22003e != i2) {
            c d2 = c.d(this.f22005g);
            d2.k(R.string.J_X05);
            d2.i(R.dimen.L_X01);
            d2.h(R.color.CAM_X0602);
            d2.f(R.color.CAM_X0206);
            c.d(this.k).f(R.color.CAM_X0203);
            c.d(this.j).q(R.color.CAM_X0107);
            this.f22007i.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_delete16, SkinManager.getColor(R.color.CAM_X0107), null));
            if (this.f22006h != null) {
                this.f22006h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.pic_post_fatiemijue, SkinManager.getColor(R.color.CAM_X0302), null));
            }
        }
        this.f22003e = i2;
    }

    public void d() {
        setVisibility(0);
        e.a().postDelayed(this.m, this.f22004f);
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22003e = 3;
        this.f22004f = 5000;
        this.l = new a();
        this.m = new b();
        b();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22003e = 3;
        this.f22004f = 5000;
        this.l = new a();
        this.m = new b();
        b();
    }
}
