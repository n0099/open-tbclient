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
    private float iFv;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLK;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout nDT;
    private RotateFrameLayout nDU;
    private TextView nDV;
    private EditText nDW;
    private ImageView nDX;
    private ImageView nDY;
    private int nDZ;
    private Bitmap nEA;
    private boolean nEa;
    private float nEb;
    private float nEc;
    private int nEd;
    private int nEe;
    private float nEf;
    private float nEg;
    private float nEh;
    private float nEi;
    private c nEj;
    private float nEk;
    private float nEl;
    private float nEm;
    private float nEn;
    private boolean nEo;
    private int nEp;
    private int nEq;
    private int nEr;
    private int nEs;
    private int nEt;
    private float nEu;
    private float nEv;
    private int nEw;
    private float nEx;
    private int nEy;
    private Map<String, Bitmap> nEz;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDZ = 0;
        this.nEi = 1.0f;
        this.mLK = 1.0f;
        this.nEo = true;
        this.nEz = new HashMap();
        this.startTime = 0L;
        this.bpE = 0.0f;
        this.bpF = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bHj = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nEw = l.getDimens(getContext(), R.dimen.ds2);
        this.iFv = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nDT = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nDT);
        this.nDT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.nDZ == 4) {
                            CoverPendantDragView.this.dUK();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cBL);
                        if (!CoverPendantDragView.this.nEa && abs < CoverPendantDragView.this.iFv && abs2 < CoverPendantDragView.this.iFv && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.OR();
                        }
                        CoverPendantDragView.this.nEb = 0.0f;
                        CoverPendantDragView.this.nEc = 0.0f;
                        CoverPendantDragView.this.nEa = false;
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
                        CoverPendantDragView.this.nEb = 0.0f;
                        CoverPendantDragView.this.nEc = 0.0f;
                        return true;
                }
            }
        });
        this.nDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nDW.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nDY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nEc = 0.0f;
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
        this.nDW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nDZ != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nDV.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nDV.getText().length()) {
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
                CoverPendantDragView.this.nDV.setText(editable.toString());
            }
        });
        this.nDW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nDT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cBL = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cBL;
        this.nEf = (this.nDT.getWidth() / 2) + this.nDT.getX();
        this.nEg = (this.nDT.getHeight() / 2) + this.nDT.getY();
        this.nDV.setText(this.nDW.getText());
        this.nDV.setVisibility(0);
        this.nDW.setVisibility(8);
        setEditTextEnable(false);
        this.nEj.HidenSoftKeyPad(this.nDW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO(String str) {
        TextPaint paint = this.nDW.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDW.getLineCount() == 1 && this.nDW.getTextSize() < this.bHj * this.mLK && measureText < this.nEv * this.mLK) {
            setTextSize(0, this.nDW.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nDW.getTextSize() != this.bHj * this.mLK) {
            setTextSize(0, this.bHj * this.mLK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UP(String str) {
        TextPaint paint = this.nDW.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDW.getTextSize() > ((this.nEu * this.mLK) / 2.0f) - (this.nEx * this.mLK) && measureText > this.nEv * this.mLK) {
            setTextSize(0, this.nDW.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.nDW.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nDW.getTextSize() - 1.0f);
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
        this.nEj = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nEk = f;
        this.nEl = f2;
        this.nEm = f3;
        this.nEn = f4;
        if (this.nEk > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nEk, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nEl > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nEl);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nEm > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nEm) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nEn > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nEn) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nEf - rawX);
        float abs4 = Math.abs(this.nEg - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nEf - this.mLastX);
        float abs6 = Math.abs(this.nEg - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dE(sqrt, (int) (sqrt / this.nEh));
        if (this.nEc != 0.0f) {
            this.nDT.setRotation(this.nDT.getRotation() - (this.nEc - ah));
        }
        this.nEc = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dE(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDT.getLayoutParams();
        int width = this.nDT.getWidth() - i;
        int i3 = (int) (width / this.nEh);
        if (width < this.nEd) {
            width = this.nEd;
            i3 = (int) (width / this.nEh);
        }
        this.mLK = ((width * 1.0f) - (this.nEt * 2)) / (this.nEy - (this.nEt * 2));
        this.mContentView.setPadding((int) (this.nEp * this.mLK), (int) (this.nEq * this.mLK), (int) (this.nEr * this.mLK), (int) (this.nEs * this.mLK));
        setTextSize(0, (this.nDW.getTextSize() * i3) / this.nDT.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nDT.setLayoutParams(layoutParams);
        float f = this.nEf - (layoutParams.width / 2);
        float f2 = this.nEg - (layoutParams.height / 2);
        this.nDT.setX(f);
        this.nDT.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nDZ != 4) {
            float y = (this.nDT.getY() + rawY) - this.mLastY;
            if (y < this.nEl) {
                y = this.nEl;
            } else if (y > (this.nEl + this.mVideoHeight) - this.nDT.getHeight()) {
                y = (this.nEl + this.mVideoHeight) - this.nDT.getHeight();
            }
            this.nDT.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nEa = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nEb != 0.0f) {
                    int i = (int) (this.nEb - ai);
                    dE(i, (int) (i / this.nEh));
                }
                if (this.nEc != 0.0f) {
                    this.nDT.setRotation(this.nDT.getRotation() - (this.nEc - ag));
                }
                this.nEc = ag;
                this.nEb = ai;
            } else if (!this.nEa && pointerCount == 1) {
                float y2 = (this.nDT.getY() + rawY) - this.mLastY;
                if (y2 < this.nEl - (this.nDT.getHeight() / 2)) {
                    y2 = this.nEl - (this.nDT.getHeight() / 2);
                } else if (y2 > ((this.nEl + this.mVideoHeight) - this.nDT.getHeight()) + (this.nDT.getHeight() / 2)) {
                    y2 = ((this.nEl + this.mVideoHeight) - this.nDT.getHeight()) + (this.nDT.getHeight() / 2);
                }
                float x = (this.nDT.getX() + rawX) - this.mLastX;
                if (x < this.nEk - (this.nDT.getWidth() / 2)) {
                    x = this.nEk - (this.nDT.getWidth() / 2);
                } else if (x > ((this.nEk + this.mVideoWidth) - this.nDT.getWidth()) + (this.nDT.getWidth() / 2)) {
                    x = ((this.nEk + this.mVideoWidth) - this.nDT.getWidth()) + (this.nDT.getWidth() / 2);
                }
                this.nDT.setX(x);
                this.nDT.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nDW.getTextSize() != f) {
            this.nDW.setTextSize(i, f);
        }
        if (this.nDV.getTextSize() != f) {
            this.nDV.setTextSize(i, f);
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
        matrix.postRotate(this.nDT.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nEg - motionEvent.getRawY(), this.nEf - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iFv && Math.abs(motionEvent.getRawY() - this.cBL) < this.iFv;
    }

    private void init() {
        this.nDU = (RotateFrameLayout) this.nDT.findViewById(R.id.content_container);
        this.nDV = (TextView) this.nDT.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nDT.findViewById(R.id.content_view);
        this.nDW = (EditText) this.nDT.findViewById(R.id.cover_edit);
        this.nDX = (ImageView) this.nDT.findViewById(R.id.cover_delete);
        this.nDY = (ImageView) this.nDT.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nDV.setText(this.nDW.getText());
        this.nDV.setVisibility(0);
        this.nDW.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nDV.getText())) {
            this.nDZ = 0;
            this.nDT.setVisibility(8);
        }
        if (this.nDZ == 4) {
            dUJ();
        }
        this.nEj.HidenSoftKeyPad(this.nDW);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nDW.setFocusable(true);
            this.nDW.setFocusableInTouchMode(true);
            this.nDW.requestFocus();
            return;
        }
        this.nDW.setFocusable(false);
        this.nDW.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nDW.setText("");
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
                    String UN = com.baidu.tieba.video.editvideo.model.b.dUE().UN(pendantData.resource);
                    if (TextUtils.isEmpty(UN)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nCT.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dUE().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(UN, pendantData);
                        break;
                    }
                    break;
            }
            this.nDZ = pendantData.pendantType;
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
        dUJ();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nDZ == 4 || this.nDZ == 0) {
            this.nDT.setX(this.nEk);
            this.nDT.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nEl);
            String obj = this.nDW.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nDW.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nDV.setText(a2);
                    this.nDW.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dUJ() {
        if (this.nEo) {
            this.nEo = false;
            this.nDX.setVisibility(8);
            this.nDY.setVisibility(8);
            this.nDU.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUK() {
        if (!this.nEo) {
            this.nEo = true;
            this.nDX.setVisibility(0);
            this.nDY.setVisibility(0);
            this.nDU.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nEz != null) {
            Bitmap bitmap = this.nEz.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nEz.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dUJ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nEi = 1.0f;
                this.mLK = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nEi = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nEd = (this.nEt * 2) + width;
                this.nEe = (this.nEt * 2) + height;
                this.nEh = (this.nEd * 1.0f) / this.nEe;
                this.nDT.setX((((this.mVideoWidth - i2) - (this.nEt * 2)) / 2) + this.nEk);
                this.nDT.setY((((this.mVideoHeight - i) - (this.nEt * 2)) / 2) + this.nEl);
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
                if (motionEvent.getPointerCount() <= 1 && abs < this.iFv && abs2 < this.iFv && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nDV == null || this.nDV.getText() == null) {
            return null;
        }
        return this.nDV.getText().toString();
    }

    public void OR() {
        this.nDV.setText(this.nDW.getText());
        this.nDV.setVisibility(8);
        this.nDW.setVisibility(0);
        setEditTextEnable(true);
        this.nEj.ShowSoftKeyPad(this.nDW);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nDW.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nDV.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nEt = 0;
            this.nDW.setMaxLines(1);
            this.nDV.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDV.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nDW.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nDW.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDV.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nEt = l.getDimens(getContext(), R.dimen.ds40);
            this.nDW.setMaxLines(2);
            this.nDV.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nDV.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nDW.setLayoutParams(layoutParams2);
            this.nEp = (int) (l.dip2px(getContext(), pendantData.left) * this.nEi);
            this.nEq = (int) (l.dip2px(getContext(), pendantData.top) * this.nEi);
            this.nEr = (int) (l.dip2px(getContext(), pendantData.right) * this.nEi);
            this.nEs = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nEi);
            this.mContentView.setPadding(this.nEp, this.nEq, this.nEr, this.nEs);
            this.bHj = l.getDimens(getContext(), R.dimen.fontsize40) * this.nEi;
            String text = getText();
            this.nEu = (i2 - this.nEq) - this.nEs;
            this.nEv = (i - this.nEp) - this.nEr;
            this.nEx = this.nEw + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bHj);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.nEv);
                this.bHj = this.nDW.getTextSize();
                dUK();
                OR();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.nDW.setText(text);
                    this.nDV.setText(text);
                }
                UP(text);
            }
        }
        this.nDV.setIncludeFontPadding(false);
        this.nDW.setIncludeFontPadding(false);
        this.nDV.setLineSpacing(this.nEw, 1.0f);
        this.nDW.setLineSpacing(this.nEw, 1.0f);
        this.nDT.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nDT.getLayoutParams();
        layoutParams3.height = (this.nEt * 2) + i2;
        layoutParams3.width = (this.nEt * 2) + i;
        this.nDT.setLayoutParams(layoutParams3);
        this.nEy = (this.nEt * 2) + i;
        ((FrameLayout.LayoutParams) this.nDU.getLayoutParams()).setMargins(this.nEt, this.nEt, this.nEt, this.nEt);
        this.nDT.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nEA == null) {
            dUL();
        }
        return this.nEA;
    }

    private void dUL() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nEA = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dUM() {
        if (this.nEA != null && !this.nEA.isRecycled()) {
            this.nEA.recycle();
            this.nEA = null;
        }
    }

    public void yG(boolean z) {
        if (this.nDZ != 0) {
            if (z) {
                dUM();
                this.nDT.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nDT.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nEz.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nEz.clear();
        this.nEz = null;
        dUM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a implements b.a {
        WeakReference<a.b> nEC;
        WeakReference<CoverPendantDragView> nED;
        WeakReference<PendantData> nEE;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nEC = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nED = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nEE = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gB(String str, String str2) {
            if (this.nEC != null && this.nEC.get() != null) {
                this.nEC.get().nCT.setVisibility(8);
            }
            if (this.nED != null && this.nED.get() != null && this.nEE != null && this.nEE.get() != null) {
                this.nED.get().a(str2, this.nEE.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void UG(String str) {
            if (this.nEC != null && this.nEC.get() != null) {
                this.nEC.get().nCT.setVisibility(8);
            }
            if (this.nED != null && this.nED.get() != null) {
                l.showToast(this.nED.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dTV() {
            if (this.nEC != null && this.nEC.get() != null) {
                this.nEC.get().nCT.setVisibility(8);
            }
        }
    }
}
