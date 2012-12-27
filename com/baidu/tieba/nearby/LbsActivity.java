package com.baidu.tieba.nearby;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.LbsView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class LbsActivity extends com.baidu.tieba.e {
    private LbsView b = null;
    private AbsoluteLayout c = null;
    private AbsoluteLayout d = null;
    private ArrayList e = null;
    private TextView f = null;
    private m g = null;
    private View.OnClickListener h = null;
    private AdapterView.OnItemClickListener i = null;
    private LinearLayout j = null;
    private ListView k = null;
    private k l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private View q = null;
    private Animation.AnimationListener r = null;
    private View s = null;
    private Random t = new Random();
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;
    private int y = 0;
    private Handler z = null;
    private boolean A = true;
    private com.baidu.tieba.c.d B = null;
    private com.baidu.tieba.c.d C = null;
    private Runnable D = null;
    private com.baidu.tieba.c.a E = null;
    private ProgressBar F = null;
    private LinkedList G = null;
    private com.baidu.tieba.u H = null;

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Point a(int i, int i2, int i3) {
        SparseArray sparseArray;
        if (this.e != null) {
            int size = this.e.size();
            if (i >= 0 && i < size) {
                sparseArray = (SparseArray) this.e.get(i);
                if (sparseArray != null) {
                    return null;
                }
                Rect a = a(i);
                int b = b(i2);
                if (sparseArray.get(b) != null) {
                    for (int i4 = 0; i4 < i2 - 1; i4++) {
                        b++;
                        if (b >= i2) {
                            b = 0;
                        }
                        if (sparseArray.get(b) == null) {
                            break;
                        }
                    }
                }
                int i5 = a.right - a.left;
                int i6 = a.bottom - a.top;
                a.left = (a.right * b) / i2;
                a.right = ((b + 1) * a.right) / i2;
                Point point = new Point();
                point.x = b((i5 / i2) - (i3 * 2)) + a.left + i3;
                point.y = a.top + i3 + b(i6 - (i3 * 2));
                int b2 = this.b.b(i);
                if (b == 0 && point.x - i3 < b2) {
                    int height = (int) ((this.b.getHeight() * (this.b.getDistanceOffset() + i)) / this.b.getZoneNum());
                    int fontSize = (height + (height - ((int) this.b.getFontSize()))) >> 1;
                    if (Math.abs(fontSize - point.y) < (this.b.getZoneNum() >> 1) + i3) {
                        point.y = fontSize - ((this.b.getZoneNum() >> 1) + i3);
                    }
                }
                sparseArray.put(b, point);
                return point;
            }
        }
        sparseArray = null;
        if (sparseArray != null) {
        }
    }

    private Rect a(int i) {
        if (i < 0 || i >= 3) {
            return null;
        }
        Rect rect = new Rect();
        int width = this.c.getWidth();
        int height = this.c.getHeight();
        if (width <= 0 || height <= 0) {
            getWindow().getDecorView().measure(View.MeasureSpec.makeMeasureSpec(ag.a((Context) this), 1073741824), View.MeasureSpec.makeMeasureSpec(ag.b((Context) this), 1073741824));
            width = this.c.getMeasuredWidth();
            height = this.c.getMeasuredHeight();
        }
        rect.left = 0;
        rect.right = width;
        rect.top = (height * i) / 3;
        rect.bottom = ((i + 1) * height) / 3;
        if (i == 2) {
            rect.bottom = height - this.p;
            if (rect.bottom < rect.top) {
                rect.bottom = rect.top;
            }
        }
        return rect;
    }

    private ScaleAnimation a(View view, Rect rect) {
        if (view == null || rect == null) {
            return null;
        }
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        int width = view.getWidth();
        int height = view.getHeight();
        if (i <= 0 || i2 <= 0 || i - width <= 0 || i2 - height <= 0) {
            return null;
        }
        float left = ((view.getLeft() - rect.left) * i) / ((i - width) * i);
        float top = ((view.getTop() - rect.top) * i2) / ((i2 - height) * i2);
        float width2 = view.getWidth() / i;
        float height2 = view.getHeight() / i2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(width2, 1.0f, height2, 1.0f, 1, left, 1, top);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        this.w = left;
        this.x = top;
        this.u = width2;
        this.v = height2;
        return scaleAnimation;
    }

    private AbsoluteLayout.LayoutParams a(Rect rect) {
        if (rect == null) {
            return null;
        }
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        if (i <= 0) {
            i = 1;
        }
        return new AbsoluteLayout.LayoutParams(i, i2 > 0 ? i2 : 1, rect.left, rect.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, com.baidu.tieba.a.z zVar) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.lbs_icon_forum);
        Point a = a(i, i2, this.n);
        imageView.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.n, a.y - this.n));
        imageView.setTag(zVar);
        imageView.setOnClickListener(this.h);
        imageView.setVisibility(8);
        c(imageView, this.n * 2);
        this.c.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, ArrayList arrayList) {
        View inflate;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(this);
        if (arrayList.size() > 1) {
            View inflate2 = from.inflate(R.layout.lbs_album_more, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.num)).setText(String.valueOf(arrayList.size()));
            inflate = inflate2;
        } else {
            inflate = from.inflate(R.layout.lbs_album_one, (ViewGroup) null);
        }
        ImageViewDrawer imageViewDrawer = (ImageViewDrawer) inflate.findViewById(R.id.image);
        imageViewDrawer.setDefaultId(R.drawable.lbs_def_image);
        String d = ((aa) arrayList.get(0)).d();
        if (d != null) {
            imageViewDrawer.setTag(d);
            imageViewDrawer.setImageSearchUrl(String.valueOf(d) + "_mini");
            Point a = a(i, i2, this.m);
            inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.m, a.y - this.m));
            inflate.setTag(new l(this, arrayList));
            inflate.setOnClickListener(this.h);
            inflate.setVisibility(8);
            c(inflate, this.m * 2);
            this.c.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.f.setVisibility(8);
        if (this.l == null) {
            if (location == null && (location = TiebaApplication.a().a(this.H)) == null) {
                this.F.setVisibility(0);
            }
            if (location != null) {
                this.l = new k(this, location);
                this.l.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        View view2;
        if (this.j.getParent() != null) {
            this.j.clearAnimation();
            h();
        }
        if (view.getTag() != null) {
            if (view.getTag() instanceof l) {
                this.g.a(((l) view.getTag()).a);
            } else if (view.getTag() instanceof com.baidu.tieba.a.z) {
                this.g.a((com.baidu.tieba.a.z) view.getTag());
            }
            this.g.notifyDataSetChanged();
        }
        int count = this.g.getCount();
        if (count > 0 && (view2 = this.g.getView(0, null, null)) != null) {
            view2.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
            Rect b = b(view, ((count - 1) * this.k.getDividerHeight()) + (view2.getMeasuredHeight() * count) + this.j.getPaddingTop() + this.j.getPaddingBottom());
            AbsoluteLayout.LayoutParams a = a(b);
            if (a == null) {
                return false;
            }
            this.j.setLayoutParams(a);
            this.k.setSelection(0);
            this.d.addView(this.j);
            ScaleAnimation a2 = a(view, b);
            if (a2 != null) {
                this.j.startAnimation(a2);
            }
            this.q = view;
            this.q.setVisibility(8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int nextInt = this.t.nextInt();
        if (nextInt == Integer.MIN_VALUE || i == 0) {
            return 0;
        }
        return Math.abs(nextInt) % i;
    }

    private Rect b(View view, int i) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        if (i > ((int) (this.c.getHeight() * 0.5f))) {
            i = (int) (this.c.getHeight() * 0.5f);
        }
        int left = view.getLeft() + (view.getWidth() >> 1);
        int top = view.getTop() + (view.getHeight() >> 1);
        if (left > (this.c.getWidth() >> 1)) {
            rect.right = view.getLeft() + view.getWidth();
            rect.left = rect.right - ((int) (this.c.getWidth() * 0.6666667f));
        } else {
            rect.left = view.getLeft();
            rect.right = rect.left + ((int) (this.c.getWidth() * 0.6666667f));
        }
        if (rect.left < this.y) {
            int i2 = this.y - rect.left;
            rect.left = this.y;
            rect.right = i2 + rect.right;
        }
        if (rect.right > this.c.getWidth() - this.y) {
            int width = rect.right - (this.c.getWidth() - this.y);
            rect.right = this.c.getWidth() - this.y;
            rect.left -= width;
        }
        if (top > (this.c.getHeight() >> 1)) {
            rect.bottom = view.getTop() + view.getHeight();
            rect.top = rect.bottom - i;
            return rect;
        }
        rect.top = view.getTop();
        rect.bottom = rect.top + i;
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.lbs_threads_icon, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.num);
        if (arrayList.size() > 1) {
            textView.setText(String.valueOf(arrayList.size()));
        } else {
            textView.setVisibility(8);
        }
        Point a = a(i, i2, this.o);
        inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.o, a.y - this.o));
        inflate.setTag(new l(this, arrayList));
        inflate.setOnClickListener(this.h);
        inflate.setVisibility(8);
        c(inflate, this.o * 2);
        this.c.addView(inflate);
    }

    private void c(View view, int i) {
        AbsoluteLayout.LayoutParams layoutParams;
        if (view == null || (layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        int i2 = layoutParams.y + i;
        int size = this.G.size();
        int i3 = 0;
        while (i3 < size && ((j) this.G.get(i3)).b >= i2) {
            i3++;
        }
        j jVar = new j(this, null);
        jVar.a = view;
        jVar.b = i2;
        this.G.add(i3, jVar);
    }

    private void g() {
        int childCount = this.c.getChildCount();
        for (int i = 1; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof ArrayList) && ((ArrayList) childAt.getTag()).size() > 0) {
                Object obj = ((ArrayList) childAt.getTag()).get(0);
                if ((obj instanceof aa) && ((aa) obj).a() == 1) {
                    this.E.a(((aa) obj).d(), this.C);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.j.clearAnimation();
        this.d.removeView(this.j);
        if (this.q != null) {
            this.q.setVisibility(0);
        }
        this.g.a().b();
    }

    private void i() {
        this.j = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.lbs_list, (ViewGroup) null);
        this.k = (ListView) this.j.findViewById(R.id.list);
        this.k.setAdapter((ListAdapter) this.g);
        this.k.setOnItemClickListener(this.i);
        this.k.setOnScrollListener(new a(this));
    }

    private m j() {
        return new m(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (this.j.getParent() != null) {
            if (this.j.getAnimation() == null || this.j.getAnimation().hasEnded()) {
                this.j.clearAnimation();
                this.k.setSelection(0);
                ScaleAnimation n = n();
                if (n != null) {
                    n.setAnimationListener(this.r);
                    this.j.startAnimation(n);
                } else {
                    h();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.A = false;
        this.z.removeMessages(1);
    }

    private void m() {
        this.G = new LinkedList();
        this.E = new com.baidu.tieba.c.a(this);
        this.E.a("_mini");
        int a = ag.a((Context) this, 40.0f);
        this.E.a(a, a);
        this.m = ag.a((Context) this, 29.0f);
        this.n = ag.a((Context) this, 18.0f);
        this.o = ag.a((Context) this, 17.0f);
        this.p = ag.a((Context) this, 64.0f);
        this.y = ag.a((Context) this, 10.0f);
        this.h = new b(this);
        this.r = new c(this);
        this.z = new d(this);
        this.i = new e(this);
        this.C = new f(this);
        this.B = new g(this);
        this.D = new h(this);
        if (this.e == null) {
            this.e = new ArrayList(3);
        }
        for (int i = 0; i < 3; i++) {
            this.e.add(new SparseArray(3));
        }
        this.F = (ProgressBar) findViewById(R.id.progress);
        this.f = (TextView) findViewById(R.id.error_info);
        this.s = findViewById(R.id.refresh);
        this.s.setOnClickListener(this.h);
        this.c = (AbsoluteLayout) findViewById(R.id.layout);
        this.d = (AbsoluteLayout) findViewById(R.id.list_container);
        this.b = (LbsView) findViewById(R.id.lbs);
        this.b.setOnClickListener(this.h);
        this.b.setZoneNum(3);
        this.g = j();
        i();
    }

    private ScaleAnimation n() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.u, 1.0f, this.v, 1, this.w, 1, this.x);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    private void o() {
        if (this.e == null) {
            return;
        }
        int size = this.e.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3 || i2 >= size) {
                return;
            }
            ((SparseArray) this.e.get(i2)).clear();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.q = null;
        int childCount = this.c.getChildCount();
        if (childCount > 1) {
            this.g.a().b();
            this.c.removeViews(1, childCount - 1);
            o();
        }
        this.d.removeAllViews();
        this.b.b();
        q();
    }

    private void q() {
        this.G.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        s();
        this.z.sendMessageDelayed(this.z.obtainMessage(2), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.z.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View t() {
        if (this.G.size() <= 0) {
            this.b.setDisplayNum(3);
            return null;
        }
        View view = ((j) this.G.remove()).a;
        if (view != null) {
            view.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            view.startAnimation(alphaAnimation);
            if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
                this.b.a(((AbsoluteLayout.LayoutParams) view.getLayoutParams()).y);
                return view;
            }
        }
        return view;
    }

    private void u() {
        this.H = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lbs_activity);
        u();
        m();
        a((Location) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.a().b(this.H);
        if (this.l != null) {
            this.l.a();
        }
        l();
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.g != null) {
            this.g.a().b();
        }
        this.E.b();
        this.z.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.g != null && this.g.b() != null && this.j.getParent() != null) {
            this.z.removeCallbacks(this.D);
            this.z.postDelayed(this.D, 300L);
        }
        g();
        if (this.A) {
            this.z.removeMessages(1);
            this.z.sendMessageDelayed(this.z.obtainMessage(1), 5000L);
        }
    }
}
