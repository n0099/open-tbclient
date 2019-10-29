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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float apk;
    private float dbc;
    private float fhT;
    float fzg;
    float fzh;
    private float iMs;
    private Map<String, Bitmap> jAA;
    private Bitmap jAB;
    private int jAa;
    private boolean jAb;
    private float jAc;
    private float jAd;
    private int jAe;
    private int jAf;
    private float jAg;
    private float jAh;
    private float jAi;
    private float jAj;
    private b jAk;
    private float jAl;
    private float jAm;
    private float jAn;
    private float jAo;
    private boolean jAp;
    private int jAq;
    private int jAr;
    private int jAs;
    private int jAt;
    private int jAu;
    private float jAv;
    private float jAw;
    private int jAx;
    private float jAy;
    private int jAz;
    private FrameLayout jzU;
    private RotateFrameLayout jzV;
    private TextView jzW;
    private EditText jzX;
    private ImageView jzY;
    private ImageView jzZ;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
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
        this.jAa = 0;
        this.jAj = 1.0f;
        this.iMs = 1.0f;
        this.jAp = true;
        this.jAA = new HashMap();
        this.startTime = 0L;
        this.fzg = 0.0f;
        this.fzh = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.apk = l.getDimens(getContext(), R.dimen.fontsize40);
        this.jAx = l.getDimens(getContext(), R.dimen.ds2);
        this.fhT = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jzU = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jzU);
        this.jzU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.jAa == 4) {
                            CoverPendantDragView.this.ctG();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.dbc);
                        if (!CoverPendantDragView.this.jAb && abs < CoverPendantDragView.this.fhT && abs2 < CoverPendantDragView.this.fhT && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.tG();
                        }
                        CoverPendantDragView.this.jAc = 0.0f;
                        CoverPendantDragView.this.jAd = 0.0f;
                        CoverPendantDragView.this.jAb = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.G(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.jAc = 0.0f;
                        CoverPendantDragView.this.jAd = 0.0f;
                        return true;
                }
            }
        });
        this.jzY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jzX.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.jzZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jAd = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.E(motionEvent)) {
                            CoverPendantDragView.this.F(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.jzX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jAa != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jzW.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (aa.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jzW.getText().length()) {
                        CoverPendantDragView.this.ES(obj);
                    } else {
                        CoverPendantDragView.this.ER(obj);
                    }
                } else {
                    String subStringWithAllOne = aa.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.ES(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jzW.setText(editable.toString());
            }
        });
        this.jzX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jzU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.dbc = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.dbc;
        this.jAg = (this.jzU.getWidth() / 2) + this.jzU.getX();
        this.jAh = (this.jzU.getHeight() / 2) + this.jzU.getY();
        this.jzW.setText(this.jzX.getText());
        this.jzW.setVisibility(0);
        this.jzX.setVisibility(8);
        setEditTextEnable(false);
        this.jAk.HidenSoftKeyPad(this.jzX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ER(String str) {
        TextPaint paint = this.jzX.getPaint();
        float measureText = paint.measureText(str);
        while (this.jzX.getLineCount() == 1 && this.jzX.getTextSize() < this.apk * this.iMs && measureText < this.jAw * this.iMs) {
            setTextSize(0, this.jzX.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (aa.getTextLengthAllOne(str) <= aa.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.jzX.getTextSize() != this.apk * this.iMs) {
            setTextSize(0, this.apk * this.iMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES(String str) {
        TextPaint paint = this.jzX.getPaint();
        float measureText = paint.measureText(str);
        while (this.jzX.getTextSize() > ((this.jAv * this.iMs) / 2.0f) - (this.jAy * this.iMs) && measureText > this.jAw * this.iMs) {
            setTextSize(0, this.jzX.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.jzX.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jzX.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = aa.subStringWithEmoji(str, aa.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.jAk = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jAl = f;
        this.jAm = f2;
        this.jAn = f3;
        this.jAo = f4;
        if (this.jAl > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jAl, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jAm > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jAm);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jAn > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jAn) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jAo > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jAo) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.jAg - rawX);
        float abs4 = Math.abs(this.jAh - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jAg - this.mLastX);
        float abs6 = Math.abs(this.jAh - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cx(sqrt, (int) (sqrt / this.jAi));
        if (this.jAd != 0.0f) {
            this.jzU.setRotation(this.jzU.getRotation() - (this.jAd - I));
        }
        this.jAd = I;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cx(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jzU.getLayoutParams();
        int width = this.jzU.getWidth() - i;
        int i3 = (int) (width / this.jAi);
        if (width < this.jAe) {
            width = this.jAe;
            i3 = (int) (width / this.jAi);
        }
        this.iMs = ((width * 1.0f) - (this.jAu * 2)) / (this.jAz - (this.jAu * 2));
        this.mContentView.setPadding((int) (this.jAq * this.iMs), (int) (this.jAr * this.iMs), (int) (this.jAs * this.iMs), (int) (this.jAt * this.iMs));
        setTextSize(0, (this.jzX.getTextSize() * i3) / this.jzU.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jzU.setLayoutParams(layoutParams);
        float f = this.jAg - (layoutParams.width / 2);
        float f2 = this.jAh - (layoutParams.height / 2);
        this.jzU.setX(f);
        this.jzU.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jAa != 4) {
            float y = (this.jzU.getY() + rawY) - this.mLastY;
            if (y < this.jAm) {
                y = this.jAm;
            } else if (y > (this.jAm + this.mVideoHeight) - this.jzU.getHeight()) {
                y = (this.jAm + this.mVideoHeight) - this.jzU.getHeight();
            }
            this.jzU.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jAb = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.jAc != 0.0f) {
                    int i = (int) (this.jAc - J);
                    cx(i, (int) (i / this.jAi));
                }
                if (this.jAd != 0.0f) {
                    this.jzU.setRotation(this.jzU.getRotation() - (this.jAd - H));
                }
                this.jAd = H;
                this.jAc = J;
            } else if (!this.jAb && pointerCount == 1) {
                float y2 = (this.jzU.getY() + rawY) - this.mLastY;
                if (y2 < this.jAm - (this.jzU.getHeight() / 2)) {
                    y2 = this.jAm - (this.jzU.getHeight() / 2);
                } else if (y2 > ((this.jAm + this.mVideoHeight) - this.jzU.getHeight()) + (this.jzU.getHeight() / 2)) {
                    y2 = ((this.jAm + this.mVideoHeight) - this.jzU.getHeight()) + (this.jzU.getHeight() / 2);
                }
                float x = (this.jzU.getX() + rawX) - this.mLastX;
                if (x < this.jAl - (this.jzU.getWidth() / 2)) {
                    x = this.jAl - (this.jzU.getWidth() / 2);
                } else if (x > ((this.jAl + this.mVideoWidth) - this.jzU.getWidth()) + (this.jzU.getWidth() / 2)) {
                    x = ((this.jAl + this.mVideoWidth) - this.jzU.getWidth()) + (this.jzU.getWidth() / 2);
                }
                this.jzU.setX(x);
                this.jzU.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jzX.getTextSize() != f) {
            this.jzX.setTextSize(i, f);
        }
        if (this.jzW.getTextSize() != f) {
            this.jzW.setTextSize(i, f);
        }
    }

    private float H(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.jzU.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jAh - motionEvent.getRawY(), this.jAg - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fhT && Math.abs(motionEvent.getRawY() - this.dbc) < this.fhT;
    }

    private void init() {
        this.jzV = (RotateFrameLayout) this.jzU.findViewById(R.id.content_container);
        this.jzW = (TextView) this.jzU.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jzU.findViewById(R.id.content_view);
        this.jzX = (EditText) this.jzU.findViewById(R.id.cover_edit);
        this.jzY = (ImageView) this.jzU.findViewById(R.id.cover_delete);
        this.jzZ = (ImageView) this.jzU.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.jzW.setText(this.jzX.getText());
        this.jzW.setVisibility(0);
        this.jzX.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jzW.getText())) {
            this.jAa = 0;
            this.jzU.setVisibility(8);
        }
        if (this.jAa == 4) {
            ctF();
        }
        this.jAk.HidenSoftKeyPad(this.jzX);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jzX.setFocusable(true);
            this.jzX.setFocusableInTouchMode(true);
            this.jzX.requestFocus();
            return;
        }
        this.jzX.setFocusable(false);
        this.jzX.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jzX.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    tG();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    tG();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    tG();
                    break;
                default:
                    hideSoftKeyPad();
                    String EQ = com.baidu.tieba.video.editvideo.model.b.ctA().EQ(pendantData.resource);
                    if (TextUtils.isEmpty(EQ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jyQ.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.ctA().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(EQ, pendantData);
                        break;
                    }
                    break;
            }
            this.jAa = pendantData.pendantType;
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
        ctF();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jAa == 4 || this.jAa == 0) {
            this.jzU.setX(this.jAl);
            this.jzU.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.jAm);
            String obj = this.jzX.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jzX.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jzW.setText(a2);
                    this.jzX.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void ctF() {
        if (this.jAp) {
            this.jAp = false;
            this.jzY.setVisibility(8);
            this.jzZ.setVisibility(8);
            this.jzV.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctG() {
        if (!this.jAp) {
            this.jAp = true;
            this.jzY.setVisibility(0);
            this.jzZ.setVisibility(0);
            this.jzV.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jAA != null) {
            Bitmap bitmap = this.jAA.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jAA.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                ctF();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jAj = 1.0f;
                this.iMs = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jAj = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jAe = (this.jAu * 2) + width;
                this.jAf = (this.jAu * 2) + height;
                this.jAi = (this.jAe * 1.0f) / this.jAf;
                this.jzU.setX((((this.mVideoWidth - i2) - (this.jAu * 2)) / 2) + this.jAl);
                this.jzU.setY((((this.mVideoHeight - i) - (this.jAu * 2)) / 2) + this.jAm);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fzg = motionEvent.getRawX();
                this.fzh = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fzg);
                float abs2 = Math.abs(rawY - this.fzh);
                if (motionEvent.getPointerCount() <= 1 && abs < this.fhT && abs2 < this.fhT && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jzW == null || this.jzW.getText() == null) {
            return null;
        }
        return this.jzW.getText().toString();
    }

    public void tG() {
        this.jzW.setText(this.jzX.getText());
        this.jzW.setVisibility(8);
        this.jzX.setVisibility(0);
        setEditTextEnable(true);
        this.jAk.ShowSoftKeyPad(this.jzX);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jzX.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jzW.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jAu = 0;
            this.jzX.setMaxLines(1);
            this.jzW.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jzW.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jzX.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.jzX.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jzW.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jAu = l.getDimens(getContext(), R.dimen.ds40);
            this.jzX.setMaxLines(2);
            this.jzW.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jzW.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jzX.setLayoutParams(layoutParams2);
            this.jAq = (int) (l.dip2px(getContext(), pendantData.left) * this.jAj);
            this.jAr = (int) (l.dip2px(getContext(), pendantData.top) * this.jAj);
            this.jAs = (int) (l.dip2px(getContext(), pendantData.right) * this.jAj);
            this.jAt = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jAj);
            this.mContentView.setPadding(this.jAq, this.jAr, this.jAs, this.jAt);
            this.apk = l.getDimens(getContext(), R.dimen.fontsize40) * this.jAj;
            String text = getText();
            this.jAv = (i2 - this.jAr) - this.jAt;
            this.jAw = (i - this.jAq) - this.jAs;
            this.jAy = this.jAx + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.apk);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(R.string.cover_hint), this.jAw);
                this.apk = this.jzX.getTextSize();
                ctG();
                tG();
            } else {
                if (aa.getTextLengthAllOne(text) > 20) {
                    text = aa.subStringWithAllOne(text, 20);
                    this.jzX.setText(text);
                    this.jzW.setText(text);
                }
                ES(text);
            }
        }
        this.jzW.setIncludeFontPadding(false);
        this.jzX.setIncludeFontPadding(false);
        this.jzW.setLineSpacing(this.jAx, 1.0f);
        this.jzX.setLineSpacing(this.jAx, 1.0f);
        this.jzU.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jzU.getLayoutParams();
        layoutParams3.height = (this.jAu * 2) + i2;
        layoutParams3.width = (this.jAu * 2) + i;
        this.jzU.setLayoutParams(layoutParams3);
        this.jAz = (this.jAu * 2) + i;
        ((FrameLayout.LayoutParams) this.jzV.getLayoutParams()).setMargins(this.jAu, this.jAu, this.jAu, this.jAu);
        this.jzU.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jAB == null) {
            ctH();
        }
        return this.jAB;
    }

    private void ctH() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jAB = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void ctI() {
        if (this.jAB != null && !this.jAB.isRecycled()) {
            this.jAB.recycle();
            this.jAB = null;
        }
    }

    public void rr(boolean z) {
        if (this.jAa != 0) {
            if (z) {
                ctI();
                this.jzU.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.jzU.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jAA.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jAA.clear();
        this.jAA = null;
        ctI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jAD;
        WeakReference<CoverPendantDragView> jAE;
        WeakReference<PendantData> jAF;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jAD = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jAE = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jAF = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ef(String str, String str2) {
            if (this.jAD != null && this.jAD.get() != null) {
                this.jAD.get().jyQ.setVisibility(8);
            }
            if (this.jAE != null && this.jAE.get() != null && this.jAF != null && this.jAF.get() != null) {
                this.jAE.get().a(str2, this.jAF.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void EH(String str) {
            if (this.jAD != null && this.jAD.get() != null) {
                this.jAD.get().jyQ.setVisibility(8);
            }
            if (this.jAE != null && this.jAE.get() != null) {
                l.showToast(this.jAE.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void csM() {
            if (this.jAD != null && this.jAD.get() != null) {
                this.jAD.get().jyQ.setVisibility(8);
            }
        }
    }
}
