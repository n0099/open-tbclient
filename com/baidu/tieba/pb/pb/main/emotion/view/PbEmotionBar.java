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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.a {
    private float cPp;
    private float eOx;
    private SearchEmotionModel.a eXF;
    private float eXR;
    private EditText eXW;
    private ImageView eXX;
    private int gMN;
    private HListView hRd;
    private com.baidu.tieba.pb.pb.main.emotion.view.a hRe;
    private double hRf;
    private int hRg;
    private int hRh;
    private int hRi;
    private int hRj;
    private b hRk;
    private RelativeLayout hRl;
    private boolean hRm;
    private boolean hRn;
    private com.baidu.tieba.pb.pb.main.emotion.view.b hRo;
    private TextWatcher hRp;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private RelativeLayout mParent;
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
        this.hRn = false;
        this.hRp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bfb())) {
                            PbEmotionBar.this.hRe.setData(PbEmotionBar.this.mData.bfb());
                            PbEmotionBar.this.hRe.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hRo == null) {
                        PbEmotionBar.this.hRo = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hRo.a(PbEmotionBar.this.eXF);
                    }
                    PbEmotionBar.this.hRo.Bx(trim);
                }
            }
        };
        this.eXF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bfb()) && PbEmotionBar.this.eXW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hRe.setData(aVar.bfb());
                    PbEmotionBar.this.hRe.notifyDataSetChanged();
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
        this.hRn = false;
        this.hRp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bfb())) {
                            PbEmotionBar.this.hRe.setData(PbEmotionBar.this.mData.bfb());
                            PbEmotionBar.this.hRe.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hRo == null) {
                        PbEmotionBar.this.hRo = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hRo.a(PbEmotionBar.this.eXF);
                    }
                    PbEmotionBar.this.hRo.Bx(trim);
                }
            }
        };
        this.eXF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bfb()) && PbEmotionBar.this.eXW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hRe.setData(aVar.bfb());
                    PbEmotionBar.this.hRe.notifyDataSetChanged();
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
        this.hRn = false;
        this.hRp = new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.3
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
                        if (PbEmotionBar.this.mData != null && !v.aa(PbEmotionBar.this.mData.bfb())) {
                            PbEmotionBar.this.hRe.setData(PbEmotionBar.this.mData.bfb());
                            PbEmotionBar.this.hRe.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (PbEmotionBar.this.hRo == null) {
                        PbEmotionBar.this.hRo = new com.baidu.tieba.pb.pb.main.emotion.view.b();
                        PbEmotionBar.this.hRo.a(PbEmotionBar.this.eXF);
                    }
                    PbEmotionBar.this.hRo.Bx(trim);
                }
            }
        };
        this.eXF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.4
            @Override // com.baidu.tieba.face.SearchEmotionModel.a
            public void a(String str, com.baidu.tieba.face.data.a aVar) {
                if (aVar != null && !v.aa(aVar.bfb()) && PbEmotionBar.this.eXW.getText().toString().trim().equals(str)) {
                    PbEmotionBar.this.hRe.setData(aVar.bfb());
                    PbEmotionBar.this.hRe.notifyDataSetChanged();
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
        this.hRd = (HListView) findViewById(R.id.lv_emotion);
        this.hRe = new com.baidu.tieba.pb.pb.main.emotion.view.a();
        this.hRe.a(this);
        this.hRd.setAdapter((ListAdapter) this.hRe);
        this.hRd.setDividerWidth(l.g(getContext(), R.dimen.ds7));
        this.hRd.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.hRl = (RelativeLayout) findViewById(R.id.layout_search);
        this.eXW = (EditText) findViewById(R.id.edit_search);
        this.eXX = (ImageView) findViewById(R.id.iv_search);
        this.eXW.addTextChangedListener(this.hRp);
        this.eXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log("c12492");
            }
        });
        this.eXW.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int i5 = i4 - i3;
                int length = 30 - (spanned.length() - i5);
                String obj = spanned.toString();
                int qW = ab.qW(obj);
                if (i5 > 0) {
                    int i6 = i3;
                    while (i6 < i5 + i3 && obj.length() < i6) {
                        int d = qW - ab.d(obj.charAt(i6));
                        i6++;
                        qW = d;
                    }
                } else {
                    qW += ab.qW(charSequence.toString());
                }
                if (qW > 30 || length <= 0) {
                    return "";
                }
                if (length >= i2 - i) {
                    return null;
                }
                return charSequence.subSequence(i, i + length);
            }
        }});
        this.mScreenWidth = l.af(getContext());
        this.eXR = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = l.g(getContext(), R.dimen.ds150);
        this.hRh = l.g(getContext(), R.dimen.ds58);
        this.hRi = l.g(getContext(), R.dimen.ds114);
        this.gMN = l.g(getContext(), R.dimen.ds10);
        this.hRg = this.mScreenWidth - l.g(getContext(), R.dimen.tbds196);
        this.hRf = (this.hRh - this.hRi) * (1.0d / this.hRg);
        this.hRj = l.g(getContext(), R.dimen.ds100);
        onChangeSkinType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                return false;
            case 1:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.hRg && M(motionEvent)) {
                    oQ(true);
                    break;
                }
                break;
            case 2:
                break;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
        return L(motionEvent);
    }

    private boolean L(MotionEvent motionEvent) {
        View childAt;
        if (M(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.hRd.getChildCount() <= 0 || this.hRd.getFirstVisiblePosition() != 0 || (childAt = this.hRd.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.eOx) {
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
        this.mParent.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.hRn && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            }
            this.hRn = false;
            dispatchTouchEvent = dispatchTouchEvent2;
        } else {
            this.hRn = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanShowEmotionPreview(false);
                }
                this.mDownX = motionEvent.getRawX();
                this.cPp = motionEvent.getRawY();
                this.eOx = motionEvent.getRawX();
                this.eOx = motionEvent.getRawX();
                break;
            case 2:
                this.eOx = motionEvent.getRawX();
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
                        oQ(false);
                    } else {
                        oQ(true);
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    oQ(false);
                } else {
                    oQ(true);
                }
                this.mVelocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case 2:
                setCanShowEmotionPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eOx));
                if (rawX2 >= 0) {
                    i = rawX2 > this.hRg ? this.hRg : rawX2;
                }
                if (layoutParams.leftMargin != i) {
                    layoutParams.leftMargin = i;
                    int xE = xE(i);
                    if (xE <= this.hRi && xE >= this.hRh) {
                        xG(i);
                        xF(xE);
                        xH(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
        return true;
    }

    private boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.eXR && Math.abs(motionEvent.getRawY() - this.cPp) < this.eXR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xE(int i) {
        return (int) ((this.hRf * i) + this.hRi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(int i) {
        this.hRd.getLayoutParams().height = (this.gMN * 2) + i;
        this.hRe.xF(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(int i) {
        float f = 1.0f - ((i * 1.0f) / this.hRg);
        this.hRl.getLayoutParams().height = (int) (this.hRj * f);
        this.hRl.setAlpha(f);
        this.eXX.setScaleX(f);
        this.eXX.setScaleY(f);
        this.eXW.setTextSize(0, f * l.g(getContext(), R.dimen.fontsize32));
    }

    private void cc(int i, int i2) {
        if (i != i2) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    layoutParams.leftMargin = intValue;
                    PbEmotionBar.this.xG(intValue);
                    PbEmotionBar.this.xF(PbEmotionBar.this.xE(layoutParams.leftMargin));
                    PbEmotionBar.this.setLayoutParams(layoutParams);
                    PbEmotionBar.this.xH(layoutParams.leftMargin);
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

    public void oQ(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.hRg;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        cc(i, i2);
    }

    public void oR(boolean z) {
        oQ(true);
        if (z) {
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.7
                @Override // java.lang.Runnable
                public void run() {
                    PbEmotionBar.this.eXW.requestFocus();
                    l.c(PbEmotionBar.this.getContext(), PbEmotionBar.this.eXW);
                }
            }, 300L);
        }
    }

    public void setOnEmotionClickListener(final a aVar) {
        if (aVar != null && this.hRe != null) {
            this.hRe.a(new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.8
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    aVar.b(emotionImageData, z);
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(String str, List<String> list, List<String> list2) {
                    if (PbEmotionBar.this.mData != null) {
                        aVar.b(PbEmotionBar.this.eXW.getText().toString(), PbEmotionBar.this.mData.bVA(), list2);
                        TiebaStatic.log("c12177");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.hRm = z;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfd() {
        return this.hRm;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfg() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfh() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(int i) {
        if (this.hRk != null) {
            this.hRk.onMove((this.hRg - i) * (1.0f / this.hRg));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.hRk = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onDestroy() {
        if (this.hRe != null) {
            this.hRe.bNS();
        }
        bmo();
    }

    public void bmo() {
        if (this.hRo != null) {
            this.hRo.bmo();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eXW, R.color.cp_cont_b);
        this.eXW.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.l(this, R.color.cp_bg_line_d);
        if (this.hRe != null) {
            this.hRe.notifyDataSetChanged();
        }
    }

    public int getMaxLeftMargin() {
        return this.hRg;
    }
}
