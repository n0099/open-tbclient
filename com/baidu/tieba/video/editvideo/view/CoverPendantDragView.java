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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes23.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bHj;
    float bpE;
    float bpF;
    private float cBL;
    private float iFt;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLI;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout nDR;
    private RotateFrameLayout nDS;
    private TextView nDT;
    private EditText nDU;
    private ImageView nDV;
    private ImageView nDW;
    private int nDX;
    private boolean nDY;
    private float nDZ;
    private float nEa;
    private int nEb;
    private int nEc;
    private float nEd;
    private float nEe;
    private float nEf;
    private float nEg;
    private c nEh;
    private float nEi;
    private float nEj;
    private float nEk;
    private float nEl;
    private boolean nEm;
    private int nEn;
    private int nEo;
    private int nEp;
    private int nEq;
    private int nEr;
    private float nEs;
    private float nEt;
    private int nEu;
    private float nEv;
    private int nEw;
    private Map<String, Bitmap> nEx;
    private Bitmap nEy;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDX = 0;
        this.nEg = 1.0f;
        this.mLI = 1.0f;
        this.nEm = true;
        this.nEx = new HashMap();
        this.startTime = 0L;
        this.bpE = 0.0f;
        this.bpF = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bHj = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nEu = l.getDimens(getContext(), R.dimen.ds2);
        this.iFt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nDR = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nDR);
        this.nDR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.nDX == 4) {
                            CoverPendantDragView.this.dUJ();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cBL);
                        if (!CoverPendantDragView.this.nDY && abs < CoverPendantDragView.this.iFt && abs2 < CoverPendantDragView.this.iFt && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.OR();
                        }
                        CoverPendantDragView.this.nDZ = 0.0f;
                        CoverPendantDragView.this.nEa = 0.0f;
                        CoverPendantDragView.this.nDY = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.ab(motionEvent)) {
                            CoverPendantDragView.this.af(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.nDZ = 0.0f;
                        CoverPendantDragView.this.nEa = 0.0f;
                        return true;
                }
            }
        });
        this.nDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nDU.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nDW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nEa = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.ab(motionEvent)) {
                            CoverPendantDragView.this.ae(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.nDU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nDX != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nDT.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nDT.getText().length()) {
                        CoverPendantDragView.this.UP(obj);
                    } else {
                        CoverPendantDragView.this.UO(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.UP(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nDT.setText(editable.toString());
            }
        });
        this.nDU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nDR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cBL = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cBL;
        this.nEd = (this.nDR.getWidth() / 2) + this.nDR.getX();
        this.nEe = (this.nDR.getHeight() / 2) + this.nDR.getY();
        this.nDT.setText(this.nDU.getText());
        this.nDT.setVisibility(0);
        this.nDU.setVisibility(8);
        setEditTextEnable(false);
        this.nEh.HidenSoftKeyPad(this.nDU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO(String str) {
        TextPaint paint = this.nDU.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDU.getLineCount() == 1 && this.nDU.getTextSize() < this.bHj * this.mLI && measureText < this.nEt * this.mLI) {
            setTextSize(0, this.nDU.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nDU.getTextSize() != this.bHj * this.mLI) {
            setTextSize(0, this.bHj * this.mLI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UP(String str) {
        TextPaint paint = this.nDU.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDU.getTextSize() > ((this.nEs * this.mLI) / 2.0f) - (this.nEv * this.mLI) && measureText > this.nEt * this.mLI) {
            setTextSize(0, this.nDU.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.nDU.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nDU.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ae.subStringWithEmoji(str, ae.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.nEh = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nEi = f;
        this.nEj = f2;
        this.nEk = f3;
        this.nEl = f4;
        if (this.nEi > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nEi, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nEj > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nEj);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nEk > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nEk) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nEl > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nEl) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float ah = ah(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.nEd - rawX);
        float abs4 = Math.abs(this.nEe - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nEd - this.mLastX);
        float abs6 = Math.abs(this.nEe - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dE(sqrt, (int) (sqrt / this.nEf));
        if (this.nEa != 0.0f) {
            this.nDR.setRotation(this.nDR.getRotation() - (this.nEa - ah));
        }
        this.nEa = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dE(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDR.getLayoutParams();
        int width = this.nDR.getWidth() - i;
        int i3 = (int) (width / this.nEf);
        if (width < this.nEb) {
            width = this.nEb;
            i3 = (int) (width / this.nEf);
        }
        this.mLI = ((width * 1.0f) - (this.nEr * 2)) / (this.nEw - (this.nEr * 2));
        this.mContentView.setPadding((int) (this.nEn * this.mLI), (int) (this.nEo * this.mLI), (int) (this.nEp * this.mLI), (int) (this.nEq * this.mLI));
        setTextSize(0, (this.nDU.getTextSize() * i3) / this.nDR.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nDR.setLayoutParams(layoutParams);
        float f = this.nEd - (layoutParams.width / 2);
        float f2 = this.nEe - (layoutParams.height / 2);
        this.nDR.setX(f);
        this.nDR.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nDX != 4) {
            float y = (this.nDR.getY() + rawY) - this.mLastY;
            if (y < this.nEj) {
                y = this.nEj;
            } else if (y > (this.nEj + this.mVideoHeight) - this.nDR.getHeight()) {
                y = (this.nEj + this.mVideoHeight) - this.nDR.getHeight();
            }
            this.nDR.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nDY = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nDZ != 0.0f) {
                    int i = (int) (this.nDZ - ai);
                    dE(i, (int) (i / this.nEf));
                }
                if (this.nEa != 0.0f) {
                    this.nDR.setRotation(this.nDR.getRotation() - (this.nEa - ag));
                }
                this.nEa = ag;
                this.nDZ = ai;
            } else if (!this.nDY && pointerCount == 1) {
                float y2 = (this.nDR.getY() + rawY) - this.mLastY;
                if (y2 < this.nEj - (this.nDR.getHeight() / 2)) {
                    y2 = this.nEj - (this.nDR.getHeight() / 2);
                } else if (y2 > ((this.nEj + this.mVideoHeight) - this.nDR.getHeight()) + (this.nDR.getHeight() / 2)) {
                    y2 = ((this.nEj + this.mVideoHeight) - this.nDR.getHeight()) + (this.nDR.getHeight() / 2);
                }
                float x = (this.nDR.getX() + rawX) - this.mLastX;
                if (x < this.nEi - (this.nDR.getWidth() / 2)) {
                    x = this.nEi - (this.nDR.getWidth() / 2);
                } else if (x > ((this.nEi + this.mVideoWidth) - this.nDR.getWidth()) + (this.nDR.getWidth() / 2)) {
                    x = ((this.nEi + this.mVideoWidth) - this.nDR.getWidth()) + (this.nDR.getWidth() / 2);
                }
                this.nDR.setX(x);
                this.nDR.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nDU.getTextSize() != f) {
            this.nDU.setTextSize(i, f);
        }
        if (this.nDT.getTextSize() != f) {
            this.nDT.setTextSize(i, f);
        }
    }

    private float ag(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.nDR.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nEe - motionEvent.getRawY(), this.nEd - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iFt && Math.abs(motionEvent.getRawY() - this.cBL) < this.iFt;
    }

    private void init() {
        this.nDS = (RotateFrameLayout) this.nDR.findViewById(R.id.content_container);
        this.nDT = (TextView) this.nDR.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nDR.findViewById(R.id.content_view);
        this.nDU = (EditText) this.nDR.findViewById(R.id.cover_edit);
        this.nDV = (ImageView) this.nDR.findViewById(R.id.cover_delete);
        this.nDW = (ImageView) this.nDR.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nDT.setText(this.nDU.getText());
        this.nDT.setVisibility(0);
        this.nDU.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nDT.getText())) {
            this.nDX = 0;
            this.nDR.setVisibility(8);
        }
        if (this.nDX == 4) {
            dUI();
        }
        this.nEh.HidenSoftKeyPad(this.nDU);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nDU.setFocusable(true);
            this.nDU.setFocusableInTouchMode(true);
            this.nDU.requestFocus();
            return;
        }
        this.nDU.setFocusable(false);
        this.nDU.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nDU.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    OR();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    OR();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    OR();
                    break;
                default:
                    hideSoftKeyPad();
                    String UN = com.baidu.tieba.video.editvideo.model.b.dUD().UN(pendantData.resource);
                    if (TextUtils.isEmpty(UN)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nCR.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dUD().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(UN, pendantData);
                        break;
                    }
                    break;
            }
            this.nDX = pendantData.pendantType;
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
        dUI();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nDX == 4 || this.nDX == 0) {
            this.nDR.setX(this.nEi);
            this.nDR.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nEj);
            String obj = this.nDU.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nDU.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nDT.setText(a2);
                    this.nDU.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dUI() {
        if (this.nEm) {
            this.nEm = false;
            this.nDV.setVisibility(8);
            this.nDW.setVisibility(8);
            this.nDS.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUJ() {
        if (!this.nEm) {
            this.nEm = true;
            this.nDV.setVisibility(0);
            this.nDW.setVisibility(0);
            this.nDS.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nEx != null) {
            Bitmap bitmap = this.nEx.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nEx.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dUI();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nEg = 1.0f;
                this.mLI = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nEg = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nEb = (this.nEr * 2) + width;
                this.nEc = (this.nEr * 2) + height;
                this.nEf = (this.nEb * 1.0f) / this.nEc;
                this.nDR.setX((((this.mVideoWidth - i2) - (this.nEr * 2)) / 2) + this.nEi);
                this.nDR.setY((((this.mVideoHeight - i) - (this.nEr * 2)) / 2) + this.nEj);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bpE = motionEvent.getRawX();
                this.bpF = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bpE);
                float abs2 = Math.abs(rawY - this.bpF);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iFt && abs2 < this.iFt && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nDT == null || this.nDT.getText() == null) {
            return null;
        }
        return this.nDT.getText().toString();
    }

    public void OR() {
        this.nDT.setText(this.nDU.getText());
        this.nDT.setVisibility(8);
        this.nDU.setVisibility(0);
        setEditTextEnable(true);
        this.nEh.ShowSoftKeyPad(this.nDU);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nDU.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nDT.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nEr = 0;
            this.nDU.setMaxLines(1);
            this.nDT.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDT.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nDU.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nDU.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDT.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nEr = l.getDimens(getContext(), R.dimen.ds40);
            this.nDU.setMaxLines(2);
            this.nDT.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nDT.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nDU.setLayoutParams(layoutParams2);
            this.nEn = (int) (l.dip2px(getContext(), pendantData.left) * this.nEg);
            this.nEo = (int) (l.dip2px(getContext(), pendantData.top) * this.nEg);
            this.nEp = (int) (l.dip2px(getContext(), pendantData.right) * this.nEg);
            this.nEq = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nEg);
            this.mContentView.setPadding(this.nEn, this.nEo, this.nEp, this.nEq);
            this.bHj = l.getDimens(getContext(), R.dimen.fontsize40) * this.nEg;
            String text = getText();
            this.nEs = (i2 - this.nEo) - this.nEq;
            this.nEt = (i - this.nEn) - this.nEp;
            this.nEv = this.nEu + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bHj);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.nEt);
                this.bHj = this.nDU.getTextSize();
                dUJ();
                OR();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.nDU.setText(text);
                    this.nDT.setText(text);
                }
                UP(text);
            }
        }
        this.nDT.setIncludeFontPadding(false);
        this.nDU.setIncludeFontPadding(false);
        this.nDT.setLineSpacing(this.nEu, 1.0f);
        this.nDU.setLineSpacing(this.nEu, 1.0f);
        this.nDR.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nDR.getLayoutParams();
        layoutParams3.height = (this.nEr * 2) + i2;
        layoutParams3.width = (this.nEr * 2) + i;
        this.nDR.setLayoutParams(layoutParams3);
        this.nEw = (this.nEr * 2) + i;
        ((FrameLayout.LayoutParams) this.nDS.getLayoutParams()).setMargins(this.nEr, this.nEr, this.nEr, this.nEr);
        this.nDR.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nEy == null) {
            dUK();
        }
        return this.nEy;
    }

    private void dUK() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nEy = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dUL() {
        if (this.nEy != null && !this.nEy.isRecycled()) {
            this.nEy.recycle();
            this.nEy = null;
        }
    }

    public void yG(boolean z) {
        if (this.nDX != 0) {
            if (z) {
                dUL();
                this.nDR.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nDR.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nEx.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nEx.clear();
        this.nEx = null;
        dUL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a implements b.a {
        WeakReference<a.b> nEA;
        WeakReference<CoverPendantDragView> nEB;
        WeakReference<PendantData> nEC;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nEA = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nEB = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nEC = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gB(String str, String str2) {
            if (this.nEA != null && this.nEA.get() != null) {
                this.nEA.get().nCR.setVisibility(8);
            }
            if (this.nEB != null && this.nEB.get() != null && this.nEC != null && this.nEC.get() != null) {
                this.nEB.get().a(str2, this.nEC.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void UG(String str) {
            if (this.nEA != null && this.nEA.get() != null) {
                this.nEA.get().nCR.setVisibility(8);
            }
            if (this.nEB != null && this.nEB.get() != null) {
                l.showToast(this.nEB.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dTU() {
            if (this.nEA != null && this.nEA.get() != null) {
                this.nEA.get().nCR.setVisibility(8);
            }
        }
    }
}
