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
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bmR;
    private float dbt;
    float dvG;
    float dvH;
    private float fVd;
    private float gzU;
    private EditText hmA;
    private ImageView hmB;
    private ImageView hmC;
    private int hmD;
    private float hmE;
    private boolean hmF;
    private float hmG;
    private float hmH;
    private int hmI;
    private int hmJ;
    private float hmK;
    private float hmL;
    private float hmM;
    private float hmN;
    private b hmO;
    private float hmP;
    private float hmQ;
    private float hmR;
    private float hmS;
    private boolean hmT;
    private float hmU;
    private int hmV;
    private int hmW;
    private int hmX;
    private int hmY;
    private int hmZ;
    private FrameLayout hmx;
    private RotateFrameLayout hmy;
    private TextView hmz;
    private float hna;
    private float hnb;
    private int hnc;
    private float hnd;
    private int hne;
    private Map<String, Bitmap> hnf;
    private Bitmap hng;
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
        this.hmD = 0;
        this.hmN = 1.0f;
        this.gzU = 1.0f;
        this.hmT = true;
        this.hnf = new HashMap();
        this.startTime = 0L;
        this.dvG = 0.0f;
        this.dvH = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.hmU = l.h(getContext(), e.C0141e.fontsize40);
        this.hnc = l.h(getContext(), e.C0141e.ds2);
        this.dbt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hmx = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hmx);
        this.hmx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hmD == 4) {
                            CoverPendantDragView.this.bEd();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bmR);
                        if (!CoverPendantDragView.this.hmF && abs < CoverPendantDragView.this.dbt && abs2 < CoverPendantDragView.this.dbt && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bEe();
                        }
                        CoverPendantDragView.this.hmG = 0.0f;
                        CoverPendantDragView.this.hmH = 0.0f;
                        CoverPendantDragView.this.hmF = false;
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
                        CoverPendantDragView.this.hmG = 0.0f;
                        CoverPendantDragView.this.hmH = 0.0f;
                        return true;
                }
            }
        });
        this.hmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hmA.setText("");
                CoverPendantDragView.this.bon();
            }
        });
        this.hmC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hmH = 0.0f;
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
        this.hmA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hmD != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hmz.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.ih(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hmz.getText().length()) {
                        CoverPendantDragView.this.vB(obj);
                    } else {
                        CoverPendantDragView.this.vA(obj);
                    }
                } else {
                    String G = y.G(obj, 20);
                    editable.delete(G.length(), obj.length());
                    CoverPendantDragView.this.vB(G);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hmz.setText(editable.toString());
            }
        });
        this.hmA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hmx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bmR = motionEvent.getRawY();
        this.hmE = this.mDownX;
        this.fVd = this.bmR;
        this.hmK = (this.hmx.getWidth() / 2) + this.hmx.getX();
        this.hmL = (this.hmx.getHeight() / 2) + this.hmx.getY();
        this.hmz.setText(this.hmA.getText());
        this.hmz.setVisibility(0);
        this.hmA.setVisibility(8);
        setEditTextEnable(false);
        this.hmO.HidenSoftKeyPad(this.hmA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(String str) {
        TextPaint paint = this.hmA.getPaint();
        float measureText = paint.measureText(str);
        while (this.hmA.getLineCount() == 1 && this.hmA.getTextSize() < this.hmU * this.gzU && measureText < this.hnb * this.gzU) {
            setTextSize(0, this.hmA.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.ih(str) <= y.ih(getResources().getString(e.j.cover_hint)) && this.hmA.getTextSize() != this.hmU * this.gzU) {
            setTextSize(0, this.hmU * this.gzU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(String str) {
        TextPaint paint = this.hmA.getPaint();
        float measureText = paint.measureText(str);
        while (this.hmA.getTextSize() > ((this.hna * this.gzU) / 2.0f) - (this.hnd * this.gzU) && measureText > this.hnb * this.gzU) {
            setTextSize(0, this.hmA.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hmA.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hmA.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0141e.ds120)) {
            str = y.I(str, y.ig(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hmO = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hmP = f;
        this.hmQ = f2;
        this.hmR = f3;
        this.hmS = f4;
        if (this.hmP > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hmP, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hmQ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hmQ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hmR > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hmR) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hmS > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hmS) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float K = K(motionEvent);
        float abs = Math.abs(this.hmE - rawX);
        float abs2 = Math.abs(this.fVd - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hmK - rawX);
        float abs4 = Math.abs(this.hmL - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hmK - this.hmE);
        float abs6 = Math.abs(this.hmL - this.fVd);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bQ(sqrt, (int) (sqrt / this.hmM));
        if (this.hmH != 0.0f) {
            this.hmx.setRotation(this.hmx.getRotation() - (this.hmH - K));
        }
        this.hmH = K;
        this.hmE = rawX;
        this.fVd = rawY;
    }

    private void bQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hmx.getLayoutParams();
        int width = this.hmx.getWidth() - i;
        int i3 = (int) (width / this.hmM);
        if (width < this.hmI) {
            width = this.hmI;
            i3 = (int) (width / this.hmM);
        }
        this.gzU = ((width * 1.0f) - (this.hmZ * 2)) / (this.hne - (this.hmZ * 2));
        this.mContentView.setPadding((int) (this.hmV * this.gzU), (int) (this.hmW * this.gzU), (int) (this.hmX * this.gzU), (int) (this.hmY * this.gzU));
        setTextSize(0, (this.hmA.getTextSize() * i3) / this.hmx.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hmx.setLayoutParams(layoutParams);
        float f = this.hmK - (layoutParams.width / 2);
        float f2 = this.hmL - (layoutParams.height / 2);
        this.hmx.setX(f);
        this.hmx.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hmD != 4) {
            float y = (this.hmx.getY() + rawY) - this.fVd;
            if (y < this.hmQ) {
                y = this.hmQ;
            } else if (y > (this.hmQ + this.mVideoHeight) - this.hmx.getHeight()) {
                y = (this.hmQ + this.mVideoHeight) - this.hmx.getHeight();
            }
            this.hmx.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hmF = true;
                float L = L(motionEvent);
                float J = J(motionEvent);
                if (this.hmG != 0.0f) {
                    int i = (int) (this.hmG - L);
                    bQ(i, (int) (i / this.hmM));
                }
                if (this.hmH != 0.0f) {
                    this.hmx.setRotation(this.hmx.getRotation() - (this.hmH - J));
                }
                this.hmH = J;
                this.hmG = L;
            } else if (!this.hmF && pointerCount == 1) {
                float y2 = (this.hmx.getY() + rawY) - this.fVd;
                if (y2 < this.hmQ - (this.hmx.getHeight() / 2)) {
                    y2 = this.hmQ - (this.hmx.getHeight() / 2);
                } else if (y2 > ((this.hmQ + this.mVideoHeight) - this.hmx.getHeight()) + (this.hmx.getHeight() / 2)) {
                    y2 = ((this.hmQ + this.mVideoHeight) - this.hmx.getHeight()) + (this.hmx.getHeight() / 2);
                }
                float x = (this.hmx.getX() + rawX) - this.hmE;
                if (x < this.hmP - (this.hmx.getWidth() / 2)) {
                    x = this.hmP - (this.hmx.getWidth() / 2);
                } else if (x > ((this.hmP + this.mVideoWidth) - this.hmx.getWidth()) + (this.hmx.getWidth() / 2)) {
                    x = ((this.hmP + this.mVideoWidth) - this.hmx.getWidth()) + (this.hmx.getWidth() / 2);
                }
                this.hmx.setX(x);
                this.hmx.setY(y2);
            }
        }
        this.hmE = rawX;
        this.fVd = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hmA.getTextSize() != f) {
            this.hmA.setTextSize(i, f);
        }
        if (this.hmz.getTextSize() != f) {
            this.hmz.setTextSize(i, f);
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
        matrix.postRotate(this.hmx.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float K(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hmL - motionEvent.getRawY(), this.hmK - motionEvent.getRawX()));
    }

    private float L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dbt && Math.abs(motionEvent.getRawY() - this.bmR) < this.dbt;
    }

    private void init() {
        this.hmy = (RotateFrameLayout) this.hmx.findViewById(e.g.content_container);
        this.hmz = (TextView) this.hmx.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.hmx.findViewById(e.g.content_view);
        this.hmA = (EditText) this.hmx.findViewById(e.g.cover_edit);
        this.hmB = (ImageView) this.hmx.findViewById(e.g.cover_delete);
        this.hmC = (ImageView) this.hmx.findViewById(e.g.cover_scale);
    }

    public void bon() {
        this.hmz.setText(this.hmA.getText());
        this.hmz.setVisibility(0);
        this.hmA.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hmz.getText())) {
            this.hmD = 0;
            this.hmx.setVisibility(8);
        }
        if (this.hmD == 4) {
            bEc();
        }
        this.hmO.HidenSoftKeyPad(this.hmA);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hmA.setFocusable(true);
            this.hmA.setFocusableInTouchMode(true);
            this.hmA.requestFocus();
            return;
        }
        this.hmA.setFocusable(false);
        this.hmA.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hmA.setText("");
                    bon();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bEe();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bEe();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bEe();
                    break;
                default:
                    bon();
                    String vz = com.baidu.tieba.video.editvideo.model.b.bDX().vz(pendantData.resource);
                    if (TextUtils.isEmpty(vz)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hls.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bDX().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(vz, pendantData);
                        break;
                    }
                    break;
            }
            this.hmD = pendantData.pendantType;
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
        bEc();
        a(this.mVideoWidth, l.h(getContext(), e.C0141e.ds100), this.mScreenWidth, pendantData);
        if (this.hmD == 4 || this.hmD == 0) {
            this.hmx.setX(this.hmP);
            this.hmx.setY(((this.mVideoHeight - l.h(getContext(), e.C0141e.ds100)) / 2) + this.hmQ);
            String obj = this.hmA.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hmA.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hmz.setText(a2);
                    this.hmA.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bEc() {
        if (this.hmT) {
            this.hmT = false;
            this.hmB.setVisibility(8);
            this.hmC.setVisibility(8);
            this.hmy.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEd() {
        if (!this.hmT) {
            this.hmT = true;
            this.hmB.setVisibility(0);
            this.hmC.setVisibility(0);
            this.hmy.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hnf != null) {
            Bitmap bitmap = this.hnf.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hnf.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bEc();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hmN = 1.0f;
                this.gzU = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hmN = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hmI = (this.hmZ * 2) + width;
                this.hmJ = (this.hmZ * 2) + height;
                this.hmM = (this.hmI * 1.0f) / this.hmJ;
                this.hmx.setX((((this.mVideoWidth - i2) - (this.hmZ * 2)) / 2) + this.hmP);
                this.hmx.setY((((this.mVideoHeight - i) - (this.hmZ * 2)) / 2) + this.hmQ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dvG = motionEvent.getRawX();
                this.dvH = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dvG);
                float abs2 = Math.abs(rawY - this.dvH);
                if (motionEvent.getPointerCount() <= 1 && abs < this.dbt && abs2 < this.dbt && System.currentTimeMillis() - this.startTime < 300) {
                    bon();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hmz == null || this.hmz.getText() == null) {
            return null;
        }
        return this.hmz.getText().toString();
    }

    public void bEe() {
        this.hmz.setText(this.hmA.getText());
        this.hmz.setVisibility(8);
        this.hmA.setVisibility(0);
        setEditTextEnable(true);
        this.hmO.ShowSoftKeyPad(this.hmA);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hmA.setTextAppearance(getContext(), e.k.cover_text_style);
            this.hmz.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0141e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0141e.fontsize40) * i) / i3);
            this.hmZ = 0;
            this.hmA.setMaxLines(1);
            this.hmz.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hmz.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hmA.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0141e.ds60), 0, l.h(getContext(), e.C0141e.ds60), 0);
        } else {
            this.hmA.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hmz.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hmZ = l.h(getContext(), e.C0141e.ds40);
            this.hmA.setMaxLines(2);
            this.hmz.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hmz.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hmA.setLayoutParams(layoutParams2);
            this.hmV = (int) (l.dip2px(getContext(), pendantData.left) * this.hmN);
            this.hmW = (int) (l.dip2px(getContext(), pendantData.top) * this.hmN);
            this.hmX = (int) (l.dip2px(getContext(), pendantData.right) * this.hmN);
            this.hmY = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hmN);
            this.mContentView.setPadding(this.hmV, this.hmW, this.hmX, this.hmY);
            this.hmU = l.h(getContext(), e.C0141e.fontsize40) * this.hmN;
            String text = getText();
            this.hna = (i2 - this.hmW) - this.hmY;
            this.hnb = (i - this.hmV) - this.hmX;
            this.hnd = this.hnc + l.h(getContext(), e.C0141e.ds6);
            setTextSize(0, this.hmU);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hnb);
                this.hmU = this.hmA.getTextSize();
                bEd();
                bEe();
            } else {
                if (y.ih(text) > 20) {
                    text = y.G(text, 20);
                    this.hmA.setText(text);
                    this.hmz.setText(text);
                }
                vB(text);
            }
        }
        this.hmz.setIncludeFontPadding(false);
        this.hmA.setIncludeFontPadding(false);
        this.hmz.setLineSpacing(this.hnc, 1.0f);
        this.hmA.setLineSpacing(this.hnc, 1.0f);
        this.hmx.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hmx.getLayoutParams();
        layoutParams3.height = (this.hmZ * 2) + i2;
        layoutParams3.width = (this.hmZ * 2) + i;
        this.hmx.setLayoutParams(layoutParams3);
        this.hne = (this.hmZ * 2) + i;
        ((FrameLayout.LayoutParams) this.hmy.getLayoutParams()).setMargins(this.hmZ, this.hmZ, this.hmZ, this.hmZ);
        this.hmx.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hng == null) {
            bEf();
        }
        return this.hng;
    }

    private void bEf() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hng = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bEg() {
        if (this.hng != null && !this.hng.isRecycled()) {
            this.hng.recycle();
            this.hng = null;
        }
    }

    public void nq(boolean z) {
        if (this.hmD != 0) {
            if (z) {
                bEg();
                this.hmx.setVisibility(0);
                return;
            }
            bon();
            getTempBitmap();
            this.hmx.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hnf.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hnf.clear();
        this.hnf = null;
        bEg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hni;
        WeakReference<CoverPendantDragView> hnj;
        WeakReference<PendantData> hnk;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hni = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hnj = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hnk = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cB(String str, String str2) {
            if (this.hni != null && this.hni.get() != null) {
                this.hni.get().hls.setVisibility(8);
            }
            if (this.hnj != null && this.hnj.get() != null && this.hnk != null && this.hnk.get() != null) {
                this.hnj.get().a(str2, this.hnk.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void vp(String str) {
            if (this.hni != null && this.hni.get() != null) {
                this.hni.get().hls.setVisibility(8);
            }
            if (this.hnj != null && this.hnj.get() != null) {
                l.showToast(this.hnj.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bDi() {
            if (this.hni != null && this.hni.get() != null) {
                this.hni.get().hls.setVisibility(8);
            }
        }
    }
}
