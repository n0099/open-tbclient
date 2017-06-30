package com.baidu.tieba.pb.pb.main.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.tieba.pb.pb.main.view.c;
import java.lang.ref.SoftReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c eGr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eGr = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SoftReference softReference;
        boolean z;
        c.a aVar;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        c.a aVar2;
        int i;
        int i2;
        Handler handler;
        int i3;
        int aRt;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        BitmapFactory.Options options;
        softReference = this.eGr.eGl;
        ImageView imageView = (ImageView) softReference.get();
        z = this.eGr.eGk;
        if (z && imageView != null) {
            i = this.eGr.eGp;
            i2 = this.eGr.eGo;
            if (i <= i2) {
                this.eGr.mIsRunning = true;
                handler = this.eGr.mHandler;
                i3 = this.eGr.eGm;
                handler.postDelayed(this, i3);
                if (imageView.isShown()) {
                    aRt = this.eGr.aRt();
                    bitmap4 = this.eGr.mBitmap;
                    if (bitmap4 != null) {
                        bitmap5 = this.eGr.mBitmap;
                        if (!bitmap5.isRecycled()) {
                            try {
                                Resources resources = imageView.getResources();
                                options = this.eGr.eGq;
                                bitmap6 = BitmapFactory.decodeResource(resources, aRt, options);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap6 = null;
                            }
                            if (bitmap6 != null) {
                                imageView.setImageBitmap(bitmap6);
                                return;
                            }
                            imageView.setImageResource(aRt);
                            bitmap7 = this.eGr.mBitmap;
                            bitmap7.recycle();
                            this.eGr.mBitmap = null;
                            return;
                        }
                    }
                    imageView.setImageResource(aRt);
                    return;
                }
                return;
            }
        }
        this.eGr.mIsRunning = false;
        aVar = this.eGr.eGn;
        if (aVar != null) {
            aVar2 = this.eGr.eGn;
            aVar2.aRu();
        }
        bitmap = this.eGr.mBitmap;
        if (bitmap != null) {
            bitmap2 = this.eGr.mBitmap;
            if (!bitmap2.isRecycled()) {
                bitmap3 = this.eGr.mBitmap;
                bitmap3.recycle();
                this.eGr.mBitmap = null;
            }
        }
    }
}
