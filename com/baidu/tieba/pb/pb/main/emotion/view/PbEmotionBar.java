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
    private SearchEmotionModel.a iSH;
    private float iSV;
    private EditText iTa;
    private ImageView iTb;
    private int kPf;
    private RelativeLayout lxr;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;
    private HListView mdO;
    private com.baidu.tieba.pb.pb.main.emotion.view.a mdP;
    private double mdQ;
    private int mdR;
    private int mdS;
    private int mdT;
    private int mdU;
    private b mdV;
    private RelativeLayout mdW;
    private boolean mdX;
    private boolean mdY;
    private com.baidu.tieba.pb.pb.main.emotion.view.b mdZ;
    private TextWatcher mea;

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
        this.mdY = false;
        this.mea = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyn())) {
                            PbEmotionBar.this.mdP.setData(PbEmotionBar.this.mData.cyn());
                            PbEmotionBar.this.mdP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdZ == null) {
                        PbEmotionBar.this.mdZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdZ.a(PbEmotionBar.this.iSH);
                    }
                    PbEmotionBar.this.mdZ.PT(trim);
                }
            }
        };
        this.iSH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyn()) && PbEmotionBar.this.iTa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdP.setData(aVar.cyn());
                    PbEmotionBar.this.mdP.notifyDataSetChanged();
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
        this.mdY = false;
        this.mea = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyn())) {
                            PbEmotionBar.this.mdP.setData(PbEmotionBar.this.mData.cyn());
                            PbEmotionBar.this.mdP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdZ == null) {
                        PbEmotionBar.this.mdZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdZ.a(PbEmotionBar.this.iSH);
                    }
                    PbEmotionBar.this.mdZ.PT(trim);
                }
            }
        };
        this.iSH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyn()) && PbEmotionBar.this.iTa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdP.setData(aVar.cyn());
                    PbEmotionBar.this.mdP.notifyDataSetChanged();
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
        this.mdY = false;
        this.mea = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cyn())) {
                            PbEmotionBar.this.mdP.setData(PbEmotionBar.this.mData.cyn());
                            PbEmotionBar.this.mdP.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.mdZ == null) {
                        PbEmotionBar.this.mdZ = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.mdZ.a(PbEmotionBar.this.iSH);
                    }
                    PbEmotionBar.this.mdZ.PT(trim);
                }
            }
        };
        this.iSH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cyn()) && PbEmotionBar.this.iTa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.mdP.setData(aVar.cyn());
                    PbEmotionBar.this.mdP.notifyDataSetChanged();
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
        this.mdO = (HListView) findViewById(R.id.lv_emotion);
        this.mdP = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.mdP.a(this);
        this.mdO.setAdapter((ListAdapter) this.mdP);
        this.mdO.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.mdO.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdW = (RelativeLayout) findViewById(R.id.layout_search);
        this.iTa = (EditText) findViewById(R.id.edit_search);
        this.iTb = (ImageView) findViewById(R.id.iv_search);
        this.iTa.addTextChangedListener(this.mea);
        this.iTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.iTa.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.iSV = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.mdS = l.getDimens(getContext(), R.dimen.ds58);
        this.mdT = l.getDimens(getContext(), R.dimen.ds114);
        this.kPf = l.getDimens(getContext(), R.dimen.ds10);
        this.mdR = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.mdQ = (this.mdS - this.mdT) * (1.0d / this.mdR);
        this.mdU = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.mdR && ab(motionEvent)) {
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
        if (this.mdO.getChildCount() <= 0 || this.mdO.getFirstVisiblePosition() != 0 || (childAt = this.mdO.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bGS) {
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
        this.lxr.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.mdY && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.mdY = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.mdY = true;
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
                    i = rawX2 > this.mdR ? this.mdR : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Gg = Gg(i);
                    if (Gg <= this.mdT && Gg >= this.mdS) {
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
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iSV && Math.abs(motionEvent.getRawY() - this.cEl) < this.iSV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gg(int i) {
        return (int) ((this.mdQ * i) + this.mdT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(int i) {
        this.mdO.getLayoutParams().height = (this.kPf * 2) + i;
        this.mdP.Gh(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi(int i) {
        float f = 1.0f - ((i * 1.0f) / this.mdR);
        this.mdW.getLayoutParams().height = (int) (this.mdU * f);
        this.mdW.setAlpha(f);
        this.iTb.setScaleX(f);
        this.iTb.setScaleY(f);
        this.iTa.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void db(int i, int i2) {
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
        int i2 = this.mdR;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        db(i, i2);
    }

    public void vV(boolean z) {
        vU(true);
        if (z) {
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.iTa.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.iTa);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.mdP != null) {
            this.mdP.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.iTa.getText().toString(), PbEmotionBar.this.mData.dsg(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.mdX = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyp() {
        return this.mdX;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cys() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj(int i) {
        if (this.mdV != null) {
            this.mdV.onMove((this.mdR - i) * (1.0f / this.mdR));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.mdV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.mdP != null) {
            this.mdP.diU();
        }
        cFE();
    }

    public void cFE() {
        if (this.mdZ != null) {
            this.mdZ.cFE();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iTa, R.color.CAM_X0105);
        this.iTa.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mdP != null) {
            this.mdP.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.mdR;
    }
}
