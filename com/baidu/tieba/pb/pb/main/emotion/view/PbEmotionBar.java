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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float beG;
    private SearchEmotionModel.a hlW;
    private float hmk;
    private EditText hmp;
    private ImageView hmq;
    private RelativeLayout iKg;
    private int jeF;
    private HListView kqB;
    private com.baidu.tieba.pb.pb.main.emotion.view.a kqC;
    private double kqD;
    private int kqE;
    private int kqF;
    private int kqG;
    private int kqH;
    private b kqI;
    private RelativeLayout kqJ;
    private boolean kqK;
    private boolean kqL;
    private com.baidu.tieba.pb.pb.main.emotion.view.b kqM;
    private TextWatcher kqN;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private float mDownY;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes9.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.kqL = false;
        this.kqN = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.isEmpty(PbEmotionBar.this.mData.bTR())) {
                            PbEmotionBar.this.kqC.setData(PbEmotionBar.this.mData.bTR());
                            PbEmotionBar.this.kqC.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kqM == null) {
                        PbEmotionBar.this.kqM = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kqM.a(PbEmotionBar.this.hlW);
                    }
                    PbEmotionBar.this.kqM.Kn(trim);
                }
            }
        };
        this.hlW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.isEmpty(aVar.bTR()) && PbEmotionBar.this.hmp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kqC.setData(aVar.bTR());
                    PbEmotionBar.this.kqC.notifyDataSetChanged();
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
        this.kqL = false;
        this.kqN = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.isEmpty(PbEmotionBar.this.mData.bTR())) {
                            PbEmotionBar.this.kqC.setData(PbEmotionBar.this.mData.bTR());
                            PbEmotionBar.this.kqC.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kqM == null) {
                        PbEmotionBar.this.kqM = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kqM.a(PbEmotionBar.this.hlW);
                    }
                    PbEmotionBar.this.kqM.Kn(trim);
                }
            }
        };
        this.hlW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.isEmpty(aVar.bTR()) && PbEmotionBar.this.hmp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kqC.setData(aVar.bTR());
                    PbEmotionBar.this.kqC.notifyDataSetChanged();
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
        this.kqL = false;
        this.kqN = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !w.isEmpty(PbEmotionBar.this.mData.bTR())) {
                            PbEmotionBar.this.kqC.setData(PbEmotionBar.this.mData.bTR());
                            PbEmotionBar.this.kqC.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kqM == null) {
                        PbEmotionBar.this.kqM = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kqM.a(PbEmotionBar.this.hlW);
                    }
                    PbEmotionBar.this.kqM.Kn(trim);
                }
            }
        };
        this.hlW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !w.isEmpty(aVar.bTR()) && PbEmotionBar.this.hmp.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kqC.setData(aVar.bTR());
                    PbEmotionBar.this.kqC.notifyDataSetChanged();
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
        this.kqB = (HListView) findViewById(R.id.lv_emotion);
        this.kqC = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.kqC.a(this);
        this.kqB.setAdapter((ListAdapter) this.kqC);
        this.kqB.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.kqB.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kqJ = (RelativeLayout) findViewById(R.id.layout_search);
        this.hmp = (EditText) findViewById(R.id.edit_search);
        this.hmq = (ImageView) findViewById(R.id.iv_search);
        this.hmp.addTextChangedListener(this.kqN);
        this.hmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.hmp.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.kqF = l.getDimens(getContext(), R.dimen.ds58);
        this.kqG = l.getDimens(getContext(), R.dimen.ds114);
        this.jeF = l.getDimens(getContext(), R.dimen.ds10);
        this.kqE = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.kqD = (this.kqF - this.kqG) * (1.0d / this.kqE);
        this.kqH = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.kqE && I(motionEvent)) {
                    sw(true);
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
        if (this.kqB.getChildCount() <= 0 || this.kqB.getFirstVisiblePosition() != 0 || (childAt = this.kqB.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.beG) {
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
        this.iKg.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.kqL && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.kqL = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.kqL = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.beG = motionEvent.getRawX();
                this.beG = motionEvent.getRawX();
                break;
            case 2:
                this.beG = motionEvent.getRawX();
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
                        sw(false);
                    } else {
                        sw(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    sw(false);
                } else {
                    sw(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.beG));
                if (rawX2 >= 0) {
                    i = rawX2 > this.kqE ? this.kqE : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int BG = BG(i);
                    if (BG <= this.kqG && BG >= this.kqF) {
                        BI(i);
                        BH(BG);
                        BJ(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hmk && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BG(int i) {
        return (int) ((this.kqD * i) + this.kqG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH(int i) {
        this.kqB.getLayoutParams().height = (this.jeF * 2) + i;
        this.kqC.BH(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BI(int i) {
        float f = 1.0f - ((i * 1.0f) / this.kqE);
        this.kqJ.getLayoutParams().height = (int) (this.kqH * f);
        this.kqJ.setAlpha(f);
        this.hmq.setScaleX(f);
        this.hmq.setScaleY(f);
        this.hmp.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cK(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.BI(intValue);
                    PbEmotionBar.this.BH(PbEmotionBar.this.BG(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.BJ(layoutParams.leftMargin);
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

    public void sw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.kqE;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cK(i, i2);
    }

    public void sx(boolean z) {
        sw(true);
        if (z) {
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.hmp.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.hmp);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.kqC != null) {
            this.kqC.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.hmp.getText().toString(), PbEmotionBar.this.mData.cNv(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.kqK = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bTT() {
        return this.kqK;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bTW() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bTX() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ(int i) {
        if (this.kqI != null) {
            this.kqI.onMove((this.kqE - i) * (1.0f / this.kqE));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.kqI = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.kqC != null) {
            this.kqC.cEM();
        }
        caS();
    }

    public void caS() {
        if (this.kqM != null) {
            this.kqM.caS();
        }
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.hmp, (int) R.color.cp_cont_b);
        this.hmp.setHintTextColor(an.getColor(R.color.cp_cont_e));
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.kqC != null) {
            this.kqC.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.kqE;
    }
}
