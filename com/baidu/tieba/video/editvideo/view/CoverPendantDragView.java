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
/* loaded from: classes10.dex */
public class CoverPendantDragView extends FrameLayout {
    private float BF;
    private float aBN;
    float gsl;
    float gsm;
    private float jKH;
    private FrameLayout kxM;
    private RotateFrameLayout kxN;
    private TextView kxO;
    private EditText kxP;
    private ImageView kxQ;
    private ImageView kxR;
    private int kxS;
    private boolean kxT;
    private float kxU;
    private float kxV;
    private int kxW;
    private int kxX;
    private float kxY;
    private float kxZ;
    private float kya;
    private float kyb;
    private b kyc;
    private float kyd;
    private float kye;
    private float kyf;
    private float kyg;
    private boolean kyh;
    private int kyi;
    private int kyj;
    private int kyk;
    private int kyl;
    private int kym;
    private float kyn;
    private float kyo;
    private int kyp;
    private float kyq;
    private int kyr;
    private Map<String, Bitmap> kys;
    private Bitmap kyt;
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
        this.kxS = 0;
        this.kyb = 1.0f;
        this.jKH = 1.0f;
        this.kyh = true;
        this.kys = new HashMap();
        this.startTime = 0L;
        this.gsl = 0.0f;
        this.gsm = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aBN = l.getDimens(getContext(), R.dimen.fontsize40);
        this.kyp = l.getDimens(getContext(), R.dimen.ds2);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kxM = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.kxM);
        this.kxM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.kxS == 4) {
                            CoverPendantDragView.this.cQi();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.kxT && abs < CoverPendantDragView.this.mTouchSlop && abs2 < CoverPendantDragView.this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.xR();
                        }
                        CoverPendantDragView.this.kxU = 0.0f;
                        CoverPendantDragView.this.kxV = 0.0f;
                        CoverPendantDragView.this.kxT = false;
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
                        CoverPendantDragView.this.kxU = 0.0f;
                        CoverPendantDragView.this.kxV = 0.0f;
                        return true;
                }
            }
        });
        this.kxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.kxP.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.kxR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.kxV = 0.0f;
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
        this.kxP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.kxS != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.kxO.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.kxO.getText().length()) {
                        CoverPendantDragView.this.Ke(obj);
                    } else {
                        CoverPendantDragView.this.Kd(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Ke(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.kxO.setText(editable.toString());
            }
        });
        this.kxP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.kxM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.BF = this.mDownY;
        this.kxY = (this.kxM.getWidth() / 2) + this.kxM.getX();
        this.kxZ = (this.kxM.getHeight() / 2) + this.kxM.getY();
        this.kxO.setText(this.kxP.getText());
        this.kxO.setVisibility(0);
        this.kxP.setVisibility(8);
        setEditTextEnable(false);
        this.kyc.HidenSoftKeyPad(this.kxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd(String str) {
        TextPaint paint = this.kxP.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxP.getLineCount() == 1 && this.kxP.getTextSize() < this.aBN * this.jKH && measureText < this.kyo * this.jKH) {
            setTextSize(0, this.kxP.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.kxP.getTextSize() != this.aBN * this.jKH) {
            setTextSize(0, this.aBN * this.jKH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke(String str) {
        TextPaint paint = this.kxP.getPaint();
        float measureText = paint.measureText(str);
        while (this.kxP.getTextSize() > ((this.kyn * this.jKH) / 2.0f) - (this.kyq * this.jKH) && measureText > this.kyo * this.jKH) {
            setTextSize(0, this.kxP.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.kxP.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.kxP.getTextSize() - 1.0f);
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
        this.kyc = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.kyd = f;
        this.kye = f2;
        this.kyf = f3;
        this.kyg = f4;
        if (this.kyd > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.kyd, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.kye > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.kye);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.kyf > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.kyf) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.kyg > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.kyg) - this.mVideoHeight);
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
        float abs2 = Math.abs(this.BF - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.kxY - rawX);
        float abs4 = Math.abs(this.kxZ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.kxY - this.mLastX);
        float abs6 = Math.abs(this.kxZ - this.BF);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cP(sqrt, (int) (sqrt / this.kya));
        if (this.kxV != 0.0f) {
            this.kxM.setRotation(this.kxM.getRotation() - (this.kxV - I));
        }
        this.kxV = I;
        this.mLastX = rawX;
        this.BF = rawY;
    }

    private void cP(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxM.getLayoutParams();
        int width = this.kxM.getWidth() - i;
        int i3 = (int) (width / this.kya);
        if (width < this.kxW) {
            width = this.kxW;
            i3 = (int) (width / this.kya);
        }
        this.jKH = ((width * 1.0f) - (this.kym * 2)) / (this.kyr - (this.kym * 2));
        this.mContentView.setPadding((int) (this.kyi * this.jKH), (int) (this.kyj * this.jKH), (int) (this.kyk * this.jKH), (int) (this.kyl * this.jKH));
        setTextSize(0, (this.kxP.getTextSize() * i3) / this.kxM.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.kxM.setLayoutParams(layoutParams);
        float f = this.kxY - (layoutParams.width / 2);
        float f2 = this.kxZ - (layoutParams.height / 2);
        this.kxM.setX(f);
        this.kxM.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.kxS != 4) {
            float y = (this.kxM.getY() + rawY) - this.BF;
            if (y < this.kye) {
                y = this.kye;
            } else if (y > (this.kye + this.mVideoHeight) - this.kxM.getHeight()) {
                y = (this.kye + this.mVideoHeight) - this.kxM.getHeight();
            }
            this.kxM.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.kxT = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.kxU != 0.0f) {
                    int i = (int) (this.kxU - J);
                    cP(i, (int) (i / this.kya));
                }
                if (this.kxV != 0.0f) {
                    this.kxM.setRotation(this.kxM.getRotation() - (this.kxV - H));
                }
                this.kxV = H;
                this.kxU = J;
            } else if (!this.kxT && pointerCount == 1) {
                float y2 = (this.kxM.getY() + rawY) - this.BF;
                if (y2 < this.kye - (this.kxM.getHeight() / 2)) {
                    y2 = this.kye - (this.kxM.getHeight() / 2);
                } else if (y2 > ((this.kye + this.mVideoHeight) - this.kxM.getHeight()) + (this.kxM.getHeight() / 2)) {
                    y2 = ((this.kye + this.mVideoHeight) - this.kxM.getHeight()) + (this.kxM.getHeight() / 2);
                }
                float x = (this.kxM.getX() + rawX) - this.mLastX;
                if (x < this.kyd - (this.kxM.getWidth() / 2)) {
                    x = this.kyd - (this.kxM.getWidth() / 2);
                } else if (x > ((this.kyd + this.mVideoWidth) - this.kxM.getWidth()) + (this.kxM.getWidth() / 2)) {
                    x = ((this.kyd + this.mVideoWidth) - this.kxM.getWidth()) + (this.kxM.getWidth() / 2);
                }
                this.kxM.setX(x);
                this.kxM.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.BF = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.kxP.getTextSize() != f) {
            this.kxP.setTextSize(i, f);
        }
        if (this.kxO.getTextSize() != f) {
            this.kxO.setTextSize(i, f);
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
        matrix.postRotate(this.kxM.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.kxZ - motionEvent.getRawY(), this.kxY - motionEvent.getRawX()));
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
        this.kxN = (RotateFrameLayout) this.kxM.findViewById(R.id.content_container);
        this.kxO = (TextView) this.kxM.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.kxM.findViewById(R.id.content_view);
        this.kxP = (EditText) this.kxM.findViewById(R.id.cover_edit);
        this.kxQ = (ImageView) this.kxM.findViewById(R.id.cover_delete);
        this.kxR = (ImageView) this.kxM.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.kxO.setText(this.kxP.getText());
        this.kxO.setVisibility(0);
        this.kxP.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.kxO.getText())) {
            this.kxS = 0;
            this.kxM.setVisibility(8);
        }
        if (this.kxS == 4) {
            cQh();
        }
        this.kyc.HidenSoftKeyPad(this.kxP);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.kxP.setFocusable(true);
            this.kxP.setFocusableInTouchMode(true);
            this.kxP.requestFocus();
            return;
        }
        this.kxP.setFocusable(false);
        this.kxP.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.kxP.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    xR();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    xR();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    xR();
                    break;
                default:
                    hideSoftKeyPad();
                    String Kc = com.baidu.tieba.video.editvideo.model.b.cQc().Kc(pendantData.resource);
                    if (TextUtils.isEmpty(Kc)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.kwN.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.cQc().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Kc, pendantData);
                        break;
                    }
                    break;
            }
            this.kxS = pendantData.pendantType;
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
        cQh();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.kxS == 4 || this.kxS == 0) {
            this.kxM.setX(this.kyd);
            this.kxM.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.kye);
            String obj = this.kxP.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.kxP.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.kxO.setText(a2);
                    this.kxP.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void cQh() {
        if (this.kyh) {
            this.kyh = false;
            this.kxQ.setVisibility(8);
            this.kxR.setVisibility(8);
            this.kxN.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQi() {
        if (!this.kyh) {
            this.kyh = true;
            this.kxQ.setVisibility(0);
            this.kxR.setVisibility(0);
            this.kxN.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.kys != null) {
            Bitmap bitmap = this.kys.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.kys.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                cQh();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.kyb = 1.0f;
                this.jKH = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.kyb = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.kxW = (this.kym * 2) + width;
                this.kxX = (this.kym * 2) + height;
                this.kya = (this.kxW * 1.0f) / this.kxX;
                this.kxM.setX((((this.mVideoWidth - i2) - (this.kym * 2)) / 2) + this.kyd);
                this.kxM.setY((((this.mVideoHeight - i) - (this.kym * 2)) / 2) + this.kye);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.gsl = motionEvent.getRawX();
                this.gsm = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.gsl);
                float abs2 = Math.abs(rawY - this.gsm);
                if (motionEvent.getPointerCount() <= 1 && abs < this.mTouchSlop && abs2 < this.mTouchSlop && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.kxO == null || this.kxO.getText() == null) {
            return null;
        }
        return this.kxO.getText().toString();
    }

    public void xR() {
        this.kxO.setText(this.kxP.getText());
        this.kxO.setVisibility(8);
        this.kxP.setVisibility(0);
        setEditTextEnable(true);
        this.kyc.ShowSoftKeyPad(this.kxP);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.kxP.setTextAppearance(getContext(), R.style.cover_text_style);
            this.kxO.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.kym = 0;
            this.kxP.setMaxLines(1);
            this.kxO.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kxO.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.kxP.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.kxP.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kxO.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.kym = l.getDimens(getContext(), R.dimen.ds40);
            this.kxP.setMaxLines(2);
            this.kxO.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.kxO.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.kxP.setLayoutParams(layoutParams2);
            this.kyi = (int) (l.dip2px(getContext(), pendantData.left) * this.kyb);
            this.kyj = (int) (l.dip2px(getContext(), pendantData.f1027top) * this.kyb);
            this.kyk = (int) (l.dip2px(getContext(), pendantData.right) * this.kyb);
            this.kyl = (int) (l.dip2px(getContext(), pendantData.bottom) * this.kyb);
            this.mContentView.setPadding(this.kyi, this.kyj, this.kyk, this.kyl);
            this.aBN = l.getDimens(getContext(), R.dimen.fontsize40) * this.kyb;
            String text = getText();
            this.kyn = (i2 - this.kyj) - this.kyl;
            this.kyo = (i - this.kyi) - this.kyk;
            this.kyq = this.kyp + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aBN);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.kyo);
                this.aBN = this.kxP.getTextSize();
                cQi();
                xR();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.kxP.setText(text);
                    this.kxO.setText(text);
                }
                Ke(text);
            }
        }
        this.kxO.setIncludeFontPadding(false);
        this.kxP.setIncludeFontPadding(false);
        this.kxO.setLineSpacing(this.kyp, 1.0f);
        this.kxP.setLineSpacing(this.kyp, 1.0f);
        this.kxM.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.kxM.getLayoutParams();
        layoutParams3.height = (this.kym * 2) + i2;
        layoutParams3.width = (this.kym * 2) + i;
        this.kxM.setLayoutParams(layoutParams3);
        this.kyr = (this.kym * 2) + i;
        ((FrameLayout.LayoutParams) this.kxN.getLayoutParams()).setMargins(this.kym, this.kym, this.kym, this.kym);
        this.kxM.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.kyt == null) {
            cQj();
        }
        return this.kyt;
    }

    private void cQj() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.kyt = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void cQk() {
        if (this.kyt != null && !this.kyt.isRecycled()) {
            this.kyt.recycle();
            this.kyt = null;
        }
    }

    public void to(boolean z) {
        if (this.kxS != 0) {
            if (z) {
                cQk();
                this.kxM.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.kxM.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.kys.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.kys.clear();
        this.kys = null;
        cQk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> kyv;
        WeakReference<CoverPendantDragView> kyw;
        WeakReference<PendantData> kyx;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.kyv = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.kyw = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.kyx = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eJ(String str, String str2) {
            if (this.kyv != null && this.kyv.get() != null) {
                this.kyv.get().kwN.setVisibility(8);
            }
            if (this.kyw != null && this.kyw.get() != null && this.kyx != null && this.kyx.get() != null) {
                this.kyw.get().a(str2, this.kyx.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void JU(String str) {
            if (this.kyv != null && this.kyv.get() != null) {
                this.kyv.get().kwN.setVisibility(8);
            }
            if (this.kyw != null && this.kyw.get() != null) {
                l.showToast(this.kyw.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cPr() {
            if (this.kyv != null && this.kyv.get() != null) {
                this.kyv.get().kwN.setVisibility(8);
            }
        }
    }
}
