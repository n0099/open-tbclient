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
/* loaded from: classes16.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float bkN;
    private SearchEmotionModel.a hFe;
    private float hFs;
    private EditText hFx;
    private ImageView hFy;
    private int jCh;
    private RelativeLayout jfq;
    private HListView kPn;
    private com.baidu.tieba.pb.pb.main.emotion.view.a kPo;
    private double kPp;
    private int kPq;
    private int kPr;
    private int kPs;
    private int kPt;
    private b kPu;
    private RelativeLayout kPv;
    private boolean kPw;
    private boolean kPx;
    private com.baidu.tieba.pb.pb.main.emotion.view.b kPy;
    private TextWatcher kPz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private float mDownY;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes16.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void c(String str, List<String> list, List<String> list2);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void onMove(float f);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.kPx = false;
        this.kPz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.chH())) {
                            PbEmotionBar.this.kPo.setData(PbEmotionBar.this.mData.chH());
                            PbEmotionBar.this.kPo.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kPy == null) {
                        PbEmotionBar.this.kPy = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kPy.a(PbEmotionBar.this.hFe);
                    }
                    PbEmotionBar.this.kPy.NU(trim);
                }
            }
        };
        this.hFe = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.chH()) && PbEmotionBar.this.hFx.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kPo.setData(aVar.chH());
                    PbEmotionBar.this.kPo.notifyDataSetChanged();
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
        this.kPx = false;
        this.kPz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.chH())) {
                            PbEmotionBar.this.kPo.setData(PbEmotionBar.this.mData.chH());
                            PbEmotionBar.this.kPo.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kPy == null) {
                        PbEmotionBar.this.kPy = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kPy.a(PbEmotionBar.this.hFe);
                    }
                    PbEmotionBar.this.kPy.NU(trim);
                }
            }
        };
        this.hFe = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.chH()) && PbEmotionBar.this.hFx.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kPo.setData(aVar.chH());
                    PbEmotionBar.this.kPo.notifyDataSetChanged();
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
        this.kPx = false;
        this.kPz = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.chH())) {
                            PbEmotionBar.this.kPo.setData(PbEmotionBar.this.mData.chH());
                            PbEmotionBar.this.kPo.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.kPy == null) {
                        PbEmotionBar.this.kPy = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.kPy.a(PbEmotionBar.this.hFe);
                    }
                    PbEmotionBar.this.kPy.NU(trim);
                }
            }
        };
        this.hFe = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.chH()) && PbEmotionBar.this.hFx.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.kPo.setData(aVar.chH());
                    PbEmotionBar.this.kPo.notifyDataSetChanged();
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
        this.kPn = (HListView) findViewById(R.id.lv_emotion);
        this.kPo = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.kPo.a(this);
        this.kPn.setAdapter((ListAdapter) this.kPo);
        this.kPn.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.kPn.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kPv = (RelativeLayout) findViewById(R.id.layout_search);
        this.hFx = (EditText) findViewById(R.id.edit_search);
        this.hFy = (ImageView) findViewById(R.id.iv_search);
        this.hFx.addTextChangedListener(this.kPz);
        this.hFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.hFx.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.hFs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.kPr = l.getDimens(getContext(), R.dimen.ds58);
        this.kPs = l.getDimens(getContext(), R.dimen.ds114);
        this.jCh = l.getDimens(getContext(), R.dimen.ds10);
        this.kPq = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.kPp = (this.kPr - this.kPs) * (1.0d / this.kPq);
        this.kPt = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.kPq && aa(motionEvent)) {
                    tN(true);
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
        if (this.kPn.getChildCount() <= 0 || this.kPn.getFirstVisiblePosition() != 0 || (childAt = this.kPn.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.bkN) {
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
        this.jfq.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.kPx && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.kPx = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.kPx = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.bkN = motionEvent.getRawX();
                this.bkN = motionEvent.getRawX();
                break;
            case 2:
                this.bkN = motionEvent.getRawX();
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
                        tN(false);
                    } else {
                        tN(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    tN(false);
                } else {
                    tN(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.bkN));
                if (rawX2 >= 0) {
                    i = rawX2 > this.kPq ? this.kPq : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int Ez = Ez(i);
                    if (Ez <= this.kPs && Ez >= this.kPr) {
                        EB(i);
                        EA(Ez);
                        EC(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.hFs && Math.abs(motionEvent.getRawY() - this.mDownY) < this.hFs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ez(int i) {
        return (int) ((this.kPp * i) + this.kPs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA(int i) {
        this.kPn.getLayoutParams().height = (this.jCh * 2) + i;
        this.kPo.EA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB(int i) {
        float f = 1.0f - ((i * 1.0f) / this.kPq);
        this.kPv.getLayoutParams().height = (int) (this.kPt * f);
        this.kPv.setAlpha(f);
        this.hFy.setScaleX(f);
        this.hFy.setScaleY(f);
        this.hFx.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cV(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.EB(intValue);
                    PbEmotionBar.this.EA(PbEmotionBar.this.Ez(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.EC(layoutParams.leftMargin);
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

    public void tN(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.kPq;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cV(i, i2);
    }

    public void tO(boolean z) {
        tN(true);
        if (z) {
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.hFx.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.hFx);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.kPo != null) {
            this.kPo.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.hFx.getText().toString(), PbEmotionBar.this.mData.dbZ(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.kPw = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean chJ() {
        return this.kPw;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chM() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC(int i) {
        if (this.kPu != null) {
            this.kPu.onMove((this.kPq - i) * (1.0f / this.kPq));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.kPu = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.kPo != null) {
            this.kPo.cTl();
        }
        coV();
    }

    public void coV() {
        if (this.kPy != null) {
            this.kPy.coV();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hFx, R.color.cp_cont_b);
        this.hFx.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.kPo != null) {
            this.kPo.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.kPq;
    }
}
