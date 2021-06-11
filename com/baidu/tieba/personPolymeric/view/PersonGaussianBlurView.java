package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.m0.z0.i;
/* loaded from: classes5.dex */
public class PersonGaussianBlurView extends PersonExpandImageView {

    /* renamed from: i  reason: collision with root package name */
    public a f19991i;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Bitmap, String, Bitmap> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            if (bitmapArr != null) {
                try {
                    if (bitmapArr.length == 0) {
                        return null;
                    }
                    Bitmap bitmap = bitmapArr[0];
                    if (c(bitmap)) {
                        if (bitmap.getWidth() >= 600 || bitmap.getHeight() >= 600) {
                            int round = Math.round(bitmap.getWidth() * 0.5f);
                            int round2 = Math.round(bitmap.getHeight() * 0.5f);
                            if (round > 0 && round2 > 0) {
                                bitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
                                if (!c(bitmap)) {
                                    return null;
                                }
                            }
                            return null;
                        }
                        return i.a(Bitmap.createBitmap(bitmap, 0, (int) (bitmap.getHeight() * 0.2f), bitmap.getWidth(), (int) (bitmap.getHeight() * 0.6f)), 15, false);
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public final boolean c(Bitmap bitmap) {
            return (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (c(bitmap)) {
                PersonGaussianBlurView.this.setImageBitmap(bitmap);
            }
        }
    }

    public PersonGaussianBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSrc(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        a aVar = this.f19991i;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a();
        this.f19991i = aVar2;
        aVar2.execute(bitmap);
    }
}
