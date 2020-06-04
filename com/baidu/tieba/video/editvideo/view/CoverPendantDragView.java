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
    private float Vq;
    private float Vr;
    private float bdb;
    private float gZY;
    private float kOF;
    private FrameLayout lDG;
    private RotateFrameLayout lDH;
    private TextView lDI;
    private EditText lDJ;
    private ImageView lDK;
    private ImageView lDL;
    private int lDM;
    private boolean lDN;
    private float lDO;
    private float lDP;
    private int lDQ;
    private int lDR;
    private float lDS;
    private float lDT;
    private float lDU;
    private float lDV;
    private b lDW;
    private float lDX;
    private float lDY;
    private float lDZ;
    private float lEa;
    private boolean lEb;
    private int lEc;
    private int lEd;
    private int lEe;
    private int lEf;
    private int lEg;
    private float lEh;
    private float lEi;
    private int lEj;
    private float lEk;
    private int lEl;
    private Map<String, Bitmap> lEm;
    private Bitmap lEn;
    float lEo;
    float lEp;
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
        this.lDM = 0;
        this.lDV = 1.0f;
        this.kOF = 1.0f;
        this.lEb = true;
        this.lEm = new HashMap();
        this.startTime = 0L;
        this.lEo = 0.0f;
        this.lEp = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bdb = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lEj = l.getDimens(getContext(), R.dimen.ds2);
        this.gZY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.lDG = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.lDG);
        this.lDG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.lDM == 4) {
                            CoverPendantDragView.this.dja();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.lDN && abs < CoverPendantDragView.this.gZY && abs2 < CoverPendantDragView.this.gZY && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Ek();
                        }
                        CoverPendantDragView.this.lDO = 0.0f;
                        CoverPendantDragView.this.lDP = 0.0f;
                        CoverPendantDragView.this.lDN = false;
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
                        CoverPendantDragView.this.lDO = 0.0f;
                        CoverPendantDragView.this.lDP = 0.0f;
                        return true;
                }
            }
        });
        this.lDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.lDJ.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.lDL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.lDP = 0.0f;
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
        this.lDJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.lDM != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.lDI.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.lDI.getText().length()) {
                        CoverPendantDragView.this.NF(obj);
                    } else {
                        CoverPendantDragView.this.NE(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.NF(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.lDI.setText(editable.toString());
            }
        });
        this.lDJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.lDG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.Vq = this.mDownX;
        this.Vr = this.mDownY;
        this.lDS = (this.lDG.getWidth() / 2) + this.lDG.getX();
        this.lDT = (this.lDG.getHeight() / 2) + this.lDG.getY();
        this.lDI.setText(this.lDJ.getText());
        this.lDI.setVisibility(0);
        this.lDJ.setVisibility(8);
        setEditTextEnable(false);
        this.lDW.HidenSoftKeyPad(this.lDJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NE(String str) {
        TextPaint paint = this.lDJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.lDJ.getLineCount() == 1 && this.lDJ.getTextSize() < this.bdb * this.kOF && measureText < this.lEi * this.kOF) {
            setTextSize(0, this.lDJ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.lDJ.getTextSize() != this.bdb * this.kOF) {
            setTextSize(0, this.bdb * this.kOF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF(String str) {
        TextPaint paint = this.lDJ.getPaint();
        float measureText = paint.measureText(str);
        while (this.lDJ.getTextSize() > ((this.lEh * this.kOF) / 2.0f) - (this.lEk * this.kOF) && measureText > this.lEi * this.kOF) {
            setTextSize(0, this.lDJ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.lDJ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.lDJ.getTextSize() - 1.0f);
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

    public void setParentViewController(b bVar) {
        this.lDW = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.lDX = f;
        this.lDY = f2;
        this.lDZ = f3;
        this.lEa = f4;
        if (this.lDX > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.lDX, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lDY > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lDY);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lDZ > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lDZ) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lEa > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lEa) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float N = N(motionEvent);
        float abs = Math.abs(this.Vq - rawX);
        float abs2 = Math.abs(this.Vr - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.lDS - rawX);
        float abs4 = Math.abs(this.lDT - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.lDS - this.Vq);
        float abs6 = Math.abs(this.lDT - this.Vr);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        da(sqrt, (int) (sqrt / this.lDU));
        if (this.lDP != 0.0f) {
            this.lDG.setRotation(this.lDG.getRotation() - (this.lDP - N));
        }
        this.lDP = N;
        this.Vq = rawX;
        this.Vr = rawY;
    }

    private void da(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lDG.getLayoutParams();
        int width = this.lDG.getWidth() - i;
        int i3 = (int) (width / this.lDU);
        if (width < this.lDQ) {
            width = this.lDQ;
            i3 = (int) (width / this.lDU);
        }
        this.kOF = ((width * 1.0f) - (this.lEg * 2)) / (this.lEl - (this.lEg * 2));
        this.mContentView.setPadding((int) (this.lEc * this.kOF), (int) (this.lEd * this.kOF), (int) (this.lEe * this.kOF), (int) (this.lEf * this.kOF));
        setTextSize(0, (this.lDJ.getTextSize() * i3) / this.lDG.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.lDG.setLayoutParams(layoutParams);
        float f = this.lDS - (layoutParams.width / 2);
        float f2 = this.lDT - (layoutParams.height / 2);
        this.lDG.setX(f);
        this.lDG.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.lDM != 4) {
            float y = (this.lDG.getY() + rawY) - this.Vr;
            if (y < this.lDY) {
                y = this.lDY;
            } else if (y > (this.lDY + this.mVideoHeight) - this.lDG.getHeight()) {
                y = (this.lDY + this.mVideoHeight) - this.lDG.getHeight();
            }
            this.lDG.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.lDN = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.lDO != 0.0f) {
                    int i = (int) (this.lDO - O);
                    da(i, (int) (i / this.lDU));
                }
                if (this.lDP != 0.0f) {
                    this.lDG.setRotation(this.lDG.getRotation() - (this.lDP - M));
                }
                this.lDP = M;
                this.lDO = O;
            } else if (!this.lDN && pointerCount == 1) {
                float y2 = (this.lDG.getY() + rawY) - this.Vr;
                if (y2 < this.lDY - (this.lDG.getHeight() / 2)) {
                    y2 = this.lDY - (this.lDG.getHeight() / 2);
                } else if (y2 > ((this.lDY + this.mVideoHeight) - this.lDG.getHeight()) + (this.lDG.getHeight() / 2)) {
                    y2 = ((this.lDY + this.mVideoHeight) - this.lDG.getHeight()) + (this.lDG.getHeight() / 2);
                }
                float x = (this.lDG.getX() + rawX) - this.Vq;
                if (x < this.lDX - (this.lDG.getWidth() / 2)) {
                    x = this.lDX - (this.lDG.getWidth() / 2);
                } else if (x > ((this.lDX + this.mVideoWidth) - this.lDG.getWidth()) + (this.lDG.getWidth() / 2)) {
                    x = ((this.lDX + this.mVideoWidth) - this.lDG.getWidth()) + (this.lDG.getWidth() / 2);
                }
                this.lDG.setX(x);
                this.lDG.setY(y2);
            }
        }
        this.Vq = rawX;
        this.Vr = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.lDJ.getTextSize() != f) {
            this.lDJ.setTextSize(i, f);
        }
        if (this.lDI.getTextSize() != f) {
            this.lDI.setTextSize(i, f);
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
        matrix.postRotate(this.lDG.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.lDT - motionEvent.getRawY(), this.lDS - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gZY && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gZY;
    }

    private void init() {
        this.lDH = (RotateFrameLayout) this.lDG.findViewById(R.id.content_container);
        this.lDI = (TextView) this.lDG.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.lDG.findViewById(R.id.content_view);
        this.lDJ = (EditText) this.lDG.findViewById(R.id.cover_edit);
        this.lDK = (ImageView) this.lDG.findViewById(R.id.cover_delete);
        this.lDL = (ImageView) this.lDG.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.lDI.setText(this.lDJ.getText());
        this.lDI.setVisibility(0);
        this.lDJ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.lDI.getText())) {
            this.lDM = 0;
            this.lDG.setVisibility(8);
        }
        if (this.lDM == 4) {
            diZ();
        }
        this.lDW.HidenSoftKeyPad(this.lDJ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.lDJ.setFocusable(true);
            this.lDJ.setFocusableInTouchMode(true);
            this.lDJ.requestFocus();
            return;
        }
        this.lDJ.setFocusable(false);
        this.lDJ.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.lDJ.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Ek();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Ek();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Ek();
                    break;
                default:
                    hideSoftKeyPad();
                    String ND = com.baidu.tieba.video.editvideo.model.b.diU().ND(pendantData.resource);
                    if (TextUtils.isEmpty(ND)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.lCF.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.diU().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(ND, pendantData);
                        break;
                    }
                    break;
            }
            this.lDM = pendantData.pendantType;
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
        diZ();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.lDM == 4 || this.lDM == 0) {
            this.lDG.setX(this.lDX);
            this.lDG.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lDY);
            String obj = this.lDJ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.lDJ.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.lDI.setText(a2);
                    this.lDJ.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void diZ() {
        if (this.lEb) {
            this.lEb = false;
            this.lDK.setVisibility(8);
            this.lDL.setVisibility(8);
            this.lDH.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dja() {
        if (!this.lEb) {
            this.lEb = true;
            this.lDK.setVisibility(0);
            this.lDL.setVisibility(0);
            this.lDH.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lEm != null) {
            Bitmap bitmap = this.lEm.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lEm.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                diZ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.lDV = 1.0f;
                this.kOF = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.lDV = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.lDQ = (this.lEg * 2) + width;
                this.lDR = (this.lEg * 2) + height;
                this.lDU = (this.lDQ * 1.0f) / this.lDR;
                this.lDG.setX((((this.mVideoWidth - i2) - (this.lEg * 2)) / 2) + this.lDX);
                this.lDG.setY((((this.mVideoHeight - i) - (this.lEg * 2)) / 2) + this.lDY);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lEo = motionEvent.getRawX();
                this.lEp = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lEo);
                float abs2 = Math.abs(rawY - this.lEp);
                if (motionEvent.getPointerCount() <= 1 && abs < this.gZY && abs2 < this.gZY && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.lDI == null || this.lDI.getText() == null) {
            return null;
        }
        return this.lDI.getText().toString();
    }

    public void Ek() {
        this.lDI.setText(this.lDJ.getText());
        this.lDI.setVisibility(8);
        this.lDJ.setVisibility(0);
        setEditTextEnable(true);
        this.lDW.ShowSoftKeyPad(this.lDJ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.lDJ.setTextAppearance(getContext(), R.style.cover_text_style);
            this.lDI.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lEg = 0;
            this.lDJ.setMaxLines(1);
            this.lDI.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lDI.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.lDJ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.lDJ.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lDI.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lEg = l.getDimens(getContext(), R.dimen.ds40);
            this.lDJ.setMaxLines(2);
            this.lDI.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.lDI.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.lDJ.setLayoutParams(layoutParams2);
            this.lEc = (int) (l.dip2px(getContext(), pendantData.left) * this.lDV);
            this.lEd = (int) (l.dip2px(getContext(), pendantData.f1025top) * this.lDV);
            this.lEe = (int) (l.dip2px(getContext(), pendantData.right) * this.lDV);
            this.lEf = (int) (l.dip2px(getContext(), pendantData.bottom) * this.lDV);
            this.mContentView.setPadding(this.lEc, this.lEd, this.lEe, this.lEf);
            this.bdb = l.getDimens(getContext(), R.dimen.fontsize40) * this.lDV;
            String text = getText();
            this.lEh = (i2 - this.lEd) - this.lEf;
            this.lEi = (i - this.lEc) - this.lEe;
            this.lEk = this.lEj + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bdb);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lEi);
                this.bdb = this.lDJ.getTextSize();
                dja();
                Ek();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.lDJ.setText(text);
                    this.lDI.setText(text);
                }
                NF(text);
            }
        }
        this.lDI.setIncludeFontPadding(false);
        this.lDJ.setIncludeFontPadding(false);
        this.lDI.setLineSpacing(this.lEj, 1.0f);
        this.lDJ.setLineSpacing(this.lEj, 1.0f);
        this.lDG.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.lDG.getLayoutParams();
        layoutParams3.height = (this.lEg * 2) + i2;
        layoutParams3.width = (this.lEg * 2) + i;
        this.lDG.setLayoutParams(layoutParams3);
        this.lEl = (this.lEg * 2) + i;
        ((FrameLayout.LayoutParams) this.lDH.getLayoutParams()).setMargins(this.lEg, this.lEg, this.lEg, this.lEg);
        this.lDG.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lEn == null) {
            djb();
        }
        return this.lEn;
    }

    private void djb() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lEn = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void djc() {
        if (this.lEn != null && !this.lEn.isRecycled()) {
            this.lEn.recycle();
            this.lEn = null;
        }
    }

    public void uT(boolean z) {
        if (this.lDM != 0) {
            if (z) {
                djc();
                this.lDG.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.lDG.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lEm.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lEm.clear();
        this.lEm = null;
        djc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lEr;
        WeakReference<CoverPendantDragView> lEs;
        WeakReference<PendantData> lEt;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lEr = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lEs = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lEt = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fx(String str, String str2) {
            if (this.lEr != null && this.lEr.get() != null) {
                this.lEr.get().lCF.setVisibility(8);
            }
            if (this.lEs != null && this.lEs.get() != null && this.lEt != null && this.lEt.get() != null) {
                this.lEs.get().a(str2, this.lEt.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Nu(String str) {
            if (this.lEr != null && this.lEr.get() != null) {
                this.lEr.get().lCF.setVisibility(8);
            }
            if (this.lEs != null && this.lEs.get() != null) {
                l.showToast(this.lEs.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dii() {
            if (this.lEr != null && this.lEr.get() != null) {
                this.lEr.get().lCF.setVisibility(8);
            }
        }
    }
}
