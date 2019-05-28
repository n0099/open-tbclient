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
    private float eXS;
    float fsJ;
    float fsK;
    private float iDH;
    private float jqA;
    private float jqB;
    private float jqC;
    private float jqD;
    private b jqE;
    private float jqF;
    private float jqG;
    private float jqH;
    private float jqI;
    private boolean jqJ;
    private float jqK;
    private int jqL;
    private int jqM;
    private int jqN;
    private int jqO;
    private int jqP;
    private float jqQ;
    private float jqR;
    private int jqS;
    private float jqT;
    private int jqU;
    private Map<String, Bitmap> jqV;
    private Bitmap jqW;
    private FrameLayout jqo;
    private RotateFrameLayout jqp;
    private TextView jqq;
    private EditText jqr;
    private ImageView jqs;
    private ImageView jqt;
    private int jqu;
    private boolean jqv;
    private float jqw;
    private float jqx;
    private int jqy;
    private int jqz;
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
        this.jqu = 0;
        this.jqD = 1.0f;
        this.iDH = 1.0f;
        this.jqJ = true;
        this.jqV = new HashMap();
        this.startTime = 0L;
        this.fsJ = 0.0f;
        this.fsK = 0.0f;
        this.mScreenWidth = l.af(TbadkCoreApplication.getInst());
        this.jqK = l.g(getContext(), R.dimen.fontsize40);
        this.jqS = l.g(getContext(), R.dimen.ds2);
        this.eXS = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.jqo = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.jqo);
        this.jqo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.g(view, motionEvent);
                        if (CoverPendantDragView.this.jqu == 4) {
                            CoverPendantDragView.this.crW();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cPp);
                        if (!CoverPendantDragView.this.jqv && abs < CoverPendantDragView.this.eXS && abs2 < CoverPendantDragView.this.eXS && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.crX();
                        }
                        CoverPendantDragView.this.jqw = 0.0f;
                        CoverPendantDragView.this.jqx = 0.0f;
                        CoverPendantDragView.this.jqv = false;
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
                        CoverPendantDragView.this.jqw = 0.0f;
                        CoverPendantDragView.this.jqx = 0.0f;
                        return true;
                }
            }
        });
        this.jqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.jqr.setText("");
                CoverPendantDragView.this.cda();
            }
        });
        this.jqt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.g(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.jqx = 0.0f;
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
        this.jqr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.jqu != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.jqq.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), (int) R.string.cover_text_length_max_tips);
                    }
                } else if (ab.qY(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.jqq.getText().length()) {
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
                CoverPendantDragView.this.jqq.setText(editable.toString());
            }
        });
        this.jqr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.jqo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cPp = motionEvent.getRawY();
        this.NT = this.mDownX;
        this.NU = this.cPp;
        this.jqA = (this.jqo.getWidth() / 2) + this.jqo.getX();
        this.jqB = (this.jqo.getHeight() / 2) + this.jqo.getY();
        this.jqq.setText(this.jqr.getText());
        this.jqq.setVisibility(0);
        this.jqr.setVisibility(8);
        setEditTextEnable(false);
        this.jqE.HidenSoftKeyPad(this.jqr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EY(String str) {
        TextPaint paint = this.jqr.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqr.getLineCount() == 1 && this.jqr.getTextSize() < this.jqK * this.iDH && measureText < this.jqR * this.iDH) {
            setTextSize(0, this.jqr.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (ab.qY(str) <= ab.qY(getResources().getString(R.string.cover_hint)) && this.jqr.getTextSize() != this.jqK * this.iDH) {
            setTextSize(0, this.jqK * this.iDH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ(String str) {
        TextPaint paint = this.jqr.getPaint();
        float measureText = paint.measureText(str);
        while (this.jqr.getTextSize() > ((this.jqQ * this.iDH) / 2.0f) - (this.jqT * this.iDH) && measureText > this.jqR * this.iDH) {
            setTextSize(0, this.jqr.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void e(String str, float f) {
        TextPaint paint = this.jqr.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.jqr.getTextSize() - 1.0f);
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
        this.jqE = bVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.jqF = f;
        this.jqG = f2;
        this.jqH = f3;
        this.jqI = f4;
        if (this.jqF > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.jqF, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.jqG > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.jqG);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.jqH > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.jqH) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.jqI > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.jqI) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.jqA - rawX);
        float abs4 = Math.abs(this.jqB - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.jqA - this.NT);
        float abs6 = Math.abs(this.jqB - this.NU);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        cA(sqrt, (int) (sqrt / this.jqC));
        if (this.jqx != 0.0f) {
            this.jqo.setRotation(this.jqo.getRotation() - (this.jqx - Q));
        }
        this.jqx = Q;
        this.NT = rawX;
        this.NU = rawY;
    }

    private void cA(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqo.getLayoutParams();
        int width = this.jqo.getWidth() - i;
        int i3 = (int) (width / this.jqC);
        if (width < this.jqy) {
            width = this.jqy;
            i3 = (int) (width / this.jqC);
        }
        this.iDH = ((width * 1.0f) - (this.jqP * 2)) / (this.jqU - (this.jqP * 2));
        this.mContentView.setPadding((int) (this.jqL * this.iDH), (int) (this.jqM * this.iDH), (int) (this.jqN * this.iDH), (int) (this.jqO * this.iDH));
        setTextSize(0, (this.jqr.getTextSize() * i3) / this.jqo.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.jqo.setLayoutParams(layoutParams);
        float f = this.jqA - (layoutParams.width / 2);
        float f2 = this.jqB - (layoutParams.height / 2);
        this.jqo.setX(f);
        this.jqo.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.jqu != 4) {
            float y = (this.jqo.getY() + rawY) - this.NU;
            if (y < this.jqG) {
                y = this.jqG;
            } else if (y > (this.jqG + this.mVideoHeight) - this.jqo.getHeight()) {
                y = (this.jqG + this.mVideoHeight) - this.jqo.getHeight();
            }
            this.jqo.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.jqv = true;
                float R = R(motionEvent);
                float P = P(motionEvent);
                if (this.jqw != 0.0f) {
                    int i = (int) (this.jqw - R);
                    cA(i, (int) (i / this.jqC));
                }
                if (this.jqx != 0.0f) {
                    this.jqo.setRotation(this.jqo.getRotation() - (this.jqx - P));
                }
                this.jqx = P;
                this.jqw = R;
            } else if (!this.jqv && pointerCount == 1) {
                float y2 = (this.jqo.getY() + rawY) - this.NU;
                if (y2 < this.jqG - (this.jqo.getHeight() / 2)) {
                    y2 = this.jqG - (this.jqo.getHeight() / 2);
                } else if (y2 > ((this.jqG + this.mVideoHeight) - this.jqo.getHeight()) + (this.jqo.getHeight() / 2)) {
                    y2 = ((this.jqG + this.mVideoHeight) - this.jqo.getHeight()) + (this.jqo.getHeight() / 2);
                }
                float x = (this.jqo.getX() + rawX) - this.NT;
                if (x < this.jqF - (this.jqo.getWidth() / 2)) {
                    x = this.jqF - (this.jqo.getWidth() / 2);
                } else if (x > ((this.jqF + this.mVideoWidth) - this.jqo.getWidth()) + (this.jqo.getWidth() / 2)) {
                    x = ((this.jqF + this.mVideoWidth) - this.jqo.getWidth()) + (this.jqo.getWidth() / 2);
                }
                this.jqo.setX(x);
                this.jqo.setY(y2);
            }
        }
        this.NT = rawX;
        this.NU = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.jqr.getTextSize() != f) {
            this.jqr.setTextSize(i, f);
        }
        if (this.jqq.getTextSize() != f) {
            this.jqq.setTextSize(i, f);
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
        matrix.postRotate(this.jqo.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float Q(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.jqB - motionEvent.getRawY(), this.jqA - motionEvent.getRawX()));
    }

    private float R(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eXS && Math.abs(motionEvent.getRawY() - this.cPp) < this.eXS;
    }

    private void init() {
        this.jqp = (RotateFrameLayout) this.jqo.findViewById(R.id.content_container);
        this.jqq = (TextView) this.jqo.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.jqo.findViewById(R.id.content_view);
        this.jqr = (EditText) this.jqo.findViewById(R.id.cover_edit);
        this.jqs = (ImageView) this.jqo.findViewById(R.id.cover_delete);
        this.jqt = (ImageView) this.jqo.findViewById(R.id.cover_scale);
    }

    public void cda() {
        this.jqq.setText(this.jqr.getText());
        this.jqq.setVisibility(0);
        this.jqr.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.jqq.getText())) {
            this.jqu = 0;
            this.jqo.setVisibility(8);
        }
        if (this.jqu == 4) {
            crV();
        }
        this.jqE.HidenSoftKeyPad(this.jqr);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.jqr.setFocusable(true);
            this.jqr.setFocusableInTouchMode(true);
            this.jqr.requestFocus();
            return;
        }
        this.jqr.setFocusable(false);
        this.jqr.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.jqr.setText("");
                    cda();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    crX();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    crX();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    crX();
                    break;
                default:
                    cda();
                    String EX = com.baidu.tieba.video.editvideo.model.b.crQ().EX(pendantData.resource);
                    if (TextUtils.isEmpty(EX)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.jpk.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.crQ().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(EX, pendantData);
                        break;
                    }
                    break;
            }
            this.jqu = pendantData.pendantType;
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
        crV();
        a(this.mVideoWidth, l.g(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.jqu == 4 || this.jqu == 0) {
            this.jqo.setX(this.jqF);
            this.jqo.setY(((this.mVideoHeight - l.g(getContext(), R.dimen.ds100)) / 2) + this.jqG);
            String obj = this.jqr.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.jqr.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.jqq.setText(a2);
                    this.jqr.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void crV() {
        if (this.jqJ) {
            this.jqJ = false;
            this.jqs.setVisibility(8);
            this.jqt.setVisibility(8);
            this.jqp.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        if (!this.jqJ) {
            this.jqJ = true;
            this.jqs.setVisibility(0);
            this.jqt.setVisibility(0);
            this.jqp.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.jqV != null) {
            Bitmap bitmap = this.jqV.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.jqV.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                crV();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.jqD = 1.0f;
                this.iDH = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.jqD = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.jqy = (this.jqP * 2) + width;
                this.jqz = (this.jqP * 2) + height;
                this.jqC = (this.jqy * 1.0f) / this.jqz;
                this.jqo.setX((((this.mVideoWidth - i2) - (this.jqP * 2)) / 2) + this.jqF);
                this.jqo.setY((((this.mVideoHeight - i) - (this.jqP * 2)) / 2) + this.jqG);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.fsJ = motionEvent.getRawX();
                this.fsK = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.fsJ);
                float abs2 = Math.abs(rawY - this.fsK);
                if (motionEvent.getPointerCount() <= 1 && abs < this.eXS && abs2 < this.eXS && System.currentTimeMillis() - this.startTime < 300) {
                    cda();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.jqq == null || this.jqq.getText() == null) {
            return null;
        }
        return this.jqq.getText().toString();
    }

    public void crX() {
        this.jqq.setText(this.jqr.getText());
        this.jqq.setVisibility(8);
        this.jqr.setVisibility(0);
        setEditTextEnable(true);
        this.jqE.ShowSoftKeyPad(this.jqr);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.jqr.setTextAppearance(getContext(), R.style.cover_text_style);
            this.jqq.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * i) / i3);
            this.jqP = 0;
            this.jqr.setMaxLines(1);
            this.jqq.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jqq.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.jqr.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.jqr.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqq.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.jqP = l.g(getContext(), R.dimen.ds40);
            this.jqr.setMaxLines(2);
            this.jqq.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jqq.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.jqr.setLayoutParams(layoutParams2);
            this.jqL = (int) (l.dip2px(getContext(), pendantData.left) * this.jqD);
            this.jqM = (int) (l.dip2px(getContext(), pendantData.top) * this.jqD);
            this.jqN = (int) (l.dip2px(getContext(), pendantData.right) * this.jqD);
            this.jqO = (int) (l.dip2px(getContext(), pendantData.bottom) * this.jqD);
            this.mContentView.setPadding(this.jqL, this.jqM, this.jqN, this.jqO);
            this.jqK = l.g(getContext(), R.dimen.fontsize40) * this.jqD;
            String text = getText();
            this.jqQ = (i2 - this.jqM) - this.jqO;
            this.jqR = (i - this.jqL) - this.jqN;
            this.jqT = this.jqS + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.jqK);
            if (TextUtils.isEmpty(text)) {
                e(getContext().getString(R.string.cover_hint), this.jqR);
                this.jqK = this.jqr.getTextSize();
                crW();
                crX();
            } else {
                if (ab.qY(text) > 20) {
                    text = ab.ab(text, 20);
                    this.jqr.setText(text);
                    this.jqq.setText(text);
                }
                EZ(text);
            }
        }
        this.jqq.setIncludeFontPadding(false);
        this.jqr.setIncludeFontPadding(false);
        this.jqq.setLineSpacing(this.jqS, 1.0f);
        this.jqr.setLineSpacing(this.jqS, 1.0f);
        this.jqo.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jqo.getLayoutParams();
        layoutParams3.height = (this.jqP * 2) + i2;
        layoutParams3.width = (this.jqP * 2) + i;
        this.jqo.setLayoutParams(layoutParams3);
        this.jqU = (this.jqP * 2) + i;
        ((FrameLayout.LayoutParams) this.jqp.getLayoutParams()).setMargins(this.jqP, this.jqP, this.jqP, this.jqP);
        this.jqo.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.jqW == null) {
            crY();
        }
        return this.jqW;
    }

    private void crY() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.jqW = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void crZ() {
        if (this.jqW != null && !this.jqW.isRecycled()) {
            this.jqW.recycle();
            this.jqW = null;
        }
    }

    public void rq(boolean z) {
        if (this.jqu != 0) {
            if (z) {
                crZ();
                this.jqo.setVisibility(0);
                return;
            }
            cda();
            getTempBitmap();
            this.jqo.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.jqV.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.jqV.clear();
        this.jqV = null;
        crZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements b.a {
        WeakReference<a.b> jqY;
        WeakReference<CoverPendantDragView> jqZ;
        WeakReference<PendantData> jra;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.jqY = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.jqZ = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.jra = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void er(String str, String str2) {
            if (this.jqY != null && this.jqY.get() != null) {
                this.jqY.get().jpk.setVisibility(8);
            }
            if (this.jqZ != null && this.jqZ.get() != null && this.jra != null && this.jra.get() != null) {
                this.jqZ.get().a(str2, this.jra.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void EO(String str) {
            if (this.jqY != null && this.jqY.get() != null) {
                this.jqY.get().jpk.setVisibility(8);
            }
            if (this.jqZ != null && this.jqZ.get() != null) {
                l.showToast(this.jqZ.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void crb() {
            if (this.jqY != null && this.jqY.get() != null) {
                this.jqY.get().jpk.setVisibility(8);
            }
        }
    }
}
