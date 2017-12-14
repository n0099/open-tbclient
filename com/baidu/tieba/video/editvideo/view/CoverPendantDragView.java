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
import com.baidu.tbadk.core.util.aj;
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
    private float EO;
    private float bKv;
    private float cvI;
    private RotateFrameLayout gSA;
    private TextView gSB;
    private EditText gSC;
    private ImageView gSD;
    private ImageView gSE;
    private int gSF;
    private boolean gSG;
    private float gSH;
    private float gSI;
    private int gSJ;
    private int gSK;
    private float gSL;
    private float gSM;
    private float gSN;
    private float gSO;
    private b gSP;
    private float gSQ;
    private float gSR;
    private float gSS;
    private float gST;
    private boolean gSU;
    private float gSV;
    private int gSW;
    private int gSX;
    private int gSY;
    private int gSZ;
    private FrameLayout gSz;
    private int gTa;
    private float gTb;
    private float gTc;
    private int gTd;
    private float gTe;
    private int gTf;
    private Map<String, Bitmap> gTg;
    private float gaf;
    float gvW;
    float gvX;
    private FrameLayout mContentView;
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
        this.gSF = 0;
        this.gSO = 1.0f;
        this.gaf = 1.0f;
        this.gSU = true;
        this.gTg = new HashMap();
        this.startTime = 0L;
        this.gvW = 0.0f;
        this.gvX = 0.0f;
        this.mScreenWidth = l.ac(TbadkCoreApplication.getInst());
        this.gSV = l.f(getContext(), d.e.fontsize40);
        this.gTd = l.f(getContext(), d.e.ds2);
        this.cvI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gSz = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gSz);
        this.gSz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.f(view, motionEvent);
                        if (CoverPendantDragView.this.gSF == 4) {
                            CoverPendantDragView.this.bCi();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.EO);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bKv);
                        if (!CoverPendantDragView.this.gSG && abs < CoverPendantDragView.this.cvI && abs2 < CoverPendantDragView.this.cvI && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bCj();
                        }
                        CoverPendantDragView.this.gSH = 0.0f;
                        CoverPendantDragView.this.gSI = 0.0f;
                        CoverPendantDragView.this.gSG = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.A(motionEvent)) {
                            CoverPendantDragView.this.J(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.gSH = 0.0f;
                        CoverPendantDragView.this.gSI = 0.0f;
                        return true;
                }
            }
        });
        this.gSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gSC.setText("");
                CoverPendantDragView.this.bkv();
            }
        });
        this.gSE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.f(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gSI = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.A(motionEvent)) {
                            CoverPendantDragView.this.I(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.gSC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gSF != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gSB.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.gZ(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gSB.getText().length()) {
                        CoverPendantDragView.this.ui(obj);
                    } else {
                        CoverPendantDragView.this.uh(obj);
                    }
                } else {
                    String E = w.E(obj, 20);
                    editable.delete(obj.lastIndexOf(E) + E.length(), obj.length());
                    CoverPendantDragView.this.ui(E);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gSB.setText(editable.toString());
            }
        });
        this.gSC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gSz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, MotionEvent motionEvent) {
        this.EO = motionEvent.getRawX();
        this.bKv = motionEvent.getRawY();
        this.mLastX = this.EO;
        this.mLastY = this.bKv;
        this.gSL = (this.gSz.getWidth() / 2) + this.gSz.getX();
        this.gSM = (this.gSz.getHeight() / 2) + this.gSz.getY();
        this.gSB.setText(this.gSC.getText());
        this.gSB.setVisibility(0);
        this.gSC.setVisibility(8);
        setEditTextEnable(false);
        this.gSP.HidenSoftKeyPad(this.gSC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        TextPaint paint = this.gSC.getPaint();
        float measureText = paint.measureText(str);
        while (this.gSC.getLineCount() == 1 && this.gSC.getTextSize() < this.gSV * this.gaf && measureText < this.gTc * this.gaf) {
            setTextSize(0, this.gSC.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.gZ(str) <= w.gZ(getResources().getString(d.j.cover_hint)) && this.gSC.getTextSize() != this.gSV * this.gaf) {
            setTextSize(0, this.gSV * this.gaf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(String str) {
        TextPaint paint = this.gSC.getPaint();
        float measureText = paint.measureText(str);
        while (this.gSC.getTextSize() > ((this.gTb * this.gaf) / 2.0f) - (this.gTe * this.gaf) && measureText > this.gTc * this.gaf) {
            setTextSize(0, this.gSC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.gSC.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gSC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), d.e.ds120)) {
            str = w.H(str, w.gY(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gSP = bVar;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.gSQ = f;
        this.gSR = f2;
        this.gSS = f3;
        this.gST = f4;
        if (this.gSQ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gSQ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gSR > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gSR);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gSS > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gSS) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gST > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gST) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float L = L(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.gSL - rawX);
        float abs4 = Math.abs(this.gSM - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gSL - this.mLastX);
        float abs6 = Math.abs(this.gSM - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cb(sqrt, (int) (sqrt / this.gSN));
        if (this.gSI != 0.0f) {
            this.gSz.setRotation(this.gSz.getRotation() - (this.gSI - L));
        }
        this.gSI = L;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cb(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSz.getLayoutParams();
        int width = this.gSz.getWidth() - i;
        int i3 = (int) (width / this.gSN);
        if (width < this.gSJ) {
            width = this.gSJ;
            i3 = (int) (width / this.gSN);
        }
        this.gaf = ((width * 1.0f) - (this.gTa * 2)) / (this.gTf - (this.gTa * 2));
        this.mContentView.setPadding((int) (this.gSW * this.gaf), (int) (this.gSX * this.gaf), (int) (this.gSY * this.gaf), (int) (this.gSZ * this.gaf));
        setTextSize(0, (this.gSC.getTextSize() * i3) / this.gSz.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gSz.setLayoutParams(layoutParams);
        float f = this.gSL - (layoutParams.width / 2);
        float f2 = this.gSM - (layoutParams.height / 2);
        this.gSz.setX(f);
        this.gSz.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gSF != 4) {
            float y = (this.gSz.getY() + rawY) - this.mLastY;
            if (y < this.gSR) {
                y = this.gSR;
            } else if (y > (this.gSR + this.mVideoHeight) - this.gSz.getHeight()) {
                y = (this.gSR + this.mVideoHeight) - this.gSz.getHeight();
            }
            this.gSz.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gSG = true;
                float M = M(motionEvent);
                float K = K(motionEvent);
                if (this.gSH != 0.0f) {
                    int i = (int) (this.gSH - M);
                    cb(i, (int) (i / this.gSN));
                }
                if (this.gSI != 0.0f) {
                    this.gSz.setRotation(this.gSz.getRotation() - (this.gSI - K));
                }
                this.gSI = K;
                this.gSH = M;
            } else if (!this.gSG && pointerCount == 1) {
                float y2 = (this.gSz.getY() + rawY) - this.mLastY;
                if (y2 < this.gSR - (this.gSz.getHeight() / 2)) {
                    y2 = this.gSR - (this.gSz.getHeight() / 2);
                } else if (y2 > ((this.gSR + this.mVideoHeight) - this.gSz.getHeight()) + (this.gSz.getHeight() / 2)) {
                    y2 = ((this.gSR + this.mVideoHeight) - this.gSz.getHeight()) + (this.gSz.getHeight() / 2);
                }
                float x = (this.gSz.getX() + rawX) - this.mLastX;
                if (x < this.gSQ - (this.gSz.getWidth() / 2)) {
                    x = this.gSQ - (this.gSz.getWidth() / 2);
                } else if (x > ((this.gSQ + this.mVideoWidth) - this.gSz.getWidth()) + (this.gSz.getWidth() / 2)) {
                    x = ((this.gSQ + this.mVideoWidth) - this.gSz.getWidth()) + (this.gSz.getWidth() / 2);
                }
                this.gSz.setX(x);
                this.gSz.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gSC.getTextSize() != f) {
            this.gSC.setTextSize(i, f);
        }
        if (this.gSB.getTextSize() != f) {
            this.gSB.setTextSize(i, f);
        }
    }

    private float K(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.gSz.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float L(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gSM - motionEvent.getRawY(), this.gSL - motionEvent.getRawX()));
    }

    private float M(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EO) < this.cvI && Math.abs(motionEvent.getRawY() - this.bKv) < this.cvI;
    }

    private void init() {
        this.gSA = (RotateFrameLayout) this.gSz.findViewById(d.g.content_container);
        this.gSB = (TextView) this.gSz.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gSz.findViewById(d.g.content_view);
        this.gSC = (EditText) this.gSz.findViewById(d.g.cover_edit);
        this.gSD = (ImageView) this.gSz.findViewById(d.g.cover_delete);
        this.gSE = (ImageView) this.gSz.findViewById(d.g.cover_scale);
    }

    public void bkv() {
        this.gSB.setText(this.gSC.getText());
        this.gSB.setVisibility(0);
        this.gSC.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gSB.getText())) {
            this.gSF = 0;
            this.gSz.setVisibility(8);
        }
        if (this.gSF == 4) {
            bCh();
        }
        this.gSP.HidenSoftKeyPad(this.gSC);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gSC.setFocusable(true);
            this.gSC.setFocusableInTouchMode(true);
            this.gSC.requestFocus();
            return;
        }
        this.gSC.setFocusable(false);
        this.gSC.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gSC.setText("");
                    bkv();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bCj();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bCj();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bCj();
                    break;
                default:
                    bkv();
                    String ug = com.baidu.tieba.video.editvideo.model.b.bCc().ug(pendantData.resource);
                    if (TextUtils.isEmpty(ug)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.gRs.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bCc().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(ug, pendantData);
                        break;
                    }
                    break;
            }
            this.gSF = pendantData.pendantType;
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
        bCh();
        a(this.mVideoWidth, l.f(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gSF == 4 || this.gSF == 0) {
            this.gSz.setX(this.gSQ);
            this.gSz.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.gSR);
            String obj = this.gSC.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gSC.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gSB.setText(a2);
                    this.gSC.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bCh() {
        if (this.gSU) {
            this.gSU = false;
            this.gSD.setVisibility(8);
            this.gSE.setVisibility(8);
            this.gSA.setBackgroundColor(getResources().getColor(d.C0096d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCi() {
        if (!this.gSU) {
            this.gSU = true;
            this.gSD.setVisibility(0);
            this.gSE.setVisibility(0);
            this.gSA.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.gTg.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gTg.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bCh();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gSO = 1.0f;
                this.gaf = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gSO = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gSJ = (this.gTa * 2) + width;
                this.gSK = (this.gTa * 2) + height;
                this.gSN = (this.gSJ * 1.0f) / this.gSK;
                this.gSz.setX((((this.mVideoWidth - i2) - (this.gTa * 2)) / 2) + this.gSQ);
                this.gSz.setY((((this.mVideoHeight - i) - (this.gTa * 2)) / 2) + this.gSR);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gvW = motionEvent.getRawX();
                this.gvX = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gvW);
                float abs2 = Math.abs(rawY - this.gvX);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cvI && abs2 < this.cvI && System.currentTimeMillis() - this.startTime < 300) {
                    bkv();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gSB == null || this.gSB.getText() == null) {
            return null;
        }
        return this.gSB.getText().toString();
    }

    public void bCj() {
        this.gSB.setText(this.gSC.getText());
        this.gSB.setVisibility(8);
        this.gSC.setVisibility(0);
        setEditTextEnable(true);
        this.gSP.ShowSoftKeyPad(this.gSC);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gSC.setTextAppearance(getContext(), d.k.cover_text_style);
            this.gSB.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.gTa = 0;
            this.gSC.setMaxLines(1);
            this.gSB.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSB.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gSC.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.gSC.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gSB.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gTa = l.f(getContext(), d.e.ds40);
            this.gSC.setMaxLines(2);
            this.gSB.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gSB.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gSC.setLayoutParams(layoutParams2);
            this.gSW = (int) (l.dip2px(getContext(), pendantData.left) * this.gSO);
            this.gSX = (int) (l.dip2px(getContext(), pendantData.top) * this.gSO);
            this.gSY = (int) (l.dip2px(getContext(), pendantData.right) * this.gSO);
            this.gSZ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gSO);
            this.mContentView.setPadding(this.gSW, this.gSX, this.gSY, this.gSZ);
            this.gSV = l.f(getContext(), d.e.fontsize40) * this.gSO;
            String text = getText();
            this.gTb = (i2 - this.gSX) - this.gSZ;
            this.gTc = (i - this.gSW) - this.gSY;
            this.gTe = this.gTd + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.gSV);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.gTc);
                this.gSV = this.gSC.getTextSize();
                bCi();
                bCj();
            } else {
                if (w.gZ(text) > 20) {
                    text = w.E(text, 20);
                    this.gSC.setText(text);
                    this.gSB.setText(text);
                }
                ui(text);
            }
        }
        this.gSB.setIncludeFontPadding(false);
        this.gSC.setIncludeFontPadding(false);
        this.gSB.setLineSpacing(this.gTd, 1.0f);
        this.gSC.setLineSpacing(this.gTd, 1.0f);
        this.gSz.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gSz.getLayoutParams();
        layoutParams3.height = (this.gTa * 2) + i2;
        layoutParams3.width = (this.gTa * 2) + i;
        this.gSz.setLayoutParams(layoutParams3);
        this.gTf = (this.gTa * 2) + i;
        ((FrameLayout.LayoutParams) this.gSA.getLayoutParams()).setMargins(this.gTa, this.gTa, this.gTa, this.gTa);
        this.gSz.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bCk();
        }
        return this.mTempBitmap;
    }

    private void bCk() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bCl() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nF(boolean z) {
        if (this.gSF != 0) {
            if (z) {
                bCl();
                this.gSz.setVisibility(0);
                return;
            }
            bkv();
            getTempBitmap();
            this.gSz.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gTg.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gTg.clear();
        this.gTg = null;
        bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gTi;
        WeakReference<CoverPendantDragView> gTj;
        WeakReference<PendantData> gTk;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gTi = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gTj = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gTk = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cn(String str, String str2) {
            if (this.gTi != null && this.gTi.get() != null) {
                this.gTi.get().gRs.setVisibility(8);
            }
            if (this.gTj != null && this.gTj.get() != null && this.gTk != null && this.gTk.get() != null) {
                this.gTj.get().a(str2, this.gTk.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tW(String str) {
            if (this.gTi != null && this.gTi.get() != null) {
                this.gTi.get().gRs.setVisibility(8);
            }
            if (this.gTj != null && this.gTj.get() != null) {
                l.showToast(this.gTj.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bBm() {
            if (this.gTi != null && this.gTi.get() != null) {
                this.gTi.get().gRs.setVisibility(8);
            }
        }
    }
}
