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
    private float bDM;
    float bmg;
    float bmh;
    private float cwD;
    private float itN;
    private FrameLayout mContentView;
    private float mDownX;
    private float mLastX;
    private float mLastY;
    private int mScreenWidth;
    private int mVideoHeight;
    private int mVideoWidth;
    private float mxi;
    private FrameLayout noJ;
    private RotateFrameLayout noK;
    private TextView noL;
    private EditText noM;
    private ImageView noN;
    private ImageView noO;
    private int noP;
    private boolean noQ;
    private float noR;
    private float noS;
    private int noT;
    private int noU;
    private float noV;
    private float noW;
    private float noX;
    private float noY;
    private c noZ;
    private float npa;
    private float npb;
    private float npc;
    private float npd;
    private boolean npe;
    private int npf;
    private int npg;
    private int nph;
    private int npi;
    private int npj;
    private float npk;
    private float npl;
    private int npm;
    private float npn;
    private int npo;
    private Map<String, Bitmap> npp;
    private Bitmap npq;
    long startTime;

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.noP = 0;
        this.noY = 1.0f;
        this.mxi = 1.0f;
        this.npe = true;
        this.npp = new HashMap();
        this.startTime = 0L;
        this.bmg = 0.0f;
        this.bmh = 0.0f;
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.bDM = l.getDimens(getContext(), R.dimen.fontsize40);
        this.npm = l.getDimens(getContext(), R.dimen.ds2);
        this.itN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.noJ = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        init();
        addView(this.noJ);
        this.noJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.1
            long startTime = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.startTime = System.currentTimeMillis();
                        CoverPendantDragView.this.c(view, motionEvent);
                        if (CoverPendantDragView.this.noP == 4) {
                            CoverPendantDragView.this.dPs();
                            return true;
                        }
                        return true;
                    case 1:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float abs = Math.abs(rawX - CoverPendantDragView.this.mDownX);
                        float abs2 = Math.abs(rawY - CoverPendantDragView.this.cwD);
                        if (!CoverPendantDragView.this.noQ && abs < CoverPendantDragView.this.itN && abs2 < CoverPendantDragView.this.itN && System.currentTimeMillis() - this.startTime < 300) {
                            CoverPendantDragView.this.Nf();
                        }
                        CoverPendantDragView.this.noR = 0.0f;
                        CoverPendantDragView.this.noS = 0.0f;
                        CoverPendantDragView.this.noQ = false;
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
                        CoverPendantDragView.this.noR = 0.0f;
                        CoverPendantDragView.this.noS = 0.0f;
                        return true;
                }
            }
        });
        this.noN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CoverPendantDragView.this.noM.setText("");
                CoverPendantDragView.this.hideSoftKeyPad();
            }
        });
        this.noO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        CoverPendantDragView.this.c(view, motionEvent);
                        return true;
                    case 1:
                        CoverPendantDragView.this.noS = 0.0f;
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
        this.noM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (CoverPendantDragView.this.noP != 4) {
                    String a2 = CoverPendantDragView.this.a(CoverPendantDragView.this.noL.getPaint(), obj);
                    if (!a2.equals(obj)) {
                        editable.delete(a2.length(), obj.length());
                        l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (af.getTextLengthAllOne(obj) < 20) {
                    if (obj.length() > CoverPendantDragView.this.noL.getText().length()) {
                        CoverPendantDragView.this.TP(obj);
                    } else {
                        CoverPendantDragView.this.TO(obj);
                    }
                } else {
                    String subStringWithAllOne = af.subStringWithAllOne(obj, 20);
                    editable.delete(subStringWithAllOne.length(), obj.length());
                    CoverPendantDragView.this.TP(subStringWithAllOne);
                    l.showToast(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
                }
                CoverPendantDragView.this.noL.setText(editable.toString());
            }
        });
        this.noM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverPendantDragView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
        this.noJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.cwD = motionEvent.getRawY();
        this.mLastX = this.mDownX;
        this.mLastY = this.cwD;
        this.noV = (this.noJ.getWidth() / 2) + this.noJ.getX();
        this.noW = (this.noJ.getHeight() / 2) + this.noJ.getY();
        this.noL.setText(this.noM.getText());
        this.noL.setVisibility(0);
        this.noM.setVisibility(8);
        setEditTextEnable(false);
        this.noZ.HidenSoftKeyPad(this.noM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TO(String str) {
        TextPaint paint = this.noM.getPaint();
        float measureText = paint.measureText(str);
        while (this.noM.getLineCount() == 1 && this.noM.getTextSize() < this.bDM * this.mxi && measureText < this.npl * this.mxi) {
            setTextSize(0, this.noM.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (af.getTextLengthAllOne(str) <= af.getTextLengthAllOne(getResources().getString(R.string.cover_hint)) && this.noM.getTextSize() != this.bDM * this.mxi) {
            setTextSize(0, this.bDM * this.mxi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TP(String str) {
        TextPaint paint = this.noM.getPaint();
        float measureText = paint.measureText(str);
        while (this.noM.getTextSize() > ((this.npk * this.mxi) / 2.0f) - (this.npn * this.mxi) && measureText > this.npl * this.mxi) {
            setTextSize(0, this.noM.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    private void g(String str, float f) {
        TextPaint paint = this.noM.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f) {
            setTextSize(0, this.noM.getTextSize() - 1.0f);
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
        this.noZ = cVar;
    }

    public void setVideoLocation(float f, float f2, float f3, float f4) {
        this.npa = f;
        this.npb = f2;
        this.npc = f3;
        this.npd = f4;
        if (this.npa > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.npa, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.npb > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.npb);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.npc > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.npc) - this.mVideoWidth, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.npd > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.npd) - this.mVideoHeight);
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
        float abs3 = Math.abs(this.noV - rawX);
        float abs4 = Math.abs(this.noW - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.noV - this.mLastX);
        float abs6 = Math.abs(this.noW - this.mLastY);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        dy(sqrt, (int) (sqrt / this.noX));
        if (this.noS != 0.0f) {
            this.noJ.setRotation(this.noJ.getRotation() - (this.noS - ah));
        }
        this.noS = ah;
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    private void dy(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.noJ.getLayoutParams();
        int width = this.noJ.getWidth() - i;
        int i3 = (int) (width / this.noX);
        if (width < this.noT) {
            width = this.noT;
            i3 = (int) (width / this.noX);
        }
        this.mxi = ((width * 1.0f) - (this.npj * 2)) / (this.npo - (this.npj * 2));
        this.mContentView.setPadding((int) (this.npf * this.mxi), (int) (this.npg * this.mxi), (int) (this.nph * this.mxi), (int) (this.npi * this.mxi));
        setTextSize(0, (this.noM.getTextSize() * i3) / this.noJ.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.noJ.setLayoutParams(layoutParams);
        float f = this.noV - (layoutParams.width / 2);
        float f2 = this.noW - (layoutParams.height / 2);
        this.noJ.setX(f);
        this.noJ.setY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.noP != 4) {
            float y = (this.noJ.getY() + rawY) - this.mLastY;
            if (y < this.npb) {
                y = this.npb;
            } else if (y > (this.npb + this.mVideoHeight) - this.noJ.getHeight()) {
                y = (this.npb + this.mVideoHeight) - this.noJ.getHeight();
            }
            this.noJ.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.noQ = true;
                float ai = ai(motionEvent);
                float ag = ag(motionEvent);
                if (this.noR != 0.0f) {
                    int i = (int) (this.noR - ai);
                    dy(i, (int) (i / this.noX));
                }
                if (this.noS != 0.0f) {
                    this.noJ.setRotation(this.noJ.getRotation() - (this.noS - ag));
                }
                this.noS = ag;
                this.noR = ai;
            } else if (!this.noQ && pointerCount == 1) {
                float y2 = (this.noJ.getY() + rawY) - this.mLastY;
                if (y2 < this.npb - (this.noJ.getHeight() / 2)) {
                    y2 = this.npb - (this.noJ.getHeight() / 2);
                } else if (y2 > ((this.npb + this.mVideoHeight) - this.noJ.getHeight()) + (this.noJ.getHeight() / 2)) {
                    y2 = ((this.npb + this.mVideoHeight) - this.noJ.getHeight()) + (this.noJ.getHeight() / 2);
                }
                float x = (this.noJ.getX() + rawX) - this.mLastX;
                if (x < this.npa - (this.noJ.getWidth() / 2)) {
                    x = this.npa - (this.noJ.getWidth() / 2);
                } else if (x > ((this.npa + this.mVideoWidth) - this.noJ.getWidth()) + (this.noJ.getWidth() / 2)) {
                    x = ((this.npa + this.mVideoWidth) - this.noJ.getWidth()) + (this.noJ.getWidth() / 2);
                }
                this.noJ.setX(x);
                this.noJ.setY(y2);
            }
        }
        this.mLastX = rawX;
        this.mLastY = rawY;
    }

    public void setTextSize(int i, float f) {
        if (this.noM.getTextSize() != f) {
            this.noM.setTextSize(i, f);
        }
        if (this.noL.getTextSize() != f) {
            this.noL.setTextSize(i, f);
        }
    }

    private float ag(MotionEvent motionEvent) {
        float[] e = e(motionEvent, 0);
        float f = e[0];
        float f2 = e[1];
        float[] e2 = e(motionEvent, 1);
        float f3 = e2[0];
        return (float) Math.toDegrees(Math.atan2(f2 - e2[1], f - f3));
    }

    private float[] e(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.noJ.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    private float ah(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.noW - motionEvent.getRawY(), this.noV - motionEvent.getRawX()));
    }

    private float ai(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.itN && Math.abs(motionEvent.getRawY() - this.cwD) < this.itN;
    }

    private void init() {
        this.noK = (RotateFrameLayout) this.noJ.findViewById(R.id.content_container);
        this.noL = (TextView) this.noJ.findViewById(R.id.cover_text);
        this.mContentView = (FrameLayout) this.noJ.findViewById(R.id.content_view);
        this.noM = (EditText) this.noJ.findViewById(R.id.cover_edit);
        this.noN = (ImageView) this.noJ.findViewById(R.id.cover_delete);
        this.noO = (ImageView) this.noJ.findViewById(R.id.cover_scale);
    }

    public void hideSoftKeyPad() {
        this.noL.setText(this.noM.getText());
        this.noL.setVisibility(0);
        this.noM.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.noL.getText())) {
            this.noP = 0;
            this.noJ.setVisibility(8);
        }
        if (this.noP == 4) {
            dPr();
        }
        this.noZ.HidenSoftKeyPad(this.noM);
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.noM.setFocusable(true);
            this.noM.setFocusableInTouchMode(true);
            this.noM.requestFocus();
            return;
        }
        this.noM.setFocusable(false);
        this.noM.setFocusableInTouchMode(false);
    }

    public void a(View view, PendantData pendantData) {
        if (pendantData != null) {
            switch (pendantData.pendantType) {
                case 0:
                    this.noM.setText("");
                    hideSoftKeyPad();
                    break;
                case 1:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_blue);
                    Nf();
                    break;
                case 2:
                    a(pendantData);
                    this.mContentView.setBackgroundResource(R.drawable.bg_cover_edit_black);
                    Nf();
                    break;
                case 3:
                    a(pendantData);
                    this.mContentView.setBackgroundDrawable(null);
                    Nf();
                    break;
                default:
                    hideSoftKeyPad();
                    String TN = com.baidu.tieba.video.editvideo.model.b.dPm().TN(pendantData.resource);
                    if (TextUtils.isEmpty(TN)) {
                        if (view != null && (view.getTag() instanceof a.b)) {
                            a.b bVar = (a.b) view.getTag();
                            bVar.nnH.setVisibility(0);
                            com.baidu.tieba.video.editvideo.model.b.dPm().a(pendantData.id, pendantData.resource, new a(bVar, this, pendantData));
                            break;
                        }
                    } else {
                        a(TN, pendantData);
                        break;
                    }
                    break;
            }
            this.noP = pendantData.pendantType;
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
        dPr();
        a(this.mVideoWidth, l.getDimens(getContext(), R.dimen.ds100), this.mScreenWidth, pendantData);
        if (this.noP == 4 || this.noP == 0) {
            this.noJ.setX(this.npa);
            this.noJ.setY(((this.mVideoHeight - l.getDimens(getContext(), R.dimen.ds100)) / 2) + this.npb);
            String obj = this.noM.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                String a2 = a(this.noM.getPaint(), obj);
                if (!a2.equals(obj)) {
                    this.noL.setText(a2);
                    this.noM.setText(a2);
                }
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    private void dPr() {
        if (this.npe) {
            this.npe = false;
            this.noN.setVisibility(8);
            this.noO.setVisibility(8);
            this.noK.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPs() {
        if (!this.npe) {
            this.npe = true;
            this.noN.setVisibility(0);
            this.noO.setVisibility(0);
            this.noK.setBackgroundResource(R.drawable.bg_cover_pendant_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, PendantData pendantData) {
        if (!TextUtils.isEmpty(str) && pendantData != null && this.npp != null) {
            Bitmap bitmap = this.npp.get(str);
            if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
                this.npp.put(str, bitmap);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() != 0 && bitmap2.getHeight() != 0) {
                dPr();
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                this.noY = 1.0f;
                this.mxi = 1.0f;
                int dip2px = l.dip2px(getContext(), width / 2);
                int i = (int) ((dip2px * height) / width);
                int i2 = (this.mVideoWidth * 2) / 3;
                if (dip2px > i2) {
                    this.noY = (i2 * 1.0f) / dip2px;
                    i = (int) ((i2 * height) / width);
                } else {
                    i2 = dip2px;
                }
                this.mContentView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
                a(i2, i, this.mScreenWidth, pendantData);
                this.noT = (this.npj * 2) + width;
                this.noU = (this.npj * 2) + height;
                this.noX = (this.noT * 1.0f) / this.noU;
                this.noJ.setX((((this.mVideoWidth - i2) - (this.npj * 2)) / 2) + this.npa);
                this.noJ.setY((((this.mVideoHeight - i) - (this.npj * 2)) / 2) + this.npb);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                this.bmg = motionEvent.getRawX();
                this.bmh = motionEvent.getRawY();
                break;
            case 1:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.bmg);
                float abs2 = Math.abs(rawY - this.bmh);
                if (motionEvent.getPointerCount() <= 1 && abs < this.itN && abs2 < this.itN && System.currentTimeMillis() - this.startTime < 300) {
                    hideSoftKeyPad();
                    break;
                }
                break;
        }
        return true;
    }

    public String getText() {
        if (this.noL == null || this.noL.getText() == null) {
            return null;
        }
        return this.noL.getText().toString();
    }

    public void Nf() {
        this.noL.setText(this.noM.getText());
        this.noL.setVisibility(8);
        this.noM.setVisibility(0);
        setEditTextEnable(true);
        this.noZ.ShowSoftKeyPad(this.noM);
    }

    public void a(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.noM.setTextAppearance(getContext(), R.style.cover_text_style);
            this.noL.setTextAppearance(getContext(), R.style.cover_text_style);
            i2 = (int) ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds100) * i) / i3);
            setTextSize(0, (l.getDimens(getContext(), R.dimen.fontsize40) * i) / i3);
            this.npj = 0;
            this.noM.setMaxLines(1);
            this.noL.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.noL.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.noM.setLayoutParams(layoutParams);
            this.mContentView.setPadding(l.getDimens(getContext(), R.dimen.ds60), 0, l.getDimens(getContext(), R.dimen.ds60), 0);
        } else {
            this.noM.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.noL.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.npj = l.getDimens(getContext(), R.dimen.ds40);
            this.noM.setMaxLines(2);
            this.noL.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.noL.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.noM.setLayoutParams(layoutParams2);
            this.npf = (int) (l.dip2px(getContext(), pendantData.left) * this.noY);
            this.npg = (int) (l.dip2px(getContext(), pendantData.top) * this.noY);
            this.nph = (int) (l.dip2px(getContext(), pendantData.right) * this.noY);
            this.npi = (int) (l.dip2px(getContext(), pendantData.bottom) * this.noY);
            this.mContentView.setPadding(this.npf, this.npg, this.nph, this.npi);
            this.bDM = l.getDimens(getContext(), R.dimen.fontsize40) * this.noY;
            String text = getText();
            this.npk = (i2 - this.npg) - this.npi;
            this.npl = (i - this.npf) - this.nph;
            this.npn = this.npm + l.getDimens(getContext(), R.dimen.ds6);
            setTextSize(0, this.bDM);
            if (TextUtils.isEmpty(text)) {
                g(getContext().getString(R.string.cover_hint), this.npl);
                this.bDM = this.noM.getTextSize();
                dPs();
                Nf();
            } else {
                if (af.getTextLengthAllOne(text) > 20) {
                    text = af.subStringWithAllOne(text, 20);
                    this.noM.setText(text);
                    this.noL.setText(text);
                }
                TP(text);
            }
        }
        this.noL.setIncludeFontPadding(false);
        this.noM.setIncludeFontPadding(false);
        this.noL.setLineSpacing(this.npm, 1.0f);
        this.noM.setLineSpacing(this.npm, 1.0f);
        this.noJ.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.noJ.getLayoutParams();
        layoutParams3.height = (this.npj * 2) + i2;
        layoutParams3.width = (this.npj * 2) + i;
        this.noJ.setLayoutParams(layoutParams3);
        this.npo = (this.npj * 2) + i;
        ((FrameLayout.LayoutParams) this.noK.getLayoutParams()).setMargins(this.npj, this.npj, this.npj, this.npj);
        this.noJ.setVisibility(0);
    }

    public Bitmap getTempBitmap() {
        if (this.npq == null) {
            dPt();
        }
        return this.npq;
    }

    private void dPt() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.npq = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public void dPu() {
        if (this.npq != null && !this.npq.isRecycled()) {
            this.npq.recycle();
            this.npq = null;
        }
    }

    public void xU(boolean z) {
        if (this.noP != 0) {
            if (z) {
                dPu();
                this.noJ.setVisibility(0);
                return;
            }
            hideSoftKeyPad();
            getTempBitmap();
            this.noJ.setVisibility(8);
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, Bitmap> entry : this.npp.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.npp.clear();
        this.npp = null;
        dPu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a implements b.a {
        WeakReference<a.b> nps;
        WeakReference<CoverPendantDragView> npt;
        WeakReference<PendantData> npu;

        public a(a.b bVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (bVar != null) {
                this.nps = new WeakReference<>(bVar);
            }
            if (coverPendantDragView != null) {
                this.npt = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.npu = new WeakReference<>(pendantData);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void gw(String str, String str2) {
            if (this.nps != null && this.nps.get() != null) {
                this.nps.get().nnH.setVisibility(8);
            }
            if (this.npt != null && this.npt.get() != null && this.npu != null && this.npu.get() != null) {
                this.npt.get().a(str2, this.npu.get());
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void TG(String str) {
            if (this.nps != null && this.nps.get() != null) {
                this.nps.get().nnH.setVisibility(8);
            }
            if (this.npt != null && this.npt.get() != null) {
                l.showToast(this.npt.get().getContext(), str);
            }
        }

        @Override // com.baidu.tieba.video.editvideo.model.b.a
        public void dOD() {
            if (this.nps != null && this.nps.get() != null) {
                this.nps.get().nnH.setVisibility(8);
            }
        }
    }
}
