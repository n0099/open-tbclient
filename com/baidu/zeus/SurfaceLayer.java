package com.baidu.zeus;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes.dex */
public class SurfaceLayer implements SurfaceTexture.OnFrameAvailableListener {
    private boolean mAllowListener;
    private int mNativePointer;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    private native void nativeOnFrameAvailable(int i);

    /* loaded from: classes.dex */
    public class OutOfResourcesException extends Exception {
        public OutOfResourcesException() {
        }

        public OutOfResourcesException(String str) {
            super(str);
        }
    }

    public SurfaceLayer(int i, boolean z, int i2) {
        this.mSurface = null;
        this.mNativePointer = i2;
        this.mSurfaceTexture = new SurfaceTexture(i, z);
        try {
            this.mSurface = (Surface) Surface.class.getConstructor(SurfaceTexture.class).newInstance(this.mSurfaceTexture);
        } catch (Exception e) {
            Log.e("SurfaceLayer", "SurfaceLayer init error ");
        }
        this.mAllowListener = true;
    }

    protected void finalize() {
        try {
            if (this.mSurfaceTexture != null) {
                SurfaceTexture.class.getDeclaredMethod("release", null).invoke(this.mSurfaceTexture, new Object[0]);
            }
            if (this.mSurface != null) {
                this.mSurface.release();
            }
        } finally {
            super.finalize();
        }
    }

    public void setOnFrameAvailableListener(boolean z) {
        if (this.mSurfaceTexture != null) {
            if (z) {
                try {
                    this.mSurfaceTexture.setOnFrameAvailableListener(this);
                    this.mAllowListener = true;
                    return;
                } catch (Exception e) {
                    Log.e("SurfaceLayer.java", "catch setOnFrameAvailableListener exception");
                    return;
                }
            }
            this.mAllowListener = false;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mAllowListener) {
            try {
                nativeOnFrameAvailable(this.mNativePointer);
            } catch (Exception e) {
                Log.e("SurfaceLayer.java", "catch onFrameAvailable exception");
            }
        }
    }

    public void updateTexImage() {
        if (this.mSurfaceTexture != null) {
            try {
                this.mSurfaceTexture.updateTexImage();
            } catch (RuntimeException e) {
                Log.e("SurfaceLayer.java", "catch updateTexImage exception");
            }
        }
    }

    public long getTimestamp() {
        if (this.mSurfaceTexture == null) {
            return 0L;
        }
        try {
            return this.mSurfaceTexture.getTimestamp();
        } catch (Exception e) {
            Log.e("SurfaceLayer.java", "catch getTimesStamp exception");
            return 0L;
        }
    }

    public void getTransformMatrix(float[] fArr) {
        if (fArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.getTransformMatrix(fArr);
        }
    }
}
