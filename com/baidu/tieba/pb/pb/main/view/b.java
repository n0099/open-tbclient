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
    private int[] eTY;
    private SoftReference<ImageView> eUa;
    private int eUb;
    private a eUc;
    private int eUd;
    private BitmapFactory.Options eUf;
    private Bitmap mBitmap;
    private int eUe = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean eTZ = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aUC();
    }

    public static b b(ImageView imageView, int i, int i2, int i3) {
        return new b(imageView, i, i2, i3);
    }

    public b(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.eTY = pv(i);
        this.eUa = new SoftReference<>(imageView);
        this.eUb = 1000 / i2;
        this.eUd = i3;
        imageView.setImageResource(this.eTY[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.eUf = new BitmapFactory.Options();
            this.eUf.inBitmap = this.mBitmap;
            this.eUf.inMutable = true;
            this.eUf.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aUB() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.eTY.length) {
            this.eUe++;
        }
        if (this.mIndex >= this.eTY.length) {
            this.mIndex = 0;
        }
        return this.eTY[this.mIndex];
    }

    public synchronized void start() {
        this.eTZ = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView = (ImageView) b.this.eUa.get();
                    if (!b.this.eTZ || imageView == null || b.this.eUe > b.this.eUd) {
                        b.this.mIsRunning = false;
                        if (b.this.eUc != null) {
                            b.this.eUc.aUC();
                        }
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    b.this.mIsRunning = true;
                    b.this.mHandler.postDelayed(this, b.this.eUb);
                    if (imageView.isShown()) {
                        int aUB = b.this.aUB();
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView.getResources(), aUB, b.this.eUf);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                                return;
                            }
                            imageView.setImageResource(aUB);
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        imageView.setImageResource(aUB);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.eTZ = false;
        this.eUa.clear();
    }

    public void a(a aVar) {
        this.eUc = aVar;
    }

    private int[] pv(int i) {
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
