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
    private float bvV;
    private float dpp;
    private float duH;
    private EditText duM;
    private ImageView duN;
    private SearchEmotionModel.a duv;
    private int ffF;
    private HListView gjJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.a gjK;
    private double gjL;
    private int gjM;
    private int gjN;
    private int gjO;
    private int gjP;
    private b gjQ;
    private RelativeLayout gjR;
    private boolean gjS;
    private boolean gjT;
    private com.baidu.tieba.pb.pb.main.emotion.view.b gjU;
    private TextWatcher gjV;
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
        this.gjT = false;
        this.gjV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.gjK.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjU == null) {
                        PbEmotionBar.this.gjU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjU.a(PbEmotionBar.this.duv);
                    }
                    PbEmotionBar.this.gjU.tE(trim);
                }
            }
        };
        this.duv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjK.setData(aVar.axh());
                    PbEmotionBar.this.gjK.notifyDataSetChanged();
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
        this.gjT = false;
        this.gjV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.gjK.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjU == null) {
                        PbEmotionBar.this.gjU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjU.a(PbEmotionBar.this.duv);
                    }
                    PbEmotionBar.this.gjU.tE(trim);
                }
            }
        };
        this.duv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjK.setData(aVar.axh());
                    PbEmotionBar.this.gjK.notifyDataSetChanged();
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
        this.gjT = false;
        this.gjV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.gjK.setData(PbEmotionBar.this.mData.axh());
                            PbEmotionBar.this.gjK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gjU == null) {
                        PbEmotionBar.this.gjU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gjU.a(PbEmotionBar.this.duv);
                    }
                    PbEmotionBar.this.gjU.tE(trim);
                }
            }
        };
        this.duv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.axh()) && PbEmotionBar.this.duM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gjK.setData(aVar.axh());
                    PbEmotionBar.this.gjK.notifyDataSetChanged();
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
        this.gjJ = (HListView) findViewById(e.g.lv_emotion);
        this.gjK = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.gjK.a(this);
        this.gjJ.setAdapter((ListAdapter) this.gjK);
        this.gjJ.setDividerWidth(l.h(getContext(), e.C0210e.ds7));
        this.gjJ.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.gjR = (RelativeLayout) findViewById(e.g.layout_search);
        this.duM = (EditText) findViewById(e.g.edit_search);
        this.duN = (ImageView) findViewById(e.g.iv_search);
        this.duM.addTextChangedListener(this.gjV);
        this.duM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.duM.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.duH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0210e.ds150);
        this.gjN = l.h(getContext(), e.C0210e.ds60);
        this.gjO = l.h(getContext(), e.C0210e.ds114);
        this.ffF = l.h(getContext(), e.C0210e.ds10);
        this.gjM = this.mScreenWidth - l.h(getContext(), e.C0210e.ds130);
        this.gjL = (this.gjN - this.gjO) * (1.0d / this.gjM);
        this.gjP = l.h(getContext(), e.C0210e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.axh() != null && !aVar.axh().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.gjK.setData(aVar.axh());
            sT(this.gjN);
            sU(this.gjM);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.gjM;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.gjM && F(motionEvent)) {
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
        if (this.gjJ.getChildCount() <= 0 || this.gjJ.getFirstVisiblePosition() != 0 || (childAt = this.gjJ.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dpp) {
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
            if (this.gjT && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.gjT = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.gjT = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bvV = motionEvent.getRawY();
                this.dpp = motionEvent.getRawX();
                this.dpp = motionEvent.getRawX();
                break;
            case 2:
                this.dpp = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dpp));
                if (rawX2 >= 0) {
                    i = rawX2 > this.gjM ? this.gjM : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int sS = sS(i);
                    if (sS <= this.gjO && sS >= this.gjN) {
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
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.duH && Math.abs(motionEvent.getRawY() - this.bvV) < this.duH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sS(int i) {
        return (int) ((this.gjL * i) + this.gjO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT(int i) {
        this.gjJ.getLayoutParams().height = (this.ffF * 2) + i;
        this.gjK.sT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU(int i) {
        float f = 1.0f - ((i * 1.0f) / this.gjM);
        this.gjR.getLayoutParams().height = (int) (this.gjP * f);
        this.gjR.setAlpha(f);
        this.duN.setScaleX(f);
        this.duN.setScaleY(f);
        this.duM.setTextSize(0, f * l.h(getContext(), e.C0210e.fontsize32));
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
        int i2 = this.gjM;
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
                    PbEmotionBar.this.duM.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.duM);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.gjK != null) {
            this.gjK.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.duM.getText().toString(), PbEmotionBar.this.mData.bnr(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.gjS = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean axj() {
        return this.gjS;
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
        if (this.gjQ != null) {
            this.gjQ.onMove((this.gjM - i) * (1.0f / this.gjM));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.gjQ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.gjK != null) {
            this.gjK.bfI();
        }
        aEp();
    }

    public void aEp() {
        if (this.gjU != null) {
            this.gjU.aEp();
        }
    }

    public void onChangeSkinType() {
        al.h(this.duM, e.d.cp_cont_b);
        this.duM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gjK != null) {
            this.gjK.notifyDataSetChanged();
        }
    }
}
