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
    private float Fd;
    private float bxE;
    private float caC;
    private SearchEmotionModel.a ceY;
    private float cfl;
    private EditText cfq;
    private ImageView cfr;
    private int dHS;
    private HListView eOF;
    private d eOG;
    private double eOH;
    private int eOI;
    private int eOJ;
    private int eOK;
    private int eOL;
    private b eOM;
    private RelativeLayout eON;
    private boolean eOO;
    private boolean eOP;
    private e eOQ;
    private TextWatcher eOR;
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
        this.eOP = false;
        this.eOR = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
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
                        if (c.this.mData != null && !v.u(c.this.mData.adD())) {
                            c.this.eOG.setData(c.this.mData.adD());
                            c.this.eOG.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (c.this.eOQ == null) {
                        c.this.eOQ = new e();
                        c.this.eOQ.a(c.this.ceY);
                    }
                    c.this.eOQ.pj(trim);
                }
            }
        };
        this.ceY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.u(aVar.adD()) && c.this.cfq.getText().toString().trim().equals(str)) {
                    c.this.eOG.setData(aVar.adD());
                    c.this.eOG.notifyDataSetChanged();
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
        this.eOF = (HListView) findViewById(d.h.lv_emotion);
        this.eOG = new d();
        this.eOG.a(this);
        this.eOF.setAdapter((ListAdapter) this.eOG);
        this.eOF.setDividerWidth(l.f(getContext(), d.f.ds7));
        this.eOF.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.eON = (RelativeLayout) findViewById(d.h.layout_search);
        this.cfq = (EditText) findViewById(d.h.edit_search);
        aj.i(this.cfq, d.e.cp_cont_b);
        this.cfr = (ImageView) findViewById(d.h.iv_search);
        this.cfq.addTextChangedListener(this.eOR);
        this.cfq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cfq.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gP = u.gP(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gP - u.e(obj.charAt(i6));
                        i6++;
                        gP = e;
                    }
                } else {
                    gP += u.gP(charSequence.toString());
                }
                if (gP > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ad(getContext());
        this.cfl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.f.ds150);
        this.eOJ = l.f(getContext(), d.f.ds60);
        this.eOK = l.f(getContext(), d.f.ds114);
        this.dHS = l.f(getContext(), d.f.ds10);
        this.eOI = this.mScreenWidth - l.f(getContext(), d.f.ds130);
        this.eOH = (this.eOJ - this.eOK) * (1.0d / this.eOI);
        this.eOL = l.f(getContext(), d.f.ds100);
        aj.k(this, d.e.cp_bg_line_d);
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.adD() != null && !aVar.adD().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.eOG.setData(aVar.adD());
            pD(this.eOJ);
            pE(this.eOI);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eOI;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.eOI && t(motionEvent)) {
                    jE(true);
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
        if (this.eOF.getChildCount() <= 0 || this.eOF.getFirstVisiblePosition() != 0 || (childAt = this.eOF.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.caC) {
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
            if (this.eOP && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.eOP = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.eOP = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.Fd = motionEvent.getRawX();
                this.bxE = motionEvent.getRawY();
                this.caC = motionEvent.getRawX();
                this.caC = motionEvent.getRawX();
                break;
            case 2:
                this.caC = motionEvent.getRawX();
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
                int rawX = (int) (motionEvent.getRawX() - this.Fd);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        jE(false);
                    } else {
                        jE(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jE(false);
                } else {
                    jE(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.caC));
                if (rawX2 >= 0) {
                    i = rawX2 > this.eOI ? this.eOI : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int pC = pC(i);
                    if (pC <= this.eOK && pC >= this.eOJ) {
                        pE(i);
                        pD(pC);
                        pF(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fd) < this.cfl && Math.abs(motionEvent.getRawY() - this.bxE) < this.cfl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pC(int i) {
        return (int) ((this.eOH * i) + this.eOK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(int i) {
        this.eOF.getLayoutParams().height = (this.dHS * 2) + i;
        this.eOG.pD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pE(int i) {
        float f = 1.0f - ((i * 1.0f) / this.eOI);
        this.eON.getLayoutParams().height = (int) (this.eOL * f);
        this.eON.setAlpha(f);
        this.cfr.setScaleX(f);
        this.cfr.setScaleY(f);
        this.cfq.setTextSize(0, f * l.f(getContext(), d.f.fontsize32));
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
                    c.this.pE(intValue);
                    c.this.pD(c.this.pC(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pF(layoutParams.leftMargin);
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

    public void jE(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eOI;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bw(i, i2);
    }

    public void jF(boolean z) {
        jE(true);
        if (z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.cfq.requestFocus();
                    l.b(c.this.getContext(), c.this.cfq);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.eOG != null) {
            this.eOG.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (c.this.mData != null) {
                        aVar.a(c.this.cfq.getText().toString(), c.this.mData.aSj(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.eOO = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adF() {
        return this.eOO;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adG() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adJ() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        if (this.eOM != null) {
            this.eOM.X((this.eOI - i) * (1.0f / this.eOI));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eOM = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.eOG != null) {
            this.eOG.aLV();
        }
        aiD();
    }

    public void aiD() {
        if (this.eOQ != null) {
            this.eOQ.aiD();
        }
    }
}
