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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes22.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bDi;
    private float cBL;
    private EditText iFA;
    private ImageView iFB;
    private SearchEmotionModel.a iFh;
    private float iFv;
    private int kGj;
    private RelativeLayout kjG;
    private HListView lTO;
    private com.baidu.tieba.pb.pb.main.emotion.view.a lTP;
    private double lTQ;
    private int lTR;
    private int lTS;
    private int lTT;
    private int lTU;
    private b lTV;
    private RelativeLayout lTW;
    private boolean lTX;
    private boolean lTY;
    private com.baidu.tieba.pb.pb.main.emotion.view.b lTZ;
    private TextWatcher lUa;
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
        this.lTY = false;
        this.lUa = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cxT())) {
                            PbEmotionBar.this.lTP.setData(PbEmotionBar.this.mData.cxT());
                            PbEmotionBar.this.lTP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lTZ == null) {
                        PbEmotionBar.this.lTZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lTZ.a(PbEmotionBar.this.iFh);
                    }
                    PbEmotionBar.this.lTZ.QD(trim);
                }
            }
        };
        this.iFh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cxT()) && PbEmotionBar.this.iFA.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lTP.setData(aVar.cxT());
                    PbEmotionBar.this.lTP.notifyDataSetChanged();
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
        this.lTY = false;
        this.lUa = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cxT())) {
                            PbEmotionBar.this.lTP.setData(PbEmotionBar.this.mData.cxT());
                            PbEmotionBar.this.lTP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lTZ == null) {
                        PbEmotionBar.this.lTZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lTZ.a(PbEmotionBar.this.iFh);
                    }
                    PbEmotionBar.this.lTZ.QD(trim);
                }
            }
        };
        this.iFh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cxT()) && PbEmotionBar.this.iFA.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lTP.setData(aVar.cxT());
                    PbEmotionBar.this.lTP.notifyDataSetChanged();
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
        this.lTY = false;
        this.lUa = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cxT())) {
                            PbEmotionBar.this.lTP.setData(PbEmotionBar.this.mData.cxT());
                            PbEmotionBar.this.lTP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lTZ == null) {
                        PbEmotionBar.this.lTZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lTZ.a(PbEmotionBar.this.iFh);
                    }
                    PbEmotionBar.this.lTZ.QD(trim);
                }
            }
        };
        this.iFh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cxT()) && PbEmotionBar.this.iFA.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lTP.setData(aVar.cxT());
                    PbEmotionBar.this.lTP.notifyDataSetChanged();
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
        this.lTO = (HListView) findViewById(R.id.lv_emotion);
        this.lTP = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.lTP.a(this);
        this.lTO.setAdapter((ListAdapter) this.lTP);
        this.lTO.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.lTO.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lTW = (RelativeLayout) findViewById(R.id.layout_search);
        this.iFA = (EditText) findViewById(R.id.edit_search);
        this.iFB = (ImageView) findViewById(R.id.iv_search);
        this.iFA.addTextChangedListener(this.lUa);
        this.iFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.iFA.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int textLength = ae.getTextLength(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int charLength = textLength - ae.getCharLength(obj.charAt(i6));
                        i6++;
                        textLength = charLength;
                    }
                } else {
                    textLength += ae.getTextLength(charSequence.toString());
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
        this.iFv = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.lTS = l.getDimens(getContext(), R.dimen.ds58);
        this.lTT = l.getDimens(getContext(), R.dimen.ds114);
        this.kGj = l.getDimens(getContext(), R.dimen.ds10);
        this.lTR = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.lTQ = (this.lTS - this.lTT) * (1.0d / this.lTR);
        this.lTU = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.lTR && ab(motionEvent)) {
                    vH(true);
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
        if (this.lTO.getChildCount() <= 0 || this.lTO.getFirstVisiblePosition() != 0 || (childAt = this.lTO.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bDi) {
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
        this.kjG.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.lTY && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.lTY = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.lTY = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cBL = motionEvent.getRawY();
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
                        vH(false);
                    } else {
                        vH(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    vH(false);
                } else {
                    vH(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bDi));
                if (rawX2 >= 0) {
                    i = rawX2 > this.lTR ? this.lTR : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int HA = HA(i);
                    if (HA <= this.lTT && HA >= this.lTS) {
                        HC(i);
                        HB(HA);
                        HD(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iFv && Math.abs(motionEvent.getRawY() - this.cBL) < this.iFv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HA(int i) {
        return (int) ((this.lTQ * i) + this.lTT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(int i) {
        this.lTO.getLayoutParams().height = (this.kGj * 2) + i;
        this.lTP.HB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(int i) {
        float f = 1.0f - ((i * 1.0f) / this.lTR);
        this.lTW.getLayoutParams().height = (int) (this.lTU * f);
        this.lTW.setAlpha(f);
        this.iFB.setScaleX(f);
        this.iFB.setScaleY(f);
        this.iFA.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void dh(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.HC(intValue);
                    PbEmotionBar.this.HB(PbEmotionBar.this.HA(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.HD(layoutParams.leftMargin);
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

    public void vH(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.lTR;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        dh(i, i2);
    }

    public void vI(boolean z) {
        vH(true);
        if (z) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.iFA.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.iFA);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.lTP != null) {
            this.lTP.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.iFA.getText().toString(), PbEmotionBar.this.mData.dtN(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.lTX = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cxV() {
        return this.lTX;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxY() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD(int i) {
        if (this.lTV != null) {
            this.lTV.onMove((this.lTR - i) * (1.0f / this.lTR));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.lTV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.lTP != null) {
            this.lTP.dkT();
        }
        cFh();
    }

    public void cFh() {
        if (this.lTZ != null) {
            this.lTZ.cFh();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iFA, R.color.CAM_X0105);
        this.iFA.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.lTP != null) {
            this.lTP.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.lTR;
    }
}
