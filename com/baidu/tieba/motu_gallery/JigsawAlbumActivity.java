package com.baidu.tieba.motu_gallery;

import android.app.Activity;
import android.content.Context;
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
public class JigsawAlbumActivity extends com.baidu.tieba.f {
    private static boolean n = false;
    private static boolean o = true;
    TextView a;
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
    private Runnable w = new e(this);
    int b = 0;
    int c = 0;

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, JigsawAlbumActivity.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (n) {
            n = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.motu_albums_activity);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            x.a(R.string.oom_retry);
        }
        this.a = (TextView) findViewById(R.id.jigsaw_selected_text);
        this.k = u.a();
        this.k.b(this);
        this.j = (ListView) findViewById(R.id.albums_list);
        this.m = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.m.a(getString(R.string.jigsaw_photo_storage));
        this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        ((Button) this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_textbtn, new g(this))).setText(R.string.jigsaw_start);
        this.i = new j(this, this);
        this.u.sendMessage(this.u.obtainMessage(1));
        this.j.setAdapter((ListAdapter) this.i);
        this.j.setOnItemClickListener(new h(this));
        this.v = (LinearLayout) findViewById(R.id.selected_ll);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        o = true;
        this.t = false;
        this.a.setText(this.k.c(this));
        if (this.k.f()) {
            this.u.sendMessage(this.u.obtainMessage(1));
        }
        this.v.removeAllViews();
        for (Uri uri : this.k.d()) {
            w wVar = new w(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.jigsawSelectedWidth), (int) getResources().getDimension(R.dimen.jigsawSelectedHeight));
            layoutParams.setMargins(0, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            if (wVar.a(uri)) {
                this.v.addView(wVar);
                wVar.setOnClickListener(new i(this, wVar));
            }
        }
        super.onResume();
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.m.b(i);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.h.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x006b A[EDGE_INSN: B:106:0x006b->B:15:0x006b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0246 A[LOOP:0: B:101:0x004c->B:98:0x0246, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void e(JigsawAlbumActivity jigsawAlbumActivity) {
        int i;
        boolean z;
        synchronized (jigsawAlbumActivity.s) {
            try {
                jigsawAlbumActivity.e.clear();
                jigsawAlbumActivity.f.clear();
                jigsawAlbumActivity.d = null;
                jigsawAlbumActivity.d = jigsawAlbumActivity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "title", "_display_name"}, null, null, "datetaken desc");
                if (jigsawAlbumActivity.d != null && jigsawAlbumActivity.d.getCount() > 0) {
                    jigsawAlbumActivity.d.moveToFirst();
                    int i2 = 0;
                    while (true) {
                        try {
                            String string = jigsawAlbumActivity.d.getString(jigsawAlbumActivity.d.getColumnIndexOrThrow("_data"));
                            if (string.equals("")) {
                                i = i2;
                            } else {
                                int i3 = jigsawAlbumActivity.d.getInt(jigsawAlbumActivity.d.getColumnIndexOrThrow("_id"));
                                String string2 = jigsawAlbumActivity.d.getString(jigsawAlbumActivity.d.getColumnIndexOrThrow("_display_name"));
                                String substring = string2.substring(string2.lastIndexOf(".") + 1);
                                if (((substring.equalsIgnoreCase("jpg") || substring.equalsIgnoreCase("jpeg") || substring.equalsIgnoreCase("jpe")) ? (char) 0 : substring.equalsIgnoreCase("png") ? (char) 1 : substring.equalsIgnoreCase("bmp") ? (char) 2 : (char) 65535) < 0) {
                                    i = i2;
                                } else {
                                    String substring2 = string.substring(0, string.lastIndexOf("/"));
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= jigsawAlbumActivity.f.size()) {
                                            z = false;
                                            break;
                                        } else if (jigsawAlbumActivity.f.get(i4).b.equals(substring2)) {
                                            z = true;
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    if (z) {
                                        i = i2;
                                        int i5 = 0;
                                        while (i5 < jigsawAlbumActivity.f.size()) {
                                            if (jigsawAlbumActivity.f.get(i5).b.equals(substring2)) {
                                                i = jigsawAlbumActivity.f.get(i5).a;
                                                jigsawAlbumActivity.g.put(String.valueOf(i), Integer.valueOf(jigsawAlbumActivity.g.get(String.valueOf(i)).intValue() + 1));
                                            }
                                            i5++;
                                            i = i;
                                        }
                                        jigsawAlbumActivity.e.add(new c(i, string, i3));
                                    } else if (substring2 == null || !substring2.endsWith(com.baidu.tieba.data.i.k()) || jigsawAlbumActivity.f.isEmpty()) {
                                        i = jigsawAlbumActivity.f.size();
                                        jigsawAlbumActivity.f.add(new c(i, substring2, 0));
                                        jigsawAlbumActivity.g.put(String.valueOf(i), 1);
                                        jigsawAlbumActivity.e.add(new c(i, string, i3));
                                    } else {
                                        c remove = jigsawAlbumActivity.f.remove(0);
                                        jigsawAlbumActivity.f.add(0, new c(0, substring2, 0));
                                        int intValue = jigsawAlbumActivity.g.get(String.valueOf(0)).intValue();
                                        jigsawAlbumActivity.g.put(String.valueOf(0), 1);
                                        i = jigsawAlbumActivity.f.size();
                                        try {
                                            remove.a = i;
                                            jigsawAlbumActivity.f.add(remove);
                                            jigsawAlbumActivity.g.put(String.valueOf(i), Integer.valueOf(intValue));
                                            if (jigsawAlbumActivity.e != null) {
                                                Iterator<c> it = jigsawAlbumActivity.e.iterator();
                                                while (it.hasNext()) {
                                                    c next = it.next();
                                                    if (next.a == 0) {
                                                        next.a = i;
                                                    } else if (next.a == i) {
                                                        next.a = 0;
                                                    }
                                                }
                                            }
                                            jigsawAlbumActivity.e.add(new c(0, string, i3));
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                            if (jigsawAlbumActivity.d.moveToNext()) {
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                        }
                        if (jigsawAlbumActivity.d.moveToNext()) {
                            break;
                        }
                        i2 = i;
                    }
                }
                if (jigsawAlbumActivity.d != null) {
                    jigsawAlbumActivity.d.close();
                }
                jigsawAlbumActivity.d = null;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (jigsawAlbumActivity.d != null) {
                    jigsawAlbumActivity.d.close();
                }
                jigsawAlbumActivity.d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String b(JigsawAlbumActivity jigsawAlbumActivity, int i) {
        Iterator<c> it = jigsawAlbumActivity.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a == i) {
                return next.b;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c a(JigsawAlbumActivity jigsawAlbumActivity, int i) {
        Iterator<c> it = jigsawAlbumActivity.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (o) {
            o = false;
            setResult(-1, u.a().g());
            finish();
        }
    }

    public final int a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (10 == i && 2 == i2) {
            a();
        }
    }
}
