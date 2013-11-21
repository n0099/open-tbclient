package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.slidingmenu.lib.R;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static u f2023a = null;
    private List<c> b = new ArrayList();
    private List<Uri> c;
    private String d;
    private boolean e;

    public static u a() {
        if (f2023a == null) {
            f2023a = new u();
        }
        return f2023a;
    }

    private u() {
        a(new ArrayList());
        this.e = false;
    }

    public int b() {
        return this.b.size();
    }

    public int a(Uri uri) {
        if (uri == null || this.b == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return -1;
            }
            if (!this.b.get(i2).d.equals(uri)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(c cVar) {
        this.b.add(cVar);
    }

    public void c() {
        this.b.clear();
    }

    public c a(int i) {
        return this.b.get(i);
    }

    public int a(Context context) {
        return c(context).size();
    }

    public boolean a(Context context, Uri uri) {
        boolean z;
        if (a(context) >= 10) {
            return false;
        }
        try {
            int dimension = (int) context.getResources().getDimension(R.dimen.jigsawSelectedImageWidth);
            if (b.b(context, uri, dimension, dimension) == null) {
                x.a(R.string.open_error);
                return false;
            }
            Iterator<Uri> it = c(context).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().equals(uri)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return false;
            }
            c(context).add(uri);
            return true;
        } catch (OtherException e) {
            e.printStackTrace();
            x.a(R.string.open_error);
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            x.a(R.string.open_error);
            return false;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            x.a(R.string.open_error);
            return false;
        }
    }

    public void b(Context context, Uri uri) {
        c(context).remove(uri);
        f(context);
    }

    public void b(Context context) {
        c(context).clear();
        f(context);
    }

    private void a(List<Uri> list) {
        this.c = list;
    }

    public List<Uri> c(Context context) {
        if (this.c.size() == 0) {
        }
        return this.c;
    }

    public int d(Context context) {
        return c(context).size();
    }

    public void a(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public String e(Context context) {
        return String.format(context.getResources().getString(R.string.jigsaw_selected_text), Integer.valueOf(d(context)), Integer.valueOf(10 - d(context)));
    }

    public Bitmap a(Context context, c cVar, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri parse = Uri.parse(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) + "/" + String.valueOf(cVar.c));
        try {
            Bitmap a2 = b.a(context, parse, i, i);
            if (a2 == null) {
                return null;
            }
            try {
                int a3 = v.a(context, parse, false);
                if (a3 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(a3);
                    return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
                }
                return a2;
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap2;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmap;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return null;
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean e() {
        boolean z = this.e;
        this.e = false;
        return z;
    }

    private void f(Context context) {
    }

    public boolean b(Uri uri) {
        for (Uri uri2 : this.c) {
            if (uri2.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    public Intent f() {
        Intent intent = new Intent();
        new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Uri uri : this.c) {
            arrayList.add(uri.toString());
        }
        intent.putStringArrayListExtra("selected_uris", arrayList);
        return intent;
    }
}
