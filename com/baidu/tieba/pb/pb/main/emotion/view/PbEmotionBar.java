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
import com.baidu.tbadk.core.util.al;
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
    private float cPp;
    private SearchEmotionModel.a cUD;
    private float cUP;
    private EditText cUU;
    private ImageView cUV;
    private float ccd;
    private int exp;
    private HListView fEh;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fEi;
    private double fEj;
    private int fEk;
    private int fEl;
    private int fEm;
    private int fEn;
    private b fEo;
    private RelativeLayout fEp;
    private boolean fEq;
    private boolean fEr;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fEs;
    private TextWatcher fEt;
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
        this.fEr = false;
        this.fEt = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apG())) {
                            PbEmotionBar.this.fEi.setData(PbEmotionBar.this.mData.apG());
                            PbEmotionBar.this.fEi.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fEs == null) {
                        PbEmotionBar.this.fEs = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fEs.a(PbEmotionBar.this.cUD);
                    }
                    PbEmotionBar.this.fEs.rE(trim);
                }
            }
        };
        this.cUD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apG()) && PbEmotionBar.this.cUU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fEi.setData(aVar.apG());
                    PbEmotionBar.this.fEi.notifyDataSetChanged();
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
        this.fEr = false;
        this.fEt = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apG())) {
                            PbEmotionBar.this.fEi.setData(PbEmotionBar.this.mData.apG());
                            PbEmotionBar.this.fEi.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fEs == null) {
                        PbEmotionBar.this.fEs = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fEs.a(PbEmotionBar.this.cUD);
                    }
                    PbEmotionBar.this.fEs.rE(trim);
                }
            }
        };
        this.cUD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apG()) && PbEmotionBar.this.cUU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fEi.setData(aVar.apG());
                    PbEmotionBar.this.fEi.notifyDataSetChanged();
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
        this.fEr = false;
        this.fEt = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apG())) {
                            PbEmotionBar.this.fEi.setData(PbEmotionBar.this.mData.apG());
                            PbEmotionBar.this.fEi.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fEs == null) {
                        PbEmotionBar.this.fEs = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fEs.a(PbEmotionBar.this.cUD);
                    }
                    PbEmotionBar.this.fEs.rE(trim);
                }
            }
        };
        this.cUD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apG()) && PbEmotionBar.this.cUU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fEi.setData(aVar.apG());
                    PbEmotionBar.this.fEi.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0141d.cp_bg_line_d));
        this.fEh = (HListView) findViewById(d.g.lv_emotion);
        this.fEi = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fEi.a(this);
        this.fEh.setAdapter((ListAdapter) this.fEi);
        this.fEh.setDividerWidth(l.e(getContext(), d.e.ds7));
        this.fEh.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fEp = (RelativeLayout) findViewById(d.g.layout_search);
        this.cUU = (EditText) findViewById(d.g.edit_search);
        this.cUV = (ImageView) findViewById(d.g.iv_search);
        this.cUU.addTextChangedListener(this.fEt);
        this.cUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cUU.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hG = x.hG(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = hG - x.d(obj.charAt(i6));
                        i6++;
                        hG = d;
                    }
                } else {
                    hG += x.hG(charSequence.toString());
                }
                if (hG > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ah(getContext());
        this.cUP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.e(getContext(), d.e.ds150);
        this.fEl = l.e(getContext(), d.e.ds60);
        this.fEm = l.e(getContext(), d.e.ds114);
        this.exp = l.e(getContext(), d.e.ds10);
        this.fEk = this.mScreenWidth - l.e(getContext(), d.e.ds130);
        this.fEj = (this.fEl - this.fEm) * (1.0d / this.fEk);
        this.fEn = l.e(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.apG() != null && !aVar.apG().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fEi.setData(aVar.apG());
            qM(this.fEl);
            qN(this.fEk);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fEk;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fEk && F(motionEvent)) {
                    kA(true);
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
        if (this.fEh.getChildCount() <= 0 || this.fEh.getFirstVisiblePosition() != 0 || (childAt = this.fEh.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cPp) {
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
            if (this.fEr && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fEr = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fEr = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.ccd = motionEvent.getRawY();
                this.cPp = motionEvent.getRawX();
                this.cPp = motionEvent.getRawX();
                break;
            case 2:
                this.cPp = motionEvent.getRawX();
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
                        kA(false);
                    } else {
                        kA(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kA(false);
                } else {
                    kA(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cPp));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fEk ? this.fEk : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qL = qL(i);
                    if (qL <= this.fEm && qL >= this.fEl) {
                        qN(i);
                        qM(qL);
                        qO(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cUP && Math.abs(motionEvent.getRawY() - this.ccd) < this.cUP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qL(int i) {
        return (int) ((this.fEj * i) + this.fEm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        this.fEh.getLayoutParams().height = (this.exp * 2) + i;
        this.fEi.qM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fEk);
        this.fEp.getLayoutParams().height = (int) (this.fEn * f);
        this.fEp.setAlpha(f);
        this.cUV.setScaleX(f);
        this.cUV.setScaleY(f);
        this.cUU.setTextSize(0, f * l.e(getContext(), d.e.fontsize32));
    }

    private void br(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.qN(intValue);
                    PbEmotionBar.this.qM(PbEmotionBar.this.qL(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.qO(layoutParams.leftMargin);
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

    public void kA(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fEk;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        br(i, i2);
    }

    public void kB(boolean z) {
        kA(true);
        if (z) {
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.cUU.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.cUU);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fEi != null) {
            this.fEi.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.cUU.getText().toString(), PbEmotionBar.this.mData.bfW(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fEq = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apI() {
        return this.fEq;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apL() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apM() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(int i) {
        if (this.fEo != null) {
            this.fEo.onMove((this.fEk - i) * (1.0f / this.fEk));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fEo = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fEi != null) {
            this.fEi.aYJ();
        }
        avk();
    }

    public void avk() {
        if (this.fEs != null) {
            this.fEs.avk();
        }
    }

    public void onChangeSkinType() {
        al.h(this.cUU, d.C0141d.cp_cont_b);
        this.cUU.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        al.j(this, d.C0141d.cp_bg_line_d);
        if (this.fEi != null) {
            this.fEi.notifyDataSetChanged();
        }
    }
}
