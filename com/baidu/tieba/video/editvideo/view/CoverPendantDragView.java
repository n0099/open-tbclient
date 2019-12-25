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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Bi;
    private float awM;
    float gmM;
    float gmN;
    private float jFQ;
    private FrameLayout ksV;
    private RotateFrameLayout ksW;
    private TextView ksX;
    private EditText ksY;
    private ImageView ksZ;
    private int ktA;
    private Map<String, Bitmap> ktB;
    private Bitmap ktC;
    private ImageView kta;
    private int ktb;
    private boolean ktc;
    private float ktd;
    private float kte;
    private int ktf;
    private int ktg;
    private float kth;
    private float kti;
    private float ktj;
    private float ktk;
    private b ktl;
    private float ktm;
    private float ktn;
    private float kto;
    private float ktp;
    private boolean ktq;
    private int ktr;
    private int kts;
    private int ktt;
    private int ktu;
    private int ktv;
    private float ktw;
    private float ktx;
    private int kty;
    private float ktz;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private float mLastX;
    private int mScreenWidth;
    private float mTouchSlop;
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
        this.ktb = 0;
        this.ktk = 1.0f;
        this.jFQ = 1.0f;
        this.ktq = true;
        this.ktB = new HashMap();
        this.startTime = 0L;
        this.gmM = 0.0f;
        this.gmN = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.awM = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kty = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ksV = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.ksV);
        this.ksV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.ktb == 4) {
                            CoverPendantDragView.this.cNF();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.ktc && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.vB();
                        }
                        CoverPendantDragView.this.ktd = 0.0f;
                        CoverPendantDragView.this.kte = 0.0f;
                        CoverPendantDragView.this.ktc = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.isTouchSlop(motionEvent)) {
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
                        CoverPendantDragView.this.ktd = 0.0f;
                        CoverPendantDragView.this.kte = 0.0f;
                        return true;
                }
            }
        });
        this.ksZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.ksY.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kta.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kte = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.isTouchSlop(motionEvent)) {
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
        this.ksY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.ktb != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.ksX.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.ksX.getText().length()) {
                        CoverPendantDragView.this.JG(obj);
                    } else {
                        CoverPendantDragView.this.JF(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.JG(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.ksX.setText(editable.toString());
            }
        });
        this.ksY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.ksV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.Bi = this.mDownY;
        this.kth = (this.ksV.getWidth() / 2) + this.ksV.getX();
        this.kti = (this.ksV.getHeight() / 2) + this.ksV.getY();
        this.ksX.setText(this.ksY.getText());
        this.ksX.setVisibility(0);
        this.ksY.setVisibility(8);
        setEditTextEnable(false);
        this.ktl.HidenSoftKeyPad(this.ksY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF(String str) {
        TextPaint paint = this.ksY.getPaint();
        float measureText = paint.measureText(str);
        while (this.ksY.getLineCount() == 1 && this.ksY.getTextSize() < this.awM * this.jFQ && measureText < this.ktx * this.jFQ) {
            setTextSize(0, this.ksY.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.ksY.getTextSize() != this.awM * this.jFQ) {
            setTextSize(0, this.awM * this.jFQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG(String str) {
        TextPaint paint = this.ksY.getPaint();
        float measureText = paint.measureText(str);
        while (this.ksY.getTextSize() > ((this.ktw * this.jFQ) / 2.0f) - (this.ktz * this.jFQ) && measureText > this.ktx * this.jFQ) {
            setTextSize(0, this.ksY.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.ksY.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.ksY.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ad.subStringWithEmoji(str, ad.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.ktl = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.ktm = f;
        this.ktn = f2;
        this.kto = f3;
        this.ktp = f4;
        if (this.ktm > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.ktm, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.ktn > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.ktn);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kto > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kto) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.ktp > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.ktp) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.Bi - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.kth - rawX);
        float abs4 = Math.abs(this.kti - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kth - this.mLastX);
        float abs6 = Math.abs(this.kti - this.Bi);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cN(sqrt, (int) (sqrt / this.ktj));
        if (this.kte != 0.0f) {
            this.ksV.setRotation(this.ksV.getRotation() - (this.kte - I));
        }
        this.kte = I;
        this.mLastX = rawX;
        this.Bi = rawY;
    }

    private void cN(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ksV.getLayoutParams();
        int width = this.ksV.getWidth() - i;
        int i3 = (int) (width / this.ktj);
        if (width < this.ktf) {
            width = this.ktf;
            i3 = (int) (width / this.ktj);
        }
        this.jFQ = ((width * 1.0f) - (this.ktv * 2)) / (this.ktA - (this.ktv * 2));
        this.mContentView.setPadding((int) (this.ktr * this.jFQ), (int) (this.kts * this.jFQ), (int) (this.ktt * this.jFQ), (int) (this.ktu * this.jFQ));
        setTextSize(0, (this.ksY.getTextSize() * i3) / this.ksV.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.ksV.setLayoutParams(layoutParams);
        float f = this.kth - (layoutParams.width / 2);
        float f2 = this.kti - (layoutParams.height / 2);
        this.ksV.setX(f);
        this.ksV.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.ktb != 4) {
            float y = (this.ksV.getY() + rawY) - this.Bi;
            if (y < this.ktn) {
                y = this.ktn;
            } else if (y > (this.ktn + this.mVideoHeight) - this.ksV.getHeight()) {
                y = (this.ktn + this.mVideoHeight) - this.ksV.getHeight();
            }
            this.ksV.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.ktc = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.ktd != 0.0f) {
                    int i = (int) (this.ktd - J);
                    cN(i, (int) (i / this.ktj));
                }
                if (this.kte != 0.0f) {
                    this.ksV.setRotation(this.ksV.getRotation() - (this.kte - H));
                }
                this.kte = H;
                this.ktd = J;
            } else if (!this.ktc && pointerCount == 1) {
                float y2 = (this.ksV.getY() + rawY) - this.Bi;
                if (y2 < this.ktn - (this.ksV.getHeight() / 2)) {
                    y2 = this.ktn - (this.ksV.getHeight() / 2);
                } else if (y2 > ((this.ktn + this.mVideoHeight) - this.ksV.getHeight()) + (this.ksV.getHeight() / 2)) {
                    y2 = ((this.ktn + this.mVideoHeight) - this.ksV.getHeight()) + (this.ksV.getHeight() / 2);
                }
                float x = (this.ksV.getX() + rawX) - this.mLastX;
                if (x < this.ktm - (this.ksV.getWidth() / 2)) {
                    x = this.ktm - (this.ksV.getWidth() / 2);
                } else if (x > ((this.ktm + this.mVideoWidth) - this.ksV.getWidth()) + (this.ksV.getWidth() / 2)) {
                    x = ((this.ktm + this.mVideoWidth) - this.ksV.getWidth()) + (this.ksV.getWidth() / 2);
                }
                this.ksV.setX(x);
                this.ksV.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.Bi = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.ksY.getTextSize() != f) {
            this.ksY.setTextSize(i, f);
        }
        if (this.ksX.getTextSize() != f) {
            this.ksX.setTextSize(i, f);
        }
    }

    private float H(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.ksV.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kti - motionEvent.getRawY(), this.kth - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchSlop(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.mTouchSlop && Math.abs(motionEvent.getRawY() - this.mDownY) < this.mTouchSlop;
    }

    private void init() {
        this.ksW = (RotateFrameLayout) this.ksV.findViewById(R.id.content_container);
        this.ksX = (TextView) this.ksV.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.ksV.findViewById(R.id.content_view);
        this.ksY = (EditText) this.ksV.findViewById(R.id.cover_edit);
        this.ksZ = (ImageView) this.ksV.findViewById(R.id.cover_delete);
        this.kta = (ImageView) this.ksV.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.ksX.setText(this.ksY.getText());
        this.ksX.setVisibility(0);
        this.ksY.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.ksX.getText())) {
            this.ktb = 0;
            this.ksV.setVisibility(8);
        }
        if (this.ktb == 4) {
            cNE();
        }
        this.ktl.HidenSoftKeyPad(this.ksY);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.ksY.setFocusable(true);
            this.ksY.setFocusableInTouchMode(true);
            this.ksY.requestFocus();
            return;
        }
        this.ksY.setFocusable(false);
        this.ksY.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.ksY.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    vB();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    vB();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    vB();
                    break;
                default:
                    hideSoftKeyPad();
                    String JE = com.baidu.tieba.video.editvideo.model.b.cNz().JE(pendantData.resource);
                    if (TextUtils.isEmpty(JE)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.krU.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cNz().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(JE, pendantData);
                        break;
                    }
                    break;
            }
            this.ktb = pendantData.pendantType;
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
        cNE();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.ktb == 4 || this.ktb == 0) {
            this.ksV.setX(this.ktm);
            this.ksV.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.ktn);
            String obj = this.ksY.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.ksY.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.ksX.setText(a2);
                    this.ksY.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cNE() {
        if (this.ktq) {
            this.ktq = false;
            this.ksZ.setVisibility(8);
            this.kta.setVisibility(8);
            this.ksW.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNF() {
        if (!this.ktq) {
            this.ktq = true;
            this.ksZ.setVisibility(0);
            this.kta.setVisibility(0);
            this.ksW.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.ktB != null) {
            Bitmap bitmap = this.ktB.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.ktB.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cNE();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.ktk = 1.0f;
                this.jFQ = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.ktk = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.ktf = (this.ktv * 2) + width;
                this.ktg = (this.ktv * 2) + height;
                this.ktj = (this.ktf * 1.0f) / this.ktg;
                this.ksV.setX((((this.mVideoWidth - i2) - (this.ktv * 2)) / 2) + this.ktm);
                this.ksV.setY((((this.mVideoHeight - i) - (this.ktv * 2)) / 2) + this.ktn);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gmM = motionEvent.getRawX();
                this.gmN = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gmM);
                float abs2 = Math.abs(rawY - this.gmN);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.ksX == null || this.ksX.getText() == null) {
            return null;
        }
        return this.ksX.getText().toString();
    }

    public void vB() {
        this.ksX.setText(this.ksY.getText());
        this.ksX.setVisibility(8);
        this.ksY.setVisibility(0);
        setEditTextEnable(true);
        this.ktl.ShowSoftKeyPad(this.ksY);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.ksY.setTextAppearance(getContext(), R.style.cover_text_style);
            this.ksX.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.ktv = 0;
            this.ksY.setMaxLines(1);
            this.ksX.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ksX.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.ksY.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.ksY.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.ksX.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.ktv = l.getDimens(getContext(), R.dimen.ds40);
            this.ksY.setMaxLines(2);
            this.ksX.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ksX.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.ksY.setLayoutParams(layoutParams2);
            this.ktr = (int) (l.dip2px(getContext(), pendantData.left) * this.ktk);
            this.kts = (int) (l.dip2px(getContext(), pendantData.top) * this.ktk);
            this.ktt = (int) (l.dip2px(getContext(), pendantData.right) * this.ktk);
            this.ktu = (int) (l.dip2px(getContext(), pendantData.bottom) * this.ktk);
            this.mContentView.setPadding(this.ktr, this.kts, this.ktt, this.ktu);
            this.awM = l.getDimens(getContext(), R.dimen.fontsize40) * this.ktk;
            String text = getText();
            this.ktw = (i2 - this.kts) - this.ktu;
            this.ktx = (i - this.ktr) - this.ktt;
            this.ktz = this.kty + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.awM);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.ktx);
                this.awM = this.ksY.getTextSize();
                cNF();
                vB();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.ksY.setText(text);
                    this.ksX.setText(text);
                }
                JG(text);
            }
        }
        this.ksX.setIncludeFontPadding(false);
        this.ksY.setIncludeFontPadding(false);
        this.ksX.setLineSpacing(this.kty, 1.0f);
        this.ksY.setLineSpacing(this.kty, 1.0f);
        this.ksV.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ksV.getLayoutParams();
        layoutParams3.height = (this.ktv * 2) + i2;
        layoutParams3.width = (this.ktv * 2) + i;
        this.ksV.setLayoutParams(layoutParams3);
        this.ktA = (this.ktv * 2) + i;
        ((FrameLayout.LayoutParams) this.ksW.getLayoutParams()).setMargins(this.ktv, this.ktv, this.ktv, this.ktv);
        this.ksV.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.ktC == null) {
            cNG();
        }
        return this.ktC;
    }

    private void cNG() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.ktC = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cNH() {
        if (this.ktC != null && !this.ktC.isRecycled()) {
            this.ktC.recycle();
            this.ktC = null;
        }
    }

    public void sY(boolean z) {
        if (this.ktb != 0) {
            if (z) {
                cNH();
                this.ksV.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.ksV.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.ktB.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.ktB.clear();
        this.ktB = null;
        cNH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements b.a {
        WeakReference<a.b> ktE;
        WeakReference<CoverPendantDragView> ktF;
        WeakReference<PendantData> ktG;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.ktE = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.ktF = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.ktG = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ey(String str, String str2) {
            if (this.ktE != null && this.ktE.get() != null) {
                this.ktE.get().krU.setVisibility(8);
            }
            if (this.ktF != null && this.ktF.get() != null && this.ktG != null && this.ktG.get() != null) {
                this.ktF.get().a(str2, this.ktG.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Jw(String str) {
            if (this.ktE != null && this.ktE.get() != null) {
                this.ktE.get().krU.setVisibility(8);
            }
            if (this.ktF != null && this.ktF.get() != null) {
                l.showToast(this.ktF.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cMM() {
            if (this.ktE != null && this.ktE.get() != null) {
                this.ktE.get().krU.setVisibility(8);
            }
        }
    }
}
