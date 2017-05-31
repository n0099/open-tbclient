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
    final /* synthetic */ c ewV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ewV = cVar;
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
        int aNt;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        BitmapFactory.Options options;
        softReference = this.ewV.ewP;
        ImageView imageView = (ImageView) softReference.get();
        z = this.ewV.ewO;
        if (z && imageView != null) {
            i = this.ewV.ewT;
            i2 = this.ewV.ewS;
            if (i <= i2) {
                this.ewV.mIsRunning = true;
                handler = this.ewV.mHandler;
                i3 = this.ewV.ewQ;
                handler.postDelayed(this, i3);
                if (imageView.isShown()) {
                    aNt = this.ewV.aNt();
                    bitmap4 = this.ewV.mBitmap;
                    if (bitmap4 != null) {
                        bitmap5 = this.ewV.mBitmap;
                        if (!bitmap5.isRecycled()) {
                            try {
                                Resources resources = imageView.getResources();
                                options = this.ewV.ewU;
                                bitmap6 = BitmapFactory.decodeResource(resources, aNt, options);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap6 = null;
                            }
                            if (bitmap6 != null) {
                                imageView.setImageBitmap(bitmap6);
                                return;
                            }
                            imageView.setImageResource(aNt);
                            bitmap7 = this.ewV.mBitmap;
                            bitmap7.recycle();
                            this.ewV.mBitmap = null;
                            return;
                        }
                    }
                    imageView.setImageResource(aNt);
                    return;
                }
                return;
            }
        }
        this.ewV.mIsRunning = false;
        aVar = this.ewV.ewR;
        if (aVar != null) {
            aVar2 = this.ewV.ewR;
            aVar2.aNu();
        }
        bitmap = this.ewV.mBitmap;
        if (bitmap != null) {
            bitmap2 = this.ewV.mBitmap;
            if (!bitmap2.isRecycled()) {
                bitmap3 = this.ewV.mBitmap;
                bitmap3.recycle();
                this.ewV.mBitmap = null;
            }
        }
    }
}
