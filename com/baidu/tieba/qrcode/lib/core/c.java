package com.baidu.tieba.qrcode.lib.core;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes8.dex */
public class c extends AsyncTask<Void, Void, String> {
    private Camera mCamera;
    private byte[] mData;
    private a mOu;
    private int orientation;

    /* loaded from: classes8.dex */
    public interface a {
        String c(byte[] bArr, int i, int i2, boolean z);
    }

    public c(Camera camera, byte[] bArr, a aVar, int i) {
        this.mCamera = camera;
        this.mData = bArr;
        this.mOu = aVar;
        this.orientation = i;
    }

    public c dCu() {
        if (Build.VERSION.SDK_INT >= 11) {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            execute(new Void[0]);
        }
        return this;
    }

    public void cancelTask() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.mOu = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Camera.Parameters parameters;
        int i;
        int i2;
        if (this.mCamera == null) {
            return null;
        }
        try {
            parameters = this.mCamera.getParameters();
        } catch (RuntimeException e) {
            BdLog.e(e);
            parameters = null;
        }
        if (parameters != null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            int i3 = previewSize.width;
            int i4 = previewSize.height;
            byte[] bArr = this.mData;
            if (this.orientation == 0) {
                bArr = new byte[this.mData.length];
                for (int i5 = 0; i5 < i4; i5++) {
                    for (int i6 = 0; i6 < i3; i6++) {
                        bArr[(((i6 * i4) + i4) - i5) - 1] = this.mData[(i5 * i3) + i6];
                    }
                }
                i = i3;
                i2 = i4;
            } else {
                i = i4;
                i2 = i3;
            }
            try {
                if (this.mOu != null) {
                    return this.mOu.c(bArr, i2, i, false);
                }
                return null;
            } catch (Exception e2) {
                try {
                    return this.mOu.c(bArr, i2, i, true);
                } catch (Exception e3) {
                    return null;
                }
            }
        }
        return null;
    }
}
