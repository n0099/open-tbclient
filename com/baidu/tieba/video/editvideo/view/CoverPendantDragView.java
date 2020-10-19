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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes23.dex */
public class CoverPendantDragView extends FrameLayout {
    float bjr;
    float bjs;
    private float bvn;
    private float cif;
    private float ibo;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mWA;
    private c mWB;
    private float mWC;
    private float mWD;
    private float mWE;
    private float mWF;
    private boolean mWG;
    private int mWH;
    private int mWI;
    private int mWJ;
    private int mWK;
    private int mWL;
    private float mWN;
    private float mWO;
    private int mWP;
    private float mWQ;
    private int mWR;
    private Map<String, Bitmap> mWS;
    private Bitmap mWT;
    private FrameLayout mWl;
    private RotateFrameLayout mWm;
    private TextView mWn;
    private EditText mWo;
    private ImageView mWp;
    private ImageView mWq;
    private int mWr;
    private boolean mWs;
    private float mWt;
    private float mWu;
    private int mWv;
    private int mWw;
    private float mWx;
    private float mWy;
    private float mWz;
    private float meN;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWr = 0;
        this.mWA = 1.0f;
        this.meN = 1.0f;
        this.mWG = true;
        this.mWS = new HashMap();
        this.startTime = 0L;
        this.bjr = 0.0f;
        this.bjs = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bvn = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mWP = l.getDimens(getContext(), R.dimen.ds2);
        this.ibo = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mWl = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.mWl);
        this.mWl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.mWr == 4) {
                            CoverPendantDragView.this.dJI();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cif);
                        if (!CoverPendantDragView.this.mWs && abs < CoverPendantDragView.this.ibo && abs2 < CoverPendantDragView.this.ibo && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Ml();
                        }
                        CoverPendantDragView.this.mWt = 0.0f;
                        CoverPendantDragView.this.mWu = 0.0f;
                        CoverPendantDragView.this.mWs = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.aa(motionEvent)) {
                            CoverPendantDragView.this.ae(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.mWt = 0.0f;
                        CoverPendantDragView.this.mWu = 0.0f;
                        return true;
                }
            }
        });
        this.mWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.mWo.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.mWq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.mWu = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.aa(motionEvent)) {
                            CoverPendantDragView.this.ad(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.mWo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.mWr != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.mWn.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (af.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.mWn.getText().length()) {
                        CoverPendantDragView.this.SZ(obj);
                    } else {
                        CoverPendantDragView.this.SY(obj);
                    }
                } else {
                    String subStringWithAllOne = af.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.SZ(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.mWn.setText(editable.toString());
            }
        });
        this.mWo.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.mWl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cif = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cif;
        this.mWx = (this.mWl.getWidth() / 2) + this.mWl.getX();
        this.mWy = (this.mWl.getHeight() / 2) + this.mWl.getY();
        this.mWn.setText(this.mWo.getText());
        this.mWn.setVisibility(0);
        this.mWo.setVisibility(8);
        setEditTextEnable(false);
        this.mWB.HidenSoftKeyPad(this.mWo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY(String str) {
        TextPaint paint = this.mWo.getPaint();
        float measureText = paint.measureText(str);
        while (this.mWo.getLineCount() == 1 && this.mWo.getTextSize() < this.bvn * this.meN && measureText < this.mWO * this.meN) {
            setTextSize(0, this.mWo.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (af.getTextLengthAllOne(str) <= af.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.mWo.getTextSize() != this.bvn * this.meN) {
            setTextSize(0, this.bvn * this.meN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SZ(String str) {
        TextPaint paint = this.mWo.getPaint();
        float measureText = paint.measureText(str);
        while (this.mWo.getTextSize() > ((this.mWN * this.meN) / 2.0f) - (this.mWQ * this.meN) && measureText > this.mWO * this.meN) {
            setTextSize(0, this.mWo.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.mWo.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.mWo.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = af.subStringWithEmoji(str, af.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.mWB = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mWC = f;
        this.mWD = f2;
        this.mWE = f3;
        this.mWF = f4;
        if (this.mWC > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mWC, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mWD > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mWD);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mWE > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mWE) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mWF > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mWF) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float ag = ag(motionEvent);
        float abs = Math.abs(this.mLastX - rawX);
        float abs2 = Math.abs(this.mLastY - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.mWx - rawX);
        float abs4 = Math.abs(this.mWy - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.mWx - this.mLastX);
        float abs6 = Math.abs(this.mWy - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        du(sqrt, (int) (sqrt / this.mWz));
        if (this.mWu != 0.0f) {
            this.mWl.setRotation(this.mWl.getRotation() - (this.mWu - ag));
        }
        this.mWu = ag;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void du(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWl.getLayoutParams();
        int width = this.mWl.getWidth() - i;
        int i3 = (int) (width / this.mWz);
        if (width < this.mWv) {
            width = this.mWv;
            i3 = (int) (width / this.mWz);
        }
        this.meN = ((width * 1.0f) - (this.mWL * 2)) / (this.mWR - (this.mWL * 2));
        this.mContentView.setPadding((int) (this.mWH * this.meN), (int) (this.mWI * this.meN), (int) (this.mWJ * this.meN), (int) (this.mWK * this.meN));
        setTextSize(0, (this.mWo.getTextSize() * i3) / this.mWl.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.mWl.setLayoutParams(layoutParams);
        float f = this.mWx - (layoutParams.width / 2);
        float f2 = this.mWy - (layoutParams.height / 2);
        this.mWl.setX(f);
        this.mWl.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.mWr != 4) {
            float y = (this.mWl.getY() + rawY) - this.mLastY;
            if (y < this.mWD) {
                y = this.mWD;
            } else if (y > (this.mWD + this.mVideoHeight) - this.mWl.getHeight()) {
                y = (this.mWD + this.mVideoHeight) - this.mWl.getHeight();
            }
            this.mWl.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.mWs = true;
                float ah = ah(motionEvent);
                float af = af(motionEvent);
                if (this.mWt != 0.0f) {
                    int i = (int) (this.mWt - ah);
                    du(i, (int) (i / this.mWz));
                }
                if (this.mWu != 0.0f) {
                    this.mWl.setRotation(this.mWl.getRotation() - (this.mWu - af));
                }
                this.mWu = af;
                this.mWt = ah;
            } else if (!this.mWs && pointerCount == 1) {
                float y2 = (this.mWl.getY() + rawY) - this.mLastY;
                if (y2 < this.mWD - (this.mWl.getHeight() / 2)) {
                    y2 = this.mWD - (this.mWl.getHeight() / 2);
                } else if (y2 > ((this.mWD + this.mVideoHeight) - this.mWl.getHeight()) + (this.mWl.getHeight() / 2)) {
                    y2 = ((this.mWD + this.mVideoHeight) - this.mWl.getHeight()) + (this.mWl.getHeight() / 2);
                }
                float x = (this.mWl.getX() + rawX) - this.mLastX;
                if (x < this.mWC - (this.mWl.getWidth() / 2)) {
                    x = this.mWC - (this.mWl.getWidth() / 2);
                } else if (x > ((this.mWC + this.mVideoWidth) - this.mWl.getWidth()) + (this.mWl.getWidth() / 2)) {
                    x = ((this.mWC + this.mVideoWidth) - this.mWl.getWidth()) + (this.mWl.getWidth() / 2);
                }
                this.mWl.setX(x);
                this.mWl.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.mWo.getTextSize() != f) {
            this.mWo.setTextSize(i, f);
        }
        if (this.mWn.getTextSize() != f) {
            this.mWn.setTextSize(i, f);
        }
    }

    private float af(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.mWl.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ag(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.mWy - motionEvent.getRawY(), this.mWx - motionEvent.getRawX()));
    }

    private float ah(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.ibo && Math.abs(motionEvent.getRawY() - this.cif) < this.ibo;
    }

    private void init() {
        this.mWm = (RotateFrameLayout) this.mWl.findViewById(R.id.content_container);
        this.mWn = (TextView) this.mWl.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.mWl.findViewById(R.id.content_view);
        this.mWo = (EditText) this.mWl.findViewById(R.id.cover_edit);
        this.mWp = (ImageView) this.mWl.findViewById(R.id.cover_delete);
        this.mWq = (ImageView) this.mWl.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.mWn.setText(this.mWo.getText());
        this.mWn.setVisibility(0);
        this.mWo.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.mWn.getText())) {
            this.mWr = 0;
            this.mWl.setVisibility(8);
        }
        if (this.mWr == 4) {
            dJH();
        }
        this.mWB.HidenSoftKeyPad(this.mWo);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.mWo.setFocusable(true);
            this.mWo.setFocusableInTouchMode(true);
            this.mWo.requestFocus();
            return;
        }
        this.mWo.setFocusable(false);
        this.mWo.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.mWo.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Ml();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Ml();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Ml();
                    break;
                default:
                    hideSoftKeyPad();
                    String SX = com.baidu.tieba.video.editvideo.model.b.dJC().SX(pendantData.resource);
                    if (TextUtils.isEmpty(SX)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mVl.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dJC().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(SX, pendantData);
                        break;
                    }
                    break;
            }
            this.mWr = pendantData.pendantType;
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
        dJH();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.mWr == 4 || this.mWr == 0) {
            this.mWl.setX(this.mWC);
            this.mWl.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mWD);
            String obj = this.mWo.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.mWo.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.mWn.setText(a2);
                    this.mWo.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dJH() {
        if (this.mWG) {
            this.mWG = false;
            this.mWp.setVisibility(8);
            this.mWq.setVisibility(8);
            this.mWm.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJI() {
        if (!this.mWG) {
            this.mWG = true;
            this.mWp.setVisibility(0);
            this.mWq.setVisibility(0);
            this.mWm.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mWS != null) {
            Bitmap bitmap = this.mWS.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mWS.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dJH();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.mWA = 1.0f;
                this.meN = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.mWA = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.mWv = (this.mWL * 2) + width;
                this.mWw = (this.mWL * 2) + height;
                this.mWz = (this.mWv * 1.0f) / this.mWw;
                this.mWl.setX((((this.mVideoWidth - i2) - (this.mWL * 2)) / 2) + this.mWC);
                this.mWl.setY((((this.mVideoHeight - i) - (this.mWL * 2)) / 2) + this.mWD);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bjr = motionEvent.getRawX();
                this.bjs = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bjr);
                float abs2 = Math.abs(rawY - this.bjs);
                if (motionEvent.getPointerCount() <= 1 && abs < this.ibo && abs2 < this.ibo && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.mWn == null || this.mWn.getText() == null) {
            return null;
        }
        return this.mWn.getText().toString();
    }

    public void Ml() {
        this.mWn.setText(this.mWo.getText());
        this.mWn.setVisibility(8);
        this.mWo.setVisibility(0);
        setEditTextEnable(true);
        this.mWB.ShowSoftKeyPad(this.mWo);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.mWo.setTextAppearance(getContext(), R.style.cover_text_style);
            this.mWn.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mWL = 0;
            this.mWo.setMaxLines(1);
            this.mWn.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWn.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.mWo.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.mWo.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mWn.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mWL = l.getDimens(getContext(), R.dimen.ds40);
            this.mWo.setMaxLines(2);
            this.mWn.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mWn.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.mWo.setLayoutParams(layoutParams2);
            this.mWH = (int) (l.dip2px(getContext(), pendantData.left) * this.mWA);
            this.mWI = (int) (l.dip2px(getContext(), pendantData.top) * this.mWA);
            this.mWJ = (int) (l.dip2px(getContext(), pendantData.right) * this.mWA);
            this.mWK = (int) (l.dip2px(getContext(), pendantData.bottom) * this.mWA);
            this.mContentView.setPadding(this.mWH, this.mWI, this.mWJ, this.mWK);
            this.bvn = l.getDimens(getContext(), R.dimen.fontsize40) * this.mWA;
            String text = getText();
            this.mWN = (i2 - this.mWI) - this.mWK;
            this.mWO = (i - this.mWH) - this.mWJ;
            this.mWQ = this.mWP + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bvn);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mWO);
                this.bvn = this.mWo.getTextSize();
                dJI();
                Ml();
            } else {
                if (af.getTextLengthAllOne(text) > 20) {
                    text = af.subStringWithAllOne(text, 20);
                    this.mWo.setText(text);
                    this.mWn.setText(text);
                }
                SZ(text);
            }
        }
        this.mWn.setIncludeFontPadding(false);
        this.mWo.setIncludeFontPadding(false);
        this.mWn.setLineSpacing(this.mWP, 1.0f);
        this.mWo.setLineSpacing(this.mWP, 1.0f);
        this.mWl.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mWl.getLayoutParams();
        layoutParams3.height = (this.mWL * 2) + i2;
        layoutParams3.width = (this.mWL * 2) + i;
        this.mWl.setLayoutParams(layoutParams3);
        this.mWR = (this.mWL * 2) + i;
        ((FrameLayout.LayoutParams) this.mWm.getLayoutParams()).setMargins(this.mWL, this.mWL, this.mWL, this.mWL);
        this.mWl.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mWT == null) {
            dJJ();
        }
        return this.mWT;
    }

    private void dJJ() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mWT = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dJK() {
        if (this.mWT != null && !this.mWT.isRecycled()) {
            this.mWT.recycle();
            this.mWT = null;
        }
    }

    public void xu(boolean z) {
        if (this.mWr != 0) {
            if (z) {
                dJK();
                this.mWl.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.mWl.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mWS.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mWS.clear();
        this.mWS = null;
        dJK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a implements b.a {
        WeakReference<a.b> mWV;
        WeakReference<CoverPendantDragView> mWW;
        WeakReference<PendantData> mWX;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mWV = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mWW = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mWX = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gr(String str, String str2) {
            if (this.mWV != null && this.mWV.get() != null) {
                this.mWV.get().mVl.setVisibility(8);
            }
            if (this.mWW != null && this.mWW.get() != null && this.mWX != null && this.mWX.get() != null) {
                this.mWW.get().a(str2, this.mWX.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void SQ(String str) {
            if (this.mWV != null && this.mWV.get() != null) {
                this.mWV.get().mVl.setVisibility(8);
            }
            if (this.mWW != null && this.mWW.get() != null) {
                l.showToast(this.mWW.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dIT() {
            if (this.mWV != null && this.mWV.get() != null) {
                this.mWV.get().mVl.setVisibility(8);
            }
        }
    }
}
