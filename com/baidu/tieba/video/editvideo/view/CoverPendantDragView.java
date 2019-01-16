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
    private float bvV;
    float dOT;
    float dOU;
    private float duH;
    private float gTJ;
    private int hHA;
    private int hHB;
    private int hHC;
    private float hHD;
    private float hHE;
    private int hHF;
    private float hHG;
    private int hHH;
    private Map<String, Bitmap> hHI;
    private Bitmap hHJ;
    private FrameLayout hHa;
    private RotateFrameLayout hHb;
    private TextView hHc;
    private EditText hHd;
    private ImageView hHe;
    private ImageView hHf;
    private int hHg;
    private float hHh;
    private boolean hHi;
    private float hHj;
    private float hHk;
    private int hHl;
    private int hHm;
    private float hHn;
    private float hHo;
    private float hHp;
    private float hHq;
    private b hHr;
    private float hHs;
    private float hHt;
    private float hHu;
    private float hHv;
    private boolean hHw;
    private float hHx;
    private int hHy;
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
        this.hHg = 0;
        this.hHq = 1.0f;
        this.gTJ = 1.0f;
        this.hHw = true;
        this.hHI = new HashMap();
        this.startTime = 0L;
        this.dOT = 0.0f;
        this.dOU = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hHx = l.h(getContext(), e.C0210e.fontsize40);
        this.hHF = l.h(getContext(), e.C0210e.ds2);
        this.duH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hHa = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hHa);
        this.hHa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hHg == 4) {
                            CoverPendantDragView.this.bKt();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bvV);
                        if (!CoverPendantDragView.this.hHi && abs < CoverPendantDragView.this.duH && abs2 < CoverPendantDragView.this.duH && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bKu();
                        }
                        CoverPendantDragView.this.hHj = 0.0f;
                        CoverPendantDragView.this.hHk = 0.0f;
                        CoverPendantDragView.this.hHi = false;
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
                        CoverPendantDragView.this.hHj = 0.0f;
                        CoverPendantDragView.this.hHk = 0.0f;
                        return true;
                }
            }
        });
        this.hHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hHd.setText("");
                CoverPendantDragView.this.bul();
            }
        });
        this.hHf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hHk = 0.0f;
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
        this.hHd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hHg != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hHc.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (z.je(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hHc.getText().length()) {
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
                CoverPendantDragView.this.hHc.setText(editable.toString());
            }
        });
        this.hHd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hHa.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bvV = motionEvent.getRawY();
        this.hHh = this.mDownX;
        this.mLastY = this.bvV;
        this.hHn = (this.hHa.getWidth() / 2) + this.hHa.getX();
        this.hHo = (this.hHa.getHeight() / 2) + this.hHa.getY();
        this.hHc.setText(this.hHd.getText());
        this.hHc.setVisibility(0);
        this.hHd.setVisibility(8);
        setEditTextEnable(false);
        this.hHr.HidenSoftKeyPad(this.hHd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(String str) {
        TextPaint paint = this.hHd.getPaint();
        float measureText = paint.measureText(str);
        while (this.hHd.getLineCount() == 1 && this.hHd.getTextSize() < this.hHx * this.gTJ && measureText < this.hHE * this.gTJ) {
            setTextSize(0, this.hHd.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (z.je(str) <= z.je(getResources().getString(e.j.cover_hint)) && this.hHd.getTextSize() != this.hHx * this.gTJ) {
            setTextSize(0, this.hHx * this.gTJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(String str) {
        TextPaint paint = this.hHd.getPaint();
        float measureText = paint.measureText(str);
        while (this.hHd.getTextSize() > ((this.hHD * this.gTJ) / 2.0f) - (this.hHG * this.gTJ) && measureText > this.hHE * this.gTJ) {
            setTextSize(0, this.hHd.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hHd.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hHd.getTextSize() - 1.0f);
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
        this.hHr = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hHs = f;
        this.hHt = f2;
        this.hHu = f3;
        this.hHv = f4;
        if (this.hHs > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hHs, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hHt > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hHt);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hHu > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hHu) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hHv > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hHv) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.hHh - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hHn - rawX);
        float abs4 = Math.abs(this.hHo - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hHn - this.hHh);
        float abs6 = Math.abs(this.hHo - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bW(sqrt, (int) (sqrt / this.hHp));
        if (this.hHk != 0.0f) {
            this.hHa.setRotation(this.hHa.getRotation() - (this.hHk - J));
        }
        this.hHk = J;
        this.hHh = rawX;
        this.mLastY = rawY;
    }

    private void bW(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hHa.getLayoutParams();
        int width = this.hHa.getWidth() - i;
        int i3 = (int) (width / this.hHp);
        if (width < this.hHl) {
            width = this.hHl;
            i3 = (int) (width / this.hHp);
        }
        this.gTJ = ((width * 1.0f) - (this.hHC * 2)) / (this.hHH - (this.hHC * 2));
        this.mContentView.setPadding((int) (this.hHy * this.gTJ), (int) (this.hHz * this.gTJ), (int) (this.hHA * this.gTJ), (int) (this.hHB * this.gTJ));
        setTextSize(0, (this.hHd.getTextSize() * i3) / this.hHa.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hHa.setLayoutParams(layoutParams);
        float f = this.hHn - (layoutParams.width / 2);
        float f2 = this.hHo - (layoutParams.height / 2);
        this.hHa.setX(f);
        this.hHa.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hHg != 4) {
            float y = (this.hHa.getY() + rawY) - this.mLastY;
            if (y < this.hHt) {
                y = this.hHt;
            } else if (y > (this.hHt + this.mVideoHeight) - this.hHa.getHeight()) {
                y = (this.hHt + this.mVideoHeight) - this.hHa.getHeight();
            }
            this.hHa.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hHi = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.hHj != 0.0f) {
                    int i = (int) (this.hHj - K);
                    bW(i, (int) (i / this.hHp));
                }
                if (this.hHk != 0.0f) {
                    this.hHa.setRotation(this.hHa.getRotation() - (this.hHk - I));
                }
                this.hHk = I;
                this.hHj = K;
            } else if (!this.hHi && pointerCount == 1) {
                float y2 = (this.hHa.getY() + rawY) - this.mLastY;
                if (y2 < this.hHt - (this.hHa.getHeight() / 2)) {
                    y2 = this.hHt - (this.hHa.getHeight() / 2);
                } else if (y2 > ((this.hHt + this.mVideoHeight) - this.hHa.getHeight()) + (this.hHa.getHeight() / 2)) {
                    y2 = ((this.hHt + this.mVideoHeight) - this.hHa.getHeight()) + (this.hHa.getHeight() / 2);
                }
                float x = (this.hHa.getX() + rawX) - this.hHh;
                if (x < this.hHs - (this.hHa.getWidth() / 2)) {
                    x = this.hHs - (this.hHa.getWidth() / 2);
                } else if (x > ((this.hHs + this.mVideoWidth) - this.hHa.getWidth()) + (this.hHa.getWidth() / 2)) {
                    x = ((this.hHs + this.mVideoWidth) - this.hHa.getWidth()) + (this.hHa.getWidth() / 2);
                }
                this.hHa.setX(x);
                this.hHa.setY(y2);
            }
        }
        this.hHh = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hHd.getTextSize() != f) {
            this.hHd.setTextSize(i, f);
        }
        if (this.hHc.getTextSize() != f) {
            this.hHc.setTextSize(i, f);
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
        matrix.postRotate(this.hHa.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hHo - motionEvent.getRawY(), this.hHn - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.duH && Math.abs(motionEvent.getRawY() - this.bvV) < this.duH;
    }

    private void init() {
        this.hHb = (RotateFrameLayout) this.hHa.findViewById(e.g.content_container);
        this.hHc = (TextView) this.hHa.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hHa.findViewById(e.g.content_view);
        this.hHd = (EditText) this.hHa.findViewById(e.g.cover_edit);
        this.hHe = (ImageView) this.hHa.findViewById(e.g.cover_delete);
        this.hHf = (ImageView) this.hHa.findViewById(e.g.cover_scale);
    }

    public void bul() {
        this.hHc.setText(this.hHd.getText());
        this.hHc.setVisibility(0);
        this.hHd.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hHc.getText())) {
            this.hHg = 0;
            this.hHa.setVisibility(8);
        }
        if (this.hHg == 4) {
            bKs();
        }
        this.hHr.HidenSoftKeyPad(this.hHd);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hHd.setFocusable(true);
            this.hHd.setFocusableInTouchMode(true);
            this.hHd.requestFocus();
            return;
        }
        this.hHd.setFocusable(false);
        this.hHd.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hHd.setText("");
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
                            bVar.hFV.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bKn().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(xb, pendantData);
                        break;
                    }
                    break;
            }
            this.hHg = pendantData.pendantType;
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
        if (this.hHg == 4 || this.hHg == 0) {
            this.hHa.setX(this.hHs);
            this.hHa.setY(((this.mVideoHeight - l.h(getContext(), e.C0210e.ds100)) / 2) + this.hHt);
            String obj = this.hHd.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hHd.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hHc.setText(a2);
                    this.hHd.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bKs() {
        if (this.hHw) {
            this.hHw = false;
            this.hHe.setVisibility(8);
            this.hHf.setVisibility(8);
            this.hHb.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKt() {
        if (!this.hHw) {
            this.hHw = true;
            this.hHe.setVisibility(0);
            this.hHf.setVisibility(0);
            this.hHb.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hHI != null) {
            Bitmap bitmap = this.hHI.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hHI.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bKs();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hHq = 1.0f;
                this.gTJ = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hHq = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hHl = (this.hHC * 2) + width;
                this.hHm = (this.hHC * 2) + height;
                this.hHp = (this.hHl * 1.0f) / this.hHm;
                this.hHa.setX((((this.mVideoWidth - i2) - (this.hHC * 2)) / 2) + this.hHs);
                this.hHa.setY((((this.mVideoHeight - i) - (this.hHC * 2)) / 2) + this.hHt);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dOT = motionEvent.getRawX();
                this.dOU = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dOT);
                float abs2 = Math.abs(rawY - this.dOU);
                if (motionEvent.getPointerCount() <= 1 && abs < this.duH && abs2 < this.duH && System.currentTimeMillis() - this.startTime < 300) {
                    bul();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hHc == null || this.hHc.getText() == null) {
            return null;
        }
        return this.hHc.getText().toString();
    }

    public void bKu() {
        this.hHc.setText(this.hHd.getText());
        this.hHc.setVisibility(8);
        this.hHd.setVisibility(0);
        setEditTextEnable(true);
        this.hHr.ShowSoftKeyPad(this.hHd);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hHd.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hHc.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0210e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0210e.fontsize40) * i) / i3);
            this.hHC = 0;
            this.hHd.setMaxLines(1);
            this.hHc.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hHc.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hHd.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0210e.ds60), 0, l.h(getContext(), e.C0210e.ds60), 0);
        } else {
            this.hHd.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hHc.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hHC = l.h(getContext(), e.C0210e.ds40);
            this.hHd.setMaxLines(2);
            this.hHc.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hHc.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hHd.setLayoutParams(layoutParams2);
            this.hHy = (int) (l.dip2px(getContext(), pendantData.left) * this.hHq);
            this.hHz = (int) (l.dip2px(getContext(), pendantData.top) * this.hHq);
            this.hHA = (int) (l.dip2px(getContext(), pendantData.right) * this.hHq);
            this.hHB = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hHq);
            this.mContentView.setPadding(this.hHy, this.hHz, this.hHA, this.hHB);
            this.hHx = l.h(getContext(), e.C0210e.fontsize40) * this.hHq;
            String text = getText();
            this.hHD = (i2 - this.hHz) - this.hHB;
            this.hHE = (i - this.hHy) - this.hHA;
            this.hHG = this.hHF + l.h(getContext(), e.C0210e.ds6);
            setTextSize(0, this.hHx);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hHE);
                this.hHx = this.hHd.getTextSize();
                bKt();
                bKu();
            } else {
                if (z.je(text) > 20) {
                    text = z.I(text, 20);
                    this.hHd.setText(text);
                    this.hHc.setText(text);
                }
                xd(text);
            }
        }
        this.hHc.setIncludeFontPadding(false);
        this.hHd.setIncludeFontPadding(false);
        this.hHc.setLineSpacing(this.hHF, 1.0f);
        this.hHd.setLineSpacing(this.hHF, 1.0f);
        this.hHa.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hHa.getLayoutParams();
        layoutParams3.height = (this.hHC * 2) + i2;
        layoutParams3.width = (this.hHC * 2) + i;
        this.hHa.setLayoutParams(layoutParams3);
        this.hHH = (this.hHC * 2) + i;
        ((FrameLayout.LayoutParams) this.hHb.getLayoutParams()).setMargins(this.hHC, this.hHC, this.hHC, this.hHC);
        this.hHa.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hHJ == null) {
            bKv();
        }
        return this.hHJ;
    }

    private void bKv() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hHJ = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bKw() {
        if (this.hHJ != null && !this.hHJ.isRecycled()) {
            this.hHJ.recycle();
            this.hHJ = null;
        }
    }

    public void ob(boolean z) {
        if (this.hHg != 0) {
            if (z) {
                bKw();
                this.hHa.setVisibility(0);
                return;
            }
            bul();
            getTempBitmap();
            this.hHa.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hHI.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hHI.clear();
        this.hHI = null;
        bKw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hHL;
        WeakReference<CoverPendantDragView> hHM;
        WeakReference<PendantData> hHN;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hHL = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hHM = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hHN = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cT(String str, String str2) {
            if (this.hHL != null && this.hHL.get() != null) {
                this.hHL.get().hFV.setVisibility(8);
            }
            if (this.hHM != null && this.hHM.get() != null && this.hHN != null && this.hHN.get() != null) {
                this.hHM.get().a(str2, this.hHN.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void wS(String str) {
            if (this.hHL != null && this.hHL.get() != null) {
                this.hHL.get().hFV.setVisibility(8);
            }
            if (this.hHM != null && this.hHM.get() != null) {
                l.showToast(this.hHM.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bJy() {
            if (this.hHL != null && this.hHL.get() != null) {
                this.hHL.get().hFV.setVisibility(8);
            }
        }
    }
}
