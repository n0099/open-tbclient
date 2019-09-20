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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float cRJ;
    private float eVl;
    private SearchEmotionModel.a feU;
    private float ffg;
    private EditText ffl;
    private ImageView ffm;
    private int gVL;
    private HListView ian;
    private com.baidu.tieba.pb.pb.main.emotion.view.a iao;
    private double iap;
    private int iaq;
    private int iar;
    private int ias;
    private int iat;
    private b iau;
    private RelativeLayout iav;
    private boolean iaw;
    private boolean iax;
    private com.baidu.tieba.pb.pb.main.emotion.view.b iay;
    private TextWatcher iaz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes4.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.iax = false;
        this.iaz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhZ())) {
                            PbEmotionBar.this.iao.setData(PbEmotionBar.this.mData.bhZ());
                            PbEmotionBar.this.iao.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iay == null) {
                        PbEmotionBar.this.iay = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iay.a(PbEmotionBar.this.feU);
                    }
                    PbEmotionBar.this.iay.CL(trim);
                }
            }
        };
        this.feU = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhZ()) && PbEmotionBar.this.ffl.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iao.setData(aVar.bhZ());
                    PbEmotionBar.this.iao.notifyDataSetChanged();
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
        this.iax = false;
        this.iaz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhZ())) {
                            PbEmotionBar.this.iao.setData(PbEmotionBar.this.mData.bhZ());
                            PbEmotionBar.this.iao.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iay == null) {
                        PbEmotionBar.this.iay = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iay.a(PbEmotionBar.this.feU);
                    }
                    PbEmotionBar.this.iay.CL(trim);
                }
            }
        };
        this.feU = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhZ()) && PbEmotionBar.this.ffl.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iao.setData(aVar.bhZ());
                    PbEmotionBar.this.iao.notifyDataSetChanged();
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
        this.iax = false;
        this.iaz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhZ())) {
                            PbEmotionBar.this.iao.setData(PbEmotionBar.this.mData.bhZ());
                            PbEmotionBar.this.iao.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iay == null) {
                        PbEmotionBar.this.iay = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iay.a(PbEmotionBar.this.feU);
                    }
                    PbEmotionBar.this.iay.CL(trim);
                }
            }
        };
        this.feU = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhZ()) && PbEmotionBar.this.ffl.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iao.setData(aVar.bhZ());
                    PbEmotionBar.this.iao.notifyDataSetChanged();
                }
            }

            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void onFail(int i2, String str) {
            }
        };
        init();
    }

    private void init() {
        setId(R.id.pb_emotion_bar);
        inflate(getContext(), R.layout.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
        this.ian = (HListView) findViewById(R.id.lv_emotion);
        this.iao = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.iao.a(this);
        this.ian.setAdapter((ListAdapter) this.iao);
        this.ian.setDividerWidth(l.g(getContext(), R.dimen.ds7));
        this.ian.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.iav = (RelativeLayout) findViewById(R.id.layout_search);
        this.ffl = (EditText) findViewById(R.id.edit_search);
        this.ffm = (ImageView) findViewById(R.id.iv_search);
        this.ffl.addTextChangedListener(this.iaz);
        this.ffl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.ffl.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int ry = aa.ry(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = ry - aa.d(obj.charAt(i6));
                        i6++;
                        ry = d;
                    }
                } else {
                    ry += aa.ry(charSequence.toString());
                }
                if (ry > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.af(getContext());
        this.ffg = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.g(getContext(), R.dimen.ds150);
        this.iar = l.g(getContext(), R.dimen.ds58);
        this.ias = l.g(getContext(), R.dimen.ds114);
        this.gVL = l.g(getContext(), R.dimen.ds10);
        this.iaq = this.mScreenWidth - l.g(getContext(), R.dimen.tbds196);
        this.iap = (this.iar - this.ias) * (1.0d / this.iaq);
        this.iat = l.g(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.iaq && M(motionEvent)) {
                    pj(true);
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
        if (this.ian.getChildCount() <= 0 || this.ian.getFirstVisiblePosition() != 0 || (childAt = this.ian.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.eVl) {
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
            if (this.iax && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.iax = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.iax = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cRJ = motionEvent.getRawY();
                this.eVl = motionEvent.getRawX();
                this.eVl = motionEvent.getRawX();
                break;
            case 2:
                this.eVl = motionEvent.getRawX();
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
                        pj(false);
                    } else {
                        pj(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    pj(false);
                } else {
                    pj(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eVl));
                if (rawX2 >= 0) {
                    i = rawX2 > this.iaq ? this.iaq : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int yn = yn(i);
                    if (yn <= this.ias && yn >= this.iar) {
                        yp(i);
                        yo(yn);
                        yq(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.ffg && Math.abs(motionEvent.getRawY() - this.cRJ) < this.ffg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yn(int i) {
        return (int) ((this.iap * i) + this.ias);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(int i) {
        this.ian.getLayoutParams().height = (this.gVL * 2) + i;
        this.iao.yo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp(int i) {
        float f = 1.0f - ((i * 1.0f) / this.iaq);
        this.iav.getLayoutParams().height = (int) (this.iat * f);
        this.iav.setAlpha(f);
        this.ffm.setScaleX(f);
        this.ffm.setScaleY(f);
        this.ffl.setTextSize(0, f * l.g(getContext(), R.dimen.fontsize32));
    }

    private void ci(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.yp(intValue);
                    PbEmotionBar.this.yo(PbEmotionBar.this.yn(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.yq(layoutParams.leftMargin);
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

    public void pj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.iaq;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        ci(i, i2);
    }

    public void pk(boolean z) {
        pj(true);
        if (z) {
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.ffl.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.ffl);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.iao != null) {
            this.iao.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.ffl.getText().toString(), PbEmotionBar.this.mData.bZw(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.iaw = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bib() {
        return this.iaw;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bie() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bif() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq(int i) {
        if (this.iau != null) {
            this.iau.onMove((this.iaq - i) * (1.0f / this.iaq));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.iau = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.iao != null) {
            this.iao.bRH();
        }
        bpq();
    }

    public void bpq() {
        if (this.iay != null) {
            this.iay.bpq();
        }
    }

    public void onChangeSkinType() {
        am.j(this.ffl, R.color.cp_cont_b);
        this.ffl.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.l(this, R.color.cp_bg_line_d);
        if (this.iao != null) {
            this.iao.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.iaq;
    }
}
