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
    private float bGS;
    private float cEl;
    private float iSH;
    private EditText iSM;
    private ImageView iSN;
    private SearchEmotionModel.a iSt;
    private int kOR;
    private RelativeLayout lxd;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;
    private com.baidu.tieba.pb.pb.main.emotion.view.a mdA;
    private double mdB;
    private int mdC;
    private int mdD;
    private int mdE;
    private int mdF;
    private b mdG;
    private RelativeLayout mdH;
    private boolean mdI;
    private boolean mdJ;
    private com.baidu.tieba.pb.pb.main.emotion.view.b mdK;
    private TextWatcher mdL;
    private HListView mdz;

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
        this.mdJ = false;
        this.mdL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyg())) {
                            PbEmotionBar.this.mdA.setData(PbEmotionBar.this.mData.cyg());
                            PbEmotionBar.this.mdA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdK == null) {
                        PbEmotionBar.this.mdK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdK.a(PbEmotionBar.this.iSt);
                    }
                    PbEmotionBar.this.mdK.PS(trim);
                }
            }
        };
        this.iSt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyg()) && PbEmotionBar.this.iSM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdA.setData(aVar.cyg());
                    PbEmotionBar.this.mdA.notifyDataSetChanged();
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
        this.mdJ = false;
        this.mdL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyg())) {
                            PbEmotionBar.this.mdA.setData(PbEmotionBar.this.mData.cyg());
                            PbEmotionBar.this.mdA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdK == null) {
                        PbEmotionBar.this.mdK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdK.a(PbEmotionBar.this.iSt);
                    }
                    PbEmotionBar.this.mdK.PS(trim);
                }
            }
        };
        this.iSt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyg()) && PbEmotionBar.this.iSM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdA.setData(aVar.cyg());
                    PbEmotionBar.this.mdA.notifyDataSetChanged();
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
        this.mdJ = false;
        this.mdL = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyg())) {
                            PbEmotionBar.this.mdA.setData(PbEmotionBar.this.mData.cyg());
                            PbEmotionBar.this.mdA.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdK == null) {
                        PbEmotionBar.this.mdK = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdK.a(PbEmotionBar.this.iSt);
                    }
                    PbEmotionBar.this.mdK.PS(trim);
                }
            }
        };
        this.iSt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyg()) && PbEmotionBar.this.iSM.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdA.setData(aVar.cyg());
                    PbEmotionBar.this.mdA.notifyDataSetChanged();
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
        this.mdz = (HListView) findViewById(R.id.lv_emotion);
        this.mdA = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.mdA.a(this);
        this.mdz.setAdapter((ListAdapter) this.mdA);
        this.mdz.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.mdz.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdH = (RelativeLayout) findViewById(R.id.layout_search);
        this.iSM = (EditText) findViewById(R.id.edit_search);
        this.iSN = (ImageView) findViewById(R.id.iv_search);
        this.iSM.addTextChangedListener(this.mdL);
        this.iSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.iSM.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.iSH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.mdD = l.getDimens(getContext(), R.dimen.ds58);
        this.mdE = l.getDimens(getContext(), R.dimen.ds114);
        this.kOR = l.getDimens(getContext(), R.dimen.ds10);
        this.mdC = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.mdB = (this.mdD - this.mdE) * (1.0d / this.mdC);
        this.mdF = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.mdC && ab(motionEvent)) {
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
        if (this.mdz.getChildCount() <= 0 || this.mdz.getFirstVisiblePosition() != 0 || (childAt = this.mdz.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bGS) {
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
        this.lxd.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.mdJ && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.mdJ = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.mdJ = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cEl = motionEvent.getRawY();
                this.bGS = motionEvent.getRawX();
                this.bGS = motionEvent.getRawX();
                break;
            case 2:
                this.bGS = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bGS));
                if (rawX2 >= 0) {
                    i = rawX2 > this.mdC ? this.mdC : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Gg = Gg(i);
                    if (Gg <= this.mdE && Gg >= this.mdD) {
                        Gi(i);
                        Gh(Gg);
                        Gj(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iSH && Math.abs(motionEvent.getRawY() - this.cEl) < this.iSH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gg(int i) {
        return (int) ((this.mdB * i) + this.mdE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(int i) {
        this.mdz.getLayoutParams().height = (this.kOR * 2) + i;
        this.mdA.Gh(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        float f = 1.0f - ((i * 1.0f) / this.mdC);
        this.mdH.getLayoutParams().height = (int) (this.mdF * f);
        this.mdH.setAlpha(f);
        this.iSN.setScaleX(f);
        this.iSN.setScaleY(f);
        this.iSM.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
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
                    PbEmotionBar.this.Gi(intValue);
                    PbEmotionBar.this.Gh(PbEmotionBar.this.Gg(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.Gj(layoutParams.leftMargin);
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
        int i2 = this.mdC;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        da(i, i2);
    }

    public void vV(boolean z) {
        vU(true);
        if (z) {
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.iSM.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.iSM);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.mdA != null) {
            this.mdA.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.iSM.getText().toString(), PbEmotionBar.this.mData.drZ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.mdI = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyi() {
        return this.mdI;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyl() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cym() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj(int i) {
        if (this.mdG != null) {
            this.mdG.onMove((this.mdC - i) * (1.0f / this.mdC));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.mdG = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.mdA != null) {
            this.mdA.diN();
        }
        cFx();
    }

    public void cFx() {
        if (this.mdK != null) {
            this.mdK.cFx();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iSM, R.color.CAM_X0105);
        this.iSM.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mdA != null) {
            this.mdA.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.mdC;
    }
}
