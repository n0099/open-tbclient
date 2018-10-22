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
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bqT;
    float dDH;
    float dDI;
    private float djD;
    private float gHv;
    private float gcE;
    private FrameLayout htN;
    private RotateFrameLayout htO;
    private TextView htP;
    private EditText htQ;
    private ImageView htR;
    private ImageView htS;
    private int htT;
    private float htU;
    private boolean htV;
    private float htW;
    private float htX;
    private int htY;
    private int htZ;
    private float hua;
    private float hub;
    private float huc;
    private float hud;
    private b hue;
    private float huf;
    private float hug;
    private float huh;
    private float hui;
    private boolean huj;
    private float huk;
    private int hul;
    private int hum;
    private int hun;
    private int huo;
    private int hup;
    private float huq;
    private float hur;
    private int hus;
    private float hut;
    private int huu;
    private Map<String, Bitmap> huv;
    private Bitmap huw;
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
        this.htT = 0;
        this.hud = 1.0f;
        this.gHv = 1.0f;
        this.huj = true;
        this.huv = new HashMap();
        this.startTime = 0L;
        this.dDH = 0.0f;
        this.dDI = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.huk = l.h(getContext(), e.C0175e.fontsize40);
        this.hus = l.h(getContext(), e.C0175e.ds2);
        this.djD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.htN = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.htN);
        this.htN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.htT == 4) {
                            CoverPendantDragView.this.bHr();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bqT);
                        if (!CoverPendantDragView.this.htV && abs < CoverPendantDragView.this.djD && abs2 < CoverPendantDragView.this.djD && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bHs();
                        }
                        CoverPendantDragView.this.htW = 0.0f;
                        CoverPendantDragView.this.htX = 0.0f;
                        CoverPendantDragView.this.htV = false;
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
                        CoverPendantDragView.this.htW = 0.0f;
                        CoverPendantDragView.this.htX = 0.0f;
                        return true;
                }
            }
        });
        this.htR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.htQ.setText("");
                CoverPendantDragView.this.brC();
            }
        });
        this.htS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.htX = 0.0f;
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
        this.htQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.htT != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.htP.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.iu(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.htP.getText().length()) {
                        CoverPendantDragView.this.wc(obj);
                    } else {
                        CoverPendantDragView.this.wb(obj);
                    }
                } else {
                    String H = y.H(obj, 20);
                    editable.delete(H.length(), obj.length());
                    CoverPendantDragView.this.wc(H);
                    l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.htP.setText(editable.toString());
            }
        });
        this.htQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.htN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bqT = motionEvent.getRawY();
        this.htU = this.mDownX;
        this.gcE = this.bqT;
        this.hua = (this.htN.getWidth() / 2) + this.htN.getX();
        this.hub = (this.htN.getHeight() / 2) + this.htN.getY();
        this.htP.setText(this.htQ.getText());
        this.htP.setVisibility(0);
        this.htQ.setVisibility(8);
        setEditTextEnable(false);
        this.hue.HidenSoftKeyPad(this.htQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(String str) {
        TextPaint paint = this.htQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.htQ.getLineCount() == 1 && this.htQ.getTextSize() < this.huk * this.gHv && measureText < this.hur * this.gHv) {
            setTextSize(0, this.htQ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.iu(str) <= y.iu(getResources().getString(e.j.cover_hint)) && this.htQ.getTextSize() != this.huk * this.gHv) {
            setTextSize(0, this.huk * this.gHv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc(String str) {
        TextPaint paint = this.htQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.htQ.getTextSize() > ((this.huq * this.gHv) / 2.0f) - (this.hut * this.gHv) && measureText > this.hur * this.gHv) {
            setTextSize(0, this.htQ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.htQ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.htQ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), e.C0175e.ds120)) {
            str = y.J(str, y.it(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hue = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.huf = f;
        this.hug = f2;
        this.huh = f3;
        this.hui = f4;
        if (this.huf > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.huf, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hug > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hug);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.huh > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.huh) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hui > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hui) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.htU - rawX);
        float abs2 = Math.abs(this.gcE - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.hua - rawX);
        float abs4 = Math.abs(this.hub - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hua - this.htU);
        float abs6 = Math.abs(this.hub - this.gcE);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bT(sqrt, (int) (sqrt / this.huc));
        if (this.htX != 0.0f) {
            this.htN.setRotation(this.htN.getRotation() - (this.htX - J));
        }
        this.htX = J;
        this.htU = rawX;
        this.gcE = rawY;
    }

    private void bT(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htN.getLayoutParams();
        int width = this.htN.getWidth() - i;
        int i3 = (int) (width / this.huc);
        if (width < this.htY) {
            width = this.htY;
            i3 = (int) (width / this.huc);
        }
        this.gHv = ((width * 1.0f) - (this.hup * 2)) / (this.huu - (this.hup * 2));
        this.mContentView.setPadding((int) (this.hul * this.gHv), (int) (this.hum * this.gHv), (int) (this.hun * this.gHv), (int) (this.huo * this.gHv));
        setTextSize(0, (this.htQ.getTextSize() * i3) / this.htN.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.htN.setLayoutParams(layoutParams);
        float f = this.hua - (layoutParams.width / 2);
        float f2 = this.hub - (layoutParams.height / 2);
        this.htN.setX(f);
        this.htN.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.htT != 4) {
            float y = (this.htN.getY() + rawY) - this.gcE;
            if (y < this.hug) {
                y = this.hug;
            } else if (y > (this.hug + this.mVideoHeight) - this.htN.getHeight()) {
                y = (this.hug + this.mVideoHeight) - this.htN.getHeight();
            }
            this.htN.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.htV = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.htW != 0.0f) {
                    int i = (int) (this.htW - K);
                    bT(i, (int) (i / this.huc));
                }
                if (this.htX != 0.0f) {
                    this.htN.setRotation(this.htN.getRotation() - (this.htX - I));
                }
                this.htX = I;
                this.htW = K;
            } else if (!this.htV && pointerCount == 1) {
                float y2 = (this.htN.getY() + rawY) - this.gcE;
                if (y2 < this.hug - (this.htN.getHeight() / 2)) {
                    y2 = this.hug - (this.htN.getHeight() / 2);
                } else if (y2 > ((this.hug + this.mVideoHeight) - this.htN.getHeight()) + (this.htN.getHeight() / 2)) {
                    y2 = ((this.hug + this.mVideoHeight) - this.htN.getHeight()) + (this.htN.getHeight() / 2);
                }
                float x = (this.htN.getX() + rawX) - this.htU;
                if (x < this.huf - (this.htN.getWidth() / 2)) {
                    x = this.huf - (this.htN.getWidth() / 2);
                } else if (x > ((this.huf + this.mVideoWidth) - this.htN.getWidth()) + (this.htN.getWidth() / 2)) {
                    x = ((this.huf + this.mVideoWidth) - this.htN.getWidth()) + (this.htN.getWidth() / 2);
                }
                this.htN.setX(x);
                this.htN.setY(y2);
            }
        }
        this.htU = rawX;
        this.gcE = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.htQ.getTextSize() != f) {
            this.htQ.setTextSize(i, f);
        }
        if (this.htP.getTextSize() != f) {
            this.htP.setTextSize(i, f);
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
        matrix.postRotate(this.htN.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hub - motionEvent.getRawY(), this.hua - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.djD && Math.abs(motionEvent.getRawY() - this.bqT) < this.djD;
    }

    private void init() {
        this.htO = (RotateFrameLayout) this.htN.findViewById(e.g.content_container);
        this.htP = (TextView) this.htN.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.htN.findViewById(e.g.content_view);
        this.htQ = (EditText) this.htN.findViewById(e.g.cover_edit);
        this.htR = (ImageView) this.htN.findViewById(e.g.cover_delete);
        this.htS = (ImageView) this.htN.findViewById(e.g.cover_scale);
    }

    public void brC() {
        this.htP.setText(this.htQ.getText());
        this.htP.setVisibility(0);
        this.htQ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.htP.getText())) {
            this.htT = 0;
            this.htN.setVisibility(8);
        }
        if (this.htT == 4) {
            bHq();
        }
        this.hue.HidenSoftKeyPad(this.htQ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.htQ.setFocusable(true);
            this.htQ.setFocusableInTouchMode(true);
            this.htQ.requestFocus();
            return;
        }
        this.htQ.setFocusable(false);
        this.htQ.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.htQ.setText("");
                    brC();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_blue);
                    bHs();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(e.f.bg_cover_edit_black);
                    bHs();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bHs();
                    break;
                default:
                    brC();
                    String wa = com.baidu.tieba.video.editvideo.model.b.bHl().wa(pendantData.resource);
                    if (TextUtils.isEmpty(wa)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hsI.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bHl().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(wa, pendantData);
                        break;
                    }
                    break;
            }
            this.htT = pendantData.pendantType;
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
        bHq();
        a(this.mVideoWidth, l.h(getContext(), e.C0175e.ds100), this.mScreenWidth, pendantData);
        if (this.htT == 4 || this.htT == 0) {
            this.htN.setX(this.huf);
            this.htN.setY(((this.mVideoHeight - l.h(getContext(), e.C0175e.ds100)) / 2) + this.hug);
            String obj = this.htQ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.htQ.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.htP.setText(a2);
                    this.htQ.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bHq() {
        if (this.huj) {
            this.huj = false;
            this.htR.setVisibility(8);
            this.htS.setVisibility(8);
            this.htO.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (!this.huj) {
            this.huj = true;
            this.htR.setVisibility(0);
            this.htS.setVisibility(0);
            this.htO.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.huv != null) {
            Bitmap bitmap = this.huv.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.huv.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bHq();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hud = 1.0f;
                this.gHv = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hud = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.htY = (this.hup * 2) + width;
                this.htZ = (this.hup * 2) + height;
                this.huc = (this.htY * 1.0f) / this.htZ;
                this.htN.setX((((this.mVideoWidth - i2) - (this.hup * 2)) / 2) + this.huf);
                this.htN.setY((((this.mVideoHeight - i) - (this.hup * 2)) / 2) + this.hug);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.dDH = motionEvent.getRawX();
                this.dDI = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.dDH);
                float abs2 = Math.abs(rawY - this.dDI);
                if (motionEvent.getPointerCount() <= 1 && abs < this.djD && abs2 < this.djD && System.currentTimeMillis() - this.startTime < 300) {
                    brC();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.htP == null || this.htP.getText() == null) {
            return null;
        }
        return this.htP.getText().toString();
    }

    public void bHs() {
        this.htP.setText(this.htQ.getText());
        this.htP.setVisibility(8);
        this.htQ.setVisibility(0);
        setEditTextEnable(true);
        this.hue.ShowSoftKeyPad(this.htQ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.htQ.setTextAppearance(getContext(), e.k.cover_text_style);
            this.htP.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0175e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0175e.fontsize40) * i) / i3);
            this.hup = 0;
            this.htQ.setMaxLines(1);
            this.htP.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htP.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.htQ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0175e.ds60), 0, l.h(getContext(), e.C0175e.ds60), 0);
        } else {
            this.htQ.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.htP.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.hup = l.h(getContext(), e.C0175e.ds40);
            this.htQ.setMaxLines(2);
            this.htP.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.htP.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.htQ.setLayoutParams(layoutParams2);
            this.hul = (int) (l.dip2px(getContext(), pendantData.left) * this.hud);
            this.hum = (int) (l.dip2px(getContext(), pendantData.top) * this.hud);
            this.hun = (int) (l.dip2px(getContext(), pendantData.right) * this.hud);
            this.huo = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hud);
            this.mContentView.setPadding(this.hul, this.hum, this.hun, this.huo);
            this.huk = l.h(getContext(), e.C0175e.fontsize40) * this.hud;
            String text = getText();
            this.huq = (i2 - this.hum) - this.huo;
            this.hur = (i - this.hul) - this.hun;
            this.hut = this.hus + l.h(getContext(), e.C0175e.ds6);
            setTextSize(0, this.huk);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.hur);
                this.huk = this.htQ.getTextSize();
                bHr();
                bHs();
            } else {
                if (y.iu(text) > 20) {
                    text = y.H(text, 20);
                    this.htQ.setText(text);
                    this.htP.setText(text);
                }
                wc(text);
            }
        }
        this.htP.setIncludeFontPadding(false);
        this.htQ.setIncludeFontPadding(false);
        this.htP.setLineSpacing(this.hus, 1.0f);
        this.htQ.setLineSpacing(this.hus, 1.0f);
        this.htN.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.htN.getLayoutParams();
        layoutParams3.height = (this.hup * 2) + i2;
        layoutParams3.width = (this.hup * 2) + i;
        this.htN.setLayoutParams(layoutParams3);
        this.huu = (this.hup * 2) + i;
        ((FrameLayout.LayoutParams) this.htO.getLayoutParams()).setMargins(this.hup, this.hup, this.hup, this.hup);
        this.htN.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.huw == null) {
            bHt();
        }
        return this.huw;
    }

    private void bHt() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.huw = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bHu() {
        if (this.huw != null && !this.huw.isRecycled()) {
            this.huw.recycle();
            this.huw = null;
        }
    }

    public void nH(boolean z) {
        if (this.htT != 0) {
            if (z) {
                bHu();
                this.htN.setVisibility(0);
                return;
            }
            brC();
            getTempBitmap();
            this.htN.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.huv.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.huv.clear();
        this.huv = null;
        bHu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<PendantData> huA;
        WeakReference<a.b> huy;
        WeakReference<CoverPendantDragView> huz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.huy = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.huz = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.huA = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cM(String str, String str2) {
            if (this.huy != null && this.huy.get() != null) {
                this.huy.get().hsI.setVisibility(8);
            }
            if (this.huz != null && this.huz.get() != null && this.huA != null && this.huA.get() != null) {
                this.huz.get().a(str2, this.huA.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void vR(String str) {
            if (this.huy != null && this.huy.get() != null) {
                this.huy.get().hsI.setVisibility(8);
            }
            if (this.huz != null && this.huz.get() != null) {
                l.showToast(this.huz.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bGw() {
            if (this.huy != null && this.huy.get() != null) {
                this.huy.get().hsI.setVisibility(8);
            }
        }
    }
}
