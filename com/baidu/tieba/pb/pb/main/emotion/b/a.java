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
/* loaded from: classes2.dex */
public class a extends LinearLayout implements EmotionView.a {
    private float czp;
    private float dkl;
    private float doJ;
    private EditText doO;
    private ImageView doP;
    private SearchEmotionModel.a dox;
    private int eLY;
    private HListView fTU;
    private com.baidu.tieba.pb.pb.main.emotion.b.b fTV;
    private double fTW;
    private int fTX;
    private int fTY;
    private int fTZ;
    private int fUa;
    private b fUb;
    private RelativeLayout fUc;
    private boolean fUd;
    private boolean fUe;
    private c fUf;
    private TextWatcher fUg;
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
    public interface InterfaceC0141a {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public a(Context context) {
        super(context);
        this.fUe = false;
        this.fUg = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.3
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
                        if (a.this.mData != null && !v.E(a.this.mData.aqp())) {
                            a.this.fTV.setData(a.this.mData.aqp());
                            a.this.fTV.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (a.this.fUf == null) {
                        a.this.fUf = new c();
                        a.this.fUf.a(a.this.dox);
                    }
                    a.this.fUf.qr(trim);
                }
            }
        };
        this.dox = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.E(aVar.aqp()) && a.this.doO.getText().toString().trim().equals(str)) {
                    a.this.fTV.setData(aVar.aqp());
                    a.this.fTV.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(d.C0107d.cp_bg_line_d));
        this.fTU = (HListView) findViewById(d.g.lv_emotion);
        this.fTV = new com.baidu.tieba.pb.pb.main.emotion.b.b();
        this.fTV.a(this);
        this.fTU.setAdapter((ListAdapter) this.fTV);
        this.fTU.setDividerWidth(l.s(getContext(), d.e.ds7));
        this.fTU.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.fUc = (RelativeLayout) findViewById(d.g.layout_search);
        this.doO = (EditText) findViewById(d.g.edit_search);
        this.doP = (ImageView) findViewById(d.g.iv_search);
        this.doO.addTextChangedListener(this.fUg);
        this.doO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.doO.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int hb = w.hb(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int e = hb - w.e(obj.charAt(i6));
                        i6++;
                        hb = e;
                    }
                } else {
                    hb += w.hb(charSequence.toString());
                }
                if (hb > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.ao(getContext());
        this.doJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.s(getContext(), d.e.ds150);
        this.fTY = l.s(getContext(), d.e.ds60);
        this.fTZ = l.s(getContext(), d.e.ds114);
        this.eLY = l.s(getContext(), d.e.ds10);
        this.fTX = this.mScreenWidth - l.s(getContext(), d.e.ds130);
        this.fTW = (this.fTY - this.fTZ) * (1.0d / this.fTX);
        this.fUa = l.s(getContext(), d.e.ds100);
        onChangeSkinType();
    }

    public void a(RelativeLayout relativeLayout, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.aqp() != null && !aVar.aqp().isEmpty()) {
            this.mParent = relativeLayout;
            this.mData = aVar;
            this.fTV.setData(aVar.aqp());
            tb(this.fTY);
            tc(this.fTX);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.fTX;
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
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.fTX && I(motionEvent)) {
                    kG(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return H(motionEvent);
    }

    private boolean H(MotionEvent motionEvent) {
        View childAt;
        if (I(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.fTU.getChildCount() <= 0 || this.fTU.getFirstVisiblePosition() != 0 || (childAt = this.fTU.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.dkl) {
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
            if (this.fUe && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.fUe = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.fUe = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.czp = motionEvent.getRawY();
                this.dkl = motionEvent.getRawX();
                this.dkl = motionEvent.getRawX();
                break;
            case 2:
                this.dkl = motionEvent.getRawX();
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
                        kG(false);
                    } else {
                        kG(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    kG(false);
                } else {
                    kG(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.dkl));
                if (rawX2 >= 0) {
                    i = rawX2 > this.fTX ? this.fTX : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int ta = ta(i);
                    if (ta <= this.fTZ && ta >= this.fTY) {
                        tc(i);
                        tb(ta);
                        td(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.doJ && Math.abs(motionEvent.getRawY() - this.czp) < this.doJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ta(int i) {
        return (int) ((this.fTW * i) + this.fTZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        this.fTU.getLayoutParams().height = (this.eLY * 2) + i;
        this.fTV.tb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        float f = 1.0f - ((i * 1.0f) / this.fTX);
        this.fUc.getLayoutParams().height = (int) (this.fUa * f);
        this.fUc.setAlpha(f);
        this.doP.setScaleX(f);
        this.doP.setScaleY(f);
        this.doO.setTextSize(0, f * l.s(getContext(), d.e.fontsize32));
    }

    private void ct(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    a.this.tc(intValue);
                    a.this.tb(a.this.ta(layoutParams.leftMargin));
                    a.this.setLayoutParams(layoutParams);
                    a.this.td(layoutParams.leftMargin);
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

    public void kG(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.fTX;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        ct(i, i2);
    }

    public void kH(boolean z) {
        kG(true);
        if (z) {
            e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.doO.requestFocus();
                    l.b(a.this.getContext(), a.this.doO);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final InterfaceC0141a interfaceC0141a) {
        if (interfaceC0141a != null && this.fTV != null) {
            this.fTV.a(new InterfaceC0141a() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.a.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0141a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    interfaceC0141a.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0141a
                public void a(String str, List<String> list, List<String> list2) {
                    if (a.this.mData != null) {
                        interfaceC0141a.a(a.this.doO.getText().toString(), a.this.mData.bev(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.fUd = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aqr() {
        return this.fUd;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqu() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.fUb != null) {
            this.fUb.onMove((this.fTX - i) * (1.0f / this.fTX));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.fUb = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.fTV != null) {
            this.fTV.aXe();
        }
        avN();
    }

    public void avN() {
        if (this.fUf != null) {
            this.fUf.avN();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.doO, d.C0107d.cp_cont_b);
        aj.t(this, d.C0107d.cp_bg_line_d);
        if (this.fTV != null) {
            this.fTV.notifyDataSetChanged();
        }
    }
}
