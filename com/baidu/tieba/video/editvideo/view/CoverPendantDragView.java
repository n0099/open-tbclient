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
    private float cDu;
    private float drX;
    private float gFZ;
    private FrameLayout hqS;
    private RotateFrameLayout hqT;
    private TextView hqU;
    private EditText hqV;
    private ImageView hqW;
    private ImageView hqX;
    private int hqY;
    private boolean hqZ;
    float hrA;
    float hrB;
    private float hra;
    private float hrb;
    private int hrc;
    private int hrd;
    private float hre;
    private float hrf;
    private float hrg;
    private float hrh;
    private b hri;
    private float hrj;
    private float hrk;
    private float hrl;
    private float hrm;
    private boolean hrn;
    private float hro;
    private int hrp;
    private int hrq;
    private int hrr;
    private int hrs;
    private int hrt;
    private float hru;
    private float hrv;
    private int hrw;
    private float hrx;
    private int hry;
    private Map<String, Bitmap> hrz;
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
        this.hqY = 0;
        this.hrh = 1.0f;
        this.gFZ = 1.0f;
        this.hrn = true;
        this.hrz = new HashMap();
        this.startTime = 0L;
        this.hrA = 0.0f;
        this.hrB = 0.0f;
        this.mScreenWidth = l.ao(TbadkCoreApplication.getInst());
        this.hro = l.t(getContext(), d.e.fontsize40);
        this.hrw = l.t(getContext(), d.e.ds2);
        this.drX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.hqS = (FrameLayout) LayoutInflater.from(getContext()).inflate(d.h.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.hqS);
        this.hqS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.hqY == 4) {
                            CoverPendantDragView.this.bBN();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cDu);
                        if (!CoverPendantDragView.this.hqZ && abs < CoverPendantDragView.this.drX && abs2 < CoverPendantDragView.this.drX && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.bBO();
                        }
                        CoverPendantDragView.this.hra = 0.0f;
                        CoverPendantDragView.this.hrb = 0.0f;
                        CoverPendantDragView.this.hqZ = false;
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
                        CoverPendantDragView.this.hra = 0.0f;
                        CoverPendantDragView.this.hrb = 0.0f;
                        return true;
                }
            }
        });
        this.hqW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.hqV.setText("");
                CoverPendantDragView.this.bmJ();
            }
        });
        this.hqX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.hrb = 0.0f;
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
        this.hqV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.hqY != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.hqU.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length() + obj.lastIndexOf(a2), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), d.j.cover_text_length_max_tips);
                    }
                } else if (w.hu(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.hqU.getText().length()) {
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
                CoverPendantDragView.this.hqU.setText(editable.toString());
            }
        });
        this.hqV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.hqS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cDu = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cDu;
        this.hre = (this.hqS.getWidth() / 2) + this.hqS.getX();
        this.hrf = (this.hqS.getHeight() / 2) + this.hqS.getY();
        this.hqU.setText(this.hqV.getText());
        this.hqU.setVisibility(0);
        this.hqV.setVisibility(8);
        setEditTextEnable(false);
        this.hri.HidenSoftKeyPad(this.hqV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        TextPaint paint = this.hqV.getPaint();
        float measureText = paint.measureText(str);
        while (this.hqV.getLineCount() == 1 && this.hqV.getTextSize() < this.hro * this.gFZ && measureText < this.hrv * this.gFZ) {
            setTextSize(0, this.hqV.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (w.hu(str) <= w.hu(getResources().getString(d.j.cover_hint)) && this.hqV.getTextSize() != this.hro * this.gFZ) {
            setTextSize(0, this.hro * this.gFZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(String str) {
        TextPaint paint = this.hqV.getPaint();
        float measureText = paint.measureText(str);
        while (this.hqV.getTextSize() > ((this.hru * this.gFZ) / 2.0f) - (this.hrx * this.gFZ) && measureText > this.hrv * this.gFZ) {
            setTextSize(0, this.hqV.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.hqV.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.hqV.getTextSize() - 1.0f);
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
        this.hri = bVar;
    }

    public void k(float f, float f2, float f3, float f4) {
        this.hrj = f;
        this.hrk = f2;
        this.hrl = f3;
        this.hrm = f4;
        if (this.hrj > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.hrj, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.hrk > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.hrk);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.hrl > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.hrl) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.hrm > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.hrm) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.hre - rawX);
        float abs4 = Math.abs(this.hrf - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.hre - this.mLastX);
        float abs6 = Math.abs(this.hrf - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cM(sqrt, (int) (sqrt / this.hrg));
        if (this.hrb != 0.0f) {
            this.hqS.setRotation(this.hqS.getRotation() - (this.hrb - Q));
        }
        this.hrb = Q;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cM(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hqS.getLayoutParams();
        int width = this.hqS.getWidth() - i;
        int i3 = (int) (width / this.hrg);
        if (width < this.hrc) {
            width = this.hrc;
            i3 = (int) (width / this.hrg);
        }
        this.gFZ = ((width * 1.0f) - (this.hrt * 2)) / (this.hry - (this.hrt * 2));
        this.mContentView.setPadding((int) (this.hrp * this.gFZ), (int) (this.hrq * this.gFZ), (int) (this.hrr * this.gFZ), (int) (this.hrs * this.gFZ));
        setTextSize(0, (this.hqV.getTextSize() * i3) / this.hqS.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.hqS.setLayoutParams(layoutParams);
        float f = this.hre - (layoutParams.width / 2);
        float f2 = this.hrf - (layoutParams.height / 2);
        this.hqS.setX(f);
        this.hqS.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.hqY != 4) {
            float y = (this.hqS.getY() + rawY) - this.mLastY;
            if (y < this.hrk) {
                y = this.hrk;
            } else if (y > (this.hrk + this.mVideoHeight) - this.hqS.getHeight()) {
                y = (this.hrk + this.mVideoHeight) - this.hqS.getHeight();
            }
            this.hqS.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.hqZ = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.hra != 0.0f) {
                    int i = (int) (this.hra - R);
                    cM(i, (int) (i / this.hrg));
                }
                if (this.hrb != 0.0f) {
                    this.hqS.setRotation(this.hqS.getRotation() - (this.hrb - P));
                }
                this.hrb = P;
                this.hra = R;
            } else if (!this.hqZ && pointerCount == 1) {
                float y2 = (this.hqS.getY() + rawY) - this.mLastY;
                if (y2 < this.hrk - (this.hqS.getHeight() / 2)) {
                    y2 = this.hrk - (this.hqS.getHeight() / 2);
                } else if (y2 > ((this.hrk + this.mVideoHeight) - this.hqS.getHeight()) + (this.hqS.getHeight() / 2)) {
                    y2 = ((this.hrk + this.mVideoHeight) - this.hqS.getHeight()) + (this.hqS.getHeight() / 2);
                }
                float x = (this.hqS.getX() + rawX) - this.mLastX;
                if (x < this.hrj - (this.hqS.getWidth() / 2)) {
                    x = this.hrj - (this.hqS.getWidth() / 2);
                } else if (x > ((this.hrj + this.mVideoWidth) - this.hqS.getWidth()) + (this.hqS.getWidth() / 2)) {
                    x = ((this.hrj + this.mVideoWidth) - this.hqS.getWidth()) + (this.hqS.getWidth() / 2);
                }
                this.hqS.setX(x);
                this.hqS.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.hqV.getTextSize() != f) {
            this.hqV.setTextSize(i, f);
        }
        if (this.hqU.getTextSize() != f) {
            this.hqU.setTextSize(i, f);
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
        matrix.postRotate(this.hqS.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.hrf - motionEvent.getRawY(), this.hre - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drX && Math.abs(motionEvent.getRawY() - this.cDu) < this.drX;
    }

    private void init() {
        this.hqT = (RotateFrameLayout) this.hqS.findViewById(d.g.content_container);
        this.hqU = (TextView) this.hqS.findViewById(d.g.cover_text);
        this.mContentView = (FrameLayout) this.hqS.findViewById(d.g.content_view);
        this.hqV = (EditText) this.hqS.findViewById(d.g.cover_edit);
        this.hqW = (ImageView) this.hqS.findViewById(d.g.cover_delete);
        this.hqX = (ImageView) this.hqS.findViewById(d.g.cover_scale);
    }

    public void bmJ() {
        this.hqU.setText(this.hqV.getText());
        this.hqU.setVisibility(0);
        this.hqV.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.hqU.getText())) {
            this.hqY = 0;
            this.hqS.setVisibility(8);
        }
        if (this.hqY == 4) {
            bBM();
        }
        this.hri.HidenSoftKeyPad(this.hqV);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.hqV.setFocusable(true);
            this.hqV.setFocusableInTouchMode(true);
            this.hqV.requestFocus();
            return;
        }
        this.hqV.setFocusable(false);
        this.hqV.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.hqV.setText("");
                    bmJ();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_blue);
                    bBO();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(d.f.bg_cover_edit_black);
                    bBO();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    bBO();
                    break;
                default:
                    bmJ();
                    String tO = com.baidu.tieba.video.editvideo.model.b.bBH().tO(pendantData.resource);
                    if (TextUtils.isEmpty(tO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.hpL.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.bBH().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(tO, pendantData);
                        break;
                    }
                    break;
            }
            this.hqY = pendantData.pendantType;
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
        bBM();
        a(this.mVideoWidth, l.t(getContext(), d.e.ds100), this.mScreenWidth, pendantData);
        if (this.hqY == 4 || this.hqY == 0) {
            this.hqS.setX(this.hrj);
            this.hqS.setY(((this.mVideoHeight - l.t(getContext(), d.e.ds100)) / 2) + this.hrk);
            String obj = this.hqV.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.hqV.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.hqU.setText(a2);
                    this.hqV.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void bBM() {
        if (this.hrn) {
            this.hrn = false;
            this.hqW.setVisibility(8);
            this.hqX.setVisibility(8);
            this.hqT.setBackgroundColor(getResources().getColor(d.C0140d.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBN() {
        if (!this.hrn) {
            this.hrn = true;
            this.hqW.setVisibility(0);
            this.hqX.setVisibility(0);
            this.hqT.setBackgroundResource(d.f.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null) {
            Bitmap bitmap = this.hrz.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.hrz.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                bBM();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.hrh = 1.0f;
                this.gFZ = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.hrh = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.hrc = (this.hrt * 2) + width;
                this.hrd = (this.hrt * 2) + height;
                this.hrg = (this.hrc * 1.0f) / this.hrd;
                this.hqS.setX((((this.mVideoWidth - i2) - (this.hrt * 2)) / 2) + this.hrj);
                this.hqS.setY((((this.mVideoHeight - i) - (this.hrt * 2)) / 2) + this.hrk);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.hrA = motionEvent.getRawX();
                this.hrB = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.hrA);
                float abs2 = Math.abs(rawY - this.hrB);
                if (motionEvent.getPointerCount() <= 1 && abs < this.drX && abs2 < this.drX && System.currentTimeMillis() - this.startTime < 300) {
                    bmJ();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.hqU == null || this.hqU.getText() == null) {
            return null;
        }
        return this.hqU.getText().toString();
    }

    public void bBO() {
        this.hqU.setText(this.hqV.getText());
        this.hqU.setVisibility(8);
        this.hqV.setVisibility(0);
        setEditTextEnable(true);
        this.hri.ShowSoftKeyPad(this.hqV);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.hqV.setTextAppearance(getContext(), d.k.cover_text_style);
            this.hqU.setTextAppearance(getContext(), d.k.cover_text_style);
            i2 = (int) ((l.t(TbadkCoreApplication.getInst(), d.e.ds100) * i) / i3);
            setTextSize(0, (l.t(getContext(), d.e.fontsize40) * i) / i3);
            this.hrt = 0;
            this.hqV.setMaxLines(1);
            this.hqU.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hqU.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.hqV.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.t(getContext(), d.e.ds60), 0, l.t(getContext(), d.e.ds60), 0);
        } else {
            this.hqV.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hqU.setTextAppearance(getContext(), d.k.cover_pendant_style);
            this.hrt = l.t(getContext(), d.e.ds40);
            this.hqV.setMaxLines(2);
            this.hqU.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hqU.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.hqV.setLayoutParams(layoutParams2);
            this.hrp = (int) (l.dip2px(getContext(), pendantData.left) * this.hrh);
            this.hrq = (int) (l.dip2px(getContext(), pendantData.top) * this.hrh);
            this.hrr = (int) (l.dip2px(getContext(), pendantData.right) * this.hrh);
            this.hrs = (int) (l.dip2px(getContext(), pendantData.bottom) * this.hrh);
            this.mContentView.setPadding(this.hrp, this.hrq, this.hrr, this.hrs);
            this.hro = l.t(getContext(), d.e.fontsize40) * this.hrh;
            String text = getText();
            this.hru = (i2 - this.hrq) - this.hrs;
            this.hrv = (i - this.hrp) - this.hrr;
            this.hrx = this.hrw + l.t(getContext(), d.e.ds6);
            setTextSize(0, this.hro);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(d.j.cover_hint), this.hrv);
                this.hro = this.hqV.getTextSize();
                bBN();
                bBO();
            } else {
                if (w.hu(text) > 20) {
                    text = w.F(text, 20);
                    this.hqV.setText(text);
                    this.hqU.setText(text);
                }
                tQ(text);
            }
        }
        this.hqU.setIncludeFontPadding(false);
        this.hqV.setIncludeFontPadding(false);
        this.hqU.setLineSpacing(this.hrw, 1.0f);
        this.hqV.setLineSpacing(this.hrw, 1.0f);
        this.hqS.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.hqS.getLayoutParams();
        layoutParams3.height = (this.hrt * 2) + i2;
        layoutParams3.width = (this.hrt * 2) + i;
        this.hqS.setLayoutParams(layoutParams3);
        this.hry = (this.hrt * 2) + i;
        ((FrameLayout.LayoutParams) this.hqT.getLayoutParams()).setMargins(this.hrt, this.hrt, this.hrt, this.hrt);
        this.hqS.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mTempBitmap == null) {
            bBP();
        }
        return this.mTempBitmap;
    }

    private void bBP() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mTempBitmap = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void bBQ() {
        if (this.mTempBitmap != null && !this.mTempBitmap.isRecycled()) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public void nl(boolean z) {
        if (this.hqY != 0) {
            if (z) {
                bBQ();
                this.hqS.setVisibility(0);
                return;
            }
            bmJ();
            getTempBitmap();
            this.hqS.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.hrz.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.hrz.clear();
        this.hrz = null;
        bBQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements b.a {
        WeakReference<a.b> hrD;
        WeakReference<CoverPendantDragView> hrE;
        WeakReference<PendantData> hrF;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.hrD = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.hrE = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.hrF = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cj(String str, String str2) {
            if (this.hrD != null && this.hrD.get() != null) {
                this.hrD.get().hpL.setVisibility(8);
            }
            if (this.hrE != null && this.hrE.get() != null && this.hrF != null && this.hrF.get() != null) {
                this.hrE.get().a(str2, this.hrF.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void tE(String str) {
            if (this.hrD != null && this.hrD.get() != null) {
                this.hrD.get().hpL.setVisibility(8);
            }
            if (this.hrE != null && this.hrE.get() != null) {
                l.showToast(this.hrE.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void bAS() {
            if (this.hrD != null && this.hrD.get() != null) {
                this.hrD.get().hpL.setVisibility(8);
            }
        }
    }
}
