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
    private SearchEmotionModel.a gaD;
    private EditText gaU;
    private ImageView gaV;
    private int hMA;
    private RelativeLayout hrZ;
    private HListView iSg;
    private com.baidu.tieba.pb.pb.main.emotion.view.a iSh;
    private double iSi;
    private int iSj;
    private int iSk;
    private int iSl;
    private int iSm;
    private b iSn;
    private RelativeLayout iSo;
    private boolean iSp;
    private boolean iSq;
    private com.baidu.tieba.pb.pb.main.emotion.view.b iSr;
    private TextWatcher iSs;
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
        this.iSq = false;
        this.iSs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzQ())) {
                            PbEmotionBar.this.iSh.setData(PbEmotionBar.this.mData.bzQ());
                            PbEmotionBar.this.iSh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSr == null) {
                        PbEmotionBar.this.iSr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSr.a(PbEmotionBar.this.gaD);
                    }
                    PbEmotionBar.this.iSr.Go(trim);
                }
            }
        };
        this.gaD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzQ()) && PbEmotionBar.this.gaU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSh.setData(aVar.bzQ());
                    PbEmotionBar.this.iSh.notifyDataSetChanged();
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
        this.iSq = false;
        this.iSs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzQ())) {
                            PbEmotionBar.this.iSh.setData(PbEmotionBar.this.mData.bzQ());
                            PbEmotionBar.this.iSh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSr == null) {
                        PbEmotionBar.this.iSr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSr.a(PbEmotionBar.this.gaD);
                    }
                    PbEmotionBar.this.iSr.Go(trim);
                }
            }
        };
        this.gaD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzQ()) && PbEmotionBar.this.gaU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSh.setData(aVar.bzQ());
                    PbEmotionBar.this.iSh.notifyDataSetChanged();
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
        this.iSq = false;
        this.iSs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bzQ())) {
                            PbEmotionBar.this.iSh.setData(PbEmotionBar.this.mData.bzQ());
                            PbEmotionBar.this.iSh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.iSr == null) {
                        PbEmotionBar.this.iSr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.iSr.a(PbEmotionBar.this.gaD);
                    }
                    PbEmotionBar.this.iSr.Go(trim);
                }
            }
        };
        this.gaD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bzQ()) && PbEmotionBar.this.gaU.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.iSh.setData(aVar.bzQ());
                    PbEmotionBar.this.iSh.notifyDataSetChanged();
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
        this.iSg = (HListView) findViewById(R.id.lv_emotion);
        this.iSh = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.iSh.a(this);
        this.iSg.setAdapter((ListAdapter) this.iSh);
        this.iSg.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.iSg.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.iSo = (RelativeLayout) findViewById(R.id.layout_search);
        this.gaU = (EditText) findViewById(R.id.edit_search);
        this.gaV = (ImageView) findViewById(R.id.iv_search);
        this.gaU.addTextChangedListener(this.iSs);
        this.gaU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.gaU.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.iSk = l.getDimens(getContext(), R.dimen.ds58);
        this.iSl = l.getDimens(getContext(), R.dimen.ds114);
        this.hMA = l.getDimens(getContext(), R.dimen.ds10);
        this.iSj = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.iSi = (this.iSk - this.iSl) * (1.0d / this.iSj);
        this.iSm = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.iSj && isTouchSlop(motionEvent)) {
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
        if (this.iSg.getChildCount() <= 0 || this.iSg.getFirstVisiblePosition() != 0 || (childAt = this.iSg.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.mLastTouchX) {
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
        this.hrZ.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.iSq && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.iSq = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.iSq = true;
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
                    i = rawX2 > this.iSj ? this.iSj : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int zi = zi(i);
                    if (zi <= this.iSl && zi >= this.iSk) {
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
        return (int) ((this.iSi * i) + this.iSl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        this.iSg.getLayoutParams().height = (this.hMA * 2) + i;
        this.iSh.zj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        float f = 1.0f - ((i * 1.0f) / this.iSj);
        this.iSo.getLayoutParams().height = (int) (this.iSm * f);
        this.iSo.setAlpha(f);
        this.gaV.setScaleX(f);
        this.gaV.setScaleY(f);
        this.gaU.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
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
        int i2 = this.iSj;
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
                    PbEmotionBar.this.gaU.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.gaU);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.iSh != null) {
            this.iSh.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.gaU.getText().toString(), PbEmotionBar.this.mData.cqQ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.iSp = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bzS() {
        return this.iSp;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzV() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzW() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(int i) {
        if (this.iSn != null) {
            this.iSn.onMove((this.iSj - i) * (1.0f / this.iSj));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.iSn = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.iSh != null) {
            this.iSh.ciC();
        }
        bGv();
    }

    public void bGv() {
        if (this.iSr != null) {
            this.iSr.bGv();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gaU, (int) R.color.cp_cont_b);
        this.gaU.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.iSh != null) {
            this.iSh.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.iSj;
    }
}
