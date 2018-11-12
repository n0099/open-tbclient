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
    private float brF;
    private float dfe;
    private float dkI;
    private EditText dkN;
    private ImageView dkO;
    private SearchEmotionModel.a dkw;
    private int eVm;
    private HListView fYW;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fYX;
    private double fYY;
    private int fYZ;
    private int fZa;
    private int fZb;
    private int fZc;
    private b fZd;
    private RelativeLayout fZe;
    private boolean fZf;
    private boolean fZg;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fZh;
    private TextWatcher fZi;
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
        this.fZg = false;
        this.fZi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.auk())) {
                            PbEmotionBar.this.fYX.setData(PbEmotionBar.this.mData.auk());
                            PbEmotionBar.this.fYX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fZh == null) {
                        PbEmotionBar.this.fZh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fZh.a(PbEmotionBar.this.dkw);
                    }
                    PbEmotionBar.this.fZh.sJ(trim);
                }
            }
        };
        this.dkw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.auk()) && PbEmotionBar.this.dkN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fYX.setData(aVar.auk());
                    PbEmotionBar.this.fYX.notifyDataSetChanged();
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
        this.fZg = false;
        this.fZi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.auk())) {
                            PbEmotionBar.this.fYX.setData(PbEmotionBar.this.mData.auk());
                            PbEmotionBar.this.fYX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fZh == null) {
                        PbEmotionBar.this.fZh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fZh.a(PbEmotionBar.this.dkw);
                    }
                    PbEmotionBar.this.fZh.sJ(trim);
                }
            }
        };
        this.dkw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.auk()) && PbEmotionBar.this.dkN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fYX.setData(aVar.auk());
                    PbEmotionBar.this.fYX.notifyDataSetChanged();
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
        this.fZg = false;
        this.fZi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.I(PbEmotionBar.this.mData.auk())) {
                            PbEmotionBar.this.fYX.setData(PbEmotionBar.this.mData.auk());
                            PbEmotionBar.this.fYX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fZh == null) {
                        PbEmotionBar.this.fZh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fZh.a(PbEmotionBar.this.dkw);
                    }
                    PbEmotionBar.this.fZh.sJ(trim);
                }
            }
        };
        this.dkw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.I(aVar.auk()) && PbEmotionBar.this.dkN.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fYX.setData(aVar.auk());
                    PbEmotionBar.this.fYX.notifyDataSetChanged();
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
        this.fYW = (HListView) findViewById(e.g.lv_emotion);
        this.fYX = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fYX.a(this);
        this.fYW.setAdapter((ListAdapter) this.fYX);
        this.fYW.setDividerWidth(l.h(getContext(), e.C0200e.ds7));
        this.fYW.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.fZe = (RelativeLayout) findViewById(e.g.layout_search);
        this.dkN = (EditText) findViewById(e.g.edit_search);
        this.dkO = (ImageView) findViewById(e.g.iv_search);
        this.dkN.addTextChangedListener(this.fZi);
        this.dkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dkN.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int it = y.it(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = it - y.d(obj.charAt(i6));
                        i6++;
                        it = d;
                    }
                } else {
                    it += y.it(charSequence.toString());
                }
                if (it > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.dkI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0200e.ds150);
        this.fZa = l.h(getContext(), e.C0200e.ds60);
        this.fZb = l.h(getContext(), e.C0200e.ds114);
        this.eVm = l.h(getContext(), e.C0200e.ds10);
        this.fYZ = this.mScreenWidth - l.h(getContext(), e.C0200e.ds130);
        this.fYY = (this.fZa - this.fZb) * (1.0d / this.fYZ);
        this.fZc = l.h(getContext(), e.C0200e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.auk() != null && !aVar.auk().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fYX.setData(aVar.auk());
            si(this.fZa);
            sj(this.fYZ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fYZ;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fYZ && G(motionEvent)) {
                    lw(true);
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
        if (this.fYW.getChildCount() <= 0 || this.fYW.getFirstVisiblePosition() != 0 || (childAt = this.fYW.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dfe) {
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
            if (this.fZg && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fZg = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fZg = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.brF = motionEvent.getRawY();
                this.dfe = motionEvent.getRawX();
                this.dfe = motionEvent.getRawX();
                break;
            case 2:
                this.dfe = motionEvent.getRawX();
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
                        lw(false);
                    } else {
                        lw(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    lw(false);
                } else {
                    lw(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dfe));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fYZ ? this.fYZ : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int sh = sh(i);
                    if (sh <= this.fZb && sh >= this.fZa) {
                        sj(i);
                        si(sh);
                        sk(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dkI && Math.abs(motionEvent.getRawY() - this.brF) < this.dkI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sh(int i) {
        return (int) ((this.fYY * i) + this.fZb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        this.fYW.getLayoutParams().height = (this.eVm * 2) + i;
        this.fYX.si(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fYZ);
        this.fZe.getLayoutParams().height = (int) (this.fZc * f);
        this.fZe.setAlpha(f);
        this.dkO.setScaleX(f);
        this.dkO.setScaleY(f);
        this.dkN.setTextSize(0, f * l.h(getContext(), e.C0200e.fontsize32));
    }

    private void bA(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.sj(intValue);
                    PbEmotionBar.this.si(PbEmotionBar.this.sh(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.sk(layoutParams.leftMargin);
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

    public void lw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fYZ;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bA(i, i2);
    }

    public void lx(boolean z) {
        lw(true);
        if (z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.dkN.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.dkN);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fYX != null) {
            this.fYX.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.dkN.getText().toString(), PbEmotionBar.this.mData.bkf(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fZf = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aum() {
        return this.fZf;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aup() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void auq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        if (this.fZd != null) {
            this.fZd.onMove((this.fYZ - i) * (1.0f / this.fYZ));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fZd = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fYX != null) {
            this.fYX.bcG();
        }
        aBt();
    }

    public void aBt() {
        if (this.fZh != null) {
            this.fZh.aBt();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dkN, e.d.cp_cont_b);
        this.dkN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.fYX != null) {
            this.fYX.notifyDataSetChanged();
        }
    }
}
