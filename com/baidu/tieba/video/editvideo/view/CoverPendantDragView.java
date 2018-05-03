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
    private float bTm;
    private float cKC;
    private FrameLayout gMI;
    private RotateFrameLayout gMJ;
    private TextView gMK;
    private EditText gML;
    private ImageView gMM;
    private ImageView gMN;
    private int gMO;
    private boolean gMP;
    private float gMQ;
    private float gMR;
    private int gMS;
    private int gMT;
    private float gMU;
    private float gMV;
    private float gMW;
    private float gMX;
    private b gMY;
    private float gMZ;
    private float gNa;
    private float gNb;
    private float gNc;
    private boolean gNd;
    private float gNe;
    private int gNf;
    private int gNg;
    private int gNh;
    private int gNi;
    private int gNj;
    private float gNk;
    private float gNl;
    private int gNm;
    private float gNn;
    private int gNo;
    private Map<String, Bitmap> gNp;
    float gNq;
    float gNr;
    private float gaW;
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
        this.gMO = 0;
        this.gMX = 1.0f;
        this.gaW = 1.0f;
        this.gNd = true;
        this.gNp = new HashMap();
        this.startTime = 0L;
        this.gNq = 0.0f;
        this.gNr = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.gNe = l.e(getContext(), d.e.fontsize40);
        this.gNm = l.e(getContext(), d.e.ds2);
        this.cKC = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gMI = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.i.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gMI);
        this.gMI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view2, motionEvent);
                        if (CoverPendantDragView.this.gMO == 4) {
                            CoverPendantDragView.this.bwW();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bTm);
                        if (!CoverPendantDragView.this.gMP && abs < CoverPendantDragView.this.cKC && abs2 < CoverPendantDragView.this.cKC && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bwX();
                        }
                        CoverPendantDragView.this.gMQ = 0.0f;
                        CoverPendantDragView.this.gMR = 0.0f;
                        CoverPendantDragView.this.gMP = false;
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
                        CoverPendantDragView.this.gMQ = 0.0f;
                        CoverPendantDragView.this.gMR = 0.0f;
                        return true;
                }
            }
        });
        this.gMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CoverPendantDragView.this.gML.setText("");
                CoverPendantDragView.this.bhP();
            }
        });
        this.gMN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view2, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gMR = 0.0f;
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
        this.gML.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gMO != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gMK.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_text_length_max_tips);
                    }
                } else if (w.hm(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gMK.getText().length()) {
                        CoverPendantDragView.this.tX(obj);
                    } else {
                        CoverPendantDragView.this.tW(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(F.length(), obj.length());
                    CoverPendantDragView.this.tX(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gMK.setText(editable.toString());
            }
        });
        this.gML.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gMI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view2, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bTm = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.bTm;
        this.gMU = (this.gMI.getWidth() / 2) + this.gMI.getX();
        this.gMV = (this.gMI.getHeight() / 2) + this.gMI.getY();
        this.gMK.setText(this.gML.getText());
        this.gMK.setVisibility(0);
        this.gML.setVisibility(8);
        setEditTextEnable(false);
        this.gMY.HidenSoftKeyPad(this.gML);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW(String str) {
        TextPaint paint = this.gML.getPaint();
        float measureText = paint.measureText(str);
        while (this.gML.getLineCount() == 1 && this.gML.getTextSize() < this.gNe * this.gaW && measureText < this.gNl * this.gaW) {
            setTextSize(0, this.gML.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hm(str) <= w.hm(getResources().getString(d.k.cover_hint)) && this.gML.getTextSize() != this.gNe * this.gaW) {
            setTextSize(0, this.gNe * this.gaW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX(String str) {
        TextPaint paint = this.gML.getPaint();
        float measureText = paint.measureText(str);
        while (this.gML.getTextSize() > ((this.gNk * this.gaW) / 2.0f) - (this.gNn * this.gaW) && measureText > this.gNl * this.gaW) {
            setTextSize(0, this.gML.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.gML.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gML.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.e(getContext(), d.e.ds120)) {
            str = w.I(str, w.hl(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gMY = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.gMZ = f;
        this.gNa = f2;
        this.gNb = f3;
        this.gNc = f4;
        if (this.gMZ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gMZ, -1);
            layoutParams.gravity = 3;
            addView(view2, layoutParams);
        }
        if (this.gNa > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gNa);
            layoutParams2.gravity = 48;
            addView(view3, layoutParams2);
        }
        if (this.gNb > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gNb) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view4, layoutParams3);
        }
        if (this.gNc > 0.0f) {
            View view5 = new View(getContext());
            view5.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gNc) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.gMU - rawX);
        float abs4 = Math.abs(this.gMV - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gMU - this.mLastX);
        float abs6 = Math.abs(this.gMV - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bN(sqrt, (int) (sqrt / this.gMW));
        if (this.gMR != 0.0f) {
            this.gMI.setRotation(this.gMI.getRotation() - (this.gMR - I));
        }
        this.gMR = I;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bN(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gMI.getLayoutParams();
        int width = this.gMI.getWidth() - i;
        int i3 = (int) (width / this.gMW);
        if (width < this.gMS) {
            width = this.gMS;
            i3 = (int) (width / this.gMW);
        }
        this.gaW = ((width * 1.0f) - (this.gNj * 2)) / (this.gNo - (this.gNj * 2));
        this.mContentView.setPadding((int) (this.gNf * this.gaW), (int) (this.gNg * this.gaW), (int) (this.gNh * this.gaW), (int) (this.gNi * this.gaW));
        setTextSize(0, (this.gML.getTextSize() * i3) / this.gMI.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gMI.setLayoutParams(layoutParams);
        float f = this.gMU - (layoutParams.width / 2);
        float f2 = this.gMV - (layoutParams.height / 2);
        this.gMI.setX(f);
        this.gMI.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gMO != 4) {
            float y = (this.gMI.getY() + rawY) - this.mLastY;
            if (y < this.gNa) {
                y = this.gNa;
            } else if (y > (this.gNa + this.mVideoHeight) - this.gMI.getHeight()) {
                y = (this.gNa + this.mVideoHeight) - this.gMI.getHeight();
            }
            this.gMI.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gMP = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.gMQ != 0.0f) {
                    int i = (int) (this.gMQ - J);
                    bN(i, (int) (i / this.gMW));
                }
                if (this.gMR != 0.0f) {
                    this.gMI.setRotation(this.gMI.getRotation() - (this.gMR - H));
                }
                this.gMR = H;
                this.gMQ = J;
            } else if (!this.gMP && pointerCount == 1) {
                float y2 = (this.gMI.getY() + rawY) - this.mLastY;
                if (y2 < this.gNa - (this.gMI.getHeight() / 2)) {
                    y2 = this.gNa - (this.gMI.getHeight() / 2);
                } else if (y2 > ((this.gNa + this.mVideoHeight) - this.gMI.getHeight()) + (this.gMI.getHeight() / 2)) {
                    y2 = ((this.gNa + this.mVideoHeight) - this.gMI.getHeight()) + (this.gMI.getHeight() / 2);
                }
                float x = (this.gMI.getX() + rawX) - this.mLastX;
                if (x < this.gMZ - (this.gMI.getWidth() / 2)) {
                    x = this.gMZ - (this.gMI.getWidth() / 2);
                } else if (x > ((this.gMZ + this.mVideoWidth) - this.gMI.getWidth()) + (this.gMI.getWidth() / 2)) {
                    x = ((this.gMZ + this.mVideoWidth) - this.gMI.getWidth()) + (this.gMI.getWidth() / 2);
                }
                this.gMI.setX(x);
                this.gMI.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gML.getTextSize() != f) {
            this.gML.setTextSize(i, f);
        }
        if (this.gMK.getTextSize() != f) {
            this.gMK.setTextSize(i, f);
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
        matrix.postRotate(this.gMI.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gMV - motionEvent.getRawY(), this.gMU - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cKC && Math.abs(motionEvent.getRawY() - this.bTm) < this.cKC;
    }

    private void init() {
        this.gMJ = (RotateFrameLayout) this.gMI.findViewById(d.g.content_container);
        this.gMK = (TextView) this.gMI.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gMI.findViewById(d.g.content_view);
        this.gML = (EditText) this.gMI.findViewById(d.g.cover_edit);
        this.gMM = (ImageView) this.gMI.findViewById(d.g.cover_delete);
        this.gMN = (ImageView) this.gMI.findViewById(d.g.cover_scale);
    }

    public void bhP() {
        this.gMK.setText(this.gML.getText());
        this.gMK.setVisibility(0);
        this.gML.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gMK.getText())) {
            this.gMO = 0;
            this.gMI.setVisibility(8);
        }
        if (this.gMO == 4) {
            bwV();
        }
        this.gMY.HidenSoftKeyPad(this.gML);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gML.setFocusable(true);
            this.gML.setFocusableInTouchMode(true);
            this.gML.requestFocus();
            return;
        }
        this.gML.setFocusable(false);
        this.gML.setFocusableInTouchMode(false);
    }

    public void a(View view2, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gML.setText("");
                    bhP();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bwX();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bwX();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bwX();
                    break;
                default:
                    bhP();
                    String tV = com.baidu.tieba.video.editvideo.model.b.bwQ().tV(pendantData.resource);
                    if (TextUtils.isEmpty(tV)) {
                        if (view2 != null && (view2.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view2.getTag();
                            bVar.gLD.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bwQ().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tV, pendantData);
                        break;
                    }
                    break;
            }
            this.gMO = pendantData.pendantType;
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
        bwV();
        a(this.mVideoWidth, l.e(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gMO == 4 || this.gMO == 0) {
            this.gMI.setX(this.gMZ);
            this.gMI.setY(((this.mVideoHeight - l.e(getContext(), d.e.ds100)) / 2) + this.gNa);
            String obj = this.gML.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gML.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gMK.setText(a2);
                    this.gML.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bwV() {
        if (this.gNd) {
            this.gNd = false;
            this.gMM.setVisibility(8);
            this.gMN.setVisibility(8);
            this.gMJ.setBackgroundColor(getResources().getColor(d.C0126d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        if (!this.gNd) {
            this.gNd = true;
            this.gMM.setVisibility(0);
            this.gMN.setVisibility(0);
            this.gMJ.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.gNp != null) {
            Bitmap bitmap = this.gNp.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gNp.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bwV();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gMX = 1.0f;
                this.gaW = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gMX = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gMS = (this.gNj * 2) + width;
                this.gMT = (this.gNj * 2) + height;
                this.gMW = (this.gMS * 1.0f) / this.gMT;
                this.gMI.setX((((this.mVideoWidth - i2) - (this.gNj * 2)) / 2) + this.gMZ);
                this.gMI.setY((((this.mVideoHeight - i) - (this.gNj * 2)) / 2) + this.gNa);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gNq = motionEvent.getRawX();
                this.gNr = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gNq);
                float abs2 = Math.abs(rawY - this.gNr);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cKC && abs2 < this.cKC && System.currentTimeMillis() - this.startTime < 300) {
                    bhP();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gMK == null || this.gMK.getText() == null) {
            return null;
        }
        return this.gMK.getText().toString();
    }

    public void bwX() {
        this.gMK.setText(this.gML.getText());
        this.gMK.setVisibility(8);
        this.gML.setVisibility(0);
        setEditTextEnable(true);
        this.gMY.ShowSoftKeyPad(this.gML);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gML.setTextAppearance(getContext(), d.l.cover_text_style);
            this.gMK.setTextAppearance(getContext(), d.l.cover_text_style);
            i2 = (int) ((l.e(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.e(getContext(), d.e.fontsize40) * i) / i3);
            this.gNj = 0;
            this.gML.setMaxLines(1);
            this.gMK.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gMK.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gML.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.e(getContext(), d.e.ds60), 0, l.e(getContext(), d.e.ds60), 0);
        } else {
            this.gML.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gMK.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gNj = l.e(getContext(), d.e.ds40);
            this.gML.setMaxLines(2);
            this.gMK.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gMK.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gML.setLayoutParams(layoutParams2);
            this.gNf = (int) (l.dip2px(getContext(), pendantData.left) * this.gMX);
            this.gNg = (int) (l.dip2px(getContext(), pendantData.top) * this.gMX);
            this.gNh = (int) (l.dip2px(getContext(), pendantData.right) * this.gMX);
            this.gNi = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gMX);
            this.mContentView.setPadding(this.gNf, this.gNg, this.gNh, this.gNi);
            this.gNe = l.e(getContext(), d.e.fontsize40) * this.gMX;
            String text = getText();
            this.gNk = (i2 - this.gNg) - this.gNi;
            this.gNl = (i - this.gNf) - this.gNh;
            this.gNn = this.gNm + l.e(getContext(), d.e.ds6);
            setTextSize(0, this.gNe);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.k.cover_hint), this.gNl);
                this.gNe = this.gML.getTextSize();
                bwW();
                bwX();
            } else {
                if (w.hm(text) > 20) {
                    text = w.F(text, 20);
                    this.gML.setText(text);
                    this.gMK.setText(text);
                }
                tX(text);
            }
        }
        this.gMK.setIncludeFontPadding(false);
        this.gML.setIncludeFontPadding(false);
        this.gMK.setLineSpacing(this.gNm, 1.0f);
        this.gML.setLineSpacing(this.gNm, 1.0f);
        this.gMI.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gMI.getLayoutParams();
        layoutParams3.height = (this.gNj * 2) + i2;
        layoutParams3.width = (this.gNj * 2) + i;
        this.gMI.setLayoutParams(layoutParams3);
        this.gNo = (this.gNj * 2) + i;
        ((FrameLayout.LayoutParams) this.gMJ.getLayoutParams()).setMargins(this.gNj, this.gNj, this.gNj, this.gNj);
        this.gMI.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bwY();
        }
        return this.mTempBitmap;
    }

    private void bwY() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bwZ() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void mS(boolean z) {
        if (this.gMO != 0) {
            if (z) {
                bwZ();
                this.gMI.setVisibility(0);
                return;
            }
            bhP();
            getTempBitmap();
            this.gMI.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gNp.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gNp.clear();
        this.gNp = null;
        bwZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gNt;
        WeakReference<CoverPendantDragView> gNu;
        WeakReference<PendantData> gNv;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gNt = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gNu = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.gNv = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ci(String str, String str2) {
            if (this.gNt != null && this.gNt.get() != null) {
                this.gNt.get().gLD.setVisibility(8);
            }
            if (this.gNu != null && this.gNu.get() != null && this.gNv != null && this.gNv.get() != null) {
                this.gNu.get().a(str2, this.gNv.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tL(String str) {
            if (this.gNt != null && this.gNt.get() != null) {
                this.gNt.get().gLD.setVisibility(8);
            }
            if (this.gNu != null && this.gNu.get() != null) {
                l.showToast(this.gNu.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bwb() {
            if (this.gNt != null && this.gNt.get() != null) {
                this.gNt.get().gLD.setVisibility(8);
            }
        }
    }
}
