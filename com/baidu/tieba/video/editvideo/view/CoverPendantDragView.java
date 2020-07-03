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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class CoverPendantDragView extends FrameLayout {
    private float VU;
    private float VV;
    private float bin;
    private float hmk;
    private int lXA;
    private float lXB;
    private float lXC;
    private float lXD;
    private float lXE;
    private c lXF;
    private float lXG;
    private float lXH;
    private float lXI;
    private float lXJ;
    private boolean lXK;
    private int lXL;
    private int lXM;
    private int lXN;
    private int lXO;
    private int lXP;
    private float lXQ;
    private float lXR;
    private int lXS;
    private float lXT;
    private int lXU;
    private Map<String, Bitmap> lXV;
    private Bitmap lXW;
    float lXX;
    float lXY;
    private FrameLayout lXp;
    private RotateFrameLayout lXq;
    private TextView lXr;
    private EditText lXs;
    private ImageView lXt;
    private ImageView lXu;
    private int lXv;
    private boolean lXw;
    private float lXx;
    private float lXy;
    private int lXz;
    private float liy;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
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
        this.lXv = 0;
        this.lXE = 1.0f;
        this.liy = 1.0f;
        this.lXK = true;
        this.lXV = new HashMap();
        this.startTime = 0L;
        this.lXX = 0.0f;
        this.lXY = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bin = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lXS = l.getDimens(getContext(), R.dimen.ds2);
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.lXp = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.lXp);
        this.lXp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.lXv == 4) {
                            CoverPendantDragView.this.dnj();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.lXw && abs < CoverPendantDragView.this.hmk && abs2 < CoverPendantDragView.this.hmk && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.EN();
                        }
                        CoverPendantDragView.this.lXx = 0.0f;
                        CoverPendantDragView.this.lXy = 0.0f;
                        CoverPendantDragView.this.lXw = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
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
                        CoverPendantDragView.this.lXx = 0.0f;
                        CoverPendantDragView.this.lXy = 0.0f;
                        return true;
                }
            }
        });
        this.lXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.lXs.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.lXu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.lXy = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.I(motionEvent)) {
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
        this.lXs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.lXv != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.lXr.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.lXr.getText().length()) {
                        CoverPendantDragView.this.Oe(obj);
                    } else {
                        CoverPendantDragView.this.Od(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Oe(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.lXr.setText(editable.toString());
            }
        });
        this.lXs.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.lXp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.VU = this.mDownX;
        this.VV = this.mDownY;
        this.lXB = (this.lXp.getWidth() / 2) + this.lXp.getX();
        this.lXC = (this.lXp.getHeight() / 2) + this.lXp.getY();
        this.lXr.setText(this.lXs.getText());
        this.lXr.setVisibility(0);
        this.lXs.setVisibility(8);
        setEditTextEnable(false);
        this.lXF.HidenSoftKeyPad(this.lXs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Od(String str) {
        TextPaint paint = this.lXs.getPaint();
        float measureText = paint.measureText(str);
        while (this.lXs.getLineCount() == 1 && this.lXs.getTextSize() < this.bin * this.liy && measureText < this.lXR * this.liy) {
            setTextSize(0, this.lXs.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.lXs.getTextSize() != this.bin * this.liy) {
            setTextSize(0, this.bin * this.liy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oe(String str) {
        TextPaint paint = this.lXs.getPaint();
        float measureText = paint.measureText(str);
        while (this.lXs.getTextSize() > ((this.lXQ * this.liy) / 2.0f) - (this.lXT * this.liy) && measureText > this.lXR * this.liy) {
            setTextSize(0, this.lXs.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.lXs.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.lXs.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ae.subStringWithEmoji(str, ae.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.lXF = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.lXG = f;
        this.lXH = f2;
        this.lXI = f3;
        this.lXJ = f4;
        if (this.lXG > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.lXG, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lXH > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lXH);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lXI > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lXI) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lXJ > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lXJ) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float N = N(motionEvent);
        float abs = Math.abs(this.VU - rawX);
        float abs2 = Math.abs(this.VV - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.lXB - rawX);
        float abs4 = Math.abs(this.lXC - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.lXB - this.VU);
        float abs6 = Math.abs(this.lXC - this.VV);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dg(sqrt, (int) (sqrt / this.lXD));
        if (this.lXy != 0.0f) {
            this.lXp.setRotation(this.lXp.getRotation() - (this.lXy - N));
        }
        this.lXy = N;
        this.VU = rawX;
        this.VV = rawY;
    }

    private void dg(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lXp.getLayoutParams();
        int width = this.lXp.getWidth() - i;
        int i3 = (int) (width / this.lXD);
        if (width < this.lXz) {
            width = this.lXz;
            i3 = (int) (width / this.lXD);
        }
        this.liy = ((width * 1.0f) - (this.lXP * 2)) / (this.lXU - (this.lXP * 2));
        this.mContentView.setPadding((int) (this.lXL * this.liy), (int) (this.lXM * this.liy), (int) (this.lXN * this.liy), (int) (this.lXO * this.liy));
        setTextSize(0, (this.lXs.getTextSize() * i3) / this.lXp.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.lXp.setLayoutParams(layoutParams);
        float f = this.lXB - (layoutParams.width / 2);
        float f2 = this.lXC - (layoutParams.height / 2);
        this.lXp.setX(f);
        this.lXp.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.lXv != 4) {
            float y = (this.lXp.getY() + rawY) - this.VV;
            if (y < this.lXH) {
                y = this.lXH;
            } else if (y > (this.lXH + this.mVideoHeight) - this.lXp.getHeight()) {
                y = (this.lXH + this.mVideoHeight) - this.lXp.getHeight();
            }
            this.lXp.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.lXw = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.lXx != 0.0f) {
                    int i = (int) (this.lXx - O);
                    dg(i, (int) (i / this.lXD));
                }
                if (this.lXy != 0.0f) {
                    this.lXp.setRotation(this.lXp.getRotation() - (this.lXy - M));
                }
                this.lXy = M;
                this.lXx = O;
            } else if (!this.lXw && pointerCount == 1) {
                float y2 = (this.lXp.getY() + rawY) - this.VV;
                if (y2 < this.lXH - (this.lXp.getHeight() / 2)) {
                    y2 = this.lXH - (this.lXp.getHeight() / 2);
                } else if (y2 > ((this.lXH + this.mVideoHeight) - this.lXp.getHeight()) + (this.lXp.getHeight() / 2)) {
                    y2 = ((this.lXH + this.mVideoHeight) - this.lXp.getHeight()) + (this.lXp.getHeight() / 2);
                }
                float x = (this.lXp.getX() + rawX) - this.VU;
                if (x < this.lXG - (this.lXp.getWidth() / 2)) {
                    x = this.lXG - (this.lXp.getWidth() / 2);
                } else if (x > ((this.lXG + this.mVideoWidth) - this.lXp.getWidth()) + (this.lXp.getWidth() / 2)) {
                    x = ((this.lXG + this.mVideoWidth) - this.lXp.getWidth()) + (this.lXp.getWidth() / 2);
                }
                this.lXp.setX(x);
                this.lXp.setY(y2);
            }
        }
        this.VU = rawX;
        this.VV = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.lXs.getTextSize() != f) {
            this.lXs.setTextSize(i, f);
        }
        if (this.lXr.getTextSize() != f) {
            this.lXr.setTextSize(i, f);
        }
    }

    private float M(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.lXp.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.lXC - motionEvent.getRawY(), this.lXB - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hmk && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hmk;
    }

    private void init() {
        this.lXq = (RotateFrameLayout) this.lXp.findViewById(R.id.content_container);
        this.lXr = (TextView) this.lXp.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.lXp.findViewById(R.id.content_view);
        this.lXs = (EditText) this.lXp.findViewById(R.id.cover_edit);
        this.lXt = (ImageView) this.lXp.findViewById(R.id.cover_delete);
        this.lXu = (ImageView) this.lXp.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.lXr.setText(this.lXs.getText());
        this.lXr.setVisibility(0);
        this.lXs.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.lXr.getText())) {
            this.lXv = 0;
            this.lXp.setVisibility(8);
        }
        if (this.lXv == 4) {
            dni();
        }
        this.lXF.HidenSoftKeyPad(this.lXs);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.lXs.setFocusable(true);
            this.lXs.setFocusableInTouchMode(true);
            this.lXs.requestFocus();
            return;
        }
        this.lXs.setFocusable(false);
        this.lXs.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.lXs.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    EN();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    EN();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    EN();
                    break;
                default:
                    hideSoftKeyPad();
                    String Oc = com.baidu.tieba.video.editvideo.model.b.dnd().Oc(pendantData.resource);
                    if (TextUtils.isEmpty(Oc)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.lWo.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dnd().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Oc, pendantData);
                        break;
                    }
                    break;
            }
            this.lXv = pendantData.pendantType;
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
        dni();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.lXv == 4 || this.lXv == 0) {
            this.lXp.setX(this.lXG);
            this.lXp.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lXH);
            String obj = this.lXs.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.lXs.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.lXr.setText(a2);
                    this.lXs.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dni() {
        if (this.lXK) {
            this.lXK = false;
            this.lXt.setVisibility(8);
            this.lXu.setVisibility(8);
            this.lXq.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnj() {
        if (!this.lXK) {
            this.lXK = true;
            this.lXt.setVisibility(0);
            this.lXu.setVisibility(0);
            this.lXq.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lXV != null) {
            Bitmap bitmap = this.lXV.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lXV.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dni();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.lXE = 1.0f;
                this.liy = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.lXE = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.lXz = (this.lXP * 2) + width;
                this.lXA = (this.lXP * 2) + height;
                this.lXD = (this.lXz * 1.0f) / this.lXA;
                this.lXp.setX((((this.mVideoWidth - i2) - (this.lXP * 2)) / 2) + this.lXG);
                this.lXp.setY((((this.mVideoHeight - i) - (this.lXP * 2)) / 2) + this.lXH);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lXX = motionEvent.getRawX();
                this.lXY = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lXX);
                float abs2 = Math.abs(rawY - this.lXY);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hmk && abs2 < this.hmk && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.lXr == null || this.lXr.getText() == null) {
            return null;
        }
        return this.lXr.getText().toString();
    }

    public void EN() {
        this.lXr.setText(this.lXs.getText());
        this.lXr.setVisibility(8);
        this.lXs.setVisibility(0);
        setEditTextEnable(true);
        this.lXF.ShowSoftKeyPad(this.lXs);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.lXs.setTextAppearance(getContext(), R.style.cover_text_style);
            this.lXr.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lXP = 0;
            this.lXs.setMaxLines(1);
            this.lXr.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lXr.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.lXs.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.lXs.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lXr.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lXP = l.getDimens(getContext(), R.dimen.ds40);
            this.lXs.setMaxLines(2);
            this.lXr.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lXr.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.lXs.setLayoutParams(layoutParams2);
            this.lXL = (int) (l.dip2px(getContext(), pendantData.left) * this.lXE);
            this.lXM = (int) (l.dip2px(getContext(), pendantData.f1034top) * this.lXE);
            this.lXN = (int) (l.dip2px(getContext(), pendantData.right) * this.lXE);
            this.lXO = (int) (l.dip2px(getContext(), pendantData.bottom) * this.lXE);
            this.mContentView.setPadding(this.lXL, this.lXM, this.lXN, this.lXO);
            this.bin = l.getDimens(getContext(), R.dimen.fontsize40) * this.lXE;
            String text = getText();
            this.lXQ = (i2 - this.lXM) - this.lXO;
            this.lXR = (i - this.lXL) - this.lXN;
            this.lXT = this.lXS + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bin);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lXR);
                this.bin = this.lXs.getTextSize();
                dnj();
                EN();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.lXs.setText(text);
                    this.lXr.setText(text);
                }
                Oe(text);
            }
        }
        this.lXr.setIncludeFontPadding(false);
        this.lXs.setIncludeFontPadding(false);
        this.lXr.setLineSpacing(this.lXS, 1.0f);
        this.lXs.setLineSpacing(this.lXS, 1.0f);
        this.lXp.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.lXp.getLayoutParams();
        layoutParams3.height = (this.lXP * 2) + i2;
        layoutParams3.width = (this.lXP * 2) + i;
        this.lXp.setLayoutParams(layoutParams3);
        this.lXU = (this.lXP * 2) + i;
        ((FrameLayout.LayoutParams) this.lXq.getLayoutParams()).setMargins(this.lXP, this.lXP, this.lXP, this.lXP);
        this.lXp.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lXW == null) {
            dnk();
        }
        return this.lXW;
    }

    private void dnk() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lXW = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dnl() {
        if (this.lXW != null && !this.lXW.isRecycled()) {
            this.lXW.recycle();
            this.lXW = null;
        }
    }

    public void vj(boolean z) {
        if (this.lXv != 0) {
            if (z) {
                dnl();
                this.lXp.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.lXp.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lXV.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lXV.clear();
        this.lXV = null;
        dnl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lYa;
        WeakReference<CoverPendantDragView> lYb;
        WeakReference<PendantData> lYc;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lYa = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lYb = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lYc = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fE(String str, String str2) {
            if (this.lYa != null && this.lYa.get() != null) {
                this.lYa.get().lWo.setVisibility(8);
            }
            if (this.lYb != null && this.lYb.get() != null && this.lYc != null && this.lYc.get() != null) {
                this.lYb.get().a(str2, this.lYc.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void NV(String str) {
            if (this.lYa != null && this.lYa.get() != null) {
                this.lYa.get().lWo.setVisibility(8);
            }
            if (this.lYb != null && this.lYb.get() != null) {
                l.showToast(this.lYb.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dmt() {
            if (this.lYa != null && this.lYa.get() != null) {
                this.lYa.get().lWo.setVisibility(8);
            }
        }
    }
}
