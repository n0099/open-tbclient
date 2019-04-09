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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Ql;
    private float Qm;
    private float cHg;
    private float eHI;
    float fcu;
    float fcv;
    private float iXA;
    private int iXB;
    private int iXC;
    private float iXD;
    private float iXE;
    private float iXF;
    private float iXG;
    private b iXH;
    private float iXI;
    private float iXJ;
    private float iXK;
    private float iXL;
    private boolean iXM;
    private float iXN;
    private int iXO;
    private int iXP;
    private int iXQ;
    private int iXR;
    private int iXS;
    private float iXT;
    private float iXU;
    private int iXV;
    private float iXW;
    private int iXX;
    private Map<String, Bitmap> iXY;
    private Bitmap iXZ;
    private FrameLayout iXr;
    private RotateFrameLayout iXs;
    private TextView iXt;
    private EditText iXu;
    private ImageView iXv;
    private ImageView iXw;
    private int iXx;
    private boolean iXy;
    private float iXz;
    private float ikT;
    private FrameLayout mContentView;
    private float mDownX;
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
        this.iXx = 0;
        this.iXG = 1.0f;
        this.ikT = 1.0f;
        this.iXM = true;
        this.iXY = new HashMap();
        this.startTime = 0L;
        this.fcu = 0.0f;
        this.fcv = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.iXN = l.h(getContext(), d.e.fontsize40);
        this.iXV = l.h(getContext(), d.e.ds2);
        this.eHI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.iXr = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.iXr);
        this.iXr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.iXx == 4) {
                            CoverPendantDragView.this.cjR();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cHg);
                        if (!CoverPendantDragView.this.iXy && abs < CoverPendantDragView.this.eHI && abs2 < CoverPendantDragView.this.eHI && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cjS();
                        }
                        CoverPendantDragView.this.iXz = 0.0f;
                        CoverPendantDragView.this.iXA = 0.0f;
                        CoverPendantDragView.this.iXy = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.J(motionEvent)) {
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
                        CoverPendantDragView.this.iXz = 0.0f;
                        CoverPendantDragView.this.iXA = 0.0f;
                        return true;
                }
            }
        });
        this.iXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.iXu.setText("");
                CoverPendantDragView.this.bUW();
            }
        });
        this.iXw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.iXA = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.J(motionEvent)) {
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
        this.iXu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.iXx != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.iXt.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (ab.pP(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.iXt.getText().length()) {
                        CoverPendantDragView.this.DD(obj);
                    } else {
                        CoverPendantDragView.this.DC(obj);
                    }
                } else {
                    String af = ab.af(obj, 20);
                    editable.delete(af.length(), obj.length());
                    CoverPendantDragView.this.DD(af);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.iXt.setText(editable.toString());
            }
        });
        this.iXu.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.iXr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cHg = motionEvent.getRawY();
        this.Ql = this.mDownX;
        this.Qm = this.cHg;
        this.iXD = (this.iXr.getWidth() / 2) + this.iXr.getX();
        this.iXE = (this.iXr.getHeight() / 2) + this.iXr.getY();
        this.iXt.setText(this.iXu.getText());
        this.iXt.setVisibility(0);
        this.iXu.setVisibility(8);
        setEditTextEnable(false);
        this.iXH.HidenSoftKeyPad(this.iXu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC(String str) {
        TextPaint paint = this.iXu.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXu.getLineCount() == 1 && this.iXu.getTextSize() < this.iXN * this.ikT && measureText < this.iXU * this.ikT) {
            setTextSize(0, this.iXu.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.pP(str) <= ab.pP(getResources().getString(d.j.cover_hint)) && this.iXu.getTextSize() != this.iXN * this.ikT) {
            setTextSize(0, this.iXN * this.ikT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        TextPaint paint = this.iXu.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXu.getTextSize() > ((this.iXT * this.ikT) / 2.0f) - (this.iXW * this.ikT) && measureText > this.iXU * this.ikT) {
            setTextSize(0, this.iXu.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.iXu.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.iXu.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), d.e.ds120)) {
            str = ab.ah(str, ab.pO(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.iXH = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.iXI = f;
        this.iXJ = f2;
        this.iXK = f3;
        this.iXL = f4;
        if (this.iXI > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.iXI, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.iXJ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.iXJ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.iXK > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.iXK) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.iXL > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.iXL) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float N = N(motionEvent);
        float abs = Math.abs(this.Ql - rawX);
        float abs2 = Math.abs(this.Qm - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.iXD - rawX);
        float abs4 = Math.abs(this.iXE - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.iXD - this.Ql);
        float abs6 = Math.abs(this.iXE - this.Qm);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        ct(sqrt, (int) (sqrt / this.iXF));
        if (this.iXA != 0.0f) {
            this.iXr.setRotation(this.iXr.getRotation() - (this.iXA - N));
        }
        this.iXA = N;
        this.Ql = rawX;
        this.Qm = rawY;
    }

    private void ct(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXr.getLayoutParams();
        int width = this.iXr.getWidth() - i;
        int i3 = (int) (width / this.iXF);
        if (width < this.iXB) {
            width = this.iXB;
            i3 = (int) (width / this.iXF);
        }
        this.ikT = ((width * 1.0f) - (this.iXS * 2)) / (this.iXX - (this.iXS * 2));
        this.mContentView.setPadding((int) (this.iXO * this.ikT), (int) (this.iXP * this.ikT), (int) (this.iXQ * this.ikT), (int) (this.iXR * this.ikT));
        setTextSize(0, (this.iXu.getTextSize() * i3) / this.iXr.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.iXr.setLayoutParams(layoutParams);
        float f = this.iXD - (layoutParams.width / 2);
        float f2 = this.iXE - (layoutParams.height / 2);
        this.iXr.setX(f);
        this.iXr.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.iXx != 4) {
            float y = (this.iXr.getY() + rawY) - this.Qm;
            if (y < this.iXJ) {
                y = this.iXJ;
            } else if (y > (this.iXJ + this.mVideoHeight) - this.iXr.getHeight()) {
                y = (this.iXJ + this.mVideoHeight) - this.iXr.getHeight();
            }
            this.iXr.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.iXy = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.iXz != 0.0f) {
                    int i = (int) (this.iXz - O);
                    ct(i, (int) (i / this.iXF));
                }
                if (this.iXA != 0.0f) {
                    this.iXr.setRotation(this.iXr.getRotation() - (this.iXA - M));
                }
                this.iXA = M;
                this.iXz = O;
            } else if (!this.iXy && pointerCount == 1) {
                float y2 = (this.iXr.getY() + rawY) - this.Qm;
                if (y2 < this.iXJ - (this.iXr.getHeight() / 2)) {
                    y2 = this.iXJ - (this.iXr.getHeight() / 2);
                } else if (y2 > ((this.iXJ + this.mVideoHeight) - this.iXr.getHeight()) + (this.iXr.getHeight() / 2)) {
                    y2 = ((this.iXJ + this.mVideoHeight) - this.iXr.getHeight()) + (this.iXr.getHeight() / 2);
                }
                float x = (this.iXr.getX() + rawX) - this.Ql;
                if (x < this.iXI - (this.iXr.getWidth() / 2)) {
                    x = this.iXI - (this.iXr.getWidth() / 2);
                } else if (x > ((this.iXI + this.mVideoWidth) - this.iXr.getWidth()) + (this.iXr.getWidth() / 2)) {
                    x = ((this.iXI + this.mVideoWidth) - this.iXr.getWidth()) + (this.iXr.getWidth() / 2);
                }
                this.iXr.setX(x);
                this.iXr.setY(y2);
            }
        }
        this.Ql = rawX;
        this.Qm = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.iXu.getTextSize() != f) {
            this.iXu.setTextSize(i, f);
        }
        if (this.iXt.getTextSize() != f) {
            this.iXt.setTextSize(i, f);
        }
    }

    private float M(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.iXr.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.iXE - motionEvent.getRawY(), this.iXD - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHI && Math.abs(motionEvent.getRawY() - this.cHg) < this.eHI;
    }

    private void init() {
        this.iXs = (RotateFrameLayout) this.iXr.findViewById(d.g.content_container);
        this.iXt = (TextView) this.iXr.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.iXr.findViewById(d.g.content_view);
        this.iXu = (EditText) this.iXr.findViewById(d.g.cover_edit);
        this.iXv = (ImageView) this.iXr.findViewById(d.g.cover_delete);
        this.iXw = (ImageView) this.iXr.findViewById(d.g.cover_scale);
    }

    public void bUW() {
        this.iXt.setText(this.iXu.getText());
        this.iXt.setVisibility(0);
        this.iXu.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.iXt.getText())) {
            this.iXx = 0;
            this.iXr.setVisibility(8);
        }
        if (this.iXx == 4) {
            cjQ();
        }
        this.iXH.HidenSoftKeyPad(this.iXu);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.iXu.setFocusable(true);
            this.iXu.setFocusableInTouchMode(true);
            this.iXu.requestFocus();
            return;
        }
        this.iXu.setFocusable(false);
        this.iXu.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.iXu.setText("");
                    bUW();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    cjS();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    cjS();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    cjS();
                    break;
                default:
                    bUW();
                    String DB = com.baidu.tieba.video.editvideo.model.b.cjL().DB(pendantData.resource);
                    if (TextUtils.isEmpty(DB)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.iWm.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cjL().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(DB, pendantData);
                        break;
                    }
                    break;
            }
            this.iXx = pendantData.pendantType;
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
        cjQ();
        a(this.mVideoWidth, l.h(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.iXx == 4 || this.iXx == 0) {
            this.iXr.setX(this.iXI);
            this.iXr.setY(((this.mVideoHeight - l.h(getContext(), d.e.ds100)) / 2) + this.iXJ);
            String obj = this.iXu.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.iXu.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.iXt.setText(a2);
                    this.iXu.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cjQ() {
        if (this.iXM) {
            this.iXM = false;
            this.iXv.setVisibility(8);
            this.iXw.setVisibility(8);
            this.iXs.setBackgroundColor(getResources().getColor(d.C0277d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjR() {
        if (!this.iXM) {
            this.iXM = true;
            this.iXv.setVisibility(0);
            this.iXw.setVisibility(0);
            this.iXs.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.iXY != null) {
            Bitmap bitmap = this.iXY.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.iXY.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cjQ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.iXG = 1.0f;
                this.ikT = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.iXG = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.iXB = (this.iXS * 2) + width;
                this.iXC = (this.iXS * 2) + height;
                this.iXF = (this.iXB * 1.0f) / this.iXC;
                this.iXr.setX((((this.mVideoWidth - i2) - (this.iXS * 2)) / 2) + this.iXI);
                this.iXr.setY((((this.mVideoHeight - i) - (this.iXS * 2)) / 2) + this.iXJ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fcu = motionEvent.getRawX();
                this.fcv = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fcu);
                float abs2 = Math.abs(rawY - this.fcv);
                if (motionEvent.getPointerCount() <= 1 && abs < this.eHI && abs2 < this.eHI && System.currentTimeMillis() - this.startTime < 300) {
                    bUW();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.iXt == null || this.iXt.getText() == null) {
            return null;
        }
        return this.iXt.getText().toString();
    }

    public void cjS() {
        this.iXt.setText(this.iXu.getText());
        this.iXt.setVisibility(8);
        this.iXu.setVisibility(0);
        setEditTextEnable(true);
        this.iXH.ShowSoftKeyPad(this.iXu);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.iXu.setTextAppearance(getContext(), d.k.cover_text_style);
            this.iXt.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), d.e.fontsize40) * i) / i3);
            this.iXS = 0;
            this.iXu.setMaxLines(1);
            this.iXt.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXt.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.iXu.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), d.e.ds60), 0, l.h(getContext(), d.e.ds60), 0);
        } else {
            this.iXu.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iXt.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iXS = l.h(getContext(), d.e.ds40);
            this.iXu.setMaxLines(2);
            this.iXt.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iXt.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.iXu.setLayoutParams(layoutParams2);
            this.iXO = (int) (l.dip2px(getContext(), pendantData.left) * this.iXG);
            this.iXP = (int) (l.dip2px(getContext(), pendantData.top) * this.iXG);
            this.iXQ = (int) (l.dip2px(getContext(), pendantData.right) * this.iXG);
            this.iXR = (int) (l.dip2px(getContext(), pendantData.bottom) * this.iXG);
            this.mContentView.setPadding(this.iXO, this.iXP, this.iXQ, this.iXR);
            this.iXN = l.h(getContext(), d.e.fontsize40) * this.iXG;
            String text = getText();
            this.iXT = (i2 - this.iXP) - this.iXR;
            this.iXU = (i - this.iXO) - this.iXQ;
            this.iXW = this.iXV + l.h(getContext(), d.e.ds6);
            setTextSize(0, this.iXN);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.j.cover_hint), this.iXU);
                this.iXN = this.iXu.getTextSize();
                cjR();
                cjS();
            } else {
                if (ab.pP(text) > 20) {
                    text = ab.af(text, 20);
                    this.iXu.setText(text);
                    this.iXt.setText(text);
                }
                DD(text);
            }
        }
        this.iXt.setIncludeFontPadding(false);
        this.iXu.setIncludeFontPadding(false);
        this.iXt.setLineSpacing(this.iXV, 1.0f);
        this.iXu.setLineSpacing(this.iXV, 1.0f);
        this.iXr.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.iXr.getLayoutParams();
        layoutParams3.height = (this.iXS * 2) + i2;
        layoutParams3.width = (this.iXS * 2) + i;
        this.iXr.setLayoutParams(layoutParams3);
        this.iXX = (this.iXS * 2) + i;
        ((FrameLayout.LayoutParams) this.iXs.getLayoutParams()).setMargins(this.iXS, this.iXS, this.iXS, this.iXS);
        this.iXr.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.iXZ == null) {
            cjT();
        }
        return this.iXZ;
    }

    private void cjT() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.iXZ = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cjU() {
        if (this.iXZ != null && !this.iXZ.isRecycled()) {
            this.iXZ.recycle();
            this.iXZ = null;
        }
    }

    public void qB(boolean z) {
        if (this.iXx != 0) {
            if (z) {
                cjU();
                this.iXr.setVisibility(0);
                return;
            }
            bUW();
            getTempBitmap();
            this.iXr.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.iXY.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.iXY.clear();
        this.iXY = null;
        cjU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> iYb;
        WeakReference<CoverPendantDragView> iYc;
        WeakReference<PendantData> iYd;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.iYb = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.iYc = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.iYd = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ed(String str, String str2) {
            if (this.iYb != null && this.iYb.get() != null) {
                this.iYb.get().iWm.setVisibility(8);
            }
            if (this.iYc != null && this.iYc.get() != null && this.iYd != null && this.iYd.get() != null) {
                this.iYc.get().a(str2, this.iYd.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Ds(String str) {
            if (this.iYb != null && this.iYb.get() != null) {
                this.iYb.get().iWm.setVisibility(8);
            }
            if (this.iYc != null && this.iYc.get() != null) {
                l.showToast(this.iYc.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ciW() {
            if (this.iYb != null && this.iYb.get() != null) {
                this.iYb.get().iWm.setVisibility(8);
            }
        }
    }
}
