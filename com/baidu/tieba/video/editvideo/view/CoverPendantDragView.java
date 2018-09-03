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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bgZ;
    private float cVA;
    private float fNj;
    private float gsA;
    private FrameLayout heF;
    private RotateFrameLayout heG;
    private TextView heH;
    private EditText heI;
    private ImageView heJ;
    private ImageView heK;
    private int heL;
    private float heM;
    private boolean heN;
    private float heO;
    private float heP;
    private int heQ;
    private int heR;
    private float heS;
    private float heT;
    private float heU;
    private float heV;
    private b heW;
    private float heX;
    private float heY;
    private float heZ;
    private float hfa;
    private boolean hfb;
    private float hfc;
    private int hfd;
    private int hfe;
    private int hff;
    private int hfg;
    private int hfh;
    private float hfi;
    private float hfj;
    private int hfk;
    private float hfl;
    private int hfm;
    private Map<String, Bitmap> hfn;
    private Bitmap hfo;
    float hfp;
    float hfq;
    private FrameLayout mContentView;
    private float mDownX;
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
        this.heL = 0;
        this.heV = 1.0f;
        this.gsA = 1.0f;
        this.hfb = true;
        this.hfn = new HashMap();
        this.startTime = 0L;
        this.hfp = 0.0f;
        this.hfq = 0.0f;
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
        this.hfc = l.f(getContext(), f.e.fontsize40);
        this.hfk = l.f(getContext(), f.e.ds2);
        this.cVA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.heF = (FrameLayout) LayoutInflater.from(getContext()).inflate(f.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.heF);
        this.heF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.heL == 4) {
                            CoverPendantDragView.this.bBo();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bgZ);
                        if (!CoverPendantDragView.this.heN && abs < CoverPendantDragView.this.cVA && abs2 < CoverPendantDragView.this.cVA && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBp();
                        }
                        CoverPendantDragView.this.heO = 0.0f;
                        CoverPendantDragView.this.heP = 0.0f;
                        CoverPendantDragView.this.heN = false;
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
                        CoverPendantDragView.this.heO = 0.0f;
                        CoverPendantDragView.this.heP = 0.0f;
                        return true;
                }
            }
        });
        this.heJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.heI.setText("");
                CoverPendantDragView.this.blH();
            }
        });
        this.heK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.heP = 0.0f;
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
        this.heI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.heL != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.heH.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), f.j.cover_text_length_max_tips);
                    }
                } else if (w.hJ(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.heH.getText().length()) {
                        CoverPendantDragView.this.uS(obj);
                    } else {
                        CoverPendantDragView.this.uR(obj);
                    }
                } else {
                    String B = w.B(obj, 20);
                    editable.delete(B.length(), obj.length());
                    CoverPendantDragView.this.uS(B);
                    l.showToast(CoverPendantDragView.this.getContext(), f.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.heH.setText(editable.toString());
            }
        });
        this.heI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.heF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bgZ = motionEvent.getRawY();
        this.heM = this.mDownX;
        this.fNj = this.bgZ;
        this.heS = (this.heF.getWidth() / 2) + this.heF.getX();
        this.heT = (this.heF.getHeight() / 2) + this.heF.getY();
        this.heH.setText(this.heI.getText());
        this.heH.setVisibility(0);
        this.heI.setVisibility(8);
        setEditTextEnable(false);
        this.heW.HidenSoftKeyPad(this.heI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uR(String str) {
        TextPaint paint = this.heI.getPaint();
        float measureText = paint.measureText(str);
        while (this.heI.getLineCount() == 1 && this.heI.getTextSize() < this.hfc * this.gsA && measureText < this.hfj * this.gsA) {
            setTextSize(0, this.heI.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hJ(str) <= w.hJ(getResources().getString(f.j.cover_hint)) && this.heI.getTextSize() != this.hfc * this.gsA) {
            setTextSize(0, this.hfc * this.gsA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(String str) {
        TextPaint paint = this.heI.getPaint();
        float measureText = paint.measureText(str);
        while (this.heI.getTextSize() > ((this.hfi * this.gsA) / 2.0f) - (this.hfl * this.gsA) && measureText > this.hfj * this.gsA) {
            setTextSize(0, this.heI.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.heI.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.heI.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), f.e.ds120)) {
            str = w.D(str, w.hI(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.heW = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.heX = f;
        this.heY = f2;
        this.heZ = f3;
        this.hfa = f4;
        if (this.heX > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.heX, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.heY > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.heY);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.heZ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.heZ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hfa > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hfa) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float K = K(motionEvent);
        float abs = Math.abs(this.heM - rawX);
        float abs2 = Math.abs(this.fNj - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.heS - rawX);
        float abs4 = Math.abs(this.heT - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.heS - this.heM);
        float abs6 = Math.abs(this.heT - this.fNj);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bO(sqrt, (int) (sqrt / this.heU));
        if (this.heP != 0.0f) {
            this.heF.setRotation(this.heF.getRotation() - (this.heP - K));
        }
        this.heP = K;
        this.heM = rawX;
        this.fNj = rawY;
    }

    private void bO(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heF.getLayoutParams();
        int width = this.heF.getWidth() - i;
        int i3 = (int) (width / this.heU);
        if (width < this.heQ) {
            width = this.heQ;
            i3 = (int) (width / this.heU);
        }
        this.gsA = ((width * 1.0f) - (this.hfh * 2)) / (this.hfm - (this.hfh * 2));
        this.mContentView.setPadding((int) (this.hfd * this.gsA), (int) (this.hfe * this.gsA), (int) (this.hff * this.gsA), (int) (this.hfg * this.gsA));
        setTextSize(0, (this.heI.getTextSize() * i3) / this.heF.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.heF.setLayoutParams(layoutParams);
        float f = this.heS - (layoutParams.width / 2);
        float f2 = this.heT - (layoutParams.height / 2);
        this.heF.setX(f);
        this.heF.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.heL != 4) {
            float y = (this.heF.getY() + rawY) - this.fNj;
            if (y < this.heY) {
                y = this.heY;
            } else if (y > (this.heY + this.mVideoHeight) - this.heF.getHeight()) {
                y = (this.heY + this.mVideoHeight) - this.heF.getHeight();
            }
            this.heF.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.heN = true;
                float L = L(motionEvent);
                float J = J(motionEvent);
                if (this.heO != 0.0f) {
                    int i = (int) (this.heO - L);
                    bO(i, (int) (i / this.heU));
                }
                if (this.heP != 0.0f) {
                    this.heF.setRotation(this.heF.getRotation() - (this.heP - J));
                }
                this.heP = J;
                this.heO = L;
            } else if (!this.heN && pointerCount == 1) {
                float y2 = (this.heF.getY() + rawY) - this.fNj;
                if (y2 < this.heY - (this.heF.getHeight() / 2)) {
                    y2 = this.heY - (this.heF.getHeight() / 2);
                } else if (y2 > ((this.heY + this.mVideoHeight) - this.heF.getHeight()) + (this.heF.getHeight() / 2)) {
                    y2 = ((this.heY + this.mVideoHeight) - this.heF.getHeight()) + (this.heF.getHeight() / 2);
                }
                float x = (this.heF.getX() + rawX) - this.heM;
                if (x < this.heX - (this.heF.getWidth() / 2)) {
                    x = this.heX - (this.heF.getWidth() / 2);
                } else if (x > ((this.heX + this.mVideoWidth) - this.heF.getWidth()) + (this.heF.getWidth() / 2)) {
                    x = ((this.heX + this.mVideoWidth) - this.heF.getWidth()) + (this.heF.getWidth() / 2);
                }
                this.heF.setX(x);
                this.heF.setY(y2);
            }
        }
        this.heM = rawX;
        this.fNj = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.heI.getTextSize() != f) {
            this.heI.setTextSize(i, f);
        }
        if (this.heH.getTextSize() != f) {
            this.heH.setTextSize(i, f);
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
        matrix.postRotate(this.heF.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float K(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.heT - motionEvent.getRawY(), this.heS - motionEvent.getRawX()));
    }

    private float L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cVA && Math.abs(motionEvent.getRawY() - this.bgZ) < this.cVA;
    }

    private void init() {
        this.heG = (RotateFrameLayout) this.heF.findViewById(f.g.content_container);
        this.heH = (TextView) this.heF.findViewById(f.g.cover_text);
        this.mContentView = (FrameLayout) this.heF.findViewById(f.g.content_view);
        this.heI = (EditText) this.heF.findViewById(f.g.cover_edit);
        this.heJ = (ImageView) this.heF.findViewById(f.g.cover_delete);
        this.heK = (ImageView) this.heF.findViewById(f.g.cover_scale);
    }

    public void blH() {
        this.heH.setText(this.heI.getText());
        this.heH.setVisibility(0);
        this.heI.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.heH.getText())) {
            this.heL = 0;
            this.heF.setVisibility(8);
        }
        if (this.heL == 4) {
            bBn();
        }
        this.heW.HidenSoftKeyPad(this.heI);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.heI.setFocusable(true);
            this.heI.setFocusableInTouchMode(true);
            this.heI.requestFocus();
            return;
        }
        this.heI.setFocusable(false);
        this.heI.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.heI.setText("");
                    blH();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(f.C0146f.bg_cover_edit_blue);
                    bBp();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(f.C0146f.bg_cover_edit_black);
                    bBp();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBp();
                    break;
                default:
                    blH();
                    String uQ = com.baidu.tieba.video.editvideo.model.b.bBi().uQ(pendantData.resource);
                    if (TextUtils.isEmpty(uQ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hdA.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBi().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(uQ, pendantData);
                        break;
                    }
                    break;
            }
            this.heL = pendantData.pendantType;
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
        bBn();
        a(this.mVideoWidth, l.f(getContext(), f.e.ds100), this.mScreenWidth, pendantData);
        if (this.heL == 4 || this.heL == 0) {
            this.heF.setX(this.heX);
            this.heF.setY(((this.mVideoHeight - l.f(getContext(), f.e.ds100)) / 2) + this.heY);
            String obj = this.heI.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.heI.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.heH.setText(a2);
                    this.heI.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBn() {
        if (this.hfb) {
            this.hfb = false;
            this.heJ.setVisibility(8);
            this.heK.setVisibility(8);
            this.heG.setBackgroundColor(getResources().getColor(f.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBo() {
        if (!this.hfb) {
            this.hfb = true;
            this.heJ.setVisibility(0);
            this.heK.setVisibility(0);
            this.heG.setBackgroundResource(f.C0146f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hfn != null) {
            Bitmap bitmap = this.hfn.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hfn.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBn();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.heV = 1.0f;
                this.gsA = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.heV = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.heQ = (this.hfh * 2) + width;
                this.heR = (this.hfh * 2) + height;
                this.heU = (this.heQ * 1.0f) / this.heR;
                this.heF.setX((((this.mVideoWidth - i2) - (this.hfh * 2)) / 2) + this.heX);
                this.heF.setY((((this.mVideoHeight - i) - (this.hfh * 2)) / 2) + this.heY);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hfp = motionEvent.getRawX();
                this.hfq = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hfp);
                float abs2 = Math.abs(rawY - this.hfq);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cVA && abs2 < this.cVA && System.currentTimeMillis() - this.startTime < 300) {
                    blH();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.heH == null || this.heH.getText() == null) {
            return null;
        }
        return this.heH.getText().toString();
    }

    public void bBp() {
        this.heH.setText(this.heI.getText());
        this.heH.setVisibility(8);
        this.heI.setVisibility(0);
        setEditTextEnable(true);
        this.heW.ShowSoftKeyPad(this.heI);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.heI.setTextAppearance(getContext(), f.k.cover_text_style);
            this.heH.setTextAppearance(getContext(), f.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), f.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), f.e.fontsize40) * i) / i3);
            this.hfh = 0;
            this.heI.setMaxLines(1);
            this.heH.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heH.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.heI.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), f.e.ds60), 0, l.f(getContext(), f.e.ds60), 0);
        } else {
            this.heI.setTextAppearance(getContext(), f.k.cover_pendant_style);
            this.heH.setTextAppearance(getContext(), f.k.cover_pendant_style);
            this.hfh = l.f(getContext(), f.e.ds40);
            this.heI.setMaxLines(2);
            this.heH.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.heH.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.heI.setLayoutParams(layoutParams2);
            this.hfd = (int) (l.dip2px(getContext(), pendantData.left) * this.heV);
            this.hfe = (int) (l.dip2px(getContext(), pendantData.top) * this.heV);
            this.hff = (int) (l.dip2px(getContext(), pendantData.right) * this.heV);
            this.hfg = (int) (l.dip2px(getContext(), pendantData.bottom) * this.heV);
            this.mContentView.setPadding(this.hfd, this.hfe, this.hff, this.hfg);
            this.hfc = l.f(getContext(), f.e.fontsize40) * this.heV;
            String text = getText();
            this.hfi = (i2 - this.hfe) - this.hfg;
            this.hfj = (i - this.hfd) - this.hff;
            this.hfl = this.hfk + l.f(getContext(), f.e.ds6);
            setTextSize(0, this.hfc);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(f.j.cover_hint), this.hfj);
                this.hfc = this.heI.getTextSize();
                bBo();
                bBp();
            } else {
                if (w.hJ(text) > 20) {
                    text = w.B(text, 20);
                    this.heI.setText(text);
                    this.heH.setText(text);
                }
                uS(text);
            }
        }
        this.heH.setIncludeFontPadding(false);
        this.heI.setIncludeFontPadding(false);
        this.heH.setLineSpacing(this.hfk, 1.0f);
        this.heI.setLineSpacing(this.hfk, 1.0f);
        this.heF.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.heF.getLayoutParams();
        layoutParams3.height = (this.hfh * 2) + i2;
        layoutParams3.width = (this.hfh * 2) + i;
        this.heF.setLayoutParams(layoutParams3);
        this.hfm = (this.hfh * 2) + i;
        ((FrameLayout.LayoutParams) this.heG.getLayoutParams()).setMargins(this.hfh, this.hfh, this.hfh, this.hfh);
        this.heF.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hfo == null) {
            bBq();
        }
        return this.hfo;
    }

    private void bBq() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hfo = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBr() {
        if (this.hfo != null && !this.hfo.isRecycled()) {
            this.hfo.recycle();
            this.hfo = null;
        }
    }

    public void mT(boolean z) {
        if (this.heL != 0) {
            if (z) {
                bBr();
                this.heF.setVisibility(0);
                return;
            }
            blH();
            getTempBitmap();
            this.heF.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hfn.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hfn.clear();
        this.hfn = null;
        bBr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hfs;
        WeakReference<CoverPendantDragView> hft;
        WeakReference<PendantData> hfu;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hfs = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hft = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hfu = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cr(String str, String str2) {
            if (this.hfs != null && this.hfs.get() != null) {
                this.hfs.get().hdA.setVisibility(8);
            }
            if (this.hft != null && this.hft.get() != null && this.hfu != null && this.hfu.get() != null) {
                this.hft.get().a(str2, this.hfu.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void uG(String str) {
            if (this.hfs != null && this.hfs.get() != null) {
                this.hfs.get().hdA.setVisibility(8);
            }
            if (this.hft != null && this.hft.get() != null) {
                l.showToast(this.hft.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAt() {
            if (this.hfs != null && this.hfs.get() != null) {
                this.hfs.get().hdA.setVisibility(8);
            }
        }
    }
}
