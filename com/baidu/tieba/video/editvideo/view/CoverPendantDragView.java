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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    private float NT;
    private float NU;
    private float cPp;
    private float eXR;
    float fsI;
    float fsJ;
    private float iDF;
    private float jqA;
    private float jqB;
    private float jqC;
    private b jqD;
    private float jqE;
    private float jqF;
    private float jqG;
    private float jqH;
    private boolean jqI;
    private float jqJ;
    private int jqK;
    private int jqL;
    private int jqM;
    private int jqN;
    private int jqO;
    private float jqP;
    private float jqQ;
    private int jqR;
    private float jqS;
    private int jqT;
    private Map<String, Bitmap> jqU;
    private Bitmap jqV;
    private FrameLayout jqn;
    private RotateFrameLayout jqo;
    private TextView jqp;
    private EditText jqq;
    private ImageView jqr;
    private ImageView jqs;
    private int jqt;
    private boolean jqu;
    private float jqv;
    private float jqw;
    private int jqx;
    private int jqy;
    private float jqz;
    private FrameLayout mContentView;
    private float mDownX;
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
        this.jqt = 0;
        this.jqC = 1.0f;
        this.iDF = 1.0f;
        this.jqI = true;
        this.jqU = new HashMap();
        this.startTime = 0L;
        this.fsI = 0.0f;
        this.fsJ = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jqJ = l.g(getContext(), R.dimen.fontsize40);
        this.jqR = l.g(getContext(), R.dimen.ds2);
        this.eXR = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jqn = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jqn);
        this.jqn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jqt == 4) {
                            CoverPendantDragView.this.crU();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cPp);
                        if (!CoverPendantDragView.this.jqu && abs < CoverPendantDragView.this.eXR && abs2 < CoverPendantDragView.this.eXR && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.crV();
                        }
                        CoverPendantDragView.this.jqv = 0.0f;
                        CoverPendantDragView.this.jqw = 0.0f;
                        CoverPendantDragView.this.jqu = false;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.M(motionEvent)) {
                            CoverPendantDragView.this.O(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return true;
                    case 6:
                        CoverPendantDragView.this.jqv = 0.0f;
                        CoverPendantDragView.this.jqw = 0.0f;
                        return true;
                }
            }
        });
        this.jqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jqq.setText("");
                CoverPendantDragView.this.ccX();
            }
        });
        this.jqs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jqw = 0.0f;
                        return true;
                    case 2:
                        if (!CoverPendantDragView.this.M(motionEvent)) {
                            CoverPendantDragView.this.N(motionEvent);
                            return true;
                        }
                        return true;
                    case 3:
                    default:
                        return true;
                }
            }
        });
        this.jqq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jqt != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jqp.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ab.qY(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jqp.getText().length()) {
                        CoverPendantDragView.this.EZ(obj);
                    } else {
                        CoverPendantDragView.this.EY(obj);
                    }
                } else {
                    String ab = ab.ab(obj, 20);
                    editable.delete(ab.length(), obj.length());
                    CoverPendantDragView.this.EZ(ab);
                    l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.jqp.setText(editable.toString());
            }
        });
        this.jqq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jqn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cPp = motionEvent.getRawY();
        this.NT = this.mDownX;
        this.NU = this.cPp;
        this.jqz = (this.jqn.getWidth() / 2) + this.jqn.getX();
        this.jqA = (this.jqn.getHeight() / 2) + this.jqn.getY();
        this.jqp.setText(this.jqq.getText());
        this.jqp.setVisibility(0);
        this.jqq.setVisibility(8);
        setEditTextEnable(false);
        this.jqD.HidenSoftKeyPad(this.jqq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EY(String str) {
        TextPaint paint = this.jqq.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqq.getLineCount() == 1 && this.jqq.getTextSize() < this.jqJ * this.iDF && measureText < this.jqQ * this.iDF) {
            setTextSize(0, this.jqq.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.qY(str) <= ab.qY(getResources().getString(R.string.cover_hint)) && this.jqq.getTextSize() != this.jqJ * this.iDF) {
            setTextSize(0, this.jqJ * this.iDF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ(String str) {
        TextPaint paint = this.jqq.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqq.getTextSize() > ((this.jqP * this.iDF) / 2.0f) - (this.jqS * this.iDF) && measureText > this.jqQ * this.iDF) {
            setTextSize(0, this.jqq.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jqq.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jqq.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.mVideoWidth - l.g(getContext(), R.dimen.ds120)) {
            str = ab.ad(str, ab.qX(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public void setParentViewController(b bVar) {
        this.jqD = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jqE = f;
        this.jqF = f2;
        this.jqG = f3;
        this.jqH = f4;
        if (this.jqE > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jqE, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jqF > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jqF);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jqG > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jqG) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jqH > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jqH) - this.mVideoHeight);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float Q = Q(motionEvent);
        float abs = Math.abs(this.NT - rawX);
        float abs2 = Math.abs(this.NU - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.jqz - rawX);
        float abs4 = Math.abs(this.jqA - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jqz - this.NT);
        float abs6 = Math.abs(this.jqA - this.NU);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cA(sqrt, (int) (sqrt / this.jqB));
        if (this.jqw != 0.0f) {
            this.jqn.setRotation(this.jqn.getRotation() - (this.jqw - Q));
        }
        this.jqw = Q;
        this.NT = rawX;
        this.NU = rawY;
    }

    private void cA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqn.getLayoutParams();
        int width = this.jqn.getWidth() - i;
        int i3 = (int) (width / this.jqB);
        if (width < this.jqx) {
            width = this.jqx;
            i3 = (int) (width / this.jqB);
        }
        this.iDF = ((width * 1.0f) - (this.jqO * 2)) / (this.jqT - (this.jqO * 2));
        this.mContentView.setPadding((int) (this.jqK * this.iDF), (int) (this.jqL * this.iDF), (int) (this.jqM * this.iDF), (int) (this.jqN * this.iDF));
        setTextSize(0, (this.jqq.getTextSize() * i3) / this.jqn.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jqn.setLayoutParams(layoutParams);
        float f = this.jqz - (layoutParams.width / 2);
        float f2 = this.jqA - (layoutParams.height / 2);
        this.jqn.setX(f);
        this.jqn.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jqt != 4) {
            float y = (this.jqn.getY() + rawY) - this.NU;
            if (y < this.jqF) {
                y = this.jqF;
            } else if (y > (this.jqF + this.mVideoHeight) - this.jqn.getHeight()) {
                y = (this.jqF + this.mVideoHeight) - this.jqn.getHeight();
            }
            this.jqn.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jqu = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.jqv != 0.0f) {
                    int i = (int) (this.jqv - R);
                    cA(i, (int) (i / this.jqB));
                }
                if (this.jqw != 0.0f) {
                    this.jqn.setRotation(this.jqn.getRotation() - (this.jqw - P));
                }
                this.jqw = P;
                this.jqv = R;
            } else if (!this.jqu && pointerCount == 1) {
                float y2 = (this.jqn.getY() + rawY) - this.NU;
                if (y2 < this.jqF - (this.jqn.getHeight() / 2)) {
                    y2 = this.jqF - (this.jqn.getHeight() / 2);
                } else if (y2 > ((this.jqF + this.mVideoHeight) - this.jqn.getHeight()) + (this.jqn.getHeight() / 2)) {
                    y2 = ((this.jqF + this.mVideoHeight) - this.jqn.getHeight()) + (this.jqn.getHeight() / 2);
                }
                float x = (this.jqn.getX() + rawX) - this.NT;
                if (x < this.jqE - (this.jqn.getWidth() / 2)) {
                    x = this.jqE - (this.jqn.getWidth() / 2);
                } else if (x > ((this.jqE + this.mVideoWidth) - this.jqn.getWidth()) + (this.jqn.getWidth() / 2)) {
                    x = ((this.jqE + this.mVideoWidth) - this.jqn.getWidth()) + (this.jqn.getWidth() / 2);
                }
                this.jqn.setX(x);
                this.jqn.setY(y2);
            }
        }
        this.NT = rawX;
        this.NU = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jqq.getTextSize() != f) {
            this.jqq.setTextSize(i, f);
        }
        if (this.jqp.getTextSize() != f) {
            this.jqp.setTextSize(i, f);
        }
    }

    private float P(MotionEvent motionEvent) {
        float[] d = d(motionEvent, 0);
        float f = d[0];
        float f2 = d[1];
        float[] d2 = d(motionEvent, 1);
        float f3 = d2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - d2[1], f - f3));
    }

    private float[] d(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.jqn.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jqA - motionEvent.getRawY(), this.jqz - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eXR && Math.abs(motionEvent.getRawY() - this.cPp) < this.eXR;
    }

    private void init() {
        this.jqo = (RotateFrameLayout) this.jqn.findViewById(R.id.content_container);
        this.jqp = (TextView) this.jqn.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jqn.findViewById(R.id.content_view);
        this.jqq = (EditText) this.jqn.findViewById(R.id.cover_edit);
        this.jqr = (ImageView) this.jqn.findViewById(R.id.cover_delete);
        this.jqs = (ImageView) this.jqn.findViewById(R.id.cover_scale);
    }

    public void ccX() {
        this.jqp.setText(this.jqq.getText());
        this.jqp.setVisibility(0);
        this.jqq.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jqp.getText())) {
            this.jqt = 0;
            this.jqn.setVisibility(8);
        }
        if (this.jqt == 4) {
            crT();
        }
        this.jqD.HidenSoftKeyPad(this.jqq);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jqq.setFocusable(true);
            this.jqq.setFocusableInTouchMode(true);
            this.jqq.requestFocus();
            return;
        }
        this.jqq.setFocusable(false);
        this.jqq.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jqq.setText("");
                    ccX();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    crV();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    crV();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    crV();
                    break;
                default:
                    ccX();
                    String EX = com.baidu.tieba.video.editvideo.model.b.crO().EX(pendantData.resource);
                    if (TextUtils.isEmpty(EX)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jpj.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.crO().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(EX, pendantData);
                        break;
                    }
                    break;
            }
            this.jqt = pendantData.pendantType;
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
        crT();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jqt == 4 || this.jqt == 0) {
            this.jqn.setX(this.jqE);
            this.jqn.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jqF);
            String obj = this.jqq.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jqq.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jqp.setText(a2);
                    this.jqq.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void crT() {
        if (this.jqI) {
            this.jqI = false;
            this.jqr.setVisibility(8);
            this.jqs.setVisibility(8);
            this.jqo.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        if (!this.jqI) {
            this.jqI = true;
            this.jqr.setVisibility(0);
            this.jqs.setVisibility(0);
            this.jqo.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jqU != null) {
            Bitmap bitmap = this.jqU.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jqU.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                crT();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jqC = 1.0f;
                this.iDF = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jqC = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jqx = (this.jqO * 2) + width;
                this.jqy = (this.jqO * 2) + height;
                this.jqB = (this.jqx * 1.0f) / this.jqy;
                this.jqn.setX((((this.mVideoWidth - i2) - (this.jqO * 2)) / 2) + this.jqE);
                this.jqn.setY((((this.mVideoHeight - i) - (this.jqO * 2)) / 2) + this.jqF);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fsI = motionEvent.getRawX();
                this.fsJ = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fsI);
                float abs2 = Math.abs(rawY - this.fsJ);
                if (motionEvent.getPointerCount() <= 1 && abs < this.eXR && abs2 < this.eXR && System.currentTimeMillis() - this.startTime < 300) {
                    ccX();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jqp == null || this.jqp.getText() == null) {
            return null;
        }
        return this.jqp.getText().toString();
    }

    public void crV() {
        this.jqp.setText(this.jqq.getText());
        this.jqp.setVisibility(8);
        this.jqq.setVisibility(0);
        setEditTextEnable(true);
        this.jqD.ShowSoftKeyPad(this.jqq);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jqq.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jqp.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jqO = 0;
            this.jqq.setMaxLines(1);
            this.jqp.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqp.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jqq.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jqq.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqp.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqO = l.g(getContext(), R.dimen.ds40);
            this.jqq.setMaxLines(2);
            this.jqp.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jqp.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jqq.setLayoutParams(layoutParams2);
            this.jqK = (int) (l.dip2px(getContext(), pendantData.left) * this.jqC);
            this.jqL = (int) (l.dip2px(getContext(), pendantData.top) * this.jqC);
            this.jqM = (int) (l.dip2px(getContext(), pendantData.right) * this.jqC);
            this.jqN = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jqC);
            this.mContentView.setPadding(this.jqK, this.jqL, this.jqM, this.jqN);
            this.jqJ = l.g(getContext(), R.dimen.fontsize40) * this.jqC;
            String text = getText();
            this.jqP = (i2 - this.jqL) - this.jqN;
            this.jqQ = (i - this.jqK) - this.jqM;
            this.jqS = this.jqR + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jqJ);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jqQ);
                this.jqJ = this.jqq.getTextSize();
                crU();
                crV();
            } else {
                if (ab.qY(text) > 20) {
                    text = ab.ab(text, 20);
                    this.jqq.setText(text);
                    this.jqp.setText(text);
                }
                EZ(text);
            }
        }
        this.jqp.setIncludeFontPadding(false);
        this.jqq.setIncludeFontPadding(false);
        this.jqp.setLineSpacing(this.jqR, 1.0f);
        this.jqq.setLineSpacing(this.jqR, 1.0f);
        this.jqn.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jqn.getLayoutParams();
        layoutParams3.height = (this.jqO * 2) + i2;
        layoutParams3.width = (this.jqO * 2) + i;
        this.jqn.setLayoutParams(layoutParams3);
        this.jqT = (this.jqO * 2) + i;
        ((FrameLayout.LayoutParams) this.jqo.getLayoutParams()).setMargins(this.jqO, this.jqO, this.jqO, this.jqO);
        this.jqn.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jqV == null) {
            crW();
        }
        return this.jqV;
    }

    private void crW() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jqV = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void crX() {
        if (this.jqV != null && !this.jqV.isRecycled()) {
            this.jqV.recycle();
            this.jqV = null;
        }
    }

    public void rq(boolean z) {
        if (this.jqt != 0) {
            if (z) {
                crX();
                this.jqn.setVisibility(0);
                return;
            }
            ccX();
            getTempBitmap();
            this.jqn.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jqU.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jqU.clear();
        this.jqU = null;
        crX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jqX;
        WeakReference<CoverPendantDragView> jqY;
        WeakReference<PendantData> jqZ;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jqX = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jqY = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jqZ = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void er(String str, String str2) {
            if (this.jqX != null && this.jqX.get() != null) {
                this.jqX.get().jpj.setVisibility(8);
            }
            if (this.jqY != null && this.jqY.get() != null && this.jqZ != null && this.jqZ.get() != null) {
                this.jqY.get().a(str2, this.jqZ.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void EO(String str) {
            if (this.jqX != null && this.jqX.get() != null) {
                this.jqX.get().jpj.setVisibility(8);
            }
            if (this.jqY != null && this.jqY.get() != null) {
                l.showToast(this.jqY.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void cqZ() {
            if (this.jqX != null && this.jqX.get() != null) {
                this.jqX.get().jpj.setVisibility(8);
            }
        }
    }
}
