package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class JigsawAlbumListActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener {
    private static volatile int j = 0;
    private static volatile int k = 0;
    private static boolean q = false;
    private static boolean r = true;

    /* renamed from: a  reason: collision with root package name */
    u f2110a;
    r b;
    q c;
    private GridView i;
    private LinearLayout m;
    private HorizontalScrollView n;
    private TextView o;
    private final int f = 50;
    private final int g = 20;
    private ViewphotoLinkedHashMap h = new ViewphotoLinkedHashMap(50);
    private NavigationBar l = null;
    int d = 0;
    int e = 0;
    private boolean p = false;
    private Handler s = new p(this);

    public boolean a() {
        return q;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (a() || this.f2110a.b() == 0) {
            q = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.motu_albums_list_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.o = (TextView) findViewById(R.id.jigsaw_selected_text);
        this.e = (int) getResources().getDimension(R.dimen.onedip);
        this.d = (i - (this.e * 16)) / 3;
        this.f2110a = u.a();
        this.b = new r(this, this);
        this.i = (GridView) findViewById(R.id.jigsaw_grid);
        this.i.setAdapter((ListAdapter) this.b);
        this.i.setOnScrollListener(this);
        this.l = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        ((Button) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_textbtn, new n(this))).setText(R.string.jigsaw_start);
        this.m = (LinearLayout) findViewById(R.id.selected_ll);
        this.n = (HorizontalScrollView) findViewById(R.id.hsv);
        this.l.a(this.f2110a.d());
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p = true;
        r = true;
        this.c = new q(this);
        Thread thread = new Thread(this.c);
        thread.setDaemon(true);
        thread.start();
        this.o.setText(this.f2110a.e(this));
        d();
    }

    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.l.c(i);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.h.clear();
        super.onDestroy();
    }

    private void d() {
        this.m.removeAllViews();
        for (Uri uri : this.f2110a.c(this)) {
            w wVar = new w(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.jigsawSelectedWidth), (int) getResources().getDimension(R.dimen.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.a(uri)) {
                this.m.addView(wVar);
                wVar.setOnClickListener(new o(this, wVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < this.m.getChildCount(); i++) {
                View childAt = this.m.getChildAt(i);
                if ((childAt instanceof w) && uri.equals(((w) childAt).getUri())) {
                    this.m.removeView(childAt);
                }
            }
            int a2 = this.f2110a.a(uri);
            if (a2 >= 0 && (aVar = (a) this.h.get((Object) Integer.valueOf(a2))) != null) {
                aVar.setIsSelected(false);
            }
            this.f2110a.b(this, uri);
            this.o.setText(this.f2110a.e(this));
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.a();
        e();
        System.gc();
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        ImageView imageView;
        if (this.h.containsKey(Integer.valueOf(i))) {
            imageView = this.h.get((Object) Integer.valueOf(i));
            this.h.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            this.h.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    private void e() {
        int b = j + 20 > this.f2110a.b() ? this.f2110a.b() - j : 20;
        if (this.h.size() != 0) {
            for (int i = j; i < j + b; i++) {
                if (this.h.containsKey(Integer.valueOf(i))) {
                    this.h.get((Object) Integer.valueOf(i)).setImageBitmap(null);
                    this.h.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (u.a().c(this).size() >= 2) {
            if (r) {
                r = false;
                setResult(2);
                finish();
                return;
            }
            return;
        }
        x.a(R.string.jigsaw_2_least);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        j = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
