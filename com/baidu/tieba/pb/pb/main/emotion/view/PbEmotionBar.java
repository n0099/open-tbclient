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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.e;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes6.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bvW;
    private float dpq;
    private float duI;
    private EditText duN;
    private ImageView duO;
    private SearchEmotionModel.a duw;
    private int ffG;
    private HListView gjK;
    private com.baidu.tieba.pb.pb.main.emotion.view.a gjL;
    private double gjM;
    private int gjN;
    private int gjO;
    private int gjP;
    private int gjQ;
    private b gjR;
    private RelativeLayout gjS;
    private boolean gjT;
    private boolean gjU;
    private com.baidu.tieba.pb.pb.main.emotion.view.b gjV;
    private TextWatcher gjW;
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
        this.gjU = false;
        this.gjW = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.axh())) {
                            PbEmotionBar.this.gjL.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjL.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjV == null) {
                        PbEmotionBar.this.gjV = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjV.a(PbEmotionBar.this.duw);
                    }
                    PbEmotionBar.this.gjV.tE(trim);
                }
            }
        };
        this.duw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjL.setData(aVar.axh());
                    PbEmotionBar.this.gjL.notifyDataSetChanged();
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
        this.gjU = false;
        this.gjW = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.axh())) {
                            PbEmotionBar.this.gjL.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjL.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjV == null) {
                        PbEmotionBar.this.gjV = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjV.a(PbEmotionBar.this.duw);
                    }
                    PbEmotionBar.this.gjV.tE(trim);
                }
            }
        };
        this.duw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjL.setData(aVar.axh());
                    PbEmotionBar.this.gjL.notifyDataSetChanged();
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
        this.gjU = false;
        this.gjW = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.axh())) {
                            PbEmotionBar.this.gjL.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjL.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjV == null) {
                        PbEmotionBar.this.gjV = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjV.a(PbEmotionBar.this.duw);
                    }
                    PbEmotionBar.this.gjV.tE(trim);
                }
            }
        };
        this.duw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjL.setData(aVar.axh());
                    PbEmotionBar.this.gjL.notifyDataSetChanged();
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
        this.gjK = (HListView) findViewById(e.g.lv_emotion);
        this.gjL = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.gjL.a(this);
        this.gjK.setAdapter((ListAdapter) this.gjL);
        this.gjK.setDividerWidth(l.h(getContext(), e.C0210e.ds7));
        this.gjK.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.gjS = (RelativeLayout) findViewById(e.g.layout_search);
        this.duN = (EditText) findViewById(e.g.edit_search);
        this.duO = (ImageView) findViewById(e.g.iv_search);
        this.duN.addTextChangedListener(this.gjW);
        this.duN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.duN.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int jc = z.jc(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = jc - z.d(obj.charAt(i6));
                        i6++;
                        jc = d;
                    }
                } else {
                    jc += z.jc(charSequence.toString());
                }
                if (jc > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.duI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0210e.ds150);
        this.gjO = l.h(getContext(), e.C0210e.ds60);
        this.gjP = l.h(getContext(), e.C0210e.ds114);
        this.ffG = l.h(getContext(), e.C0210e.ds10);
        this.gjN = this.mScreenWidth - l.h(getContext(), e.C0210e.ds130);
        this.gjM = (this.gjO - this.gjP) * (1.0d / this.gjN);
        this.gjQ = l.h(getContext(), e.C0210e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.axh() != null && !aVar.axh().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.gjL.setData(aVar.axh());
            sT(this.gjO);
            sU(this.gjN);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.gjN;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.gjN && F(motionEvent)) {
                    lC(true);
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
        if (this.gjK.getChildCount() <= 0 || this.gjK.getFirstVisiblePosition() != 0 || (childAt = this.gjK.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dpq) {
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
            if (this.gjU && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.gjU = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.gjU = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bvW = motionEvent.getRawY();
                this.dpq = motionEvent.getRawX();
                this.dpq = motionEvent.getRawX();
                break;
            case 2:
                this.dpq = motionEvent.getRawX();
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
                        lC(false);
                    } else {
                        lC(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    lC(false);
                } else {
                    lC(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dpq));
                if (rawX2 >= 0) {
                    i = rawX2 > this.gjN ? this.gjN : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int sS = sS(i);
                    if (sS <= this.gjP && sS >= this.gjO) {
                        sU(i);
                        sT(sS);
                        sV(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.duI && Math.abs(motionEvent.getRawY() - this.bvW) < this.duI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sS(int i) {
        return (int) ((this.gjM * i) + this.gjP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT(int i) {
        this.gjK.getLayoutParams().height = (this.ffG * 2) + i;
        this.gjL.sT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU(int i) {
        float f = 1.0f - ((i * 1.0f) / this.gjN);
        this.gjS.getLayoutParams().height = (int) (this.gjQ * f);
        this.gjS.setAlpha(f);
        this.duO.setScaleX(f);
        this.duO.setScaleY(f);
        this.duN.setTextSize(0, f * l.h(getContext(), e.C0210e.fontsize32));
    }

    private void bz(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.sU(intValue);
                    PbEmotionBar.this.sT(PbEmotionBar.this.sS(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.sV(layoutParams.leftMargin);
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

    public void lC(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.gjN;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bz(i, i2);
    }

    public void lD(boolean z) {
        lC(true);
        if (z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.duN.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.duN);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.gjL != null) {
            this.gjL.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.duN.getText().toString(), PbEmotionBar.this.mData.bnr(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.gjT = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean axj() {
        return this.gjT;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void axm() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void axn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(int i) {
        if (this.gjR != null) {
            this.gjR.onMove((this.gjN - i) * (1.0f / this.gjN));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.gjR = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.gjL != null) {
            this.gjL.bfI();
        }
        aEp();
    }

    public void aEp() {
        if (this.gjV != null) {
            this.gjV.aEp();
        }
    }

    public void onChangeSkinType() {
        al.h(this.duN, e.d.cp_cont_b);
        this.duN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gjL != null) {
            this.gjL.notifyDataSetChanged();
        }
    }
}
