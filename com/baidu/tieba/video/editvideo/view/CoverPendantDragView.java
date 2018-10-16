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
    private float gHu;
    private float gcD;
    private FrameLayout htM;
    private RotateFrameLayout htN;
    private TextView htO;
    private EditText htP;
    private ImageView htQ;
    private ImageView htR;
    private int htS;
    private float htT;
    private boolean htU;
    private float htV;
    private float htW;
    private int htX;
    private int htY;
    private float htZ;
    private float hua;
    private float hub;
    private float huc;
    private b hud;
    private float hue;
    private float huf;
    private float hug;
    private float huh;
    private boolean hui;
    private float huj;
    private int huk;
    private int hul;
    private int hum;
    private int hun;
    private int huo;
    private float hup;
    private float huq;
    private int hur;
    private float hus;
    private int hut;
    private Map<String, Bitmap> huu;
    private Bitmap huv;
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
        this.htS = 0;
        this.huc = 1.0f;
        this.gHu = 1.0f;
        this.hui = true;
        this.huu = new HashMap();
        this.startTime = 0L;
        this.dDH = 0.0f;
        this.dDI = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.huj = l.h(getContext(), e.C0175e.fontsize40);
        this.hur = l.h(getContext(), e.C0175e.ds2);
        this.djD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.htM = (FrameLayout) LayoutInflater.from(getContext()).inflate(e.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.htM);
        this.htM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.htS == 4) {
                            CoverPendantDragView.this.bHr();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bqT);
                        if (!CoverPendantDragView.this.htU && abs < CoverPendantDragView.this.djD && abs2 < CoverPendantDragView.this.djD && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bHs();
                        }
                        CoverPendantDragView.this.htV = 0.0f;
                        CoverPendantDragView.this.htW = 0.0f;
                        CoverPendantDragView.this.htU = false;
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
                        CoverPendantDragView.this.htV = 0.0f;
                        CoverPendantDragView.this.htW = 0.0f;
                        return true;
                }
            }
        });
        this.htQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.htP.setText("");
                CoverPendantDragView.this.brC();
            }
        });
        this.htR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.htW = 0.0f;
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
        this.htP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.htS != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.htO.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), e.j.cover_text_length_max_tips);
                    }
                } else if (y.iu(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.htO.getText().length()) {
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
                CoverPendantDragView.this.htO.setText(editable.toString());
            }
        });
        this.htP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.htM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bqT = motionEvent.getRawY();
        this.htT = this.mDownX;
        this.gcD = this.bqT;
        this.htZ = (this.htM.getWidth() / 2) + this.htM.getX();
        this.hua = (this.htM.getHeight() / 2) + this.htM.getY();
        this.htO.setText(this.htP.getText());
        this.htO.setVisibility(0);
        this.htP.setVisibility(8);
        setEditTextEnable(false);
        this.hud.HidenSoftKeyPad(this.htP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(String str) {
        TextPaint paint = this.htP.getPaint();
        float measureText = paint.measureText(str);
        while (this.htP.getLineCount() == 1 && this.htP.getTextSize() < this.huj * this.gHu && measureText < this.huq * this.gHu) {
            setTextSize(0, this.htP.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (y.iu(str) <= y.iu(getResources().getString(e.j.cover_hint)) && this.htP.getTextSize() != this.huj * this.gHu) {
            setTextSize(0, this.huj * this.gHu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc(String str) {
        TextPaint paint = this.htP.getPaint();
        float measureText = paint.measureText(str);
        while (this.htP.getTextSize() > ((this.hup * this.gHu) / 2.0f) - (this.hus * this.gHu) && measureText > this.huq * this.gHu) {
            setTextSize(0, this.htP.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.htP.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.htP.getTextSize() - 1.0f);
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
        this.hud = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.hue = f;
        this.huf = f2;
        this.hug = f3;
        this.huh = f4;
        if (this.hue > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hue, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.huf > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.huf);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hug > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hug) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.huh > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.huh) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float J = J(motionEvent);
        float abs = Math.abs(this.htT - rawX);
        float abs2 = Math.abs(this.gcD - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.htZ - rawX);
        float abs4 = Math.abs(this.hua - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.htZ - this.htT);
        float abs6 = Math.abs(this.hua - this.gcD);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bT(sqrt, (int) (sqrt / this.hub));
        if (this.htW != 0.0f) {
            this.htM.setRotation(this.htM.getRotation() - (this.htW - J));
        }
        this.htW = J;
        this.htT = rawX;
        this.gcD = rawY;
    }

    private void bT(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htM.getLayoutParams();
        int width = this.htM.getWidth() - i;
        int i3 = (int) (width / this.hub);
        if (width < this.htX) {
            width = this.htX;
            i3 = (int) (width / this.hub);
        }
        this.gHu = ((width * 1.0f) - (this.huo * 2)) / (this.hut - (this.huo * 2));
        this.mContentView.setPadding((int) (this.huk * this.gHu), (int) (this.hul * this.gHu), (int) (this.hum * this.gHu), (int) (this.hun * this.gHu));
        setTextSize(0, (this.htP.getTextSize() * i3) / this.htM.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.htM.setLayoutParams(layoutParams);
        float f = this.htZ - (layoutParams.width / 2);
        float f2 = this.hua - (layoutParams.height / 2);
        this.htM.setX(f);
        this.htM.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.htS != 4) {
            float y = (this.htM.getY() + rawY) - this.gcD;
            if (y < this.huf) {
                y = this.huf;
            } else if (y > (this.huf + this.mVideoHeight) - this.htM.getHeight()) {
                y = (this.huf + this.mVideoHeight) - this.htM.getHeight();
            }
            this.htM.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.htU = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.htV != 0.0f) {
                    int i = (int) (this.htV - K);
                    bT(i, (int) (i / this.hub));
                }
                if (this.htW != 0.0f) {
                    this.htM.setRotation(this.htM.getRotation() - (this.htW - I));
                }
                this.htW = I;
                this.htV = K;
            } else if (!this.htU && pointerCount == 1) {
                float y2 = (this.htM.getY() + rawY) - this.gcD;
                if (y2 < this.huf - (this.htM.getHeight() / 2)) {
                    y2 = this.huf - (this.htM.getHeight() / 2);
                } else if (y2 > ((this.huf + this.mVideoHeight) - this.htM.getHeight()) + (this.htM.getHeight() / 2)) {
                    y2 = ((this.huf + this.mVideoHeight) - this.htM.getHeight()) + (this.htM.getHeight() / 2);
                }
                float x = (this.htM.getX() + rawX) - this.htT;
                if (x < this.hue - (this.htM.getWidth() / 2)) {
                    x = this.hue - (this.htM.getWidth() / 2);
                } else if (x > ((this.hue + this.mVideoWidth) - this.htM.getWidth()) + (this.htM.getWidth() / 2)) {
                    x = ((this.hue + this.mVideoWidth) - this.htM.getWidth()) + (this.htM.getWidth() / 2);
                }
                this.htM.setX(x);
                this.htM.setY(y2);
            }
        }
        this.htT = rawX;
        this.gcD = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.htP.getTextSize() != f) {
            this.htP.setTextSize(i, f);
        }
        if (this.htO.getTextSize() != f) {
            this.htO.setTextSize(i, f);
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
        matrix.postRotate(this.htM.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hua - motionEvent.getRawY(), this.htZ - motionEvent.getRawX()));
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
        this.htN = (RotateFrameLayout) this.htM.findViewById(e.g.content_container);
        this.htO = (TextView) this.htM.findViewById(e.g.cover_text);
        this.mContentView = (FrameLayout) this.htM.findViewById(e.g.content_view);
        this.htP = (EditText) this.htM.findViewById(e.g.cover_edit);
        this.htQ = (ImageView) this.htM.findViewById(e.g.cover_delete);
        this.htR = (ImageView) this.htM.findViewById(e.g.cover_scale);
    }

    public void brC() {
        this.htO.setText(this.htP.getText());
        this.htO.setVisibility(0);
        this.htP.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.htO.getText())) {
            this.htS = 0;
            this.htM.setVisibility(8);
        }
        if (this.htS == 4) {
            bHq();
        }
        this.hud.HidenSoftKeyPad(this.htP);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.htP.setFocusable(true);
            this.htP.setFocusableInTouchMode(true);
            this.htP.requestFocus();
            return;
        }
        this.htP.setFocusable(false);
        this.htP.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.htP.setText("");
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
                            bVar.hsH.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bHl().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(wa, pendantData);
                        break;
                    }
                    break;
            }
            this.htS = pendantData.pendantType;
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
        if (this.htS == 4 || this.htS == 0) {
            this.htM.setX(this.hue);
            this.htM.setY(((this.mVideoHeight - l.h(getContext(), e.C0175e.ds100)) / 2) + this.huf);
            String obj = this.htP.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.htP.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.htO.setText(a2);
                    this.htP.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bHq() {
        if (this.hui) {
            this.hui = false;
            this.htQ.setVisibility(8);
            this.htR.setVisibility(8);
            this.htN.setBackgroundColor(getResources().getColor(e.d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (!this.hui) {
            this.hui = true;
            this.htQ.setVisibility(0);
            this.htR.setVisibility(0);
            this.htN.setBackgroundResource(e.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.huu != null) {
            Bitmap bitmap = this.huu.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.huu.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bHq();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.huc = 1.0f;
                this.gHu = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.huc = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.htX = (this.huo * 2) + width;
                this.htY = (this.huo * 2) + height;
                this.hub = (this.htX * 1.0f) / this.htY;
                this.htM.setX((((this.mVideoWidth - i2) - (this.huo * 2)) / 2) + this.hue);
                this.htM.setY((((this.mVideoHeight - i) - (this.huo * 2)) / 2) + this.huf);
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
        if (this.htO == null || this.htO.getText() == null) {
            return null;
        }
        return this.htO.getText().toString();
    }

    public void bHs() {
        this.htO.setText(this.htP.getText());
        this.htO.setVisibility(8);
        this.htP.setVisibility(0);
        setEditTextEnable(true);
        this.hud.ShowSoftKeyPad(this.htP);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.htP.setTextAppearance(getContext(), e.k.cover_text_style);
            this.htO.setTextAppearance(getContext(), e.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), e.C0175e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), e.C0175e.fontsize40) * i) / i3);
            this.huo = 0;
            this.htP.setMaxLines(1);
            this.htO.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htO.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.htP.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), e.C0175e.ds60), 0, l.h(getContext(), e.C0175e.ds60), 0);
        } else {
            this.htP.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.htO.setTextAppearance(getContext(), e.k.cover_pendant_style);
            this.huo = l.h(getContext(), e.C0175e.ds40);
            this.htP.setMaxLines(2);
            this.htO.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.htO.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.htP.setLayoutParams(layoutParams2);
            this.huk = (int) (l.dip2px(getContext(), pendantData.left) * this.huc);
            this.hul = (int) (l.dip2px(getContext(), pendantData.top) * this.huc);
            this.hum = (int) (l.dip2px(getContext(), pendantData.right) * this.huc);
            this.hun = (int) (l.dip2px(getContext(), pendantData.bottom) * this.huc);
            this.mContentView.setPadding(this.huk, this.hul, this.hum, this.hun);
            this.huj = l.h(getContext(), e.C0175e.fontsize40) * this.huc;
            String text = getText();
            this.hup = (i2 - this.hul) - this.hun;
            this.huq = (i - this.huk) - this.hum;
            this.hus = this.hur + l.h(getContext(), e.C0175e.ds6);
            setTextSize(0, this.huj);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(e.j.cover_hint), this.huq);
                this.huj = this.htP.getTextSize();
                bHr();
                bHs();
            } else {
                if (y.iu(text) > 20) {
                    text = y.H(text, 20);
                    this.htP.setText(text);
                    this.htO.setText(text);
                }
                wc(text);
            }
        }
        this.htO.setIncludeFontPadding(false);
        this.htP.setIncludeFontPadding(false);
        this.htO.setLineSpacing(this.hur, 1.0f);
        this.htP.setLineSpacing(this.hur, 1.0f);
        this.htM.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.htM.getLayoutParams();
        layoutParams3.height = (this.huo * 2) + i2;
        layoutParams3.width = (this.huo * 2) + i;
        this.htM.setLayoutParams(layoutParams3);
        this.hut = (this.huo * 2) + i;
        ((FrameLayout.LayoutParams) this.htN.getLayoutParams()).setMargins(this.huo, this.huo, this.huo, this.huo);
        this.htM.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.huv == null) {
            bHt();
        }
        return this.huv;
    }

    private void bHt() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.huv = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bHu() {
        if (this.huv != null && !this.huv.isRecycled()) {
            this.huv.recycle();
            this.huv = null;
        }
    }

    public void nH(boolean z) {
        if (this.htS != 0) {
            if (z) {
                bHu();
                this.htM.setVisibility(0);
                return;
            }
            brC();
            getTempBitmap();
            this.htM.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.huu.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.huu.clear();
        this.huu = null;
        bHu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> hux;
        WeakReference<CoverPendantDragView> huy;
        WeakReference<PendantData> huz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hux = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.huy = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.huz = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cM(String str, String str2) {
            if (this.hux != null && this.hux.get() != null) {
                this.hux.get().hsH.setVisibility(8);
            }
            if (this.huy != null && this.huy.get() != null && this.huz != null && this.huz.get() != null) {
                this.huy.get().a(str2, this.huz.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void vR(String str) {
            if (this.hux != null && this.hux.get() != null) {
                this.hux.get().hsH.setVisibility(8);
            }
            if (this.huy != null && this.huy.get() != null) {
                l.showToast(this.huy.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bGw() {
            if (this.hux != null && this.hux.get() != null) {
                this.hux.get().hsH.setVisibility(8);
            }
        }
    }
}
