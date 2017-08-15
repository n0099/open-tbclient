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
    private int[] eVR;
    private SoftReference<ImageView> eVT;
    private int eVU;
    private a eVV;
    private int eVW;
    private BitmapFactory.Options eVY;
    private Bitmap mBitmap;
    private int eVX = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean eVS = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aVj();
    }

    public static b b(ImageView imageView, int i, int i2, int i3) {
        return new b(imageView, i, i2, i3);
    }

    public b(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.eVR = pF(i);
        this.eVT = new SoftReference<>(imageView);
        this.eVU = 1000 / i2;
        this.eVW = i3;
        imageView.setImageResource(this.eVR[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.eVY = new BitmapFactory.Options();
            this.eVY.inBitmap = this.mBitmap;
            this.eVY.inMutable = true;
            this.eVY.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aVi() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.eVR.length) {
            this.eVX++;
        }
        if (this.mIndex >= this.eVR.length) {
            this.mIndex = 0;
        }
        return this.eVR[this.mIndex];
    }

    public synchronized void start() {
        this.eVS = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView = (ImageView) b.this.eVT.get();
                    if (!b.this.eVS || imageView == null || b.this.eVX > b.this.eVW) {
                        b.this.mIsRunning = false;
                        if (b.this.eVV != null) {
                            b.this.eVV.aVj();
                        }
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    b.this.mIsRunning = true;
                    b.this.mHandler.postDelayed(this, b.this.eVU);
                    if (imageView.isShown()) {
                        int aVi = b.this.aVi();
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView.getResources(), aVi, b.this.eVY);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                                return;
                            }
                            imageView.setImageResource(aVi);
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        imageView.setImageResource(aVi);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.eVS = false;
        this.eVT.clear();
    }

    public void a(a aVar) {
        this.eVV = aVar;
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
