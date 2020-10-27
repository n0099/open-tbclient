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
    float bkM;
    float bkN;
    private float bxB;
    private float cqF;
    private float inQ;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mrl;
    private FrameLayout niM;
    private RotateFrameLayout niN;
    private TextView niO;
    private EditText niP;
    private ImageView niQ;
    private ImageView niR;
    private int niS;
    private boolean niT;
    private float niU;
    private float niV;
    private int niW;
    private int niX;
    private float niY;
    private float niZ;
    private float nja;
    private float njb;
    private c njc;
    private float njd;
    private float nje;
    private float njf;
    private float njg;
    private boolean njh;
    private int nji;
    private int njj;
    private int njk;
    private int njl;
    private int njm;
    private float njn;
    private float njo;
    private int njp;
    private float njq;
    private int njr;
    private Map<String, Bitmap> njs;
    private Bitmap njt;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.niS = 0;
        this.njb = 1.0f;
        this.mrl = 1.0f;
        this.njh = true;
        this.njs = new HashMap();
        this.startTime = 0L;
        this.bkM = 0.0f;
        this.bkN = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bxB = l.getDimens(getContext(), R.dimen.fontsize40);
        this.njp = l.getDimens(getContext(), R.dimen.ds2);
        this.inQ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.niM = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.niM);
        this.niM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.niS == 4) {
                            CoverPendantDragView.this.dMQ();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cqF);
                        if (!CoverPendantDragView.this.niT && abs < CoverPendantDragView.this.inQ && abs2 < CoverPendantDragView.this.inQ && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.MF();
                        }
                        CoverPendantDragView.this.niU = 0.0f;
                        CoverPendantDragView.this.niV = 0.0f;
                        CoverPendantDragView.this.niT = false;
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
                        CoverPendantDragView.this.niU = 0.0f;
                        CoverPendantDragView.this.niV = 0.0f;
                        return true;
                }
            }
        });
        this.niQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.niP.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.niR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.niV = 0.0f;
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
        this.niP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.niS != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.niO.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (af.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.niO.getText().length()) {
                        CoverPendantDragView.this.Ty(obj);
                    } else {
                        CoverPendantDragView.this.Tx(obj);
                    }
                } else {
                    String subStringWithAllOne = af.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Ty(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.niO.setText(editable.toString());
            }
        });
        this.niP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.niM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cqF = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cqF;
        this.niY = (this.niM.getWidth() / 2) + this.niM.getX();
        this.niZ = (this.niM.getHeight() / 2) + this.niM.getY();
        this.niO.setText(this.niP.getText());
        this.niO.setVisibility(0);
        this.niP.setVisibility(8);
        setEditTextEnable(false);
        this.njc.HidenSoftKeyPad(this.niP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tx(String str) {
        TextPaint paint = this.niP.getPaint();
        float measureText = paint.measureText(str);
        while (this.niP.getLineCount() == 1 && this.niP.getTextSize() < this.bxB * this.mrl && measureText < this.njo * this.mrl) {
            setTextSize(0, this.niP.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (af.getTextLengthAllOne(str) <= af.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.niP.getTextSize() != this.bxB * this.mrl) {
            setTextSize(0, this.bxB * this.mrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ty(String str) {
        TextPaint paint = this.niP.getPaint();
        float measureText = paint.measureText(str);
        while (this.niP.getTextSize() > ((this.njn * this.mrl) / 2.0f) - (this.njq * this.mrl) && measureText > this.njo * this.mrl) {
            setTextSize(0, this.niP.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.niP.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.niP.getTextSize() - 1.0f);
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
        this.njc = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.njd = f;
        this.nje = f2;
        this.njf = f3;
        this.njg = f4;
        if (this.njd > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.njd, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nje > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nje);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.njf > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.njf) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.njg > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.njg) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.niY - rawX);
        float abs4 = Math.abs(this.niZ - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.niY - this.mLastX);
        float abs6 = Math.abs(this.niZ - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dw(sqrt, (int) (sqrt / this.nja));
        if (this.niV != 0.0f) {
            this.niM.setRotation(this.niM.getRotation() - (this.niV - ag));
        }
        this.niV = ag;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dw(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.niM.getLayoutParams();
        int width = this.niM.getWidth() - i;
        int i3 = (int) (width / this.nja);
        if (width < this.niW) {
            width = this.niW;
            i3 = (int) (width / this.nja);
        }
        this.mrl = ((width * 1.0f) - (this.njm * 2)) / (this.njr - (this.njm * 2));
        this.mContentView.setPadding((int) (this.nji * this.mrl), (int) (this.njj * this.mrl), (int) (this.njk * this.mrl), (int) (this.njl * this.mrl));
        setTextSize(0, (this.niP.getTextSize() * i3) / this.niM.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.niM.setLayoutParams(layoutParams);
        float f = this.niY - (layoutParams.width / 2);
        float f2 = this.niZ - (layoutParams.height / 2);
        this.niM.setX(f);
        this.niM.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.niS != 4) {
            float y = (this.niM.getY() + rawY) - this.mLastY;
            if (y < this.nje) {
                y = this.nje;
            } else if (y > (this.nje + this.mVideoHeight) - this.niM.getHeight()) {
                y = (this.nje + this.mVideoHeight) - this.niM.getHeight();
            }
            this.niM.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.niT = true;
                float ah = ah(motionEvent);
                float af = af(motionEvent);
                if (this.niU != 0.0f) {
                    int i = (int) (this.niU - ah);
                    dw(i, (int) (i / this.nja));
                }
                if (this.niV != 0.0f) {
                    this.niM.setRotation(this.niM.getRotation() - (this.niV - af));
                }
                this.niV = af;
                this.niU = ah;
            } else if (!this.niT && pointerCount == 1) {
                float y2 = (this.niM.getY() + rawY) - this.mLastY;
                if (y2 < this.nje - (this.niM.getHeight() / 2)) {
                    y2 = this.nje - (this.niM.getHeight() / 2);
                } else if (y2 > ((this.nje + this.mVideoHeight) - this.niM.getHeight()) + (this.niM.getHeight() / 2)) {
                    y2 = ((this.nje + this.mVideoHeight) - this.niM.getHeight()) + (this.niM.getHeight() / 2);
                }
                float x = (this.niM.getX() + rawX) - this.mLastX;
                if (x < this.njd - (this.niM.getWidth() / 2)) {
                    x = this.njd - (this.niM.getWidth() / 2);
                } else if (x > ((this.njd + this.mVideoWidth) - this.niM.getWidth()) + (this.niM.getWidth() / 2)) {
                    x = ((this.njd + this.mVideoWidth) - this.niM.getWidth()) + (this.niM.getWidth() / 2);
                }
                this.niM.setX(x);
                this.niM.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.niP.getTextSize() != f) {
            this.niP.setTextSize(i, f);
        }
        if (this.niO.getTextSize() != f) {
            this.niO.setTextSize(i, f);
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
        matrix.postRotate(this.niM.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ag(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.niZ - motionEvent.getRawY(), this.niY - motionEvent.getRawX()));
    }

    private float ah(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.inQ && Math.abs(motionEvent.getRawY() - this.cqF) < this.inQ;
    }

    private void init() {
        this.niN = (RotateFrameLayout) this.niM.findViewById(R.id.content_container);
        this.niO = (TextView) this.niM.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.niM.findViewById(R.id.content_view);
        this.niP = (EditText) this.niM.findViewById(R.id.cover_edit);
        this.niQ = (ImageView) this.niM.findViewById(R.id.cover_delete);
        this.niR = (ImageView) this.niM.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.niO.setText(this.niP.getText());
        this.niO.setVisibility(0);
        this.niP.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.niO.getText())) {
            this.niS = 0;
            this.niM.setVisibility(8);
        }
        if (this.niS == 4) {
            dMP();
        }
        this.njc.HidenSoftKeyPad(this.niP);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.niP.setFocusable(true);
            this.niP.setFocusableInTouchMode(true);
            this.niP.requestFocus();
            return;
        }
        this.niP.setFocusable(false);
        this.niP.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.niP.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    MF();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    MF();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    MF();
                    break;
                default:
                    hideSoftKeyPad();
                    String Tw = com.baidu.tieba.video.editvideo.model.b.dMK().Tw(pendantData.resource);
                    if (TextUtils.isEmpty(Tw)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nhL.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dMK().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Tw, pendantData);
                        break;
                    }
                    break;
            }
            this.niS = pendantData.pendantType;
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
        dMP();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.niS == 4 || this.niS == 0) {
            this.niM.setX(this.njd);
            this.niM.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nje);
            String obj = this.niP.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.niP.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.niO.setText(a2);
                    this.niP.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dMP() {
        if (this.njh) {
            this.njh = false;
            this.niQ.setVisibility(8);
            this.niR.setVisibility(8);
            this.niN.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMQ() {
        if (!this.njh) {
            this.njh = true;
            this.niQ.setVisibility(0);
            this.niR.setVisibility(0);
            this.niN.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.njs != null) {
            Bitmap bitmap = this.njs.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.njs.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dMP();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.njb = 1.0f;
                this.mrl = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.njb = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.niW = (this.njm * 2) + width;
                this.niX = (this.njm * 2) + height;
                this.nja = (this.niW * 1.0f) / this.niX;
                this.niM.setX((((this.mVideoWidth - i2) - (this.njm * 2)) / 2) + this.njd);
                this.niM.setY((((this.mVideoHeight - i) - (this.njm * 2)) / 2) + this.nje);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bkM = motionEvent.getRawX();
                this.bkN = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bkM);
                float abs2 = Math.abs(rawY - this.bkN);
                if (motionEvent.getPointerCount() <= 1 && abs < this.inQ && abs2 < this.inQ && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.niO == null || this.niO.getText() == null) {
            return null;
        }
        return this.niO.getText().toString();
    }

    public void MF() {
        this.niO.setText(this.niP.getText());
        this.niO.setVisibility(8);
        this.niP.setVisibility(0);
        setEditTextEnable(true);
        this.njc.ShowSoftKeyPad(this.niP);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.niP.setTextAppearance(getContext(), R.style.cover_text_style);
            this.niO.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.njm = 0;
            this.niP.setMaxLines(1);
            this.niO.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.niO.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.niP.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.niP.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.niO.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.njm = l.getDimens(getContext(), R.dimen.ds40);
            this.niP.setMaxLines(2);
            this.niO.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.niO.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.niP.setLayoutParams(layoutParams2);
            this.nji = (int) (l.dip2px(getContext(), pendantData.left) * this.njb);
            this.njj = (int) (l.dip2px(getContext(), pendantData.top) * this.njb);
            this.njk = (int) (l.dip2px(getContext(), pendantData.right) * this.njb);
            this.njl = (int) (l.dip2px(getContext(), pendantData.bottom) * this.njb);
            this.mContentView.setPadding(this.nji, this.njj, this.njk, this.njl);
            this.bxB = l.getDimens(getContext(), R.dimen.fontsize40) * this.njb;
            String text = getText();
            this.njn = (i2 - this.njj) - this.njl;
            this.njo = (i - this.nji) - this.njk;
            this.njq = this.njp + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bxB);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.njo);
                this.bxB = this.niP.getTextSize();
                dMQ();
                MF();
            } else {
                if (af.getTextLengthAllOne(text) > 20) {
                    text = af.subStringWithAllOne(text, 20);
                    this.niP.setText(text);
                    this.niO.setText(text);
                }
                Ty(text);
            }
        }
        this.niO.setIncludeFontPadding(false);
        this.niP.setIncludeFontPadding(false);
        this.niO.setLineSpacing(this.njp, 1.0f);
        this.niP.setLineSpacing(this.njp, 1.0f);
        this.niM.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.niM.getLayoutParams();
        layoutParams3.height = (this.njm * 2) + i2;
        layoutParams3.width = (this.njm * 2) + i;
        this.niM.setLayoutParams(layoutParams3);
        this.njr = (this.njm * 2) + i;
        ((FrameLayout.LayoutParams) this.niN.getLayoutParams()).setMargins(this.njm, this.njm, this.njm, this.njm);
        this.niM.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.njt == null) {
            dMR();
        }
        return this.njt;
    }

    private void dMR() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.njt = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dMS() {
        if (this.njt != null && !this.njt.isRecycled()) {
            this.njt.recycle();
            this.njt = null;
        }
    }

    public void xL(boolean z) {
        if (this.niS != 0) {
            if (z) {
                dMS();
                this.niM.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.niM.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.njs.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.njs.clear();
        this.njs = null;
        dMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a implements b.a {
        WeakReference<a.b> njv;
        WeakReference<CoverPendantDragView> njw;
        WeakReference<PendantData> njx;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.njv = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.njw = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.njx = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gw(String str, String str2) {
            if (this.njv != null && this.njv.get() != null) {
                this.njv.get().nhL.setVisibility(8);
            }
            if (this.njw != null && this.njw.get() != null && this.njx != null && this.njx.get() != null) {
                this.njw.get().a(str2, this.njx.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Tp(String str) {
            if (this.njv != null && this.njv.get() != null) {
                this.njv.get().nhL.setVisibility(8);
            }
            if (this.njw != null && this.njw.get() != null) {
                l.showToast(this.njw.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dMb() {
            if (this.njv != null && this.njv.get() != null) {
                this.njv.get().nhL.setVisibility(8);
            }
        }
    }
}
