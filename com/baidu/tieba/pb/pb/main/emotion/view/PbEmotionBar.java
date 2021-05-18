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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.HListView;
import d.a.c.e.p.l;
import d.a.j0.z0.i0;
import java.util.List;
/* loaded from: classes5.dex */
public class PbEmotionBar extends LinearLayout implements EmotionView.c {
    public int A;
    public boolean B;
    public boolean C;
    public d.a.k0.d2.k.e.a1.g.b D;
    public TextWatcher E;
    public SearchEmotionModel.b F;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f19268e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f19269f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.d2.k.e.a1.g.a f19270g;

    /* renamed from: h  reason: collision with root package name */
    public float f19271h;

    /* renamed from: i  reason: collision with root package name */
    public float f19272i;
    public float j;
    public double k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public j s;
    public d.a.k0.d2.k.e.a1.e.a t;
    public RelativeLayout u;
    public EditText v;
    public ImageView w;
    public VelocityTracker x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c12492");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int i6 = i5 - i4;
            int length = 30 - (spanned.length() - i6);
            String obj = spanned.toString();
            int b2 = i0.b(obj);
            if (i6 > 0) {
                for (int i7 = i4; i7 < i6 + i4 && obj.length() < i7; i7++) {
                    b2 -= i0.a(obj.charAt(i7));
                }
            } else {
                b2 += i0.b(charSequence.toString());
            }
            if (b2 <= 30 && length > 0) {
                if (length >= i3 - i2) {
                    return null;
                }
                return charSequence.subSequence(i2, length + i2);
            }
            return "";
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String trim = editable.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                if (PbEmotionBar.this.t == null || ListUtils.isEmpty(PbEmotionBar.this.t.a())) {
                    return;
                }
                PbEmotionBar.this.f19270g.e(PbEmotionBar.this.t.a());
                PbEmotionBar.this.f19270g.notifyDataSetChanged();
                return;
            }
            if (PbEmotionBar.this.D == null) {
                PbEmotionBar.this.D = new d.a.k0.d2.k.e.a1.g.b();
                PbEmotionBar.this.D.g(PbEmotionBar.this.F);
            }
            PbEmotionBar.this.D.f(trim);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SearchEmotionModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, d.a.k0.k0.c.a aVar) {
            if (aVar == null || ListUtils.isEmpty(aVar.a()) || !PbEmotionBar.this.v.getText().toString().trim().equals(str)) {
                return;
            }
            PbEmotionBar.this.f19270g.e(aVar.a());
            PbEmotionBar.this.f19270g.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout.LayoutParams f19277e;

        public e(RelativeLayout.LayoutParams layoutParams) {
            this.f19277e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f19277e.leftMargin = intValue;
            PbEmotionBar.this.B(intValue);
            PbEmotionBar pbEmotionBar = PbEmotionBar.this;
            pbEmotionBar.A(pbEmotionBar.r(this.f19277e.leftMargin));
            PbEmotionBar.this.setLayoutParams(this.f19277e);
            PbEmotionBar.this.v(this.f19277e.leftMargin);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (((RelativeLayout.LayoutParams) PbEmotionBar.this.getLayoutParams()).leftMargin <= 0) {
                PbEmotionBar.this.setCanShowEmotionPreview(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PbEmotionBar.this.v.requestFocus();
            l.K(PbEmotionBar.this.getContext(), PbEmotionBar.this.v);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19281a;

        public h(i iVar) {
            this.f19281a = iVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void a(String str, List<String> list, List<String> list2) {
            if (PbEmotionBar.this.t != null) {
                this.f19281a.a(PbEmotionBar.this.v.getText().toString(), PbEmotionBar.this.t.b(), list2);
                TiebaStatic.log("c12177");
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.i
        public void b(EmotionImageData emotionImageData, boolean z) {
            this.f19281a.b(emotionImageData, z);
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(String str, List<String> list, List<String> list2);

        void b(EmotionImageData emotionImageData, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void onMove(float f2);
    }

    public PbEmotionBar(Context context) {
        super(context);
        this.C = false;
        this.E = new c();
        this.F = new d();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanShowEmotionPreview(boolean z) {
        this.B = z;
    }

    public final void A(int i2) {
        this.f19269f.getLayoutParams().height = (this.q * 2) + i2;
        this.f19270g.h(i2);
    }

    public final void B(int i2) {
        float f2 = 1.0f - ((i2 * 1.0f) / this.m);
        this.u.getLayoutParams().height = (int) (this.r * f2);
        this.u.setAlpha(f2);
        this.w.setScaleX(f2);
        this.w.setScaleY(f2);
        this.v.setTextSize(0, l.g(getContext(), R.dimen.fontsize32) * f2);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        return ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin <= 0;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r1 != 2) goto L13;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        this.f19268e.requestDisallowInterceptTouchEvent(true);
        if (!onInterceptTouchEvent(motionEvent)) {
            if (this.C && motionEvent.getAction() == 2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                dispatchTouchEvent = super.dispatchTouchEvent(obtain);
            } else {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
            this.C = false;
        } else {
            this.C = true;
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                setCanShowEmotionPreview(false);
            }
            this.f19271h = motionEvent.getRawX();
            this.f19272i = motionEvent.getRawY();
            this.j = motionEvent.getRawX();
        }
        this.j = motionEvent.getRawX();
        return dispatchTouchEvent;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        return this.B;
    }

    public int getMaxLeftMargin() {
        return this.m;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            } else if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin == this.m && u(motionEvent)) {
                p(true);
            }
            return y(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r1 != 3) goto L10;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x == null) {
            this.x = VelocityTracker.obtain();
        }
        this.x.addMovement(motionEvent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        int action = motionEvent.getAction();
        int i2 = 0;
        if (action != 1) {
            if (action == 2) {
                setCanShowEmotionPreview(false);
                int rawX = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.j));
                if (rawX >= 0 && rawX <= (i2 = this.m)) {
                    i2 = rawX;
                }
                if (layoutParams.leftMargin != i2) {
                    layoutParams.leftMargin = i2;
                    int r = r(i2);
                    if (r <= this.p && r >= this.o) {
                        B(i2);
                        A(r);
                        v(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
            }
            return true;
        }
        this.x.computeCurrentVelocity(1000, this.z);
        float xVelocity = this.x.getXVelocity();
        int rawX2 = (int) (motionEvent.getRawX() - this.f19271h);
        if (Math.abs(xVelocity) <= this.y || Math.abs(rawX2) <= this.A) {
            if (layoutParams.leftMargin > this.l * 0.4d) {
                p(false);
            } else {
                p(true);
            }
        } else if (rawX2 > 0) {
            p(false);
        } else {
            p(true);
        }
        this.x.clear();
        this.x.recycle();
        this.x = null;
        return true;
    }

    public void p(boolean z) {
        int i2 = ((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin;
        if (i2 <= 0) {
            setCanShowEmotionPreview(true);
            return;
        }
        int i3 = this.m;
        if (z) {
            i3 = 0;
            TiebaStatic.log("c12175");
        }
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
        }
        z(i2, i3);
    }

    public void q(boolean z) {
        p(true);
        if (z) {
            d.a.c.e.m.e.a().postDelayed(new g(), 300L);
        }
    }

    public final int r(int i2) {
        return (int) ((this.k * i2) + this.p);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void s() {
        d.a.k0.d2.k.e.a1.g.b bVar = this.D;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void setOnEmotionClickListener(i iVar) {
        d.a.k0.d2.k.e.a1.g.a aVar;
        if (iVar == null || (aVar = this.f19270g) == null) {
            return;
        }
        aVar.g(new h(iVar));
    }

    public void setOnMoveListener(j jVar) {
        this.s = jVar;
    }

    public final void t() {
        setId(R.id.pb_emotion_bar);
        LinearLayout.inflate(getContext(), R.layout.layout_pb_emotion_bar, this);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
        this.f19269f = (HListView) findViewById(R.id.lv_emotion);
        d.a.k0.d2.k.e.a1.g.a aVar = new d.a.k0.d2.k.e.a1.g.a();
        this.f19270g = aVar;
        aVar.f(this);
        this.f19269f.setAdapter((ListAdapter) this.f19270g);
        this.f19269f.setDividerWidth(l.g(getContext(), R.dimen.ds7));
        this.f19269f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.u = (RelativeLayout) findViewById(R.id.layout_search);
        this.v = (EditText) findViewById(R.id.edit_search);
        this.w = (ImageView) findViewById(R.id.iv_search);
        this.v.addTextChangedListener(this.E);
        this.v.setOnClickListener(new a());
        this.v.setFilters(new InputFilter[]{new b()});
        this.l = l.k(getContext());
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.z = ViewConfiguration.getMaximumFlingVelocity();
        this.y = ViewConfiguration.getMinimumFlingVelocity();
        this.A = l.g(getContext(), R.dimen.ds150);
        this.o = l.g(getContext(), R.dimen.ds58);
        this.p = l.g(getContext(), R.dimen.ds114);
        this.q = l.g(getContext(), R.dimen.ds10);
        int g2 = this.l - l.g(getContext(), R.dimen.tbds196);
        this.m = g2;
        this.k = (this.o - this.p) * (1.0d / g2);
        this.r = l.g(getContext(), R.dimen.ds100);
        w();
    }

    public final boolean u(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getRawX() - this.f19271h);
        float abs2 = Math.abs(motionEvent.getRawY() - this.f19272i);
        float f2 = this.n;
        return abs < f2 && abs2 < f2;
    }

    public final void v(int i2) {
        j jVar = this.s;
        if (jVar != null) {
            int i3 = this.m;
            jVar.onMove((i3 - i2) * (1.0f / i3));
        }
    }

    public void w() {
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
        this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        d.a.k0.d2.k.e.a1.g.a aVar = this.f19270g;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void x() {
        d.a.k0.d2.k.e.a1.g.a aVar = this.f19270g;
        if (aVar != null) {
            aVar.d();
        }
        s();
    }

    public final boolean y(MotionEvent motionEvent) {
        View childAt;
        if (u(motionEvent)) {
            return false;
        }
        if (((RelativeLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
            return true;
        }
        if (this.f19269f.getChildCount() <= 0 || this.f19269f.getFirstVisiblePosition() != 0 || (childAt = this.f19269f.getChildAt(0)) == null || childAt.getLeft() < 0 || motionEvent.getRawX() <= this.j) {
            setCanShowEmotionPreview(true);
            return false;
        }
        return true;
    }

    public final void z(int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new e((RelativeLayout.LayoutParams) getLayoutParams()));
        ofInt.addListener(new f());
        ofInt.setDuration(300L).start();
    }

    public PbEmotionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
        this.E = new c();
        this.F = new d();
        t();
    }

    public PbEmotionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C = false;
        this.E = new c();
        this.F = new d();
        t();
    }
}
