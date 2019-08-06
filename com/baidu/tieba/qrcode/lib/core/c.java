package com.baidu.tieba.qrcode.lib.core;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes5.dex */
public class c extends AsyncTask<Void, Void, String> {
    private a iEl;
    private Camera mCamera;
    private byte[] mData;
    private int orientation;

    /* loaded from: classes5.dex */
    public interface a {
        String b(byte[] bArr, int i, int i2, boolean z);
    }

    public c(Camera camera, byte[] bArr, a aVar, int i) {
        this.mCamera = camera;
        this.mData = bArr;
        this.iEl = aVar;
        this.orientation = i;
    }

    public c chj() {
        if (Build.VERSION.SDK_INT >= 11) {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            execute(new Void[0]);
        }
        return this;
    }

    public void hc() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.iEl = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Camera.Parameters parameters;
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
            int i = previewSize.width;
            int i2 = previewSize.height;
            byte[] bArr = this.mData;
            if (this.orientation == 0) {
                bArr = new byte[this.mData.length];
                for (int i3 = 0; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i; i4++) {
                        bArr[(((i4 * i2) + i2) - i3) - 1] = this.mData[(i3 * i) + i4];
                    }
                }
            } else {
                i2 = i;
                i = i2;
            }
            try {
                if (this.iEl != null) {
                    return this.iEl.b(bArr, i2, i, false);
                }
                return null;
            } catch (Exception e2) {
                try {
                    return this.iEl.b(bArr, i2, i, true);
                } catch (Exception e3) {
                    return null;
                }
            }
        }
        return null;
    }
}
