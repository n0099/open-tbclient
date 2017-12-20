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
    private float EO;
    private float bKv;
    private float cra;
    private float cvI;
    private EditText cvN;
    private ImageView cvO;
    private SearchEmotionModel.a cvw;
    private int dYr;
    private int ffA;
    private b ffB;
    private RelativeLayout ffC;
    private boolean ffD;
    private boolean ffE;
    private c ffF;
    private TextWatcher ffG;
    private HListView ffu;
    private com.baidu.tieba.pb.pb.main.emotion.b.b ffv;
    private double ffw;
    private int ffx;
    private int ffy;
    private int ffz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0131a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.ffE = false;
        this.ffG = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                            a.this.ffv.setData(a.this.mData.ahM());
                            a.this.ffv.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.ffF == null) {
                        a.this.ffF = new c();
                        a.this.ffF.a(a.this.cvw);
                    }
                    a.this.ffF.qe(trim);
                }
            }
        };
        this.cvw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.w(aVar.ahM()) && a.this.cvN.getText().toString().trim().equals(str)) {
                    a.this.ffv.setData(aVar.ahM());
                    a.this.ffv.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0096d.cp_bg_line_d));
        this.ffu = (HListView) findViewById(d.g.lv_emotion);
        this.ffv = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.ffv.a(this);
        this.ffu.setAdapter((ListAdapter) this.ffv);
        this.ffu.setDividerWidth(l.f(getContext(), d.e.ds7));
        this.ffu.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.ffC = (RelativeLayout) findViewById(d.g.layout_search);
        this.cvN = (EditText) findViewById(d.g.edit_search);
        this.cvO = (ImageView) findViewById(d.g.iv_search);
        this.cvN.addTextChangedListener(this.ffG);
        this.cvN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.cvN.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
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
        this.cvI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.f(getContext(), d.e.ds150);
        this.ffy = l.f(getContext(), d.e.ds60);
        this.ffz = l.f(getContext(), d.e.ds114);
        this.dYr = l.f(getContext(), d.e.ds10);
        this.ffx = this.mScreenWidth - l.f(getContext(), d.e.ds130);
        this.ffw = (this.ffy - this.ffz) * (1.0d / this.ffx);
        this.ffA = l.f(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.ahM() != null && !aVar.ahM().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.ffv.setData(aVar.ahM());
            qp(this.ffy);
            qq(this.ffx);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.ffx;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.ffx && A(motionEvent)) {
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
        if (this.ffu.getChildCount() <= 0 || this.ffu.getFirstVisiblePosition() != 0 || (childAt = this.ffu.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cra) {
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
            if (this.ffE && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.ffE = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.ffE = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.EO = motionEvent.getRawX();
                this.bKv = motionEvent.getRawY();
                this.cra = motionEvent.getRawX();
                this.cra = motionEvent.getRawX();
                break;
            case 2:
                this.cra = motionEvent.getRawX();
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
                int rawX = (int) (motionEvent.getRawX() - this.EO);
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cra));
                if (rawX2 >= 0) {
                    i = rawX2 > this.ffx ? this.ffx : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int qo = qo(i);
                    if (qo <= this.ffz && qo >= this.ffy) {
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
        return Math.abs(motionEvent.getRawX() - this.EO) < this.cvI && Math.abs(motionEvent.getRawY() - this.bKv) < this.cvI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qo(int i) {
        return (int) ((this.ffw * i) + this.ffz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        this.ffu.getLayoutParams().height = (this.dYr * 2) + i;
        this.ffv.qp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
        float f = 1.0f - ((i * 1.0f) / this.ffx);
        this.ffC.getLayoutParams().height = (int) (this.ffA * f);
        this.ffC.setAlpha(f);
        this.cvO.setScaleX(f);
        this.cvO.setScaleY(f);
        this.cvN.setTextSize(0, f * l.f(getContext(), d.e.fontsize32));
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
        int i2 = this.ffx;
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
                    a.this.cvN.requestFocus();
                    l.b(a.this.getContext(), a.this.cvN);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0131a interfaceC0131a) {
        if (interfaceC0131a != null && this.ffv != null) {
            this.ffv.a(new InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0131a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0131a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0131a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0131a.a(a.this.cvN.getText().toString(), a.this.mData.aXc(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.ffD = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ahO() {
        return this.ffD;
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
        if (this.ffB != null) {
            this.ffB.onMove((this.ffx - i) * (1.0f / this.ffx));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.ffB = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.ffv != null) {
            this.ffv.aPO();
        }
        anc();
    }

    public void anc() {
        if (this.ffF != null) {
            this.ffF.anc();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cvN, d.C0096d.cp_cont_b);
        aj.k(this, d.C0096d.cp_bg_line_d);
        if (this.ffv != null) {
            this.ffv.notifyDataSetChanged();
        }
    }
}
