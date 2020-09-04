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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes17.dex */
public class CoverPendantDragView extends FrameLayout {
    private float boq;
    private float hFs;
    private float lGB;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout mwN;
    private RotateFrameLayout mwO;
    private TextView mwP;
    private EditText mwQ;
    private ImageView mwR;
    private ImageView mwS;
    private int mwT;
    private boolean mwU;
    private float mwV;
    private float mwW;
    private int mwX;
    private int mwY;
    private float mwZ;
    private float mxa;
    private float mxb;
    private float mxc;
    private c mxd;
    private float mxe;
    private float mxf;
    private float mxg;
    private float mxh;
    private boolean mxi;
    private int mxj;
    private int mxk;
    private int mxl;
    private int mxm;
    private int mxn;
    private float mxo;
    private float mxp;
    private int mxq;
    private float mxr;
    private int mxs;
    private Map<String, Bitmap> mxt;
    private Bitmap mxu;
    float mxv;
    float mxw;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mwT = 0;
        this.mxc = 1.0f;
        this.lGB = 1.0f;
        this.mxi = true;
        this.mxt = new HashMap();
        this.startTime = 0L;
        this.mxv = 0.0f;
        this.mxw = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.boq = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mxq = l.getDimens(getContext(), R.dimen.ds2);
        this.hFs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mwN = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.mwN);
        this.mwN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.mwT == 4) {
                            CoverPendantDragView.this.dCc();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.mwU && abs < CoverPendantDragView.this.hFs && abs2 < CoverPendantDragView.this.hFs && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Kz();
                        }
                        CoverPendantDragView.this.mwV = 0.0f;
                        CoverPendantDragView.this.mwW = 0.0f;
                        CoverPendantDragView.this.mwU = false;
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
                        CoverPendantDragView.this.mwV = 0.0f;
                        CoverPendantDragView.this.mwW = 0.0f;
                        return true;
                }
            }
        });
        this.mwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.mwQ.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.mwS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.mwW = 0.0f;
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
        this.mwQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.mwT != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.mwP.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.mwP.getText().length()) {
                        CoverPendantDragView.this.RL(obj);
                    } else {
                        CoverPendantDragView.this.RK(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.RL(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.mwP.setText(editable.toString());
            }
        });
        this.mwQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.mwN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.mDownY;
        this.mwZ = (this.mwN.getWidth() / 2) + this.mwN.getX();
        this.mxa = (this.mwN.getHeight() / 2) + this.mwN.getY();
        this.mwP.setText(this.mwQ.getText());
        this.mwP.setVisibility(0);
        this.mwQ.setVisibility(8);
        setEditTextEnable(false);
        this.mxd.HidenSoftKeyPad(this.mwQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RK(String str) {
        TextPaint paint = this.mwQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.mwQ.getLineCount() == 1 && this.mwQ.getTextSize() < this.boq * this.lGB && measureText < this.mxp * this.lGB) {
            setTextSize(0, this.mwQ.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.mwQ.getTextSize() != this.boq * this.lGB) {
            setTextSize(0, this.boq * this.lGB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RL(String str) {
        TextPaint paint = this.mwQ.getPaint();
        float measureText = paint.measureText(str);
        while (this.mwQ.getTextSize() > ((this.mxo * this.lGB) / 2.0f) - (this.mxr * this.lGB) && measureText > this.mxp * this.lGB) {
            setTextSize(0, this.mwQ.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.mwQ.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.mwQ.getTextSize() - 1.0f);
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
        this.mxd = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mxe = f;
        this.mxf = f2;
        this.mxg = f3;
        this.mxh = f4;
        if (this.mxe > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mxe, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mxf > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mxf);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mxg > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mxg) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mxh > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mxh) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.mwZ - rawX);
        float abs4 = Math.abs(this.mxa - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.mwZ - this.mLastX);
        float abs6 = Math.abs(this.mxa - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dq(sqrt, (int) (sqrt / this.mxb));
        if (this.mwW != 0.0f) {
            this.mwN.setRotation(this.mwN.getRotation() - (this.mwW - ag));
        }
        this.mwW = ag;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dq(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mwN.getLayoutParams();
        int width = this.mwN.getWidth() - i;
        int i3 = (int) (width / this.mxb);
        if (width < this.mwX) {
            width = this.mwX;
            i3 = (int) (width / this.mxb);
        }
        this.lGB = ((width * 1.0f) - (this.mxn * 2)) / (this.mxs - (this.mxn * 2));
        this.mContentView.setPadding((int) (this.mxj * this.lGB), (int) (this.mxk * this.lGB), (int) (this.mxl * this.lGB), (int) (this.mxm * this.lGB));
        setTextSize(0, (this.mwQ.getTextSize() * i3) / this.mwN.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.mwN.setLayoutParams(layoutParams);
        float f = this.mwZ - (layoutParams.width / 2);
        float f2 = this.mxa - (layoutParams.height / 2);
        this.mwN.setX(f);
        this.mwN.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.mwT != 4) {
            float y = (this.mwN.getY() + rawY) - this.mLastY;
            if (y < this.mxf) {
                y = this.mxf;
            } else if (y > (this.mxf + this.mVideoHeight) - this.mwN.getHeight()) {
                y = (this.mxf + this.mVideoHeight) - this.mwN.getHeight();
            }
            this.mwN.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.mwU = true;
                float ah = ah(motionEvent);
                float af = af(motionEvent);
                if (this.mwV != 0.0f) {
                    int i = (int) (this.mwV - ah);
                    dq(i, (int) (i / this.mxb));
                }
                if (this.mwW != 0.0f) {
                    this.mwN.setRotation(this.mwN.getRotation() - (this.mwW - af));
                }
                this.mwW = af;
                this.mwV = ah;
            } else if (!this.mwU && pointerCount == 1) {
                float y2 = (this.mwN.getY() + rawY) - this.mLastY;
                if (y2 < this.mxf - (this.mwN.getHeight() / 2)) {
                    y2 = this.mxf - (this.mwN.getHeight() / 2);
                } else if (y2 > ((this.mxf + this.mVideoHeight) - this.mwN.getHeight()) + (this.mwN.getHeight() / 2)) {
                    y2 = ((this.mxf + this.mVideoHeight) - this.mwN.getHeight()) + (this.mwN.getHeight() / 2);
                }
                float x = (this.mwN.getX() + rawX) - this.mLastX;
                if (x < this.mxe - (this.mwN.getWidth() / 2)) {
                    x = this.mxe - (this.mwN.getWidth() / 2);
                } else if (x > ((this.mxe + this.mVideoWidth) - this.mwN.getWidth()) + (this.mwN.getWidth() / 2)) {
                    x = ((this.mxe + this.mVideoWidth) - this.mwN.getWidth()) + (this.mwN.getWidth() / 2);
                }
                this.mwN.setX(x);
                this.mwN.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.mwQ.getTextSize() != f) {
            this.mwQ.setTextSize(i, f);
        }
        if (this.mwP.getTextSize() != f) {
            this.mwP.setTextSize(i, f);
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
        matrix.postRotate(this.mwN.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ag(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.mxa - motionEvent.getRawY(), this.mwZ - motionEvent.getRawX()));
    }

    private float ah(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hFs && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hFs;
    }

    private void init() {
        this.mwO = (RotateFrameLayout) this.mwN.findViewById(R.id.content_container);
        this.mwP = (TextView) this.mwN.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.mwN.findViewById(R.id.content_view);
        this.mwQ = (EditText) this.mwN.findViewById(R.id.cover_edit);
        this.mwR = (ImageView) this.mwN.findViewById(R.id.cover_delete);
        this.mwS = (ImageView) this.mwN.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.mwP.setText(this.mwQ.getText());
        this.mwP.setVisibility(0);
        this.mwQ.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.mwP.getText())) {
            this.mwT = 0;
            this.mwN.setVisibility(8);
        }
        if (this.mwT == 4) {
            dCb();
        }
        this.mxd.HidenSoftKeyPad(this.mwQ);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.mwQ.setFocusable(true);
            this.mwQ.setFocusableInTouchMode(true);
            this.mwQ.requestFocus();
            return;
        }
        this.mwQ.setFocusable(false);
        this.mwQ.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.mwQ.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Kz();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Kz();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Kz();
                    break;
                default:
                    hideSoftKeyPad();
                    String RJ = com.baidu.tieba.video.editvideo.model.b.dBW().RJ(pendantData.resource);
                    if (TextUtils.isEmpty(RJ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mvM.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dBW().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(RJ, pendantData);
                        break;
                    }
                    break;
            }
            this.mwT = pendantData.pendantType;
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
        dCb();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.mwT == 4 || this.mwT == 0) {
            this.mwN.setX(this.mxe);
            this.mwN.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mxf);
            String obj = this.mwQ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.mwQ.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.mwP.setText(a2);
                    this.mwQ.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dCb() {
        if (this.mxi) {
            this.mxi = false;
            this.mwR.setVisibility(8);
            this.mwS.setVisibility(8);
            this.mwO.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCc() {
        if (!this.mxi) {
            this.mxi = true;
            this.mwR.setVisibility(0);
            this.mwS.setVisibility(0);
            this.mwO.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mxt != null) {
            Bitmap bitmap = this.mxt.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mxt.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dCb();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.mxc = 1.0f;
                this.lGB = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.mxc = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.mwX = (this.mxn * 2) + width;
                this.mwY = (this.mxn * 2) + height;
                this.mxb = (this.mwX * 1.0f) / this.mwY;
                this.mwN.setX((((this.mVideoWidth - i2) - (this.mxn * 2)) / 2) + this.mxe);
                this.mwN.setY((((this.mVideoHeight - i) - (this.mxn * 2)) / 2) + this.mxf);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.mxv = motionEvent.getRawX();
                this.mxw = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.mxv);
                float abs2 = Math.abs(rawY - this.mxw);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hFs && abs2 < this.hFs && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.mwP == null || this.mwP.getText() == null) {
            return null;
        }
        return this.mwP.getText().toString();
    }

    public void Kz() {
        this.mwP.setText(this.mwQ.getText());
        this.mwP.setVisibility(8);
        this.mwQ.setVisibility(0);
        setEditTextEnable(true);
        this.mxd.ShowSoftKeyPad(this.mwQ);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.mwQ.setTextAppearance(getContext(), R.style.cover_text_style);
            this.mwP.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mxn = 0;
            this.mwQ.setMaxLines(1);
            this.mwP.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mwP.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.mwQ.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.mwQ.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mwP.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mxn = l.getDimens(getContext(), R.dimen.ds40);
            this.mwQ.setMaxLines(2);
            this.mwP.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mwP.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.mwQ.setLayoutParams(layoutParams2);
            this.mxj = (int) (l.dip2px(getContext(), pendantData.left) * this.mxc);
            this.mxk = (int) (l.dip2px(getContext(), pendantData.top) * this.mxc);
            this.mxl = (int) (l.dip2px(getContext(), pendantData.right) * this.mxc);
            this.mxm = (int) (l.dip2px(getContext(), pendantData.bottom) * this.mxc);
            this.mContentView.setPadding(this.mxj, this.mxk, this.mxl, this.mxm);
            this.boq = l.getDimens(getContext(), R.dimen.fontsize40) * this.mxc;
            String text = getText();
            this.mxo = (i2 - this.mxk) - this.mxm;
            this.mxp = (i - this.mxj) - this.mxl;
            this.mxr = this.mxq + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.boq);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mxp);
                this.boq = this.mwQ.getTextSize();
                dCc();
                Kz();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.mwQ.setText(text);
                    this.mwP.setText(text);
                }
                RL(text);
            }
        }
        this.mwP.setIncludeFontPadding(false);
        this.mwQ.setIncludeFontPadding(false);
        this.mwP.setLineSpacing(this.mxq, 1.0f);
        this.mwQ.setLineSpacing(this.mxq, 1.0f);
        this.mwN.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mwN.getLayoutParams();
        layoutParams3.height = (this.mxn * 2) + i2;
        layoutParams3.width = (this.mxn * 2) + i;
        this.mwN.setLayoutParams(layoutParams3);
        this.mxs = (this.mxn * 2) + i;
        ((FrameLayout.LayoutParams) this.mwO.getLayoutParams()).setMargins(this.mxn, this.mxn, this.mxn, this.mxn);
        this.mwN.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mxu == null) {
            dCd();
        }
        return this.mxu;
    }

    private void dCd() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mxu = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dCe() {
        if (this.mxu != null && !this.mxu.isRecycled()) {
            this.mxu.recycle();
            this.mxu = null;
        }
    }

    public void wE(boolean z) {
        if (this.mwT != 0) {
            if (z) {
                dCe();
                this.mwN.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.mwN.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mxt.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mxt.clear();
        this.mxt = null;
        dCe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a implements b.a {
        WeakReference<PendantData> mxA;
        WeakReference<a.b> mxy;
        WeakReference<CoverPendantDragView> mxz;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mxy = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mxz = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mxA = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fY(String str, String str2) {
            if (this.mxy != null && this.mxy.get() != null) {
                this.mxy.get().mvM.setVisibility(8);
            }
            if (this.mxz != null && this.mxz.get() != null && this.mxA != null && this.mxA.get() != null) {
                this.mxz.get().a(str2, this.mxA.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void RC(String str) {
            if (this.mxy != null && this.mxy.get() != null) {
                this.mxy.get().mvM.setVisibility(8);
            }
            if (this.mxz != null && this.mxz.get() != null) {
                l.showToast(this.mxz.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dBn() {
            if (this.mxy != null && this.mxy.get() != null) {
                this.mxy.get().mvM.setVisibility(8);
            }
        }
    }
}
