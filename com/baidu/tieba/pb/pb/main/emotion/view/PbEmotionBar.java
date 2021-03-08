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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bIs;
    private float cFL;
    private float iUE;
    private EditText iUJ;
    private ImageView iUK;
    private SearchEmotionModel.a iUq;
    private int kRh;
    private RelativeLayout lzu;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;
    private HListView mfR;
    private com.baidu.tieba.pb.pb.main.emotion.view.a mfS;
    private double mfT;
    private int mfU;
    private int mfV;
    private int mfW;
    private int mfX;
    private b mfY;
    private RelativeLayout mfZ;
    private boolean mga;
    private boolean mgb;
    private com.baidu.tieba.pb.pb.main.emotion.view.b mgc;
    private TextWatcher mgd;

    /* loaded from: classes2.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void c(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.mgb = false;
        this.mgd = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyt())) {
                            PbEmotionBar.this.mfS.setData(PbEmotionBar.this.mData.cyt());
                            PbEmotionBar.this.mfS.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mgc == null) {
                        PbEmotionBar.this.mgc = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mgc.a(PbEmotionBar.this.iUq);
                    }
                    PbEmotionBar.this.mgc.PZ(trim);
                }
            }
        };
        this.iUq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyt()) && PbEmotionBar.this.iUJ.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mfS.setData(aVar.cyt());
                    PbEmotionBar.this.mfS.notifyDataSetChanged();
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
        this.mgb = false;
        this.mgd = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyt())) {
                            PbEmotionBar.this.mfS.setData(PbEmotionBar.this.mData.cyt());
                            PbEmotionBar.this.mfS.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mgc == null) {
                        PbEmotionBar.this.mgc = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mgc.a(PbEmotionBar.this.iUq);
                    }
                    PbEmotionBar.this.mgc.PZ(trim);
                }
            }
        };
        this.iUq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyt()) && PbEmotionBar.this.iUJ.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mfS.setData(aVar.cyt());
                    PbEmotionBar.this.mfS.notifyDataSetChanged();
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
        this.mgb = false;
        this.mgd = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyt())) {
                            PbEmotionBar.this.mfS.setData(PbEmotionBar.this.mData.cyt());
                            PbEmotionBar.this.mfS.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mgc == null) {
                        PbEmotionBar.this.mgc = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mgc.a(PbEmotionBar.this.iUq);
                    }
                    PbEmotionBar.this.mgc.PZ(trim);
                }
            }
        };
        this.iUq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyt()) && PbEmotionBar.this.iUJ.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mfS.setData(aVar.cyt());
                    PbEmotionBar.this.mfS.notifyDataSetChanged();
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
        setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
        this.mfR = (HListView) findViewById(R.id.lv_emotion);
        this.mfS = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.mfS.a(this);
        this.mfR.setAdapter((ListAdapter) this.mfS);
        this.mfR.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.mfR.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mfZ = (RelativeLayout) findViewById(R.id.layout_search);
        this.iUJ = (EditText) findViewById(R.id.edit_search);
        this.iUK = (ImageView) findViewById(R.id.iv_search);
        this.iUJ.addTextChangedListener(this.mgd);
        this.iUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.iUJ.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = ag.getTextLength(obj);
                if (i5 > 0) {
                    for (int i6 = i3; i6 < i5 + i3 && obj.length() < i6; i6++) {
                        textLength -= ag.getCharLength(obj.charAt(i6));
                    }
                } else {
                    textLength += ag.getTextLength(charSequence.toString());
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
        this.iUE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.mfV = l.getDimens(getContext(), R.dimen.ds58);
        this.mfW = l.getDimens(getContext(), R.dimen.ds114);
        this.kRh = l.getDimens(getContext(), R.dimen.ds10);
        this.mfU = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.mfT = (this.mfV - this.mfW) * (1.0d / this.mfU);
        this.mfX = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.mfU && ab(motionEvent)) {
                    vU(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return aa(motionEvent);
    }

    private boolean aa(MotionEvent motionEvent) {
        View childAt;
        if (ab(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.mfR.getChildCount() <= 0 || this.mfR.getFirstVisiblePosition() != 0 || (childAt = this.mfR.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bIs) {
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
        this.lzu.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.mgb && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.mgb = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.mgb = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cFL = motionEvent.getRawY();
                this.bIs = motionEvent.getRawX();
                this.bIs = motionEvent.getRawX();
                break;
            case 2:
                this.bIs = motionEvent.getRawX();
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
                        vU(false);
                    } else {
                        vU(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    vU(false);
                } else {
                    vU(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bIs));
                if (rawX2 >= 0) {
                    i = rawX2 > this.mfU ? this.mfU : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Gj = Gj(i);
                    if (Gj <= this.mfW && Gj >= this.mfV) {
                        Gl(i);
                        Gk(Gj);
                        Gm(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iUE && Math.abs(motionEvent.getRawY() - this.cFL) < this.iUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gj(int i) {
        return (int) ((this.mfT * i) + this.mfW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gk(int i) {
        this.mfR.getLayoutParams().height = (this.kRh * 2) + i;
        this.mfS.Gk(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gl(int i) {
        float f = 1.0f - ((i * 1.0f) / this.mfU);
        this.mfZ.getLayoutParams().height = (int) (this.mfX * f);
        this.mfZ.setAlpha(f);
        this.iUK.setScaleX(f);
        this.iUK.setScaleY(f);
        this.iUJ.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void db(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.Gl(intValue);
                    PbEmotionBar.this.Gk(PbEmotionBar.this.Gj(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Gm(layoutParams.leftMargin);
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

    public void vU(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.mfU;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        db(i, i2);
    }

    public void vV(boolean z) {
        vU(true);
        if (z) {
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.iUJ.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.iUJ);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.mfS != null) {
            this.mfS.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.iUJ.getText().toString(), PbEmotionBar.this.mData.dsp(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.mga = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyv() {
        return this.mga;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyy() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyz() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gm(int i) {
        if (this.mfY != null) {
            this.mfY.onMove((this.mfU - i) * (1.0f / this.mfU));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.mfY = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.mfS != null) {
            this.mfS.djd();
        }
        cFK();
    }

    public void cFK() {
        if (this.mgc != null) {
            this.mgc.cFK();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iUJ, R.color.CAM_X0105);
        this.iUJ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mfS != null) {
            this.mfS.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.mfU;
    }
}
