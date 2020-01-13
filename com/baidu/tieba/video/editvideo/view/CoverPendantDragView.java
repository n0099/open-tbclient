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
/* loaded from: classes8.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Bn;
    private float axv;
    float gpV;
    float gpW;
    private float jJs;
    private TextView kwA;
    private EditText kwB;
    private ImageView kwC;
    private ImageView kwD;
    private int kwE;
    private boolean kwF;
    private float kwG;
    private float kwH;
    private int kwI;
    private int kwJ;
    private float kwK;
    private float kwL;
    private float kwM;
    private float kwN;
    private b kwO;
    private float kwP;
    private float kwQ;
    private float kwR;
    private float kwS;
    private boolean kwT;
    private int kwU;
    private int kwV;
    private int kwW;
    private int kwX;
    private int kwY;
    private float kwZ;
    private FrameLayout kwy;
    private RotateFrameLayout kwz;
    private float kxa;
    private int kxb;
    private float kxc;
    private int kxd;
    private Map<String, Bitmap> kxe;
    private Bitmap kxf;
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
        this.kwE = 0;
        this.kwN = 1.0f;
        this.jJs = 1.0f;
        this.kwT = true;
        this.kxe = new HashMap();
        this.startTime = 0L;
        this.gpV = 0.0f;
        this.gpW = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.axv = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kxb = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kwy = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kwy);
        this.kwy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kwE == 4) {
                            CoverPendantDragView.this.cOK();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kwF && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.vS();
                        }
                        CoverPendantDragView.this.kwG = 0.0f;
                        CoverPendantDragView.this.kwH = 0.0f;
                        CoverPendantDragView.this.kwF = false;
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
                        CoverPendantDragView.this.kwG = 0.0f;
                        CoverPendantDragView.this.kwH = 0.0f;
                        return true;
                }
            }
        });
        this.kwC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kwB.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kwD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kwH = 0.0f;
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
        this.kwB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kwE != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kwA.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kwA.getText().length()) {
                        CoverPendantDragView.this.JQ(obj);
                    } else {
                        CoverPendantDragView.this.JP(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.JQ(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.kwA.setText(editable.toString());
            }
        });
        this.kwB.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kwy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.Bn = this.mDownY;
        this.kwK = (this.kwy.getWidth() / 2) + this.kwy.getX();
        this.kwL = (this.kwy.getHeight() / 2) + this.kwy.getY();
        this.kwA.setText(this.kwB.getText());
        this.kwA.setVisibility(0);
        this.kwB.setVisibility(8);
        setEditTextEnable(false);
        this.kwO.HidenSoftKeyPad(this.kwB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP(String str) {
        TextPaint paint = this.kwB.getPaint();
        float measureText = paint.measureText(str);
        while (this.kwB.getLineCount() == 1 && this.kwB.getTextSize() < this.axv * this.jJs && measureText < this.kxa * this.jJs) {
            setTextSize(0, this.kwB.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kwB.getTextSize() != this.axv * this.jJs) {
            setTextSize(0, this.axv * this.jJs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ(String str) {
        TextPaint paint = this.kwB.getPaint();
        float measureText = paint.measureText(str);
        while (this.kwB.getTextSize() > ((this.kwZ * this.jJs) / 2.0f) - (this.kxc * this.jJs) && measureText > this.kxa * this.jJs) {
            setTextSize(0, this.kwB.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kwB.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kwB.getTextSize() - 1.0f);
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
        this.kwO = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kwP = f;
        this.kwQ = f2;
        this.kwR = f3;
        this.kwS = f4;
        if (this.kwP > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kwP, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kwQ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kwQ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kwR > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kwR) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kwS > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kwS) - this.mVideoHeight);
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
        float abs2 = Math.abs(this.Bn - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.kwK - rawX);
        float abs4 = Math.abs(this.kwL - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kwK - this.mLastX);
        float abs6 = Math.abs(this.kwL - this.Bn);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cM(sqrt, (int) (sqrt / this.kwM));
        if (this.kwH != 0.0f) {
            this.kwy.setRotation(this.kwy.getRotation() - (this.kwH - I));
        }
        this.kwH = I;
        this.mLastX = rawX;
        this.Bn = rawY;
    }

    private void cM(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kwy.getLayoutParams();
        int width = this.kwy.getWidth() - i;
        int i3 = (int) (width / this.kwM);
        if (width < this.kwI) {
            width = this.kwI;
            i3 = (int) (width / this.kwM);
        }
        this.jJs = ((width * 1.0f) - (this.kwY * 2)) / (this.kxd - (this.kwY * 2));
        this.mContentView.setPadding((int) (this.kwU * this.jJs), (int) (this.kwV * this.jJs), (int) (this.kwW * this.jJs), (int) (this.kwX * this.jJs));
        setTextSize(0, (this.kwB.getTextSize() * i3) / this.kwy.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kwy.setLayoutParams(layoutParams);
        float f = this.kwK - (layoutParams.width / 2);
        float f2 = this.kwL - (layoutParams.height / 2);
        this.kwy.setX(f);
        this.kwy.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kwE != 4) {
            float y = (this.kwy.getY() + rawY) - this.Bn;
            if (y < this.kwQ) {
                y = this.kwQ;
            } else if (y > (this.kwQ + this.mVideoHeight) - this.kwy.getHeight()) {
                y = (this.kwQ + this.mVideoHeight) - this.kwy.getHeight();
            }
            this.kwy.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kwF = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kwG != 0.0f) {
                    int i = (int) (this.kwG - J);
                    cM(i, (int) (i / this.kwM));
                }
                if (this.kwH != 0.0f) {
                    this.kwy.setRotation(this.kwy.getRotation() - (this.kwH - H));
                }
                this.kwH = H;
                this.kwG = J;
            } else if (!this.kwF && pointerCount == 1) {
                float y2 = (this.kwy.getY() + rawY) - this.Bn;
                if (y2 < this.kwQ - (this.kwy.getHeight() / 2)) {
                    y2 = this.kwQ - (this.kwy.getHeight() / 2);
                } else if (y2 > ((this.kwQ + this.mVideoHeight) - this.kwy.getHeight()) + (this.kwy.getHeight() / 2)) {
                    y2 = ((this.kwQ + this.mVideoHeight) - this.kwy.getHeight()) + (this.kwy.getHeight() / 2);
                }
                float x = (this.kwy.getX() + rawX) - this.mLastX;
                if (x < this.kwP - (this.kwy.getWidth() / 2)) {
                    x = this.kwP - (this.kwy.getWidth() / 2);
                } else if (x > ((this.kwP + this.mVideoWidth) - this.kwy.getWidth()) + (this.kwy.getWidth() / 2)) {
                    x = ((this.kwP + this.mVideoWidth) - this.kwy.getWidth()) + (this.kwy.getWidth() / 2);
                }
                this.kwy.setX(x);
                this.kwy.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.Bn = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kwB.getTextSize() != f) {
            this.kwB.setTextSize(i, f);
        }
        if (this.kwA.getTextSize() != f) {
            this.kwA.setTextSize(i, f);
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
        matrix.postRotate(this.kwy.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kwL - motionEvent.getRawY(), this.kwK - motionEvent.getRawX()));
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
        this.kwz = (RotateFrameLayout) this.kwy.findViewById(R.id.content_container);
        this.kwA = (TextView) this.kwy.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kwy.findViewById(R.id.content_view);
        this.kwB = (EditText) this.kwy.findViewById(R.id.cover_edit);
        this.kwC = (ImageView) this.kwy.findViewById(R.id.cover_delete);
        this.kwD = (ImageView) this.kwy.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kwA.setText(this.kwB.getText());
        this.kwA.setVisibility(0);
        this.kwB.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kwA.getText())) {
            this.kwE = 0;
            this.kwy.setVisibility(8);
        }
        if (this.kwE == 4) {
            cOJ();
        }
        this.kwO.HidenSoftKeyPad(this.kwB);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kwB.setFocusable(true);
            this.kwB.setFocusableInTouchMode(true);
            this.kwB.requestFocus();
            return;
        }
        this.kwB.setFocusable(false);
        this.kwB.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kwB.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    vS();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    vS();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    vS();
                    break;
                default:
                    hideSoftKeyPad();
                    String JO = com.baidu.tieba.video.editvideo.model.b.cOE().JO(pendantData.resource);
                    if (TextUtils.isEmpty(JO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kvx.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cOE().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(JO, pendantData);
                        break;
                    }
                    break;
            }
            this.kwE = pendantData.pendantType;
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
        cOJ();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kwE == 4 || this.kwE == 0) {
            this.kwy.setX(this.kwP);
            this.kwy.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kwQ);
            String obj = this.kwB.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kwB.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kwA.setText(a2);
                    this.kwB.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cOJ() {
        if (this.kwT) {
            this.kwT = false;
            this.kwC.setVisibility(8);
            this.kwD.setVisibility(8);
            this.kwz.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOK() {
        if (!this.kwT) {
            this.kwT = true;
            this.kwC.setVisibility(0);
            this.kwD.setVisibility(0);
            this.kwz.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kxe != null) {
            Bitmap bitmap = this.kxe.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kxe.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cOJ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kwN = 1.0f;
                this.jJs = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kwN = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kwI = (this.kwY * 2) + width;
                this.kwJ = (this.kwY * 2) + height;
                this.kwM = (this.kwI * 1.0f) / this.kwJ;
                this.kwy.setX((((this.mVideoWidth - i2) - (this.kwY * 2)) / 2) + this.kwP);
                this.kwy.setY((((this.mVideoHeight - i) - (this.kwY * 2)) / 2) + this.kwQ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gpV = motionEvent.getRawX();
                this.gpW = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gpV);
                float abs2 = Math.abs(rawY - this.gpW);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kwA == null || this.kwA.getText() == null) {
            return null;
        }
        return this.kwA.getText().toString();
    }

    public void vS() {
        this.kwA.setText(this.kwB.getText());
        this.kwA.setVisibility(8);
        this.kwB.setVisibility(0);
        setEditTextEnable(true);
        this.kwO.ShowSoftKeyPad(this.kwB);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kwB.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kwA.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kwY = 0;
            this.kwB.setMaxLines(1);
            this.kwA.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kwA.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kwB.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kwB.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kwA.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kwY = l.getDimens(getContext(), R.dimen.ds40);
            this.kwB.setMaxLines(2);
            this.kwA.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kwA.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kwB.setLayoutParams(layoutParams2);
            this.kwU = (int) (l.dip2px(getContext(), pendantData.left) * this.kwN);
            this.kwV = (int) (l.dip2px(getContext(), pendantData.top) * this.kwN);
            this.kwW = (int) (l.dip2px(getContext(), pendantData.right) * this.kwN);
            this.kwX = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kwN);
            this.mContentView.setPadding(this.kwU, this.kwV, this.kwW, this.kwX);
            this.axv = l.getDimens(getContext(), R.dimen.fontsize40) * this.kwN;
            String text = getText();
            this.kwZ = (i2 - this.kwV) - this.kwX;
            this.kxa = (i - this.kwU) - this.kwW;
            this.kxc = this.kxb + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.axv);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kxa);
                this.axv = this.kwB.getTextSize();
                cOK();
                vS();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kwB.setText(text);
                    this.kwA.setText(text);
                }
                JQ(text);
            }
        }
        this.kwA.setIncludeFontPadding(false);
        this.kwB.setIncludeFontPadding(false);
        this.kwA.setLineSpacing(this.kxb, 1.0f);
        this.kwB.setLineSpacing(this.kxb, 1.0f);
        this.kwy.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kwy.getLayoutParams();
        layoutParams3.height = (this.kwY * 2) + i2;
        layoutParams3.width = (this.kwY * 2) + i;
        this.kwy.setLayoutParams(layoutParams3);
        this.kxd = (this.kwY * 2) + i;
        ((FrameLayout.LayoutParams) this.kwz.getLayoutParams()).setMargins(this.kwY, this.kwY, this.kwY, this.kwY);
        this.kwy.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kxf == null) {
            cOL();
        }
        return this.kxf;
    }

    private void cOL() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kxf = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cOM() {
        if (this.kxf != null && !this.kxf.isRecycled()) {
            this.kxf.recycle();
            this.kxf = null;
        }
    }

    public void tk(boolean z) {
        if (this.kwE != 0) {
            if (z) {
                cOM();
                this.kwy.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kwy.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kxe.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kxe.clear();
        this.kxe = null;
        cOM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> kxh;
        WeakReference<CoverPendantDragView> kxi;
        WeakReference<PendantData> kxj;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kxh = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kxi = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kxj = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eA(String str, String str2) {
            if (this.kxh != null && this.kxh.get() != null) {
                this.kxh.get().kvx.setVisibility(8);
            }
            if (this.kxi != null && this.kxi.get() != null && this.kxj != null && this.kxj.get() != null) {
                this.kxi.get().a(str2, this.kxj.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JG(String str) {
            if (this.kxh != null && this.kxh.get() != null) {
                this.kxh.get().kvx.setVisibility(8);
            }
            if (this.kxi != null && this.kxi.get() != null) {
                l.showToast(this.kxi.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cNR() {
            if (this.kxh != null && this.kxh.get() != null) {
                this.kxh.get().kvx.setVisibility(8);
            }
        }
    }
}
