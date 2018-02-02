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
    private float czA;
    private float dpe;
    private float gDH;
    private FrameLayout hpD;
    private RotateFrameLayout hpE;
    private TextView hpF;
    private EditText hpG;
    private ImageView hpH;
    private ImageView hpI;
    private int hpJ;
    private boolean hpK;
    private float hpL;
    private float hpM;
    private int hpN;
    private int hpO;
    private float hpP;
    private float hpQ;
    private float hpR;
    private float hpS;
    private b hpT;
    private float hpU;
    private float hpV;
    private float hpW;
    private float hpX;
    private boolean hpY;
    private float hpZ;
    private int hqa;
    private int hqb;
    private int hqc;
    private int hqd;
    private int hqe;
    private float hqf;
    private float hqg;
    private int hqh;
    private float hqi;
    private int hqj;
    private Map<String, Bitmap> hqk;
    float hql;
    float hqm;
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
        this.hpJ = 0;
        this.hpS = 1.0f;
        this.gDH = 1.0f;
        this.hpY = true;
        this.hqk = new HashMap();
        this.startTime = 0L;
        this.hql = 0.0f;
        this.hqm = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hpZ = l.s(getContext(), d.e.fontsize40);
        this.hqh = l.s(getContext(), d.e.ds2);
        this.dpe = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hpD = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hpD);
        this.hpD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hpJ == 4) {
                            CoverPendantDragView.this.bBe();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.czA);
                        if (!CoverPendantDragView.this.hpK && abs < CoverPendantDragView.this.dpe && abs2 < CoverPendantDragView.this.dpe && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBf();
                        }
                        CoverPendantDragView.this.hpL = 0.0f;
                        CoverPendantDragView.this.hpM = 0.0f;
                        CoverPendantDragView.this.hpK = false;
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
                        CoverPendantDragView.this.hpL = 0.0f;
                        CoverPendantDragView.this.hpM = 0.0f;
                        return true;
                }
            }
        });
        this.hpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hpG.setText("");
                CoverPendantDragView.this.blw();
            }
        });
        this.hpI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hpM = 0.0f;
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
        this.hpG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hpJ != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hpF.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hl(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hpF.getText().length()) {
                        CoverPendantDragView.this.tM(obj);
                    } else {
                        CoverPendantDragView.this.tL(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(obj.lastIndexOf(F) + F.length(), obj.length());
                    CoverPendantDragView.this.tM(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hpF.setText(editable.toString());
            }
        });
        this.hpG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hpD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.czA = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.czA;
        this.hpP = (this.hpD.getWidth() / 2) + this.hpD.getX();
        this.hpQ = (this.hpD.getHeight() / 2) + this.hpD.getY();
        this.hpF.setText(this.hpG.getText());
        this.hpF.setVisibility(0);
        this.hpG.setVisibility(8);
        setEditTextEnable(false);
        this.hpT.HidenSoftKeyPad(this.hpG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(String str) {
        TextPaint paint = this.hpG.getPaint();
        float measureText = paint.measureText(str);
        while (this.hpG.getLineCount() == 1 && this.hpG.getTextSize() < this.hpZ * this.gDH && measureText < this.hqg * this.gDH) {
            setTextSize(0, this.hpG.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hl(str) <= w.hl(getResources().getString(d.j.cover_hint)) && this.hpG.getTextSize() != this.hpZ * this.gDH) {
            setTextSize(0, this.hpZ * this.gDH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(String str) {
        TextPaint paint = this.hpG.getPaint();
        float measureText = paint.measureText(str);
        while (this.hpG.getTextSize() > ((this.hqf * this.gDH) / 2.0f) - (this.hqi * this.gDH) && measureText > this.hqg * this.gDH) {
            setTextSize(0, this.hpG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.hpG.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hpG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.s(getContext(), d.e.ds120)) {
            str = w.I(str, w.hk(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hpT = bVar;
    }

    public void j(float f, float f2, float f3, float f4) {
        this.hpU = f;
        this.hpV = f2;
        this.hpW = f3;
        this.hpX = f4;
        if (this.hpU > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hpU, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hpV > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hpV);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hpW > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hpW) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hpX > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hpX) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.hpP - rawX);
        float abs4 = Math.abs(this.hpQ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hpP - this.mLastX);
        float abs6 = Math.abs(this.hpQ - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cR(sqrt, (int) (sqrt / this.hpR));
        if (this.hpM != 0.0f) {
            this.hpD.setRotation(this.hpD.getRotation() - (this.hpM - M));
        }
        this.hpM = M;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cR(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpD.getLayoutParams();
        int width = this.hpD.getWidth() - i;
        int i3 = (int) (width / this.hpR);
        if (width < this.hpN) {
            width = this.hpN;
            i3 = (int) (width / this.hpR);
        }
        this.gDH = ((width * 1.0f) - (this.hqe * 2)) / (this.hqj - (this.hqe * 2));
        this.mContentView.setPadding((int) (this.hqa * this.gDH), (int) (this.hqb * this.gDH), (int) (this.hqc * this.gDH), (int) (this.hqd * this.gDH));
        setTextSize(0, (this.hpG.getTextSize() * i3) / this.hpD.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hpD.setLayoutParams(layoutParams);
        float f = this.hpP - (layoutParams.width / 2);
        float f2 = this.hpQ - (layoutParams.height / 2);
        this.hpD.setX(f);
        this.hpD.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hpJ != 4) {
            float y = (this.hpD.getY() + rawY) - this.mLastY;
            if (y < this.hpV) {
                y = this.hpV;
            } else if (y > (this.hpV + this.mVideoHeight) - this.hpD.getHeight()) {
                y = (this.hpV + this.mVideoHeight) - this.hpD.getHeight();
            }
            this.hpD.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hpK = true;
                float N = N(motionEvent);
                float L = L(motionEvent);
                if (this.hpL != 0.0f) {
                    int i = (int) (this.hpL - N);
                    cR(i, (int) (i / this.hpR));
                }
                if (this.hpM != 0.0f) {
                    this.hpD.setRotation(this.hpD.getRotation() - (this.hpM - L));
                }
                this.hpM = L;
                this.hpL = N;
            } else if (!this.hpK && pointerCount == 1) {
                float y2 = (this.hpD.getY() + rawY) - this.mLastY;
                if (y2 < this.hpV - (this.hpD.getHeight() / 2)) {
                    y2 = this.hpV - (this.hpD.getHeight() / 2);
                } else if (y2 > ((this.hpV + this.mVideoHeight) - this.hpD.getHeight()) + (this.hpD.getHeight() / 2)) {
                    y2 = ((this.hpV + this.mVideoHeight) - this.hpD.getHeight()) + (this.hpD.getHeight() / 2);
                }
                float x = (this.hpD.getX() + rawX) - this.mLastX;
                if (x < this.hpU - (this.hpD.getWidth() / 2)) {
                    x = this.hpU - (this.hpD.getWidth() / 2);
                } else if (x > ((this.hpU + this.mVideoWidth) - this.hpD.getWidth()) + (this.hpD.getWidth() / 2)) {
                    x = ((this.hpU + this.mVideoWidth) - this.hpD.getWidth()) + (this.hpD.getWidth() / 2);
                }
                this.hpD.setX(x);
                this.hpD.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hpG.getTextSize() != f) {
            this.hpG.setTextSize(i, f);
        }
        if (this.hpF.getTextSize() != f) {
            this.hpF.setTextSize(i, f);
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
        matrix.postRotate(this.hpD.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float M(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hpQ - motionEvent.getRawY(), this.hpP - motionEvent.getRawX()));
    }

    private float N(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dpe && Math.abs(motionEvent.getRawY() - this.czA) < this.dpe;
    }

    private void init() {
        this.hpE = (RotateFrameLayout) this.hpD.findViewById(d.g.content_container);
        this.hpF = (TextView) this.hpD.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hpD.findViewById(d.g.content_view);
        this.hpG = (EditText) this.hpD.findViewById(d.g.cover_edit);
        this.hpH = (ImageView) this.hpD.findViewById(d.g.cover_delete);
        this.hpI = (ImageView) this.hpD.findViewById(d.g.cover_scale);
    }

    public void blw() {
        this.hpF.setText(this.hpG.getText());
        this.hpF.setVisibility(0);
        this.hpG.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hpF.getText())) {
            this.hpJ = 0;
            this.hpD.setVisibility(8);
        }
        if (this.hpJ == 4) {
            bBd();
        }
        this.hpT.HidenSoftKeyPad(this.hpG);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hpG.setFocusable(true);
            this.hpG.setFocusableInTouchMode(true);
            this.hpG.requestFocus();
            return;
        }
        this.hpG.setFocusable(false);
        this.hpG.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hpG.setText("");
                    blw();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBf();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBf();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBf();
                    break;
                default:
                    blw();
                    String tK = com.baidu.tieba.video.editvideo.model.b.bAY().tK(pendantData.resource);
                    if (TextUtils.isEmpty(tK)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.how.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bAY().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tK, pendantData);
                        break;
                    }
                    break;
            }
            this.hpJ = pendantData.pendantType;
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
        bBd();
        a(this.mVideoWidth, l.s(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hpJ == 4 || this.hpJ == 0) {
            this.hpD.setX(this.hpU);
            this.hpD.setY(((this.mVideoHeight - l.s(getContext(), d.e.ds100)) / 2) + this.hpV);
            String obj = this.hpG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hpG.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hpF.setText(a2);
                    this.hpG.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBd() {
        if (this.hpY) {
            this.hpY = false;
            this.hpH.setVisibility(8);
            this.hpI.setVisibility(8);
            this.hpE.setBackgroundColor(getResources().getColor(d.C0108d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (!this.hpY) {
            this.hpY = true;
            this.hpH.setVisibility(0);
            this.hpI.setVisibility(0);
            this.hpE.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hqk.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hqk.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBd();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hpS = 1.0f;
                this.gDH = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hpS = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hpN = (this.hqe * 2) + width;
                this.hpO = (this.hqe * 2) + height;
                this.hpR = (this.hpN * 1.0f) / this.hpO;
                this.hpD.setX((((this.mVideoWidth - i2) - (this.hqe * 2)) / 2) + this.hpU);
                this.hpD.setY((((this.mVideoHeight - i) - (this.hqe * 2)) / 2) + this.hpV);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hql = motionEvent.getRawX();
                this.hqm = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hql);
                float abs2 = Math.abs(rawY - this.hqm);
                if (motionEvent.getPointerCount() <= 1 && abs < this.dpe && abs2 < this.dpe && System.currentTimeMillis() - this.startTime < 300) {
                    blw();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hpF == null || this.hpF.getText() == null) {
            return null;
        }
        return this.hpF.getText().toString();
    }

    public void bBf() {
        this.hpF.setText(this.hpG.getText());
        this.hpF.setVisibility(8);
        this.hpG.setVisibility(0);
        setEditTextEnable(true);
        this.hpT.ShowSoftKeyPad(this.hpG);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hpG.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hpF.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.s(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.s(getContext(), d.e.fontsize40) * i) / i3);
            this.hqe = 0;
            this.hpG.setMaxLines(1);
            this.hpF.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hpF.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hpG.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.s(getContext(), d.e.ds60), 0, l.s(getContext(), d.e.ds60), 0);
        } else {
            this.hpG.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hpF.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hqe = l.s(getContext(), d.e.ds40);
            this.hpG.setMaxLines(2);
            this.hpF.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hpF.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hpG.setLayoutParams(layoutParams2);
            this.hqa = (int) (l.dip2px(getContext(), pendantData.left) * this.hpS);
            this.hqb = (int) (l.dip2px(getContext(), pendantData.top) * this.hpS);
            this.hqc = (int) (l.dip2px(getContext(), pendantData.right) * this.hpS);
            this.hqd = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hpS);
            this.mContentView.setPadding(this.hqa, this.hqb, this.hqc, this.hqd);
            this.hpZ = l.s(getContext(), d.e.fontsize40) * this.hpS;
            String text = getText();
            this.hqf = (i2 - this.hqb) - this.hqd;
            this.hqg = (i - this.hqa) - this.hqc;
            this.hqi = this.hqh + l.s(getContext(), d.e.ds6);
            setTextSize(0, this.hpZ);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.hqg);
                this.hpZ = this.hpG.getTextSize();
                bBe();
                bBf();
            } else {
                if (w.hl(text) > 20) {
                    text = w.F(text, 20);
                    this.hpG.setText(text);
                    this.hpF.setText(text);
                }
                tM(text);
            }
        }
        this.hpF.setIncludeFontPadding(false);
        this.hpG.setIncludeFontPadding(false);
        this.hpF.setLineSpacing(this.hqh, 1.0f);
        this.hpG.setLineSpacing(this.hqh, 1.0f);
        this.hpD.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hpD.getLayoutParams();
        layoutParams3.height = (this.hqe * 2) + i2;
        layoutParams3.width = (this.hqe * 2) + i;
        this.hpD.setLayoutParams(layoutParams3);
        this.hqj = (this.hqe * 2) + i;
        ((FrameLayout.LayoutParams) this.hpE.getLayoutParams()).setMargins(this.hqe, this.hqe, this.hqe, this.hqe);
        this.hpD.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBg();
        }
        return this.mTempBitmap;
    }

    private void bBg() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBh() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void ne(boolean z) {
        if (this.hpJ != 0) {
            if (z) {
                bBh();
                this.hpD.setVisibility(0);
                return;
            }
            blw();
            getTempBitmap();
            this.hpD.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hqk.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hqk.clear();
        this.hqk = null;
        bBh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hqo;
        WeakReference<CoverPendantDragView> hqp;
        WeakReference<PendantData> hqq;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hqo = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hqp = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hqq = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ch(String str, String str2) {
            if (this.hqo != null && this.hqo.get() != null) {
                this.hqo.get().how.setVisibility(8);
            }
            if (this.hqp != null && this.hqp.get() != null && this.hqq != null && this.hqq.get() != null) {
                this.hqp.get().a(str2, this.hqq.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tA(String str) {
            if (this.hqo != null && this.hqo.get() != null) {
                this.hqo.get().how.setVisibility(8);
            }
            if (this.hqp != null && this.hqp.get() != null) {
                l.showToast(this.hqp.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAi() {
            if (this.hqo != null && this.hqo.get() != null) {
                this.hqo.get().how.setVisibility(8);
            }
        }
    }
}
