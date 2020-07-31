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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes16.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float beZ;
    private SearchEmotionModel.a hrI;
    private float hrW;
    private EditText hsb;
    private ImageView hsc;
    private RelativeLayout iQl;
    private int jnb;
    private com.baidu.tieba.pb.pb.main.emotion.view.a kzA;
    private double kzB;
    private int kzC;
    private int kzD;
    private int kzE;
    private int kzF;
    private b kzG;
    private RelativeLayout kzH;
    private boolean kzI;
    private boolean kzJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b kzK;
    private TextWatcher kzL;
    private HListView kzz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private float mDownY;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes16.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.kzJ = false;
        this.kzL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.bXk())) {
                            PbEmotionBar.this.kzA.setData(PbEmotionBar.this.mData.bXk());
                            PbEmotionBar.this.kzA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kzK == null) {
                        PbEmotionBar.this.kzK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kzK.a(PbEmotionBar.this.hrI);
                    }
                    PbEmotionBar.this.kzK.La(trim);
                }
            }
        };
        this.hrI = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.bXk()) && PbEmotionBar.this.hsb.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kzA.setData(aVar.bXk());
                    PbEmotionBar.this.kzA.notifyDataSetChanged();
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
        this.kzJ = false;
        this.kzL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.bXk())) {
                            PbEmotionBar.this.kzA.setData(PbEmotionBar.this.mData.bXk());
                            PbEmotionBar.this.kzA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kzK == null) {
                        PbEmotionBar.this.kzK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kzK.a(PbEmotionBar.this.hrI);
                    }
                    PbEmotionBar.this.kzK.La(trim);
                }
            }
        };
        this.hrI = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.bXk()) && PbEmotionBar.this.hsb.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kzA.setData(aVar.bXk());
                    PbEmotionBar.this.kzA.notifyDataSetChanged();
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
        this.kzJ = false;
        this.kzL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.bXk())) {
                            PbEmotionBar.this.kzA.setData(PbEmotionBar.this.mData.bXk());
                            PbEmotionBar.this.kzA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kzK == null) {
                        PbEmotionBar.this.kzK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kzK.a(PbEmotionBar.this.hrI);
                    }
                    PbEmotionBar.this.kzK.La(trim);
                }
            }
        };
        this.hrI = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.bXk()) && PbEmotionBar.this.hsb.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kzA.setData(aVar.bXk());
                    PbEmotionBar.this.kzA.notifyDataSetChanged();
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
        this.kzz = (HListView) findViewById(R.id.lv_emotion);
        this.kzA = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.kzA.a(this);
        this.kzz.setAdapter((ListAdapter) this.kzA);
        this.kzz.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.kzz.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kzH = (RelativeLayout) findViewById(R.id.layout_search);
        this.hsb = (EditText) findViewById(R.id.edit_search);
        this.hsc = (ImageView) findViewById(R.id.iv_search);
        this.hsb.addTextChangedListener(this.kzL);
        this.hsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.hsb.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = ae.getTextLength(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int charLength = textLength - ae.getCharLength(obj.charAt(i6));
                        i6++;
                        textLength = charLength;
                    }
                } else {
                    textLength += ae.getTextLength(charSequence.toString());
                }
                if (textLength > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.getEquipmentWidth(getContext());
        this.hrW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.kzD = l.getDimens(getContext(), R.dimen.ds58);
        this.kzE = l.getDimens(getContext(), R.dimen.ds114);
        this.jnb = l.getDimens(getContext(), R.dimen.ds10);
        this.kzC = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.kzB = (this.kzD - this.kzE) * (1.0d / this.kzC);
        this.kzF = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.kzC && I(motionEvent)) {
                    tc(true);
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
        if (this.kzz.getChildCount() <= 0 || this.kzz.getFirstVisiblePosition() != 0 || (childAt = this.kzz.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.beZ) {
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
        this.iQl.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.kzJ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.kzJ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.kzJ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.beZ = motionEvent.getRawX();
                this.beZ = motionEvent.getRawX();
                break;
            case 2:
                this.beZ = motionEvent.getRawX();
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
                        tc(false);
                    } else {
                        tc(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    tc(false);
                } else {
                    tc(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.beZ));
                if (rawX2 >= 0) {
                    i = rawX2 > this.kzC ? this.kzC : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Cf = Cf(i);
                    if (Cf <= this.kzE && Cf >= this.kzD) {
                        Ch(i);
                        Cg(Cf);
                        Ci(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hrW && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hrW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Cf(int i) {
        return (int) ((this.kzB * i) + this.kzE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg(int i) {
        this.kzz.getLayoutParams().height = (this.jnb * 2) + i;
        this.kzA.Cg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(int i) {
        float f = 1.0f - ((i * 1.0f) / this.kzC);
        this.kzH.getLayoutParams().height = (int) (this.kzF * f);
        this.kzH.setAlpha(f);
        this.hsc.setScaleX(f);
        this.hsc.setScaleY(f);
        this.hsb.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cN(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.Ch(intValue);
                    PbEmotionBar.this.Cg(PbEmotionBar.this.Cf(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Ci(layoutParams.leftMargin);
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

    public void tc(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.kzC;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cN(i, i2);
    }

    public void td(boolean z) {
        tc(true);
        if (z) {
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.hsb.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.hsb);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.kzA != null) {
            this.kzA.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.hsb.getText().toString(), PbEmotionBar.this.mData.cRi(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.kzI = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bXm() {
        return this.kzI;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bXp() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bXq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(int i) {
        if (this.kzG != null) {
            this.kzG.onMove((this.kzC - i) * (1.0f / this.kzC));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.kzG = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.kzA != null) {
            this.kzA.cIv();
        }
        ceq();
    }

    public void ceq() {
        if (this.kzK != null) {
            this.kzK.ceq();
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.hsb, R.color.cp_cont_b);
        this.hsb.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.kzA != null) {
            this.kzA.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.kzC;
    }
}
