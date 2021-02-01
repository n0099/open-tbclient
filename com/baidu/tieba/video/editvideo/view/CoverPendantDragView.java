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
    private float iSH;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private float mVB;
    private int mVideoHeight;
    private int mVideoWidth;
    private int nNA;
    private int nNB;
    private int nNC;
    private int nND;
    private float nNE;
    private float nNF;
    private int nNG;
    private float nNH;
    private int nNI;
    private Map<String, Bitmap> nNJ;
    private Bitmap nNK;
    private FrameLayout nNd;
    private RotateFrameLayout nNe;
    private TextView nNf;
    private EditText nNg;
    private ImageView nNh;
    private ImageView nNi;
    private int nNj;
    private boolean nNk;
    private float nNl;
    private float nNm;
    private int nNn;
    private int nNo;
    private float nNp;
    private float nNq;
    private float nNr;
    private float nNs;
    private c nNt;
    private float nNu;
    private float nNv;
    private float nNw;
    private float nNx;
    private boolean nNy;
    private int nNz;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nNj = 0;
        this.nNs = 1.0f;
        this.mVB = 1.0f;
        this.nNy = true;
        this.nNJ = new HashMap();
        this.startTime = 0L;
        this.bqb = 0.0f;
        this.bqc = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bKT = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nNG = l.getDimens(getContext(), R.dimen.ds2);
        this.iSH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nNd = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nNd);
        this.nNd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nNj == 4) {
                            CoverPendantDragView.this.dSV();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cEl);
                        if (!CoverPendantDragView.this.nNk && abs < CoverPendantDragView.this.iSH && abs2 < CoverPendantDragView.this.iSH && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.LZ();
                        }
                        CoverPendantDragView.this.nNl = 0.0f;
                        CoverPendantDragView.this.nNm = 0.0f;
                        CoverPendantDragView.this.nNk = false;
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
                        CoverPendantDragView.this.nNl = 0.0f;
                        CoverPendantDragView.this.nNm = 0.0f;
                        return true;
                }
            }
        });
        this.nNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nNg.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nNi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nNm = 0.0f;
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
        this.nNg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nNj != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nNf.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ag.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nNf.getText().length()) {
                        CoverPendantDragView.this.Ul(obj);
                    } else {
                        CoverPendantDragView.this.Uk(obj);
                    }
                } else {
                    String subStringWithAllOne = ag.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Ul(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nNf.setText(editable.toString());
            }
        });
        this.nNg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nNd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cEl = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cEl;
        this.nNp = (this.nNd.getWidth() / 2) + this.nNd.getX();
        this.nNq = (this.nNd.getHeight() / 2) + this.nNd.getY();
        this.nNf.setText(this.nNg.getText());
        this.nNf.setVisibility(0);
        this.nNg.setVisibility(8);
        setEditTextEnable(false);
        this.nNt.HidenSoftKeyPad(this.nNg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk(String str) {
        TextPaint paint = this.nNg.getPaint();
        float measureText = paint.measureText(str);
        while (this.nNg.getLineCount() == 1 && this.nNg.getTextSize() < this.bKT * this.mVB && measureText < this.nNF * this.mVB) {
            setTextSize(0, this.nNg.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ag.getTextLengthAllOne(str) <= ag.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nNg.getTextSize() != this.bKT * this.mVB) {
            setTextSize(0, this.bKT * this.mVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul(String str) {
        TextPaint paint = this.nNg.getPaint();
        float measureText = paint.measureText(str);
        while (this.nNg.getTextSize() > ((this.nNE * this.mVB) / 2.0f) - (this.nNH * this.mVB) && measureText > this.nNF * this.mVB) {
            setTextSize(0, this.nNg.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nNg.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nNg.getTextSize() - 1.0f);
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
        this.nNt = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nNu = f;
        this.nNv = f2;
        this.nNw = f3;
        this.nNx = f4;
        if (this.nNu > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nNu, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nNv > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nNv);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nNw > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nNw) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nNx > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nNx) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nNp - rawX);
        float abs4 = Math.abs(this.nNq - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nNp - this.mLastX);
        float abs6 = Math.abs(this.nNq - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dx(sqrt, (int) (sqrt / this.nNr));
        if (this.nNm != 0.0f) {
            this.nNd.setRotation(this.nNd.getRotation() - (this.nNm - ah));
        }
        this.nNm = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dx(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nNd.getLayoutParams();
        int width = this.nNd.getWidth() - i;
        int i3 = (int) (width / this.nNr);
        if (width < this.nNn) {
            width = this.nNn;
            i3 = (int) (width / this.nNr);
        }
        this.mVB = ((width * 1.0f) - (this.nND * 2)) / (this.nNI - (this.nND * 2));
        this.mContentView.setPadding((int) (this.nNz * this.mVB), (int) (this.nNA * this.mVB), (int) (this.nNB * this.mVB), (int) (this.nNC * this.mVB));
        setTextSize(0, (this.nNg.getTextSize() * i3) / this.nNd.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nNd.setLayoutParams(layoutParams);
        float f = this.nNp - (layoutParams.width / 2);
        float f2 = this.nNq - (layoutParams.height / 2);
        this.nNd.setX(f);
        this.nNd.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nNj != 4) {
            float y = (this.nNd.getY() + rawY) - this.mLastY;
            if (y < this.nNv) {
                y = this.nNv;
            } else if (y > (this.nNv + this.mVideoHeight) - this.nNd.getHeight()) {
                y = (this.nNv + this.mVideoHeight) - this.nNd.getHeight();
            }
            this.nNd.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nNk = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nNl != 0.0f) {
                    int i = (int) (this.nNl - ai);
                    dx(i, (int) (i / this.nNr));
                }
                if (this.nNm != 0.0f) {
                    this.nNd.setRotation(this.nNd.getRotation() - (this.nNm - ag));
                }
                this.nNm = ag;
                this.nNl = ai;
            } else if (!this.nNk && pointerCount == 1) {
                float y2 = (this.nNd.getY() + rawY) - this.mLastY;
                if (y2 < this.nNv - (this.nNd.getHeight() / 2)) {
                    y2 = this.nNv - (this.nNd.getHeight() / 2);
                } else if (y2 > ((this.nNv + this.mVideoHeight) - this.nNd.getHeight()) + (this.nNd.getHeight() / 2)) {
                    y2 = ((this.nNv + this.mVideoHeight) - this.nNd.getHeight()) + (this.nNd.getHeight() / 2);
                }
                float x = (this.nNd.getX() + rawX) - this.mLastX;
                if (x < this.nNu - (this.nNd.getWidth() / 2)) {
                    x = this.nNu - (this.nNd.getWidth() / 2);
                } else if (x > ((this.nNu + this.mVideoWidth) - this.nNd.getWidth()) + (this.nNd.getWidth() / 2)) {
                    x = ((this.nNu + this.mVideoWidth) - this.nNd.getWidth()) + (this.nNd.getWidth() / 2);
                }
                this.nNd.setX(x);
                this.nNd.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nNg.getTextSize() != f) {
            this.nNg.setTextSize(i, f);
        }
        if (this.nNf.getTextSize() != f) {
            this.nNf.setTextSize(i, f);
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
        matrix.postRotate(this.nNd.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nNq - motionEvent.getRawY(), this.nNp - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iSH && Math.abs(motionEvent.getRawY() - this.cEl) < this.iSH;
    }

    private void init() {
        this.nNe = (RotateFrameLayout) this.nNd.findViewById(R.id.content_container);
        this.nNf = (TextView) this.nNd.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nNd.findViewById(R.id.content_view);
        this.nNg = (EditText) this.nNd.findViewById(R.id.cover_edit);
        this.nNh = (ImageView) this.nNd.findViewById(R.id.cover_delete);
        this.nNi = (ImageView) this.nNd.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nNf.setText(this.nNg.getText());
        this.nNf.setVisibility(0);
        this.nNg.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nNf.getText())) {
            this.nNj = 0;
            this.nNd.setVisibility(8);
        }
        if (this.nNj == 4) {
            dSU();
        }
        this.nNt.HidenSoftKeyPad(this.nNg);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nNg.setFocusable(true);
            this.nNg.setFocusableInTouchMode(true);
            this.nNg.requestFocus();
            return;
        }
        this.nNg.setFocusable(false);
        this.nNg.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nNg.setText("");
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
                    String Uj = com.baidu.tieba.video.editvideo.model.b.dSP().Uj(pendantData.resource);
                    if (TextUtils.isEmpty(Uj)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nMd.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dSP().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Uj, pendantData);
                        break;
                    }
                    break;
            }
            this.nNj = pendantData.pendantType;
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
        dSU();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nNj == 4 || this.nNj == 0) {
            this.nNd.setX(this.nNu);
            this.nNd.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nNv);
            String obj = this.nNg.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nNg.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nNf.setText(a2);
                    this.nNg.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dSU() {
        if (this.nNy) {
            this.nNy = false;
            this.nNh.setVisibility(8);
            this.nNi.setVisibility(8);
            this.nNe.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSV() {
        if (!this.nNy) {
            this.nNy = true;
            this.nNh.setVisibility(0);
            this.nNi.setVisibility(0);
            this.nNe.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nNJ != null) {
            Bitmap bitmap = this.nNJ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nNJ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dSU();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nNs = 1.0f;
                this.mVB = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nNs = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nNn = (this.nND * 2) + width;
                this.nNo = (this.nND * 2) + height;
                this.nNr = (this.nNn * 1.0f) / this.nNo;
                this.nNd.setX((((this.mVideoWidth - i2) - (this.nND * 2)) / 2) + this.nNu);
                this.nNd.setY((((this.mVideoHeight - i) - (this.nND * 2)) / 2) + this.nNv);
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
                if (motionEvent.getPointerCount() <= 1 && abs < this.iSH && abs2 < this.iSH && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nNf == null || this.nNf.getText() == null) {
            return null;
        }
        return this.nNf.getText().toString();
    }

    public void LZ() {
        this.nNf.setText(this.nNg.getText());
        this.nNf.setVisibility(8);
        this.nNg.setVisibility(0);
        setEditTextEnable(true);
        this.nNt.ShowSoftKeyPad(this.nNg);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nNg.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nNf.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nND = 0;
            this.nNg.setMaxLines(1);
            this.nNf.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nNf.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nNg.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nNg.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nNf.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nND = l.getDimens(getContext(), R.dimen.ds40);
            this.nNg.setMaxLines(2);
            this.nNf.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nNf.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nNg.setLayoutParams(layoutParams2);
            this.nNz = (int) (l.dip2px(getContext(), pendantData.left) * this.nNs);
            this.nNA = (int) (l.dip2px(getContext(), pendantData.top) * this.nNs);
            this.nNB = (int) (l.dip2px(getContext(), pendantData.right) * this.nNs);
            this.nNC = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nNs);
            this.mContentView.setPadding(this.nNz, this.nNA, this.nNB, this.nNC);
            this.bKT = l.getDimens(getContext(), R.dimen.fontsize40) * this.nNs;
            String text = getText();
            this.nNE = (i2 - this.nNA) - this.nNC;
            this.nNF = (i - this.nNz) - this.nNB;
            this.nNH = this.nNG + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bKT);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nNF);
                this.bKT = this.nNg.getTextSize();
                dSV();
                LZ();
            } else {
                if (ag.getTextLengthAllOne(text) > 20) {
                    text = ag.subStringWithAllOne(text, 20);
                    this.nNg.setText(text);
                    this.nNf.setText(text);
                }
                Ul(text);
            }
        }
        this.nNf.setIncludeFontPadding(false);
        this.nNg.setIncludeFontPadding(false);
        this.nNf.setLineSpacing(this.nNG, 1.0f);
        this.nNg.setLineSpacing(this.nNG, 1.0f);
        this.nNd.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nNd.getLayoutParams();
        layoutParams3.height = (this.nND * 2) + i2;
        layoutParams3.width = (this.nND * 2) + i;
        this.nNd.setLayoutParams(layoutParams3);
        this.nNI = (this.nND * 2) + i;
        ((FrameLayout.LayoutParams) this.nNe.getLayoutParams()).setMargins(this.nND, this.nND, this.nND, this.nND);
        this.nNd.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nNK == null) {
            dSW();
        }
        return this.nNK;
    }

    private void dSW() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nNK = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dSX() {
        if (this.nNK != null && !this.nNK.isRecycled()) {
            this.nNK.recycle();
            this.nNK = null;
        }
    }

    public void yY(boolean z) {
        if (this.nNj != 0) {
            if (z) {
                dSX();
                this.nNd.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nNd.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nNJ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nNJ.clear();
        this.nNJ = null;
        dSX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> nNM;
        WeakReference<CoverPendantDragView> nNN;
        WeakReference<PendantData> nNO;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nNM = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nNN = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nNO = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gD(String str, String str2) {
            if (this.nNM != null && this.nNM.get() != null) {
                this.nNM.get().nMd.setVisibility(8);
            }
            if (this.nNN != null && this.nNN.get() != null && this.nNO != null && this.nNO.get() != null) {
                this.nNN.get().a(str2, this.nNO.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Uc(String str) {
            if (this.nNM != null && this.nNM.get() != null) {
                this.nNM.get().nMd.setVisibility(8);
            }
            if (this.nNN != null && this.nNN.get() != null) {
                l.showToast(this.nNN.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dSg() {
            if (this.nNM != null && this.nNM.get() != null) {
                this.nNM.get().nMd.setVisibility(8);
            }
        }
    }
}
