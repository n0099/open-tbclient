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
    private float bTm;
    private float cFq;
    private float cKC;
    private EditText cKH;
    private ImageView cKI;
    private SearchEmotionModel.a cKq;
    private int ekR;
    private HListView frJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.a frK;
    private double frL;
    private int frM;
    private int frN;
    private int frO;
    private int frP;
    private b frQ;
    private RelativeLayout frR;
    private boolean frS;
    private boolean frT;
    private com.baidu.tieba.pb.pb.main.emotion.view.b frU;
    private TextWatcher frV;
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
        this.frT = false;
        this.frV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.frK.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frU == null) {
                        PbEmotionBar.this.frU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frU.a(PbEmotionBar.this.cKq);
                    }
                    PbEmotionBar.this.frU.qN(trim);
                }
            }
        };
        this.cKq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKH.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frK.setData(aVar.alA());
                    PbEmotionBar.this.frK.notifyDataSetChanged();
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
        this.frT = false;
        this.frV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.frK.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frU == null) {
                        PbEmotionBar.this.frU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frU.a(PbEmotionBar.this.cKq);
                    }
                    PbEmotionBar.this.frU.qN(trim);
                }
            }
        };
        this.cKq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKH.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frK.setData(aVar.alA());
                    PbEmotionBar.this.frK.notifyDataSetChanged();
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
        this.frT = false;
        this.frV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.frK.setData(PbEmotionBar.this.mData.alA());
                            PbEmotionBar.this.frK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.frU == null) {
                        PbEmotionBar.this.frU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.frU.a(PbEmotionBar.this.cKq);
                    }
                    PbEmotionBar.this.frU.qN(trim);
                }
            }
        };
        this.cKq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.alA()) && PbEmotionBar.this.cKH.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.frK.setData(aVar.alA());
                    PbEmotionBar.this.frK.notifyDataSetChanged();
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
        this.frJ = (HListView) findViewById(d.g.lv_emotion);
        this.frK = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.frK.a(this);
        this.frJ.setAdapter((ListAdapter) this.frK);
        this.frJ.setDividerWidth(l.e(getContext(), d.e.ds7));
        this.frJ.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.frR = (RelativeLayout) findViewById(d.g.layout_search);
        this.cKH = (EditText) findViewById(d.g.edit_search);
        this.cKI = (ImageView) findViewById(d.g.iv_search);
        this.cKH.addTextChangedListener(this.frV);
        this.cKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log("c12492");
            }
        });
        this.cKH.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.cKC = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.e(getContext(), d.e.ds150);
        this.frN = l.e(getContext(), d.e.ds60);
        this.frO = l.e(getContext(), d.e.ds114);
        this.ekR = l.e(getContext(), d.e.ds10);
        this.frM = this.mScreenWidth - l.e(getContext(), d.e.ds130);
        this.frL = (this.frN - this.frO) * (1.0d / this.frM);
        this.frP = l.e(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.alA() != null && !aVar.alA().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.frK.setData(aVar.alA());
            qB(this.frN);
            qC(this.frM);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.frM;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.frM && E(motionEvent)) {
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
        if (this.frJ.getChildCount() <= 0 || this.frJ.getFirstVisiblePosition() != 0 || (childAt = this.frJ.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cFq) {
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
            if (this.frT && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.frT = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.frT = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bTm = motionEvent.getRawY();
                this.cFq = motionEvent.getRawX();
                this.cFq = motionEvent.getRawX();
                break;
            case 2:
                this.cFq = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cFq));
                if (rawX2 >= 0) {
                    i = rawX2 > this.frM ? this.frM : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qA = qA(i);
                    if (qA <= this.frO && qA >= this.frN) {
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
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cKC && Math.abs(motionEvent.getRawY() - this.bTm) < this.cKC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qA(int i) {
        return (int) ((this.frL * i) + this.frO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(int i) {
        this.frJ.getLayoutParams().height = (this.ekR * 2) + i;
        this.frK.qB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qC(int i) {
        float f = 1.0f - ((i * 1.0f) / this.frM);
        this.frR.getLayoutParams().height = (int) (this.frP * f);
        this.frR.setAlpha(f);
        this.cKI.setScaleX(f);
        this.cKI.setScaleY(f);
        this.cKH.setTextSize(0, f * l.e(getContext(), d.e.fontsize32));
    }

    private void bp(int i, int i2) {
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
        int i2 = this.frM;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bp(i, i2);
    }

    public void ku(boolean z) {
        kt(true);
        if (z) {
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.cKH.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.cKH);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.frK != null) {
            this.frK.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.cKH.getText().toString(), PbEmotionBar.this.mData.baX(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.frS = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean alC() {
        return this.frS;
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
        if (this.frQ != null) {
            this.frQ.onMove((this.frM - i) * (1.0f / this.frM));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.frQ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.frK != null) {
            this.frK.aTN();
        }
        arg();
    }

    public void arg() {
        if (this.frU != null) {
            this.frU.arg();
        }
    }

    public void onChangeSkinType() {
        ak.h(this.cKH, d.C0126d.cp_cont_b);
        this.cKH.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.frK != null) {
            this.frK.notifyDataSetChanged();
        }
    }
}
