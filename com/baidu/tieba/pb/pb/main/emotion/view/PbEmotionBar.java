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
    private float bzL;
    private float cwD;
    private float itN;
    private EditText itS;
    private ImageView itT;
    private SearchEmotionModel.a itz;
    private RelativeLayout jVp;
    private int ksc;
    private HListView lFC;
    private com.baidu.tieba.pb.pb.main.emotion.view.a lFD;
    private double lFE;
    private int lFF;
    private int lFG;
    private int lFH;
    private int lFI;
    private b lFJ;
    private RelativeLayout lFK;
    private boolean lFL;
    private boolean lFM;
    private com.baidu.tieba.pb.pb.main.emotion.view.b lFN;
    private TextWatcher lFO;
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
        this.lFM = false;
        this.lFO = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cua())) {
                            PbEmotionBar.this.lFD.setData(PbEmotionBar.this.mData.cua());
                            PbEmotionBar.this.lFD.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lFN == null) {
                        PbEmotionBar.this.lFN = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lFN.a(PbEmotionBar.this.itz);
                    }
                    PbEmotionBar.this.lFN.PZ(trim);
                }
            }
        };
        this.itz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cua()) && PbEmotionBar.this.itS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lFD.setData(aVar.cua());
                    PbEmotionBar.this.lFD.notifyDataSetChanged();
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
        this.lFM = false;
        this.lFO = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cua())) {
                            PbEmotionBar.this.lFD.setData(PbEmotionBar.this.mData.cua());
                            PbEmotionBar.this.lFD.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lFN == null) {
                        PbEmotionBar.this.lFN = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lFN.a(PbEmotionBar.this.itz);
                    }
                    PbEmotionBar.this.lFN.PZ(trim);
                }
            }
        };
        this.itz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cua()) && PbEmotionBar.this.itS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lFD.setData(aVar.cua());
                    PbEmotionBar.this.lFD.notifyDataSetChanged();
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
        this.lFM = false;
        this.lFO = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cua())) {
                            PbEmotionBar.this.lFD.setData(PbEmotionBar.this.mData.cua());
                            PbEmotionBar.this.lFD.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lFN == null) {
                        PbEmotionBar.this.lFN = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lFN.a(PbEmotionBar.this.itz);
                    }
                    PbEmotionBar.this.lFN.PZ(trim);
                }
            }
        };
        this.itz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cua()) && PbEmotionBar.this.itS.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lFD.setData(aVar.cua());
                    PbEmotionBar.this.lFD.notifyDataSetChanged();
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
        this.lFC = (HListView) findViewById(R.id.lv_emotion);
        this.lFD = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.lFD.a(this);
        this.lFC.setAdapter((ListAdapter) this.lFD);
        this.lFC.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.lFC.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lFK = (RelativeLayout) findViewById(R.id.layout_search);
        this.itS = (EditText) findViewById(R.id.edit_search);
        this.itT = (ImageView) findViewById(R.id.iv_search);
        this.itS.addTextChangedListener(this.lFO);
        this.itS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.itS.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.itN = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.lFG = l.getDimens(getContext(), R.dimen.ds58);
        this.lFH = l.getDimens(getContext(), R.dimen.ds114);
        this.ksc = l.getDimens(getContext(), R.dimen.ds10);
        this.lFF = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.lFE = (this.lFG - this.lFH) * (1.0d / this.lFF);
        this.lFI = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.lFF && ab(motionEvent)) {
                    vb(true);
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
        if (this.lFC.getChildCount() <= 0 || this.lFC.getFirstVisiblePosition() != 0 || (childAt = this.lFC.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bzL) {
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
        this.jVp.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.lFM && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.lFM = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.lFM = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cwD = motionEvent.getRawY();
                this.bzL = motionEvent.getRawX();
                this.bzL = motionEvent.getRawX();
                break;
            case 2:
                this.bzL = motionEvent.getRawX();
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
                        vb(false);
                    } else {
                        vb(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    vb(false);
                } else {
                    vb(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bzL));
                if (rawX2 >= 0) {
                    i = rawX2 > this.lFF ? this.lFF : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Gm = Gm(i);
                    if (Gm <= this.lFH && Gm >= this.lFG) {
                        Go(i);
                        Gn(Gm);
                        Gp(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.itN && Math.abs(motionEvent.getRawY() - this.cwD) < this.itN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gm(int i) {
        return (int) ((this.lFE * i) + this.lFH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gn(int i) {
        this.lFC.getLayoutParams().height = (this.ksc * 2) + i;
        this.lFD.Gn(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(int i) {
        float f = 1.0f - ((i * 1.0f) / this.lFF);
        this.lFK.getLayoutParams().height = (int) (this.lFI * f);
        this.lFK.setAlpha(f);
        this.itT.setScaleX(f);
        this.itT.setScaleY(f);
        this.itS.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void dc(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.Go(intValue);
                    PbEmotionBar.this.Gn(PbEmotionBar.this.Gm(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Gp(layoutParams.leftMargin);
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

    public void vb(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.lFF;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        dc(i, i2);
    }

    public void vc(boolean z) {
        vb(true);
        if (z) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.itS.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.itS);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.lFD != null) {
            this.lFD.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.itS.getText().toString(), PbEmotionBar.this.mData.doW(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.lFL = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cuc() {
        return this.lFL;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cuf() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cug() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp(int i) {
        if (this.lFJ != null) {
            this.lFJ.onMove((this.lFF - i) * (1.0f / this.lFF));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.lFJ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.lFD != null) {
            this.lFD.dgj();
        }
        cBn();
    }

    public void cBn() {
        if (this.lFN != null) {
            this.lFN.cBn();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.itS, R.color.cp_cont_b);
        this.itS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.lFD != null) {
            this.lFD.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.lFF;
    }
}
