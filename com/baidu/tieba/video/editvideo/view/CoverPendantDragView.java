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
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bgY;
    private float cVE;
    private float fNq;
    private float gsx;
    private FrameLayout heE;
    private RotateFrameLayout heF;
    private TextView heG;
    private EditText heH;
    private ImageView heI;
    private ImageView heJ;
    private int heK;
    private float heL;
    private boolean heM;
    private float heN;
    private float heO;
    private int heP;
    private int heQ;
    private float heR;
    private float heS;
    private float heT;
    private float heU;
    private b heV;
    private float heW;
    private float heX;
    private float heY;
    private float heZ;
    private boolean hfa;
    private float hfb;
    private int hfc;
    private int hfd;
    private int hfe;
    private int hff;
    private int hfg;
    private float hfh;
    private float hfi;
    private int hfj;
    private float hfk;
    private int hfl;
    private Map<String, Bitmap> hfm;
    private Bitmap hfn;
    float hfo;
    float hfp;
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
        this.heK = 0;
        this.heU = 1.0f;
        this.gsx = 1.0f;
        this.hfa = true;
        this.hfm = new HashMap();
        this.startTime = 0L;
        this.hfo = 0.0f;
        this.hfp = 0.0f;
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
        this.hfb = l.f(getContext(), d.e.fontsize40);
        this.hfj = l.f(getContext(), d.e.ds2);
        this.cVE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.heE = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.heE);
        this.heE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.heK == 4) {
                            CoverPendantDragView.this.bBm();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bgY);
                        if (!CoverPendantDragView.this.heM && abs < CoverPendantDragView.this.cVE && abs2 < CoverPendantDragView.this.cVE && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBn();
                        }
                        CoverPendantDragView.this.heN = 0.0f;
                        CoverPendantDragView.this.heO = 0.0f;
                        CoverPendantDragView.this.heM = false;
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
                        CoverPendantDragView.this.heN = 0.0f;
                        CoverPendantDragView.this.heO = 0.0f;
                        return true;
                }
            }
        });
        this.heI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.heH.setText("");
                CoverPendantDragView.this.blK();
            }
        });
        this.heJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.heO = 0.0f;
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
        this.heH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.heK != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.heG.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hJ(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.heG.getText().length()) {
                        CoverPendantDragView.this.uO(obj);
                    } else {
                        CoverPendantDragView.this.uN(obj);
                    }
                } else {
                    String B = w.B(obj, 20);
                    editable.delete(B.length(), obj.length());
                    CoverPendantDragView.this.uO(B);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.heG.setText(editable.toString());
            }
        });
        this.heH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.heE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bgY = motionEvent.getRawY();
        this.heL = this.mDownX;
        this.fNq = this.bgY;
        this.heR = (this.heE.getWidth() / 2) + this.heE.getX();
        this.heS = (this.heE.getHeight() / 2) + this.heE.getY();
        this.heG.setText(this.heH.getText());
        this.heG.setVisibility(0);
        this.heH.setVisibility(8);
        setEditTextEnable(false);
        this.heV.HidenSoftKeyPad(this.heH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(String str) {
        TextPaint paint = this.heH.getPaint();
        float measureText = paint.measureText(str);
        while (this.heH.getLineCount() == 1 && this.heH.getTextSize() < this.hfb * this.gsx && measureText < this.hfi * this.gsx) {
            setTextSize(0, this.heH.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hJ(str) <= w.hJ(getResources().getString(d.j.cover_hint)) && this.heH.getTextSize() != this.hfb * this.gsx) {
            setTextSize(0, this.hfb * this.gsx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(String str) {
        TextPaint paint = this.heH.getPaint();
        float measureText = paint.measureText(str);
        while (this.heH.getTextSize() > ((this.hfh * this.gsx) / 2.0f) - (this.hfk * this.gsx) && measureText > this.hfi * this.gsx) {
            setTextSize(0, this.heH.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.heH.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.heH.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.f(getContext(), d.e.ds120)) {
            str = w.D(str, w.hI(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.heV = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.heW = f;
        this.heX = f2;
        this.heY = f3;
        this.heZ = f4;
        if (this.heW > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.heW, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.heX > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.heX);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.heY > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.heY) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.heZ > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.heZ) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float K = K(motionEvent);
        float abs = Math.abs(this.heL - rawX);
        float abs2 = Math.abs(this.fNq - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.heR - rawX);
        float abs4 = Math.abs(this.heS - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.heR - this.heL);
        float abs6 = Math.abs(this.heS - this.fNq);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bO(sqrt, (int) (sqrt / this.heT));
        if (this.heO != 0.0f) {
            this.heE.setRotation(this.heE.getRotation() - (this.heO - K));
        }
        this.heO = K;
        this.heL = rawX;
        this.fNq = rawY;
    }

    private void bO(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heE.getLayoutParams();
        int width = this.heE.getWidth() - i;
        int i3 = (int) (width / this.heT);
        if (width < this.heP) {
            width = this.heP;
            i3 = (int) (width / this.heT);
        }
        this.gsx = ((width * 1.0f) - (this.hfg * 2)) / (this.hfl - (this.hfg * 2));
        this.mContentView.setPadding((int) (this.hfc * this.gsx), (int) (this.hfd * this.gsx), (int) (this.hfe * this.gsx), (int) (this.hff * this.gsx));
        setTextSize(0, (this.heH.getTextSize() * i3) / this.heE.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.heE.setLayoutParams(layoutParams);
        float f = this.heR - (layoutParams.width / 2);
        float f2 = this.heS - (layoutParams.height / 2);
        this.heE.setX(f);
        this.heE.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.heK != 4) {
            float y = (this.heE.getY() + rawY) - this.fNq;
            if (y < this.heX) {
                y = this.heX;
            } else if (y > (this.heX + this.mVideoHeight) - this.heE.getHeight()) {
                y = (this.heX + this.mVideoHeight) - this.heE.getHeight();
            }
            this.heE.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.heM = true;
                float L = L(motionEvent);
                float J = J(motionEvent);
                if (this.heN != 0.0f) {
                    int i = (int) (this.heN - L);
                    bO(i, (int) (i / this.heT));
                }
                if (this.heO != 0.0f) {
                    this.heE.setRotation(this.heE.getRotation() - (this.heO - J));
                }
                this.heO = J;
                this.heN = L;
            } else if (!this.heM && pointerCount == 1) {
                float y2 = (this.heE.getY() + rawY) - this.fNq;
                if (y2 < this.heX - (this.heE.getHeight() / 2)) {
                    y2 = this.heX - (this.heE.getHeight() / 2);
                } else if (y2 > ((this.heX + this.mVideoHeight) - this.heE.getHeight()) + (this.heE.getHeight() / 2)) {
                    y2 = ((this.heX + this.mVideoHeight) - this.heE.getHeight()) + (this.heE.getHeight() / 2);
                }
                float x = (this.heE.getX() + rawX) - this.heL;
                if (x < this.heW - (this.heE.getWidth() / 2)) {
                    x = this.heW - (this.heE.getWidth() / 2);
                } else if (x > ((this.heW + this.mVideoWidth) - this.heE.getWidth()) + (this.heE.getWidth() / 2)) {
                    x = ((this.heW + this.mVideoWidth) - this.heE.getWidth()) + (this.heE.getWidth() / 2);
                }
                this.heE.setX(x);
                this.heE.setY(y2);
            }
        }
        this.heL = rawX;
        this.fNq = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.heH.getTextSize() != f) {
            this.heH.setTextSize(i, f);
        }
        if (this.heG.getTextSize() != f) {
            this.heG.setTextSize(i, f);
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
        matrix.postRotate(this.heE.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float K(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.heS - motionEvent.getRawY(), this.heR - motionEvent.getRawX()));
    }

    private float L(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cVE && Math.abs(motionEvent.getRawY() - this.bgY) < this.cVE;
    }

    private void init() {
        this.heF = (RotateFrameLayout) this.heE.findViewById(d.g.content_container);
        this.heG = (TextView) this.heE.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.heE.findViewById(d.g.content_view);
        this.heH = (EditText) this.heE.findViewById(d.g.cover_edit);
        this.heI = (ImageView) this.heE.findViewById(d.g.cover_delete);
        this.heJ = (ImageView) this.heE.findViewById(d.g.cover_scale);
    }

    public void blK() {
        this.heG.setText(this.heH.getText());
        this.heG.setVisibility(0);
        this.heH.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.heG.getText())) {
            this.heK = 0;
            this.heE.setVisibility(8);
        }
        if (this.heK == 4) {
            bBl();
        }
        this.heV.HidenSoftKeyPad(this.heH);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.heH.setFocusable(true);
            this.heH.setFocusableInTouchMode(true);
            this.heH.requestFocus();
            return;
        }
        this.heH.setFocusable(false);
        this.heH.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.heH.setText("");
                    blK();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBn();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBn();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBn();
                    break;
                default:
                    blK();
                    String uM = com.baidu.tieba.video.editvideo.model.b.bBg().uM(pendantData.resource);
                    if (TextUtils.isEmpty(uM)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hdz.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBg().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(uM, pendantData);
                        break;
                    }
                    break;
            }
            this.heK = pendantData.pendantType;
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
        bBl();
        a(this.mVideoWidth, l.f(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.heK == 4 || this.heK == 0) {
            this.heE.setX(this.heW);
            this.heE.setY(((this.mVideoHeight - l.f(getContext(), d.e.ds100)) / 2) + this.heX);
            String obj = this.heH.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.heH.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.heG.setText(a2);
                    this.heH.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBl() {
        if (this.hfa) {
            this.hfa = false;
            this.heI.setVisibility(8);
            this.heJ.setVisibility(8);
            this.heF.setBackgroundColor(getResources().getColor(d.C0140d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        if (!this.hfa) {
            this.hfa = true;
            this.heI.setVisibility(0);
            this.heJ.setVisibility(0);
            this.heF.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hfm != null) {
            Bitmap bitmap = this.hfm.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hfm.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBl();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.heU = 1.0f;
                this.gsx = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.heU = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.heP = (this.hfg * 2) + width;
                this.heQ = (this.hfg * 2) + height;
                this.heT = (this.heP * 1.0f) / this.heQ;
                this.heE.setX((((this.mVideoWidth - i2) - (this.hfg * 2)) / 2) + this.heW);
                this.heE.setY((((this.mVideoHeight - i) - (this.hfg * 2)) / 2) + this.heX);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hfo = motionEvent.getRawX();
                this.hfp = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hfo);
                float abs2 = Math.abs(rawY - this.hfp);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cVE && abs2 < this.cVE && System.currentTimeMillis() - this.startTime < 300) {
                    blK();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.heG == null || this.heG.getText() == null) {
            return null;
        }
        return this.heG.getText().toString();
    }

    public void bBn() {
        this.heG.setText(this.heH.getText());
        this.heG.setVisibility(8);
        this.heH.setVisibility(0);
        setEditTextEnable(true);
        this.heV.ShowSoftKeyPad(this.heH);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.heH.setTextAppearance(getContext(), d.k.cover_text_style);
            this.heG.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.f(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.f(getContext(), d.e.fontsize40) * i) / i3);
            this.hfg = 0;
            this.heH.setMaxLines(1);
            this.heG.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heG.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.heH.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.f(getContext(), d.e.ds60), 0, l.f(getContext(), d.e.ds60), 0);
        } else {
            this.heH.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.heG.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hfg = l.f(getContext(), d.e.ds40);
            this.heH.setMaxLines(2);
            this.heG.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.heG.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.heH.setLayoutParams(layoutParams2);
            this.hfc = (int) (l.dip2px(getContext(), pendantData.left) * this.heU);
            this.hfd = (int) (l.dip2px(getContext(), pendantData.top) * this.heU);
            this.hfe = (int) (l.dip2px(getContext(), pendantData.right) * this.heU);
            this.hff = (int) (l.dip2px(getContext(), pendantData.bottom) * this.heU);
            this.mContentView.setPadding(this.hfc, this.hfd, this.hfe, this.hff);
            this.hfb = l.f(getContext(), d.e.fontsize40) * this.heU;
            String text = getText();
            this.hfh = (i2 - this.hfd) - this.hff;
            this.hfi = (i - this.hfc) - this.hfe;
            this.hfk = this.hfj + l.f(getContext(), d.e.ds6);
            setTextSize(0, this.hfb);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.j.cover_hint), this.hfi);
                this.hfb = this.heH.getTextSize();
                bBm();
                bBn();
            } else {
                if (w.hJ(text) > 20) {
                    text = w.B(text, 20);
                    this.heH.setText(text);
                    this.heG.setText(text);
                }
                uO(text);
            }
        }
        this.heG.setIncludeFontPadding(false);
        this.heH.setIncludeFontPadding(false);
        this.heG.setLineSpacing(this.hfj, 1.0f);
        this.heH.setLineSpacing(this.hfj, 1.0f);
        this.heE.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.heE.getLayoutParams();
        layoutParams3.height = (this.hfg * 2) + i2;
        layoutParams3.width = (this.hfg * 2) + i;
        this.heE.setLayoutParams(layoutParams3);
        this.hfl = (this.hfg * 2) + i;
        ((FrameLayout.LayoutParams) this.heF.getLayoutParams()).setMargins(this.hfg, this.hfg, this.hfg, this.hfg);
        this.heE.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.hfn == null) {
            bBo();
        }
        return this.hfn;
    }

    private void bBo() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.hfn = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBp() {
        if (this.hfn != null && !this.hfn.isRecycled()) {
            this.hfn.recycle();
            this.hfn = null;
        }
    }

    public void mT(boolean z) {
        if (this.heK != 0) {
            if (z) {
                bBp();
                this.heE.setVisibility(0);
                return;
            }
            blK();
            getTempBitmap();
            this.heE.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hfm.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hfm.clear();
        this.hfm = null;
        bBp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hfr;
        WeakReference<CoverPendantDragView> hfs;
        WeakReference<PendantData> hft;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hfr = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hfs = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hft = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cr(String str, String str2) {
            if (this.hfr != null && this.hfr.get() != null) {
                this.hfr.get().hdz.setVisibility(8);
            }
            if (this.hfs != null && this.hfs.get() != null && this.hft != null && this.hft.get() != null) {
                this.hfs.get().a(str2, this.hft.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void uC(String str) {
            if (this.hfr != null && this.hfr.get() != null) {
                this.hfr.get().hdz.setVisibility(8);
            }
            if (this.hfs != null && this.hfs.get() != null) {
                l.showToast(this.hfs.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAr() {
            if (this.hfr != null && this.hfr.get() != null) {
                this.hfr.get().hdz.setVisibility(8);
            }
        }
    }
}
