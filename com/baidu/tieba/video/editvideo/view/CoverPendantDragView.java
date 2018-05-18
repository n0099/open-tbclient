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
import com.baidu.tbadk.core.util.ak;
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
    private float bUb;
    private float cLJ;
    private FrameLayout gNL;
    private RotateFrameLayout gNM;
    private TextView gNN;
    private EditText gNO;
    private ImageView gNP;
    private ImageView gNQ;
    private int gNR;
    private boolean gNS;
    private float gNT;
    private float gNU;
    private int gNV;
    private int gNW;
    private float gNX;
    private float gNY;
    private float gNZ;
    private float gOa;
    private b gOb;
    private float gOc;
    private float gOd;
    private float gOe;
    private float gOf;
    private boolean gOg;
    private float gOh;
    private int gOi;
    private int gOj;
    private int gOk;
    private int gOl;
    private int gOm;
    private float gOn;
    private float gOo;
    private int gOp;
    private float gOq;
    private int gOr;
    private Map<String, Bitmap> gOs;
    float gOt;
    float gOu;
    private float gcc;
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
        this.gNR = 0;
        this.gOa = 1.0f;
        this.gcc = 1.0f;
        this.gOg = true;
        this.gOs = new HashMap();
        this.startTime = 0L;
        this.gOt = 0.0f;
        this.gOu = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.gOh = l.e(getContext(), d.e.fontsize40);
        this.gOp = l.e(getContext(), d.e.ds2);
        this.cLJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gNL = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.i.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gNL);
        this.gNL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view2, motionEvent);
                        if (CoverPendantDragView.this.gNR == 4) {
                            CoverPendantDragView.this.bwU();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bUb);
                        if (!CoverPendantDragView.this.gNS && abs < CoverPendantDragView.this.cLJ && abs2 < CoverPendantDragView.this.cLJ && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bwV();
                        }
                        CoverPendantDragView.this.gNT = 0.0f;
                        CoverPendantDragView.this.gNU = 0.0f;
                        CoverPendantDragView.this.gNS = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.G(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.gNT = 0.0f;
                        CoverPendantDragView.this.gNU = 0.0f;
                        return true;
                }
            }
        });
        this.gNP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CoverPendantDragView.this.gNO.setText("");
                CoverPendantDragView.this.bhP();
            }
        });
        this.gNQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view2, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gNU = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.F(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.gNO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gNR != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gNN.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_text_length_max_tips);
                    }
                } else if (w.hn(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gNN.getText().length()) {
                        CoverPendantDragView.this.ua(obj);
                    } else {
                        CoverPendantDragView.this.tZ(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(F.length(), obj.length());
                    CoverPendantDragView.this.ua(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gNN.setText(editable.toString());
            }
        });
        this.gNO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gNL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view2, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bUb = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.bUb;
        this.gNX = (this.gNL.getWidth() / 2) + this.gNL.getX();
        this.gNY = (this.gNL.getHeight() / 2) + this.gNL.getY();
        this.gNN.setText(this.gNO.getText());
        this.gNN.setVisibility(0);
        this.gNO.setVisibility(8);
        setEditTextEnable(false);
        this.gOb.HidenSoftKeyPad(this.gNO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(String str) {
        TextPaint paint = this.gNO.getPaint();
        float measureText = paint.measureText(str);
        while (this.gNO.getLineCount() == 1 && this.gNO.getTextSize() < this.gOh * this.gcc && measureText < this.gOo * this.gcc) {
            setTextSize(0, this.gNO.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hn(str) <= w.hn(getResources().getString(d.k.cover_hint)) && this.gNO.getTextSize() != this.gOh * this.gcc) {
            setTextSize(0, this.gOh * this.gcc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(String str) {
        TextPaint paint = this.gNO.getPaint();
        float measureText = paint.measureText(str);
        while (this.gNO.getTextSize() > ((this.gOn * this.gcc) / 2.0f) - (this.gOq * this.gcc) && measureText > this.gOo * this.gcc) {
            setTextSize(0, this.gNO.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.gNO.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gNO.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.e(getContext(), d.e.ds120)) {
            str = w.I(str, w.hm(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gOb = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.gOc = f;
        this.gOd = f2;
        this.gOe = f3;
        this.gOf = f4;
        if (this.gOc > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gOc, -1);
            layoutParams.gravity = 3;
            addView(view2, layoutParams);
        }
        if (this.gOd > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gOd);
            layoutParams2.gravity = 48;
            addView(view3, layoutParams2);
        }
        if (this.gOe > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gOe) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view4, layoutParams3);
        }
        if (this.gOf > 0.0f) {
            View view5 = new View(getContext());
            view5.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gOf) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view5, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.gNX - rawX);
        float abs4 = Math.abs(this.gNY - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gNX - this.mLastX);
        float abs6 = Math.abs(this.gNY - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bN(sqrt, (int) (sqrt / this.gNZ));
        if (this.gNU != 0.0f) {
            this.gNL.setRotation(this.gNL.getRotation() - (this.gNU - I));
        }
        this.gNU = I;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bN(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gNL.getLayoutParams();
        int width = this.gNL.getWidth() - i;
        int i3 = (int) (width / this.gNZ);
        if (width < this.gNV) {
            width = this.gNV;
            i3 = (int) (width / this.gNZ);
        }
        this.gcc = ((width * 1.0f) - (this.gOm * 2)) / (this.gOr - (this.gOm * 2));
        this.mContentView.setPadding((int) (this.gOi * this.gcc), (int) (this.gOj * this.gcc), (int) (this.gOk * this.gcc), (int) (this.gOl * this.gcc));
        setTextSize(0, (this.gNO.getTextSize() * i3) / this.gNL.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gNL.setLayoutParams(layoutParams);
        float f = this.gNX - (layoutParams.width / 2);
        float f2 = this.gNY - (layoutParams.height / 2);
        this.gNL.setX(f);
        this.gNL.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gNR != 4) {
            float y = (this.gNL.getY() + rawY) - this.mLastY;
            if (y < this.gOd) {
                y = this.gOd;
            } else if (y > (this.gOd + this.mVideoHeight) - this.gNL.getHeight()) {
                y = (this.gOd + this.mVideoHeight) - this.gNL.getHeight();
            }
            this.gNL.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gNS = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.gNT != 0.0f) {
                    int i = (int) (this.gNT - J);
                    bN(i, (int) (i / this.gNZ));
                }
                if (this.gNU != 0.0f) {
                    this.gNL.setRotation(this.gNL.getRotation() - (this.gNU - H));
                }
                this.gNU = H;
                this.gNT = J;
            } else if (!this.gNS && pointerCount == 1) {
                float y2 = (this.gNL.getY() + rawY) - this.mLastY;
                if (y2 < this.gOd - (this.gNL.getHeight() / 2)) {
                    y2 = this.gOd - (this.gNL.getHeight() / 2);
                } else if (y2 > ((this.gOd + this.mVideoHeight) - this.gNL.getHeight()) + (this.gNL.getHeight() / 2)) {
                    y2 = ((this.gOd + this.mVideoHeight) - this.gNL.getHeight()) + (this.gNL.getHeight() / 2);
                }
                float x = (this.gNL.getX() + rawX) - this.mLastX;
                if (x < this.gOc - (this.gNL.getWidth() / 2)) {
                    x = this.gOc - (this.gNL.getWidth() / 2);
                } else if (x > ((this.gOc + this.mVideoWidth) - this.gNL.getWidth()) + (this.gNL.getWidth() / 2)) {
                    x = ((this.gOc + this.mVideoWidth) - this.gNL.getWidth()) + (this.gNL.getWidth() / 2);
                }
                this.gNL.setX(x);
                this.gNL.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gNO.getTextSize() != f) {
            this.gNO.setTextSize(i, f);
        }
        if (this.gNN.getTextSize() != f) {
            this.gNN.setTextSize(i, f);
        }
    }

    private float H(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.gNL.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gNY - motionEvent.getRawY(), this.gNX - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cLJ && Math.abs(motionEvent.getRawY() - this.bUb) < this.cLJ;
    }

    private void init() {
        this.gNM = (RotateFrameLayout) this.gNL.findViewById(d.g.content_container);
        this.gNN = (TextView) this.gNL.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gNL.findViewById(d.g.content_view);
        this.gNO = (EditText) this.gNL.findViewById(d.g.cover_edit);
        this.gNP = (ImageView) this.gNL.findViewById(d.g.cover_delete);
        this.gNQ = (ImageView) this.gNL.findViewById(d.g.cover_scale);
    }

    public void bhP() {
        this.gNN.setText(this.gNO.getText());
        this.gNN.setVisibility(0);
        this.gNO.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gNN.getText())) {
            this.gNR = 0;
            this.gNL.setVisibility(8);
        }
        if (this.gNR == 4) {
            bwT();
        }
        this.gOb.HidenSoftKeyPad(this.gNO);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gNO.setFocusable(true);
            this.gNO.setFocusableInTouchMode(true);
            this.gNO.requestFocus();
            return;
        }
        this.gNO.setFocusable(false);
        this.gNO.setFocusableInTouchMode(false);
    }

    public void a(View view2, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gNO.setText("");
                    bhP();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bwV();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bwV();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bwV();
                    break;
                default:
                    bhP();
                    String tY = com.baidu.tieba.video.editvideo.model.b.bwO().tY(pendantData.resource);
                    if (TextUtils.isEmpty(tY)) {
                        if (view2 != null && (view2.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view2.getTag();
                            bVar.gMG.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bwO().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tY, pendantData);
                        break;
                    }
                    break;
            }
            this.gNR = pendantData.pendantType;
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
        bwT();
        a(this.mVideoWidth, l.e(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gNR == 4 || this.gNR == 0) {
            this.gNL.setX(this.gOc);
            this.gNL.setY(((this.mVideoHeight - l.e(getContext(), d.e.ds100)) / 2) + this.gOd);
            String obj = this.gNO.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gNO.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gNN.setText(a2);
                    this.gNO.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bwT() {
        if (this.gOg) {
            this.gOg = false;
            this.gNP.setVisibility(8);
            this.gNQ.setVisibility(8);
            this.gNM.setBackgroundColor(getResources().getColor(d.C0126d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwU() {
        if (!this.gOg) {
            this.gOg = true;
            this.gNP.setVisibility(0);
            this.gNQ.setVisibility(0);
            this.gNM.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.gOs != null) {
            Bitmap bitmap = this.gOs.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gOs.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bwT();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gOa = 1.0f;
                this.gcc = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gOa = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gNV = (this.gOm * 2) + width;
                this.gNW = (this.gOm * 2) + height;
                this.gNZ = (this.gNV * 1.0f) / this.gNW;
                this.gNL.setX((((this.mVideoWidth - i2) - (this.gOm * 2)) / 2) + this.gOc);
                this.gNL.setY((((this.mVideoHeight - i) - (this.gOm * 2)) / 2) + this.gOd);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gOt = motionEvent.getRawX();
                this.gOu = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gOt);
                float abs2 = Math.abs(rawY - this.gOu);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cLJ && abs2 < this.cLJ && System.currentTimeMillis() - this.startTime < 300) {
                    bhP();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gNN == null || this.gNN.getText() == null) {
            return null;
        }
        return this.gNN.getText().toString();
    }

    public void bwV() {
        this.gNN.setText(this.gNO.getText());
        this.gNN.setVisibility(8);
        this.gNO.setVisibility(0);
        setEditTextEnable(true);
        this.gOb.ShowSoftKeyPad(this.gNO);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gNO.setTextAppearance(getContext(), d.l.cover_text_style);
            this.gNN.setTextAppearance(getContext(), d.l.cover_text_style);
            i2 = (int) ((l.e(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.e(getContext(), d.e.fontsize40) * i) / i3);
            this.gOm = 0;
            this.gNO.setMaxLines(1);
            this.gNN.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gNN.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gNO.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.e(getContext(), d.e.ds60), 0, l.e(getContext(), d.e.ds60), 0);
        } else {
            this.gNO.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gNN.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gOm = l.e(getContext(), d.e.ds40);
            this.gNO.setMaxLines(2);
            this.gNN.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gNN.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gNO.setLayoutParams(layoutParams2);
            this.gOi = (int) (l.dip2px(getContext(), pendantData.left) * this.gOa);
            this.gOj = (int) (l.dip2px(getContext(), pendantData.top) * this.gOa);
            this.gOk = (int) (l.dip2px(getContext(), pendantData.right) * this.gOa);
            this.gOl = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gOa);
            this.mContentView.setPadding(this.gOi, this.gOj, this.gOk, this.gOl);
            this.gOh = l.e(getContext(), d.e.fontsize40) * this.gOa;
            String text = getText();
            this.gOn = (i2 - this.gOj) - this.gOl;
            this.gOo = (i - this.gOi) - this.gOk;
            this.gOq = this.gOp + l.e(getContext(), d.e.ds6);
            setTextSize(0, this.gOh);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.k.cover_hint), this.gOo);
                this.gOh = this.gNO.getTextSize();
                bwU();
                bwV();
            } else {
                if (w.hn(text) > 20) {
                    text = w.F(text, 20);
                    this.gNO.setText(text);
                    this.gNN.setText(text);
                }
                ua(text);
            }
        }
        this.gNN.setIncludeFontPadding(false);
        this.gNO.setIncludeFontPadding(false);
        this.gNN.setLineSpacing(this.gOp, 1.0f);
        this.gNO.setLineSpacing(this.gOp, 1.0f);
        this.gNL.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gNL.getLayoutParams();
        layoutParams3.height = (this.gOm * 2) + i2;
        layoutParams3.width = (this.gOm * 2) + i;
        this.gNL.setLayoutParams(layoutParams3);
        this.gOr = (this.gOm * 2) + i;
        ((FrameLayout.LayoutParams) this.gNM.getLayoutParams()).setMargins(this.gOm, this.gOm, this.gOm, this.gOm);
        this.gNL.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bwW();
        }
        return this.mTempBitmap;
    }

    private void bwW() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bwX() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void mT(boolean z) {
        if (this.gNR != 0) {
            if (z) {
                bwX();
                this.gNL.setVisibility(0);
                return;
            }
            bhP();
            getTempBitmap();
            this.gNL.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gOs.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gOs.clear();
        this.gOs = null;
        bwX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gOw;
        WeakReference<CoverPendantDragView> gOx;
        WeakReference<PendantData> gOy;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gOw = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gOx = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gOy = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ci(String str, String str2) {
            if (this.gOw != null && this.gOw.get() != null) {
                this.gOw.get().gMG.setVisibility(8);
            }
            if (this.gOx != null && this.gOx.get() != null && this.gOy != null && this.gOy.get() != null) {
                this.gOx.get().a(str2, this.gOy.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tO(String str) {
            if (this.gOw != null && this.gOw.get() != null) {
                this.gOw.get().gMG.setVisibility(8);
            }
            if (this.gOx != null && this.gOx.get() != null) {
                l.showToast(this.gOx.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bvZ() {
            if (this.gOw != null && this.gOw.get() != null) {
                this.gOw.get().gMG.setVisibility(8);
            }
        }
    }
}
