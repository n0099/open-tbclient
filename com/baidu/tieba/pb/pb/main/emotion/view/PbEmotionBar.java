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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes6.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bqT;
    private float ddY;
    private float djD;
    private EditText djI;
    private ImageView djJ;
    private SearchEmotionModel.a djr;
    private int eTT;
    private int fXA;
    private int fXB;
    private int fXC;
    private b fXD;
    private RelativeLayout fXE;
    private boolean fXF;
    private boolean fXG;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fXH;
    private TextWatcher fXI;
    private HListView fXw;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fXx;
    private double fXy;
    private int fXz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.fXG = false;
        this.fXI = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.J(PbEmotionBar.this.mData.auL())) {
                            PbEmotionBar.this.fXx.setData(PbEmotionBar.this.mData.auL());
                            PbEmotionBar.this.fXx.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fXH == null) {
                        PbEmotionBar.this.fXH = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fXH.a(PbEmotionBar.this.djr);
                    }
                    PbEmotionBar.this.fXH.sI(trim);
                }
            }
        };
        this.djr = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.J(aVar.auL()) && PbEmotionBar.this.djI.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fXx.setData(aVar.auL());
                    PbEmotionBar.this.fXx.notifyDataSetChanged();
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
        this.fXG = false;
        this.fXI = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.J(PbEmotionBar.this.mData.auL())) {
                            PbEmotionBar.this.fXx.setData(PbEmotionBar.this.mData.auL());
                            PbEmotionBar.this.fXx.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fXH == null) {
                        PbEmotionBar.this.fXH = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fXH.a(PbEmotionBar.this.djr);
                    }
                    PbEmotionBar.this.fXH.sI(trim);
                }
            }
        };
        this.djr = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.J(aVar.auL()) && PbEmotionBar.this.djI.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fXx.setData(aVar.auL());
                    PbEmotionBar.this.fXx.notifyDataSetChanged();
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
        this.fXG = false;
        this.fXI = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.J(PbEmotionBar.this.mData.auL())) {
                            PbEmotionBar.this.fXx.setData(PbEmotionBar.this.mData.auL());
                            PbEmotionBar.this.fXx.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fXH == null) {
                        PbEmotionBar.this.fXH = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fXH.a(PbEmotionBar.this.djr);
                    }
                    PbEmotionBar.this.fXH.sI(trim);
                }
            }
        };
        this.djr = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.J(aVar.auL()) && PbEmotionBar.this.djI.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fXx.setData(aVar.auL());
                    PbEmotionBar.this.fXx.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i2, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(e.g.pb_emotion_bar);
        inflate(getContext(), e.h.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
        this.fXw = (HListView) findViewById(e.g.lv_emotion);
        this.fXx = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fXx.a(this);
        this.fXw.setAdapter((ListAdapter) this.fXx);
        this.fXw.setDividerWidth(l.h(getContext(), e.C0175e.ds7));
        this.fXw.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.fXE = (RelativeLayout) findViewById(e.g.layout_search);
        this.djI = (EditText) findViewById(e.g.edit_search);
        this.djJ = (ImageView) findViewById(e.g.iv_search);
        this.djI.addTextChangedListener(this.fXI);
        this.djI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.djI.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int is = y.is(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = is - y.d(obj.charAt(i6));
                        i6++;
                        is = d;
                    }
                } else {
                    is += y.is(charSequence.toString());
                }
                if (is > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.djD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0175e.ds150);
        this.fXA = l.h(getContext(), e.C0175e.ds60);
        this.fXB = l.h(getContext(), e.C0175e.ds114);
        this.eTT = l.h(getContext(), e.C0175e.ds10);
        this.fXz = this.mScreenWidth - l.h(getContext(), e.C0175e.ds130);
        this.fXy = (this.fXA - this.fXB) * (1.0d / this.fXz);
        this.fXC = l.h(getContext(), e.C0175e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.auL() != null && !aVar.auL().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fXx.setData(aVar.auL());
            rP(this.fXA);
            rQ(this.fXz);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fXz;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fXz && F(motionEvent)) {
                    ll(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return E(motionEvent);
    }

    private boolean E(MotionEvent motionEvent) {
        View childAt;
        if (F(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fXw.getChildCount() <= 0 || this.fXw.getFirstVisiblePosition() != 0 || (childAt = this.fXw.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.ddY) {
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
            if (this.fXG && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fXG = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fXG = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bqT = motionEvent.getRawY();
                this.ddY = motionEvent.getRawX();
                this.ddY = motionEvent.getRawX();
                break;
            case 2:
                this.ddY = motionEvent.getRawX();
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
                        ll(false);
                    } else {
                        ll(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    ll(false);
                } else {
                    ll(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.ddY));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fXz ? this.fXz : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int rO = rO(i);
                    if (rO <= this.fXB && rO >= this.fXA) {
                        rQ(i);
                        rP(rO);
                        rR(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.djD && Math.abs(motionEvent.getRawY() - this.bqT) < this.djD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rO(int i) {
        return (int) ((this.fXy * i) + this.fXB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        this.fXw.getLayoutParams().height = (this.eTT * 2) + i;
        this.fXx.rP(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fXz);
        this.fXE.getLayoutParams().height = (int) (this.fXC * f);
        this.fXE.setAlpha(f);
        this.djJ.setScaleX(f);
        this.djJ.setScaleY(f);
        this.djI.setTextSize(0, f * l.h(getContext(), e.C0175e.fontsize32));
    }

    private void by(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.rQ(intValue);
                    PbEmotionBar.this.rP(PbEmotionBar.this.rO(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.rR(layoutParams.leftMargin);
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

    public void ll(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fXz;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        by(i, i2);
    }

    public void lm(boolean z) {
        ll(true);
        if (z) {
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.djI.requestFocus();
                    l.b(PbEmotionBar.this.getContext(), PbEmotionBar.this.djI);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fXx != null) {
            this.fXx.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.djI.getText().toString(), PbEmotionBar.this.mData.bkI(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fXF = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean auN() {
        return this.fXF;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void auQ() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void auR() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        if (this.fXD != null) {
            this.fXD.onMove((this.fXz - i) * (1.0f / this.fXz));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fXD = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fXx != null) {
            this.fXx.bdh();
        }
        aBV();
    }

    public void aBV() {
        if (this.fXH != null) {
            this.fXH.aBV();
        }
    }

    public void onChangeSkinType() {
        al.h(this.djI, e.d.cp_cont_b);
        this.djI.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.fXx != null) {
            this.fXx.notifyDataSetChanged();
        }
    }
}
