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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout implements EmotionView.a {
    private float EP;
    private float bCe;
    private float chX;
    private SearchEmotionModel.a cmg;
    private float cmt;
    private EditText cmy;
    private ImageView cmz;
    private int dPs;
    private HListView eXj;
    private d eXk;
    private double eXl;
    private int eXm;
    private int eXn;
    private int eXo;
    private int eXp;
    private b eXq;
    private RelativeLayout eXr;
    private boolean eXs;
    private boolean eXt;
    private e eXu;
    private TextWatcher eXv;
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
        void onMove(float f);
    }

    public c(Context context) {
        super(context);
        this.eXt = false;
        this.eXv = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
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
                        if (c.this.mData != null && !v.v(c.this.mData.afG())) {
                            c.this.eXk.setData(c.this.mData.afG());
                            c.this.eXk.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (c.this.eXu == null) {
                        c.this.eXu = new e();
                        c.this.eXu.a(c.this.cmg);
                    }
                    c.this.eXu.pN(trim);
                }
            }
        };
        this.cmg = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.v(aVar.afG()) && c.this.cmy.getText().toString().trim().equals(str)) {
                    c.this.eXk.setData(aVar.afG());
                    c.this.eXk.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0080d.cp_bg_line_d));
        this.eXj = (HListView) findViewById(d.g.lv_emotion);
        this.eXk = new d();
        this.eXk.a(this);
        this.eXj.setAdapter((ListAdapter) this.eXk);
        this.eXj.setDividerWidth(l.f(getContext(), d.e.ds7));
        this.eXj.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.eXr = (RelativeLayout) findViewById(d.g.layout_search);
        this.cmy = (EditText) findViewById(d.g.edit_search);
        this.cmz = (ImageView) findViewById(d.g.iv_search);
        this.cmy.addTextChangedListener(this.eXv);
        this.cmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cmy.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gV = w.gV(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gV - w.e(obj.charAt(i6));
                        i6++;
                        gV = e;
                    }
                } else {
                    gV += w.gV(charSequence.toString());
                }
                if (gV > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ac(getContext());
        this.cmt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.e.ds150);
        this.eXn = l.f(getContext(), d.e.ds60);
        this.eXo = l.f(getContext(), d.e.ds114);
        this.dPs = l.f(getContext(), d.e.ds10);
        this.eXm = this.mScreenWidth - l.f(getContext(), d.e.ds130);
        this.eXl = (this.eXn - this.eXo) * (1.0d / this.eXm);
        this.eXp = l.f(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.afG() != null && !aVar.afG().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.eXk.setData(aVar.afG());
            pW(this.eXn);
            pX(this.eXm);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eXm;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.eXm && v(motionEvent)) {
                    jx(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return w(motionEvent);
    }

    private boolean w(MotionEvent motionEvent) {
        View childAt;
        if (v(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.eXj.getChildCount() <= 0 || this.eXj.getFirstVisiblePosition() != 0 || (childAt = this.eXj.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.chX) {
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
            if (this.eXt && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.eXt = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.eXt = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.EP = motionEvent.getRawX();
                this.bCe = motionEvent.getRawY();
                this.chX = motionEvent.getRawX();
                this.chX = motionEvent.getRawX();
                break;
            case 2:
                this.chX = motionEvent.getRawX();
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
                        jx(false);
                    } else {
                        jx(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jx(false);
                } else {
                    jx(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.chX));
                if (rawX2 >= 0) {
                    i = rawX2 > this.eXm ? this.eXm : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int pV = pV(i);
                    if (pV <= this.eXo && pV >= this.eXn) {
                        pX(i);
                        pW(pV);
                        pY(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmt && Math.abs(motionEvent.getRawY() - this.bCe) < this.cmt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pV(int i) {
        return (int) ((this.eXl * i) + this.eXo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(int i) {
        this.eXj.getLayoutParams().height = (this.dPs * 2) + i;
        this.eXk.pW(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        float f = 1.0f - ((i * 1.0f) / this.eXm);
        this.eXr.getLayoutParams().height = (int) (this.eXp * f);
        this.eXr.setAlpha(f);
        this.cmz.setScaleX(f);
        this.cmz.setScaleY(f);
        this.cmy.setTextSize(0, f * l.f(getContext(), d.e.fontsize32));
    }

    private void by(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    c.this.pX(intValue);
                    c.this.pW(c.this.pV(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pY(layoutParams.leftMargin);
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

    public void jx(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eXm;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        by(i, i2);
    }

    public void jy(boolean z) {
        jx(true);
        if (z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.cmy.requestFocus();
                    l.b(c.this.getContext(), c.this.cmy);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.eXk != null) {
            this.eXk.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (c.this.mData != null) {
                        aVar.a(c.this.cmy.getText().toString(), c.this.mData.aVs(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.eXs = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean afI() {
        return this.eXs;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afL() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afM() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(int i) {
        if (this.eXq != null) {
            this.eXq.onMove((this.eXm - i) * (1.0f / this.eXm));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eXq = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.eXk != null) {
            this.eXk.aOI();
        }
        akK();
    }

    public void akK() {
        if (this.eXu != null) {
            this.eXu.akK();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cmy, d.C0080d.cp_cont_b);
        aj.k(this, d.C0080d.cp_bg_line_d);
        if (this.eXk != null) {
            this.eXk.notifyDataSetChanged();
        }
    }
}
