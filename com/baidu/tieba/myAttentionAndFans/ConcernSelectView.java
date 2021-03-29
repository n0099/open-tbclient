package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19049e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19050f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19051g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19052h;
    public TextView i;
    public TextView j;
    public View k;
    public LinearLayout l;
    public Animation m;
    public Animation n;
    public boolean o;
    public g p;
    public int q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "1"));
            int i = ConcernSelectView.this.l.getVisibility() == 0 ? 1 : 0;
            ConcernSelectView concernSelectView = ConcernSelectView.this;
            concernSelectView.g(concernSelectView.l, i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "2"));
            SkinManager.setViewTextColor(ConcernSelectView.this.i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(ConcernSelectView.this.j, R.color.CAM_X0107);
            ConcernSelectView.this.f19052h.setText(R.string.all_concerned);
            if (ConcernSelectView.this.p != null) {
                ConcernSelectView.this.p.a(0);
            }
            ConcernSelectView concernSelectView = ConcernSelectView.this;
            concernSelectView.g(concernSelectView.l, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "3"));
            SkinManager.setViewTextColor(ConcernSelectView.this.i, R.color.CAM_X0107);
            SkinManager.setViewTextColor(ConcernSelectView.this.j, R.color.CAM_X0105);
            ConcernSelectView.this.f19052h.setText(R.string.each_concerned);
            if (ConcernSelectView.this.p != null) {
                ConcernSelectView.this.p.a(1);
            }
            ConcernSelectView concernSelectView = ConcernSelectView.this;
            concernSelectView.g(concernSelectView.l, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19056a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19057b;

        public d(int i, View view) {
            this.f19056a = i;
            this.f19057b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            boolean z = this.f19056a == 0;
            if (z && (view = this.f19057b) != null && (view.getParent() instanceof ListView)) {
                ListView listView = (ListView) this.f19057b.getParent();
                int bottom = this.f19057b.getBottom();
                Rect rect = new Rect();
                boolean globalVisibleRect = this.f19057b.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                listView.getGlobalVisibleRect(rect2);
                if (!globalVisibleRect) {
                    listView.smoothScrollBy(bottom, 260);
                } else if (rect2.bottom == rect.bottom) {
                    listView.smoothScrollBy(bottom, 260);
                }
            }
            if (ConcernSelectView.this.p != null) {
                ConcernSelectView.this.p.b(z);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            ConcernSelectView.this.o = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ConcernSelectView.this.o = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(int i);

        void b(boolean z);
    }

    public ConcernSelectView(Context context) {
        super(context);
        this.q = 3;
        this.f19049e = context;
        k();
    }

    public final void g(View view, int i) {
        LinearLayout linearLayout;
        if (view == null || view.getAnimation() != null || (linearLayout = this.l) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount < 0) {
            childCount = 0;
        }
        d.b.i0.u1.a aVar = new d.b.i0.u1.a(view, i, (((int) this.f19049e.getResources().getDimension(R.dimen.tbds80)) + ((int) this.f19049e.getResources().getDimension(R.dimen.ds1))) * childCount);
        if (i == 0 && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        aVar.setDuration(260L);
        aVar.setAnimationListener(new d(i, view));
        view.startAnimation(aVar);
        ImageView imageView = this.f19051g;
        if (imageView != null) {
            if (imageView.getAnimation() == null || this.f19051g.getAnimation().hasEnded()) {
                if (i == 0) {
                    if (this.m == null) {
                        j();
                    }
                    Animation animation = this.n;
                    if (animation != null) {
                        animation.cancel();
                    }
                    this.f19051g.startAnimation(this.m);
                    return;
                }
                if (this.n == null) {
                    i();
                }
                Animation animation2 = this.m;
                if (animation2 != null) {
                    animation2.cancel();
                }
                this.f19051g.startAnimation(this.n);
            }
        }
    }

    public void h() {
        if (this.l.getVisibility() == 0) {
            g(this.l, 1);
        }
    }

    public final void i() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19049e, R.anim.rotate_collapse);
        this.n = loadAnimation;
        loadAnimation.setAnimationListener(new e());
    }

    public final void j() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19049e, R.anim.rotate_expand);
        this.m = loadAnimation;
        loadAnimation.setAnimationListener(new f());
    }

    public final void k() {
        LayoutInflater.from(this.f19049e).inflate(R.layout.concern_select_layout, this);
        this.f19050f = (LinearLayout) findViewById(R.id.expandable_area);
        this.f19051g = (ImageView) findViewById(R.id.expandable_btn);
        this.l = (LinearLayout) findViewById(R.id.menu_list);
        this.f19052h = (TextView) findViewById(R.id.menu_title);
        this.i = (TextView) findViewById(R.id.all_concerned_item);
        this.j = (TextView) findViewById(R.id.each_concerned_item);
        this.k = findViewById(R.id.item_divider_line);
        this.f19050f.setOnClickListener(new a());
        this.i.setOnClickListener(new b());
        this.j.setOnClickListener(new c());
        m(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean l() {
        return this.l.getVisibility() == 0;
    }

    public void m(int i) {
        if (this.q == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19051g, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f19052h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        SkinManager.setBackgroundResource(this.l, R.drawable.concern_item_bg);
        SkinManager.setBackgroundResource(this.f19052h, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.i, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
    }

    public void setOnExpandListener(g gVar) {
        this.p = gVar;
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = 3;
        this.f19049e = context;
        k();
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = 3;
        this.f19049e = context;
        k();
    }
}
