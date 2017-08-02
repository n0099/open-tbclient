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
    private int[] eSL;
    private SoftReference<ImageView> eSN;
    private int eSO;
    private a eSP;
    private int eSQ;
    private BitmapFactory.Options eSS;
    private Bitmap mBitmap;
    private int eSR = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean eSM = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void aUr();
    }

    public static b b(ImageView imageView, int i, int i2, int i3) {
        return new b(imageView, i, i2, i3);
    }

    public b(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.eSL = pw(i);
        this.eSN = new SoftReference<>(imageView);
        this.eSO = 1000 / i2;
        this.eSQ = i3;
        imageView.setImageResource(this.eSL[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.eSS = new BitmapFactory.Options();
            this.eSS.inBitmap = this.mBitmap;
            this.eSS.inMutable = true;
            this.eSS.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aUq() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.eSL.length) {
            this.eSR++;
        }
        if (this.mIndex >= this.eSL.length) {
            this.mIndex = 0;
        }
        return this.eSL[this.mIndex];
    }

    public synchronized void start() {
        this.eSM = true;
        if (!this.mIsRunning) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView = (ImageView) b.this.eSN.get();
                    if (!b.this.eSM || imageView == null || b.this.eSR > b.this.eSQ) {
                        b.this.mIsRunning = false;
                        if (b.this.eSP != null) {
                            b.this.eSP.aUr();
                        }
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    b.this.mIsRunning = true;
                    b.this.mHandler.postDelayed(this, b.this.eSO);
                    if (imageView.isShown()) {
                        int aUq = b.this.aUq();
                        if (b.this.mBitmap != null && !b.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView.getResources(), aUq, b.this.eSS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                                return;
                            }
                            imageView.setImageResource(aUq);
                            b.this.mBitmap.recycle();
                            b.this.mBitmap = null;
                            return;
                        }
                        imageView.setImageResource(aUq);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.eSM = false;
        this.eSN.clear();
    }

    public void a(a aVar) {
        this.eSP = aVar;
    }

    private int[] pw(int i) {
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
