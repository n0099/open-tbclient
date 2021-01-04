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
    private float mQT;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout nHY;
    private RotateFrameLayout nHZ;
    private float nIA;
    private int nIB;
    private float nIC;
    private int nID;
    private Map<String, Bitmap> nIE;
    private Bitmap nIF;
    private TextView nIa;
    private EditText nIb;
    private ImageView nIc;
    private ImageView nId;
    private int nIe;
    private boolean nIf;
    private float nIg;
    private float nIh;
    private int nIi;
    private int nIj;
    private float nIk;
    private float nIl;
    private float nIm;
    private float nIn;
    private c nIo;
    private float nIp;
    private float nIq;
    private float nIr;
    private float nIs;
    private boolean nIt;
    private int nIu;
    private int nIv;
    private int nIw;
    private int nIx;
    private int nIy;
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
        this.nIe = 0;
        this.nIn = 1.0f;
        this.mQT = 1.0f;
        this.nIt = true;
        this.nIE = new HashMap();
        this.startTime = 0L;
        this.brm = 0.0f;
        this.brn = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bLV = l.getDimens(getContext(), R.dimen.fontsize40);
        this.nIB = l.getDimens(getContext(), R.dimen.ds2);
        this.iRH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nHY = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.nHY);
        this.nHY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.j(view, motionEvent);
                        if (CoverPendantDragView.this.nIe == 4) {
                            CoverPendantDragView.this.dUB();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cGB);
                        if (!CoverPendantDragView.this.nIf && abs < CoverPendantDragView.this.iRH && abs2 < CoverPendantDragView.this.iRH && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Ow();
                        }
                        CoverPendantDragView.this.nIg = 0.0f;
                        CoverPendantDragView.this.nIh = 0.0f;
                        CoverPendantDragView.this.nIf = false;
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
                        CoverPendantDragView.this.nIg = 0.0f;
                        CoverPendantDragView.this.nIh = 0.0f;
                        return true;
                }
            }
        });
        this.nIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.nIb.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.nId.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.j(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.nIh = 0.0f;
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
        this.nIb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.nIe != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.nIa.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ad.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.nIa.getText().length()) {
                        CoverPendantDragView.this.Uw(obj);
                    } else {
                        CoverPendantDragView.this.Uv(obj);
                    }
                } else {
                    String subStringWithAllOne = ad.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.Uw(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.nIa.setText(editable.toString());
            }
        });
        this.nIb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.nHY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cGB = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cGB;
        this.nIk = (this.nHY.getWidth() / 2) + this.nHY.getX();
        this.nIl = (this.nHY.getHeight() / 2) + this.nHY.getY();
        this.nIa.setText(this.nIb.getText());
        this.nIa.setVisibility(0);
        this.nIb.setVisibility(8);
        setEditTextEnable(false);
        this.nIo.HidenSoftKeyPad(this.nIb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uv(String str) {
        TextPaint paint = this.nIb.getPaint();
        float measureText = paint.measureText(str);
        while (this.nIb.getLineCount() == 1 && this.nIb.getTextSize() < this.bLV * this.mQT && measureText < this.nIA * this.mQT) {
            setTextSize(0, this.nIb.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ad.getTextLengthAllOne(str) <= ad.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.nIb.getTextSize() != this.bLV * this.mQT) {
            setTextSize(0, this.bLV * this.mQT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw(String str) {
        TextPaint paint = this.nIb.getPaint();
        float measureText = paint.measureText(str);
        while (this.nIb.getTextSize() > ((this.nIz * this.mQT) / 2.0f) - (this.nIC * this.mQT) && measureText > this.nIA * this.mQT) {
            setTextSize(0, this.nIb.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.nIb.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.nIb.getTextSize() - 1.0f);
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
        this.nIo = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.nIp = f;
        this.nIq = f2;
        this.nIr = f3;
        this.nIs = f4;
        if (this.nIp > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.nIp, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.nIq > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.nIq);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.nIr > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.nIr) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.nIs > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.nIs) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.nIk - rawX);
        float abs4 = Math.abs(this.nIl - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.nIk - this.mLastX);
        float abs6 = Math.abs(this.nIl - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dA(sqrt, (int) (sqrt / this.nIm));
        if (this.nIh != 0.0f) {
            this.nHY.setRotation(this.nHY.getRotation() - (this.nIh - ah));
        }
        this.nIh = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nHY.getLayoutParams();
        int width = this.nHY.getWidth() - i;
        int i3 = (int) (width / this.nIm);
        if (width < this.nIi) {
            width = this.nIi;
            i3 = (int) (width / this.nIm);
        }
        this.mQT = ((width * 1.0f) - (this.nIy * 2)) / (this.nID - (this.nIy * 2));
        this.mContentView.setPadding((int) (this.nIu * this.mQT), (int) (this.nIv * this.mQT), (int) (this.nIw * this.mQT), (int) (this.nIx * this.mQT));
        setTextSize(0, (this.nIb.getTextSize() * i3) / this.nHY.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.nHY.setLayoutParams(layoutParams);
        float f = this.nIk - (layoutParams.width / 2);
        float f2 = this.nIl - (layoutParams.height / 2);
        this.nHY.setX(f);
        this.nHY.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.nIe != 4) {
            float y = (this.nHY.getY() + rawY) - this.mLastY;
            if (y < this.nIq) {
                y = this.nIq;
            } else if (y > (this.nIq + this.mVideoHeight) - this.nHY.getHeight()) {
                y = (this.nIq + this.mVideoHeight) - this.nHY.getHeight();
            }
            this.nHY.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.nIf = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.nIg != 0.0f) {
                    int i = (int) (this.nIg - ai);
                    dA(i, (int) (i / this.nIm));
                }
                if (this.nIh != 0.0f) {
                    this.nHY.setRotation(this.nHY.getRotation() - (this.nIh - ag));
                }
                this.nIh = ag;
                this.nIg = ai;
            } else if (!this.nIf && pointerCount == 1) {
                float y2 = (this.nHY.getY() + rawY) - this.mLastY;
                if (y2 < this.nIq - (this.nHY.getHeight() / 2)) {
                    y2 = this.nIq - (this.nHY.getHeight() / 2);
                } else if (y2 > ((this.nIq + this.mVideoHeight) - this.nHY.getHeight()) + (this.nHY.getHeight() / 2)) {
                    y2 = ((this.nIq + this.mVideoHeight) - this.nHY.getHeight()) + (this.nHY.getHeight() / 2);
                }
                float x = (this.nHY.getX() + rawX) - this.mLastX;
                if (x < this.nIp - (this.nHY.getWidth() / 2)) {
                    x = this.nIp - (this.nHY.getWidth() / 2);
                } else if (x > ((this.nIp + this.mVideoWidth) - this.nHY.getWidth()) + (this.nHY.getWidth() / 2)) {
                    x = ((this.nIp + this.mVideoWidth) - this.nHY.getWidth()) + (this.nHY.getWidth() / 2);
                }
                this.nHY.setX(x);
                this.nHY.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.nIb.getTextSize() != f) {
            this.nIb.setTextSize(i, f);
        }
        if (this.nIa.getTextSize() != f) {
            this.nIa.setTextSize(i, f);
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
        matrix.postRotate(this.nHY.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.nIl - motionEvent.getRawY(), this.nIk - motionEvent.getRawX()));
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
        this.nHZ = (RotateFrameLayout) this.nHY.findViewById(R.id.content_container);
        this.nIa = (TextView) this.nHY.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.nHY.findViewById(R.id.content_view);
        this.nIb = (EditText) this.nHY.findViewById(R.id.cover_edit);
        this.nIc = (ImageView) this.nHY.findViewById(R.id.cover_delete);
        this.nId = (ImageView) this.nHY.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.nIa.setText(this.nIb.getText());
        this.nIa.setVisibility(0);
        this.nIb.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.nIa.getText())) {
            this.nIe = 0;
            this.nHY.setVisibility(8);
        }
        if (this.nIe == 4) {
            dUA();
        }
        this.nIo.HidenSoftKeyPad(this.nIb);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.nIb.setFocusable(true);
            this.nIb.setFocusableInTouchMode(true);
            this.nIb.requestFocus();
            return;
        }
        this.nIb.setFocusable(false);
        this.nIb.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.nIb.setText("");
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
                    String Uu = com.baidu.tieba.video.editvideo.model.b.dUv().Uu(pendantData.resource);
                    if (TextUtils.isEmpty(Uu)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nGY.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dUv().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(Uu, pendantData);
                        break;
                    }
                    break;
            }
            this.nIe = pendantData.pendantType;
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
        dUA();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.nIe == 4 || this.nIe == 0) {
            this.nHY.setX(this.nIp);
            this.nHY.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.nIq);
            String obj = this.nIb.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.nIb.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.nIa.setText(a2);
                    this.nIb.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dUA() {
        if (this.nIt) {
            this.nIt = false;
            this.nIc.setVisibility(8);
            this.nId.setVisibility(8);
            this.nHZ.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUB() {
        if (!this.nIt) {
            this.nIt = true;
            this.nIc.setVisibility(0);
            this.nId.setVisibility(0);
            this.nHZ.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.nIE != null) {
            Bitmap bitmap = this.nIE.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.nIE.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dUA();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.nIn = 1.0f;
                this.mQT = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.nIn = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.nIi = (this.nIy * 2) + width;
                this.nIj = (this.nIy * 2) + height;
                this.nIm = (this.nIi * 1.0f) / this.nIj;
                this.nHY.setX((((this.mVideoWidth - i2) - (this.nIy * 2)) / 2) + this.nIp);
                this.nHY.setY((((this.mVideoHeight - i) - (this.nIy * 2)) / 2) + this.nIq);
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
        if (this.nIa == null || this.nIa.getText() == null) {
            return null;
        }
        return this.nIa.getText().toString();
    }

    public void Ow() {
        this.nIa.setText(this.nIb.getText());
        this.nIa.setVisibility(8);
        this.nIb.setVisibility(0);
        setEditTextEnable(true);
        this.nIo.ShowSoftKeyPad(this.nIb);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.nIb.setTextAppearance(getContext(), R.style.cover_text_style);
            this.nIa.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.nIy = 0;
            this.nIb.setMaxLines(1);
            this.nIa.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nIa.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.nIb.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.nIb.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nIa.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.nIy = l.getDimens(getContext(), R.dimen.ds40);
            this.nIb.setMaxLines(2);
            this.nIa.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nIa.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.nIb.setLayoutParams(layoutParams2);
            this.nIu = (int) (l.dip2px(getContext(), pendantData.left) * this.nIn);
            this.nIv = (int) (l.dip2px(getContext(), pendantData.top) * this.nIn);
            this.nIw = (int) (l.dip2px(getContext(), pendantData.right) * this.nIn);
            this.nIx = (int) (l.dip2px(getContext(), pendantData.bottom) * this.nIn);
            this.mContentView.setPadding(this.nIu, this.nIv, this.nIw, this.nIx);
            this.bLV = l.getDimens(getContext(), R.dimen.fontsize40) * this.nIn;
            String text = getText();
            this.nIz = (i2 - this.nIv) - this.nIx;
            this.nIA = (i - this.nIu) - this.nIw;
            this.nIC = this.nIB + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bLV);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.nIA);
                this.bLV = this.nIb.getTextSize();
                dUB();
                Ow();
            } else {
                if (ad.getTextLengthAllOne(text) > 20) {
                    text = ad.subStringWithAllOne(text, 20);
                    this.nIb.setText(text);
                    this.nIa.setText(text);
                }
                Uw(text);
            }
        }
        this.nIa.setIncludeFontPadding(false);
        this.nIb.setIncludeFontPadding(false);
        this.nIa.setLineSpacing(this.nIB, 1.0f);
        this.nIb.setLineSpacing(this.nIB, 1.0f);
        this.nHY.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nHY.getLayoutParams();
        layoutParams3.height = (this.nIy * 2) + i2;
        layoutParams3.width = (this.nIy * 2) + i;
        this.nHY.setLayoutParams(layoutParams3);
        this.nID = (this.nIy * 2) + i;
        ((FrameLayout.LayoutParams) this.nHZ.getLayoutParams()).setMargins(this.nIy, this.nIy, this.nIy, this.nIy);
        this.nHY.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.nIF == null) {
            dUC();
        }
        return this.nIF;
    }

    private void dUC() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.nIF = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dUD() {
        if (this.nIF != null && !this.nIF.isRecycled()) {
            this.nIF.recycle();
            this.nIF = null;
        }
    }

    public void yJ(boolean z) {
        if (this.nIe != 0) {
            if (z) {
                dUD();
                this.nHY.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.nHY.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.nIE.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.nIE.clear();
        this.nIE = null;
        dUD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements b.a {
        WeakReference<a.b> nIH;
        WeakReference<CoverPendantDragView> nII;
        WeakReference<PendantData> nIJ;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nIH = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.nII = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.nIJ = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gy(String str, String str2) {
            if (this.nIH != null && this.nIH.get() != null) {
                this.nIH.get().nGY.setVisibility(8);
            }
            if (this.nII != null && this.nII.get() != null && this.nIJ != null && this.nIJ.get() != null) {
                this.nII.get().a(str2, this.nIJ.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void Un(String str) {
            if (this.nIH != null && this.nIH.get() != null) {
                this.nIH.get().nGY.setVisibility(8);
            }
            if (this.nII != null && this.nII.get() != null) {
                l.showToast(this.nII.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dTM() {
            if (this.nIH != null && this.nIH.get() != null) {
                this.nIH.get().nGY.setVisibility(8);
            }
        }
    }
}
