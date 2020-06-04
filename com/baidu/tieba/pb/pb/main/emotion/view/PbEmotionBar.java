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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float aZz;
    private SearchEmotionModel.a gZK;
    private float gZY;
    private EditText had;
    private ImageView hae;
    private int iND;
    private RelativeLayout ita;
    private HListView jWL;
    private com.baidu.tieba.pb.pb.main.emotion.view.a jWM;
    private double jWN;
    private int jWO;
    private int jWP;
    private int jWQ;
    private int jWR;
    private b jWS;
    private RelativeLayout jWT;
    private boolean jWU;
    private boolean jWV;
    private com.baidu.tieba.pb.pb.main.emotion.view.b jWW;
    private TextWatcher jWX;
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
        this.jWV = false;
        this.jWX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bQU())) {
                            PbEmotionBar.this.jWM.setData(PbEmotionBar.this.mData.bQU());
                            PbEmotionBar.this.jWM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jWW == null) {
                        PbEmotionBar.this.jWW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jWW.a(PbEmotionBar.this.gZK);
                    }
                    PbEmotionBar.this.jWW.JL(trim);
                }
            }
        };
        this.gZK = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bQU()) && PbEmotionBar.this.had.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jWM.setData(aVar.bQU());
                    PbEmotionBar.this.jWM.notifyDataSetChanged();
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
        this.jWV = false;
        this.jWX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bQU())) {
                            PbEmotionBar.this.jWM.setData(PbEmotionBar.this.mData.bQU());
                            PbEmotionBar.this.jWM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jWW == null) {
                        PbEmotionBar.this.jWW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jWW.a(PbEmotionBar.this.gZK);
                    }
                    PbEmotionBar.this.jWW.JL(trim);
                }
            }
        };
        this.gZK = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bQU()) && PbEmotionBar.this.had.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jWM.setData(aVar.bQU());
                    PbEmotionBar.this.jWM.notifyDataSetChanged();
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
        this.jWV = false;
        this.jWX = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bQU())) {
                            PbEmotionBar.this.jWM.setData(PbEmotionBar.this.mData.bQU());
                            PbEmotionBar.this.jWM.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jWW == null) {
                        PbEmotionBar.this.jWW = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jWW.a(PbEmotionBar.this.gZK);
                    }
                    PbEmotionBar.this.jWW.JL(trim);
                }
            }
        };
        this.gZK = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bQU()) && PbEmotionBar.this.had.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jWM.setData(aVar.bQU());
                    PbEmotionBar.this.jWM.notifyDataSetChanged();
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
        this.jWL = (HListView) findViewById(R.id.lv_emotion);
        this.jWM = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.jWM.a(this);
        this.jWL.setAdapter((ListAdapter) this.jWM);
        this.jWL.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.jWL.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jWT = (RelativeLayout) findViewById(R.id.layout_search);
        this.had = (EditText) findViewById(R.id.edit_search);
        this.hae = (ImageView) findViewById(R.id.iv_search);
        this.had.addTextChangedListener(this.jWX);
        this.had.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.had.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.gZY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.jWP = l.getDimens(getContext(), R.dimen.ds58);
        this.jWQ = l.getDimens(getContext(), R.dimen.ds114);
        this.iND = l.getDimens(getContext(), R.dimen.ds10);
        this.jWO = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.jWN = (this.jWP - this.jWQ) * (1.0d / this.jWO);
        this.jWR = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.jWO && I(motionEvent)) {
                    si(true);
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
        if (this.jWL.getChildCount() <= 0 || this.jWL.getFirstVisiblePosition() != 0 || (childAt = this.jWL.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.aZz) {
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
        this.ita.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.jWV && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.jWV = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.jWV = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.aZz = motionEvent.getRawX();
                this.aZz = motionEvent.getRawX();
                break;
            case 2:
                this.aZz = motionEvent.getRawX();
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
                        si(false);
                    } else {
                        si(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    si(false);
                } else {
                    si(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.aZz));
                if (rawX2 >= 0) {
                    i = rawX2 > this.jWO ? this.jWO : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int AE = AE(i);
                    if (AE <= this.jWQ && AE >= this.jWP) {
                        AG(i);
                        AF(AE);
                        AH(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gZY && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gZY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AE(int i) {
        return (int) ((this.jWN * i) + this.jWQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF(int i) {
        this.jWL.getLayoutParams().height = (this.iND * 2) + i;
        this.jWM.AF(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG(int i) {
        float f = 1.0f - ((i * 1.0f) / this.jWO);
        this.jWT.getLayoutParams().height = (int) (this.jWR * f);
        this.jWT.setAlpha(f);
        this.hae.setScaleX(f);
        this.hae.setScaleY(f);
        this.had.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cE(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.AG(intValue);
                    PbEmotionBar.this.AF(PbEmotionBar.this.AE(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.AH(layoutParams.leftMargin);
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

    public void si(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.jWO;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cE(i, i2);
    }

    public void sj(boolean z) {
        si(true);
        if (z) {
            e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.had.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.had);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.jWM != null) {
            this.jWM.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.had.getText().toString(), PbEmotionBar.this.mData.cJd(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.jWU = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bQW() {
        return this.jWU;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bQZ() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bRa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(int i) {
        if (this.jWS != null) {
            this.jWS.onMove((this.jWO - i) * (1.0f / this.jWO));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.jWS = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.jWM != null) {
            this.jWM.cAv();
        }
        bXG();
    }

    public void bXG() {
        if (this.jWW != null) {
            this.jWW.bXG();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.had, (int) R.color.cp_cont_b);
        this.had.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.jWM != null) {
            this.jWM.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.jWO;
    }
}
