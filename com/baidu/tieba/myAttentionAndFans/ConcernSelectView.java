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
    public Context f19162e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19163f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19164g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19165h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19166i;
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
            int i2 = ConcernSelectView.this.l.getVisibility() == 0 ? 1 : 0;
            ConcernSelectView concernSelectView = ConcernSelectView.this;
            concernSelectView.g(concernSelectView.l, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "2"));
            SkinManager.setViewTextColor(ConcernSelectView.this.f19166i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(ConcernSelectView.this.j, R.color.CAM_X0107);
            ConcernSelectView.this.f19165h.setText(R.string.all_concerned);
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
            SkinManager.setViewTextColor(ConcernSelectView.this.f19166i, R.color.CAM_X0107);
            SkinManager.setViewTextColor(ConcernSelectView.this.j, R.color.CAM_X0105);
            ConcernSelectView.this.f19165h.setText(R.string.each_concerned);
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
        public final /* synthetic */ int f19170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19171b;

        public d(int i2, View view) {
            this.f19170a = i2;
            this.f19171b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            boolean z = this.f19170a == 0;
            if (z && (view = this.f19171b) != null && (view.getParent() instanceof ListView)) {
                ListView listView = (ListView) this.f19171b.getParent();
                int bottom = this.f19171b.getBottom();
                Rect rect = new Rect();
                boolean globalVisibleRect = this.f19171b.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                listView.getGlobalVisibleRect(rect2);
                if (!globalVisibleRect) {
                    listView.smoothScrollBy(bottom, 260);
                } else if (rect2.bottom == rect.bottom) {
                    listView.smoothScrollBy(bottom, 260);
                }
            }
            if (ConcernSelectView.this.p != null) {
                ConcernSelectView.this.p.onExpand(z);
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
        void a(int i2);

        void onExpand(boolean z);
    }

    public ConcernSelectView(Context context) {
        super(context);
        this.q = 3;
        this.f19162e = context;
        k();
    }

    public final void g(View view, int i2) {
        LinearLayout linearLayout;
        if (view == null || view.getAnimation() != null || (linearLayout = this.l) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount < 0) {
            childCount = 0;
        }
        d.a.j0.v1.a aVar = new d.a.j0.v1.a(view, i2, (((int) this.f19162e.getResources().getDimension(R.dimen.tbds80)) + ((int) this.f19162e.getResources().getDimension(R.dimen.ds1))) * childCount);
        if (i2 == 0 && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        aVar.setDuration(260L);
        aVar.setAnimationListener(new d(i2, view));
        view.startAnimation(aVar);
        ImageView imageView = this.f19164g;
        if (imageView != null) {
            if (imageView.getAnimation() == null || this.f19164g.getAnimation().hasEnded()) {
                if (i2 == 0) {
                    if (this.m == null) {
                        j();
                    }
                    Animation animation = this.n;
                    if (animation != null) {
                        animation.cancel();
                    }
                    this.f19164g.startAnimation(this.m);
                    return;
                }
                if (this.n == null) {
                    i();
                }
                Animation animation2 = this.m;
                if (animation2 != null) {
                    animation2.cancel();
                }
                this.f19164g.startAnimation(this.n);
            }
        }
    }

    public void h() {
        if (this.l.getVisibility() == 0) {
            g(this.l, 1);
        }
    }

    public final void i() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19162e, R.anim.rotate_collapse);
        this.n = loadAnimation;
        loadAnimation.setAnimationListener(new e());
    }

    public final void j() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19162e, R.anim.rotate_expand);
        this.m = loadAnimation;
        loadAnimation.setAnimationListener(new f());
    }

    public final void k() {
        LayoutInflater.from(this.f19162e).inflate(R.layout.concern_select_layout, this);
        this.f19163f = (LinearLayout) findViewById(R.id.expandable_area);
        this.f19164g = (ImageView) findViewById(R.id.expandable_btn);
        this.l = (LinearLayout) findViewById(R.id.menu_list);
        this.f19165h = (TextView) findViewById(R.id.menu_title);
        this.f19166i = (TextView) findViewById(R.id.all_concerned_item);
        this.j = (TextView) findViewById(R.id.each_concerned_item);
        this.k = findViewById(R.id.item_divider_line);
        this.f19163f.setOnClickListener(new a());
        this.f19166i.setOnClickListener(new b());
        this.j.setOnClickListener(new c());
        m(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean l() {
        return this.l.getVisibility() == 0;
    }

    public void m(int i2) {
        if (this.q == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19164g, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f19165h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f19166i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        SkinManager.setBackgroundResource(this.l, R.drawable.concern_item_bg);
        SkinManager.setBackgroundResource(this.f19165h, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f19166i, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
    }

    public void setOnExpandListener(g gVar) {
        this.p = gVar;
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = 3;
        this.f19162e = context;
        k();
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = 3;
        this.f19162e = context;
        k();
    }
}
