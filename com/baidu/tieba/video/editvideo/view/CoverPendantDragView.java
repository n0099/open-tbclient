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
    private float lXA;
    private float lXB;
    private int lXC;
    private int lXD;
    private float lXE;
    private float lXF;
    private float lXG;
    private float lXH;
    private c lXI;
    private float lXJ;
    private float lXK;
    private float lXL;
    private float lXM;
    private boolean lXN;
    private int lXO;
    private int lXP;
    private int lXQ;
    private int lXR;
    private int lXS;
    private float lXT;
    private float lXU;
    private int lXV;
    private float lXW;
    private int lXX;
    private Map<String, Bitmap> lXY;
    private Bitmap lXZ;
    private FrameLayout lXs;
    private RotateFrameLayout lXt;
    private TextView lXu;
    private EditText lXv;
    private ImageView lXw;
    private ImageView lXx;
    private int lXy;
    private boolean lXz;
    float lYa;
    float lYb;
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
        this.lXy = 0;
        this.lXH = 1.0f;
        this.liy = 1.0f;
        this.lXN = true;
        this.lXY = new HashMap();
        this.startTime = 0L;
        this.lYa = 0.0f;
        this.lYb = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bin = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lXV = l.getDimens(getContext(), R.dimen.ds2);
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.lXs = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.lXs);
        this.lXs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.lXy == 4) {
                            CoverPendantDragView.this.dnn();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.lXz && abs < CoverPendantDragView.this.hmk && abs2 < CoverPendantDragView.this.hmk && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.EN();
                        }
                        CoverPendantDragView.this.lXA = 0.0f;
                        CoverPendantDragView.this.lXB = 0.0f;
                        CoverPendantDragView.this.lXz = false;
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
                        CoverPendantDragView.this.lXA = 0.0f;
                        CoverPendantDragView.this.lXB = 0.0f;
                        return true;
                }
            }
        });
        this.lXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.lXv.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.lXx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.lXB = 0.0f;
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
        this.lXv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.lXy != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.lXu.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.lXu.getText().length()) {
                        CoverPendantDragView.this.Of(obj);
                    } else {
                        CoverPendantDragView.this.Oe(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Of(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.lXu.setText(editable.toString());
            }
        });
        this.lXv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.lXs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.VU = this.mDownX;
        this.VV = this.mDownY;
        this.lXE = (this.lXs.getWidth() / 2) + this.lXs.getX();
        this.lXF = (this.lXs.getHeight() / 2) + this.lXs.getY();
        this.lXu.setText(this.lXv.getText());
        this.lXu.setVisibility(0);
        this.lXv.setVisibility(8);
        setEditTextEnable(false);
        this.lXI.HidenSoftKeyPad(this.lXv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oe(String str) {
        TextPaint paint = this.lXv.getPaint();
        float measureText = paint.measureText(str);
        while (this.lXv.getLineCount() == 1 && this.lXv.getTextSize() < this.bin * this.liy && measureText < this.lXU * this.liy) {
            setTextSize(0, this.lXv.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.lXv.getTextSize() != this.bin * this.liy) {
            setTextSize(0, this.bin * this.liy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Of(String str) {
        TextPaint paint = this.lXv.getPaint();
        float measureText = paint.measureText(str);
        while (this.lXv.getTextSize() > ((this.lXT * this.liy) / 2.0f) - (this.lXW * this.liy) && measureText > this.lXU * this.liy) {
            setTextSize(0, this.lXv.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.lXv.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.lXv.getTextSize() - 1.0f);
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
        this.lXI = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.lXJ = f;
        this.lXK = f2;
        this.lXL = f3;
        this.lXM = f4;
        if (this.lXJ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.lXJ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lXK > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lXK);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lXL > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lXL) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lXM > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lXM) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.lXE - rawX);
        float abs4 = Math.abs(this.lXF - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.lXE - this.VU);
        float abs6 = Math.abs(this.lXF - this.VV);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dg(sqrt, (int) (sqrt / this.lXG));
        if (this.lXB != 0.0f) {
            this.lXs.setRotation(this.lXs.getRotation() - (this.lXB - N));
        }
        this.lXB = N;
        this.VU = rawX;
        this.VV = rawY;
    }

    private void dg(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lXs.getLayoutParams();
        int width = this.lXs.getWidth() - i;
        int i3 = (int) (width / this.lXG);
        if (width < this.lXC) {
            width = this.lXC;
            i3 = (int) (width / this.lXG);
        }
        this.liy = ((width * 1.0f) - (this.lXS * 2)) / (this.lXX - (this.lXS * 2));
        this.mContentView.setPadding((int) (this.lXO * this.liy), (int) (this.lXP * this.liy), (int) (this.lXQ * this.liy), (int) (this.lXR * this.liy));
        setTextSize(0, (this.lXv.getTextSize() * i3) / this.lXs.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.lXs.setLayoutParams(layoutParams);
        float f = this.lXE - (layoutParams.width / 2);
        float f2 = this.lXF - (layoutParams.height / 2);
        this.lXs.setX(f);
        this.lXs.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.lXy != 4) {
            float y = (this.lXs.getY() + rawY) - this.VV;
            if (y < this.lXK) {
                y = this.lXK;
            } else if (y > (this.lXK + this.mVideoHeight) - this.lXs.getHeight()) {
                y = (this.lXK + this.mVideoHeight) - this.lXs.getHeight();
            }
            this.lXs.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.lXz = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.lXA != 0.0f) {
                    int i = (int) (this.lXA - O);
                    dg(i, (int) (i / this.lXG));
                }
                if (this.lXB != 0.0f) {
                    this.lXs.setRotation(this.lXs.getRotation() - (this.lXB - M));
                }
                this.lXB = M;
                this.lXA = O;
            } else if (!this.lXz && pointerCount == 1) {
                float y2 = (this.lXs.getY() + rawY) - this.VV;
                if (y2 < this.lXK - (this.lXs.getHeight() / 2)) {
                    y2 = this.lXK - (this.lXs.getHeight() / 2);
                } else if (y2 > ((this.lXK + this.mVideoHeight) - this.lXs.getHeight()) + (this.lXs.getHeight() / 2)) {
                    y2 = ((this.lXK + this.mVideoHeight) - this.lXs.getHeight()) + (this.lXs.getHeight() / 2);
                }
                float x = (this.lXs.getX() + rawX) - this.VU;
                if (x < this.lXJ - (this.lXs.getWidth() / 2)) {
                    x = this.lXJ - (this.lXs.getWidth() / 2);
                } else if (x > ((this.lXJ + this.mVideoWidth) - this.lXs.getWidth()) + (this.lXs.getWidth() / 2)) {
                    x = ((this.lXJ + this.mVideoWidth) - this.lXs.getWidth()) + (this.lXs.getWidth() / 2);
                }
                this.lXs.setX(x);
                this.lXs.setY(y2);
            }
        }
        this.VU = rawX;
        this.VV = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.lXv.getTextSize() != f) {
            this.lXv.setTextSize(i, f);
        }
        if (this.lXu.getTextSize() != f) {
            this.lXu.setTextSize(i, f);
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
        matrix.postRotate(this.lXs.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.lXF - motionEvent.getRawY(), this.lXE - motionEvent.getRawX()));
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
        this.lXt = (RotateFrameLayout) this.lXs.findViewById(R.id.content_container);
        this.lXu = (TextView) this.lXs.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.lXs.findViewById(R.id.content_view);
        this.lXv = (EditText) this.lXs.findViewById(R.id.cover_edit);
        this.lXw = (ImageView) this.lXs.findViewById(R.id.cover_delete);
        this.lXx = (ImageView) this.lXs.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.lXu.setText(this.lXv.getText());
        this.lXu.setVisibility(0);
        this.lXv.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.lXu.getText())) {
            this.lXy = 0;
            this.lXs.setVisibility(8);
        }
        if (this.lXy == 4) {
            dnm();
        }
        this.lXI.HidenSoftKeyPad(this.lXv);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.lXv.setFocusable(true);
            this.lXv.setFocusableInTouchMode(true);
            this.lXv.requestFocus();
            return;
        }
        this.lXv.setFocusable(false);
        this.lXv.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.lXv.setText("");
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
                    String Od = com.baidu.tieba.video.editvideo.model.b.dnh().Od(pendantData.resource);
                    if (TextUtils.isEmpty(Od)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.lWr.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dnh().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Od, pendantData);
                        break;
                    }
                    break;
            }
            this.lXy = pendantData.pendantType;
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
        dnm();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.lXy == 4 || this.lXy == 0) {
            this.lXs.setX(this.lXJ);
            this.lXs.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lXK);
            String obj = this.lXv.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.lXv.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.lXu.setText(a2);
                    this.lXv.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dnm() {
        if (this.lXN) {
            this.lXN = false;
            this.lXw.setVisibility(8);
            this.lXx.setVisibility(8);
            this.lXt.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnn() {
        if (!this.lXN) {
            this.lXN = true;
            this.lXw.setVisibility(0);
            this.lXx.setVisibility(0);
            this.lXt.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lXY != null) {
            Bitmap bitmap = this.lXY.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lXY.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dnm();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.lXH = 1.0f;
                this.liy = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.lXH = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.lXC = (this.lXS * 2) + width;
                this.lXD = (this.lXS * 2) + height;
                this.lXG = (this.lXC * 1.0f) / this.lXD;
                this.lXs.setX((((this.mVideoWidth - i2) - (this.lXS * 2)) / 2) + this.lXJ);
                this.lXs.setY((((this.mVideoHeight - i) - (this.lXS * 2)) / 2) + this.lXK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lYa = motionEvent.getRawX();
                this.lYb = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lYa);
                float abs2 = Math.abs(rawY - this.lYb);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hmk && abs2 < this.hmk && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.lXu == null || this.lXu.getText() == null) {
            return null;
        }
        return this.lXu.getText().toString();
    }

    public void EN() {
        this.lXu.setText(this.lXv.getText());
        this.lXu.setVisibility(8);
        this.lXv.setVisibility(0);
        setEditTextEnable(true);
        this.lXI.ShowSoftKeyPad(this.lXv);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.lXv.setTextAppearance(getContext(), R.style.cover_text_style);
            this.lXu.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lXS = 0;
            this.lXv.setMaxLines(1);
            this.lXu.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lXu.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.lXv.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.lXv.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lXu.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lXS = l.getDimens(getContext(), R.dimen.ds40);
            this.lXv.setMaxLines(2);
            this.lXu.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lXu.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.lXv.setLayoutParams(layoutParams2);
            this.lXO = (int) (l.dip2px(getContext(), pendantData.left) * this.lXH);
            this.lXP = (int) (l.dip2px(getContext(), pendantData.f1035top) * this.lXH);
            this.lXQ = (int) (l.dip2px(getContext(), pendantData.right) * this.lXH);
            this.lXR = (int) (l.dip2px(getContext(), pendantData.bottom) * this.lXH);
            this.mContentView.setPadding(this.lXO, this.lXP, this.lXQ, this.lXR);
            this.bin = l.getDimens(getContext(), R.dimen.fontsize40) * this.lXH;
            String text = getText();
            this.lXT = (i2 - this.lXP) - this.lXR;
            this.lXU = (i - this.lXO) - this.lXQ;
            this.lXW = this.lXV + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bin);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lXU);
                this.bin = this.lXv.getTextSize();
                dnn();
                EN();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.lXv.setText(text);
                    this.lXu.setText(text);
                }
                Of(text);
            }
        }
        this.lXu.setIncludeFontPadding(false);
        this.lXv.setIncludeFontPadding(false);
        this.lXu.setLineSpacing(this.lXV, 1.0f);
        this.lXv.setLineSpacing(this.lXV, 1.0f);
        this.lXs.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.lXs.getLayoutParams();
        layoutParams3.height = (this.lXS * 2) + i2;
        layoutParams3.width = (this.lXS * 2) + i;
        this.lXs.setLayoutParams(layoutParams3);
        this.lXX = (this.lXS * 2) + i;
        ((FrameLayout.LayoutParams) this.lXt.getLayoutParams()).setMargins(this.lXS, this.lXS, this.lXS, this.lXS);
        this.lXs.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lXZ == null) {
            dno();
        }
        return this.lXZ;
    }

    private void dno() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lXZ = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dnp() {
        if (this.lXZ != null && !this.lXZ.isRecycled()) {
            this.lXZ.recycle();
            this.lXZ = null;
        }
    }

    public void vj(boolean z) {
        if (this.lXy != 0) {
            if (z) {
                dnp();
                this.lXs.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.lXs.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lXY.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lXY.clear();
        this.lXY = null;
        dnp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lYd;
        WeakReference<CoverPendantDragView> lYe;
        WeakReference<PendantData> lYf;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lYd = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lYe = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lYf = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fE(String str, String str2) {
            if (this.lYd != null && this.lYd.get() != null) {
                this.lYd.get().lWr.setVisibility(8);
            }
            if (this.lYe != null && this.lYe.get() != null && this.lYf != null && this.lYf.get() != null) {
                this.lYe.get().a(str2, this.lYf.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void NW(String str) {
            if (this.lYd != null && this.lYd.get() != null) {
                this.lYd.get().lWr.setVisibility(8);
            }
            if (this.lYe != null && this.lYe.get() != null) {
                l.showToast(this.lYe.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dmx() {
            if (this.lYd != null && this.lYd.get() != null) {
                this.lYd.get().lWr.setVisibility(8);
            }
        }
    }
}
