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
import com.baidu.tieba.dga;
import com.baidu.tieba.gy9;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.utility.GroupChatKeyboardLayout;
import com.baidu.tieba.immessagecenter.chatgroup.utility.NoSlidingLinearLayout;
import com.baidu.tieba.jk5;
import com.baidu.tieba.ki5;
import com.baidu.tieba.kj;
import com.baidu.tieba.li5;
import com.baidu.tieba.mj;
import com.baidu.tieba.ng8;
import com.baidu.tieba.p75;
import com.baidu.tieba.pi5;
import com.baidu.tieba.uj5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wi;
import com.baidu.tieba.wi5;
import com.baidu.tieba.xg;
import com.baidu.tieba.yh5;
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
public class GroupInputTool implements LifecycleObserver, mj {
    public static /* synthetic */ Interceptable $ic;
    public static GroupChatFragment k;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;
    public h b;
    public f c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public final CustomMessageListener i;
    public final Handler j;

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
        public static final Pattern w;
        public transient /* synthetic */ FieldHolder $fh;
        public wi5 a;
        public EditorTools b;
        public RelativeLayout c;
        public RelativeLayout d;
        public GroupChatKeyboardLayout e;
        public RelativeLayout f;
        public LinearLayout.LayoutParams g;
        public pi5 h;
        public jk5 i;
        public ki5 j;
        public NoSlidingLinearLayout k;
        public ISendVoiceView l;
        public GroupInputViewController m;
        public GroupChatRobotTopHeadView n;
        public GroupChatRobotFloorView o;
        public ng8 p;
        public GroupChatUserReplyView q;
        public GroupChatUserReplyView r;
        public int s;
        public int t;
        public boolean u;
        public long v;

        /* loaded from: classes6.dex */
        public class a implements InputFilter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0340a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC0340a(a aVar) {
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
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && GroupInputTool.k != null && GroupInputTool.k.getContext() != null) {
                        String string = GroupInputTool.k.getString(R.string.obfuscated_res_0x7f0f0eb1);
                        BdTopToast bdTopToast = new BdTopToast(GroupInputTool.k.getContext());
                        bdTopToast.g(string);
                        bdTopToast.h(false);
                        bdTopToast.i((ViewGroup) GroupInputTool.k.getView());
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
                    if (this.a.O()) {
                        if (TextUtils.isEmpty(charSequence)) {
                            return charSequence;
                        }
                        boolean matches = g.w.matcher(charSequence.toString()).matches();
                        if (!matches) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (this.a.v == 0 || currentTimeMillis - this.a.v > 5000) {
                                this.a.v = currentTimeMillis;
                                xg.a().post(new RunnableC0340a(this));
                            }
                        }
                        if (!matches) {
                            return "";
                        }
                        return charSequence;
                    }
                    this.a.v = 0L;
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.O() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
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
                    if (this.d.g != null && this.d.f != null) {
                        this.d.g.height = i;
                        this.d.f.setLayoutParams(this.d.g);
                        this.d.f.requestLayout();
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
                    if (this.b.g != null && this.b.f != null) {
                        this.b.g.height = -2;
                        this.b.f.setLayoutParams(this.b.g);
                        this.b.f.requestLayout();
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
                    if (this.b.g != null && this.b.f != null) {
                        this.b.g.height = -2;
                        this.b.f.setLayoutParams(this.b.g);
                        this.b.f.requestLayout();
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
            w = Pattern.compile("[0-9]");
        }

        public ISendVoiceView E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.l;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (EditorTools) invokeV.objValue;
        }

        public final void K() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.n = (GroupChatRobotTopHeadView) this.f.findViewById(R.id.obfuscated_res_0x7f091104);
            }
        }

        public final void M() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.r = (GroupChatUserReplyView) this.f.findViewById(R.id.obfuscated_res_0x7f090e8a);
            }
        }

        public final void N() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.q = (GroupChatUserReplyView) this.f.findViewById(R.id.obfuscated_res_0x7f090e8b);
            }
        }

        public final boolean O() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.u;
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
            this.a = null;
            this.b = null;
            this.j = null;
            this.l = null;
            this.s = R.color.CAM_X0212;
            this.u = false;
            this.v = 0L;
        }

        public final void H(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, spanGroupEditText) == null) {
                spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new a(this)});
            }
        }

        public final void L(@NonNull SpanGroupEditText spanGroupEditText) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupEditText) == null) {
                spanGroupEditText.addTextChangedListener(new b(this));
            }
        }

        public void Q(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                this.u = z;
            }
        }

        public void R(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                this.t = i;
                S();
            }
        }

        public static g D(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
                g gVar = new g();
                gVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e6a);
                gVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e01);
                gVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e65);
                gVar.e = (GroupChatKeyboardLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ac);
                gVar.k = (NoSlidingLinearLayout) view2.findViewById(R.id.mask_view);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public final void P(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.b.y(i);
                S();
                NoSlidingLinearLayout noSlidingLinearLayout = this.k;
                if (noSlidingLinearLayout != null) {
                    noSlidingLinearLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
                }
                GroupChatRobotFloorView groupChatRobotFloorView = this.o;
                if (groupChatRobotFloorView != null) {
                    groupChatRobotFloorView.A(i);
                }
                GroupChatRobotTopHeadView groupChatRobotTopHeadView = this.n;
                if (groupChatRobotTopHeadView != null) {
                    groupChatRobotTopHeadView.d(i);
                }
                RelativeLayout relativeLayout = this.d;
                if (relativeLayout != null) {
                    p75.d(relativeLayout).f(R.color.CAM_X0207);
                }
                GroupChatUserReplyView groupChatUserReplyView = this.q;
                if (groupChatUserReplyView != null) {
                    groupChatUserReplyView.d(i);
                }
                GroupChatUserReplyView groupChatUserReplyView2 = this.r;
                if (groupChatUserReplyView2 != null) {
                    groupChatUserReplyView2.d(i);
                }
            }
        }

        public void C(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
                int max = Math.max(i2, i);
                int i3 = max - ((i2 + i) - max);
                RelativeLayout relativeLayout = this.f;
                if (relativeLayout != null && (relativeLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                    this.g = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
                ofInt.setDuration(j);
                ofInt.addUpdateListener(new c(this, i3, i, i2));
                ofInt.addListener(new d(this, animatorListenerAdapter));
                ofInt.setTarget(this.f);
                ofInt.start();
            }
        }

        public final void G(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, groupChatFragment, context) == null) {
                wi5 wi5Var = new wi5(context, true, false);
                this.a = wi5Var;
                wi5Var.j(true);
                EditorTools editorTools = new EditorTools(context);
                this.b = editorTools;
                editorTools.setId(R.id.group_chat_input_tool_view);
                this.b.setMoreButtonAtEnd(true);
                this.b.setBarLauncherType(9);
                this.b.setBarMaxLauCount(1);
                this.b.setBackgroundColorId(R.color.CAM_X0204);
                this.b.setBarBackgroundColorId(R.color.CAM_X0207);
                this.b.setDeskBackgroundColorId(R.color.CAM_X0206);
                this.b.setMoreDeskBgColorId(R.color.CAM_X0206);
                this.b.setViewDisplayTime(15L, 20L);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, ki5.class, context);
                if (runTask != null && runTask.getData() != null) {
                    ki5 ki5Var = (ki5) runTask.getData();
                    this.j = ki5Var;
                    li5 li5Var = ki5Var.m;
                    if (li5Var != null && (li5Var instanceof ISendVoiceView)) {
                        this.l = (ISendVoiceView) li5Var;
                    }
                    ki5 ki5Var2 = this.j;
                    ki5Var2.l = 1;
                    this.b.d(ki5Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.b.h(arrayList);
                ki5 p = this.b.p(5);
                if (p != null) {
                    p.f(true);
                    p.e(true);
                    p.d = 0;
                }
                this.b.d(this.a);
                pi5 pi5Var = new pi5(context);
                this.h = pi5Var;
                this.b.d(pi5Var);
                jk5 jk5Var = new jk5(context, true);
                this.i = jk5Var;
                this.b.d(jk5Var);
                this.b.f();
                this.c.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                li5 li5Var2 = this.a.m;
                if (li5Var2 instanceof EditText) {
                    p75 d2 = p75.d((EditText) li5Var2);
                    d2.C(R.dimen.T_X06);
                    d2.o(R.string.J_X07);
                    d2.m(R.dimen.L_X01);
                    d2.l(R.color.CAM_X0209);
                    d2.v(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.s));
                }
                this.b.y(TbadkCoreApplication.getInst().getSkinType());
                GroupChatKeyboardLayout groupChatKeyboardLayout = this.e;
                if (groupChatKeyboardLayout != null) {
                    groupChatKeyboardLayout.setBlank(wi.j(TbadkCoreApplication.getInst()) / 5, wi.j(TbadkCoreApplication.getInst()) / 5, 0, wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
                }
            }
        }

        public final void I(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || this.a.g() == null) {
                return;
            }
            SpanGroupEditText g = this.a.g();
            g.setId(R.id.obfuscated_res_0x7f090e63);
            g.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            g.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            g.setMaxLines(5);
            g.setMinLines(1);
            g.setGravity(48);
            g.setIncludeFontPadding(false);
            g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.T_X06));
            g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            g.setHintTextColor(context.getResources().getColor(R.color.CAM_X0109));
            dga.l(g, R.drawable.edittext_cursor);
            g.setLineSpacing(wi.g(context, R.dimen.M_T_X002), 1.0f);
            g.setPadding(wi.g(context, R.dimen.M_W_X006), wi.g(context, R.dimen.M_H_X004), wi.g(context, R.dimen.M_W_X006), wi.g(context, R.dimen.M_H_X004));
            H(g);
            L(g);
        }

        public final void J(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, groupChatFragment, context) == null) {
                GroupChatRobotFloorView groupChatRobotFloorView = (GroupChatRobotFloorView) this.f.findViewById(R.id.obfuscated_res_0x7f090e7e);
                this.o = groupChatRobotFloorView;
                groupChatRobotFloorView.setPageContext(groupChatFragment.getPageContext());
                this.o.A(TbadkCoreApplication.getInst().getSkinType());
                ng8 ng8Var = new ng8(groupChatFragment);
                this.p = ng8Var;
                ng8Var.u(this.o);
            }
        }

        public void S() {
            li5 li5Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                int i = this.t;
                if (i == 0) {
                    this.s = SkinManager.getColor(R.color.CAM_X0212);
                } else if (i == 1) {
                    this.s = gy9.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
                } else {
                    this.s = SkinManager.getColor(R.color.CAM_X0212);
                }
                wi5 wi5Var = this.a;
                if (wi5Var != null && (li5Var = wi5Var.m) != null && (li5Var instanceof EditText)) {
                    p75 d2 = p75.d((EditText) li5Var);
                    d2.C(R.dimen.T_X06);
                    d2.o(R.string.J_X07);
                    d2.m(R.dimen.L_X01);
                    d2.l(R.color.CAM_X0209);
                    d2.h(this.s);
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
                this.a.f = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.c != null) {
                    this.a.c.a(this.a.e, this.a.f);
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
                    this.a.j.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements uj5.b {
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

        @Override // com.baidu.tieba.uj5.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.c != null) {
                    this.a.c.a(z, this.a.f);
                }
                this.a.e = z;
                this.a.L().o(z);
                if (this.a.a.e != null) {
                    this.a.a.e.setIsKeyboardOn(z);
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
                if (this.a.e) {
                    this.a.a.F().r();
                } else {
                    this.a.L().t(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ng8.e {
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

        @Override // com.baidu.tieba.ng8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.k != null) {
                    GroupInputTool.k.x2();
                }
                this.a.h0(false);
                this.a.W();
                this.a.u(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.ng8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (GroupInputTool.k != null) {
                    GroupInputTool.k.I2();
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
        this.i = new a(this, 2921776);
        this.j = new b(this);
        k = groupChatFragment;
        X();
    }

    public void C(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (gVar = this.a) != null && gVar.e != null) {
            this.a.e.setDisallowInterceptTouchEvent(z);
        }
    }

    public void D(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setDisallowInterceptTouchEvent(z);
        }
    }

    public void b0(@NonNull Bundle bundle) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) && (gVar = this.a) != null && gVar.m != null) {
            this.a.m.o1(bundle);
        }
    }

    public void c0(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, botsDTO) != null) || this.a.p == null) {
            return;
        }
        this.a.p.r(botsDTO);
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f = z;
        }
    }

    public void e0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (gVar = this.a) != null) {
            gVar.Q(z);
        }
    }

    public void f0(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (gVar = this.a) != null) {
            gVar.R(i);
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
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.a.b != null) {
            this.a.b.setTopShadowDividerVisible(z);
        }
    }

    public final void i0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048605, this, z) != null) || (gVar = this.a) == null) {
            return;
        }
        if (z) {
            gVar.d.setVisibility(0);
        } else {
            gVar.d.setVisibility(8);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) && onClickListener != null && (gVar = this.a) != null && gVar.k != null) {
            this.a.k.setOnClickListener(onClickListener);
        }
    }

    public void k0(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (gVar = this.a) != null) {
            if (!z) {
                gVar.k.setVisibility(8);
            } else {
                gVar.k.setVisibility(0);
            }
        }
    }

    public void l0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public void m0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hVar) == null) {
            this.b = hVar;
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048612, this, i) != null) {
            return;
        }
        this.a.P(i);
    }

    @Override // com.baidu.tieba.mj
    public void onDeletedVoice(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, str) == null) && (hVar = this.b) != null) {
            hVar.a();
        }
    }

    @Override // com.baidu.tieba.mj
    public void onShowRecordTime(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.mj
    public void onShowRecording(int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.mj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            h hVar = this.b;
            if (hVar != null) {
                hVar.b(voiceModel);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Handler handler = this.j;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = k;
            if (groupChatFragment != null && this.d != null) {
                uj5.c(groupChatFragment.requireActivity(), this.d);
            }
            k = null;
        }
    }

    @Nullable
    public pi5 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.h;
            }
            return null;
        }
        return (pi5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.c;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public wi5 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.a;
            }
            return null;
        }
        return (wi5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.f;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.a;
            if (gVar == null || gVar.k.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ng8 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.p;
        }
        return (ng8) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (I() == null || (findViewById = I().findViewById(R.id.obfuscated_res_0x7f090e64)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public jk5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.i;
            }
            return null;
        }
        return (jk5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.E();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    public GroupChatRobotTopHeadView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.n;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.b;
            }
            return null;
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.r;
            }
            return null;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            g gVar = this.a;
            if (gVar != null) {
                return gVar.q;
            }
            return null;
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
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.a.k == null) {
            return;
        }
        this.a.k.setOnClickListener(new d(this));
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            g gVar = this.a;
            if (gVar != null && gVar.O()) {
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
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            g gVar = this.a;
            if (gVar != null && gVar.l != null) {
                return this.a.l.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj
    public void onStopingRecorder() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStopingRecorder();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (!this.e && !this.f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (gVar = this.a) != null && gVar.F() != null) {
            this.f = false;
            this.a.F().r();
            this.a.F().s();
            this.a.F().C(new yh5(5, -1, null));
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(this.e, this.f);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            g D = g.D(k.requireView());
            this.a = D;
            GroupChatFragment groupChatFragment = k;
            D.J(groupChatFragment, groupChatFragment.getContext());
            this.a.N();
            this.a.K();
            g gVar = this.a;
            GroupChatFragment groupChatFragment2 = k;
            gVar.G(groupChatFragment2, groupChatFragment2.getContext());
            this.a.I(k.getContext());
            this.a.M();
            FragmentActivity requireActivity = k.requireActivity();
            k.registerListener(this.i);
            V();
            if (this.a.F() != null && this.a.F().b != null) {
                this.d = uj5.b(requireActivity, this.a.F().b, new c(this));
            }
        }
    }

    public void n0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            if (this.a.o != null) {
                this.a.o.setRoomDetailInfo(this.g, this.h);
            }
        }
    }

    @Override // com.baidu.tieba.mj
    public void onStartedRecorder(boolean z, int i) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onStartedRecorder(z, kj.c);
        }
    }

    @Override // com.baidu.tieba.mj
    public void onShowErr(int i, String str) {
        g gVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048615, this, i, str) == null) && (gVar = this.a) != null && gVar.l != null) {
            this.a.l.onShowErr(i, str);
            if (!StringUtils.isNull(str) && (groupChatFragment = k) != null) {
                if (i == 3) {
                    groupChatFragment.showToast(str);
                    this.a.l.setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.j;
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
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (!z && J()) {
                k0(false);
            }
            this.a.C(i, i2, j, animatorListenerAdapter);
        }
    }

    public void u(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && (gVar = this.a) != null && gVar.f != null) {
            if (z && !J()) {
                k0(true);
            }
            this.a.C(i, i2, j, animatorListenerAdapter);
        }
    }
}
