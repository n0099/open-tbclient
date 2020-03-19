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
    private float aCb;
    private float jMj;
    float kAa;
    private float kzA;
    private int kzB;
    private int kzC;
    private float kzD;
    private float kzE;
    private float kzF;
    private float kzG;
    private b kzH;
    private float kzI;
    private float kzJ;
    private float kzK;
    private float kzL;
    private boolean kzM;
    private int kzN;
    private int kzO;
    private int kzP;
    private int kzQ;
    private int kzR;
    private float kzS;
    private float kzT;
    private int kzU;
    private float kzV;
    private int kzW;
    private Map<String, Bitmap> kzX;
    private Bitmap kzY;
    float kzZ;
    private FrameLayout kzr;
    private RotateFrameLayout kzs;
    private TextView kzt;
    private EditText kzu;
    private ImageView kzv;
    private ImageView kzw;
    private int kzx;
    private boolean kzy;
    private float kzz;
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
        this.kzx = 0;
        this.kzG = 1.0f;
        this.jMj = 1.0f;
        this.kzM = true;
        this.kzX = new HashMap();
        this.startTime = 0L;
        this.kzZ = 0.0f;
        this.kAa = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aCb = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kzU = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kzr = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kzr);
        this.kzr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kzx == 4) {
                            CoverPendantDragView.this.cQC();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kzy && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.xW();
                        }
                        CoverPendantDragView.this.kzz = 0.0f;
                        CoverPendantDragView.this.kzA = 0.0f;
                        CoverPendantDragView.this.kzy = false;
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
                        CoverPendantDragView.this.kzz = 0.0f;
                        CoverPendantDragView.this.kzA = 0.0f;
                        return true;
                }
            }
        });
        this.kzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kzu.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kzw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kzA = 0.0f;
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
        this.kzu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kzx != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kzt.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kzt.getText().length()) {
                        CoverPendantDragView.this.Ke(obj);
                    } else {
                        CoverPendantDragView.this.Kd(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Ke(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.kzt.setText(editable.toString());
            }
        });
        this.kzu.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kzr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.BF = this.mDownY;
        this.kzD = (this.kzr.getWidth() / 2) + this.kzr.getX();
        this.kzE = (this.kzr.getHeight() / 2) + this.kzr.getY();
        this.kzt.setText(this.kzu.getText());
        this.kzt.setVisibility(0);
        this.kzu.setVisibility(8);
        setEditTextEnable(false);
        this.kzH.HidenSoftKeyPad(this.kzu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd(String str) {
        TextPaint paint = this.kzu.getPaint();
        float measureText = paint.measureText(str);
        while (this.kzu.getLineCount() == 1 && this.kzu.getTextSize() < this.aCb * this.jMj && measureText < this.kzT * this.jMj) {
            setTextSize(0, this.kzu.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kzu.getTextSize() != this.aCb * this.jMj) {
            setTextSize(0, this.aCb * this.jMj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke(String str) {
        TextPaint paint = this.kzu.getPaint();
        float measureText = paint.measureText(str);
        while (this.kzu.getTextSize() > ((this.kzS * this.jMj) / 2.0f) - (this.kzV * this.jMj) && measureText > this.kzT * this.jMj) {
            setTextSize(0, this.kzu.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kzu.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kzu.getTextSize() - 1.0f);
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
        this.kzH = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kzI = f;
        this.kzJ = f2;
        this.kzK = f3;
        this.kzL = f4;
        if (this.kzI > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kzI, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kzJ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kzJ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kzK > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kzK) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kzL > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kzL) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.kzD - rawX);
        float abs4 = Math.abs(this.kzE - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kzD - this.mLastX);
        float abs6 = Math.abs(this.kzE - this.BF);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cQ(sqrt, (int) (sqrt / this.kzF));
        if (this.kzA != 0.0f) {
            this.kzr.setRotation(this.kzr.getRotation() - (this.kzA - I));
        }
        this.kzA = I;
        this.mLastX = rawX;
        this.BF = rawY;
    }

    private void cQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kzr.getLayoutParams();
        int width = this.kzr.getWidth() - i;
        int i3 = (int) (width / this.kzF);
        if (width < this.kzB) {
            width = this.kzB;
            i3 = (int) (width / this.kzF);
        }
        this.jMj = ((width * 1.0f) - (this.kzR * 2)) / (this.kzW - (this.kzR * 2));
        this.mContentView.setPadding((int) (this.kzN * this.jMj), (int) (this.kzO * this.jMj), (int) (this.kzP * this.jMj), (int) (this.kzQ * this.jMj));
        setTextSize(0, (this.kzu.getTextSize() * i3) / this.kzr.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kzr.setLayoutParams(layoutParams);
        float f = this.kzD - (layoutParams.width / 2);
        float f2 = this.kzE - (layoutParams.height / 2);
        this.kzr.setX(f);
        this.kzr.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kzx != 4) {
            float y = (this.kzr.getY() + rawY) - this.BF;
            if (y < this.kzJ) {
                y = this.kzJ;
            } else if (y > (this.kzJ + this.mVideoHeight) - this.kzr.getHeight()) {
                y = (this.kzJ + this.mVideoHeight) - this.kzr.getHeight();
            }
            this.kzr.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kzy = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kzz != 0.0f) {
                    int i = (int) (this.kzz - J);
                    cQ(i, (int) (i / this.kzF));
                }
                if (this.kzA != 0.0f) {
                    this.kzr.setRotation(this.kzr.getRotation() - (this.kzA - H));
                }
                this.kzA = H;
                this.kzz = J;
            } else if (!this.kzy && pointerCount == 1) {
                float y2 = (this.kzr.getY() + rawY) - this.BF;
                if (y2 < this.kzJ - (this.kzr.getHeight() / 2)) {
                    y2 = this.kzJ - (this.kzr.getHeight() / 2);
                } else if (y2 > ((this.kzJ + this.mVideoHeight) - this.kzr.getHeight()) + (this.kzr.getHeight() / 2)) {
                    y2 = ((this.kzJ + this.mVideoHeight) - this.kzr.getHeight()) + (this.kzr.getHeight() / 2);
                }
                float x = (this.kzr.getX() + rawX) - this.mLastX;
                if (x < this.kzI - (this.kzr.getWidth() / 2)) {
                    x = this.kzI - (this.kzr.getWidth() / 2);
                } else if (x > ((this.kzI + this.mVideoWidth) - this.kzr.getWidth()) + (this.kzr.getWidth() / 2)) {
                    x = ((this.kzI + this.mVideoWidth) - this.kzr.getWidth()) + (this.kzr.getWidth() / 2);
                }
                this.kzr.setX(x);
                this.kzr.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.BF = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kzu.getTextSize() != f) {
            this.kzu.setTextSize(i, f);
        }
        if (this.kzt.getTextSize() != f) {
            this.kzt.setTextSize(i, f);
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
        matrix.postRotate(this.kzr.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kzE - motionEvent.getRawY(), this.kzD - motionEvent.getRawX()));
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
        this.kzs = (RotateFrameLayout) this.kzr.findViewById(R.id.content_container);
        this.kzt = (TextView) this.kzr.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kzr.findViewById(R.id.content_view);
        this.kzu = (EditText) this.kzr.findViewById(R.id.cover_edit);
        this.kzv = (ImageView) this.kzr.findViewById(R.id.cover_delete);
        this.kzw = (ImageView) this.kzr.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kzt.setText(this.kzu.getText());
        this.kzt.setVisibility(0);
        this.kzu.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kzt.getText())) {
            this.kzx = 0;
            this.kzr.setVisibility(8);
        }
        if (this.kzx == 4) {
            cQB();
        }
        this.kzH.HidenSoftKeyPad(this.kzu);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kzu.setFocusable(true);
            this.kzu.setFocusableInTouchMode(true);
            this.kzu.requestFocus();
            return;
        }
        this.kzu.setFocusable(false);
        this.kzu.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kzu.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    xW();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    xW();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    xW();
                    break;
                default:
                    hideSoftKeyPad();
                    String Kc = com.baidu.tieba.video.editvideo.model.b.cQw().Kc(pendantData.resource);
                    if (TextUtils.isEmpty(Kc)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kys.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cQw().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Kc, pendantData);
                        break;
                    }
                    break;
            }
            this.kzx = pendantData.pendantType;
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
        cQB();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kzx == 4 || this.kzx == 0) {
            this.kzr.setX(this.kzI);
            this.kzr.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kzJ);
            String obj = this.kzu.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kzu.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kzt.setText(a2);
                    this.kzu.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cQB() {
        if (this.kzM) {
            this.kzM = false;
            this.kzv.setVisibility(8);
            this.kzw.setVisibility(8);
            this.kzs.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQC() {
        if (!this.kzM) {
            this.kzM = true;
            this.kzv.setVisibility(0);
            this.kzw.setVisibility(0);
            this.kzs.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kzX != null) {
            Bitmap bitmap = this.kzX.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kzX.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cQB();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kzG = 1.0f;
                this.jMj = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kzG = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kzB = (this.kzR * 2) + width;
                this.kzC = (this.kzR * 2) + height;
                this.kzF = (this.kzB * 1.0f) / this.kzC;
                this.kzr.setX((((this.mVideoWidth - i2) - (this.kzR * 2)) / 2) + this.kzI);
                this.kzr.setY((((this.mVideoHeight - i) - (this.kzR * 2)) / 2) + this.kzJ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.kzZ = motionEvent.getRawX();
                this.kAa = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.kzZ);
                float abs2 = Math.abs(rawY - this.kAa);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kzt == null || this.kzt.getText() == null) {
            return null;
        }
        return this.kzt.getText().toString();
    }

    public void xW() {
        this.kzt.setText(this.kzu.getText());
        this.kzt.setVisibility(8);
        this.kzu.setVisibility(0);
        setEditTextEnable(true);
        this.kzH.ShowSoftKeyPad(this.kzu);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kzu.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kzt.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kzR = 0;
            this.kzu.setMaxLines(1);
            this.kzt.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kzt.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kzu.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kzu.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kzt.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kzR = l.getDimens(getContext(), R.dimen.ds40);
            this.kzu.setMaxLines(2);
            this.kzt.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kzt.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kzu.setLayoutParams(layoutParams2);
            this.kzN = (int) (l.dip2px(getContext(), pendantData.left) * this.kzG);
            this.kzO = (int) (l.dip2px(getContext(), pendantData.f1027top) * this.kzG);
            this.kzP = (int) (l.dip2px(getContext(), pendantData.right) * this.kzG);
            this.kzQ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kzG);
            this.mContentView.setPadding(this.kzN, this.kzO, this.kzP, this.kzQ);
            this.aCb = l.getDimens(getContext(), R.dimen.fontsize40) * this.kzG;
            String text = getText();
            this.kzS = (i2 - this.kzO) - this.kzQ;
            this.kzT = (i - this.kzN) - this.kzP;
            this.kzV = this.kzU + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aCb);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kzT);
                this.aCb = this.kzu.getTextSize();
                cQC();
                xW();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kzu.setText(text);
                    this.kzt.setText(text);
                }
                Ke(text);
            }
        }
        this.kzt.setIncludeFontPadding(false);
        this.kzu.setIncludeFontPadding(false);
        this.kzt.setLineSpacing(this.kzU, 1.0f);
        this.kzu.setLineSpacing(this.kzU, 1.0f);
        this.kzr.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kzr.getLayoutParams();
        layoutParams3.height = (this.kzR * 2) + i2;
        layoutParams3.width = (this.kzR * 2) + i;
        this.kzr.setLayoutParams(layoutParams3);
        this.kzW = (this.kzR * 2) + i;
        ((FrameLayout.LayoutParams) this.kzs.getLayoutParams()).setMargins(this.kzR, this.kzR, this.kzR, this.kzR);
        this.kzr.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kzY == null) {
            cQD();
        }
        return this.kzY;
    }

    private void cQD() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kzY = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cQE() {
        if (this.kzY != null && !this.kzY.isRecycled()) {
            this.kzY.recycle();
            this.kzY = null;
        }
    }

    public void tu(boolean z) {
        if (this.kzx != 0) {
            if (z) {
                cQE();
                this.kzr.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kzr.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kzX.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kzX.clear();
        this.kzX = null;
        cQE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> kAc;
        WeakReference<CoverPendantDragView> kAd;
        WeakReference<PendantData> kAe;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kAc = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kAd = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kAe = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eH(String str, String str2) {
            if (this.kAc != null && this.kAc.get() != null) {
                this.kAc.get().kys.setVisibility(8);
            }
            if (this.kAd != null && this.kAd.get() != null && this.kAe != null && this.kAe.get() != null) {
                this.kAd.get().a(str2, this.kAe.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JU(String str) {
            if (this.kAc != null && this.kAc.get() != null) {
                this.kAc.get().kys.setVisibility(8);
            }
            if (this.kAd != null && this.kAd.get() != null) {
                l.showToast(this.kAd.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cPL() {
            if (this.kAc != null && this.kAc.get() != null) {
                this.kAc.get().kys.setVisibility(8);
            }
        }
    }
}
