package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Random;
/* loaded from: classes11.dex */
public class c {
    public Bitmap bitmap;
    public int height;
    public int money;
    public float opB;
    public boolean opC;
    public float rotation;
    public float speed;
    public int width;
    public float x;
    public float y;

    public c(Context context, Bitmap bitmap, int i, float f, float f2, int i2) {
        double random = Math.random();
        this.width = (int) (((random < ((double) f2) || random > ((double) f)) ? f : random) * bitmap.getWidth());
        this.height = (this.width * bitmap.getHeight()) / bitmap.getWidth();
        i2 = i2 == 0 ? context.getResources().getDisplayMetrics().widthPixels : i2;
        this.bitmap = Bitmap.createScaledBitmap(bitmap, this.width, this.height, true);
        bitmap.recycle();
        int nextInt = new Random().nextInt(i2) - this.width;
        this.x = nextInt < 0 ? (nextInt + i2) - this.width : nextInt;
        this.y = -this.height;
        this.speed = i + (((float) Math.random()) * 1000.0f);
        this.rotation = (((float) Math.random()) * 180.0f) - 90.0f;
        this.opB = (((float) Math.random()) * 90.0f) - 45.0f;
        this.opC = ecI();
    }

    public boolean G(float f, float f2) {
        return this.x - 50.0f < f && (this.x + 50.0f) + ((float) this.width) > f && this.y - 50.0f < f2 && (this.y + 50.0f) + ((float) this.height) > f2;
    }

    public boolean ecI() {
        int nextInt = new Random().nextInt(10) + 1;
        if (nextInt % 2 == 0) {
            this.money = nextInt * 2;
            return true;
        }
        return false;
    }

    public void recycle() {
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
        }
    }
}
