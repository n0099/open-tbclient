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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bDi;
    private float cBP;
    private SearchEmotionModel.a iMM;
    private float iNa;
    private EditText iNf;
    private ImageView iNg;
    private int kGN;
    private int lUA;
    private int lUB;
    private b lUC;
    private RelativeLayout lUD;
    private boolean lUE;
    private boolean lUF;
    private com.baidu.tieba.pb.pb.main.emotion.view.b lUG;
    private TextWatcher lUH;
    private HListView lUv;
    private com.baidu.tieba.pb.pb.main.emotion.view.a lUw;
    private double lUx;
    private int lUy;
    private int lUz;
    private RelativeLayout loZ;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

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
        this.lUF = false;
        this.lUH = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.cwV())) {
                            PbEmotionBar.this.lUw.setData(PbEmotionBar.this.mData.cwV());
                            PbEmotionBar.this.lUw.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lUG == null) {
                        PbEmotionBar.this.lUG = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lUG.a(PbEmotionBar.this.iMM);
                    }
                    PbEmotionBar.this.lUG.Pa(trim);
                }
            }
        };
        this.iMM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.cwV()) && PbEmotionBar.this.iNf.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lUw.setData(aVar.cwV());
                    PbEmotionBar.this.lUw.notifyDataSetChanged();
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
        this.lUF = false;
        this.lUH = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.cwV())) {
                            PbEmotionBar.this.lUw.setData(PbEmotionBar.this.mData.cwV());
                            PbEmotionBar.this.lUw.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lUG == null) {
                        PbEmotionBar.this.lUG = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lUG.a(PbEmotionBar.this.iMM);
                    }
                    PbEmotionBar.this.lUG.Pa(trim);
                }
            }
        };
        this.iMM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.cwV()) && PbEmotionBar.this.iNf.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lUw.setData(aVar.cwV());
                    PbEmotionBar.this.lUw.notifyDataSetChanged();
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
        this.lUF = false;
        this.lUH = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !x.isEmpty(PbEmotionBar.this.mData.cwV())) {
                            PbEmotionBar.this.lUw.setData(PbEmotionBar.this.mData.cwV());
                            PbEmotionBar.this.lUw.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lUG == null) {
                        PbEmotionBar.this.lUG = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lUG.a(PbEmotionBar.this.iMM);
                    }
                    PbEmotionBar.this.lUG.Pa(trim);
                }
            }
        };
        this.iMM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !x.isEmpty(aVar.cwV()) && PbEmotionBar.this.iNf.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lUw.setData(aVar.cwV());
                    PbEmotionBar.this.lUw.notifyDataSetChanged();
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
        this.lUv = (HListView) findViewById(R.id.lv_emotion);
        this.lUw = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.lUw.a(this);
        this.lUv.setAdapter((ListAdapter) this.lUw);
        this.lUv.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.lUv.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lUD = (RelativeLayout) findViewById(R.id.layout_search);
        this.iNf = (EditText) findViewById(R.id.edit_search);
        this.iNg = (ImageView) findViewById(R.id.iv_search);
        this.iNf.addTextChangedListener(this.lUH);
        this.iNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.iNf.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = ad.getTextLength(obj);
                if (i5 > 0) {
                    for (int i6 = i3; i6 < i5 + i3 && obj.length() < i6; i6++) {
                        textLength -= ad.getCharLength(obj.charAt(i6));
                    }
                } else {
                    textLength += ad.getTextLength(charSequence.toString());
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
        this.iNa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.lUz = l.getDimens(getContext(), R.dimen.ds58);
        this.lUA = l.getDimens(getContext(), R.dimen.ds114);
        this.kGN = l.getDimens(getContext(), R.dimen.ds10);
        this.lUy = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.lUx = (this.lUz - this.lUA) * (1.0d / this.lUy);
        this.lUB = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.lUy && ab(motionEvent)) {
                    vE(true);
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
        if (this.lUv.getChildCount() <= 0 || this.lUv.getFirstVisiblePosition() != 0 || (childAt = this.lUv.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bDi) {
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
        this.loZ.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.lUF && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.lUF = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.lUF = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cBP = motionEvent.getRawY();
                this.bDi = motionEvent.getRawX();
                this.bDi = motionEvent.getRawX();
                break;
            case 2:
                this.bDi = motionEvent.getRawX();
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
                        vE(false);
                    } else {
                        vE(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    vE(false);
                } else {
                    vE(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bDi));
                if (rawX2 >= 0) {
                    i = rawX2 > this.lUy ? this.lUy : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int FN = FN(i);
                    if (FN <= this.lUA && FN >= this.lUz) {
                        FP(i);
                        FO(FN);
                        FQ(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iNa && Math.abs(motionEvent.getRawY() - this.cBP) < this.iNa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FN(int i) {
        return (int) ((this.lUx * i) + this.lUA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(int i) {
        this.lUv.getLayoutParams().height = (this.kGN * 2) + i;
        this.lUw.FO(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(int i) {
        float f = 1.0f - ((i * 1.0f) / this.lUy);
        this.lUD.getLayoutParams().height = (int) (this.lUB * f);
        this.lUD.setAlpha(f);
        this.iNg.setScaleX(f);
        this.iNg.setScaleY(f);
        this.iNf.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void dd(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.FP(intValue);
                    PbEmotionBar.this.FO(PbEmotionBar.this.FN(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.FQ(layoutParams.leftMargin);
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

    public void vE(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.lUy;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        dd(i, i2);
    }

    public void vF(boolean z) {
        vE(true);
        if (z) {
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.iNf.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.iNf);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.lUw != null) {
            this.lUw.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.iNf.getText().toString(), PbEmotionBar.this.mData.dpL(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.lUE = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cwX() {
        return this.lUE;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxa() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(int i) {
        if (this.lUC != null) {
            this.lUC.onMove((this.lUy - i) * (1.0f / this.lUy));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.lUC = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.lUw != null) {
            this.lUw.dgM();
        }
        cEk();
    }

    public void cEk() {
        if (this.lUG != null) {
            this.lUG.cEk();
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iNf, R.color.CAM_X0105);
        this.iNf.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.lUw != null) {
            this.lUw.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.lUy;
    }
}
