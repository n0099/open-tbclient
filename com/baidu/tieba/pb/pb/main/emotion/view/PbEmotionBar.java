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
    private float cHf;
    private float eHH;
    private EditText eHM;
    private ImageView eHN;
    private SearchEmotionModel.a eHv;
    private float eyU;
    private int gvz;
    private RelativeLayout hzA;
    private boolean hzB;
    private boolean hzC;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hzD;
    private TextWatcher hzE;
    private HListView hzs;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hzt;
    private double hzu;
    private int hzv;
    private int hzw;
    private int hzx;
    private int hzy;
    private b hzz;
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
        this.hzC = false;
        this.hzE = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.hzt.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzt.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzD == null) {
                        PbEmotionBar.this.hzD = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzD.a(PbEmotionBar.this.eHv);
                    }
                    PbEmotionBar.this.hzD.Ah(trim);
                }
            }
        };
        this.eHv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzt.setData(aVar.aXH());
                    PbEmotionBar.this.hzt.notifyDataSetChanged();
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
        this.hzC = false;
        this.hzE = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.hzt.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzt.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzD == null) {
                        PbEmotionBar.this.hzD = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzD.a(PbEmotionBar.this.eHv);
                    }
                    PbEmotionBar.this.hzD.Ah(trim);
                }
            }
        };
        this.eHv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzt.setData(aVar.aXH());
                    PbEmotionBar.this.hzt.notifyDataSetChanged();
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
        this.hzC = false;
        this.hzE = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                            PbEmotionBar.this.hzt.setData(PbEmotionBar.this.mData.aXH());
                            PbEmotionBar.this.hzt.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hzD == null) {
                        PbEmotionBar.this.hzD = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hzD.a(PbEmotionBar.this.eHv);
                    }
                    PbEmotionBar.this.hzD.Ah(trim);
                }
            }
        };
        this.eHv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.T(aVar.aXH()) && PbEmotionBar.this.eHM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hzt.setData(aVar.aXH());
                    PbEmotionBar.this.hzt.notifyDataSetChanged();
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
        this.hzs = (HListView) findViewById(d.g.lv_emotion);
        this.hzt = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hzt.a(this);
        this.hzs.setAdapter((ListAdapter) this.hzt);
        this.hzs.setDividerWidth(l.h(getContext(), d.e.ds7));
        this.hzs.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hzA = (RelativeLayout) findViewById(d.g.layout_search);
        this.eHM = (EditText) findViewById(d.g.edit_search);
        this.eHN = (ImageView) findViewById(d.g.iv_search);
        this.eHM.addTextChangedListener(this.hzE);
        this.eHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.eHM.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.eHH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), d.e.ds150);
        this.hzw = l.h(getContext(), d.e.ds58);
        this.hzx = l.h(getContext(), d.e.ds114);
        this.gvz = l.h(getContext(), d.e.ds10);
        this.hzv = this.mScreenWidth - l.h(getContext(), d.e.tbds196);
        this.hzu = (this.hzw - this.hzx) * (1.0d / this.hzv);
        this.hzy = l.h(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hzv && J(motionEvent)) {
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
        if (this.hzs.getChildCount() <= 0 || this.hzs.getFirstVisiblePosition() != 0 || (childAt = this.hzs.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.eyU) {
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
            if (this.hzC && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hzC = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hzC = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cHf = motionEvent.getRawY();
                this.eyU = motionEvent.getRawX();
                this.eyU = motionEvent.getRawX();
                break;
            case 2:
                this.eyU = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eyU));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hzv ? this.hzv : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int wy = wy(i);
                    if (wy <= this.hzx && wy >= this.hzw) {
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
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eHH && Math.abs(motionEvent.getRawY() - this.cHf) < this.eHH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wy(int i) {
        return (int) ((this.hzu * i) + this.hzx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(int i) {
        this.hzs.getLayoutParams().height = (this.gvz * 2) + i;
        this.hzt.wz(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hzv);
        this.hzA.getLayoutParams().height = (int) (this.hzy * f);
        this.hzA.setAlpha(f);
        this.eHN.setScaleX(f);
        this.eHN.setScaleY(f);
        this.eHM.setTextSize(0, f * l.h(getContext(), d.e.fontsize32));
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
        int i2 = this.hzv;
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
                    PbEmotionBar.this.eHM.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.eHM);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hzt != null) {
            this.hzt.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.eHM.getText().toString(), PbEmotionBar.this.mData.bNH(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hzB = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXJ() {
        return this.hzB;
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
        if (this.hzz != null) {
            this.hzz.onMove((this.hzv - i) * (1.0f / this.hzv));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hzz = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hzt != null) {
            this.hzt.bGi();
        }
        beW();
    }

    public void beW() {
        if (this.hzD != null) {
            this.hzD.beW();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eHM, d.C0277d.cp_cont_b);
        this.eHM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.hzt != null) {
            this.hzt.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hzv;
    }
}
