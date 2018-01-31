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
/* loaded from: classes2.dex */
public class a extends LinearLayout implements EmotionView.a {
    private float czA;
    private float dkG;
    private SearchEmotionModel.a doS;
    private float dpe;
    private EditText dpj;
    private ImageView dpk;
    private int eMt;
    private c fUA;
    private TextWatcher fUB;
    private HListView fUp;
    private com.baidu.tieba.pb.pb.main.emotion.b.b fUq;
    private double fUr;
    private int fUs;
    private int fUt;
    private int fUu;
    private int fUv;
    private b fUw;
    private RelativeLayout fUx;
    private boolean fUy;
    private boolean fUz;
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
    public interface InterfaceC0142a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.fUz = false;
        this.fUB = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.E(a.this.mData.aqu())) {
                            a.this.fUq.setData(a.this.mData.aqu());
                            a.this.fUq.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.fUA == null) {
                        a.this.fUA = new c();
                        a.this.fUA.a(a.this.doS);
                    }
                    a.this.fUA.qy(trim);
                }
            }
        };
        this.doS = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.E(aVar.aqu()) && a.this.dpj.getText().toString().trim().equals(str)) {
                    a.this.fUq.setData(aVar.aqu());
                    a.this.fUq.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0108d.cp_bg_line_d));
        this.fUp = (HListView) findViewById(d.g.lv_emotion);
        this.fUq = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.fUq.a(this);
        this.fUp.setAdapter((ListAdapter) this.fUq);
        this.fUp.setDividerWidth(l.s(getContext(), d.e.ds7));
        this.fUp.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fUx = (RelativeLayout) findViewById(d.g.layout_search);
        this.dpj = (EditText) findViewById(d.g.edit_search);
        this.dpk = (ImageView) findViewById(d.g.iv_search);
        this.dpj.addTextChangedListener(this.fUB);
        this.dpj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dpj.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hi = w.hi(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = hi - w.e(obj.charAt(i6));
                        i6++;
                        hi = e;
                    }
                } else {
                    hi += w.hi(charSequence.toString());
                }
                if (hi > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ao(getContext());
        this.dpe = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.s(getContext(), d.e.ds150);
        this.fUt = l.s(getContext(), d.e.ds60);
        this.fUu = l.s(getContext(), d.e.ds114);
        this.eMt = l.s(getContext(), d.e.ds10);
        this.fUs = this.mScreenWidth - l.s(getContext(), d.e.ds130);
        this.fUr = (this.fUt - this.fUu) * (1.0d / this.fUs);
        this.fUv = l.s(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.aqu() != null && !aVar.aqu().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fUq.setData(aVar.aqu());
            tb(this.fUt);
            tc(this.fUs);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fUs;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fUs && I(motionEvent)) {
                    kI(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return H(motionEvent);
    }

    private boolean H(MotionEvent motionEvent) {
        View childAt;
        if (I(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fUp.getChildCount() <= 0 || this.fUp.getFirstVisiblePosition() != 0 || (childAt = this.fUp.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dkG) {
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
            if (this.fUz && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fUz = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fUz = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.czA = motionEvent.getRawY();
                this.dkG = motionEvent.getRawX();
                this.dkG = motionEvent.getRawX();
                break;
            case 2:
                this.dkG = motionEvent.getRawX();
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
                        kI(false);
                    } else {
                        kI(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kI(false);
                } else {
                    kI(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dkG));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fUs ? this.fUs : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int ta = ta(i);
                    if (ta <= this.fUu && ta >= this.fUt) {
                        tc(i);
                        tb(ta);
                        td(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dpe && Math.abs(motionEvent.getRawY() - this.czA) < this.dpe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ta(int i) {
        return (int) ((this.fUr * i) + this.fUu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        this.fUp.getLayoutParams().height = (this.eMt * 2) + i;
        this.fUq.tb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fUs);
        this.fUx.getLayoutParams().height = (int) (this.fUv * f);
        this.fUx.setAlpha(f);
        this.dpk.setScaleX(f);
        this.dpk.setScaleY(f);
        this.dpj.setTextSize(0, f * l.s(getContext(), d.e.fontsize32));
    }

    private void ct(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.tc(intValue);
                    a.this.tb(a.this.ta(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.td(layoutParams.leftMargin);
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

    public void kI(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fUs;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        ct(i, i2);
    }

    public void kJ(boolean z) {
        kI(true);
        if (z) {
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dpj.requestFocus();
                    l.b(a.this.getContext(), a.this.dpj);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0142a interfaceC0142a) {
        if (interfaceC0142a != null && this.fUq != null) {
            this.fUq.a(new InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0142a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0142a.a(a.this.dpj.getText().toString(), a.this.mData.beA(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fUy = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aqw() {
        return this.fUy;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqz() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqA() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.fUw != null) {
            this.fUw.onMove((this.fUs - i) * (1.0f / this.fUs));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fUw = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fUq != null) {
            this.fUq.aXj();
        }
        avS();
    }

    public void avS() {
        if (this.fUA != null) {
            this.fUA.avS();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dpj, d.C0108d.cp_cont_b);
        aj.t(this, d.C0108d.cp_bg_line_d);
        if (this.fUq != null) {
            this.fUq.notifyDataSetChanged();
        }
    }
}
