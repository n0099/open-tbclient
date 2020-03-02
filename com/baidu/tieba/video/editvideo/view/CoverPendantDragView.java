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
    private float aBM;
    float grY;
    float grZ;
    private float jKv;
    private FrameLayout kxA;
    private RotateFrameLayout kxB;
    private TextView kxC;
    private EditText kxD;
    private ImageView kxE;
    private ImageView kxF;
    private int kxG;
    private boolean kxH;
    private float kxI;
    private float kxJ;
    private int kxK;
    private int kxL;
    private float kxM;
    private float kxN;
    private float kxO;
    private float kxP;
    private b kxQ;
    private float kxR;
    private float kxS;
    private float kxT;
    private float kxU;
    private boolean kxV;
    private int kxW;
    private int kxX;
    private int kxY;
    private int kxZ;
    private int kya;
    private float kyb;
    private float kyc;
    private int kyd;
    private float kye;
    private int kyf;
    private Map<String, Bitmap> kyg;
    private Bitmap kyh;
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
        this.kxG = 0;
        this.kxP = 1.0f;
        this.jKv = 1.0f;
        this.kxV = true;
        this.kyg = new HashMap();
        this.startTime = 0L;
        this.grY = 0.0f;
        this.grZ = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aBM = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kyd = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kxA = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kxA);
        this.kxA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kxG == 4) {
                            CoverPendantDragView.this.cQh();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kxH && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.xR();
                        }
                        CoverPendantDragView.this.kxI = 0.0f;
                        CoverPendantDragView.this.kxJ = 0.0f;
                        CoverPendantDragView.this.kxH = false;
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
                        CoverPendantDragView.this.kxI = 0.0f;
                        CoverPendantDragView.this.kxJ = 0.0f;
                        return true;
                }
            }
        });
        this.kxE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kxD.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kxF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kxJ = 0.0f;
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
        this.kxD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kxG != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kxC.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kxC.getText().length()) {
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
                CoverPendantDragView.this.kxC.setText(editable.toString());
            }
        });
        this.kxD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kxA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.BF = this.mDownY;
        this.kxM = (this.kxA.getWidth() / 2) + this.kxA.getX();
        this.kxN = (this.kxA.getHeight() / 2) + this.kxA.getY();
        this.kxC.setText(this.kxD.getText());
        this.kxC.setVisibility(0);
        this.kxD.setVisibility(8);
        setEditTextEnable(false);
        this.kxQ.HidenSoftKeyPad(this.kxD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc(String str) {
        TextPaint paint = this.kxD.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxD.getLineCount() == 1 && this.kxD.getTextSize() < this.aBM * this.jKv && measureText < this.kyc * this.jKv) {
            setTextSize(0, this.kxD.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kxD.getTextSize() != this.aBM * this.jKv) {
            setTextSize(0, this.aBM * this.jKv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd(String str) {
        TextPaint paint = this.kxD.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxD.getTextSize() > ((this.kyb * this.jKv) / 2.0f) - (this.kye * this.jKv) && measureText > this.kyc * this.jKv) {
            setTextSize(0, this.kxD.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kxD.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kxD.getTextSize() - 1.0f);
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
        this.kxQ = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kxR = f;
        this.kxS = f2;
        this.kxT = f3;
        this.kxU = f4;
        if (this.kxR > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kxR, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kxS > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kxS);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kxT > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kxT) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kxU > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kxU) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.kxM - rawX);
        float abs4 = Math.abs(this.kxN - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kxM - this.mLastX);
        float abs6 = Math.abs(this.kxN - this.BF);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cP(sqrt, (int) (sqrt / this.kxO));
        if (this.kxJ != 0.0f) {
            this.kxA.setRotation(this.kxA.getRotation() - (this.kxJ - I));
        }
        this.kxJ = I;
        this.mLastX = rawX;
        this.BF = rawY;
    }

    private void cP(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxA.getLayoutParams();
        int width = this.kxA.getWidth() - i;
        int i3 = (int) (width / this.kxO);
        if (width < this.kxK) {
            width = this.kxK;
            i3 = (int) (width / this.kxO);
        }
        this.jKv = ((width * 1.0f) - (this.kya * 2)) / (this.kyf - (this.kya * 2));
        this.mContentView.setPadding((int) (this.kxW * this.jKv), (int) (this.kxX * this.jKv), (int) (this.kxY * this.jKv), (int) (this.kxZ * this.jKv));
        setTextSize(0, (this.kxD.getTextSize() * i3) / this.kxA.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kxA.setLayoutParams(layoutParams);
        float f = this.kxM - (layoutParams.width / 2);
        float f2 = this.kxN - (layoutParams.height / 2);
        this.kxA.setX(f);
        this.kxA.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kxG != 4) {
            float y = (this.kxA.getY() + rawY) - this.BF;
            if (y < this.kxS) {
                y = this.kxS;
            } else if (y > (this.kxS + this.mVideoHeight) - this.kxA.getHeight()) {
                y = (this.kxS + this.mVideoHeight) - this.kxA.getHeight();
            }
            this.kxA.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kxH = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kxI != 0.0f) {
                    int i = (int) (this.kxI - J);
                    cP(i, (int) (i / this.kxO));
                }
                if (this.kxJ != 0.0f) {
                    this.kxA.setRotation(this.kxA.getRotation() - (this.kxJ - H));
                }
                this.kxJ = H;
                this.kxI = J;
            } else if (!this.kxH && pointerCount == 1) {
                float y2 = (this.kxA.getY() + rawY) - this.BF;
                if (y2 < this.kxS - (this.kxA.getHeight() / 2)) {
                    y2 = this.kxS - (this.kxA.getHeight() / 2);
                } else if (y2 > ((this.kxS + this.mVideoHeight) - this.kxA.getHeight()) + (this.kxA.getHeight() / 2)) {
                    y2 = ((this.kxS + this.mVideoHeight) - this.kxA.getHeight()) + (this.kxA.getHeight() / 2);
                }
                float x = (this.kxA.getX() + rawX) - this.mLastX;
                if (x < this.kxR - (this.kxA.getWidth() / 2)) {
                    x = this.kxR - (this.kxA.getWidth() / 2);
                } else if (x > ((this.kxR + this.mVideoWidth) - this.kxA.getWidth()) + (this.kxA.getWidth() / 2)) {
                    x = ((this.kxR + this.mVideoWidth) - this.kxA.getWidth()) + (this.kxA.getWidth() / 2);
                }
                this.kxA.setX(x);
                this.kxA.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.BF = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kxD.getTextSize() != f) {
            this.kxD.setTextSize(i, f);
        }
        if (this.kxC.getTextSize() != f) {
            this.kxC.setTextSize(i, f);
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
        matrix.postRotate(this.kxA.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kxN - motionEvent.getRawY(), this.kxM - motionEvent.getRawX()));
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
        this.kxB = (RotateFrameLayout) this.kxA.findViewById(R.id.content_container);
        this.kxC = (TextView) this.kxA.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kxA.findViewById(R.id.content_view);
        this.kxD = (EditText) this.kxA.findViewById(R.id.cover_edit);
        this.kxE = (ImageView) this.kxA.findViewById(R.id.cover_delete);
        this.kxF = (ImageView) this.kxA.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kxC.setText(this.kxD.getText());
        this.kxC.setVisibility(0);
        this.kxD.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kxC.getText())) {
            this.kxG = 0;
            this.kxA.setVisibility(8);
        }
        if (this.kxG == 4) {
            cQg();
        }
        this.kxQ.HidenSoftKeyPad(this.kxD);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kxD.setFocusable(true);
            this.kxD.setFocusableInTouchMode(true);
            this.kxD.requestFocus();
            return;
        }
        this.kxD.setFocusable(false);
        this.kxD.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kxD.setText("");
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
                    String Kb = com.baidu.tieba.video.editvideo.model.b.cQb().Kb(pendantData.resource);
                    if (TextUtils.isEmpty(Kb)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kwB.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cQb().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Kb, pendantData);
                        break;
                    }
                    break;
            }
            this.kxG = pendantData.pendantType;
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
        cQg();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kxG == 4 || this.kxG == 0) {
            this.kxA.setX(this.kxR);
            this.kxA.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kxS);
            String obj = this.kxD.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kxD.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kxC.setText(a2);
                    this.kxD.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cQg() {
        if (this.kxV) {
            this.kxV = false;
            this.kxE.setVisibility(8);
            this.kxF.setVisibility(8);
            this.kxB.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQh() {
        if (!this.kxV) {
            this.kxV = true;
            this.kxE.setVisibility(0);
            this.kxF.setVisibility(0);
            this.kxB.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kyg != null) {
            Bitmap bitmap = this.kyg.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kyg.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cQg();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kxP = 1.0f;
                this.jKv = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kxP = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kxK = (this.kya * 2) + width;
                this.kxL = (this.kya * 2) + height;
                this.kxO = (this.kxK * 1.0f) / this.kxL;
                this.kxA.setX((((this.mVideoWidth - i2) - (this.kya * 2)) / 2) + this.kxR);
                this.kxA.setY((((this.mVideoHeight - i) - (this.kya * 2)) / 2) + this.kxS);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.grY = motionEvent.getRawX();
                this.grZ = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.grY);
                float abs2 = Math.abs(rawY - this.grZ);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kxC == null || this.kxC.getText() == null) {
            return null;
        }
        return this.kxC.getText().toString();
    }

    public void xR() {
        this.kxC.setText(this.kxD.getText());
        this.kxC.setVisibility(8);
        this.kxD.setVisibility(0);
        setEditTextEnable(true);
        this.kxQ.ShowSoftKeyPad(this.kxD);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kxD.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kxC.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kya = 0;
            this.kxD.setMaxLines(1);
            this.kxC.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxC.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kxD.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kxD.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kxC.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kya = l.getDimens(getContext(), R.dimen.ds40);
            this.kxD.setMaxLines(2);
            this.kxC.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kxC.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kxD.setLayoutParams(layoutParams2);
            this.kxW = (int) (l.dip2px(getContext(), pendantData.left) * this.kxP);
            this.kxX = (int) (l.dip2px(getContext(), pendantData.f1027top) * this.kxP);
            this.kxY = (int) (l.dip2px(getContext(), pendantData.right) * this.kxP);
            this.kxZ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kxP);
            this.mContentView.setPadding(this.kxW, this.kxX, this.kxY, this.kxZ);
            this.aBM = l.getDimens(getContext(), R.dimen.fontsize40) * this.kxP;
            String text = getText();
            this.kyb = (i2 - this.kxX) - this.kxZ;
            this.kyc = (i - this.kxW) - this.kxY;
            this.kye = this.kyd + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aBM);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kyc);
                this.aBM = this.kxD.getTextSize();
                cQh();
                xR();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kxD.setText(text);
                    this.kxC.setText(text);
                }
                Kd(text);
            }
        }
        this.kxC.setIncludeFontPadding(false);
        this.kxD.setIncludeFontPadding(false);
        this.kxC.setLineSpacing(this.kyd, 1.0f);
        this.kxD.setLineSpacing(this.kyd, 1.0f);
        this.kxA.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kxA.getLayoutParams();
        layoutParams3.height = (this.kya * 2) + i2;
        layoutParams3.width = (this.kya * 2) + i;
        this.kxA.setLayoutParams(layoutParams3);
        this.kyf = (this.kya * 2) + i;
        ((FrameLayout.LayoutParams) this.kxB.getLayoutParams()).setMargins(this.kya, this.kya, this.kya, this.kya);
        this.kxA.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kyh == null) {
            cQi();
        }
        return this.kyh;
    }

    private void cQi() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kyh = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cQj() {
        if (this.kyh != null && !this.kyh.isRecycled()) {
            this.kyh.recycle();
            this.kyh = null;
        }
    }

    public void to(boolean z) {
        if (this.kxG != 0) {
            if (z) {
                cQj();
                this.kxA.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kxA.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kyg.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kyg.clear();
        this.kyg = null;
        cQj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> kyj;
        WeakReference<CoverPendantDragView> kyk;
        WeakReference<PendantData> kyl;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kyj = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kyk = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kyl = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eJ(String str, String str2) {
            if (this.kyj != null && this.kyj.get() != null) {
                this.kyj.get().kwB.setVisibility(8);
            }
            if (this.kyk != null && this.kyk.get() != null && this.kyl != null && this.kyl.get() != null) {
                this.kyk.get().a(str2, this.kyl.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JT(String str) {
            if (this.kyj != null && this.kyj.get() != null) {
                this.kyj.get().kwB.setVisibility(8);
            }
            if (this.kyk != null && this.kyk.get() != null) {
                l.showToast(this.kyk.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cPq() {
            if (this.kyj != null && this.kyj.get() != null) {
                this.kyj.get().kwB.setVisibility(8);
            }
        }
    }
}
