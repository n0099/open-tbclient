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
public class b {
    private int[] eVT;
    private SoftReference<ImageView> eVV;
    private int eVW;
    private a eVX;
    private int eVY;
    private BitmapFactory.Options eWa;
    private Bitmap mBitmap;
    private int eVZ = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean eVU = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aVe();
    }

    public static b b(ImageView imageView, int i, int i2, int i3) {
        return new b(imageView, i, i2, i3);
    }

    public b(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.eVT = pF(i);
        this.eVV = new SoftReference<>(imageView);
        this.eVW = 1000 / i2;
        this.eVY = i3;
        imageView.setImageResource(this.eVT[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.eWa = new BitmapFactory.Options();
            this.eWa.inBitmap = this.mBitmap;
            this.eWa.inMutable = true;
            this.eWa.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aVd() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.eVT.length) {
            this.eVZ++;
        }
        if (this.mIndex >= this.eVT.length) {
            this.mIndex = 0;
        }
        return this.eVT[this.mIndex];
    }

    public synchronized void start() {
        this.eVU = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView = (ImageView) b.this.eVV.get();
                    if (!b.this.eVU || imageView == null || b.this.eVZ > b.this.eVY) {
                        b.this.mIsRunning = false;
                        if (b.this.eVX != null) {
                            b.this.eVX.aVe();
                        }
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    b.this.mIsRunning = true;
                    b.this.mHandler.postDelayed(this, b.this.eVW);
                    if (imageView.isShown()) {
                        int aVd = b.this.aVd();
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView.getResources(), aVd, b.this.eWa);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                                return;
                            }
                            imageView.setImageResource(aVd);
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        imageView.setImageResource(aVd);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.eVU = false;
        this.eVV.clear();
    }

    public void a(a aVar) {
        this.eVX = aVar;
    }

    private int[] pF(int i) {
        TypedArray obtainTypedArray = TbadkCoreApplication.getInst().getResources().obtainTypedArray(i);
        int length = obtainTypedArray.length();
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }
}
