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
import com.baidu.tbadk.core.util.ao;
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
    private float bHj;
    float bmA;
    float bmB;
    private float cBP;
    private float iNa;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private float mMm;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private boolean nDA;
    private float nDB;
    private float nDC;
    private int nDD;
    private int nDE;
    private float nDF;
    private float nDG;
    private float nDH;
    private float nDI;
    private c nDJ;
    private float nDK;
    private float nDL;
    private float nDM;
    private float nDN;
    private boolean nDO;
    private int nDP;
    private int nDQ;
    private int nDR;
    private int nDS;
    private int nDT;
    private float nDU;
    private float nDV;
    private int nDW;
    private float nDX;
    private int nDY;
    private Map<String, Bitmap> nDZ;
    private FrameLayout nDt;
    private RotateFrameLayout nDu;
    private TextView nDv;
    private EditText nDw;
    private ImageView nDx;
    private ImageView nDy;
    private int nDz;
    private Bitmap nEa;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDz = 0;
        this.nDI = 1.0f;
        this.mMm = 1.0f;
        this.nDO = true;
        this.nDZ = new HashMap();
        this.startTime = 0L;
        this.bmA = 0.0f;
        this.bmB = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bHj = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nDW = l.getDimens(getContext(), R.dimen.ds2);
        this.iNa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nDt = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nDt);
        this.nDt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nDz == 4) {
                            CoverPendantDragView.this.dQK();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cBP);
                        if (!CoverPendantDragView.this.nDA && abs < CoverPendantDragView.this.iNa && abs2 < CoverPendantDragView.this.iNa && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.KB();
                        }
                        CoverPendantDragView.this.nDB = 0.0f;
                        CoverPendantDragView.this.nDC = 0.0f;
                        CoverPendantDragView.this.nDA = false;
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
                        CoverPendantDragView.this.nDB = 0.0f;
                        CoverPendantDragView.this.nDC = 0.0f;
                        return true;
                }
            }
        });
        this.nDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nDw.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nDy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nDC = 0.0f;
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
        this.nDw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nDz != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nDv.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nDv.getText().length()) {
                        CoverPendantDragView.this.To(obj);
                    } else {
                        CoverPendantDragView.this.Tn(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.To(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nDv.setText(editable.toString());
            }
        });
        this.nDw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nDt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cBP = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cBP;
        this.nDF = (this.nDt.getWidth() / 2) + this.nDt.getX();
        this.nDG = (this.nDt.getHeight() / 2) + this.nDt.getY();
        this.nDv.setText(this.nDw.getText());
        this.nDv.setVisibility(0);
        this.nDw.setVisibility(8);
        setEditTextEnable(false);
        this.nDJ.HidenSoftKeyPad(this.nDw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn(String str) {
        TextPaint paint = this.nDw.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDw.getLineCount() == 1 && this.nDw.getTextSize() < this.bHj * this.mMm && measureText < this.nDV * this.mMm) {
            setTextSize(0, this.nDw.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nDw.getTextSize() != this.bHj * this.mMm) {
            setTextSize(0, this.bHj * this.mMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To(String str) {
        TextPaint paint = this.nDw.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDw.getTextSize() > ((this.nDU * this.mMm) / 2.0f) - (this.nDX * this.mMm) && measureText > this.nDV * this.mMm) {
            setTextSize(0, this.nDw.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nDw.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nDw.getTextSize() - 1.0f);
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

    public void setParentViewController(c cVar) {
        this.nDJ = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nDK = f;
        this.nDL = f2;
        this.nDM = f3;
        this.nDN = f4;
        if (this.nDK > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nDK, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nDL > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nDL);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nDM > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nDM) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nDN > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nDN) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nDF - rawX);
        float abs4 = Math.abs(this.nDG - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nDF - this.mLastX);
        float abs6 = Math.abs(this.nDG - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dA(sqrt, (int) (sqrt / this.nDH));
        if (this.nDC != 0.0f) {
            this.nDt.setRotation(this.nDt.getRotation() - (this.nDC - ah));
        }
        this.nDC = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDt.getLayoutParams();
        int width = this.nDt.getWidth() - i;
        int i3 = (int) (width / this.nDH);
        if (width < this.nDD) {
            width = this.nDD;
            i3 = (int) (width / this.nDH);
        }
        this.mMm = ((width * 1.0f) - (this.nDT * 2)) / (this.nDY - (this.nDT * 2));
        this.mContentView.setPadding((int) (this.nDP * this.mMm), (int) (this.nDQ * this.mMm), (int) (this.nDR * this.mMm), (int) (this.nDS * this.mMm));
        setTextSize(0, (this.nDw.getTextSize() * i3) / this.nDt.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nDt.setLayoutParams(layoutParams);
        float f = this.nDF - (layoutParams.width / 2);
        float f2 = this.nDG - (layoutParams.height / 2);
        this.nDt.setX(f);
        this.nDt.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nDz != 4) {
            float y = (this.nDt.getY() + rawY) - this.mLastY;
            if (y < this.nDL) {
                y = this.nDL;
            } else if (y > (this.nDL + this.mVideoHeight) - this.nDt.getHeight()) {
                y = (this.nDL + this.mVideoHeight) - this.nDt.getHeight();
            }
            this.nDt.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nDA = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nDB != 0.0f) {
                    int i = (int) (this.nDB - ai);
                    dA(i, (int) (i / this.nDH));
                }
                if (this.nDC != 0.0f) {
                    this.nDt.setRotation(this.nDt.getRotation() - (this.nDC - ag));
                }
                this.nDC = ag;
                this.nDB = ai;
            } else if (!this.nDA && pointerCount == 1) {
                float y2 = (this.nDt.getY() + rawY) - this.mLastY;
                if (y2 < this.nDL - (this.nDt.getHeight() / 2)) {
                    y2 = this.nDL - (this.nDt.getHeight() / 2);
                } else if (y2 > ((this.nDL + this.mVideoHeight) - this.nDt.getHeight()) + (this.nDt.getHeight() / 2)) {
                    y2 = ((this.nDL + this.mVideoHeight) - this.nDt.getHeight()) + (this.nDt.getHeight() / 2);
                }
                float x = (this.nDt.getX() + rawX) - this.mLastX;
                if (x < this.nDK - (this.nDt.getWidth() / 2)) {
                    x = this.nDK - (this.nDt.getWidth() / 2);
                } else if (x > ((this.nDK + this.mVideoWidth) - this.nDt.getWidth()) + (this.nDt.getWidth() / 2)) {
                    x = ((this.nDK + this.mVideoWidth) - this.nDt.getWidth()) + (this.nDt.getWidth() / 2);
                }
                this.nDt.setX(x);
                this.nDt.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nDw.getTextSize() != f) {
            this.nDw.setTextSize(i, f);
        }
        if (this.nDv.getTextSize() != f) {
            this.nDv.setTextSize(i, f);
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
        matrix.postRotate(this.nDt.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nDG - motionEvent.getRawY(), this.nDF - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iNa && Math.abs(motionEvent.getRawY() - this.cBP) < this.iNa;
    }

    private void init() {
        this.nDu = (RotateFrameLayout) this.nDt.findViewById(R.id.content_container);
        this.nDv = (TextView) this.nDt.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nDt.findViewById(R.id.content_view);
        this.nDw = (EditText) this.nDt.findViewById(R.id.cover_edit);
        this.nDx = (ImageView) this.nDt.findViewById(R.id.cover_delete);
        this.nDy = (ImageView) this.nDt.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nDv.setText(this.nDw.getText());
        this.nDv.setVisibility(0);
        this.nDw.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nDv.getText())) {
            this.nDz = 0;
            this.nDt.setVisibility(8);
        }
        if (this.nDz == 4) {
            dQJ();
        }
        this.nDJ.HidenSoftKeyPad(this.nDw);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nDw.setFocusable(true);
            this.nDw.setFocusableInTouchMode(true);
            this.nDw.requestFocus();
            return;
        }
        this.nDw.setFocusable(false);
        this.nDw.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nDw.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    KB();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    KB();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    KB();
                    break;
                default:
                    hideSoftKeyPad();
                    String Tm = com.baidu.tieba.video.editvideo.model.b.dQE().Tm(pendantData.resource);
                    if (TextUtils.isEmpty(Tm)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nCt.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dQE().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Tm, pendantData);
                        break;
                    }
                    break;
            }
            this.nDz = pendantData.pendantType;
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
        dQJ();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nDz == 4 || this.nDz == 0) {
            this.nDt.setX(this.nDK);
            this.nDt.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nDL);
            String obj = this.nDw.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nDw.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nDv.setText(a2);
                    this.nDw.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dQJ() {
        if (this.nDO) {
            this.nDO = false;
            this.nDx.setVisibility(8);
            this.nDy.setVisibility(8);
            this.nDu.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQK() {
        if (!this.nDO) {
            this.nDO = true;
            this.nDx.setVisibility(0);
            this.nDy.setVisibility(0);
            this.nDu.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nDZ != null) {
            Bitmap bitmap = this.nDZ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nDZ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dQJ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nDI = 1.0f;
                this.mMm = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nDI = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nDD = (this.nDT * 2) + width;
                this.nDE = (this.nDT * 2) + height;
                this.nDH = (this.nDD * 1.0f) / this.nDE;
                this.nDt.setX((((this.mVideoWidth - i2) - (this.nDT * 2)) / 2) + this.nDK);
                this.nDt.setY((((this.mVideoHeight - i) - (this.nDT * 2)) / 2) + this.nDL);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bmA = motionEvent.getRawX();
                this.bmB = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bmA);
                float abs2 = Math.abs(rawY - this.bmB);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iNa && abs2 < this.iNa && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nDv == null || this.nDv.getText() == null) {
            return null;
        }
        return this.nDv.getText().toString();
    }

    public void KB() {
        this.nDv.setText(this.nDw.getText());
        this.nDv.setVisibility(8);
        this.nDw.setVisibility(0);
        setEditTextEnable(true);
        this.nDJ.ShowSoftKeyPad(this.nDw);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nDw.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nDv.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nDT = 0;
            this.nDw.setMaxLines(1);
            this.nDv.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDv.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nDw.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nDw.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDv.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDT = l.getDimens(getContext(), R.dimen.ds40);
            this.nDw.setMaxLines(2);
            this.nDv.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nDv.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nDw.setLayoutParams(layoutParams2);
            this.nDP = (int) (l.dip2px(getContext(), pendantData.left) * this.nDI);
            this.nDQ = (int) (l.dip2px(getContext(), pendantData.top) * this.nDI);
            this.nDR = (int) (l.dip2px(getContext(), pendantData.right) * this.nDI);
            this.nDS = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nDI);
            this.mContentView.setPadding(this.nDP, this.nDQ, this.nDR, this.nDS);
            this.bHj = l.getDimens(getContext(), R.dimen.fontsize40) * this.nDI;
            String text = getText();
            this.nDU = (i2 - this.nDQ) - this.nDS;
            this.nDV = (i - this.nDP) - this.nDR;
            this.nDX = this.nDW + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bHj);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nDV);
                this.bHj = this.nDw.getTextSize();
                dQK();
                KB();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.nDw.setText(text);
                    this.nDv.setText(text);
                }
                To(text);
            }
        }
        this.nDv.setIncludeFontPadding(false);
        this.nDw.setIncludeFontPadding(false);
        this.nDv.setLineSpacing(this.nDW, 1.0f);
        this.nDw.setLineSpacing(this.nDW, 1.0f);
        this.nDt.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nDt.getLayoutParams();
        layoutParams3.height = (this.nDT * 2) + i2;
        layoutParams3.width = (this.nDT * 2) + i;
        this.nDt.setLayoutParams(layoutParams3);
        this.nDY = (this.nDT * 2) + i;
        ((FrameLayout.LayoutParams) this.nDu.getLayoutParams()).setMargins(this.nDT, this.nDT, this.nDT, this.nDT);
        this.nDt.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nEa == null) {
            dQL();
        }
        return this.nEa;
    }

    private void dQL() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nEa = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dQM() {
        if (this.nEa != null && !this.nEa.isRecycled()) {
            this.nEa.recycle();
            this.nEa = null;
        }
    }

    public void yF(boolean z) {
        if (this.nDz != 0) {
            if (z) {
                dQM();
                this.nDt.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nDt.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nDZ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nDZ.clear();
        this.nDZ = null;
        dQM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements b.a {
        WeakReference<a.b> nEc;
        WeakReference<CoverPendantDragView> nEd;
        WeakReference<PendantData> nEe;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nEc = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nEd = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nEe = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gx(String str, String str2) {
            if (this.nEc != null && this.nEc.get() != null) {
                this.nEc.get().nCt.setVisibility(8);
            }
            if (this.nEd != null && this.nEd.get() != null && this.nEe != null && this.nEe.get() != null) {
                this.nEd.get().a(str2, this.nEe.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Tf(String str) {
            if (this.nEc != null && this.nEc.get() != null) {
                this.nEc.get().nCt.setVisibility(8);
            }
            if (this.nEd != null && this.nEd.get() != null) {
                l.showToast(this.nEd.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dPV() {
            if (this.nEc != null && this.nEc.get() != null) {
                this.nEc.get().nCt.setVisibility(8);
            }
        }
    }
}
