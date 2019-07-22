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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Oj;
    private float Ok;
    private float cQM;
    private float fcT;
    float fxF;
    float fxG;
    private float iKa;
    private RotateFrameLayout jwA;
    private TextView jwB;
    private EditText jwC;
    private ImageView jwD;
    private ImageView jwE;
    private int jwF;
    private boolean jwG;
    private float jwH;
    private float jwI;
    private int jwJ;
    private int jwK;
    private float jwL;
    private float jwM;
    private float jwN;
    private float jwO;
    private b jwP;
    private float jwQ;
    private float jwR;
    private float jwS;
    private float jwT;
    private boolean jwU;
    private float jwV;
    private int jwW;
    private int jwX;
    private int jwY;
    private int jwZ;
    private FrameLayout jwz;
    private int jxa;
    private float jxb;
    private float jxc;
    private int jxd;
    private float jxe;
    private int jxf;
    private Map<String, Bitmap> jxg;
    private Bitmap jxh;
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
        this.jwF = 0;
        this.jwO = 1.0f;
        this.iKa = 1.0f;
        this.jwU = true;
        this.jxg = new HashMap();
        this.startTime = 0L;
        this.fxF = 0.0f;
        this.fxG = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jwV = l.g(getContext(), R.dimen.fontsize40);
        this.jxd = l.g(getContext(), R.dimen.ds2);
        this.fcT = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jwz = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jwz);
        this.jwz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jwF == 4) {
                            CoverPendantDragView.this.cuI();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cQM);
                        if (!CoverPendantDragView.this.jwG && abs < CoverPendantDragView.this.fcT && abs2 < CoverPendantDragView.this.fcT && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cuJ();
                        }
                        CoverPendantDragView.this.jwH = 0.0f;
                        CoverPendantDragView.this.jwI = 0.0f;
                        CoverPendantDragView.this.jwG = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.N(motionEvent)) {
                            CoverPendantDragView.this.P(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.jwH = 0.0f;
                        CoverPendantDragView.this.jwI = 0.0f;
                        return true;
                }
            }
        });
        this.jwD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jwC.setText("");
                CoverPendantDragView.this.cfS();
            }
        });
        this.jwE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jwI = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.N(motionEvent)) {
                            CoverPendantDragView.this.O(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.jwC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jwF != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jwB.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ab.rp(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jwB.getText().length()) {
                        CoverPendantDragView.this.FP(obj);
                    } else {
                        CoverPendantDragView.this.FO(obj);
                    }
                } else {
                    String ab = ab.ab(obj, 20);
                    editable.delete(ab.length(), obj.length());
                    CoverPendantDragView.this.FP(ab);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jwB.setText(editable.toString());
            }
        });
        this.jwC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jwz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cQM = motionEvent.getRawY();
        this.Oj = this.mDownX;
        this.Ok = this.cQM;
        this.jwL = (this.jwz.getWidth() / 2) + this.jwz.getX();
        this.jwM = (this.jwz.getHeight() / 2) + this.jwz.getY();
        this.jwB.setText(this.jwC.getText());
        this.jwB.setVisibility(0);
        this.jwC.setVisibility(8);
        setEditTextEnable(false);
        this.jwP.HidenSoftKeyPad(this.jwC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(String str) {
        TextPaint paint = this.jwC.getPaint();
        float measureText = paint.measureText(str);
        while (this.jwC.getLineCount() == 1 && this.jwC.getTextSize() < this.jwV * this.iKa && measureText < this.jxc * this.iKa) {
            setTextSize(0, this.jwC.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.rp(str) <= ab.rp(getResources().getString(R.string.cover_hint)) && this.jwC.getTextSize() != this.jwV * this.iKa) {
            setTextSize(0, this.jwV * this.iKa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        TextPaint paint = this.jwC.getPaint();
        float measureText = paint.measureText(str);
        while (this.jwC.getTextSize() > ((this.jxb * this.iKa) / 2.0f) - (this.jxe * this.iKa) && measureText > this.jxc * this.iKa) {
            setTextSize(0, this.jwC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jwC.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jwC.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.g(getContext(), R.dimen.ds120)) {
            str = ab.ad(str, ab.ro(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.jwP = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jwQ = f;
        this.jwR = f2;
        this.jwS = f3;
        this.jwT = f4;
        if (this.jwQ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jwQ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jwR > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jwR);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jwS > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jwS) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jwT > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jwT) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float R = R(motionEvent);
        float abs = Math.abs(this.Oj - rawX);
        float abs2 = Math.abs(this.Ok - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.jwL - rawX);
        float abs4 = Math.abs(this.jwM - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jwL - this.Oj);
        float abs6 = Math.abs(this.jwM - this.Ok);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cF(sqrt, (int) (sqrt / this.jwN));
        if (this.jwI != 0.0f) {
            this.jwz.setRotation(this.jwz.getRotation() - (this.jwI - R));
        }
        this.jwI = R;
        this.Oj = rawX;
        this.Ok = rawY;
    }

    private void cF(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jwz.getLayoutParams();
        int width = this.jwz.getWidth() - i;
        int i3 = (int) (width / this.jwN);
        if (width < this.jwJ) {
            width = this.jwJ;
            i3 = (int) (width / this.jwN);
        }
        this.iKa = ((width * 1.0f) - (this.jxa * 2)) / (this.jxf - (this.jxa * 2));
        this.mContentView.setPadding((int) (this.jwW * this.iKa), (int) (this.jwX * this.iKa), (int) (this.jwY * this.iKa), (int) (this.jwZ * this.iKa));
        setTextSize(0, (this.jwC.getTextSize() * i3) / this.jwz.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jwz.setLayoutParams(layoutParams);
        float f = this.jwL - (layoutParams.width / 2);
        float f2 = this.jwM - (layoutParams.height / 2);
        this.jwz.setX(f);
        this.jwz.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jwF != 4) {
            float y = (this.jwz.getY() + rawY) - this.Ok;
            if (y < this.jwR) {
                y = this.jwR;
            } else if (y > (this.jwR + this.mVideoHeight) - this.jwz.getHeight()) {
                y = (this.jwR + this.mVideoHeight) - this.jwz.getHeight();
            }
            this.jwz.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jwG = true;
                float S = S(motionEvent);
                float Q = Q(motionEvent);
                if (this.jwH != 0.0f) {
                    int i = (int) (this.jwH - S);
                    cF(i, (int) (i / this.jwN));
                }
                if (this.jwI != 0.0f) {
                    this.jwz.setRotation(this.jwz.getRotation() - (this.jwI - Q));
                }
                this.jwI = Q;
                this.jwH = S;
            } else if (!this.jwG && pointerCount == 1) {
                float y2 = (this.jwz.getY() + rawY) - this.Ok;
                if (y2 < this.jwR - (this.jwz.getHeight() / 2)) {
                    y2 = this.jwR - (this.jwz.getHeight() / 2);
                } else if (y2 > ((this.jwR + this.mVideoHeight) - this.jwz.getHeight()) + (this.jwz.getHeight() / 2)) {
                    y2 = ((this.jwR + this.mVideoHeight) - this.jwz.getHeight()) + (this.jwz.getHeight() / 2);
                }
                float x = (this.jwz.getX() + rawX) - this.Oj;
                if (x < this.jwQ - (this.jwz.getWidth() / 2)) {
                    x = this.jwQ - (this.jwz.getWidth() / 2);
                } else if (x > ((this.jwQ + this.mVideoWidth) - this.jwz.getWidth()) + (this.jwz.getWidth() / 2)) {
                    x = ((this.jwQ + this.mVideoWidth) - this.jwz.getWidth()) + (this.jwz.getWidth() / 2);
                }
                this.jwz.setX(x);
                this.jwz.setY(y2);
            }
        }
        this.Oj = rawX;
        this.Ok = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jwC.getTextSize() != f) {
            this.jwC.setTextSize(i, f);
        }
        if (this.jwB.getTextSize() != f) {
            this.jwB.setTextSize(i, f);
        }
    }

    private float Q(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.jwz.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float R(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jwM - motionEvent.getRawY(), this.jwL - motionEvent.getRawX()));
    }

    private float S(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fcT && Math.abs(motionEvent.getRawY() - this.cQM) < this.fcT;
    }

    private void init() {
        this.jwA = (RotateFrameLayout) this.jwz.findViewById(R.id.content_container);
        this.jwB = (TextView) this.jwz.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jwz.findViewById(R.id.content_view);
        this.jwC = (EditText) this.jwz.findViewById(R.id.cover_edit);
        this.jwD = (ImageView) this.jwz.findViewById(R.id.cover_delete);
        this.jwE = (ImageView) this.jwz.findViewById(R.id.cover_scale);
    }

    public void cfS() {
        this.jwB.setText(this.jwC.getText());
        this.jwB.setVisibility(0);
        this.jwC.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jwB.getText())) {
            this.jwF = 0;
            this.jwz.setVisibility(8);
        }
        if (this.jwF == 4) {
            cuH();
        }
        this.jwP.HidenSoftKeyPad(this.jwC);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jwC.setFocusable(true);
            this.jwC.setFocusableInTouchMode(true);
            this.jwC.requestFocus();
            return;
        }
        this.jwC.setFocusable(false);
        this.jwC.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jwC.setText("");
                    cfS();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    cuJ();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    cuJ();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    cuJ();
                    break;
                default:
                    cfS();
                    String FN = com.baidu.tieba.video.editvideo.model.b.cuC().FN(pendantData.resource);
                    if (TextUtils.isEmpty(FN)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jvv.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cuC().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(FN, pendantData);
                        break;
                    }
                    break;
            }
            this.jwF = pendantData.pendantType;
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
        cuH();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jwF == 4 || this.jwF == 0) {
            this.jwz.setX(this.jwQ);
            this.jwz.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jwR);
            String obj = this.jwC.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jwC.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jwB.setText(a2);
                    this.jwC.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cuH() {
        if (this.jwU) {
            this.jwU = false;
            this.jwD.setVisibility(8);
            this.jwE.setVisibility(8);
            this.jwA.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        if (!this.jwU) {
            this.jwU = true;
            this.jwD.setVisibility(0);
            this.jwE.setVisibility(0);
            this.jwA.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jxg != null) {
            Bitmap bitmap = this.jxg.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jxg.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cuH();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jwO = 1.0f;
                this.iKa = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jwO = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jwJ = (this.jxa * 2) + width;
                this.jwK = (this.jxa * 2) + height;
                this.jwN = (this.jwJ * 1.0f) / this.jwK;
                this.jwz.setX((((this.mVideoWidth - i2) - (this.jxa * 2)) / 2) + this.jwQ);
                this.jwz.setY((((this.mVideoHeight - i) - (this.jxa * 2)) / 2) + this.jwR);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fxF = motionEvent.getRawX();
                this.fxG = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fxF);
                float abs2 = Math.abs(rawY - this.fxG);
                if (motionEvent.getPointerCount() <= 1 && abs < this.fcT && abs2 < this.fcT && System.currentTimeMillis() - this.startTime < 300) {
                    cfS();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jwB == null || this.jwB.getText() == null) {
            return null;
        }
        return this.jwB.getText().toString();
    }

    public void cuJ() {
        this.jwB.setText(this.jwC.getText());
        this.jwB.setVisibility(8);
        this.jwC.setVisibility(0);
        setEditTextEnable(true);
        this.jwP.ShowSoftKeyPad(this.jwC);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jwC.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jwB.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jxa = 0;
            this.jwC.setMaxLines(1);
            this.jwB.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jwB.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jwC.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jwC.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jwB.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jxa = l.g(getContext(), R.dimen.ds40);
            this.jwC.setMaxLines(2);
            this.jwB.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jwB.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jwC.setLayoutParams(layoutParams2);
            this.jwW = (int) (l.dip2px(getContext(), pendantData.left) * this.jwO);
            this.jwX = (int) (l.dip2px(getContext(), pendantData.top) * this.jwO);
            this.jwY = (int) (l.dip2px(getContext(), pendantData.right) * this.jwO);
            this.jwZ = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jwO);
            this.mContentView.setPadding(this.jwW, this.jwX, this.jwY, this.jwZ);
            this.jwV = l.g(getContext(), R.dimen.fontsize40) * this.jwO;
            String text = getText();
            this.jxb = (i2 - this.jwX) - this.jwZ;
            this.jxc = (i - this.jwW) - this.jwY;
            this.jxe = this.jxd + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jwV);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jxc);
                this.jwV = this.jwC.getTextSize();
                cuI();
                cuJ();
            } else {
                if (ab.rp(text) > 20) {
                    text = ab.ab(text, 20);
                    this.jwC.setText(text);
                    this.jwB.setText(text);
                }
                FP(text);
            }
        }
        this.jwB.setIncludeFontPadding(false);
        this.jwC.setIncludeFontPadding(false);
        this.jwB.setLineSpacing(this.jxd, 1.0f);
        this.jwC.setLineSpacing(this.jxd, 1.0f);
        this.jwz.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jwz.getLayoutParams();
        layoutParams3.height = (this.jxa * 2) + i2;
        layoutParams3.width = (this.jxa * 2) + i;
        this.jwz.setLayoutParams(layoutParams3);
        this.jxf = (this.jxa * 2) + i;
        ((FrameLayout.LayoutParams) this.jwA.getLayoutParams()).setMargins(this.jxa, this.jxa, this.jxa, this.jxa);
        this.jwz.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jxh == null) {
            cuK();
        }
        return this.jxh;
    }

    private void cuK() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jxh = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cuL() {
        if (this.jxh != null && !this.jxh.isRecycled()) {
            this.jxh.recycle();
            this.jxh = null;
        }
    }

    public void rE(boolean z) {
        if (this.jwF != 0) {
            if (z) {
                cuL();
                this.jwz.setVisibility(0);
                return;
            }
            cfS();
            getTempBitmap();
            this.jwz.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jxg.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jxg.clear();
        this.jxg = null;
        cuL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jxj;
        WeakReference<CoverPendantDragView> jxk;
        WeakReference<PendantData> jxl;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jxj = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jxk = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jxl = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void es(String str, String str2) {
            if (this.jxj != null && this.jxj.get() != null) {
                this.jxj.get().jvv.setVisibility(8);
            }
            if (this.jxk != null && this.jxk.get() != null && this.jxl != null && this.jxl.get() != null) {
                this.jxk.get().a(str2, this.jxl.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void FE(String str) {
            if (this.jxj != null && this.jxj.get() != null) {
                this.jxj.get().jvv.setVisibility(8);
            }
            if (this.jxk != null && this.jxk.get() != null) {
                l.showToast(this.jxk.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ctN() {
            if (this.jxj != null && this.jxj.get() != null) {
                this.jxj.get().jvv.setVisibility(8);
            }
        }
    }
}
