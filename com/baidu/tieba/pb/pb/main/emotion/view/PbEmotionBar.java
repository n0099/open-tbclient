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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float alf;
    private float dak;
    private SearchEmotionModel.a fgN;
    private float fhc;
    private EditText fhh;
    private ImageView fhi;
    private int gSU;
    private RelativeLayout gyn;
    private HListView hYe;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hYf;
    private double hYg;
    private int hYh;
    private int hYi;
    private int hYj;
    private int hYk;
    private b hYl;
    private RelativeLayout hYm;
    private boolean hYn;
    private boolean hYo;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hYp;
    private TextWatcher hYq;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes4.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void b(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.hYo = false;
        this.hYq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bfP())) {
                            PbEmotionBar.this.hYf.setData(PbEmotionBar.this.mData.bfP());
                            PbEmotionBar.this.hYf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hYp == null) {
                        PbEmotionBar.this.hYp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hYp.a(PbEmotionBar.this.fgN);
                    }
                    PbEmotionBar.this.hYp.Be(trim);
                }
            }
        };
        this.fgN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bfP()) && PbEmotionBar.this.fhh.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hYf.setData(aVar.bfP());
                    PbEmotionBar.this.hYf.notifyDataSetChanged();
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
        this.hYo = false;
        this.hYq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bfP())) {
                            PbEmotionBar.this.hYf.setData(PbEmotionBar.this.mData.bfP());
                            PbEmotionBar.this.hYf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hYp == null) {
                        PbEmotionBar.this.hYp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hYp.a(PbEmotionBar.this.fgN);
                    }
                    PbEmotionBar.this.hYp.Be(trim);
                }
            }
        };
        this.fgN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bfP()) && PbEmotionBar.this.fhh.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hYf.setData(aVar.bfP());
                    PbEmotionBar.this.hYf.notifyDataSetChanged();
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
        this.hYo = false;
        this.hYq = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bfP())) {
                            PbEmotionBar.this.hYf.setData(PbEmotionBar.this.mData.bfP());
                            PbEmotionBar.this.hYf.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hYp == null) {
                        PbEmotionBar.this.hYp = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hYp.a(PbEmotionBar.this.fgN);
                    }
                    PbEmotionBar.this.hYp.Be(trim);
                }
            }
        };
        this.fgN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bfP()) && PbEmotionBar.this.fhh.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hYf.setData(aVar.bfP());
                    PbEmotionBar.this.hYf.notifyDataSetChanged();
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
        this.hYe = (HListView) findViewById(R.id.lv_emotion);
        this.hYf = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hYf.a(this);
        this.hYe.setAdapter((ListAdapter) this.hYf);
        this.hYe.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.hYe.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.hYm = (RelativeLayout) findViewById(R.id.layout_search);
        this.fhh = (EditText) findViewById(R.id.edit_search);
        this.fhi = (ImageView) findViewById(R.id.iv_search);
        this.fhh.addTextChangedListener(this.hYq);
        this.fhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.fhh.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = aa.getTextLength(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int charLength = textLength - aa.getCharLength(obj.charAt(i6));
                        i6++;
                        textLength = charLength;
                    }
                } else {
                    textLength += aa.getTextLength(charSequence.toString());
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
        this.fhc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.hYi = l.getDimens(getContext(), R.dimen.ds58);
        this.hYj = l.getDimens(getContext(), R.dimen.ds114);
        this.gSU = l.getDimens(getContext(), R.dimen.ds10);
        this.hYh = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.hYg = (this.hYi - this.hYj) * (1.0d / this.hYh);
        this.hYk = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hYh && E(motionEvent)) {
                    oS(true);
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
        if (E(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.hYe.getChildCount() <= 0 || this.hYe.getFirstVisiblePosition() != 0 || (childAt = this.hYe.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.alf) {
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
        this.gyn.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.hYo && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hYo = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hYo = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.dak = motionEvent.getRawY();
                this.alf = motionEvent.getRawX();
                this.alf = motionEvent.getRawX();
                break;
            case 2:
                this.alf = motionEvent.getRawX();
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
                        oS(false);
                    } else {
                        oS(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    oS(false);
                } else {
                    oS(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.alf));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hYh ? this.hYh : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int wS = wS(i);
                    if (wS <= this.hYj && wS >= this.hYi) {
                        wU(i);
                        wT(wS);
                        wV(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.fhc && Math.abs(motionEvent.getRawY() - this.dak) < this.fhc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wS(int i) {
        return (int) ((this.hYg * i) + this.hYj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wT(int i) {
        this.hYe.getLayoutParams().height = (this.gSU * 2) + i;
        this.hYf.wT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hYh);
        this.hYm.getLayoutParams().height = (int) (this.hYk * f);
        this.hYm.setAlpha(f);
        this.fhi.setScaleX(f);
        this.fhi.setScaleY(f);
        this.fhh.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void bZ(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.wU(intValue);
                    PbEmotionBar.this.wT(PbEmotionBar.this.wS(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.wV(layoutParams.leftMargin);
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

    public void oS(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.hYh;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        bZ(i, i2);
    }

    public void oT(boolean z) {
        oS(true);
        if (z) {
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.fhh.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.fhh);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hYf != null) {
            this.hYf.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.fhh.getText().toString(), PbEmotionBar.this.mData.bWw(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hYn = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfR() {
        return this.hYn;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfU() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfV() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.hYl != null) {
            this.hYl.onMove((this.hYh - i) * (1.0f / this.hYh));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hYl = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hYf != null) {
            this.hYf.bOD();
        }
        bmt();
    }

    public void bmt() {
        if (this.hYp != null) {
            this.hYp.bmt();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fhh, (int) R.color.cp_cont_b);
        this.fhh.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.hYf != null) {
            this.hYf.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hYh;
    }
}
