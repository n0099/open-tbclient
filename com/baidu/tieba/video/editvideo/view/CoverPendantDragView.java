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
    private float UY;
    private float UZ;
    private float aVI;
    private float gKV;
    private float kvz;
    private FrameLayout ljI;
    private RotateFrameLayout ljJ;
    private TextView ljK;
    private EditText ljL;
    private ImageView ljM;
    private ImageView ljN;
    private int ljO;
    private boolean ljP;
    private float ljQ;
    private float ljR;
    private int ljS;
    private int ljT;
    private float ljU;
    private float ljV;
    private float ljW;
    private float ljX;
    private b ljY;
    private float ljZ;
    private float lka;
    private float lkb;
    private float lkc;
    private boolean lkd;
    private int lke;
    private int lkf;
    private int lkg;
    private int lkh;
    private int lki;
    private float lkj;
    private float lkk;
    private int lkl;
    private float lkm;
    private int lkn;
    private Map<String, Bitmap> lko;
    private Bitmap lkp;
    float lkq;
    float lkr;
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
        this.ljO = 0;
        this.ljX = 1.0f;
        this.kvz = 1.0f;
        this.lkd = true;
        this.lko = new HashMap();
        this.startTime = 0L;
        this.lkq = 0.0f;
        this.lkr = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aVI = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lkl = l.getDimens(getContext(), R.dimen.ds2);
        this.gKV = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ljI = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.ljI);
        this.ljI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.ljO == 4) {
                            CoverPendantDragView.this.dbz();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.ljP && abs < CoverPendantDragView.this.gKV && abs2 < CoverPendantDragView.this.gKV && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.CO();
                        }
                        CoverPendantDragView.this.ljQ = 0.0f;
                        CoverPendantDragView.this.ljR = 0.0f;
                        CoverPendantDragView.this.ljP = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.D(motionEvent)) {
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
                        CoverPendantDragView.this.ljQ = 0.0f;
                        CoverPendantDragView.this.ljR = 0.0f;
                        return true;
                }
            }
        });
        this.ljM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.ljL.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.ljN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.ljR = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.D(motionEvent)) {
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
        this.ljL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.ljO != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.ljK.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.ljK.getText().length()) {
                        CoverPendantDragView.this.LO(obj);
                    } else {
                        CoverPendantDragView.this.LN(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.LO(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.ljK.setText(editable.toString());
            }
        });
        this.ljL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.ljI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.UY = this.mDownX;
        this.UZ = this.mDownY;
        this.ljU = (this.ljI.getWidth() / 2) + this.ljI.getX();
        this.ljV = (this.ljI.getHeight() / 2) + this.ljI.getY();
        this.ljK.setText(this.ljL.getText());
        this.ljK.setVisibility(0);
        this.ljL.setVisibility(8);
        setEditTextEnable(false);
        this.ljY.HidenSoftKeyPad(this.ljL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LN(String str) {
        TextPaint paint = this.ljL.getPaint();
        float measureText = paint.measureText(str);
        while (this.ljL.getLineCount() == 1 && this.ljL.getTextSize() < this.aVI * this.kvz && measureText < this.lkk * this.kvz) {
            setTextSize(0, this.ljL.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.ljL.getTextSize() != this.aVI * this.kvz) {
            setTextSize(0, this.aVI * this.kvz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LO(String str) {
        TextPaint paint = this.ljL.getPaint();
        float measureText = paint.measureText(str);
        while (this.ljL.getTextSize() > ((this.lkj * this.kvz) / 2.0f) - (this.lkm * this.kvz) && measureText > this.lkk * this.kvz) {
            setTextSize(0, this.ljL.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.ljL.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.ljL.getTextSize() - 1.0f);
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
        this.ljY = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.ljZ = f;
        this.lka = f2;
        this.lkb = f3;
        this.lkc = f4;
        if (this.ljZ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.ljZ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lka > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lka);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lkb > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lkb) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lkc > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lkc) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.UY - rawX);
        float abs2 = Math.abs(this.UZ - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.ljU - rawX);
        float abs4 = Math.abs(this.ljV - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.ljU - this.UY);
        float abs6 = Math.abs(this.ljV - this.UZ);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cV(sqrt, (int) (sqrt / this.ljW));
        if (this.ljR != 0.0f) {
            this.ljI.setRotation(this.ljI.getRotation() - (this.ljR - I));
        }
        this.ljR = I;
        this.UY = rawX;
        this.UZ = rawY;
    }

    private void cV(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ljI.getLayoutParams();
        int width = this.ljI.getWidth() - i;
        int i3 = (int) (width / this.ljW);
        if (width < this.ljS) {
            width = this.ljS;
            i3 = (int) (width / this.ljW);
        }
        this.kvz = ((width * 1.0f) - (this.lki * 2)) / (this.lkn - (this.lki * 2));
        this.mContentView.setPadding((int) (this.lke * this.kvz), (int) (this.lkf * this.kvz), (int) (this.lkg * this.kvz), (int) (this.lkh * this.kvz));
        setTextSize(0, (this.ljL.getTextSize() * i3) / this.ljI.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.ljI.setLayoutParams(layoutParams);
        float f = this.ljU - (layoutParams.width / 2);
        float f2 = this.ljV - (layoutParams.height / 2);
        this.ljI.setX(f);
        this.ljI.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.ljO != 4) {
            float y = (this.ljI.getY() + rawY) - this.UZ;
            if (y < this.lka) {
                y = this.lka;
            } else if (y > (this.lka + this.mVideoHeight) - this.ljI.getHeight()) {
                y = (this.lka + this.mVideoHeight) - this.ljI.getHeight();
            }
            this.ljI.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.ljP = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.ljQ != 0.0f) {
                    int i = (int) (this.ljQ - J);
                    cV(i, (int) (i / this.ljW));
                }
                if (this.ljR != 0.0f) {
                    this.ljI.setRotation(this.ljI.getRotation() - (this.ljR - H));
                }
                this.ljR = H;
                this.ljQ = J;
            } else if (!this.ljP && pointerCount == 1) {
                float y2 = (this.ljI.getY() + rawY) - this.UZ;
                if (y2 < this.lka - (this.ljI.getHeight() / 2)) {
                    y2 = this.lka - (this.ljI.getHeight() / 2);
                } else if (y2 > ((this.lka + this.mVideoHeight) - this.ljI.getHeight()) + (this.ljI.getHeight() / 2)) {
                    y2 = ((this.lka + this.mVideoHeight) - this.ljI.getHeight()) + (this.ljI.getHeight() / 2);
                }
                float x = (this.ljI.getX() + rawX) - this.UY;
                if (x < this.ljZ - (this.ljI.getWidth() / 2)) {
                    x = this.ljZ - (this.ljI.getWidth() / 2);
                } else if (x > ((this.ljZ + this.mVideoWidth) - this.ljI.getWidth()) + (this.ljI.getWidth() / 2)) {
                    x = ((this.ljZ + this.mVideoWidth) - this.ljI.getWidth()) + (this.ljI.getWidth() / 2);
                }
                this.ljI.setX(x);
                this.ljI.setY(y2);
            }
        }
        this.UY = rawX;
        this.UZ = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.ljL.getTextSize() != f) {
            this.ljL.setTextSize(i, f);
        }
        if (this.ljK.getTextSize() != f) {
            this.ljK.setTextSize(i, f);
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
        matrix.postRotate(this.ljI.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.ljV - motionEvent.getRawY(), this.ljU - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gKV && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gKV;
    }

    private void init() {
        this.ljJ = (RotateFrameLayout) this.ljI.findViewById(R.id.content_container);
        this.ljK = (TextView) this.ljI.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.ljI.findViewById(R.id.content_view);
        this.ljL = (EditText) this.ljI.findViewById(R.id.cover_edit);
        this.ljM = (ImageView) this.ljI.findViewById(R.id.cover_delete);
        this.ljN = (ImageView) this.ljI.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.ljK.setText(this.ljL.getText());
        this.ljK.setVisibility(0);
        this.ljL.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.ljK.getText())) {
            this.ljO = 0;
            this.ljI.setVisibility(8);
        }
        if (this.ljO == 4) {
            dby();
        }
        this.ljY.HidenSoftKeyPad(this.ljL);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.ljL.setFocusable(true);
            this.ljL.setFocusableInTouchMode(true);
            this.ljL.requestFocus();
            return;
        }
        this.ljL.setFocusable(false);
        this.ljL.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.ljL.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    CO();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    CO();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    CO();
                    break;
                default:
                    hideSoftKeyPad();
                    String LM = com.baidu.tieba.video.editvideo.model.b.dbt().LM(pendantData.resource);
                    if (TextUtils.isEmpty(LM)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.liH.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dbt().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(LM, pendantData);
                        break;
                    }
                    break;
            }
            this.ljO = pendantData.pendantType;
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
        dby();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.ljO == 4 || this.ljO == 0) {
            this.ljI.setX(this.ljZ);
            this.ljI.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lka);
            String obj = this.ljL.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.ljL.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.ljK.setText(a2);
                    this.ljL.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dby() {
        if (this.lkd) {
            this.lkd = false;
            this.ljM.setVisibility(8);
            this.ljN.setVisibility(8);
            this.ljJ.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbz() {
        if (!this.lkd) {
            this.lkd = true;
            this.ljM.setVisibility(0);
            this.ljN.setVisibility(0);
            this.ljJ.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lko != null) {
            Bitmap bitmap = this.lko.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lko.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dby();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.ljX = 1.0f;
                this.kvz = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.ljX = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.ljS = (this.lki * 2) + width;
                this.ljT = (this.lki * 2) + height;
                this.ljW = (this.ljS * 1.0f) / this.ljT;
                this.ljI.setX((((this.mVideoWidth - i2) - (this.lki * 2)) / 2) + this.ljZ);
                this.ljI.setY((((this.mVideoHeight - i) - (this.lki * 2)) / 2) + this.lka);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lkq = motionEvent.getRawX();
                this.lkr = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lkq);
                float abs2 = Math.abs(rawY - this.lkr);
                if (motionEvent.getPointerCount() <= 1 && abs < this.gKV && abs2 < this.gKV && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.ljK == null || this.ljK.getText() == null) {
            return null;
        }
        return this.ljK.getText().toString();
    }

    public void CO() {
        this.ljK.setText(this.ljL.getText());
        this.ljK.setVisibility(8);
        this.ljL.setVisibility(0);
        setEditTextEnable(true);
        this.ljY.ShowSoftKeyPad(this.ljL);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.ljL.setTextAppearance(getContext(), R.style.cover_text_style);
            this.ljK.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lki = 0;
            this.ljL.setMaxLines(1);
            this.ljK.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ljK.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.ljL.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.ljL.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.ljK.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lki = l.getDimens(getContext(), R.dimen.ds40);
            this.ljL.setMaxLines(2);
            this.ljK.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ljK.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.ljL.setLayoutParams(layoutParams2);
            this.lke = (int) (l.dip2px(getContext(), pendantData.left) * this.ljX);
            this.lkf = (int) (l.dip2px(getContext(), pendantData.f1033top) * this.ljX);
            this.lkg = (int) (l.dip2px(getContext(), pendantData.right) * this.ljX);
            this.lkh = (int) (l.dip2px(getContext(), pendantData.bottom) * this.ljX);
            this.mContentView.setPadding(this.lke, this.lkf, this.lkg, this.lkh);
            this.aVI = l.getDimens(getContext(), R.dimen.fontsize40) * this.ljX;
            String text = getText();
            this.lkj = (i2 - this.lkf) - this.lkh;
            this.lkk = (i - this.lke) - this.lkg;
            this.lkm = this.lkl + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aVI);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lkk);
                this.aVI = this.ljL.getTextSize();
                dbz();
                CO();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.ljL.setText(text);
                    this.ljK.setText(text);
                }
                LO(text);
            }
        }
        this.ljK.setIncludeFontPadding(false);
        this.ljL.setIncludeFontPadding(false);
        this.ljK.setLineSpacing(this.lkl, 1.0f);
        this.ljL.setLineSpacing(this.lkl, 1.0f);
        this.ljI.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ljI.getLayoutParams();
        layoutParams3.height = (this.lki * 2) + i2;
        layoutParams3.width = (this.lki * 2) + i;
        this.ljI.setLayoutParams(layoutParams3);
        this.lkn = (this.lki * 2) + i;
        ((FrameLayout.LayoutParams) this.ljJ.getLayoutParams()).setMargins(this.lki, this.lki, this.lki, this.lki);
        this.ljI.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lkp == null) {
            dbA();
        }
        return this.lkp;
    }

    private void dbA() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lkp = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dbB() {
        if (this.lkp != null && !this.lkp.isRecycled()) {
            this.lkp.recycle();
            this.lkp = null;
        }
    }

    public void uv(boolean z) {
        if (this.ljO != 0) {
            if (z) {
                dbB();
                this.ljI.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.ljI.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lko.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lko.clear();
        this.lko = null;
        dbB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lkt;
        WeakReference<CoverPendantDragView> lku;
        WeakReference<PendantData> lkv;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lkt = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lku = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lkv = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eW(String str, String str2) {
            if (this.lkt != null && this.lkt.get() != null) {
                this.lkt.get().liH.setVisibility(8);
            }
            if (this.lku != null && this.lku.get() != null && this.lkv != null && this.lkv.get() != null) {
                this.lku.get().a(str2, this.lkv.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void LD(String str) {
            if (this.lkt != null && this.lkt.get() != null) {
                this.lkt.get().liH.setVisibility(8);
            }
            if (this.lku != null && this.lku.get() != null) {
                l.showToast(this.lku.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void daH() {
            if (this.lkt != null && this.lkt.get() != null) {
                this.lkt.get().liH.setVisibility(8);
            }
        }
    }
}
