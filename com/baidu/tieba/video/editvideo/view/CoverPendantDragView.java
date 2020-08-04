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
    private float lpT;
    private FrameLayout mContentView;
    private float mDownX;
    private float mDownY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private FrameLayout meL;
    private RotateFrameLayout meM;
    private TextView meN;
    private EditText meO;
    private ImageView meP;
    private ImageView meQ;
    private int meR;
    private boolean meS;
    private float meT;
    private float meU;
    private int meV;
    private int meW;
    private float meX;
    private float meY;
    private float meZ;
    private float mfa;
    private c mfb;
    private float mfc;
    private float mfd;
    private float mfe;
    private float mff;
    private boolean mfg;
    private int mfh;
    private int mfi;
    private int mfj;
    private int mfk;
    private int mfl;
    private float mfm;
    private float mfn;
    private int mfo;
    private float mfp;
    private int mfq;
    private Map<String, Bitmap> mfr;
    private Bitmap mfs;
    float mft;
    float mfu;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.meR = 0;
        this.mfa = 1.0f;
        this.lpT = 1.0f;
        this.mfg = true;
        this.mfr = new HashMap();
        this.startTime = 0L;
        this.mft = 0.0f;
        this.mfu = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.biI = l.getDimens(getContext(), R.dimen.fontsize40);
        this.mfo = l.getDimens(getContext(), R.dimen.ds2);
        this.hrW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.meL = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.meL);
        this.meL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.meR == 4) {
                            CoverPendantDragView.this.dqy();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.mDownY);
                        if (!CoverPendantDragView.this.meS && abs < CoverPendantDragView.this.hrW && abs2 < CoverPendantDragView.this.hrW && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.EU();
                        }
                        CoverPendantDragView.this.meT = 0.0f;
                        CoverPendantDragView.this.meU = 0.0f;
                        CoverPendantDragView.this.meS = false;
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
                        CoverPendantDragView.this.meT = 0.0f;
                        CoverPendantDragView.this.meU = 0.0f;
                        return true;
                }
            }
        });
        this.meP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.meO.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.meQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.meU = 0.0f;
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
        this.meO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.meR != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.meN.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (ae.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.meN.getText().length()) {
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
                CoverPendantDragView.this.meN.setText(editable.toString());
            }
        });
        this.meO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.meL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.VM = this.mDownX;
        this.VN = this.mDownY;
        this.meX = (this.meL.getWidth() / 2) + this.meL.getX();
        this.meY = (this.meL.getHeight() / 2) + this.meL.getY();
        this.meN.setText(this.meO.getText());
        this.meN.setVisibility(0);
        this.meO.setVisibility(8);
        setEditTextEnable(false);
        this.mfb.HidenSoftKeyPad(this.meO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM(String str) {
        TextPaint paint = this.meO.getPaint();
        float measureText = paint.measureText(str);
        while (this.meO.getLineCount() == 1 && this.meO.getTextSize() < this.biI * this.lpT && measureText < this.mfn * this.lpT) {
            setTextSize(0, this.meO.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ae.getTextLengthAllOne(str) <= ae.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.meO.getTextSize() != this.biI * this.lpT) {
            setTextSize(0, this.biI * this.lpT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON(String str) {
        TextPaint paint = this.meO.getPaint();
        float measureText = paint.measureText(str);
        while (this.meO.getTextSize() > ((this.mfm * this.lpT) / 2.0f) - (this.mfp * this.lpT) && measureText > this.mfn * this.lpT) {
            setTextSize(0, this.meO.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void f(String str, float f) {
        TextPaint paint = this.meO.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.meO.getTextSize() - 1.0f);
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
        this.mfb = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.mfc = f;
        this.mfd = f2;
        this.mfe = f3;
        this.mff = f4;
        if (this.mfc > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mfc, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.mfd > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.mfd);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.mfe > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.mfe) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.mff > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.mff) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.meX - rawX);
        float abs4 = Math.abs(this.meY - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.meX - this.VM);
        float abs6 = Math.abs(this.meY - this.VN);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        di(sqrt, (int) (sqrt / this.meZ));
        if (this.meU != 0.0f) {
            this.meL.setRotation(this.meL.getRotation() - (this.meU - N));
        }
        this.meU = N;
        this.VM = rawX;
        this.VN = rawY;
    }

    private void di(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.meL.getLayoutParams();
        int width = this.meL.getWidth() - i;
        int i3 = (int) (width / this.meZ);
        if (width < this.meV) {
            width = this.meV;
            i3 = (int) (width / this.meZ);
        }
        this.lpT = ((width * 1.0f) - (this.mfl * 2)) / (this.mfq - (this.mfl * 2));
        this.mContentView.setPadding((int) (this.mfh * this.lpT), (int) (this.mfi * this.lpT), (int) (this.mfj * this.lpT), (int) (this.mfk * this.lpT));
        setTextSize(0, (this.meO.getTextSize() * i3) / this.meL.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.meL.setLayoutParams(layoutParams);
        float f = this.meX - (layoutParams.width / 2);
        float f2 = this.meY - (layoutParams.height / 2);
        this.meL.setX(f);
        this.meL.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.meR != 4) {
            float y = (this.meL.getY() + rawY) - this.VN;
            if (y < this.mfd) {
                y = this.mfd;
            } else if (y > (this.mfd + this.mVideoHeight) - this.meL.getHeight()) {
                y = (this.mfd + this.mVideoHeight) - this.meL.getHeight();
            }
            this.meL.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.meS = true;
                float O = O(motionEvent);
                float M = M(motionEvent);
                if (this.meT != 0.0f) {
                    int i = (int) (this.meT - O);
                    di(i, (int) (i / this.meZ));
                }
                if (this.meU != 0.0f) {
                    this.meL.setRotation(this.meL.getRotation() - (this.meU - M));
                }
                this.meU = M;
                this.meT = O;
            } else if (!this.meS && pointerCount == 1) {
                float y2 = (this.meL.getY() + rawY) - this.VN;
                if (y2 < this.mfd - (this.meL.getHeight() / 2)) {
                    y2 = this.mfd - (this.meL.getHeight() / 2);
                } else if (y2 > ((this.mfd + this.mVideoHeight) - this.meL.getHeight()) + (this.meL.getHeight() / 2)) {
                    y2 = ((this.mfd + this.mVideoHeight) - this.meL.getHeight()) + (this.meL.getHeight() / 2);
                }
                float x = (this.meL.getX() + rawX) - this.VM;
                if (x < this.mfc - (this.meL.getWidth() / 2)) {
                    x = this.mfc - (this.meL.getWidth() / 2);
                } else if (x > ((this.mfc + this.mVideoWidth) - this.meL.getWidth()) + (this.meL.getWidth() / 2)) {
                    x = ((this.mfc + this.mVideoWidth) - this.meL.getWidth()) + (this.meL.getWidth() / 2);
                }
                this.meL.setX(x);
                this.meL.setY(y2);
            }
        }
        this.VM = rawX;
        this.VN = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.meO.getTextSize() != f) {
            this.meO.setTextSize(i, f);
        }
        if (this.meN.getTextSize() != f) {
            this.meN.setTextSize(i, f);
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
        matrix.postRotate(this.meL.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float N(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.meY - motionEvent.getRawY(), this.meX - motionEvent.getRawX()));
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
        this.meM = (RotateFrameLayout) this.meL.findViewById(R.id.content_container);
        this.meN = (TextView) this.meL.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.meL.findViewById(R.id.content_view);
        this.meO = (EditText) this.meL.findViewById(R.id.cover_edit);
        this.meP = (ImageView) this.meL.findViewById(R.id.cover_delete);
        this.meQ = (ImageView) this.meL.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.meN.setText(this.meO.getText());
        this.meN.setVisibility(0);
        this.meO.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.meN.getText())) {
            this.meR = 0;
            this.meL.setVisibility(8);
        }
        if (this.meR == 4) {
            dqx();
        }
        this.mfb.HidenSoftKeyPad(this.meO);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.meO.setFocusable(true);
            this.meO.setFocusableInTouchMode(true);
            this.meO.requestFocus();
            return;
        }
        this.meO.setFocusable(false);
        this.meO.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.meO.setText("");
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
                    String OL = com.baidu.tieba.video.editvideo.model.b.dqs().OL(pendantData.resource);
                    if (TextUtils.isEmpty(OL)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.mdJ.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dqs().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(OL, pendantData);
                        break;
                    }
                    break;
            }
            this.meR = pendantData.pendantType;
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
        dqx();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.meR == 4 || this.meR == 0) {
            this.meL.setX(this.mfc);
            this.meL.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.mfd);
            String obj = this.meO.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.meO.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.meN.setText(a2);
                    this.meO.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dqx() {
        if (this.mfg) {
            this.mfg = false;
            this.meP.setVisibility(8);
            this.meQ.setVisibility(8);
            this.meM.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqy() {
        if (!this.mfg) {
            this.mfg = true;
            this.meP.setVisibility(0);
            this.meQ.setVisibility(0);
            this.meM.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.mfr != null) {
            Bitmap bitmap = this.mfr.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.mfr.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dqx();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.mfa = 1.0f;
                this.lpT = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.mfa = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.meV = (this.mfl * 2) + width;
                this.meW = (this.mfl * 2) + height;
                this.meZ = (this.meV * 1.0f) / this.meW;
                this.meL.setX((((this.mVideoWidth - i2) - (this.mfl * 2)) / 2) + this.mfc);
                this.meL.setY((((this.mVideoHeight - i) - (this.mfl * 2)) / 2) + this.mfd);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.mft = motionEvent.getRawX();
                this.mfu = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.mft);
                float abs2 = Math.abs(rawY - this.mfu);
                if (motionEvent.getPointerCount() <= 1 && abs < this.hrW && abs2 < this.hrW && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.meN == null || this.meN.getText() == null) {
            return null;
        }
        return this.meN.getText().toString();
    }

    public void EU() {
        this.meN.setText(this.meO.getText());
        this.meN.setVisibility(8);
        this.meO.setVisibility(0);
        setEditTextEnable(true);
        this.mfb.ShowSoftKeyPad(this.meO);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.meO.setTextAppearance(getContext(), R.style.cover_text_style);
            this.meN.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.mfl = 0;
            this.meO.setMaxLines(1);
            this.meN.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.meN.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.meO.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.meO.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.meN.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.mfl = l.getDimens(getContext(), R.dimen.ds40);
            this.meO.setMaxLines(2);
            this.meN.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.meN.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.meO.setLayoutParams(layoutParams2);
            this.mfh = (int) (l.dip2px(getContext(), pendantData.left) * this.mfa);
            this.mfi = (int) (l.dip2px(getContext(), pendantData.top) * this.mfa);
            this.mfj = (int) (l.dip2px(getContext(), pendantData.right) * this.mfa);
            this.mfk = (int) (l.dip2px(getContext(), pendantData.bottom) * this.mfa);
            this.mContentView.setPadding(this.mfh, this.mfi, this.mfj, this.mfk);
            this.biI = l.getDimens(getContext(), R.dimen.fontsize40) * this.mfa;
            String text = getText();
            this.mfm = (i2 - this.mfi) - this.mfk;
            this.mfn = (i - this.mfh) - this.mfj;
            this.mfp = this.mfo + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.biI);
            if (TextUtils.isEmpty(text)) {
                f(getContext().getString(R.string.cover_hint), this.mfn);
                this.biI = this.meO.getTextSize();
                dqy();
                EU();
            } else {
                if (ae.getTextLengthAllOne(text) > 20) {
                    text = ae.subStringWithAllOne(text, 20);
                    this.meO.setText(text);
                    this.meN.setText(text);
                }
                ON(text);
            }
        }
        this.meN.setIncludeFontPadding(false);
        this.meO.setIncludeFontPadding(false);
        this.meN.setLineSpacing(this.mfo, 1.0f);
        this.meO.setLineSpacing(this.mfo, 1.0f);
        this.meL.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.meL.getLayoutParams();
        layoutParams3.height = (this.mfl * 2) + i2;
        layoutParams3.width = (this.mfl * 2) + i;
        this.meL.setLayoutParams(layoutParams3);
        this.mfq = (this.mfl * 2) + i;
        ((FrameLayout.LayoutParams) this.meM.getLayoutParams()).setMargins(this.mfl, this.mfl, this.mfl, this.mfl);
        this.meL.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.mfs == null) {
            dqz();
        }
        return this.mfs;
    }

    private void dqz() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.mfs = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dqA() {
        if (this.mfs != null && !this.mfs.isRecycled()) {
            this.mfs.recycle();
            this.mfs = null;
        }
    }

    public void vN(boolean z) {
        if (this.meR != 0) {
            if (z) {
                dqA();
                this.meL.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.meL.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.mfr.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.mfr.clear();
        this.mfr = null;
        dqA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a implements b.a {
        WeakReference<a.b> mfw;
        WeakReference<CoverPendantDragView> mfx;
        WeakReference<PendantData> mfy;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.mfw = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.mfx = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.mfy = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void fG(String str, String str2) {
            if (this.mfw != null && this.mfw.get() != null) {
                this.mfw.get().mdJ.setVisibility(8);
            }
            if (this.mfx != null && this.mfx.get() != null && this.mfy != null && this.mfy.get() != null) {
                this.mfx.get().a(str2, this.mfy.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void OE(String str) {
            if (this.mfw != null && this.mfw.get() != null) {
                this.mfw.get().mdJ.setVisibility(8);
            }
            if (this.mfx != null && this.mfx.get() != null) {
                l.showToast(this.mfx.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dpJ() {
            if (this.mfw != null && this.mfw.get() != null) {
                this.mfw.get().mdJ.setVisibility(8);
            }
        }
    }
}
