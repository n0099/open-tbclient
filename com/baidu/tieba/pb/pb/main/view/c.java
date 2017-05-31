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
    private int[] ewN;
    private SoftReference<ImageView> ewP;
    private int ewQ;
    private a ewR;
    private int ewS;
    private BitmapFactory.Options ewU;
    private Bitmap mBitmap;
    private int ewT = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean ewO = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aNu();
    }

    public static c b(ImageView imageView, int i, int i2, int i3) {
        return new c(imageView, i, i2, i3);
    }

    public c(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.ewN = oO(i);
        this.ewP = new SoftReference<>(imageView);
        this.ewQ = 1000 / i2;
        this.ewS = i3;
        imageView.setImageResource(this.ewN[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.ewU = new BitmapFactory.Options();
            this.ewU.inBitmap = this.mBitmap;
            this.ewU.inMutable = true;
            this.ewU.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aNt() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.ewN.length) {
            this.ewT++;
        }
        if (this.mIndex >= this.ewN.length) {
            this.mIndex = 0;
        }
        return this.ewN[this.mIndex];
    }

    public synchronized void start() {
        this.ewO = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new d(this));
        }
    }

    public synchronized void stop() {
        this.ewO = false;
        this.ewP.clear();
    }

    public void a(a aVar) {
        this.ewR = aVar;
    }

    private int[] oO(int i) {
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
