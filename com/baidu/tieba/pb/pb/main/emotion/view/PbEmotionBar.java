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
/* loaded from: classes9.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private SearchEmotionModel.a gaB;
    private EditText gaS;
    private ImageView gaT;
    private int hMy;
    private RelativeLayout hrX;
    private HListView iSe;
    private com.baidu.tieba.pb.pb.main.emotion.view.a iSf;
    private double iSg;
    private int iSh;
    private int iSi;
    private int iSj;
    private int iSk;
    private b iSl;
    private RelativeLayout iSm;
    private boolean iSn;
    private boolean iSo;
    private com.baidu.tieba.pb.pb.main.emotion.view.b iSp;
    private TextWatcher iSq;
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
        this.iSo = false;
        this.iSq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzO())) {
                            PbEmotionBar.this.iSf.setData(PbEmotionBar.this.mData.bzO());
                            PbEmotionBar.this.iSf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSp == null) {
                        PbEmotionBar.this.iSp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSp.a(PbEmotionBar.this.gaB);
                    }
                    PbEmotionBar.this.iSp.Go(trim);
                }
            }
        };
        this.gaB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzO()) && PbEmotionBar.this.gaS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSf.setData(aVar.bzO());
                    PbEmotionBar.this.iSf.notifyDataSetChanged();
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
        this.iSo = false;
        this.iSq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzO())) {
                            PbEmotionBar.this.iSf.setData(PbEmotionBar.this.mData.bzO());
                            PbEmotionBar.this.iSf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSp == null) {
                        PbEmotionBar.this.iSp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSp.a(PbEmotionBar.this.gaB);
                    }
                    PbEmotionBar.this.iSp.Go(trim);
                }
            }
        };
        this.gaB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzO()) && PbEmotionBar.this.gaS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSf.setData(aVar.bzO());
                    PbEmotionBar.this.iSf.notifyDataSetChanged();
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
        this.iSo = false;
        this.iSq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzO())) {
                            PbEmotionBar.this.iSf.setData(PbEmotionBar.this.mData.bzO());
                            PbEmotionBar.this.iSf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSp == null) {
                        PbEmotionBar.this.iSp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSp.a(PbEmotionBar.this.gaB);
                    }
                    PbEmotionBar.this.iSp.Go(trim);
                }
            }
        };
        this.gaB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzO()) && PbEmotionBar.this.gaS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSf.setData(aVar.bzO());
                    PbEmotionBar.this.iSf.notifyDataSetChanged();
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
        this.iSe = (HListView) findViewById(R.id.lv_emotion);
        this.iSf = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.iSf.a(this);
        this.iSe.setAdapter((ListAdapter) this.iSf);
        this.iSe.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.iSe.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.iSm = (RelativeLayout) findViewById(R.id.layout_search);
        this.gaS = (EditText) findViewById(R.id.edit_search);
        this.gaT = (ImageView) findViewById(R.id.iv_search);
        this.gaS.addTextChangedListener(this.iSq);
        this.gaS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.gaS.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.iSi = l.getDimens(getContext(), R.dimen.ds58);
        this.iSj = l.getDimens(getContext(), R.dimen.ds114);
        this.hMy = l.getDimens(getContext(), R.dimen.ds10);
        this.iSh = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.iSg = (this.iSi - this.iSj) * (1.0d / this.iSh);
        this.iSk = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.iSh && isTouchSlop(motionEvent)) {
                    qz(true);
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
        if (this.iSe.getChildCount() <= 0 || this.iSe.getFirstVisiblePosition() != 0 || (childAt = this.iSe.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.mLastTouchX) {
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
        this.hrX.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.iSo && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.iSo = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.iSo = true;
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
                        qz(false);
                    } else {
                        qz(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    qz(false);
                } else {
                    qz(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.mLastTouchX));
                if (rawX2 >= 0) {
                    i = rawX2 > this.iSh ? this.iSh : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int zi = zi(i);
                    if (zi <= this.iSj && zi >= this.iSi) {
                        zk(i);
                        zj(zi);
                        zl(layoutParams.leftMargin);
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
    public int zi(int i) {
        return (int) ((this.iSg * i) + this.iSj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        this.iSe.getLayoutParams().height = (this.hMy * 2) + i;
        this.iSf.zj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        float f = 1.0f - ((i * 1.0f) / this.iSh);
        this.iSm.getLayoutParams().height = (int) (this.iSk * f);
        this.iSm.setAlpha(f);
        this.gaT.setScaleX(f);
        this.gaT.setScaleY(f);
        this.gaS.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cs(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.zk(intValue);
                    PbEmotionBar.this.zj(PbEmotionBar.this.zi(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.zl(layoutParams.leftMargin);
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

    public void qz(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.iSh;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cs(i, i2);
    }

    public void qA(boolean z) {
        qz(true);
        if (z) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.gaS.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.gaS);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.iSf != null) {
            this.iSf.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.gaS.getText().toString(), PbEmotionBar.this.mData.cqO(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.iSn = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bzQ() {
        return this.iSn;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzT() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzU() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(int i) {
        if (this.iSl != null) {
            this.iSl.onMove((this.iSh - i) * (1.0f / this.iSh));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.iSl = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.iSf != null) {
            this.iSf.ciA();
        }
        bGt();
    }

    public void bGt() {
        if (this.iSp != null) {
            this.iSp.bGt();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gaS, (int) R.color.cp_cont_b);
        this.gaS.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.iSf != null) {
            this.iSf.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.iSh;
    }
}
