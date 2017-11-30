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
    private float bKr;
    private float cvz;
    private float fXz;
    private FrameLayout gPQ;
    private RotateFrameLayout gPR;
    private TextView gPS;
    private EditText gPT;
    private ImageView gPU;
    private ImageView gPV;
    private int gPW;
    private boolean gPX;
    private float gPY;
    private float gPZ;
    private int gQa;
    private int gQb;
    private float gQc;
    private float gQd;
    private float gQe;
    private float gQf;
    private b gQg;
    private float gQh;
    private float gQi;
    private float gQj;
    private float gQk;
    private boolean gQl;
    private float gQm;
    private int gQn;
    private int gQo;
    private int gQp;
    private int gQq;
    private int gQr;
    private float gQs;
    private float gQt;
    private int gQu;
    private float gQv;
    private int gQw;
    private Map<String, Bitmap> gQx;
    float gtp;
    float gtq;
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
        this.gPW = 0;
        this.gQf = 1.0f;
        this.fXz = 1.0f;
        this.gQl = true;
        this.gQx = new HashMap();
        this.startTime = 0L;
        this.gtp = 0.0f;
        this.gtq = 0.0f;
        this.mScreenWidth = l.ac(TbadkCoreApplication.getInst());
        this.gQm = l.f(getContext(), d.e.fontsize40);
        this.gQu = l.f(getContext(), d.e.ds2);
        this.cvz = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gPQ = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gPQ);
        this.gPQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.f(view, motionEvent);
                        if (CoverPendantDragView.this.gPW == 4) {
                            CoverPendantDragView.this.bBB();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.EP);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bKr);
                        if (!CoverPendantDragView.this.gPX && abs < CoverPendantDragView.this.cvz && abs2 < CoverPendantDragView.this.cvz && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBC();
                        }
                        CoverPendantDragView.this.gPY = 0.0f;
                        CoverPendantDragView.this.gPZ = 0.0f;
                        CoverPendantDragView.this.gPX = false;
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
                        CoverPendantDragView.this.gPY = 0.0f;
                        CoverPendantDragView.this.gPZ = 0.0f;
                        return true;
                }
            }
        });
        this.gPU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gPT.setText("");
                CoverPendantDragView.this.bkn();
            }
        });
        this.gPV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.f(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gPZ = 0.0f;
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
        this.gPT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gPW != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gPS.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hb(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gPS.getText().length()) {
                        CoverPendantDragView.this.ud(obj);
                    } else {
                        CoverPendantDragView.this.uc(obj);
                    }
                } else {
                    String E = w.E(obj, 20);
                    editable.delete(obj.lastIndexOf(E) + E.length(), obj.length());
                    CoverPendantDragView.this.ud(E);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gPS.setText(editable.toString());
            }
        });
        this.gPT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gPQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, MotionEvent motionEvent) {
        this.EP = motionEvent.getRawX();
        this.bKr = motionEvent.getRawY();
        this.mLastX = this.EP;
        this.mLastY = this.bKr;
        this.gQc = (this.gPQ.getWidth() / 2) + this.gPQ.getX();
        this.gQd = (this.gPQ.getHeight() / 2) + this.gPQ.getY();
        this.gPS.setText(this.gPT.getText());
        this.gPS.setVisibility(0);
        this.gPT.setVisibility(8);
        setEditTextEnable(false);
        this.gQg.HidenSoftKeyPad(this.gPT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(String str) {
        TextPaint paint = this.gPT.getPaint();
        float measureText = paint.measureText(str);
        while (this.gPT.getLineCount() == 1 && this.gPT.getTextSize() < this.gQm * this.fXz && measureText < this.gQt * this.fXz) {
            setTextSize(0, this.gPT.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hb(str) <= w.hb(getResources().getString(d.j.cover_hint)) && this.gPT.getTextSize() != this.gQm * this.fXz) {
            setTextSize(0, this.gQm * this.fXz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(String str) {
        TextPaint paint = this.gPT.getPaint();
        float measureText = paint.measureText(str);
        while (this.gPT.getTextSize() > ((this.gQs * this.fXz) / 2.0f) - (this.gQv * this.fXz) && measureText > this.gQt * this.fXz) {
            setTextSize(0, this.gPT.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.gPT.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gPT.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), d.e.ds120)) {
            str = w.H(str, w.ha(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gQg = bVar;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.gQh = f;
        this.gQi = f2;
        this.gQj = f3;
        this.gQk = f4;
        if (this.gQh > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gQh, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gQi > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gQi);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gQj > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gQj) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gQk > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gQk) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.gQc - rawX);
        float abs4 = Math.abs(this.gQd - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gQc - this.mLastX);
        float abs6 = Math.abs(this.gQd - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        ca(sqrt, (int) (sqrt / this.gQe));
        if (this.gPZ != 0.0f) {
            this.gPQ.setRotation(this.gPQ.getRotation() - (this.gPZ - L));
        }
        this.gPZ = L;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void ca(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gPQ.getLayoutParams();
        int width = this.gPQ.getWidth() - i;
        int i3 = (int) (width / this.gQe);
        if (width < this.gQa) {
            width = this.gQa;
            i3 = (int) (width / this.gQe);
        }
        this.fXz = ((width * 1.0f) - (this.gQr * 2)) / (this.gQw - (this.gQr * 2));
        this.mContentView.setPadding((int) (this.gQn * this.fXz), (int) (this.gQo * this.fXz), (int) (this.gQp * this.fXz), (int) (this.gQq * this.fXz));
        setTextSize(0, (this.gPT.getTextSize() * i3) / this.gPQ.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gPQ.setLayoutParams(layoutParams);
        float f = this.gQc - (layoutParams.width / 2);
        float f2 = this.gQd - (layoutParams.height / 2);
        this.gPQ.setX(f);
        this.gPQ.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gPW != 4) {
            float y = (this.gPQ.getY() + rawY) - this.mLastY;
            if (y < this.gQi) {
                y = this.gQi;
            } else if (y > (this.gQi + this.mVideoHeight) - this.gPQ.getHeight()) {
                y = (this.gQi + this.mVideoHeight) - this.gPQ.getHeight();
            }
            this.gPQ.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gPX = true;
                float M = M(motionEvent);
                float K = K(motionEvent);
                if (this.gPY != 0.0f) {
                    int i = (int) (this.gPY - M);
                    ca(i, (int) (i / this.gQe));
                }
                if (this.gPZ != 0.0f) {
                    this.gPQ.setRotation(this.gPQ.getRotation() - (this.gPZ - K));
                }
                this.gPZ = K;
                this.gPY = M;
            } else if (!this.gPX && pointerCount == 1) {
                float y2 = (this.gPQ.getY() + rawY) - this.mLastY;
                if (y2 < this.gQi - (this.gPQ.getHeight() / 2)) {
                    y2 = this.gQi - (this.gPQ.getHeight() / 2);
                } else if (y2 > ((this.gQi + this.mVideoHeight) - this.gPQ.getHeight()) + (this.gPQ.getHeight() / 2)) {
                    y2 = ((this.gQi + this.mVideoHeight) - this.gPQ.getHeight()) + (this.gPQ.getHeight() / 2);
                }
                float x = (this.gPQ.getX() + rawX) - this.mLastX;
                if (x < this.gQh - (this.gPQ.getWidth() / 2)) {
                    x = this.gQh - (this.gPQ.getWidth() / 2);
                } else if (x > ((this.gQh + this.mVideoWidth) - this.gPQ.getWidth()) + (this.gPQ.getWidth() / 2)) {
                    x = ((this.gQh + this.mVideoWidth) - this.gPQ.getWidth()) + (this.gPQ.getWidth() / 2);
                }
                this.gPQ.setX(x);
                this.gPQ.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gPT.getTextSize() != f) {
            this.gPT.setTextSize(i, f);
        }
        if (this.gPS.getTextSize() != f) {
            this.gPS.setTextSize(i, f);
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
        matrix.postRotate(this.gPQ.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float L(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gQd - motionEvent.getRawY(), this.gQc - motionEvent.getRawX()));
    }

    private float M(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cvz && Math.abs(motionEvent.getRawY() - this.bKr) < this.cvz;
    }

    private void init() {
        this.gPR = (RotateFrameLayout) this.gPQ.findViewById(d.g.content_container);
        this.gPS = (TextView) this.gPQ.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gPQ.findViewById(d.g.content_view);
        this.gPT = (EditText) this.gPQ.findViewById(d.g.cover_edit);
        this.gPU = (ImageView) this.gPQ.findViewById(d.g.cover_delete);
        this.gPV = (ImageView) this.gPQ.findViewById(d.g.cover_scale);
    }

    public void bkn() {
        this.gPS.setText(this.gPT.getText());
        this.gPS.setVisibility(0);
        this.gPT.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gPS.getText())) {
            this.gPW = 0;
            this.gPQ.setVisibility(8);
        }
        if (this.gPW == 4) {
            bBA();
        }
        this.gQg.HidenSoftKeyPad(this.gPT);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gPT.setFocusable(true);
            this.gPT.setFocusableInTouchMode(true);
            this.gPT.requestFocus();
            return;
        }
        this.gPT.setFocusable(false);
        this.gPT.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gPT.setText("");
                    bkn();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBC();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBC();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBC();
                    break;
                default:
                    bkn();
                    String ub = com.baidu.tieba.video.editvideo.model.b.bBv().ub(pendantData.resource);
                    if (TextUtils.isEmpty(ub)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.gOJ.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBv().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(ub, pendantData);
                        break;
                    }
                    break;
            }
            this.gPW = pendantData.pendantType;
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
        bBA();
        a(this.mVideoWidth, l.f(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gPW == 4 || this.gPW == 0) {
            this.gPQ.setX(this.gQh);
            this.gPQ.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.gQi);
            String obj = this.gPT.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gPT.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gPS.setText(a2);
                    this.gPT.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBA() {
        if (this.gQl) {
            this.gQl = false;
            this.gPU.setVisibility(8);
            this.gPV.setVisibility(8);
            this.gPR.setBackgroundColor(getResources().getColor(d.C0082d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBB() {
        if (!this.gQl) {
            this.gQl = true;
            this.gPU.setVisibility(0);
            this.gPV.setVisibility(0);
            this.gPR.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.gQx.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gQx.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBA();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gQf = 1.0f;
                this.fXz = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gQf = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gQa = (this.gQr * 2) + width;
                this.gQb = (this.gQr * 2) + height;
                this.gQe = (this.gQa * 1.0f) / this.gQb;
                this.gPQ.setX((((this.mVideoWidth - i2) - (this.gQr * 2)) / 2) + this.gQh);
                this.gPQ.setY((((this.mVideoHeight - i) - (this.gQr * 2)) / 2) + this.gQi);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gtp = motionEvent.getRawX();
                this.gtq = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gtp);
                float abs2 = Math.abs(rawY - this.gtq);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cvz && abs2 < this.cvz && System.currentTimeMillis() - this.startTime < 300) {
                    bkn();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gPS == null || this.gPS.getText() == null) {
            return null;
        }
        return this.gPS.getText().toString();
    }

    public void bBC() {
        this.gPS.setText(this.gPT.getText());
        this.gPS.setVisibility(8);
        this.gPT.setVisibility(0);
        setEditTextEnable(true);
        this.gQg.ShowSoftKeyPad(this.gPT);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gPT.setTextAppearance(getContext(), d.k.cover_text_style);
            this.gPS.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.gQr = 0;
            this.gPT.setMaxLines(1);
            this.gPS.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gPS.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gPT.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.gPT.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gPS.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.gQr = l.f(getContext(), d.e.ds40);
            this.gPT.setMaxLines(2);
            this.gPS.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gPS.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gPT.setLayoutParams(layoutParams2);
            this.gQn = (int) (l.dip2px(getContext(), pendantData.left) * this.gQf);
            this.gQo = (int) (l.dip2px(getContext(), pendantData.top) * this.gQf);
            this.gQp = (int) (l.dip2px(getContext(), pendantData.right) * this.gQf);
            this.gQq = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gQf);
            this.mContentView.setPadding(this.gQn, this.gQo, this.gQp, this.gQq);
            this.gQm = l.f(getContext(), d.e.fontsize40) * this.gQf;
            String text = getText();
            this.gQs = (i2 - this.gQo) - this.gQq;
            this.gQt = (i - this.gQn) - this.gQp;
            this.gQv = this.gQu + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.gQm);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.gQt);
                this.gQm = this.gPT.getTextSize();
                bBB();
                bBC();
            } else {
                if (w.hb(text) > 20) {
                    text = w.E(text, 20);
                    this.gPT.setText(text);
                    this.gPS.setText(text);
                }
                ud(text);
            }
        }
        this.gPS.setIncludeFontPadding(false);
        this.gPT.setIncludeFontPadding(false);
        this.gPS.setLineSpacing(this.gQu, 1.0f);
        this.gPT.setLineSpacing(this.gQu, 1.0f);
        this.gPQ.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gPQ.getLayoutParams();
        layoutParams3.height = (this.gQr * 2) + i2;
        layoutParams3.width = (this.gQr * 2) + i;
        this.gPQ.setLayoutParams(layoutParams3);
        this.gQw = (this.gQr * 2) + i;
        ((FrameLayout.LayoutParams) this.gPR.getLayoutParams()).setMargins(this.gQr, this.gQr, this.gQr, this.gQr);
        this.gPQ.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBD();
        }
        return this.mTempBitmap;
    }

    private void bBD() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBE() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nD(boolean z) {
        if (this.gPW != 0) {
            if (z) {
                bBE();
                this.gPQ.setVisibility(0);
                return;
            }
            bkn();
            getTempBitmap();
            this.gPQ.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gQx.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gQx.clear();
        this.gQx = null;
        bBE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<CoverPendantDragView> gQA;
        WeakReference<PendantData> gQB;
        WeakReference<a.b> gQz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gQz = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gQA = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gQB = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cm(String str, String str2) {
            if (this.gQz != null && this.gQz.get() != null) {
                this.gQz.get().gOJ.setVisibility(8);
            }
            if (this.gQA != null && this.gQA.get() != null && this.gQB != null && this.gQB.get() != null) {
                this.gQA.get().a(str2, this.gQB.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tR(String str) {
            if (this.gQz != null && this.gQz.get() != null) {
                this.gQz.get().gOJ.setVisibility(8);
            }
            if (this.gQA != null && this.gQA.get() != null) {
                l.showToast(this.gQA.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAF() {
            if (this.gQz != null && this.gQz.get() != null) {
                this.gQz.get().gOJ.setVisibility(8);
            }
        }
    }
}
