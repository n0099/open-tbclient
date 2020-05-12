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
    private float Vb;
    private float Vc;
    private float aVN;
    private float gLb;
    private float kvD;
    private FrameLayout ljM;
    private RotateFrameLayout ljN;
    private TextView ljO;
    private EditText ljP;
    private ImageView ljQ;
    private ImageView ljR;
    private int ljS;
    private boolean ljT;
    private float ljU;
    private float ljV;
    private int ljW;
    private int ljX;
    private float ljY;
    private float ljZ;
    private float lka;
    private float lkb;
    private b lkc;
    private float lkd;
    private float lke;
    private float lkf;
    private float lkg;
    private boolean lkh;
    private int lki;
    private int lkj;
    private int lkk;
    private int lkl;
    private int lkm;
    private float lkn;
    private float lko;
    private int lkp;
    private float lkq;
    private int lkr;
    private Map<String, Bitmap> lks;
    private Bitmap lkt;
    float lku;
    float lkv;
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
        this.ljS = 0;
        this.lkb = 1.0f;
        this.kvD = 1.0f;
        this.lkh = true;
        this.lks = new HashMap();
        this.startTime = 0L;
        this.lku = 0.0f;
        this.lkv = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.aVN = l.getDimens(getContext(), R.dimen.fontsize40);
        this.lkp = l.getDimens(getContext(), R.dimen.ds2);
        this.gLb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ljM = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.ljM);
        this.ljM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.d(view, motionEvent);
                        if (CoverPendantDragView.this.ljS == 4) {
                            CoverPendantDragView.this.dbx();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.ljT && abs < CoverPendantDragView.this.gLb && abs2 < CoverPendantDragView.this.gLb && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.CN();
                        }
                        CoverPendantDragView.this.ljU = 0.0f;
                        CoverPendantDragView.this.ljV = 0.0f;
                        CoverPendantDragView.this.ljT = false;
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
                        CoverPendantDragView.this.ljU = 0.0f;
                        CoverPendantDragView.this.ljV = 0.0f;
                        return true;
                }
            }
        });
        this.ljQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.ljP.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.ljR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.d(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.ljV = 0.0f;
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
        this.ljP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.ljS != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.ljO.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.ljO.getText().length()) {
                        CoverPendantDragView.this.LR(obj);
                    } else {
                        CoverPendantDragView.this.LQ(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.LR(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.ljO.setText(editable.toString());
            }
        });
        this.ljP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.ljM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.Vb = this.mDownX;
        this.Vc = this.mDownY;
        this.ljY = (this.ljM.getWidth() / 2) + this.ljM.getX();
        this.ljZ = (this.ljM.getHeight() / 2) + this.ljM.getY();
        this.ljO.setText(this.ljP.getText());
        this.ljO.setVisibility(0);
        this.ljP.setVisibility(8);
        setEditTextEnable(false);
        this.lkc.HidenSoftKeyPad(this.ljP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LQ(String str) {
        TextPaint paint = this.ljP.getPaint();
        float measureText = paint.measureText(str);
        while (this.ljP.getLineCount() == 1 && this.ljP.getTextSize() < this.aVN * this.kvD && measureText < this.lko * this.kvD) {
            setTextSize(0, this.ljP.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.ljP.getTextSize() != this.aVN * this.kvD) {
            setTextSize(0, this.aVN * this.kvD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR(String str) {
        TextPaint paint = this.ljP.getPaint();
        float measureText = paint.measureText(str);
        while (this.ljP.getTextSize() > ((this.lkn * this.kvD) / 2.0f) - (this.lkq * this.kvD) && measureText > this.lko * this.kvD) {
            setTextSize(0, this.ljP.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.ljP.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.ljP.getTextSize() - 1.0f);
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
        this.lkc = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.lkd = f;
        this.lke = f2;
        this.lkf = f3;
        this.lkg = f4;
        if (this.lkd > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.lkd, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.lke > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.lke);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.lkf > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.lkf) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.lkg > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.lkg) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float I = I(motionEvent);
        float abs = Math.abs(this.Vb - rawX);
        float abs2 = Math.abs(this.Vc - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.ljY - rawX);
        float abs4 = Math.abs(this.ljZ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.ljY - this.Vb);
        float abs6 = Math.abs(this.ljZ - this.Vc);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cV(sqrt, (int) (sqrt / this.lka));
        if (this.ljV != 0.0f) {
            this.ljM.setRotation(this.ljM.getRotation() - (this.ljV - I));
        }
        this.ljV = I;
        this.Vb = rawX;
        this.Vc = rawY;
    }

    private void cV(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ljM.getLayoutParams();
        int width = this.ljM.getWidth() - i;
        int i3 = (int) (width / this.lka);
        if (width < this.ljW) {
            width = this.ljW;
            i3 = (int) (width / this.lka);
        }
        this.kvD = ((width * 1.0f) - (this.lkm * 2)) / (this.lkr - (this.lkm * 2));
        this.mContentView.setPadding((int) (this.lki * this.kvD), (int) (this.lkj * this.kvD), (int) (this.lkk * this.kvD), (int) (this.lkl * this.kvD));
        setTextSize(0, (this.ljP.getTextSize() * i3) / this.ljM.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.ljM.setLayoutParams(layoutParams);
        float f = this.ljY - (layoutParams.width / 2);
        float f2 = this.ljZ - (layoutParams.height / 2);
        this.ljM.setX(f);
        this.ljM.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.ljS != 4) {
            float y = (this.ljM.getY() + rawY) - this.Vc;
            if (y < this.lke) {
                y = this.lke;
            } else if (y > (this.lke + this.mVideoHeight) - this.ljM.getHeight()) {
                y = (this.lke + this.mVideoHeight) - this.ljM.getHeight();
            }
            this.ljM.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.ljT = true;
                float J = J(motionEvent);
                float H = H(motionEvent);
                if (this.ljU != 0.0f) {
                    int i = (int) (this.ljU - J);
                    cV(i, (int) (i / this.lka));
                }
                if (this.ljV != 0.0f) {
                    this.ljM.setRotation(this.ljM.getRotation() - (this.ljV - H));
                }
                this.ljV = H;
                this.ljU = J;
            } else if (!this.ljT && pointerCount == 1) {
                float y2 = (this.ljM.getY() + rawY) - this.Vc;
                if (y2 < this.lke - (this.ljM.getHeight() / 2)) {
                    y2 = this.lke - (this.ljM.getHeight() / 2);
                } else if (y2 > ((this.lke + this.mVideoHeight) - this.ljM.getHeight()) + (this.ljM.getHeight() / 2)) {
                    y2 = ((this.lke + this.mVideoHeight) - this.ljM.getHeight()) + (this.ljM.getHeight() / 2);
                }
                float x = (this.ljM.getX() + rawX) - this.Vb;
                if (x < this.lkd - (this.ljM.getWidth() / 2)) {
                    x = this.lkd - (this.ljM.getWidth() / 2);
                } else if (x > ((this.lkd + this.mVideoWidth) - this.ljM.getWidth()) + (this.ljM.getWidth() / 2)) {
                    x = ((this.lkd + this.mVideoWidth) - this.ljM.getWidth()) + (this.ljM.getWidth() / 2);
                }
                this.ljM.setX(x);
                this.ljM.setY(y2);
            }
        }
        this.Vb = rawX;
        this.Vc = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.ljP.getTextSize() != f) {
            this.ljP.setTextSize(i, f);
        }
        if (this.ljO.getTextSize() != f) {
            this.ljO.setTextSize(i, f);
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
        matrix.postRotate(this.ljM.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float I(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.ljZ - motionEvent.getRawY(), this.ljY - motionEvent.getRawX()));
    }

    private float J(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gLb && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gLb;
    }

    private void init() {
        this.ljN = (RotateFrameLayout) this.ljM.findViewById(R.id.content_container);
        this.ljO = (TextView) this.ljM.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.ljM.findViewById(R.id.content_view);
        this.ljP = (EditText) this.ljM.findViewById(R.id.cover_edit);
        this.ljQ = (ImageView) this.ljM.findViewById(R.id.cover_delete);
        this.ljR = (ImageView) this.ljM.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.ljO.setText(this.ljP.getText());
        this.ljO.setVisibility(0);
        this.ljP.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.ljO.getText())) {
            this.ljS = 0;
            this.ljM.setVisibility(8);
        }
        if (this.ljS == 4) {
            dbw();
        }
        this.lkc.HidenSoftKeyPad(this.ljP);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.ljP.setFocusable(true);
            this.ljP.setFocusableInTouchMode(true);
            this.ljP.requestFocus();
            return;
        }
        this.ljP.setFocusable(false);
        this.ljP.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.ljP.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    CN();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    CN();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    CN();
                    break;
                default:
                    hideSoftKeyPad();
                    String LP = com.baidu.tieba.video.editvideo.model.b.dbr().LP(pendantData.resource);
                    if (TextUtils.isEmpty(LP)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.liL.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dbr().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(LP, pendantData);
                        break;
                    }
                    break;
            }
            this.ljS = pendantData.pendantType;
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
        dbw();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.ljS == 4 || this.ljS == 0) {
            this.ljM.setX(this.lkd);
            this.ljM.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.lke);
            String obj = this.ljP.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.ljP.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.ljO.setText(a2);
                    this.ljP.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dbw() {
        if (this.lkh) {
            this.lkh = false;
            this.ljQ.setVisibility(8);
            this.ljR.setVisibility(8);
            this.ljN.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbx() {
        if (!this.lkh) {
            this.lkh = true;
            this.ljQ.setVisibility(0);
            this.ljR.setVisibility(0);
            this.ljN.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.lks != null) {
            Bitmap bitmap = this.lks.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.lks.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dbw();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.lkb = 1.0f;
                this.kvD = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.lkb = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.ljW = (this.lkm * 2) + width;
                this.ljX = (this.lkm * 2) + height;
                this.lka = (this.ljW * 1.0f) / this.ljX;
                this.ljM.setX((((this.mVideoWidth - i2) - (this.lkm * 2)) / 2) + this.lkd);
                this.ljM.setY((((this.mVideoHeight - i) - (this.lkm * 2)) / 2) + this.lke);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.lku = motionEvent.getRawX();
                this.lkv = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.lku);
                float abs2 = Math.abs(rawY - this.lkv);
                if (motionEvent.getPointerCount() <= 1 && abs < this.gLb && abs2 < this.gLb && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.ljO == null || this.ljO.getText() == null) {
            return null;
        }
        return this.ljO.getText().toString();
    }

    public void CN() {
        this.ljO.setText(this.ljP.getText());
        this.ljO.setVisibility(8);
        this.ljP.setVisibility(0);
        setEditTextEnable(true);
        this.lkc.ShowSoftKeyPad(this.ljP);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.ljP.setTextAppearance(getContext(), R.style.cover_text_style);
            this.ljO.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.lkm = 0;
            this.ljP.setMaxLines(1);
            this.ljO.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ljO.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.ljP.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.ljP.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.ljO.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.lkm = l.getDimens(getContext(), R.dimen.ds40);
            this.ljP.setMaxLines(2);
            this.ljO.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ljO.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.ljP.setLayoutParams(layoutParams2);
            this.lki = (int) (l.dip2px(getContext(), pendantData.left) * this.lkb);
            this.lkj = (int) (l.dip2px(getContext(), pendantData.f1025top) * this.lkb);
            this.lkk = (int) (l.dip2px(getContext(), pendantData.right) * this.lkb);
            this.lkl = (int) (l.dip2px(getContext(), pendantData.bottom) * this.lkb);
            this.mContentView.setPadding(this.lki, this.lkj, this.lkk, this.lkl);
            this.aVN = l.getDimens(getContext(), R.dimen.fontsize40) * this.lkb;
            String text = getText();
            this.lkn = (i2 - this.lkj) - this.lkl;
            this.lko = (i - this.lki) - this.lkk;
            this.lkq = this.lkp + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.aVN);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.lko);
                this.aVN = this.ljP.getTextSize();
                dbx();
                CN();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.ljP.setText(text);
                    this.ljO.setText(text);
                }
                LR(text);
            }
        }
        this.ljO.setIncludeFontPadding(false);
        this.ljP.setIncludeFontPadding(false);
        this.ljO.setLineSpacing(this.lkp, 1.0f);
        this.ljP.setLineSpacing(this.lkp, 1.0f);
        this.ljM.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ljM.getLayoutParams();
        layoutParams3.height = (this.lkm * 2) + i2;
        layoutParams3.width = (this.lkm * 2) + i;
        this.ljM.setLayoutParams(layoutParams3);
        this.lkr = (this.lkm * 2) + i;
        ((FrameLayout.LayoutParams) this.ljN.getLayoutParams()).setMargins(this.lkm, this.lkm, this.lkm, this.lkm);
        this.ljM.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.lkt == null) {
            dby();
        }
        return this.lkt;
    }

    private void dby() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.lkt = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dbz() {
        if (this.lkt != null && !this.lkt.isRecycled()) {
            this.lkt.recycle();
            this.lkt = null;
        }
    }

    public void uv(boolean z) {
        if (this.ljS != 0) {
            if (z) {
                dbz();
                this.ljM.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.ljM.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.lks.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.lks.clear();
        this.lks = null;
        dbz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements b.a {
        WeakReference<a.b> lkx;
        WeakReference<CoverPendantDragView> lky;
        WeakReference<PendantData> lkz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.lkx = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.lky = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.lkz = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void eW(String str, String str2) {
            if (this.lkx != null && this.lkx.get() != null) {
                this.lkx.get().liL.setVisibility(8);
            }
            if (this.lky != null && this.lky.get() != null && this.lkz != null && this.lkz.get() != null) {
                this.lky.get().a(str2, this.lkz.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void LG(String str) {
            if (this.lkx != null && this.lkx.get() != null) {
                this.lkx.get().liL.setVisibility(8);
            }
            if (this.lky != null && this.lky.get() != null) {
                l.showToast(this.lky.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void daF() {
            if (this.lkx != null && this.lkx.get() != null) {
                this.lkx.get().liL.setVisibility(8);
            }
        }
    }
}
