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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class CoverPendantDragView extends FrameLayout {
    private float Bn;
    private float axv;
    float gpV;
    float gpW;
    private float jJx;
    private FrameLayout kwD;
    private RotateFrameLayout kwE;
    private TextView kwF;
    private EditText kwG;
    private ImageView kwH;
    private ImageView kwI;
    private int kwJ;
    private boolean kwK;
    private float kwL;
    private float kwM;
    private int kwN;
    private int kwO;
    private float kwP;
    private float kwQ;
    private float kwR;
    private float kwS;
    private b kwT;
    private float kwU;
    private float kwV;
    private float kwW;
    private float kwX;
    private boolean kwY;
    private int kwZ;
    private int kxa;
    private int kxb;
    private int kxc;
    private int kxd;
    private float kxe;
    private float kxf;
    private int kxg;
    private float kxh;
    private int kxi;
    private Map<String, Bitmap> kxj;
    private Bitmap kxk;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private float mLastX;
    private int mScreenWidth;
    private float mTouchSlop;
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
        this.kwJ = 0;
        this.kwS = 1.0f;
        this.jJx = 1.0f;
        this.kwY = true;
        this.kxj = new HashMap();
        this.startTime = 0L;
        this.gpV = 0.0f;
        this.gpW = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.axv = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kxg = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kwD = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kwD);
        this.kwD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kwJ == 4) {
                            CoverPendantDragView.this.cOM();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kwK && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.vS();
                        }
                        CoverPendantDragView.this.kwL = 0.0f;
                        CoverPendantDragView.this.kwM = 0.0f;
                        CoverPendantDragView.this.kwK = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.isTouchSlop(motionEvent)) {
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
                        CoverPendantDragView.this.kwL = 0.0f;
                        CoverPendantDragView.this.kwM = 0.0f;
                        return true;
                }
            }
        });
        this.kwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kwG.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kwI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kwM = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.isTouchSlop(motionEvent)) {
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
        this.kwG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kwJ != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kwF.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kwF.getText().length()) {
                        CoverPendantDragView.this.JQ(obj);
                    } else {
                        CoverPendantDragView.this.JP(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.JQ(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.kwF.setText(editable.toString());
            }
        });
        this.kwG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kwD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.Bn = this.mDownY;
        this.kwP = (this.kwD.getWidth() / 2) + this.kwD.getX();
        this.kwQ = (this.kwD.getHeight() / 2) + this.kwD.getY();
        this.kwF.setText(this.kwG.getText());
        this.kwF.setVisibility(0);
        this.kwG.setVisibility(8);
        setEditTextEnable(false);
        this.kwT.HidenSoftKeyPad(this.kwG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP(String str) {
        TextPaint paint = this.kwG.getPaint();
        float measureText = paint.measureText(str);
        while (this.kwG.getLineCount() == 1 && this.kwG.getTextSize() < this.axv * this.jJx && measureText < this.kxf * this.jJx) {
            setTextSize(0, this.kwG.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kwG.getTextSize() != this.axv * this.jJx) {
            setTextSize(0, this.axv * this.jJx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ(String str) {
        TextPaint paint = this.kwG.getPaint();
        float measureText = paint.measureText(str);
        while (this.kwG.getTextSize() > ((this.kxe * this.jJx) / 2.0f) - (this.kxh * this.jJx) && measureText > this.kxf * this.jJx) {
            setTextSize(0, this.kwG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kwG.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kwG.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ad.subStringWithEmoji(str, ad.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.kwT = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kwU = f;
        this.kwV = f2;
        this.kwW = f3;
        this.kwX = f4;
        if (this.kwU > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kwU, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kwV > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kwV);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kwW > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kwW) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kwX > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kwX) - this.mVideoHeight);
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
        float abs2 = Math.abs(this.Bn - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.kwP - rawX);
        float abs4 = Math.abs(this.kwQ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kwP - this.mLastX);
        float abs6 = Math.abs(this.kwQ - this.Bn);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cM(sqrt, (int) (sqrt / this.kwR));
        if (this.kwM != 0.0f) {
            this.kwD.setRotation(this.kwD.getRotation() - (this.kwM - I));
        }
        this.kwM = I;
        this.mLastX = rawX;
        this.Bn = rawY;
    }

    private void cM(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kwD.getLayoutParams();
        int width = this.kwD.getWidth() - i;
        int i3 = (int) (width / this.kwR);
        if (width < this.kwN) {
            width = this.kwN;
            i3 = (int) (width / this.kwR);
        }
        this.jJx = ((width * 1.0f) - (this.kxd * 2)) / (this.kxi - (this.kxd * 2));
        this.mContentView.setPadding((int) (this.kwZ * this.jJx), (int) (this.kxa * this.jJx), (int) (this.kxb * this.jJx), (int) (this.kxc * this.jJx));
        setTextSize(0, (this.kwG.getTextSize() * i3) / this.kwD.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kwD.setLayoutParams(layoutParams);
        float f = this.kwP - (layoutParams.width / 2);
        float f2 = this.kwQ - (layoutParams.height / 2);
        this.kwD.setX(f);
        this.kwD.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kwJ != 4) {
            float y = (this.kwD.getY() + rawY) - this.Bn;
            if (y < this.kwV) {
                y = this.kwV;
            } else if (y > (this.kwV + this.mVideoHeight) - this.kwD.getHeight()) {
                y = (this.kwV + this.mVideoHeight) - this.kwD.getHeight();
            }
            this.kwD.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kwK = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kwL != 0.0f) {
                    int i = (int) (this.kwL - J);
                    cM(i, (int) (i / this.kwR));
                }
                if (this.kwM != 0.0f) {
                    this.kwD.setRotation(this.kwD.getRotation() - (this.kwM - H));
                }
                this.kwM = H;
                this.kwL = J;
            } else if (!this.kwK && pointerCount == 1) {
                float y2 = (this.kwD.getY() + rawY) - this.Bn;
                if (y2 < this.kwV - (this.kwD.getHeight() / 2)) {
                    y2 = this.kwV - (this.kwD.getHeight() / 2);
                } else if (y2 > ((this.kwV + this.mVideoHeight) - this.kwD.getHeight()) + (this.kwD.getHeight() / 2)) {
                    y2 = ((this.kwV + this.mVideoHeight) - this.kwD.getHeight()) + (this.kwD.getHeight() / 2);
                }
                float x = (this.kwD.getX() + rawX) - this.mLastX;
                if (x < this.kwU - (this.kwD.getWidth() / 2)) {
                    x = this.kwU - (this.kwD.getWidth() / 2);
                } else if (x > ((this.kwU + this.mVideoWidth) - this.kwD.getWidth()) + (this.kwD.getWidth() / 2)) {
                    x = ((this.kwU + this.mVideoWidth) - this.kwD.getWidth()) + (this.kwD.getWidth() / 2);
                }
                this.kwD.setX(x);
                this.kwD.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.Bn = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kwG.getTextSize() != f) {
            this.kwG.setTextSize(i, f);
        }
        if (this.kwF.getTextSize() != f) {
            this.kwF.setTextSize(i, f);
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
        matrix.postRotate(this.kwD.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kwQ - motionEvent.getRawY(), this.kwP - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchSlop(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.mTouchSlop && Math.abs(motionEvent.getRawY() - this.mDownY) < this.mTouchSlop;
    }

    private void init() {
        this.kwE = (RotateFrameLayout) this.kwD.findViewById(R.id.content_container);
        this.kwF = (TextView) this.kwD.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kwD.findViewById(R.id.content_view);
        this.kwG = (EditText) this.kwD.findViewById(R.id.cover_edit);
        this.kwH = (ImageView) this.kwD.findViewById(R.id.cover_delete);
        this.kwI = (ImageView) this.kwD.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kwF.setText(this.kwG.getText());
        this.kwF.setVisibility(0);
        this.kwG.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kwF.getText())) {
            this.kwJ = 0;
            this.kwD.setVisibility(8);
        }
        if (this.kwJ == 4) {
            cOL();
        }
        this.kwT.HidenSoftKeyPad(this.kwG);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kwG.setFocusable(true);
            this.kwG.setFocusableInTouchMode(true);
            this.kwG.requestFocus();
            return;
        }
        this.kwG.setFocusable(false);
        this.kwG.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kwG.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    vS();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    vS();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    vS();
                    break;
                default:
                    hideSoftKeyPad();
                    String JO = com.baidu.tieba.video.editvideo.model.b.cOG().JO(pendantData.resource);
                    if (TextUtils.isEmpty(JO)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kvC.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cOG().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(JO, pendantData);
                        break;
                    }
                    break;
            }
            this.kwJ = pendantData.pendantType;
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
        cOL();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kwJ == 4 || this.kwJ == 0) {
            this.kwD.setX(this.kwU);
            this.kwD.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kwV);
            String obj = this.kwG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kwG.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kwF.setText(a2);
                    this.kwG.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cOL() {
        if (this.kwY) {
            this.kwY = false;
            this.kwH.setVisibility(8);
            this.kwI.setVisibility(8);
            this.kwE.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOM() {
        if (!this.kwY) {
            this.kwY = true;
            this.kwH.setVisibility(0);
            this.kwI.setVisibility(0);
            this.kwE.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kxj != null) {
            Bitmap bitmap = this.kxj.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kxj.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cOL();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kwS = 1.0f;
                this.jJx = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kwS = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kwN = (this.kxd * 2) + width;
                this.kwO = (this.kxd * 2) + height;
                this.kwR = (this.kwN * 1.0f) / this.kwO;
                this.kwD.setX((((this.mVideoWidth - i2) - (this.kxd * 2)) / 2) + this.kwU);
                this.kwD.setY((((this.mVideoHeight - i) - (this.kxd * 2)) / 2) + this.kwV);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gpV = motionEvent.getRawX();
                this.gpW = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gpV);
                float abs2 = Math.abs(rawY - this.gpW);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kwF == null || this.kwF.getText() == null) {
            return null;
        }
        return this.kwF.getText().toString();
    }

    public void vS() {
        this.kwF.setText(this.kwG.getText());
        this.kwF.setVisibility(8);
        this.kwG.setVisibility(0);
        setEditTextEnable(true);
        this.kwT.ShowSoftKeyPad(this.kwG);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kwG.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kwF.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kxd = 0;
            this.kwG.setMaxLines(1);
            this.kwF.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kwF.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kwG.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kwG.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kwF.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kxd = l.getDimens(getContext(), R.dimen.ds40);
            this.kwG.setMaxLines(2);
            this.kwF.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kwF.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kwG.setLayoutParams(layoutParams2);
            this.kwZ = (int) (l.dip2px(getContext(), pendantData.left) * this.kwS);
            this.kxa = (int) (l.dip2px(getContext(), pendantData.top) * this.kwS);
            this.kxb = (int) (l.dip2px(getContext(), pendantData.right) * this.kwS);
            this.kxc = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kwS);
            this.mContentView.setPadding(this.kwZ, this.kxa, this.kxb, this.kxc);
            this.axv = l.getDimens(getContext(), R.dimen.fontsize40) * this.kwS;
            String text = getText();
            this.kxe = (i2 - this.kxa) - this.kxc;
            this.kxf = (i - this.kwZ) - this.kxb;
            this.kxh = this.kxg + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.axv);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kxf);
                this.axv = this.kwG.getTextSize();
                cOM();
                vS();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kwG.setText(text);
                    this.kwF.setText(text);
                }
                JQ(text);
            }
        }
        this.kwF.setIncludeFontPadding(false);
        this.kwG.setIncludeFontPadding(false);
        this.kwF.setLineSpacing(this.kxg, 1.0f);
        this.kwG.setLineSpacing(this.kxg, 1.0f);
        this.kwD.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kwD.getLayoutParams();
        layoutParams3.height = (this.kxd * 2) + i2;
        layoutParams3.width = (this.kxd * 2) + i;
        this.kwD.setLayoutParams(layoutParams3);
        this.kxi = (this.kxd * 2) + i;
        ((FrameLayout.LayoutParams) this.kwE.getLayoutParams()).setMargins(this.kxd, this.kxd, this.kxd, this.kxd);
        this.kwD.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kxk == null) {
            cON();
        }
        return this.kxk;
    }

    private void cON() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kxk = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cOO() {
        if (this.kxk != null && !this.kxk.isRecycled()) {
            this.kxk.recycle();
            this.kxk = null;
        }
    }

    public void tk(boolean z) {
        if (this.kwJ != 0) {
            if (z) {
                cOO();
                this.kwD.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kwD.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kxj.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kxj.clear();
        this.kxj = null;
        cOO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> kxm;
        WeakReference<CoverPendantDragView> kxn;
        WeakReference<PendantData> kxo;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kxm = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kxn = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kxo = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eA(String str, String str2) {
            if (this.kxm != null && this.kxm.get() != null) {
                this.kxm.get().kvC.setVisibility(8);
            }
            if (this.kxn != null && this.kxn.get() != null && this.kxo != null && this.kxo.get() != null) {
                this.kxn.get().a(str2, this.kxo.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JG(String str) {
            if (this.kxm != null && this.kxm.get() != null) {
                this.kxm.get().kvC.setVisibility(8);
            }
            if (this.kxn != null && this.kxn.get() != null) {
                l.showToast(this.kxn.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cNT() {
            if (this.kxm != null && this.kxm.get() != null) {
                this.kxm.get().kvC.setVisibility(8);
            }
        }
    }
}
