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
public class JigsawAlbumListActivity extends com.baidu.tieba.f implements AbsListView.OnScrollListener {
    private static volatile int j = 0;
    private static volatile int k = 0;
    private static boolean q = false;
    private static boolean r = true;
    u a;
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
    private Handler s = new m(this);

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (q || this.a.b() == 0) {
            q = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.motu_albums_list_activity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        this.o = (TextView) findViewById(R.id.jigsaw_selected_text);
        this.e = (int) getResources().getDimension(R.dimen.onedip);
        this.d = (i - (this.e * 16)) / 3;
        this.a = u.a();
        this.b = new r(this, this);
        this.i = (GridView) findViewById(R.id.jigsaw_grid);
        this.i.setAdapter((ListAdapter) this.b);
        this.i.setOnScrollListener(this);
        this.l = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        ((Button) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_textbtn, new o(this))).setText(R.string.jigsaw_start);
        this.m = (LinearLayout) findViewById(R.id.selected_ll);
        this.n = (HorizontalScrollView) findViewById(R.id.hsv);
        this.l.a(this.a.e());
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p = true;
        r = true;
        this.c = new q(this);
        Thread thread = new Thread(this.c);
        thread.setDaemon(true);
        thread.start();
        this.o.setText(this.a.c(this));
        c();
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.l.b(i);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.h.clear();
        super.onDestroy();
    }

    private void c() {
        this.m.removeAllViews();
        for (Uri uri : this.a.d()) {
            w wVar = new w(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.jigsawSelectedWidth), (int) getResources().getDimension(R.dimen.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.a(uri)) {
                this.m.addView(wVar);
                wVar.setOnClickListener(new p(this, wVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(JigsawAlbumListActivity jigsawAlbumListActivity, Uri uri) {
        a aVar;
        if (uri != null) {
            for (int i = 0; i < jigsawAlbumListActivity.m.getChildCount(); i++) {
                View childAt = jigsawAlbumListActivity.m.getChildAt(i);
                if ((childAt instanceof w) && uri.equals(((w) childAt).getUri())) {
                    jigsawAlbumListActivity.m.removeView(childAt);
                }
            }
            int a = jigsawAlbumListActivity.a.a(uri);
            if (a >= 0 && (aVar = (a) jigsawAlbumListActivity.h.get((Object) Integer.valueOf(a))) != null) {
                aVar.setIsSelected(false);
            }
            jigsawAlbumListActivity.a.b(jigsawAlbumListActivity, uri);
            jigsawAlbumListActivity.o.setText(jigsawAlbumListActivity.a.c(jigsawAlbumListActivity));
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.a();
        int b = j + 20 > this.a.b() ? this.a.b() - j : 20;
        if (this.h.size() != 0) {
            for (int i = j; i < j + b; i++) {
                if (this.h.containsKey(Integer.valueOf(i))) {
                    this.h.get((Object) Integer.valueOf(i)).setImageBitmap(null);
                    this.h.get((Object) Integer.valueOf(i)).setTag("");
                }
            }
        }
        System.gc();
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(JigsawAlbumListActivity jigsawAlbumListActivity, int i, Bitmap bitmap) {
        ImageView imageView;
        if (jigsawAlbumListActivity.h.containsKey(Integer.valueOf(i))) {
            imageView = jigsawAlbumListActivity.h.get((Object) Integer.valueOf(i));
            jigsawAlbumListActivity.h.get((Object) Integer.valueOf(i)).setImageBitmap(bitmap);
        } else {
            imageView = new ImageView(jigsawAlbumListActivity);
            imageView.setImageBitmap(bitmap);
            jigsawAlbumListActivity.h.put(Integer.valueOf(i), imageView);
        }
        imageView.setTag("bitmap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(JigsawAlbumListActivity jigsawAlbumListActivity) {
        if (u.a().d().size() < 2) {
            x.a(R.string.jigsaw_2_least);
        } else if (r) {
            r = false;
            jigsawAlbumListActivity.setResult(2);
            jigsawAlbumListActivity.finish();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        j = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
