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
    private float EP;
    private float bKz;
    private float cvM;
    private FrameLayout gSE;
    private RotateFrameLayout gSF;
    private TextView gSG;
    private EditText gSH;
    private ImageView gSI;
    private ImageView gSJ;
    private int gSK;
    private boolean gSL;
    private float gSM;
    private float gSN;
    private int gSO;
    private int gSP;
    private float gSQ;
    private float gSR;
    private float gSS;
    private float gST;
    private b gSU;
    private float gSV;
    private float gSW;
    private float gSX;
    private float gSY;
    private boolean gSZ;
    private float gTa;
    private int gTb;
    private int gTc;
    private int gTd;
    private int gTe;
    private int gTf;
    private float gTg;
    private float gTh;
    private int gTi;
    private float gTj;
    private int gTk;
    private Map<String, Bitmap> gTl;
    private float gak;
    float gwb;
    float gwc;
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
        this.gSK = 0;
        this.gST = 1.0f;
        this.gak = 1.0f;
        this.gSZ = true;
        this.gTl = new HashMap();
        this.startTime = 0L;
        this.gwb = 0.0f;
        this.gwc = 0.0f;
        this.mScreenWidth = l.ac(TbadkCoreApplication.getInst());
        this.gTa = l.f(getContext(), d.e.fontsize40);
        this.gTi = l.f(getContext(), d.e.ds2);
        this.cvM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gSE = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gSE);
        this.gSE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.f(view, motionEvent);
                        if (CoverPendantDragView.this.gSK == 4) {
                            CoverPendantDragView.this.bCi();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.EP);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bKz);
                        if (!CoverPendantDragView.this.gSL && abs < CoverPendantDragView.this.cvM && abs2 < CoverPendantDragView.this.cvM && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bCj();
                        }
                        CoverPendantDragView.this.gSM = 0.0f;
                        CoverPendantDragView.this.gSN = 0.0f;
                        CoverPendantDragView.this.gSL = false;
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
                        CoverPendantDragView.this.gSM = 0.0f;
                        CoverPendantDragView.this.gSN = 0.0f;
                        return true;
                }
            }
        });
        this.gSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gSH.setText("");
                CoverPendantDragView.this.bkv();
            }
        });
        this.gSJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.f(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gSN = 0.0f;
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
        this.gSH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gSK != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gSG.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.gZ(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gSG.getText().length()) {
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
                CoverPendantDragView.this.gSG.setText(editable.toString());
            }
        });
        this.gSH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gSE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, MotionEvent motionEvent) {
        this.EP = motionEvent.getRawX();
        this.bKz = motionEvent.getRawY();
        this.mLastX = this.EP;
        this.mLastY = this.bKz;
        this.gSQ = (this.gSE.getWidth() / 2) + this.gSE.getX();
        this.gSR = (this.gSE.getHeight() / 2) + this.gSE.getY();
        this.gSG.setText(this.gSH.getText());
        this.gSG.setVisibility(0);
        this.gSH.setVisibility(8);
        setEditTextEnable(false);
        this.gSU.HidenSoftKeyPad(this.gSH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        TextPaint paint = this.gSH.getPaint();
        float measureText = paint.measureText(str);
        while (this.gSH.getLineCount() == 1 && this.gSH.getTextSize() < this.gTa * this.gak && measureText < this.gTh * this.gak) {
            setTextSize(0, this.gSH.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.gZ(str) <= w.gZ(getResources().getString(d.j.cover_hint)) && this.gSH.getTextSize() != this.gTa * this.gak) {
            setTextSize(0, this.gTa * this.gak);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(String str) {
        TextPaint paint = this.gSH.getPaint();
        float measureText = paint.measureText(str);
        while (this.gSH.getTextSize() > ((this.gTg * this.gak) / 2.0f) - (this.gTj * this.gak) && measureText > this.gTh * this.gak) {
            setTextSize(0, this.gSH.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.gSH.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gSH.getTextSize() - 1.0f);
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
        this.gSU = bVar;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.gSV = f;
        this.gSW = f2;
        this.gSX = f3;
        this.gSY = f4;
        if (this.gSV > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gSV, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gSW > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gSW);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gSX > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gSX) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gSY > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gSY) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.gSQ - rawX);
        float abs4 = Math.abs(this.gSR - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gSQ - this.mLastX);
        float abs6 = Math.abs(this.gSR - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cb(sqrt, (int) (sqrt / this.gSS));
        if (this.gSN != 0.0f) {
            this.gSE.setRotation(this.gSE.getRotation() - (this.gSN - L));
        }
        this.gSN = L;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cb(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSE.getLayoutParams();
        int width = this.gSE.getWidth() - i;
        int i3 = (int) (width / this.gSS);
        if (width < this.gSO) {
            width = this.gSO;
            i3 = (int) (width / this.gSS);
        }
        this.gak = ((width * 1.0f) - (this.gTf * 2)) / (this.gTk - (this.gTf * 2));
        this.mContentView.setPadding((int) (this.gTb * this.gak), (int) (this.gTc * this.gak), (int) (this.gTd * this.gak), (int) (this.gTe * this.gak));
        setTextSize(0, (this.gSH.getTextSize() * i3) / this.gSE.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gSE.setLayoutParams(layoutParams);
        float f = this.gSQ - (layoutParams.width / 2);
        float f2 = this.gSR - (layoutParams.height / 2);
        this.gSE.setX(f);
        this.gSE.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gSK != 4) {
            float y = (this.gSE.getY() + rawY) - this.mLastY;
            if (y < this.gSW) {
                y = this.gSW;
            } else if (y > (this.gSW + this.mVideoHeight) - this.gSE.getHeight()) {
                y = (this.gSW + this.mVideoHeight) - this.gSE.getHeight();
            }
            this.gSE.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gSL = true;
                float M = M(motionEvent);
                float K = K(motionEvent);
                if (this.gSM != 0.0f) {
                    int i = (int) (this.gSM - M);
                    cb(i, (int) (i / this.gSS));
                }
                if (this.gSN != 0.0f) {
                    this.gSE.setRotation(this.gSE.getRotation() - (this.gSN - K));
                }
                this.gSN = K;
                this.gSM = M;
            } else if (!this.gSL && pointerCount == 1) {
                float y2 = (this.gSE.getY() + rawY) - this.mLastY;
                if (y2 < this.gSW - (this.gSE.getHeight() / 2)) {
                    y2 = this.gSW - (this.gSE.getHeight() / 2);
                } else if (y2 > ((this.gSW + this.mVideoHeight) - this.gSE.getHeight()) + (this.gSE.getHeight() / 2)) {
                    y2 = ((this.gSW + this.mVideoHeight) - this.gSE.getHeight()) + (this.gSE.getHeight() / 2);
                }
                float x = (this.gSE.getX() + rawX) - this.mLastX;
                if (x < this.gSV - (this.gSE.getWidth() / 2)) {
                    x = this.gSV - (this.gSE.getWidth() / 2);
                } else if (x > ((this.gSV + this.mVideoWidth) - this.gSE.getWidth()) + (this.gSE.getWidth() / 2)) {
                    x = ((this.gSV + this.mVideoWidth) - this.gSE.getWidth()) + (this.gSE.getWidth() / 2);
                }
                this.gSE.setX(x);
                this.gSE.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gSH.getTextSize() != f) {
            this.gSH.setTextSize(i, f);
        }
        if (this.gSG.getTextSize() != f) {
            this.gSG.setTextSize(i, f);
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
        matrix.postRotate(this.gSE.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float L(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gSR - motionEvent.getRawY(), this.gSQ - motionEvent.getRawX()));
    }

    private float M(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cvM && Math.abs(motionEvent.getRawY() - this.bKz) < this.cvM;
    }

    private void init() {
        this.gSF = (RotateFrameLayout) this.gSE.findViewById(d.g.content_container);
        this.gSG = (TextView) this.gSE.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gSE.findViewById(d.g.content_view);
        this.gSH = (EditText) this.gSE.findViewById(d.g.cover_edit);
        this.gSI = (ImageView) this.gSE.findViewById(d.g.cover_delete);
        this.gSJ = (ImageView) this.gSE.findViewById(d.g.cover_scale);
    }

    public void bkv() {
        this.gSG.setText(this.gSH.getText());
        this.gSG.setVisibility(0);
        this.gSH.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gSG.getText())) {
            this.gSK = 0;
            this.gSE.setVisibility(8);
        }
        if (this.gSK == 4) {
            bCh();
        }
        this.gSU.HidenSoftKeyPad(this.gSH);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gSH.setFocusable(true);
            this.gSH.setFocusableInTouchMode(true);
            this.gSH.requestFocus();
            return;
        }
        this.gSH.setFocusable(false);
        this.gSH.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gSH.setText("");
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
                            bVar.gRx.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bCc().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(ug, pendantData);
                        break;
                    }
                    break;
            }
            this.gSK = pendantData.pendantType;
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
        if (this.gSK == 4 || this.gSK == 0) {
            this.gSE.setX(this.gSV);
            this.gSE.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.gSW);
            String obj = this.gSH.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gSH.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gSG.setText(a2);
                    this.gSH.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bCh() {
        if (this.gSZ) {
            this.gSZ = false;
            this.gSI.setVisibility(8);
            this.gSJ.setVisibility(8);
            this.gSF.setBackgroundColor(getResources().getColor(d.C0095d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCi() {
        if (!this.gSZ) {
            this.gSZ = true;
            this.gSI.setVisibility(0);
            this.gSJ.setVisibility(0);
            this.gSF.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.gTl.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gTl.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bCh();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gST = 1.0f;
                this.gak = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gST = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gSO = (this.gTf * 2) + width;
                this.gSP = (this.gTf * 2) + height;
                this.gSS = (this.gSO * 1.0f) / this.gSP;
                this.gSE.setX((((this.mVideoWidth - i2) - (this.gTf * 2)) / 2) + this.gSV);
                this.gSE.setY((((this.mVideoHeight - i) - (this.gTf * 2)) / 2) + this.gSW);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gwb = motionEvent.getRawX();
                this.gwc = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gwb);
                float abs2 = Math.abs(rawY - this.gwc);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cvM && abs2 < this.cvM && System.currentTimeMillis() - this.startTime < 300) {
                    bkv();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gSG == null || this.gSG.getText() == null) {
            return null;
        }
        return this.gSG.getText().toString();
    }

    public void bCj() {
        this.gSG.setText(this.gSH.getText());
        this.gSG.setVisibility(8);
        this.gSH.setVisibility(0);
        setEditTextEnable(true);
        this.gSU.ShowSoftKeyPad(this.gSH);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gSH.setTextAppearance(getContext(), d.k.cover_text_style);
            this.gSG.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.gTf = 0;
            this.gSH.setMaxLines(1);
            this.gSG.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSG.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gSH.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.gSH.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gSG.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gTf = l.f(getContext(), d.e.ds40);
            this.gSH.setMaxLines(2);
            this.gSG.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gSG.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gSH.setLayoutParams(layoutParams2);
            this.gTb = (int) (l.dip2px(getContext(), pendantData.left) * this.gST);
            this.gTc = (int) (l.dip2px(getContext(), pendantData.top) * this.gST);
            this.gTd = (int) (l.dip2px(getContext(), pendantData.right) * this.gST);
            this.gTe = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gST);
            this.mContentView.setPadding(this.gTb, this.gTc, this.gTd, this.gTe);
            this.gTa = l.f(getContext(), d.e.fontsize40) * this.gST;
            String text = getText();
            this.gTg = (i2 - this.gTc) - this.gTe;
            this.gTh = (i - this.gTb) - this.gTd;
            this.gTj = this.gTi + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.gTa);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.gTh);
                this.gTa = this.gSH.getTextSize();
                bCi();
                bCj();
            } else {
                if (w.gZ(text) > 20) {
                    text = w.E(text, 20);
                    this.gSH.setText(text);
                    this.gSG.setText(text);
                }
                ui(text);
            }
        }
        this.gSG.setIncludeFontPadding(false);
        this.gSH.setIncludeFontPadding(false);
        this.gSG.setLineSpacing(this.gTi, 1.0f);
        this.gSH.setLineSpacing(this.gTi, 1.0f);
        this.gSE.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gSE.getLayoutParams();
        layoutParams3.height = (this.gTf * 2) + i2;
        layoutParams3.width = (this.gTf * 2) + i;
        this.gSE.setLayoutParams(layoutParams3);
        this.gTk = (this.gTf * 2) + i;
        ((FrameLayout.LayoutParams) this.gSF.getLayoutParams()).setMargins(this.gTf, this.gTf, this.gTf, this.gTf);
        this.gSE.setVisibility(0);
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
        if (this.gSK != 0) {
            if (z) {
                bCl();
                this.gSE.setVisibility(0);
                return;
            }
            bkv();
            getTempBitmap();
            this.gSE.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gTl.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gTl.clear();
        this.gTl = null;
        bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gTn;
        WeakReference<CoverPendantDragView> gTo;
        WeakReference<PendantData> gTp;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gTn = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gTo = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gTp = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cn(String str, String str2) {
            if (this.gTn != null && this.gTn.get() != null) {
                this.gTn.get().gRx.setVisibility(8);
            }
            if (this.gTo != null && this.gTo.get() != null && this.gTp != null && this.gTp.get() != null) {
                this.gTo.get().a(str2, this.gTp.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tW(String str) {
            if (this.gTn != null && this.gTn.get() != null) {
                this.gTn.get().gRx.setVisibility(8);
            }
            if (this.gTo != null && this.gTo.get() != null) {
                l.showToast(this.gTo.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bBm() {
            if (this.gTn != null && this.gTn.get() != null) {
                this.gTn.get().gRx.setVisibility(8);
            }
        }
    }
}
