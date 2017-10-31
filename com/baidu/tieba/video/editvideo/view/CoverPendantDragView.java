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
    private float bCe;
    private float cmt;
    private float fNr;
    private FrameLayout gEF;
    private RotateFrameLayout gEG;
    private TextView gEH;
    private EditText gEI;
    private ImageView gEJ;
    private ImageView gEK;
    private int gEL;
    private boolean gEM;
    private float gEN;
    private float gEO;
    private int gEP;
    private int gEQ;
    private float gER;
    private float gES;
    private float gET;
    private float gEU;
    private b gEV;
    private float gEW;
    private float gEX;
    private float gEY;
    private float gEZ;
    private boolean gFa;
    private float gFb;
    private int gFc;
    private int gFd;
    private int gFe;
    private int gFf;
    private int gFg;
    private float gFh;
    private float gFi;
    private int gFj;
    private float gFk;
    private int gFl;
    private Map<String, Bitmap> gFm;
    float gjw;
    float gjx;
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
        this.gEL = 0;
        this.gEU = 1.0f;
        this.fNr = 1.0f;
        this.gFa = true;
        this.gFm = new HashMap();
        this.startTime = 0L;
        this.gjw = 0.0f;
        this.gjx = 0.0f;
        this.mScreenWidth = l.ac(TbadkCoreApplication.getInst());
        this.gFb = l.f(getContext(), d.e.fontsize40);
        this.gFj = l.f(getContext(), d.e.ds2);
        this.cmt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gEF = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gEF);
        this.gEF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.f(view, motionEvent);
                        if (CoverPendantDragView.this.gEL == 4) {
                            CoverPendantDragView.this.byZ();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.EP);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bCe);
                        if (!CoverPendantDragView.this.gEM && abs < CoverPendantDragView.this.cmt && abs2 < CoverPendantDragView.this.cmt && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bza();
                        }
                        CoverPendantDragView.this.gEN = 0.0f;
                        CoverPendantDragView.this.gEO = 0.0f;
                        CoverPendantDragView.this.gEM = false;
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
                        CoverPendantDragView.this.gEN = 0.0f;
                        CoverPendantDragView.this.gEO = 0.0f;
                        return true;
                }
            }
        });
        this.gEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gEI.setText("");
                CoverPendantDragView.this.bic();
            }
        });
        this.gEK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.f(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gEO = 0.0f;
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
        this.gEI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gEL != 4) {
                    String a = CoverPendantDragView.this.a(CoverPendantDragView.this.gEH.getPaint(), obj);
                    if (!a.equals(obj)) {
                        editable.delete(a.length() + obj.lastIndexOf(a), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.gX(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gEH.getText().length()) {
                        CoverPendantDragView.this.tm(obj);
                    } else {
                        CoverPendantDragView.this.tl(obj);
                    }
                } else {
                    String E = w.E(obj, 20);
                    editable.delete(obj.lastIndexOf(E) + E.length(), obj.length());
                    CoverPendantDragView.this.tm(E);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gEH.setText(editable.toString());
            }
        });
        this.gEI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gEF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, MotionEvent motionEvent) {
        this.EP = motionEvent.getRawX();
        this.bCe = motionEvent.getRawY();
        this.mLastX = this.EP;
        this.mLastY = this.bCe;
        this.gER = (this.gEF.getWidth() / 2) + this.gEF.getX();
        this.gES = (this.gEF.getHeight() / 2) + this.gEF.getY();
        this.gEH.setText(this.gEI.getText());
        this.gEH.setVisibility(0);
        this.gEI.setVisibility(8);
        setEditTextEnable(false);
        this.gEV.HidenSoftKeyPad(this.gEI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(String str) {
        TextPaint paint = this.gEI.getPaint();
        float measureText = paint.measureText(str);
        while (this.gEI.getLineCount() == 1 && this.gEI.getTextSize() < this.gFb * this.fNr && measureText < this.gFi * this.fNr) {
            setTextSize(0, this.gEI.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.gX(str) <= w.gX(getResources().getString(d.j.cover_hint)) && this.gEI.getTextSize() != this.gFb * this.fNr) {
            setTextSize(0, this.gFb * this.fNr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm(String str) {
        TextPaint paint = this.gEI.getPaint();
        float measureText = paint.measureText(str);
        while (this.gEI.getTextSize() > ((this.gFh * this.fNr) / 2.0f) - (this.gFk * this.fNr) && measureText > this.gFi * this.fNr) {
            setTextSize(0, this.gEI.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.gEI.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gEI.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), d.e.ds120)) {
            str = w.H(str, w.gW(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gEV = bVar;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.gEW = f;
        this.gEX = f2;
        this.gEY = f3;
        this.gEZ = f4;
        if (this.gEW > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gEW, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gEX > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gEX);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gEY > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gEY) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gEZ > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gEZ) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.gER - rawX);
        float abs4 = Math.abs(this.gES - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gER - this.mLastX);
        float abs6 = Math.abs(this.gES - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        ca(sqrt, (int) (sqrt / this.gET));
        if (this.gEO != 0.0f) {
            this.gEF.setRotation(this.gEF.getRotation() - (this.gEO - H));
        }
        this.gEO = H;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void ca(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEF.getLayoutParams();
        int width = this.gEF.getWidth() - i;
        int i3 = (int) (width / this.gET);
        if (width < this.gEP) {
            width = this.gEP;
            i3 = (int) (width / this.gET);
        }
        this.fNr = ((width * 1.0f) - (this.gFg * 2)) / (this.gFl - (this.gFg * 2));
        this.mContentView.setPadding((int) (this.gFc * this.fNr), (int) (this.gFd * this.fNr), (int) (this.gFe * this.fNr), (int) (this.gFf * this.fNr));
        setTextSize(0, (this.gEI.getTextSize() * i3) / this.gEF.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gEF.setLayoutParams(layoutParams);
        float f = this.gER - (layoutParams.width / 2);
        float f2 = this.gES - (layoutParams.height / 2);
        this.gEF.setX(f);
        this.gEF.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gEL != 4) {
            float y = (this.gEF.getY() + rawY) - this.mLastY;
            if (y < this.gEX) {
                y = this.gEX;
            } else if (y > (this.gEX + this.mVideoHeight) - this.gEF.getHeight()) {
                y = (this.gEX + this.mVideoHeight) - this.gEF.getHeight();
            }
            this.gEF.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gEM = true;
                float I = I(motionEvent);
                float G = G(motionEvent);
                if (this.gEN != 0.0f) {
                    int i = (int) (this.gEN - I);
                    ca(i, (int) (i / this.gET));
                }
                if (this.gEO != 0.0f) {
                    this.gEF.setRotation(this.gEF.getRotation() - (this.gEO - G));
                }
                this.gEO = G;
                this.gEN = I;
            } else if (!this.gEM && pointerCount == 1) {
                float y2 = (this.gEF.getY() + rawY) - this.mLastY;
                if (y2 < this.gEX - (this.gEF.getHeight() / 2)) {
                    y2 = this.gEX - (this.gEF.getHeight() / 2);
                } else if (y2 > ((this.gEX + this.mVideoHeight) - this.gEF.getHeight()) + (this.gEF.getHeight() / 2)) {
                    y2 = ((this.gEX + this.mVideoHeight) - this.gEF.getHeight()) + (this.gEF.getHeight() / 2);
                }
                float x = (this.gEF.getX() + rawX) - this.mLastX;
                if (x < this.gEW - (this.gEF.getWidth() / 2)) {
                    x = this.gEW - (this.gEF.getWidth() / 2);
                } else if (x > ((this.gEW + this.mVideoWidth) - this.gEF.getWidth()) + (this.gEF.getWidth() / 2)) {
                    x = ((this.gEW + this.mVideoWidth) - this.gEF.getWidth()) + (this.gEF.getWidth() / 2);
                }
                this.gEF.setX(x);
                this.gEF.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gEI.getTextSize() != f) {
            this.gEI.setTextSize(i, f);
        }
        if (this.gEH.getTextSize() != f) {
            this.gEH.setTextSize(i, f);
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
        matrix.postRotate(this.gEF.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float H(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gES - motionEvent.getRawY(), this.gER - motionEvent.getRawX()));
    }

    private float I(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmt && Math.abs(motionEvent.getRawY() - this.bCe) < this.cmt;
    }

    private void init() {
        this.gEG = (RotateFrameLayout) this.gEF.findViewById(d.g.content_container);
        this.gEH = (TextView) this.gEF.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gEF.findViewById(d.g.content_view);
        this.gEI = (EditText) this.gEF.findViewById(d.g.cover_edit);
        this.gEJ = (ImageView) this.gEF.findViewById(d.g.cover_delete);
        this.gEK = (ImageView) this.gEF.findViewById(d.g.cover_scale);
    }

    public void bic() {
        this.gEH.setText(this.gEI.getText());
        this.gEH.setVisibility(0);
        this.gEI.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gEH.getText())) {
            this.gEL = 0;
            this.gEF.setVisibility(8);
        }
        if (this.gEL == 4) {
            byY();
        }
        this.gEV.HidenSoftKeyPad(this.gEI);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gEI.setFocusable(true);
            this.gEI.setFocusableInTouchMode(true);
            this.gEI.requestFocus();
            return;
        }
        this.gEI.setFocusable(false);
        this.gEI.setFocusableInTouchMode(false);
    }

    public void a(View view, final PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gEI.setText("");
                    bic();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bza();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bza();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bza();
                    break;
                default:
                    bic();
                    String tk = com.baidu.tieba.video.editvideo.model.b.byT().tk(pendantData.resource);
                    if (TextUtils.isEmpty(tk)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            final a.b bVar = (a.b) view.getTag();
                            bVar.gEa.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.byT().a(pendantData.id, pendantData.resource, new b.a() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.6
                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void cf(String str, String str2) {
                                    bVar.gEa.setVisibility(8);
                                    CoverPendantDragView.this.a(str2, pendantData);
                                }

                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void tf(String str) {
                                    bVar.gEa.setVisibility(8);
                                    l.showToast(CoverPendantDragView.this.getContext(), str);
                                }

                                @Override // com.baidu.tieba.video.editvideo.model.b.a
                                public void byq() {
                                    bVar.gEa.setVisibility(8);
                                }
                            });
                            break;
                        }
                    } else {
                        a(tk, pendantData);
                        break;
                    }
                    break;
            }
            this.gEL = pendantData.pendantType;
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
        byY();
        a(this.mVideoWidth, l.f(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gEL == 4 || this.gEL == 0) {
            this.gEF.setX(this.gEW);
            this.gEF.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.gEX);
            String obj = this.gEI.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a = a(this.gEI.getPaint(), obj);
                if (!a.equals(obj)) {
                    this.gEH.setText(a);
                    this.gEI.setText(a);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void byY() {
        if (this.gFa) {
            this.gFa = false;
            this.gEJ.setVisibility(8);
            this.gEK.setVisibility(8);
            this.gEG.setBackgroundColor(getResources().getColor(d.C0080d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byZ() {
        if (!this.gFa) {
            this.gFa = true;
            this.gEJ.setVisibility(0);
            this.gEK.setVisibility(0);
            this.gEG.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.gFm.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gFm.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                byY();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gEU = 1.0f;
                this.fNr = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gEU = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gEP = (this.gFg * 2) + width;
                this.gEQ = (this.gFg * 2) + height;
                this.gET = (this.gEP * 1.0f) / this.gEQ;
                this.gEF.setX((((this.mVideoWidth - i2) - (this.gFg * 2)) / 2) + this.gEW);
                this.gEF.setY((((this.mVideoHeight - i) - (this.gFg * 2)) / 2) + this.gEX);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gjw = motionEvent.getRawX();
                this.gjx = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gjw);
                float abs2 = Math.abs(rawY - this.gjx);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cmt && abs2 < this.cmt && System.currentTimeMillis() - this.startTime < 300) {
                    bic();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gEH == null || this.gEH.getText() == null) {
            return null;
        }
        return this.gEH.getText().toString();
    }

    public void bza() {
        this.gEH.setText(this.gEI.getText());
        this.gEH.setVisibility(8);
        this.gEI.setVisibility(0);
        setEditTextEnable(true);
        this.gEV.ShowSoftKeyPad(this.gEI);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gEI.setTextAppearance(getContext(), d.k.cover_text_style);
            this.gEH.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.gFg = 0;
            this.gEI.setMaxLines(1);
            this.gEH.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEH.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gEI.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.gEI.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gEH.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gFg = l.f(getContext(), d.e.ds40);
            this.gEI.setMaxLines(2);
            this.gEH.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gEH.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gEI.setLayoutParams(layoutParams2);
            this.gFc = (int) (l.dip2px(getContext(), pendantData.left) * this.gEU);
            this.gFd = (int) (l.dip2px(getContext(), pendantData.top) * this.gEU);
            this.gFe = (int) (l.dip2px(getContext(), pendantData.right) * this.gEU);
            this.gFf = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gEU);
            this.mContentView.setPadding(this.gFc, this.gFd, this.gFe, this.gFf);
            this.gFb = l.f(getContext(), d.e.fontsize40) * this.gEU;
            String text = getText();
            this.gFh = (i2 - this.gFd) - this.gFf;
            this.gFi = (i - this.gFc) - this.gFe;
            this.gFk = this.gFj + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.gFb);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.gFi);
                this.gFb = this.gEI.getTextSize();
                byZ();
                bza();
            } else {
                if (w.gX(text) > 20) {
                    text = w.E(text, 20);
                    this.gEI.setText(text);
                    this.gEH.setText(text);
                }
                tm(text);
            }
        }
        this.gEH.setIncludeFontPadding(false);
        this.gEI.setIncludeFontPadding(false);
        this.gEH.setLineSpacing(this.gFj, 1.0f);
        this.gEI.setLineSpacing(this.gFj, 1.0f);
        this.gEF.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gEF.getLayoutParams();
        layoutParams3.height = (this.gFg * 2) + i2;
        layoutParams3.width = (this.gFg * 2) + i;
        this.gEF.setLayoutParams(layoutParams3);
        this.gFl = (this.gFg * 2) + i;
        ((FrameLayout.LayoutParams) this.gEG.getLayoutParams()).setMargins(this.gFg, this.gFg, this.gFg, this.gFg);
        this.gEF.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bzb();
        }
        return this.mTempBitmap;
    }

    private void bzb() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bzc() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void mW(boolean z) {
        if (this.gEL != 0) {
            if (z) {
                bzc();
                this.gEF.setVisibility(0);
                return;
            }
            bic();
            bzb();
            this.gEF.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gFm.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gFm.clear();
        this.gFm = null;
        bzc();
    }
}
