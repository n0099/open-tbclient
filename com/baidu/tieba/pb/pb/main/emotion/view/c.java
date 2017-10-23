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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout implements EmotionView.a {
    private float Fe;
    private float bxs;
    private float caq;
    private SearchEmotionModel.a ceM;
    private float ceZ;
    private EditText cfe;
    private ImageView cff;
    private int dHE;
    private boolean eOA;
    private boolean eOB;
    private e eOC;
    private TextWatcher eOD;
    private HListView eOr;
    private d eOs;
    private double eOt;
    private int eOu;
    private int eOv;
    private int eOw;
    private int eOx;
    private b eOy;
    private RelativeLayout eOz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void X(float f);
    }

    public c(Context context) {
        super(context);
        this.eOB = false;
        this.eOD = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
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
                        if (c.this.mData != null && !v.u(c.this.mData.adz())) {
                            c.this.eOs.setData(c.this.mData.adz());
                            c.this.eOs.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (c.this.eOC == null) {
                        c.this.eOC = new e();
                        c.this.eOC.a(c.this.ceM);
                    }
                    c.this.eOC.pi(trim);
                }
            }
        };
        this.ceM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.u(aVar.adz()) && c.this.cfe.getText().toString().trim().equals(str)) {
                    c.this.eOs.setData(aVar.adz());
                    c.this.eOs.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(d.h.pb_emotion_bar);
        inflate(getContext(), d.j.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.e.cp_bg_line_d));
        this.eOr = (HListView) findViewById(d.h.lv_emotion);
        this.eOs = new d();
        this.eOs.a(this);
        this.eOr.setAdapter((ListAdapter) this.eOs);
        this.eOr.setDividerWidth(l.f(getContext(), d.f.ds7));
        this.eOr.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.eOz = (RelativeLayout) findViewById(d.h.layout_search);
        this.cfe = (EditText) findViewById(d.h.edit_search);
        aj.i(this.cfe, d.e.cp_cont_b);
        this.cff = (ImageView) findViewById(d.h.iv_search);
        this.cfe.addTextChangedListener(this.eOD);
        this.cfe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cfe.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gO = u.gO(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gO - u.e(obj.charAt(i6));
                        i6++;
                        gO = e;
                    }
                } else {
                    gO += u.gO(charSequence.toString());
                }
                if (gO > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ad(getContext());
        this.ceZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.f.ds150);
        this.eOv = l.f(getContext(), d.f.ds60);
        this.eOw = l.f(getContext(), d.f.ds114);
        this.dHE = l.f(getContext(), d.f.ds10);
        this.eOu = this.mScreenWidth - l.f(getContext(), d.f.ds130);
        this.eOt = (this.eOv - this.eOw) * (1.0d / this.eOu);
        this.eOx = l.f(getContext(), d.f.ds100);
        aj.k(this, d.e.cp_bg_line_d);
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.adz() != null && !aVar.adz().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.eOs.setData(aVar.adz());
            pC(this.eOv);
            pD(this.eOu);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eOu;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.eOu && t(motionEvent)) {
                    jD(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return u(motionEvent);
    }

    private boolean u(MotionEvent motionEvent) {
        View childAt;
        if (t(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.eOr.getChildCount() <= 0 || this.eOr.getFirstVisiblePosition() != 0 || (childAt = this.eOr.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.caq) {
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
            if (this.eOB && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.eOB = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.eOB = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.Fe = motionEvent.getRawX();
                this.bxs = motionEvent.getRawY();
                this.caq = motionEvent.getRawX();
                this.caq = motionEvent.getRawX();
                break;
            case 2:
                this.caq = motionEvent.getRawX();
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
                int rawX = (int) (motionEvent.getRawX() - this.Fe);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        jD(false);
                    } else {
                        jD(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jD(false);
                } else {
                    jD(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.caq));
                if (rawX2 >= 0) {
                    i = rawX2 > this.eOu ? this.eOu : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int pB = pB(i);
                    if (pB <= this.eOw && pB >= this.eOv) {
                        pD(i);
                        pC(pB);
                        pE(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fe) < this.ceZ && Math.abs(motionEvent.getRawY() - this.bxs) < this.ceZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pB(int i) {
        return (int) ((this.eOt * i) + this.eOw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(int i) {
        this.eOr.getLayoutParams().height = (this.dHE * 2) + i;
        this.eOs.pC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(int i) {
        float f = 1.0f - ((i * 1.0f) / this.eOu);
        this.eOz.getLayoutParams().height = (int) (this.eOx * f);
        this.eOz.setAlpha(f);
        this.cff.setScaleX(f);
        this.cff.setScaleY(f);
        this.cfe.setTextSize(0, f * l.f(getContext(), d.f.fontsize32));
    }

    private void bw(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    c.this.pD(intValue);
                    c.this.pC(c.this.pB(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pE(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((RelativeLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanShowEmotionPreview(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void jD(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eOu;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bw(i, i2);
    }

    public void jE(boolean z) {
        jD(true);
        if (z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.cfe.requestFocus();
                    l.b(c.this.getContext(), c.this.cfe);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.eOs != null) {
            this.eOs.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (c.this.mData != null) {
                        aVar.a(c.this.cfe.getText().toString(), c.this.mData.aSe(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.eOA = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adB() {
        return this.eOA;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adE() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pE(int i) {
        if (this.eOy != null) {
            this.eOy.X((this.eOu - i) * (1.0f / this.eOu));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eOy = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.eOs != null) {
            this.eOs.aLQ();
        }
        aiy();
    }

    public void aiy() {
        if (this.eOC != null) {
            this.eOC.aiy();
        }
    }
}
