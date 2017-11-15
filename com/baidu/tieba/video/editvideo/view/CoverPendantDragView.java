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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float EP;
    private float bCr;
    private float cmM;
    private float fOq;
    private FrameLayout gFN;
    private RotateFrameLayout gFO;
    private TextView gFP;
    private EditText gFQ;
    private ImageView gFR;
    private ImageView gFS;
    private int gFT;
    private boolean gFU;
    private float gFV;
    private float gFW;
    private int gFX;
    private int gFY;
    private float gFZ;
    private float gGa;
    private float gGb;
    private float gGc;
    private b gGd;
    private float gGe;
    private float gGf;
    private float gGg;
    private float gGh;
    private boolean gGi;
    private float gGj;
    private int gGk;
    private int gGl;
    private int gGm;
    private int gGn;
    private int gGo;
    private float gGp;
    private float gGq;
    private int gGr;
    private float gGs;
    private int gGt;
    private Map<String, Bitmap> gGu;
    float gky;
    float gkz;
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
        this.gFT = 0;
        this.gGc = 1.0f;
        this.fOq = 1.0f;
        this.gGi = true;
        this.gGu = new HashMap();
        this.startTime = 0L;
        this.gky = 0.0f;
        this.gkz = 0.0f;
        this.mScreenWidth = l.ac(TbadkCoreApplication.getInst());
        this.gGj = l.f(getContext(), d.e.fontsize40);
        this.gGr = l.f(getContext(), d.e.ds2);
        this.cmM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gFN = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gFN);
        this.gFN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.f(view, motionEvent);
                        if (CoverPendantDragView.this.gFT == 4) {
                            CoverPendantDragView.this.bzl();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.EP);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bCr);
                        if (!CoverPendantDragView.this.gFU && abs < CoverPendantDragView.this.cmM && abs2 < CoverPendantDragView.this.cmM && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bzm();
                        }
                        CoverPendantDragView.this.gFV = 0.0f;
                        CoverPendantDragView.this.gFW = 0.0f;
                        CoverPendantDragView.this.gFU = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.v(motionEvent)) {
                            CoverPendantDragView.this.F(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.gFV = 0.0f;
                        CoverPendantDragView.this.gFW = 0.0f;
                        return true;
                }
            }
        });
        this.gFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gFQ.setText("");
                CoverPendantDragView.this.bin();
            }
        });
        this.gFS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.f(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gFW = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.v(motionEvent)) {
                            CoverPendantDragView.this.E(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.gFQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gFT != 4) {
                    String a = CoverPendantDragView.this.a(CoverPendantDragView.this.gFP.getPaint(), obj);
                    if (!a.equals(obj)) {
                        editable.delete(a.length() + obj.lastIndexOf(a), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.gY(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gFP.getText().length()) {
                        CoverPendantDragView.this.ts(obj);
                    } else {
                        CoverPendantDragView.this.tr(obj);
                    }
                } else {
                    String E = w.E(obj, 20);
                    editable.delete(obj.lastIndexOf(E) + E.length(), obj.length());
                    CoverPendantDragView.this.ts(E);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gFP.setText(editable.toString());
            }
        });
        this.gFQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gFN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, MotionEvent motionEvent) {
        this.EP = motionEvent.getRawX();
        this.bCr = motionEvent.getRawY();
        this.mLastX = this.EP;
        this.mLastY = this.bCr;
        this.gFZ = (this.gFN.getWidth() / 2) + this.gFN.getX();
        this.gGa = (this.gFN.getHeight() / 2) + this.gFN.getY();
        this.gFP.setText(this.gFQ.getText());
        this.gFP.setVisibility(0);
        this.gFQ.setVisibility(8);
        setEditTextEnable(false);
        this.gGd.HidenSoftKeyPad(this.gFQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(String str) {
        TextPaint paint = this.gFQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.gFQ.getLineCount() == 1 && this.gFQ.getTextSize() < this.gGj * this.fOq && measureText < this.gGq * this.fOq) {
            setTextSize(0, this.gFQ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.gY(str) <= w.gY(getResources().getString(d.j.cover_hint)) && this.gFQ.getTextSize() != this.gGj * this.fOq) {
            setTextSize(0, this.gGj * this.fOq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(String str) {
        TextPaint paint = this.gFQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.gFQ.getTextSize() > ((this.gGp * this.fOq) / 2.0f) - (this.gGs * this.fOq) && measureText > this.gGq * this.fOq) {
            setTextSize(0, this.gFQ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.gFQ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gFQ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), d.e.ds120)) {
            str = w.H(str, w.gX(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gGd = bVar;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.gGe = f;
        this.gGf = f2;
        this.gGg = f3;
        this.gGh = f4;
        if (this.gGe > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gGe, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gGf > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gGf);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gGg > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gGg) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gGh > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gGh) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float H = H(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.gFZ - rawX);
        float abs4 = Math.abs(this.gGa - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gFZ - this.mLastX);
        float abs6 = Math.abs(this.gGa - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bZ(sqrt, (int) (sqrt / this.gGb));
        if (this.gFW != 0.0f) {
            this.gFN.setRotation(this.gFN.getRotation() - (this.gFW - H));
        }
        this.gFW = H;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bZ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gFN.getLayoutParams();
        int width = this.gFN.getWidth() - i;
        int i3 = (int) (width / this.gGb);
        if (width < this.gFX) {
            width = this.gFX;
            i3 = (int) (width / this.gGb);
        }
        this.fOq = ((width * 1.0f) - (this.gGo * 2)) / (this.gGt - (this.gGo * 2));
        this.mContentView.setPadding((int) (this.gGk * this.fOq), (int) (this.gGl * this.fOq), (int) (this.gGm * this.fOq), (int) (this.gGn * this.fOq));
        setTextSize(0, (this.gFQ.getTextSize() * i3) / this.gFN.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gFN.setLayoutParams(layoutParams);
        float f = this.gFZ - (layoutParams.width / 2);
        float f2 = this.gGa - (layoutParams.height / 2);
        this.gFN.setX(f);
        this.gFN.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gFT != 4) {
            float y = (this.gFN.getY() + rawY) - this.mLastY;
            if (y < this.gGf) {
                y = this.gGf;
            } else if (y > (this.gGf + this.mVideoHeight) - this.gFN.getHeight()) {
                y = (this.gGf + this.mVideoHeight) - this.gFN.getHeight();
            }
            this.gFN.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gFU = true;
                float I = I(motionEvent);
                float G = G(motionEvent);
                if (this.gFV != 0.0f) {
                    int i = (int) (this.gFV - I);
                    bZ(i, (int) (i / this.gGb));
                }
                if (this.gFW != 0.0f) {
                    this.gFN.setRotation(this.gFN.getRotation() - (this.gFW - G));
                }
                this.gFW = G;
                this.gFV = I;
            } else if (!this.gFU && pointerCount == 1) {
                float y2 = (this.gFN.getY() + rawY) - this.mLastY;
                if (y2 < this.gGf - (this.gFN.getHeight() / 2)) {
                    y2 = this.gGf - (this.gFN.getHeight() / 2);
                } else if (y2 > ((this.gGf + this.mVideoHeight) - this.gFN.getHeight()) + (this.gFN.getHeight() / 2)) {
                    y2 = ((this.gGf + this.mVideoHeight) - this.gFN.getHeight()) + (this.gFN.getHeight() / 2);
                }
                float x = (this.gFN.getX() + rawX) - this.mLastX;
                if (x < this.gGe - (this.gFN.getWidth() / 2)) {
                    x = this.gGe - (this.gFN.getWidth() / 2);
                } else if (x > ((this.gGe + this.mVideoWidth) - this.gFN.getWidth()) + (this.gFN.getWidth() / 2)) {
                    x = ((this.gGe + this.mVideoWidth) - this.gFN.getWidth()) + (this.gFN.getWidth() / 2);
                }
                this.gFN.setX(x);
                this.gFN.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gFQ.getTextSize() != f) {
            this.gFQ.setTextSize(i, f);
        }
        if (this.gFP.getTextSize() != f) {
            this.gFP.setTextSize(i, f);
        }
    }

    private float G(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.gFN.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float H(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gGa - motionEvent.getRawY(), this.gFZ - motionEvent.getRawX()));
    }

    private float I(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmM && Math.abs(motionEvent.getRawY() - this.bCr) < this.cmM;
    }

    private void init() {
        this.gFO = (RotateFrameLayout) this.gFN.findViewById(d.g.content_container);
        this.gFP = (TextView) this.gFN.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gFN.findViewById(d.g.content_view);
        this.gFQ = (EditText) this.gFN.findViewById(d.g.cover_edit);
        this.gFR = (ImageView) this.gFN.findViewById(d.g.cover_delete);
        this.gFS = (ImageView) this.gFN.findViewById(d.g.cover_scale);
    }

    public void bin() {
        this.gFP.setText(this.gFQ.getText());
        this.gFP.setVisibility(0);
        this.gFQ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gFP.getText())) {
            this.gFT = 0;
            this.gFN.setVisibility(8);
        }
        if (this.gFT == 4) {
            bzk();
        }
        this.gGd.HidenSoftKeyPad(this.gFQ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gFQ.setFocusable(true);
            this.gFQ.setFocusableInTouchMode(true);
            this.gFQ.requestFocus();
            return;
        }
        this.gFQ.setFocusable(false);
        this.gFQ.setFocusableInTouchMode(false);
    }

    public void a(View view, final PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gFQ.setText("");
                    bin();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bzm();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bzm();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bzm();
                    break;
                default:
                    bin();
                    String tq = com.baidu.tieba.video.editvideo.model.b.bzf().tq(pendantData.resource);
                    if (TextUtils.isEmpty(tq)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            final a.b bVar = (a.b) view.getTag();
                            bVar.gFi.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bzf().a(pendantData.id, pendantData.resource, new b.a() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.6
                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void cj(String str, String str2) {
                                    bVar.gFi.setVisibility(8);
                                    CoverPendantDragView.this.a(str2, pendantData);
                                }

                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void tl(String str) {
                                    bVar.gFi.setVisibility(8);
                                    l.showToast(CoverPendantDragView.this.getContext(), str);
                                }

                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void byC() {
                                    bVar.gFi.setVisibility(8);
                                }
                            });
                            break;
                        }
                    } else {
                        a(tq, pendantData);
                        break;
                    }
                    break;
            }
            this.gFT = pendantData.pendantType;
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
        bzk();
        a(this.mVideoWidth, l.f(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gFT == 4 || this.gFT == 0) {
            this.gFN.setX(this.gGe);
            this.gFN.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.gGf);
            String obj = this.gFQ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a = a(this.gFQ.getPaint(), obj);
                if (!a.equals(obj)) {
                    this.gFP.setText(a);
                    this.gFQ.setText(a);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bzk() {
        if (this.gGi) {
            this.gGi = false;
            this.gFR.setVisibility(8);
            this.gFS.setVisibility(8);
            this.gFO.setBackgroundColor(getResources().getColor(d.C0080d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzl() {
        if (!this.gGi) {
            this.gGi = true;
            this.gFR.setVisibility(0);
            this.gFS.setVisibility(0);
            this.gFO.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.gGu.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gGu.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bzk();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gGc = 1.0f;
                this.fOq = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gGc = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gFX = (this.gGo * 2) + width;
                this.gFY = (this.gGo * 2) + height;
                this.gGb = (this.gFX * 1.0f) / this.gFY;
                this.gFN.setX((((this.mVideoWidth - i2) - (this.gGo * 2)) / 2) + this.gGe);
                this.gFN.setY((((this.mVideoHeight - i) - (this.gGo * 2)) / 2) + this.gGf);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gky = motionEvent.getRawX();
                this.gkz = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gky);
                float abs2 = Math.abs(rawY - this.gkz);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cmM && abs2 < this.cmM && System.currentTimeMillis() - this.startTime < 300) {
                    bin();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gFP == null || this.gFP.getText() == null) {
            return null;
        }
        return this.gFP.getText().toString();
    }

    public void bzm() {
        this.gFP.setText(this.gFQ.getText());
        this.gFP.setVisibility(8);
        this.gFQ.setVisibility(0);
        setEditTextEnable(true);
        this.gGd.ShowSoftKeyPad(this.gFQ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gFQ.setTextAppearance(getContext(), d.k.cover_text_style);
            this.gFP.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.gGo = 0;
            this.gFQ.setMaxLines(1);
            this.gFP.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gFP.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gFQ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.gFQ.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gFP.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gGo = l.f(getContext(), d.e.ds40);
            this.gFQ.setMaxLines(2);
            this.gFP.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gFP.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gFQ.setLayoutParams(layoutParams2);
            this.gGk = (int) (l.dip2px(getContext(), pendantData.left) * this.gGc);
            this.gGl = (int) (l.dip2px(getContext(), pendantData.top) * this.gGc);
            this.gGm = (int) (l.dip2px(getContext(), pendantData.right) * this.gGc);
            this.gGn = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gGc);
            this.mContentView.setPadding(this.gGk, this.gGl, this.gGm, this.gGn);
            this.gGj = l.f(getContext(), d.e.fontsize40) * this.gGc;
            String text = getText();
            this.gGp = (i2 - this.gGl) - this.gGn;
            this.gGq = (i - this.gGk) - this.gGm;
            this.gGs = this.gGr + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.gGj);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.gGq);
                this.gGj = this.gFQ.getTextSize();
                bzl();
                bzm();
            } else {
                if (w.gY(text) > 20) {
                    text = w.E(text, 20);
                    this.gFQ.setText(text);
                    this.gFP.setText(text);
                }
                ts(text);
            }
        }
        this.gFP.setIncludeFontPadding(false);
        this.gFQ.setIncludeFontPadding(false);
        this.gFP.setLineSpacing(this.gGr, 1.0f);
        this.gFQ.setLineSpacing(this.gGr, 1.0f);
        this.gFN.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gFN.getLayoutParams();
        layoutParams3.height = (this.gGo * 2) + i2;
        layoutParams3.width = (this.gGo * 2) + i;
        this.gFN.setLayoutParams(layoutParams3);
        this.gGt = (this.gGo * 2) + i;
        ((FrameLayout.LayoutParams) this.gFO.getLayoutParams()).setMargins(this.gGo, this.gGo, this.gGo, this.gGo);
        this.gFN.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bzn();
        }
        return this.mTempBitmap;
    }

    private void bzn() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bzo() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void ne(boolean z) {
        if (this.gFT != 0) {
            if (z) {
                bzo();
                this.gFN.setVisibility(0);
                return;
            }
            bin();
            bzn();
            this.gFN.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gGu.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gGu.clear();
        this.gGu = null;
        bzo();
    }
}
