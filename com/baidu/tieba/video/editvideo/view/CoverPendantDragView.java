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
    private float cDi;
    private float drL;
    private float gFK;
    private FrameLayout hqF;
    private RotateFrameLayout hqG;
    private TextView hqH;
    private EditText hqI;
    private ImageView hqJ;
    private ImageView hqK;
    private int hqL;
    private boolean hqM;
    private float hqN;
    private float hqO;
    private int hqP;
    private int hqQ;
    private float hqR;
    private float hqS;
    private float hqT;
    private float hqU;
    private b hqV;
    private float hqW;
    private float hqX;
    private float hqY;
    private float hqZ;
    private boolean hra;
    private float hrb;
    private int hrc;
    private int hrd;
    private int hre;
    private int hrf;
    private int hrg;
    private float hrh;
    private float hri;
    private int hrj;
    private float hrk;
    private int hrl;
    private Map<String, Bitmap> hrm;
    float hrn;
    float hro;
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
        this.hqL = 0;
        this.hqU = 1.0f;
        this.gFK = 1.0f;
        this.hra = true;
        this.hrm = new HashMap();
        this.startTime = 0L;
        this.hrn = 0.0f;
        this.hro = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hrb = l.t(getContext(), d.e.fontsize40);
        this.hrj = l.t(getContext(), d.e.ds2);
        this.drL = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hqF = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hqF);
        this.hqF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hqL == 4) {
                            CoverPendantDragView.this.bBM();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cDi);
                        if (!CoverPendantDragView.this.hqM && abs < CoverPendantDragView.this.drL && abs2 < CoverPendantDragView.this.drL && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBN();
                        }
                        CoverPendantDragView.this.hqN = 0.0f;
                        CoverPendantDragView.this.hqO = 0.0f;
                        CoverPendantDragView.this.hqM = false;
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
                        CoverPendantDragView.this.hqN = 0.0f;
                        CoverPendantDragView.this.hqO = 0.0f;
                        return true;
                }
            }
        });
        this.hqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hqI.setText("");
                CoverPendantDragView.this.bmI();
            }
        });
        this.hqK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hqO = 0.0f;
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
        this.hqI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hqL != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hqH.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hu(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hqH.getText().length()) {
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
                CoverPendantDragView.this.hqH.setText(editable.toString());
            }
        });
        this.hqI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hqF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cDi = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cDi;
        this.hqR = (this.hqF.getWidth() / 2) + this.hqF.getX();
        this.hqS = (this.hqF.getHeight() / 2) + this.hqF.getY();
        this.hqH.setText(this.hqI.getText());
        this.hqH.setVisibility(0);
        this.hqI.setVisibility(8);
        setEditTextEnable(false);
        this.hqV.HidenSoftKeyPad(this.hqI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        TextPaint paint = this.hqI.getPaint();
        float measureText = paint.measureText(str);
        while (this.hqI.getLineCount() == 1 && this.hqI.getTextSize() < this.hrb * this.gFK && measureText < this.hri * this.gFK) {
            setTextSize(0, this.hqI.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hu(str) <= w.hu(getResources().getString(d.j.cover_hint)) && this.hqI.getTextSize() != this.hrb * this.gFK) {
            setTextSize(0, this.hrb * this.gFK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(String str) {
        TextPaint paint = this.hqI.getPaint();
        float measureText = paint.measureText(str);
        while (this.hqI.getTextSize() > ((this.hrh * this.gFK) / 2.0f) - (this.hrk * this.gFK) && measureText > this.hri * this.gFK) {
            setTextSize(0, this.hqI.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.hqI.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hqI.getTextSize() - 1.0f);
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
        this.hqV = bVar;
    }

    public void k(float f, float f2, float f3, float f4) {
        this.hqW = f;
        this.hqX = f2;
        this.hqY = f3;
        this.hqZ = f4;
        if (this.hqW > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hqW, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hqX > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hqX);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hqY > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hqY) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hqZ > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hqZ) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.hqR - rawX);
        float abs4 = Math.abs(this.hqS - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hqR - this.mLastX);
        float abs6 = Math.abs(this.hqS - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cM(sqrt, (int) (sqrt / this.hqT));
        if (this.hqO != 0.0f) {
            this.hqF.setRotation(this.hqF.getRotation() - (this.hqO - Q));
        }
        this.hqO = Q;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cM(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hqF.getLayoutParams();
        int width = this.hqF.getWidth() - i;
        int i3 = (int) (width / this.hqT);
        if (width < this.hqP) {
            width = this.hqP;
            i3 = (int) (width / this.hqT);
        }
        this.gFK = ((width * 1.0f) - (this.hrg * 2)) / (this.hrl - (this.hrg * 2));
        this.mContentView.setPadding((int) (this.hrc * this.gFK), (int) (this.hrd * this.gFK), (int) (this.hre * this.gFK), (int) (this.hrf * this.gFK));
        setTextSize(0, (this.hqI.getTextSize() * i3) / this.hqF.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hqF.setLayoutParams(layoutParams);
        float f = this.hqR - (layoutParams.width / 2);
        float f2 = this.hqS - (layoutParams.height / 2);
        this.hqF.setX(f);
        this.hqF.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hqL != 4) {
            float y = (this.hqF.getY() + rawY) - this.mLastY;
            if (y < this.hqX) {
                y = this.hqX;
            } else if (y > (this.hqX + this.mVideoHeight) - this.hqF.getHeight()) {
                y = (this.hqX + this.mVideoHeight) - this.hqF.getHeight();
            }
            this.hqF.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hqM = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.hqN != 0.0f) {
                    int i = (int) (this.hqN - R);
                    cM(i, (int) (i / this.hqT));
                }
                if (this.hqO != 0.0f) {
                    this.hqF.setRotation(this.hqF.getRotation() - (this.hqO - P));
                }
                this.hqO = P;
                this.hqN = R;
            } else if (!this.hqM && pointerCount == 1) {
                float y2 = (this.hqF.getY() + rawY) - this.mLastY;
                if (y2 < this.hqX - (this.hqF.getHeight() / 2)) {
                    y2 = this.hqX - (this.hqF.getHeight() / 2);
                } else if (y2 > ((this.hqX + this.mVideoHeight) - this.hqF.getHeight()) + (this.hqF.getHeight() / 2)) {
                    y2 = ((this.hqX + this.mVideoHeight) - this.hqF.getHeight()) + (this.hqF.getHeight() / 2);
                }
                float x = (this.hqF.getX() + rawX) - this.mLastX;
                if (x < this.hqW - (this.hqF.getWidth() / 2)) {
                    x = this.hqW - (this.hqF.getWidth() / 2);
                } else if (x > ((this.hqW + this.mVideoWidth) - this.hqF.getWidth()) + (this.hqF.getWidth() / 2)) {
                    x = ((this.hqW + this.mVideoWidth) - this.hqF.getWidth()) + (this.hqF.getWidth() / 2);
                }
                this.hqF.setX(x);
                this.hqF.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hqI.getTextSize() != f) {
            this.hqI.setTextSize(i, f);
        }
        if (this.hqH.getTextSize() != f) {
            this.hqH.setTextSize(i, f);
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
        matrix.postRotate(this.hqF.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hqS - motionEvent.getRawY(), this.hqR - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drL && Math.abs(motionEvent.getRawY() - this.cDi) < this.drL;
    }

    private void init() {
        this.hqG = (RotateFrameLayout) this.hqF.findViewById(d.g.content_container);
        this.hqH = (TextView) this.hqF.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hqF.findViewById(d.g.content_view);
        this.hqI = (EditText) this.hqF.findViewById(d.g.cover_edit);
        this.hqJ = (ImageView) this.hqF.findViewById(d.g.cover_delete);
        this.hqK = (ImageView) this.hqF.findViewById(d.g.cover_scale);
    }

    public void bmI() {
        this.hqH.setText(this.hqI.getText());
        this.hqH.setVisibility(0);
        this.hqI.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hqH.getText())) {
            this.hqL = 0;
            this.hqF.setVisibility(8);
        }
        if (this.hqL == 4) {
            bBL();
        }
        this.hqV.HidenSoftKeyPad(this.hqI);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hqI.setFocusable(true);
            this.hqI.setFocusableInTouchMode(true);
            this.hqI.requestFocus();
            return;
        }
        this.hqI.setFocusable(false);
        this.hqI.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hqI.setText("");
                    bmI();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBN();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBN();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBN();
                    break;
                default:
                    bmI();
                    String tO = com.baidu.tieba.video.editvideo.model.b.bBG().tO(pendantData.resource);
                    if (TextUtils.isEmpty(tO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hpy.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBG().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tO, pendantData);
                        break;
                    }
                    break;
            }
            this.hqL = pendantData.pendantType;
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
        bBL();
        a(this.mVideoWidth, l.t(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hqL == 4 || this.hqL == 0) {
            this.hqF.setX(this.hqW);
            this.hqF.setY(((this.mVideoHeight - l.t(getContext(), d.e.ds100)) / 2) + this.hqX);
            String obj = this.hqI.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hqI.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hqH.setText(a2);
                    this.hqI.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBL() {
        if (this.hra) {
            this.hra = false;
            this.hqJ.setVisibility(8);
            this.hqK.setVisibility(8);
            this.hqG.setBackgroundColor(getResources().getColor(d.C0141d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBM() {
        if (!this.hra) {
            this.hra = true;
            this.hqJ.setVisibility(0);
            this.hqK.setVisibility(0);
            this.hqG.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hrm.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hrm.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBL();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hqU = 1.0f;
                this.gFK = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hqU = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hqP = (this.hrg * 2) + width;
                this.hqQ = (this.hrg * 2) + height;
                this.hqT = (this.hqP * 1.0f) / this.hqQ;
                this.hqF.setX((((this.mVideoWidth - i2) - (this.hrg * 2)) / 2) + this.hqW);
                this.hqF.setY((((this.mVideoHeight - i) - (this.hrg * 2)) / 2) + this.hqX);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hrn = motionEvent.getRawX();
                this.hro = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hrn);
                float abs2 = Math.abs(rawY - this.hro);
                if (motionEvent.getPointerCount() <= 1 && abs < this.drL && abs2 < this.drL && System.currentTimeMillis() - this.startTime < 300) {
                    bmI();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hqH == null || this.hqH.getText() == null) {
            return null;
        }
        return this.hqH.getText().toString();
    }

    public void bBN() {
        this.hqH.setText(this.hqI.getText());
        this.hqH.setVisibility(8);
        this.hqI.setVisibility(0);
        setEditTextEnable(true);
        this.hqV.ShowSoftKeyPad(this.hqI);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hqI.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hqH.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.t(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.t(getContext(), d.e.fontsize40) * i) / i3);
            this.hrg = 0;
            this.hqI.setMaxLines(1);
            this.hqH.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hqH.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hqI.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.t(getContext(), d.e.ds60), 0, l.t(getContext(), d.e.ds60), 0);
        } else {
            this.hqI.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hqH.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hrg = l.t(getContext(), d.e.ds40);
            this.hqI.setMaxLines(2);
            this.hqH.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hqH.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hqI.setLayoutParams(layoutParams2);
            this.hrc = (int) (l.dip2px(getContext(), pendantData.left) * this.hqU);
            this.hrd = (int) (l.dip2px(getContext(), pendantData.top) * this.hqU);
            this.hre = (int) (l.dip2px(getContext(), pendantData.right) * this.hqU);
            this.hrf = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hqU);
            this.mContentView.setPadding(this.hrc, this.hrd, this.hre, this.hrf);
            this.hrb = l.t(getContext(), d.e.fontsize40) * this.hqU;
            String text = getText();
            this.hrh = (i2 - this.hrd) - this.hrf;
            this.hri = (i - this.hrc) - this.hre;
            this.hrk = this.hrj + l.t(getContext(), d.e.ds6);
            setTextSize(0, this.hrb);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.j.cover_hint), this.hri);
                this.hrb = this.hqI.getTextSize();
                bBM();
                bBN();
            } else {
                if (w.hu(text) > 20) {
                    text = w.F(text, 20);
                    this.hqI.setText(text);
                    this.hqH.setText(text);
                }
                tQ(text);
            }
        }
        this.hqH.setIncludeFontPadding(false);
        this.hqI.setIncludeFontPadding(false);
        this.hqH.setLineSpacing(this.hrj, 1.0f);
        this.hqI.setLineSpacing(this.hrj, 1.0f);
        this.hqF.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hqF.getLayoutParams();
        layoutParams3.height = (this.hrg * 2) + i2;
        layoutParams3.width = (this.hrg * 2) + i;
        this.hqF.setLayoutParams(layoutParams3);
        this.hrl = (this.hrg * 2) + i;
        ((FrameLayout.LayoutParams) this.hqG.getLayoutParams()).setMargins(this.hrg, this.hrg, this.hrg, this.hrg);
        this.hqF.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBO();
        }
        return this.mTempBitmap;
    }

    private void bBO() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBP() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nl(boolean z) {
        if (this.hqL != 0) {
            if (z) {
                bBP();
                this.hqF.setVisibility(0);
                return;
            }
            bmI();
            getTempBitmap();
            this.hqF.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hrm.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hrm.clear();
        this.hrm = null;
        bBP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hrq;
        WeakReference<CoverPendantDragView> hrr;
        WeakReference<PendantData> hrs;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hrq = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hrr = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hrs = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cj(String str, String str2) {
            if (this.hrq != null && this.hrq.get() != null) {
                this.hrq.get().hpy.setVisibility(8);
            }
            if (this.hrr != null && this.hrr.get() != null && this.hrs != null && this.hrs.get() != null) {
                this.hrr.get().a(str2, this.hrs.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tE(String str) {
            if (this.hrq != null && this.hrq.get() != null) {
                this.hrq.get().hpy.setVisibility(8);
            }
            if (this.hrr != null && this.hrr.get() != null) {
                l.showToast(this.hrr.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAR() {
            if (this.hrq != null && this.hrq.get() != null) {
                this.hrq.get().hpy.setVisibility(8);
            }
        }
    }
}
