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
    private float bve;
    private float dlL;
    private SearchEmotionModel.a dqY;
    private float drk;
    private EditText drp;
    private ImageView drq;
    private int fcb;
    private HListView gfN;
    private com.baidu.tieba.pb.pb.main.emotion.view.a gfO;
    private double gfP;
    private int gfQ;
    private int gfR;
    private int gfS;
    private int gfT;
    private b gfU;
    private RelativeLayout gfV;
    private boolean gfW;
    private boolean gfX;
    private com.baidu.tieba.pb.pb.main.emotion.view.b gfY;
    private TextWatcher gfZ;
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
        this.gfX = false;
        this.gfZ = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.avV())) {
                            PbEmotionBar.this.gfO.setData(PbEmotionBar.this.mData.avV());
                            PbEmotionBar.this.gfO.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gfY == null) {
                        PbEmotionBar.this.gfY = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gfY.a(PbEmotionBar.this.dqY);
                    }
                    PbEmotionBar.this.gfY.tl(trim);
                }
            }
        };
        this.dqY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.avV()) && PbEmotionBar.this.drp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gfO.setData(aVar.avV());
                    PbEmotionBar.this.gfO.notifyDataSetChanged();
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
        this.gfX = false;
        this.gfZ = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.avV())) {
                            PbEmotionBar.this.gfO.setData(PbEmotionBar.this.mData.avV());
                            PbEmotionBar.this.gfO.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gfY == null) {
                        PbEmotionBar.this.gfY = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gfY.a(PbEmotionBar.this.dqY);
                    }
                    PbEmotionBar.this.gfY.tl(trim);
                }
            }
        };
        this.dqY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.avV()) && PbEmotionBar.this.drp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gfO.setData(aVar.avV());
                    PbEmotionBar.this.gfO.notifyDataSetChanged();
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
        this.gfX = false;
        this.gfZ = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.avV())) {
                            PbEmotionBar.this.gfO.setData(PbEmotionBar.this.mData.avV());
                            PbEmotionBar.this.gfO.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.gfY == null) {
                        PbEmotionBar.this.gfY = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.gfY.a(PbEmotionBar.this.dqY);
                    }
                    PbEmotionBar.this.gfY.tl(trim);
                }
            }
        };
        this.dqY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.avV()) && PbEmotionBar.this.drp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.gfO.setData(aVar.avV());
                    PbEmotionBar.this.gfO.notifyDataSetChanged();
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
        this.gfN = (HListView) findViewById(e.g.lv_emotion);
        this.gfO = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.gfO.a(this);
        this.gfN.setAdapter((ListAdapter) this.gfO);
        this.gfN.setDividerWidth(l.h(getContext(), e.C0210e.ds7));
        this.gfN.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.gfV = (RelativeLayout) findViewById(e.g.layout_search);
        this.drp = (EditText) findViewById(e.g.edit_search);
        this.drq = (ImageView) findViewById(e.g.iv_search);
        this.drp.addTextChangedListener(this.gfZ);
        this.drp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.drp.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int iL = y.iL(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = iL - y.d(obj.charAt(i6));
                        i6++;
                        iL = d;
                    }
                } else {
                    iL += y.iL(charSequence.toString());
                }
                if (iL > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.drk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0210e.ds150);
        this.gfR = l.h(getContext(), e.C0210e.ds60);
        this.gfS = l.h(getContext(), e.C0210e.ds114);
        this.fcb = l.h(getContext(), e.C0210e.ds10);
        this.gfQ = this.mScreenWidth - l.h(getContext(), e.C0210e.ds130);
        this.gfP = (this.gfR - this.gfS) * (1.0d / this.gfQ);
        this.gfT = l.h(getContext(), e.C0210e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.avV() != null && !aVar.avV().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.gfO.setData(aVar.avV());
            sC(this.gfR);
            sD(this.gfQ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.gfQ;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.gfQ && G(motionEvent)) {
                    lz(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return F(motionEvent);
    }

    private boolean F(MotionEvent motionEvent) {
        View childAt;
        if (G(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.gfN.getChildCount() <= 0 || this.gfN.getFirstVisiblePosition() != 0 || (childAt = this.gfN.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dlL) {
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
            if (this.gfX && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.gfX = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.gfX = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bve = motionEvent.getRawY();
                this.dlL = motionEvent.getRawX();
                this.dlL = motionEvent.getRawX();
                break;
            case 2:
                this.dlL = motionEvent.getRawX();
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
                        lz(false);
                    } else {
                        lz(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    lz(false);
                } else {
                    lz(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dlL));
                if (rawX2 >= 0) {
                    i = rawX2 > this.gfQ ? this.gfQ : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int sB = sB(i);
                    if (sB <= this.gfS && sB >= this.gfR) {
                        sD(i);
                        sC(sB);
                        sE(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drk && Math.abs(motionEvent.getRawY() - this.bve) < this.drk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sB(int i) {
        return (int) ((this.gfP * i) + this.gfS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(int i) {
        this.gfN.getLayoutParams().height = (this.fcb * 2) + i;
        this.gfO.sC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(int i) {
        float f = 1.0f - ((i * 1.0f) / this.gfQ);
        this.gfV.getLayoutParams().height = (int) (this.gfT * f);
        this.gfV.setAlpha(f);
        this.drq.setScaleX(f);
        this.drq.setScaleY(f);
        this.drp.setTextSize(0, f * l.h(getContext(), e.C0210e.fontsize32));
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
                    PbEmotionBar.this.sD(intValue);
                    PbEmotionBar.this.sC(PbEmotionBar.this.sB(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.sE(layoutParams.leftMargin);
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

    public void lz(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.gfQ;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        by(i, i2);
    }

    public void lA(boolean z) {
        lz(true);
        if (z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.drp.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.drp);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.gfO != null) {
            this.gfO.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.drp.getText().toString(), PbEmotionBar.this.mData.blY(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.gfW = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean avX() {
        return this.gfW;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awa() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sE(int i) {
        if (this.gfU != null) {
            this.gfU.onMove((this.gfQ - i) * (1.0f / this.gfQ));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.gfU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.gfO != null) {
            this.gfO.bex();
        }
        aDd();
    }

    public void aDd() {
        if (this.gfY != null) {
            this.gfY.aDd();
        }
    }

    public void onChangeSkinType() {
        al.h(this.drp, e.d.cp_cont_b);
        this.drp.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.gfO != null) {
            this.gfO.notifyDataSetChanged();
        }
    }
}
