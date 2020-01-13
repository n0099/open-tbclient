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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes7.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private SearchEmotionModel.a fYB;
    private EditText fYS;
    private ImageView fYT;
    private int hKA;
    private RelativeLayout hpY;
    private HListView iQJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.a iQK;
    private double iQL;
    private int iQM;
    private int iQN;
    private int iQO;
    private int iQP;
    private b iQQ;
    private RelativeLayout iQR;
    private boolean iQS;
    private boolean iQT;
    private com.baidu.tieba.pb.pb.main.emotion.view.b iQU;
    private TextWatcher iQV;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private float mDownY;
    private int mFlingDistance;
    private float mLastTouchX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes7.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.iQT = false;
        this.iQV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bym())) {
                            PbEmotionBar.this.iQK.setData(PbEmotionBar.this.mData.bym());
                            PbEmotionBar.this.iQK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iQU == null) {
                        PbEmotionBar.this.iQU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iQU.a(PbEmotionBar.this.fYB);
                    }
                    PbEmotionBar.this.iQU.FZ(trim);
                }
            }
        };
        this.fYB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bym()) && PbEmotionBar.this.fYS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iQK.setData(aVar.bym());
                    PbEmotionBar.this.iQK.notifyDataSetChanged();
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
        this.iQT = false;
        this.iQV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bym())) {
                            PbEmotionBar.this.iQK.setData(PbEmotionBar.this.mData.bym());
                            PbEmotionBar.this.iQK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iQU == null) {
                        PbEmotionBar.this.iQU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iQU.a(PbEmotionBar.this.fYB);
                    }
                    PbEmotionBar.this.iQU.FZ(trim);
                }
            }
        };
        this.fYB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bym()) && PbEmotionBar.this.fYS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iQK.setData(aVar.bym());
                    PbEmotionBar.this.iQK.notifyDataSetChanged();
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
        this.iQT = false;
        this.iQV = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bym())) {
                            PbEmotionBar.this.iQK.setData(PbEmotionBar.this.mData.bym());
                            PbEmotionBar.this.iQK.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iQU == null) {
                        PbEmotionBar.this.iQU = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iQU.a(PbEmotionBar.this.fYB);
                    }
                    PbEmotionBar.this.iQU.FZ(trim);
                }
            }
        };
        this.fYB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bym()) && PbEmotionBar.this.fYS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iQK.setData(aVar.bym());
                    PbEmotionBar.this.iQK.notifyDataSetChanged();
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
        this.iQJ = (HListView) findViewById(R.id.lv_emotion);
        this.iQK = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.iQK.a(this);
        this.iQJ.setAdapter((ListAdapter) this.iQK);
        this.iQJ.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.iQJ.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.iQR = (RelativeLayout) findViewById(R.id.layout_search);
        this.fYS = (EditText) findViewById(R.id.edit_search);
        this.fYT = (ImageView) findViewById(R.id.iv_search);
        this.fYS.addTextChangedListener(this.iQV);
        this.fYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.fYS.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = ad.getTextLength(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int charLength = textLength - ad.getCharLength(obj.charAt(i6));
                        i6++;
                        textLength = charLength;
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
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.iQN = l.getDimens(getContext(), R.dimen.ds58);
        this.iQO = l.getDimens(getContext(), R.dimen.ds114);
        this.hKA = l.getDimens(getContext(), R.dimen.ds10);
        this.iQM = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.iQL = (this.iQN - this.iQO) * (1.0d / this.iQM);
        this.iQP = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.iQM && isTouchSlop(motionEvent)) {
                    qw(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return D(motionEvent);
    }

    private boolean D(MotionEvent motionEvent) {
        View childAt;
        if (isTouchSlop(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.iQJ.getChildCount() <= 0 || this.iQJ.getFirstVisiblePosition() != 0 || (childAt = this.iQJ.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.mLastTouchX) {
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
        this.hpY.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.iQT && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.iQT = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.iQT = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchX = motionEvent.getRawX();
                break;
            case 2:
                this.mLastTouchX = motionEvent.getRawX();
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
                        qw(false);
                    } else {
                        qw(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    qw(false);
                } else {
                    qw(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.mLastTouchX));
                if (rawX2 >= 0) {
                    i = rawX2 > this.iQM ? this.iQM : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int zc = zc(i);
                    if (zc <= this.iQO && zc >= this.iQN) {
                        ze(i);
                        zd(zc);
                        zf(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean isTouchSlop(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.mTouchSlop && Math.abs(motionEvent.getRawY() - this.mDownY) < this.mTouchSlop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zc(int i) {
        return (int) ((this.iQL * i) + this.iQO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(int i) {
        this.iQJ.getLayoutParams().height = (this.hKA * 2) + i;
        this.iQK.zd(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ze(int i) {
        float f = 1.0f - ((i * 1.0f) / this.iQM);
        this.iQR.getLayoutParams().height = (int) (this.iQP * f);
        this.iQR.setAlpha(f);
        this.fYT.setScaleX(f);
        this.fYT.setScaleY(f);
        this.fYS.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cr(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.ze(intValue);
                    PbEmotionBar.this.zd(PbEmotionBar.this.zc(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.zf(layoutParams.leftMargin);
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

    public void qw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.iQM;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cr(i, i2);
    }

    public void qx(boolean z) {
        qw(true);
        if (z) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.fYS.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.fYS);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.iQK != null) {
            this.iQK.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.fYS.getText().toString(), PbEmotionBar.this.mData.cpv(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.iQS = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean byo() {
        return this.iQS;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void byr() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bys() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf(int i) {
        if (this.iQQ != null) {
            this.iQQ.onMove((this.iQM - i) * (1.0f / this.iQM));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.iQQ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.iQK != null) {
            this.iQK.cgV();
        }
        bER();
    }

    public void bER() {
        if (this.iQU != null) {
            this.iQU.bER();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fYS, (int) R.color.cp_cont_b);
        this.fYS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.iQK != null) {
            this.iQK.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.iQM;
    }
}
