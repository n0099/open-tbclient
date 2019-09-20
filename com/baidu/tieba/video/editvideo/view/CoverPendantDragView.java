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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float cRJ;
    private float ffg;
    float fzR;
    float fzS;
    private float iNA;
    private int jAA;
    private int jAB;
    private int jAC;
    private int jAD;
    private float jAE;
    private float jAF;
    private int jAG;
    private float jAH;
    private int jAI;
    private Map<String, Bitmap> jAJ;
    private Bitmap jAK;
    private FrameLayout jAc;
    private RotateFrameLayout jAd;
    private TextView jAe;
    private EditText jAf;
    private ImageView jAg;
    private ImageView jAh;
    private int jAi;
    private boolean jAj;
    private float jAk;
    private float jAl;
    private int jAm;
    private int jAn;
    private float jAo;
    private float jAp;
    private float jAq;
    private float jAr;
    private b jAs;
    private float jAt;
    private float jAu;
    private float jAv;
    private float jAw;
    private boolean jAx;
    private float jAy;
    private int jAz;
    private FrameLayout mContentView;
    private float mDownX;
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
        this.jAi = 0;
        this.jAr = 1.0f;
        this.iNA = 1.0f;
        this.jAx = true;
        this.jAJ = new HashMap();
        this.startTime = 0L;
        this.fzR = 0.0f;
        this.fzS = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jAy = l.g(getContext(), R.dimen.fontsize40);
        this.jAG = l.g(getContext(), R.dimen.ds2);
        this.ffg = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jAc = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jAc);
        this.jAc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jAi == 4) {
                            CoverPendantDragView.this.cvS();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cRJ);
                        if (!CoverPendantDragView.this.jAj && abs < CoverPendantDragView.this.ffg && abs2 < CoverPendantDragView.this.ffg && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cvT();
                        }
                        CoverPendantDragView.this.jAk = 0.0f;
                        CoverPendantDragView.this.jAl = 0.0f;
                        CoverPendantDragView.this.jAj = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.M(motionEvent)) {
                            CoverPendantDragView.this.O(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.jAk = 0.0f;
                        CoverPendantDragView.this.jAl = 0.0f;
                        return true;
                }
            }
        });
        this.jAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jAf.setText("");
                CoverPendantDragView.this.cgY();
            }
        });
        this.jAh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jAl = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.M(motionEvent)) {
                            CoverPendantDragView.this.N(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.jAf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jAi != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jAe.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (aa.rA(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jAe.getText().length()) {
                        CoverPendantDragView.this.Gq(obj);
                    } else {
                        CoverPendantDragView.this.Gp(obj);
                    }
                } else {
                    String ab = aa.ab(obj, 20);
                    editable.delete(ab.length(), obj.length());
                    CoverPendantDragView.this.Gq(ab);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jAe.setText(editable.toString());
            }
        });
        this.jAf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jAc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cRJ = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cRJ;
        this.jAo = (this.jAc.getWidth() / 2) + this.jAc.getX();
        this.jAp = (this.jAc.getHeight() / 2) + this.jAc.getY();
        this.jAe.setText(this.jAf.getText());
        this.jAe.setVisibility(0);
        this.jAf.setVisibility(8);
        setEditTextEnable(false);
        this.jAs.HidenSoftKeyPad(this.jAf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp(String str) {
        TextPaint paint = this.jAf.getPaint();
        float measureText = paint.measureText(str);
        while (this.jAf.getLineCount() == 1 && this.jAf.getTextSize() < this.jAy * this.iNA && measureText < this.jAF * this.iNA) {
            setTextSize(0, this.jAf.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (aa.rA(str) <= aa.rA(getResources().getString(R.string.cover_hint)) && this.jAf.getTextSize() != this.jAy * this.iNA) {
            setTextSize(0, this.jAy * this.iNA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        TextPaint paint = this.jAf.getPaint();
        float measureText = paint.measureText(str);
        while (this.jAf.getTextSize() > ((this.jAE * this.iNA) / 2.0f) - (this.jAH * this.iNA) && measureText > this.jAF * this.iNA) {
            setTextSize(0, this.jAf.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jAf.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jAf.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.g(getContext(), R.dimen.ds120)) {
            str = aa.ad(str, aa.rz(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.jAs = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jAt = f;
        this.jAu = f2;
        this.jAv = f3;
        this.jAw = f4;
        if (this.jAt > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jAt, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jAu > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jAu);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jAv > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jAv) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jAw > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jAw) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float Q = Q(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.jAo - rawX);
        float abs4 = Math.abs(this.jAp - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jAo - this.mLastX);
        float abs6 = Math.abs(this.jAp - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cE(sqrt, (int) (sqrt / this.jAq));
        if (this.jAl != 0.0f) {
            this.jAc.setRotation(this.jAc.getRotation() - (this.jAl - Q));
        }
        this.jAl = Q;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cE(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jAc.getLayoutParams();
        int width = this.jAc.getWidth() - i;
        int i3 = (int) (width / this.jAq);
        if (width < this.jAm) {
            width = this.jAm;
            i3 = (int) (width / this.jAq);
        }
        this.iNA = ((width * 1.0f) - (this.jAD * 2)) / (this.jAI - (this.jAD * 2));
        this.mContentView.setPadding((int) (this.jAz * this.iNA), (int) (this.jAA * this.iNA), (int) (this.jAB * this.iNA), (int) (this.jAC * this.iNA));
        setTextSize(0, (this.jAf.getTextSize() * i3) / this.jAc.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jAc.setLayoutParams(layoutParams);
        float f = this.jAo - (layoutParams.width / 2);
        float f2 = this.jAp - (layoutParams.height / 2);
        this.jAc.setX(f);
        this.jAc.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jAi != 4) {
            float y = (this.jAc.getY() + rawY) - this.mLastY;
            if (y < this.jAu) {
                y = this.jAu;
            } else if (y > (this.jAu + this.mVideoHeight) - this.jAc.getHeight()) {
                y = (this.jAu + this.mVideoHeight) - this.jAc.getHeight();
            }
            this.jAc.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jAj = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.jAk != 0.0f) {
                    int i = (int) (this.jAk - R);
                    cE(i, (int) (i / this.jAq));
                }
                if (this.jAl != 0.0f) {
                    this.jAc.setRotation(this.jAc.getRotation() - (this.jAl - P));
                }
                this.jAl = P;
                this.jAk = R;
            } else if (!this.jAj && pointerCount == 1) {
                float y2 = (this.jAc.getY() + rawY) - this.mLastY;
                if (y2 < this.jAu - (this.jAc.getHeight() / 2)) {
                    y2 = this.jAu - (this.jAc.getHeight() / 2);
                } else if (y2 > ((this.jAu + this.mVideoHeight) - this.jAc.getHeight()) + (this.jAc.getHeight() / 2)) {
                    y2 = ((this.jAu + this.mVideoHeight) - this.jAc.getHeight()) + (this.jAc.getHeight() / 2);
                }
                float x = (this.jAc.getX() + rawX) - this.mLastX;
                if (x < this.jAt - (this.jAc.getWidth() / 2)) {
                    x = this.jAt - (this.jAc.getWidth() / 2);
                } else if (x > ((this.jAt + this.mVideoWidth) - this.jAc.getWidth()) + (this.jAc.getWidth() / 2)) {
                    x = ((this.jAt + this.mVideoWidth) - this.jAc.getWidth()) + (this.jAc.getWidth() / 2);
                }
                this.jAc.setX(x);
                this.jAc.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jAf.getTextSize() != f) {
            this.jAf.setTextSize(i, f);
        }
        if (this.jAe.getTextSize() != f) {
            this.jAe.setTextSize(i, f);
        }
    }

    private float P(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.jAc.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jAp - motionEvent.getRawY(), this.jAo - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.ffg && Math.abs(motionEvent.getRawY() - this.cRJ) < this.ffg;
    }

    private void init() {
        this.jAd = (RotateFrameLayout) this.jAc.findViewById(R.id.content_container);
        this.jAe = (TextView) this.jAc.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jAc.findViewById(R.id.content_view);
        this.jAf = (EditText) this.jAc.findViewById(R.id.cover_edit);
        this.jAg = (ImageView) this.jAc.findViewById(R.id.cover_delete);
        this.jAh = (ImageView) this.jAc.findViewById(R.id.cover_scale);
    }

    public void cgY() {
        this.jAe.setText(this.jAf.getText());
        this.jAe.setVisibility(0);
        this.jAf.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jAe.getText())) {
            this.jAi = 0;
            this.jAc.setVisibility(8);
        }
        if (this.jAi == 4) {
            cvR();
        }
        this.jAs.HidenSoftKeyPad(this.jAf);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jAf.setFocusable(true);
            this.jAf.setFocusableInTouchMode(true);
            this.jAf.requestFocus();
            return;
        }
        this.jAf.setFocusable(false);
        this.jAf.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jAf.setText("");
                    cgY();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    cvT();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    cvT();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    cvT();
                    break;
                default:
                    cgY();
                    String Go = com.baidu.tieba.video.editvideo.model.b.cvM().Go(pendantData.resource);
                    if (TextUtils.isEmpty(Go)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jyY.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cvM().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Go, pendantData);
                        break;
                    }
                    break;
            }
            this.jAi = pendantData.pendantType;
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
        cvR();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jAi == 4 || this.jAi == 0) {
            this.jAc.setX(this.jAt);
            this.jAc.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jAu);
            String obj = this.jAf.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jAf.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jAe.setText(a2);
                    this.jAf.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cvR() {
        if (this.jAx) {
            this.jAx = false;
            this.jAg.setVisibility(8);
            this.jAh.setVisibility(8);
            this.jAd.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvS() {
        if (!this.jAx) {
            this.jAx = true;
            this.jAg.setVisibility(0);
            this.jAh.setVisibility(0);
            this.jAd.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jAJ != null) {
            Bitmap bitmap = this.jAJ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jAJ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cvR();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jAr = 1.0f;
                this.iNA = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jAr = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jAm = (this.jAD * 2) + width;
                this.jAn = (this.jAD * 2) + height;
                this.jAq = (this.jAm * 1.0f) / this.jAn;
                this.jAc.setX((((this.mVideoWidth - i2) - (this.jAD * 2)) / 2) + this.jAt);
                this.jAc.setY((((this.mVideoHeight - i) - (this.jAD * 2)) / 2) + this.jAu);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fzR = motionEvent.getRawX();
                this.fzS = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fzR);
                float abs2 = Math.abs(rawY - this.fzS);
                if (motionEvent.getPointerCount() <= 1 && abs < this.ffg && abs2 < this.ffg && System.currentTimeMillis() - this.startTime < 300) {
                    cgY();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jAe == null || this.jAe.getText() == null) {
            return null;
        }
        return this.jAe.getText().toString();
    }

    public void cvT() {
        this.jAe.setText(this.jAf.getText());
        this.jAe.setVisibility(8);
        this.jAf.setVisibility(0);
        setEditTextEnable(true);
        this.jAs.ShowSoftKeyPad(this.jAf);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jAf.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jAe.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jAD = 0;
            this.jAf.setMaxLines(1);
            this.jAe.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jAe.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jAf.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jAf.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jAe.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jAD = l.g(getContext(), R.dimen.ds40);
            this.jAf.setMaxLines(2);
            this.jAe.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jAe.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jAf.setLayoutParams(layoutParams2);
            this.jAz = (int) (l.dip2px(getContext(), pendantData.left) * this.jAr);
            this.jAA = (int) (l.dip2px(getContext(), pendantData.top) * this.jAr);
            this.jAB = (int) (l.dip2px(getContext(), pendantData.right) * this.jAr);
            this.jAC = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jAr);
            this.mContentView.setPadding(this.jAz, this.jAA, this.jAB, this.jAC);
            this.jAy = l.g(getContext(), R.dimen.fontsize40) * this.jAr;
            String text = getText();
            this.jAE = (i2 - this.jAA) - this.jAC;
            this.jAF = (i - this.jAz) - this.jAB;
            this.jAH = this.jAG + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jAy);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jAF);
                this.jAy = this.jAf.getTextSize();
                cvS();
                cvT();
            } else {
                if (aa.rA(text) > 20) {
                    text = aa.ab(text, 20);
                    this.jAf.setText(text);
                    this.jAe.setText(text);
                }
                Gq(text);
            }
        }
        this.jAe.setIncludeFontPadding(false);
        this.jAf.setIncludeFontPadding(false);
        this.jAe.setLineSpacing(this.jAG, 1.0f);
        this.jAf.setLineSpacing(this.jAG, 1.0f);
        this.jAc.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jAc.getLayoutParams();
        layoutParams3.height = (this.jAD * 2) + i2;
        layoutParams3.width = (this.jAD * 2) + i;
        this.jAc.setLayoutParams(layoutParams3);
        this.jAI = (this.jAD * 2) + i;
        ((FrameLayout.LayoutParams) this.jAd.getLayoutParams()).setMargins(this.jAD, this.jAD, this.jAD, this.jAD);
        this.jAc.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jAK == null) {
            cvU();
        }
        return this.jAK;
    }

    private void cvU() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jAK = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cvV() {
        if (this.jAK != null && !this.jAK.isRecycled()) {
            this.jAK.recycle();
            this.jAK = null;
        }
    }

    public void rI(boolean z) {
        if (this.jAi != 0) {
            if (z) {
                cvV();
                this.jAc.setVisibility(0);
                return;
            }
            cgY();
            getTempBitmap();
            this.jAc.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jAJ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jAJ.clear();
        this.jAJ = null;
        cvV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jAM;
        WeakReference<CoverPendantDragView> jAN;
        WeakReference<PendantData> jAO;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jAM = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jAN = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jAO = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void et(String str, String str2) {
            if (this.jAM != null && this.jAM.get() != null) {
                this.jAM.get().jyY.setVisibility(8);
            }
            if (this.jAN != null && this.jAN.get() != null && this.jAO != null && this.jAO.get() != null) {
                this.jAN.get().a(str2, this.jAO.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Gf(String str) {
            if (this.jAM != null && this.jAM.get() != null) {
                this.jAM.get().jyY.setVisibility(8);
            }
            if (this.jAN != null && this.jAN.get() != null) {
                l.showToast(this.jAN.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cuX() {
            if (this.jAM != null && this.jAM.get() != null) {
                this.jAM.get().jyY.setVisibility(8);
            }
        }
    }
}
