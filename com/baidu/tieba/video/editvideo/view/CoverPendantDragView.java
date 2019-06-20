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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float NR;
    private float NT;
    private float cPq;
    private float eXS;
    float fsJ;
    float fsK;
    private float iDI;
    private float jqA;
    private int jqB;
    private int jqC;
    private float jqD;
    private float jqE;
    private float jqF;
    private float jqG;
    private b jqH;
    private float jqI;
    private float jqJ;
    private float jqK;
    private float jqL;
    private boolean jqM;
    private float jqN;
    private int jqO;
    private int jqP;
    private int jqQ;
    private int jqR;
    private int jqS;
    private float jqT;
    private float jqU;
    private int jqV;
    private float jqW;
    private int jqX;
    private Map<String, Bitmap> jqY;
    private Bitmap jqZ;
    private FrameLayout jqr;
    private RotateFrameLayout jqs;
    private TextView jqt;
    private EditText jqu;
    private ImageView jqv;
    private ImageView jqw;
    private int jqx;
    private boolean jqy;
    private float jqz;
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
        this.jqx = 0;
        this.jqG = 1.0f;
        this.iDI = 1.0f;
        this.jqM = true;
        this.jqY = new HashMap();
        this.startTime = 0L;
        this.fsJ = 0.0f;
        this.fsK = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jqN = l.g(getContext(), R.dimen.fontsize40);
        this.jqV = l.g(getContext(), R.dimen.ds2);
        this.eXS = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jqr = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jqr);
        this.jqr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jqx == 4) {
                            CoverPendantDragView.this.crV();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cPq);
                        if (!CoverPendantDragView.this.jqy && abs < CoverPendantDragView.this.eXS && abs2 < CoverPendantDragView.this.eXS && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.crW();
                        }
                        CoverPendantDragView.this.jqz = 0.0f;
                        CoverPendantDragView.this.jqA = 0.0f;
                        CoverPendantDragView.this.jqy = false;
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
                        CoverPendantDragView.this.jqz = 0.0f;
                        CoverPendantDragView.this.jqA = 0.0f;
                        return true;
                }
            }
        });
        this.jqv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jqu.setText("");
                CoverPendantDragView.this.cdb();
            }
        });
        this.jqw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jqA = 0.0f;
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
        this.jqu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jqx != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jqt.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ab.qX(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jqt.getText().length()) {
                        CoverPendantDragView.this.Fb(obj);
                    } else {
                        CoverPendantDragView.this.Fa(obj);
                    }
                } else {
                    String ab = ab.ab(obj, 20);
                    editable.delete(ab.length(), obj.length());
                    CoverPendantDragView.this.Fb(ab);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jqt.setText(editable.toString());
            }
        });
        this.jqu.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jqr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cPq = motionEvent.getRawY();
        this.NR = this.mDownX;
        this.NT = this.cPq;
        this.jqD = (this.jqr.getWidth() / 2) + this.jqr.getX();
        this.jqE = (this.jqr.getHeight() / 2) + this.jqr.getY();
        this.jqt.setText(this.jqu.getText());
        this.jqt.setVisibility(0);
        this.jqu.setVisibility(8);
        setEditTextEnable(false);
        this.jqH.HidenSoftKeyPad(this.jqu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa(String str) {
        TextPaint paint = this.jqu.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqu.getLineCount() == 1 && this.jqu.getTextSize() < this.jqN * this.iDI && measureText < this.jqU * this.iDI) {
            setTextSize(0, this.jqu.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.qX(str) <= ab.qX(getResources().getString(R.string.cover_hint)) && this.jqu.getTextSize() != this.jqN * this.iDI) {
            setTextSize(0, this.jqN * this.iDI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fb(String str) {
        TextPaint paint = this.jqu.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqu.getTextSize() > ((this.jqT * this.iDI) / 2.0f) - (this.jqW * this.iDI) && measureText > this.jqU * this.iDI) {
            setTextSize(0, this.jqu.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jqu.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jqu.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.g(getContext(), R.dimen.ds120)) {
            str = ab.ad(str, ab.qW(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.jqH = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jqI = f;
        this.jqJ = f2;
        this.jqK = f3;
        this.jqL = f4;
        if (this.jqI > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jqI, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jqJ > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jqJ);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jqK > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jqK) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jqL > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jqL) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float Q = Q(motionEvent);
        float abs = Math.abs(this.NR - rawX);
        float abs2 = Math.abs(this.NT - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.jqD - rawX);
        float abs4 = Math.abs(this.jqE - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jqD - this.NR);
        float abs6 = Math.abs(this.jqE - this.NT);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cA(sqrt, (int) (sqrt / this.jqF));
        if (this.jqA != 0.0f) {
            this.jqr.setRotation(this.jqr.getRotation() - (this.jqA - Q));
        }
        this.jqA = Q;
        this.NR = rawX;
        this.NT = rawY;
    }

    private void cA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqr.getLayoutParams();
        int width = this.jqr.getWidth() - i;
        int i3 = (int) (width / this.jqF);
        if (width < this.jqB) {
            width = this.jqB;
            i3 = (int) (width / this.jqF);
        }
        this.iDI = ((width * 1.0f) - (this.jqS * 2)) / (this.jqX - (this.jqS * 2));
        this.mContentView.setPadding((int) (this.jqO * this.iDI), (int) (this.jqP * this.iDI), (int) (this.jqQ * this.iDI), (int) (this.jqR * this.iDI));
        setTextSize(0, (this.jqu.getTextSize() * i3) / this.jqr.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jqr.setLayoutParams(layoutParams);
        float f = this.jqD - (layoutParams.width / 2);
        float f2 = this.jqE - (layoutParams.height / 2);
        this.jqr.setX(f);
        this.jqr.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jqx != 4) {
            float y = (this.jqr.getY() + rawY) - this.NT;
            if (y < this.jqJ) {
                y = this.jqJ;
            } else if (y > (this.jqJ + this.mVideoHeight) - this.jqr.getHeight()) {
                y = (this.jqJ + this.mVideoHeight) - this.jqr.getHeight();
            }
            this.jqr.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jqy = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.jqz != 0.0f) {
                    int i = (int) (this.jqz - R);
                    cA(i, (int) (i / this.jqF));
                }
                if (this.jqA != 0.0f) {
                    this.jqr.setRotation(this.jqr.getRotation() - (this.jqA - P));
                }
                this.jqA = P;
                this.jqz = R;
            } else if (!this.jqy && pointerCount == 1) {
                float y2 = (this.jqr.getY() + rawY) - this.NT;
                if (y2 < this.jqJ - (this.jqr.getHeight() / 2)) {
                    y2 = this.jqJ - (this.jqr.getHeight() / 2);
                } else if (y2 > ((this.jqJ + this.mVideoHeight) - this.jqr.getHeight()) + (this.jqr.getHeight() / 2)) {
                    y2 = ((this.jqJ + this.mVideoHeight) - this.jqr.getHeight()) + (this.jqr.getHeight() / 2);
                }
                float x = (this.jqr.getX() + rawX) - this.NR;
                if (x < this.jqI - (this.jqr.getWidth() / 2)) {
                    x = this.jqI - (this.jqr.getWidth() / 2);
                } else if (x > ((this.jqI + this.mVideoWidth) - this.jqr.getWidth()) + (this.jqr.getWidth() / 2)) {
                    x = ((this.jqI + this.mVideoWidth) - this.jqr.getWidth()) + (this.jqr.getWidth() / 2);
                }
                this.jqr.setX(x);
                this.jqr.setY(y2);
            }
        }
        this.NR = rawX;
        this.NT = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jqu.getTextSize() != f) {
            this.jqu.setTextSize(i, f);
        }
        if (this.jqt.getTextSize() != f) {
            this.jqt.setTextSize(i, f);
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
        matrix.postRotate(this.jqr.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jqE - motionEvent.getRawY(), this.jqD - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eXS && Math.abs(motionEvent.getRawY() - this.cPq) < this.eXS;
    }

    private void init() {
        this.jqs = (RotateFrameLayout) this.jqr.findViewById(R.id.content_container);
        this.jqt = (TextView) this.jqr.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jqr.findViewById(R.id.content_view);
        this.jqu = (EditText) this.jqr.findViewById(R.id.cover_edit);
        this.jqv = (ImageView) this.jqr.findViewById(R.id.cover_delete);
        this.jqw = (ImageView) this.jqr.findViewById(R.id.cover_scale);
    }

    public void cdb() {
        this.jqt.setText(this.jqu.getText());
        this.jqt.setVisibility(0);
        this.jqu.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jqt.getText())) {
            this.jqx = 0;
            this.jqr.setVisibility(8);
        }
        if (this.jqx == 4) {
            crU();
        }
        this.jqH.HidenSoftKeyPad(this.jqu);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jqu.setFocusable(true);
            this.jqu.setFocusableInTouchMode(true);
            this.jqu.requestFocus();
            return;
        }
        this.jqu.setFocusable(false);
        this.jqu.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jqu.setText("");
                    cdb();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    crW();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    crW();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    crW();
                    break;
                default:
                    cdb();
                    String EZ = com.baidu.tieba.video.editvideo.model.b.crP().EZ(pendantData.resource);
                    if (TextUtils.isEmpty(EZ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jpo.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.crP().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(EZ, pendantData);
                        break;
                    }
                    break;
            }
            this.jqx = pendantData.pendantType;
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
        crU();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jqx == 4 || this.jqx == 0) {
            this.jqr.setX(this.jqI);
            this.jqr.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jqJ);
            String obj = this.jqu.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jqu.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jqt.setText(a2);
                    this.jqu.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void crU() {
        if (this.jqM) {
            this.jqM = false;
            this.jqv.setVisibility(8);
            this.jqw.setVisibility(8);
            this.jqs.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crV() {
        if (!this.jqM) {
            this.jqM = true;
            this.jqv.setVisibility(0);
            this.jqw.setVisibility(0);
            this.jqs.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jqY != null) {
            Bitmap bitmap = this.jqY.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jqY.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                crU();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jqG = 1.0f;
                this.iDI = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jqG = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jqB = (this.jqS * 2) + width;
                this.jqC = (this.jqS * 2) + height;
                this.jqF = (this.jqB * 1.0f) / this.jqC;
                this.jqr.setX((((this.mVideoWidth - i2) - (this.jqS * 2)) / 2) + this.jqI);
                this.jqr.setY((((this.mVideoHeight - i) - (this.jqS * 2)) / 2) + this.jqJ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fsJ = motionEvent.getRawX();
                this.fsK = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fsJ);
                float abs2 = Math.abs(rawY - this.fsK);
                if (motionEvent.getPointerCount() <= 1 && abs < this.eXS && abs2 < this.eXS && System.currentTimeMillis() - this.startTime < 300) {
                    cdb();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jqt == null || this.jqt.getText() == null) {
            return null;
        }
        return this.jqt.getText().toString();
    }

    public void crW() {
        this.jqt.setText(this.jqu.getText());
        this.jqt.setVisibility(8);
        this.jqu.setVisibility(0);
        setEditTextEnable(true);
        this.jqH.ShowSoftKeyPad(this.jqu);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jqu.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jqt.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jqS = 0;
            this.jqu.setMaxLines(1);
            this.jqt.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqt.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jqu.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jqu.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqt.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqS = l.g(getContext(), R.dimen.ds40);
            this.jqu.setMaxLines(2);
            this.jqt.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jqt.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jqu.setLayoutParams(layoutParams2);
            this.jqO = (int) (l.dip2px(getContext(), pendantData.left) * this.jqG);
            this.jqP = (int) (l.dip2px(getContext(), pendantData.top) * this.jqG);
            this.jqQ = (int) (l.dip2px(getContext(), pendantData.right) * this.jqG);
            this.jqR = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jqG);
            this.mContentView.setPadding(this.jqO, this.jqP, this.jqQ, this.jqR);
            this.jqN = l.g(getContext(), R.dimen.fontsize40) * this.jqG;
            String text = getText();
            this.jqT = (i2 - this.jqP) - this.jqR;
            this.jqU = (i - this.jqO) - this.jqQ;
            this.jqW = this.jqV + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jqN);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jqU);
                this.jqN = this.jqu.getTextSize();
                crV();
                crW();
            } else {
                if (ab.qX(text) > 20) {
                    text = ab.ab(text, 20);
                    this.jqu.setText(text);
                    this.jqt.setText(text);
                }
                Fb(text);
            }
        }
        this.jqt.setIncludeFontPadding(false);
        this.jqu.setIncludeFontPadding(false);
        this.jqt.setLineSpacing(this.jqV, 1.0f);
        this.jqu.setLineSpacing(this.jqV, 1.0f);
        this.jqr.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jqr.getLayoutParams();
        layoutParams3.height = (this.jqS * 2) + i2;
        layoutParams3.width = (this.jqS * 2) + i;
        this.jqr.setLayoutParams(layoutParams3);
        this.jqX = (this.jqS * 2) + i;
        ((FrameLayout.LayoutParams) this.jqs.getLayoutParams()).setMargins(this.jqS, this.jqS, this.jqS, this.jqS);
        this.jqr.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jqZ == null) {
            crX();
        }
        return this.jqZ;
    }

    private void crX() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jqZ = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void crY() {
        if (this.jqZ != null && !this.jqZ.isRecycled()) {
            this.jqZ.recycle();
            this.jqZ = null;
        }
    }

    public void rr(boolean z) {
        if (this.jqx != 0) {
            if (z) {
                crY();
                this.jqr.setVisibility(0);
                return;
            }
            cdb();
            getTempBitmap();
            this.jqr.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jqY.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jqY.clear();
        this.jqY = null;
        crY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jrb;
        WeakReference<CoverPendantDragView> jrc;
        WeakReference<PendantData> jrd;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jrb = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jrc = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jrd = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void er(String str, String str2) {
            if (this.jrb != null && this.jrb.get() != null) {
                this.jrb.get().jpo.setVisibility(8);
            }
            if (this.jrc != null && this.jrc.get() != null && this.jrd != null && this.jrd.get() != null) {
                this.jrc.get().a(str2, this.jrd.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void EQ(String str) {
            if (this.jrb != null && this.jrb.get() != null) {
                this.jrb.get().jpo.setVisibility(8);
            }
            if (this.jrc != null && this.jrc.get() != null) {
                l.showToast(this.jrc.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void crc() {
            if (this.jrb != null && this.jrb.get() != null) {
                this.jrb.get().jpo.setVisibility(8);
            }
        }
    }
}
