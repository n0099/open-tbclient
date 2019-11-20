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
    private float aoS;
    private float dak;
    private float fhc;
    float fyp;
    float fyq;
    private float iLB;
    private int jzA;
    private int jzB;
    private int jzC;
    private int jzD;
    private float jzE;
    private float jzF;
    private int jzG;
    private float jzH;
    private int jzI;
    private Map<String, Bitmap> jzJ;
    private Bitmap jzK;
    private FrameLayout jzd;
    private RotateFrameLayout jze;
    private TextView jzf;
    private EditText jzg;
    private ImageView jzh;
    private ImageView jzi;
    private int jzj;
    private boolean jzk;
    private float jzl;
    private float jzm;
    private int jzn;
    private int jzo;
    private float jzp;
    private float jzq;
    private float jzr;
    private float jzs;
    private b jzt;
    private float jzu;
    private float jzv;
    private float jzw;
    private float jzx;
    private boolean jzy;
    private int jzz;
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
        this.jzj = 0;
        this.jzs = 1.0f;
        this.iLB = 1.0f;
        this.jzy = true;
        this.jzJ = new HashMap();
        this.startTime = 0L;
        this.fyp = 0.0f;
        this.fyq = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aoS = l.getDimens(getContext(), R.dimen.fontsize40);
        this.jzG = l.getDimens(getContext(), R.dimen.ds2);
        this.fhc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jzd = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jzd);
        this.jzd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.jzj == 4) {
                            CoverPendantDragView.this.ctE();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.dak);
                        if (!CoverPendantDragView.this.jzk && abs < CoverPendantDragView.this.fhc && abs2 < CoverPendantDragView.this.fhc && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.tH();
                        }
                        CoverPendantDragView.this.jzl = 0.0f;
                        CoverPendantDragView.this.jzm = 0.0f;
                        CoverPendantDragView.this.jzk = false;
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
                        CoverPendantDragView.this.jzl = 0.0f;
                        CoverPendantDragView.this.jzm = 0.0f;
                        return true;
                }
            }
        });
        this.jzh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jzg.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.jzi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jzm = 0.0f;
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
        this.jzg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jzj != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jzf.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (aa.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jzf.getText().length()) {
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
                CoverPendantDragView.this.jzf.setText(editable.toString());
            }
        });
        this.jzg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jzd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.dak = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.dak;
        this.jzp = (this.jzd.getWidth() / 2) + this.jzd.getX();
        this.jzq = (this.jzd.getHeight() / 2) + this.jzd.getY();
        this.jzf.setText(this.jzg.getText());
        this.jzf.setVisibility(0);
        this.jzg.setVisibility(8);
        setEditTextEnable(false);
        this.jzt.HidenSoftKeyPad(this.jzg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ER(String str) {
        TextPaint paint = this.jzg.getPaint();
        float measureText = paint.measureText(str);
        while (this.jzg.getLineCount() == 1 && this.jzg.getTextSize() < this.aoS * this.iLB && measureText < this.jzF * this.iLB) {
            setTextSize(0, this.jzg.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (aa.getTextLengthAllOne(str) <= aa.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.jzg.getTextSize() != this.aoS * this.iLB) {
            setTextSize(0, this.aoS * this.iLB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES(String str) {
        TextPaint paint = this.jzg.getPaint();
        float measureText = paint.measureText(str);
        while (this.jzg.getTextSize() > ((this.jzE * this.iLB) / 2.0f) - (this.jzH * this.iLB) && measureText > this.jzF * this.iLB) {
            setTextSize(0, this.jzg.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void d(String str, float f) {
        TextPaint paint = this.jzg.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jzg.getTextSize() - 1.0f);
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
        this.jzt = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jzu = f;
        this.jzv = f2;
        this.jzw = f3;
        this.jzx = f4;
        if (this.jzu > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jzu, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jzv > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jzv);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jzw > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jzw) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jzx > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jzx) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.jzp - rawX);
        float abs4 = Math.abs(this.jzq - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jzp - this.mLastX);
        float abs6 = Math.abs(this.jzq - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cv(sqrt, (int) (sqrt / this.jzr));
        if (this.jzm != 0.0f) {
            this.jzd.setRotation(this.jzd.getRotation() - (this.jzm - I));
        }
        this.jzm = I;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void cv(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jzd.getLayoutParams();
        int width = this.jzd.getWidth() - i;
        int i3 = (int) (width / this.jzr);
        if (width < this.jzn) {
            width = this.jzn;
            i3 = (int) (width / this.jzr);
        }
        this.iLB = ((width * 1.0f) - (this.jzD * 2)) / (this.jzI - (this.jzD * 2));
        this.mContentView.setPadding((int) (this.jzz * this.iLB), (int) (this.jzA * this.iLB), (int) (this.jzB * this.iLB), (int) (this.jzC * this.iLB));
        setTextSize(0, (this.jzg.getTextSize() * i3) / this.jzd.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jzd.setLayoutParams(layoutParams);
        float f = this.jzp - (layoutParams.width / 2);
        float f2 = this.jzq - (layoutParams.height / 2);
        this.jzd.setX(f);
        this.jzd.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jzj != 4) {
            float y = (this.jzd.getY() + rawY) - this.mLastY;
            if (y < this.jzv) {
                y = this.jzv;
            } else if (y > (this.jzv + this.mVideoHeight) - this.jzd.getHeight()) {
                y = (this.jzv + this.mVideoHeight) - this.jzd.getHeight();
            }
            this.jzd.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jzk = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.jzl != 0.0f) {
                    int i = (int) (this.jzl - J);
                    cv(i, (int) (i / this.jzr));
                }
                if (this.jzm != 0.0f) {
                    this.jzd.setRotation(this.jzd.getRotation() - (this.jzm - H));
                }
                this.jzm = H;
                this.jzl = J;
            } else if (!this.jzk && pointerCount == 1) {
                float y2 = (this.jzd.getY() + rawY) - this.mLastY;
                if (y2 < this.jzv - (this.jzd.getHeight() / 2)) {
                    y2 = this.jzv - (this.jzd.getHeight() / 2);
                } else if (y2 > ((this.jzv + this.mVideoHeight) - this.jzd.getHeight()) + (this.jzd.getHeight() / 2)) {
                    y2 = ((this.jzv + this.mVideoHeight) - this.jzd.getHeight()) + (this.jzd.getHeight() / 2);
                }
                float x = (this.jzd.getX() + rawX) - this.mLastX;
                if (x < this.jzu - (this.jzd.getWidth() / 2)) {
                    x = this.jzu - (this.jzd.getWidth() / 2);
                } else if (x > ((this.jzu + this.mVideoWidth) - this.jzd.getWidth()) + (this.jzd.getWidth() / 2)) {
                    x = ((this.jzu + this.mVideoWidth) - this.jzd.getWidth()) + (this.jzd.getWidth() / 2);
                }
                this.jzd.setX(x);
                this.jzd.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jzg.getTextSize() != f) {
            this.jzg.setTextSize(i, f);
        }
        if (this.jzf.getTextSize() != f) {
            this.jzf.setTextSize(i, f);
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
        matrix.postRotate(this.jzd.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jzq - motionEvent.getRawY(), this.jzp - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fhc && Math.abs(motionEvent.getRawY() - this.dak) < this.fhc;
    }

    private void init() {
        this.jze = (RotateFrameLayout) this.jzd.findViewById(R.id.content_container);
        this.jzf = (TextView) this.jzd.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jzd.findViewById(R.id.content_view);
        this.jzg = (EditText) this.jzd.findViewById(R.id.cover_edit);
        this.jzh = (ImageView) this.jzd.findViewById(R.id.cover_delete);
        this.jzi = (ImageView) this.jzd.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.jzf.setText(this.jzg.getText());
        this.jzf.setVisibility(0);
        this.jzg.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jzf.getText())) {
            this.jzj = 0;
            this.jzd.setVisibility(8);
        }
        if (this.jzj == 4) {
            ctD();
        }
        this.jzt.HidenSoftKeyPad(this.jzg);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jzg.setFocusable(true);
            this.jzg.setFocusableInTouchMode(true);
            this.jzg.requestFocus();
            return;
        }
        this.jzg.setFocusable(false);
        this.jzg.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jzg.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    tH();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    tH();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    tH();
                    break;
                default:
                    hideSoftKeyPad();
                    String EQ = com.baidu.tieba.video.editvideo.model.b.cty().EQ(pendantData.resource);
                    if (TextUtils.isEmpty(EQ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jxZ.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cty().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(EQ, pendantData);
                        break;
                    }
                    break;
            }
            this.jzj = pendantData.pendantType;
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
        ctD();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jzj == 4 || this.jzj == 0) {
            this.jzd.setX(this.jzu);
            this.jzd.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.jzv);
            String obj = this.jzg.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jzg.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jzf.setText(a2);
                    this.jzg.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void ctD() {
        if (this.jzy) {
            this.jzy = false;
            this.jzh.setVisibility(8);
            this.jzi.setVisibility(8);
            this.jze.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctE() {
        if (!this.jzy) {
            this.jzy = true;
            this.jzh.setVisibility(0);
            this.jzi.setVisibility(0);
            this.jze.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jzJ != null) {
            Bitmap bitmap = this.jzJ.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jzJ.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                ctD();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jzs = 1.0f;
                this.iLB = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jzs = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jzn = (this.jzD * 2) + width;
                this.jzo = (this.jzD * 2) + height;
                this.jzr = (this.jzn * 1.0f) / this.jzo;
                this.jzd.setX((((this.mVideoWidth - i2) - (this.jzD * 2)) / 2) + this.jzu);
                this.jzd.setY((((this.mVideoHeight - i) - (this.jzD * 2)) / 2) + this.jzv);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fyp = motionEvent.getRawX();
                this.fyq = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fyp);
                float abs2 = Math.abs(rawY - this.fyq);
                if (motionEvent.getPointerCount() <= 1 && abs < this.fhc && abs2 < this.fhc && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jzf == null || this.jzf.getText() == null) {
            return null;
        }
        return this.jzf.getText().toString();
    }

    public void tH() {
        this.jzf.setText(this.jzg.getText());
        this.jzf.setVisibility(8);
        this.jzg.setVisibility(0);
        setEditTextEnable(true);
        this.jzt.ShowSoftKeyPad(this.jzg);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jzg.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jzf.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jzD = 0;
            this.jzg.setMaxLines(1);
            this.jzf.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jzf.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jzg.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.jzg.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jzf.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jzD = l.getDimens(getContext(), R.dimen.ds40);
            this.jzg.setMaxLines(2);
            this.jzf.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jzf.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jzg.setLayoutParams(layoutParams2);
            this.jzz = (int) (l.dip2px(getContext(), pendantData.left) * this.jzs);
            this.jzA = (int) (l.dip2px(getContext(), pendantData.top) * this.jzs);
            this.jzB = (int) (l.dip2px(getContext(), pendantData.right) * this.jzs);
            this.jzC = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jzs);
            this.mContentView.setPadding(this.jzz, this.jzA, this.jzB, this.jzC);
            this.aoS = l.getDimens(getContext(), R.dimen.fontsize40) * this.jzs;
            String text = getText();
            this.jzE = (i2 - this.jzA) - this.jzC;
            this.jzF = (i - this.jzz) - this.jzB;
            this.jzH = this.jzG + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aoS);
            if (TextUtils.isEmpty(text)) {
                d(getContext().getString(R.string.cover_hint), this.jzF);
                this.aoS = this.jzg.getTextSize();
                ctE();
                tH();
            } else {
                if (aa.getTextLengthAllOne(text) > 20) {
                    text = aa.subStringWithAllOne(text, 20);
                    this.jzg.setText(text);
                    this.jzf.setText(text);
                }
                ES(text);
            }
        }
        this.jzf.setIncludeFontPadding(false);
        this.jzg.setIncludeFontPadding(false);
        this.jzf.setLineSpacing(this.jzG, 1.0f);
        this.jzg.setLineSpacing(this.jzG, 1.0f);
        this.jzd.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jzd.getLayoutParams();
        layoutParams3.height = (this.jzD * 2) + i2;
        layoutParams3.width = (this.jzD * 2) + i;
        this.jzd.setLayoutParams(layoutParams3);
        this.jzI = (this.jzD * 2) + i;
        ((FrameLayout.LayoutParams) this.jze.getLayoutParams()).setMargins(this.jzD, this.jzD, this.jzD, this.jzD);
        this.jzd.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jzK == null) {
            ctF();
        }
        return this.jzK;
    }

    private void ctF() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jzK = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void ctG() {
        if (this.jzK != null && !this.jzK.isRecycled()) {
            this.jzK.recycle();
            this.jzK = null;
        }
    }

    public void rr(boolean z) {
        if (this.jzj != 0) {
            if (z) {
                ctG();
                this.jzd.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.jzd.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jzJ.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jzJ.clear();
        this.jzJ = null;
        ctG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jzM;
        WeakReference<CoverPendantDragView> jzN;
        WeakReference<PendantData> jzO;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jzM = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jzN = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jzO = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void ef(String str, String str2) {
            if (this.jzM != null && this.jzM.get() != null) {
                this.jzM.get().jxZ.setVisibility(8);
            }
            if (this.jzN != null && this.jzN.get() != null && this.jzO != null && this.jzO.get() != null) {
                this.jzN.get().a(str2, this.jzO.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void EH(String str) {
            if (this.jzM != null && this.jzM.get() != null) {
                this.jzM.get().jxZ.setVisibility(8);
            }
            if (this.jzN != null && this.jzN.get() != null) {
                l.showToast(this.jzN.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void csK() {
            if (this.jzM != null && this.jzM.get() != null) {
                this.jzM.get().jxZ.setVisibility(8);
            }
        }
    }
}
