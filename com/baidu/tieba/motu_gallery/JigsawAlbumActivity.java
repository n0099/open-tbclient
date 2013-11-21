package com.baidu.tieba.motu_gallery;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class JigsawAlbumActivity extends com.baidu.tieba.j {
    private static boolean n = false;
    private static boolean o = true;

    /* renamed from: a  reason: collision with root package name */
    TextView f2002a;
    private Cursor d;
    private j i;
    private ListView j;
    private u k;
    private l l;
    private LinearLayout v;
    private ArrayList<c> e = new ArrayList<>();
    private ArrayList<c> f = new ArrayList<>();
    private Map<String, Integer> g = new HashMap();
    private Map<String, Bitmap> h = new LinkedHashMap();
    private NavigationBar m = null;
    private final int p = 0;
    private final int q = 1;
    private final int r = 2;
    private byte[] s = new byte[1];
    private boolean t = false;
    private Handler u = new Handler(new d(this));
    private Runnable w = new i(this);
    int b = 0;
    int c = 0;

    public boolean a() {
        return n;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (a()) {
            n = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.motu_albums_activity);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            x.a(R.string.oom_retry);
        }
        this.f2002a = (TextView) findViewById(R.id.jigsaw_selected_text);
        this.k = u.a();
        this.k.b(this);
        this.j = (ListView) findViewById(R.id.albums_list);
        this.m = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.m.a(getString(R.string.jigsaw_photo_storage));
        this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        ((Button) this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_textbtn, new f(this))).setText(R.string.jigsaw_start);
        this.i = new j(this, this);
        this.u.sendMessage(this.u.obtainMessage(1));
        this.j.setAdapter((ListAdapter) this.i);
        this.j.setOnItemClickListener(new g(this));
        this.v = (LinearLayout) findViewById(R.id.selected_ll);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        o = true;
        this.t = false;
        this.f2002a.setText(this.k.e(this));
        if (this.k.e()) {
            this.u.sendMessage(this.u.obtainMessage(1));
        }
        b();
        super.onResume();
    }

    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.m.c(i);
    }

    private void b() {
        this.v.removeAllViews();
        for (Uri uri : this.k.c(this)) {
            w wVar = new w(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.jigsawSelectedWidth), (int) getResources().getDimension(R.dimen.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.a(uri)) {
                this.v.addView(wVar);
                wVar.setOnClickListener(new h(this, wVar));
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.h.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c A[Catch: all -> 0x01b5, TryCatch #5 {, blocks: (B:14:0x0068, B:16:0x006c, B:17:0x0071, B:18:0x0074, B:58:0x01bc, B:60:0x01c0, B:61:0x01c5, B:4:0x0004, B:6:0x003c, B:8:0x0044, B:10:0x004a, B:12:0x0060, B:20:0x0076, B:22:0x0098, B:25:0x00ab, B:27:0x00b3, B:29:0x00bb, B:30:0x00f8, B:36:0x014b, B:32:0x011f, B:33:0x0125, B:39:0x0153, B:41:0x015b, B:43:0x016b, B:44:0x0195, B:45:0x019b, B:57:0x01b9), top: B:69:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        int i;
        synchronized (this.s) {
            try {
                this.e.clear();
                this.f.clear();
                this.d = null;
                this.d = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
            } catch (Exception e) {
                e.printStackTrace();
                if (this.d != null) {
                    this.d.close();
                }
                this.d = null;
            }
            if (this.d != null && this.d.getCount() > 0) {
                this.d.moveToFirst();
                int i2 = 0;
                do {
                    try {
                        String string = this.d.getString(this.d.getColumnIndexOrThrow("_data"));
                        if (!string.equals("")) {
                            int i3 = this.d.getInt(this.d.getColumnIndexOrThrow("_id"));
                            if (b(this.d.getString(this.d.getColumnIndexOrThrow("_display_name"))) >= 0) {
                                String substring = string.substring(0, string.lastIndexOf("/"));
                                if (!a(substring)) {
                                    if (substring != null && substring.endsWith("tieba") && !this.f.isEmpty()) {
                                        c remove = this.f.remove(0);
                                        this.f.add(0, new c(0, substring, 0));
                                        int intValue = this.g.get(String.valueOf(0)).intValue();
                                        this.g.put(String.valueOf(0), new Integer(1));
                                        i = this.f.size();
                                        try {
                                            remove.f2005a = i;
                                            this.f.add(remove);
                                            this.g.put(String.valueOf(i), new Integer(intValue));
                                            a(0, i);
                                            this.e.add(new c(0, string, i3));
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            i2 = i;
                                            if (!this.d.moveToNext()) {
                                                if (this.d != null) {
                                                }
                                                this.d = null;
                                            }
                                        }
                                    } else {
                                        i = this.f.size();
                                        this.f.add(new c(i, substring, 0));
                                        this.g.put(String.valueOf(i), new Integer(1));
                                        this.e.add(new c(i, string, i3));
                                    }
                                } else {
                                    i = i2;
                                    int i4 = 0;
                                    while (i4 < this.f.size()) {
                                        if (this.f.get(i4).b.equals(substring)) {
                                            i = this.f.get(i4).f2005a;
                                            this.g.put(String.valueOf(i), new Integer(this.g.get(String.valueOf(i)).intValue() + 1));
                                        }
                                        i4++;
                                        i = i;
                                    }
                                    this.e.add(new c(i, string, i3));
                                }
                                i2 = i;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = i2;
                    }
                } while (!this.d.moveToNext());
                if (this.d != null) {
                }
                this.d = null;
            } else {
                if (this.d != null) {
                    this.d.close();
                }
                this.d = null;
            }
        }
    }

    private void a(int i, int i2) {
        if (this.e != null) {
            Iterator<c> it = this.e.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.f2005a == i) {
                    next.f2005a = i2;
                } else if (next.f2005a == i2) {
                    next.f2005a = i;
                }
            }
        }
    }

    private boolean a(String str) {
        for (int i = 0; i < this.f.size(); i++) {
            if (this.f.get(i).b.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int b(String str) {
        String substring = str.substring(str.lastIndexOf(".") + 1);
        if (substring.equalsIgnoreCase("jpg") || substring.equalsIgnoreCase("jpeg") || substring.equalsIgnoreCase("jpe")) {
            return 0;
        }
        if (substring.equalsIgnoreCase("png")) {
            return 1;
        }
        if (substring.equalsIgnoreCase("bmp")) {
            return 2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        Iterator<c> it = this.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f2005a == i) {
                return next.b;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c b(int i) {
        Iterator<c> it = this.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f2005a == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (o) {
            o = false;
            setResult(-1, u.a().f());
            finish();
        }
    }

    public int a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (10 == i && 2 == i2) {
            d();
        }
    }
}
