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
    private float brt;
    private float cif;
    private SearchEmotionModel.a iba;
    private float ibo;
    private EditText ibt;
    private ImageView ibu;
    private RelativeLayout jCT;
    private int jZG;
    private HListView lnc;
    private com.baidu.tieba.pb.pb.main.emotion.view.a lnd;
    private double lne;
    private int lnf;
    private int lnh;
    private int lni;
    private int lnj;
    private b lnk;
    private RelativeLayout lnl;
    private boolean lnm;
    private boolean lnn;
    private com.baidu.tieba.pb.pb.main.emotion.view.b lno;
    private TextWatcher lnp;
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
        this.lnn = false;
        this.lnp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cos())) {
                            PbEmotionBar.this.lnd.setData(PbEmotionBar.this.mData.cos());
                            PbEmotionBar.this.lnd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lno == null) {
                        PbEmotionBar.this.lno = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lno.a(PbEmotionBar.this.iba);
                    }
                    PbEmotionBar.this.lno.Pk(trim);
                }
            }
        };
        this.iba = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cos()) && PbEmotionBar.this.ibt.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lnd.setData(aVar.cos());
                    PbEmotionBar.this.lnd.notifyDataSetChanged();
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
        this.lnn = false;
        this.lnp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cos())) {
                            PbEmotionBar.this.lnd.setData(PbEmotionBar.this.mData.cos());
                            PbEmotionBar.this.lnd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lno == null) {
                        PbEmotionBar.this.lno = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lno.a(PbEmotionBar.this.iba);
                    }
                    PbEmotionBar.this.lno.Pk(trim);
                }
            }
        };
        this.iba = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cos()) && PbEmotionBar.this.ibt.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lnd.setData(aVar.cos());
                    PbEmotionBar.this.lnd.notifyDataSetChanged();
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
        this.lnn = false;
        this.lnp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !y.isEmpty(PbEmotionBar.this.mData.cos())) {
                            PbEmotionBar.this.lnd.setData(PbEmotionBar.this.mData.cos());
                            PbEmotionBar.this.lnd.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.lno == null) {
                        PbEmotionBar.this.lno = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.lno.a(PbEmotionBar.this.iba);
                    }
                    PbEmotionBar.this.lno.Pk(trim);
                }
            }
        };
        this.iba = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !y.isEmpty(aVar.cos()) && PbEmotionBar.this.ibt.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.lnd.setData(aVar.cos());
                    PbEmotionBar.this.lnd.notifyDataSetChanged();
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
        this.lnc = (HListView) findViewById(R.id.lv_emotion);
        this.lnd = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.lnd.a(this);
        this.lnc.setAdapter((ListAdapter) this.lnd);
        this.lnc.setDividerWidth(l.getDimens(getContext(), R.dimen.ds7));
        this.lnc.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lnl = (RelativeLayout) findViewById(R.id.layout_search);
        this.ibt = (EditText) findViewById(R.id.edit_search);
        this.ibu = (ImageView) findViewById(R.id.iv_search);
        this.ibt.addTextChangedListener(this.lnp);
        this.ibt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.ibt.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
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
        this.ibo = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.getDimens(getContext(), R.dimen.ds150);
        this.lnh = l.getDimens(getContext(), R.dimen.ds58);
        this.lni = l.getDimens(getContext(), R.dimen.ds114);
        this.jZG = l.getDimens(getContext(), R.dimen.ds10);
        this.lnf = this.mScreenWidth - l.getDimens(getContext(), R.dimen.tbds196);
        this.lne = (this.lnh - this.lni) * (1.0d / this.lnf);
        this.lnj = l.getDimens(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.lnf && aa(motionEvent)) {
                    uB(true);
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
        if (this.lnc.getChildCount() <= 0 || this.lnc.getFirstVisiblePosition() != 0 || (childAt = this.lnc.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.brt) {
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
        this.jCT.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.lnn && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.lnn = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.lnn = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cif = motionEvent.getRawY();
                this.brt = motionEvent.getRawX();
                this.brt = motionEvent.getRawX();
                break;
            case 2:
                this.brt = motionEvent.getRawX();
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
                        uB(false);
                    } else {
                        uB(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    uB(false);
                } else {
                    uB(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.brt));
                if (rawX2 >= 0) {
                    i = rawX2 > this.lnf ? this.lnf : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int FG = FG(i);
                    if (FG <= this.lni && FG >= this.lnh) {
                        FI(i);
                        FH(FG);
                        FJ(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean aa(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.ibo && Math.abs(motionEvent.getRawY() - this.cif) < this.ibo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FG(int i) {
        return (int) ((this.lne * i) + this.lni);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        this.lnc.getLayoutParams().height = (this.jZG * 2) + i;
        this.lnd.FH(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI(int i) {
        float f = 1.0f - ((i * 1.0f) / this.lnf);
        this.lnl.getLayoutParams().height = (int) (this.lnj * f);
        this.lnl.setAlpha(f);
        this.ibu.setScaleX(f);
        this.ibu.setScaleY(f);
        this.ibt.setTextSize(0, f * l.getDimens(getContext(), R.dimen.fontsize32));
    }

    private void cY(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.FI(intValue);
                    PbEmotionBar.this.FH(PbEmotionBar.this.FG(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.FJ(layoutParams.leftMargin);
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

    public void uB(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.lnf;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
        }
        cY(i, i2);
    }

    public void uC(boolean z) {
        uB(true);
        if (z) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.ibt.requestFocus();
                    l.showSoftKeyPad(PbEmotionBar.this.getContext(), PbEmotionBar.this.ibt);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.lnd != null) {
            this.lnd.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void c(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.c(PbEmotionBar.this.ibt.getText().toString(), PbEmotionBar.this.mData.djm(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.lnm = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cou() {
        return this.lnm;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cox() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void coy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ(int i) {
        if (this.lnk != null) {
            this.lnk.onMove((this.lnf - i) * (1.0f / this.lnf));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.lnk = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.lnd != null) {
            this.lnd.daz();
        }
        cvF();
    }

    public void cvF() {
        if (this.lno != null) {
            this.lno.cvF();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ibt, R.color.cp_cont_b);
        this.ibt.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.lnd != null) {
            this.lnd.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.lnf;
    }
}
