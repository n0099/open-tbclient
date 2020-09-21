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
/* loaded from: classes21.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bVQ;
    private float bnG;
    private SearchEmotionModel.a hMf;
    private float hMt;
    private EditText hMy;
    private ImageView hMz;
    private int jKJ;
    private RelativeLayout jnW;
    private HListView kXP;
    private com.baidu.tieba.pb.pb.main.emotion.view.a kXQ;
    private double kXR;
    private int kXS;
    private int kXT;
    private int kXU;
    private int kXV;
    private b kXW;
    private RelativeLayout kXX;
    private boolean kXY;
    private boolean kXZ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b kYa;
    private TextWatcher kYb;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes21.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void c(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.kXZ = false;
        this.kYb = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.ckU())) {
                            PbEmotionBar.this.kXQ.setData(PbEmotionBar.this.mData.ckU());
                            PbEmotionBar.this.kXQ.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kYa == null) {
                        PbEmotionBar.this.kYa = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kYa.a(PbEmotionBar.this.hMf);
                    }
                    PbEmotionBar.this.kYa.Ov(trim);
                }
            }
        };
        this.hMf = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.ckU()) && PbEmotionBar.this.hMy.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kXQ.setData(aVar.ckU());
                    PbEmotionBar.this.kXQ.notifyDataSetChanged();
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
        this.kXZ = false;
        this.kYb = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.ckU())) {
                            PbEmotionBar.this.kXQ.setData(PbEmotionBar.this.mData.ckU());
                            PbEmotionBar.this.kXQ.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kYa == null) {
                        PbEmotionBar.this.kYa = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kYa.a(PbEmotionBar.this.hMf);
                    }
                    PbEmotionBar.this.kYa.Ov(trim);
                }
            }
        };
        this.hMf = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.ckU()) && PbEmotionBar.this.hMy.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kXQ.setData(aVar.ckU());
                    PbEmotionBar.this.kXQ.notifyDataSetChanged();
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
        this.kXZ = false;
        this.kYb = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.ckU())) {
                            PbEmotionBar.this.kXQ.setData(PbEmotionBar.this.mData.ckU());
                            PbEmotionBar.this.kXQ.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kYa == null) {
                        PbEmotionBar.this.kYa = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kYa.a(PbEmotionBar.this.hMf);
                    }
                    PbEmotionBar.this.kYa.Ov(trim);
                }
            }
        };
        this.hMf = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.ckU()) && PbEmotionBar.this.hMy.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kXQ.setData(aVar.ckU());
                    PbEmotionBar.this.kXQ.notifyDataSetChanged();
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
        this.kXP = (HListView) findViewById(R.id.lv_emotion);
        this.kXQ = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.kXQ.a(this);
        this.kXP.setAdapter((ListAdapter) this.kXQ);
        this.kXP.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.kXP.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kXX = (RelativeLayout) findViewById(R.id.layout_search);
        this.hMy = (EditText) findViewById(R.id.edit_search);
        this.hMz = (ImageView) findViewById(R.id.iv_search);
        this.hMy.addTextChangedListener(this.kYb);
        this.hMy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.hMy.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.hMt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.kXT = l.getDimens(getContext(), R.dimen.ds58);
        this.kXU = l.getDimens(getContext(), R.dimen.ds114);
        this.jKJ = l.getDimens(getContext(), R.dimen.ds10);
        this.kXS = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.kXR = (this.kXT - this.kXU) * (1.0d / this.kXS);
        this.kXV = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.kXS && aa(motionEvent)) {
                    tU(true);
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
        if (this.kXP.getChildCount() <= 0 || this.kXP.getFirstVisiblePosition() != 0 || (childAt = this.kXP.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bnG) {
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
        this.jnW.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.kXZ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.kXZ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.kXZ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.bVQ = motionEvent.getRawY();
                this.bnG = motionEvent.getRawX();
                this.bnG = motionEvent.getRawX();
                break;
            case 2:
                this.bnG = motionEvent.getRawX();
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
                        tU(false);
                    } else {
                        tU(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    tU(false);
                } else {
                    tU(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bnG));
                if (rawX2 >= 0) {
                    i = rawX2 > this.kXS ? this.kXS : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Fa = Fa(i);
                    if (Fa <= this.kXU && Fa >= this.kXT) {
                        Fc(i);
                        Fb(Fa);
                        Fd(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hMt && Math.abs(motionEvent.getRawY() - this.bVQ) < this.hMt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Fa(int i) {
        return (int) ((this.kXR * i) + this.kXU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fb(int i) {
        this.kXP.getLayoutParams().height = (this.jKJ * 2) + i;
        this.kXQ.Fb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fc(int i) {
        float f = 1.0f - ((i * 1.0f) / this.kXS);
        this.kXX.getLayoutParams().height = (int) (this.kXV * f);
        this.kXX.setAlpha(f);
        this.hMz.setScaleX(f);
        this.hMz.setScaleY(f);
        this.hMy.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cY(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.Fc(intValue);
                    PbEmotionBar.this.Fb(PbEmotionBar.this.Fa(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Fd(layoutParams.leftMargin);
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

    public void tU(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.kXS;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cY(i, i2);
    }

    public void tV(boolean z) {
        tU(true);
        if (z) {
            e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.hMy.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.hMy);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.kXQ != null) {
            this.kXQ.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.hMy.getText().toString(), PbEmotionBar.this.mData.dfD(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.kXY = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ckW() {
        return this.kXY;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ckZ() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cla() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd(int i) {
        if (this.kXW != null) {
            this.kXW.onMove((this.kXS - i) * (1.0f / this.kXS));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.kXW = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.kXQ != null) {
            this.kXQ.cWQ();
        }
        csi();
    }

    public void csi() {
        if (this.kYa != null) {
            this.kYa.csi();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hMy, R.color.cp_cont_b);
        this.hMy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.kXQ != null) {
            this.kXQ.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.kXS;
    }
}
