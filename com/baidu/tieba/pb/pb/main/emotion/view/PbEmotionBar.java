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
    private SearchEmotionModel.a eHN;
    private float eHZ;
    private EditText eIe;
    private ImageView eIf;
    private float ezn;
    private int gvM;
    private HListView hzL;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hzM;
    private double hzN;
    private int hzO;
    private int hzP;
    private int hzQ;
    private int hzR;
    private b hzS;
    private RelativeLayout hzT;
    private boolean hzU;
    private boolean hzV;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hzW;
    private TextWatcher hzX;
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
        this.hzV = false;
        this.hzX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXK())) {
                            PbEmotionBar.this.hzM.setData(PbEmotionBar.this.mData.aXK());
                            PbEmotionBar.this.hzM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzW == null) {
                        PbEmotionBar.this.hzW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzW.a(PbEmotionBar.this.eHN);
                    }
                    PbEmotionBar.this.hzW.Aj(trim);
                }
            }
        };
        this.eHN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXK()) && PbEmotionBar.this.eIe.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzM.setData(aVar.aXK());
                    PbEmotionBar.this.hzM.notifyDataSetChanged();
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
        this.hzV = false;
        this.hzX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXK())) {
                            PbEmotionBar.this.hzM.setData(PbEmotionBar.this.mData.aXK());
                            PbEmotionBar.this.hzM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzW == null) {
                        PbEmotionBar.this.hzW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzW.a(PbEmotionBar.this.eHN);
                    }
                    PbEmotionBar.this.hzW.Aj(trim);
                }
            }
        };
        this.eHN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXK()) && PbEmotionBar.this.eIe.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzM.setData(aVar.aXK());
                    PbEmotionBar.this.hzM.notifyDataSetChanged();
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
        this.hzV = false;
        this.hzX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.T(PbEmotionBar.this.mData.aXK())) {
                            PbEmotionBar.this.hzM.setData(PbEmotionBar.this.mData.aXK());
                            PbEmotionBar.this.hzM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzW == null) {
                        PbEmotionBar.this.hzW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzW.a(PbEmotionBar.this.eHN);
                    }
                    PbEmotionBar.this.hzW.Aj(trim);
                }
            }
        };
        this.eHN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXK()) && PbEmotionBar.this.eIe.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzM.setData(aVar.aXK());
                    PbEmotionBar.this.hzM.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0236d.cp_bg_line_d));
        this.hzL = (HListView) findViewById(d.g.lv_emotion);
        this.hzM = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hzM.a(this);
        this.hzL.setAdapter((ListAdapter) this.hzM);
        this.hzL.setDividerWidth(l.h(getContext(), d.e.ds7));
        this.hzL.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hzT = (RelativeLayout) findViewById(d.g.layout_search);
        this.eIe = (EditText) findViewById(d.g.edit_search);
        this.eIf = (ImageView) findViewById(d.g.iv_search);
        this.eIe.addTextChangedListener(this.hzX);
        this.eIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.eIe.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.eHZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), d.e.ds150);
        this.hzP = l.h(getContext(), d.e.ds58);
        this.hzQ = l.h(getContext(), d.e.ds114);
        this.gvM = l.h(getContext(), d.e.ds10);
        this.hzO = this.mScreenWidth - l.h(getContext(), d.e.tbds196);
        this.hzN = (this.hzP - this.hzQ) * (1.0d / this.hzO);
        this.hzR = l.h(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hzO && J(motionEvent)) {
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
        if (this.hzL.getChildCount() <= 0 || this.hzL.getFirstVisiblePosition() != 0 || (childAt = this.hzL.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.ezn) {
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
            if (this.hzV && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hzV = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hzV = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cHg = motionEvent.getRawY();
                this.ezn = motionEvent.getRawX();
                this.ezn = motionEvent.getRawX();
                break;
            case 2:
                this.ezn = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.ezn));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hzO ? this.hzO : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int wC = wC(i);
                    if (wC <= this.hzQ && wC >= this.hzP) {
                        wE(i);
                        wD(wC);
                        wF(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean J(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHZ && Math.abs(motionEvent.getRawY() - this.cHg) < this.eHZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wC(int i) {
        return (int) ((this.hzN * i) + this.hzQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(int i) {
        this.hzL.getLayoutParams().height = (this.gvM * 2) + i;
        this.hzM.wD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wE(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hzO);
        this.hzT.getLayoutParams().height = (int) (this.hzR * f);
        this.hzT.setAlpha(f);
        this.eIf.setScaleX(f);
        this.eIf.setScaleY(f);
        this.eIe.setTextSize(0, f * l.h(getContext(), d.e.fontsize32));
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
                    PbEmotionBar.this.wE(intValue);
                    PbEmotionBar.this.wD(PbEmotionBar.this.wC(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.wF(layoutParams.leftMargin);
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
        int i2 = this.hzO;
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
                    PbEmotionBar.this.eIe.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.eIe);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hzM != null) {
            this.hzM.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.eIe.getText().toString(), PbEmotionBar.this.mData.bNJ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hzU = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXM() {
        return this.hzU;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXP() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(int i) {
        if (this.hzS != null) {
            this.hzS.onMove((this.hzO - i) * (1.0f / this.hzO));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hzS = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hzM != null) {
            this.hzM.bGl();
        }
        beY();
    }

    public void beY() {
        if (this.hzW != null) {
            this.hzW.beY();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eIe, d.C0236d.cp_cont_b);
        this.eIe.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        al.l(this, d.C0236d.cp_bg_line_d);
        if (this.hzM != null) {
            this.hzM.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hzO;
    }
}
