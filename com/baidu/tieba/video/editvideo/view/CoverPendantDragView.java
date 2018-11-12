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
    private float brF;
    float dEX;
    float dEY;
    private float dkI;
    private float gIW;
    private ImageView hvA;
    private ImageView hvB;
    private int hvC;
    private float hvD;
    private boolean hvE;
    private float hvF;
    private float hvG;
    private int hvH;
    private int hvI;
    private float hvJ;
    private float hvK;
    private float hvL;
    private float hvM;
    private b hvN;
    private float hvO;
    private float hvP;
    private float hvQ;
    private float hvR;
    private boolean hvS;
    private float hvT;
    private int hvU;
    private int hvV;
    private int hvW;
    private int hvX;
    private int hvY;
    private float hvZ;
    private FrameLayout hvw;
    private RotateFrameLayout hvx;
    private TextView hvy;
    private EditText hvz;
    private float hwa;
    private int hwb;
    private float hwc;
    private int hwd;
    private Map<String, Bitmap> hwe;
    private Bitmap hwf;
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
        this.hvC = 0;
        this.hvM = 1.0f;
        this.gIW = 1.0f;
        this.hvS = true;
        this.hwe = new HashMap();
        this.startTime = 0L;
        this.dEX = 0.0f;
        this.dEY = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hvT = l.h(getContext(), e.C0200e.fontsize40);
        this.hwb = l.h(getContext(), e.C0200e.ds2);
        this.dkI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hvw = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hvw);
        this.hvw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hvC == 4) {
                            CoverPendantDragView.this.bGQ();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.brF);
                        if (!CoverPendantDragView.this.hvE && abs < CoverPendantDragView.this.dkI && abs2 < CoverPendantDragView.this.dkI && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bGR();
                        }
                        CoverPendantDragView.this.hvF = 0.0f;
                        CoverPendantDragView.this.hvG = 0.0f;
                        CoverPendantDragView.this.hvE = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.G(motionEvent)) {
                            CoverPendantDragView.this.I(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.hvF = 0.0f;
                        CoverPendantDragView.this.hvG = 0.0f;
                        return true;
                }
            }
        });
        this.hvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hvz.setText("");
                CoverPendantDragView.this.bqY();
            }
        });
        this.hvB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hvG = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.G(motionEvent)) {
                            CoverPendantDragView.this.H(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.hvz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hvC != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hvy.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.iv(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hvy.getText().length()) {
                        CoverPendantDragView.this.wh(obj);
                    } else {
                        CoverPendantDragView.this.wg(obj);
                    }
                } else {
                    String H = y.H(obj, 20);
                    editable.delete(H.length(), obj.length());
                    CoverPendantDragView.this.wh(H);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hvy.setText(editable.toString());
            }
        });
        this.hvz.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hvw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.brF = motionEvent.getRawY();
        this.hvD = this.mDownX;
        this.mLastY = this.brF;
        this.hvJ = (this.hvw.getWidth() / 2) + this.hvw.getX();
        this.hvK = (this.hvw.getHeight() / 2) + this.hvw.getY();
        this.hvy.setText(this.hvz.getText());
        this.hvy.setVisibility(0);
        this.hvz.setVisibility(8);
        setEditTextEnable(false);
        this.hvN.HidenSoftKeyPad(this.hvz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(String str) {
        TextPaint paint = this.hvz.getPaint();
        float measureText = paint.measureText(str);
        while (this.hvz.getLineCount() == 1 && this.hvz.getTextSize() < this.hvT * this.gIW && measureText < this.hwa * this.gIW) {
            setTextSize(0, this.hvz.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.iv(str) <= y.iv(getResources().getString(e.j.cover_hint)) && this.hvz.getTextSize() != this.hvT * this.gIW) {
            setTextSize(0, this.hvT * this.gIW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(String str) {
        TextPaint paint = this.hvz.getPaint();
        float measureText = paint.measureText(str);
        while (this.hvz.getTextSize() > ((this.hvZ * this.gIW) / 2.0f) - (this.hwc * this.gIW) && measureText > this.hwa * this.gIW) {
            setTextSize(0, this.hvz.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hvz.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hvz.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0200e.ds120)) {
            str = y.J(str, y.iu(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hvN = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hvO = f;
        this.hvP = f2;
        this.hvQ = f3;
        this.hvR = f4;
        if (this.hvO > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hvO, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hvP > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hvP);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hvQ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hvQ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hvR > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hvR) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float K = K(motionEvent);
        float abs = Math.abs(this.hvD - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hvJ - rawX);
        float abs4 = Math.abs(this.hvK - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hvJ - this.hvD);
        float abs6 = Math.abs(this.hvK - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bX(sqrt, (int) (sqrt / this.hvL));
        if (this.hvG != 0.0f) {
            this.hvw.setRotation(this.hvw.getRotation() - (this.hvG - K));
        }
        this.hvG = K;
        this.hvD = rawX;
        this.mLastY = rawY;
    }

    private void bX(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvw.getLayoutParams();
        int width = this.hvw.getWidth() - i;
        int i3 = (int) (width / this.hvL);
        if (width < this.hvH) {
            width = this.hvH;
            i3 = (int) (width / this.hvL);
        }
        this.gIW = ((width * 1.0f) - (this.hvY * 2)) / (this.hwd - (this.hvY * 2));
        this.mContentView.setPadding((int) (this.hvU * this.gIW), (int) (this.hvV * this.gIW), (int) (this.hvW * this.gIW), (int) (this.hvX * this.gIW));
        setTextSize(0, (this.hvz.getTextSize() * i3) / this.hvw.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hvw.setLayoutParams(layoutParams);
        float f = this.hvJ - (layoutParams.width / 2);
        float f2 = this.hvK - (layoutParams.height / 2);
        this.hvw.setX(f);
        this.hvw.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hvC != 4) {
            float y = (this.hvw.getY() + rawY) - this.mLastY;
            if (y < this.hvP) {
                y = this.hvP;
            } else if (y > (this.hvP + this.mVideoHeight) - this.hvw.getHeight()) {
                y = (this.hvP + this.mVideoHeight) - this.hvw.getHeight();
            }
            this.hvw.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hvE = true;
                float L = L(motionEvent);
                float J = J(motionEvent);
                if (this.hvF != 0.0f) {
                    int i = (int) (this.hvF - L);
                    bX(i, (int) (i / this.hvL));
                }
                if (this.hvG != 0.0f) {
                    this.hvw.setRotation(this.hvw.getRotation() - (this.hvG - J));
                }
                this.hvG = J;
                this.hvF = L;
            } else if (!this.hvE && pointerCount == 1) {
                float y2 = (this.hvw.getY() + rawY) - this.mLastY;
                if (y2 < this.hvP - (this.hvw.getHeight() / 2)) {
                    y2 = this.hvP - (this.hvw.getHeight() / 2);
                } else if (y2 > ((this.hvP + this.mVideoHeight) - this.hvw.getHeight()) + (this.hvw.getHeight() / 2)) {
                    y2 = ((this.hvP + this.mVideoHeight) - this.hvw.getHeight()) + (this.hvw.getHeight() / 2);
                }
                float x = (this.hvw.getX() + rawX) - this.hvD;
                if (x < this.hvO - (this.hvw.getWidth() / 2)) {
                    x = this.hvO - (this.hvw.getWidth() / 2);
                } else if (x > ((this.hvO + this.mVideoWidth) - this.hvw.getWidth()) + (this.hvw.getWidth() / 2)) {
                    x = ((this.hvO + this.mVideoWidth) - this.hvw.getWidth()) + (this.hvw.getWidth() / 2);
                }
                this.hvw.setX(x);
                this.hvw.setY(y2);
            }
        }
        this.hvD = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hvz.getTextSize() != f) {
            this.hvz.setTextSize(i, f);
        }
        if (this.hvy.getTextSize() != f) {
            this.hvy.setTextSize(i, f);
        }
    }

    private float J(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.hvw.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float K(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hvK - motionEvent.getRawY(), this.hvJ - motionEvent.getRawX()));
    }

    private float L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dkI && Math.abs(motionEvent.getRawY() - this.brF) < this.dkI;
    }

    private void init() {
        this.hvx = (RotateFrameLayout) this.hvw.findViewById(e.g.content_container);
        this.hvy = (TextView) this.hvw.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hvw.findViewById(e.g.content_view);
        this.hvz = (EditText) this.hvw.findViewById(e.g.cover_edit);
        this.hvA = (ImageView) this.hvw.findViewById(e.g.cover_delete);
        this.hvB = (ImageView) this.hvw.findViewById(e.g.cover_scale);
    }

    public void bqY() {
        this.hvy.setText(this.hvz.getText());
        this.hvy.setVisibility(0);
        this.hvz.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hvy.getText())) {
            this.hvC = 0;
            this.hvw.setVisibility(8);
        }
        if (this.hvC == 4) {
            bGP();
        }
        this.hvN.HidenSoftKeyPad(this.hvz);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hvz.setFocusable(true);
            this.hvz.setFocusableInTouchMode(true);
            this.hvz.requestFocus();
            return;
        }
        this.hvz.setFocusable(false);
        this.hvz.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hvz.setText("");
                    bqY();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bGR();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bGR();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bGR();
                    break;
                default:
                    bqY();
                    String wf = com.baidu.tieba.video.editvideo.model.b.bGK().wf(pendantData.resource);
                    if (TextUtils.isEmpty(wf)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hur.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bGK().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(wf, pendantData);
                        break;
                    }
                    break;
            }
            this.hvC = pendantData.pendantType;
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
        bGP();
        a(this.mVideoWidth, l.h(getContext(), e.C0200e.ds100), this.mScreenWidth, pendantData);
        if (this.hvC == 4 || this.hvC == 0) {
            this.hvw.setX(this.hvO);
            this.hvw.setY(((this.mVideoHeight - l.h(getContext(), e.C0200e.ds100)) / 2) + this.hvP);
            String obj = this.hvz.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hvz.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hvy.setText(a2);
                    this.hvz.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bGP() {
        if (this.hvS) {
            this.hvS = false;
            this.hvA.setVisibility(8);
            this.hvB.setVisibility(8);
            this.hvx.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGQ() {
        if (!this.hvS) {
            this.hvS = true;
            this.hvA.setVisibility(0);
            this.hvB.setVisibility(0);
            this.hvx.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hwe != null) {
            Bitmap bitmap = this.hwe.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hwe.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bGP();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hvM = 1.0f;
                this.gIW = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hvM = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hvH = (this.hvY * 2) + width;
                this.hvI = (this.hvY * 2) + height;
                this.hvL = (this.hvH * 1.0f) / this.hvI;
                this.hvw.setX((((this.mVideoWidth - i2) - (this.hvY * 2)) / 2) + this.hvO);
                this.hvw.setY((((this.mVideoHeight - i) - (this.hvY * 2)) / 2) + this.hvP);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dEX = motionEvent.getRawX();
                this.dEY = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dEX);
                float abs2 = Math.abs(rawY - this.dEY);
                if (motionEvent.getPointerCount() <= 1 && abs < this.dkI && abs2 < this.dkI && System.currentTimeMillis() - this.startTime < 300) {
                    bqY();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hvy == null || this.hvy.getText() == null) {
            return null;
        }
        return this.hvy.getText().toString();
    }

    public void bGR() {
        this.hvy.setText(this.hvz.getText());
        this.hvy.setVisibility(8);
        this.hvz.setVisibility(0);
        setEditTextEnable(true);
        this.hvN.ShowSoftKeyPad(this.hvz);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hvz.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hvy.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0200e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0200e.fontsize40) * i) / i3);
            this.hvY = 0;
            this.hvz.setMaxLines(1);
            this.hvy.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvy.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hvz.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0200e.ds60), 0, l.h(getContext(), e.C0200e.ds60), 0);
        } else {
            this.hvz.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hvy.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hvY = l.h(getContext(), e.C0200e.ds40);
            this.hvz.setMaxLines(2);
            this.hvy.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hvy.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hvz.setLayoutParams(layoutParams2);
            this.hvU = (int) (l.dip2px(getContext(), pendantData.left) * this.hvM);
            this.hvV = (int) (l.dip2px(getContext(), pendantData.top) * this.hvM);
            this.hvW = (int) (l.dip2px(getContext(), pendantData.right) * this.hvM);
            this.hvX = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hvM);
            this.mContentView.setPadding(this.hvU, this.hvV, this.hvW, this.hvX);
            this.hvT = l.h(getContext(), e.C0200e.fontsize40) * this.hvM;
            String text = getText();
            this.hvZ = (i2 - this.hvV) - this.hvX;
            this.hwa = (i - this.hvU) - this.hvW;
            this.hwc = this.hwb + l.h(getContext(), e.C0200e.ds6);
            setTextSize(0, this.hvT);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hwa);
                this.hvT = this.hvz.getTextSize();
                bGQ();
                bGR();
            } else {
                if (y.iv(text) > 20) {
                    text = y.H(text, 20);
                    this.hvz.setText(text);
                    this.hvy.setText(text);
                }
                wh(text);
            }
        }
        this.hvy.setIncludeFontPadding(false);
        this.hvz.setIncludeFontPadding(false);
        this.hvy.setLineSpacing(this.hwb, 1.0f);
        this.hvz.setLineSpacing(this.hwb, 1.0f);
        this.hvw.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hvw.getLayoutParams();
        layoutParams3.height = (this.hvY * 2) + i2;
        layoutParams3.width = (this.hvY * 2) + i;
        this.hvw.setLayoutParams(layoutParams3);
        this.hwd = (this.hvY * 2) + i;
        ((FrameLayout.LayoutParams) this.hvx.getLayoutParams()).setMargins(this.hvY, this.hvY, this.hvY, this.hvY);
        this.hvw.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hwf == null) {
            bGS();
        }
        return this.hwf;
    }

    private void bGS() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hwf = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bGT() {
        if (this.hwf != null && !this.hwf.isRecycled()) {
            this.hwf.recycle();
            this.hwf = null;
        }
    }

    public void nV(boolean z) {
        if (this.hvC != 0) {
            if (z) {
                bGT();
                this.hvw.setVisibility(0);
                return;
            }
            bqY();
            getTempBitmap();
            this.hvw.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hwe.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hwe.clear();
        this.hwe = null;
        bGT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hwh;
        WeakReference<CoverPendantDragView> hwi;
        WeakReference<PendantData> hwj;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hwh = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hwi = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hwj = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cM(String str, String str2) {
            if (this.hwh != null && this.hwh.get() != null) {
                this.hwh.get().hur.setVisibility(8);
            }
            if (this.hwi != null && this.hwi.get() != null && this.hwj != null && this.hwj.get() != null) {
                this.hwi.get().a(str2, this.hwj.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void vW(String str) {
            if (this.hwh != null && this.hwh.get() != null) {
                this.hwh.get().hur.setVisibility(8);
            }
            if (this.hwi != null && this.hwi.get() != null) {
                l.showToast(this.hwi.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bFV() {
            if (this.hwh != null && this.hwh.get() != null) {
                this.hwh.get().hur.setVisibility(8);
            }
        }
    }
}
