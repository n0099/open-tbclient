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
    private float cQT;
    private float fdt;
    float fye;
    float fyf;
    private float iLe;
    private FrameLayout jxG;
    private RotateFrameLayout jxH;
    private TextView jxI;
    private EditText jxJ;
    private ImageView jxK;
    private ImageView jxL;
    private int jxM;
    private boolean jxN;
    private float jxO;
    private float jxP;
    private int jxQ;
    private int jxR;
    private float jxS;
    private float jxT;
    private float jxU;
    private float jxV;
    private b jxW;
    private float jxX;
    private float jxY;
    private float jxZ;
    private float jya;
    private boolean jyb;
    private float jyc;
    private int jyd;
    private int jye;
    private int jyf;
    private int jyg;
    private int jyh;
    private float jyi;
    private float jyj;
    private int jyk;
    private float jyl;
    private int jym;
    private Map<String, Bitmap> jyn;
    private Bitmap jyo;
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
        this.jxM = 0;
        this.jxV = 1.0f;
        this.iLe = 1.0f;
        this.jyb = true;
        this.jyn = new HashMap();
        this.startTime = 0L;
        this.fye = 0.0f;
        this.fyf = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jyc = l.g(getContext(), R.dimen.fontsize40);
        this.jyk = l.g(getContext(), R.dimen.ds2);
        this.fdt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jxG = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jxG);
        this.jxG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jxM == 4) {
                            CoverPendantDragView.this.cve();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cQT);
                        if (!CoverPendantDragView.this.jxN && abs < CoverPendantDragView.this.fdt && abs2 < CoverPendantDragView.this.fdt && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.cvf();
                        }
                        CoverPendantDragView.this.jxO = 0.0f;
                        CoverPendantDragView.this.jxP = 0.0f;
                        CoverPendantDragView.this.jxN = false;
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
                        CoverPendantDragView.this.jxO = 0.0f;
                        CoverPendantDragView.this.jxP = 0.0f;
                        return true;
                }
            }
        });
        this.jxK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jxJ.setText("");
                CoverPendantDragView.this.cgk();
            }
        });
        this.jxL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jxP = 0.0f;
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
        this.jxJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jxM != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jxI.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ab.rp(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jxI.getText().length()) {
                        CoverPendantDragView.this.FQ(obj);
                    } else {
                        CoverPendantDragView.this.FP(obj);
                    }
                } else {
                    String ab = ab.ab(obj, 20);
                    editable.delete(ab.length(), obj.length());
                    CoverPendantDragView.this.FQ(ab);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jxI.setText(editable.toString());
            }
        });
        this.jxJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jxG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cQT = motionEvent.getRawY();
        this.Oj = this.mDownX;
        this.Ok = this.cQT;
        this.jxS = (this.jxG.getWidth() / 2) + this.jxG.getX();
        this.jxT = (this.jxG.getHeight() / 2) + this.jxG.getY();
        this.jxI.setText(this.jxJ.getText());
        this.jxI.setVisibility(0);
        this.jxJ.setVisibility(8);
        setEditTextEnable(false);
        this.jxW.HidenSoftKeyPad(this.jxJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        TextPaint paint = this.jxJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.jxJ.getLineCount() == 1 && this.jxJ.getTextSize() < this.jyc * this.iLe && measureText < this.jyj * this.iLe) {
            setTextSize(0, this.jxJ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.rp(str) <= ab.rp(getResources().getString(R.string.cover_hint)) && this.jxJ.getTextSize() != this.jyc * this.iLe) {
            setTextSize(0, this.jyc * this.iLe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        TextPaint paint = this.jxJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.jxJ.getTextSize() > ((this.jyi * this.iLe) / 2.0f) - (this.jyl * this.iLe) && measureText > this.jyj * this.iLe) {
            setTextSize(0, this.jxJ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jxJ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jxJ.getTextSize() - 1.0f);
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
        this.jxW = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jxX = f;
        this.jxY = f2;
        this.jxZ = f3;
        this.jya = f4;
        if (this.jxX > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jxX, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jxY > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jxY);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jxZ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jxZ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jya > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jya) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.jxS - rawX);
        float abs4 = Math.abs(this.jxT - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jxS - this.Oj);
        float abs6 = Math.abs(this.jxT - this.Ok);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cF(sqrt, (int) (sqrt / this.jxU));
        if (this.jxP != 0.0f) {
            this.jxG.setRotation(this.jxG.getRotation() - (this.jxP - R));
        }
        this.jxP = R;
        this.Oj = rawX;
        this.Ok = rawY;
    }

    private void cF(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jxG.getLayoutParams();
        int width = this.jxG.getWidth() - i;
        int i3 = (int) (width / this.jxU);
        if (width < this.jxQ) {
            width = this.jxQ;
            i3 = (int) (width / this.jxU);
        }
        this.iLe = ((width * 1.0f) - (this.jyh * 2)) / (this.jym - (this.jyh * 2));
        this.mContentView.setPadding((int) (this.jyd * this.iLe), (int) (this.jye * this.iLe), (int) (this.jyf * this.iLe), (int) (this.jyg * this.iLe));
        setTextSize(0, (this.jxJ.getTextSize() * i3) / this.jxG.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jxG.setLayoutParams(layoutParams);
        float f = this.jxS - (layoutParams.width / 2);
        float f2 = this.jxT - (layoutParams.height / 2);
        this.jxG.setX(f);
        this.jxG.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jxM != 4) {
            float y = (this.jxG.getY() + rawY) - this.Ok;
            if (y < this.jxY) {
                y = this.jxY;
            } else if (y > (this.jxY + this.mVideoHeight) - this.jxG.getHeight()) {
                y = (this.jxY + this.mVideoHeight) - this.jxG.getHeight();
            }
            this.jxG.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jxN = true;
                float S = S(motionEvent);
                float Q = Q(motionEvent);
                if (this.jxO != 0.0f) {
                    int i = (int) (this.jxO - S);
                    cF(i, (int) (i / this.jxU));
                }
                if (this.jxP != 0.0f) {
                    this.jxG.setRotation(this.jxG.getRotation() - (this.jxP - Q));
                }
                this.jxP = Q;
                this.jxO = S;
            } else if (!this.jxN && pointerCount == 1) {
                float y2 = (this.jxG.getY() + rawY) - this.Ok;
                if (y2 < this.jxY - (this.jxG.getHeight() / 2)) {
                    y2 = this.jxY - (this.jxG.getHeight() / 2);
                } else if (y2 > ((this.jxY + this.mVideoHeight) - this.jxG.getHeight()) + (this.jxG.getHeight() / 2)) {
                    y2 = ((this.jxY + this.mVideoHeight) - this.jxG.getHeight()) + (this.jxG.getHeight() / 2);
                }
                float x = (this.jxG.getX() + rawX) - this.Oj;
                if (x < this.jxX - (this.jxG.getWidth() / 2)) {
                    x = this.jxX - (this.jxG.getWidth() / 2);
                } else if (x > ((this.jxX + this.mVideoWidth) - this.jxG.getWidth()) + (this.jxG.getWidth() / 2)) {
                    x = ((this.jxX + this.mVideoWidth) - this.jxG.getWidth()) + (this.jxG.getWidth() / 2);
                }
                this.jxG.setX(x);
                this.jxG.setY(y2);
            }
        }
        this.Oj = rawX;
        this.Ok = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jxJ.getTextSize() != f) {
            this.jxJ.setTextSize(i, f);
        }
        if (this.jxI.getTextSize() != f) {
            this.jxI.setTextSize(i, f);
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
        matrix.postRotate(this.jxG.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float R(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jxT - motionEvent.getRawY(), this.jxS - motionEvent.getRawX()));
    }

    private float S(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fdt && Math.abs(motionEvent.getRawY() - this.cQT) < this.fdt;
    }

    private void init() {
        this.jxH = (RotateFrameLayout) this.jxG.findViewById(R.id.content_container);
        this.jxI = (TextView) this.jxG.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jxG.findViewById(R.id.content_view);
        this.jxJ = (EditText) this.jxG.findViewById(R.id.cover_edit);
        this.jxK = (ImageView) this.jxG.findViewById(R.id.cover_delete);
        this.jxL = (ImageView) this.jxG.findViewById(R.id.cover_scale);
    }

    public void cgk() {
        this.jxI.setText(this.jxJ.getText());
        this.jxI.setVisibility(0);
        this.jxJ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jxI.getText())) {
            this.jxM = 0;
            this.jxG.setVisibility(8);
        }
        if (this.jxM == 4) {
            cvd();
        }
        this.jxW.HidenSoftKeyPad(this.jxJ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jxJ.setFocusable(true);
            this.jxJ.setFocusableInTouchMode(true);
            this.jxJ.requestFocus();
            return;
        }
        this.jxJ.setFocusable(false);
        this.jxJ.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jxJ.setText("");
                    cgk();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    cvf();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    cvf();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    cvf();
                    break;
                default:
                    cgk();
                    String FO = com.baidu.tieba.video.editvideo.model.b.cuY().FO(pendantData.resource);
                    if (TextUtils.isEmpty(FO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jwC.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cuY().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(FO, pendantData);
                        break;
                    }
                    break;
            }
            this.jxM = pendantData.pendantType;
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
        cvd();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jxM == 4 || this.jxM == 0) {
            this.jxG.setX(this.jxX);
            this.jxG.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jxY);
            String obj = this.jxJ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jxJ.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jxI.setText(a2);
                    this.jxJ.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cvd() {
        if (this.jyb) {
            this.jyb = false;
            this.jxK.setVisibility(8);
            this.jxL.setVisibility(8);
            this.jxH.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cve() {
        if (!this.jyb) {
            this.jyb = true;
            this.jxK.setVisibility(0);
            this.jxL.setVisibility(0);
            this.jxH.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jyn != null) {
            Bitmap bitmap = this.jyn.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jyn.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cvd();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jxV = 1.0f;
                this.iLe = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jxV = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jxQ = (this.jyh * 2) + width;
                this.jxR = (this.jyh * 2) + height;
                this.jxU = (this.jxQ * 1.0f) / this.jxR;
                this.jxG.setX((((this.mVideoWidth - i2) - (this.jyh * 2)) / 2) + this.jxX);
                this.jxG.setY((((this.mVideoHeight - i) - (this.jyh * 2)) / 2) + this.jxY);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fye = motionEvent.getRawX();
                this.fyf = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fye);
                float abs2 = Math.abs(rawY - this.fyf);
                if (motionEvent.getPointerCount() <= 1 && abs < this.fdt && abs2 < this.fdt && System.currentTimeMillis() - this.startTime < 300) {
                    cgk();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jxI == null || this.jxI.getText() == null) {
            return null;
        }
        return this.jxI.getText().toString();
    }

    public void cvf() {
        this.jxI.setText(this.jxJ.getText());
        this.jxI.setVisibility(8);
        this.jxJ.setVisibility(0);
        setEditTextEnable(true);
        this.jxW.ShowSoftKeyPad(this.jxJ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jxJ.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jxI.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jyh = 0;
            this.jxJ.setMaxLines(1);
            this.jxI.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jxI.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jxJ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jxJ.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jxI.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jyh = l.g(getContext(), R.dimen.ds40);
            this.jxJ.setMaxLines(2);
            this.jxI.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jxI.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jxJ.setLayoutParams(layoutParams2);
            this.jyd = (int) (l.dip2px(getContext(), pendantData.left) * this.jxV);
            this.jye = (int) (l.dip2px(getContext(), pendantData.top) * this.jxV);
            this.jyf = (int) (l.dip2px(getContext(), pendantData.right) * this.jxV);
            this.jyg = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jxV);
            this.mContentView.setPadding(this.jyd, this.jye, this.jyf, this.jyg);
            this.jyc = l.g(getContext(), R.dimen.fontsize40) * this.jxV;
            String text = getText();
            this.jyi = (i2 - this.jye) - this.jyg;
            this.jyj = (i - this.jyd) - this.jyf;
            this.jyl = this.jyk + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jyc);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jyj);
                this.jyc = this.jxJ.getTextSize();
                cve();
                cvf();
            } else {
                if (ab.rp(text) > 20) {
                    text = ab.ab(text, 20);
                    this.jxJ.setText(text);
                    this.jxI.setText(text);
                }
                FQ(text);
            }
        }
        this.jxI.setIncludeFontPadding(false);
        this.jxJ.setIncludeFontPadding(false);
        this.jxI.setLineSpacing(this.jyk, 1.0f);
        this.jxJ.setLineSpacing(this.jyk, 1.0f);
        this.jxG.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jxG.getLayoutParams();
        layoutParams3.height = (this.jyh * 2) + i2;
        layoutParams3.width = (this.jyh * 2) + i;
        this.jxG.setLayoutParams(layoutParams3);
        this.jym = (this.jyh * 2) + i;
        ((FrameLayout.LayoutParams) this.jxH.getLayoutParams()).setMargins(this.jyh, this.jyh, this.jyh, this.jyh);
        this.jxG.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jyo == null) {
            cvg();
        }
        return this.jyo;
    }

    private void cvg() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jyo = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cvh() {
        if (this.jyo != null && !this.jyo.isRecycled()) {
            this.jyo.recycle();
            this.jyo = null;
        }
    }

    public void rF(boolean z) {
        if (this.jxM != 0) {
            if (z) {
                cvh();
                this.jxG.setVisibility(0);
                return;
            }
            cgk();
            getTempBitmap();
            this.jxG.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jyn.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jyn.clear();
        this.jyn = null;
        cvh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jyq;
        WeakReference<CoverPendantDragView> jyr;
        WeakReference<PendantData> jys;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jyq = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jyr = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jys = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void es(String str, String str2) {
            if (this.jyq != null && this.jyq.get() != null) {
                this.jyq.get().jwC.setVisibility(8);
            }
            if (this.jyr != null && this.jyr.get() != null && this.jys != null && this.jys.get() != null) {
                this.jyr.get().a(str2, this.jys.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void FF(String str) {
            if (this.jyq != null && this.jyq.get() != null) {
                this.jyq.get().jwC.setVisibility(8);
            }
            if (this.jyr != null && this.jyr.get() != null) {
                l.showToast(this.jyr.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cuj() {
            if (this.jyq != null && this.jyq.get() != null) {
                this.jyq.get().jwC.setVisibility(8);
            }
        }
    }
}
