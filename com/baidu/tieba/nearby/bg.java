package com.baidu.tieba.nearby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Location;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends AsyncTask {
    com.baidu.tieba.c.t a = null;
    Address b;
    com.baidu.tieba.b.o c;
    final /* synthetic */ NewNearbyActivity d;

    public bg(NewNearbyActivity newNearbyActivity, Address address, com.baidu.tieba.b.o oVar) {
        this.d = newNearbyActivity;
        this.b = null;
        this.c = null;
        this.b = address;
        this.c = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        Bitmap bitmap;
        Bitmap a;
        if (this.b == null) {
            return null;
        }
        try {
            int a2 = com.baidu.tieba.c.ai.a(this.d, 110.0f);
            int a3 = com.baidu.tieba.c.ai.a((Context) this.d);
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("http://api.map.baidu.com/staticimage?");
            stringBuffer.append("width=" + String.valueOf(a3));
            stringBuffer.append("&");
            stringBuffer.append("height=" + String.valueOf(a2 + 100));
            stringBuffer.append("&");
            stringBuffer.append("center=" + String.valueOf(this.b.getLongitude()) + "," + String.valueOf(this.b.getLatitude()));
            stringBuffer.append("&");
            stringBuffer.append("zoom=" + String.valueOf(this.c.b()));
            this.a = new com.baidu.tieba.c.t(this.d, stringBuffer.toString());
            this.a.c(false);
            byte[] h = this.a.h();
            if (this.a.b()) {
                bitmap = com.baidu.tieba.c.e.a(h);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 50, bitmap.getWidth(), bitmap.getHeight() - 100, (Matrix) null, false);
                new Canvas(createBitmap).drawBitmap(com.baidu.tieba.c.e.a(this.d, (int) R.drawable.nearby_my_pos), (createBitmap.getWidth() - a.getWidth()) >> 1, (createBitmap.getHeight() >> 1) - a.getHeight(), (Paint) null);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } else {
                bitmap = null;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.toString());
            bitmap = null;
        }
        return bitmap;
    }

    public void a() {
        if (this.a != null) {
            this.a.g();
        }
        cancel(true);
        this.d.i = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        AbsoluteLayout absoluteLayout3;
        int i;
        int i2;
        AbsoluteLayout absoluteLayout4;
        com.baidu.tieba.c.a aVar;
        com.baidu.tieba.c.d dVar;
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            absoluteLayout = this.d.f;
            absoluteLayout.setBackgroundDrawable(new BitmapDrawable(bitmap));
            absoluteLayout2 = this.d.f;
            int width = absoluteLayout2.getWidth() >> 1;
            absoluteLayout3 = this.d.f;
            int height = absoluteLayout3.getHeight() >> 1;
            LayoutInflater from = LayoutInflater.from(this.d);
            Location location = new Location("");
            Location location2 = new Location("");
            float pow = (float) Math.pow(2.0d, 18 - this.c.b());
            location.setLatitude(this.b.getLatitude());
            location.setLongitude(this.b.getLongitude());
            Iterator it = this.c.a().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.b.p pVar = (com.baidu.tieba.b.p) it.next();
                if (pVar.n() != null && pVar.o() != null) {
                    try {
                        double doubleValue = Double.valueOf(pVar.n()).doubleValue();
                        double doubleValue2 = Double.valueOf(pVar.o()).doubleValue();
                        View inflate = from.inflate(R.layout.nearby_map_head, (ViewGroup) null);
                        ((RelativeLayout) inflate.findViewById(R.id.nearby_head_background)).setBackgroundResource(R.drawable.nearby_head_bg);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                        imageView.setTag(pVar.l().d());
                        location2.setLatitude(location.getLatitude());
                        location2.setLongitude(doubleValue);
                        location2.setLatitude(doubleValue2);
                        location2.setLongitude(location.getLongitude());
                        int distanceTo = (int) (((int) location2.distanceTo(location)) / pow);
                        int distanceTo2 = (int) (((int) location2.distanceTo(location)) / pow);
                        if (doubleValue < location.getLongitude()) {
                            distanceTo = -distanceTo;
                        }
                        if (doubleValue2 >= location.getLatitude()) {
                            distanceTo2 = -distanceTo2;
                        }
                        i = this.d.h;
                        int i3 = (distanceTo + width) - i;
                        i2 = this.d.h;
                        inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i3, (distanceTo2 + height) - (i2 * 2)));
                        absoluteLayout4 = this.d.f;
                        absoluteLayout4.addView(inflate);
                        aVar = this.d.G;
                        String d = pVar.l().d();
                        dVar = this.d.H;
                        Bitmap d2 = aVar.d(d, dVar);
                        if (d2 != null) {
                            imageView.setImageBitmap(d2);
                        }
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.toString());
                    }
                }
            }
        }
    }
}
