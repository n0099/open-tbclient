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
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bmR;
    private float cVG;
    private SearchEmotionModel.a dbh;
    private float dbt;
    private EditText dby;
    private ImageView dbz;
    private int eMl;
    private HListView fPW;
    private com.baidu.tieba.pb.pb.main.emotion.view.a fPX;
    private double fPY;
    private int fPZ;
    private int fQa;
    private int fQb;
    private int fQc;
    private b fQd;
    private RelativeLayout fQe;
    private boolean fQf;
    private boolean fQg;
    private com.baidu.tieba.pb.pb.main.emotion.view.b fQh;
    private TextWatcher fQi;
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
        this.fQg = false;
        this.fQi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.z(PbEmotionBar.this.mData.arp())) {
                            PbEmotionBar.this.fPX.setData(PbEmotionBar.this.mData.arp());
                            PbEmotionBar.this.fPX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fQh == null) {
                        PbEmotionBar.this.fQh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fQh.a(PbEmotionBar.this.dbh);
                    }
                    PbEmotionBar.this.fQh.sh(trim);
                }
            }
        };
        this.dbh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.z(aVar.arp()) && PbEmotionBar.this.dby.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fPX.setData(aVar.arp());
                    PbEmotionBar.this.fPX.notifyDataSetChanged();
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
        this.fQg = false;
        this.fQi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.z(PbEmotionBar.this.mData.arp())) {
                            PbEmotionBar.this.fPX.setData(PbEmotionBar.this.mData.arp());
                            PbEmotionBar.this.fPX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fQh == null) {
                        PbEmotionBar.this.fQh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fQh.a(PbEmotionBar.this.dbh);
                    }
                    PbEmotionBar.this.fQh.sh(trim);
                }
            }
        };
        this.dbh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.z(aVar.arp()) && PbEmotionBar.this.dby.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fPX.setData(aVar.arp());
                    PbEmotionBar.this.fPX.notifyDataSetChanged();
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
        this.fQg = false;
        this.fQi = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.z(PbEmotionBar.this.mData.arp())) {
                            PbEmotionBar.this.fPX.setData(PbEmotionBar.this.mData.arp());
                            PbEmotionBar.this.fPX.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.fQh == null) {
                        PbEmotionBar.this.fQh = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.fQh.a(PbEmotionBar.this.dbh);
                    }
                    PbEmotionBar.this.fQh.sh(trim);
                }
            }
        };
        this.dbh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.z(aVar.arp()) && PbEmotionBar.this.dby.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.fPX.setData(aVar.arp());
                    PbEmotionBar.this.fPX.notifyDataSetChanged();
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
        this.fPW = (HListView) findViewById(e.g.lv_emotion);
        this.fPX = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.fPX.a(this);
        this.fPW.setAdapter((ListAdapter) this.fPX);
        this.fPW.setDividerWidth(l.h(getContext(), e.C0141e.ds7));
        this.fPW.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.fQe = (RelativeLayout) findViewById(e.g.layout_search);
        this.dby = (EditText) findViewById(e.g.edit_search);
        this.dbz = (ImageView) findViewById(e.g.iv_search);
        this.dby.addTextChangedListener(this.fQi);
        this.dby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.dby.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int m16if = y.m16if(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = m16if - y.d(obj.charAt(i6));
                        i6++;
                        m16if = d;
                    }
                } else {
                    m16if += y.m16if(charSequence.toString());
                }
                if (m16if > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.aO(getContext());
        this.dbt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.h(getContext(), e.C0141e.ds150);
        this.fQa = l.h(getContext(), e.C0141e.ds60);
        this.fQb = l.h(getContext(), e.C0141e.ds114);
        this.eMl = l.h(getContext(), e.C0141e.ds10);
        this.fPZ = this.mScreenWidth - l.h(getContext(), e.C0141e.ds130);
        this.fPY = (this.fQa - this.fQb) * (1.0d / this.fPZ);
        this.fQc = l.h(getContext(), e.C0141e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.arp() != null && !aVar.arp().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fPX.setData(aVar.arp());
            rs(this.fQa);
            rt(this.fPZ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fPZ;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fPZ && G(motionEvent)) {
                    kU(true);
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
        if (this.fPW.getChildCount() <= 0 || this.fPW.getFirstVisiblePosition() != 0 || (childAt = this.fPW.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.cVG) {
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
            if (this.fQg && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fQg = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fQg = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bmR = motionEvent.getRawY();
                this.cVG = motionEvent.getRawX();
                this.cVG = motionEvent.getRawX();
                break;
            case 2:
                this.cVG = motionEvent.getRawX();
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
                        kU(false);
                    } else {
                        kU(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kU(false);
                } else {
                    kU(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.cVG));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fPZ ? this.fPZ : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int rr = rr(i);
                    if (rr <= this.fQb && rr >= this.fQa) {
                        rt(i);
                        rs(rr);
                        ru(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.dbt && Math.abs(motionEvent.getRawY() - this.bmR) < this.dbt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rr(int i) {
        return (int) ((this.fPY * i) + this.fQb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
        this.fPW.getLayoutParams().height = (this.eMl * 2) + i;
        this.fPX.rs(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fPZ);
        this.fQe.getLayoutParams().height = (int) (this.fQc * f);
        this.fQe.setAlpha(f);
        this.dbz.setScaleX(f);
        this.dbz.setScaleY(f);
        this.dby.setTextSize(0, f * l.h(getContext(), e.C0141e.fontsize32));
    }

    private void bv(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.rt(intValue);
                    PbEmotionBar.this.rs(PbEmotionBar.this.rr(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.ru(layoutParams.leftMargin);
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

    public void kU(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fPZ;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        bv(i, i2);
    }

    public void kV(boolean z) {
        kU(true);
        if (z) {
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.dby.requestFocus();
                    l.b(PbEmotionBar.this.getContext(), PbEmotionBar.this.dby);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.fPX != null) {
            this.fPX.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.a(PbEmotionBar.this.dby.getText().toString(), PbEmotionBar.this.mData.bhw(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fQf = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arr() {
        return this.fQf;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aru() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru(int i) {
        if (this.fQd != null) {
            this.fQd.onMove((this.fPZ - i) * (1.0f / this.fPZ));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fQd = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fPX != null) {
            this.fPX.aZV();
        }
        ayC();
    }

    public void ayC() {
        if (this.fQh != null) {
            this.fQh.ayC();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dby, e.d.cp_cont_b);
        this.dby.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.j(this, e.d.cp_bg_line_d);
        if (this.fPX != null) {
            this.fPX.notifyDataSetChanged();
        }
    }
}
