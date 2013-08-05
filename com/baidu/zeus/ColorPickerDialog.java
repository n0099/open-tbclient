package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class ColorPickerDialog extends AlertDialog implements DialogInterface.OnClickListener {
    private int mColor;
    private DialogInterface.OnDismissListener mDlgDismissListener;
    private OnColorChangedListener mListener;
    JsPromptResult mRes;

    /* loaded from: classes.dex */
    public interface OnColorChangedListener {
        void colorChanged(int i);
    }

    /* loaded from: classes.dex */
    class ColorPickerView extends View {
        private static final int CENTER_RADIUS = 32;
        private static final int CENTER_X = 100;
        private static final int CENTER_Y = 100;
        private static final float PI = 3.1415925f;
        private Paint mCenterPaint;
        private boolean mColorChanged;
        private final int[] mColors;
        private boolean mHighlightCenter;
        private OnColorChangedListener mListener;
        private Paint mPaint;
        private boolean mTrackingCenter;

        ColorPickerView(Context context, OnColorChangedListener onColorChangedListener, int i) {
            super(context);
            this.mColorChanged = false;
            this.mListener = onColorChangedListener;
            this.mColors = new int[]{-16777216, -65536, -65281, -16776961, -16711681, -16711936, -256, -65536, -1};
            SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.mColors, (float[]) null);
            this.mPaint = new Paint(1);
            this.mPaint.setShader(sweepGradient);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(32.0f);
            this.mCenterPaint = new Paint(1);
            this.mCenterPaint.setStyle(Paint.Style.FILL);
            this.mCenterPaint.setStrokeWidth(5.0f);
            this.mCenterPaint.setColor(i);
            this.mCenterPaint.setAlpha(Util.MASK_8BIT);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float strokeWidth = 100.0f - (this.mPaint.getStrokeWidth() * 0.5f);
            canvas.translate(100.0f, 100.0f);
            canvas.drawOval(new RectF(-strokeWidth, -strokeWidth, strokeWidth, strokeWidth), this.mPaint);
            canvas.drawCircle(0.0f, 0.0f, 32.0f, this.mCenterPaint);
            if (this.mTrackingCenter) {
                int color = this.mCenterPaint.getColor();
                this.mCenterPaint.setStyle(Paint.Style.STROKE);
                if (this.mHighlightCenter) {
                    this.mCenterPaint.setAlpha(Util.MASK_8BIT);
                } else {
                    this.mCenterPaint.setAlpha(DERTags.TAGGED);
                }
                canvas.drawCircle(0.0f, 0.0f, this.mCenterPaint.getStrokeWidth() + 32.0f, this.mCenterPaint);
                this.mCenterPaint.setStyle(Paint.Style.FILL);
                this.mCenterPaint.setColor(color);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(200, 200);
        }

        private int floatToByte(float f) {
            return Math.round(f);
        }

        private int pinToByte(int i) {
            if (i < 0) {
                return 0;
            }
            return i > 255 ? Util.MASK_8BIT : i;
        }

        private int ave(int i, int i2, float f) {
            return Math.round((i2 - i) * f) + i;
        }

        private int interpColor(int[] iArr, float f) {
            if (f <= 0.0f) {
                return iArr[0];
            }
            if (f >= 1.0f) {
                return iArr[iArr.length - 1];
            }
            float length = (iArr.length - 1) * f;
            int i = (int) length;
            float f2 = length - i;
            int i2 = iArr[i];
            int i3 = iArr[i + 1];
            return Color.argb(ave(Color.alpha(i2), Color.alpha(i3), f2), ave(Color.red(i2), Color.red(i3), f2), ave(Color.green(i2), Color.green(i3), f2), ave(Color.blue(i2), Color.blue(i3), f2));
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX() - 100.0f;
            float y = motionEvent.getY() - 100.0f;
            boolean z = Math.sqrt((double) ((x * x) + (y * y))) <= 32.0d;
            switch (motionEvent.getAction()) {
                case 0:
                    this.mTrackingCenter = z;
                    if (z) {
                        this.mHighlightCenter = true;
                        invalidate();
                        break;
                    }
                    if (!this.mTrackingCenter) {
                        if (this.mHighlightCenter != z) {
                            this.mHighlightCenter = z;
                            invalidate();
                            break;
                        }
                    } else {
                        float atan2 = ((float) Math.atan2(y, x)) / 6.283185f;
                        if (atan2 < 0.0f) {
                            atan2 += 1.0f;
                        }
                        this.mCenterPaint.setColor(interpColor(this.mColors, atan2));
                        this.mColorChanged = true;
                        invalidate();
                        break;
                    }
                    break;
                case 1:
                    if (this.mColorChanged) {
                        this.mColorChanged = false;
                        this.mListener.colorChanged(this.mCenterPaint.getColor());
                    }
                    if (this.mTrackingCenter) {
                        this.mTrackingCenter = false;
                        invalidate();
                        break;
                    }
                    break;
                case 2:
                    if (!this.mTrackingCenter) {
                    }
                    break;
            }
            return true;
        }
    }

    public ColorPickerDialog(Context context, String str, JsPromptResult jsPromptResult) {
        this(context, 0, str, jsPromptResult);
    }

    public ColorPickerDialog(Context context, int i, String str, JsPromptResult jsPromptResult) {
        super(context, i);
        int i2;
        this.mListener = new OnColorChangedListener() { // from class: com.baidu.zeus.ColorPickerDialog.1
            @Override // com.baidu.zeus.ColorPickerDialog.OnColorChangedListener
            public void colorChanged(int i3) {
                ColorPickerDialog.this.mColor = i3;
            }
        };
        this.mDlgDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.zeus.ColorPickerDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ColorPickerDialog.this.mRes != null) {
                    ColorPickerDialog.this.mRes.cancel();
                    ColorPickerDialog.this.mRes.setReady();
                    ColorPickerDialog.this.mRes = null;
                }
            }
        };
        this.mRes = jsPromptResult;
        try {
            i2 = Integer.parseInt(str.substring(1), 16);
        } catch (Exception e) {
            i2 = 16777215;
        }
        this.mColor = i2;
        setButton(-1, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_SET, "Set"), this);
        setButton(-2, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_CANCEL, "Cancel"), this);
        setTitle(PickerHelper.getStringById(WebChromeClient.STRING_DLG_TITLE_COLOR, "Set Color"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(1);
        linearLayout.addView(new ColorPickerView(context, this.mListener, i2));
        setView(linearLayout);
        setOnDismissListener(this.mDlgDismissListener);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mRes != null) {
            if (i == -1) {
                this.mRes.confirm(String.format("#%02x%02x%02x", Integer.valueOf(Color.red(this.mColor)), Integer.valueOf(Color.green(this.mColor)), Integer.valueOf(Color.blue(this.mColor))));
            } else {
                this.mRes.cancel();
            }
            this.mRes.setReady();
            this.mRes = null;
        }
    }
}
