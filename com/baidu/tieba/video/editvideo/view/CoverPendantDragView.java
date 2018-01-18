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
    private float czp;
    private float doJ;
    private float gDm;
    private float hpA;
    private float hpB;
    private float hpC;
    private float hpD;
    private boolean hpE;
    private float hpF;
    private int hpG;
    private int hpH;
    private int hpI;
    private int hpJ;
    private int hpK;
    private float hpL;
    private float hpM;
    private int hpN;
    private float hpO;
    private int hpP;
    private Map<String, Bitmap> hpQ;
    float hpR;
    float hpS;
    private FrameLayout hpj;
    private RotateFrameLayout hpk;
    private TextView hpl;
    private EditText hpm;
    private ImageView hpn;
    private ImageView hpo;
    private int hpp;
    private boolean hpq;
    private float hpr;
    private float hps;
    private int hpt;
    private int hpu;
    private float hpv;
    private float hpw;
    private float hpx;
    private float hpy;
    private b hpz;
    private FrameLayout mContentView;
    private float mDownX;
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
        this.hpp = 0;
        this.hpy = 1.0f;
        this.gDm = 1.0f;
        this.hpE = true;
        this.hpQ = new HashMap();
        this.startTime = 0L;
        this.hpR = 0.0f;
        this.hpS = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hpF = l.s(getContext(), d.e.fontsize40);
        this.hpN = l.s(getContext(), d.e.ds2);
        this.doJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hpj = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hpj);
        this.hpj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hpp == 4) {
                            CoverPendantDragView.this.bBc();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.czp);
                        if (!CoverPendantDragView.this.hpq && abs < CoverPendantDragView.this.doJ && abs2 < CoverPendantDragView.this.doJ && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBd();
                        }
                        CoverPendantDragView.this.hpr = 0.0f;
                        CoverPendantDragView.this.hps = 0.0f;
                        CoverPendantDragView.this.hpq = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
                            CoverPendantDragView.this.K(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.hpr = 0.0f;
                        CoverPendantDragView.this.hps = 0.0f;
                        return true;
                }
            }
        });
        this.hpn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hpm.setText("");
                CoverPendantDragView.this.blv();
            }
        });
        this.hpo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hps = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
                            CoverPendantDragView.this.J(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.hpm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hpp != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hpl.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hd(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hpl.getText().length()) {
                        CoverPendantDragView.this.tE(obj);
                    } else {
                        CoverPendantDragView.this.tD(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(obj.lastIndexOf(F) + F.length(), obj.length());
                    CoverPendantDragView.this.tE(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hpl.setText(editable.toString());
            }
        });
        this.hpm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hpj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.czp = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.czp;
        this.hpv = (this.hpj.getWidth() / 2) + this.hpj.getX();
        this.hpw = (this.hpj.getHeight() / 2) + this.hpj.getY();
        this.hpl.setText(this.hpm.getText());
        this.hpl.setVisibility(0);
        this.hpm.setVisibility(8);
        setEditTextEnable(false);
        this.hpz.HidenSoftKeyPad(this.hpm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD(String str) {
        TextPaint paint = this.hpm.getPaint();
        float measureText = paint.measureText(str);
        while (this.hpm.getLineCount() == 1 && this.hpm.getTextSize() < this.hpF * this.gDm && measureText < this.hpM * this.gDm) {
            setTextSize(0, this.hpm.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hd(str) <= w.hd(getResources().getString(d.j.cover_hint)) && this.hpm.getTextSize() != this.hpF * this.gDm) {
            setTextSize(0, this.hpF * this.gDm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(String str) {
        TextPaint paint = this.hpm.getPaint();
        float measureText = paint.measureText(str);
        while (this.hpm.getTextSize() > ((this.hpL * this.gDm) / 2.0f) - (this.hpO * this.gDm) && measureText > this.hpM * this.gDm) {
            setTextSize(0, this.hpm.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.hpm.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hpm.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.s(getContext(), d.e.ds120)) {
            str = w.I(str, w.hc(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hpz = bVar;
    }

    public void j(float f, float f2, float f3, float f4) {
        this.hpA = f;
        this.hpB = f2;
        this.hpC = f3;
        this.hpD = f4;
        if (this.hpA > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hpA, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hpB > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hpB);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hpC > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hpC) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hpD > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hpD) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float M = M(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hpv - rawX);
        float abs4 = Math.abs(this.hpw - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hpv - this.mLastX);
        float abs6 = Math.abs(this.hpw - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cR(sqrt, (int) (sqrt / this.hpx));
        if (this.hps != 0.0f) {
            this.hpj.setRotation(this.hpj.getRotation() - (this.hps - M));
        }
        this.hps = M;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cR(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpj.getLayoutParams();
        int width = this.hpj.getWidth() - i;
        int i3 = (int) (width / this.hpx);
        if (width < this.hpt) {
            width = this.hpt;
            i3 = (int) (width / this.hpx);
        }
        this.gDm = ((width * 1.0f) - (this.hpK * 2)) / (this.hpP - (this.hpK * 2));
        this.mContentView.setPadding((int) (this.hpG * this.gDm), (int) (this.hpH * this.gDm), (int) (this.hpI * this.gDm), (int) (this.hpJ * this.gDm));
        setTextSize(0, (this.hpm.getTextSize() * i3) / this.hpj.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hpj.setLayoutParams(layoutParams);
        float f = this.hpv - (layoutParams.width / 2);
        float f2 = this.hpw - (layoutParams.height / 2);
        this.hpj.setX(f);
        this.hpj.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hpp != 4) {
            float y = (this.hpj.getY() + rawY) - this.mLastY;
            if (y < this.hpB) {
                y = this.hpB;
            } else if (y > (this.hpB + this.mVideoHeight) - this.hpj.getHeight()) {
                y = (this.hpB + this.mVideoHeight) - this.hpj.getHeight();
            }
            this.hpj.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hpq = true;
                float N = N(motionEvent);
                float L = L(motionEvent);
                if (this.hpr != 0.0f) {
                    int i = (int) (this.hpr - N);
                    cR(i, (int) (i / this.hpx));
                }
                if (this.hps != 0.0f) {
                    this.hpj.setRotation(this.hpj.getRotation() - (this.hps - L));
                }
                this.hps = L;
                this.hpr = N;
            } else if (!this.hpq && pointerCount == 1) {
                float y2 = (this.hpj.getY() + rawY) - this.mLastY;
                if (y2 < this.hpB - (this.hpj.getHeight() / 2)) {
                    y2 = this.hpB - (this.hpj.getHeight() / 2);
                } else if (y2 > ((this.hpB + this.mVideoHeight) - this.hpj.getHeight()) + (this.hpj.getHeight() / 2)) {
                    y2 = ((this.hpB + this.mVideoHeight) - this.hpj.getHeight()) + (this.hpj.getHeight() / 2);
                }
                float x = (this.hpj.getX() + rawX) - this.mLastX;
                if (x < this.hpA - (this.hpj.getWidth() / 2)) {
                    x = this.hpA - (this.hpj.getWidth() / 2);
                } else if (x > ((this.hpA + this.mVideoWidth) - this.hpj.getWidth()) + (this.hpj.getWidth() / 2)) {
                    x = ((this.hpA + this.mVideoWidth) - this.hpj.getWidth()) + (this.hpj.getWidth() / 2);
                }
                this.hpj.setX(x);
                this.hpj.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hpm.getTextSize() != f) {
            this.hpm.setTextSize(i, f);
        }
        if (this.hpl.getTextSize() != f) {
            this.hpl.setTextSize(i, f);
        }
    }

    private float L(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.hpj.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float M(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hpw - motionEvent.getRawY(), this.hpv - motionEvent.getRawX()));
    }

    private float N(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.doJ && Math.abs(motionEvent.getRawY() - this.czp) < this.doJ;
    }

    private void init() {
        this.hpk = (RotateFrameLayout) this.hpj.findViewById(d.g.content_container);
        this.hpl = (TextView) this.hpj.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hpj.findViewById(d.g.content_view);
        this.hpm = (EditText) this.hpj.findViewById(d.g.cover_edit);
        this.hpn = (ImageView) this.hpj.findViewById(d.g.cover_delete);
        this.hpo = (ImageView) this.hpj.findViewById(d.g.cover_scale);
    }

    public void blv() {
        this.hpl.setText(this.hpm.getText());
        this.hpl.setVisibility(0);
        this.hpm.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hpl.getText())) {
            this.hpp = 0;
            this.hpj.setVisibility(8);
        }
        if (this.hpp == 4) {
            bBb();
        }
        this.hpz.HidenSoftKeyPad(this.hpm);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hpm.setFocusable(true);
            this.hpm.setFocusableInTouchMode(true);
            this.hpm.requestFocus();
            return;
        }
        this.hpm.setFocusable(false);
        this.hpm.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hpm.setText("");
                    blv();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBd();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBd();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBd();
                    break;
                default:
                    blv();
                    String tC = com.baidu.tieba.video.editvideo.model.b.bAW().tC(pendantData.resource);
                    if (TextUtils.isEmpty(tC)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hoc.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bAW().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tC, pendantData);
                        break;
                    }
                    break;
            }
            this.hpp = pendantData.pendantType;
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
        bBb();
        a(this.mVideoWidth, l.s(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hpp == 4 || this.hpp == 0) {
            this.hpj.setX(this.hpA);
            this.hpj.setY(((this.mVideoHeight - l.s(getContext(), d.e.ds100)) / 2) + this.hpB);
            String obj = this.hpm.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hpm.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hpl.setText(a2);
                    this.hpm.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBb() {
        if (this.hpE) {
            this.hpE = false;
            this.hpn.setVisibility(8);
            this.hpo.setVisibility(8);
            this.hpk.setBackgroundColor(getResources().getColor(d.C0107d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBc() {
        if (!this.hpE) {
            this.hpE = true;
            this.hpn.setVisibility(0);
            this.hpo.setVisibility(0);
            this.hpk.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hpQ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hpQ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBb();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hpy = 1.0f;
                this.gDm = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hpy = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hpt = (this.hpK * 2) + width;
                this.hpu = (this.hpK * 2) + height;
                this.hpx = (this.hpt * 1.0f) / this.hpu;
                this.hpj.setX((((this.mVideoWidth - i2) - (this.hpK * 2)) / 2) + this.hpA);
                this.hpj.setY((((this.mVideoHeight - i) - (this.hpK * 2)) / 2) + this.hpB);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hpR = motionEvent.getRawX();
                this.hpS = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hpR);
                float abs2 = Math.abs(rawY - this.hpS);
                if (motionEvent.getPointerCount() <= 1 && abs < this.doJ && abs2 < this.doJ && System.currentTimeMillis() - this.startTime < 300) {
                    blv();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hpl == null || this.hpl.getText() == null) {
            return null;
        }
        return this.hpl.getText().toString();
    }

    public void bBd() {
        this.hpl.setText(this.hpm.getText());
        this.hpl.setVisibility(8);
        this.hpm.setVisibility(0);
        setEditTextEnable(true);
        this.hpz.ShowSoftKeyPad(this.hpm);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hpm.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hpl.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.s(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.s(getContext(), d.e.fontsize40) * i) / i3);
            this.hpK = 0;
            this.hpm.setMaxLines(1);
            this.hpl.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpl.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hpm.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.s(getContext(), d.e.ds60), 0, l.s(getContext(), d.e.ds60), 0);
        } else {
            this.hpm.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hpl.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hpK = l.s(getContext(), d.e.ds40);
            this.hpm.setMaxLines(2);
            this.hpl.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hpl.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hpm.setLayoutParams(layoutParams2);
            this.hpG = (int) (l.dip2px(getContext(), pendantData.left) * this.hpy);
            this.hpH = (int) (l.dip2px(getContext(), pendantData.top) * this.hpy);
            this.hpI = (int) (l.dip2px(getContext(), pendantData.right) * this.hpy);
            this.hpJ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hpy);
            this.mContentView.setPadding(this.hpG, this.hpH, this.hpI, this.hpJ);
            this.hpF = l.s(getContext(), d.e.fontsize40) * this.hpy;
            String text = getText();
            this.hpL = (i2 - this.hpH) - this.hpJ;
            this.hpM = (i - this.hpG) - this.hpI;
            this.hpO = this.hpN + l.s(getContext(), d.e.ds6);
            setTextSize(0, this.hpF);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.hpM);
                this.hpF = this.hpm.getTextSize();
                bBc();
                bBd();
            } else {
                if (w.hd(text) > 20) {
                    text = w.F(text, 20);
                    this.hpm.setText(text);
                    this.hpl.setText(text);
                }
                tE(text);
            }
        }
        this.hpl.setIncludeFontPadding(false);
        this.hpm.setIncludeFontPadding(false);
        this.hpl.setLineSpacing(this.hpN, 1.0f);
        this.hpm.setLineSpacing(this.hpN, 1.0f);
        this.hpj.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hpj.getLayoutParams();
        layoutParams3.height = (this.hpK * 2) + i2;
        layoutParams3.width = (this.hpK * 2) + i;
        this.hpj.setLayoutParams(layoutParams3);
        this.hpP = (this.hpK * 2) + i;
        ((FrameLayout.LayoutParams) this.hpk.getLayoutParams()).setMargins(this.hpK, this.hpK, this.hpK, this.hpK);
        this.hpj.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBe();
        }
        return this.mTempBitmap;
    }

    private void bBe() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBf() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nb(boolean z) {
        if (this.hpp != 0) {
            if (z) {
                bBf();
                this.hpj.setVisibility(0);
                return;
            }
            blv();
            getTempBitmap();
            this.hpj.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hpQ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hpQ.clear();
        this.hpQ = null;
        bBf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hpU;
        WeakReference<CoverPendantDragView> hpV;
        WeakReference<PendantData> hpW;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hpU = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hpV = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hpW = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ci(String str, String str2) {
            if (this.hpU != null && this.hpU.get() != null) {
                this.hpU.get().hoc.setVisibility(8);
            }
            if (this.hpV != null && this.hpV.get() != null && this.hpW != null && this.hpW.get() != null) {
                this.hpV.get().a(str2, this.hpW.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ts(String str) {
            if (this.hpU != null && this.hpU.get() != null) {
                this.hpU.get().hoc.setVisibility(8);
            }
            if (this.hpV != null && this.hpV.get() != null) {
                l.showToast(this.hpV.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAg() {
            if (this.hpU != null && this.hpU.get() != null) {
                this.hpU.get().hoc.setVisibility(8);
            }
        }
    }
}
