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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float cHg;
    private float eHI;
    private EditText eHN;
    private ImageView eHO;
    private SearchEmotionModel.a eHw;
    private float eyV;
    private int gvA;
    private b hzA;
    private RelativeLayout hzB;
    private boolean hzC;
    private boolean hzD;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hzE;
    private TextWatcher hzF;
    private HListView hzt;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hzu;
    private double hzv;
    private int hzw;
    private int hzx;
    private int hzy;
    private int hzz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes4.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.hzD = false;
        this.hzF = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXH())) {
                            PbEmotionBar.this.hzu.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzu.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzE == null) {
                        PbEmotionBar.this.hzE = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzE.a(PbEmotionBar.this.eHw);
                    }
                    PbEmotionBar.this.hzE.Ah(trim);
                }
            }
        };
        this.eHw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzu.setData(aVar.aXH());
                    PbEmotionBar.this.hzu.notifyDataSetChanged();
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
        this.hzD = false;
        this.hzF = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXH())) {
                            PbEmotionBar.this.hzu.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzu.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzE == null) {
                        PbEmotionBar.this.hzE = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzE.a(PbEmotionBar.this.eHw);
                    }
                    PbEmotionBar.this.hzE.Ah(trim);
                }
            }
        };
        this.eHw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzu.setData(aVar.aXH());
                    PbEmotionBar.this.hzu.notifyDataSetChanged();
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
        this.hzD = false;
        this.hzF = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXH())) {
                            PbEmotionBar.this.hzu.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzu.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzE == null) {
                        PbEmotionBar.this.hzE = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzE.a(PbEmotionBar.this.eHw);
                    }
                    PbEmotionBar.this.hzE.Ah(trim);
                }
            }
        };
        this.eHw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzu.setData(aVar.aXH());
                    PbEmotionBar.this.hzu.notifyDataSetChanged();
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
        inflate(getContext(), d.h.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.C0277d.cp_bg_line_d));
        this.hzt = (HListView) findViewById(d.g.lv_emotion);
        this.hzu = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hzu.a(this);
        this.hzt.setAdapter((ListAdapter) this.hzu);
        this.hzt.setDividerWidth(l.h(getContext(), d.e.ds7));
        this.hzt.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hzB = (RelativeLayout) findViewById(d.g.layout_search);
        this.eHN = (EditText) findViewById(d.g.edit_search);
        this.eHO = (ImageView) findViewById(d.g.iv_search);
        this.eHN.addTextChangedListener(this.hzF);
        this.eHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.eHN.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int pN = ab.pN(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = pN - ab.d(obj.charAt(i6));
                        i6++;
                        pN = d;
                    }
                } else {
                    pN += ab.pN(charSequence.toString());
                }
                if (pN > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.eHI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), d.e.ds150);
        this.hzx = l.h(getContext(), d.e.ds58);
        this.hzy = l.h(getContext(), d.e.ds114);
        this.gvA = l.h(getContext(), d.e.ds10);
        this.hzw = this.mScreenWidth - l.h(getContext(), d.e.tbds196);
        this.hzv = (this.hzx - this.hzy) * (1.0d / this.hzw);
        this.hzz = l.h(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hzw && J(motionEvent)) {
                    ob(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return I(motionEvent);
    }

    private boolean I(MotionEvent motionEvent) {
        View childAt;
        if (J(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.hzt.getChildCount() <= 0 || this.hzt.getFirstVisiblePosition() != 0 || (childAt = this.hzt.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.eyV) {
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
            if (this.hzD && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hzD = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hzD = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cHg = motionEvent.getRawY();
                this.eyV = motionEvent.getRawX();
                this.eyV = motionEvent.getRawX();
                break;
            case 2:
                this.eyV = motionEvent.getRawX();
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
                        ob(false);
                    } else {
                        ob(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    ob(false);
                } else {
                    ob(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eyV));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hzw ? this.hzw : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int wy = wy(i);
                    if (wy <= this.hzy && wy >= this.hzx) {
                        wA(i);
                        wz(wy);
                        wB(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean J(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHI && Math.abs(motionEvent.getRawY() - this.cHg) < this.eHI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wy(int i) {
        return (int) ((this.hzv * i) + this.hzy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(int i) {
        this.hzt.getLayoutParams().height = (this.gvA * 2) + i;
        this.hzu.wz(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hzw);
        this.hzB.getLayoutParams().height = (int) (this.hzz * f);
        this.hzB.setAlpha(f);
        this.eHO.setScaleX(f);
        this.eHO.setScaleY(f);
        this.eHN.setTextSize(0, f * l.h(getContext(), d.e.fontsize32));
    }

    private void bV(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.wA(intValue);
                    PbEmotionBar.this.wz(PbEmotionBar.this.wy(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.wB(layoutParams.leftMargin);
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

    public void ob(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.hzw;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bV(i, i2);
    }

    public void oc(boolean z) {
        ob(true);
        if (z) {
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.eHN.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.eHN);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hzu != null) {
            this.hzu.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.eHN.getText().toString(), PbEmotionBar.this.mData.bNH(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hzC = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXJ() {
        return this.hzC;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXM() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(int i) {
        if (this.hzA != null) {
            this.hzA.onMove((this.hzw - i) * (1.0f / this.hzw));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hzA = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hzu != null) {
            this.hzu.bGi();
        }
        beW();
    }

    public void beW() {
        if (this.hzE != null) {
            this.hzE.beW();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eHN, d.C0277d.cp_cont_b);
        this.eHN.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.hzu != null) {
            this.hzu.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hzw;
    }
}
