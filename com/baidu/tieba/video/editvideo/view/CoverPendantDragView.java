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
/* loaded from: classes22.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bCb;
    float bkv;
    float bkw;
    private float cuT;
    private float iuB;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mxw;
    private FrameLayout npQ;
    private RotateFrameLayout npR;
    private TextView npS;
    private EditText npT;
    private ImageView npU;
    private ImageView npV;
    private int npW;
    private boolean npX;
    private float npY;
    private float npZ;
    private int nqa;
    private int nqb;
    private float nqc;
    private float nqd;
    private float nqe;
    private float nqf;
    private c nqg;
    private float nqh;
    private float nqi;
    private float nqj;
    private float nqk;
    private boolean nql;
    private int nqm;
    private int nqn;
    private int nqo;
    private int nqp;
    private int nqq;
    private float nqr;
    private float nqs;
    private int nqt;
    private float nqu;
    private int nqv;
    private Map<String, Bitmap> nqw;
    private Bitmap nqx;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.npW = 0;
        this.nqf = 1.0f;
        this.mxw = 1.0f;
        this.nql = true;
        this.nqw = new HashMap();
        this.startTime = 0L;
        this.bkv = 0.0f;
        this.bkw = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bCb = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nqt = l.getDimens(getContext(), R.dimen.ds2);
        this.iuB = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.npQ = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.npQ);
        this.npQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.npW == 4) {
                            CoverPendantDragView.this.dPr();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cuT);
                        if (!CoverPendantDragView.this.npX && abs < CoverPendantDragView.this.iuB && abs2 < CoverPendantDragView.this.iuB && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Mw();
                        }
                        CoverPendantDragView.this.npY = 0.0f;
                        CoverPendantDragView.this.npZ = 0.0f;
                        CoverPendantDragView.this.npX = false;
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
                        CoverPendantDragView.this.npY = 0.0f;
                        CoverPendantDragView.this.npZ = 0.0f;
                        return true;
                }
            }
        });
        this.npU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.npT.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.npV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.npZ = 0.0f;
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
        this.npT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.npW != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.npS.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.npS.getText().length()) {
                        CoverPendantDragView.this.TA(obj);
                    } else {
                        CoverPendantDragView.this.Tz(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.TA(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.npS.setText(editable.toString());
            }
        });
        this.npT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.npQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cuT = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cuT;
        this.nqc = (this.npQ.getWidth() / 2) + this.npQ.getX();
        this.nqd = (this.npQ.getHeight() / 2) + this.npQ.getY();
        this.npS.setText(this.npT.getText());
        this.npS.setVisibility(0);
        this.npT.setVisibility(8);
        setEditTextEnable(false);
        this.nqg.HidenSoftKeyPad(this.npT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tz(String str) {
        TextPaint paint = this.npT.getPaint();
        float measureText = paint.measureText(str);
        while (this.npT.getLineCount() == 1 && this.npT.getTextSize() < this.bCb * this.mxw && measureText < this.nqs * this.mxw) {
            setTextSize(0, this.npT.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.npT.getTextSize() != this.bCb * this.mxw) {
            setTextSize(0, this.bCb * this.mxw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA(String str) {
        TextPaint paint = this.npT.getPaint();
        float measureText = paint.measureText(str);
        while (this.npT.getTextSize() > ((this.nqr * this.mxw) / 2.0f) - (this.nqu * this.mxw) && measureText > this.nqs * this.mxw) {
            setTextSize(0, this.npT.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.npT.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.npT.getTextSize() - 1.0f);
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
        this.nqg = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nqh = f;
        this.nqi = f2;
        this.nqj = f3;
        this.nqk = f4;
        if (this.nqh > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nqh, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nqi > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nqi);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nqj > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nqj) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nqk > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nqk) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nqc - rawX);
        float abs4 = Math.abs(this.nqd - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nqc - this.mLastX);
        float abs6 = Math.abs(this.nqd - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dz(sqrt, (int) (sqrt / this.nqe));
        if (this.npZ != 0.0f) {
            this.npQ.setRotation(this.npQ.getRotation() - (this.npZ - ah));
        }
        this.npZ = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dz(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.npQ.getLayoutParams();
        int width = this.npQ.getWidth() - i;
        int i3 = (int) (width / this.nqe);
        if (width < this.nqa) {
            width = this.nqa;
            i3 = (int) (width / this.nqe);
        }
        this.mxw = ((width * 1.0f) - (this.nqq * 2)) / (this.nqv - (this.nqq * 2));
        this.mContentView.setPadding((int) (this.nqm * this.mxw), (int) (this.nqn * this.mxw), (int) (this.nqo * this.mxw), (int) (this.nqp * this.mxw));
        setTextSize(0, (this.npT.getTextSize() * i3) / this.npQ.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.npQ.setLayoutParams(layoutParams);
        float f = this.nqc - (layoutParams.width / 2);
        float f2 = this.nqd - (layoutParams.height / 2);
        this.npQ.setX(f);
        this.npQ.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.npW != 4) {
            float y = (this.npQ.getY() + rawY) - this.mLastY;
            if (y < this.nqi) {
                y = this.nqi;
            } else if (y > (this.nqi + this.mVideoHeight) - this.npQ.getHeight()) {
                y = (this.nqi + this.mVideoHeight) - this.npQ.getHeight();
            }
            this.npQ.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.npX = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.npY != 0.0f) {
                    int i = (int) (this.npY - ai);
                    dz(i, (int) (i / this.nqe));
                }
                if (this.npZ != 0.0f) {
                    this.npQ.setRotation(this.npQ.getRotation() - (this.npZ - ag));
                }
                this.npZ = ag;
                this.npY = ai;
            } else if (!this.npX && pointerCount == 1) {
                float y2 = (this.npQ.getY() + rawY) - this.mLastY;
                if (y2 < this.nqi - (this.npQ.getHeight() / 2)) {
                    y2 = this.nqi - (this.npQ.getHeight() / 2);
                } else if (y2 > ((this.nqi + this.mVideoHeight) - this.npQ.getHeight()) + (this.npQ.getHeight() / 2)) {
                    y2 = ((this.nqi + this.mVideoHeight) - this.npQ.getHeight()) + (this.npQ.getHeight() / 2);
                }
                float x = (this.npQ.getX() + rawX) - this.mLastX;
                if (x < this.nqh - (this.npQ.getWidth() / 2)) {
                    x = this.nqh - (this.npQ.getWidth() / 2);
                } else if (x > ((this.nqh + this.mVideoWidth) - this.npQ.getWidth()) + (this.npQ.getWidth() / 2)) {
                    x = ((this.nqh + this.mVideoWidth) - this.npQ.getWidth()) + (this.npQ.getWidth() / 2);
                }
                this.npQ.setX(x);
                this.npQ.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.npT.getTextSize() != f) {
            this.npT.setTextSize(i, f);
        }
        if (this.npS.getTextSize() != f) {
            this.npS.setTextSize(i, f);
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
        matrix.postRotate(this.npQ.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nqd - motionEvent.getRawY(), this.nqc - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iuB && Math.abs(motionEvent.getRawY() - this.cuT) < this.iuB;
    }

    private void init() {
        this.npR = (RotateFrameLayout) this.npQ.findViewById(R.id.content_container);
        this.npS = (TextView) this.npQ.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.npQ.findViewById(R.id.content_view);
        this.npT = (EditText) this.npQ.findViewById(R.id.cover_edit);
        this.npU = (ImageView) this.npQ.findViewById(R.id.cover_delete);
        this.npV = (ImageView) this.npQ.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.npS.setText(this.npT.getText());
        this.npS.setVisibility(0);
        this.npT.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.npS.getText())) {
            this.npW = 0;
            this.npQ.setVisibility(8);
        }
        if (this.npW == 4) {
            dPq();
        }
        this.nqg.HidenSoftKeyPad(this.npT);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.npT.setFocusable(true);
            this.npT.setFocusableInTouchMode(true);
            this.npT.requestFocus();
            return;
        }
        this.npT.setFocusable(false);
        this.npT.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.npT.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Mw();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Mw();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Mw();
                    break;
                default:
                    hideSoftKeyPad();
                    String Ty = com.baidu.tieba.video.editvideo.model.b.dPl().Ty(pendantData.resource);
                    if (TextUtils.isEmpty(Ty)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.noQ.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dPl().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Ty, pendantData);
                        break;
                    }
                    break;
            }
            this.npW = pendantData.pendantType;
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
        dPq();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.npW == 4 || this.npW == 0) {
            this.npQ.setX(this.nqh);
            this.npQ.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nqi);
            String obj = this.npT.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.npT.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.npS.setText(a2);
                    this.npT.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dPq() {
        if (this.nql) {
            this.nql = false;
            this.npU.setVisibility(8);
            this.npV.setVisibility(8);
            this.npR.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPr() {
        if (!this.nql) {
            this.nql = true;
            this.npU.setVisibility(0);
            this.npV.setVisibility(0);
            this.npR.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nqw != null) {
            Bitmap bitmap = this.nqw.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nqw.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dPq();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nqf = 1.0f;
                this.mxw = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nqf = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nqa = (this.nqq * 2) + width;
                this.nqb = (this.nqq * 2) + height;
                this.nqe = (this.nqa * 1.0f) / this.nqb;
                this.npQ.setX((((this.mVideoWidth - i2) - (this.nqq * 2)) / 2) + this.nqh);
                this.npQ.setY((((this.mVideoHeight - i) - (this.nqq * 2)) / 2) + this.nqi);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bkv = motionEvent.getRawX();
                this.bkw = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bkv);
                float abs2 = Math.abs(rawY - this.bkw);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iuB && abs2 < this.iuB && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.npS == null || this.npS.getText() == null) {
            return null;
        }
        return this.npS.getText().toString();
    }

    public void Mw() {
        this.npS.setText(this.npT.getText());
        this.npS.setVisibility(8);
        this.npT.setVisibility(0);
        setEditTextEnable(true);
        this.nqg.ShowSoftKeyPad(this.npT);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.npT.setTextAppearance(getContext(), R.style.cover_text_style);
            this.npS.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nqq = 0;
            this.npT.setMaxLines(1);
            this.npS.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.npS.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.npT.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.npT.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.npS.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nqq = l.getDimens(getContext(), R.dimen.ds40);
            this.npT.setMaxLines(2);
            this.npS.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.npS.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.npT.setLayoutParams(layoutParams2);
            this.nqm = (int) (l.dip2px(getContext(), pendantData.left) * this.nqf);
            this.nqn = (int) (l.dip2px(getContext(), pendantData.top) * this.nqf);
            this.nqo = (int) (l.dip2px(getContext(), pendantData.right) * this.nqf);
            this.nqp = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nqf);
            this.mContentView.setPadding(this.nqm, this.nqn, this.nqo, this.nqp);
            this.bCb = l.getDimens(getContext(), R.dimen.fontsize40) * this.nqf;
            String text = getText();
            this.nqr = (i2 - this.nqn) - this.nqp;
            this.nqs = (i - this.nqm) - this.nqo;
            this.nqu = this.nqt + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bCb);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.nqs);
                this.bCb = this.npT.getTextSize();
                dPr();
                Mw();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.npT.setText(text);
                    this.npS.setText(text);
                }
                TA(text);
            }
        }
        this.npS.setIncludeFontPadding(false);
        this.npT.setIncludeFontPadding(false);
        this.npS.setLineSpacing(this.nqt, 1.0f);
        this.npT.setLineSpacing(this.nqt, 1.0f);
        this.npQ.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.npQ.getLayoutParams();
        layoutParams3.height = (this.nqq * 2) + i2;
        layoutParams3.width = (this.nqq * 2) + i;
        this.npQ.setLayoutParams(layoutParams3);
        this.nqv = (this.nqq * 2) + i;
        ((FrameLayout.LayoutParams) this.npR.getLayoutParams()).setMargins(this.nqq, this.nqq, this.nqq, this.nqq);
        this.npQ.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nqx == null) {
            dPs();
        }
        return this.nqx;
    }

    private void dPs() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nqx = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dPt() {
        if (this.nqx != null && !this.nqx.isRecycled()) {
            this.nqx.recycle();
            this.nqx = null;
        }
    }

    public void yb(boolean z) {
        if (this.npW != 0) {
            if (z) {
                dPt();
                this.npQ.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.npQ.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nqw.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nqw.clear();
        this.nqw = null;
        dPt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements b.a {
        WeakReference<CoverPendantDragView> nqA;
        WeakReference<PendantData> nqB;
        WeakReference<a.b> nqz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nqz = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nqA = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nqB = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gw(String str, String str2) {
            if (this.nqz != null && this.nqz.get() != null) {
                this.nqz.get().noQ.setVisibility(8);
            }
            if (this.nqA != null && this.nqA.get() != null && this.nqB != null && this.nqB.get() != null) {
                this.nqA.get().a(str2, this.nqB.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Tr(String str) {
            if (this.nqz != null && this.nqz.get() != null) {
                this.nqz.get().noQ.setVisibility(8);
            }
            if (this.nqA != null && this.nqA.get() != null) {
                l.showToast(this.nqA.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dOC() {
            if (this.nqz != null && this.nqz.get() != null) {
                this.nqz.get().noQ.setVisibility(8);
            }
        }
    }
}
