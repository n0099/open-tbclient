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
import com.baidu.tieba.f;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bgZ;
    private float cPP;
    private float cVA;
    private EditText cVF;
    private ImageView cVG;
    private SearchEmotionModel.a cVo;
    private int eEV;
    private boolean fIA;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fIB;
    private TextWatcher fIC;
    private HListView fIq;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fIr;
    private double fIs;
    private int fIt;
    private int fIu;
    private int fIv;
    private int fIw;
    private b fIx;
    private RelativeLayout fIy;
    private boolean fIz;
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
        this.fIA = false;
        this.fIC = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apB())) {
                            PbEmotionBar.this.fIr.setData(PbEmotionBar.this.mData.apB());
                            PbEmotionBar.this.fIr.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIB == null) {
                        PbEmotionBar.this.fIB = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIB.a(PbEmotionBar.this.cVo);
                    }
                    PbEmotionBar.this.fIB.rA(trim);
                }
            }
        };
        this.cVo = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apB()) && PbEmotionBar.this.cVF.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIr.setData(aVar.apB());
                    PbEmotionBar.this.fIr.notifyDataSetChanged();
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
        this.fIA = false;
        this.fIC = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apB())) {
                            PbEmotionBar.this.fIr.setData(PbEmotionBar.this.mData.apB());
                            PbEmotionBar.this.fIr.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIB == null) {
                        PbEmotionBar.this.fIB = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIB.a(PbEmotionBar.this.cVo);
                    }
                    PbEmotionBar.this.fIB.rA(trim);
                }
            }
        };
        this.cVo = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apB()) && PbEmotionBar.this.cVF.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIr.setData(aVar.apB());
                    PbEmotionBar.this.fIr.notifyDataSetChanged();
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
        this.fIA = false;
        this.fIC = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.z(PbEmotionBar.this.mData.apB())) {
                            PbEmotionBar.this.fIr.setData(PbEmotionBar.this.mData.apB());
                            PbEmotionBar.this.fIr.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fIB == null) {
                        PbEmotionBar.this.fIB = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fIB.a(PbEmotionBar.this.cVo);
                    }
                    PbEmotionBar.this.fIB.rA(trim);
                }
            }
        };
        this.cVo = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.z(aVar.apB()) && PbEmotionBar.this.cVF.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fIr.setData(aVar.apB());
                    PbEmotionBar.this.fIr.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i2, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(f.g.pb_emotion_bar);
        inflate(getContext(), f.h.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(f.d.cp_bg_line_d));
        this.fIq = (HListView) findViewById(f.g.lv_emotion);
        this.fIr = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fIr.a(this);
        this.fIq.setAdapter((ListAdapter) this.fIr);
        this.fIq.setDividerWidth(l.f(getContext(), f.e.ds7));
        this.fIq.setSelector(getResources().getDrawable(f.C0146f.transparent_bg));
        this.fIy = (RelativeLayout) findViewById(f.g.layout_search);
        this.cVF = (EditText) findViewById(f.g.edit_search);
        this.cVG = (ImageView) findViewById(f.g.iv_search);
        this.cVF.addTextChangedListener(this.fIC);
        this.cVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cVF.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hH = com.baidu.tbadk.util.w.hH(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = hH - com.baidu.tbadk.util.w.d(obj.charAt(i6));
                        i6++;
                        hH = d;
                    }
                } else {
                    hH += com.baidu.tbadk.util.w.hH(charSequence.toString());
                }
                if (hH > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ah(getContext());
        this.cVA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), f.e.ds150);
        this.fIu = l.f(getContext(), f.e.ds60);
        this.fIv = l.f(getContext(), f.e.ds114);
        this.eEV = l.f(getContext(), f.e.ds10);
        this.fIt = this.mScreenWidth - l.f(getContext(), f.e.ds130);
        this.fIs = (this.fIu - this.fIv) * (1.0d / this.fIt);
        this.fIw = l.f(getContext(), f.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.apB() != null && !aVar.apB().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fIr.setData(aVar.apB());
            qR(this.fIu);
            qS(this.fIt);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fIt;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fIt && G(motionEvent)) {
                    kw(true);
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
        if (this.fIq.getChildCount() <= 0 || this.fIq.getFirstVisiblePosition() != 0 || (childAt = this.fIq.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cPP) {
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
            if (this.fIA && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fIA = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fIA = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bgZ = motionEvent.getRawY();
                this.cPP = motionEvent.getRawX();
                this.cPP = motionEvent.getRawX();
                break;
            case 2:
                this.cPP = motionEvent.getRawX();
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
                        kw(false);
                    } else {
                        kw(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kw(false);
                } else {
                    kw(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cPP));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fIt ? this.fIt : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qQ = qQ(i);
                    if (qQ <= this.fIv && qQ >= this.fIu) {
                        qS(i);
                        qR(qQ);
                        qT(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cVA && Math.abs(motionEvent.getRawY() - this.bgZ) < this.cVA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qQ(int i) {
        return (int) ((this.fIs * i) + this.fIv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR(int i) {
        this.fIq.getLayoutParams().height = (this.eEV * 2) + i;
        this.fIr.qR(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fIt);
        this.fIy.getLayoutParams().height = (int) (this.fIw * f);
        this.fIy.setAlpha(f);
        this.cVG.setScaleX(f);
        this.cVG.setScaleY(f);
        this.cVF.setTextSize(0, f * l.f(getContext(), f.e.fontsize32));
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
                    PbEmotionBar.this.qS(intValue);
                    PbEmotionBar.this.qR(PbEmotionBar.this.qQ(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.qT(layoutParams.leftMargin);
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

    public void kw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fIt;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        br(i, i2);
    }

    public void kx(boolean z) {
        kw(true);
        if (z) {
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.cVF.requestFocus();
                    l.b(PbEmotionBar.this.getContext(), PbEmotionBar.this.cVF);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fIr != null) {
            this.fIr.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.cVF.getText().toString(), PbEmotionBar.this.mData.beS(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fIz = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apD() {
        return this.fIz;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apG() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apH() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        if (this.fIx != null) {
            this.fIx.onMove((this.fIt - i) * (1.0f / this.fIt));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fIx = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fIr != null) {
            this.fIr.aXI();
        }
        awr();
    }

    public void awr() {
        if (this.fIB != null) {
            this.fIB.awr();
        }
    }

    public void onChangeSkinType() {
        am.h(this.cVF, f.d.cp_cont_b);
        this.cVF.setHintTextColor(am.getColor(f.d.cp_cont_e));
        am.j(this, f.d.cp_bg_line_d);
        if (this.fIr != null) {
            this.fIr.notifyDataSetChanged();
        }
    }
}
