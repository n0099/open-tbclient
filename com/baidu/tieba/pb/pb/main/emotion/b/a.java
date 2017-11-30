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
/* loaded from: classes.dex */
public class a extends LinearLayout implements EmotionView.a {
    private float EP;
    private float bKr;
    private float cqR;
    private EditText cvE;
    private ImageView cvF;
    private SearchEmotionModel.a cvn;
    private float cvz;
    private int dXm;
    private b feA;
    private RelativeLayout feB;
    private boolean feC;
    private boolean feD;
    private c feE;
    private TextWatcher feF;
    private HListView fet;
    private com.baidu.tieba.pb.pb.main.emotion.b.b feu;
    private double fev;
    private int few;
    private int fex;
    private int fey;
    private int fez;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0116a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.feD = false;
        this.feF = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.w(a.this.mData.ahF())) {
                            a.this.feu.setData(a.this.mData.ahF());
                            a.this.feu.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.feE == null) {
                        a.this.feE = new c();
                        a.this.feE.a(a.this.cvn);
                    }
                    a.this.feE.qe(trim);
                }
            }
        };
        this.cvn = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.ahF()) && a.this.cvE.getText().toString().trim().equals(str)) {
                    a.this.feu.setData(aVar.ahF());
                    a.this.feu.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0082d.cp_bg_line_d));
        this.fet = (HListView) findViewById(d.g.lv_emotion);
        this.feu = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.feu.a(this);
        this.fet.setAdapter((ListAdapter) this.feu);
        this.fet.setDividerWidth(l.f(getContext(), d.e.ds7));
        this.fet.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.feB = (RelativeLayout) findViewById(d.g.layout_search);
        this.cvE = (EditText) findViewById(d.g.edit_search);
        this.cvF = (ImageView) findViewById(d.g.iv_search);
        this.cvE.addTextChangedListener(this.feF);
        this.cvE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cvE.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gZ = w.gZ(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gZ - w.e(obj.charAt(i6));
                        i6++;
                        gZ = e;
                    }
                } else {
                    gZ += w.gZ(charSequence.toString());
                }
                if (gZ > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ac(getContext());
        this.cvz = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.e.ds150);
        this.fex = l.f(getContext(), d.e.ds60);
        this.fey = l.f(getContext(), d.e.ds114);
        this.dXm = l.f(getContext(), d.e.ds10);
        this.few = this.mScreenWidth - l.f(getContext(), d.e.ds130);
        this.fev = (this.fex - this.fey) * (1.0d / this.few);
        this.fez = l.f(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.ahF() != null && !aVar.ahF().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.feu.setData(aVar.ahF());
            qi(this.fex);
            qj(this.few);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.few;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.few && A(motionEvent)) {
                    kb(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return z(motionEvent);
    }

    private boolean z(MotionEvent motionEvent) {
        View childAt;
        if (A(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fet.getChildCount() <= 0 || this.fet.getFirstVisiblePosition() != 0 || (childAt = this.fet.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cqR) {
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
            if (this.feD && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.feD = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.feD = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.EP = motionEvent.getRawX();
                this.bKr = motionEvent.getRawY();
                this.cqR = motionEvent.getRawX();
                this.cqR = motionEvent.getRawX();
                break;
            case 2:
                this.cqR = motionEvent.getRawX();
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
                int rawX = (int) (motionEvent.getRawX() - this.EP);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        kb(false);
                    } else {
                        kb(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kb(false);
                } else {
                    kb(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cqR));
                if (rawX2 >= 0) {
                    i = rawX2 > this.few ? this.few : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qh = qh(i);
                    if (qh <= this.fey && qh >= this.fex) {
                        qj(i);
                        qi(qh);
                        qk(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean A(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cvz && Math.abs(motionEvent.getRawY() - this.bKr) < this.cvz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qh(int i) {
        return (int) ((this.fev * i) + this.fey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(int i) {
        this.fet.getLayoutParams().height = (this.dXm * 2) + i;
        this.feu.qi(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(int i) {
        float f = 1.0f - ((i * 1.0f) / this.few);
        this.feB.getLayoutParams().height = (int) (this.fez * f);
        this.feB.setAlpha(f);
        this.cvF.setScaleX(f);
        this.cvF.setScaleY(f);
        this.cvE.setTextSize(0, f * l.f(getContext(), d.e.fontsize32));
    }

    private void bu(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.qj(intValue);
                    a.this.qi(a.this.qh(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.qk(layoutParams.leftMargin);
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

    public void kb(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.few;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bu(i, i2);
    }

    public void kc(boolean z) {
        kb(true);
        if (z) {
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cvE.requestFocus();
                    l.b(a.this.getContext(), a.this.cvE);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0116a interfaceC0116a) {
        if (interfaceC0116a != null && this.feu != null) {
            this.feu.a(new InterfaceC0116a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0116a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0116a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0116a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0116a.a(a.this.cvE.getText().toString(), a.this.mData.aWU(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.feC = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ahH() {
        return this.feC;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahK() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahL() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(int i) {
        if (this.feA != null) {
            this.feA.onMove((this.few - i) * (1.0f / this.few));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.feA = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.feu != null) {
            this.feu.aPG();
        }
        amU();
    }

    public void amU() {
        if (this.feE != null) {
            this.feE.amU();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cvE, d.C0082d.cp_cont_b);
        aj.k(this, d.C0082d.cp_bg_line_d);
        if (this.feu != null) {
            this.feu.notifyDataSetChanged();
        }
    }
}
