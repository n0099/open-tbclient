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
    private float cHd;
    private float eHV;
    float fcH;
    float fcI;
    private FrameLayout iXC;
    private RotateFrameLayout iXD;
    private TextView iXE;
    private EditText iXF;
    private ImageView iXG;
    private ImageView iXH;
    private int iXI;
    private boolean iXJ;
    private float iXK;
    private float iXL;
    private int iXM;
    private int iXN;
    private float iXO;
    private float iXP;
    private float iXQ;
    private float iXR;
    private b iXS;
    private float iXT;
    private float iXU;
    private float iXV;
    private float iXW;
    private boolean iXX;
    private float iXY;
    private int iXZ;
    private int iYa;
    private int iYb;
    private int iYc;
    private int iYd;
    private float iYe;
    private float iYf;
    private int iYg;
    private float iYh;
    private int iYi;
    private Map<String, Bitmap> iYj;
    private Bitmap iYk;
    private float ilg;
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
        this.iXI = 0;
        this.iXR = 1.0f;
        this.ilg = 1.0f;
        this.iXX = true;
        this.iYj = new HashMap();
        this.startTime = 0L;
        this.fcH = 0.0f;
        this.fcI = 0.0f;
        this.mScreenWidth = l.aO(TbadkCoreApplication.getInst());
        this.iXY = l.h(getContext(), d.e.fontsize40);
        this.iYg = l.h(getContext(), d.e.ds2);
        this.eHV = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.iXC = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.iXC);
        this.iXC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.iXI == 4) {
                            CoverPendantDragView.this.cjT();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cHd);
                        if (!CoverPendantDragView.this.iXJ && abs < CoverPendantDragView.this.eHV && abs2 < CoverPendantDragView.this.eHV && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cjU();
                        }
                        CoverPendantDragView.this.iXK = 0.0f;
                        CoverPendantDragView.this.iXL = 0.0f;
                        CoverPendantDragView.this.iXJ = false;
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
                        CoverPendantDragView.this.iXK = 0.0f;
                        CoverPendantDragView.this.iXL = 0.0f;
                        return true;
                }
            }
        });
        this.iXG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.iXF.setText("");
                CoverPendantDragView.this.bVa();
            }
        });
        this.iXH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.iXL = 0.0f;
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
        this.iXF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.iXI != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.iXE.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (ab.pO(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.iXE.getText().length()) {
                        CoverPendantDragView.this.DE(obj);
                    } else {
                        CoverPendantDragView.this.DD(obj);
                    }
                } else {
                    String af = ab.af(obj, 20);
                    editable.delete(af.length(), obj.length());
                    CoverPendantDragView.this.DE(af);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.iXE.setText(editable.toString());
            }
        });
        this.iXF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.iXC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cHd = motionEvent.getRawY();
        this.Ql = this.mDownX;
        this.Qm = this.cHd;
        this.iXO = (this.iXC.getWidth() / 2) + this.iXC.getX();
        this.iXP = (this.iXC.getHeight() / 2) + this.iXC.getY();
        this.iXE.setText(this.iXF.getText());
        this.iXE.setVisibility(0);
        this.iXF.setVisibility(8);
        setEditTextEnable(false);
        this.iXS.HidenSoftKeyPad(this.iXF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        TextPaint paint = this.iXF.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXF.getLineCount() == 1 && this.iXF.getTextSize() < this.iXY * this.ilg && measureText < this.iYf * this.ilg) {
            setTextSize(0, this.iXF.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.pO(str) <= ab.pO(getResources().getString(d.j.cover_hint)) && this.iXF.getTextSize() != this.iXY * this.ilg) {
            setTextSize(0, this.iXY * this.ilg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(String str) {
        TextPaint paint = this.iXF.getPaint();
        float measureText = paint.measureText(str);
        while (this.iXF.getTextSize() > ((this.iYe * this.ilg) / 2.0f) - (this.iYh * this.ilg) && measureText > this.iYf * this.ilg) {
            setTextSize(0, this.iXF.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.iXF.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.iXF.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.h(getContext(), d.e.ds120)) {
            str = ab.ah(str, ab.pN(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.iXS = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.iXT = f;
        this.iXU = f2;
        this.iXV = f3;
        this.iXW = f4;
        if (this.iXT > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.iXT, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.iXU > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.iXU);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.iXV > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.iXV) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.iXW > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.iXW) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.iXO - rawX);
        float abs4 = Math.abs(this.iXP - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.iXO - this.Ql);
        float abs6 = Math.abs(this.iXP - this.Qm);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        ct(sqrt, (int) (sqrt / this.iXQ));
        if (this.iXL != 0.0f) {
            this.iXC.setRotation(this.iXC.getRotation() - (this.iXL - N));
        }
        this.iXL = N;
        this.Ql = rawX;
        this.Qm = rawY;
    }

    private void ct(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXC.getLayoutParams();
        int width = this.iXC.getWidth() - i;
        int i3 = (int) (width / this.iXQ);
        if (width < this.iXM) {
            width = this.iXM;
            i3 = (int) (width / this.iXQ);
        }
        this.ilg = ((width * 1.0f) - (this.iYd * 2)) / (this.iYi - (this.iYd * 2));
        this.mContentView.setPadding((int) (this.iXZ * this.ilg), (int) (this.iYa * this.ilg), (int) (this.iYb * this.ilg), (int) (this.iYc * this.ilg));
        setTextSize(0, (this.iXF.getTextSize() * i3) / this.iXC.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.iXC.setLayoutParams(layoutParams);
        float f = this.iXO - (layoutParams.width / 2);
        float f2 = this.iXP - (layoutParams.height / 2);
        this.iXC.setX(f);
        this.iXC.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.iXI != 4) {
            float y = (this.iXC.getY() + rawY) - this.Qm;
            if (y < this.iXU) {
                y = this.iXU;
            } else if (y > (this.iXU + this.mVideoHeight) - this.iXC.getHeight()) {
                y = (this.iXU + this.mVideoHeight) - this.iXC.getHeight();
            }
            this.iXC.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.iXJ = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.iXK != 0.0f) {
                    int i = (int) (this.iXK - O);
                    ct(i, (int) (i / this.iXQ));
                }
                if (this.iXL != 0.0f) {
                    this.iXC.setRotation(this.iXC.getRotation() - (this.iXL - M));
                }
                this.iXL = M;
                this.iXK = O;
            } else if (!this.iXJ && pointerCount == 1) {
                float y2 = (this.iXC.getY() + rawY) - this.Qm;
                if (y2 < this.iXU - (this.iXC.getHeight() / 2)) {
                    y2 = this.iXU - (this.iXC.getHeight() / 2);
                } else if (y2 > ((this.iXU + this.mVideoHeight) - this.iXC.getHeight()) + (this.iXC.getHeight() / 2)) {
                    y2 = ((this.iXU + this.mVideoHeight) - this.iXC.getHeight()) + (this.iXC.getHeight() / 2);
                }
                float x = (this.iXC.getX() + rawX) - this.Ql;
                if (x < this.iXT - (this.iXC.getWidth() / 2)) {
                    x = this.iXT - (this.iXC.getWidth() / 2);
                } else if (x > ((this.iXT + this.mVideoWidth) - this.iXC.getWidth()) + (this.iXC.getWidth() / 2)) {
                    x = ((this.iXT + this.mVideoWidth) - this.iXC.getWidth()) + (this.iXC.getWidth() / 2);
                }
                this.iXC.setX(x);
                this.iXC.setY(y2);
            }
        }
        this.Ql = rawX;
        this.Qm = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.iXF.getTextSize() != f) {
            this.iXF.setTextSize(i, f);
        }
        if (this.iXE.getTextSize() != f) {
            this.iXE.setTextSize(i, f);
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
        matrix.postRotate(this.iXC.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.iXP - motionEvent.getRawY(), this.iXO - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHV && Math.abs(motionEvent.getRawY() - this.cHd) < this.eHV;
    }

    private void init() {
        this.iXD = (RotateFrameLayout) this.iXC.findViewById(d.g.content_container);
        this.iXE = (TextView) this.iXC.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.iXC.findViewById(d.g.content_view);
        this.iXF = (EditText) this.iXC.findViewById(d.g.cover_edit);
        this.iXG = (ImageView) this.iXC.findViewById(d.g.cover_delete);
        this.iXH = (ImageView) this.iXC.findViewById(d.g.cover_scale);
    }

    public void bVa() {
        this.iXE.setText(this.iXF.getText());
        this.iXE.setVisibility(0);
        this.iXF.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.iXE.getText())) {
            this.iXI = 0;
            this.iXC.setVisibility(8);
        }
        if (this.iXI == 4) {
            cjS();
        }
        this.iXS.HidenSoftKeyPad(this.iXF);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.iXF.setFocusable(true);
            this.iXF.setFocusableInTouchMode(true);
            this.iXF.requestFocus();
            return;
        }
        this.iXF.setFocusable(false);
        this.iXF.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.iXF.setText("");
                    bVa();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    cjU();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    cjU();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    cjU();
                    break;
                default:
                    bVa();
                    String DC = com.baidu.tieba.video.editvideo.model.b.cjN().DC(pendantData.resource);
                    if (TextUtils.isEmpty(DC)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.iWx.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cjN().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(DC, pendantData);
                        break;
                    }
                    break;
            }
            this.iXI = pendantData.pendantType;
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
        cjS();
        a(this.mVideoWidth, l.h(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.iXI == 4 || this.iXI == 0) {
            this.iXC.setX(this.iXT);
            this.iXC.setY(((this.mVideoHeight - l.h(getContext(), d.e.ds100)) / 2) + this.iXU);
            String obj = this.iXF.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.iXF.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.iXE.setText(a2);
                    this.iXF.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cjS() {
        if (this.iXX) {
            this.iXX = false;
            this.iXG.setVisibility(8);
            this.iXH.setVisibility(8);
            this.iXD.setBackgroundColor(getResources().getColor(d.C0277d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjT() {
        if (!this.iXX) {
            this.iXX = true;
            this.iXG.setVisibility(0);
            this.iXH.setVisibility(0);
            this.iXD.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.iYj != null) {
            Bitmap bitmap = this.iYj.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.iYj.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cjS();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.iXR = 1.0f;
                this.ilg = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.iXR = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.iXM = (this.iYd * 2) + width;
                this.iXN = (this.iYd * 2) + height;
                this.iXQ = (this.iXM * 1.0f) / this.iXN;
                this.iXC.setX((((this.mVideoWidth - i2) - (this.iYd * 2)) / 2) + this.iXT);
                this.iXC.setY((((this.mVideoHeight - i) - (this.iYd * 2)) / 2) + this.iXU);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fcH = motionEvent.getRawX();
                this.fcI = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fcH);
                float abs2 = Math.abs(rawY - this.fcI);
                if (motionEvent.getPointerCount() <= 1 && abs < this.eHV && abs2 < this.eHV && System.currentTimeMillis() - this.startTime < 300) {
                    bVa();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.iXE == null || this.iXE.getText() == null) {
            return null;
        }
        return this.iXE.getText().toString();
    }

    public void cjU() {
        this.iXE.setText(this.iXF.getText());
        this.iXE.setVisibility(8);
        this.iXF.setVisibility(0);
        setEditTextEnable(true);
        this.iXS.ShowSoftKeyPad(this.iXF);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.iXF.setTextAppearance(getContext(), d.k.cover_text_style);
            this.iXE.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.h(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.h(getContext(), d.e.fontsize40) * i) / i3);
            this.iYd = 0;
            this.iXF.setMaxLines(1);
            this.iXE.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXE.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.iXF.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.h(getContext(), d.e.ds60), 0, l.h(getContext(), d.e.ds60), 0);
        } else {
            this.iXF.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iXE.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.iYd = l.h(getContext(), d.e.ds40);
            this.iXF.setMaxLines(2);
            this.iXE.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iXE.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.iXF.setLayoutParams(layoutParams2);
            this.iXZ = (int) (l.dip2px(getContext(), pendantData.left) * this.iXR);
            this.iYa = (int) (l.dip2px(getContext(), pendantData.top) * this.iXR);
            this.iYb = (int) (l.dip2px(getContext(), pendantData.right) * this.iXR);
            this.iYc = (int) (l.dip2px(getContext(), pendantData.bottom) * this.iXR);
            this.mContentView.setPadding(this.iXZ, this.iYa, this.iYb, this.iYc);
            this.iXY = l.h(getContext(), d.e.fontsize40) * this.iXR;
            String text = getText();
            this.iYe = (i2 - this.iYa) - this.iYc;
            this.iYf = (i - this.iXZ) - this.iYb;
            this.iYh = this.iYg + l.h(getContext(), d.e.ds6);
            setTextSize(0, this.iXY);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(d.j.cover_hint), this.iYf);
                this.iXY = this.iXF.getTextSize();
                cjT();
                cjU();
            } else {
                if (ab.pO(text) > 20) {
                    text = ab.af(text, 20);
                    this.iXF.setText(text);
                    this.iXE.setText(text);
                }
                DE(text);
            }
        }
        this.iXE.setIncludeFontPadding(false);
        this.iXF.setIncludeFontPadding(false);
        this.iXE.setLineSpacing(this.iYg, 1.0f);
        this.iXF.setLineSpacing(this.iYg, 1.0f);
        this.iXC.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.iXC.getLayoutParams();
        layoutParams3.height = (this.iYd * 2) + i2;
        layoutParams3.width = (this.iYd * 2) + i;
        this.iXC.setLayoutParams(layoutParams3);
        this.iYi = (this.iYd * 2) + i;
        ((FrameLayout.LayoutParams) this.iXD.getLayoutParams()).setMargins(this.iYd, this.iYd, this.iYd, this.iYd);
        this.iXC.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.iYk == null) {
            cjV();
        }
        return this.iYk;
    }

    private void cjV() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.iYk = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cjW() {
        if (this.iYk != null && !this.iYk.isRecycled()) {
            this.iYk.recycle();
            this.iYk = null;
        }
    }

    public void qB(boolean z) {
        if (this.iXI != 0) {
            if (z) {
                cjW();
                this.iXC.setVisibility(0);
                return;
            }
            bVa();
            getTempBitmap();
            this.iXC.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.iYj.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.iYj.clear();
        this.iYj = null;
        cjW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> iYm;
        WeakReference<CoverPendantDragView> iYn;
        WeakReference<PendantData> iYo;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.iYm = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.iYn = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.iYo = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ec(String str, String str2) {
            if (this.iYm != null && this.iYm.get() != null) {
                this.iYm.get().iWx.setVisibility(8);
            }
            if (this.iYn != null && this.iYn.get() != null && this.iYo != null && this.iYo.get() != null) {
                this.iYn.get().a(str2, this.iYo.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Dt(String str) {
            if (this.iYm != null && this.iYm.get() != null) {
                this.iYm.get().iWx.setVisibility(8);
            }
            if (this.iYn != null && this.iYn.get() != null) {
                l.showToast(this.iYn.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ciY() {
            if (this.iYm != null && this.iYm.get() != null) {
                this.iYm.get().iWx.setVisibility(8);
            }
        }
    }
}
