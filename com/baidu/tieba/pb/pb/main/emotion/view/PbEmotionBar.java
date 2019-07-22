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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float cQM;
    private float eTy;
    private SearchEmotionModel.a fcH;
    private float fcT;
    private EditText fcY;
    private ImageView fcZ;
    private int gTa;
    private int hXA;
    private b hXB;
    private RelativeLayout hXC;
    private boolean hXD;
    private boolean hXE;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hXF;
    private TextWatcher hXG;
    private HListView hXu;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hXv;
    private double hXw;
    private int hXx;
    private int hXy;
    private int hXz;
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
        this.hXE = false;
        this.hXG = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhh())) {
                            PbEmotionBar.this.hXv.setData(PbEmotionBar.this.mData.bhh());
                            PbEmotionBar.this.hXv.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hXF == null) {
                        PbEmotionBar.this.hXF = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hXF.a(PbEmotionBar.this.fcH);
                    }
                    PbEmotionBar.this.hXF.Cl(trim);
                }
            }
        };
        this.fcH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhh()) && PbEmotionBar.this.fcY.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hXv.setData(aVar.bhh());
                    PbEmotionBar.this.hXv.notifyDataSetChanged();
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
        this.hXE = false;
        this.hXG = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhh())) {
                            PbEmotionBar.this.hXv.setData(PbEmotionBar.this.mData.bhh());
                            PbEmotionBar.this.hXv.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hXF == null) {
                        PbEmotionBar.this.hXF = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hXF.a(PbEmotionBar.this.fcH);
                    }
                    PbEmotionBar.this.hXF.Cl(trim);
                }
            }
        };
        this.fcH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhh()) && PbEmotionBar.this.fcY.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hXv.setData(aVar.bhh());
                    PbEmotionBar.this.hXv.notifyDataSetChanged();
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
        this.hXE = false;
        this.hXG = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bhh())) {
                            PbEmotionBar.this.hXv.setData(PbEmotionBar.this.mData.bhh());
                            PbEmotionBar.this.hXv.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hXF == null) {
                        PbEmotionBar.this.hXF = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hXF.a(PbEmotionBar.this.fcH);
                    }
                    PbEmotionBar.this.hXF.Cl(trim);
                }
            }
        };
        this.fcH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bhh()) && PbEmotionBar.this.fcY.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hXv.setData(aVar.bhh());
                    PbEmotionBar.this.hXv.notifyDataSetChanged();
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
        this.hXu = (HListView) findViewById(R.id.lv_emotion);
        this.hXv = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hXv.a(this);
        this.hXu.setAdapter((ListAdapter) this.hXv);
        this.hXu.setDividerWidth(l.g(getContext(), R.dimen.ds7));
        this.hXu.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.hXC = (RelativeLayout) findViewById(R.id.layout_search);
        this.fcY = (EditText) findViewById(R.id.edit_search);
        this.fcZ = (ImageView) findViewById(R.id.iv_search);
        this.fcY.addTextChangedListener(this.hXG);
        this.fcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.fcY.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int rn = ab.rn(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = rn - ab.d(obj.charAt(i6));
                        i6++;
                        rn = d;
                    }
                } else {
                    rn += ab.rn(charSequence.toString());
                }
                if (rn > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.af(getContext());
        this.fcT = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.g(getContext(), R.dimen.ds150);
        this.hXy = l.g(getContext(), R.dimen.ds58);
        this.hXz = l.g(getContext(), R.dimen.ds114);
        this.gTa = l.g(getContext(), R.dimen.ds10);
        this.hXx = this.mScreenWidth - l.g(getContext(), R.dimen.tbds196);
        this.hXw = (this.hXy - this.hXz) * (1.0d / this.hXx);
        this.hXA = l.g(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hXx && N(motionEvent)) {
                    pf(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return M(motionEvent);
    }

    private boolean M(MotionEvent motionEvent) {
        View childAt;
        if (N(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.hXu.getChildCount() <= 0 || this.hXu.getFirstVisiblePosition() != 0 || (childAt = this.hXu.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.eTy) {
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
            if (this.hXE && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hXE = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hXE = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cQM = motionEvent.getRawY();
                this.eTy = motionEvent.getRawX();
                this.eTy = motionEvent.getRawX();
                break;
            case 2:
                this.eTy = motionEvent.getRawX();
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
                        pf(false);
                    } else {
                        pf(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    pf(false);
                } else {
                    pf(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eTy));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hXx ? this.hXx : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int yi = yi(i);
                    if (yi <= this.hXz && yi >= this.hXy) {
                        yk(i);
                        yj(yi);
                        yl(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean N(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fcT && Math.abs(motionEvent.getRawY() - this.cQM) < this.fcT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yi(int i) {
        return (int) ((this.hXw * i) + this.hXz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj(int i) {
        this.hXu.getLayoutParams().height = (this.gTa * 2) + i;
        this.hXv.yj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yk(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hXx);
        this.hXC.getLayoutParams().height = (int) (this.hXA * f);
        this.hXC.setAlpha(f);
        this.fcZ.setScaleX(f);
        this.fcZ.setScaleY(f);
        this.fcY.setTextSize(0, f * l.g(getContext(), R.dimen.fontsize32));
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
                    PbEmotionBar.this.yk(intValue);
                    PbEmotionBar.this.yj(PbEmotionBar.this.yi(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.yl(layoutParams.leftMargin);
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

    public void pf(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.hXx;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        ci(i, i2);
    }

    public void pg(boolean z) {
        pf(true);
        if (z) {
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.fcY.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.fcY);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hXv != null) {
            this.hXv.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.fcY.getText().toString(), PbEmotionBar.this.mData.bYs(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hXD = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bhj() {
        return this.hXD;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bhm() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bhn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        if (this.hXB != null) {
            this.hXB.onMove((this.hXx - i) * (1.0f / this.hXx));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hXB = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hXv != null) {
            this.hXv.bQF();
        }
        bos();
    }

    public void bos() {
        if (this.hXF != null) {
            this.hXF.bos();
        }
    }

    public void onChangeSkinType() {
        am.j(this.fcY, R.color.cp_cont_b);
        this.fcY.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.l(this, R.color.cp_bg_line_d);
        if (this.hXv != null) {
            this.hXv.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hXx;
    }
}
