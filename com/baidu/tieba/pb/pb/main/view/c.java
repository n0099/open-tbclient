package com.baidu.tieba.pb.pb.main.view;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class c {
    private int[] eGj;
    private SoftReference<ImageView> eGl;
    private int eGm;
    private a eGn;
    private int eGo;
    private BitmapFactory.Options eGq;
    private Bitmap mBitmap;
    private int eGp = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean eGk = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aRu();
    }

    public static c b(ImageView imageView, int i, int i2, int i3) {
        return new c(imageView, i, i2, i3);
    }

    public c(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.eGj = pg(i);
        this.eGl = new SoftReference<>(imageView);
        this.eGm = 1000 / i2;
        this.eGo = i3;
        imageView.setImageResource(this.eGj[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.eGq = new BitmapFactory.Options();
            this.eGq.inBitmap = this.mBitmap;
            this.eGq.inMutable = true;
            this.eGq.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRt() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.eGj.length) {
            this.eGp++;
        }
        if (this.mIndex >= this.eGj.length) {
            this.mIndex = 0;
        }
        return this.eGj[this.mIndex];
    }

    public synchronized void start() {
        this.eGk = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new d(this));
        }
    }

    public synchronized void stop() {
        this.eGk = false;
        this.eGl.clear();
    }

    public void a(a aVar) {
        this.eGn = aVar;
    }

    private int[] pg(int i) {
        TypedArray obtainTypedArray = TbadkCoreApplication.m9getInst().getResources().obtainTypedArray(i);
        int length = obtainTypedArray.length();
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }
}
