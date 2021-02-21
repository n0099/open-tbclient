package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes8.dex */
public class PersonGaussianBlurView extends PersonExpandImageView {
    a mFG;

    public PersonGaussianBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSrc(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.mFG != null) {
                this.mFG.cancel();
            }
            this.mFG = new a();
            this.mFG.execute(bitmap);
        }
    }

    /* loaded from: classes8.dex */
    class a extends BdAsyncTask<Bitmap, String, Bitmap> {
        private final float mFH = 0.5f;
        private final int mFI = 15;

        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            if (bitmapArr != null) {
                try {
                    if (bitmapArr.length == 0) {
                        return null;
                    }
                    Bitmap bitmap = bitmapArr[0];
                    if (I(bitmap)) {
                        if (bitmap.getWidth() >= 600 || bitmap.getHeight() >= 600) {
                            int round = Math.round(bitmap.getWidth() * 0.5f);
                            int round2 = Math.round(bitmap.getHeight() * 0.5f);
                            if (round <= 0 || round2 <= 0) {
                                return null;
                            }
                            bitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
                            if (!I(bitmap)) {
                                return null;
                            }
                        }
                        return com.baidu.tbadk.util.i.b(Bitmap.createBitmap(bitmap, 0, (int) (bitmap.getHeight() * 0.2f), bitmap.getWidth(), (int) (bitmap.getHeight() * 0.6f)), 15, false);
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (I(bitmap)) {
                PersonGaussianBlurView.this.setImageBitmap(bitmap);
            }
        }

        private boolean I(Bitmap bitmap) {
            return (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) ? false : true;
        }
    }
}
