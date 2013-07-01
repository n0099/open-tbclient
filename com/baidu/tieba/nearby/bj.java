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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1159a = null;
    Address b;
    com.baidu.tieba.model.av c;
    final /* synthetic */ NewNearbyActivity d;

    public bj(NewNearbyActivity newNearbyActivity, Address address, com.baidu.tieba.model.av avVar) {
        this.d = newNearbyActivity;
        this.b = null;
        this.c = null;
        this.b = address;
        this.c = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        Bitmap bitmap;
        Bitmap b;
        if (this.b == null) {
            return null;
        }
        try {
            int a2 = com.baidu.tieba.util.ab.a(this.d, 110.0f);
            int a3 = com.baidu.tieba.util.ab.a((Context) this.d);
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("http://api.map.baidu.com/staticimage?");
            stringBuffer.append("width=" + String.valueOf(a3));
            stringBuffer.append("&");
            stringBuffer.append("height=" + String.valueOf(a2 + 100));
            stringBuffer.append("&");
            stringBuffer.append("center=" + String.valueOf(this.b.getLongitude()) + "," + String.valueOf(this.b.getLatitude()));
            stringBuffer.append("&");
            stringBuffer.append("zoom=" + String.valueOf(this.c.b()));
            this.f1159a = new com.baidu.tieba.util.r(this.d, stringBuffer.toString());
            this.f1159a.c(false);
            byte[] i = this.f1159a.i();
            if (this.f1159a.c()) {
                bitmap = com.baidu.tieba.util.d.a(i);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 50, bitmap.getWidth(), bitmap.getHeight() - 100, (Matrix) null, false);
                new Canvas(createBitmap).drawBitmap(com.baidu.tieba.util.d.b(this.d, (int) R.drawable.nearby_my_pos), (createBitmap.getWidth() - b.getWidth()) >> 1, (createBitmap.getHeight() >> 1) - b.getHeight(), (Paint) null);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } else {
                bitmap = null;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.toString());
            bitmap = null;
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.f1159a != null) {
            this.f1159a.h();
        }
        cancel(true);
        this.d.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        AbsoluteLayout absoluteLayout;
        AbsoluteLayout absoluteLayout2;
        AbsoluteLayout absoluteLayout3;
        int i;
        int i2;
        AbsoluteLayout absoluteLayout4;
        com.baidu.tieba.util.a aVar;
        com.baidu.tbadk.a.d dVar;
        super.a((Object) bitmap);
        if (bitmap != null) {
            absoluteLayout = this.d.e;
            absoluteLayout.setBackgroundDrawable(new BitmapDrawable(bitmap));
            absoluteLayout2 = this.d.e;
            int width = absoluteLayout2.getWidth() >> 1;
            absoluteLayout3 = this.d.e;
            int height = absoluteLayout3.getHeight() >> 1;
            LayoutInflater from = LayoutInflater.from(this.d);
            Location location = new Location("");
            Location location2 = new Location("");
            float pow = (float) Math.pow(2.0d, 18 - this.c.b());
            location.setLatitude(this.b.getLatitude());
            location.setLongitude(this.b.getLongitude());
            Iterator it = this.c.a().iterator();
            while (it.hasNext()) {
                com.baidu.tieba.model.aw awVar = (com.baidu.tieba.model.aw) it.next();
                if (awVar.n() != null && awVar.o() != null) {
                    try {
                        double doubleValue = Double.valueOf(awVar.n()).doubleValue();
                        double doubleValue2 = Double.valueOf(awVar.o()).doubleValue();
                        View inflate = from.inflate(R.layout.nearby_map_head, (ViewGroup) null);
                        ((RelativeLayout) inflate.findViewById(R.id.nearby_head_background)).setBackgroundResource(R.drawable.nearby_head_bg);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
                        imageView.setTag(awVar.l().getPortrait());
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
                        i = this.d.g;
                        int i3 = (distanceTo + width) - i;
                        i2 = this.d.g;
                        inflate.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i3, (distanceTo2 + height) - (i2 * 2)));
                        absoluteLayout4 = this.d.e;
                        absoluteLayout4.addView(inflate);
                        aVar = this.d.K;
                        String portrait = awVar.l().getPortrait();
                        dVar = this.d.L;
                        com.baidu.adp.widget.a.b d = aVar.d(portrait, dVar);
                        if (d != null) {
                            d.b(imageView);
                        }
                    } catch (Exception e) {
                        com.baidu.tieba.util.z.b(getClass().getName(), "onPostExecute", e.toString());
                    }
                }
            }
        }
    }
}
