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
    private float bve;
    float dLw;
    float dLx;
    private float drk;
    private float gPM;
    private FrameLayout hCI;
    private RotateFrameLayout hCJ;
    private TextView hCK;
    private EditText hCL;
    private ImageView hCM;
    private ImageView hCN;
    private int hCO;
    private float hCP;
    private boolean hCQ;
    private float hCR;
    private float hCS;
    private int hCT;
    private int hCU;
    private float hCV;
    private float hCW;
    private float hCX;
    private float hCY;
    private b hCZ;
    private float hDa;
    private float hDb;
    private float hDc;
    private float hDd;
    private boolean hDe;
    private float hDf;
    private int hDg;
    private int hDh;
    private int hDi;
    private int hDj;
    private int hDk;
    private float hDl;
    private float hDm;
    private int hDn;
    private float hDo;
    private int hDp;
    private Map<String, Bitmap> hDq;
    private Bitmap hDr;
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
        this.hCO = 0;
        this.hCY = 1.0f;
        this.gPM = 1.0f;
        this.hDe = true;
        this.hDq = new HashMap();
        this.startTime = 0L;
        this.dLw = 0.0f;
        this.dLx = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hDf = l.h(getContext(), e.C0210e.fontsize40);
        this.hDn = l.h(getContext(), e.C0210e.ds2);
        this.drk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hCI = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hCI);
        this.hCI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hCO == 4) {
                            CoverPendantDragView.this.bIU();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bve);
                        if (!CoverPendantDragView.this.hCQ && abs < CoverPendantDragView.this.drk && abs2 < CoverPendantDragView.this.drk && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bIV();
                        }
                        CoverPendantDragView.this.hCR = 0.0f;
                        CoverPendantDragView.this.hCS = 0.0f;
                        CoverPendantDragView.this.hCQ = false;
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
                        CoverPendantDragView.this.hCR = 0.0f;
                        CoverPendantDragView.this.hCS = 0.0f;
                        return true;
                }
            }
        });
        this.hCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hCL.setText("");
                CoverPendantDragView.this.bsQ();
            }
        });
        this.hCN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hCS = 0.0f;
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
        this.hCL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hCO != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hCK.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.iN(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hCK.getText().length()) {
                        CoverPendantDragView.this.wK(obj);
                    } else {
                        CoverPendantDragView.this.wJ(obj);
                    }
                } else {
                    String H = y.H(obj, 20);
                    editable.delete(H.length(), obj.length());
                    CoverPendantDragView.this.wK(H);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hCK.setText(editable.toString());
            }
        });
        this.hCL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hCI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bve = motionEvent.getRawY();
        this.hCP = this.mDownX;
        this.mLastY = this.bve;
        this.hCV = (this.hCI.getWidth() / 2) + this.hCI.getX();
        this.hCW = (this.hCI.getHeight() / 2) + this.hCI.getY();
        this.hCK.setText(this.hCL.getText());
        this.hCK.setVisibility(0);
        this.hCL.setVisibility(8);
        setEditTextEnable(false);
        this.hCZ.HidenSoftKeyPad(this.hCL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(String str) {
        TextPaint paint = this.hCL.getPaint();
        float measureText = paint.measureText(str);
        while (this.hCL.getLineCount() == 1 && this.hCL.getTextSize() < this.hDf * this.gPM && measureText < this.hDm * this.gPM) {
            setTextSize(0, this.hCL.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.iN(str) <= y.iN(getResources().getString(e.j.cover_hint)) && this.hCL.getTextSize() != this.hDf * this.gPM) {
            setTextSize(0, this.hDf * this.gPM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wK(String str) {
        TextPaint paint = this.hCL.getPaint();
        float measureText = paint.measureText(str);
        while (this.hCL.getTextSize() > ((this.hDl * this.gPM) / 2.0f) - (this.hDo * this.gPM) && measureText > this.hDm * this.gPM) {
            setTextSize(0, this.hCL.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hCL.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hCL.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0210e.ds120)) {
            str = y.J(str, y.iM(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hCZ = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hDa = f;
        this.hDb = f2;
        this.hDc = f3;
        this.hDd = f4;
        if (this.hDa > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hDa, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hDb > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hDb);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hDc > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hDc) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hDd > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hDd) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float K = K(motionEvent);
        float abs = Math.abs(this.hCP - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hCV - rawX);
        float abs4 = Math.abs(this.hCW - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hCV - this.hCP);
        float abs6 = Math.abs(this.hCW - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bV(sqrt, (int) (sqrt / this.hCX));
        if (this.hCS != 0.0f) {
            this.hCI.setRotation(this.hCI.getRotation() - (this.hCS - K));
        }
        this.hCS = K;
        this.hCP = rawX;
        this.mLastY = rawY;
    }

    private void bV(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hCI.getLayoutParams();
        int width = this.hCI.getWidth() - i;
        int i3 = (int) (width / this.hCX);
        if (width < this.hCT) {
            width = this.hCT;
            i3 = (int) (width / this.hCX);
        }
        this.gPM = ((width * 1.0f) - (this.hDk * 2)) / (this.hDp - (this.hDk * 2));
        this.mContentView.setPadding((int) (this.hDg * this.gPM), (int) (this.hDh * this.gPM), (int) (this.hDi * this.gPM), (int) (this.hDj * this.gPM));
        setTextSize(0, (this.hCL.getTextSize() * i3) / this.hCI.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hCI.setLayoutParams(layoutParams);
        float f = this.hCV - (layoutParams.width / 2);
        float f2 = this.hCW - (layoutParams.height / 2);
        this.hCI.setX(f);
        this.hCI.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hCO != 4) {
            float y = (this.hCI.getY() + rawY) - this.mLastY;
            if (y < this.hDb) {
                y = this.hDb;
            } else if (y > (this.hDb + this.mVideoHeight) - this.hCI.getHeight()) {
                y = (this.hDb + this.mVideoHeight) - this.hCI.getHeight();
            }
            this.hCI.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hCQ = true;
                float L = L(motionEvent);
                float J = J(motionEvent);
                if (this.hCR != 0.0f) {
                    int i = (int) (this.hCR - L);
                    bV(i, (int) (i / this.hCX));
                }
                if (this.hCS != 0.0f) {
                    this.hCI.setRotation(this.hCI.getRotation() - (this.hCS - J));
                }
                this.hCS = J;
                this.hCR = L;
            } else if (!this.hCQ && pointerCount == 1) {
                float y2 = (this.hCI.getY() + rawY) - this.mLastY;
                if (y2 < this.hDb - (this.hCI.getHeight() / 2)) {
                    y2 = this.hDb - (this.hCI.getHeight() / 2);
                } else if (y2 > ((this.hDb + this.mVideoHeight) - this.hCI.getHeight()) + (this.hCI.getHeight() / 2)) {
                    y2 = ((this.hDb + this.mVideoHeight) - this.hCI.getHeight()) + (this.hCI.getHeight() / 2);
                }
                float x = (this.hCI.getX() + rawX) - this.hCP;
                if (x < this.hDa - (this.hCI.getWidth() / 2)) {
                    x = this.hDa - (this.hCI.getWidth() / 2);
                } else if (x > ((this.hDa + this.mVideoWidth) - this.hCI.getWidth()) + (this.hCI.getWidth() / 2)) {
                    x = ((this.hDa + this.mVideoWidth) - this.hCI.getWidth()) + (this.hCI.getWidth() / 2);
                }
                this.hCI.setX(x);
                this.hCI.setY(y2);
            }
        }
        this.hCP = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hCL.getTextSize() != f) {
            this.hCL.setTextSize(i, f);
        }
        if (this.hCK.getTextSize() != f) {
            this.hCK.setTextSize(i, f);
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
        matrix.postRotate(this.hCI.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float K(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hCW - motionEvent.getRawY(), this.hCV - motionEvent.getRawX()));
    }

    private float L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drk && Math.abs(motionEvent.getRawY() - this.bve) < this.drk;
    }

    private void init() {
        this.hCJ = (RotateFrameLayout) this.hCI.findViewById(e.g.content_container);
        this.hCK = (TextView) this.hCI.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hCI.findViewById(e.g.content_view);
        this.hCL = (EditText) this.hCI.findViewById(e.g.cover_edit);
        this.hCM = (ImageView) this.hCI.findViewById(e.g.cover_delete);
        this.hCN = (ImageView) this.hCI.findViewById(e.g.cover_scale);
    }

    public void bsQ() {
        this.hCK.setText(this.hCL.getText());
        this.hCK.setVisibility(0);
        this.hCL.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hCK.getText())) {
            this.hCO = 0;
            this.hCI.setVisibility(8);
        }
        if (this.hCO == 4) {
            bIT();
        }
        this.hCZ.HidenSoftKeyPad(this.hCL);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hCL.setFocusable(true);
            this.hCL.setFocusableInTouchMode(true);
            this.hCL.requestFocus();
            return;
        }
        this.hCL.setFocusable(false);
        this.hCL.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hCL.setText("");
                    bsQ();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bIV();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bIV();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bIV();
                    break;
                default:
                    bsQ();
                    String wI = com.baidu.tieba.video.editvideo.model.b.bIO().wI(pendantData.resource);
                    if (TextUtils.isEmpty(wI)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hBD.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bIO().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(wI, pendantData);
                        break;
                    }
                    break;
            }
            this.hCO = pendantData.pendantType;
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
        bIT();
        a(this.mVideoWidth, l.h(getContext(), e.C0210e.ds100), this.mScreenWidth, pendantData);
        if (this.hCO == 4 || this.hCO == 0) {
            this.hCI.setX(this.hDa);
            this.hCI.setY(((this.mVideoHeight - l.h(getContext(), e.C0210e.ds100)) / 2) + this.hDb);
            String obj = this.hCL.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hCL.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hCK.setText(a2);
                    this.hCL.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bIT() {
        if (this.hDe) {
            this.hDe = false;
            this.hCM.setVisibility(8);
            this.hCN.setVisibility(8);
            this.hCJ.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        if (!this.hDe) {
            this.hDe = true;
            this.hCM.setVisibility(0);
            this.hCN.setVisibility(0);
            this.hCJ.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hDq != null) {
            Bitmap bitmap = this.hDq.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hDq.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bIT();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hCY = 1.0f;
                this.gPM = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hCY = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hCT = (this.hDk * 2) + width;
                this.hCU = (this.hDk * 2) + height;
                this.hCX = (this.hCT * 1.0f) / this.hCU;
                this.hCI.setX((((this.mVideoWidth - i2) - (this.hDk * 2)) / 2) + this.hDa);
                this.hCI.setY((((this.mVideoHeight - i) - (this.hDk * 2)) / 2) + this.hDb);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dLw = motionEvent.getRawX();
                this.dLx = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dLw);
                float abs2 = Math.abs(rawY - this.dLx);
                if (motionEvent.getPointerCount() <= 1 && abs < this.drk && abs2 < this.drk && System.currentTimeMillis() - this.startTime < 300) {
                    bsQ();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hCK == null || this.hCK.getText() == null) {
            return null;
        }
        return this.hCK.getText().toString();
    }

    public void bIV() {
        this.hCK.setText(this.hCL.getText());
        this.hCK.setVisibility(8);
        this.hCL.setVisibility(0);
        setEditTextEnable(true);
        this.hCZ.ShowSoftKeyPad(this.hCL);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hCL.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hCK.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0210e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0210e.fontsize40) * i) / i3);
            this.hDk = 0;
            this.hCL.setMaxLines(1);
            this.hCK.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hCK.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hCL.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0210e.ds60), 0, l.h(getContext(), e.C0210e.ds60), 0);
        } else {
            this.hCL.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hCK.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hDk = l.h(getContext(), e.C0210e.ds40);
            this.hCL.setMaxLines(2);
            this.hCK.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hCK.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hCL.setLayoutParams(layoutParams2);
            this.hDg = (int) (l.dip2px(getContext(), pendantData.left) * this.hCY);
            this.hDh = (int) (l.dip2px(getContext(), pendantData.top) * this.hCY);
            this.hDi = (int) (l.dip2px(getContext(), pendantData.right) * this.hCY);
            this.hDj = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hCY);
            this.mContentView.setPadding(this.hDg, this.hDh, this.hDi, this.hDj);
            this.hDf = l.h(getContext(), e.C0210e.fontsize40) * this.hCY;
            String text = getText();
            this.hDl = (i2 - this.hDh) - this.hDj;
            this.hDm = (i - this.hDg) - this.hDi;
            this.hDo = this.hDn + l.h(getContext(), e.C0210e.ds6);
            setTextSize(0, this.hDf);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hDm);
                this.hDf = this.hCL.getTextSize();
                bIU();
                bIV();
            } else {
                if (y.iN(text) > 20) {
                    text = y.H(text, 20);
                    this.hCL.setText(text);
                    this.hCK.setText(text);
                }
                wK(text);
            }
        }
        this.hCK.setIncludeFontPadding(false);
        this.hCL.setIncludeFontPadding(false);
        this.hCK.setLineSpacing(this.hDn, 1.0f);
        this.hCL.setLineSpacing(this.hDn, 1.0f);
        this.hCI.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hCI.getLayoutParams();
        layoutParams3.height = (this.hDk * 2) + i2;
        layoutParams3.width = (this.hDk * 2) + i;
        this.hCI.setLayoutParams(layoutParams3);
        this.hDp = (this.hDk * 2) + i;
        ((FrameLayout.LayoutParams) this.hCJ.getLayoutParams()).setMargins(this.hDk, this.hDk, this.hDk, this.hDk);
        this.hCI.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hDr == null) {
            bIW();
        }
        return this.hDr;
    }

    private void bIW() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hDr = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bIX() {
        if (this.hDr != null && !this.hDr.isRecycled()) {
            this.hDr.recycle();
            this.hDr = null;
        }
    }

    public void nX(boolean z) {
        if (this.hCO != 0) {
            if (z) {
                bIX();
                this.hCI.setVisibility(0);
                return;
            }
            bsQ();
            getTempBitmap();
            this.hCI.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hDq.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hDq.clear();
        this.hDq = null;
        bIX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hDt;
        WeakReference<CoverPendantDragView> hDu;
        WeakReference<PendantData> hDv;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hDt = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hDu = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hDv = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cR(String str, String str2) {
            if (this.hDt != null && this.hDt.get() != null) {
                this.hDt.get().hBD.setVisibility(8);
            }
            if (this.hDu != null && this.hDu.get() != null && this.hDv != null && this.hDv.get() != null) {
                this.hDu.get().a(str2, this.hDv.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void wz(String str) {
            if (this.hDt != null && this.hDt.get() != null) {
                this.hDt.get().hBD.setVisibility(8);
            }
            if (this.hDu != null && this.hDu.get() != null) {
                l.showToast(this.hDu.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bHZ() {
            if (this.hDt != null && this.hDt.get() != null) {
                this.hDt.get().hBD.setVisibility(8);
            }
        }
    }
}
