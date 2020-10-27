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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes22.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float btz;
    private float cqF;
    private SearchEmotionModel.a inC;
    private float inQ;
    private EditText inV;
    private ImageView inW;
    private RelativeLayout jPs;
    private int kmg;
    private HListView lzG;
    private com.baidu.tieba.pb.pb.main.emotion.view.a lzH;
    private double lzI;
    private int lzJ;
    private int lzK;
    private int lzL;
    private int lzM;
    private b lzN;
    private RelativeLayout lzO;
    private boolean lzP;
    private boolean lzQ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b lzR;
    private TextWatcher lzS;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes22.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void c(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.lzQ = false;
        this.lzS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.crz())) {
                            PbEmotionBar.this.lzH.setData(PbEmotionBar.this.mData.crz());
                            PbEmotionBar.this.lzH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lzR == null) {
                        PbEmotionBar.this.lzR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lzR.a(PbEmotionBar.this.inC);
                    }
                    PbEmotionBar.this.lzR.PI(trim);
                }
            }
        };
        this.inC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.crz()) && PbEmotionBar.this.inV.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lzH.setData(aVar.crz());
                    PbEmotionBar.this.lzH.notifyDataSetChanged();
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
        this.lzQ = false;
        this.lzS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.crz())) {
                            PbEmotionBar.this.lzH.setData(PbEmotionBar.this.mData.crz());
                            PbEmotionBar.this.lzH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lzR == null) {
                        PbEmotionBar.this.lzR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lzR.a(PbEmotionBar.this.inC);
                    }
                    PbEmotionBar.this.lzR.PI(trim);
                }
            }
        };
        this.inC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.crz()) && PbEmotionBar.this.inV.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lzH.setData(aVar.crz());
                    PbEmotionBar.this.lzH.notifyDataSetChanged();
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
        this.lzQ = false;
        this.lzS = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.crz())) {
                            PbEmotionBar.this.lzH.setData(PbEmotionBar.this.mData.crz());
                            PbEmotionBar.this.lzH.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lzR == null) {
                        PbEmotionBar.this.lzR = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lzR.a(PbEmotionBar.this.inC);
                    }
                    PbEmotionBar.this.lzR.PI(trim);
                }
            }
        };
        this.inC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.crz()) && PbEmotionBar.this.inV.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lzH.setData(aVar.crz());
                    PbEmotionBar.this.lzH.notifyDataSetChanged();
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
        this.lzG = (HListView) findViewById(R.id.lv_emotion);
        this.lzH = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.lzH.a(this);
        this.lzG.setAdapter((ListAdapter) this.lzH);
        this.lzG.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.lzG.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lzO = (RelativeLayout) findViewById(R.id.layout_search);
        this.inV = (EditText) findViewById(R.id.edit_search);
        this.inW = (ImageView) findViewById(R.id.iv_search);
        this.inV.addTextChangedListener(this.lzS);
        this.inV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.inV.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = af.getTextLength(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int charLength = textLength - af.getCharLength(obj.charAt(i6));
                        i6++;
                        textLength = charLength;
                    }
                } else {
                    textLength += af.getTextLength(charSequence.toString());
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
        this.inQ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.lzK = l.getDimens(getContext(), R.dimen.ds58);
        this.lzL = l.getDimens(getContext(), R.dimen.ds114);
        this.kmg = l.getDimens(getContext(), R.dimen.ds10);
        this.lzJ = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.lzI = (this.lzK - this.lzL) * (1.0d / this.lzJ);
        this.lzM = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.lzJ && aa(motionEvent)) {
                    uS(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return Z(motionEvent);
    }

    private boolean Z(MotionEvent motionEvent) {
        View childAt;
        if (aa(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.lzG.getChildCount() <= 0 || this.lzG.getFirstVisiblePosition() != 0 || (childAt = this.lzG.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.btz) {
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
        this.jPs.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.lzQ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.lzQ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.lzQ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cqF = motionEvent.getRawY();
                this.btz = motionEvent.getRawX();
                this.btz = motionEvent.getRawX();
                break;
            case 2:
                this.btz = motionEvent.getRawX();
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
                        uS(false);
                    } else {
                        uS(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    uS(false);
                } else {
                    uS(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.btz));
                if (rawX2 >= 0) {
                    i = rawX2 > this.lzJ ? this.lzJ : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int FZ = FZ(i);
                    if (FZ <= this.lzL && FZ >= this.lzK) {
                        Gb(i);
                        Ga(FZ);
                        Gc(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.inQ && Math.abs(motionEvent.getRawY() - this.cqF) < this.inQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FZ(int i) {
        return (int) ((this.lzI * i) + this.lzL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(int i) {
        this.lzG.getLayoutParams().height = (this.kmg * 2) + i;
        this.lzH.Ga(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb(int i) {
        float f = 1.0f - ((i * 1.0f) / this.lzJ);
        this.lzO.getLayoutParams().height = (int) (this.lzM * f);
        this.lzO.setAlpha(f);
        this.inW.setScaleX(f);
        this.inW.setScaleY(f);
        this.inV.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void da(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.Gb(intValue);
                    PbEmotionBar.this.Ga(PbEmotionBar.this.FZ(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Gc(layoutParams.leftMargin);
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

    public void uS(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.lzJ;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        da(i, i2);
    }

    public void uT(boolean z) {
        uS(true);
        if (z) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.inV.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.inV);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.lzH != null) {
            this.lzH.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.inV.getText().toString(), PbEmotionBar.this.mData.dmt(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.lzP = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean crB() {
        return this.lzP;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void crE() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void crF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc(int i) {
        if (this.lzN != null) {
            this.lzN.onMove((this.lzJ - i) * (1.0f / this.lzJ));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.lzN = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.lzH != null) {
            this.lzH.ddH();
        }
        cyM();
    }

    public void cyM() {
        if (this.lzR != null) {
            this.lzR.cyM();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.inV, R.color.cp_cont_b);
        this.inV.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.lzH != null) {
            this.lzH.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.lzJ;
    }
}
