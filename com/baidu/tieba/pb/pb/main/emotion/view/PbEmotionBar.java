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
    private float aSl;
    private SearchEmotionModel.a gKN;
    private float gLb;
    private EditText gLg;
    private ImageView gLh;
    private RelativeLayout idE;
    private int iyj;
    private HListView jEg;
    private com.baidu.tieba.pb.pb.main.emotion.view.a jEh;
    private double jEi;
    private int jEj;
    private int jEk;
    private int jEl;
    private int jEm;
    private b jEn;
    private RelativeLayout jEo;
    private boolean jEp;
    private boolean jEq;
    private com.baidu.tieba.pb.pb.main.emotion.view.b jEr;
    private TextWatcher jEs;
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
        this.jEq = false;
        this.jEs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKx())) {
                            PbEmotionBar.this.jEh.setData(PbEmotionBar.this.mData.bKx());
                            PbEmotionBar.this.jEh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEr == null) {
                        PbEmotionBar.this.jEr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEr.a(PbEmotionBar.this.gKN);
                    }
                    PbEmotionBar.this.jEr.HZ(trim);
                }
            }
        };
        this.gKN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKx()) && PbEmotionBar.this.gLg.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEh.setData(aVar.bKx());
                    PbEmotionBar.this.jEh.notifyDataSetChanged();
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
        this.jEq = false;
        this.jEs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKx())) {
                            PbEmotionBar.this.jEh.setData(PbEmotionBar.this.mData.bKx());
                            PbEmotionBar.this.jEh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEr == null) {
                        PbEmotionBar.this.jEr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEr.a(PbEmotionBar.this.gKN);
                    }
                    PbEmotionBar.this.jEr.HZ(trim);
                }
            }
        };
        this.gKN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKx()) && PbEmotionBar.this.gLg.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEh.setData(aVar.bKx());
                    PbEmotionBar.this.jEh.notifyDataSetChanged();
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
        this.jEq = false;
        this.jEs = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKx())) {
                            PbEmotionBar.this.jEh.setData(PbEmotionBar.this.mData.bKx());
                            PbEmotionBar.this.jEh.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEr == null) {
                        PbEmotionBar.this.jEr = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEr.a(PbEmotionBar.this.gKN);
                    }
                    PbEmotionBar.this.jEr.HZ(trim);
                }
            }
        };
        this.gKN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKx()) && PbEmotionBar.this.gLg.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEh.setData(aVar.bKx());
                    PbEmotionBar.this.jEh.notifyDataSetChanged();
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
        this.jEg = (HListView) findViewById(R.id.lv_emotion);
        this.jEh = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.jEh.a(this);
        this.jEg.setAdapter((ListAdapter) this.jEh);
        this.jEg.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.jEg.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jEo = (RelativeLayout) findViewById(R.id.layout_search);
        this.gLg = (EditText) findViewById(R.id.edit_search);
        this.gLh = (ImageView) findViewById(R.id.iv_search);
        this.gLg.addTextChangedListener(this.jEs);
        this.gLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.gLg.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.gLb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.jEk = l.getDimens(getContext(), R.dimen.ds58);
        this.jEl = l.getDimens(getContext(), R.dimen.ds114);
        this.iyj = l.getDimens(getContext(), R.dimen.ds10);
        this.jEj = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.jEi = (this.jEk - this.jEl) * (1.0d / this.jEj);
        this.jEm = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.jEj && D(motionEvent)) {
                    rJ(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return C(motionEvent);
    }

    private boolean C(MotionEvent motionEvent) {
        View childAt;
        if (D(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.jEg.getChildCount() <= 0 || this.jEg.getFirstVisiblePosition() != 0 || (childAt = this.jEg.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.aSl) {
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
        this.idE.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.jEq && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.jEq = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.jEq = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.aSl = motionEvent.getRawX();
                this.aSl = motionEvent.getRawX();
                break;
            case 2:
                this.aSl = motionEvent.getRawX();
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
                        rJ(false);
                    } else {
                        rJ(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    rJ(false);
                } else {
                    rJ(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.aSl));
                if (rawX2 >= 0) {
                    i = rawX2 > this.jEj ? this.jEj : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int zR = zR(i);
                    if (zR <= this.jEl && zR >= this.jEk) {
                        zT(i);
                        zS(zR);
                        zU(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean D(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gLb && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gLb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zR(int i) {
        return (int) ((this.jEi * i) + this.jEl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        this.jEg.getLayoutParams().height = (this.iyj * 2) + i;
        this.jEh.zS(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        float f = 1.0f - ((i * 1.0f) / this.jEj);
        this.jEo.getLayoutParams().height = (int) (this.jEm * f);
        this.jEo.setAlpha(f);
        this.gLh.setScaleX(f);
        this.gLh.setScaleY(f);
        this.gLg.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cz(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.zT(intValue);
                    PbEmotionBar.this.zS(PbEmotionBar.this.zR(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.zU(layoutParams.leftMargin);
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

    public void rJ(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.jEj;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cz(i, i2);
    }

    public void rK(boolean z) {
        rJ(true);
        if (z) {
            e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.gLg.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.gLg);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.jEh != null) {
            this.jEh.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.gLg.getText().toString(), PbEmotionBar.this.mData.cBQ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.jEp = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bKz() {
        return this.jEp;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKC() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKD() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(int i) {
        if (this.jEn != null) {
            this.jEn.onMove((this.jEj - i) * (1.0f / this.jEj));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.jEn = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.jEh != null) {
            this.jEh.ctC();
        }
        bRi();
    }

    public void bRi() {
        if (this.jEr != null) {
            this.jEr.bRi();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gLg, (int) R.color.cp_cont_b);
        this.gLg.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.jEh != null) {
            this.jEh.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.jEj;
    }
}
