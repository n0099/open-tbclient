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
    private float bon;
    private float hFm;
    private float lGo;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private ImageView mwA;
    private int mwB;
    private boolean mwC;
    private float mwD;
    private float mwE;
    private int mwF;
    private int mwG;
    private float mwH;
    private float mwI;
    private float mwJ;
    private float mwK;
    private c mwL;
    private float mwM;
    private float mwN;
    private float mwO;
    private float mwP;
    private boolean mwQ;
    private int mwR;
    private int mwS;
    private int mwT;
    private int mwU;
    private int mwV;
    private float mwW;
    private float mwX;
    private int mwY;
    private float mwZ;
    private FrameLayout mwv;
    private RotateFrameLayout mww;
    private TextView mwx;
    private EditText mwy;
    private ImageView mwz;
    private int mxa;
    private Map<String, Bitmap> mxb;
    private Bitmap mxc;
    float mxd;
    float mxe;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mwB = 0;
        this.mwK = 1.0f;
        this.lGo = 1.0f;
        this.mwQ = true;
        this.mxb = new HashMap();
        this.startTime = 0L;
        this.mxd = 0.0f;
        this.mxe = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bon = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mwY = l.getDimens(getContext(), R.dimen.ds2);
        this.hFm = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mwv = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.mwv);
        this.mwv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.mwB == 4) {
                            CoverPendantDragView.this.dBT();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.mwC && abs < CoverPendantDragView.this.hFm && abs2 < CoverPendantDragView.this.hFm && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Kz();
                        }
                        CoverPendantDragView.this.mwD = 0.0f;
                        CoverPendantDragView.this.mwE = 0.0f;
                        CoverPendantDragView.this.mwC = false;
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
                        CoverPendantDragView.this.mwD = 0.0f;
                        CoverPendantDragView.this.mwE = 0.0f;
                        return true;
                }
            }
        });
        this.mwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.mwy.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.mwA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.mwE = 0.0f;
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
        this.mwy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.mwB != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.mwx.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.mwx.getText().length()) {
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
                CoverPendantDragView.this.mwx.setText(editable.toString());
            }
        });
        this.mwy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.mwv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.mDownY;
        this.mwH = (this.mwv.getWidth() / 2) + this.mwv.getX();
        this.mwI = (this.mwv.getHeight() / 2) + this.mwv.getY();
        this.mwx.setText(this.mwy.getText());
        this.mwx.setVisibility(0);
        this.mwy.setVisibility(8);
        setEditTextEnable(false);
        this.mwL.HidenSoftKeyPad(this.mwy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RK(String str) {
        TextPaint paint = this.mwy.getPaint();
        float measureText = paint.measureText(str);
        while (this.mwy.getLineCount() == 1 && this.mwy.getTextSize() < this.bon * this.lGo && measureText < this.mwX * this.lGo) {
            setTextSize(0, this.mwy.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.mwy.getTextSize() != this.bon * this.lGo) {
            setTextSize(0, this.bon * this.lGo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RL(String str) {
        TextPaint paint = this.mwy.getPaint();
        float measureText = paint.measureText(str);
        while (this.mwy.getTextSize() > ((this.mwW * this.lGo) / 2.0f) - (this.mwZ * this.lGo) && measureText > this.mwX * this.lGo) {
            setTextSize(0, this.mwy.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.mwy.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.mwy.getTextSize() - 1.0f);
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
        this.mwL = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mwM = f;
        this.mwN = f2;
        this.mwO = f3;
        this.mwP = f4;
        if (this.mwM > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mwM, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mwN > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mwN);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mwO > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mwO) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mwP > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mwP) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.mwH - rawX);
        float abs4 = Math.abs(this.mwI - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.mwH - this.mLastX);
        float abs6 = Math.abs(this.mwI - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dq(sqrt, (int) (sqrt / this.mwJ));
        if (this.mwE != 0.0f) {
            this.mwv.setRotation(this.mwv.getRotation() - (this.mwE - ag));
        }
        this.mwE = ag;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dq(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mwv.getLayoutParams();
        int width = this.mwv.getWidth() - i;
        int i3 = (int) (width / this.mwJ);
        if (width < this.mwF) {
            width = this.mwF;
            i3 = (int) (width / this.mwJ);
        }
        this.lGo = ((width * 1.0f) - (this.mwV * 2)) / (this.mxa - (this.mwV * 2));
        this.mContentView.setPadding((int) (this.mwR * this.lGo), (int) (this.mwS * this.lGo), (int) (this.mwT * this.lGo), (int) (this.mwU * this.lGo));
        setTextSize(0, (this.mwy.getTextSize() * i3) / this.mwv.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.mwv.setLayoutParams(layoutParams);
        float f = this.mwH - (layoutParams.width / 2);
        float f2 = this.mwI - (layoutParams.height / 2);
        this.mwv.setX(f);
        this.mwv.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.mwB != 4) {
            float y = (this.mwv.getY() + rawY) - this.mLastY;
            if (y < this.mwN) {
                y = this.mwN;
            } else if (y > (this.mwN + this.mVideoHeight) - this.mwv.getHeight()) {
                y = (this.mwN + this.mVideoHeight) - this.mwv.getHeight();
            }
            this.mwv.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.mwC = true;
                float ah = ah(motionEvent);
                float af = af(motionEvent);
                if (this.mwD != 0.0f) {
                    int i = (int) (this.mwD - ah);
                    dq(i, (int) (i / this.mwJ));
                }
                if (this.mwE != 0.0f) {
                    this.mwv.setRotation(this.mwv.getRotation() - (this.mwE - af));
                }
                this.mwE = af;
                this.mwD = ah;
            } else if (!this.mwC && pointerCount == 1) {
                float y2 = (this.mwv.getY() + rawY) - this.mLastY;
                if (y2 < this.mwN - (this.mwv.getHeight() / 2)) {
                    y2 = this.mwN - (this.mwv.getHeight() / 2);
                } else if (y2 > ((this.mwN + this.mVideoHeight) - this.mwv.getHeight()) + (this.mwv.getHeight() / 2)) {
                    y2 = ((this.mwN + this.mVideoHeight) - this.mwv.getHeight()) + (this.mwv.getHeight() / 2);
                }
                float x = (this.mwv.getX() + rawX) - this.mLastX;
                if (x < this.mwM - (this.mwv.getWidth() / 2)) {
                    x = this.mwM - (this.mwv.getWidth() / 2);
                } else if (x > ((this.mwM + this.mVideoWidth) - this.mwv.getWidth()) + (this.mwv.getWidth() / 2)) {
                    x = ((this.mwM + this.mVideoWidth) - this.mwv.getWidth()) + (this.mwv.getWidth() / 2);
                }
                this.mwv.setX(x);
                this.mwv.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.mwy.getTextSize() != f) {
            this.mwy.setTextSize(i, f);
        }
        if (this.mwx.getTextSize() != f) {
            this.mwx.setTextSize(i, f);
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
        matrix.postRotate(this.mwv.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ag(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.mwI - motionEvent.getRawY(), this.mwH - motionEvent.getRawX()));
    }

    private float ah(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hFm && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hFm;
    }

    private void init() {
        this.mww = (RotateFrameLayout) this.mwv.findViewById(R.id.content_container);
        this.mwx = (TextView) this.mwv.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.mwv.findViewById(R.id.content_view);
        this.mwy = (EditText) this.mwv.findViewById(R.id.cover_edit);
        this.mwz = (ImageView) this.mwv.findViewById(R.id.cover_delete);
        this.mwA = (ImageView) this.mwv.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.mwx.setText(this.mwy.getText());
        this.mwx.setVisibility(0);
        this.mwy.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.mwx.getText())) {
            this.mwB = 0;
            this.mwv.setVisibility(8);
        }
        if (this.mwB == 4) {
            dBS();
        }
        this.mwL.HidenSoftKeyPad(this.mwy);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.mwy.setFocusable(true);
            this.mwy.setFocusableInTouchMode(true);
            this.mwy.requestFocus();
            return;
        }
        this.mwy.setFocusable(false);
        this.mwy.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.mwy.setText("");
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
                    String RJ = com.baidu.tieba.video.editvideo.model.b.dBN().RJ(pendantData.resource);
                    if (TextUtils.isEmpty(RJ)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mvu.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dBN().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(RJ, pendantData);
                        break;
                    }
                    break;
            }
            this.mwB = pendantData.pendantType;
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
        dBS();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.mwB == 4 || this.mwB == 0) {
            this.mwv.setX(this.mwM);
            this.mwv.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mwN);
            String obj = this.mwy.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.mwy.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.mwx.setText(a2);
                    this.mwy.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dBS() {
        if (this.mwQ) {
            this.mwQ = false;
            this.mwz.setVisibility(8);
            this.mwA.setVisibility(8);
            this.mww.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBT() {
        if (!this.mwQ) {
            this.mwQ = true;
            this.mwz.setVisibility(0);
            this.mwA.setVisibility(0);
            this.mww.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mxb != null) {
            Bitmap bitmap = this.mxb.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mxb.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dBS();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.mwK = 1.0f;
                this.lGo = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.mwK = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.mwF = (this.mwV * 2) + width;
                this.mwG = (this.mwV * 2) + height;
                this.mwJ = (this.mwF * 1.0f) / this.mwG;
                this.mwv.setX((((this.mVideoWidth - i2) - (this.mwV * 2)) / 2) + this.mwM);
                this.mwv.setY((((this.mVideoHeight - i) - (this.mwV * 2)) / 2) + this.mwN);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.mxd = motionEvent.getRawX();
                this.mxe = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.mxd);
                float abs2 = Math.abs(rawY - this.mxe);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hFm && abs2 < this.hFm && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.mwx == null || this.mwx.getText() == null) {
            return null;
        }
        return this.mwx.getText().toString();
    }

    public void Kz() {
        this.mwx.setText(this.mwy.getText());
        this.mwx.setVisibility(8);
        this.mwy.setVisibility(0);
        setEditTextEnable(true);
        this.mwL.ShowSoftKeyPad(this.mwy);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.mwy.setTextAppearance(getContext(), R.style.cover_text_style);
            this.mwx.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mwV = 0;
            this.mwy.setMaxLines(1);
            this.mwx.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mwx.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.mwy.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.mwy.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mwx.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mwV = l.getDimens(getContext(), R.dimen.ds40);
            this.mwy.setMaxLines(2);
            this.mwx.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mwx.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.mwy.setLayoutParams(layoutParams2);
            this.mwR = (int) (l.dip2px(getContext(), pendantData.left) * this.mwK);
            this.mwS = (int) (l.dip2px(getContext(), pendantData.top) * this.mwK);
            this.mwT = (int) (l.dip2px(getContext(), pendantData.right) * this.mwK);
            this.mwU = (int) (l.dip2px(getContext(), pendantData.bottom) * this.mwK);
            this.mContentView.setPadding(this.mwR, this.mwS, this.mwT, this.mwU);
            this.bon = l.getDimens(getContext(), R.dimen.fontsize40) * this.mwK;
            String text = getText();
            this.mwW = (i2 - this.mwS) - this.mwU;
            this.mwX = (i - this.mwR) - this.mwT;
            this.mwZ = this.mwY + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bon);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mwX);
                this.bon = this.mwy.getTextSize();
                dBT();
                Kz();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.mwy.setText(text);
                    this.mwx.setText(text);
                }
                RL(text);
            }
        }
        this.mwx.setIncludeFontPadding(false);
        this.mwy.setIncludeFontPadding(false);
        this.mwx.setLineSpacing(this.mwY, 1.0f);
        this.mwy.setLineSpacing(this.mwY, 1.0f);
        this.mwv.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mwv.getLayoutParams();
        layoutParams3.height = (this.mwV * 2) + i2;
        layoutParams3.width = (this.mwV * 2) + i;
        this.mwv.setLayoutParams(layoutParams3);
        this.mxa = (this.mwV * 2) + i;
        ((FrameLayout.LayoutParams) this.mww.getLayoutParams()).setMargins(this.mwV, this.mwV, this.mwV, this.mwV);
        this.mwv.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mxc == null) {
            dBU();
        }
        return this.mxc;
    }

    private void dBU() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mxc = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dBV() {
        if (this.mxc != null && !this.mxc.isRecycled()) {
            this.mxc.recycle();
            this.mxc = null;
        }
    }

    public void wC(boolean z) {
        if (this.mwB != 0) {
            if (z) {
                dBV();
                this.mwv.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.mwv.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mxb.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mxb.clear();
        this.mxb = null;
        dBV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a implements b.a {
        WeakReference<a.b> mxg;
        WeakReference<CoverPendantDragView> mxh;
        WeakReference<PendantData> mxi;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mxg = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mxh = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mxi = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fX(String str, String str2) {
            if (this.mxg != null && this.mxg.get() != null) {
                this.mxg.get().mvu.setVisibility(8);
            }
            if (this.mxh != null && this.mxh.get() != null && this.mxi != null && this.mxi.get() != null) {
                this.mxh.get().a(str2, this.mxi.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void RC(String str) {
            if (this.mxg != null && this.mxg.get() != null) {
                this.mxg.get().mvu.setVisibility(8);
            }
            if (this.mxh != null && this.mxh.get() != null) {
                l.showToast(this.mxh.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dBe() {
            if (this.mxg != null && this.mxg.get() != null) {
                this.mxg.get().mvu.setVisibility(8);
            }
        }
    }
}
