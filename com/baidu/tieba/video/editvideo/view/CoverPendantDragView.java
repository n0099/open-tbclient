package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bTq;
    private float cKF;
    private FrameLayout gML;
    private RotateFrameLayout gMM;
    private TextView gMN;
    private EditText gMO;
    private ImageView gMP;
    private ImageView gMQ;
    private int gMR;
    private boolean gMS;
    private float gMT;
    private float gMU;
    private int gMV;
    private int gMW;
    private float gMX;
    private float gMY;
    private float gMZ;
    private float gNa;
    private b gNb;
    private float gNc;
    private float gNd;
    private float gNe;
    private float gNf;
    private boolean gNg;
    private float gNh;
    private int gNi;
    private int gNj;
    private int gNk;
    private int gNl;
    private int gNm;
    private float gNn;
    private float gNo;
    private int gNp;
    private float gNq;
    private int gNr;
    private Map<String, Bitmap> gNs;
    float gNt;
    float gNu;
    private float gaZ;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private Bitmap mTempBitmap;
    private int mVideoHeight;
    private int mVideoWidth;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMR = 0;
        this.gNa = 1.0f;
        this.gaZ = 1.0f;
        this.gNg = true;
        this.gNs = new HashMap();
        this.startTime = 0L;
        this.gNt = 0.0f;
        this.gNu = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.gNh = l.e(getContext(), d.e.fontsize40);
        this.gNp = l.e(getContext(), d.e.ds2);
        this.cKF = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gML = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.i.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gML);
        this.gML.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view2, motionEvent);
                        if (CoverPendantDragView.this.gMR == 4) {
                            CoverPendantDragView.this.bwW();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bTq);
                        if (!CoverPendantDragView.this.gMS && abs < CoverPendantDragView.this.cKF && abs2 < CoverPendantDragView.this.cKF && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bwX();
                        }
                        CoverPendantDragView.this.gMT = 0.0f;
                        CoverPendantDragView.this.gMU = 0.0f;
                        CoverPendantDragView.this.gMS = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.G(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.gMT = 0.0f;
                        CoverPendantDragView.this.gMU = 0.0f;
                        return true;
                }
            }
        });
        this.gMP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CoverPendantDragView.this.gMO.setText("");
                CoverPendantDragView.this.bhP();
            }
        });
        this.gMQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view2, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gMU = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.F(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.gMO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gMR != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gMN.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_text_length_max_tips);
                    }
                } else if (w.hm(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gMN.getText().length()) {
                        CoverPendantDragView.this.tX(obj);
                    } else {
                        CoverPendantDragView.this.tW(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(F.length(), obj.length());
                    CoverPendantDragView.this.tX(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gMN.setText(editable.toString());
            }
        });
        this.gMO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gML.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view2, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bTq = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.bTq;
        this.gMX = (this.gML.getWidth() / 2) + this.gML.getX();
        this.gMY = (this.gML.getHeight() / 2) + this.gML.getY();
        this.gMN.setText(this.gMO.getText());
        this.gMN.setVisibility(0);
        this.gMO.setVisibility(8);
        setEditTextEnable(false);
        this.gNb.HidenSoftKeyPad(this.gMO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW(String str) {
        TextPaint paint = this.gMO.getPaint();
        float measureText = paint.measureText(str);
        while (this.gMO.getLineCount() == 1 && this.gMO.getTextSize() < this.gNh * this.gaZ && measureText < this.gNo * this.gaZ) {
            setTextSize(0, this.gMO.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hm(str) <= w.hm(getResources().getString(d.k.cover_hint)) && this.gMO.getTextSize() != this.gNh * this.gaZ) {
            setTextSize(0, this.gNh * this.gaZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX(String str) {
        TextPaint paint = this.gMO.getPaint();
        float measureText = paint.measureText(str);
        while (this.gMO.getTextSize() > ((this.gNn * this.gaZ) / 2.0f) - (this.gNq * this.gaZ) && measureText > this.gNo * this.gaZ) {
            setTextSize(0, this.gMO.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.gMO.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gMO.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.e(getContext(), d.e.ds120)) {
            str = w.I(str, w.hl(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gNb = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.gNc = f;
        this.gNd = f2;
        this.gNe = f3;
        this.gNf = f4;
        if (this.gNc > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gNc, -1);
            layoutParams.gravity = 3;
            addView(view2, layoutParams);
        }
        if (this.gNd > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gNd);
            layoutParams2.gravity = 48;
            addView(view3, layoutParams2);
        }
        if (this.gNe > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gNe) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view4, layoutParams3);
        }
        if (this.gNf > 0.0f) {
            View view5 = new View(getContext());
            view5.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gNf) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view5, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.gMX - rawX);
        float abs4 = Math.abs(this.gMY - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gMX - this.mLastX);
        float abs6 = Math.abs(this.gMY - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bO(sqrt, (int) (sqrt / this.gMZ));
        if (this.gMU != 0.0f) {
            this.gML.setRotation(this.gML.getRotation() - (this.gMU - I));
        }
        this.gMU = I;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bO(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gML.getLayoutParams();
        int width = this.gML.getWidth() - i;
        int i3 = (int) (width / this.gMZ);
        if (width < this.gMV) {
            width = this.gMV;
            i3 = (int) (width / this.gMZ);
        }
        this.gaZ = ((width * 1.0f) - (this.gNm * 2)) / (this.gNr - (this.gNm * 2));
        this.mContentView.setPadding((int) (this.gNi * this.gaZ), (int) (this.gNj * this.gaZ), (int) (this.gNk * this.gaZ), (int) (this.gNl * this.gaZ));
        setTextSize(0, (this.gMO.getTextSize() * i3) / this.gML.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gML.setLayoutParams(layoutParams);
        float f = this.gMX - (layoutParams.width / 2);
        float f2 = this.gMY - (layoutParams.height / 2);
        this.gML.setX(f);
        this.gML.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gMR != 4) {
            float y = (this.gML.getY() + rawY) - this.mLastY;
            if (y < this.gNd) {
                y = this.gNd;
            } else if (y > (this.gNd + this.mVideoHeight) - this.gML.getHeight()) {
                y = (this.gNd + this.mVideoHeight) - this.gML.getHeight();
            }
            this.gML.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gMS = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.gMT != 0.0f) {
                    int i = (int) (this.gMT - J);
                    bO(i, (int) (i / this.gMZ));
                }
                if (this.gMU != 0.0f) {
                    this.gML.setRotation(this.gML.getRotation() - (this.gMU - H));
                }
                this.gMU = H;
                this.gMT = J;
            } else if (!this.gMS && pointerCount == 1) {
                float y2 = (this.gML.getY() + rawY) - this.mLastY;
                if (y2 < this.gNd - (this.gML.getHeight() / 2)) {
                    y2 = this.gNd - (this.gML.getHeight() / 2);
                } else if (y2 > ((this.gNd + this.mVideoHeight) - this.gML.getHeight()) + (this.gML.getHeight() / 2)) {
                    y2 = ((this.gNd + this.mVideoHeight) - this.gML.getHeight()) + (this.gML.getHeight() / 2);
                }
                float x = (this.gML.getX() + rawX) - this.mLastX;
                if (x < this.gNc - (this.gML.getWidth() / 2)) {
                    x = this.gNc - (this.gML.getWidth() / 2);
                } else if (x > ((this.gNc + this.mVideoWidth) - this.gML.getWidth()) + (this.gML.getWidth() / 2)) {
                    x = ((this.gNc + this.mVideoWidth) - this.gML.getWidth()) + (this.gML.getWidth() / 2);
                }
                this.gML.setX(x);
                this.gML.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gMO.getTextSize() != f) {
            this.gMO.setTextSize(i, f);
        }
        if (this.gMN.getTextSize() != f) {
            this.gMN.setTextSize(i, f);
        }
    }

    private float H(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.gML.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gMY - motionEvent.getRawY(), this.gMX - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cKF && Math.abs(motionEvent.getRawY() - this.bTq) < this.cKF;
    }

    private void init() {
        this.gMM = (RotateFrameLayout) this.gML.findViewById(d.g.content_container);
        this.gMN = (TextView) this.gML.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gML.findViewById(d.g.content_view);
        this.gMO = (EditText) this.gML.findViewById(d.g.cover_edit);
        this.gMP = (ImageView) this.gML.findViewById(d.g.cover_delete);
        this.gMQ = (ImageView) this.gML.findViewById(d.g.cover_scale);
    }

    public void bhP() {
        this.gMN.setText(this.gMO.getText());
        this.gMN.setVisibility(0);
        this.gMO.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gMN.getText())) {
            this.gMR = 0;
            this.gML.setVisibility(8);
        }
        if (this.gMR == 4) {
            bwV();
        }
        this.gNb.HidenSoftKeyPad(this.gMO);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gMO.setFocusable(true);
            this.gMO.setFocusableInTouchMode(true);
            this.gMO.requestFocus();
            return;
        }
        this.gMO.setFocusable(false);
        this.gMO.setFocusableInTouchMode(false);
    }

    public void a(View view2, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gMO.setText("");
                    bhP();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bwX();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bwX();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bwX();
                    break;
                default:
                    bhP();
                    String tV = com.baidu.tieba.video.editvideo.model.b.bwQ().tV(pendantData.resource);
                    if (TextUtils.isEmpty(tV)) {
                        if (view2 != null && (view2.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view2.getTag();
                            bVar.gLG.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bwQ().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tV, pendantData);
                        break;
                    }
                    break;
            }
            this.gMR = pendantData.pendantType;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mVideoWidth == 0 && this.mVideoHeight == 0) {
            this.mVideoWidth = getMeasuredWidth();
            this.mVideoHeight = getMeasuredHeight();
        }
    }

    private void a(PendantData pendantData) {
        bwV();
        a(this.mVideoWidth, l.e(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gMR == 4 || this.gMR == 0) {
            this.gML.setX(this.gNc);
            this.gML.setY(((this.mVideoHeight - l.e(getContext(), d.e.ds100)) / 2) + this.gNd);
            String obj = this.gMO.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gMO.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gMN.setText(a2);
                    this.gMO.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bwV() {
        if (this.gNg) {
            this.gNg = false;
            this.gMP.setVisibility(8);
            this.gMQ.setVisibility(8);
            this.gMM.setBackgroundColor(getResources().getColor(d.C0126d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        if (!this.gNg) {
            this.gNg = true;
            this.gMP.setVisibility(0);
            this.gMQ.setVisibility(0);
            this.gMM.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.gNs != null) {
            Bitmap bitmap = this.gNs.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gNs.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bwV();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gNa = 1.0f;
                this.gaZ = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gNa = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gMV = (this.gNm * 2) + width;
                this.gMW = (this.gNm * 2) + height;
                this.gMZ = (this.gMV * 1.0f) / this.gMW;
                this.gML.setX((((this.mVideoWidth - i2) - (this.gNm * 2)) / 2) + this.gNc);
                this.gML.setY((((this.mVideoHeight - i) - (this.gNm * 2)) / 2) + this.gNd);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gNt = motionEvent.getRawX();
                this.gNu = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gNt);
                float abs2 = Math.abs(rawY - this.gNu);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cKF && abs2 < this.cKF && System.currentTimeMillis() - this.startTime < 300) {
                    bhP();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gMN == null || this.gMN.getText() == null) {
            return null;
        }
        return this.gMN.getText().toString();
    }

    public void bwX() {
        this.gMN.setText(this.gMO.getText());
        this.gMN.setVisibility(8);
        this.gMO.setVisibility(0);
        setEditTextEnable(true);
        this.gNb.ShowSoftKeyPad(this.gMO);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gMO.setTextAppearance(getContext(), d.l.cover_text_style);
            this.gMN.setTextAppearance(getContext(), d.l.cover_text_style);
            i2 = (int) ((l.e(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.e(getContext(), d.e.fontsize40) * i) / i3);
            this.gNm = 0;
            this.gMO.setMaxLines(1);
            this.gMN.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gMN.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gMO.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.e(getContext(), d.e.ds60), 0, l.e(getContext(), d.e.ds60), 0);
        } else {
            this.gMO.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gMN.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gNm = l.e(getContext(), d.e.ds40);
            this.gMO.setMaxLines(2);
            this.gMN.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gMN.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gMO.setLayoutParams(layoutParams2);
            this.gNi = (int) (l.dip2px(getContext(), pendantData.left) * this.gNa);
            this.gNj = (int) (l.dip2px(getContext(), pendantData.top) * this.gNa);
            this.gNk = (int) (l.dip2px(getContext(), pendantData.right) * this.gNa);
            this.gNl = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gNa);
            this.mContentView.setPadding(this.gNi, this.gNj, this.gNk, this.gNl);
            this.gNh = l.e(getContext(), d.e.fontsize40) * this.gNa;
            String text = getText();
            this.gNn = (i2 - this.gNj) - this.gNl;
            this.gNo = (i - this.gNi) - this.gNk;
            this.gNq = this.gNp + l.e(getContext(), d.e.ds6);
            setTextSize(0, this.gNh);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.k.cover_hint), this.gNo);
                this.gNh = this.gMO.getTextSize();
                bwW();
                bwX();
            } else {
                if (w.hm(text) > 20) {
                    text = w.F(text, 20);
                    this.gMO.setText(text);
                    this.gMN.setText(text);
                }
                tX(text);
            }
        }
        this.gMN.setIncludeFontPadding(false);
        this.gMO.setIncludeFontPadding(false);
        this.gMN.setLineSpacing(this.gNp, 1.0f);
        this.gMO.setLineSpacing(this.gNp, 1.0f);
        this.gML.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gML.getLayoutParams();
        layoutParams3.height = (this.gNm * 2) + i2;
        layoutParams3.width = (this.gNm * 2) + i;
        this.gML.setLayoutParams(layoutParams3);
        this.gNr = (this.gNm * 2) + i;
        ((FrameLayout.LayoutParams) this.gMM.getLayoutParams()).setMargins(this.gNm, this.gNm, this.gNm, this.gNm);
        this.gML.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bwY();
        }
        return this.mTempBitmap;
    }

    private void bwY() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bwZ() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void mS(boolean z) {
        if (this.gMR != 0) {
            if (z) {
                bwZ();
                this.gML.setVisibility(0);
                return;
            }
            bhP();
            getTempBitmap();
            this.gML.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gNs.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gNs.clear();
        this.gNs = null;
        bwZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gNw;
        WeakReference<CoverPendantDragView> gNx;
        WeakReference<PendantData> gNy;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gNw = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gNx = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gNy = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ci(String str, String str2) {
            if (this.gNw != null && this.gNw.get() != null) {
                this.gNw.get().gLG.setVisibility(8);
            }
            if (this.gNx != null && this.gNx.get() != null && this.gNy != null && this.gNy.get() != null) {
                this.gNx.get().a(str2, this.gNy.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tL(String str) {
            if (this.gNw != null && this.gNw.get() != null) {
                this.gNw.get().gLG.setVisibility(8);
            }
            if (this.gNx != null && this.gNx.get() != null) {
                l.showToast(this.gNx.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bwb() {
            if (this.gNw != null && this.gNw.get() != null) {
                this.gNw.get().gLG.setVisibility(8);
            }
        }
    }
}
