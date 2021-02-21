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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bKT;
    float bqb;
    float bqc;
    private float cEl;
    private float iSV;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mWb;
    private FrameLayout nND;
    private RotateFrameLayout nNE;
    private TextView nNF;
    private EditText nNG;
    private ImageView nNH;
    private ImageView nNI;
    private int nNJ;
    private boolean nNK;
    private float nNL;
    private float nNM;
    private int nNN;
    private int nNO;
    private float nNP;
    private float nNQ;
    private float nNR;
    private float nNS;
    private c nNT;
    private float nNU;
    private float nNV;
    private float nNW;
    private float nNX;
    private boolean nNY;
    private int nNZ;
    private int nOa;
    private int nOb;
    private int nOc;
    private int nOd;
    private float nOe;
    private float nOf;
    private int nOg;
    private float nOh;
    private int nOi;
    private Map<String, Bitmap> nOj;
    private Bitmap nOk;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nNJ = 0;
        this.nNS = 1.0f;
        this.mWb = 1.0f;
        this.nNY = true;
        this.nOj = new HashMap();
        this.startTime = 0L;
        this.bqb = 0.0f;
        this.bqc = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bKT = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nOg = l.getDimens(getContext(), R.dimen.ds2);
        this.iSV = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nND = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nND);
        this.nND.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nNJ == 4) {
                            CoverPendantDragView.this.dTd();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cEl);
                        if (!CoverPendantDragView.this.nNK && abs < CoverPendantDragView.this.iSV && abs2 < CoverPendantDragView.this.iSV && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.LZ();
                        }
                        CoverPendantDragView.this.nNL = 0.0f;
                        CoverPendantDragView.this.nNM = 0.0f;
                        CoverPendantDragView.this.nNK = false;
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
                        CoverPendantDragView.this.nNL = 0.0f;
                        CoverPendantDragView.this.nNM = 0.0f;
                        return true;
                }
            }
        });
        this.nNH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nNG.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nNI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nNM = 0.0f;
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
        this.nNG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nNJ != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nNF.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ag.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nNF.getText().length()) {
                        CoverPendantDragView.this.Ux(obj);
                    } else {
                        CoverPendantDragView.this.Uw(obj);
                    }
                } else {
                    String subStringWithAllOne = ag.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Ux(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nNF.setText(editable.toString());
            }
        });
        this.nNG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nND.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cEl = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cEl;
        this.nNP = (this.nND.getWidth() / 2) + this.nND.getX();
        this.nNQ = (this.nND.getHeight() / 2) + this.nND.getY();
        this.nNF.setText(this.nNG.getText());
        this.nNF.setVisibility(0);
        this.nNG.setVisibility(8);
        setEditTextEnable(false);
        this.nNT.HidenSoftKeyPad(this.nNG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw(String str) {
        TextPaint paint = this.nNG.getPaint();
        float measureText = paint.measureText(str);
        while (this.nNG.getLineCount() == 1 && this.nNG.getTextSize() < this.bKT * this.mWb && measureText < this.nOf * this.mWb) {
            setTextSize(0, this.nNG.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ag.getTextLengthAllOne(str) <= ag.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nNG.getTextSize() != this.bKT * this.mWb) {
            setTextSize(0, this.bKT * this.mWb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ux(String str) {
        TextPaint paint = this.nNG.getPaint();
        float measureText = paint.measureText(str);
        while (this.nNG.getTextSize() > ((this.nOe * this.mWb) / 2.0f) - (this.nOh * this.mWb) && measureText > this.nOf * this.mWb) {
            setTextSize(0, this.nNG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nNG.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nNG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ag.subStringWithEmoji(str, ag.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.nNT = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nNU = f;
        this.nNV = f2;
        this.nNW = f3;
        this.nNX = f4;
        if (this.nNU > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nNU, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nNV > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nNV);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nNW > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nNW) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nNX > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nNX) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nNP - rawX);
        float abs4 = Math.abs(this.nNQ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nNP - this.mLastX);
        float abs6 = Math.abs(this.nNQ - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dy(sqrt, (int) (sqrt / this.nNR));
        if (this.nNM != 0.0f) {
            this.nND.setRotation(this.nND.getRotation() - (this.nNM - ah));
        }
        this.nNM = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dy(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nND.getLayoutParams();
        int width = this.nND.getWidth() - i;
        int i3 = (int) (width / this.nNR);
        if (width < this.nNN) {
            width = this.nNN;
            i3 = (int) (width / this.nNR);
        }
        this.mWb = ((width * 1.0f) - (this.nOd * 2)) / (this.nOi - (this.nOd * 2));
        this.mContentView.setPadding((int) (this.nNZ * this.mWb), (int) (this.nOa * this.mWb), (int) (this.nOb * this.mWb), (int) (this.nOc * this.mWb));
        setTextSize(0, (this.nNG.getTextSize() * i3) / this.nND.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nND.setLayoutParams(layoutParams);
        float f = this.nNP - (layoutParams.width / 2);
        float f2 = this.nNQ - (layoutParams.height / 2);
        this.nND.setX(f);
        this.nND.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nNJ != 4) {
            float y = (this.nND.getY() + rawY) - this.mLastY;
            if (y < this.nNV) {
                y = this.nNV;
            } else if (y > (this.nNV + this.mVideoHeight) - this.nND.getHeight()) {
                y = (this.nNV + this.mVideoHeight) - this.nND.getHeight();
            }
            this.nND.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nNK = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nNL != 0.0f) {
                    int i = (int) (this.nNL - ai);
                    dy(i, (int) (i / this.nNR));
                }
                if (this.nNM != 0.0f) {
                    this.nND.setRotation(this.nND.getRotation() - (this.nNM - ag));
                }
                this.nNM = ag;
                this.nNL = ai;
            } else if (!this.nNK && pointerCount == 1) {
                float y2 = (this.nND.getY() + rawY) - this.mLastY;
                if (y2 < this.nNV - (this.nND.getHeight() / 2)) {
                    y2 = this.nNV - (this.nND.getHeight() / 2);
                } else if (y2 > ((this.nNV + this.mVideoHeight) - this.nND.getHeight()) + (this.nND.getHeight() / 2)) {
                    y2 = ((this.nNV + this.mVideoHeight) - this.nND.getHeight()) + (this.nND.getHeight() / 2);
                }
                float x = (this.nND.getX() + rawX) - this.mLastX;
                if (x < this.nNU - (this.nND.getWidth() / 2)) {
                    x = this.nNU - (this.nND.getWidth() / 2);
                } else if (x > ((this.nNU + this.mVideoWidth) - this.nND.getWidth()) + (this.nND.getWidth() / 2)) {
                    x = ((this.nNU + this.mVideoWidth) - this.nND.getWidth()) + (this.nND.getWidth() / 2);
                }
                this.nND.setX(x);
                this.nND.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nNG.getTextSize() != f) {
            this.nNG.setTextSize(i, f);
        }
        if (this.nNF.getTextSize() != f) {
            this.nNF.setTextSize(i, f);
        }
    }

    private float ag(MotionEvent motionEvent) {
        float[] f = f(motionEvent, 0);
        float f2 = f[0];
        float f3 = f[1];
        float[] f4 = f(motionEvent, 1);
        float f5 = f4[0];
        return (float) Math.toDegrees(Math.atan2(f3 - f4[1], f2 - f5));
    }

    private float[] f(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.nND.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nNQ - motionEvent.getRawY(), this.nNP - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iSV && Math.abs(motionEvent.getRawY() - this.cEl) < this.iSV;
    }

    private void init() {
        this.nNE = (RotateFrameLayout) this.nND.findViewById(R.id.content_container);
        this.nNF = (TextView) this.nND.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nND.findViewById(R.id.content_view);
        this.nNG = (EditText) this.nND.findViewById(R.id.cover_edit);
        this.nNH = (ImageView) this.nND.findViewById(R.id.cover_delete);
        this.nNI = (ImageView) this.nND.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nNF.setText(this.nNG.getText());
        this.nNF.setVisibility(0);
        this.nNG.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nNF.getText())) {
            this.nNJ = 0;
            this.nND.setVisibility(8);
        }
        if (this.nNJ == 4) {
            dTc();
        }
        this.nNT.HidenSoftKeyPad(this.nNG);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nNG.setFocusable(true);
            this.nNG.setFocusableInTouchMode(true);
            this.nNG.requestFocus();
            return;
        }
        this.nNG.setFocusable(false);
        this.nNG.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nNG.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    LZ();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    LZ();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    LZ();
                    break;
                default:
                    hideSoftKeyPad();
                    String Uv = com.baidu.tieba.video.editvideo.model.b.dSX().Uv(pendantData.resource);
                    if (TextUtils.isEmpty(Uv)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nMD.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dSX().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Uv, pendantData);
                        break;
                    }
                    break;
            }
            this.nNJ = pendantData.pendantType;
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
        dTc();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nNJ == 4 || this.nNJ == 0) {
            this.nND.setX(this.nNU);
            this.nND.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nNV);
            String obj = this.nNG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nNG.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nNF.setText(a2);
                    this.nNG.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dTc() {
        if (this.nNY) {
            this.nNY = false;
            this.nNH.setVisibility(8);
            this.nNI.setVisibility(8);
            this.nNE.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTd() {
        if (!this.nNY) {
            this.nNY = true;
            this.nNH.setVisibility(0);
            this.nNI.setVisibility(0);
            this.nNE.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nOj != null) {
            Bitmap bitmap = this.nOj.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nOj.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dTc();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nNS = 1.0f;
                this.mWb = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nNS = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nNN = (this.nOd * 2) + width;
                this.nNO = (this.nOd * 2) + height;
                this.nNR = (this.nNN * 1.0f) / this.nNO;
                this.nND.setX((((this.mVideoWidth - i2) - (this.nOd * 2)) / 2) + this.nNU);
                this.nND.setY((((this.mVideoHeight - i) - (this.nOd * 2)) / 2) + this.nNV);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bqb = motionEvent.getRawX();
                this.bqc = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bqb);
                float abs2 = Math.abs(rawY - this.bqc);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iSV && abs2 < this.iSV && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nNF == null || this.nNF.getText() == null) {
            return null;
        }
        return this.nNF.getText().toString();
    }

    public void LZ() {
        this.nNF.setText(this.nNG.getText());
        this.nNF.setVisibility(8);
        this.nNG.setVisibility(0);
        setEditTextEnable(true);
        this.nNT.ShowSoftKeyPad(this.nNG);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nNG.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nNF.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nOd = 0;
            this.nNG.setMaxLines(1);
            this.nNF.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nNF.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nNG.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nNG.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nNF.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nOd = l.getDimens(getContext(), R.dimen.ds40);
            this.nNG.setMaxLines(2);
            this.nNF.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nNF.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nNG.setLayoutParams(layoutParams2);
            this.nNZ = (int) (l.dip2px(getContext(), pendantData.left) * this.nNS);
            this.nOa = (int) (l.dip2px(getContext(), pendantData.top) * this.nNS);
            this.nOb = (int) (l.dip2px(getContext(), pendantData.right) * this.nNS);
            this.nOc = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nNS);
            this.mContentView.setPadding(this.nNZ, this.nOa, this.nOb, this.nOc);
            this.bKT = l.getDimens(getContext(), R.dimen.fontsize40) * this.nNS;
            String text = getText();
            this.nOe = (i2 - this.nOa) - this.nOc;
            this.nOf = (i - this.nNZ) - this.nOb;
            this.nOh = this.nOg + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bKT);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nOf);
                this.bKT = this.nNG.getTextSize();
                dTd();
                LZ();
            } else {
                if (ag.getTextLengthAllOne(text) > 20) {
                    text = ag.subStringWithAllOne(text, 20);
                    this.nNG.setText(text);
                    this.nNF.setText(text);
                }
                Ux(text);
            }
        }
        this.nNF.setIncludeFontPadding(false);
        this.nNG.setIncludeFontPadding(false);
        this.nNF.setLineSpacing(this.nOg, 1.0f);
        this.nNG.setLineSpacing(this.nOg, 1.0f);
        this.nND.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nND.getLayoutParams();
        layoutParams3.height = (this.nOd * 2) + i2;
        layoutParams3.width = (this.nOd * 2) + i;
        this.nND.setLayoutParams(layoutParams3);
        this.nOi = (this.nOd * 2) + i;
        ((FrameLayout.LayoutParams) this.nNE.getLayoutParams()).setMargins(this.nOd, this.nOd, this.nOd, this.nOd);
        this.nND.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nOk == null) {
            dTe();
        }
        return this.nOk;
    }

    private void dTe() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nOk = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dTf() {
        if (this.nOk != null && !this.nOk.isRecycled()) {
            this.nOk.recycle();
            this.nOk = null;
        }
    }

    public void yY(boolean z) {
        if (this.nNJ != 0) {
            if (z) {
                dTf();
                this.nND.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nND.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nOj.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nOj.clear();
        this.nOj = null;
        dTf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> nOm;
        WeakReference<CoverPendantDragView> nOn;
        WeakReference<PendantData> nOo;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nOm = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nOn = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nOo = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gF(String str, String str2) {
            if (this.nOm != null && this.nOm.get() != null) {
                this.nOm.get().nMD.setVisibility(8);
            }
            if (this.nOn != null && this.nOn.get() != null && this.nOo != null && this.nOo.get() != null) {
                this.nOn.get().a(str2, this.nOo.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Uo(String str) {
            if (this.nOm != null && this.nOm.get() != null) {
                this.nOm.get().nMD.setVisibility(8);
            }
            if (this.nOn != null && this.nOn.get() != null) {
                l.showToast(this.nOn.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dSo() {
            if (this.nOm != null && this.nOm.get() != null) {
                this.nOm.get().nMD.setVisibility(8);
            }
        }
    }
}
