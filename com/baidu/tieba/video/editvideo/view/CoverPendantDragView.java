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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Vq;
    private float Vr;
    private float bdb;
    private float gZN;
    private float kNw;
    private EditText lCA;
    private ImageView lCB;
    private ImageView lCC;
    private int lCD;
    private boolean lCE;
    private float lCF;
    private float lCG;
    private int lCH;
    private int lCI;
    private float lCJ;
    private float lCK;
    private float lCL;
    private float lCM;
    private b lCN;
    private float lCO;
    private float lCP;
    private float lCQ;
    private float lCR;
    private boolean lCS;
    private int lCT;
    private int lCU;
    private int lCV;
    private int lCW;
    private int lCX;
    private float lCY;
    private float lCZ;
    private FrameLayout lCx;
    private RotateFrameLayout lCy;
    private TextView lCz;
    private int lDa;
    private float lDb;
    private int lDc;
    private Map<String, Bitmap> lDd;
    private Bitmap lDe;
    float lDf;
    float lDg;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
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
        this.lCD = 0;
        this.lCM = 1.0f;
        this.kNw = 1.0f;
        this.lCS = true;
        this.lDd = new HashMap();
        this.startTime = 0L;
        this.lDf = 0.0f;
        this.lDg = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bdb = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lDa = l.getDimens(getContext(), R.dimen.ds2);
        this.gZN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.lCx = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.lCx);
        this.lCx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.lCD == 4) {
                            CoverPendantDragView.this.diL();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.lCE && abs < CoverPendantDragView.this.gZN && abs2 < CoverPendantDragView.this.gZN && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Ek();
                        }
                        CoverPendantDragView.this.lCF = 0.0f;
                        CoverPendantDragView.this.lCG = 0.0f;
                        CoverPendantDragView.this.lCE = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
                            CoverPendantDragView.this.L(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.lCF = 0.0f;
                        CoverPendantDragView.this.lCG = 0.0f;
                        return true;
                }
            }
        });
        this.lCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.lCA.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.lCC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.lCG = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
                            CoverPendantDragView.this.K(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.lCA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.lCD != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.lCz.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.lCz.getText().length()) {
                        CoverPendantDragView.this.NE(obj);
                    } else {
                        CoverPendantDragView.this.ND(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.NE(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.lCz.setText(editable.toString());
            }
        });
        this.lCA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.lCx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.Vq = this.mDownX;
        this.Vr = this.mDownY;
        this.lCJ = (this.lCx.getWidth() / 2) + this.lCx.getX();
        this.lCK = (this.lCx.getHeight() / 2) + this.lCx.getY();
        this.lCz.setText(this.lCA.getText());
        this.lCz.setVisibility(0);
        this.lCA.setVisibility(8);
        setEditTextEnable(false);
        this.lCN.HidenSoftKeyPad(this.lCA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(String str) {
        TextPaint paint = this.lCA.getPaint();
        float measureText = paint.measureText(str);
        while (this.lCA.getLineCount() == 1 && this.lCA.getTextSize() < this.bdb * this.kNw && measureText < this.lCZ * this.kNw) {
            setTextSize(0, this.lCA.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.lCA.getTextSize() != this.bdb * this.kNw) {
            setTextSize(0, this.bdb * this.kNw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NE(String str) {
        TextPaint paint = this.lCA.getPaint();
        float measureText = paint.measureText(str);
        while (this.lCA.getTextSize() > ((this.lCY * this.kNw) / 2.0f) - (this.lDb * this.kNw) && measureText > this.lCZ * this.kNw) {
            setTextSize(0, this.lCA.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.lCA.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.lCA.getTextSize() - 1.0f);
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

    public void setParentViewController(b bVar) {
        this.lCN = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.lCO = f;
        this.lCP = f2;
        this.lCQ = f3;
        this.lCR = f4;
        if (this.lCO > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.lCO, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lCP > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lCP);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lCQ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lCQ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lCR > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lCR) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float N = N(motionEvent);
        float abs = Math.abs(this.Vq - rawX);
        float abs2 = Math.abs(this.Vr - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.lCJ - rawX);
        float abs4 = Math.abs(this.lCK - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.lCJ - this.Vq);
        float abs6 = Math.abs(this.lCK - this.Vr);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        da(sqrt, (int) (sqrt / this.lCL));
        if (this.lCG != 0.0f) {
            this.lCx.setRotation(this.lCx.getRotation() - (this.lCG - N));
        }
        this.lCG = N;
        this.Vq = rawX;
        this.Vr = rawY;
    }

    private void da(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lCx.getLayoutParams();
        int width = this.lCx.getWidth() - i;
        int i3 = (int) (width / this.lCL);
        if (width < this.lCH) {
            width = this.lCH;
            i3 = (int) (width / this.lCL);
        }
        this.kNw = ((width * 1.0f) - (this.lCX * 2)) / (this.lDc - (this.lCX * 2));
        this.mContentView.setPadding((int) (this.lCT * this.kNw), (int) (this.lCU * this.kNw), (int) (this.lCV * this.kNw), (int) (this.lCW * this.kNw));
        setTextSize(0, (this.lCA.getTextSize() * i3) / this.lCx.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.lCx.setLayoutParams(layoutParams);
        float f = this.lCJ - (layoutParams.width / 2);
        float f2 = this.lCK - (layoutParams.height / 2);
        this.lCx.setX(f);
        this.lCx.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.lCD != 4) {
            float y = (this.lCx.getY() + rawY) - this.Vr;
            if (y < this.lCP) {
                y = this.lCP;
            } else if (y > (this.lCP + this.mVideoHeight) - this.lCx.getHeight()) {
                y = (this.lCP + this.mVideoHeight) - this.lCx.getHeight();
            }
            this.lCx.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.lCE = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.lCF != 0.0f) {
                    int i = (int) (this.lCF - O);
                    da(i, (int) (i / this.lCL));
                }
                if (this.lCG != 0.0f) {
                    this.lCx.setRotation(this.lCx.getRotation() - (this.lCG - M));
                }
                this.lCG = M;
                this.lCF = O;
            } else if (!this.lCE && pointerCount == 1) {
                float y2 = (this.lCx.getY() + rawY) - this.Vr;
                if (y2 < this.lCP - (this.lCx.getHeight() / 2)) {
                    y2 = this.lCP - (this.lCx.getHeight() / 2);
                } else if (y2 > ((this.lCP + this.mVideoHeight) - this.lCx.getHeight()) + (this.lCx.getHeight() / 2)) {
                    y2 = ((this.lCP + this.mVideoHeight) - this.lCx.getHeight()) + (this.lCx.getHeight() / 2);
                }
                float x = (this.lCx.getX() + rawX) - this.Vq;
                if (x < this.lCO - (this.lCx.getWidth() / 2)) {
                    x = this.lCO - (this.lCx.getWidth() / 2);
                } else if (x > ((this.lCO + this.mVideoWidth) - this.lCx.getWidth()) + (this.lCx.getWidth() / 2)) {
                    x = ((this.lCO + this.mVideoWidth) - this.lCx.getWidth()) + (this.lCx.getWidth() / 2);
                }
                this.lCx.setX(x);
                this.lCx.setY(y2);
            }
        }
        this.Vq = rawX;
        this.Vr = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.lCA.getTextSize() != f) {
            this.lCA.setTextSize(i, f);
        }
        if (this.lCz.getTextSize() != f) {
            this.lCz.setTextSize(i, f);
        }
    }

    private float M(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.lCx.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.lCK - motionEvent.getRawY(), this.lCJ - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gZN && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gZN;
    }

    private void init() {
        this.lCy = (RotateFrameLayout) this.lCx.findViewById(R.id.content_container);
        this.lCz = (TextView) this.lCx.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.lCx.findViewById(R.id.content_view);
        this.lCA = (EditText) this.lCx.findViewById(R.id.cover_edit);
        this.lCB = (ImageView) this.lCx.findViewById(R.id.cover_delete);
        this.lCC = (ImageView) this.lCx.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.lCz.setText(this.lCA.getText());
        this.lCz.setVisibility(0);
        this.lCA.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.lCz.getText())) {
            this.lCD = 0;
            this.lCx.setVisibility(8);
        }
        if (this.lCD == 4) {
            diK();
        }
        this.lCN.HidenSoftKeyPad(this.lCA);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.lCA.setFocusable(true);
            this.lCA.setFocusableInTouchMode(true);
            this.lCA.requestFocus();
            return;
        }
        this.lCA.setFocusable(false);
        this.lCA.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.lCA.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Ek();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Ek();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Ek();
                    break;
                default:
                    hideSoftKeyPad();
                    String NC = com.baidu.tieba.video.editvideo.model.b.diF().NC(pendantData.resource);
                    if (TextUtils.isEmpty(NC)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.lBw.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.diF().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(NC, pendantData);
                        break;
                    }
                    break;
            }
            this.lCD = pendantData.pendantType;
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
        diK();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.lCD == 4 || this.lCD == 0) {
            this.lCx.setX(this.lCO);
            this.lCx.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lCP);
            String obj = this.lCA.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.lCA.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.lCz.setText(a2);
                    this.lCA.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void diK() {
        if (this.lCS) {
            this.lCS = false;
            this.lCB.setVisibility(8);
            this.lCC.setVisibility(8);
            this.lCy.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diL() {
        if (!this.lCS) {
            this.lCS = true;
            this.lCB.setVisibility(0);
            this.lCC.setVisibility(0);
            this.lCy.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lDd != null) {
            Bitmap bitmap = this.lDd.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lDd.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                diK();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.lCM = 1.0f;
                this.kNw = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.lCM = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.lCH = (this.lCX * 2) + width;
                this.lCI = (this.lCX * 2) + height;
                this.lCL = (this.lCH * 1.0f) / this.lCI;
                this.lCx.setX((((this.mVideoWidth - i2) - (this.lCX * 2)) / 2) + this.lCO);
                this.lCx.setY((((this.mVideoHeight - i) - (this.lCX * 2)) / 2) + this.lCP);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lDf = motionEvent.getRawX();
                this.lDg = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lDf);
                float abs2 = Math.abs(rawY - this.lDg);
                if (motionEvent.getPointerCount() <= 1 && abs < this.gZN && abs2 < this.gZN && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.lCz == null || this.lCz.getText() == null) {
            return null;
        }
        return this.lCz.getText().toString();
    }

    public void Ek() {
        this.lCz.setText(this.lCA.getText());
        this.lCz.setVisibility(8);
        this.lCA.setVisibility(0);
        setEditTextEnable(true);
        this.lCN.ShowSoftKeyPad(this.lCA);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.lCA.setTextAppearance(getContext(), R.style.cover_text_style);
            this.lCz.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lCX = 0;
            this.lCA.setMaxLines(1);
            this.lCz.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lCz.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.lCA.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.lCA.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lCz.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lCX = l.getDimens(getContext(), R.dimen.ds40);
            this.lCA.setMaxLines(2);
            this.lCz.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lCz.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.lCA.setLayoutParams(layoutParams2);
            this.lCT = (int) (l.dip2px(getContext(), pendantData.left) * this.lCM);
            this.lCU = (int) (l.dip2px(getContext(), pendantData.f1025top) * this.lCM);
            this.lCV = (int) (l.dip2px(getContext(), pendantData.right) * this.lCM);
            this.lCW = (int) (l.dip2px(getContext(), pendantData.bottom) * this.lCM);
            this.mContentView.setPadding(this.lCT, this.lCU, this.lCV, this.lCW);
            this.bdb = l.getDimens(getContext(), R.dimen.fontsize40) * this.lCM;
            String text = getText();
            this.lCY = (i2 - this.lCU) - this.lCW;
            this.lCZ = (i - this.lCT) - this.lCV;
            this.lDb = this.lDa + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bdb);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lCZ);
                this.bdb = this.lCA.getTextSize();
                diL();
                Ek();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.lCA.setText(text);
                    this.lCz.setText(text);
                }
                NE(text);
            }
        }
        this.lCz.setIncludeFontPadding(false);
        this.lCA.setIncludeFontPadding(false);
        this.lCz.setLineSpacing(this.lDa, 1.0f);
        this.lCA.setLineSpacing(this.lDa, 1.0f);
        this.lCx.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.lCx.getLayoutParams();
        layoutParams3.height = (this.lCX * 2) + i2;
        layoutParams3.width = (this.lCX * 2) + i;
        this.lCx.setLayoutParams(layoutParams3);
        this.lDc = (this.lCX * 2) + i;
        ((FrameLayout.LayoutParams) this.lCy.getLayoutParams()).setMargins(this.lCX, this.lCX, this.lCX, this.lCX);
        this.lCx.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lDe == null) {
            diM();
        }
        return this.lDe;
    }

    private void diM() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lDe = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void diN() {
        if (this.lDe != null && !this.lDe.isRecycled()) {
            this.lDe.recycle();
            this.lDe = null;
        }
    }

    public void uT(boolean z) {
        if (this.lCD != 0) {
            if (z) {
                diN();
                this.lCx.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.lCx.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lDd.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lDd.clear();
        this.lDd = null;
        diN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lDi;
        WeakReference<CoverPendantDragView> lDj;
        WeakReference<PendantData> lDk;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lDi = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lDj = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lDk = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fx(String str, String str2) {
            if (this.lDi != null && this.lDi.get() != null) {
                this.lDi.get().lBw.setVisibility(8);
            }
            if (this.lDj != null && this.lDj.get() != null && this.lDk != null && this.lDk.get() != null) {
                this.lDj.get().a(str2, this.lDk.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Nt(String str) {
            if (this.lDi != null && this.lDi.get() != null) {
                this.lDi.get().lBw.setVisibility(8);
            }
            if (this.lDj != null && this.lDj.get() != null) {
                l.showToast(this.lDj.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dhT() {
            if (this.lDi != null && this.lDi.get() != null) {
                this.lDi.get().lBw.setVisibility(8);
            }
        }
    }
}
