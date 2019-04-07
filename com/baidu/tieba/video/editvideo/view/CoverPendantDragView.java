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
    private float cHf;
    private float eHH;
    float fcu;
    float fcv;
    private int iXA;
    private int iXB;
    private float iXC;
    private float iXD;
    private float iXE;
    private float iXF;
    private b iXG;
    private float iXH;
    private float iXI;
    private float iXJ;
    private float iXK;
    private boolean iXL;
    private float iXM;
    private int iXN;
    private int iXO;
    private int iXP;
    private int iXQ;
    private int iXR;
    private float iXS;
    private float iXT;
    private int iXU;
    private float iXV;
    private int iXW;
    private Map<String, Bitmap> iXX;
    private Bitmap iXY;
    private FrameLayout iXq;
    private RotateFrameLayout iXr;
    private TextView iXs;
    private EditText iXt;
    private ImageView iXu;
    private ImageView iXv;
    private int iXw;
    private boolean iXx;
    private float iXy;
    private float iXz;
    private float ikS;
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
        this.iXw = 0;
        this.iXF = 1.0f;
        this.ikS = 1.0f;
        this.iXL = true;
        this.iXX = new HashMap();
        this.startTime = 0L;
        this.fcu = 0.0f;
        this.fcv = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.iXM = l.h(getContext(), d.e.fontsize40);
        this.iXU = l.h(getContext(), d.e.ds2);
        this.eHH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.iXq = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.iXq);
        this.iXq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.iXw == 4) {
                            CoverPendantDragView.this.cjR();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cHf);
                        if (!CoverPendantDragView.this.iXx && abs < CoverPendantDragView.this.eHH && abs2 < CoverPendantDragView.this.eHH && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cjS();
                        }
                        CoverPendantDragView.this.iXy = 0.0f;
                        CoverPendantDragView.this.iXz = 0.0f;
                        CoverPendantDragView.this.iXx = false;
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
                        CoverPendantDragView.this.iXy = 0.0f;
                        CoverPendantDragView.this.iXz = 0.0f;
                        return true;
                }
            }
        });
        this.iXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.iXt.setText("");
                CoverPendantDragView.this.bUW();
            }
        });
        this.iXv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.iXz = 0.0f;
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
        this.iXt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.iXw != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.iXs.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (ab.pP(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.iXs.getText().length()) {
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
                CoverPendantDragView.this.iXs.setText(editable.toString());
            }
        });
        this.iXt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.iXq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cHf = motionEvent.getRawY();
        this.Ql = this.mDownX;
        this.Qm = this.cHf;
        this.iXC = (this.iXq.getWidth() / 2) + this.iXq.getX();
        this.iXD = (this.iXq.getHeight() / 2) + this.iXq.getY();
        this.iXs.setText(this.iXt.getText());
        this.iXs.setVisibility(0);
        this.iXt.setVisibility(8);
        setEditTextEnable(false);
        this.iXG.HidenSoftKeyPad(this.iXt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC(String str) {
        TextPaint paint = this.iXt.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXt.getLineCount() == 1 && this.iXt.getTextSize() < this.iXM * this.ikS && measureText < this.iXT * this.ikS) {
            setTextSize(0, this.iXt.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.pP(str) <= ab.pP(getResources().getString(d.j.cover_hint)) && this.iXt.getTextSize() != this.iXM * this.ikS) {
            setTextSize(0, this.iXM * this.ikS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        TextPaint paint = this.iXt.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXt.getTextSize() > ((this.iXS * this.ikS) / 2.0f) - (this.iXV * this.ikS) && measureText > this.iXT * this.ikS) {
            setTextSize(0, this.iXt.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.iXt.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.iXt.getTextSize() - 1.0f);
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
        this.iXG = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.iXH = f;
        this.iXI = f2;
        this.iXJ = f3;
        this.iXK = f4;
        if (this.iXH > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.iXH, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.iXI > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.iXI);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.iXJ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.iXJ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.iXK > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.iXK) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.iXC - rawX);
        float abs4 = Math.abs(this.iXD - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.iXC - this.Ql);
        float abs6 = Math.abs(this.iXD - this.Qm);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        ct(sqrt, (int) (sqrt / this.iXE));
        if (this.iXz != 0.0f) {
            this.iXq.setRotation(this.iXq.getRotation() - (this.iXz - N));
        }
        this.iXz = N;
        this.Ql = rawX;
        this.Qm = rawY;
    }

    private void ct(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXq.getLayoutParams();
        int width = this.iXq.getWidth() - i;
        int i3 = (int) (width / this.iXE);
        if (width < this.iXA) {
            width = this.iXA;
            i3 = (int) (width / this.iXE);
        }
        this.ikS = ((width * 1.0f) - (this.iXR * 2)) / (this.iXW - (this.iXR * 2));
        this.mContentView.setPadding((int) (this.iXN * this.ikS), (int) (this.iXO * this.ikS), (int) (this.iXP * this.ikS), (int) (this.iXQ * this.ikS));
        setTextSize(0, (this.iXt.getTextSize() * i3) / this.iXq.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.iXq.setLayoutParams(layoutParams);
        float f = this.iXC - (layoutParams.width / 2);
        float f2 = this.iXD - (layoutParams.height / 2);
        this.iXq.setX(f);
        this.iXq.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.iXw != 4) {
            float y = (this.iXq.getY() + rawY) - this.Qm;
            if (y < this.iXI) {
                y = this.iXI;
            } else if (y > (this.iXI + this.mVideoHeight) - this.iXq.getHeight()) {
                y = (this.iXI + this.mVideoHeight) - this.iXq.getHeight();
            }
            this.iXq.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.iXx = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.iXy != 0.0f) {
                    int i = (int) (this.iXy - O);
                    ct(i, (int) (i / this.iXE));
                }
                if (this.iXz != 0.0f) {
                    this.iXq.setRotation(this.iXq.getRotation() - (this.iXz - M));
                }
                this.iXz = M;
                this.iXy = O;
            } else if (!this.iXx && pointerCount == 1) {
                float y2 = (this.iXq.getY() + rawY) - this.Qm;
                if (y2 < this.iXI - (this.iXq.getHeight() / 2)) {
                    y2 = this.iXI - (this.iXq.getHeight() / 2);
                } else if (y2 > ((this.iXI + this.mVideoHeight) - this.iXq.getHeight()) + (this.iXq.getHeight() / 2)) {
                    y2 = ((this.iXI + this.mVideoHeight) - this.iXq.getHeight()) + (this.iXq.getHeight() / 2);
                }
                float x = (this.iXq.getX() + rawX) - this.Ql;
                if (x < this.iXH - (this.iXq.getWidth() / 2)) {
                    x = this.iXH - (this.iXq.getWidth() / 2);
                } else if (x > ((this.iXH + this.mVideoWidth) - this.iXq.getWidth()) + (this.iXq.getWidth() / 2)) {
                    x = ((this.iXH + this.mVideoWidth) - this.iXq.getWidth()) + (this.iXq.getWidth() / 2);
                }
                this.iXq.setX(x);
                this.iXq.setY(y2);
            }
        }
        this.Ql = rawX;
        this.Qm = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.iXt.getTextSize() != f) {
            this.iXt.setTextSize(i, f);
        }
        if (this.iXs.getTextSize() != f) {
            this.iXs.setTextSize(i, f);
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
        matrix.postRotate(this.iXq.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.iXD - motionEvent.getRawY(), this.iXC - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHH && Math.abs(motionEvent.getRawY() - this.cHf) < this.eHH;
    }

    private void init() {
        this.iXr = (RotateFrameLayout) this.iXq.findViewById(d.g.content_container);
        this.iXs = (TextView) this.iXq.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.iXq.findViewById(d.g.content_view);
        this.iXt = (EditText) this.iXq.findViewById(d.g.cover_edit);
        this.iXu = (ImageView) this.iXq.findViewById(d.g.cover_delete);
        this.iXv = (ImageView) this.iXq.findViewById(d.g.cover_scale);
    }

    public void bUW() {
        this.iXs.setText(this.iXt.getText());
        this.iXs.setVisibility(0);
        this.iXt.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.iXs.getText())) {
            this.iXw = 0;
            this.iXq.setVisibility(8);
        }
        if (this.iXw == 4) {
            cjQ();
        }
        this.iXG.HidenSoftKeyPad(this.iXt);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.iXt.setFocusable(true);
            this.iXt.setFocusableInTouchMode(true);
            this.iXt.requestFocus();
            return;
        }
        this.iXt.setFocusable(false);
        this.iXt.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.iXt.setText("");
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
                            bVar.iWl.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cjL().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(DB, pendantData);
                        break;
                    }
                    break;
            }
            this.iXw = pendantData.pendantType;
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
        if (this.iXw == 4 || this.iXw == 0) {
            this.iXq.setX(this.iXH);
            this.iXq.setY(((this.mVideoHeight - l.h(getContext(), d.e.ds100)) / 2) + this.iXI);
            String obj = this.iXt.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.iXt.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.iXs.setText(a2);
                    this.iXt.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cjQ() {
        if (this.iXL) {
            this.iXL = false;
            this.iXu.setVisibility(8);
            this.iXv.setVisibility(8);
            this.iXr.setBackgroundColor(getResources().getColor(d.C0277d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjR() {
        if (!this.iXL) {
            this.iXL = true;
            this.iXu.setVisibility(0);
            this.iXv.setVisibility(0);
            this.iXr.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.iXX != null) {
            Bitmap bitmap = this.iXX.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.iXX.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cjQ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.iXF = 1.0f;
                this.ikS = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.iXF = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.iXA = (this.iXR * 2) + width;
                this.iXB = (this.iXR * 2) + height;
                this.iXE = (this.iXA * 1.0f) / this.iXB;
                this.iXq.setX((((this.mVideoWidth - i2) - (this.iXR * 2)) / 2) + this.iXH);
                this.iXq.setY((((this.mVideoHeight - i) - (this.iXR * 2)) / 2) + this.iXI);
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
                if (motionEvent.getPointerCount() <= 1 && abs < this.eHH && abs2 < this.eHH && System.currentTimeMillis() - this.startTime < 300) {
                    bUW();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.iXs == null || this.iXs.getText() == null) {
            return null;
        }
        return this.iXs.getText().toString();
    }

    public void cjS() {
        this.iXs.setText(this.iXt.getText());
        this.iXs.setVisibility(8);
        this.iXt.setVisibility(0);
        setEditTextEnable(true);
        this.iXG.ShowSoftKeyPad(this.iXt);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.iXt.setTextAppearance(getContext(), d.k.cover_text_style);
            this.iXs.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), d.e.fontsize40) * i) / i3);
            this.iXR = 0;
            this.iXt.setMaxLines(1);
            this.iXs.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXs.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.iXt.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), d.e.ds60), 0, l.h(getContext(), d.e.ds60), 0);
        } else {
            this.iXt.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iXs.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iXR = l.h(getContext(), d.e.ds40);
            this.iXt.setMaxLines(2);
            this.iXs.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iXs.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.iXt.setLayoutParams(layoutParams2);
            this.iXN = (int) (l.dip2px(getContext(), pendantData.left) * this.iXF);
            this.iXO = (int) (l.dip2px(getContext(), pendantData.top) * this.iXF);
            this.iXP = (int) (l.dip2px(getContext(), pendantData.right) * this.iXF);
            this.iXQ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.iXF);
            this.mContentView.setPadding(this.iXN, this.iXO, this.iXP, this.iXQ);
            this.iXM = l.h(getContext(), d.e.fontsize40) * this.iXF;
            String text = getText();
            this.iXS = (i2 - this.iXO) - this.iXQ;
            this.iXT = (i - this.iXN) - this.iXP;
            this.iXV = this.iXU + l.h(getContext(), d.e.ds6);
            setTextSize(0, this.iXM);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.j.cover_hint), this.iXT);
                this.iXM = this.iXt.getTextSize();
                cjR();
                cjS();
            } else {
                if (ab.pP(text) > 20) {
                    text = ab.af(text, 20);
                    this.iXt.setText(text);
                    this.iXs.setText(text);
                }
                DD(text);
            }
        }
        this.iXs.setIncludeFontPadding(false);
        this.iXt.setIncludeFontPadding(false);
        this.iXs.setLineSpacing(this.iXU, 1.0f);
        this.iXt.setLineSpacing(this.iXU, 1.0f);
        this.iXq.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.iXq.getLayoutParams();
        layoutParams3.height = (this.iXR * 2) + i2;
        layoutParams3.width = (this.iXR * 2) + i;
        this.iXq.setLayoutParams(layoutParams3);
        this.iXW = (this.iXR * 2) + i;
        ((FrameLayout.LayoutParams) this.iXr.getLayoutParams()).setMargins(this.iXR, this.iXR, this.iXR, this.iXR);
        this.iXq.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.iXY == null) {
            cjT();
        }
        return this.iXY;
    }

    private void cjT() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.iXY = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cjU() {
        if (this.iXY != null && !this.iXY.isRecycled()) {
            this.iXY.recycle();
            this.iXY = null;
        }
    }

    public void qB(boolean z) {
        if (this.iXw != 0) {
            if (z) {
                cjU();
                this.iXq.setVisibility(0);
                return;
            }
            bUW();
            getTempBitmap();
            this.iXq.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.iXX.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.iXX.clear();
        this.iXX = null;
        cjU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> iYa;
        WeakReference<CoverPendantDragView> iYb;
        WeakReference<PendantData> iYc;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.iYa = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.iYb = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.iYc = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ed(String str, String str2) {
            if (this.iYa != null && this.iYa.get() != null) {
                this.iYa.get().iWl.setVisibility(8);
            }
            if (this.iYb != null && this.iYb.get() != null && this.iYc != null && this.iYc.get() != null) {
                this.iYb.get().a(str2, this.iYc.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Ds(String str) {
            if (this.iYa != null && this.iYa.get() != null) {
                this.iYa.get().iWl.setVisibility(8);
            }
            if (this.iYb != null && this.iYb.get() != null) {
                l.showToast(this.iYb.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ciW() {
            if (this.iYa != null && this.iYa.get() != null) {
                this.iYa.get().iWl.setVisibility(8);
            }
        }
    }
}
