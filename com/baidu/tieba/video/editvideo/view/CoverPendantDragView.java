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
/* loaded from: classes10.dex */
public class CoverPendantDragView extends FrameLayout {
    private float BF;
    private float aBL;
    float grW;
    float grX;
    private float jKt;
    private TextView kxA;
    private EditText kxB;
    private ImageView kxC;
    private ImageView kxD;
    private int kxE;
    private boolean kxF;
    private float kxG;
    private float kxH;
    private int kxI;
    private int kxJ;
    private float kxK;
    private float kxL;
    private float kxM;
    private float kxN;
    private b kxO;
    private float kxP;
    private float kxQ;
    private float kxR;
    private float kxS;
    private boolean kxT;
    private int kxU;
    private int kxV;
    private int kxW;
    private int kxX;
    private int kxY;
    private float kxZ;
    private FrameLayout kxy;
    private RotateFrameLayout kxz;
    private float kya;
    private int kyb;
    private float kyc;
    private int kyd;
    private Map<String, Bitmap> kye;
    private Bitmap kyf;
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
        this.kxE = 0;
        this.kxN = 1.0f;
        this.jKt = 1.0f;
        this.kxT = true;
        this.kye = new HashMap();
        this.startTime = 0L;
        this.grW = 0.0f;
        this.grX = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aBL = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kyb = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kxy = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kxy);
        this.kxy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kxE == 4) {
                            CoverPendantDragView.this.cQf();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kxF && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.xR();
                        }
                        CoverPendantDragView.this.kxG = 0.0f;
                        CoverPendantDragView.this.kxH = 0.0f;
                        CoverPendantDragView.this.kxF = false;
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
                        CoverPendantDragView.this.kxG = 0.0f;
                        CoverPendantDragView.this.kxH = 0.0f;
                        return true;
                }
            }
        });
        this.kxC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kxB.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kxD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kxH = 0.0f;
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
        this.kxB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kxE != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kxA.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kxA.getText().length()) {
                        CoverPendantDragView.this.Kd(obj);
                    } else {
                        CoverPendantDragView.this.Kc(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Kd(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.kxA.setText(editable.toString());
            }
        });
        this.kxB.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kxy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.BF = this.mDownY;
        this.kxK = (this.kxy.getWidth() / 2) + this.kxy.getX();
        this.kxL = (this.kxy.getHeight() / 2) + this.kxy.getY();
        this.kxA.setText(this.kxB.getText());
        this.kxA.setVisibility(0);
        this.kxB.setVisibility(8);
        setEditTextEnable(false);
        this.kxO.HidenSoftKeyPad(this.kxB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc(String str) {
        TextPaint paint = this.kxB.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxB.getLineCount() == 1 && this.kxB.getTextSize() < this.aBL * this.jKt && measureText < this.kya * this.jKt) {
            setTextSize(0, this.kxB.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kxB.getTextSize() != this.aBL * this.jKt) {
            setTextSize(0, this.aBL * this.jKt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd(String str) {
        TextPaint paint = this.kxB.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxB.getTextSize() > ((this.kxZ * this.jKt) / 2.0f) - (this.kyc * this.jKt) && measureText > this.kya * this.jKt) {
            setTextSize(0, this.kxB.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kxB.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kxB.getTextSize() - 1.0f);
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
        this.kxO = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kxP = f;
        this.kxQ = f2;
        this.kxR = f3;
        this.kxS = f4;
        if (this.kxP > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kxP, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kxQ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kxQ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kxR > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kxR) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kxS > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kxS) - this.mVideoHeight);
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
        float abs2 = Math.abs(this.BF - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.kxK - rawX);
        float abs4 = Math.abs(this.kxL - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kxK - this.mLastX);
        float abs6 = Math.abs(this.kxL - this.BF);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cP(sqrt, (int) (sqrt / this.kxM));
        if (this.kxH != 0.0f) {
            this.kxy.setRotation(this.kxy.getRotation() - (this.kxH - I));
        }
        this.kxH = I;
        this.mLastX = rawX;
        this.BF = rawY;
    }

    private void cP(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxy.getLayoutParams();
        int width = this.kxy.getWidth() - i;
        int i3 = (int) (width / this.kxM);
        if (width < this.kxI) {
            width = this.kxI;
            i3 = (int) (width / this.kxM);
        }
        this.jKt = ((width * 1.0f) - (this.kxY * 2)) / (this.kyd - (this.kxY * 2));
        this.mContentView.setPadding((int) (this.kxU * this.jKt), (int) (this.kxV * this.jKt), (int) (this.kxW * this.jKt), (int) (this.kxX * this.jKt));
        setTextSize(0, (this.kxB.getTextSize() * i3) / this.kxy.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kxy.setLayoutParams(layoutParams);
        float f = this.kxK - (layoutParams.width / 2);
        float f2 = this.kxL - (layoutParams.height / 2);
        this.kxy.setX(f);
        this.kxy.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kxE != 4) {
            float y = (this.kxy.getY() + rawY) - this.BF;
            if (y < this.kxQ) {
                y = this.kxQ;
            } else if (y > (this.kxQ + this.mVideoHeight) - this.kxy.getHeight()) {
                y = (this.kxQ + this.mVideoHeight) - this.kxy.getHeight();
            }
            this.kxy.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kxF = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kxG != 0.0f) {
                    int i = (int) (this.kxG - J);
                    cP(i, (int) (i / this.kxM));
                }
                if (this.kxH != 0.0f) {
                    this.kxy.setRotation(this.kxy.getRotation() - (this.kxH - H));
                }
                this.kxH = H;
                this.kxG = J;
            } else if (!this.kxF && pointerCount == 1) {
                float y2 = (this.kxy.getY() + rawY) - this.BF;
                if (y2 < this.kxQ - (this.kxy.getHeight() / 2)) {
                    y2 = this.kxQ - (this.kxy.getHeight() / 2);
                } else if (y2 > ((this.kxQ + this.mVideoHeight) - this.kxy.getHeight()) + (this.kxy.getHeight() / 2)) {
                    y2 = ((this.kxQ + this.mVideoHeight) - this.kxy.getHeight()) + (this.kxy.getHeight() / 2);
                }
                float x = (this.kxy.getX() + rawX) - this.mLastX;
                if (x < this.kxP - (this.kxy.getWidth() / 2)) {
                    x = this.kxP - (this.kxy.getWidth() / 2);
                } else if (x > ((this.kxP + this.mVideoWidth) - this.kxy.getWidth()) + (this.kxy.getWidth() / 2)) {
                    x = ((this.kxP + this.mVideoWidth) - this.kxy.getWidth()) + (this.kxy.getWidth() / 2);
                }
                this.kxy.setX(x);
                this.kxy.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.BF = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kxB.getTextSize() != f) {
            this.kxB.setTextSize(i, f);
        }
        if (this.kxA.getTextSize() != f) {
            this.kxA.setTextSize(i, f);
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
        matrix.postRotate(this.kxy.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kxL - motionEvent.getRawY(), this.kxK - motionEvent.getRawX()));
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
        this.kxz = (RotateFrameLayout) this.kxy.findViewById(R.id.content_container);
        this.kxA = (TextView) this.kxy.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kxy.findViewById(R.id.content_view);
        this.kxB = (EditText) this.kxy.findViewById(R.id.cover_edit);
        this.kxC = (ImageView) this.kxy.findViewById(R.id.cover_delete);
        this.kxD = (ImageView) this.kxy.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kxA.setText(this.kxB.getText());
        this.kxA.setVisibility(0);
        this.kxB.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kxA.getText())) {
            this.kxE = 0;
            this.kxy.setVisibility(8);
        }
        if (this.kxE == 4) {
            cQe();
        }
        this.kxO.HidenSoftKeyPad(this.kxB);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kxB.setFocusable(true);
            this.kxB.setFocusableInTouchMode(true);
            this.kxB.requestFocus();
            return;
        }
        this.kxB.setFocusable(false);
        this.kxB.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kxB.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    xR();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    xR();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    xR();
                    break;
                default:
                    hideSoftKeyPad();
                    String Kb = com.baidu.tieba.video.editvideo.model.b.cPZ().Kb(pendantData.resource);
                    if (TextUtils.isEmpty(Kb)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kwz.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cPZ().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Kb, pendantData);
                        break;
                    }
                    break;
            }
            this.kxE = pendantData.pendantType;
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
        cQe();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kxE == 4 || this.kxE == 0) {
            this.kxy.setX(this.kxP);
            this.kxy.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kxQ);
            String obj = this.kxB.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kxB.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kxA.setText(a2);
                    this.kxB.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cQe() {
        if (this.kxT) {
            this.kxT = false;
            this.kxC.setVisibility(8);
            this.kxD.setVisibility(8);
            this.kxz.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQf() {
        if (!this.kxT) {
            this.kxT = true;
            this.kxC.setVisibility(0);
            this.kxD.setVisibility(0);
            this.kxz.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kye != null) {
            Bitmap bitmap = this.kye.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kye.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cQe();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kxN = 1.0f;
                this.jKt = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kxN = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kxI = (this.kxY * 2) + width;
                this.kxJ = (this.kxY * 2) + height;
                this.kxM = (this.kxI * 1.0f) / this.kxJ;
                this.kxy.setX((((this.mVideoWidth - i2) - (this.kxY * 2)) / 2) + this.kxP);
                this.kxy.setY((((this.mVideoHeight - i) - (this.kxY * 2)) / 2) + this.kxQ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.grW = motionEvent.getRawX();
                this.grX = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.grW);
                float abs2 = Math.abs(rawY - this.grX);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kxA == null || this.kxA.getText() == null) {
            return null;
        }
        return this.kxA.getText().toString();
    }

    public void xR() {
        this.kxA.setText(this.kxB.getText());
        this.kxA.setVisibility(8);
        this.kxB.setVisibility(0);
        setEditTextEnable(true);
        this.kxO.ShowSoftKeyPad(this.kxB);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kxB.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kxA.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kxY = 0;
            this.kxB.setMaxLines(1);
            this.kxA.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxA.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kxB.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kxB.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kxA.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kxY = l.getDimens(getContext(), R.dimen.ds40);
            this.kxB.setMaxLines(2);
            this.kxA.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kxA.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kxB.setLayoutParams(layoutParams2);
            this.kxU = (int) (l.dip2px(getContext(), pendantData.left) * this.kxN);
            this.kxV = (int) (l.dip2px(getContext(), pendantData.f1028top) * this.kxN);
            this.kxW = (int) (l.dip2px(getContext(), pendantData.right) * this.kxN);
            this.kxX = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kxN);
            this.mContentView.setPadding(this.kxU, this.kxV, this.kxW, this.kxX);
            this.aBL = l.getDimens(getContext(), R.dimen.fontsize40) * this.kxN;
            String text = getText();
            this.kxZ = (i2 - this.kxV) - this.kxX;
            this.kya = (i - this.kxU) - this.kxW;
            this.kyc = this.kyb + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aBL);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kya);
                this.aBL = this.kxB.getTextSize();
                cQf();
                xR();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kxB.setText(text);
                    this.kxA.setText(text);
                }
                Kd(text);
            }
        }
        this.kxA.setIncludeFontPadding(false);
        this.kxB.setIncludeFontPadding(false);
        this.kxA.setLineSpacing(this.kyb, 1.0f);
        this.kxB.setLineSpacing(this.kyb, 1.0f);
        this.kxy.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kxy.getLayoutParams();
        layoutParams3.height = (this.kxY * 2) + i2;
        layoutParams3.width = (this.kxY * 2) + i;
        this.kxy.setLayoutParams(layoutParams3);
        this.kyd = (this.kxY * 2) + i;
        ((FrameLayout.LayoutParams) this.kxz.getLayoutParams()).setMargins(this.kxY, this.kxY, this.kxY, this.kxY);
        this.kxy.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kyf == null) {
            cQg();
        }
        return this.kyf;
    }

    private void cQg() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kyf = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cQh() {
        if (this.kyf != null && !this.kyf.isRecycled()) {
            this.kyf.recycle();
            this.kyf = null;
        }
    }

    public void to(boolean z) {
        if (this.kxE != 0) {
            if (z) {
                cQh();
                this.kxy.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kxy.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kye.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kye.clear();
        this.kye = null;
        cQh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> kyh;
        WeakReference<CoverPendantDragView> kyi;
        WeakReference<PendantData> kyj;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kyh = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kyi = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kyj = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eJ(String str, String str2) {
            if (this.kyh != null && this.kyh.get() != null) {
                this.kyh.get().kwz.setVisibility(8);
            }
            if (this.kyi != null && this.kyi.get() != null && this.kyj != null && this.kyj.get() != null) {
                this.kyi.get().a(str2, this.kyj.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JT(String str) {
            if (this.kyh != null && this.kyh.get() != null) {
                this.kyh.get().kwz.setVisibility(8);
            }
            if (this.kyi != null && this.kyi.get() != null) {
                l.showToast(this.kyi.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cPo() {
            if (this.kyh != null && this.kyh.get() != null) {
                this.kyh.get().kwz.setVisibility(8);
            }
        }
    }
}
