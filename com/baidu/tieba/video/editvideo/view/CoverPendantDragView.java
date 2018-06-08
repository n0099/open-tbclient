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
    private float cUP;
    private float ccd;
    private float gZA;
    private float gZB;
    private float gZC;
    private b gZD;
    private float gZE;
    private float gZF;
    private float gZG;
    private float gZH;
    private boolean gZI;
    private float gZJ;
    private int gZK;
    private int gZL;
    private int gZM;
    private int gZN;
    private int gZO;
    private float gZP;
    private float gZQ;
    private int gZR;
    private float gZS;
    private int gZT;
    private Map<String, Bitmap> gZU;
    float gZV;
    float gZW;
    private FrameLayout gZn;
    private RotateFrameLayout gZo;
    private TextView gZp;
    private EditText gZq;
    private ImageView gZr;
    private ImageView gZs;
    private int gZt;
    private boolean gZu;
    private float gZv;
    private float gZw;
    private int gZx;
    private int gZy;
    private float gZz;
    private float gnu;
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
        this.gZt = 0;
        this.gZC = 1.0f;
        this.gnu = 1.0f;
        this.gZI = true;
        this.gZU = new HashMap();
        this.startTime = 0L;
        this.gZV = 0.0f;
        this.gZW = 0.0f;
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
        this.gZJ = l.e(getContext(), d.e.fontsize40);
        this.gZR = l.e(getContext(), d.e.ds2);
        this.cUP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gZn = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.i.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.gZn);
        this.gZn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.e(view, motionEvent);
                        if (CoverPendantDragView.this.gZt == 4) {
                            CoverPendantDragView.this.bCb();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.ccd);
                        if (!CoverPendantDragView.this.gZu && abs < CoverPendantDragView.this.cUP && abs2 < CoverPendantDragView.this.cUP && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bCc();
                        }
                        CoverPendantDragView.this.gZv = 0.0f;
                        CoverPendantDragView.this.gZw = 0.0f;
                        CoverPendantDragView.this.gZu = false;
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
                        CoverPendantDragView.this.gZv = 0.0f;
                        CoverPendantDragView.this.gZw = 0.0f;
                        return true;
                }
            }
        });
        this.gZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.gZq.setText("");
                CoverPendantDragView.this.bmN();
            }
        });
        this.gZs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.e(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.gZw = 0.0f;
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
        this.gZq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.gZt != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.gZp.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_text_length_max_tips);
                    }
                } else if (x.hI(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.gZp.getText().length()) {
                        CoverPendantDragView.this.uU(obj);
                    } else {
                        CoverPendantDragView.this.uT(obj);
                    }
                } else {
                    String F = x.F(obj, 20);
                    editable.delete(F.length(), obj.length());
                    CoverPendantDragView.this.uU(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.k.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.gZp.setText(editable.toString());
            }
        });
        this.gZq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.gZn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.ccd = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.ccd;
        this.gZz = (this.gZn.getWidth() / 2) + this.gZn.getX();
        this.gZA = (this.gZn.getHeight() / 2) + this.gZn.getY();
        this.gZp.setText(this.gZq.getText());
        this.gZp.setVisibility(0);
        this.gZq.setVisibility(8);
        setEditTextEnable(false);
        this.gZD.HidenSoftKeyPad(this.gZq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(String str) {
        TextPaint paint = this.gZq.getPaint();
        float measureText = paint.measureText(str);
        while (this.gZq.getLineCount() == 1 && this.gZq.getTextSize() < this.gZJ * this.gnu && measureText < this.gZQ * this.gnu) {
            setTextSize(0, this.gZq.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (x.hI(str) <= x.hI(getResources().getString(d.k.cover_hint)) && this.gZq.getTextSize() != this.gZJ * this.gnu) {
            setTextSize(0, this.gZJ * this.gnu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(String str) {
        TextPaint paint = this.gZq.getPaint();
        float measureText = paint.measureText(str);
        while (this.gZq.getTextSize() > ((this.gZP * this.gnu) / 2.0f) - (this.gZS * this.gnu) && measureText > this.gZQ * this.gnu) {
            setTextSize(0, this.gZq.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.gZq.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.gZq.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.e(getContext(), d.e.ds120)) {
            str = x.I(str, x.hH(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.gZD = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.gZE = f;
        this.gZF = f2;
        this.gZG = f3;
        this.gZH = f4;
        if (this.gZE > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.gZE, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.gZF > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.gZF);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.gZG > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.gZG) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.gZH > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.gZH) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.gZz - rawX);
        float abs4 = Math.abs(this.gZA - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.gZz - this.mLastX);
        float abs6 = Math.abs(this.gZA - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        bP(sqrt, (int) (sqrt / this.gZB));
        if (this.gZw != 0.0f) {
            this.gZn.setRotation(this.gZn.getRotation() - (this.gZw - J));
        }
        this.gZw = J;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void bP(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gZn.getLayoutParams();
        int width = this.gZn.getWidth() - i;
        int i3 = (int) (width / this.gZB);
        if (width < this.gZx) {
            width = this.gZx;
            i3 = (int) (width / this.gZB);
        }
        this.gnu = ((width * 1.0f) - (this.gZO * 2)) / (this.gZT - (this.gZO * 2));
        this.mContentView.setPadding((int) (this.gZK * this.gnu), (int) (this.gZL * this.gnu), (int) (this.gZM * this.gnu), (int) (this.gZN * this.gnu));
        setTextSize(0, (this.gZq.getTextSize() * i3) / this.gZn.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.gZn.setLayoutParams(layoutParams);
        float f = this.gZz - (layoutParams.width / 2);
        float f2 = this.gZA - (layoutParams.height / 2);
        this.gZn.setX(f);
        this.gZn.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.gZt != 4) {
            float y = (this.gZn.getY() + rawY) - this.mLastY;
            if (y < this.gZF) {
                y = this.gZF;
            } else if (y > (this.gZF + this.mVideoHeight) - this.gZn.getHeight()) {
                y = (this.gZF + this.mVideoHeight) - this.gZn.getHeight();
            }
            this.gZn.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.gZu = true;
                float K = K(motionEvent);
                float I = I(motionEvent);
                if (this.gZv != 0.0f) {
                    int i = (int) (this.gZv - K);
                    bP(i, (int) (i / this.gZB));
                }
                if (this.gZw != 0.0f) {
                    this.gZn.setRotation(this.gZn.getRotation() - (this.gZw - I));
                }
                this.gZw = I;
                this.gZv = K;
            } else if (!this.gZu && pointerCount == 1) {
                float y2 = (this.gZn.getY() + rawY) - this.mLastY;
                if (y2 < this.gZF - (this.gZn.getHeight() / 2)) {
                    y2 = this.gZF - (this.gZn.getHeight() / 2);
                } else if (y2 > ((this.gZF + this.mVideoHeight) - this.gZn.getHeight()) + (this.gZn.getHeight() / 2)) {
                    y2 = ((this.gZF + this.mVideoHeight) - this.gZn.getHeight()) + (this.gZn.getHeight() / 2);
                }
                float x = (this.gZn.getX() + rawX) - this.mLastX;
                if (x < this.gZE - (this.gZn.getWidth() / 2)) {
                    x = this.gZE - (this.gZn.getWidth() / 2);
                } else if (x > ((this.gZE + this.mVideoWidth) - this.gZn.getWidth()) + (this.gZn.getWidth() / 2)) {
                    x = ((this.gZE + this.mVideoWidth) - this.gZn.getWidth()) + (this.gZn.getWidth() / 2);
                }
                this.gZn.setX(x);
                this.gZn.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.gZq.getTextSize() != f) {
            this.gZq.setTextSize(i, f);
        }
        if (this.gZp.getTextSize() != f) {
            this.gZp.setTextSize(i, f);
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
        matrix.postRotate(this.gZn.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float J(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.gZA - motionEvent.getRawY(), this.gZz - motionEvent.getRawX()));
    }

    private float K(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cUP && Math.abs(motionEvent.getRawY() - this.ccd) < this.cUP;
    }

    private void init() {
        this.gZo = (RotateFrameLayout) this.gZn.findViewById(d.g.content_container);
        this.gZp = (TextView) this.gZn.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.gZn.findViewById(d.g.content_view);
        this.gZq = (EditText) this.gZn.findViewById(d.g.cover_edit);
        this.gZr = (ImageView) this.gZn.findViewById(d.g.cover_delete);
        this.gZs = (ImageView) this.gZn.findViewById(d.g.cover_scale);
    }

    public void bmN() {
        this.gZp.setText(this.gZq.getText());
        this.gZp.setVisibility(0);
        this.gZq.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.gZp.getText())) {
            this.gZt = 0;
            this.gZn.setVisibility(8);
        }
        if (this.gZt == 4) {
            bCa();
        }
        this.gZD.HidenSoftKeyPad(this.gZq);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gZq.setFocusable(true);
            this.gZq.setFocusableInTouchMode(true);
            this.gZq.requestFocus();
            return;
        }
        this.gZq.setFocusable(false);
        this.gZq.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.gZq.setText("");
                    bmN();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bCc();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bCc();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bCc();
                    break;
                default:
                    bmN();
                    String uS = com.baidu.tieba.video.editvideo.model.b.bBV().uS(pendantData.resource);
                    if (TextUtils.isEmpty(uS)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.gYi.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBV().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(uS, pendantData);
                        break;
                    }
                    break;
            }
            this.gZt = pendantData.pendantType;
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
        bCa();
        a(this.mVideoWidth, l.e(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.gZt == 4 || this.gZt == 0) {
            this.gZn.setX(this.gZE);
            this.gZn.setY(((this.mVideoHeight - l.e(getContext(), d.e.ds100)) / 2) + this.gZF);
            String obj = this.gZq.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.gZq.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.gZp.setText(a2);
                    this.gZq.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bCa() {
        if (this.gZI) {
            this.gZI = false;
            this.gZr.setVisibility(8);
            this.gZs.setVisibility(8);
            this.gZo.setBackgroundColor(getResources().getColor(d.C0141d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCb() {
        if (!this.gZI) {
            this.gZI = true;
            this.gZr.setVisibility(0);
            this.gZs.setVisibility(0);
            this.gZo.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.gZU != null) {
            Bitmap bitmap = this.gZU.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.gZU.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bCa();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.gZC = 1.0f;
                this.gnu = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.gZC = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.gZx = (this.gZO * 2) + width;
                this.gZy = (this.gZO * 2) + height;
                this.gZB = (this.gZx * 1.0f) / this.gZy;
                this.gZn.setX((((this.mVideoWidth - i2) - (this.gZO * 2)) / 2) + this.gZE);
                this.gZn.setY((((this.mVideoHeight - i) - (this.gZO * 2)) / 2) + this.gZF);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gZV = motionEvent.getRawX();
                this.gZW = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gZV);
                float abs2 = Math.abs(rawY - this.gZW);
                if (motionEvent.getPointerCount() <= 1 && abs < this.cUP && abs2 < this.cUP && System.currentTimeMillis() - this.startTime < 300) {
                    bmN();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.gZp == null || this.gZp.getText() == null) {
            return null;
        }
        return this.gZp.getText().toString();
    }

    public void bCc() {
        this.gZp.setText(this.gZq.getText());
        this.gZp.setVisibility(8);
        this.gZq.setVisibility(0);
        setEditTextEnable(true);
        this.gZD.ShowSoftKeyPad(this.gZq);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.gZq.setTextAppearance(getContext(), d.l.cover_text_style);
            this.gZp.setTextAppearance(getContext(), d.l.cover_text_style);
            i2 = (int) ((l.e(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.e(getContext(), d.e.fontsize40) * i) / i3);
            this.gZO = 0;
            this.gZq.setMaxLines(1);
            this.gZp.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gZp.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.gZq.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.e(getContext(), d.e.ds60), 0, l.e(getContext(), d.e.ds60), 0);
        } else {
            this.gZq.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gZp.setTextAppearance(getContext(), d.l.cover_pendant_style);
            this.gZO = l.e(getContext(), d.e.ds40);
            this.gZq.setMaxLines(2);
            this.gZp.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gZp.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.gZq.setLayoutParams(layoutParams2);
            this.gZK = (int) (l.dip2px(getContext(), pendantData.left) * this.gZC);
            this.gZL = (int) (l.dip2px(getContext(), pendantData.top) * this.gZC);
            this.gZM = (int) (l.dip2px(getContext(), pendantData.right) * this.gZC);
            this.gZN = (int) (l.dip2px(getContext(), pendantData.bottom) * this.gZC);
            this.mContentView.setPadding(this.gZK, this.gZL, this.gZM, this.gZN);
            this.gZJ = l.e(getContext(), d.e.fontsize40) * this.gZC;
            String text = getText();
            this.gZP = (i2 - this.gZL) - this.gZN;
            this.gZQ = (i - this.gZK) - this.gZM;
            this.gZS = this.gZR + l.e(getContext(), d.e.ds6);
            setTextSize(0, this.gZJ);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.k.cover_hint), this.gZQ);
                this.gZJ = this.gZq.getTextSize();
                bCb();
                bCc();
            } else {
                if (x.hI(text) > 20) {
                    text = x.F(text, 20);
                    this.gZq.setText(text);
                    this.gZp.setText(text);
                }
                uU(text);
            }
        }
        this.gZp.setIncludeFontPadding(false);
        this.gZq.setIncludeFontPadding(false);
        this.gZp.setLineSpacing(this.gZR, 1.0f);
        this.gZq.setLineSpacing(this.gZR, 1.0f);
        this.gZn.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.gZn.getLayoutParams();
        layoutParams3.height = (this.gZO * 2) + i2;
        layoutParams3.width = (this.gZO * 2) + i;
        this.gZn.setLayoutParams(layoutParams3);
        this.gZT = (this.gZO * 2) + i;
        ((FrameLayout.LayoutParams) this.gZo.getLayoutParams()).setMargins(this.gZO, this.gZO, this.gZO, this.gZO);
        this.gZn.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bCd();
        }
        return this.mTempBitmap;
    }

    private void bCd() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bCe() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void mZ(boolean z) {
        if (this.gZt != 0) {
            if (z) {
                bCe();
                this.gZn.setVisibility(0);
                return;
            }
            bmN();
            getTempBitmap();
            this.gZn.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.gZU.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.gZU.clear();
        this.gZU = null;
        bCe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> gZY;
        WeakReference<CoverPendantDragView> gZZ;
        WeakReference<PendantData> haa;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.gZY = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.gZZ = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.haa = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cq(String str, String str2) {
            if (this.gZY != null && this.gZY.get() != null) {
                this.gZY.get().gYi.setVisibility(8);
            }
            if (this.gZZ != null && this.gZZ.get() != null && this.haa != null && this.haa.get() != null) {
                this.gZZ.get().a(str2, this.haa.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void uI(String str) {
            if (this.gZY != null && this.gZY.get() != null) {
                this.gZY.get().gYi.setVisibility(8);
            }
            if (this.gZZ != null && this.gZZ.get() != null) {
                l.showToast(this.gZZ.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bBg() {
            if (this.gZY != null && this.gZY.get() != null) {
                this.gZY.get().gYi.setVisibility(8);
            }
        }
    }
}
