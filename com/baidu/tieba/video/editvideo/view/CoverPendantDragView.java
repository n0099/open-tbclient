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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bMt;
    float brB;
    float brC;
    private float cFL;
    private float iUE;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mYm;
    private FrameLayout nPI;
    private RotateFrameLayout nPJ;
    private TextView nPK;
    private EditText nPL;
    private ImageView nPM;
    private ImageView nPN;
    private int nPO;
    private boolean nPP;
    private float nPQ;
    private float nPR;
    private int nPS;
    private int nPT;
    private float nPU;
    private float nPV;
    private float nPW;
    private float nPX;
    private c nPY;
    private float nPZ;
    private float nQa;
    private float nQb;
    private float nQc;
    private boolean nQd;
    private int nQe;
    private int nQf;
    private int nQg;
    private int nQh;
    private int nQi;
    private float nQj;
    private float nQk;
    private int nQl;
    private float nQm;
    private int nQn;
    private Map<String, Bitmap> nQo;
    private Bitmap nQp;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPO = 0;
        this.nPX = 1.0f;
        this.mYm = 1.0f;
        this.nQd = true;
        this.nQo = new HashMap();
        this.startTime = 0L;
        this.brB = 0.0f;
        this.brC = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bMt = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nQl = l.getDimens(getContext(), R.dimen.ds2);
        this.iUE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nPI = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nPI);
        this.nPI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nPO == 4) {
                            CoverPendantDragView.this.dTl();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cFL);
                        if (!CoverPendantDragView.this.nPP && abs < CoverPendantDragView.this.iUE && abs2 < CoverPendantDragView.this.iUE && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Mc();
                        }
                        CoverPendantDragView.this.nPQ = 0.0f;
                        CoverPendantDragView.this.nPR = 0.0f;
                        CoverPendantDragView.this.nPP = false;
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
                        CoverPendantDragView.this.nPQ = 0.0f;
                        CoverPendantDragView.this.nPR = 0.0f;
                        return true;
                }
            }
        });
        this.nPM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nPL.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nPN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nPR = 0.0f;
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
        this.nPL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nPO != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nPK.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ag.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nPK.getText().length()) {
                        CoverPendantDragView.this.UE(obj);
                    } else {
                        CoverPendantDragView.this.UD(obj);
                    }
                } else {
                    String subStringWithAllOne = ag.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.UE(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nPK.setText(editable.toString());
            }
        });
        this.nPL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nPI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cFL = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cFL;
        this.nPU = (this.nPI.getWidth() / 2) + this.nPI.getX();
        this.nPV = (this.nPI.getHeight() / 2) + this.nPI.getY();
        this.nPK.setText(this.nPL.getText());
        this.nPK.setVisibility(0);
        this.nPL.setVisibility(8);
        setEditTextEnable(false);
        this.nPY.HidenSoftKeyPad(this.nPL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UD(String str) {
        TextPaint paint = this.nPL.getPaint();
        float measureText = paint.measureText(str);
        while (this.nPL.getLineCount() == 1 && this.nPL.getTextSize() < this.bMt * this.mYm && measureText < this.nQk * this.mYm) {
            setTextSize(0, this.nPL.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ag.getTextLengthAllOne(str) <= ag.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nPL.getTextSize() != this.bMt * this.mYm) {
            setTextSize(0, this.bMt * this.mYm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UE(String str) {
        TextPaint paint = this.nPL.getPaint();
        float measureText = paint.measureText(str);
        while (this.nPL.getTextSize() > ((this.nQj * this.mYm) / 2.0f) - (this.nQm * this.mYm) && measureText > this.nQk * this.mYm) {
            setTextSize(0, this.nPL.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nPL.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nPL.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.getDimens(getContext(), R.dimen.ds120)) {
            str = ag.subStringWithEmoji(str, ag.getTextLengthWithEmoji(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(c cVar) {
        this.nPY = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nPZ = f;
        this.nQa = f2;
        this.nQb = f3;
        this.nQc = f4;
        if (this.nPZ > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nPZ, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nQa > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nQa);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nQb > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nQb) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nQc > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nQc) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nPU - rawX);
        float abs4 = Math.abs(this.nPV - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nPU - this.mLastX);
        float abs6 = Math.abs(this.nPV - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dy(sqrt, (int) (sqrt / this.nPW));
        if (this.nPR != 0.0f) {
            this.nPI.setRotation(this.nPI.getRotation() - (this.nPR - ah));
        }
        this.nPR = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dy(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nPI.getLayoutParams();
        int width = this.nPI.getWidth() - i;
        int i3 = (int) (width / this.nPW);
        if (width < this.nPS) {
            width = this.nPS;
            i3 = (int) (width / this.nPW);
        }
        this.mYm = ((width * 1.0f) - (this.nQi * 2)) / (this.nQn - (this.nQi * 2));
        this.mContentView.setPadding((int) (this.nQe * this.mYm), (int) (this.nQf * this.mYm), (int) (this.nQg * this.mYm), (int) (this.nQh * this.mYm));
        setTextSize(0, (this.nPL.getTextSize() * i3) / this.nPI.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nPI.setLayoutParams(layoutParams);
        float f = this.nPU - (layoutParams.width / 2);
        float f2 = this.nPV - (layoutParams.height / 2);
        this.nPI.setX(f);
        this.nPI.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nPO != 4) {
            float y = (this.nPI.getY() + rawY) - this.mLastY;
            if (y < this.nQa) {
                y = this.nQa;
            } else if (y > (this.nQa + this.mVideoHeight) - this.nPI.getHeight()) {
                y = (this.nQa + this.mVideoHeight) - this.nPI.getHeight();
            }
            this.nPI.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nPP = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nPQ != 0.0f) {
                    int i = (int) (this.nPQ - ai);
                    dy(i, (int) (i / this.nPW));
                }
                if (this.nPR != 0.0f) {
                    this.nPI.setRotation(this.nPI.getRotation() - (this.nPR - ag));
                }
                this.nPR = ag;
                this.nPQ = ai;
            } else if (!this.nPP && pointerCount == 1) {
                float y2 = (this.nPI.getY() + rawY) - this.mLastY;
                if (y2 < this.nQa - (this.nPI.getHeight() / 2)) {
                    y2 = this.nQa - (this.nPI.getHeight() / 2);
                } else if (y2 > ((this.nQa + this.mVideoHeight) - this.nPI.getHeight()) + (this.nPI.getHeight() / 2)) {
                    y2 = ((this.nQa + this.mVideoHeight) - this.nPI.getHeight()) + (this.nPI.getHeight() / 2);
                }
                float x = (this.nPI.getX() + rawX) - this.mLastX;
                if (x < this.nPZ - (this.nPI.getWidth() / 2)) {
                    x = this.nPZ - (this.nPI.getWidth() / 2);
                } else if (x > ((this.nPZ + this.mVideoWidth) - this.nPI.getWidth()) + (this.nPI.getWidth() / 2)) {
                    x = ((this.nPZ + this.mVideoWidth) - this.nPI.getWidth()) + (this.nPI.getWidth() / 2);
                }
                this.nPI.setX(x);
                this.nPI.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nPL.getTextSize() != f) {
            this.nPL.setTextSize(i, f);
        }
        if (this.nPK.getTextSize() != f) {
            this.nPK.setTextSize(i, f);
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
        matrix.postRotate(this.nPI.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nPV - motionEvent.getRawY(), this.nPU - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iUE && Math.abs(motionEvent.getRawY() - this.cFL) < this.iUE;
    }

    private void init() {
        this.nPJ = (RotateFrameLayout) this.nPI.findViewById(R.id.content_container);
        this.nPK = (TextView) this.nPI.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nPI.findViewById(R.id.content_view);
        this.nPL = (EditText) this.nPI.findViewById(R.id.cover_edit);
        this.nPM = (ImageView) this.nPI.findViewById(R.id.cover_delete);
        this.nPN = (ImageView) this.nPI.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nPK.setText(this.nPL.getText());
        this.nPK.setVisibility(0);
        this.nPL.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nPK.getText())) {
            this.nPO = 0;
            this.nPI.setVisibility(8);
        }
        if (this.nPO == 4) {
            dTk();
        }
        this.nPY.HidenSoftKeyPad(this.nPL);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nPL.setFocusable(true);
            this.nPL.setFocusableInTouchMode(true);
            this.nPL.requestFocus();
            return;
        }
        this.nPL.setFocusable(false);
        this.nPL.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nPL.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Mc();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Mc();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Mc();
                    break;
                default:
                    hideSoftKeyPad();
                    String UC = com.baidu.tieba.video.editvideo.model.b.dTf().UC(pendantData.resource);
                    if (TextUtils.isEmpty(UC)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nOI.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dTf().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(UC, pendantData);
                        break;
                    }
                    break;
            }
            this.nPO = pendantData.pendantType;
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
        dTk();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nPO == 4 || this.nPO == 0) {
            this.nPI.setX(this.nPZ);
            this.nPI.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nQa);
            String obj = this.nPL.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nPL.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nPK.setText(a2);
                    this.nPL.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dTk() {
        if (this.nQd) {
            this.nQd = false;
            this.nPM.setVisibility(8);
            this.nPN.setVisibility(8);
            this.nPJ.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTl() {
        if (!this.nQd) {
            this.nQd = true;
            this.nPM.setVisibility(0);
            this.nPN.setVisibility(0);
            this.nPJ.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nQo != null) {
            Bitmap bitmap = this.nQo.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nQo.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dTk();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nPX = 1.0f;
                this.mYm = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nPX = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nPS = (this.nQi * 2) + width;
                this.nPT = (this.nQi * 2) + height;
                this.nPW = (this.nPS * 1.0f) / this.nPT;
                this.nPI.setX((((this.mVideoWidth - i2) - (this.nQi * 2)) / 2) + this.nPZ);
                this.nPI.setY((((this.mVideoHeight - i) - (this.nQi * 2)) / 2) + this.nQa);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.brB = motionEvent.getRawX();
                this.brC = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.brB);
                float abs2 = Math.abs(rawY - this.brC);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iUE && abs2 < this.iUE && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nPK == null || this.nPK.getText() == null) {
            return null;
        }
        return this.nPK.getText().toString();
    }

    public void Mc() {
        this.nPK.setText(this.nPL.getText());
        this.nPK.setVisibility(8);
        this.nPL.setVisibility(0);
        setEditTextEnable(true);
        this.nPY.ShowSoftKeyPad(this.nPL);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nPL.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nPK.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nQi = 0;
            this.nPL.setMaxLines(1);
            this.nPK.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nPK.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nPL.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nPL.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nPK.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nQi = l.getDimens(getContext(), R.dimen.ds40);
            this.nPL.setMaxLines(2);
            this.nPK.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nPK.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nPL.setLayoutParams(layoutParams2);
            this.nQe = (int) (l.dip2px(getContext(), pendantData.left) * this.nPX);
            this.nQf = (int) (l.dip2px(getContext(), pendantData.top) * this.nPX);
            this.nQg = (int) (l.dip2px(getContext(), pendantData.right) * this.nPX);
            this.nQh = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nPX);
            this.mContentView.setPadding(this.nQe, this.nQf, this.nQg, this.nQh);
            this.bMt = l.getDimens(getContext(), R.dimen.fontsize40) * this.nPX;
            String text = getText();
            this.nQj = (i2 - this.nQf) - this.nQh;
            this.nQk = (i - this.nQe) - this.nQg;
            this.nQm = this.nQl + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bMt);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nQk);
                this.bMt = this.nPL.getTextSize();
                dTl();
                Mc();
            } else {
                if (ag.getTextLengthAllOne(text) > 20) {
                    text = ag.subStringWithAllOne(text, 20);
                    this.nPL.setText(text);
                    this.nPK.setText(text);
                }
                UE(text);
            }
        }
        this.nPK.setIncludeFontPadding(false);
        this.nPL.setIncludeFontPadding(false);
        this.nPK.setLineSpacing(this.nQl, 1.0f);
        this.nPL.setLineSpacing(this.nQl, 1.0f);
        this.nPI.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nPI.getLayoutParams();
        layoutParams3.height = (this.nQi * 2) + i2;
        layoutParams3.width = (this.nQi * 2) + i;
        this.nPI.setLayoutParams(layoutParams3);
        this.nQn = (this.nQi * 2) + i;
        ((FrameLayout.LayoutParams) this.nPJ.getLayoutParams()).setMargins(this.nQi, this.nQi, this.nQi, this.nQi);
        this.nPI.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nQp == null) {
            dTm();
        }
        return this.nQp;
    }

    private void dTm() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nQp = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dTn() {
        if (this.nQp != null && !this.nQp.isRecycled()) {
            this.nQp.recycle();
            this.nQp = null;
        }
    }

    public void yX(boolean z) {
        if (this.nPO != 0) {
            if (z) {
                dTn();
                this.nPI.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nPI.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nQo.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nQo.clear();
        this.nQo = null;
        dTn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements b.a {
        WeakReference<a.b> nQr;
        WeakReference<CoverPendantDragView> nQs;
        WeakReference<PendantData> nQt;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nQr = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nQs = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nQt = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gF(String str, String str2) {
            if (this.nQr != null && this.nQr.get() != null) {
                this.nQr.get().nOI.setVisibility(8);
            }
            if (this.nQs != null && this.nQs.get() != null && this.nQt != null && this.nQt.get() != null) {
                this.nQs.get().a(str2, this.nQt.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Uv(String str) {
            if (this.nQr != null && this.nQr.get() != null) {
                this.nQr.get().nOI.setVisibility(8);
            }
            if (this.nQs != null && this.nQs.get() != null) {
                l.showToast(this.nQs.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dSw() {
            if (this.nQr != null && this.nQr.get() != null) {
                this.nQr.get().nOI.setVisibility(8);
            }
        }
    }
}
