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
    private float czf;
    private float dfJ;
    private SearchEmotionModel.a djW;
    private float dki;
    private EditText dkn;
    private ImageView dko;
    private int eKy;
    private int fSA;
    private b fSB;
    private RelativeLayout fSC;
    private boolean fSD;
    private boolean fSE;
    private c fSF;
    private TextWatcher fSG;
    private HListView fSu;
    private com.baidu.tieba.pb.pb.main.emotion.b.b fSv;
    private double fSw;
    private int fSx;
    private int fSy;
    private int fSz;
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
        this.fSE = false;
        this.fSG = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.G(a.this.mData.apm())) {
                            a.this.fSv.setData(a.this.mData.apm());
                            a.this.fSv.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.fSF == null) {
                        a.this.fSF = new c();
                        a.this.fSF.a(a.this.djW);
                    }
                    a.this.fSF.qp(trim);
                }
            }
        };
        this.djW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.G(aVar.apm()) && a.this.dkn.getText().toString().trim().equals(str)) {
                    a.this.fSv.setData(aVar.apm());
                    a.this.fSv.notifyDataSetChanged();
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
        this.fSu = (HListView) findViewById(d.g.lv_emotion);
        this.fSv = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.fSv.a(this);
        this.fSu.setAdapter((ListAdapter) this.fSv);
        this.fSu.setDividerWidth(l.s(getContext(), d.e.ds7));
        this.fSu.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fSC = (RelativeLayout) findViewById(d.g.layout_search);
        this.dkn = (EditText) findViewById(d.g.edit_search);
        this.dko = (ImageView) findViewById(d.g.iv_search);
        this.dkn.addTextChangedListener(this.fSG);
        this.dkn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dkn.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int ha = w.ha(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = ha - w.e(obj.charAt(i6));
                        i6++;
                        ha = e;
                    }
                } else {
                    ha += w.ha(charSequence.toString());
                }
                if (ha > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ao(getContext());
        this.dki = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.s(getContext(), d.e.ds150);
        this.fSy = l.s(getContext(), d.e.ds60);
        this.fSz = l.s(getContext(), d.e.ds114);
        this.eKy = l.s(getContext(), d.e.ds10);
        this.fSx = this.mScreenWidth - l.s(getContext(), d.e.ds130);
        this.fSw = (this.fSy - this.fSz) * (1.0d / this.fSx);
        this.fSA = l.s(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.apm() != null && !aVar.apm().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fSv.setData(aVar.apm());
            tj(this.fSy);
            tk(this.fSx);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fSx;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fSx && I(motionEvent)) {
                    kE(true);
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
        if (this.fSu.getChildCount() <= 0 || this.fSu.getFirstVisiblePosition() != 0 || (childAt = this.fSu.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dfJ) {
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
            if (this.fSE && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fSE = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fSE = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.czf = motionEvent.getRawY();
                this.dfJ = motionEvent.getRawX();
                this.dfJ = motionEvent.getRawX();
                break;
            case 2:
                this.dfJ = motionEvent.getRawX();
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
                        kE(false);
                    } else {
                        kE(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kE(false);
                } else {
                    kE(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dfJ));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fSx ? this.fSx : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int ti = ti(i);
                    if (ti <= this.fSz && ti >= this.fSy) {
                        tk(i);
                        tj(ti);
                        tl(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dki && Math.abs(motionEvent.getRawY() - this.czf) < this.dki;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ti(int i) {
        return (int) ((this.fSw * i) + this.fSz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        this.fSu.getLayoutParams().height = (this.eKy * 2) + i;
        this.fSv.tj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fSx);
        this.fSC.getLayoutParams().height = (int) (this.fSA * f);
        this.fSC.setAlpha(f);
        this.dko.setScaleX(f);
        this.dko.setScaleY(f);
        this.dkn.setTextSize(0, f * l.s(getContext(), d.e.fontsize32));
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
                    a.this.tk(intValue);
                    a.this.tj(a.this.ti(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.tl(layoutParams.leftMargin);
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

    public void kE(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fSx;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        ct(i, i2);
    }

    public void kF(boolean z) {
        kE(true);
        if (z) {
            e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dkn.requestFocus();
                    l.b(a.this.getContext(), a.this.dkn);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0142a interfaceC0142a) {
        if (interfaceC0142a != null && this.fSv != null) {
            this.fSv.a(new InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0142a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0142a.a(a.this.dkn.getText().toString(), a.this.mData.ber(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fSD = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apo() {
        return this.fSD;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apr() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aps() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        if (this.fSB != null) {
            this.fSB.onMove((this.fSx - i) * (1.0f / this.fSx));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fSB = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fSv != null) {
            this.fSv.aWZ();
        }
        auK();
    }

    public void auK() {
        if (this.fSF != null) {
            this.fSF.auK();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dkn, d.C0108d.cp_cont_b);
        aj.t(this, d.C0108d.cp_bg_line_d);
        if (this.fSv != null) {
            this.fSv.notifyDataSetChanged();
        }
    }
}
