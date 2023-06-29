package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.aj5;
import com.baidu.tieba.ci5;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.GroupChatKeyboardLayout;
import com.baidu.tieba.immessagecenter.chatgroup.utility.NoSlidingLinearLayout;
import com.baidu.tieba.lj;
import com.baidu.tieba.nj;
import com.baidu.tieba.nk5;
import com.baidu.tieba.oi5;
import com.baidu.tieba.pi5;
import com.baidu.tieba.s2a;
import com.baidu.tieba.s75;
import com.baidu.tieba.ti5;
import com.baidu.tieba.tka;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.tieba.yh8;
import com.baidu.tieba.yj5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class GroupInputTool implements LifecycleObserver, nj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment a;
    public g b;
    public h c;
    public f d;
    public ViewTreeObserver.OnGlobalLayoutListener e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public final CustomMessageListener j;
    public final Handler k;

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z, boolean z2);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static final Pattern x;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment a;
        public aj5 b;
        public EditorTools c;
        public RelativeLayout d;
        public RelativeLayout e;
        public GroupChatKeyboardLayout f;
        public RelativeLayout g;
        public LinearLayout.LayoutParams h;
        public ti5 i;
        public nk5 j;
        public oi5 k;
        public NoSlidingLinearLayout l;
        public ISendVoiceView m;
        public GroupInputViewController n;
        public GroupChatRobotTopHeadView o;
        public GroupChatRobotFloorView p;
        public yh8 q;
        public GroupChatUserReplyView r;
        public GroupChatUserReplyView s;
        public int t;
        public int u;
        public boolean v;
        public long w;

        /* loaded from: classes6.dex */
        public class a implements InputFilter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0346a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0346a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.a != null && this.a.a.a.getContext() != null) {
                        String string = this.a.a.a.getString(R.string.obfuscated_res_0x7f0f0ece);
                        BdTopToast bdTopToast = new BdTopToast(this.a.a.a.getContext());
                        bdTopToast.g(string);
                        bdTopToast.h(false);
                        bdTopToast.i((ViewGroup) this.a.a.a.getView());
                    }
                }
            }

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                    if (this.a.P()) {
                        if (TextUtils.isEmpty(charSequence)) {
                            return charSequence;
                        }
                        boolean matches = g.x.matcher(charSequence.toString()).matches();
                        if (!matches) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (this.a.w == 0 || currentTimeMillis - this.a.w > 5000) {
                                this.a.w = currentTimeMillis;
                                yg.a().post(new RunnableC0346a(this));
                            }
                        }
                        if (!matches) {
                            return "";
                        }
                        return charSequence;
                    }
                    this.a.w = 0L;
                    return charSequence;
                }
                return (CharSequence) invokeCommon.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public CharSequence a;
            public final /* synthetic */ g b;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.P() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
                    editable.delete(0, 1);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                    this.a = charSequence;
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ g d;

            public c(g gVar, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = gVar;
                this.a = i;
                this.b = i2;
                this.c = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * this.a);
                    int i2 = this.b;
                    if (i2 > this.c) {
                        i = i2 - animatedFraction;
                    } else {
                        i = i2 + animatedFraction;
                    }
                    if (this.d.h != null && this.d.g != null) {
                        this.d.h.height = i;
                        this.d.g.setLayoutParams(this.d.h);
                        this.d.g.requestLayout();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatorListenerAdapter a;
            public final /* synthetic */ g b;

            public d(g gVar, AnimatorListenerAdapter animatorListenerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, animatorListenerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = animatorListenerAdapter;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    AnimatorListenerAdapter animatorListenerAdapter = this.a;
                    if (animatorListenerAdapter != null) {
                        animatorListenerAdapter.onAnimationCancel(animator);
                    }
                    if (this.b.h != null && this.b.g != null) {
                        this.b.h.height = -2;
                        this.b.g.setLayoutParams(this.b.h);
                        this.b.g.requestLayout();
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    AnimatorListenerAdapter animatorListenerAdapter = this.a;
                    if (animatorListenerAdapter != null) {
                        animatorListenerAdapter.onAnimationEnd(animator);
                    }
                    if (this.b.h != null && this.b.g != null) {
                        this.b.h.height = -2;
                        this.b.g.setLayoutParams(this.b.h);
                        this.b.g.requestLayout();
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                AnimatorListenerAdapter animatorListenerAdapter;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && (animatorListenerAdapter = this.a) != null) {
                    animatorListenerAdapter.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AnimatorListenerAdapter animatorListenerAdapter;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, animator) == null) && (animatorListenerAdapter = this.a) != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-157042278, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputTool$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-157042278, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/inputtool/GroupInputTool$g;");
                    return;
                }
            }
            x = Pattern.compile("[0-9]");
        }

        public ISendVoiceView F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.m;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools G() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return (EditorTools) invokeV.objValue;
        }

        public final void L() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.o = (GroupChatRobotTopHeadView) this.g.findViewById(R.id.obfuscated_res_0x7f091110);
            }
        }

        public final void N() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.s = (GroupChatUserReplyView) this.g.findViewById(R.id.obfuscated_res_0x7f090e94);
            }
        }

        public final void O() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.r = (GroupChatUserReplyView) this.g.findViewById(R.id.obfuscated_res_0x7f090e95);
            }
        }

        public final boolean P() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.v;
            }
            return invokeV.booleanValue;
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = null;
            this.c = null;
            this.k = null;
            this.m = null;
            this.t = R.color.CAM_X0212;
            this.v = false;
            this.w = 0L;
        }

        public final void I(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, spanGroupEditText) == null) {
                spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new a(this)});
            }
        }

        public final void M(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupEditText) == null) {
                spanGroupEditText.addTextChangedListener(new b(this));
            }
        }

        public void R(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                this.v = z;
            }
        }

        public void S(Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, fragment) == null) {
                this.a = fragment;
            }
        }

        public void T(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                this.u = i;
                U();
            }
        }

        public static g E(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
                g gVar = new g();
                gVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e74);
                gVar.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e5c);
                gVar.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e6f);
                gVar.f = (GroupChatKeyboardLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b3);
                gVar.l = (NoSlidingLinearLayout) view2.findViewById(R.id.mask_view);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public final void Q(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.c.y(i);
                U();
                NoSlidingLinearLayout noSlidingLinearLayout = this.l;
                if (noSlidingLinearLayout != null) {
                    noSlidingLinearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
                }
                GroupChatRobotFloorView groupChatRobotFloorView = this.p;
                if (groupChatRobotFloorView != null) {
                    groupChatRobotFloorView.A(i);
                }
                GroupChatRobotTopHeadView groupChatRobotTopHeadView = this.o;
                if (groupChatRobotTopHeadView != null) {
                    groupChatRobotTopHeadView.d(i);
                }
                RelativeLayout relativeLayout = this.e;
                if (relativeLayout != null) {
                    s75.d(relativeLayout).f(R.color.CAM_X0207);
                }
                GroupChatUserReplyView groupChatUserReplyView = this.r;
                if (groupChatUserReplyView != null) {
                    groupChatUserReplyView.d(i);
                }
                GroupChatUserReplyView groupChatUserReplyView2 = this.s;
                if (groupChatUserReplyView2 != null) {
                    groupChatUserReplyView2.d(i);
                }
            }
        }

        public void D(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
                int max = Math.max(i2, i);
                int i3 = max - ((i2 + i) - max);
                RelativeLayout relativeLayout = this.g;
                if (relativeLayout != null && (relativeLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                    this.h = (LinearLayout.LayoutParams) this.g.getLayoutParams();
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
                ofInt.setDuration(j);
                ofInt.addUpdateListener(new c(this, i3, i, i2));
                ofInt.addListener(new d(this, animatorListenerAdapter));
                ofInt.setTarget(this.g);
                ofInt.start();
            }
        }

        public final void H(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, groupChatFragment, context) == null) {
                aj5 aj5Var = new aj5(context, true, false);
                this.b = aj5Var;
                aj5Var.j(true);
                EditorTools editorTools = new EditorTools(context);
                this.c = editorTools;
                editorTools.setId(R.id.group_chat_input_tool_view);
                this.c.setMoreButtonAtEnd(true);
                this.c.setBarLauncherType(9);
                this.c.setBarMaxLauCount(1);
                this.c.setBackgroundColorId(R.color.CAM_X0204);
                this.c.setBarBackgroundColorId(R.color.CAM_X0207);
                this.c.setDeskBackgroundColorId(R.color.CAM_X0206);
                this.c.setMoreDeskBgColorId(R.color.CAM_X0206);
                this.c.setViewDisplayTime(15L, 20L);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, oi5.class, context);
                if (runTask != null && runTask.getData() != null) {
                    oi5 oi5Var = (oi5) runTask.getData();
                    this.k = oi5Var;
                    pi5 pi5Var = oi5Var.m;
                    if (pi5Var != null && (pi5Var instanceof ISendVoiceView)) {
                        this.m = (ISendVoiceView) pi5Var;
                    }
                    oi5 oi5Var2 = this.k;
                    oi5Var2.l = 1;
                    this.c.d(oi5Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.c.h(arrayList);
                oi5 p = this.c.p(5);
                if (p != null) {
                    p.f(true);
                    p.e(true);
                    p.d = 0;
                }
                this.c.d(this.b);
                ti5 ti5Var = new ti5(context);
                this.i = ti5Var;
                this.c.d(ti5Var);
                nk5 nk5Var = new nk5(context, true);
                this.j = nk5Var;
                this.c.d(nk5Var);
                this.c.f();
                this.d.addView(this.c, new ViewGroup.LayoutParams(-1, -2));
                pi5 pi5Var2 = this.b.m;
                if (pi5Var2 instanceof EditText) {
                    s75 d2 = s75.d((EditText) pi5Var2);
                    d2.C(R.dimen.T_X06);
                    d2.o(R.string.J_X07);
                    d2.m(R.dimen.L_X01);
                    d2.l(R.color.CAM_X0209);
                    d2.v(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.t));
                }
                this.c.y(TbadkCoreApplication.getInst().getSkinType());
                GroupChatKeyboardLayout groupChatKeyboardLayout = this.f;
                if (groupChatKeyboardLayout != null) {
                    groupChatKeyboardLayout.setBlank(xi.j(TbadkCoreApplication.getInst()) / 5, xi.j(TbadkCoreApplication.getInst()) / 5, 0, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
                }
            }
        }

        public final void J(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || this.b.g() == null) {
                return;
            }
            SpanGroupEditText g = this.b.g();
            g.setId(R.id.obfuscated_res_0x7f090e6d);
            g.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            g.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            g.setMaxLines(5);
            g.setMinLines(1);
            g.setGravity(48);
            g.setIncludeFontPadding(false);
            g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.T_X06));
            g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            g.setHintTextColor(context.getResources().getColor(R.color.CAM_X0109));
            tka.l(g, R.drawable.edittext_cursor);
            g.setLineSpacing(xi.g(context, R.dimen.M_T_X002), 1.0f);
            g.setPadding(xi.g(context, R.dimen.M_W_X006), xi.g(context, R.dimen.M_H_X004), xi.g(context, R.dimen.M_W_X006), xi.g(context, R.dimen.M_H_X004));
            I(g);
            M(g);
        }

        public final void K(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, groupChatFragment, context) == null) {
                GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) this.g.findViewById(R.id.obfuscated_res_0x7f090e88);
                this.p = groupChatRobotFloorView;
                groupChatRobotFloorView.setPageContext(groupChatFragment.getPageContext());
                this.p.A(TbadkCoreApplication.getInst().getSkinType());
                yh8 yh8Var = new yh8(groupChatFragment);
                this.q = yh8Var;
                yh8Var.u(this.p);
            }
        }

        public void U() {
            pi5 pi5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int i = this.u;
                if (i == 0) {
                    this.t = SkinManager.getColor(R.color.CAM_X0212);
                } else if (i == 1) {
                    this.t = s2a.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
                } else {
                    this.t = SkinManager.getColor(R.color.CAM_X0212);
                }
                aj5 aj5Var = this.b;
                if (aj5Var != null && (pi5Var = aj5Var.m) != null && (pi5Var instanceof EditText)) {
                    s75 d2 = s75.d((EditText) pi5Var);
                    d2.C(R.dimen.T_X06);
                    d2.o(R.string.J_X07);
                    d2.m(R.dimen.L_X01);
                    d2.l(R.color.CAM_X0209);
                    d2.h(this.t);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupInputTool groupInputTool, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.g = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.d != null) {
                    this.a.d.a(this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public b(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.k.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yj5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public c(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.yj5.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.d != null) {
                    this.a.d.a(z, this.a.g);
                }
                this.a.f = z;
                this.a.L().o(z);
                if (this.a.b.f != null) {
                    this.a.b.f.setIsKeyboardOn(z);
                }
                this.a.i0(!z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public d(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.L() != null && this.a.L().k()) {
                if (this.a.f) {
                    this.a.b.G().r();
                } else {
                    this.a.L().t(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yh8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public e(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.yh8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.a != null) {
                    this.a.a.x2();
                }
                this.a.h0(false);
                this.a.W();
                this.a.u(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.yh8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.a != null) {
                    this.a.a.J2();
                }
                this.a.h0(true);
                this.a.s(i, i2, j, animatorListenerAdapter, z);
            }
        }
    }

    public GroupInputTool(GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this, 2921776);
        this.k = new b(this);
        this.a = groupChatFragment;
        X();
    }

    public void C(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (gVar = this.b) != null && gVar.f != null) {
            this.b.f.setDisallowInterceptTouchEvent(z);
        }
    }

    public void D(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (gVar = this.b) != null && gVar.l != null) {
            this.b.l.setDisallowInterceptTouchEvent(z);
        }
    }

    public void b0(@NonNull Bundle bundle) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) && (gVar = this.b) != null && gVar.n != null) {
            this.b.n.o1(bundle);
        }
    }

    public void c0(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, botsDTO) != null) || this.b.q == null) {
            return;
        }
        this.b.q.r(botsDTO);
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.g = z;
        }
    }

    public void e0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (gVar = this.b) != null) {
            gVar.R(z);
        }
    }

    public void f0(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (gVar = this.b) != null) {
            gVar.T(i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            f0(i);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.b.c != null) {
            this.b.c.setTopShadowDividerVisible(z);
        }
    }

    public final void i0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048605, this, z) != null) || (gVar = this.b) == null) {
            return;
        }
        if (z) {
            gVar.e.setVisibility(0);
        } else {
            gVar.e.setVisibility(8);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) && onClickListener != null && (gVar = this.b) != null && gVar.l != null) {
            this.b.l.setOnClickListener(onClickListener);
        }
    }

    public void k0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (gVar = this.b) != null) {
            if (!z) {
                gVar.l.setVisibility(8);
            } else {
                gVar.l.setVisibility(0);
            }
        }
    }

    public void l0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public void m0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hVar) == null) {
            this.c = hVar;
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048612, this, i) != null) {
            return;
        }
        this.b.Q(i);
    }

    @Override // com.baidu.tieba.nj
    public void onDeletedVoice(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, str) == null) && (hVar = this.c) != null) {
            hVar.a();
        }
    }

    @Override // com.baidu.tieba.nj
    public void onShowRecordTime(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && (gVar = this.b) != null && gVar.m != null) {
            this.b.m.onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.nj
    public void onShowRecording(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && (gVar = this.b) != null && gVar.m != null) {
            this.b.m.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.nj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            h hVar = this.c;
            if (hVar != null) {
                hVar.b(voiceModel);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Handler handler = this.k;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = this.a;
            if (groupChatFragment != null && this.e != null) {
                yj5.c(groupChatFragment.requireActivity(), this.e);
            }
            this.a = null;
        }
    }

    @Nullable
    public ti5 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.i;
        }
        return (ti5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public aj5 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.b;
        }
        return (aj5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.b;
            if (gVar == null || gVar.l.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public yh8 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048583, this)) != null) {
            return (yh8) invokeV.objValue;
        }
        return this.b.q;
    }

    public boolean M() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (I() == null || (findViewById = I().findViewById(R.id.obfuscated_res_0x7f090e6e)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public nk5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.j;
        }
        return (nk5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g gVar = this.b;
            if (gVar != null) {
                return gVar.F();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    public GroupChatRobotTopHeadView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (GroupChatRobotTopHeadView) invokeV.objValue;
        }
        return this.b.o;
    }

    @Nullable
    public EditorTools R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.c;
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.s;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            g gVar = this.b;
            if (gVar == null) {
                return null;
            }
            return gVar.r;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || L() == null) {
            return;
        }
        L().q(new e(this));
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.b.l == null) {
            return;
        }
        this.b.l.setOnClickListener(new d(this));
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            g gVar = this.b;
            if (gVar != null && gVar.P()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            g gVar = this.b;
            if (gVar != null && gVar.m != null) {
                return this.b.m.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nj
    public void onStopingRecorder() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (gVar = this.b) != null && gVar.m != null) {
            this.b.m.onStopingRecorder();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (!this.f && !this.g) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (L() != null && L().k()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void U() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (gVar = this.b) != null && gVar.G() != null) {
            this.g = false;
            this.b.G().r();
            this.b.G().s();
            this.b.G().C(new ci5(5, -1, null));
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(this.f, this.g);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            g E = g.E(this.a.requireView());
            this.b = E;
            E.S(this.a);
            g gVar = this.b;
            GroupChatFragment groupChatFragment = this.a;
            gVar.K(groupChatFragment, groupChatFragment.getContext());
            this.b.O();
            this.b.L();
            g gVar2 = this.b;
            GroupChatFragment groupChatFragment2 = this.a;
            gVar2.H(groupChatFragment2, groupChatFragment2.getContext());
            this.b.J(this.a.getContext());
            this.b.N();
            FragmentActivity requireActivity = this.a.requireActivity();
            this.a.registerListener(this.j);
            V();
            if (this.b.G() != null && this.b.G().b != null) {
                this.e = yj5.b(requireActivity, this.b.G().b, new c(this));
            }
        }
    }

    public void n0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.h = j;
            this.i = j2;
            if (this.b.p != null) {
                this.b.p.setRoomDetailInfo(this.h, this.i);
            }
        }
    }

    @Override // com.baidu.tieba.nj
    public void onStartedRecorder(boolean z, int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (gVar = this.b) != null && gVar.m != null) {
            this.b.m.onStartedRecorder(z, lj.c);
        }
    }

    @Override // com.baidu.tieba.nj
    public void onShowErr(int i, String str) {
        g gVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048615, this, i, str) == null) && (gVar = this.b) != null && gVar.m != null) {
            this.b.m.onShowErr(i, str);
            if (!StringUtils.isNull(str) && (groupChatFragment = this.a) != null) {
                if (i == 3) {
                    groupChatFragment.showToast(str);
                    this.b.m.setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.k;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    groupChatFragment.showToast(str);
                }
            }
        }
    }

    public void s(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.b) != null && gVar.g != null) {
            if (!z && J()) {
                k0(false);
            }
            this.b.D(i, i2, j, animatorListenerAdapter);
        }
    }

    public void u(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.b) != null && gVar.g != null) {
            if (z && !J()) {
                k0(true);
            }
            this.b.D(i, i2, j, animatorListenerAdapter);
        }
    }
}
