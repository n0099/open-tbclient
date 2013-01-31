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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aa;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ah;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.LbsView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class LbsActivity extends com.baidu.tieba.e {
    private LbsView c = null;
    private AbsoluteLayout d = null;
    private AbsoluteLayout e = null;
    private ArrayList f = null;
    private TextView g = null;
    private m h = null;
    private View.OnClickListener i = null;
    private AdapterView.OnItemClickListener j = null;
    private LinearLayout k = null;
    private ListView l = null;
    private k m = null;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private View r = null;
    private Animation.AnimationListener s = null;
    private ImageView t = null;
    private Random u = new Random();
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;
    private float y = 0.0f;
    private int z = 0;
    private Handler A = null;
    private boolean B = true;
    private com.baidu.tieba.c.d C = null;
    private com.baidu.tieba.c.d D = null;
    private Runnable E = null;
    private com.baidu.tieba.c.a F = null;
    private ProgressBar G = null;
    private LinkedList H = null;
    private com.baidu.tieba.x I = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lbs_activity);
        w();
        o();
        a((Location) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.b().b(this.I);
        if (this.m != null) {
            this.m.a();
        }
        n();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.a().b();
        }
        this.F.b();
        this.A.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h != null && this.h.b() != null && this.k.getParent() != null) {
            this.A.removeCallbacks(this.E);
            this.A.postDelayed(this.E, 300L);
        }
        i();
        if (this.B) {
            this.A.removeMessages(1);
            this.A.sendMessageDelayed(this.A.obtainMessage(1), 5000L);
        }
    }

    private void i() {
        int childCount = this.d.getChildCount();
        for (int i = 1; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof ArrayList) && ((ArrayList) childAt.getTag()).size() > 0) {
                Object obj = ((ArrayList) childAt.getTag()).get(0);
                if ((obj instanceof ab) && ((ab) obj).a() == 1) {
                    this.F.a(((ab) obj).d(), this.D);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k.clearAnimation();
        this.e.removeView(this.k);
        if (this.r != null) {
            this.r.setVisibility(0);
        }
        this.h.a().b();
    }

    private void k() {
        this.k = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.lbs_list, (ViewGroup) null);
        this.l = (ListView) this.k.findViewById(R.id.list);
        this.l.setAdapter((ListAdapter) this.h);
        this.l.setOnItemClickListener(this.j);
        this.l.setOnScrollListener(new a(this));
    }

    private m l() {
        return new m(this);
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

    private Rect b(View view, int i) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        if (i > ((int) (this.d.getHeight() * 0.5f))) {
            i = (int) (this.d.getHeight() * 0.5f);
        }
        int left = view.getLeft() + (view.getWidth() >> 1);
        int top = view.getTop() + (view.getHeight() >> 1);
        if (left > (this.d.getWidth() >> 1)) {
            rect.right = view.getLeft() + view.getWidth();
            rect.left = rect.right - ((int) (this.d.getWidth() * 0.6666667f));
        } else {
            rect.left = view.getLeft();
            rect.right = rect.left + ((int) (this.d.getWidth() * 0.6666667f));
        }
        if (rect.left < this.z) {
            int i2 = this.z - rect.left;
            rect.left = this.z;
            rect.right = i2 + rect.right;
        }
        if (rect.right > this.d.getWidth() - this.z) {
            int width = rect.right - (this.d.getWidth() - this.z);
            rect.right = this.d.getWidth() - this.z;
            rect.left -= width;
        }
        if (top > (this.d.getHeight() >> 1)) {
            rect.bottom = view.getTop() + view.getHeight();
            rect.top = rect.bottom - i;
            return rect;
        }
        rect.top = view.getTop();
        rect.bottom = rect.top + i;
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        if (this.k.getParent() != null) {
            if (this.k.getAnimation() == null || this.k.getAnimation().hasEnded()) {
                this.k.clearAnimation();
                this.l.setSelection(0);
                ScaleAnimation p = p();
                if (p != null) {
                    p.setAnimationListener(this.s);
                    this.k.startAnimation(p);
                } else {
                    j();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.c.a(i);
        if (i == 1) {
            this.g.setTextColor(ad.a(i));
            this.t.setImageResource(R.drawable.lbs_refresh_1);
        } else {
            this.g.setTextColor(-16777216);
            this.t.setImageResource(R.drawable.lbs_refresh);
        }
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            a(i, this.d.getChildAt(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void g() {
        super.g();
        a_(-1);
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(-1, this.d.getChildAt(i));
        }
        this.t.setImageResource(0);
    }

    private void a(int i, View view) {
        int size;
        ab abVar;
        ImageView imageView;
        if (view != null && view.getTag() != null) {
            if ((view.getTag() instanceof aa) && (view instanceof ImageView)) {
                if (i == -1) {
                    ((ImageView) view).setImageResource(0);
                } else if (i == 1) {
                    ((ImageView) view).setImageResource(R.drawable.lbs_icon_forum_1);
                } else {
                    ((ImageView) view).setImageResource(R.drawable.lbs_icon_forum);
                }
            } else if (view.getTag() instanceof l) {
                l lVar = (l) view.getTag();
                if (lVar.a != null && (size = lVar.a.size()) > 0 && (abVar = (ab) lVar.a.get(0)) != null) {
                    if (abVar.a() == 1 && abVar.d() != null) {
                        View findViewById = view.findViewById(R.id.lbs_album_id);
                        if (findViewById != null) {
                            if (size > 1) {
                                if (i == -1) {
                                    findViewById.setBackgroundResource(0);
                                    return;
                                } else if (i == 1) {
                                    findViewById.setBackgroundResource(R.drawable.lbs_album_more_1);
                                    return;
                                } else {
                                    findViewById.setBackgroundResource(R.drawable.lbs_album_more);
                                    return;
                                }
                            } else if (i == -1) {
                                findViewById.setBackgroundResource(0);
                                return;
                            } else if (i == 1) {
                                findViewById.setBackgroundResource(R.drawable.lbs_album_one_1);
                                return;
                            } else {
                                findViewById.setBackgroundResource(R.drawable.lbs_album_one);
                                return;
                            }
                        }
                        return;
                    }
                    View findViewById2 = view.findViewById(R.id.lbs_threads_id);
                    if (findViewById2 != null && (findViewById2 instanceof ImageView) && (imageView = (ImageView) findViewById2) != null) {
                        if (i == -1) {
                            imageView.setBackgroundResource(0);
                        } else if (i == 1) {
                            imageView.setImageResource(R.drawable.lbs_icon_thread_1);
                        } else {
                            imageView.setImageResource(R.drawable.lbs_icon_thread);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        View view2;
        if (this.k.getParent() != null) {
            this.k.clearAnimation();
            j();
        }
        if (view.getTag() != null) {
            if (view.getTag() instanceof l) {
                this.h.a(((l) view.getTag()).a);
            } else if (view.getTag() instanceof aa) {
                this.h.a((aa) view.getTag());
            }
            this.h.notifyDataSetChanged();
        }
        int count = this.h.getCount();
        if (count > 0 && (view2 = this.h.getView(0, null, null)) != null) {
            view2.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
            Rect b = b(view, ((count - 1) * this.l.getDividerHeight()) + (view2.getMeasuredHeight() * count) + this.k.getPaddingTop() + this.k.getPaddingBottom());
            AbsoluteLayout.LayoutParams a = a(b);
            if (a == null) {
                return false;
            }
            this.k.setLayoutParams(a);
            this.l.setSelection(0);
            this.e.addView(this.k);
            ScaleAnimation a2 = a(view, b);
            if (a2 != null) {
                this.k.startAnimation(a2);
            }
            this.r = view;
            this.r.setVisibility(8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.B = false;
        this.A.removeMessages(1);
    }

    private void o() {
        this.H = new LinkedList();
        this.F = new com.baidu.tieba.c.a(this);
        this.F.a("_mini");
        int a = ah.a(this, 40.0f);
        this.F.a(a, a);
        this.n = ah.a(this, 29.0f);
        this.o = ah.a(this, 18.0f);
        this.p = ah.a(this, 17.0f);
        this.q = ah.a(this, 64.0f);
        this.z = ah.a(this, 10.0f);
        this.i = new b(this);
        this.s = new c(this);
        this.A = new d(this);
        this.j = new e(this);
        this.D = new f(this);
        this.C = new g(this);
        this.E = new h(this);
        if (this.f == null) {
            this.f = new ArrayList(3);
        }
        for (int i = 0; i < 3; i++) {
            this.f.add(new SparseArray(3));
        }
        this.G = (ProgressBar) findViewById(R.id.progress);
        this.g = (TextView) findViewById(R.id.error_info);
        this.t = (ImageView) findViewById(R.id.refresh);
        this.t.setOnClickListener(this.i);
        this.d = (AbsoluteLayout) findViewById(R.id.layout);
        this.e = (AbsoluteLayout) findViewById(R.id.list_container);
        this.c = (LbsView) findViewById(R.id.lbs);
        this.c.setOnClickListener(this.i);
        this.c.setZoneNum(3);
        this.h = l();
        k();
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
        this.x = left;
        this.y = top;
        this.v = width2;
        this.w = height2;
        return scaleAnimation;
    }

    private ScaleAnimation p() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.v, 1.0f, this.w, 1, this.x, 1, this.y);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    private void q() {
        if (this.f != null) {
            int size = this.f.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 3 && i2 < size) {
                    ((SparseArray) this.f.get(i2)).clear();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private Rect c(int i) {
        if (i < 0 || i >= 3) {
            return null;
        }
        Rect rect = new Rect();
        int width = this.d.getWidth();
        int height = this.d.getHeight();
        if (width <= 0 || height <= 0) {
            getWindow().getDecorView().measure(View.MeasureSpec.makeMeasureSpec(ah.a((Context) this), 1073741824), View.MeasureSpec.makeMeasureSpec(ah.b((Context) this), 1073741824));
            width = this.d.getMeasuredWidth();
            height = this.d.getMeasuredHeight();
        }
        rect.left = 0;
        rect.right = width;
        rect.top = (height * i) / 3;
        rect.bottom = ((i + 1) * height) / 3;
        if (i == 2) {
            rect.bottom = height - this.q;
            if (rect.bottom < rect.top) {
                rect.bottom = rect.top;
            }
        }
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Point a(int i, int i2, int i3) {
        SparseArray sparseArray;
        if (this.f != null) {
            int size = this.f.size();
            if (i >= 0 && i < size) {
                sparseArray = (SparseArray) this.f.get(i);
                if (sparseArray != null) {
                    return null;
                }
                Rect c = c(i);
                int d = d(i2);
                if (sparseArray.get(d) != null) {
                    for (int i4 = 0; i4 < i2 - 1; i4++) {
                        d++;
                        if (d >= i2) {
                            d = 0;
                        }
                        if (sparseArray.get(d) == null) {
                            break;
                        }
                    }
                }
                int i5 = c.right - c.left;
                int i6 = c.bottom - c.top;
                c.left = (c.right * d) / i2;
                c.right = ((d + 1) * c.right) / i2;
                Point point = new Point();
                point.x = d((i5 / i2) - (i3 * 2)) + c.left + i3;
                point.y = c.top + i3 + d(i6 - (i3 * 2));
                int c2 = this.c.c(i);
                if (d == 0 && point.x - i3 < c2) {
                    int height = (int) ((this.c.getHeight() * (this.c.getDistanceOffset() + i)) / this.c.getZoneNum());
                    int fontSize = (height + (height - ((int) this.c.getFontSize()))) >> 1;
                    if (Math.abs(fontSize - point.y) < (this.c.getZoneNum() >> 1) + i3) {
                        point.y = fontSize - ((this.c.getZoneNum() >> 1) + i3);
                    }
                }
                sparseArray.put(d, point);
                return point;
            }
        }
        sparseArray = null;
        if (sparseArray != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i) {
        int nextInt = this.u.nextInt();
        if (nextInt != Integer.MIN_VALUE && i != 0) {
            return Math.abs(nextInt) % i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.g.setVisibility(8);
        if (this.m == null) {
            if (location == null && (location = TiebaApplication.b().a(this.I)) == null) {
                this.G.setVisibility(0);
            }
            if (location != null) {
                this.m = new k(this, location);
                this.m.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, ArrayList arrayList) {
        View inflate;
        if (arrayList != null && arrayList.size() > 0) {
            LayoutInflater from = LayoutInflater.from(this);
            if (arrayList.size() > 1) {
                View inflate2 = from.inflate(R.layout.lbs_album_more, (ViewGroup) null);
                ((TextView) inflate2.findViewById(R.id.num)).setText(String.valueOf(arrayList.size()));
                inflate = inflate2;
            } else {
                inflate = from.inflate(R.layout.lbs_album_one, (ViewGroup) null);
            }
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.lbs_album_id);
            if (relativeLayout != null) {
                if (arrayList.size() > 1) {
                    if (TiebaApplication.b().af() == 1) {
                        relativeLayout.setBackgroundResource(R.drawable.lbs_album_more_1);
                    } else {
                        relativeLayout.setBackgroundResource(R.drawable.lbs_album_more);
                    }
                } else if (TiebaApplication.b().af() == 1) {
                    relativeLayout.setBackgroundResource(R.drawable.lbs_album_one_1);
                } else {
                    relativeLayout.setBackgroundResource(R.drawable.lbs_album_one);
                }
            }
            ImageViewDrawer imageViewDrawer = (ImageViewDrawer) inflate.findViewById(R.id.image);
            imageViewDrawer.setDefaultId(R.drawable.lbs_def_image);
            String d = ((ab) arrayList.get(0)).d();
            if (d != null) {
                imageViewDrawer.setTag(d);
                imageViewDrawer.setImageSearchUrl(String.valueOf(d) + "_mini");
                Point a = a(i, i2, this.n);
                inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.n, a.y - this.n));
                inflate.setTag(new l(this, arrayList));
                inflate.setOnClickListener(this.i);
                inflate.setVisibility(8);
                c(inflate, this.n * 2);
                this.d.addView(inflate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, aa aaVar) {
        ImageView imageView = new ImageView(this);
        if (TiebaApplication.b().af() == 1) {
            imageView.setImageResource(R.drawable.lbs_icon_forum_1);
        } else {
            imageView.setImageResource(R.drawable.lbs_icon_forum);
        }
        Point a = a(i, i2, this.o);
        imageView.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.o, a.y - this.o));
        imageView.setPadding(0, 0, 0, 0);
        imageView.setTag(aaVar);
        imageView.setOnClickListener(this.i);
        imageView.setVisibility(8);
        c(imageView, this.o * 2);
        this.d.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.lbs_threads_icon, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.lbs_threads_id);
            if (imageView != null) {
                if (TiebaApplication.b().af() == 1) {
                    imageView.setImageResource(R.drawable.lbs_icon_thread_1);
                } else {
                    imageView.setImageResource(R.drawable.lbs_icon_thread);
                }
            }
            TextView textView = (TextView) inflate.findViewById(R.id.num);
            if (arrayList.size() > 1) {
                textView.setText(String.valueOf(arrayList.size()));
            } else {
                textView.setVisibility(8);
            }
            Point a = a(i, i2, this.p);
            inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, a.x - this.p, a.y - this.p));
            inflate.setTag(new l(this, arrayList));
            inflate.setOnClickListener(this.i);
            inflate.setVisibility(8);
            c(inflate, this.p * 2);
            this.d.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.r = null;
        int childCount = this.d.getChildCount();
        if (childCount > 1) {
            this.h.a().b();
            this.d.removeViews(1, childCount - 1);
            q();
        }
        this.e.removeAllViews();
        this.c.b();
        s();
    }

    private void s() {
        this.H.clear();
    }

    private void c(View view, int i) {
        AbsoluteLayout.LayoutParams layoutParams;
        if (view != null && (layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams()) != null) {
            int i2 = layoutParams.y + i;
            int size = this.H.size();
            int i3 = 0;
            while (i3 < size && ((j) this.H.get(i3)).b >= i2) {
                i3++;
            }
            j jVar = new j(this, null);
            jVar.a = view;
            jVar.b = i2;
            this.H.add(i3, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        u();
        this.A.sendMessageDelayed(this.A.obtainMessage(2), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.A.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View v() {
        if (this.H.size() > 0) {
            View view = ((j) this.H.remove()).a;
            if (view != null) {
                view.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                view.startAnimation(alphaAnimation);
                if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
                    this.c.b(((AbsoluteLayout.LayoutParams) view.getLayoutParams()).y);
                    return view;
                }
            }
            return view;
        }
        this.c.setDisplayNum(3);
        return null;
    }

    private void w() {
        this.I = new i(this);
    }
}
