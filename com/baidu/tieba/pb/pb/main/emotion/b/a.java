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
public class a extends LinearLayout implements EmotionView.a {
    private float EP;
    private float bKz;
    private float crf;
    private SearchEmotionModel.a cvA;
    private float cvM;
    private EditText cvR;
    private ImageView cvS;
    private int dYv;
    private com.baidu.tieba.pb.pb.main.emotion.b.b ffA;
    private double ffB;
    private int ffC;
    private int ffD;
    private int ffE;
    private int ffF;
    private b ffG;
    private RelativeLayout ffH;
    private boolean ffI;
    private boolean ffJ;
    private c ffK;
    private TextWatcher ffL;
    private HListView ffz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0130a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.ffJ = false;
        this.ffL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.w(a.this.mData.ahM())) {
                            a.this.ffA.setData(a.this.mData.ahM());
                            a.this.ffA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.ffK == null) {
                        a.this.ffK = new c();
                        a.this.ffK.a(a.this.cvA);
                    }
                    a.this.ffK.qe(trim);
                }
            }
        };
        this.cvA = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.ahM()) && a.this.cvR.getText().toString().trim().equals(str)) {
                    a.this.ffA.setData(aVar.ahM());
                    a.this.ffA.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0095d.cp_bg_line_d));
        this.ffz = (HListView) findViewById(d.g.lv_emotion);
        this.ffA = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.ffA.a(this);
        this.ffz.setAdapter((ListAdapter) this.ffA);
        this.ffz.setDividerWidth(l.f(getContext(), d.e.ds7));
        this.ffz.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.ffH = (RelativeLayout) findViewById(d.g.layout_search);
        this.cvR = (EditText) findViewById(d.g.edit_search);
        this.cvS = (ImageView) findViewById(d.g.iv_search);
        this.cvR.addTextChangedListener(this.ffL);
        this.cvR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cvR.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int gX = w.gX(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = gX - w.e(obj.charAt(i6));
                        i6++;
                        gX = e;
                    }
                } else {
                    gX += w.gX(charSequence.toString());
                }
                if (gX > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ac(getContext());
        this.cvM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.e.ds150);
        this.ffD = l.f(getContext(), d.e.ds60);
        this.ffE = l.f(getContext(), d.e.ds114);
        this.dYv = l.f(getContext(), d.e.ds10);
        this.ffC = this.mScreenWidth - l.f(getContext(), d.e.ds130);
        this.ffB = (this.ffD - this.ffE) * (1.0d / this.ffC);
        this.ffF = l.f(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.ahM() != null && !aVar.ahM().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.ffA.setData(aVar.ahM());
            qp(this.ffD);
            qq(this.ffC);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.ffC;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.ffC && A(motionEvent)) {
                    kc(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return z(motionEvent);
    }

    private boolean z(MotionEvent motionEvent) {
        View childAt;
        if (A(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.ffz.getChildCount() <= 0 || this.ffz.getFirstVisiblePosition() != 0 || (childAt = this.ffz.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.crf) {
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
            if (this.ffJ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.ffJ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.ffJ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.EP = motionEvent.getRawX();
                this.bKz = motionEvent.getRawY();
                this.crf = motionEvent.getRawX();
                this.crf = motionEvent.getRawX();
                break;
            case 2:
                this.crf = motionEvent.getRawX();
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
                        kc(false);
                    } else {
                        kc(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kc(false);
                } else {
                    kc(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.crf));
                if (rawX2 >= 0) {
                    i = rawX2 > this.ffC ? this.ffC : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qo = qo(i);
                    if (qo <= this.ffE && qo >= this.ffD) {
                        qq(i);
                        qp(qo);
                        qr(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean A(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cvM && Math.abs(motionEvent.getRawY() - this.bKz) < this.cvM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qo(int i) {
        return (int) ((this.ffB * i) + this.ffE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        this.ffz.getLayoutParams().height = (this.dYv * 2) + i;
        this.ffA.qp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
        float f = 1.0f - ((i * 1.0f) / this.ffC);
        this.ffH.getLayoutParams().height = (int) (this.ffF * f);
        this.ffH.setAlpha(f);
        this.cvS.setScaleX(f);
        this.cvS.setScaleY(f);
        this.cvR.setTextSize(0, f * l.f(getContext(), d.e.fontsize32));
    }

    private void bv(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.qq(intValue);
                    a.this.qp(a.this.qo(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.qr(layoutParams.leftMargin);
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

    public void kc(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.ffC;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bv(i, i2);
    }

    public void kd(boolean z) {
        kc(true);
        if (z) {
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cvR.requestFocus();
                    l.b(a.this.getContext(), a.this.cvR);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null && this.ffA != null) {
            this.ffA.a(new InterfaceC0130a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0130a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0130a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0130a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0130a.a(a.this.cvR.getText().toString(), a.this.mData.aXd(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.ffI = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ahO() {
        return this.ffI;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahR() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahS() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        if (this.ffG != null) {
            this.ffG.onMove((this.ffC - i) * (1.0f / this.ffC));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.ffG = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.ffA != null) {
            this.ffA.aPP();
        }
        and();
    }

    public void and() {
        if (this.ffK != null) {
            this.ffK.and();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cvR, d.C0095d.cp_cont_b);
        aj.k(this, d.C0095d.cp_bg_line_d);
        if (this.ffA != null) {
            this.ffA.notifyDataSetChanged();
        }
    }
}
