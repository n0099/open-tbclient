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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bvh;
    float dOk;
    float dOl;
    private float dtY;
    private float gSE;
    private FrameLayout hFT;
    private RotateFrameLayout hFU;
    private TextView hFV;
    private EditText hFW;
    private ImageView hFX;
    private ImageView hFY;
    private int hFZ;
    private int hGA;
    private Map<String, Bitmap> hGB;
    private Bitmap hGC;
    private float hGa;
    private boolean hGb;
    private float hGc;
    private float hGd;
    private int hGe;
    private int hGf;
    private float hGg;
    private float hGh;
    private float hGi;
    private float hGj;
    private b hGk;
    private float hGl;
    private float hGm;
    private float hGn;
    private float hGo;
    private boolean hGp;
    private float hGq;
    private int hGr;
    private int hGs;
    private int hGt;
    private int hGu;
    private int hGv;
    private float hGw;
    private float hGx;
    private int hGy;
    private float hGz;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastY;
    private int mScreenWidth;
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
        this.hFZ = 0;
        this.hGj = 1.0f;
        this.gSE = 1.0f;
        this.hGp = true;
        this.hGB = new HashMap();
        this.startTime = 0L;
        this.dOk = 0.0f;
        this.dOl = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hGq = l.h(getContext(), e.C0210e.fontsize40);
        this.hGy = l.h(getContext(), e.C0210e.ds2);
        this.dtY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hFT = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hFT);
        this.hFT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hFZ == 4) {
                            CoverPendantDragView.this.bJK();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bvh);
                        if (!CoverPendantDragView.this.hGb && abs < CoverPendantDragView.this.dtY && abs2 < CoverPendantDragView.this.dtY && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bJL();
                        }
                        CoverPendantDragView.this.hGc = 0.0f;
                        CoverPendantDragView.this.hGd = 0.0f;
                        CoverPendantDragView.this.hGb = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.F(motionEvent)) {
                            CoverPendantDragView.this.H(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.hGc = 0.0f;
                        CoverPendantDragView.this.hGd = 0.0f;
                        return true;
                }
            }
        });
        this.hFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hFW.setText("");
                CoverPendantDragView.this.btC();
            }
        });
        this.hFY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hGd = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.F(motionEvent)) {
                            CoverPendantDragView.this.G(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.hFW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hFZ != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hFV.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.iO(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hFV.getText().length()) {
                        CoverPendantDragView.this.wN(obj);
                    } else {
                        CoverPendantDragView.this.wM(obj);
                    }
                } else {
                    String I = y.I(obj, 20);
                    editable.delete(I.length(), obj.length());
                    CoverPendantDragView.this.wN(I);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hFV.setText(editable.toString());
            }
        });
        this.hFW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hFT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bvh = motionEvent.getRawY();
        this.hGa = this.mDownX;
        this.mLastY = this.bvh;
        this.hGg = (this.hFT.getWidth() / 2) + this.hFT.getX();
        this.hGh = (this.hFT.getHeight() / 2) + this.hFT.getY();
        this.hFV.setText(this.hFW.getText());
        this.hFV.setVisibility(0);
        this.hFW.setVisibility(8);
        setEditTextEnable(false);
        this.hGk.HidenSoftKeyPad(this.hFW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(String str) {
        TextPaint paint = this.hFW.getPaint();
        float measureText = paint.measureText(str);
        while (this.hFW.getLineCount() == 1 && this.hFW.getTextSize() < this.hGq * this.gSE && measureText < this.hGx * this.gSE) {
            setTextSize(0, this.hFW.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.iO(str) <= y.iO(getResources().getString(e.j.cover_hint)) && this.hFW.getTextSize() != this.hGq * this.gSE) {
            setTextSize(0, this.hGq * this.gSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN(String str) {
        TextPaint paint = this.hFW.getPaint();
        float measureText = paint.measureText(str);
        while (this.hFW.getTextSize() > ((this.hGw * this.gSE) / 2.0f) - (this.hGz * this.gSE) && measureText > this.hGx * this.gSE) {
            setTextSize(0, this.hFW.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hFW.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hFW.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0210e.ds120)) {
            str = y.K(str, y.iN(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hGk = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hGl = f;
        this.hGm = f2;
        this.hGn = f3;
        this.hGo = f4;
        if (this.hGl > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hGl, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hGm > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hGm);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hGn > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hGn) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hGo > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hGo) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.hGa - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hGg - rawX);
        float abs4 = Math.abs(this.hGh - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hGg - this.hGa);
        float abs6 = Math.abs(this.hGh - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bW(sqrt, (int) (sqrt / this.hGi));
        if (this.hGd != 0.0f) {
            this.hFT.setRotation(this.hFT.getRotation() - (this.hGd - J));
        }
        this.hGd = J;
        this.hGa = rawX;
        this.mLastY = rawY;
    }

    private void bW(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hFT.getLayoutParams();
        int width = this.hFT.getWidth() - i;
        int i3 = (int) (width / this.hGi);
        if (width < this.hGe) {
            width = this.hGe;
            i3 = (int) (width / this.hGi);
        }
        this.gSE = ((width * 1.0f) - (this.hGv * 2)) / (this.hGA - (this.hGv * 2));
        this.mContentView.setPadding((int) (this.hGr * this.gSE), (int) (this.hGs * this.gSE), (int) (this.hGt * this.gSE), (int) (this.hGu * this.gSE));
        setTextSize(0, (this.hFW.getTextSize() * i3) / this.hFT.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hFT.setLayoutParams(layoutParams);
        float f = this.hGg - (layoutParams.width / 2);
        float f2 = this.hGh - (layoutParams.height / 2);
        this.hFT.setX(f);
        this.hFT.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hFZ != 4) {
            float y = (this.hFT.getY() + rawY) - this.mLastY;
            if (y < this.hGm) {
                y = this.hGm;
            } else if (y > (this.hGm + this.mVideoHeight) - this.hFT.getHeight()) {
                y = (this.hGm + this.mVideoHeight) - this.hFT.getHeight();
            }
            this.hFT.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hGb = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.hGc != 0.0f) {
                    int i = (int) (this.hGc - K);
                    bW(i, (int) (i / this.hGi));
                }
                if (this.hGd != 0.0f) {
                    this.hFT.setRotation(this.hFT.getRotation() - (this.hGd - I));
                }
                this.hGd = I;
                this.hGc = K;
            } else if (!this.hGb && pointerCount == 1) {
                float y2 = (this.hFT.getY() + rawY) - this.mLastY;
                if (y2 < this.hGm - (this.hFT.getHeight() / 2)) {
                    y2 = this.hGm - (this.hFT.getHeight() / 2);
                } else if (y2 > ((this.hGm + this.mVideoHeight) - this.hFT.getHeight()) + (this.hFT.getHeight() / 2)) {
                    y2 = ((this.hGm + this.mVideoHeight) - this.hFT.getHeight()) + (this.hFT.getHeight() / 2);
                }
                float x = (this.hFT.getX() + rawX) - this.hGa;
                if (x < this.hGl - (this.hFT.getWidth() / 2)) {
                    x = this.hGl - (this.hFT.getWidth() / 2);
                } else if (x > ((this.hGl + this.mVideoWidth) - this.hFT.getWidth()) + (this.hFT.getWidth() / 2)) {
                    x = ((this.hGl + this.mVideoWidth) - this.hFT.getWidth()) + (this.hFT.getWidth() / 2);
                }
                this.hFT.setX(x);
                this.hFT.setY(y2);
            }
        }
        this.hGa = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hFW.getTextSize() != f) {
            this.hFW.setTextSize(i, f);
        }
        if (this.hFV.getTextSize() != f) {
            this.hFV.setTextSize(i, f);
        }
    }

    private float I(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.hFT.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hGh - motionEvent.getRawY(), this.hGg - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dtY && Math.abs(motionEvent.getRawY() - this.bvh) < this.dtY;
    }

    private void init() {
        this.hFU = (RotateFrameLayout) this.hFT.findViewById(e.g.content_container);
        this.hFV = (TextView) this.hFT.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hFT.findViewById(e.g.content_view);
        this.hFW = (EditText) this.hFT.findViewById(e.g.cover_edit);
        this.hFX = (ImageView) this.hFT.findViewById(e.g.cover_delete);
        this.hFY = (ImageView) this.hFT.findViewById(e.g.cover_scale);
    }

    public void btC() {
        this.hFV.setText(this.hFW.getText());
        this.hFV.setVisibility(0);
        this.hFW.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hFV.getText())) {
            this.hFZ = 0;
            this.hFT.setVisibility(8);
        }
        if (this.hFZ == 4) {
            bJJ();
        }
        this.hGk.HidenSoftKeyPad(this.hFW);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hFW.setFocusable(true);
            this.hFW.setFocusableInTouchMode(true);
            this.hFW.requestFocus();
            return;
        }
        this.hFW.setFocusable(false);
        this.hFW.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hFW.setText("");
                    btC();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bJL();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bJL();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bJL();
                    break;
                default:
                    btC();
                    String wL = com.baidu.tieba.video.editvideo.model.b.bJE().wL(pendantData.resource);
                    if (TextUtils.isEmpty(wL)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hEO.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bJE().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(wL, pendantData);
                        break;
                    }
                    break;
            }
            this.hFZ = pendantData.pendantType;
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
        bJJ();
        a(this.mVideoWidth, l.h(getContext(), e.C0210e.ds100), this.mScreenWidth, pendantData);
        if (this.hFZ == 4 || this.hFZ == 0) {
            this.hFT.setX(this.hGl);
            this.hFT.setY(((this.mVideoHeight - l.h(getContext(), e.C0210e.ds100)) / 2) + this.hGm);
            String obj = this.hFW.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hFW.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hFV.setText(a2);
                    this.hFW.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bJJ() {
        if (this.hGp) {
            this.hGp = false;
            this.hFX.setVisibility(8);
            this.hFY.setVisibility(8);
            this.hFU.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        if (!this.hGp) {
            this.hGp = true;
            this.hFX.setVisibility(0);
            this.hFY.setVisibility(0);
            this.hFU.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hGB != null) {
            Bitmap bitmap = this.hGB.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hGB.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bJJ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hGj = 1.0f;
                this.gSE = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hGj = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hGe = (this.hGv * 2) + width;
                this.hGf = (this.hGv * 2) + height;
                this.hGi = (this.hGe * 1.0f) / this.hGf;
                this.hFT.setX((((this.mVideoWidth - i2) - (this.hGv * 2)) / 2) + this.hGl);
                this.hFT.setY((((this.mVideoHeight - i) - (this.hGv * 2)) / 2) + this.hGm);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dOk = motionEvent.getRawX();
                this.dOl = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dOk);
                float abs2 = Math.abs(rawY - this.dOl);
                if (motionEvent.getPointerCount() <= 1 && abs < this.dtY && abs2 < this.dtY && System.currentTimeMillis() - this.startTime < 300) {
                    btC();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hFV == null || this.hFV.getText() == null) {
            return null;
        }
        return this.hFV.getText().toString();
    }

    public void bJL() {
        this.hFV.setText(this.hFW.getText());
        this.hFV.setVisibility(8);
        this.hFW.setVisibility(0);
        setEditTextEnable(true);
        this.hGk.ShowSoftKeyPad(this.hFW);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hFW.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hFV.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0210e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0210e.fontsize40) * i) / i3);
            this.hGv = 0;
            this.hFW.setMaxLines(1);
            this.hFV.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hFV.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hFW.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0210e.ds60), 0, l.h(getContext(), e.C0210e.ds60), 0);
        } else {
            this.hFW.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hFV.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hGv = l.h(getContext(), e.C0210e.ds40);
            this.hFW.setMaxLines(2);
            this.hFV.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hFV.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hFW.setLayoutParams(layoutParams2);
            this.hGr = (int) (l.dip2px(getContext(), pendantData.left) * this.hGj);
            this.hGs = (int) (l.dip2px(getContext(), pendantData.top) * this.hGj);
            this.hGt = (int) (l.dip2px(getContext(), pendantData.right) * this.hGj);
            this.hGu = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hGj);
            this.mContentView.setPadding(this.hGr, this.hGs, this.hGt, this.hGu);
            this.hGq = l.h(getContext(), e.C0210e.fontsize40) * this.hGj;
            String text = getText();
            this.hGw = (i2 - this.hGs) - this.hGu;
            this.hGx = (i - this.hGr) - this.hGt;
            this.hGz = this.hGy + l.h(getContext(), e.C0210e.ds6);
            setTextSize(0, this.hGq);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hGx);
                this.hGq = this.hFW.getTextSize();
                bJK();
                bJL();
            } else {
                if (y.iO(text) > 20) {
                    text = y.I(text, 20);
                    this.hFW.setText(text);
                    this.hFV.setText(text);
                }
                wN(text);
            }
        }
        this.hFV.setIncludeFontPadding(false);
        this.hFW.setIncludeFontPadding(false);
        this.hFV.setLineSpacing(this.hGy, 1.0f);
        this.hFW.setLineSpacing(this.hGy, 1.0f);
        this.hFT.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hFT.getLayoutParams();
        layoutParams3.height = (this.hGv * 2) + i2;
        layoutParams3.width = (this.hGv * 2) + i;
        this.hFT.setLayoutParams(layoutParams3);
        this.hGA = (this.hGv * 2) + i;
        ((FrameLayout.LayoutParams) this.hFU.getLayoutParams()).setMargins(this.hGv, this.hGv, this.hGv, this.hGv);
        this.hFT.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hGC == null) {
            bJM();
        }
        return this.hGC;
    }

    private void bJM() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hGC = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bJN() {
        if (this.hGC != null && !this.hGC.isRecycled()) {
            this.hGC.recycle();
            this.hGC = null;
        }
    }

    public void oa(boolean z) {
        if (this.hFZ != 0) {
            if (z) {
                bJN();
                this.hFT.setVisibility(0);
                return;
            }
            btC();
            getTempBitmap();
            this.hFT.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hGB.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hGB.clear();
        this.hGB = null;
        bJN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hGE;
        WeakReference<CoverPendantDragView> hGF;
        WeakReference<PendantData> hGG;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hGE = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hGF = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hGG = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cR(String str, String str2) {
            if (this.hGE != null && this.hGE.get() != null) {
                this.hGE.get().hEO.setVisibility(8);
            }
            if (this.hGF != null && this.hGF.get() != null && this.hGG != null && this.hGG.get() != null) {
                this.hGF.get().a(str2, this.hGG.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void wC(String str) {
            if (this.hGE != null && this.hGE.get() != null) {
                this.hGE.get().hEO.setVisibility(8);
            }
            if (this.hGF != null && this.hGF.get() != null) {
                l.showToast(this.hGF.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bIP() {
            if (this.hGE != null && this.hGE.get() != null) {
                this.hGE.get().hEO.setVisibility(8);
            }
        }
    }
}
