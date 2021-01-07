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
/* loaded from: classes8.dex */
public class CoverPendantDragView extends FrameLayout {
    private float bLV;
    float brm;
    float brn;
    private float cGB;
    private float iRH;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private float mQS;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout nHX;
    private RotateFrameLayout nHY;
    private TextView nHZ;
    private int nIA;
    private float nIB;
    private int nIC;
    private Map<String, Bitmap> nID;
    private Bitmap nIE;
    private EditText nIa;
    private ImageView nIb;
    private ImageView nIc;
    private int nId;
    private boolean nIe;
    private float nIf;
    private float nIg;
    private int nIh;
    private int nIi;
    private float nIj;
    private float nIk;
    private float nIl;
    private float nIm;
    private c nIn;
    private float nIo;
    private float nIp;
    private float nIq;
    private float nIr;
    private boolean nIs;
    private int nIt;
    private int nIu;
    private int nIv;
    private int nIw;
    private int nIx;
    private float nIy;
    private float nIz;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nId = 0;
        this.nIm = 1.0f;
        this.mQS = 1.0f;
        this.nIs = true;
        this.nID = new HashMap();
        this.startTime = 0L;
        this.brm = 0.0f;
        this.brn = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bLV = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nIA = l.getDimens(getContext(), R.dimen.ds2);
        this.iRH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nHX = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nHX);
        this.nHX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nId == 4) {
                            CoverPendantDragView.this.dUC();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cGB);
                        if (!CoverPendantDragView.this.nIe && abs < CoverPendantDragView.this.iRH && abs2 < CoverPendantDragView.this.iRH && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Ow();
                        }
                        CoverPendantDragView.this.nIf = 0.0f;
                        CoverPendantDragView.this.nIg = 0.0f;
                        CoverPendantDragView.this.nIe = false;
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
                        CoverPendantDragView.this.nIf = 0.0f;
                        CoverPendantDragView.this.nIg = 0.0f;
                        return true;
                }
            }
        });
        this.nIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nIa.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nIc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nIg = 0.0f;
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
        this.nIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nId != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nHZ.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nHZ.getText().length()) {
                        CoverPendantDragView.this.Uv(obj);
                    } else {
                        CoverPendantDragView.this.Uu(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Uv(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nHZ.setText(editable.toString());
            }
        });
        this.nIa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nHX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cGB = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cGB;
        this.nIj = (this.nHX.getWidth() / 2) + this.nHX.getX();
        this.nIk = (this.nHX.getHeight() / 2) + this.nHX.getY();
        this.nHZ.setText(this.nIa.getText());
        this.nHZ.setVisibility(0);
        this.nIa.setVisibility(8);
        setEditTextEnable(false);
        this.nIn.HidenSoftKeyPad(this.nIa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu(String str) {
        TextPaint paint = this.nIa.getPaint();
        float measureText = paint.measureText(str);
        while (this.nIa.getLineCount() == 1 && this.nIa.getTextSize() < this.bLV * this.mQS && measureText < this.nIz * this.mQS) {
            setTextSize(0, this.nIa.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nIa.getTextSize() != this.bLV * this.mQS) {
            setTextSize(0, this.bLV * this.mQS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uv(String str) {
        TextPaint paint = this.nIa.getPaint();
        float measureText = paint.measureText(str);
        while (this.nIa.getTextSize() > ((this.nIy * this.mQS) / 2.0f) - (this.nIB * this.mQS) && measureText > this.nIz * this.mQS) {
            setTextSize(0, this.nIa.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nIa.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nIa.getTextSize() - 1.0f);
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
        this.nIn = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nIo = f;
        this.nIp = f2;
        this.nIq = f3;
        this.nIr = f4;
        if (this.nIo > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nIo, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nIp > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nIp);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nIq > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nIq) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nIr > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nIr) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nIj - rawX);
        float abs4 = Math.abs(this.nIk - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nIj - this.mLastX);
        float abs6 = Math.abs(this.nIk - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dA(sqrt, (int) (sqrt / this.nIl));
        if (this.nIg != 0.0f) {
            this.nHX.setRotation(this.nHX.getRotation() - (this.nIg - ah));
        }
        this.nIg = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nHX.getLayoutParams();
        int width = this.nHX.getWidth() - i;
        int i3 = (int) (width / this.nIl);
        if (width < this.nIh) {
            width = this.nIh;
            i3 = (int) (width / this.nIl);
        }
        this.mQS = ((width * 1.0f) - (this.nIx * 2)) / (this.nIC - (this.nIx * 2));
        this.mContentView.setPadding((int) (this.nIt * this.mQS), (int) (this.nIu * this.mQS), (int) (this.nIv * this.mQS), (int) (this.nIw * this.mQS));
        setTextSize(0, (this.nIa.getTextSize() * i3) / this.nHX.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nHX.setLayoutParams(layoutParams);
        float f = this.nIj - (layoutParams.width / 2);
        float f2 = this.nIk - (layoutParams.height / 2);
        this.nHX.setX(f);
        this.nHX.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nId != 4) {
            float y = (this.nHX.getY() + rawY) - this.mLastY;
            if (y < this.nIp) {
                y = this.nIp;
            } else if (y > (this.nIp + this.mVideoHeight) - this.nHX.getHeight()) {
                y = (this.nIp + this.mVideoHeight) - this.nHX.getHeight();
            }
            this.nHX.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nIe = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nIf != 0.0f) {
                    int i = (int) (this.nIf - ai);
                    dA(i, (int) (i / this.nIl));
                }
                if (this.nIg != 0.0f) {
                    this.nHX.setRotation(this.nHX.getRotation() - (this.nIg - ag));
                }
                this.nIg = ag;
                this.nIf = ai;
            } else if (!this.nIe && pointerCount == 1) {
                float y2 = (this.nHX.getY() + rawY) - this.mLastY;
                if (y2 < this.nIp - (this.nHX.getHeight() / 2)) {
                    y2 = this.nIp - (this.nHX.getHeight() / 2);
                } else if (y2 > ((this.nIp + this.mVideoHeight) - this.nHX.getHeight()) + (this.nHX.getHeight() / 2)) {
                    y2 = ((this.nIp + this.mVideoHeight) - this.nHX.getHeight()) + (this.nHX.getHeight() / 2);
                }
                float x = (this.nHX.getX() + rawX) - this.mLastX;
                if (x < this.nIo - (this.nHX.getWidth() / 2)) {
                    x = this.nIo - (this.nHX.getWidth() / 2);
                } else if (x > ((this.nIo + this.mVideoWidth) - this.nHX.getWidth()) + (this.nHX.getWidth() / 2)) {
                    x = ((this.nIo + this.mVideoWidth) - this.nHX.getWidth()) + (this.nHX.getWidth() / 2);
                }
                this.nHX.setX(x);
                this.nHX.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nIa.getTextSize() != f) {
            this.nIa.setTextSize(i, f);
        }
        if (this.nHZ.getTextSize() != f) {
            this.nHZ.setTextSize(i, f);
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
        matrix.postRotate(this.nHX.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nIk - motionEvent.getRawY(), this.nIj - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iRH && Math.abs(motionEvent.getRawY() - this.cGB) < this.iRH;
    }

    private void init() {
        this.nHY = (RotateFrameLayout) this.nHX.findViewById(R.id.content_container);
        this.nHZ = (TextView) this.nHX.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nHX.findViewById(R.id.content_view);
        this.nIa = (EditText) this.nHX.findViewById(R.id.cover_edit);
        this.nIb = (ImageView) this.nHX.findViewById(R.id.cover_delete);
        this.nIc = (ImageView) this.nHX.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nHZ.setText(this.nIa.getText());
        this.nHZ.setVisibility(0);
        this.nIa.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nHZ.getText())) {
            this.nId = 0;
            this.nHX.setVisibility(8);
        }
        if (this.nId == 4) {
            dUB();
        }
        this.nIn.HidenSoftKeyPad(this.nIa);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nIa.setFocusable(true);
            this.nIa.setFocusableInTouchMode(true);
            this.nIa.requestFocus();
            return;
        }
        this.nIa.setFocusable(false);
        this.nIa.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nIa.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Ow();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Ow();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Ow();
                    break;
                default:
                    hideSoftKeyPad();
                    String Ut = com.baidu.tieba.video.editvideo.model.b.dUw().Ut(pendantData.resource);
                    if (TextUtils.isEmpty(Ut)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nGX.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dUw().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Ut, pendantData);
                        break;
                    }
                    break;
            }
            this.nId = pendantData.pendantType;
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
        dUB();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nId == 4 || this.nId == 0) {
            this.nHX.setX(this.nIo);
            this.nHX.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nIp);
            String obj = this.nIa.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nIa.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nHZ.setText(a2);
                    this.nIa.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dUB() {
        if (this.nIs) {
            this.nIs = false;
            this.nIb.setVisibility(8);
            this.nIc.setVisibility(8);
            this.nHY.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUC() {
        if (!this.nIs) {
            this.nIs = true;
            this.nIb.setVisibility(0);
            this.nIc.setVisibility(0);
            this.nHY.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nID != null) {
            Bitmap bitmap = this.nID.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nID.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dUB();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nIm = 1.0f;
                this.mQS = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nIm = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nIh = (this.nIx * 2) + width;
                this.nIi = (this.nIx * 2) + height;
                this.nIl = (this.nIh * 1.0f) / this.nIi;
                this.nHX.setX((((this.mVideoWidth - i2) - (this.nIx * 2)) / 2) + this.nIo);
                this.nHX.setY((((this.mVideoHeight - i) - (this.nIx * 2)) / 2) + this.nIp);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.brm = motionEvent.getRawX();
                this.brn = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.brm);
                float abs2 = Math.abs(rawY - this.brn);
                if (motionEvent.getPointerCount() <= 1 && abs < this.iRH && abs2 < this.iRH && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.nHZ == null || this.nHZ.getText() == null) {
            return null;
        }
        return this.nHZ.getText().toString();
    }

    public void Ow() {
        this.nHZ.setText(this.nIa.getText());
        this.nHZ.setVisibility(8);
        this.nIa.setVisibility(0);
        setEditTextEnable(true);
        this.nIn.ShowSoftKeyPad(this.nIa);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nIa.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nHZ.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nIx = 0;
            this.nIa.setMaxLines(1);
            this.nHZ.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nHZ.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nIa.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nIa.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nHZ.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nIx = l.getDimens(getContext(), R.dimen.ds40);
            this.nIa.setMaxLines(2);
            this.nHZ.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nHZ.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nIa.setLayoutParams(layoutParams2);
            this.nIt = (int) (l.dip2px(getContext(), pendantData.left) * this.nIm);
            this.nIu = (int) (l.dip2px(getContext(), pendantData.top) * this.nIm);
            this.nIv = (int) (l.dip2px(getContext(), pendantData.right) * this.nIm);
            this.nIw = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nIm);
            this.mContentView.setPadding(this.nIt, this.nIu, this.nIv, this.nIw);
            this.bLV = l.getDimens(getContext(), R.dimen.fontsize40) * this.nIm;
            String text = getText();
            this.nIy = (i2 - this.nIu) - this.nIw;
            this.nIz = (i - this.nIt) - this.nIv;
            this.nIB = this.nIA + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bLV);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nIz);
                this.bLV = this.nIa.getTextSize();
                dUC();
                Ow();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.nIa.setText(text);
                    this.nHZ.setText(text);
                }
                Uv(text);
            }
        }
        this.nHZ.setIncludeFontPadding(false);
        this.nIa.setIncludeFontPadding(false);
        this.nHZ.setLineSpacing(this.nIA, 1.0f);
        this.nIa.setLineSpacing(this.nIA, 1.0f);
        this.nHX.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nHX.getLayoutParams();
        layoutParams3.height = (this.nIx * 2) + i2;
        layoutParams3.width = (this.nIx * 2) + i;
        this.nHX.setLayoutParams(layoutParams3);
        this.nIC = (this.nIx * 2) + i;
        ((FrameLayout.LayoutParams) this.nHY.getLayoutParams()).setMargins(this.nIx, this.nIx, this.nIx, this.nIx);
        this.nHX.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nIE == null) {
            dUD();
        }
        return this.nIE;
    }

    private void dUD() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nIE = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dUE() {
        if (this.nIE != null && !this.nIE.isRecycled()) {
            this.nIE.recycle();
            this.nIE = null;
        }
    }

    public void yJ(boolean z) {
        if (this.nId != 0) {
            if (z) {
                dUE();
                this.nHX.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nHX.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nID.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nID.clear();
        this.nID = null;
        dUE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> nIG;
        WeakReference<CoverPendantDragView> nIH;
        WeakReference<PendantData> nII;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nIG = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nIH = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nII = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gy(String str, String str2) {
            if (this.nIG != null && this.nIG.get() != null) {
                this.nIG.get().nGX.setVisibility(8);
            }
            if (this.nIH != null && this.nIH.get() != null && this.nII != null && this.nII.get() != null) {
                this.nIH.get().a(str2, this.nII.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Um(String str) {
            if (this.nIG != null && this.nIG.get() != null) {
                this.nIG.get().nGX.setVisibility(8);
            }
            if (this.nIH != null && this.nIH.get() != null) {
                l.showToast(this.nIH.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dTN() {
            if (this.nIG != null && this.nIG.get() != null) {
                this.nIG.get().nGX.setVisibility(8);
            }
        }
    }
}
