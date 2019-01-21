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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bvW;
    float dOU;
    float dOV;
    private float duI;
    private float gTK;
    private int hHA;
    private int hHB;
    private int hHC;
    private int hHD;
    private float hHE;
    private float hHF;
    private int hHG;
    private float hHH;
    private int hHI;
    private Map<String, Bitmap> hHJ;
    private Bitmap hHK;
    private FrameLayout hHb;
    private RotateFrameLayout hHc;
    private TextView hHd;
    private EditText hHe;
    private ImageView hHf;
    private ImageView hHg;
    private int hHh;
    private float hHi;
    private boolean hHj;
    private float hHk;
    private float hHl;
    private int hHm;
    private int hHn;
    private float hHo;
    private float hHp;
    private float hHq;
    private float hHr;
    private b hHs;
    private float hHt;
    private float hHu;
    private float hHv;
    private float hHw;
    private boolean hHx;
    private float hHy;
    private int hHz;
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
        this.hHh = 0;
        this.hHr = 1.0f;
        this.gTK = 1.0f;
        this.hHx = true;
        this.hHJ = new HashMap();
        this.startTime = 0L;
        this.dOU = 0.0f;
        this.dOV = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hHy = l.h(getContext(), e.C0210e.fontsize40);
        this.hHG = l.h(getContext(), e.C0210e.ds2);
        this.duI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hHb = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hHb);
        this.hHb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hHh == 4) {
                            CoverPendantDragView.this.bKt();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bvW);
                        if (!CoverPendantDragView.this.hHj && abs < CoverPendantDragView.this.duI && abs2 < CoverPendantDragView.this.duI && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bKu();
                        }
                        CoverPendantDragView.this.hHk = 0.0f;
                        CoverPendantDragView.this.hHl = 0.0f;
                        CoverPendantDragView.this.hHj = false;
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
                        CoverPendantDragView.this.hHk = 0.0f;
                        CoverPendantDragView.this.hHl = 0.0f;
                        return true;
                }
            }
        });
        this.hHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hHe.setText("");
                CoverPendantDragView.this.bul();
            }
        });
        this.hHg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hHl = 0.0f;
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
        this.hHe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hHh != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hHd.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (z.je(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hHd.getText().length()) {
                        CoverPendantDragView.this.xd(obj);
                    } else {
                        CoverPendantDragView.this.xc(obj);
                    }
                } else {
                    String I = z.I(obj, 20);
                    editable.delete(I.length(), obj.length());
                    CoverPendantDragView.this.xd(I);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hHd.setText(editable.toString());
            }
        });
        this.hHe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hHb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bvW = motionEvent.getRawY();
        this.hHi = this.mDownX;
        this.mLastY = this.bvW;
        this.hHo = (this.hHb.getWidth() / 2) + this.hHb.getX();
        this.hHp = (this.hHb.getHeight() / 2) + this.hHb.getY();
        this.hHd.setText(this.hHe.getText());
        this.hHd.setVisibility(0);
        this.hHe.setVisibility(8);
        setEditTextEnable(false);
        this.hHs.HidenSoftKeyPad(this.hHe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(String str) {
        TextPaint paint = this.hHe.getPaint();
        float measureText = paint.measureText(str);
        while (this.hHe.getLineCount() == 1 && this.hHe.getTextSize() < this.hHy * this.gTK && measureText < this.hHF * this.gTK) {
            setTextSize(0, this.hHe.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (z.je(str) <= z.je(getResources().getString(e.j.cover_hint)) && this.hHe.getTextSize() != this.hHy * this.gTK) {
            setTextSize(0, this.hHy * this.gTK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(String str) {
        TextPaint paint = this.hHe.getPaint();
        float measureText = paint.measureText(str);
        while (this.hHe.getTextSize() > ((this.hHE * this.gTK) / 2.0f) - (this.hHH * this.gTK) && measureText > this.hHF * this.gTK) {
            setTextSize(0, this.hHe.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hHe.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hHe.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0210e.ds120)) {
            str = z.K(str, z.jd(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hHs = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hHt = f;
        this.hHu = f2;
        this.hHv = f3;
        this.hHw = f4;
        if (this.hHt > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hHt, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hHu > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hHu);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hHv > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hHv) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hHw > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hHw) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.hHi - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hHo - rawX);
        float abs4 = Math.abs(this.hHp - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hHo - this.hHi);
        float abs6 = Math.abs(this.hHp - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bW(sqrt, (int) (sqrt / this.hHq));
        if (this.hHl != 0.0f) {
            this.hHb.setRotation(this.hHb.getRotation() - (this.hHl - J));
        }
        this.hHl = J;
        this.hHi = rawX;
        this.mLastY = rawY;
    }

    private void bW(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hHb.getLayoutParams();
        int width = this.hHb.getWidth() - i;
        int i3 = (int) (width / this.hHq);
        if (width < this.hHm) {
            width = this.hHm;
            i3 = (int) (width / this.hHq);
        }
        this.gTK = ((width * 1.0f) - (this.hHD * 2)) / (this.hHI - (this.hHD * 2));
        this.mContentView.setPadding((int) (this.hHz * this.gTK), (int) (this.hHA * this.gTK), (int) (this.hHB * this.gTK), (int) (this.hHC * this.gTK));
        setTextSize(0, (this.hHe.getTextSize() * i3) / this.hHb.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hHb.setLayoutParams(layoutParams);
        float f = this.hHo - (layoutParams.width / 2);
        float f2 = this.hHp - (layoutParams.height / 2);
        this.hHb.setX(f);
        this.hHb.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hHh != 4) {
            float y = (this.hHb.getY() + rawY) - this.mLastY;
            if (y < this.hHu) {
                y = this.hHu;
            } else if (y > (this.hHu + this.mVideoHeight) - this.hHb.getHeight()) {
                y = (this.hHu + this.mVideoHeight) - this.hHb.getHeight();
            }
            this.hHb.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hHj = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.hHk != 0.0f) {
                    int i = (int) (this.hHk - K);
                    bW(i, (int) (i / this.hHq));
                }
                if (this.hHl != 0.0f) {
                    this.hHb.setRotation(this.hHb.getRotation() - (this.hHl - I));
                }
                this.hHl = I;
                this.hHk = K;
            } else if (!this.hHj && pointerCount == 1) {
                float y2 = (this.hHb.getY() + rawY) - this.mLastY;
                if (y2 < this.hHu - (this.hHb.getHeight() / 2)) {
                    y2 = this.hHu - (this.hHb.getHeight() / 2);
                } else if (y2 > ((this.hHu + this.mVideoHeight) - this.hHb.getHeight()) + (this.hHb.getHeight() / 2)) {
                    y2 = ((this.hHu + this.mVideoHeight) - this.hHb.getHeight()) + (this.hHb.getHeight() / 2);
                }
                float x = (this.hHb.getX() + rawX) - this.hHi;
                if (x < this.hHt - (this.hHb.getWidth() / 2)) {
                    x = this.hHt - (this.hHb.getWidth() / 2);
                } else if (x > ((this.hHt + this.mVideoWidth) - this.hHb.getWidth()) + (this.hHb.getWidth() / 2)) {
                    x = ((this.hHt + this.mVideoWidth) - this.hHb.getWidth()) + (this.hHb.getWidth() / 2);
                }
                this.hHb.setX(x);
                this.hHb.setY(y2);
            }
        }
        this.hHi = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hHe.getTextSize() != f) {
            this.hHe.setTextSize(i, f);
        }
        if (this.hHd.getTextSize() != f) {
            this.hHd.setTextSize(i, f);
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
        matrix.postRotate(this.hHb.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hHp - motionEvent.getRawY(), this.hHo - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.duI && Math.abs(motionEvent.getRawY() - this.bvW) < this.duI;
    }

    private void init() {
        this.hHc = (RotateFrameLayout) this.hHb.findViewById(e.g.content_container);
        this.hHd = (TextView) this.hHb.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hHb.findViewById(e.g.content_view);
        this.hHe = (EditText) this.hHb.findViewById(e.g.cover_edit);
        this.hHf = (ImageView) this.hHb.findViewById(e.g.cover_delete);
        this.hHg = (ImageView) this.hHb.findViewById(e.g.cover_scale);
    }

    public void bul() {
        this.hHd.setText(this.hHe.getText());
        this.hHd.setVisibility(0);
        this.hHe.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hHd.getText())) {
            this.hHh = 0;
            this.hHb.setVisibility(8);
        }
        if (this.hHh == 4) {
            bKs();
        }
        this.hHs.HidenSoftKeyPad(this.hHe);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hHe.setFocusable(true);
            this.hHe.setFocusableInTouchMode(true);
            this.hHe.requestFocus();
            return;
        }
        this.hHe.setFocusable(false);
        this.hHe.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hHe.setText("");
                    bul();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bKu();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bKu();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bKu();
                    break;
                default:
                    bul();
                    String xb = com.baidu.tieba.video.editvideo.model.b.bKn().xb(pendantData.resource);
                    if (TextUtils.isEmpty(xb)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hFW.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bKn().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(xb, pendantData);
                        break;
                    }
                    break;
            }
            this.hHh = pendantData.pendantType;
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
        bKs();
        a(this.mVideoWidth, l.h(getContext(), e.C0210e.ds100), this.mScreenWidth, pendantData);
        if (this.hHh == 4 || this.hHh == 0) {
            this.hHb.setX(this.hHt);
            this.hHb.setY(((this.mVideoHeight - l.h(getContext(), e.C0210e.ds100)) / 2) + this.hHu);
            String obj = this.hHe.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hHe.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hHd.setText(a2);
                    this.hHe.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bKs() {
        if (this.hHx) {
            this.hHx = false;
            this.hHf.setVisibility(8);
            this.hHg.setVisibility(8);
            this.hHc.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKt() {
        if (!this.hHx) {
            this.hHx = true;
            this.hHf.setVisibility(0);
            this.hHg.setVisibility(0);
            this.hHc.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hHJ != null) {
            Bitmap bitmap = this.hHJ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hHJ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bKs();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hHr = 1.0f;
                this.gTK = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hHr = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hHm = (this.hHD * 2) + width;
                this.hHn = (this.hHD * 2) + height;
                this.hHq = (this.hHm * 1.0f) / this.hHn;
                this.hHb.setX((((this.mVideoWidth - i2) - (this.hHD * 2)) / 2) + this.hHt);
                this.hHb.setY((((this.mVideoHeight - i) - (this.hHD * 2)) / 2) + this.hHu);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dOU = motionEvent.getRawX();
                this.dOV = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dOU);
                float abs2 = Math.abs(rawY - this.dOV);
                if (motionEvent.getPointerCount() <= 1 && abs < this.duI && abs2 < this.duI && System.currentTimeMillis() - this.startTime < 300) {
                    bul();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hHd == null || this.hHd.getText() == null) {
            return null;
        }
        return this.hHd.getText().toString();
    }

    public void bKu() {
        this.hHd.setText(this.hHe.getText());
        this.hHd.setVisibility(8);
        this.hHe.setVisibility(0);
        setEditTextEnable(true);
        this.hHs.ShowSoftKeyPad(this.hHe);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hHe.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hHd.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0210e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0210e.fontsize40) * i) / i3);
            this.hHD = 0;
            this.hHe.setMaxLines(1);
            this.hHd.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hHd.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hHe.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0210e.ds60), 0, l.h(getContext(), e.C0210e.ds60), 0);
        } else {
            this.hHe.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hHd.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hHD = l.h(getContext(), e.C0210e.ds40);
            this.hHe.setMaxLines(2);
            this.hHd.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hHd.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hHe.setLayoutParams(layoutParams2);
            this.hHz = (int) (l.dip2px(getContext(), pendantData.left) * this.hHr);
            this.hHA = (int) (l.dip2px(getContext(), pendantData.top) * this.hHr);
            this.hHB = (int) (l.dip2px(getContext(), pendantData.right) * this.hHr);
            this.hHC = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hHr);
            this.mContentView.setPadding(this.hHz, this.hHA, this.hHB, this.hHC);
            this.hHy = l.h(getContext(), e.C0210e.fontsize40) * this.hHr;
            String text = getText();
            this.hHE = (i2 - this.hHA) - this.hHC;
            this.hHF = (i - this.hHz) - this.hHB;
            this.hHH = this.hHG + l.h(getContext(), e.C0210e.ds6);
            setTextSize(0, this.hHy);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hHF);
                this.hHy = this.hHe.getTextSize();
                bKt();
                bKu();
            } else {
                if (z.je(text) > 20) {
                    text = z.I(text, 20);
                    this.hHe.setText(text);
                    this.hHd.setText(text);
                }
                xd(text);
            }
        }
        this.hHd.setIncludeFontPadding(false);
        this.hHe.setIncludeFontPadding(false);
        this.hHd.setLineSpacing(this.hHG, 1.0f);
        this.hHe.setLineSpacing(this.hHG, 1.0f);
        this.hHb.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hHb.getLayoutParams();
        layoutParams3.height = (this.hHD * 2) + i2;
        layoutParams3.width = (this.hHD * 2) + i;
        this.hHb.setLayoutParams(layoutParams3);
        this.hHI = (this.hHD * 2) + i;
        ((FrameLayout.LayoutParams) this.hHc.getLayoutParams()).setMargins(this.hHD, this.hHD, this.hHD, this.hHD);
        this.hHb.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hHK == null) {
            bKv();
        }
        return this.hHK;
    }

    private void bKv() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hHK = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bKw() {
        if (this.hHK != null && !this.hHK.isRecycled()) {
            this.hHK.recycle();
            this.hHK = null;
        }
    }

    public void ob(boolean z) {
        if (this.hHh != 0) {
            if (z) {
                bKw();
                this.hHb.setVisibility(0);
                return;
            }
            bul();
            getTempBitmap();
            this.hHb.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hHJ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hHJ.clear();
        this.hHJ = null;
        bKw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hHM;
        WeakReference<CoverPendantDragView> hHN;
        WeakReference<PendantData> hHO;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hHM = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hHN = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hHO = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cT(String str, String str2) {
            if (this.hHM != null && this.hHM.get() != null) {
                this.hHM.get().hFW.setVisibility(8);
            }
            if (this.hHN != null && this.hHN.get() != null && this.hHO != null && this.hHO.get() != null) {
                this.hHN.get().a(str2, this.hHO.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void wS(String str) {
            if (this.hHM != null && this.hHM.get() != null) {
                this.hHM.get().hFW.setVisibility(8);
            }
            if (this.hHN != null && this.hHN.get() != null) {
                l.showToast(this.hHN.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bJy() {
            if (this.hHM != null && this.hHM.get() != null) {
                this.hHM.get().hFW.setVisibility(8);
            }
        }
    }
}
