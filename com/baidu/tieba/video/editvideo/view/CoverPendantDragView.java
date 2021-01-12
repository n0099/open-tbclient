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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bHj;
    float bmA;
    float bmB;
    private float cBP;
    private float iNa;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private float mMm;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float nDA;
    private float nDB;
    private int nDC;
    private int nDD;
    private float nDE;
    private float nDF;
    private float nDG;
    private float nDH;
    private c nDI;
    private float nDJ;
    private float nDK;
    private float nDL;
    private float nDM;
    private boolean nDN;
    private int nDO;
    private int nDP;
    private int nDQ;
    private int nDR;
    private int nDS;
    private float nDT;
    private float nDU;
    private int nDV;
    private float nDW;
    private int nDX;
    private Map<String, Bitmap> nDY;
    private Bitmap nDZ;
    private FrameLayout nDs;
    private RotateFrameLayout nDt;
    private TextView nDu;
    private EditText nDv;
    private ImageView nDw;
    private ImageView nDx;
    private int nDy;
    private boolean nDz;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDy = 0;
        this.nDH = 1.0f;
        this.mMm = 1.0f;
        this.nDN = true;
        this.nDY = new HashMap();
        this.startTime = 0L;
        this.bmA = 0.0f;
        this.bmB = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bHj = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nDV = l.getDimens(getContext(), R.dimen.ds2);
        this.iNa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nDs = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nDs);
        this.nDs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nDy == 4) {
                            CoverPendantDragView.this.dQK();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cBP);
                        if (!CoverPendantDragView.this.nDz && abs < CoverPendantDragView.this.iNa && abs2 < CoverPendantDragView.this.iNa && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.KB();
                        }
                        CoverPendantDragView.this.nDA = 0.0f;
                        CoverPendantDragView.this.nDB = 0.0f;
                        CoverPendantDragView.this.nDz = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.ab(motionEvent)) {
                            CoverPendantDragView.this.af(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.nDA = 0.0f;
                        CoverPendantDragView.this.nDB = 0.0f;
                        return true;
                }
            }
        });
        this.nDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nDv.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nDx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nDB = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.ab(motionEvent)) {
                            CoverPendantDragView.this.ae(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.nDv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nDy != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nDu.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nDu.getText().length()) {
                        CoverPendantDragView.this.Tn(obj);
                    } else {
                        CoverPendantDragView.this.Tm(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Tn(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nDu.setText(editable.toString());
            }
        });
        this.nDv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nDs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cBP = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cBP;
        this.nDE = (this.nDs.getWidth() / 2) + this.nDs.getX();
        this.nDF = (this.nDs.getHeight() / 2) + this.nDs.getY();
        this.nDu.setText(this.nDv.getText());
        this.nDu.setVisibility(0);
        this.nDv.setVisibility(8);
        setEditTextEnable(false);
        this.nDI.HidenSoftKeyPad(this.nDv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tm(String str) {
        TextPaint paint = this.nDv.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDv.getLineCount() == 1 && this.nDv.getTextSize() < this.bHj * this.mMm && measureText < this.nDU * this.mMm) {
            setTextSize(0, this.nDv.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nDv.getTextSize() != this.bHj * this.mMm) {
            setTextSize(0, this.bHj * this.mMm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn(String str) {
        TextPaint paint = this.nDv.getPaint();
        float measureText = paint.measureText(str);
        while (this.nDv.getTextSize() > ((this.nDT * this.mMm) / 2.0f) - (this.nDW * this.mMm) && measureText > this.nDU * this.mMm) {
            setTextSize(0, this.nDv.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nDv.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nDv.getTextSize() - 1.0f);
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

    public void setParentViewController(c cVar) {
        this.nDI = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nDJ = f;
        this.nDK = f2;
        this.nDL = f3;
        this.nDM = f4;
        if (this.nDJ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nDJ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nDK > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nDK);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nDL > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nDL) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nDM > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nDM) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float ah = ah(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.nDE - rawX);
        float abs4 = Math.abs(this.nDF - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nDE - this.mLastX);
        float abs6 = Math.abs(this.nDF - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dA(sqrt, (int) (sqrt / this.nDG));
        if (this.nDB != 0.0f) {
            this.nDs.setRotation(this.nDs.getRotation() - (this.nDB - ah));
        }
        this.nDB = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDs.getLayoutParams();
        int width = this.nDs.getWidth() - i;
        int i3 = (int) (width / this.nDG);
        if (width < this.nDC) {
            width = this.nDC;
            i3 = (int) (width / this.nDG);
        }
        this.mMm = ((width * 1.0f) - (this.nDS * 2)) / (this.nDX - (this.nDS * 2));
        this.mContentView.setPadding((int) (this.nDO * this.mMm), (int) (this.nDP * this.mMm), (int) (this.nDQ * this.mMm), (int) (this.nDR * this.mMm));
        setTextSize(0, (this.nDv.getTextSize() * i3) / this.nDs.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nDs.setLayoutParams(layoutParams);
        float f = this.nDE - (layoutParams.width / 2);
        float f2 = this.nDF - (layoutParams.height / 2);
        this.nDs.setX(f);
        this.nDs.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nDy != 4) {
            float y = (this.nDs.getY() + rawY) - this.mLastY;
            if (y < this.nDK) {
                y = this.nDK;
            } else if (y > (this.nDK + this.mVideoHeight) - this.nDs.getHeight()) {
                y = (this.nDK + this.mVideoHeight) - this.nDs.getHeight();
            }
            this.nDs.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nDz = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nDA != 0.0f) {
                    int i = (int) (this.nDA - ai);
                    dA(i, (int) (i / this.nDG));
                }
                if (this.nDB != 0.0f) {
                    this.nDs.setRotation(this.nDs.getRotation() - (this.nDB - ag));
                }
                this.nDB = ag;
                this.nDA = ai;
            } else if (!this.nDz && pointerCount == 1) {
                float y2 = (this.nDs.getY() + rawY) - this.mLastY;
                if (y2 < this.nDK - (this.nDs.getHeight() / 2)) {
                    y2 = this.nDK - (this.nDs.getHeight() / 2);
                } else if (y2 > ((this.nDK + this.mVideoHeight) - this.nDs.getHeight()) + (this.nDs.getHeight() / 2)) {
                    y2 = ((this.nDK + this.mVideoHeight) - this.nDs.getHeight()) + (this.nDs.getHeight() / 2);
                }
                float x = (this.nDs.getX() + rawX) - this.mLastX;
                if (x < this.nDJ - (this.nDs.getWidth() / 2)) {
                    x = this.nDJ - (this.nDs.getWidth() / 2);
                } else if (x > ((this.nDJ + this.mVideoWidth) - this.nDs.getWidth()) + (this.nDs.getWidth() / 2)) {
                    x = ((this.nDJ + this.mVideoWidth) - this.nDs.getWidth()) + (this.nDs.getWidth() / 2);
                }
                this.nDs.setX(x);
                this.nDs.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nDv.getTextSize() != f) {
            this.nDv.setTextSize(i, f);
        }
        if (this.nDu.getTextSize() != f) {
            this.nDu.setTextSize(i, f);
        }
    }

    private float ag(MotionEvent motionEvent) {
        float[] f = f(motionEvent, 0);
        float f2 = f[0];
        float f3 = f[1];
        float[] f4 = f(motionEvent, 1);
        float f5 = f4[0];
        return (float) Math.toDegrees(Math.atan2(f3 - f4[1], f2 - f5));
    }

    private float[] f(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.nDs.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nDF - motionEvent.getRawY(), this.nDE - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iNa && Math.abs(motionEvent.getRawY() - this.cBP) < this.iNa;
    }

    private void init() {
        this.nDt = (RotateFrameLayout) this.nDs.findViewById(R.id.content_container);
        this.nDu = (TextView) this.nDs.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nDs.findViewById(R.id.content_view);
        this.nDv = (EditText) this.nDs.findViewById(R.id.cover_edit);
        this.nDw = (ImageView) this.nDs.findViewById(R.id.cover_delete);
        this.nDx = (ImageView) this.nDs.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nDu.setText(this.nDv.getText());
        this.nDu.setVisibility(0);
        this.nDv.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nDu.getText())) {
            this.nDy = 0;
            this.nDs.setVisibility(8);
        }
        if (this.nDy == 4) {
            dQJ();
        }
        this.nDI.HidenSoftKeyPad(this.nDv);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nDv.setFocusable(true);
            this.nDv.setFocusableInTouchMode(true);
            this.nDv.requestFocus();
            return;
        }
        this.nDv.setFocusable(false);
        this.nDv.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nDv.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    KB();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    KB();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    KB();
                    break;
                default:
                    hideSoftKeyPad();
                    String Tl = com.baidu.tieba.video.editvideo.model.b.dQE().Tl(pendantData.resource);
                    if (TextUtils.isEmpty(Tl)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nCs.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dQE().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Tl, pendantData);
                        break;
                    }
                    break;
            }
            this.nDy = pendantData.pendantType;
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
        dQJ();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nDy == 4 || this.nDy == 0) {
            this.nDs.setX(this.nDJ);
            this.nDs.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nDK);
            String obj = this.nDv.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nDv.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nDu.setText(a2);
                    this.nDv.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dQJ() {
        if (this.nDN) {
            this.nDN = false;
            this.nDw.setVisibility(8);
            this.nDx.setVisibility(8);
            this.nDt.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQK() {
        if (!this.nDN) {
            this.nDN = true;
            this.nDw.setVisibility(0);
            this.nDx.setVisibility(0);
            this.nDt.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nDY != null) {
            Bitmap bitmap = this.nDY.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nDY.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dQJ();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nDH = 1.0f;
                this.mMm = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nDH = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nDC = (this.nDS * 2) + width;
                this.nDD = (this.nDS * 2) + height;
                this.nDG = (this.nDC * 1.0f) / this.nDD;
                this.nDs.setX((((this.mVideoWidth - i2) - (this.nDS * 2)) / 2) + this.nDJ);
                this.nDs.setY((((this.mVideoHeight - i) - (this.nDS * 2)) / 2) + this.nDK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bmA = motionEvent.getRawX();
                this.bmB = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bmA);
                float abs2 = Math.abs(rawY - this.bmB);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iNa && abs2 < this.iNa && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nDu == null || this.nDu.getText() == null) {
            return null;
        }
        return this.nDu.getText().toString();
    }

    public void KB() {
        this.nDu.setText(this.nDv.getText());
        this.nDu.setVisibility(8);
        this.nDv.setVisibility(0);
        setEditTextEnable(true);
        this.nDI.ShowSoftKeyPad(this.nDv);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nDv.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nDu.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nDS = 0;
            this.nDv.setMaxLines(1);
            this.nDu.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDu.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nDv.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nDv.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDu.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nDS = l.getDimens(getContext(), R.dimen.ds40);
            this.nDv.setMaxLines(2);
            this.nDu.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nDu.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nDv.setLayoutParams(layoutParams2);
            this.nDO = (int) (l.dip2px(getContext(), pendantData.left) * this.nDH);
            this.nDP = (int) (l.dip2px(getContext(), pendantData.top) * this.nDH);
            this.nDQ = (int) (l.dip2px(getContext(), pendantData.right) * this.nDH);
            this.nDR = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nDH);
            this.mContentView.setPadding(this.nDO, this.nDP, this.nDQ, this.nDR);
            this.bHj = l.getDimens(getContext(), R.dimen.fontsize40) * this.nDH;
            String text = getText();
            this.nDT = (i2 - this.nDP) - this.nDR;
            this.nDU = (i - this.nDO) - this.nDQ;
            this.nDW = this.nDV + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bHj);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nDU);
                this.bHj = this.nDv.getTextSize();
                dQK();
                KB();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.nDv.setText(text);
                    this.nDu.setText(text);
                }
                Tn(text);
            }
        }
        this.nDu.setIncludeFontPadding(false);
        this.nDv.setIncludeFontPadding(false);
        this.nDu.setLineSpacing(this.nDV, 1.0f);
        this.nDv.setLineSpacing(this.nDV, 1.0f);
        this.nDs.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nDs.getLayoutParams();
        layoutParams3.height = (this.nDS * 2) + i2;
        layoutParams3.width = (this.nDS * 2) + i;
        this.nDs.setLayoutParams(layoutParams3);
        this.nDX = (this.nDS * 2) + i;
        ((FrameLayout.LayoutParams) this.nDt.getLayoutParams()).setMargins(this.nDS, this.nDS, this.nDS, this.nDS);
        this.nDs.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nDZ == null) {
            dQL();
        }
        return this.nDZ;
    }

    private void dQL() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nDZ = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dQM() {
        if (this.nDZ != null && !this.nDZ.isRecycled()) {
            this.nDZ.recycle();
            this.nDZ = null;
        }
    }

    public void yF(boolean z) {
        if (this.nDy != 0) {
            if (z) {
                dQM();
                this.nDs.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nDs.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nDY.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nDY.clear();
        this.nDY = null;
        dQM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements b.a {
        WeakReference<a.b> nEb;
        WeakReference<CoverPendantDragView> nEc;
        WeakReference<PendantData> nEd;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nEb = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nEc = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nEd = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gx(String str, String str2) {
            if (this.nEb != null && this.nEb.get() != null) {
                this.nEb.get().nCs.setVisibility(8);
            }
            if (this.nEc != null && this.nEc.get() != null && this.nEd != null && this.nEd.get() != null) {
                this.nEc.get().a(str2, this.nEd.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Te(String str) {
            if (this.nEb != null && this.nEb.get() != null) {
                this.nEb.get().nCs.setVisibility(8);
            }
            if (this.nEc != null && this.nEc.get() != null) {
                l.showToast(this.nEc.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dPV() {
            if (this.nEb != null && this.nEb.get() != null) {
                this.nEb.get().nCs.setVisibility(8);
            }
        }
    }
}
