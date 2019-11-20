package com.baidu.tieba.video.record;

import android.hardware.Camera;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
class b {
    private float jCr;
    private int jCs;
    private i jCt;
    private Camera mCamera;
    private int mode = 0;

    public b(Camera camera) {
        this.mCamera = camera;
    }

    public void setRecordController(i iVar) {
        this.jCt = iVar;
    }

    public boolean j(MotionEvent motionEvent) {
        if (this.jCt == null || !this.jCt.aoA()) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mode = 0;
                    break;
                case 2:
                    if (this.mode == 1 && motionEvent.getPointerCount() >= 2) {
                        float spacing = spacing(motionEvent);
                        int i = (int) ((spacing - this.jCr) / 10.0f);
                        if (i >= 1 || i <= -1) {
                            int i2 = i + this.jCs;
                            if (i2 > getMaxZoom()) {
                                i2 = getMaxZoom();
                            }
                            setZoom(i2 >= 0 ? i2 : 0);
                            this.jCr = spacing;
                            break;
                        }
                    }
                    break;
                case 5:
                    this.mode = 1;
                    this.jCr = spacing(motionEvent);
                    break;
            }
        }
        return true;
    }

    private float spacing(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        double x = motionEvent.getX(0) - motionEvent.getX(1);
        double y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private int getMaxZoom() {
        if (this.mCamera == null) {
            return -1;
        }
        Camera.Parameters parameters = this.mCamera.getParameters();
        if (parameters.isZoomSupported()) {
            if (parameters.getMaxZoom() <= 40) {
                return parameters.getMaxZoom();
            }
            return 40;
        }
        return -1;
    }

    private void setZoom(int i) {
        if (this.mCamera != null) {
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(i);
                this.mCamera.setParameters(parameters);
                this.jCs = i;
            }
        }
    }
}
