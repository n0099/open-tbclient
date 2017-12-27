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
    private float czf;
    private float dki;
    private float gOd;
    private float hAa;
    private boolean hAb;
    private float hAc;
    private int hAd;
    private int hAe;
    private int hAf;
    private int hAg;
    private int hAh;
    private float hAi;
    private float hAj;
    private int hAk;
    private float hAl;
    private int hAm;
    private Map<String, Bitmap> hAn;
    float hAo;
    float hAp;
    private FrameLayout hzG;
    private RotateFrameLayout hzH;
    private TextView hzI;
    private EditText hzJ;
    private ImageView hzK;
    private ImageView hzL;
    private int hzM;
    private boolean hzN;
    private float hzO;
    private float hzP;
    private int hzQ;
    private int hzR;
    private float hzS;
    private float hzT;
    private float hzU;
    private float hzV;
    private b hzW;
    private float hzX;
    private float hzY;
    private float hzZ;
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
        this.hzM = 0;
        this.hzV = 1.0f;
        this.gOd = 1.0f;
        this.hAb = true;
        this.hAn = new HashMap();
        this.startTime = 0L;
        this.hAo = 0.0f;
        this.hAp = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hAc = l.s(getContext(), d.e.fontsize40);
        this.hAk = l.s(getContext(), d.e.ds2);
        this.dki = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hzG = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hzG);
        this.hzG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hzM == 4) {
                            CoverPendantDragView.this.bHF();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.czf);
                        if (!CoverPendantDragView.this.hzN && abs < CoverPendantDragView.this.dki && abs2 < CoverPendantDragView.this.dki && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bHG();
                        }
                        CoverPendantDragView.this.hzO = 0.0f;
                        CoverPendantDragView.this.hzP = 0.0f;
                        CoverPendantDragView.this.hzN = false;
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
                        CoverPendantDragView.this.hzO = 0.0f;
                        CoverPendantDragView.this.hzP = 0.0f;
                        return true;
                }
            }
        });
        this.hzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hzJ.setText("");
                CoverPendantDragView.this.bsc();
            }
        });
        this.hzL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hzP = 0.0f;
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
        this.hzJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hzM != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hzI.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hc(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hzI.getText().length()) {
                        CoverPendantDragView.this.uj(obj);
                    } else {
                        CoverPendantDragView.this.ui(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(obj.lastIndexOf(F) + F.length(), obj.length());
                    CoverPendantDragView.this.uj(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hzI.setText(editable.toString());
            }
        });
        this.hzJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hzG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.czf = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.czf;
        this.hzS = (this.hzG.getWidth() / 2) + this.hzG.getX();
        this.hzT = (this.hzG.getHeight() / 2) + this.hzG.getY();
        this.hzI.setText(this.hzJ.getText());
        this.hzI.setVisibility(0);
        this.hzJ.setVisibility(8);
        setEditTextEnable(false);
        this.hzW.HidenSoftKeyPad(this.hzJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(String str) {
        TextPaint paint = this.hzJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.hzJ.getLineCount() == 1 && this.hzJ.getTextSize() < this.hAc * this.gOd && measureText < this.hAj * this.gOd) {
            setTextSize(0, this.hzJ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hc(str) <= w.hc(getResources().getString(d.j.cover_hint)) && this.hzJ.getTextSize() != this.hAc * this.gOd) {
            setTextSize(0, this.hAc * this.gOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(String str) {
        TextPaint paint = this.hzJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.hzJ.getTextSize() > ((this.hAi * this.gOd) / 2.0f) - (this.hAl * this.gOd) && measureText > this.hAj * this.gOd) {
            setTextSize(0, this.hzJ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void c(String str, float f) {
        TextPaint paint = this.hzJ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hzJ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.s(getContext(), d.e.ds120)) {
            str = w.I(str, w.hb(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hzW = bVar;
    }

    public void j(float f, float f2, float f3, float f4) {
        this.hzX = f;
        this.hzY = f2;
        this.hzZ = f3;
        this.hAa = f4;
        if (this.hzX > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hzX, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hzY > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hzY);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hzZ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hzZ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hAa > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hAa) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.hzS - rawX);
        float abs4 = Math.abs(this.hzT - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hzS - this.mLastX);
        float abs6 = Math.abs(this.hzT - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cY(sqrt, (int) (sqrt / this.hzU));
        if (this.hzP != 0.0f) {
            this.hzG.setRotation(this.hzG.getRotation() - (this.hzP - M));
        }
        this.hzP = M;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cY(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hzG.getLayoutParams();
        int width = this.hzG.getWidth() - i;
        int i3 = (int) (width / this.hzU);
        if (width < this.hzQ) {
            width = this.hzQ;
            i3 = (int) (width / this.hzU);
        }
        this.gOd = ((width * 1.0f) - (this.hAh * 2)) / (this.hAm - (this.hAh * 2));
        this.mContentView.setPadding((int) (this.hAd * this.gOd), (int) (this.hAe * this.gOd), (int) (this.hAf * this.gOd), (int) (this.hAg * this.gOd));
        setTextSize(0, (this.hzJ.getTextSize() * i3) / this.hzG.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hzG.setLayoutParams(layoutParams);
        float f = this.hzS - (layoutParams.width / 2);
        float f2 = this.hzT - (layoutParams.height / 2);
        this.hzG.setX(f);
        this.hzG.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hzM != 4) {
            float y = (this.hzG.getY() + rawY) - this.mLastY;
            if (y < this.hzY) {
                y = this.hzY;
            } else if (y > (this.hzY + this.mVideoHeight) - this.hzG.getHeight()) {
                y = (this.hzY + this.mVideoHeight) - this.hzG.getHeight();
            }
            this.hzG.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hzN = true;
                float N = N(motionEvent);
                float L = L(motionEvent);
                if (this.hzO != 0.0f) {
                    int i = (int) (this.hzO - N);
                    cY(i, (int) (i / this.hzU));
                }
                if (this.hzP != 0.0f) {
                    this.hzG.setRotation(this.hzG.getRotation() - (this.hzP - L));
                }
                this.hzP = L;
                this.hzO = N;
            } else if (!this.hzN && pointerCount == 1) {
                float y2 = (this.hzG.getY() + rawY) - this.mLastY;
                if (y2 < this.hzY - (this.hzG.getHeight() / 2)) {
                    y2 = this.hzY - (this.hzG.getHeight() / 2);
                } else if (y2 > ((this.hzY + this.mVideoHeight) - this.hzG.getHeight()) + (this.hzG.getHeight() / 2)) {
                    y2 = ((this.hzY + this.mVideoHeight) - this.hzG.getHeight()) + (this.hzG.getHeight() / 2);
                }
                float x = (this.hzG.getX() + rawX) - this.mLastX;
                if (x < this.hzX - (this.hzG.getWidth() / 2)) {
                    x = this.hzX - (this.hzG.getWidth() / 2);
                } else if (x > ((this.hzX + this.mVideoWidth) - this.hzG.getWidth()) + (this.hzG.getWidth() / 2)) {
                    x = ((this.hzX + this.mVideoWidth) - this.hzG.getWidth()) + (this.hzG.getWidth() / 2);
                }
                this.hzG.setX(x);
                this.hzG.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hzJ.getTextSize() != f) {
            this.hzJ.setTextSize(i, f);
        }
        if (this.hzI.getTextSize() != f) {
            this.hzI.setTextSize(i, f);
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
        matrix.postRotate(this.hzG.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float M(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hzT - motionEvent.getRawY(), this.hzS - motionEvent.getRawX()));
    }

    private float N(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dki && Math.abs(motionEvent.getRawY() - this.czf) < this.dki;
    }

    private void init() {
        this.hzH = (RotateFrameLayout) this.hzG.findViewById(d.g.content_container);
        this.hzI = (TextView) this.hzG.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hzG.findViewById(d.g.content_view);
        this.hzJ = (EditText) this.hzG.findViewById(d.g.cover_edit);
        this.hzK = (ImageView) this.hzG.findViewById(d.g.cover_delete);
        this.hzL = (ImageView) this.hzG.findViewById(d.g.cover_scale);
    }

    public void bsc() {
        this.hzI.setText(this.hzJ.getText());
        this.hzI.setVisibility(0);
        this.hzJ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hzI.getText())) {
            this.hzM = 0;
            this.hzG.setVisibility(8);
        }
        if (this.hzM == 4) {
            bHE();
        }
        this.hzW.HidenSoftKeyPad(this.hzJ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hzJ.setFocusable(true);
            this.hzJ.setFocusableInTouchMode(true);
            this.hzJ.requestFocus();
            return;
        }
        this.hzJ.setFocusable(false);
        this.hzJ.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hzJ.setText("");
                    bsc();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bHG();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bHG();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bHG();
                    break;
                default:
                    bsc();
                    String uh = com.baidu.tieba.video.editvideo.model.b.bHz().uh(pendantData.resource);
                    if (TextUtils.isEmpty(uh)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hyz.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bHz().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(uh, pendantData);
                        break;
                    }
                    break;
            }
            this.hzM = pendantData.pendantType;
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
        bHE();
        a(this.mVideoWidth, l.s(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hzM == 4 || this.hzM == 0) {
            this.hzG.setX(this.hzX);
            this.hzG.setY(((this.mVideoHeight - l.s(getContext(), d.e.ds100)) / 2) + this.hzY);
            String obj = this.hzJ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hzJ.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hzI.setText(a2);
                    this.hzJ.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bHE() {
        if (this.hAb) {
            this.hAb = false;
            this.hzK.setVisibility(8);
            this.hzL.setVisibility(8);
            this.hzH.setBackgroundColor(getResources().getColor(d.C0108d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHF() {
        if (!this.hAb) {
            this.hAb = true;
            this.hzK.setVisibility(0);
            this.hzL.setVisibility(0);
            this.hzH.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hAn.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hAn.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bHE();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hzV = 1.0f;
                this.gOd = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hzV = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hzQ = (this.hAh * 2) + width;
                this.hzR = (this.hAh * 2) + height;
                this.hzU = (this.hzQ * 1.0f) / this.hzR;
                this.hzG.setX((((this.mVideoWidth - i2) - (this.hAh * 2)) / 2) + this.hzX);
                this.hzG.setY((((this.mVideoHeight - i) - (this.hAh * 2)) / 2) + this.hzY);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hAo = motionEvent.getRawX();
                this.hAp = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hAo);
                float abs2 = Math.abs(rawY - this.hAp);
                if (motionEvent.getPointerCount() <= 1 && abs < this.dki && abs2 < this.dki && System.currentTimeMillis() - this.startTime < 300) {
                    bsc();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hzI == null || this.hzI.getText() == null) {
            return null;
        }
        return this.hzI.getText().toString();
    }

    public void bHG() {
        this.hzI.setText(this.hzJ.getText());
        this.hzI.setVisibility(8);
        this.hzJ.setVisibility(0);
        setEditTextEnable(true);
        this.hzW.ShowSoftKeyPad(this.hzJ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hzJ.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hzI.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.s(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.s(getContext(), d.e.fontsize40) * i) / i3);
            this.hAh = 0;
            this.hzJ.setMaxLines(1);
            this.hzI.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hzI.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hzJ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.s(getContext(), d.e.ds60), 0, l.s(getContext(), d.e.ds60), 0);
        } else {
            this.hzJ.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hzI.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hAh = l.s(getContext(), d.e.ds40);
            this.hzJ.setMaxLines(2);
            this.hzI.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hzI.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hzJ.setLayoutParams(layoutParams2);
            this.hAd = (int) (l.dip2px(getContext(), pendantData.left) * this.hzV);
            this.hAe = (int) (l.dip2px(getContext(), pendantData.top) * this.hzV);
            this.hAf = (int) (l.dip2px(getContext(), pendantData.right) * this.hzV);
            this.hAg = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hzV);
            this.mContentView.setPadding(this.hAd, this.hAe, this.hAf, this.hAg);
            this.hAc = l.s(getContext(), d.e.fontsize40) * this.hzV;
            String text = getText();
            this.hAi = (i2 - this.hAe) - this.hAg;
            this.hAj = (i - this.hAd) - this.hAf;
            this.hAl = this.hAk + l.s(getContext(), d.e.ds6);
            setTextSize(0, this.hAc);
            if (TextUtils.isEmpty(text)) {
                c(getContext().getString(d.j.cover_hint), this.hAj);
                this.hAc = this.hzJ.getTextSize();
                bHF();
                bHG();
            } else {
                if (w.hc(text) > 20) {
                    text = w.F(text, 20);
                    this.hzJ.setText(text);
                    this.hzI.setText(text);
                }
                uj(text);
            }
        }
        this.hzI.setIncludeFontPadding(false);
        this.hzJ.setIncludeFontPadding(false);
        this.hzI.setLineSpacing(this.hAk, 1.0f);
        this.hzJ.setLineSpacing(this.hAk, 1.0f);
        this.hzG.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hzG.getLayoutParams();
        layoutParams3.height = (this.hAh * 2) + i2;
        layoutParams3.width = (this.hAh * 2) + i;
        this.hzG.setLayoutParams(layoutParams3);
        this.hAm = (this.hAh * 2) + i;
        ((FrameLayout.LayoutParams) this.hzH.getLayoutParams()).setMargins(this.hAh, this.hAh, this.hAh, this.hAh);
        this.hzG.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bHH();
        }
        return this.mTempBitmap;
    }

    private void bHH() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bHI() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nZ(boolean z) {
        if (this.hzM != 0) {
            if (z) {
                bHI();
                this.hzG.setVisibility(0);
                return;
            }
            bsc();
            getTempBitmap();
            this.hzG.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hAn.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hAn.clear();
        this.hAn = null;
        bHI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hAr;
        WeakReference<CoverPendantDragView> hAs;
        WeakReference<PendantData> hAt;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hAr = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hAs = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hAt = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void co(String str, String str2) {
            if (this.hAr != null && this.hAr.get() != null) {
                this.hAr.get().hyz.setVisibility(8);
            }
            if (this.hAs != null && this.hAs.get() != null && this.hAt != null && this.hAt.get() != null) {
                this.hAs.get().a(str2, this.hAt.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tX(String str) {
            if (this.hAr != null && this.hAr.get() != null) {
                this.hAr.get().hyz.setVisibility(8);
            }
            if (this.hAs != null && this.hAs.get() != null) {
                l.showToast(this.hAs.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bGJ() {
            if (this.hAr != null && this.hAr.get() != null) {
                this.hAr.get().hyz.setVisibility(8);
            }
        }
    }
}
