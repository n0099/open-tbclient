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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoverPendantDragView extends FrameLayout {
    private float cDl;
    private float drO;
    private float gGa;
    private int hrA;
    private int hrB;
    private int hrC;
    private int hrD;
    private int hrE;
    private float hrF;
    private float hrG;
    private int hrH;
    private float hrI;
    private int hrJ;
    private Map<String, Bitmap> hrK;
    float hrL;
    float hrM;
    private FrameLayout hrd;
    private RotateFrameLayout hre;
    private TextView hrf;
    private EditText hrg;
    private ImageView hrh;
    private ImageView hri;
    private int hrj;
    private boolean hrk;
    private float hrl;
    private float hrm;
    private int hrn;
    private int hro;
    private float hrp;
    private float hrq;
    private float hrr;
    private float hrs;
    private b hrt;
    private float hru;
    private float hrv;
    private float hrw;
    private float hrx;
    private boolean hry;
    private float hrz;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private Bitmap mTempBitmap;
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
        this.hrj = 0;
        this.hrs = 1.0f;
        this.gGa = 1.0f;
        this.hry = true;
        this.hrK = new HashMap();
        this.startTime = 0L;
        this.hrL = 0.0f;
        this.hrM = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hrz = l.t(getContext(), d.e.fontsize40);
        this.hrH = l.t(getContext(), d.e.ds2);
        this.drO = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hrd = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hrd);
        this.hrd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hrj == 4) {
                            CoverPendantDragView.this.bBR();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cDl);
                        if (!CoverPendantDragView.this.hrk && abs < CoverPendantDragView.this.drO && abs2 < CoverPendantDragView.this.drO && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBS();
                        }
                        CoverPendantDragView.this.hrl = 0.0f;
                        CoverPendantDragView.this.hrm = 0.0f;
                        CoverPendantDragView.this.hrk = false;
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
                        CoverPendantDragView.this.hrl = 0.0f;
                        CoverPendantDragView.this.hrm = 0.0f;
                        return true;
                }
            }
        });
        this.hrh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hrg.setText("");
                CoverPendantDragView.this.bmJ();
            }
        });
        this.hri.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hrm = 0.0f;
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
        this.hrg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hrj != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hrf.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hu(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hrf.getText().length()) {
                        CoverPendantDragView.this.tQ(obj);
                    } else {
                        CoverPendantDragView.this.tP(obj);
                    }
                } else {
                    String F = w.F(obj, 20);
                    editable.delete(obj.lastIndexOf(F) + F.length(), obj.length());
                    CoverPendantDragView.this.tQ(F);
                    l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.hrf.setText(editable.toString());
            }
        });
        this.hrg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hrd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cDl = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cDl;
        this.hrp = (this.hrd.getWidth() / 2) + this.hrd.getX();
        this.hrq = (this.hrd.getHeight() / 2) + this.hrd.getY();
        this.hrf.setText(this.hrg.getText());
        this.hrf.setVisibility(0);
        this.hrg.setVisibility(8);
        setEditTextEnable(false);
        this.hrt.HidenSoftKeyPad(this.hrg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        TextPaint paint = this.hrg.getPaint();
        float measureText = paint.measureText(str);
        while (this.hrg.getLineCount() == 1 && this.hrg.getTextSize() < this.hrz * this.gGa && measureText < this.hrG * this.gGa) {
            setTextSize(0, this.hrg.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hu(str) <= w.hu(getResources().getString(d.j.cover_hint)) && this.hrg.getTextSize() != this.hrz * this.gGa) {
            setTextSize(0, this.hrz * this.gGa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(String str) {
        TextPaint paint = this.hrg.getPaint();
        float measureText = paint.measureText(str);
        while (this.hrg.getTextSize() > ((this.hrF * this.gGa) / 2.0f) - (this.hrI * this.gGa) && measureText > this.hrG * this.gGa) {
            setTextSize(0, this.hrg.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.hrg.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hrg.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.t(getContext(), d.e.ds120)) {
            str = w.I(str, w.ht(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.hrt = bVar;
    }

    public void k(float f, float f2, float f3, float f4) {
        this.hru = f;
        this.hrv = f2;
        this.hrw = f3;
        this.hrx = f4;
        if (this.hru > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hru, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hrv > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hrv);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hrw > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hrw) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hrx > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hrx) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.hrp - rawX);
        float abs4 = Math.abs(this.hrq - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hrp - this.mLastX);
        float abs6 = Math.abs(this.hrq - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cM(sqrt, (int) (sqrt / this.hrr));
        if (this.hrm != 0.0f) {
            this.hrd.setRotation(this.hrd.getRotation() - (this.hrm - Q));
        }
        this.hrm = Q;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cM(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hrd.getLayoutParams();
        int width = this.hrd.getWidth() - i;
        int i3 = (int) (width / this.hrr);
        if (width < this.hrn) {
            width = this.hrn;
            i3 = (int) (width / this.hrr);
        }
        this.gGa = ((width * 1.0f) - (this.hrE * 2)) / (this.hrJ - (this.hrE * 2));
        this.mContentView.setPadding((int) (this.hrA * this.gGa), (int) (this.hrB * this.gGa), (int) (this.hrC * this.gGa), (int) (this.hrD * this.gGa));
        setTextSize(0, (this.hrg.getTextSize() * i3) / this.hrd.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hrd.setLayoutParams(layoutParams);
        float f = this.hrp - (layoutParams.width / 2);
        float f2 = this.hrq - (layoutParams.height / 2);
        this.hrd.setX(f);
        this.hrd.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hrj != 4) {
            float y = (this.hrd.getY() + rawY) - this.mLastY;
            if (y < this.hrv) {
                y = this.hrv;
            } else if (y > (this.hrv + this.mVideoHeight) - this.hrd.getHeight()) {
                y = (this.hrv + this.mVideoHeight) - this.hrd.getHeight();
            }
            this.hrd.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hrk = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.hrl != 0.0f) {
                    int i = (int) (this.hrl - R);
                    cM(i, (int) (i / this.hrr));
                }
                if (this.hrm != 0.0f) {
                    this.hrd.setRotation(this.hrd.getRotation() - (this.hrm - P));
                }
                this.hrm = P;
                this.hrl = R;
            } else if (!this.hrk && pointerCount == 1) {
                float y2 = (this.hrd.getY() + rawY) - this.mLastY;
                if (y2 < this.hrv - (this.hrd.getHeight() / 2)) {
                    y2 = this.hrv - (this.hrd.getHeight() / 2);
                } else if (y2 > ((this.hrv + this.mVideoHeight) - this.hrd.getHeight()) + (this.hrd.getHeight() / 2)) {
                    y2 = ((this.hrv + this.mVideoHeight) - this.hrd.getHeight()) + (this.hrd.getHeight() / 2);
                }
                float x = (this.hrd.getX() + rawX) - this.mLastX;
                if (x < this.hru - (this.hrd.getWidth() / 2)) {
                    x = this.hru - (this.hrd.getWidth() / 2);
                } else if (x > ((this.hru + this.mVideoWidth) - this.hrd.getWidth()) + (this.hrd.getWidth() / 2)) {
                    x = ((this.hru + this.mVideoWidth) - this.hrd.getWidth()) + (this.hrd.getWidth() / 2);
                }
                this.hrd.setX(x);
                this.hrd.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hrg.getTextSize() != f) {
            this.hrg.setTextSize(i, f);
        }
        if (this.hrf.getTextSize() != f) {
            this.hrf.setTextSize(i, f);
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
        matrix.postRotate(this.hrd.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hrq - motionEvent.getRawY(), this.hrp - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drO && Math.abs(motionEvent.getRawY() - this.cDl) < this.drO;
    }

    private void init() {
        this.hre = (RotateFrameLayout) this.hrd.findViewById(d.g.content_container);
        this.hrf = (TextView) this.hrd.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hrd.findViewById(d.g.content_view);
        this.hrg = (EditText) this.hrd.findViewById(d.g.cover_edit);
        this.hrh = (ImageView) this.hrd.findViewById(d.g.cover_delete);
        this.hri = (ImageView) this.hrd.findViewById(d.g.cover_scale);
    }

    public void bmJ() {
        this.hrf.setText(this.hrg.getText());
        this.hrf.setVisibility(0);
        this.hrg.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hrf.getText())) {
            this.hrj = 0;
            this.hrd.setVisibility(8);
        }
        if (this.hrj == 4) {
            bBQ();
        }
        this.hrt.HidenSoftKeyPad(this.hrg);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hrg.setFocusable(true);
            this.hrg.setFocusableInTouchMode(true);
            this.hrg.requestFocus();
            return;
        }
        this.hrg.setFocusable(false);
        this.hrg.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hrg.setText("");
                    bmJ();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBS();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBS();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBS();
                    break;
                default:
                    bmJ();
                    String tO = com.baidu.tieba.video.editvideo.model.b.bBL().tO(pendantData.resource);
                    if (TextUtils.isEmpty(tO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hpW.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBL().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tO, pendantData);
                        break;
                    }
                    break;
            }
            this.hrj = pendantData.pendantType;
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
        bBQ();
        a(this.mVideoWidth, l.t(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hrj == 4 || this.hrj == 0) {
            this.hrd.setX(this.hru);
            this.hrd.setY(((this.mVideoHeight - l.t(getContext(), d.e.ds100)) / 2) + this.hrv);
            String obj = this.hrg.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hrg.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hrf.setText(a2);
                    this.hrg.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBQ() {
        if (this.hry) {
            this.hry = false;
            this.hrh.setVisibility(8);
            this.hri.setVisibility(8);
            this.hre.setBackgroundColor(getResources().getColor(d.C0141d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBR() {
        if (!this.hry) {
            this.hry = true;
            this.hrh.setVisibility(0);
            this.hri.setVisibility(0);
            this.hre.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hrK.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hrK.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBQ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hrs = 1.0f;
                this.gGa = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hrs = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hrn = (this.hrE * 2) + width;
                this.hro = (this.hrE * 2) + height;
                this.hrr = (this.hrn * 1.0f) / this.hro;
                this.hrd.setX((((this.mVideoWidth - i2) - (this.hrE * 2)) / 2) + this.hru);
                this.hrd.setY((((this.mVideoHeight - i) - (this.hrE * 2)) / 2) + this.hrv);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hrL = motionEvent.getRawX();
                this.hrM = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hrL);
                float abs2 = Math.abs(rawY - this.hrM);
                if (motionEvent.getPointerCount() <= 1 && abs < this.drO && abs2 < this.drO && System.currentTimeMillis() - this.startTime < 300) {
                    bmJ();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hrf == null || this.hrf.getText() == null) {
            return null;
        }
        return this.hrf.getText().toString();
    }

    public void bBS() {
        this.hrf.setText(this.hrg.getText());
        this.hrf.setVisibility(8);
        this.hrg.setVisibility(0);
        setEditTextEnable(true);
        this.hrt.ShowSoftKeyPad(this.hrg);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hrg.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hrf.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.t(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.t(getContext(), d.e.fontsize40) * i) / i3);
            this.hrE = 0;
            this.hrg.setMaxLines(1);
            this.hrf.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hrf.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hrg.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.t(getContext(), d.e.ds60), 0, l.t(getContext(), d.e.ds60), 0);
        } else {
            this.hrg.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hrf.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hrE = l.t(getContext(), d.e.ds40);
            this.hrg.setMaxLines(2);
            this.hrf.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hrf.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hrg.setLayoutParams(layoutParams2);
            this.hrA = (int) (l.dip2px(getContext(), pendantData.left) * this.hrs);
            this.hrB = (int) (l.dip2px(getContext(), pendantData.top) * this.hrs);
            this.hrC = (int) (l.dip2px(getContext(), pendantData.right) * this.hrs);
            this.hrD = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hrs);
            this.mContentView.setPadding(this.hrA, this.hrB, this.hrC, this.hrD);
            this.hrz = l.t(getContext(), d.e.fontsize40) * this.hrs;
            String text = getText();
            this.hrF = (i2 - this.hrB) - this.hrD;
            this.hrG = (i - this.hrA) - this.hrC;
            this.hrI = this.hrH + l.t(getContext(), d.e.ds6);
            setTextSize(0, this.hrz);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.j.cover_hint), this.hrG);
                this.hrz = this.hrg.getTextSize();
                bBR();
                bBS();
            } else {
                if (w.hu(text) > 20) {
                    text = w.F(text, 20);
                    this.hrg.setText(text);
                    this.hrf.setText(text);
                }
                tQ(text);
            }
        }
        this.hrf.setIncludeFontPadding(false);
        this.hrg.setIncludeFontPadding(false);
        this.hrf.setLineSpacing(this.hrH, 1.0f);
        this.hrg.setLineSpacing(this.hrH, 1.0f);
        this.hrd.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hrd.getLayoutParams();
        layoutParams3.height = (this.hrE * 2) + i2;
        layoutParams3.width = (this.hrE * 2) + i;
        this.hrd.setLayoutParams(layoutParams3);
        this.hrJ = (this.hrE * 2) + i;
        ((FrameLayout.LayoutParams) this.hre.getLayoutParams()).setMargins(this.hrE, this.hrE, this.hrE, this.hrE);
        this.hrd.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBT();
        }
        return this.mTempBitmap;
    }

    private void bBT() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBU() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nq(boolean z) {
        if (this.hrj != 0) {
            if (z) {
                bBU();
                this.hrd.setVisibility(0);
                return;
            }
            bmJ();
            getTempBitmap();
            this.hrd.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hrK.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hrK.clear();
        this.hrK = null;
        bBU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hrO;
        WeakReference<CoverPendantDragView> hrP;
        WeakReference<PendantData> hrQ;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hrO = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hrP = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hrQ = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cj(String str, String str2) {
            if (this.hrO != null && this.hrO.get() != null) {
                this.hrO.get().hpW.setVisibility(8);
            }
            if (this.hrP != null && this.hrP.get() != null && this.hrQ != null && this.hrQ.get() != null) {
                this.hrP.get().a(str2, this.hrQ.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tE(String str) {
            if (this.hrO != null && this.hrO.get() != null) {
                this.hrO.get().hpW.setVisibility(8);
            }
            if (this.hrP != null && this.hrP.get() != null) {
                l.showToast(this.hrP.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAW() {
            if (this.hrO != null && this.hrO.get() != null) {
                this.hrO.get().hpW.setVisibility(8);
            }
        }
    }
}
