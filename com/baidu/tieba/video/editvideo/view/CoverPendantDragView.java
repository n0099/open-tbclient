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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float cSR;
    private float ceo;
    private float grl;
    private float hdA;
    private float hdB;
    private int hdC;
    private int hdD;
    private float hdE;
    private float hdF;
    private float hdG;
    private float hdH;
    private b hdI;
    private float hdJ;
    private float hdK;
    private float hdL;
    private float hdM;
    private boolean hdN;
    private float hdO;
    private int hdP;
    private int hdQ;
    private int hdR;
    private int hdS;
    private int hdT;
    private float hdU;
    private float hdV;
    private int hdW;
    private float hdX;
    private int hdY;
    private Map<String, Bitmap> hdZ;
    private FrameLayout hds;
    private RotateFrameLayout hdt;
    private TextView hdu;
    private EditText hdv;
    private ImageView hdw;
    private ImageView hdx;
    private int hdy;
    private boolean hdz;
    float hea;
    float heb;
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
        this.hdy = 0;
        this.hdH = 1.0f;
        this.grl = 1.0f;
        this.hdN = true;
        this.hdZ = new HashMap();
        this.startTime = 0L;
        this.hea = 0.0f;
        this.heb = 0.0f;
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
        this.hdO = l.e(getContext(), d.e.fontsize40);
        this.hdW = l.e(getContext(), d.e.ds2);
        this.cSR = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hds = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.i.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hds);
        this.hds.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.hdy == 4) {
                            CoverPendantDragView.this.bCB();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.ceo);
                        if (!CoverPendantDragView.this.hdz && abs < CoverPendantDragView.this.cSR && abs2 < CoverPendantDragView.this.cSR && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bCC();
                        }
                        CoverPendantDragView.this.hdA = 0.0f;
                        CoverPendantDragView.this.hdB = 0.0f;
                        CoverPendantDragView.this.hdz = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.F(motionEvent)) {
                            CoverPendantDragView.this.H(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.hdA = 0.0f;
                        CoverPendantDragView.this.hdB = 0.0f;
                        return true;
                }
            }
        });
        this.hdw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hdv.setText("");
                CoverPendantDragView.this.bnr();
            }
        });
        this.hdx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hdB = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.F(motionEvent)) {
                            CoverPendantDragView.this.G(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.hdv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hdy != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hdu.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_text_length_max_tips);
                    }
                } else if (x.hM(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hdu.getText().length()) {
                        CoverPendantDragView.this.uQ(obj);
                    } else {
                        CoverPendantDragView.this.uP(obj);
                    }
                } else {
                    String F = x.F(obj, 20);
                    editable.delete(F.length(), obj.length());
                    CoverPendantDragView.this.uQ(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hdu.setText(editable.toString());
            }
        });
        this.hdv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hds.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.ceo = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.ceo;
        this.hdE = (this.hds.getWidth() / 2) + this.hds.getX();
        this.hdF = (this.hds.getHeight() / 2) + this.hds.getY();
        this.hdu.setText(this.hdv.getText());
        this.hdu.setVisibility(0);
        this.hdv.setVisibility(8);
        setEditTextEnable(false);
        this.hdI.HidenSoftKeyPad(this.hdv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(String str) {
        TextPaint paint = this.hdv.getPaint();
        float measureText = paint.measureText(str);
        while (this.hdv.getLineCount() == 1 && this.hdv.getTextSize() < this.hdO * this.grl && measureText < this.hdV * this.grl) {
            setTextSize(0, this.hdv.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (x.hM(str) <= x.hM(getResources().getString(d.k.cover_hint)) && this.hdv.getTextSize() != this.hdO * this.grl) {
            setTextSize(0, this.hdO * this.grl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(String str) {
        TextPaint paint = this.hdv.getPaint();
        float measureText = paint.measureText(str);
        while (this.hdv.getTextSize() > ((this.hdU * this.grl) / 2.0f) - (this.hdX * this.grl) && measureText > this.hdV * this.grl) {
            setTextSize(0, this.hdv.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.hdv.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hdv.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.e(getContext(), d.e.ds120)) {
            str = x.I(str, x.hL(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hdI = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hdJ = f;
        this.hdK = f2;
        this.hdL = f3;
        this.hdM = f4;
        if (this.hdJ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hdJ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hdK > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hdK);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hdL > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hdL) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hdM > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hdM) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hdE - rawX);
        float abs4 = Math.abs(this.hdF - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hdE - this.mLastX);
        float abs6 = Math.abs(this.hdF - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bN(sqrt, (int) (sqrt / this.hdG));
        if (this.hdB != 0.0f) {
            this.hds.setRotation(this.hds.getRotation() - (this.hdB - J));
        }
        this.hdB = J;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bN(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hds.getLayoutParams();
        int width = this.hds.getWidth() - i;
        int i3 = (int) (width / this.hdG);
        if (width < this.hdC) {
            width = this.hdC;
            i3 = (int) (width / this.hdG);
        }
        this.grl = ((width * 1.0f) - (this.hdT * 2)) / (this.hdY - (this.hdT * 2));
        this.mContentView.setPadding((int) (this.hdP * this.grl), (int) (this.hdQ * this.grl), (int) (this.hdR * this.grl), (int) (this.hdS * this.grl));
        setTextSize(0, (this.hdv.getTextSize() * i3) / this.hds.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hds.setLayoutParams(layoutParams);
        float f = this.hdE - (layoutParams.width / 2);
        float f2 = this.hdF - (layoutParams.height / 2);
        this.hds.setX(f);
        this.hds.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hdy != 4) {
            float y = (this.hds.getY() + rawY) - this.mLastY;
            if (y < this.hdK) {
                y = this.hdK;
            } else if (y > (this.hdK + this.mVideoHeight) - this.hds.getHeight()) {
                y = (this.hdK + this.mVideoHeight) - this.hds.getHeight();
            }
            this.hds.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hdz = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.hdA != 0.0f) {
                    int i = (int) (this.hdA - K);
                    bN(i, (int) (i / this.hdG));
                }
                if (this.hdB != 0.0f) {
                    this.hds.setRotation(this.hds.getRotation() - (this.hdB - I));
                }
                this.hdB = I;
                this.hdA = K;
            } else if (!this.hdz && pointerCount == 1) {
                float y2 = (this.hds.getY() + rawY) - this.mLastY;
                if (y2 < this.hdK - (this.hds.getHeight() / 2)) {
                    y2 = this.hdK - (this.hds.getHeight() / 2);
                } else if (y2 > ((this.hdK + this.mVideoHeight) - this.hds.getHeight()) + (this.hds.getHeight() / 2)) {
                    y2 = ((this.hdK + this.mVideoHeight) - this.hds.getHeight()) + (this.hds.getHeight() / 2);
                }
                float x = (this.hds.getX() + rawX) - this.mLastX;
                if (x < this.hdJ - (this.hds.getWidth() / 2)) {
                    x = this.hdJ - (this.hds.getWidth() / 2);
                } else if (x > ((this.hdJ + this.mVideoWidth) - this.hds.getWidth()) + (this.hds.getWidth() / 2)) {
                    x = ((this.hdJ + this.mVideoWidth) - this.hds.getWidth()) + (this.hds.getWidth() / 2);
                }
                this.hds.setX(x);
                this.hds.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hdv.getTextSize() != f) {
            this.hdv.setTextSize(i, f);
        }
        if (this.hdu.getTextSize() != f) {
            this.hdu.setTextSize(i, f);
        }
    }

    private float I(MotionEvent motionEvent) {
        float[] c = c(motionEvent, 0);
        float f = c[0];
        float f2 = c[1];
        float[] c2 = c(motionEvent, 1);
        float f3 = c2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - c2[1], f - f3));
    }

    private float[] c(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.hds.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hdF - motionEvent.getRawY(), this.hdE - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cSR && Math.abs(motionEvent.getRawY() - this.ceo) < this.cSR;
    }

    private void init() {
        this.hdt = (RotateFrameLayout) this.hds.findViewById(d.g.content_container);
        this.hdu = (TextView) this.hds.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hds.findViewById(d.g.content_view);
        this.hdv = (EditText) this.hds.findViewById(d.g.cover_edit);
        this.hdw = (ImageView) this.hds.findViewById(d.g.cover_delete);
        this.hdx = (ImageView) this.hds.findViewById(d.g.cover_scale);
    }

    public void bnr() {
        this.hdu.setText(this.hdv.getText());
        this.hdu.setVisibility(0);
        this.hdv.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hdu.getText())) {
            this.hdy = 0;
            this.hds.setVisibility(8);
        }
        if (this.hdy == 4) {
            bCA();
        }
        this.hdI.HidenSoftKeyPad(this.hdv);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hdv.setFocusable(true);
            this.hdv.setFocusableInTouchMode(true);
            this.hdv.requestFocus();
            return;
        }
        this.hdv.setFocusable(false);
        this.hdv.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hdv.setText("");
                    bnr();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bCC();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bCC();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bCC();
                    break;
                default:
                    bnr();
                    String uO = com.baidu.tieba.video.editvideo.model.b.bCv().uO(pendantData.resource);
                    if (TextUtils.isEmpty(uO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hcn.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bCv().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(uO, pendantData);
                        break;
                    }
                    break;
            }
            this.hdy = pendantData.pendantType;
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
        bCA();
        a(this.mVideoWidth, l.e(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hdy == 4 || this.hdy == 0) {
            this.hds.setX(this.hdJ);
            this.hds.setY(((this.mVideoHeight - l.e(getContext(), d.e.ds100)) / 2) + this.hdK);
            String obj = this.hdv.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hdv.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hdu.setText(a2);
                    this.hdv.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bCA() {
        if (this.hdN) {
            this.hdN = false;
            this.hdw.setVisibility(8);
            this.hdx.setVisibility(8);
            this.hdt.setBackgroundColor(getResources().getColor(d.C0142d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCB() {
        if (!this.hdN) {
            this.hdN = true;
            this.hdw.setVisibility(0);
            this.hdx.setVisibility(0);
            this.hdt.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.hdZ != null) {
            Bitmap bitmap = this.hdZ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hdZ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bCA();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hdH = 1.0f;
                this.grl = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hdH = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hdC = (this.hdT * 2) + width;
                this.hdD = (this.hdT * 2) + height;
                this.hdG = (this.hdC * 1.0f) / this.hdD;
                this.hds.setX((((this.mVideoWidth - i2) - (this.hdT * 2)) / 2) + this.hdJ);
                this.hds.setY((((this.mVideoHeight - i) - (this.hdT * 2)) / 2) + this.hdK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hea = motionEvent.getRawX();
                this.heb = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hea);
                float abs2 = Math.abs(rawY - this.heb);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cSR && abs2 < this.cSR && System.currentTimeMillis() - this.startTime < 300) {
                    bnr();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hdu == null || this.hdu.getText() == null) {
            return null;
        }
        return this.hdu.getText().toString();
    }

    public void bCC() {
        this.hdu.setText(this.hdv.getText());
        this.hdu.setVisibility(8);
        this.hdv.setVisibility(0);
        setEditTextEnable(true);
        this.hdI.ShowSoftKeyPad(this.hdv);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hdv.setTextAppearance(getContext(), d.l.cover_text_style);
            this.hdu.setTextAppearance(getContext(), d.l.cover_text_style);
            i2 = (int) ((l.e(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.e(getContext(), d.e.fontsize40) * i) / i3);
            this.hdT = 0;
            this.hdv.setMaxLines(1);
            this.hdu.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdu.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hdv.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.e(getContext(), d.e.ds60), 0, l.e(getContext(), d.e.ds60), 0);
        } else {
            this.hdv.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.hdu.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.hdT = l.e(getContext(), d.e.ds40);
            this.hdv.setMaxLines(2);
            this.hdu.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hdu.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hdv.setLayoutParams(layoutParams2);
            this.hdP = (int) (l.dip2px(getContext(), pendantData.left) * this.hdH);
            this.hdQ = (int) (l.dip2px(getContext(), pendantData.top) * this.hdH);
            this.hdR = (int) (l.dip2px(getContext(), pendantData.right) * this.hdH);
            this.hdS = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hdH);
            this.mContentView.setPadding(this.hdP, this.hdQ, this.hdR, this.hdS);
            this.hdO = l.e(getContext(), d.e.fontsize40) * this.hdH;
            String text = getText();
            this.hdU = (i2 - this.hdQ) - this.hdS;
            this.hdV = (i - this.hdP) - this.hdR;
            this.hdX = this.hdW + l.e(getContext(), d.e.ds6);
            setTextSize(0, this.hdO);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.k.cover_hint), this.hdV);
                this.hdO = this.hdv.getTextSize();
                bCB();
                bCC();
            } else {
                if (x.hM(text) > 20) {
                    text = x.F(text, 20);
                    this.hdv.setText(text);
                    this.hdu.setText(text);
                }
                uQ(text);
            }
        }
        this.hdu.setIncludeFontPadding(false);
        this.hdv.setIncludeFontPadding(false);
        this.hdu.setLineSpacing(this.hdW, 1.0f);
        this.hdv.setLineSpacing(this.hdW, 1.0f);
        this.hds.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hds.getLayoutParams();
        layoutParams3.height = (this.hdT * 2) + i2;
        layoutParams3.width = (this.hdT * 2) + i;
        this.hds.setLayoutParams(layoutParams3);
        this.hdY = (this.hdT * 2) + i;
        ((FrameLayout.LayoutParams) this.hdt.getLayoutParams()).setMargins(this.hdT, this.hdT, this.hdT, this.hdT);
        this.hds.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bCD();
        }
        return this.mTempBitmap;
    }

    private void bCD() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bCE() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nh(boolean z) {
        if (this.hdy != 0) {
            if (z) {
                bCE();
                this.hds.setVisibility(0);
                return;
            }
            bnr();
            getTempBitmap();
            this.hds.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hdZ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hdZ.clear();
        this.hdZ = null;
        bCE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hed;
        WeakReference<CoverPendantDragView> hee;
        WeakReference<PendantData> hef;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hed = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hee = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hef = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cu(String str, String str2) {
            if (this.hed != null && this.hed.get() != null) {
                this.hed.get().hcn.setVisibility(8);
            }
            if (this.hee != null && this.hee.get() != null && this.hef != null && this.hef.get() != null) {
                this.hee.get().a(str2, this.hef.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void uE(String str) {
            if (this.hed != null && this.hed.get() != null) {
                this.hed.get().hcn.setVisibility(8);
            }
            if (this.hee != null && this.hee.get() != null) {
                l.showToast(this.hee.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bBG() {
            if (this.hed != null && this.hed.get() != null) {
                this.hed.get().hcn.setVisibility(8);
            }
        }
    }
}
