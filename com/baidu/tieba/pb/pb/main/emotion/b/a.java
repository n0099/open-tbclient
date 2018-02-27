package com.baidu.tieba.pb.pb.main.emotion.b;

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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
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
/* loaded from: classes2.dex */
public class a extends LinearLayout implements EmotionView.a {
    private float cDi;
    private float dnk;
    private float drL;
    private EditText drQ;
    private ImageView drR;
    private SearchEmotionModel.a drz;
    private int eQq;
    private boolean fXA;
    private c fXB;
    private TextWatcher fXC;
    private HListView fXq;
    private com.baidu.tieba.pb.pb.main.emotion.b.b fXr;
    private double fXs;
    private int fXt;
    private int fXu;
    private int fXv;
    private int fXw;
    private b fXx;
    private RelativeLayout fXy;
    private boolean fXz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0211a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.fXA = false;
        this.fXC = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.E(a.this.mData.arj())) {
                            a.this.fXr.setData(a.this.mData.arj());
                            a.this.fXr.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.fXB == null) {
                        a.this.fXB = new c();
                        a.this.fXB.a(a.this.drz);
                    }
                    a.this.fXB.qH(trim);
                }
            }
        };
        this.drz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.E(aVar.arj()) && a.this.drQ.getText().toString().trim().equals(str)) {
                    a.this.fXr.setData(aVar.arj());
                    a.this.fXr.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0141d.cp_bg_line_d));
        this.fXq = (HListView) findViewById(d.g.lv_emotion);
        this.fXr = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.fXr.a(this);
        this.fXq.setAdapter((ListAdapter) this.fXr);
        this.fXq.setDividerWidth(l.t(getContext(), d.e.ds7));
        this.fXq.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fXy = (RelativeLayout) findViewById(d.g.layout_search);
        this.drQ = (EditText) findViewById(d.g.edit_search);
        this.drR = (ImageView) findViewById(d.g.iv_search);
        this.drQ.addTextChangedListener(this.fXC);
        this.drQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.drQ.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hs = w.hs(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = hs - w.e(obj.charAt(i6));
                        i6++;
                        hs = e;
                    }
                } else {
                    hs += w.hs(charSequence.toString());
                }
                if (hs > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ao(getContext());
        this.drL = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.t(getContext(), d.e.ds150);
        this.fXu = l.t(getContext(), d.e.ds60);
        this.fXv = l.t(getContext(), d.e.ds114);
        this.eQq = l.t(getContext(), d.e.ds10);
        this.fXt = this.mScreenWidth - l.t(getContext(), d.e.ds130);
        this.fXs = (this.fXu - this.fXv) * (1.0d / this.fXt);
        this.fXw = l.t(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.arj() != null && !aVar.arj().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fXr.setData(aVar.arj());
            tg(this.fXu);
            th(this.fXt);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fXt;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fXt && M(motionEvent)) {
                    kR(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return L(motionEvent);
    }

    private boolean L(MotionEvent motionEvent) {
        View childAt;
        if (M(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fXq.getChildCount() <= 0 || this.fXq.getFirstVisiblePosition() != 0 || (childAt = this.fXq.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dnk) {
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
            if (this.fXA && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fXA = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fXA = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cDi = motionEvent.getRawY();
                this.dnk = motionEvent.getRawX();
                this.dnk = motionEvent.getRawX();
                break;
            case 2:
                this.dnk = motionEvent.getRawX();
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
                        kR(false);
                    } else {
                        kR(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kR(false);
                } else {
                    kR(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dnk));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fXt ? this.fXt : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int tf = tf(i);
                    if (tf <= this.fXv && tf >= this.fXu) {
                        th(i);
                        tg(tf);
                        ti(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drL && Math.abs(motionEvent.getRawY() - this.cDi) < this.drL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tf(int i) {
        return (int) ((this.fXs * i) + this.fXv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(int i) {
        this.fXq.getLayoutParams().height = (this.eQq * 2) + i;
        this.fXr.tg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fXt);
        this.fXy.getLayoutParams().height = (int) (this.fXw * f);
        this.fXy.setAlpha(f);
        this.drR.setScaleX(f);
        this.drR.setScaleY(f);
        this.drQ.setTextSize(0, f * l.t(getContext(), d.e.fontsize32));
    }

    private void cp(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.th(intValue);
                    a.this.tg(a.this.tf(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.ti(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((RelativeLayout.LayoutParams) a.this.getLayoutParams()).leftMargin <= 0) {
                        a.this.setCanShowEmotionPreview(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void kR(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fXt;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        cp(i, i2);
    }

    public void kS(boolean z) {
        kR(true);
        if (z) {
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.drQ.requestFocus();
                    l.b(a.this.getContext(), a.this.drQ);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0211a interfaceC0211a) {
        if (interfaceC0211a != null && this.fXr != null) {
            this.fXr.a(new InterfaceC0211a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0211a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0211a.a(a.this.drQ.getText().toString(), a.this.mData.bfZ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fXz = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arl() {
        return this.fXz;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aro() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i) {
        if (this.fXx != null) {
            this.fXx.onMove((this.fXt - i) * (1.0f / this.fXt));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fXx = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fXr != null) {
            this.fXr.aYR();
        }
        awO();
    }

    public void awO() {
        if (this.fXB != null) {
            this.fXB.awO();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.drQ, d.C0141d.cp_cont_b);
        this.drQ.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.t(this, d.C0141d.cp_bg_line_d);
        if (this.fXr != null) {
            this.fXr.notifyDataSetChanged();
        }
    }
}
