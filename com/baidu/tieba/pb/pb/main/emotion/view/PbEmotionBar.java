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
import android.util.AttributeSet;
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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bTq;
    private float cFt;
    private float cKF;
    private EditText cKK;
    private ImageView cKL;
    private SearchEmotionModel.a cKt;
    private int ekU;
    private HListView frM;
    private com.baidu.tieba.pb.pb.main.emotion.view.a frN;
    private double frO;
    private int frP;
    private int frQ;
    private int frR;
    private int frS;
    private b frT;
    private RelativeLayout frU;
    private boolean frV;
    private boolean frW;
    private com.baidu.tieba.pb.pb.main.emotion.view.b frX;
    private TextWatcher frY;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.frW = false;
        this.frY = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.w(PbEmotionBar.this.mData.alA())) {
                            PbEmotionBar.this.frN.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frN.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frX == null) {
                        PbEmotionBar.this.frX = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frX.a(PbEmotionBar.this.cKt);
                    }
                    PbEmotionBar.this.frX.qN(trim);
                }
            }
        };
        this.cKt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKK.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frN.setData(aVar.alA());
                    PbEmotionBar.this.frN.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i, String str) {
            }
        };
        init();
    }

    public PbEmotionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.frW = false;
        this.frY = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.w(PbEmotionBar.this.mData.alA())) {
                            PbEmotionBar.this.frN.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frN.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frX == null) {
                        PbEmotionBar.this.frX = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frX.a(PbEmotionBar.this.cKt);
                    }
                    PbEmotionBar.this.frX.qN(trim);
                }
            }
        };
        this.cKt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKK.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frN.setData(aVar.alA());
                    PbEmotionBar.this.frN.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i, String str) {
            }
        };
        init();
    }

    public PbEmotionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.frW = false;
        this.frY = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    String trim = editable.toString().trim();
                    if (TextUtils.isEmpty(trim)) {
                        if (PbEmotionBar.this.mData != null && !v.w(PbEmotionBar.this.mData.alA())) {
                            PbEmotionBar.this.frN.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frN.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frX == null) {
                        PbEmotionBar.this.frX = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frX.a(PbEmotionBar.this.cKt);
                    }
                    PbEmotionBar.this.frX.qN(trim);
                }
            }
        };
        this.cKt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKK.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frN.setData(aVar.alA());
                    PbEmotionBar.this.frN.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i2, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(d.g.pb_emotion_bar);
        inflate(getContext(), d.i.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.C0126d.cp_bg_line_d));
        this.frM = (HListView) findViewById(d.g.lv_emotion);
        this.frN = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.frN.a(this);
        this.frM.setAdapter((ListAdapter) this.frN);
        this.frM.setDividerWidth(l.e(getContext(), d.e.ds7));
        this.frM.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.frU = (RelativeLayout) findViewById(d.g.layout_search);
        this.cKK = (EditText) findViewById(d.g.edit_search);
        this.cKL = (ImageView) findViewById(d.g.iv_search);
        this.cKK.addTextChangedListener(this.frY);
        this.cKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log("c12492");
            }
        });
        this.cKK.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hk = w.hk(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = hk - w.d(obj.charAt(i6));
                        i6++;
                        hk = d;
                    }
                } else {
                    hk += w.hk(charSequence.toString());
                }
                if (hk > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.af(getContext());
        this.cKF = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.e(getContext(), d.e.ds150);
        this.frQ = l.e(getContext(), d.e.ds60);
        this.frR = l.e(getContext(), d.e.ds114);
        this.ekU = l.e(getContext(), d.e.ds10);
        this.frP = this.mScreenWidth - l.e(getContext(), d.e.ds130);
        this.frO = (this.frQ - this.frR) * (1.0d / this.frP);
        this.frS = l.e(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.alA() != null && !aVar.alA().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.frN.setData(aVar.alA());
            qB(this.frQ);
            qC(this.frP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.frP;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.frP && E(motionEvent)) {
                    kt(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return D(motionEvent);
    }

    private boolean D(MotionEvent motionEvent) {
        View childAt;
        if (E(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.frM.getChildCount() <= 0 || this.frM.getFirstVisiblePosition() != 0 || (childAt = this.frM.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cFt) {
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
            if (this.frW && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.frW = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.frW = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bTq = motionEvent.getRawY();
                this.cFt = motionEvent.getRawX();
                this.cFt = motionEvent.getRawX();
                break;
            case 2:
                this.cFt = motionEvent.getRawX();
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
                int rawX = (int) (motionEvent.getRawX() - this.mDownX);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        kt(false);
                    } else {
                        kt(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kt(false);
                } else {
                    kt(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cFt));
                if (rawX2 >= 0) {
                    i = rawX2 > this.frP ? this.frP : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qA = qA(i);
                    if (qA <= this.frR && qA >= this.frQ) {
                        qC(i);
                        qB(qA);
                        qD(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cKF && Math.abs(motionEvent.getRawY() - this.bTq) < this.cKF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qA(int i) {
        return (int) ((this.frO * i) + this.frR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(int i) {
        this.frM.getLayoutParams().height = (this.ekU * 2) + i;
        this.frN.qB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qC(int i) {
        float f = 1.0f - ((i * 1.0f) / this.frP);
        this.frU.getLayoutParams().height = (int) (this.frS * f);
        this.frU.setAlpha(f);
        this.cKL.setScaleX(f);
        this.cKL.setScaleY(f);
        this.cKK.setTextSize(0, f * l.e(getContext(), d.e.fontsize32));
    }

    private void bq(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.qC(intValue);
                    PbEmotionBar.this.qB(PbEmotionBar.this.qA(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.qD(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((RelativeLayout.LayoutParams) PbEmotionBar.this.getLayoutParams()).leftMargin <= 0) {
                        PbEmotionBar.this.setCanShowEmotionPreview(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void kt(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.frP;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bq(i, i2);
    }

    public void ku(boolean z) {
        kt(true);
        if (z) {
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.cKK.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.cKK);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.frN != null) {
            this.frN.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.cKK.getText().toString(), PbEmotionBar.this.mData.baX(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.frV = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean alC() {
        return this.frV;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alF() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alG() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD(int i) {
        if (this.frT != null) {
            this.frT.onMove((this.frP - i) * (1.0f / this.frP));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.frT = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.frN != null) {
            this.frN.aTN();
        }
        arg();
    }

    public void arg() {
        if (this.frX != null) {
            this.frX.arg();
        }
    }

    public void onChangeSkinType() {
        ak.h(this.cKK, d.C0126d.cp_cont_b);
        this.cKK.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.frN != null) {
            this.frN.notifyDataSetChanged();
        }
    }
}
