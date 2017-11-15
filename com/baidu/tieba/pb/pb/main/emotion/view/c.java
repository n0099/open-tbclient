package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout implements EmotionView.a {
    private float EP;
    private float bCr;
    private float cil;
    private float cmM;
    private EditText cmR;
    private ImageView cmS;
    private SearchEmotionModel.a cmz;
    private int dPx;
    private HListView eXE;
    private d eXF;
    private double eXG;
    private int eXH;
    private int eXI;
    private int eXJ;
    private int eXK;
    private b eXL;
    private RelativeLayout eXM;
    private boolean eXN;
    private boolean eXO;
    private e eXP;
    private TextWatcher eXQ;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onMove(float f);
    }

    public c(Context context) {
        super(context);
        this.eXO = false;
        this.eXQ = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    String trim = editable.toString().trim();
                    if (TextUtils.isEmpty(trim)) {
                        if (c.this.mData != null && !v.v(c.this.mData.afU())) {
                            c.this.eXF.setData(c.this.mData.afU());
                            c.this.eXF.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (c.this.eXP == null) {
                        c.this.eXP = new e();
                        c.this.eXP.a(c.this.cmz);
                    }
                    c.this.eXP.pR(trim);
                }
            }
        };
        this.cmz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.v(aVar.afU()) && c.this.cmR.getText().toString().trim().equals(str)) {
                    c.this.eXF.setData(aVar.afU());
                    c.this.eXF.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(d.g.pb_emotion_bar);
        inflate(getContext(), d.h.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.C0080d.cp_bg_line_d));
        this.eXE = (HListView) findViewById(d.g.lv_emotion);
        this.eXF = new d();
        this.eXF.a(this);
        this.eXE.setAdapter((ListAdapter) this.eXF);
        this.eXE.setDividerWidth(l.f(getContext(), d.e.ds7));
        this.eXE.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.eXM = (RelativeLayout) findViewById(d.g.layout_search);
        this.cmR = (EditText) findViewById(d.g.edit_search);
        this.cmS = (ImageView) findViewById(d.g.iv_search);
        this.cmR.addTextChangedListener(this.eXQ);
        this.cmR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cmR.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gW = w.gW(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gW - w.e(obj.charAt(i6));
                        i6++;
                        gW = e;
                    }
                } else {
                    gW += w.gW(charSequence.toString());
                }
                if (gW > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ac(getContext());
        this.cmM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.e.ds150);
        this.eXI = l.f(getContext(), d.e.ds60);
        this.eXJ = l.f(getContext(), d.e.ds114);
        this.dPx = l.f(getContext(), d.e.ds10);
        this.eXH = this.mScreenWidth - l.f(getContext(), d.e.ds130);
        this.eXG = (this.eXI - this.eXJ) * (1.0d / this.eXH);
        this.eXK = l.f(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.afU() != null && !aVar.afU().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.eXF.setData(aVar.afU());
            pX(this.eXI);
            pY(this.eXH);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eXH;
            layoutParams.addRule(12);
            relativeLayout.addView(this, layoutParams);
            if (!z) {
                setVisibility(8);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.eXH && v(motionEvent)) {
                    jD(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return w(motionEvent);
    }

    private boolean w(MotionEvent motionEvent) {
        View childAt;
        if (v(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.eXE.getChildCount() <= 0 || this.eXE.getFirstVisiblePosition() != 0 || (childAt = this.eXE.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cil) {
            setCanShowEmotionPreview(true);
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        boolean dispatchTouchEvent2;
        this.mParent.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.eXO && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.eXO = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.eXO = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.EP = motionEvent.getRawX();
                this.bCr = motionEvent.getRawY();
                this.cil = motionEvent.getRawX();
                this.cil = motionEvent.getRawX();
                break;
            case 2:
                this.cil = motionEvent.getRawX();
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.EP);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        jD(false);
                    } else {
                        jD(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jD(false);
                } else {
                    jD(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cil));
                if (rawX2 >= 0) {
                    i = rawX2 > this.eXH ? this.eXH : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int pW = pW(i);
                    if (pW <= this.eXJ && pW >= this.eXI) {
                        pY(i);
                        pX(pW);
                        pZ(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmM && Math.abs(motionEvent.getRawY() - this.bCr) < this.cmM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pW(int i) {
        return (int) ((this.eXG * i) + this.eXJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        this.eXE.getLayoutParams().height = (this.dPx * 2) + i;
        this.eXF.pX(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(int i) {
        float f = 1.0f - ((i * 1.0f) / this.eXH);
        this.eXM.getLayoutParams().height = (int) (this.eXK * f);
        this.eXM.setAlpha(f);
        this.cmS.setScaleX(f);
        this.cmS.setScaleY(f);
        this.cmR.setTextSize(0, f * l.f(getContext(), d.e.fontsize32));
    }

    private void bx(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    c.this.pY(intValue);
                    c.this.pX(c.this.pW(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pZ(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((RelativeLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanShowEmotionPreview(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void jD(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eXH;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bx(i, i2);
    }

    public void jE(boolean z) {
        jD(true);
        if (z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.cmR.requestFocus();
                    l.b(c.this.getContext(), c.this.cmR);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.eXF != null) {
            this.eXF.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (c.this.mData != null) {
                        aVar.a(c.this.cmR.getText().toString(), c.this.mData.aVA(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.eXN = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean afW() {
        return this.eXN;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afZ() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aga() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(int i) {
        if (this.eXL != null) {
            this.eXL.onMove((this.eXH - i) * (1.0f / this.eXH));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eXL = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.eXF != null) {
            this.eXF.aOQ();
        }
        akY();
    }

    public void akY() {
        if (this.eXP != null) {
            this.eXP.akY();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cmR, d.C0080d.cp_cont_b);
        aj.k(this, d.C0080d.cp_bg_line_d);
        if (this.eXF != null) {
            this.eXF.notifyDataSetChanged();
        }
    }
}
