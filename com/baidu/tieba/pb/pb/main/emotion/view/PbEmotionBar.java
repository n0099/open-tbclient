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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float cNj;
    private SearchEmotionModel.a cSF;
    private float cSR;
    private EditText cSW;
    private ImageView cSX;
    private float ceo;
    private int eBg;
    private HListView fIi;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fIj;
    private double fIk;
    private int fIl;
    private int fIm;
    private int fIn;
    private int fIo;
    private b fIp;
    private RelativeLayout fIq;
    private boolean fIr;
    private boolean fIs;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fIt;
    private TextWatcher fIu;
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
        this.fIs = false;
        this.fIu = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.A(PbEmotionBar.this.mData.apa())) {
                            PbEmotionBar.this.fIj.setData(PbEmotionBar.this.mData.apa());
                            PbEmotionBar.this.fIj.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIt == null) {
                        PbEmotionBar.this.fIt = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIt.a(PbEmotionBar.this.cSF);
                    }
                    PbEmotionBar.this.fIt.rD(trim);
                }
            }
        };
        this.cSF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.A(aVar.apa()) && PbEmotionBar.this.cSW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIj.setData(aVar.apa());
                    PbEmotionBar.this.fIj.notifyDataSetChanged();
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
        this.fIs = false;
        this.fIu = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.A(PbEmotionBar.this.mData.apa())) {
                            PbEmotionBar.this.fIj.setData(PbEmotionBar.this.mData.apa());
                            PbEmotionBar.this.fIj.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIt == null) {
                        PbEmotionBar.this.fIt = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIt.a(PbEmotionBar.this.cSF);
                    }
                    PbEmotionBar.this.fIt.rD(trim);
                }
            }
        };
        this.cSF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.A(aVar.apa()) && PbEmotionBar.this.cSW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIj.setData(aVar.apa());
                    PbEmotionBar.this.fIj.notifyDataSetChanged();
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
        this.fIs = false;
        this.fIu = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.A(PbEmotionBar.this.mData.apa())) {
                            PbEmotionBar.this.fIj.setData(PbEmotionBar.this.mData.apa());
                            PbEmotionBar.this.fIj.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIt == null) {
                        PbEmotionBar.this.fIt = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIt.a(PbEmotionBar.this.cSF);
                    }
                    PbEmotionBar.this.fIt.rD(trim);
                }
            }
        };
        this.cSF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.A(aVar.apa()) && PbEmotionBar.this.cSW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIj.setData(aVar.apa());
                    PbEmotionBar.this.fIj.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0142d.cp_bg_line_d));
        this.fIi = (HListView) findViewById(d.g.lv_emotion);
        this.fIj = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fIj.a(this);
        this.fIi.setAdapter((ListAdapter) this.fIj);
        this.fIi.setDividerWidth(l.e(getContext(), d.e.ds7));
        this.fIi.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fIq = (RelativeLayout) findViewById(d.g.layout_search);
        this.cSW = (EditText) findViewById(d.g.edit_search);
        this.cSX = (ImageView) findViewById(d.g.iv_search);
        this.cSW.addTextChangedListener(this.fIu);
        this.cSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cSW.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hK = x.hK(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = hK - x.d(obj.charAt(i6));
                        i6++;
                        hK = d;
                    }
                } else {
                    hK += x.hK(charSequence.toString());
                }
                if (hK > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ah(getContext());
        this.cSR = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.e(getContext(), d.e.ds150);
        this.fIm = l.e(getContext(), d.e.ds60);
        this.fIn = l.e(getContext(), d.e.ds114);
        this.eBg = l.e(getContext(), d.e.ds10);
        this.fIl = this.mScreenWidth - l.e(getContext(), d.e.ds130);
        this.fIk = (this.fIm - this.fIn) * (1.0d / this.fIl);
        this.fIo = l.e(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.apa() != null && !aVar.apa().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fIj.setData(aVar.apa());
            qU(this.fIm);
            qV(this.fIl);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fIl;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fIl && F(motionEvent)) {
                    kK(true);
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
        if (this.fIi.getChildCount() <= 0 || this.fIi.getFirstVisiblePosition() != 0 || (childAt = this.fIi.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cNj) {
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
            if (this.fIs && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fIs = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fIs = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.ceo = motionEvent.getRawY();
                this.cNj = motionEvent.getRawX();
                this.cNj = motionEvent.getRawX();
                break;
            case 2:
                this.cNj = motionEvent.getRawX();
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
                        kK(false);
                    } else {
                        kK(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kK(false);
                } else {
                    kK(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cNj));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fIl ? this.fIl : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qT = qT(i);
                    if (qT <= this.fIn && qT >= this.fIm) {
                        qV(i);
                        qU(qT);
                        qW(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cSR && Math.abs(motionEvent.getRawY() - this.ceo) < this.cSR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qT(int i) {
        return (int) ((this.fIk * i) + this.fIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU(int i) {
        this.fIi.getLayoutParams().height = (this.eBg * 2) + i;
        this.fIj.qU(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fIl);
        this.fIq.getLayoutParams().height = (int) (this.fIo * f);
        this.fIq.setAlpha(f);
        this.cSX.setScaleX(f);
        this.cSX.setScaleY(f);
        this.cSW.setTextSize(0, f * l.e(getContext(), d.e.fontsize32));
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
                    PbEmotionBar.this.qV(intValue);
                    PbEmotionBar.this.qU(PbEmotionBar.this.qT(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.qW(layoutParams.leftMargin);
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

    public void kK(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fIl;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bq(i, i2);
    }

    public void kL(boolean z) {
        kK(true);
        if (z) {
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.cSW.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.cSW);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fIj != null) {
            this.fIj.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.cSW.getText().toString(), PbEmotionBar.this.mData.bgE(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fIr = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apc() {
        return this.fIr;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apf() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(int i) {
        if (this.fIp != null) {
            this.fIp.onMove((this.fIl - i) * (1.0f / this.fIl));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fIp = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fIj != null) {
            this.fIj.aZq();
        }
        avN();
    }

    public void avN() {
        if (this.fIt != null) {
            this.fIt.avN();
        }
    }

    public void onChangeSkinType() {
        am.h(this.cSW, d.C0142d.cp_cont_b);
        this.cSW.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        am.j(this, d.C0142d.cp_bg_line_d);
        if (this.fIj != null) {
            this.fIj.notifyDataSetChanged();
        }
    }
}
