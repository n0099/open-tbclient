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
    private float aSg;
    private SearchEmotionModel.a gKH;
    private float gKV;
    private EditText gLa;
    private ImageView gLb;
    private RelativeLayout idy;
    private int iyd;
    private HListView jEc;
    private com.baidu.tieba.pb.pb.main.emotion.view.a jEd;
    private double jEe;
    private int jEf;
    private int jEg;
    private int jEh;
    private int jEi;
    private b jEj;
    private RelativeLayout jEk;
    private boolean jEl;
    private boolean jEm;
    private com.baidu.tieba.pb.pb.main.emotion.view.b jEn;
    private TextWatcher jEo;
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
        this.jEm = false;
        this.jEo = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKy())) {
                            PbEmotionBar.this.jEd.setData(PbEmotionBar.this.mData.bKy());
                            PbEmotionBar.this.jEd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEn == null) {
                        PbEmotionBar.this.jEn = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEn.a(PbEmotionBar.this.gKH);
                    }
                    PbEmotionBar.this.jEn.HW(trim);
                }
            }
        };
        this.gKH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKy()) && PbEmotionBar.this.gLa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEd.setData(aVar.bKy());
                    PbEmotionBar.this.jEd.notifyDataSetChanged();
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
        this.jEm = false;
        this.jEo = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKy())) {
                            PbEmotionBar.this.jEd.setData(PbEmotionBar.this.mData.bKy());
                            PbEmotionBar.this.jEd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEn == null) {
                        PbEmotionBar.this.jEn = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEn.a(PbEmotionBar.this.gKH);
                    }
                    PbEmotionBar.this.jEn.HW(trim);
                }
            }
        };
        this.gKH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKy()) && PbEmotionBar.this.gLa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEd.setData(aVar.bKy());
                    PbEmotionBar.this.jEd.notifyDataSetChanged();
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
        this.jEm = false;
        this.jEo = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.isEmpty(PbEmotionBar.this.mData.bKy())) {
                            PbEmotionBar.this.jEd.setData(PbEmotionBar.this.mData.bKy());
                            PbEmotionBar.this.jEd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.jEn == null) {
                        PbEmotionBar.this.jEn = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.jEn.a(PbEmotionBar.this.gKH);
                    }
                    PbEmotionBar.this.jEn.HW(trim);
                }
            }
        };
        this.gKH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.isEmpty(aVar.bKy()) && PbEmotionBar.this.gLa.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.jEd.setData(aVar.bKy());
                    PbEmotionBar.this.jEd.notifyDataSetChanged();
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
        this.jEc = (HListView) findViewById(R.id.lv_emotion);
        this.jEd = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.jEd.a(this);
        this.jEc.setAdapter((ListAdapter) this.jEd);
        this.jEc.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.jEc.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jEk = (RelativeLayout) findViewById(R.id.layout_search);
        this.gLa = (EditText) findViewById(R.id.edit_search);
        this.gLb = (ImageView) findViewById(R.id.iv_search);
        this.gLa.addTextChangedListener(this.jEo);
        this.gLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.gLa.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.gKV = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.jEg = l.getDimens(getContext(), R.dimen.ds58);
        this.jEh = l.getDimens(getContext(), R.dimen.ds114);
        this.iyd = l.getDimens(getContext(), R.dimen.ds10);
        this.jEf = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.jEe = (this.jEg - this.jEh) * (1.0d / this.jEf);
        this.jEi = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.jEf && D(motionEvent)) {
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
        if (this.jEc.getChildCount() <= 0 || this.jEc.getFirstVisiblePosition() != 0 || (childAt = this.jEc.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.aSg) {
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
        this.idy.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.jEm && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.jEm = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.jEm = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.mDownY = motionEvent.getRawY();
                this.aSg = motionEvent.getRawX();
                this.aSg = motionEvent.getRawX();
                break;
            case 2:
                this.aSg = motionEvent.getRawX();
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.aSg));
                if (rawX2 >= 0) {
                    i = rawX2 > this.jEf ? this.jEf : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int zR = zR(i);
                    if (zR <= this.jEh && zR >= this.jEg) {
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
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gKV && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gKV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zR(int i) {
        return (int) ((this.jEe * i) + this.jEh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        this.jEc.getLayoutParams().height = (this.iyd * 2) + i;
        this.jEd.zS(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        float f = 1.0f - ((i * 1.0f) / this.jEf);
        this.jEk.getLayoutParams().height = (int) (this.jEi * f);
        this.jEk.setAlpha(f);
        this.gLb.setScaleX(f);
        this.gLb.setScaleY(f);
        this.gLa.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
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
        int i2 = this.jEf;
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
                    PbEmotionBar.this.gLa.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.gLa);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.jEd != null) {
            this.jEd.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.gLa.getText().toString(), PbEmotionBar.this.mData.cBS(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.jEl = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bKA() {
        return this.jEl;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKD() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKE() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zU(int i) {
        if (this.jEj != null) {
            this.jEj.onMove((this.jEf - i) * (1.0f / this.jEf));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.jEj = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.jEd != null) {
            this.jEd.ctE();
        }
        bRj();
    }

    public void bRj() {
        if (this.jEn != null) {
            this.jEn.bRj();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gLa, (int) R.color.cp_cont_b);
        this.gLa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.jEd != null) {
            this.jEd.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.jEf;
    }
}
