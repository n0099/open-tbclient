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
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes22.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bVQ;
    private float brz;
    private float hMt;
    private float lPv;
    private FrameLayout mContentView;
    private float mDownX;
    private RotateFrameLayout mGA;
    private TextView mGB;
    private EditText mGC;
    private ImageView mGD;
    private ImageView mGE;
    private int mGF;
    private boolean mGG;
    private float mGH;
    private float mGI;
    private int mGJ;
    private int mGK;
    private float mGL;
    private float mGM;
    private float mGN;
    private float mGO;
    private c mGP;
    private float mGQ;
    private float mGR;
    private float mGS;
    private float mGT;
    private boolean mGU;
    private int mGV;
    private int mGW;
    private int mGX;
    private int mGY;
    private int mGZ;
    private FrameLayout mGz;
    private float mHa;
    private float mHb;
    private int mHc;
    private float mHd;
    private int mHe;
    private Map<String, Bitmap> mHf;
    private Bitmap mHg;
    float mHh;
    float mHi;
    private float mLastX;
    private float mLastY;
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
        this.mGF = 0;
        this.mGO = 1.0f;
        this.lPv = 1.0f;
        this.mGU = true;
        this.mHf = new HashMap();
        this.startTime = 0L;
        this.mHh = 0.0f;
        this.mHi = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.brz = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mHc = l.getDimens(getContext(), R.dimen.ds2);
        this.hMt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mGz = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.mGz);
        this.mGz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.mGF == 4) {
                            CoverPendantDragView.this.dFW();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.bVQ);
                        if (!CoverPendantDragView.this.mGG && abs < CoverPendantDragView.this.hMt && abs2 < CoverPendantDragView.this.hMt && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Lg();
                        }
                        CoverPendantDragView.this.mGH = 0.0f;
                        CoverPendantDragView.this.mGI = 0.0f;
                        CoverPendantDragView.this.mGG = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.aa(motionEvent)) {
                            CoverPendantDragView.this.ae(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.mGH = 0.0f;
                        CoverPendantDragView.this.mGI = 0.0f;
                        return true;
                }
            }
        });
        this.mGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.mGC.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.mGE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.mGI = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.aa(motionEvent)) {
                            CoverPendantDragView.this.ad(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.mGC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.mGF != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.mGB.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (af.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.mGB.getText().length()) {
                        CoverPendantDragView.this.Sl(obj);
                    } else {
                        CoverPendantDragView.this.Sk(obj);
                    }
                } else {
                    String subStringWithAllOne = af.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Sl(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.mGB.setText(editable.toString());
            }
        });
        this.mGC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.mGz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.bVQ = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.bVQ;
        this.mGL = (this.mGz.getWidth() / 2) + this.mGz.getX();
        this.mGM = (this.mGz.getHeight() / 2) + this.mGz.getY();
        this.mGB.setText(this.mGC.getText());
        this.mGB.setVisibility(0);
        this.mGC.setVisibility(8);
        setEditTextEnable(false);
        this.mGP.HidenSoftKeyPad(this.mGC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sk(String str) {
        TextPaint paint = this.mGC.getPaint();
        float measureText = paint.measureText(str);
        while (this.mGC.getLineCount() == 1 && this.mGC.getTextSize() < this.brz * this.lPv && measureText < this.mHb * this.lPv) {
            setTextSize(0, this.mGC.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (af.getTextLengthAllOne(str) <= af.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.mGC.getTextSize() != this.brz * this.lPv) {
            setTextSize(0, this.brz * this.lPv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sl(String str) {
        TextPaint paint = this.mGC.getPaint();
        float measureText = paint.measureText(str);
        while (this.mGC.getTextSize() > ((this.mHa * this.lPv) / 2.0f) - (this.mHd * this.lPv) && measureText > this.mHb * this.lPv) {
            setTextSize(0, this.mGC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.mGC.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.mGC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = af.subStringWithEmoji(str, af.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.mGP = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mGQ = f;
        this.mGR = f2;
        this.mGS = f3;
        this.mGT = f4;
        if (this.mGQ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mGQ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mGR > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mGR);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mGS > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mGS) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mGT > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mGT) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float ag = ag(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.mGL - rawX);
        float abs4 = Math.abs(this.mGM - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.mGL - this.mLastX);
        float abs6 = Math.abs(this.mGM - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        du(sqrt, (int) (sqrt / this.mGN));
        if (this.mGI != 0.0f) {
            this.mGz.setRotation(this.mGz.getRotation() - (this.mGI - ag));
        }
        this.mGI = ag;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void du(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGz.getLayoutParams();
        int width = this.mGz.getWidth() - i;
        int i3 = (int) (width / this.mGN);
        if (width < this.mGJ) {
            width = this.mGJ;
            i3 = (int) (width / this.mGN);
        }
        this.lPv = ((width * 1.0f) - (this.mGZ * 2)) / (this.mHe - (this.mGZ * 2));
        this.mContentView.setPadding((int) (this.mGV * this.lPv), (int) (this.mGW * this.lPv), (int) (this.mGX * this.lPv), (int) (this.mGY * this.lPv));
        setTextSize(0, (this.mGC.getTextSize() * i3) / this.mGz.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.mGz.setLayoutParams(layoutParams);
        float f = this.mGL - (layoutParams.width / 2);
        float f2 = this.mGM - (layoutParams.height / 2);
        this.mGz.setX(f);
        this.mGz.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.mGF != 4) {
            float y = (this.mGz.getY() + rawY) - this.mLastY;
            if (y < this.mGR) {
                y = this.mGR;
            } else if (y > (this.mGR + this.mVideoHeight) - this.mGz.getHeight()) {
                y = (this.mGR + this.mVideoHeight) - this.mGz.getHeight();
            }
            this.mGz.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.mGG = true;
                float ah = ah(motionEvent);
                float af = af(motionEvent);
                if (this.mGH != 0.0f) {
                    int i = (int) (this.mGH - ah);
                    du(i, (int) (i / this.mGN));
                }
                if (this.mGI != 0.0f) {
                    this.mGz.setRotation(this.mGz.getRotation() - (this.mGI - af));
                }
                this.mGI = af;
                this.mGH = ah;
            } else if (!this.mGG && pointerCount == 1) {
                float y2 = (this.mGz.getY() + rawY) - this.mLastY;
                if (y2 < this.mGR - (this.mGz.getHeight() / 2)) {
                    y2 = this.mGR - (this.mGz.getHeight() / 2);
                } else if (y2 > ((this.mGR + this.mVideoHeight) - this.mGz.getHeight()) + (this.mGz.getHeight() / 2)) {
                    y2 = ((this.mGR + this.mVideoHeight) - this.mGz.getHeight()) + (this.mGz.getHeight() / 2);
                }
                float x = (this.mGz.getX() + rawX) - this.mLastX;
                if (x < this.mGQ - (this.mGz.getWidth() / 2)) {
                    x = this.mGQ - (this.mGz.getWidth() / 2);
                } else if (x > ((this.mGQ + this.mVideoWidth) - this.mGz.getWidth()) + (this.mGz.getWidth() / 2)) {
                    x = ((this.mGQ + this.mVideoWidth) - this.mGz.getWidth()) + (this.mGz.getWidth() / 2);
                }
                this.mGz.setX(x);
                this.mGz.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.mGC.getTextSize() != f) {
            this.mGC.setTextSize(i, f);
        }
        if (this.mGB.getTextSize() != f) {
            this.mGB.setTextSize(i, f);
        }
    }

    private float af(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.mGz.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ag(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.mGM - motionEvent.getRawY(), this.mGL - motionEvent.getRawX()));
    }

    private float ah(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hMt && Math.abs(motionEvent.getRawY() - this.bVQ) < this.hMt;
    }

    private void init() {
        this.mGA = (RotateFrameLayout) this.mGz.findViewById(R.id.content_container);
        this.mGB = (TextView) this.mGz.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.mGz.findViewById(R.id.content_view);
        this.mGC = (EditText) this.mGz.findViewById(R.id.cover_edit);
        this.mGD = (ImageView) this.mGz.findViewById(R.id.cover_delete);
        this.mGE = (ImageView) this.mGz.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.mGB.setText(this.mGC.getText());
        this.mGB.setVisibility(0);
        this.mGC.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.mGB.getText())) {
            this.mGF = 0;
            this.mGz.setVisibility(8);
        }
        if (this.mGF == 4) {
            dFV();
        }
        this.mGP.HidenSoftKeyPad(this.mGC);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.mGC.setFocusable(true);
            this.mGC.setFocusableInTouchMode(true);
            this.mGC.requestFocus();
            return;
        }
        this.mGC.setFocusable(false);
        this.mGC.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.mGC.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Lg();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Lg();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Lg();
                    break;
                default:
                    hideSoftKeyPad();
                    String Sj = com.baidu.tieba.video.editvideo.model.b.dFQ().Sj(pendantData.resource);
                    if (TextUtils.isEmpty(Sj)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mFy.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dFQ().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Sj, pendantData);
                        break;
                    }
                    break;
            }
            this.mGF = pendantData.pendantType;
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
        dFV();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.mGF == 4 || this.mGF == 0) {
            this.mGz.setX(this.mGQ);
            this.mGz.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mGR);
            String obj = this.mGC.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.mGC.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.mGB.setText(a2);
                    this.mGC.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dFV() {
        if (this.mGU) {
            this.mGU = false;
            this.mGD.setVisibility(8);
            this.mGE.setVisibility(8);
            this.mGA.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFW() {
        if (!this.mGU) {
            this.mGU = true;
            this.mGD.setVisibility(0);
            this.mGE.setVisibility(0);
            this.mGA.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mHf != null) {
            Bitmap bitmap = this.mHf.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mHf.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dFV();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.mGO = 1.0f;
                this.lPv = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.mGO = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.mGJ = (this.mGZ * 2) + width;
                this.mGK = (this.mGZ * 2) + height;
                this.mGN = (this.mGJ * 1.0f) / this.mGK;
                this.mGz.setX((((this.mVideoWidth - i2) - (this.mGZ * 2)) / 2) + this.mGQ);
                this.mGz.setY((((this.mVideoHeight - i) - (this.mGZ * 2)) / 2) + this.mGR);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.mHh = motionEvent.getRawX();
                this.mHi = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.mHh);
                float abs2 = Math.abs(rawY - this.mHi);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hMt && abs2 < this.hMt && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.mGB == null || this.mGB.getText() == null) {
            return null;
        }
        return this.mGB.getText().toString();
    }

    public void Lg() {
        this.mGB.setText(this.mGC.getText());
        this.mGB.setVisibility(8);
        this.mGC.setVisibility(0);
        setEditTextEnable(true);
        this.mGP.ShowSoftKeyPad(this.mGC);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.mGC.setTextAppearance(getContext(), R.style.cover_text_style);
            this.mGB.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mGZ = 0;
            this.mGC.setMaxLines(1);
            this.mGB.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGB.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.mGC.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.mGC.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mGB.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mGZ = l.getDimens(getContext(), R.dimen.ds40);
            this.mGC.setMaxLines(2);
            this.mGB.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mGB.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.mGC.setLayoutParams(layoutParams2);
            this.mGV = (int) (l.dip2px(getContext(), pendantData.left) * this.mGO);
            this.mGW = (int) (l.dip2px(getContext(), pendantData.top) * this.mGO);
            this.mGX = (int) (l.dip2px(getContext(), pendantData.right) * this.mGO);
            this.mGY = (int) (l.dip2px(getContext(), pendantData.bottom) * this.mGO);
            this.mContentView.setPadding(this.mGV, this.mGW, this.mGX, this.mGY);
            this.brz = l.getDimens(getContext(), R.dimen.fontsize40) * this.mGO;
            String text = getText();
            this.mHa = (i2 - this.mGW) - this.mGY;
            this.mHb = (i - this.mGV) - this.mGX;
            this.mHd = this.mHc + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.brz);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mHb);
                this.brz = this.mGC.getTextSize();
                dFW();
                Lg();
            } else {
                if (af.getTextLengthAllOne(text) > 20) {
                    text = af.subStringWithAllOne(text, 20);
                    this.mGC.setText(text);
                    this.mGB.setText(text);
                }
                Sl(text);
            }
        }
        this.mGB.setIncludeFontPadding(false);
        this.mGC.setIncludeFontPadding(false);
        this.mGB.setLineSpacing(this.mHc, 1.0f);
        this.mGC.setLineSpacing(this.mHc, 1.0f);
        this.mGz.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mGz.getLayoutParams();
        layoutParams3.height = (this.mGZ * 2) + i2;
        layoutParams3.width = (this.mGZ * 2) + i;
        this.mGz.setLayoutParams(layoutParams3);
        this.mHe = (this.mGZ * 2) + i;
        ((FrameLayout.LayoutParams) this.mGA.getLayoutParams()).setMargins(this.mGZ, this.mGZ, this.mGZ, this.mGZ);
        this.mGz.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mHg == null) {
            dFX();
        }
        return this.mHg;
    }

    private void dFX() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mHg = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dFY() {
        if (this.mHg != null && !this.mHg.isRecycled()) {
            this.mHg.recycle();
            this.mHg = null;
        }
    }

    public void wN(boolean z) {
        if (this.mGF != 0) {
            if (z) {
                dFY();
                this.mGz.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.mGz.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mHf.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mHf.clear();
        this.mHf = null;
        dFY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements b.a {
        WeakReference<a.b> mHk;
        WeakReference<CoverPendantDragView> mHl;
        WeakReference<PendantData> mHm;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mHk = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mHl = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mHm = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gk(String str, String str2) {
            if (this.mHk != null && this.mHk.get() != null) {
                this.mHk.get().mFy.setVisibility(8);
            }
            if (this.mHl != null && this.mHl.get() != null && this.mHm != null && this.mHm.get() != null) {
                this.mHl.get().a(str2, this.mHm.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Sc(String str) {
            if (this.mHk != null && this.mHk.get() != null) {
                this.mHk.get().mFy.setVisibility(8);
            }
            if (this.mHl != null && this.mHl.get() != null) {
                l.showToast(this.mHl.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dFh() {
            if (this.mHk != null && this.mHk.get() != null) {
                this.mHk.get().mFy.setVisibility(8);
            }
        }
    }
}
