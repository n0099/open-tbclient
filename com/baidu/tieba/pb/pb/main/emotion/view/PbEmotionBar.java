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
    private float bvh;
    private float doD;
    private SearchEmotionModel.a dtM;
    private float dtY;
    private EditText dud;
    private ImageView due;
    private int feS;
    private HListView giG;
    private com.baidu.tieba.pb.pb.main.emotion.view.a giH;
    private double giI;
    private int giJ;
    private int giK;
    private int giL;
    private int giM;
    private b giN;
    private RelativeLayout giO;
    private boolean giP;
    private boolean giQ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b giR;
    private TextWatcher giS;
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
        this.giQ = false;
        this.giS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.awK())) {
                            PbEmotionBar.this.giH.setData(PbEmotionBar.this.mData.awK());
                            PbEmotionBar.this.giH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.giR == null) {
                        PbEmotionBar.this.giR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.giR.a(PbEmotionBar.this.dtM);
                    }
                    PbEmotionBar.this.giR.to(trim);
                }
            }
        };
        this.dtM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.awK()) && PbEmotionBar.this.dud.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.giH.setData(aVar.awK());
                    PbEmotionBar.this.giH.notifyDataSetChanged();
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
        this.giQ = false;
        this.giS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.awK())) {
                            PbEmotionBar.this.giH.setData(PbEmotionBar.this.mData.awK());
                            PbEmotionBar.this.giH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.giR == null) {
                        PbEmotionBar.this.giR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.giR.a(PbEmotionBar.this.dtM);
                    }
                    PbEmotionBar.this.giR.to(trim);
                }
            }
        };
        this.dtM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.awK()) && PbEmotionBar.this.dud.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.giH.setData(aVar.awK());
                    PbEmotionBar.this.giH.notifyDataSetChanged();
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
        this.giQ = false;
        this.giS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.awK())) {
                            PbEmotionBar.this.giH.setData(PbEmotionBar.this.mData.awK());
                            PbEmotionBar.this.giH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.giR == null) {
                        PbEmotionBar.this.giR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.giR.a(PbEmotionBar.this.dtM);
                    }
                    PbEmotionBar.this.giR.to(trim);
                }
            }
        };
        this.dtM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.awK()) && PbEmotionBar.this.dud.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.giH.setData(aVar.awK());
                    PbEmotionBar.this.giH.notifyDataSetChanged();
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
        this.giG = (HListView) findViewById(e.g.lv_emotion);
        this.giH = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.giH.a(this);
        this.giG.setAdapter((ListAdapter) this.giH);
        this.giG.setDividerWidth(l.h(getContext(), e.C0210e.ds7));
        this.giG.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.giO = (RelativeLayout) findViewById(e.g.layout_search);
        this.dud = (EditText) findViewById(e.g.edit_search);
        this.due = (ImageView) findViewById(e.g.iv_search);
        this.dud.addTextChangedListener(this.giS);
        this.dud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dud.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int iM = y.iM(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = iM - y.d(obj.charAt(i6));
                        i6++;
                        iM = d;
                    }
                } else {
                    iM += y.iM(charSequence.toString());
                }
                if (iM > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.dtY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0210e.ds150);
        this.giK = l.h(getContext(), e.C0210e.ds60);
        this.giL = l.h(getContext(), e.C0210e.ds114);
        this.feS = l.h(getContext(), e.C0210e.ds10);
        this.giJ = this.mScreenWidth - l.h(getContext(), e.C0210e.ds130);
        this.giI = (this.giK - this.giL) * (1.0d / this.giJ);
        this.giM = l.h(getContext(), e.C0210e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.awK() != null && !aVar.awK().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.giH.setData(aVar.awK());
            sP(this.giK);
            sQ(this.giJ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.giJ;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.giJ && F(motionEvent)) {
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
        if (this.giG.getChildCount() <= 0 || this.giG.getFirstVisiblePosition() != 0 || (childAt = this.giG.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.doD) {
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
            if (this.giQ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.giQ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.giQ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bvh = motionEvent.getRawY();
                this.doD = motionEvent.getRawX();
                this.doD = motionEvent.getRawX();
                break;
            case 2:
                this.doD = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.doD));
                if (rawX2 >= 0) {
                    i = rawX2 > this.giJ ? this.giJ : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int sO = sO(i);
                    if (sO <= this.giL && sO >= this.giK) {
                        sQ(i);
                        sP(sO);
                        sR(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dtY && Math.abs(motionEvent.getRawY() - this.bvh) < this.dtY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sO(int i) {
        return (int) ((this.giI * i) + this.giL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i) {
        this.giG.getLayoutParams().height = (this.feS * 2) + i;
        this.giH.sP(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(int i) {
        float f = 1.0f - ((i * 1.0f) / this.giJ);
        this.giO.getLayoutParams().height = (int) (this.giM * f);
        this.giO.setAlpha(f);
        this.due.setScaleX(f);
        this.due.setScaleY(f);
        this.dud.setTextSize(0, f * l.h(getContext(), e.C0210e.fontsize32));
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
                    PbEmotionBar.this.sQ(intValue);
                    PbEmotionBar.this.sP(PbEmotionBar.this.sO(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.sR(layoutParams.leftMargin);
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
        int i2 = this.giJ;
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
                    PbEmotionBar.this.dud.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.dud);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.giH != null) {
            this.giH.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.dud.getText().toString(), PbEmotionBar.this.mData.bmJ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.giP = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean awM() {
        return this.giP;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awP() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sR(int i) {
        if (this.giN != null) {
            this.giN.onMove((this.giJ - i) * (1.0f / this.giJ));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.giN = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.giH != null) {
            this.giH.bfi();
        }
        aDS();
    }

    public void aDS() {
        if (this.giR != null) {
            this.giR.aDS();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dud, e.d.cp_cont_b);
        this.dud.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.giH != null) {
            this.giH.notifyDataSetChanged();
        }
    }
}
