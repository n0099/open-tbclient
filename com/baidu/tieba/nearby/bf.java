package com.baidu.tieba.nearby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a = null;
    Address b;
    com.baidu.tieba.c.as c;
    final /* synthetic */ NewNearbyActivity d;

    public bf(NewNearbyActivity newNearbyActivity, Address address, com.baidu.tieba.c.as asVar) {
        this.d = newNearbyActivity;
        this.b = null;
        this.c = null;
        this.b = address;
        this.c = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Bitmap a(String... strArr) {
        Bitmap bitmap;
        Bitmap b;
        if (this.b == null) {
            return null;
        }
        try {
            int a = com.baidu.tieba.d.ag.a(this.d, 110.0f);
            int a2 = com.baidu.tieba.d.ag.a((Context) this.d);
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("http://api.map.baidu.com/staticimage?");
            stringBuffer.append("width=" + String.valueOf(a2));
            stringBuffer.append("&");
            stringBuffer.append("height=" + String.valueOf(a + 100));
            stringBuffer.append("&");
            stringBuffer.append("center=" + String.valueOf(this.b.getLongitude()) + "," + String.valueOf(this.b.getLatitude()));
            stringBuffer.append("&");
            stringBuffer.append("zoom=" + String.valueOf(this.c.b()));
            this.a = new com.baidu.tieba.d.t(this.d, stringBuffer.toString());
            this.a.c(false);
            byte[] h = this.a.h();
            if (this.a.b()) {
                bitmap = com.baidu.tieba.d.e.a(h);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 50, bitmap.getWidth(), bitmap.getHeight() - 100, (Matrix) null, false);
                new Canvas(createBitmap).drawBitmap(com.baidu.tieba.d.e.b(this.d, (int) R.drawable.nearby_my_pos), (createBitmap.getWidth() - b.getWidth()) >> 1, (createBitmap.getHeight() >> 1) - b.getHeight(), (Paint) null);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } else {
                bitmap = null;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.toString());
            bitmap = null;
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.a != null) {
            this.a.g();
        }
        cancel(true);
        this.d.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        AbsoluteLayout absoluteLayout3;
        int i;
        int i2;
        AbsoluteLayout absoluteLayout4;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.d dVar;
        super.a((Object) bitmap);
        if (bitmap != null) {
            absoluteLayout = this.d.g;
            absoluteLayout.setBackgroundDrawable(new BitmapDrawable(bitmap));
            absoluteLayout2 = this.d.g;
            int width = absoluteLayout2.getWidth() >> 1;
            absoluteLayout3 = this.d.g;
            int height = absoluteLayout3.getHeight() >> 1;
            LayoutInflater from = LayoutInflater.from(this.d);
            Location location = new Location("");
            Location location2 = new Location("");
            float pow = (float) Math.pow(2.0d, 18 - this.c.b());
            location.setLatitude(this.b.getLatitude());
            location.setLongitude(this.b.getLongitude());
            Iterator it = this.c.a().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.c.at atVar = (com.baidu.tieba.c.at) it.next();
                if (atVar.n() != null && atVar.o() != null) {
                    try {
                        double doubleValue = Double.valueOf(atVar.n()).doubleValue();
                        double doubleValue2 = Double.valueOf(atVar.o()).doubleValue();
                        View inflate = from.inflate(R.layout.nearby_map_head, (ViewGroup) null);
                        ((RelativeLayout) inflate.findViewById(R.id.nearby_head_background)).setBackgroundResource(R.drawable.nearby_head_bg);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                        imageView.setTag(atVar.l().e());
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
                        i = this.d.i;
                        int i3 = (distanceTo + width) - i;
                        i2 = this.d.i;
                        inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i3, (distanceTo2 + height) - (i2 * 2)));
                        absoluteLayout4 = this.d.g;
                        absoluteLayout4.addView(inflate);
                        aVar = this.d.H;
                        String e = atVar.l().e();
                        dVar = this.d.I;
                        Bitmap d = aVar.d(e, dVar);
                        if (d != null) {
                            imageView.setImageBitmap(d);
                        }
                    } catch (Exception e2) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "onPostExecute", e2.toString());
                    }
                }
            }
        }
    }
}
