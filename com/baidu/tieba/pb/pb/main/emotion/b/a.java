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
/* loaded from: classes2.dex */
public class a extends LinearLayout implements EmotionView.a {
    private float cDu;
    private float dnw;
    private SearchEmotionModel.a drL;
    private float drX;
    private EditText dsc;
    private ImageView dsd;
    private int eQC;
    private HListView fXB;
    private com.baidu.tieba.pb.pb.main.emotion.b.b fXC;
    private double fXD;
    private int fXE;
    private int fXF;
    private int fXG;
    private int fXH;
    private b fXI;
    private RelativeLayout fXJ;
    private boolean fXK;
    private boolean fXL;
    private c fXM;
    private TextWatcher fXN;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0210a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.fXL = false;
        this.fXN = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.E(a.this.mData.ark())) {
                            a.this.fXC.setData(a.this.mData.ark());
                            a.this.fXC.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.fXM == null) {
                        a.this.fXM = new c();
                        a.this.fXM.a(a.this.drL);
                    }
                    a.this.fXM.qH(trim);
                }
            }
        };
        this.drL = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.E(aVar.ark()) && a.this.dsc.getText().toString().trim().equals(str)) {
                    a.this.fXC.setData(aVar.ark());
                    a.this.fXC.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0140d.cp_bg_line_d));
        this.fXB = (HListView) findViewById(d.g.lv_emotion);
        this.fXC = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.fXC.a(this);
        this.fXB.setAdapter((ListAdapter) this.fXC);
        this.fXB.setDividerWidth(l.t(getContext(), d.e.ds7));
        this.fXB.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fXJ = (RelativeLayout) findViewById(d.g.layout_search);
        this.dsc = (EditText) findViewById(d.g.edit_search);
        this.dsd = (ImageView) findViewById(d.g.iv_search);
        this.dsc.addTextChangedListener(this.fXN);
        this.dsc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dsc.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hs = w.hs(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = hs - w.e(obj.charAt(i6));
                        i6++;
                        hs = e;
                    }
                } else {
                    hs += w.hs(charSequence.toString());
                }
                if (hs > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ao(getContext());
        this.drX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.t(getContext(), d.e.ds150);
        this.fXF = l.t(getContext(), d.e.ds60);
        this.fXG = l.t(getContext(), d.e.ds114);
        this.eQC = l.t(getContext(), d.e.ds10);
        this.fXE = this.mScreenWidth - l.t(getContext(), d.e.ds130);
        this.fXD = (this.fXF - this.fXG) * (1.0d / this.fXE);
        this.fXH = l.t(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.ark() != null && !aVar.ark().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fXC.setData(aVar.ark());
            tf(this.fXF);
            tg(this.fXE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fXE;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fXE && M(motionEvent)) {
                    kR(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return L(motionEvent);
    }

    private boolean L(MotionEvent motionEvent) {
        View childAt;
        if (M(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fXB.getChildCount() <= 0 || this.fXB.getFirstVisiblePosition() != 0 || (childAt = this.fXB.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dnw) {
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
            if (this.fXL && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fXL = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fXL = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cDu = motionEvent.getRawY();
                this.dnw = motionEvent.getRawX();
                this.dnw = motionEvent.getRawX();
                break;
            case 2:
                this.dnw = motionEvent.getRawX();
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
                        kR(false);
                    } else {
                        kR(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kR(false);
                } else {
                    kR(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dnw));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fXE ? this.fXE : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int te = te(i);
                    if (te <= this.fXG && te >= this.fXF) {
                        tg(i);
                        tf(te);
                        th(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drX && Math.abs(motionEvent.getRawY() - this.cDu) < this.drX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int te(int i) {
        return (int) ((this.fXD * i) + this.fXG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(int i) {
        this.fXB.getLayoutParams().height = (this.eQC * 2) + i;
        this.fXC.tf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fXE);
        this.fXJ.getLayoutParams().height = (int) (this.fXH * f);
        this.fXJ.setAlpha(f);
        this.dsd.setScaleX(f);
        this.dsd.setScaleY(f);
        this.dsc.setTextSize(0, f * l.t(getContext(), d.e.fontsize32));
    }

    private void cp(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.tg(intValue);
                    a.this.tf(a.this.te(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.th(layoutParams.leftMargin);
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

    public void kR(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fXE;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        cp(i, i2);
    }

    public void kS(boolean z) {
        kR(true);
        if (z) {
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dsc.requestFocus();
                    l.b(a.this.getContext(), a.this.dsc);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0210a interfaceC0210a) {
        if (interfaceC0210a != null && this.fXC != null) {
            this.fXC.a(new InterfaceC0210a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0210a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0210a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0210a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0210a.a(a.this.dsc.getText().toString(), a.this.mData.bga(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fXK = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arm() {
        return this.fXK;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arp() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        if (this.fXI != null) {
            this.fXI.onMove((this.fXE - i) * (1.0f / this.fXE));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fXI = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fXC != null) {
            this.fXC.aYS();
        }
        awP();
    }

    public void awP() {
        if (this.fXM != null) {
            this.fXM.awP();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dsc, d.C0140d.cp_cont_b);
        this.dsc.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        aj.t(this, d.C0140d.cp_bg_line_d);
        if (this.fXC != null) {
            this.fXC.notifyDataSetChanged();
        }
    }
}
