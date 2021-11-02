package com.baidu.tieba.write.write.work.topic;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicListLayout;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicSuggestLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SelectTopicLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b.a.r0.k1.f> A;
    public float B;
    public float C;
    public final View.OnClickListener D;

    /* renamed from: e  reason: collision with root package name */
    public View f56267e;

    /* renamed from: f  reason: collision with root package name */
    public View f56268f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f56269g;

    /* renamed from: h  reason: collision with root package name */
    public View f56270h;

    /* renamed from: i  reason: collision with root package name */
    public View f56271i;
    public ImageView j;
    public TextView k;
    public RelativeLayout l;
    public TextView m;
    public ImageView n;
    public EditText o;
    public SelectTopicListLayout p;
    public SelectTopicSuggestLayout q;
    public HotTopicSelectModel r;
    public f s;
    public boolean t;
    public int u;
    public int v;
    public VelocityTracker w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicLayout f56272e;

        public a(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56272e = selectTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56272e.close(true);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicLayout f56273e;

        public b(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56273e = selectTopicLayout;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    this.f56273e.q.bindData("", null);
                    this.f56273e.p.setVisibility(0);
                    this.f56273e.q.setVisibility(8);
                    this.f56273e.setDelButtonVisible(false);
                    return;
                }
                this.f56273e.p.setVisibility(8);
                this.f56273e.q.setVisibility(0);
                this.f56273e.r.K(obj);
                this.f56273e.setDelButtonVisible(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f56274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SelectTopicLayout f56275f;

        public c(SelectTopicLayout selectTopicLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56275f = selectTopicLayout;
            this.f56274e = z;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f56275f.setVisibility(8);
                this.f56275f.t = false;
                this.f56275f.o.setText("");
                this.f56275f.p.onClose();
                this.f56275f.q.onClose();
                if (this.f56275f.s != null) {
                    this.f56275f.s.a(false, this.f56274e);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicLayout f56276e;

        public d(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56276e = selectTopicLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f56276e.t = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicLayout f56277e;

        public e(SelectTopicLayout selectTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56277e = selectTopicLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view == this.f56277e.n) {
                this.f56277e.clearAllTopicText();
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a(boolean z, boolean z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = -1;
        this.A = new ArrayList();
        this.D = new e(this);
        k();
    }

    private String getSearchKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.r;
            String C = hotTopicSelectModel != null ? hotTopicSelectModel.C() : "";
            return C != null ? C : "";
        }
        return (String) invokeV.objValue;
    }

    public void clearAllTopicText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.setText("");
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close(false);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v = -1;
            n();
        }
    }

    public final int i(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int i2 = this.v;
            int j = j(motionEvent, i2);
            if (m(motionEvent, j, i2)) {
                return 0;
            }
            return (int) Math.abs(motionEvent.getY(j) - this.C);
        }
        return invokeL.intValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public final int j(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, motionEvent, i2)) == null) {
            int findPointerIndex = motionEvent.findPointerIndex(i2);
            if (findPointerIndex == -1) {
                this.v = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.select_topic_layout, this);
            View findViewById = findViewById(R.id.title_placeholder);
            this.f56267e = findViewById;
            findViewById.setOnClickListener(new a(this));
            this.f56268f = findViewById(R.id.container_layout_shadow);
            this.f56269g = (RelativeLayout) findViewById(R.id.container_layout);
            this.f56270h = findViewById(R.id.top_container_layout);
            this.f56271i = findViewById(R.id.bottom_container_layout);
            this.j = (ImageView) findViewById(R.id.select_topic_title_arrow);
            this.k = (TextView) findViewById(R.id.select_topic_title_tip);
            this.l = (RelativeLayout) findViewById(R.id.topic_self_edit_container);
            this.m = (TextView) findViewById(R.id.topic_self_edit_prefix);
            this.n = (ImageView) findViewById(R.id.topic_self_edit_clear_btn);
            EditText editText = (EditText) findViewById(R.id.topic_self_edit_view);
            this.o = editText;
            editText.addTextChangedListener(new b(this));
            this.p = (SelectTopicListLayout) findViewById(R.id.select_topic_list_layout);
            this.q = (SelectTopicSuggestLayout) findViewById(R.id.select_topic_suggest_layout);
            this.n.setOnClickListener(this.D);
            setDelButtonVisible(false);
            onSkinChange();
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.y = ViewConfiguration.getMaximumFlingVelocity();
            this.x = ViewConfiguration.getMinimumFlingVelocity();
            this.z = l.i(getContext()) / 8;
        }
    }

    public final boolean m(MotionEvent motionEvent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, motionEvent, i2, i3)) == null) ? motionEvent == null || i3 == -1 || i2 == -1 || i2 >= motionEvent.getPointerCount() : invokeLII.booleanValue;
    }

    public final void n() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (velocityTracker = this.w) == null) {
            return;
        }
        velocityTracker.clear();
        this.w.recycle();
        this.w = null;
    }

    public void onHotSelectDataNoSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void onHotSelectDataNoSearchSuccess(b.a.r0.k1.c cVar, b.a.r0.k1.c cVar2, b.a.r0.k1.c cVar3) {
        SelectTopicListLayout selectTopicListLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, cVar, cVar2, cVar3) == null) || (selectTopicListLayout = this.p) == null) {
            return;
        }
        selectTopicListLayout.bindData(cVar, cVar2, cVar3);
    }

    public void onHotSelectDataSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void onHotSelectDataSearchSuccess(b.a.r0.k1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.A.clear();
            String searchKey = getSearchKey();
            b.a.r0.k1.c cVar2 = new b.a.r0.k1.c();
            this.A.add(b.a.r0.k1.f.a(searchKey, 0L, false));
            if (cVar == null) {
                cVar = cVar2;
            }
            cVar.c().addAll(0, this.A);
            this.q.bindData(getSearchKey(), cVar.c());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (this.t) {
                return true;
            }
            if ((motionEvent.getAction() & 255) == 0) {
                int actionIndex = motionEvent.getActionIndex();
                this.v = motionEvent.getPointerId(actionIndex);
                this.B = motionEvent.getY();
                float y = motionEvent.getY(actionIndex);
                this.C = y;
                if (y < this.f56267e.getHeight()) {
                    return false;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void onSkinChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.q0.s.u.c.d(this.f56268f).o(new int[]{R.color.CAM_X0803, R.color.CAM_X0601});
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f56270h);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0207);
            b.a.q0.s.u.c.d(this.f56271i).f(R.color.CAM_X0207);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.k);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            d3.A(R.string.F_X01);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.l);
            d4.n(R.string.J_X07);
            d4.f(R.color.CAM_X0209);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.m);
            d5.v(R.color.CAM_X0110);
            d5.z(R.dimen.T_X07);
            d5.A(R.string.F_X01);
            this.o.setHintTextColor(b.a.q0.s.u.a.h(R.color.CAM_X0110));
            b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.o);
            d6.v(R.color.CAM_X0105);
            d6.z(R.dimen.T_X07);
            d6.A(R.string.F_X01);
            this.p.onChangeSkin();
            this.q.onChangeSkin();
            SkinManager.setImageResource(this.n, R.drawable.del_search_btn);
            b.a.q0.s.u.c d7 = b.a.q0.s.u.c.d(this.j);
            d7.n(R.string.J_X01);
            d7.f(R.color.CAM_X0209);
            this.j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_post_dropdown42, SkinManager.getColor(R.color.CAM_X0108), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (this.t) {
                return true;
            }
            if (this.w == null) {
                this.w = VelocityTracker.obtain();
            }
            this.w.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int j = j(motionEvent, this.v);
                        if (!m(motionEvent, j, this.v)) {
                            float y = motionEvent.getY(j);
                            float f2 = y - this.B;
                            this.B = y;
                            float translationY = this.f56269g.getTranslationY() + f2;
                            this.f56269g.setTranslationY(translationY >= 0.0f ? translationY : 0.0f);
                        }
                    }
                }
                VelocityTracker velocityTracker = this.w;
                velocityTracker.computeCurrentVelocity(1000, this.y);
                float yVelocity = velocityTracker.getYVelocity();
                int i2 = i(motionEvent);
                h();
                if (Math.abs(yVelocity) <= this.x || i2 <= this.z) {
                    if (this.f56269g.getTranslationY() >= this.u / 2.0f) {
                        close();
                    } else {
                        open();
                    }
                } else if (yVelocity > 0.0f) {
                    close();
                } else {
                    open();
                }
            } else {
                int actionIndex = motionEvent.getActionIndex();
                this.v = motionEvent.getPointerId(actionIndex);
                this.B = motionEvent.getY();
                this.C = motionEvent.getY(actionIndex);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void open() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.t) {
            return;
        }
        this.t = true;
        setVisibility(0);
        RelativeLayout relativeLayout = this.f56269g;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, Key.TRANSLATION_Y, relativeLayout.getTranslationY(), 0.0f);
        ofFloat.setDuration((this.f56269g.getTranslationY() / this.u) * 300.0f);
        ofFloat.addListener(new d(this));
        ofFloat.start();
        f fVar = this.s;
        if (fVar != null) {
            fVar.a(true, false);
        }
        HotTopicSelectModel hotTopicSelectModel = this.r;
        if (hotTopicSelectModel != null) {
            hotTopicSelectModel.B();
        }
    }

    public void setDelButtonVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void setHotTopicModel(HotTopicSelectModel hotTopicSelectModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hotTopicSelectModel) == null) {
            this.r = hotTopicSelectModel;
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.p.setSelectTopicId(j);
        }
    }

    public void setStateListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public void setTitlePlaceholderHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || i2 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f56267e.getLayoutParams();
        layoutParams.height = i2;
        this.f56267e.setLayoutParams(layoutParams);
        int i3 = l.i(getContext()) - i2;
        this.u = i3;
        this.f56269g.setTranslationY(i3);
    }

    public void close(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.t) {
            return;
        }
        if (this.o.isFocused()) {
            Context context = getContext();
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).HidenSoftKeyPad((InputMethodManager) context.getSystemService("input_method"), this.o);
            }
        }
        this.t = true;
        RelativeLayout relativeLayout = this.f56269g;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, Key.TRANSLATION_Y, relativeLayout.getTranslationY(), this.u);
        ofFloat.setDuration(((this.u - this.f56269g.getTranslationY()) / this.u) * 300.0f);
        ofFloat.addListener(new c(this, z));
        ofFloat.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = -1;
        this.A = new ArrayList();
        this.D = new e(this);
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = -1;
        this.A = new ArrayList();
        this.D = new e(this);
        k();
    }
}
