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
    private float VM;
    private float VN;
    private float biI;
    private float hrW;
    private float lpR;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout meJ;
    private RotateFrameLayout meK;
    private TextView meL;
    private EditText meM;
    private ImageView meN;
    private ImageView meO;
    private int meP;
    private boolean meQ;
    private float meR;
    private float meS;
    private int meT;
    private int meU;
    private float meV;
    private float meW;
    private float meX;
    private float meY;
    private c meZ;
    private float mfa;
    private float mfb;
    private float mfc;
    private float mfd;
    private boolean mfe;
    private int mff;
    private int mfg;
    private int mfh;
    private int mfi;
    private int mfj;
    private float mfk;
    private float mfl;
    private int mfm;
    private float mfn;
    private int mfo;
    private Map<String, Bitmap> mfp;
    private Bitmap mfq;
    float mfr;
    float mfs;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.meP = 0;
        this.meY = 1.0f;
        this.lpR = 1.0f;
        this.mfe = true;
        this.mfp = new HashMap();
        this.startTime = 0L;
        this.mfr = 0.0f;
        this.mfs = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.biI = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mfm = l.getDimens(getContext(), R.dimen.ds2);
        this.hrW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.meJ = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.meJ);
        this.meJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.meP == 4) {
                            CoverPendantDragView.this.dqx();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.meQ && abs < CoverPendantDragView.this.hrW && abs2 < CoverPendantDragView.this.hrW && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.EU();
                        }
                        CoverPendantDragView.this.meR = 0.0f;
                        CoverPendantDragView.this.meS = 0.0f;
                        CoverPendantDragView.this.meQ = false;
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
                        CoverPendantDragView.this.meR = 0.0f;
                        CoverPendantDragView.this.meS = 0.0f;
                        return true;
                }
            }
        });
        this.meN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.meM.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.meO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.meS = 0.0f;
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
        this.meM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.meP != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.meL.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.meL.getText().length()) {
                        CoverPendantDragView.this.ON(obj);
                    } else {
                        CoverPendantDragView.this.OM(obj);
                    }
                } else {
                    String subStringWithAllOne = ae.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.ON(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.meL.setText(editable.toString());
            }
        });
        this.meM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.meJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.VM = this.mDownX;
        this.VN = this.mDownY;
        this.meV = (this.meJ.getWidth() / 2) + this.meJ.getX();
        this.meW = (this.meJ.getHeight() / 2) + this.meJ.getY();
        this.meL.setText(this.meM.getText());
        this.meL.setVisibility(0);
        this.meM.setVisibility(8);
        setEditTextEnable(false);
        this.meZ.HidenSoftKeyPad(this.meM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM(String str) {
        TextPaint paint = this.meM.getPaint();
        float measureText = paint.measureText(str);
        while (this.meM.getLineCount() == 1 && this.meM.getTextSize() < this.biI * this.lpR && measureText < this.mfl * this.lpR) {
            setTextSize(0, this.meM.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.meM.getTextSize() != this.biI * this.lpR) {
            setTextSize(0, this.biI * this.lpR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON(String str) {
        TextPaint paint = this.meM.getPaint();
        float measureText = paint.measureText(str);
        while (this.meM.getTextSize() > ((this.mfk * this.lpR) / 2.0f) - (this.mfn * this.lpR) && measureText > this.mfl * this.lpR) {
            setTextSize(0, this.meM.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.meM.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.meM.getTextSize() - 1.0f);
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
        this.meZ = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mfa = f;
        this.mfb = f2;
        this.mfc = f3;
        this.mfd = f4;
        if (this.mfa > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mfa, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mfb > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mfb);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mfc > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mfc) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mfd > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mfd) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float N = N(motionEvent);
        float abs = Math.abs(this.VM - rawX);
        float abs2 = Math.abs(this.VN - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.meV - rawX);
        float abs4 = Math.abs(this.meW - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.meV - this.VM);
        float abs6 = Math.abs(this.meW - this.VN);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        di(sqrt, (int) (sqrt / this.meX));
        if (this.meS != 0.0f) {
            this.meJ.setRotation(this.meJ.getRotation() - (this.meS - N));
        }
        this.meS = N;
        this.VM = rawX;
        this.VN = rawY;
    }

    private void di(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.meJ.getLayoutParams();
        int width = this.meJ.getWidth() - i;
        int i3 = (int) (width / this.meX);
        if (width < this.meT) {
            width = this.meT;
            i3 = (int) (width / this.meX);
        }
        this.lpR = ((width * 1.0f) - (this.mfj * 2)) / (this.mfo - (this.mfj * 2));
        this.mContentView.setPadding((int) (this.mff * this.lpR), (int) (this.mfg * this.lpR), (int) (this.mfh * this.lpR), (int) (this.mfi * this.lpR));
        setTextSize(0, (this.meM.getTextSize() * i3) / this.meJ.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.meJ.setLayoutParams(layoutParams);
        float f = this.meV - (layoutParams.width / 2);
        float f2 = this.meW - (layoutParams.height / 2);
        this.meJ.setX(f);
        this.meJ.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.meP != 4) {
            float y = (this.meJ.getY() + rawY) - this.VN;
            if (y < this.mfb) {
                y = this.mfb;
            } else if (y > (this.mfb + this.mVideoHeight) - this.meJ.getHeight()) {
                y = (this.mfb + this.mVideoHeight) - this.meJ.getHeight();
            }
            this.meJ.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.meQ = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.meR != 0.0f) {
                    int i = (int) (this.meR - O);
                    di(i, (int) (i / this.meX));
                }
                if (this.meS != 0.0f) {
                    this.meJ.setRotation(this.meJ.getRotation() - (this.meS - M));
                }
                this.meS = M;
                this.meR = O;
            } else if (!this.meQ && pointerCount == 1) {
                float y2 = (this.meJ.getY() + rawY) - this.VN;
                if (y2 < this.mfb - (this.meJ.getHeight() / 2)) {
                    y2 = this.mfb - (this.meJ.getHeight() / 2);
                } else if (y2 > ((this.mfb + this.mVideoHeight) - this.meJ.getHeight()) + (this.meJ.getHeight() / 2)) {
                    y2 = ((this.mfb + this.mVideoHeight) - this.meJ.getHeight()) + (this.meJ.getHeight() / 2);
                }
                float x = (this.meJ.getX() + rawX) - this.VM;
                if (x < this.mfa - (this.meJ.getWidth() / 2)) {
                    x = this.mfa - (this.meJ.getWidth() / 2);
                } else if (x > ((this.mfa + this.mVideoWidth) - this.meJ.getWidth()) + (this.meJ.getWidth() / 2)) {
                    x = ((this.mfa + this.mVideoWidth) - this.meJ.getWidth()) + (this.meJ.getWidth() / 2);
                }
                this.meJ.setX(x);
                this.meJ.setY(y2);
            }
        }
        this.VM = rawX;
        this.VN = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.meM.getTextSize() != f) {
            this.meM.setTextSize(i, f);
        }
        if (this.meL.getTextSize() != f) {
            this.meL.setTextSize(i, f);
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
        matrix.postRotate(this.meJ.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.meW - motionEvent.getRawY(), this.meV - motionEvent.getRawX()));
    }

    private float O(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hrW && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hrW;
    }

    private void init() {
        this.meK = (RotateFrameLayout) this.meJ.findViewById(R.id.content_container);
        this.meL = (TextView) this.meJ.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.meJ.findViewById(R.id.content_view);
        this.meM = (EditText) this.meJ.findViewById(R.id.cover_edit);
        this.meN = (ImageView) this.meJ.findViewById(R.id.cover_delete);
        this.meO = (ImageView) this.meJ.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.meL.setText(this.meM.getText());
        this.meL.setVisibility(0);
        this.meM.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.meL.getText())) {
            this.meP = 0;
            this.meJ.setVisibility(8);
        }
        if (this.meP == 4) {
            dqw();
        }
        this.meZ.HidenSoftKeyPad(this.meM);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.meM.setFocusable(true);
            this.meM.setFocusableInTouchMode(true);
            this.meM.requestFocus();
            return;
        }
        this.meM.setFocusable(false);
        this.meM.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.meM.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    EU();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    EU();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    EU();
                    break;
                default:
                    hideSoftKeyPad();
                    String OL = com.baidu.tieba.video.editvideo.model.b.dqr().OL(pendantData.resource);
                    if (TextUtils.isEmpty(OL)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mdH.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dqr().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(OL, pendantData);
                        break;
                    }
                    break;
            }
            this.meP = pendantData.pendantType;
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
        dqw();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.meP == 4 || this.meP == 0) {
            this.meJ.setX(this.mfa);
            this.meJ.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mfb);
            String obj = this.meM.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.meM.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.meL.setText(a2);
                    this.meM.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dqw() {
        if (this.mfe) {
            this.mfe = false;
            this.meN.setVisibility(8);
            this.meO.setVisibility(8);
            this.meK.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqx() {
        if (!this.mfe) {
            this.mfe = true;
            this.meN.setVisibility(0);
            this.meO.setVisibility(0);
            this.meK.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mfp != null) {
            Bitmap bitmap = this.mfp.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mfp.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dqw();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.meY = 1.0f;
                this.lpR = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.meY = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.meT = (this.mfj * 2) + width;
                this.meU = (this.mfj * 2) + height;
                this.meX = (this.meT * 1.0f) / this.meU;
                this.meJ.setX((((this.mVideoWidth - i2) - (this.mfj * 2)) / 2) + this.mfa);
                this.meJ.setY((((this.mVideoHeight - i) - (this.mfj * 2)) / 2) + this.mfb);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.mfr = motionEvent.getRawX();
                this.mfs = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.mfr);
                float abs2 = Math.abs(rawY - this.mfs);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hrW && abs2 < this.hrW && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.meL == null || this.meL.getText() == null) {
            return null;
        }
        return this.meL.getText().toString();
    }

    public void EU() {
        this.meL.setText(this.meM.getText());
        this.meL.setVisibility(8);
        this.meM.setVisibility(0);
        setEditTextEnable(true);
        this.meZ.ShowSoftKeyPad(this.meM);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.meM.setTextAppearance(getContext(), R.style.cover_text_style);
            this.meL.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mfj = 0;
            this.meM.setMaxLines(1);
            this.meL.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.meL.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.meM.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.meM.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.meL.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mfj = l.getDimens(getContext(), R.dimen.ds40);
            this.meM.setMaxLines(2);
            this.meL.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.meL.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.meM.setLayoutParams(layoutParams2);
            this.mff = (int) (l.dip2px(getContext(), pendantData.left) * this.meY);
            this.mfg = (int) (l.dip2px(getContext(), pendantData.top) * this.meY);
            this.mfh = (int) (l.dip2px(getContext(), pendantData.right) * this.meY);
            this.mfi = (int) (l.dip2px(getContext(), pendantData.bottom) * this.meY);
            this.mContentView.setPadding(this.mff, this.mfg, this.mfh, this.mfi);
            this.biI = l.getDimens(getContext(), R.dimen.fontsize40) * this.meY;
            String text = getText();
            this.mfk = (i2 - this.mfg) - this.mfi;
            this.mfl = (i - this.mff) - this.mfh;
            this.mfn = this.mfm + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.biI);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mfl);
                this.biI = this.meM.getTextSize();
                dqx();
                EU();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.meM.setText(text);
                    this.meL.setText(text);
                }
                ON(text);
            }
        }
        this.meL.setIncludeFontPadding(false);
        this.meM.setIncludeFontPadding(false);
        this.meL.setLineSpacing(this.mfm, 1.0f);
        this.meM.setLineSpacing(this.mfm, 1.0f);
        this.meJ.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.meJ.getLayoutParams();
        layoutParams3.height = (this.mfj * 2) + i2;
        layoutParams3.width = (this.mfj * 2) + i;
        this.meJ.setLayoutParams(layoutParams3);
        this.mfo = (this.mfj * 2) + i;
        ((FrameLayout.LayoutParams) this.meK.getLayoutParams()).setMargins(this.mfj, this.mfj, this.mfj, this.mfj);
        this.meJ.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mfq == null) {
            dqy();
        }
        return this.mfq;
    }

    private void dqy() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mfq = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dqz() {
        if (this.mfq != null && !this.mfq.isRecycled()) {
            this.mfq.recycle();
            this.mfq = null;
        }
    }

    public void vN(boolean z) {
        if (this.meP != 0) {
            if (z) {
                dqz();
                this.meJ.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.meJ.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mfp.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mfp.clear();
        this.mfp = null;
        dqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a implements b.a {
        WeakReference<a.b> mfu;
        WeakReference<CoverPendantDragView> mfv;
        WeakReference<PendantData> mfw;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mfu = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mfv = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mfw = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fG(String str, String str2) {
            if (this.mfu != null && this.mfu.get() != null) {
                this.mfu.get().mdH.setVisibility(8);
            }
            if (this.mfv != null && this.mfv.get() != null && this.mfw != null && this.mfw.get() != null) {
                this.mfv.get().a(str2, this.mfw.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void OE(String str) {
            if (this.mfu != null && this.mfu.get() != null) {
                this.mfu.get().mdH.setVisibility(8);
            }
            if (this.mfv != null && this.mfv.get() != null) {
                l.showToast(this.mfv.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dpI() {
            if (this.mfu != null && this.mfu.get() != null) {
                this.mfu.get().mdH.setVisibility(8);
            }
        }
    }
}
